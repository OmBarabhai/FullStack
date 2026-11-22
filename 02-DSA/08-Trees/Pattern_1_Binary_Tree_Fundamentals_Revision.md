# Pattern 1 — Binary Tree Fundamentals & DFS Traversals

> **Status:** In progress  
> **Language:** Java  
> **Focus:** Tree construction, recursive operations, DFS traversals, and tree mirroring.

---

## Revision Navigation

| Section | Topic |
|---|---|
| 1–2 | Node structure and binary tree types |
| 3–6 | Example tree, recursion, leaf check, and basic operations |
| 7–9 | Max/min practice, DFS traversal orders, and LeetCode traversal implementations |
| 10–13 | Invert, mirror, Same Tree, and Symmetric Tree |
| 14–17 | Complexity, common mistakes, quick revision, and runnable Java code |

---

## 1. Binary Tree Node

Each node stores a value and references to its left and right children.

```java
class Node {
    Node left;
    Node right;
    int val;

    Node(int val) {
        this.val = val;
    }
}
```

- `val`: value stored in the node.
- `left` and `right`: references to its children.
- A new node has `null` children by default.

---

## 2. Types of Binary Trees

These types describe the **structure** of a tree, except BST, which also follows a value-ordering rule.

### 1. Full Binary Tree (0 or 2 children)

Every node has either **0 children or exactly 2 children**. A node with only one child makes the tree non-full.

**Full example:**

```text
        1
       / \
      2   3
     / \
    4   5
```

Every node has either two children (`1`, `2`) or no children (`3`, `4`, `5`).

**Not full:**

```text
    1
   / \
  2   3
     /
    4
```

Node `3` has only one child.

### 2. Perfect Binary Tree

- Every internal node has exactly 2 children.
- All leaf nodes are at the same level.
- So, every level is completely filled.

```text
        1
       / \
      2   3
     / \ / \
    4  5 6   7
```

Here, all leaves (`4`, `5`, `6`, `7`) are at the same level and every position is filled.

### 3. Complete Binary Tree (CBT)

Every level is full except possibly the last. The last level must be filled **from left to right**, with no gaps.

**Complete:**

```text
        1
       / \
      2   3
     / \ /
    4  5 6
```

The last level has nodes in the leftmost positions; it does not need to be full.

**Not complete:**

```text
        1
       / \
      2   3
     /     \
    4       7
```

There is a gap before node `7`, so the last level is not filled from left to right.

### 4. Balanced Binary Tree

At **every node**, the heights of the left and right subtrees can differ by at most `1`:

```text
| height(left) - height(right) | <= 1
```

**Balanced:**

```text
        1
       / \
      2   3
     / \
    4   5
```

At node `1`, the subtree-height difference is `1`; at node `2`, it is `0`.

**Not balanced:**

```text
    1
   /
  2
 /
3
```

At node `1`, the left and right subtree heights differ by `2`.

### 5. Degenerate and Skew Binary Trees

- **Degenerate:** every non-leaf node has exactly one child. It behaves like a linked list.
- **Left-skewed:** every node continues through its left child.
- **Right-skewed:** every node continues through its right child.

**Degenerate (one child per parent):**

```text
    1
   /
  2
   \
    3
   /
  4
```

**Left-skewed:** `1 -> left 2 -> left 3`

**Right-skewed:** `1 -> right 2 -> right 3`

A skewed tree is a special case of a degenerate tree.

### 6. Binary Search Tree (BST)

For every node:
- All values in its **left subtree** are smaller.
- All values in its **right subtree** are greater.

**Valid BST:**

```text
        4
       / \
      2   6
     / \ / \
    1  3 5   7
```

**Invalid BST:**

```text
        40
       /  \
     20    60
          / \
         30  70
```

`30` is in the right subtree of `40`, but `30 < 40`. Checking only the immediate parent (`60`) is not enough; the BST rule must hold for the entire subtree.

---

## 3. Example Tree

```text
             3
           /   \
          4     2
         / \   / \
       -1   1 6   9
```

- `3` is the root.
- `-1`, `1`, `6`, and `9` are leaf nodes.
- A node can be treated as the root of its own subtree.

### Constructing the Example Tree

```java
Node a = new Node(3);
Node b = new Node(4);
Node c = new Node(2);
Node d = new Node(-1);
Node e = new Node(1);
Node f = new Node(6);
Node g = new Node(9);

a.left = b;
a.right = c;

b.left = d;
b.right = e;

c.left = f;
c.right = g;
```

---

## 4. Recursive Display — The Basic Structure

```java
private static void display(Node root) {
    if (root == null) {
        return;
    }

    // Process the current node.

    display(root.left);
    display(root.right);
}
```

The position of the processing statement determines the traversal order. Keep one visit order in each traversal method.

### Base case

```java
if (root == null) {
    return;
}
```

An empty child has nothing to process. Return to the previous recursive call.

### Recursive calls

```java
display(root.left);
display(root.right);
```

These calls process the entire left and right subtrees. When a recursive call finishes, execution continues from the next line in its caller.

---

## 5. Leaf Node Check

A **leaf node** is a node with no children.

```java
if (root.left == null && root.right == null) {
    // Current node is a leaf
}
```

Both conditions are needed:
- `root.left == null`: no left child.
- `root.right == null`: no right child.

A reusable helper:

```java
private static boolean isLeaf(Node root) {
    return root != null && root.left == null && root.right == null;
}
```

**When is this useful?** Use a leaf check when a problem asks you to:
- Count leaf nodes.
- Find root-to-leaf paths or path sums.
- Perform an action only when you reach the end of a path.

**Important:** This check does not optimize normal preorder, inorder, postorder, size, sum, max, or min. Those operations still need to process the required nodes. Also, check `root != null` before accessing `root.left` or `root.right`.

---

## 6. Basic Binary Tree Operations

These methods use **bottom-up recursion**: get the answers from the left and right subtrees, then combine them at the current node.

| Operation | What the method combines |
|---|---|
| `size()` | `1 + left size + right size` |
| `sum()` | `root.val + left sum + right sum` |
| `max()` | Largest of current value, left maximum, and right maximum |
| `min()` | Smallest of current value, left minimum, and right minimum |
| `level()` | `1 + max(left height, right height)` |

For the example tree:

```text
Size: 7
Sum: 24
Max: 9
Min: -1
Height: 3
```

### Bottom-up dry run — size, sum, max, min, and height

Use the example tree from Section 3:

```text
             3
           /   \
          4     2
         / \   / \
       -1   1 6   9
```

The calls reach the leaves first. Each node then combines the values returned by its left and right subtrees.

| Current node | Left result | Right result | Values returned by this node |
|---|---|---|---|
| `-1` | empty | empty | size `1`, sum `-1`, max `-1`, min `-1`, height `1` |
| `1` | empty | empty | size `1`, sum `1`, max `1`, min `1`, height `1` |
| `4` | `-1` | `1` | size `3`, sum `4`, max `4`, min `-1`, height `2` |
| `6` | empty | empty | size `1`, sum `6`, max `6`, min `6`, height `1` |
| `9` | empty | empty | size `1`, sum `9`, max `9`, min `9`, height `1` |
| `2` | `6` | `9` | size `3`, sum `17`, max `9`, min `2`, height `2` |
| `3` | subtree rooted at `4` | subtree rooted at `2` | size `7`, sum `24`, max `9`, min `-1`, height `3` |

**Follow one return — `size(4)`:**

```text
        4
       / \
     -1   1
```

```text
size(-1) returns 1
size(1)  returns 1
size(4)  returns 1 + 1 + 1 = 3
```

Then the root receives `size(4) = 3` and `size(2) = 3`:

```text
size(3) = 1 + 3 + 3 = 7
```

**Base cases for an empty subtree:**

| Operation | Return when `root == null` | Reason |
|---|---:|---|
| `size()` | `0` | No nodes |
| `sum()` | `0` | No values to add |
| `max()` | `Integer.MIN_VALUE` | Neutral boundary for maximum |
| `min()` | `Integer.MAX_VALUE` | Neutral boundary for minimum |
| `level()` | `0` | Empty tree has height 0 |

### Levels and Maximum Nodes

For a **perfect binary tree**:

- Nodes at level `L` = `2^(L-1)`
- Maximum total nodes in `L` levels = `2^L - 1`
- Therefore, `L = log2(n + 1)`, where `n` is the total number of nodes.

**Note:** This logarithmic height applies to a perfect tree. A skewed tree can have height `n`.

---

## 7. Maximum and Minimum — Practice Problems

### GFG — Max and Min Element in Binary Tree

[Open GFG problem](https://www.geeksforgeeks.org/problems/max-and-min-element-in-binary-tree/1)

Your solution uses two separate recursive methods:

```java
class Solution {
    public static int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}
```

### Code360 — Min and Max of Binary Tree

[Open Code360 problem](https://www.naukri.com/code360/problems/min-and-max-of-binary-tree_5673?leftPanelTabValue=SUBMISSION)

This version returns both answers together using `Pair<Integer, Integer>`.

```java
public class Solution {

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        return new Pair<>(findMin(root), findMax(root));
    }

    public static int findMax(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public static int findMin(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }
}
```

**Why `new Pair<>(...)`?**

1. The problem needs two answers: minimum and maximum.
2. `Pair<Integer, Integer>` is the return type that holds both values.
3. `findMin(root)` and `findMax(root)` calculate the two values.
4. Create a `Pair` object to return them together:

```java
return new Pair<>(findMin(root), findMax(root));
```

The `Pair` constructor expects minimum first and maximum second.

---

## 8. Three DFS Traversals

The recursive calls are the same; only the position where the current node is processed changes.

| Traversal | Order | Output for the example tree |
|---|---|---|
| Preorder | Node → Left → Right | `3 4 -1 1 2 6 9` |
| Inorder | Left → Node → Right | `-1 4 1 3 6 2 9` |
| Postorder | Left → Right → Node | `-1 1 4 6 9 2 3` |

**Memory trick:**
- Preorder: process the node **before** recursive calls.
- Inorder: process the node **between** recursive calls.
- Postorder: process the node **after** recursive calls.

### Traversal Dry Runs — Grouped Like the Tree

The following dry runs use this tree. Parentheses group the traversal of each subtree.

```text
                 1
              /     \
             2       3
            / \     / \
           4   5   6   7
          / \   \ / \  /
         8   9  11 12 13 14
```

**Inorder — Left → Root → Right**

```text
((8 4 9) 2 (5 11)) 1 ((12 6 13) 3 (14 7))

8 4 9 2 5 11 1 12 6 13 3 14 7
```

**Preorder — Root → Left → Right**

```text
1 (2 (4 8 9) (5 11)) (3 (6 12 13) (7 14))

1 2 4 8 9 5 11 3 6 12 13 7 14
```

**Postorder — Left → Right → Root**

```text
((8 9 4) (11 5) 2) ((12 13 6) (14 7) 3) 1

8 9 4 11 5 2 12 13 6 14 7 3 1
```

### Current-node visit order

The recursive calls visit the same tree, but the node is recorded at a different moment:

| Traversal | When the current node is recorded | Visit sequence |
|---|---|---|
| Preorder | Immediately on entering the node | `1 → 2 → 4 → 8 → 9 → 5 → 11 → 3 → 6 → 12 → 13 → 7 → 14` |
| Inorder | After finishing its left subtree | `8 → 4 → 9 → 2 → 5 → 11 → 1 → 12 → 6 → 13 → 3 → 14 → 7` |
| Postorder | After finishing both subtrees | `8 → 9 → 4 → 11 → 5 → 2 → 12 → 13 → 6 → 14 → 7 → 3 → 1` |

**Watch node `2`:**

- Preorder records `2`, then visits `4`, then `5`.
- Inorder visits the subtree rooted at `4`, records `2`, then visits the subtree rooted at `5`.
- Postorder finishes both `4` and `5` before recording `2`.

---

## 9. LeetCode Traversal Implementations

Each method creates one result list and passes the same list through recursion.

### LeetCode 94 — Binary Tree Inorder Traversal

```java
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }

    public void inorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }
}
```

### LeetCode 144 — Binary Tree Preorder Traversal

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalHelper(root, ans);
        return ans;
    }

    public void preorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }
}
```

### LeetCode 145 — Binary Tree Postorder Traversal

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }

    public void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        postorderTraversalHelper(root.left, ans);
        postorderTraversalHelper(root.right, ans);
        ans.add(root.val);
    }
}
```

---

## 10. Tree Transformation — Invert Binary Tree (LeetCode 226)

**Problem:** Swap the left and right child of every node so the tree becomes its mirror image.

### Original tree

```text
       4
      / \
     2   7
    / \ / \
   1  3 6  9
```

### Inverted tree

```text
       4
      / \
     7   2
    / \ / \
   9  6 3  1
```

### Java solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        
        if(root == null){
            return null;
        }

        TreeNode temp = invertTree(root.right);
        root.right = invertTree(root.left);
        root.left = temp;

        return root;
    }
}
```

### How the logic works

1. **Base case:** If `root == null`, there is no node to invert, so return `null`.
2. Invert the right subtree and keep its returned root in `temp`.
3. Invert the left subtree and place its returned root on `root.right`.
4. Put `temp` on `root.left`. The two child subtrees are now swapped.
5. Return `root`, which is the root of the inverted subtree.

The same operation happens at every node, so the entire tree is mirrored.

### Dry run — which subtree is saved and where it returns

Start with:

```text
       4
      / \
     2   7
    / \ / \
   1  3 6  9
```

The recursive calls finish the children before the current node is rewired:

| Current node | `temp = invertTree(root.right)` returns | `invertTree(root.left)` returns | Final children |
|---|---|---|---|
| `7` | node `9` | node `6` | left `9`, right `6` |
| `2` | node `3` | node `1` | left `3`, right `1` |
| `4` | mirrored subtree rooted at `7` | mirrored subtree rooted at `2` | left `7`, right `2` |

The final tree is:

```text
       4
      / \
     7   2
    / \ / \
   9  6 3  1
```

**Important:** `temp` preserves the already-inverted original right subtree while the new right pointer is assigned from the original left subtree.

**Complexity:** `O(n)` time because every node is visited once. Auxiliary recursion stack space is `O(h)`, where `h` is the tree height.

---

---

## 11. Mirror Binary Tree — Three Recursive Orders

**Goal:** Make the tree a mirror image by swapping the left and right child of every node. The tree is modified in place.

### Example

**Original tree**

```text
       1
      / \
     2   3
    / \
   4   5
```

**Mirrored tree**

```text
       1
      / \
     3   2
        / \
       5   4
```

The key operation at every node is the same: swap `root.left` and `root.right`. The important difference between the versions is **when** this swap happens relative to the recursive calls.

### Version 1 — Recurse Left, Recurse Right, Then Swap (Postorder)

```java
public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {

    if (root == null) {
        return;
    }

    // Mirror the left subtree
    mirrorBinaryTree(root.left);

    // Mirror the right subtree
    mirrorBinaryTree(root.right);

    // Swap left and right children
    BinaryTreeNode<Integer> temp = root.left;
    root.left = root.right;
    root.right = temp;
}
```

**How to think about it:** Finish both original subtrees first. Only after they have been mirrored, swap the current node's child references.

1. `root == null` is the base case. An empty subtree has nothing to mirror.
2. `mirrorBinaryTree(root.left)` mirrors the subtree that was originally on the left.
3. `mirrorBinaryTree(root.right)` mirrors the subtree that was originally on the right.
4. Save the current left child in `temp`, put the right child on the left, and put `temp` on the right.

**Why it works:** The recursive calls happen before the current node's pointers are swapped. Therefore, each call reaches the original left and original right subtrees exactly once. Then the current node swaps those two already-mirrored subtrees.

**Traversal order:** Left subtree → Right subtree → Current node's swap. This is a postorder-style solution.

### Version 2 — Swap First, Then Recurse Left and Right (Preorder)

```java
public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {

    if (root == null) {
        return;
    }

    // Swap left and right children
    BinaryTreeNode<Integer> temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Mirror the left subtree
    mirrorBinaryTree(root.left);

    // Mirror the right subtree
    mirrorBinaryTree(root.right);
}
```

**How to think about it:** First swap the current node's children. Then recursively mirror whichever subtrees are now connected on its left and right.

1. `root == null` handles an empty subtree.
2. The swap makes the original right subtree become `root.left` and the original left subtree become `root.right`.
3. `mirrorBinaryTree(root.left)` now mirrors the original right subtree.
4. `mirrorBinaryTree(root.right)` now mirrors the original left subtree.

**Why it works:** Swapping the references does not remove either subtree. It only changes which side each subtree is attached to. The two recursive calls then visit both original subtrees, one time each, and mirror them.

**Traversal order:** Current node's swap → Left subtree → Right subtree. This is a preorder-style solution.

### Version 3 — Recurse Left, Swap, Then Recurse Right (Incorrect)

```java
public static void mirrorBinaryTree(BinaryTreeNode<Integer> root) {

    if (root == null) {
        return;
    }

    // Mirror the left subtree
    mirrorBinaryTree(root.left);

    // Swap left and right children
    BinaryTreeNode<Integer> temp = root.left;
    root.left = root.right;
    root.right = temp;

    // Mirror the right subtree
    mirrorBinaryTree(root.right);
}
```

<badge color="danger">Incorrect order</badge>

**Where the logic goes wrong:** The first recursive call mirrors the original left subtree. Then the swap changes what `root.left` and `root.right` refer to. After the swap, `root.right` points to the original left subtree — the same subtree that was already mirrored.

The final recursive call therefore mirrors the original left subtree a second time. Mirroring it twice restores its original shape. The original right subtree is never mirrored.

**Dry run using the example tree**

Original:

```text
       1
      / \
     2   3
    / \
   4   5
```

1. `mirrorBinaryTree(root.left)` mirrors node `2`:

```text
     2
    / \
   5   4
```

2. Swap the children of node `1`. Now `root.left` points to node `3`, and `root.right` points to node `2`:

```text
       1
      / \
     3   2
        / \
       5   4
```

3. `mirrorBinaryTree(root.right)` now visits node `2` again. It mirrors that subtree a second time, changing its children back to `4` and `5`. Node `3` is not visited by this code.

The resulting tree is therefore not the required mirror:

```text
       1
      / \
     3   2
        / \
       4   5
```

**Main lesson:** After swapping pointers, do not assume `root.left` and `root.right` still refer to the same subtrees they referred to before the swap. Track which original subtree each pointer now references.

### Compare All Three Versions

| Version | Operation order | Correct? | Reason |
|---|---|---|---|
| 1 | Recurse left → Recurse right → Swap | Yes | Both original subtrees are mirrored before the current node is swapped. |
| 2 | Swap → Recurse left → Recurse right | Yes | After swapping, both original subtrees are still visited exactly once. |
| 3 | Recurse left → Swap → Recurse right | No | The last call revisits the already-mirrored original left subtree; the original right subtree is skipped. |

### Why Is the Method `void`?

The method changes the existing tree's child references directly. It does not create or return a new tree root. Therefore, do not assign the result of `mirrorBinaryTree(...)` to a variable; the method returns no value.

### Complexity

For either correct version:

- **Time:** `O(n)` — every node is visited once.
- **Auxiliary space:** `O(h)` — recursive call stack, where `h` is the tree height.

**Recommended version to remember:** Version 1. It is often easiest to reason about: mirror the left subtree, mirror the right subtree, then swap the current node's children.

**Connection to LeetCode 226:** Both perform the same mirror operation. LeetCode 226 returns the root (`TreeNode`), while this platform method is `void` and modifies the supplied `BinaryTreeNode` in place.

---

---

## 12. Same Tree — LeetCode 100

[Open LeetCode 100 — Same Tree](https://leetcode.com/problems/same-tree/)

**Problem:** Given the roots of two binary trees, determine whether they are the same.

Two trees are the same when:
1. They have the same structure.
2. Corresponding nodes contain the same values.

### Java solution

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } 
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }
}
```

### Understand the logic — Compare two trees together

At every position, compare the node from the first tree (`p`) with the corresponding node from the second tree (`q`). There are three checks before making the recursive calls:

**Case 1 — Both nodes are `null`: return `true`**

```java
if (p == null && q == null) {
    return true;
}
```

Both trees have no node at this position, so their structures match here.

**Case 2 — Only one node is `null`: return `false`**

```java
if (p == null || q == null) {
    return false;
}
```

One tree has a node while the other does not. Their structures are different.

**Case 3 — Both nodes exist, but their values differ: return `false`**

```java
if (p.val != q.val) {
    return false;
}
```

The corresponding nodes must contain the same value.

**Case 4 — Compare both pairs of subtrees**

```java
return isSameTree(p.left, q.left) &&
       isSameTree(p.right, q.right);
```

- Compare the left subtree of `p` with the left subtree of `q`.
- Compare the right subtree of `p` with the right subtree of `q`.
- Use `&&` because **both** comparisons must return `true` for the complete trees to be the same.

### Dry run

**Tree P**

```text
       1
      / \
     2   3
```

**Tree Q**

```text
       1
      / \
     2   3
```

Compare corresponding positions:

| Comparison | Result | Reason |
|---|---|---|
| `1` and `1` | Continue | Values match |
| `2` and `2` | Continue | Values match |
| `null` and `null` | `true` | Both positions are empty |
| `3` and `3` | Continue | Values match |
| Both complete subtree comparisons | `true` | Left and right both match |

The method returns `true`.

**Call trace for the matching trees:**

| Call | Check | Result |
|---|---|---|
| `isSameTree(1, 1)` | Values match; compare both child pairs | waits for children |
| `isSameTree(2, 2)` | Values match; both child pairs are `null/null` | `true` |
| `isSameTree(3, 3)` | Values match; both child pairs are `null/null` | `true` |
| Return to `(1, 1)` | `true && true` | `true` |

The return values travel back up the recursion tree:

```text
             (1,1) -> true
              / \
       (2,2) true  (3,3) true
          / \         / \
     (N,N) (N,N)  (N,N) (N,N)
       T      T      T     T
```

**What if the right value in Q is `4` instead of `3`?**

```text
       1                 1
      / \               / \
     2   3             2   4
```

When recursion compares `3` and `4`, the value check returns `false`. Therefore the trees are not the same.

### Why use `&&` instead of `||`?

`&&` means the left comparison **and** the right comparison must both be true. If either side differs, the complete trees are different. Using `||` would incorrectly accept trees when only one side matches.

### Complexity

Let `N` and `M` be the number of nodes in the two trees, and `H` be the maximum recursion depth reached while comparing them.

| Complexity | Value | Explanation |
|---|---|---|
| Time | `O(min(N, M))` | In the worst case, corresponding nodes are compared until the smaller tree is fully checked. |
| Auxiliary space | `O(H)` | Recursive calls use the call stack. |

### Interview pattern to remember

**Pattern:** Recursive DFS — compare two trees simultaneously.

```text
Both null?             → true
Only one null?         → false
Values different?      → false
Otherwise:
    Compare left with left
    Compare right with right
    Both must be true
```

**Key idea:** Same Tree checks both **structure and values**. Matching values alone are not enough; the corresponding left and right child positions must also match.

---

---

## 13. Symmetric Tree — LeetCode 101

[Open LeetCode 101 — Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)

**Problem:** Given the root of a binary tree, check whether the tree is a mirror of itself around its center.

A symmetric tree has matching values and structure on opposite sides. The left side must mirror the right side.

### Your approach — Mirror one subtree, then use Same Tree

You combined the two techniques already learned:

1. Mirror the left subtree using `mirror()`.
2. Compare the mirrored left subtree with the right subtree using `isSameTree()`.

**Your submitted code (including your commented alternative):**

```java
class Solution {
    
    public boolean isSymmetric(TreeNode root) {
        mirror(root.left);
        return isSameTree(root.left,root.right);
    }

    // public boolean isSymmetric(TreeNode root) {
    //     mirror(root.right);
    //     return isSameTree(root.left,root.right);
    // }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return (isSameTree(p.left, q.left) && isSameTree(p.right,q.right));
    }

    public void mirror(TreeNode root) {
        if(root == null){
            return;
        }

        mirror(root.left);
        mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp; 
    }
}
```

**Important null check:** Add this at the beginning of `isSymmetric()` so an empty tree is handled safely:

```java
if (root == null) {
    return true;
}
```

Your commented alternative—mirroring `root.right` and then comparing it with `root.left`—also works. You only need to mirror one side before comparing the two sides with `isSameTree()`.

### Dry run — Why mirroring works

Original symmetric tree:

```text
          1
        /   \
       2     2
      / \   / \
     3   4 4   3
```

After mirroring the left subtree:

```text
          1
        /   \
       2     2
      / \   / \
     4   3 4   3
```

Now the left and right subtrees have the same structure and values, so `isSameTree()` returns `true`.

### Important limitation of your approach

`mirror(root.left)` changes the original tree. The method checks symmetry correctly, but it leaves the input tree modified. For a checking function, it is usually better not to change the input tree.

### Recommended interview approach — Compare opposite sides directly

Instead of physically mirroring a subtree, compare the left child of one node with the right child of the other, and vice versa.

```java
class Solution {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode p, TreeNode q) {
        // Both positions are empty: they match.
        if (p == null && q == null) {
            return true;
        }

        // Only one position is empty: structure differs.
        if (p == null || q == null) {
            return false;
        }

        // Corresponding mirror nodes must have equal values.
        if (p.val != q.val) {
            return false;
        }

        // Compare opposite sides to check the mirror structure.
        return isMirror(p.left, q.right) &&
               isMirror(p.right, q.left);
    }
}
```

### Understand the key recursive calls

For two trees to be mirror images:

```java
isMirror(p.left, q.right)
isMirror(p.right, q.left)
```

- `p.left` must match `q.right`.
- `p.right` must match `q.left`.
- Both comparisons must be true, so use `&&`.

### Direct mirror comparison — call trace

For the tree above, the helper starts with `p = root.left` and `q = root.right`:

```text
             1
           /   \
          2     2       compare (2, 2)
         / \   / \
        3   4 4   3
```

| Helper call | What is compared | Result |
|---|---|---|
| `isMirror(2, 2)` | Values match | continue |
| `isMirror(3, 3)` | `p.left` with `q.right` | `true` after matching values and empty children |
| `isMirror(4, 4)` | `p.right` with `q.left` | `true` after matching values and empty children |
| Return to `isMirror(2, 2)` | `true && true` | `true` |

If one opposite position is empty and the other contains a node, the helper returns `false` immediately. That is how it detects a shape mismatch as well as a value mismatch.

This is the main difference from **Same Tree (LeetCode 100)**:

| Problem | Recursive comparison |
|---|---|
| Same Tree — LeetCode 100 | Left with left; right with right |
| Symmetric Tree — LeetCode 101 | Left with right; right with left |

### Complexity

Let `n` be the number of nodes and `h` be the height of the tree.

| Approach | Time | Auxiliary space | Changes input tree? |
|---|---:|---:|---|
| Mirror one side + `isSameTree()` | `O(n)` | `O(h)` | Yes |
| Direct `isMirror()` comparison | `O(n)` | `O(h)` | No |

Each approach visits at most a linear number of nodes. The recursive call stack can grow to the tree height.

### Interview pattern to remember

```text
Same Tree:
    left  ↔ left
    right ↔ right

Symmetric Tree:
    left  ↔ right
    right ↔ left
```

**Key idea:** Symmetric Tree is a mirror comparison, not an ordinary same-position comparison. Prefer the direct `isMirror()` solution in interviews because it checks the mirror relationship without modifying the original tree.

---

## 14. Complexity

Let `n` be the number of nodes and `h` be the tree height.

| Operation | Time | Auxiliary space |
|---|---:|---:|
| `size`, `sum`, `max`, `min`, `level` | `O(n)` | `O(h)` |
| Preorder, inorder, postorder | `O(n)` | `O(h)` |

For a balanced tree, recursion depth is about `O(log n)`. For a skewed tree, it can reach `O(n)`.

---

## 15. Common Mistakes

- Forgetting the `root == null` base case.
- Checking `root.left` twice instead of checking both `root.left` and `root.right` for a leaf.
- Putting the visit operation in the wrong place in a traversal.
- Thinking `return` stops all recursive calls.
- Forgetting that each recursive call processes the entire subtree rooted at that node.

---

## 16. Quick Revision

```text
Leaf node  = left == null && right == null
Preorder   = Node → Left → Right
Inorder    = Left → Node → Right
Postorder  = Left → Right → Node
Mirror     = either mirror left/right then swap, or swap then mirror both new children
```

- Empty subtree: handle it first with `if (root == null)`.
- Bottom-up recursion: get left and right answers, then combine them.
- Use a leaf check only when the problem specifically asks about leaf nodes or root-to-leaf paths.

---

## 17. Complete Runnable Java Code

This combines tree construction, leaf checking, all three traversals, and the five basic operations in one program.

```java
class Node {
    Node left;
    Node right;
    int val;

    Node(int val) {
        this.val = val;
    }
}

public class Main {

    public static void main(String[] args) {

        // Creating nodes
        Node a = new Node(3);
        Node b = new Node(4);
        Node c = new Node(2);
        Node d = new Node(-1);
        Node e = new Node(1);
        Node f = new Node(6);
        Node g = new Node(9);

        // Connecting nodes
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        System.out.print("Postorder: ");
        postorder(a);
        System.out.println();

        System.out.print("Preorder: ");
        preorder(a);
        System.out.println();

        System.out.print("Inorder: ");
        inorder(a);
        System.out.println();

        System.out.println("Size: " + size(a));
        System.out.println("Sum: " + sum(a));
        System.out.println("Max: " + max(a));
        System.out.println("Min: " + min(a));
        System.out.println("Height: " + level(a));
        System.out.println("Is -1 a leaf? " + isLeaf(d));
    }

    // Check whether a node is a leaf
    private static boolean isLeaf(Node root) {
        return root != null && root.left == null && root.right == null;
    }

    private static int size(Node root) {
        if (root == null) return 0;
        return 1 + size(root.left) + size(root.right);
    }

    private static int sum(Node root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    private static int max(Node root) {
        if (root == null) return Integer.MIN_VALUE;

        int leftMax = max(root.left);
        int rightMax = max(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }

    private static int min(Node root) {
        if (root == null) return Integer.MAX_VALUE;

        int leftMin = min(root.left);
        int rightMin = min(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    // Height measured in number of nodes
    private static int level(Node root) {
        if (root == null) return 0;

        int leftHeight = level(root.left);
        int rightHeight = level(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Node -> Left -> Right
    private static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Left -> Node -> Right
    private static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Left -> Right -> Node
    private static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}
```

**Expected output:**

```text
Postorder: -1 1 4 6 9 2 3
Preorder: 3 4 -1 1 2 6 9
Inorder: -1 4 1 3 6 2 9
Size: 7
Sum: 24
Max: 9
Min: -1
Height: 3
Is -1 a leaf? true
```
