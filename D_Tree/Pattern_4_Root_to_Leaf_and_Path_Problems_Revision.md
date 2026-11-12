# Pattern 4 — Root-to-Leaf & Path Problems

> **Language:** Java

## Revision Navigation

| Problem | Focus |
|---|---|
| LeetCode 129 — Sum Root to Leaf Numbers | Carry the number formed along each root-to-leaf path |
| LeetCode 112 — Path Sum | Carry the remaining target and validate it only at a leaf |
| Coding-platform path count variant | Count all root-to-leaf paths whose sum equals the target |
| Root-to-Leaf Paths | Store every root-to-leaf path as a separate list |
| LeetCode 257 — Binary Tree Paths | Build each root-to-leaf path as a string using `StringBuilder` |
| LeetCode 113 — Path Sum II | Collect all root-to-leaf paths whose sum equals the target |

## 1. LeetCode 129 — Sum Root to Leaf Numbers

**Problem:** [Sum Root to Leaf Numbers — LeetCode 129](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

**Idea:** Build the number while moving from the root to each leaf. Add the numbers formed by all root-to-leaf paths.

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelp(root, 0);
    }

    public int sumNumbersHelp(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        int left = sumNumbersHelp(root.left, sum);
        int right = sumNumbersHelp(root.right, sum);
        return right + left;
    }
}
```

**How it works:**
- `sum * 10 + root.val` appends the current digit to the number.
- At a leaf, return the completed path number.
- Otherwise, add the results from the left and right paths.

**Example:** The two root-to-leaf paths form `12` and `13`; answer = `25`.

```text
    1
   / \
  2   3
```

**Complexity:** `O(n)` time, `O(h)` recursion stack.

### Alternative implementation — Handle child cases separately

This version explicitly checks whether the current node has only a left child, only a right child, or both children. If neither child exists, the node is a leaf and the completed number is returned.

```java
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelp(root, 0);
    }

    public int sumNumbersHelp(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left != null) {
            return sumNumbersHelp(root.left, sum * 10 + root.val);
        }
        if (root.left == null && root.right != null) {
            return sumNumbersHelp(root.right, sum * 10 + root.val);
        }
        if (root.left != null && root.right != null) {
            return sumNumbersHelp(root.left, sum * 10 + root.val) + sumNumbersHelp(root.right, sum * 10 + root.val);
        }
        return sum * 10 + root.val;
    }
}
```

**How the conditions work:**
- **Only left child:** continue through `root.left`.
- **Only right child:** continue through `root.right`.
- **Both children:** calculate the number from each subtree and add the results.
- **No children (leaf):** return `sum * 10 + root.val`, because the root-to-leaf number is complete.

This is equivalent to the first implementation, but spells out the child cases. The first implementation is shorter because it calls both children and lets the `root == null` base case return `0` for a missing child.

## 2. LeetCode 112 — Path Sum

**Problem:** [Path Sum — LeetCode 112](https://leetcode.com/problems/path-sum/)

**Goal:** Check whether at least one root-to-leaf path has a sum equal to `targetSum`.

### Complete concise implementation

```java
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        return hasPathSum(root.left, targetSum - root.val) ||
               hasPathSum(root.right, targetSum - root.val);
    }
}
```

### Key logic

- `root == null` → return `false`; an empty branch cannot complete a path.
- `root.left == null && root.right == null` → the current node is a leaf.
- At a leaf, `targetSum == root.val` checks whether the remaining sum matches the leaf value.
- Otherwise, subtract `root.val` and search both children. `||` means either side can contain a valid path.

**Why not check `targetSum == 0` at any node?** The remaining sum can become zero before reaching a leaf. The path is valid only after reaching a leaf and matching its value.

### Dry run

Tree:

```text
      5
     /
    4
   /
  11
    \
     2
```

`targetSum = 22`

| Node | Remaining target | Result |
|---:|---:|---|
| 5 | 22 | Pass `22 - 5 = 17` |
| 4 | 17 | Pass `17 - 4 = 13` |
| 11 | 13 | Pass `13 - 11 = 2` |
| 2 | 2 | Leaf and `2 == 2` → `true` |

Path: `5 → 4 → 11 → 2`; sum = `22`.

**Complexity:** `O(N)` time; `O(H)` auxiliary recursion stack, where `H` is the tree height.


## 3. Code360 — Path Sum (Count Root-to-Leaf Paths)

**Problem:** [Path Sum — Code360](https://www.naukri.com/code360/problems/path-sum_3170353?leftPanelTabValue=PROBLEM)

**What is required?** Return the **number of leaf nodes** for which the sum of the nodes from the root to that leaf is equal to `target`.

A valid path must:
- Start at the root.
- End at a leaf (a node with no left or right child).
- Have a total sum equal to `target`.

The function returns a count. It does not return just `true` or `false`.

### Implementation

```java
public class Solution {
    public static int pathSum(TreeNode<Integer> root, int target) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            if(target == root.data){
                return 1;
            }
        }
        
        return pathSum(root.left,target - root.data) + pathSum(root.right,target - root.data);
    }
}
```

### How the recursion works

The `target` parameter represents the **sum still required** from the current node down to a leaf.

1. **Empty node:** If `root == null`, return `0`. An empty branch cannot form a valid root-to-leaf path.
2. **Leaf node:** If both children are `null`, compare the remaining `target` with `root.data`. If they match, return `1` because one valid path has been found.
3. **Internal node:** The current node is not the end of a path yet. Subtract its value from `target`, then recursively count valid paths in both subtrees.
4. **Combine counts:** Add the left and right results. Both subtrees may contain valid paths, so use `+`, not `||`.

**Why do we subtract the current node?** The current node's value has now been included in the path. The child calls only need to find the part of the sum that is still required.

**When a leaf does not match:** This implementation continues to the recursive return statement. Since both children of that leaf are `null`, the two calls return `0`, so that leaf contributes `0` to the count.

### Dry run — Code360 Sample 1, first test case

**Tree:**

```text
      3
     / \
    1   9
       / \
      6  10
```

`target = 4`

The possible root-to-leaf paths are:
- `3 → 1` = `4` — valid.
- `3 → 9 → 6` = `18` — not valid.
- `3 → 9 → 10` = `22` — not valid.

Now trace the recursive calls. Each call is shown as `pathSum(node, remainingTarget)`:

| Recursive call | What happens | Returned count |
|---|---|---:|
| `pathSum(3, 4)` | `3` is not a leaf. Remaining target becomes `4 - 3 = 1`; check both children. | `1` |
| `pathSum(1, 1)` | `1` is a leaf and `1 == 1`. This is one valid path. | `1` |
| `pathSum(9, 1)` | `9` is not a leaf. Remaining target becomes `1 - 9 = -8`; check both children. | `0` |
| `pathSum(6, -8)` | Leaf does not match. Its two `null` child calls return `0`. | `0` |
| `pathSum(10, -8)` | Leaf does not match. Its two `null` child calls return `0`. | `0` |

**Return values combine from the bottom up:**

```text
Node 9:  0 + 0 = 0
Node 3:  1 + 0 = 1
```

**Final answer:** `1`

### Key takeaway

At every node, carry the **remaining target**. A leaf contributes `1` only when its value matches that remaining target. Add the counts from the left and right subtrees to get the total number of valid paths.

**Complexity:** `O(N)` time because each node is visited once. Auxiliary recursion space is `O(H)`, where `H` is the tree height (`O(N)` in a skewed tree).

## 4. Root-to-Leaf Paths — Store All Paths

**Goal:** Return every path from the root to a leaf. Each path is stored as a separate `ArrayList<Integer>`.

### Implementation

```java
class Solution {
	public ArrayList<ArrayList<Integer>> paths(Node root) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		
		ArrayList<Integer> op = new ArrayList<>();
		dfs(root, op, ans);
		return ans;
	}
	public void dfs(Node root, ArrayList<Integer> op, ArrayList<ArrayList<Integer>> ans) {
		if (root == null) {
			return;
		}
		op.add(root.data);
		if (root.left == null && root.right == null) {
			ans.add(new ArrayList<>(op));
		}
		else {
			dfs(root.left, op, ans);
			dfs(root.right, op, ans);
		}
		op.remove(op.size() - 1);
		
	}
	
}
```

### Key logic

- `op` stores the path currently being explored.
- Add `root.data` when entering a node.
- When the node is a leaf, add `new ArrayList<>(op)` to `ans`. This copy keeps the completed path independent of later backtracking.
- Otherwise, explore the left and right children.
- Remove the current node from `op` before returning, so the next branch starts with the correct path.
- The `root == null` check handles an empty tree and missing child calls.

### Why use `new ArrayList<>(op)`?

The same `op` list is reused while recursion explores the tree. This is intentional: each recursive call receives a reference to that same list, so changes made during recursion are visible to the other calls. Backtracking then removes the last node to restore the path for the next branch.

But when a complete path is found, we must save a **separate copy** of its current values.

```java
ans.add(op);                   // Stores the same list object
ans.add(new ArrayList<>(op));  // Stores a new list with the current values
```

**What goes wrong with `ans.add(op)`?**

For this tree:

```text
    1
   / \
  2   3
   \
    5
```

When the DFS reaches leaf `5`, `op` is `[1, 2, 5]`. If we use `ans.add(op)`, `ans` stores a reference to the original `op` list; it does not save a snapshot. Backtracking then removes `5` and `2`. When DFS reaches leaf `3`, the same list becomes `[1, 3]`. The earlier entry changes too, because it still refers to that same list. After the final backtracking, the shared list becomes empty.

**What happens with `new ArrayList<>(op)`?**

The copy constructor creates a different list and copies the current elements into it. The saved path stays `[1, 2, 5]` even when the original `op` list is later changed. The next leaf is saved as another independent list, `[1, 3]`.

| Operation | Original `op` | Saved paths in `ans` when using a copy |
|---|---|---|
| Reach leaf `5` and save | `[1, 2, 5]` | `[[1, 2, 5]]` |
| Backtrack to node `1` | `[1]` | `[[1, 2, 5]]` |
| Reach leaf `3` and save | `[1, 3]` | `[[1, 2, 5], [1, 3]]` |
| Finish backtracking | `[]` | `[[1, 2, 5], [1, 3]]` |

**Remember the difference:** pass `op` into recursive calls to reuse one working path; copy it when adding a completed path to `ans` so the saved result does not change during backtracking.

**Example:**

```text
    1
   / \
  2   3
   \
    5
```

The root-to-leaf paths are:

```text
[[1, 2, 5], [1, 3]]
```

**Complexity:** `O(N + total output size)` time. Auxiliary recursion and current-path space are `O(H)`, where `H` is the tree height. The returned paths require additional output space.

### Alternative implementation — Copy using `addAll()` (screenshot approach)

This version follows the same DFS and backtracking idea. At a leaf, it first adds the leaf value, then creates a new list and copies the current path into it using `addAll()`.

```java
class Solution {
    public ArrayList<ArrayList<Integer>> paths(Node root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        dfs(root, arr, ans);
        return ans;
    }

    private void dfs(Node root, ArrayList<Integer> arr,
                     ArrayList<ArrayList<Integer>> ans) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            arr.add(root.data);

            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(arr);
            ans.add(list);

            arr.remove(arr.size() - 1);
            return;
        }

        arr.add(root.data);
        dfs(root.left, arr, ans);
        dfs(root.right, arr, ans);
        arr.remove(arr.size() - 1); // backtracking
    }
}
```

**What does `list.addAll(arr)` do?** It copies all elements currently present in `arr` into the new `list`. So these two ways both save an independent copy of the current path:

```java
ans.add(new ArrayList<>(arr));
```

```java
ArrayList<Integer> list = new ArrayList<>();
list.addAll(arr);
ans.add(list);
```

Both implementations produce the same result. The `addAll()` version handles the leaf separately: add the leaf, copy the path, remove the leaf, and return. The earlier implementation is easier to revise because it follows one consistent order for every node: **add current value → process leaf or children → remove current value**. Use that earlier implementation as the primary version; remember `addAll()` as an equivalent way to make the copy.

## 5. LeetCode 257 — Binary Tree Paths

**Problem:** [Binary Tree Paths — LeetCode 257](https://leetcode.com/problems/binary-tree-paths/)

**Goal:** Return every root-to-leaf path as a string, with node values separated by `->`.

### Implementation

```java
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, ans, sb);
        return ans;
    }

    public void dfs(TreeNode root, List<String> ans, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int len = sb.length();
        if (len > 0) {
            sb.append("->");
        }
        sb.append(root.val);

        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        } else {
            dfs(root.left, ans, sb);
            dfs(root.right, ans, sb);
        }
        sb.setLength(len);
    }
}
```

### Key logic

- `len` saves the current `StringBuilder` length before adding this node's value.
- Add `->` only when the path already contains a node; then append `root.val`.
- At a leaf, `sb.toString()` creates a `String` containing the complete path and stores it in `ans`.
- Otherwise, explore both children using the same `StringBuilder`.
- `sb.setLength(len)` removes everything added in this call and restores the path to its previous state before returning. This handles both the node value and the `->` separator, including multi-digit values.

**Example:**

```text
    1
   / \
  2   3
   \
    5
```

Output:

```text
["1->2->5", "1->3"]
```

**Remember:** `StringBuilder` is reused during recursion, so restore it after exploring a node. `sb.toString()` saves an independent `String` for each completed path.

**Complexity:** `O(N + total output length)` time. Auxiliary path and recursion space are `O(H)`, where `H` is the tree height; the returned strings require additional output space.

## 6. LeetCode 113 — Path Sum II

**Problem:** [Path Sum II — LeetCode 113](https://leetcode.com/problems/path-sum-ii/)

**Goal:** Return all root-to-leaf paths whose node values add up to `targetSum`.

### Implementation

```java
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(root, targetSum, ans, curr);
        return ans;
    }

    public void dfs(TreeNode currNode, int targetSum, List<List<Integer>> ans, List<Integer> curr) {
        if (currNode == null) {
            return;
        }
        curr.add(currNode.val);
        if (currNode.left == null && currNode.right == null && targetSum == currNode.val) {
            ans.add(new ArrayList<>(curr));
            curr.remove(curr.size() - 1);
            return;
        }
        dfs(currNode.left, targetSum - currNode.val, ans, curr);
        dfs(currNode.right, targetSum - currNode.val, ans, curr);
        curr.remove(curr.size() - 1);
    }
}
```

### Key logic

- `curr` stores the path currently being explored. Add `currNode.val` when entering a node.
- `targetSum` is the **remaining sum required**. When moving to a child, subtract the current node's value.
- Save a path only when the current node is a **leaf** and `targetSum == currNode.val`.
- `new ArrayList<>(curr)` stores an independent copy of the completed path. The working list `curr` is reused during DFS.
- Backtrack by removing the current node. In the matching-leaf case, remove it before `return`; in other cases, remove it after exploring both children.

### Dry run

For this tree with `targetSum = 22`:

```text
              5
            /   \
           4     8
          /     / \
        11     13  4
       /  \       / \
      7    2      5   1
```

The branches show the exact parent-child relationships: `5` has children `4` and `8`; `11` has children `7` and `2`; and the right-side `4` has children `5` and `1`.

The first valid path is `5 → 4 → 11 → 2`:

| Node visited | Remaining target passed to this node | Current path |
|---:|---:|---|
| 5 | 22 | `[5]` |
| 4 | 17 | `[5, 4]` |
| 11 | 13 | `[5, 4, 11]` |
| 2 | 2 | `[5, 4, 11, 2]` |

At leaf `2`, the remaining target is `2`, so the path is copied into `ans`. DFS later finds the other valid path, `5 → 8 → 4 → 5`.

**Output:** `[[5, 4, 11, 2], [5, 8, 4, 5]]`

**Complexity:** `O(N + total output size)` time; in the worst case, path copying can take `O(NH)`, where `H` is the tree height. Auxiliary recursion and current-path space are `O(H)`, excluding the returned answer.

