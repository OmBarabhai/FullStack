# Pattern 3 — Tree Properties & Structural Analysis

> **Language:** Java  
> **Revision style:** Tree-first dry runs, postorder return traces, and concise complexity notes.

## Revision Navigation

| No. | Problem | Main idea | Status |
|---:|---|---|---|
| 1 | [Count Complete Tree Nodes — LeetCode 222](#1-count-complete-tree-nodes--leetcode-222) | Add `1 + left count + right count` | Practised; revise independently |
| 2 | [Check If Binary Tree Is a Sum Tree — Code360](#2-check-if-binary-tree-is-a-sum-tree--code360) | Return subtree sum; propagate `-1` when invalid | Practised; revise independently |
| 3 | [Balanced Binary Tree — LeetCode 110](#3-balanced-binary-tree--leetcode-110) | Compare subtree heights at every node | Two approaches practised |
| 4 | [Diameter of Binary Tree — LeetCode 543](#4-diameter-of-binary-tree--leetcode-543) | Compare paths through each node | Two approaches practised |

---

## 1. Count Complete Tree Nodes — LeetCode 222

**Problem:** [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

### Java implementation — simple recursive count

```java
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
```

### Tree dry run — count returns from the leaves upward

```text
          1
         / \
        2   3
       / \
      4   5
```

The recursive calls finish the children before calculating their parent. So the **return / postorder order** is:

```text
4 → 5 → 2 → 3 → 1
```

| Current node | Left count returned | Right count returned | Calculation | Value returned |
|---:|---:|---:|---|---:|
| 4 | 0 | 0 | `1 + 0 + 0` | 1 |
| 5 | 0 | 0 | `1 + 0 + 0` | 1 |
| 2 | 1 (from 4) | 1 (from 5) | `1 + 1 + 1` | 3 |
| 3 | 0 | 0 | `1 + 0 + 0` | 1 |
| 1 | 3 (from 2) | 1 (from 3) | `1 + 3 + 1` | 5 |

**Follow the returns:**

```text
4 returns 1 ─┐
             ├─> 2 returns 3 ─┐
5 returns 1 ─┘                 │
                               ├─> 1 returns 5
3 returns 1 ──────────────────┘
```

**Answer:** `5` nodes.

### What to remember

- `null` contributes `0`.
- Every real node contributes `1` for itself.
- Add the counts returned by the left and right subtrees.

**Complexity:** `O(N)` time; `O(H)` recursion stack, where `H` is the tree height.

> **Scope note:** This is the simple `O(N)` recursive count and works for any binary tree. The file does not include the optimized complete-tree method for LeetCode 222 (`O(log² N)`).

---

## 2. Check If Binary Tree Is a Sum Tree — Code360

**Problem:** [Check If Binary Tree Is Sum Tree Or Not](https://www.naukri.com/code360/problems/check-if-binary-tree-is-sum-tree-or-not_1164404?leftPanelTabValue=SUBMISSION)

### Java implementation — submitted code

```java
public class Solution {
    public static boolean isSumTree(TreeNode<Integer> root) {
        int isSum = 1;
        isSum = isSumTreeHelp(root, isSum);
        if (isSum == -1) {
            return false;
        }
        return true;
    }

    public static int isSumTreeHelp(TreeNode<Integer> root, int isSum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }

        int leftSum = isSumTreeHelp(root.left, isSum);
        int rightSum = isSumTreeHelp(root.right, isSum);

        if (leftSum == -1 || rightSum == -1) {
            return -1;
        }
        if (root.val != leftSum + rightSum) {
            return -1;
        }
        return root.val + leftSum + rightSum;
    }
}
```

### Tree dry run — see how `-1` travels upward

Use the custom test tree from the notes:

```text
          4                 root
         / \
       10   5
      / \
     4   8                 leaves
```

The helper uses **postorder: left → right → current node**.

**Node completion order:**

```text
4 (leaf) → 8 (leaf) → 10 → 5 (leaf) → 4 (root)
```

| Current node | Left return | Right return | What happens | Helper returns |
|---|---:|---:|---|---:|
| 4 (leaf under 10) | — | — | Leaf returns its own value | 4 |
| 8 (leaf) | — | — | Leaf returns its own value | 8 |
| 10 | 4 | 8 | `10 != 4 + 8` | -1 |
| 5 (leaf) | — | — | Leaf returns its own value | 5 |
| 4 (root) | -1 | 5 | Left subtree is already invalid | -1 |

**Watch the invalid result propagate:**

```text
        4 (root)
       / \
      10  5
     / \
    4   8

4 returns 4 ─┐
             ├─> 10 checks 10 != 4 + 8 → returns -1
8 returns 8 ─┘                         │
                                       └─> root receives -1
5 returns 5 ─────────────────────────────> root returns -1
```

`isSumTree()` receives `-1`, so the final answer is **`false`**.

### What to remember

- `null` returns `0`; a leaf returns its own value.
- A non-leaf node checks whether `root.val == leftSum + rightSum`.
- If either child returns `-1`, propagate `-1` immediately. Do not treat an invalid subtree's result as an ordinary sum.
- When valid, return the **total sum of the subtree**: `root.val + leftSum + rightSum`.

**Complexity:** `O(N)` time; `O(H)` recursion stack.

**Code note:** The submitted `isSum` parameter is passed through but never used. It does not affect the result; this revision keeps the submitted implementation unchanged.

---

## 3. Balanced Binary Tree — LeetCode 110

**Problem:** [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)

A node passes when:

```text
abs(left subtree height - right subtree height) <= 1
```

A tree is balanced only when **every node** passes this condition.

### Approach 1 — calculate heights, then validate subtrees

#### Java implementation — submitted code

```java
class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftLevels = isBalancedHelp(root.left);
        int rightLevels = isBalancedHelp(root.right);
        if(Math.abs(leftLevels - rightLevels) > 1){
            return false;
        } 
        return isBalanced(root.left)  && isBalanced(root.right);
    }

    public int isBalancedHelp(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(isBalancedHelp(root.left), isBalancedHelp(root.right));
    }
}
```

### Tree dry run — root passes, but a lower node fails

```text
          1
         / \
        2   6
       /   / \
      3   7   8
     /
    4
```

Use the convention in this implementation: `null` height = `0`; a leaf height = `1`.

At root `1`, the first height calculation gives:

```text
left height  = 3   (1 → 2 → 3 → 4 has 3 edges but 3 nodes below 1)
right height = 2
Difference   = 1   → root passes
```

The method then calls `isBalanced(root.left)`. At node `2`:

```text
left subtree (3 → 4) height = 2
right subtree height        = 0
Difference                  = 2   → node 2 fails
```

| Node checked | Left height | Right height | Difference | Result at node |
|---:|---:|---:|---:|---|
| 1 | 3 | 2 | 1 | Passes |
| 2 | 2 | 0 | 2 | **Fails** |

The root's check is not enough. The recursive call into node `2` returns `false`, so the full tree returns **`false`**.

### Complexity

- **Time:** `O(N²)` worst case, because `isBalancedHelp()` recalculates subtree heights while `isBalanced()` recursively checks each subtree. This repeated work is most costly in a skewed tree.
- **Auxiliary space:** `O(H)` recursion stack.

---

### Approach 2 — optimized: calculate height and check balance in one traversal

#### Java implementation — submitted code

```java
class Solution {
    static boolean flag;
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        flag = true;
        levels(root);
        return flag;
    }

    public int levels(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        if (Math.abs(leftLevels - rightLevels) > 1) {
            flag = false;
        }
        return 1 + Math.max(leftLevels, rightLevels);
    }
}
```

### Tree dry run — postorder returns and `flag`

Use the same tree:

```text
          1  (7th)
         / \
        2   6  (3rd and 6th)
       /   / \
      3   7   8  (2nd, 4th, 5th)
     /
    4  (1st)
```

**Postorder processing:** `4 → 3 → 2 → 7 → 8 → 6 → 1`

At each node, both child heights arrive first. The helper checks their difference, then returns the current node's height to its parent.

| Node completed | Left height | Right height | Difference | Height returned | `flag` after check |
|---:|---:|---:|---:|---:|---|
| 4 | 0 | 0 | 0 | 1 | `true` |
| 3 | 1 | 0 | 1 | 2 | `true` |
| 2 | 2 | 0 | 2 | 3 | `false` |
| 7 | 0 | 0 | 0 | 1 | `false` |
| 8 | 0 | 0 | 0 | 1 | `false` |
| 6 | 1 | 1 | 0 | 2 | `false` |
| 1 | 3 | 2 | 1 | 4 | `false` |

**Follow the important returns:**

```text
4 returns height 1
       ↓
3 receives 1, returns height 2
       ↓
2 receives 2, finds difference 2 → flag = false
  returns height 3 anyway
       ↓
1 receives left height 3 and right height 2
  root difference = 1, but flag stays false
```

The helper still returns height `3` from node `2` after detecting the imbalance. Its parent needs that height to finish its own calculation. The separate `flag` remembers that a node already failed.

**Final answer:** `false`.

### Why this version is O(N)

The first approach runs a separate height traversal repeatedly. Here, `levels()` gets each child's height from its recursive return, checks the current node, and returns its own height. Each node is processed once.

```java
int leftLevels = levels(root.left);
int rightLevels = levels(root.right);
return 1 + Math.max(leftLevels, rightLevels);
```

#### Complexity and comparison

| Approach | What happens | Time | Auxiliary space |
|---|---|---:|---:|
| Height + recursive validation | Recalculates subtree heights while checking descendants | `O(N²)` worst case | `O(H)` |
| Height + shared `flag` | Calculates height and checks balance in one postorder traversal | `O(N)` | `O(H)` |

---

## 4. Diameter of Binary Tree — LeetCode 543

**Problem:** [Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)

**Diameter:** the number of **edges** on the longest path between any two nodes. That path does not have to pass through the root.

### Approach 1 — calculate heights and check subtrees separately

#### Java implementation — submitted code

```java
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = levels(root.left) + levels(root.right);
        int b = diameterOfBinaryTree(root.left);
        int c = diameterOfBinaryTree(root.right);
        return Math.max(a, Math.max(b, c));
    }

    public int levels(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = levels(root.left);
        int rightLevel = levels(root.right);
        return 1 + Math.max(leftLevel, rightLevel);
    }
}
```

### Tree dry run — compare the three diameter possibilities

```text
          1
         / \
        2   3
       / \
      4   5
```

At every current node, calculate:

```text
a = left height + right height   (path through current node)
b = best diameter in left subtree
c = best diameter in right subtree
return max(a, b, c)
```

Heights are counted in **nodes** for the helper (`null = 0`, leaf = 1). Adding the two child heights gives the diameter in **edges**.

| Current node | Left height | Right height | Through this node (`a`) | Best left (`b`) | Best right (`c`) | Returned diameter |
|---:|---:|---:|---:|---:|---:|---:|
| 4 | 0 | 0 | 0 | 0 | 0 | 0 |
| 5 | 0 | 0 | 0 | 0 | 0 | 0 |
| 2 | 1 | 1 | 2 | 0 | 0 | 2 |
| 3 | 0 | 0 | 0 | 0 | 0 | 0 |
| 1 | 2 | 1 | 3 | 2 | 0 | 3 |

At root `1`:

```text
a = 2 + 1 = 3
b = 2
c = 0
answer = max(3, 2, 0) = 3
```

One longest path is:

```text
4 → 2 → 1 → 3
     1   2   3   ← edges counted
```

**Answer:** `3` edges.

### Complexity

- **Time:** `O(N²)` worst case. The `levels()` helper recalculates subtree heights at multiple ancestor nodes.
- **Auxiliary space:** `O(H)` recursion stack.

---

### Approach 2 — optimized: calculate height and update diameter in one traversal

#### Java implementation — submitted code

```java
class Solution {
    static int max;

    public int diameterOfBinaryTree(TreeNode root) {
        max = 0;
        levels(root);
        return max;
    }

    public int levels(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = levels(root.left);
        int rightLevel = levels(root.right);
        max = Math.max(max, leftLevel + rightLevel);
        return 1 + Math.max(leftLevel, rightLevel);
    }
}
```

### Tree dry run — one postorder pass

Use the same tree:

```text
          1  (5th)
         / \
        2   3  (3rd and 4th)
       / \
      4   5  (1st and 2nd)
```

**Postorder processing:** `4 → 5 → 2 → 3 → 1`

For each node, the helper:

1. Receives the left and right heights.
2. Updates `max` with `leftLevel + rightLevel` (diameter through this node).
3. Returns `1 + max(leftLevel, rightLevel)` (height for its parent).

| Node completed | Left height | Right height | Diameter through node | Height returned | `max` after update |
|---:|---:|---:|---:|---:|---:|
| 4 | 0 | 0 | 0 | 1 | 0 |
| 5 | 0 | 0 | 0 | 1 | 0 |
| 2 | 1 | 1 | 2 | 2 | 2 |
| 3 | 0 | 0 | 0 | 1 | 2 |
| 1 | 2 | 1 | 3 | 3 | 3 |

**Trace the updates:**

```text
4 returns height 1 ─┐
                    ├─> 2 gets (1, 1): diameter = 2, returns height 2 ─┐
5 returns height 1 ─┘                                                    │
                                                                         ├─> 1 gets (2, 1): diameter = 3
3 returns height 1 ─────────────────────────────────────────────────────┘
```

`max` becomes `2` at node `2`, then becomes `3` at node `1`. The final diameter is **`3` edges**.

### Complexity and comparison

| Approach | What happens | Time | Auxiliary space |
|---|---|---:|---:|
| Height + recursive diameter | Recalculates subtree heights at multiple ancestors | `O(N²)` worst case | `O(H)` |
| Height + global maximum | Reuses child heights and updates the best diameter in the same postorder pass | `O(N)` | `O(H)` |

---

## Self-Revision Checklist

- [ ] Count nodes: trace `4 → 5 → 2 → 3 → 1` and calculate each returned count.
- [ ] Sum Tree: explain why node `10` returns `-1` and why the root must propagate it.
- [ ] Balanced Tree: show a tree where the root passes but a lower node fails.
- [ ] Optimized balance: trace postorder heights and show when `flag` first becomes `false`.
- [ ] Diameter: distinguish height (nodes) from diameter (edges).
- [ ] Optimized diameter: show how `max` is updated and how height returns to the parent.
- [ ] Reimplement each approach independently.

