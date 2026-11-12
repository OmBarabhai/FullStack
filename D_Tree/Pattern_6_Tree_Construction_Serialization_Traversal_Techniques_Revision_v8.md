# Pattern 6 — Tree Construction, Serialization & Traversal Techniques

> **Language:** Java only  
> **Purpose:** Rebuild a tree from traversal information, rewire tree pointers, and understand traversal techniques that use special pointer handling.

---

## Revision Navigation

| Problem | Main idea | Status |
|---|---|---|
| [1. Construct Binary Tree from Preorder and Inorder Traversal](#1-construct-binary-tree-from-preorder-and-inorder-traversal) | Use preorder to choose each root and inorder to divide left and right subtrees | Practised with guidance |
| [2. Construct Binary Tree from Inorder and Postorder Traversal](#2-construct-binary-tree-from-inorder-and-postorder-traversal) | Use postorder backwards to choose each root, then split with inorder | Practised with guidance |

---

## Pattern Overview

In construction problems, traversal arrays give us information about the nodes, but we must recover the tree structure.

For **Preorder + Inorder**:

- **Preorder** (`Root → Left → Right`) tells us which node is the root first.
- **Inorder** (`Left → Root → Right`) tells us which values belong to the left subtree and which belong to the right subtree.
- A HashMap stores each inorder value's index so we can find the root position quickly.

For **Inorder + Postorder**:

- **Postorder** (`Left → Right → Root`) tells us the root at the end of the current range.
- **Inorder** divides the left and right subtrees. A HashMap gives the root index quickly.
- The postorder ranges are inclusive and stay in ascending index order: the left subtree uses the first values, the right subtree uses the following values, and the root is at the end.
- In this implementation, the left subtree is constructed before the right subtree.

---

## 1. Construct Binary Tree from Preorder and Inorder Traversal

**LeetCode:** [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)  
**Difficulty:** Medium  
**Status:** Practised with guidance; attempt independently again before marking complete.

### Core intuition

1. The first value in the current preorder range is the root of that subtree.
2. Find this root's index in the inorder array using the HashMap.
3. Values before the root in the current inorder range belong to the left subtree.
4. Values after the root belong to the right subtree.
5. Calculate the matching preorder ranges and recursively build the left and right subtrees.

**Important assumption:** The problem guarantees unique node values. The HashMap approach uses each value as a unique key. Duplicate values would make this index lookup ambiguous.

### Your Java implementation

```java
public class Solution {
    /*
    For constructing left and right subtrees:

    // Left Subtree:
    Preorder: preorder[pre_st + 1 ... pre_st + num_in_left]
    Inorder:  inorder[in_st ... in_st + num_in_left - 1]

    // Right Subtree:
    Preorder: preorder[pre_st + num_in_left + 1 ... pre_end]
    Inorder:  inorder[in_st + num_in_left + 1 ... in_end]

    Where:
    - pre_st: Start index of current preorder segment
    - in_st:  Start index of current inorder segment
    - num_in_left: Number of nodes in the left subtree (root_in_idx - in_st)
    */

    public static TreeNode helper(
        int[] inorder, int in_st, int in_end,
        int[] preorder, int pre_st, int pre_end,
        HashMap<Integer, Integer> map
    ) {
        if (in_st > in_end || pre_st > pre_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_st]);
        int root_in_idx = map.get(preorder[pre_st]);
        int num_in_left = root_in_idx - in_st;
        root.left = helper(
            inorder, in_st, in_st + num_in_left - 1,
            preorder, pre_st + 1, pre_st + num_in_left, map
        );
        root.right = helper(
            inorder, in_st + num_in_left + 1, in_end,
            preorder, pre_st + num_in_left + 1, pre_end, map
        );
        return root;
    }

    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int arr_size = inorder.length - 1;
        return helper(inorder, 0, arr_size, preorder, 0, arr_size, map);
    }
}
```

### Understand the index ranges

All start and end indices in this implementation are **inclusive**.

| Variable | Meaning |
|---|---|
| `pre_st`, `pre_end` | Current subtree's range in preorder |
| `in_st`, `in_end` | Current subtree's range in inorder |
| `preorder[pre_st]` | Root value of the current subtree |
| `in_root_idx` | Position of that root inside inorder |
| `num_in_left` | Number of nodes in the left subtree |

The key calculation is:

```java
int num_in_left = in_root_idx - in_st;
```

It counts the inorder elements strictly before the root within the current inorder range.

The recursive ranges are therefore:

| Subtree | Preorder range | Inorder range |
|---|---|---|
| Left | `pre_st + 1` to `pre_st + num_in_left` | `in_st` to `in_st + num_in_left - 1` |
| Right | `pre_st + num_in_left + 1` to `pre_end` | `in_st + num_in_left + 1` to `in_end` |

Why these boundaries?

- Preorder starts with the root. So the left subtree begins immediately after the root, and contains exactly `num_in_left` values.
- The right subtree starts after the root plus all left-subtree values.
- In inorder, the root's position separates the left and right ranges.
- When a range becomes empty (`start > end`), the helper returns `null`.

The initial end index must be `length - 1` because the helper uses inclusive ranges. In your code, `size_arr = inorder.length - 1` supplies the final valid index. For empty arrays, this becomes `-1`, so the base condition returns `null` immediately.

### Visual dry run

Use this example:

```text
preorder = [3, 9, 20, 15, 7]
index       0  1   2   3  4

inorder  = [9, 3, 15, 20, 7]
index       0  1   2   3  4
```

**Step 1 — Pick the root**

The first value in preorder is `3`, so `3` is the root.

```text
preorder range: [0..4]  -> [3, 9, 20, 15, 7]
inorder range:  [0..4]  -> [9, 3, 15, 20, 7]

in_root_idx = 1
num_in_left = 1 - 0 = 1
```

In the current inorder range, one value (`9`) is before `3`, so the left subtree has one node. Values after `3` (`15, 20, 7`) belong to the right subtree.

```text
          3
         / \
       [9] [15, 20, 7]
       left     right
```

**Step 2 — Build the left subtree**

The left recursive call receives:

```text
preorder [1..1] -> [9]
inorder  [0..0] -> [9]
```

`9` becomes the left child of `3`. Its left and right ranges are empty, so both recursive calls return `null`.

```text
          3
         / \
        9  [15, 20, 7]
```

**Step 3 — Build the right subtree**

The right recursive call receives:

```text
preorder [2..4] -> [20, 15, 7]
inorder  [2..4] -> [15, 20, 7]
```

The first preorder value is `20`, so it becomes the right child of `3`.

```text
in_root_idx = 3
num_in_left = 3 - 2 = 1
```

There is one value (`15`) before `20` in this inorder range. Therefore, `15` is the left child of `20`, and `7` is its right child.

```text
             3
            / \
           9   20
              /  \
             15   7
```

**Recursive call trace**

| Call | Preorder range | Inorder range | Root chosen | Left-subtree count |
|---|---|---|---:|---:|
| 1 | `[0..4]` | `[0..4]` | 3 | 1 |
| 2 — left of 3 | `[1..1]` | `[0..0]` | 9 | 0 |
| 3 — right of 3 | `[2..4]` | `[2..4]` | 20 | 1 |
| 4 — left of 20 | `[3..3]` | `[2..2]` | 15 | 0 |
| 5 — right of 20 | `[4..4]` | `[4..4]` | 7 | 0 |

**Final constructed tree**

```text
             3
            / \
           9   20
              /  \
             15   7
```

Check the result:

```text
Preorder:  3, 9, 20, 15, 7   (Root → Left → Right)
Inorder:   9, 3, 15, 20, 7   (Left → Root → Right)
```

Both traversals match the input arrays.

### Complexity

- **Time:** `O(n)` — building the inorder index map takes `O(n)`, and each node is constructed once. HashMap index lookups are `O(1)` on average.
- **Auxiliary space:** `O(n)` for the HashMap, plus `O(h)` recursion stack, where `h` is the tree height. In the worst case, the recursion stack is `O(n)`.

### Boundary reminders

1. **Inclusive end index:** Use `length - 1`, not `length`, as the last valid array index.
2. **Left preorder end:** It is `pre_st + num_in_left`, not one position beyond that.
3. **Right preorder start:** Skip the root and all left-subtree nodes: `pre_st + num_in_left + 1`.
4. **Left inorder end:** Stop immediately before the root: `in_st + num_in_left - 1`.
5. **Do not confuse traversal roles:** Preorder selects the root; inorder splits the left and right subtrees.
6. **Unique values:** This HashMap-index method relies on distinct node values.

### Quick recall

> **Preorder tells me WHO is the root. Inorder tells me HOW MANY nodes go left and which values go right.**

- Find root from `preorder[pre_st]`.
- Find its inorder index from the map.
- Count left nodes with `in_root_idx - in_st`.
- Split both traversal ranges and recurse.

### Self-revision checklist

- [ ] Explain why preorder's first value is the current root.
- [ ] Explain how inorder separates the left and right subtrees.
- [ ] Derive the four recursive range boundaries without looking.
- [ ] Dry-run all recursive calls on paper.
- [ ] Reimplement the solution independently.


---

## 2. Construct Binary Tree from Inorder and Postorder Traversal

**LeetCode:** [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)  
**Difficulty:** Medium  
**Status:** Practised with guidance; reimplement independently.

### Core idea

- The last value in the current postorder range is the root: `postorder[post_end]`.
- Find the root's position in inorder using the HashMap.
- The number of values before the root in inorder gives the size of the left subtree.
- Use that count to divide the postorder range into left and right subtree ranges.
- Build the **left subtree first**, then the right. The postorder ranges are kept in their normal left-to-right order, so each recursive call receives the matching contiguous range for that subtree.

**Important assumption:** Node values are unique, so each value maps to one inorder index.

### Java implementation

```java
import java.util.*;

class Solution {
    public TreeNode helper(int[] inorder, int in_st, int in_end, int[] postorder, int post_st, int post_end,
            HashMap<Integer, Integer> map) {
        if (in_st > in_end || post_st > post_end) {
            return null;
        }
        if (inorder.length == 0)
            return null;

        TreeNode root = new TreeNode(postorder[post_end]);
        int in_root_idx = map.get(postorder[post_end]);
        int num_in_left = in_root_idx - in_st;

        root.left = helper(inorder, in_st, in_root_idx - 1, postorder, post_st,
                post_st + num_in_left - 1, map);
        root.right = helper(inorder, in_root_idx + 1, in_end, postorder, post_st + num_in_left,
                post_end - 1, map);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size_arr = inorder.length - 1;
        for (int i = 0; i <= size_arr; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, size_arr, postorder, 0, size_arr, map);
    }
}
```

### Understand the index ranges

All ranges are **inclusive**. The current root is at `postorder[post_end]`.

```java
int num_in_left = in_root_idx - in_st;
```

This counts the inorder values before the root inside the current inorder range.

| Subtree | Inorder range | Postorder range |
|---|---|---|
| Left | `in_st` to `in_root_idx - 1` | `post_st` to `post_st + num_in_left - 1` |
| Right | `in_root_idx + 1` to `in_end` | `post_st + num_in_left` to `post_end - 1` |

Why these boundaries?

- Postorder stores the left subtree first, then the right subtree, and the root last.
- `num_in_left` tells us how many postorder values belong to the left subtree.
- The right subtree takes the remaining values before the root.
- The root is excluded from both subtree ranges, so the right range ends at `post_end - 1`.
- The helper builds the left subtree first using the first `num_in_left` values in the current postorder range.
- The right subtree uses the remaining values before the root, ending at `post_end - 1`.
- The recursive-call order does not change the final tree; each call receives the range belonging to its subtree.
- When either range becomes empty (`start > end`), the helper returns `null`.

### Practical dry run

Input:

```text
inorder   = [9, 3, 15, 20, 7]
index        0  1   2   3  4

postorder = [9, 15, 7, 20, 3]
index        0   1  2   3  4
```

**Step 1 — Build the root**

The last postorder value is `3`, so it becomes the root.

```text
postorder range: [0..4] -> [9, 15, 7, 20, 3]
root = postorder[4] = 3
in_root_idx = 1
num_in_left = 1 - 0 = 1
```

The left subtree has one node. The remaining three values before the root belong to the right subtree.

```text
             3
           /   \
         [9]  [15, 20, 7]
         left     right
```

**Step 2 — Build the left subtree first**

The left call receives:

```text
inorder range:   [0..0] -> [9]
postorder range: [0..0] -> [9]
```

The last value in this postorder range is `9`, so it becomes the left child of `3`. Its left and right ranges are empty, so those calls return `null`.

**Step 3 — Build the right subtree of 3**

The right call receives:

```text
inorder range:   [2..4] -> [15, 20, 7]
postorder range: [1..3] -> [15, 7, 20]
```

The last value in this postorder range is `20`, so it becomes the right child of `3`.

```text
in_root_idx = 3
num_in_left = 3 - 2 = 1
```

For node `20`:

- Left subtree: inorder `[2..2]`, postorder `[1..1]` → node `15`.
- Right subtree: inorder `[4..4]`, postorder `[2..2]` → node `7`.

**Final constructed tree**

```text
             3
            / \
           9   20
              /  \
             15   7
```

Check the result:

```text
Inorder:   9, 3, 15, 20, 7   (Left → Root → Right)
Postorder: 9, 15, 7, 20, 3  (Left → Right → Root)
```

Both traversals match the input arrays.

### Complexity

- **Time:** `O(n)` — building the HashMap takes `O(n)`, and each node is constructed once with an average `O(1)` map lookup.
- **Auxiliary space:** `O(n)` for the HashMap, plus `O(h)` recursion stack, where `h` is the tree height. In the worst case, the recursion stack is `O(n)`.

### Quick recall

- Root: `postorder[post_end]`
- Left subtree size: `in_root_idx - in_st`
- Left postorder range: `post_st` to `post_st + num_in_left - 1`
- Right postorder range: `post_st + num_in_left` to `post_end - 1`
- Build left first, then right.
- Base condition for ascending ranges: `post_st > post_end` (or `in_st > in_end`).
- Assumption: node values are unique for the HashMap index lookup.

**Complexity:** `O(n)` time; `O(n)` HashMap space and `O(h)` recursion stack (`O(n)` worst case).

---

## Pattern Progress

| Problem | Status |
|---|---|
| Construct Binary Tree from Preorder and Inorder Traversal | Guided practice |
| Construct Binary Tree from Inorder and Postorder Traversal | Guided practice |

