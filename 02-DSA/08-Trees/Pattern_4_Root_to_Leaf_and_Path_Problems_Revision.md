# Pattern 4 — Root-to-Leaf & Path Problems

> **Language:** Java  
> **Revision style:** Tree-first dry runs, recursion state, return values, and concise complexity notes.

## Revision Navigation

| No. | Problem | What to track | Status |
|---:|---|---|---|
| 1 | [Sum Root to Leaf Numbers — LeetCode 129](#1-sum-root-to-leaf-numbers--leetcode-129) | Number built along each path; add leaf returns | Practised; revise independently |
| 2 | [Path Sum — LeetCode 112](#2-path-sum--leetcode-112) | Remaining target; boolean result at a leaf | Practised; revise independently |
| 3 | [Path Sum Count — Code360](#3-path-sum-count--code360) | Remaining target; add counts from both branches | Practised; revise independently |
| 4 | [Root-to-Leaf Paths](#4-root-to-leaf-paths--store-all-paths) | Working list, saved copy, backtracking | Practised; revise independently |
| 5 | [Binary Tree Paths — LeetCode 257](#5-binary-tree-paths--leetcode-257) | StringBuilder length and restore point | Practised; revise independently |
| 6 | [Path Sum II — LeetCode 113](#6-path-sum-ii--leetcode-113) | Remaining target, matching leaf, copied path | Practised; revise independently |

---

## 1. Sum Root to Leaf Numbers — LeetCode 129

**Problem:** [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)  
**Task:** Each root-to-leaf path forms a number. Return the sum of all those numbers.

### Java implementation — carry the number

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

### Tree dry run

```text
       1
      / \
     2   3
```

Start at `1` with `sum = 0`.

```text
At node 1: sum = 0 * 10 + 1 = 1
             /             \
            2               3
sum = 1 * 10 + 2 = 12   sum = 1 * 10 + 3 = 13
        leaf                   leaf
        return 12              return 13
```

| Call | Number entering node | Updated number | Result |
|---|---:|---:|---:|
| `sumNumbersHelp(1, 0)` | 0 | 1 | Waits for both children |
| `sumNumbersHelp(2, 1)` | 1 | 12 | Leaf returns `12` |
| `sumNumbersHelp(3, 1)` | 1 | 13 | Leaf returns `13` |
| Back at node `1` | — | — | `left + right = 12 + 13 = 25` |

**Final answer:** `25`

**What the recursion carries:** the number formed so far, not a remaining target. `sum * 10 + root.val` appends the next digit.

### Alternative implementation — explicit child cases

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

### Dry run of the child conditions

At each node, this version chooses the existing child links:

```text
          1                 1 has both children
         / \
        2   3               2 has no children → leaf
                             3 has no children → leaf
```

- At `1`, both children exist, so it calls the left and right sides and adds their returns.
- At `2`, neither child exists, so it returns `12` as a completed number.
- At `3`, neither child exists, so it returns `13`.

It produces the same result: `12 + 13 = 25`. The first implementation is shorter because the `null` base case handles missing children.

**Complexity — both implementations:** `O(N)` time, `O(H)` recursion stack. `N` is the number of nodes and `H` is the tree height.

---

## 2. Path Sum — LeetCode 112

**Problem:** [Path Sum](https://leetcode.com/problems/path-sum/)  
**Task:** Return `true` only when a root-to-leaf path adds up to `targetSum`.

### Java implementation

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

### Tree dry run — follow the remaining target

```text
       5
      /
     4
    /
   11
     \
      2
```

`targetSum = 22`. Each child receives the target left after subtracting the current node.

| Current node | Target on entry | Value passed to child | Result |
|---:|---:|---:|---|
| `5` | 22 | `22 - 5 = 17` | Continue left |
| `4` | 17 | `17 - 4 = 13` | Continue left |
| `11` | 13 | `13 - 11 = 2` | Continue right |
| `2` | 2 | — | Leaf: `2 == 2`, return `true` |

The matching path is:

```text
5 → 4 → 11 → 2
5 + 4 + 11 + 2 = 22
```

The result returns upward through the recursive calls. At a node, `leftResult || rightResult` is true when either branch finds a valid path.

**Leaf check matters:** a matching remaining target at an internal node is not enough. The path must finish at a leaf.

**Complexity:** `O(N)` time, `O(H)` recursion stack.

---

## 3. Path Sum Count — Code360

**Problem:** [Path Sum — Code360](https://www.naukri.com/code360/problems/path-sum_3170353?leftPanelTabValue=PROBLEM)  
**Task:** Return the **number** of root-to-leaf paths whose sum equals `target`. This is a count (`int`), not a boolean.

### Java implementation — submitted Code360 version

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

### Tree dry run — count matching leaves

```text
        3
       / \
      1   9
         / \
        6  10
```

`target = 4`

```text
Path 3 → 1       = 4   ✓
Path 3 → 9 → 6   = 18  ✗
Path 3 → 9 → 10  = 22  ✗
```

The method passes the **remaining target** to each child:

| Call | What happens | Returned count |
|---|---|---:|
| `pathSum(3, 4)` | Internal node; children receive `4 - 3 = 1` | `1` overall |
| `pathSum(1, 1)` | Leaf matches `1` | `1` |
| `pathSum(9, 1)` | Children receive `1 - 9 = -8` | `0` |
| `pathSum(6, -8)` | Leaf does not match; null children return `0` | `0` |
| `pathSum(10, -8)` | Leaf does not match; null children return `0` | `0` |

Returns combine with `+`:

```text
At node 9:  0 + 0 = 0
At node 3:  1 + 0 = 1
```

**Final answer:** `1`

**Important difference from LeetCode 112:** `||` answers whether a path exists; `+` adds the number of valid paths found in both subtrees.

**Code detail:** when a leaf does not match, this submitted implementation falls through to the two recursive calls on `null` children. Both return `0`, so that leaf contributes zero.

**Complexity:** `O(N)` time, `O(H)` recursion stack.

---

## 4. Root-to-Leaf Paths — Store All Paths

**Task:** Return each root-to-leaf path as its own `ArrayList<Integer>`.

### Java implementation — copy the path at a leaf

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

### Tree dry run — watch `op` and `ans`

```text
       1
      / \
     2   3
      \
       5
```

- `op` is one reusable working path.
- `ans` stores separate copies when a leaf is reached.
- After exploring a branch, `op.remove(op.size() - 1)` removes the node added by that call.

| DFS event | `op` after event | `ans` |
|---|---|---|
| Enter `1` | `[1]` | `[]` |
| Enter `2` | `[1, 2]` | `[]` |
| Enter leaf `5`; save a copy | `[1, 2, 5]` | `[[1, 2, 5]]` |
| Backtrack from `5`, then `2` | `[1]` | `[[1, 2, 5]]` |
| Enter leaf `3`; save a copy | `[1, 3]` | `[[1, 2, 5], [1, 3]]` |
| Backtrack from `3`, then `1` | `[]` | `[[1, 2, 5], [1, 3]]` |

**Final answer:** `[[1, 2, 5], [1, 3]]`

### Why copy the list?

These two statements do different things:

```java
ans.add(op);                   // Stores the same list object
ans.add(new ArrayList<>(op));  // Stores a new list with the current values
```

`ans.add(op)` stores the same list object. Later backtracking changes that object. The copied list keeps the path values as they were when the leaf was reached.

### Alternative implementation — copy with `addAll()`

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

The copy operation in this version is:

```java
ans.add(new ArrayList<>(arr));
```

It can also be written as:

```java
ArrayList<Integer> list = new ArrayList<>();
list.addAll(arr);
ans.add(list);
```

Both implementations save an independent copy. The first implementation uses the same simple order at every node: add the current value → explore/save → remove the current value. The alternative handles the leaf separately by adding it, copying, removing it, and returning.

**Complexity:** Traversal is `O(N)`. Copying paths takes time proportional to the total number of values in the returned paths. Auxiliary path and recursion space are `O(H)`; returned paths are output space.

---

## 5. Binary Tree Paths — LeetCode 257

**Problem:** [Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)  
**Task:** Return every root-to-leaf path as a string, separating values with `->`.

### Java implementation — StringBuilder + restore length

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

### Tree dry run — trace the StringBuilder

```text
       1
      / \
     2   3
      \
       5
```

`len` records the StringBuilder length **before** the current node is appended. On return, `setLength(len)` restores that exact earlier state.

| DFS event | `len` saved | `sb` after append / save | Action on return |
|---|---:|---|---|
| Enter `1` | 0 | `1` | Restore to `""` |
| Enter `2` | 1 | `1->2` | Restore to `1` |
| Enter `5` | 4 | `1->2->5` | Save path; restore to `1->2` |
| Return from `2` | — | `1->2` | `2` call restores to `1` |
| Enter `3` | 1 | `1->3` | Save path; restore to `1` |
| Return from `1` | — | `1` | Root restores to `""` |

**Final answer:** `["1->2->5", "1->3"]`

`sb.toString()` saves a separate immutable string in `ans`. The working `StringBuilder` is then reused for the next branch.

**Complexity:** `O(N + total output characters)` time. Auxiliary recursion stack and current path are `O(H)`; returned strings are output space.

---

## 6. Path Sum II — LeetCode 113

**Problem:** [Path Sum II](https://leetcode.com/problems/path-sum-ii/)  
**Task:** Return all root-to-leaf paths whose values add up to `targetSum`.

### Java implementation — path list + remaining target

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

### Tree dry run — follow both matching paths and backtracking

`targetSum = 22`

```text
              5
            /   \
           4     8
          /     / \
        11     13  4
       /  \       / \
      7    2      5   1
```

The call carries the remaining target. The current node is added to `curr`; at a matching leaf, a copy is saved.

**Left side of the tree**

| Node | Remaining target on entry | Current path | Leaf result |
|---:|---:|---|---|
| `5` | 22 | `[5]` | Internal node; children get 17 |
| `4` | 17 | `[5, 4]` | Internal node; child gets 13 |
| `11` | 13 | `[5, 4, 11]` | Internal node; children get 2 |
| `7` | 2 | `[5, 4, 11, 7]` | `7 != 2`; no path saved |
| `2` | 2 | `[5, 4, 11, 2]` | `2 == 2`; save `[5, 4, 11, 2]` |

After the left subtree finishes, backtracking restores `curr` to `[5]` before the right subtree starts.

**Right side of the tree**

| Node | Remaining target on entry | Current path | Leaf result |
|---:|---:|---|---|
| `8` | 17 | `[5, 8]` | Children get 9 |
| `13` | 9 | `[5, 8, 13]` | `13 != 9`; no path saved |
| `4` | 9 | `[5, 8, 4]` | Children get 5 |
| `5` | 5 | `[5, 8, 4, 5]` | `5 == 5`; save `[5, 8, 4, 5]` |
| `1` | 5 | `[5, 8, 4, 1]` | `1 != 5`; no path saved |

**Final answer:**

```text
[
  [5, 4, 11, 2],
  [5, 8, 4, 5]
]
```

**Pointer to the important lines:**

- `curr.add(currNode.val)` — enter the current node.
- `targetSum - currNode.val` — pass the remaining amount to the children.
- `ans.add(new ArrayList<>(curr))` — save an independent copy only at a matching leaf.
- `curr.remove(curr.size() - 1)` — undo the current node before returning to the parent/next branch.

**Complexity:** Each node is visited once (`O(N)` traversal). Copying all successful paths adds work proportional to the total output size; in a worst case this can be `O(NH)`. Auxiliary recursion and current-path space are `O(H)`, excluding the returned answer.

---

## Quick Comparison — What Does Each Recursive Call Carry?

| Problem | State passed down | What comes back / gets saved |
|---|---|---|
| Sum Root to Leaf Numbers | Number built so far | Completed number at each leaf; add the returns |
| Path Sum (boolean) | Remaining target | `true` / `false` from either branch |
| Path Sum Count | Remaining target | Count from left + count from right |
| Store All Paths | Current path list | Copy of each completed root-to-leaf path |
| Binary Tree Paths | StringBuilder + saved length | String copy at each leaf; restore builder |
| Path Sum II | Remaining target + current path | Copy only when a leaf matches |

## Self-Revision Checklist

- [ ] Sum Root to Leaf Numbers: trace `1 → 2` as `12` and `1 → 3` as `13`; add the leaf returns.
- [ ] Path Sum: subtract the current value and check equality only at a leaf.
- [ ] Path Sum Count: explain why the left and right counts are added with `+`.
- [ ] Store All Paths: trace `op`, `ans`, and each backtracking removal.
- [ ] Explain why `new ArrayList<>(op)` is required to save a path copy.
- [ ] Binary Tree Paths: trace `sb` and show why `setLength(len)` restores the parent path.
- [ ] Path Sum II: trace both valid paths and at least one non-matching leaf.
- [ ] Explain the difference between boolean existence, integer count, and collecting all paths.
- [ ] Reimplement each approach independently.
