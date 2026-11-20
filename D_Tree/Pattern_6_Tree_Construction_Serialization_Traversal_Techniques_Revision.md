# Pattern 6 — Tree Construction, Serialization & Traversal Techniques

> **Language:** Java only  
> **Revision style:** Correct tree first → follow recursive calls or pointer changes → check the final tree.

---

## Revision Navigation

| Problem | Main idea | Practice status |
|---|---|---|
| [1. Construct Binary Tree from Preorder and Inorder](#1-construct-binary-tree-from-preorder-and-inorder) | Preorder chooses the root; inorder separates left and right subtrees | Practised; reimplement independently |
| [2. Construct Binary Tree from Inorder and Postorder](#2-construct-binary-tree-from-inorder-and-postorder) | Postorder chooses the root from the end; inorder separates subtrees | Practised; reimplement independently |
| [3. Flatten Binary Tree to Linked List](#3-flatten-binary-tree-to-linked-list) | Keep preorder order and rewire the tree into a right-only chain | Three approaches practised; reimplement independently |

---

## 1. Construct Binary Tree from Preorder and Inorder

**LeetCode:** [105. Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)  
**Difficulty:** Medium

### Given input and expected tree

```text
Preorder: [3, 9, 20, 15, 7]   Root → Left → Right
Inorder:  [9, 3, 15, 20, 7]   Left → Root → Right
```

```text
             3
            / \
           9   20
              /  \
             15   7
```

### Dry run — build the tree from the root down

**1. Pick the root from preorder.** The first value is `3`. Find `3` in the current inorder range:

```text
Inorder:  [9 | 3 | 15, 20, 7]
           left       right
```

There is one value before `3`, so the left subtree has one node. The values after `3` belong to the right subtree.

```text
          3
         / \
        9   [15, 20, 7]
```

**2. Build the left side.** Its preorder and inorder ranges both contain only `9`, so attach `9` as the left child. Its child ranges are empty and return `null`.

**3. Build the right side.** Its ranges are:

```text
Preorder: [20, 15, 7]  -> root is 20
Inorder:  [15, 20, 7]  -> 15 is left of 20; 7 is right of 20
```

Attach `20` to the right of `3`, then split around `20`:

```text
             3
            / \
           9   20
              /  \
             15   7
```

### Recursive-call trace — exact index ranges

Every range in your code is **inclusive**. The formula below counts how many values are to the left of the selected root in the current inorder range:

```java
int num_in_left = root_in_idx - in_st;
```

| Current root | Preorder range | Inorder range | `num_in_left` |
|---:|---|---|---:|
| `3` | `[0..4]` | `[0..4]` | 1 |
| `9` | `[1..1]` | `[0..0]` | 0 |
| `20` | `[2..4]` | `[2..4]` | 1 |
| `15` | `[3..3]` | `[2..2]` | 0 |
| `7` | `[4..4]` | `[4..4]` | 0 |

At root `3`, the calls split like this:

```text
                 helper(...)
                 root = 3
                 /       \
       left range         right range
       [9]                [20, 15, 7]
```

At node `20`:

```text
                 helper(...)
                 root = 20
                 /        \
             [15]          [7]
```

The base condition `start > end` returns `null` when a subtree range is empty. Once both child calls return, the method returns the current `root` to its parent.

### Java implementation — submitted code

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

### Complexity and recall

- **Time:** `O(N)` — each node is created once; HashMap lookups are `O(1)` on average.
- **Auxiliary space:** `O(N)` for the map, plus `O(H)` recursion stack.
- **Assumption:** Values are unique, so the HashMap maps each value to one inorder index.

**Recall:** Preorder tells you **which node is the root**. Inorder tells you **how many nodes go left** and which values belong to the right.

---

## 2. Construct Binary Tree from Inorder and Postorder

**LeetCode:** [106. Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)  
**Difficulty:** Medium

### Given input and expected tree

```text
Inorder:   [9, 3, 15, 20, 7]   Left → Root → Right
Postorder: [9, 15, 7, 20, 3]   Left → Right → Root
```

```text
             3
            / \
           9   20
              /  \
             15   7
```

### Dry run — build the tree from the root down

**1. Pick the root from the end of postorder.** The last value is `3`. In inorder, it splits the values as:

```text
Inorder:  [9 | 3 | 15, 20, 7]
           left       right
```

**2. Build the left side.** The left inorder and postorder ranges both contain `9`, so `9` becomes the left child of `3`.

**3. Build the right side.** The current right-side postorder segment is `[15, 7, 20]`. Its last value, `20`, is the right child. In its inorder segment:

```text
Inorder: [15 | 20 | 7]
          left root right
```

So `15` becomes the left child of `20`, and `7` its right child.

### Recursive-call trace — exact index ranges

Every range is inclusive. The last item of the current postorder range is the root. The formula counts the values to its left in the current inorder segment:

```java
int numInLeft = rootInIdx - inSt;
```

| Current root | Inorder range | Postorder range | `numInLeft` |
|---:|---|---|---:|
| `3` | `[0..4]` | `[0..4]` | 1 |
| `9` | `[0..0]` | `[0..0]` | 0 |
| `20` | `[2..4]` | `[1..3]` | 1 |
| `15` | `[2..2]` | `[1..1]` | 0 |
| `7` | `[4..4]` | `[2..2]` | 0 |

At root `3`:

```text
Left:  inorder [0..0], postorder [0..0]  -> node 9
Right: inorder [2..4], postorder [1..3]  -> node 20
```

At node `20`:

```text
Left:  inorder [2..2], postorder [1..1]  -> node 15
Right: inorder [4..4], postorder [2..2]  -> node 7
```

**Range boundary to watch:** `postorder[posEn]` is the root, so the right subtree ends at `posEn - 1`. The root must not be included in either child range.

### Java implementation — submitted final code

```java
import java.util.*;

class Solution {
    public TreeNode helper(int[] inorder, int inSt, int inEn,
                           int[] postorder, int posSt, int posEn,
                           HashMap<Integer, Integer> map) {
        if (inSt > inEn || posSt > posEn) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[posEn]);
        int rootInIdx = map.get(postorder[posEn]);
        int numInLeft = rootInIdx - inSt;

        root.left = helper(inorder, inSt, rootInIdx - 1,
                           postorder, posSt,
                           posSt + numInLeft - 1, map);

        root.right = helper(inorder, rootInIdx + 1, inEn,
                            postorder, posSt + numInLeft,
                            posEn - 1, map);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        int sizeArr = inorder.length - 1;
        return helper(inorder, 0, sizeArr,
                      postorder, 0, sizeArr, map);
    }
}
```

### Complexity and recall

- **Time:** `O(N)` — each node is created once; HashMap lookups are `O(1)` on average.
- **Auxiliary space:** `O(N)` for the map, plus `O(H)` recursion stack.
- **Assumption:** Both arrays describe the same tree and values are unique.

**Recall:** Postorder's last value tells you **which node is the root**. Inorder tells you **how to split the subtrees**.

---

## 3. Flatten Binary Tree to Linked List

**LeetCode:** [114. Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)  
**Code360:** [Flatten Binary Tree to Linked List](https://www.naukri.com/code360/problems/flatten-binary-tree-to-linked-list_1112615?count=25&page=1&search=&sort_entity=order&sort_order=ASC&leftPanelTabValue=SUBMISSION)

**Required order:** Preorder — `Root → Left → Right`. The flattened tree uses only `right` pointers; every `left` pointer must be `null`.

### Approach 1 — Preorder + ArrayList (LeetCode)

#### Original tree and preorder list

```text
          1
         / \
        2   5
       / \   \
      3   4   6
```

Follow the DFS calls:

```text
Visit 1
  go left  -> visit 2
                go left  -> visit 3
                go right -> visit 4
  go right -> visit 5
                go right -> visit 6
```

So the collected references are:

```text
arr:    [1, 2, 3, 4, 5, 6]
index:   0  1  2  3  4  5
```

#### Pointer-update dry run

For each pair `a = arr[i]` and `b = arr[i + 1]`, make `a.right` point to `b` and clear `a.left`:

```java
TreeNode a = arr.get(i);
TreeNode b = arr.get(i + 1);
```

The three pointer updates inside that loop are:

```java
a.right = b;
a.left = null;
b.left = null;
```

| `i` | `a` | `b` | Update |
|---:|---:|---:|---|
| 0 | 1 | 2 | `1.right = 2` |
| 1 | 2 | 3 | `2.right = 3` |
| 2 | 3 | 4 | `3.right = 4` |
| 3 | 4 | 5 | `4.right = 5` |
| 4 | 5 | 6 | `5.right = 6` |

Every node becomes the `a` node once, except the last node. The loop also clears the next node's left pointer through `b.left = null`. Handle the final node separately:

```java
last.left = null;
last.right = null;
```

#### Final flattened structure

```text
1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
```

The right-pointer chain is `1 → 2 → 3 → 4 → 5 → 6`; all left pointers are `null`.

#### Java implementation — LeetCode submitted code

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);
        for (int i = 0; i < arr.size() - 1; i++) {
            TreeNode a = arr.get(i);
            TreeNode b = arr.get(i + 1);
            a.right = b;
            a.left = null;
            b.left = null;
        }
        TreeNode last = arr.get(arr.size() - 1);
        last.left = null;
        last.right = null;
    }

    public void dfs(TreeNode root, ArrayList<TreeNode> arr) {
        if (root == null) {
            return;
        }
        arr.add(root);
        dfs(root.left, arr);
        dfs(root.right, arr);
    }
}
```

**Complexity:** `O(N)` time for preorder collection plus pointer rewiring; `O(N)` ArrayList space and `O(H)` recursion stack.

---

### Approach 2 — Preorder + ArrayList (Code360, returns the root)

The algorithm is the same. This platform's method returns `TreeNode<Integer>`, so it must return the **original root**, which is the head of the flattened chain.

#### Sample tree and preorder

```text
          15
         /  \
        40   62
            /  \
           10   20
```

Preorder visits: `15 → 40 → 62 → 10 → 20`.

```text
arr:    [15, 40, 62, 10, 20]
index:    0   1   2   3   4
```

#### Pointer-update dry run

| `i` | `a` | `b` | Update |
|---:|---:|---:|---|
| 0 | 15 | 40 | `15.right = 40` |
| 1 | 40 | 62 | `40.right = 62` |
| 2 | 62 | 10 | `62.right = 10` |
| 3 | 10 | 20 | `10.right = 20` |

The submitted code also contains `b.right = null`. It is safe here because the next iteration writes that node's final `right` neighbour; it is redundant, not needed for the algorithm.

At the end:

```java
last.left = null;
last.right = null;
```

```text
Head (return root)                 Tail (last)
        15 → 40 → 62 → 10 → 20 → null
```

Return `root` (`15`), not `last` (`20`). Returning `last` would return only the tail reference to the caller.

#### Java implementation — Code360 submitted version

```java
public class Solution {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        if (root == null) return root;

        ArrayList<TreeNode> arr = new ArrayList<>();
        dfs(root, arr);

        for (int i = 0; i < arr.size() - 1; i++) {
            TreeNode<Integer> a = arr.get(i);
            TreeNode<Integer> b = arr.get(i + 1);
            a.right = b;
            a.left = null;
            b.right = null;
        }

        TreeNode<Integer> last = arr.get(arr.size() - 1);
        last.left = null;
        last.right = null;
        return root;
    }

    public static void dfs(TreeNode<Integer> root, ArrayList<TreeNode> arr) {
        if (root == null) return;
        arr.add(root);
        dfs(root.left, arr);
        dfs(root.right, arr);
    }
}
```

**Complexity:** `O(N)` time; `O(N)` ArrayList space plus `O(H)` recursion stack.

---

### Approach 3 — Recursive pointer rearrangement (no ArrayList)

This approach flattens the left and right subtrees first, then joins the chains. The `lst` and `rst` variables preserve the original child references while the pointers are changed.

#### Original tree

```text
          1
         / \
        2   5
       / \   \
      3   4   6
```

#### Dry run — follow the recursive returns and rewiring

**At node `2`**

```text
lst = 3
rst = 4
```

The recursive calls flatten nodes `3` and `4` (each is a leaf). Then `root.right = lst` makes `2.right = 3`. The `while` loop moves `last` from `2` to `3`, and `last.right = rst` attaches `4`:

```text
2 → 3 → 4
```

**At node `5`**

```text
lst = null
rst = 6
```

After recursively flattening `null` and node `6`, `root.right = lst` makes `5.right = null`. So `last` stays at `5`; attaching `rst` gives:

```text
5 → 6
```

**Back at node `1`**

The saved subtrees are now flattened:

```text
lst: 2 → 3 → 4
rst: 5 → 6
```

Set `1.right = lst`, then follow the right chain:

```text
1 → 2 → 3 → 4
            ↑
           last
```

Attach the saved right chain with `last.right = rst`:

```text
1 → 2 → 3 → 4 → 5 → 6
```

#### Java implementation — LeetCode (`void` return)

```java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        TreeNode lst = root.left;
        TreeNode rst = root.right;
        root.left = null;
        // root.right = null;
        flatten(lst);
        flatten(rst);
        root.right = lst;
        TreeNode last = root; // ye lst ka last element hoga
        while (last.right != null)
            last = last.right;
        last.right = rst;
    }
}
```

#### Java implementation — Code360 (returns the original root)

```java
public class Solution {
    public static TreeNode<Integer> flattenBinaryTree(TreeNode<Integer> root) {
        if (root == null)
            return root;
        TreeNode<Integer> lst = root.left;
        TreeNode<Integer> rst = root.right;
        root.left = null;
        // root.right = null;
        flattenBinaryTree(lst);
        flattenBinaryTree(rst);
        root.right = lst;
        TreeNode<Integer> last = root; // ye lst ka last element hoga
        while (last.right != null)
            last = last.right;
        last.right = rst;
        return root;
    }
}
```

#### Complexity

- **Time:** `O(N²)` worst case. A node may scan to the end of its flattened left chain. In a left-skewed tree, the repeated scans can be `N-1`, `N-2`, and so on.
- **Auxiliary space:** `O(H)` for recursive calls. This approach does not allocate an ArrayList.

#### Compare the three implementations

| Implementation | Time | Extra space | Return contract |
|---|---:|---:|---|
| LeetCode ArrayList | `O(N)` | `O(N)` list + `O(H)` stack | `void`; modifies input tree |
| Code360 ArrayList | `O(N)` | `O(N)` list + `O(H)` stack | Returns original `root` |
| Recursive pointer rearrangement | `O(N²)` worst case | `O(H)` stack | LeetCode `void`; Code360 returns `root` |

**Remember:** Save both children before changing links. Flatten both, connect the left chain after the current root, find its tail, then append the right chain. In Code360, return the original root because it remains the head.

---

## Self-Revision Checklist

- [ ] **Preorder + Inorder:** Identify the root from preorder and derive both sets of inclusive ranges.
- [ ] **Preorder + Inorder:** Explain `num_in_left = root_in_idx - in_st` and dry-run all five recursive roots.
- [ ] **Inorder + Postorder:** Identify the root from `postorder[posEn]` and explain why the right postorder range ends at `posEn - 1`.
- [ ] **Inorder + Postorder:** Derive the left and right ranges without memorising the calls.
- [ ] **Flatten — ArrayList:** Write the preorder list and trace every `a.right = b` update.
- [ ] **Flatten — Code360:** Explain why the method returns `root`, not `last`.
- [ ] **Flatten — recursion:** Trace `lst`, `rst`, and `last` at nodes `2`, `5`, and `1`.
- [ ] Compare `O(N)` ArrayList flattening with the `O(N²)` worst-case pointer-rearrangement approach.
- [ ] Reimplement each approach independently.
