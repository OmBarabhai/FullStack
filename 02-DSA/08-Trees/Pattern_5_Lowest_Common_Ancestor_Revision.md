# Pattern 5 — Lowest Common Ancestor (LCA)

> **Language:** Java  
> **Focus:** Find the lowest node in a binary tree that has both target nodes as descendants. A node can also be an ancestor of itself.

---

## Revision Navigation

| Problem | Main idea | Status |
|---|---|---|
| [1. Lowest Common Ancestor of a Binary Tree](#1-lowest-common-ancestor-of-a-binary-tree) | Compare repeated `exists()` searches with a single recursive traversal | Practised with guidance; reimplement independently |
| [2. Lowest Common Ancestor of Three Nodes](#2-lowest-common-ancestor-of-three-nodes) | Compare subtree-search and single-traversal recursion | Practised with guidance; reimplement independently |
| [3. Distance Between Two Nodes of a Tree](#3-distance-between-two-nodes-of-a-tree) | Find the LCA, then add both target depths from it | Practised with guidance; reimplement independently |

---

## 1. Lowest Common Ancestor of a Binary Tree

**LeetCode:** [236. Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)  
**Difficulty:** Medium

### Core idea

At each current root, first check whether the root itself is one of the target nodes. Otherwise, search the left subtree for both targets using `exists()`.

There are three possible outcomes:

| `p` in left? | `q` in left? | What it tells us | Action |
|---|---|---|---|
| `true` | `true` | Both targets are in the left subtree | Recursively search left |
| `false` | `false` | Neither target is in the left subtree, so both are in the right subtree | Recursively search right |
| `true` | `false` | The targets are on different sides of the current root | Return current root |
| `false` | `true` | The targets are on different sides of the current root | Return current root |

**Key observation:** If both targets are found on the same side, the LCA must be in that subtree. If they are split between the left and right sides, the current root is their lowest common ancestor.

### Java implementation — submitted approach

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val == p.val || root.val == q.val)
            return root;

        boolean p_LiesInLeft = exists(root.left, p.val);
        boolean q_LiesInLeft = exists(root.left, q.val);

        if (p_LiesInLeft && q_LiesInLeft)
            return lowestCommonAncestor(root.left, p, q);

        else if (!p_LiesInLeft && !q_LiesInLeft)
            return lowestCommonAncestor(root.right, p, q);

        else
            return root;
    }

    public boolean exists(TreeNode root, int val) {
        if (root == null)
            return false;

        if (root.val == val)
            return true;

        return exists(root.left, val) || exists(root.right, val);
    }
}
```

### Understand the two methods

**`exists(root, val)`**

- Searches the subtree rooted at `root` for the target value.
- Returns `true` as soon as the value is found.
- Returns `false` when the search reaches a `null` node without finding it.
- Uses DFS: it checks the current node, then searches left or right.

**`lowestCommonAncestor(root, p, q)`**

1. If `root` is `null`, return `null` because there is no subtree to search.
2. If the current root matches `p` or `q`, return it. A target node can be an ancestor of the other target.
3. Search the left subtree separately for `p` and `q`.
4. Use the two boolean results to decide whether to continue left, continue right, or return the current root.

### Dry run

Example tree:

```text
             3
           /   \
          5     1
         / \   / \
        6   2 0   8
           / \
          7   4
```

Let `p = 6` and `q = 4`.

**Call 1 — current root is `3`**

```text
p_LiesInLeft = exists(root.left, 6) = true
q_LiesInLeft = exists(root.left, 4) = true
```

Both targets are inside the left subtree of `3`, so continue with `lowestCommonAncestor(5, p, q)`.

**Call 2 — current root is `5`**

```text
p_LiesInLeft = exists(root.left, 6) = true
q_LiesInLeft = exists(root.left, 4) = false
```

The targets are separated: `6` is in the left subtree of `5`, while `4` is not in that subtree. Therefore, return `5`.

**Result:** The LCA of nodes `6` and `4` is node `5`.

### Practical points to remember

- Always test both targets independently: `exists(root.left, p.val)` and `exists(root.left, q.val)`.
- Do not use the same target value in both checks; each boolean must describe a different target.
- Check whether the current root is `p` or `q` before searching its children. This handles the case where one target is an ancestor of the other.
- Enforce the left/right decision table consistently. Both `true` means recurse left; both `false` means recurse right; different results mean the current root is the LCA.
- This implementation assumes both target nodes are present in the tree, as guaranteed by LeetCode 236. The decision that both are on the right when neither is found on the left relies on that condition.
- The method compares node values. This is appropriate for the problem's unique node values.

### Best- and worst-case time complexity

Let `N` be the number of nodes and `H` be the height of the tree.

- **Best case — `O(1)`:** The current root is `p` or `q`. The method returns immediately before calling `exists()`.
- **Worst-case upper bound — `O(N × H)`:** At each level of the LCA search path, the method can call `exists()` for both targets. Each search may visit up to all nodes in the current left subtree. Across at most `H` levels, this gives an `O(N × H)` upper bound.
  - For a **skewed tree**, `H = N`, so the upper bound becomes `O(N²)`.
  - For a **balanced tree**, `H = O(log N)`, giving an `O(N log N)` upper bound.
- **Auxiliary space — `O(H)`:** The LCA recursion and the `exists()` DFS use call-stack space bounded by the tree height.

**Why the worst case grows:** The algorithm performs fresh subtree searches at each recursive step instead of carrying search results forward. The two calls to `exists()` change only the constant factor, not the asymptotic bound.

**Performance note:** A standard single-traversal recursive LCA solution can solve the problem in `O(N)` time. This revision focuses on the `exists()`-based approach submitted here.

### Alternative implementation — single recursive traversal

This is the standard recursive approach. Instead of calling `exists()` to inspect the left subtree repeatedly, it searches the left and right subtrees once and returns the result upward.

#### Java implementation — submitted code

```java
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return root;

        if (root.val == p.val || root.val == q.val)
            return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l != null && r != null) {
            return root;
        }

        return (l == null) ? r : l;
    }
}
```

#### How the return values work

- `null` means neither target was found in that subtree.
- A non-null node means that subtree found `p`, found `q`, or already found their LCA.
- `l` stores the result from the left subtree; `r` stores the result from the right subtree.

After both recursive calls, there are three outcomes:

| `l` | `r` | Meaning | Return |
|---|---|---|---|
| non-null | non-null | One target was found on each side | Current `root` is the LCA |
| non-null | `null` | The useful result is in the left subtree | Return `l` upward |
| `null` | non-null | The useful result is in the right subtree | Return `r` upward |
| `null` | `null` | Neither target was found below this node | Return `null` |

**Why return the current root when both sides are non-null?** Each side has found one of the targets (or a result containing a target). The current root is the first node connecting those two sides, so it is their lowest common ancestor.

**Why return whichever side is non-null?** The LCA may be deeper in one subtree. Returning that result allows the ancestor calls to receive it without searching that subtree again.

#### Dry run

Use this tree and find the LCA of `p = 6` and `q = 4`:

```text
             3
           /   \\
          5     1
         / \\   / \\
        6   2 0   8
           / \\
          7   4
```

1. At node `6`, the base condition matches `p`, so it returns node `6`.
2. In the other branch below node `5`, node `4` matches `q`, so it returns node `4`.
3. At node `5`, both results are non-null (`l = 6`, `r = 4`), so node `5` is returned.
4. At node `3`, the left result is node `5` and the right result is `null`. The method returns node `5` upward.

**Result:** LCA is node `5`.

#### Complexity

Let `N` be the number of nodes and `H` be the tree height.

- **Best case — `O(1)`:** The current root is `p` or `q`, so the method returns immediately.
- **Worst case — `O(N)`:** Each visited node is processed once. In the worst case, the recursion visits the whole tree before the required result is determined.
- **Auxiliary space — `O(H)`:** The recursive call stack is bounded by the tree height. A skewed tree can use `O(N)` stack space; a balanced tree uses `O(log N)`.

#### Compare the two approaches

| Approach | Main operation | Worst-case time | Auxiliary space |
|---|---|---:|---:|
| `exists()`-based | Repeatedly searches the left subtree for each target | `O(N × H)` upper bound | `O(H)` |
| Single recursive traversal | Searches left and right recursively and propagates non-null results | `O(N)` | `O(H)` |

**Recall:** `exists()` asks separate yes/no questions about a subtree. The single-traversal method lets each recursive call return what it found, so the tree is not searched repeatedly.

### Quick recall

```text
1. If current root is null -> return null.
2. If current root is p or q -> return current root.
3. Search left subtree for p and q separately.
4. Both found left  -> recurse left.
5. Neither found left -> recurse right.
6. One found left   -> current root is the LCA.
```

### Self-revision checklist

- [ ] Explain why the current root is returned when it equals `p` or `q`.
- [ ] Explain how `exists()` searches a subtree.
- [ ] State what each of the two boolean variables represents.
- [ ] Derive the three possible decisions without looking.
- [ ] Dry-run a case where both targets are on the same side.
- [ ] Dry-run a case where the targets are on opposite sides.
- [ ] Explain why the method assumes both targets exist in the tree.
- [ ] State the worst-case time and auxiliary-space complexity.
- [ ] Reimplement the approach independently.


---

## 2. Lowest Common Ancestor of Three Nodes

**Problem:** Lowest Common Ancestor of Three Nodes (Binary Tree)  
**Language:** Java

### Core idea

This extends the same `exists()`-based approach from the two-node LCA problem. At each current root:

1. If the current root is one of the three target values, return it.
2. Search the left subtree separately for `node1`, `node2`, and `node3`.
3. If all three are found on the left, continue into the left subtree.
4. If none are found on the left, all three are in the right subtree, so continue right.
5. Otherwise, the targets are split across the current root, so return the current root as their LCA.

**Key idea:** Move down only when all three targets are on the same side. A mixed set of boolean results means the current root is the first common ancestor that contains targets on different sides.

### Java implementation — submitted approach

```java
public class Solution {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        if (root == null) {
            return root;
        }
        if (root.data == node1 || root.data == node2 || root.data == node3) {
            return root;
        }

        boolean node1_isExisted = exist(root.left, node1);
        boolean node2_isExisted = exist(root.left, node2);
        boolean node3_isExisted = exist(root.left, node3);

        if (node1_isExisted && node2_isExisted && node3_isExisted)
            return lcaOfThreeNodes(root.left, node1, node2, node3);

        else if (!node1_isExisted && !node2_isExisted && !node3_isExisted)
            return lcaOfThreeNodes(root.right, node1, node2, node3);
        else
            return root;
    }

    public static boolean exist(BinaryTreeNode<Integer> root, int val) {
        if (root == null)
            return false;
        if (root.data == val)
            return true;
        return exist(root.left, val) || exist(root.right, val);
    }
}
```

### Understand the three checks

Each boolean answers one independent question: does this target exist anywhere inside the current root's left subtree?

| Variable | Search | Meaning when `true` |
|---|---|---|
| `node1_isExisted` | `exist(root.left, node1)` | `node1` is in the left subtree |
| `node2_isExisted` | `exist(root.left, node2)` | `node2` is in the left subtree |
| `node3_isExisted` | `exist(root.left, node3)` | `node3` is in the left subtree |

The decision table is:

| Node 1 in left? | Node 2 in left? | Node 3 in left? | Decision |
|---|---|---|---|
| `true` | `true` | `true` | All targets are left; recurse left |
| `false` | `false` | `false` | All targets are right; recurse right |
| Mixed results | Mixed results | Mixed results | Targets are split; return current root |

The `root.data == node1 || root.data == node2 || root.data == node3` condition handles a target that is itself an ancestor of the other target nodes.

### Practical dry run

Example tree:

```text
             1
           /   \\
          2     3
         / \\   / \\
        4   5  6   7
```

Find the LCA of `4`, `5`, and `6`.

**Call 1 — current root is `1`**

```text
node1_isExisted = exist(root.left, 4) = true
node2_isExisted = exist(root.left, 5) = true
node3_isExisted = exist(root.left, 6) = false
```

The results are mixed: `4` and `5` are in the left subtree, while `6` is not. The current root `1` is therefore the lowest node whose subtree contains all three targets.

**Result:** `1`

### Important points to remember

- Run `exist()` separately for each target value. Each boolean must represent a different node.
- Recurse left only when all three booleans are `true`.
- Recurse right only when all three booleans are `false`.
- Any mixed combination means the current root is the LCA.
- Check whether the current root matches any target before searching its children.
- This decision logic assumes all three target nodes exist in the tree. When none is found in the left subtree, the method treats all three as being in the right subtree.
- The method compares node values, so the values are expected to identify the target nodes uniquely.

### Best- and worst-case time complexity

Let `N` be the number of nodes and `H` be the height of the tree.

- **Best case — `O(1)`:** The current root matches any one of `node1`, `node2`, or `node3`. The method returns immediately before calling `exist()`.
- **Worst-case upper bound — `O(N × H)`:** At each level on the LCA search path, the method can perform three subtree searches. Each search may visit up to all nodes in the current left subtree. Across at most `H` levels, this gives an `O(N × H)` upper bound.
  - For a **skewed tree**, `H = N`, so the upper bound becomes `O(N²)`.
  - For a **balanced tree**, `H = O(log N)`, giving an `O(N log N)` upper bound.
- **Auxiliary space — `O(H)`:** The recursion stacks used by `lcaOfThreeNodes()` and `exist()` are bounded by the tree height.

**Why the worst case grows:** The method repeats subtree searches at each recursive step. Using three calls to `exist()` instead of two changes the constant factor, but the asymptotic upper bound remains `O(N × H)`.

### Quick recall

```text
1. If current root is null -> return null.
2. If current root matches any target -> return current root.
3. Check all three targets in the left subtree separately.
4. All true  -> recurse left.
5. All false -> recurse right.
6. Mixed     -> current root is the LCA.
```

### Self-revision checklist

- [ ] Explain what each of the three `exist()` calls checks.
- [ ] Explain why all three `true` means recurse left.
- [ ] Explain why all three `false` means recurse right.
- [ ] Explain why a mixed result means the current root is the LCA.
- [ ] Explain why the current root is returned when it matches any target.
- [ ] Dry-run a case where all three targets are on the same side.
- [ ] Dry-run a case where the targets are split across sides.
- [ ] State the assumption that all three target nodes are present.
- [ ] State time and auxiliary-space complexity.
- [ ] Reimplement the approach independently.

### Alternative implementation — single recursive traversal

This version uses the recursive-return idea from the standard two-node LCA approach. It does not call `exist()` separately for each target. Instead, each recursive call returns a target node it found or the LCA already identified in that subtree.

### Java implementation — submitted code

```java
public class Solution {
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        if (root == null) {
            return root;
        }
        if (root.data == node1 || root.data == node2 || root.data == node3) {
            return root;
        }

        BinaryTreeNode<Integer>  r = lcaOfThreeNodes(root.left, node1,node2,node3);
        BinaryTreeNode<Integer>  l = lcaOfThreeNodes(root.right, node1,node2,node3);

        if (l != null && r != null){
            return root;
        }
        return (l == null) ? r : l;
    }
}
```

### How the recursive returns work

- If `root` is `null`, return `null`: this branch did not find a target.
- If the current root matches any target, return that node immediately.
- Otherwise, recursively search both children.
- In this submitted code, `r` stores the result from `root.left`, while `l` stores the result from `root.right`. Remember what each variable actually receives.
- If both results are non-null, target results were found on both sides. The current root connects those sides, so it is the LCA.
- If only one result is non-null, pass that result upward. If both are null, the expression returns `null`.

| Left-call result (`r`) | Right-call result (`l`) | Returned value |
|---|---|---|
| Non-null | Non-null | Current `root` — targets are found in both sides |
| Non-null | `null` | `r` — pass the left result upward |
| `null` | Non-null | `l` — pass the right result upward |
| `null` | `null` | `null` — no target was found in this subtree |

### Practical dry run

Use this tree and find the LCA of `4`, `5`, and `6`:

```text
             1
           /   \\
          2     3
         / \\   / \\
        4   5  6   7
```

**At node `2`:**

- The left call reaches `4`, which matches a target and returns node `4`.
- The right call reaches `5`, which matches a target and returns node `5`.
- Both child results are non-null, so node `2` is returned from this subtree.

**At node `3`:**

- The left call reaches `6`, which matches a target and returns node `6`.
- The right call reaches `7`, which does not match a target, so that call returns `null`.
- Only one child result is non-null, so node `6` is passed upward.

**At node `1`:**

- The left subtree returns node `2`.
- The right subtree returns node `6`.
- Both results are non-null, so node `1` is returned.

**Result:** `1` is the LCA of `4`, `5`, and `6`.

### Complexity

Let `N` be the number of nodes and `H` the height of the tree.

- **Best case — `O(1)`:** The current root matches one of the three target values, so it is returned immediately.
- **Worst case — `O(N)`:** Each node is visited at most once. The two recursive calls explore the left and right subtrees without repeating subtree searches.
- **Auxiliary space — `O(H)`:** The recursive call stack follows the tree height: `O(log N)` for a balanced tree and `O(N)` for a skewed tree.

### Compare the two three-node approaches

| Approach | Best case | Worst case | Auxiliary space |
|---|---:|---:|---:|
| Repeated `exist()` searches | `O(1)` | `O(N × H)` upper bound | `O(H)` |
| Single recursive traversal | `O(1)` | `O(N)` | `O(H)` |

**Practical takeaway:** The `exist()` version explicitly checks whether each target is in the left subtree. The single-traversal version is more efficient because it uses the results returned by recursion instead of searching subtrees again.

### Quick recall

```text
1. Null node -> return null.
2. Current node matches any target -> return current node.
3. Get one result from the left subtree and one from the right.
4. Both results non-null -> current node is the LCA.
5. Otherwise -> return whichever result is non-null.
```

### Self-revision checklist

- [ ] Explain what each recursive call returns.
- [ ] Explain why two non-null results make the current node the LCA.
- [ ] Explain why one non-null result must be passed upward.
- [ ] Remember that `r` stores the left result and `l` stores the right result in this code.
- [ ] Dry-run a case where all targets are in one subtree.
- [ ] Dry-run a case where targets are spread across both subtrees.
- [ ] State the `O(N)` worst-case time and `O(H)` auxiliary-space complexity.
- [ ] Reimplement the single-traversal approach independently.

---

## 3. Distance Between Two Nodes of a Tree

**Problem:** Distance between two nodes of a Tree  
**Difficulty:** Moderate  
**Language:** Java

### Core idea

The distance between two nodes is the minimum number of **edges** on the path connecting them. Use the Lowest Common Ancestor (LCA) to split that path into two parts:

\[
\text{Distance}(node1,node2) = \text{depth}(node1\text{ from LCA}) + \text{depth}(node2\text{ from LCA})
\]

The solution has three steps:

1. Find the LCA of `node1` and `node2`.
2. Run DFS starting from the LCA. Track the depth of each target relative to the LCA.
3. If both target depths were found, add them. Otherwise, return `-1`.

### Java implementation — submitted code

```java
public class Solution {
    public static int findDistanceBetweenNodes(TreeNode root, int node1, int node2) {
        TreeNode lca = lca(root, node1, node2);
        int[] dst = { -1, -1 };
        dfs(lca, node1, node2, 0, dst);
        int node1Found = dst[0];
        int node2Found = dst[1];
        int ans = node1Found + node2Found;
        return (node1Found == -1 || node2Found == -1) ? -1 : ans;
    }

    public static void dfs(TreeNode root, int node1, int node2, int depth, int[] dst) {
        if (root == null)
            return;
        if (root.val == node1)
            dst[0] = depth;
        if (root.val == node2)
            dst[1] = depth;
        dfs(root.left, node1, node2, depth + 1, dst);
        dfs(root.right, node1, node2, depth + 1, dst);

    }

    public static TreeNode lca(TreeNode root, int node1, int node2) {
        if (root == null) {
            return root;
        }
        if (root.val == node1 || root.val == node2) {
            return root;
        }
        TreeNode l = lca(root.left, node1, node2);
        TreeNode r = lca(root.right, node1, node2);

        if (l != null && r != null) {
            return root;
        }
        return (l == null) ? r : l;
    }
}
```

### Understand the implementation

**Step 1 — Find the LCA**

```java
TreeNode lca = lca(root, node1, node2);
```

The existing recursive LCA method identifies the lowest node whose subtree contains both target values. The path from `node1` to `node2` passes through this LCA.

**Step 2 — Find both depths using DFS**

```java
int[] dst = { -1, -1 };
dfs(lca, node1, node2, 0, dst);
```

- DFS starts at the LCA with `depth = 0`.
- Moving to either child increases the depth by one because distance is measured in edges.
- `dst[0]` stores the depth of `node1` from the LCA.
- `dst[1]` stores the depth of `node2` from the LCA.
- Both values start at `-1`, meaning that the corresponding target has not been found yet.

When a target is found, its current depth is stored in the matching array position.

**Step 3 — Validate and add the depths**

```java
int node1Found = dst[0];
int node2Found = dst[1];
int ans = node1Found + node2Found;
return (node1Found == -1 || node2Found == -1) ? -1 : ans;
```

If either target depth is still `-1`, that target was not found, so return `-1`. Otherwise, their depths add up to the distance between the nodes.

**Why initialize with `-1`?** A depth of `0` is valid: it occurs when a target is the LCA itself. Using `-1` as the not-found marker keeps a valid zero distance separate from a missing target.

### Dry run — sample 1

The sample tree is represented as:

```text
             5
           /   \
          6     2
         / \
        4   3
       / \
      9   7
```

Find the distance between `node1 = 7` and `node2 = 2`.

**Step 1 — LCA**

- Node `7` is in the left subtree of `5`.
- Node `2` is in the right subtree of `5`.
- Therefore, the LCA is `5`.

**Step 2 — DFS from node 5**

| Current node | Depth from 5 | Action |
|---|---:|---|
| 5 | 0 | Starting point (LCA) |
| 6 | 1 | Continue left |
| 4 | 2 | Continue left |
| 9 | 3 | Not a target |
| 7 | 3 | Store `dst[0] = 3` |
| 3 | 2 | Not a target |
| 2 | 1 | Store `dst[1] = 1` |

**Step 3 — Add the depths**

```text
dst = {3, 1}
Distance = 3 + 1 = 4
```

The path is `7 -> 4 -> 6 -> 5 -> 2`, which contains four edges.

### Important edge cases

| Case | Depth array after DFS | Result |
|---|---|---:|
| Both targets are the same existing node (`9`, `9`) | `{0, 0}` when that node is the LCA | `0` |
| One target is missing | One position remains `-1` | `-1` |
| Both targets exist and are different | Both positions contain their depths | Sum of both depths |

The same-node case works because both target checks match the same node, and both array positions receive its depth. If that node is the LCA, both depths are zero.

### Complexity

Let `N` be the number of nodes and `H` the height of the tree.

- **LCA:** `O(N)` worst-case time.
- **DFS:** `O(N)` worst-case time, since it may visit every node in the LCA's subtree.
- **Total time:** `O(N) + O(N) = O(N)`.
- **Auxiliary space:** `O(H)` for the recursive call stack. The distance array uses `O(1)` extra space.

### Quick recall

```text
1. Find LCA(node1, node2).
2. Start DFS from the LCA at depth 0.
3. Store node1's depth in dst[0].
4. Store node2's depth in dst[1].
5. If either depth is -1 -> return -1.
6. Otherwise -> return dst[0] + dst[1].
```

### Self-revision checklist

- [ ] Explain why the path between the targets passes through their LCA.
- [ ] Explain why DFS starts from the LCA with depth `0`.
- [ ] Explain why each recursive child call uses `depth + 1`.
- [ ] Explain what `dst[0]` and `dst[1]` store.
- [ ] Explain why `-1` is used as the not-found marker instead of `0`.
- [ ] Dry-run a case where the LCA is one of the target nodes.
- [ ] Dry-run a case where both target values are equal.
- [ ] Dry-run a case where one target is missing.
- [ ] State the `O(N)` time and `O(H)` auxiliary-space complexity.
- [ ] Reimplement the solution independently.

---

## Pattern progress

| Problem | Status |
|---|---|
| Lowest Common Ancestor of a Binary Tree — LeetCode 236 | Practised with guidance; reimplement independently |
| Lowest Common Ancestor of Three Nodes | Practised with guidance; reimplement independently |
| Distance Between Two Nodes of a Tree | Practised with guidance; reimplement independently |

