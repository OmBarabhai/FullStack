# Pattern 3 — Tree Properties & Structural Analysis

> **Language:** Java

## Revision Navigation

| Problem | Focus |
|---|---|
| LeetCode 222 — Count Complete Tree Nodes | Count nodes using subtree recursion; complete-tree optimization |
| Check If Binary Tree Is a Sum Tree | Return subtree sums and propagate invalid status |
| LeetCode 110 — Balanced Binary Tree | Compare subtree heights and recursively validate every node |
| LeetCode 543 — Diameter of Binary Tree | Compare the diameter through each node; optimize height + diameter into one traversal |

## 1. LeetCode 222 — Count Complete Tree Nodes

**Problem:** [Count Complete Tree Nodes — LeetCode 222](https://leetcode.com/problems/count-complete-tree-nodes/)

### Simple solution — O(n)

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

**How it works:** Return `0` for an empty node. Otherwise count the current node (`1`) plus the left and right subtree counts.

### Visual dry run — follow the recursive returns

Use this small tree:

```text
        1
       / \
      2   3
     / \
    4   5
```

The recursion finishes the children before returning to their parent. The visit/return order is **postorder: left → right → root**.

```text
        1  (last)
       / \
      2   3  (after 2)
     / \
    4   5  (first)
```

**Node return order:** `4 → 5 → 2 → 3 → 1`

| Node completed | Left count | Right count | Calculation | Count returned |
|---:|---:|---:|---|---:|
| `4` | `0` | `0` | `1 + 0 + 0` | `1` |
| `5` | `0` | `0` | `1 + 0 + 0` | `1` |
| `2` | `1` (from `4`) | `1` (from `5`) | `1 + 1 + 1` | `3` |
| `3` | `0` | `0` | `1 + 0 + 0` | `1` |
| `1` | `3` (from `2`) | `1` (from `3`) | `1 + 3 + 1` | `5` |

So the method returns **`5`**. Each child returns its subtree count to its parent; the parent adds those counts and includes itself.

**Complexity:** `O(n)` time, `O(h)` recursion stack. This works for any binary tree. LeetCode 222 specifically asks for an optimized complete-tree solution (`O(log² n)`); use the complete-tree height property for that version.

## 2. Check If Binary Tree Is a Sum Tree

**Problem:** [Check If Binary Tree Is Sum Tree Or Not — Code360](https://www.naukri.com/code360/problems/check-if-binary-tree-is-sum-tree-or-not_1164404?leftPanelTabValue=SUBMISSION)

**Idea:** The helper returns the total sum of a valid subtree. It returns `-1` if the subtree is invalid.

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

**How it works:**
- `null` returns `0`; a leaf returns its own value.
- If either child returns `-1`, return `-1` immediately. An invalid child makes the whole subtree invalid.
- If the current value is not `leftSum + rightSum`, return `-1`.
- Otherwise return the total subtree sum: `root.val + leftSum + rightSum`.

**Custom test case** (catches the missing-child-check bug):

```text
1
4 10 5 4 8 -1 -1 -1 -1 -1 -1
```

Tree:

```text
        4
       / \
      10  5
     / \
    4   8
```

**Expected output:** `false`

Node `10` is invalid (`10 != 4 + 8`), so it returns `-1`. The root must also return `-1` when either child is invalid. Without the child check, the root can compare `4` with `-1 + 5` and incorrectly accept the tree.

### Visual dry run — follow the postorder traversal

The helper visits **left subtree → right subtree → current node**. The repeated value `4` appears twice in this tree: one is a leaf under node `10`, and the other is the root.

```text
          4  (root: visited last)
         / \
       10   5
      / \
     4   8  (leaves: visited first)
```

**Node return order:** `4 (leaf) → 8 → 10 → 5 → 4 (root)`

| Node completed | Left result | Right result | Check / action | Returned result |
|---|---:|---:|---|---:|
| `4` (leaf under `10`) | — | — | Leaf returns its own value | `4` |
| `8` (leaf) | — | — | Leaf returns its own value | `8` |
| `10` | `4` | `8` | `10 != 4 + 8` (`12`) | `-1` |
| `5` (leaf) | — | — | Leaf returns its own value | `5` |
| `4` (root) | `-1` | `5` | Left child is invalid, so propagate `-1` | `-1` |

**Follow the key propagation:** node `10` returns `-1` → the root receives `-1` from its left subtree → the root also returns `-1` → `isSumTree()` returns `false`.

This is why checking `leftSum == -1 || rightSum == -1` must happen before comparing the current node's value with the two sums.

**Complexity:** `O(n)` time, `O(h)` recursion stack.

**Note:** The `isSum` parameter is not used in the helper; it can be removed in a cleaner version. The important logic is returning and propagating `-1`.

## 3. LeetCode 110 — Balanced Binary Tree

**Problem:** [Balanced Binary Tree — LeetCode 110](https://leetcode.com/problems/balanced-binary-tree/)

**Idea:** A binary tree is height-balanced when, at every node, the height difference between its left and right subtrees is at most `1`.

### Understand the balance condition (from the class diagram)

At **every node**, compare the heights of its left and right subtrees:

```text
abs(left subtree height - right subtree height) <= 1
```

- Difference `0` — balanced at this node.
- Difference `1` — balanced at this node.
- Difference greater than `1` — unbalanced at this node.

The heights do **not** need to be exactly equal. The condition must be true at **every node in the tree**, not only at the root.

**Balanced example**

```text
        1
       / \
      2   5
     / \
    3   4
```

| Node | Left height | Right height | Difference | Status |
|---:|---:|---:|---:|---|
| `1` | `2` | `1` | `1` | Balanced |
| `2` | `1` | `1` | `0` | Balanced |
| `3`, `4`, `5` | `0` | `0` | `0` | Balanced |

Every node satisfies the condition, so the tree is balanced.

**Unbalanced example — the root alone can look balanced**

```text
          1
         / \
        2   6
       /   / \
      3   7   8
     /
    4
```

| Node | Left height | Right height | Difference | Status |
|---:|---:|---:|---:|---|
| `2` | `2` | `0` | `2` | **Unbalanced** |
| `6` | `1` | `1` | `0` | Balanced |
| `1` (root) | `3` | `2` | `1` | Balanced at root |

The root passes because its difference is `1`, but node `2` fails because its difference is `2`. Therefore, the **whole tree is unbalanced**. This is why we must validate every node.

In the optimized approach below, `flag` becomes `false` as soon as any node fails this check. It stays `false` even if an ancestor is balanced.

### Your recursive solution — Height calculation + subtree validation

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

### How it works

1. **Empty tree:** `root == null` returns `true` because an empty tree is balanced.
2. **Calculate heights:** `isBalancedHelp()` returns the height of a subtree. A `null` node has height `0`; otherwise, height is `1 + max(left height, right height)`.
3. **Check the current node:** If `Math.abs(leftLevels - rightLevels) > 1`, this node is unbalanced, so return `false` immediately.
4. **Check descendants:** If the current node passes, recursively check both child subtrees. This is necessary because the current node can be balanced while a deeper node is unbalanced.
5. `&&` means both left and right subtrees must be balanced.

### Example

**Balanced tree — returns `true`**

```text
        3
       / \
      9   20
         /  \
        15   7
```

At the root, the left height is `1` and the right height is `2`; the difference is `1`. The child subtrees are also balanced, so the result is `true`.

**Unbalanced tree — returns `false`**

```text
        1
       /
      2
     /
    3
```

At node `1`, the left height is `2` and the right height is `0`. The difference is `2`, which is greater than `1`, so the method returns `false`.

### Complexity

- **Time:** `O(n²)` in the worst case. `isBalancedHelp()` recalculates subtree heights for each node, so nodes can be visited repeatedly. This is especially costly for a skewed tree.
- **Auxiliary space:** `O(h)` recursion stack, where `h` is the tree height.

**Key takeaway:** Checking only the root's height difference is not enough. The recursive calls to `isBalanced(root.left)` and `isBalanced(root.right)` ensure that every node in the tree satisfies the balance condition.


### Optimized solution — Calculate height and check balance in one traversal

This version uses one recursive traversal. The helper `levels()` calculates each subtree's height and checks its balance at the same time.

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

### How it works

1. `isBalanced()` initializes the shared `flag` to `true`, calls `levels(root)`, and returns the final flag.
2. `levels(null)` returns `0` because an empty subtree has height `0`.
3. The helper first gets the left and right subtree heights. This is a postorder process: children are handled before the current node.
4. At every node, it checks `Math.abs(leftLevels - rightLevels) > 1`. If this is true, it sets `flag = false`.
5. It still returns the current node's height: `1 + Math.max(leftLevels, rightLevels)`. That height is needed by the parent node.

`flag` remembers whether **any** node was found to be unbalanced. The helper returns an `int` (height), so the flag carries the separate true/false result.

### Detailed dry run — Root looks balanced, but a lower node is not

Use this exact tree to understand why the check must happen at **every node**:

```text
          1
         / \
        2   6
       /   / \
      3   7   8
     /
    4
```

The helper uses postorder: it calculates the left and right subtree heights first, then checks the current node. A `null` child returns height `0`.

**Traversal order — follow the numbers from the leaves upward**

```text
          1  (7th)
         / \
        2   6  (3rd and 6th)
       /   / \
      3   7   8  (2nd, 4th, 5th)
     /
    4  (1st)
```

**Postorder node order:** `4 → 3 → 2 → 7 → 8 → 6 → 1`

At each node, the helper first receives the heights from its children, checks the difference, and then returns its own height to its parent.

**Step 1 — Calculate heights from the bottom upward**

| Node being processed | Left height | Right height | Difference | Height returned | `flag` after check |
|---:|---:|---:|---:|---:|---|
| `4` | `0` | `0` | `0` | `1` | `true` |
| `3` | `1` (node `4`) | `0` | `1` | `2` | `true` |
| `2` | `2` (node `3`) | `0` | `2` | `3` | `false` |
| `7` | `0` | `0` | `0` | `1` | `false` |
| `8` | `0` | `0` | `0` | `1` | `false` |
| `6` | `1` (node `7`) | `1` (node `8`) | `0` | `2` | `false` |
| `1` | `3` (node `2`) | `2` (node `6`) | `1` | `4` | `false` |

**Step 2 — Follow the important recursive returns**

1. Nodes `4`, `7`, and `8` are leaves. Each returns height `1` because both child heights are `0`.
2. Node `3` receives left height `1` and right height `0`. Difference is `1`, so it is balanced and returns height `2`.
3. Node `2` receives left height `2` and right height `0`. Difference is `2`, so `flag` changes from `true` to `false`. Node `2` still returns height `3` because its parent needs the height.
4. Node `6` receives heights `1` and `1`. Difference is `0`, so it is balanced and returns height `2`. The flag stays `false`; it is not reset.
5. Root `1` receives heights `3` and `2`. Difference is `1`, so the root itself is balanced. But the earlier failure at node `2` is still remembered by `flag`.
6. `levels(root)` finishes and `isBalanced()` returns `flag`, which is `false`.

**Result:** `false` — the root passes, but node `2` does not.

### Why the optimized code is faster than the first code

Both versions must know the left and right height at every node. The difference is **how they get those heights**.

**First code: it calculates heights again and again**

For the same tree, `isBalancedHelp(root)` first walks through the whole tree to calculate the root's child heights. Then `isBalanced(root.left)` starts another height calculation for the left subtree. The next recursive call calculates heights again for an even smaller subtree.

```text
          1  ← height calculation for root
         / \
        2   6  ← height calculation for node 2, then node 6
       /   / \
      3   7   8  ← height calculations happen again below
     /
    4
```

Think of it this way: node `4` is visited while calculating the height for root `1`, then again while calculating the height for node `2`, then again when checking node `3`, and again when checking node `4`. The same lower nodes are repeatedly visited by `isBalancedHelp()`.

**Optimized code: it calculates a height once and passes it upward**

```text
4 returns height 1
      ↓
3 receives 1, returns height 2
      ↓
2 receives 2, detects imbalance, returns height 3
      ↓
1 receives 3 from left and 2 from right, returns height 4
```

In the actual tree, the right side (`7`, `8`, then `6`) is processed too. Each node's height is calculated once by `levels()`. The parent uses the height returned by its child; it does not call a separate height traversal again.

| First code | Optimized code |
|---|---|
| `isBalancedHelp()` repeatedly walks through subtrees to recalculate heights | `levels()` calculates a node's height once and returns it to its parent |
| Then recursive `isBalanced()` calls repeat this work for child subtrees | The same traversal checks balance at each node while calculating height |
| Worst-case time: `O(n²)` | Time: `O(n)` |

**The important point:** The optimized code is not skipping nodes or doing less checking. It still checks every node. It avoids doing the **same height calculation repeatedly**. That is why it is faster.

### Why this is a bottom-up tree-DP style solution

The helper computes one piece of information for each node: **the height of its subtree**. It reuses the heights returned by its children instead of traversing those subtrees again:

```java
int leftLevels = levels(root.left);
int rightLevels = levels(root.right);
return 1 + Math.max(leftLevels, rightLevels);
```

This is a bottom-up dependency: a node's height can be calculated only after its children's heights are known. The `flag` carries the other piece of information — whether any node seen so far has violated the balance condition. It is tree-DP-like postorder processing, although the implementation uses a shared flag rather than returning a pair of values.

### Complexity

- **Time:** `O(n)` — each node is visited once; its height is calculated during the same traversal that checks its balance.
- **Auxiliary space:** `O(h)` — recursion stack, where `h` is the tree height.

### Compare the two approaches

| Approach | How it works | Time |
|---|---|---:|
| Height + recursive validation | Recalculates subtree heights at each node, then checks both subtrees | `O(n²)` worst case |
| Height + shared `flag` | Calculates heights and checks balance in the same traversal | `O(n)` |

**Revision takeaway:** The first approach asks for subtree heights repeatedly. This optimized approach gets each child's height once, checks the current node, and passes its height upward. The `flag` remembers if any node failed the balance condition. Think of it as bottom-up tree DP: each node uses the height results from its children to calculate its own height.

## 4. LeetCode 543 — Diameter of Binary Tree

**Problem:** [Diameter of Binary Tree — LeetCode 543](https://leetcode.com/problems/diameter-of-binary-tree/)

**Meaning:** The diameter is the number of **edges** on the longest path between any two nodes. The path does not have to pass through the root.

### Approach 1 — Calculate heights and check subtrees separately

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

**How it works:** At every node, calculate three possibilities:

- `a` — diameter passing through the current node: left subtree height + right subtree height.
- `b` — diameter entirely inside the left subtree.
- `c` — diameter entirely inside the right subtree.

Return the largest of these three. This checks every possible place where the longest path could occur.

**Example tree**

```text
          1
         / \
        2   3
       / \
      4   5
```

**Dry run:** Heights are measured in nodes; diameter is measured in edges.

**How the first (repeated-height) approach moves through this tree:**

```text
          1  (diameter check starts here)
         / \
        2   3
       / \
      4   5
```

1. `diameterOfBinaryTree(1)` first calculates the heights of subtrees `2` and `3`; this height work visits children before parents.
2. It then calls `diameterOfBinaryTree(2)`, which calculates the heights of `4` and `5` again.
3. It checks the diameter inside node `4`, then node `5`, and finally node `3`.
4. The root compares its own candidate (`3`) with the best results returned by its left (`2`) and right (`0`) subtrees.

The table below summarizes the **diameter candidate at each node**. Unlike the optimized approach, this first approach revisits nodes while recalculating heights.

| Current node | Left height | Right height | Diameter through node | Best diameter returned |
|---:|---:|---:|---:|---:|
| `4` | `0` | `0` | `0` | `0` |
| `5` | `0` | `0` | `0` | `0` |
| `2` | `1` | `1` | `2` | `2` |
| `3` | `0` | `0` | `0` | `0` |
| `1` | `2` | `1` | `3` | `3` |

At node `1`:

- `a = 2 + 1 = 3`
- `b = 2` (best diameter in the left subtree)
- `c = 0` (best diameter in the right subtree)
- Return `max(3, 2, 0) = 3`.

The longest path is `4 → 2 → 1 → 3`, which contains **3 edges**.

### Why the optimized code is faster than the first code

Both approaches need the height of the left and right subtree to calculate the diameter through a node. But the first approach recalculates those heights every time it checks an ancestor.

**First code — repeated height work**

```text
At node 1:
  levels(2) and levels(3)  → calculate heights
  diameter(2):
    levels(4) and levels(5) → calculate those heights AGAIN
    diameter(4), diameter(5)
  diameter(3)
```

For example, the subtree rooted at `2` is measured once when node `1` calculates its candidate diameter, and then measured again when `diameterOfBinaryTree(2)` starts. In a deeper tree, this repeated work happens at many ancestor levels.

**Optimized code — reuse the returned heights**

```text
4 returns height 1 ─┐
                    ├→ node 2 calculates diameter 2, returns height 2 ─┐
5 returns height 1 ─┘                                                   │
                                                                        ├→ node 1 calculates diameter 3
3 returns height 1 ────────────────────────────────────────────────────┘
```

Each node is processed once. When node `2` returns height `2`, node `1` uses that returned value directly. It does not run `levels(2)` again. At every node, the helper does two things with the child heights it already has:

1. Updates `max` with `leftLevel + rightLevel` (the diameter passing through this node).
2. Returns `1 + Math.max(leftLevel, rightLevel)` (this node's height for its parent).

| First code | Optimized code |
|---|---|
| Calls `levels()` to calculate heights, then recursively calculates diameters in both subtrees | One postorder helper calculates heights and updates the best diameter together |
| A subtree's height can be recalculated at multiple ancestors | Each node's height is calculated once and reused by its parent |
| Worst-case time: `O(n²)` | Time: `O(n)` |

**The important point:** The optimized version still considers the diameter through every node. It is faster because it does not repeatedly walk through the same subtree just to get its height again.

**Complexity:**

- **Time:** `O(n²)` worst case. `levels()` can revisit nodes while the diameter is being calculated at multiple ancestors. This repeated work is especially costly for a skewed tree.
- **Auxiliary space:** `O(h)` recursion stack, where `h` is the tree height.

### Approach 2 — Optimized: calculate height and update diameter in one traversal

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

**How it works:** The helper does two jobs during the same postorder traversal:

1. `leftLevel + rightLevel` gives the diameter passing through the current node. Update the global maximum with it.
2. `1 + Math.max(leftLevel, rightLevel)` returns the current subtree's height to its parent.

Height is returned upward; the maximum diameter is stored separately in `max`. The longest path may pass through any node, so update `max` at every node, not only at the root.

**Dry run using the same tree**

```text
          1  (5th)
         / \
        2   3  (3rd and 4th)
       / \
      4   5  (1st and 2nd)
```

**Postorder node order:** `4 → 5 → 2 → 3 → 1`

The helper processes both children before the current node. A null child returns height `0`. At each numbered node, it updates `max` using the two child heights, then returns its own height to its parent.

| Node processed | Left height | Right height | Diameter through node | Height returned | `max` after update |
|---:|---:|---:|---:|---:|---:|
| `4` | `0` | `0` | `0` | `1` | `0` |
| `5` | `0` | `0` | `0` | `1` | `0` |
| `2` | `1` | `1` | `2` | `2` | `2` |
| `3` | `0` | `0` | `0` | `1` | `2` |
| `1` | `2` | `1` | `3` | `3` | `3` |

At node `2`, the best diameter becomes `2`. At node `1`, it increases to `3`. The final `max` is `3`, so the answer is **3**.

**Why this is a bottom-up tree-DP style solution:** Each node reuses the heights returned by its children. Once both child heights are known, it calculates its own height and the longest path passing through itself. Each node is processed once, so subtree heights are not recalculated.

**Complexity:**

- **Time:** `O(n)` — each node is visited once.
- **Auxiliary space:** `O(h)` — recursion stack.

### Compare the two approaches

| Approach | What it does | Time | Auxiliary space |
|---|---|---:|---:|
| Height + recursive diameter | Recalculates subtree heights while checking left and right subtree diameters | `O(n²)` worst case | `O(h)` |
| Height + global maximum | Calculates height and updates the diameter in the same postorder traversal | `O(n)` | `O(h)` |

**Revision takeaway:** The diameter through a node is `left height + right height`. In the optimized approach, calculate that at every node, update the global maximum, and return the node's height to its parent.

