# Pattern 2 — Level Order, Views & Positional Traversals

> **Language:** Java  
> **Study style:** Tree first → queue trace → code → output → complexity  
> **Rule:** The submitted Java implementations below are kept unchanged. The explanations and dry runs are reorganized for faster revision.

## Revision Navigation

| No. | Problem | Platform | Main pattern |
|---:|---|---|---|
| 1 | Binary Tree Level Order Traversal | LeetCode 102 | BFS + one list per level |
| 2 | Binary Tree Zigzag Level Order Traversal | LeetCode 103 | BFS + alternate insertion direction |
| 3 | ZigZag Traversal (flat output) | Code360 | BFS + reverse / deque |
| 4 | Level Order Traversal (flat output) | Code360 | BFS + `addAll()` |
| 5 | Binary Tree Level Order Traversal II | LeetCode 107 | BFS + reverse level lists |
| 6 | Binary Tree Right Side View | LeetCode 199 | Last node at each level |
| 7 | Left View of a Binary Tree | GeeksforGeeks | First node at each level |
| 8 | Boundary Traversal of a Binary Tree | Code360 | Root + left boundary + leaves + reversed right boundary (recursive and iterative) |

---

## Before These Problems — Understand the BFS Queue

For all BFS problems, use this tree first:

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

The queue is FIFO: the first node added is the first node removed.

**One level at a time:**

| Level | Queue at start | Nodes removed (visit order) | Children added | Queue after level |
|---:|---|---|---|---|
| 1 | `[1]` | `1` | `2, 3` | `[2, 3]` |
| 2 | `[2, 3]` | `2, 3` | `4, 5, 6, 7` | `[4, 5, 6, 7]` |
| 3 | `[4, 5, 6, 7]` | `4, 5, 6, 7` | — | `[]` |

**The important line:**

```java
int currLevelSize = Q.size();
```

Save the queue size before processing the level. Children added during the `for` loop must wait for the next level.

---

## 1. LeetCode 102 — Binary Tree Level Order Traversal

**Problem:** [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)  
**Goal:** Return a separate list for every level, from left to right.

### Tree and dry run

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

| Level | Saved size | `Q` removes | `op` collected | `Q` after adding children |
|---:|---:|---|---|---|
| 1 | 1 | `1` | `[1]` | `[2, 3]` |
| 2 | 2 | `2, 3` | `[2, 3]` | `[4, 5, 6, 7]` |
| 3 | 4 | `4, 5, 6, 7` | `[4, 5, 6, 7]` | `[]` |

**Output:**

```text
[[1], [2, 3], [4, 5, 6, 7]]
```

### Java implementation — submitted code


```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            List<Integer> op = new ArrayList<>();
            int currLevelSize = Q.size();

            for (int i = 1; i <= currLevelSize; i++) {
                TreeNode front = Q.remove();
                op.add(front.val);

                if (front.left != null) {
                    Q.add(front.left);
                }
                if (front.right != null) {
                    Q.add(front.right);
                }
            }

            ans.add(op);
        }

        return ans;
    }
}
```

### Follow the loop

1. `Q.remove()` gives the next node in the current level.
2. `op.add(front.val)` stores that node's value.
3. Add `front.left`, then `front.right`, to the queue.
4. After exactly `currLevelSize` removals, add `op` to `ans`.

**Boundary check:** If `root == null`, return the empty `ans`. `ArrayDeque` does not accept `null`.

### Complexity

- **Time:** `O(N)` — each node is added to and removed from the queue once.
- **Auxiliary space:** `O(W)` — `W` is the maximum number of nodes at any level. The result list is output space.

**Quick recall:** `Queue + saved level size + one list per level`.

---

## 2. LeetCode 103 — Binary Tree Zigzag Level Order Traversal

**Problem:** [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)  
**Goal:** Return levels in alternating directions: left-to-right, then right-to-left.

### Tree and dry run

Use the same tree:

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

The queue always removes nodes in normal BFS order. Only the insertion direction into `op` changes.

| Level | Direction | Queue removes | Insertions into `op` | Completed `op` |
|---:|---|---|---|---|
| 1 | Left → right | `1` | `addLast(1)` | `[1]` |
| 2 | Right → left | `2, 3` | `addFirst(2)`, then `addFirst(3)` | `[3, 2]` |
| 3 | Left → right | `4, 5, 6, 7` | `addLast()` in visit order | `[4, 5, 6, 7]` |

**Output:**

```text
[[1], [3, 2], [4, 5, 6, 7]]
```

### Java implementation — submitted code


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        boolean leftToRight = true;
        while (!Q.isEmpty()) {
            int currLevelSize = Q.size();
            List<Integer> op = new ArrayList<>();
            for (int i = 1; i <= currLevelSize; i++) {
                TreeNode front = Q.remove();
                if(leftToRight){
                    op.addLast(front.val);
                }else{
                    op.addFirst(front.val);
                }
                if(front.left != null){
                    Q.add(front.left);
                }
                if(front.right != null){
                    Q.add(front.right);
                }
            }
            ans.add(op);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}
```

### Important Java version note

The submitted implementation declares `op` as `List<Integer>` and calls `addFirst()` / `addLast()`. Those `List` methods require **Java 21+**. For Java 17, use the Code360 deque-style implementation in Problem 3, where the current-level container is declared as `Deque<Integer>`.

### Complexity

- With `ArrayList.addFirst()`, inserting at the beginning shifts existing values. Worst-case time can reach `O(N²)` for a very wide level.
- **Auxiliary space:** `O(W)` for the queue and current-level collection, excluding the returned result.

**Quick recall:** BFS order stays normal; only the current level's value insertion direction alternates.

---

## 3. Code360 — ZigZag Traversal (Flat List)

**Goal:** Return all values in one flat list, while alternating the direction of each level.

### Tree and expected output

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

Level result:

```text
Level 1: [1]
Level 2: [3, 2]
Level 3: [4, 5, 6, 7]

Flat output: [1, 3, 2, 4, 5, 6, 7]
```

### Approach A — collect, then reverse

For each level:
- Collect values in normal queue order.
- When `rightToLeft` is `true`, reverse only that level's `curr`.
- Append the completed level using `ans.addAll(curr)`.
- Toggle direction once, after the level is complete.

#### Java implementation — submitted code


```java
import java.util.* ;
import java.io.*; 
public class Solution {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<BinaryTreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        boolean rightToLeft = false;
        while (!Q.isEmpty()) {
            int currLevelSize = Q.size();
            List<Integer> curr = new ArrayList<>();
            for (int i = 1; i <= currLevelSize; i++) {
                BinaryTreeNode<Integer> front = Q.remove();
                // if(rightToLeft){
                // 	curr.addFirst(front.data);
                // }else{
                // 	curr.addLast(front.data);
                // }
                curr.add(front.data);

                if (front.left != null) {
                    Q.add(front.left);
                }
                if (front.right != null) {
                    Q.add(front.right);
                }
            }
            if (rightToLeft) {
                Collections.reverse(curr);
            }
            ans.addAll(curr);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}
```

### Approach A — level-by-level trace

| Level | Queue removes | `curr` before reversal | Action | Values appended to `ans` |
|---:|---|---|---|---|
| 1 | `1` | `[1]` | No reverse | `[1]` |
| 2 | `2, 3` | `[2, 3]` | Reverse | `[3, 2]` |
| 3 | `4, 5, 6, 7` | `[4, 5, 6, 7]` | No reverse | `[4, 5, 6, 7]` |

Final `ans`: `[1, 3, 2, 4, 5, 6, 7]`.

### Approach B — use a deque for the current level

Instead of collecting and reversing, insert values directly at the correct end:
- Left-to-right: `addLast(value)`.
- Right-to-left: `addFirst(value)`.

#### Java implementation — submitted code


```java
import java.util.* ;
import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/


public class Solution {
    public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<BinaryTreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        boolean rightToLeft = false;
        while (!Q.isEmpty()) {
            int currLevelSize = Q.size();
            // List<Integer> curr = new ArrayList<>();
            Deque<Integer> curr = new ArrayDeque<>();
            
            for (int i = 1; i <= currLevelSize; i++) {
                BinaryTreeNode<Integer> front = Q.remove();
                if(rightToLeft){
                	curr.addFirst(front.data);
                }else{
                	curr.addLast(front.data);
                }
                // curr.add(front.data);

                if (front.left != null) {
                    Q.add(front.left);
                }
                if (front.right != null) {
                    Q.add(front.right);
                }
            }
            // if (rightToLeft) {
            //     Collections.reverse(curr);
            // }
            ans.addAll(curr);
            rightToLeft = !rightToLeft;
        }
        return ans;
    }
}
```

### Approach B — level 2 pointer-free trace

Queue removes nodes in the same order: `2`, then `3`.

```text
rightToLeft = true

Start curr:        []
Remove node 2
addFirst(2):       [2]

Remove node 3
addFirst(3):       [3, 2]

Completed level:   [3, 2]
```

The queue still enqueues children left first, then right. Only `curr` changes direction.

### Compare the two implementations

| Approach | How it forms a reversed level | Time |
|---|---|---:|
| `ArrayList` + `Collections.reverse()` | Collect normally, then reverse | `O(N)` overall |
| `Deque` + `addFirst()` / `addLast()` | Insert at the required end | `O(N)` overall |

**Java compatibility:** `Deque` and `ArrayDeque` work from Java 6 onward. The deque implementation is suitable for Java 17.

**Quick recall:** `BFS + alternate current-level order + addAll()`.

---

## 4. Code360 — Level Order Traversal (Flat List)

**Goal:** Return level-order values in one flat list, left to right.

### Tree and dry run

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

| Level | Queue removes | `curr` grows to | `ans` after `addAll()` |
|---:|---|---|---|
| 1 | `1` | `[1]` | `[1]` |
| 2 | `2, 3` | `[2, 3]` | `[1, 2, 3]` |
| 3 | `4, 5, 6, 7` | `[4, 5, 6, 7]` | `[1, 2, 3, 4, 5, 6, 7]` |

**Output:** `[1, 2, 3, 4, 5, 6, 7]`

### Java implementation — submitted code


```java
/*********************************************************

 Following is the TreeNode structure:

 class TreeNode<T>
 {
     T data;
     TreeNode<T> left;
     TreeNode<T> right;

     TreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };
 *********************************************************/

import java.util.*;
public class Solution {
    public static List<Integer> levelOrder(TreeNode<Integer> root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int currLevelSize = Q.size();

            Deque<Integer> curr = new ArrayDeque<>();

            for(int i = 1; i <= currLevelSize; i++){

                TreeNode<Integer> frontNode = Q.remove();
                curr.add(frontNode.data);

                if(frontNode.left != null){
                    Q.add(frontNode.left);
                }
                if(frontNode.right != null){
                    Q.add(frontNode.right);
                }
            }
            ans.addAll(curr);
        }
        return ans;
    }
}
```

### What the two loops do

- `while (!Q.isEmpty())` continues until all levels are processed.
- `currLevelSize = Q.size()` freezes the current-level count.
- The `for` loop processes exactly those nodes.
- `curr.add(frontNode.data)` collects values for this level.
- `ans.addAll(curr)` appends those values to the flat result.

`curr` is a `Deque<Integer>` in the submitted code, but this problem only appends values; a `List<Integer>` would also work.

### Complexity

- **Time:** `O(N)`.
- **Auxiliary space:** `O(W)` for the queue and current-level collection; returned `ans` is output space.

**Quick recall:** Save level size → process that many nodes → `addAll()`.

---

## 5. LeetCode 107 — Binary Tree Level Order Traversal II

**Problem:** [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)  
**Goal:** Return levels from bottom to top. Values within each level stay left to right.

### Tree and dry run

```text
              1
           /     \
          2       3
         / \    / \
        4   5   6   7
```

First, normal BFS builds:

```text
Level 1: [1]
Level 2: [2, 3]
Level 3: [4, 5, 6, 7]
```

Before reversing `ans`:

```text
[
  [1],
  [2, 3],
  [4, 5, 6, 7]
]
```

After `Collections.reverse(ans)`:

```text
[
  [4, 5, 6, 7],
  [2, 3],
  [1]
]
```

**Output:** `[[4, 5, 6, 7], [2, 3], [1]]`

### Java implementation — submitted code


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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int currLevelSize = Q.size();
            Deque<Integer> curr = new ArrayDeque<>();
            for (int i = 1; i <= currLevelSize; i++) {
                TreeNode frontNode = Q.remove();
                curr.add(frontNode.val);
                if (frontNode.left != null) {
                    Q.add(frontNode.left);
                }
                if (frontNode.right != null) {
                    Q.add(frontNode.right);
                }
            }
            ans.add(new ArrayList<>(curr));
        }
        Collections.reverse(ans);
        return ans;
    }
}
```

### Follow the two important operations

```java
ans.add(new ArrayList<>(curr));
```

Copies the current level into `ans` as one `List<Integer>`.

```java
Collections.reverse(ans);
```

Reverses the outer list of levels. It does **not** reverse values inside an individual level.

### Complexity

- **Time:** `O(N)` — BFS visits every node once; reversing the list of levels is at most `O(N)`.
- **Auxiliary space:** `O(W)` for the queue and current-level deque, excluding the returned result.

**Quick recall:** Normal BFS first; reverse the completed list of levels once at the end.

---

## 6. LeetCode 199 — Binary Tree Right Side View

**Problem:** [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)  
**Goal:** Select the rightmost visible node at each level.

### Tree and dry run

```text
          1
         / \
        2   3
       /     \
      4       5
```

The queue processes each level from left to right because the code enqueues left child before right child.

| Level | Nodes removed | `lastNodeRight` changes | Value added to `ans` |
|---:|---|---|---:|
| 1 | `1` | `1` | `1` |
| 2 | `2`, `3` | `2 → 3` | `3` |
| 3 | `4`, `5` | `4 → 5` | `5` |

**Output:** `[1, 3, 5]`

### Java implementation — submitted code


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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int currLevelSize = Q.size();
            int lastNodeRight = 0;
            for (int i = 1; i <= currLevelSize; i++) {
                TreeNode frontNode = Q.remove();
                if (frontNode.left != null) {
                    Q.add(frontNode.left);
                }
                if (frontNode.right != null) {
                    Q.add(frontNode.right);
                }
                lastNodeRight = frontNode.val;
            }
            ans.add(lastNodeRight);
        }
        return ans;
    }
}
```

### Follow the pointer to the answer

```java
lastNodeRight = frontNode.val;
```

This assignment runs for every node in the current level. The last node overwrites earlier candidates.

```java
ans.add(lastNodeRight);
```

This is after the `for` loop, so exactly one value is added per level.

### Important edge case — a level has only a left child

```text
    1
   /
  2
   \
    3
```

The right-side view is `[1, 2, 3]`. A node does not need to be a right child to be visible from the right; it can be the only node at that level.

### Complexity

- **Time:** `O(N)`.
- **Auxiliary space:** `O(W)` for the BFS queue, excluding the returned answer.

**Quick recall:** Process left to right → keep overwriting the candidate → add the final candidate once per level.

---

## 7. GeeksforGeeks — Left View of a Binary Tree

**Problem:** [Left View of a Binary Tree](https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1)  
**Goal:** Select the first visible node at every level.

### Tree and dry run

```text
          1
         / \
        2   3
         \ / \
          5 6   7
```

| Level | Queue at start | First node removed (`i == 1`) | Left-view value |
|---:|---|---:|---:|
| 1 | `[1]` | `1` | `1` |
| 2 | `[2, 3]` | `2` | `2` |
| 3 | `[5, 6, 7]` | `5` | `5` |

**Left view:** `1 2 5`

### Approach A — print the left view

#### Java implementation — submitted code


```java
import java.util.*;
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int sizeCurrLevel = Q.size();
            for(int i = 1; i <= sizeCurrLevel; i++){
                TreeNode<Integer> frontNode = Q.remove();
                if (i == 1) {
                    System.out.print(frontNode.data + " ");
                }
                if (frontNode.left != null) {
                    Q.add(frontNode.left);
                }
                if (frontNode.right != null) {
                    Q.add(frontNode.right);
                }
            }
        }
    }
}
```

### Where the selection happens

```java
if (i == 1) {
    System.out.print(frontNode.data + " ");
}
```

`i == 1` selects the first node removed at each level. Since left children are enqueued before right children, this is the leftmost node of that level.

**Input assumption:** This submitted print version expects a non-null root. `ArrayDeque` does not accept `null`.

### Approach B — return the left view in an ArrayList

#### Java implementation — submitted code


```java
import java.util.*;
public class Solution 
{
    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Deque<TreeNode> Q = new ArrayDeque<>();
        Q.add(root);
        while(!Q.isEmpty()){
            int size_currLvl = Q.size();
            Deque<Integer> curr = new ArrayDeque<>();
            for(int i = 1; i <= size_currLvl; i++){
                TreeNode<Integer> frontNode = Q.remove();
                if(frontNode.left != null){
                    Q.add(frontNode.left);
                }
                if(frontNode.right != null){
                    Q.add(frontNode.right);
                }
                if(i == 1){
                    curr.add(frontNode.data);
                }
            }
            ans.addAll(curr);
        }
        return ans;
    }
}
```

### Approach B — same tree, same selected nodes

```text
Level 1: first node = 1  → ans = [1]
Level 2: first node = 2  → ans = [1, 2]
Level 3: first node = 5  → ans = [1, 2, 5]
```

Returned value: `[1, 2, 5]`.

The submitted `curr` deque holds at most one value per level because it adds only when `i == 1`. `ans.addAll(curr)` then appends that value to the answer.

### Compare the two versions

| `printLeftView()` | `getLeftView()` |
|---|---|
| Prints values directly. | Returns an `ArrayList<Integer>`. |
| Submitted code assumes a non-null root. | Checks `root == null` and returns an empty list. |
| No result collection. | Stores one value per level. |

### Complexity

- **Time:** `O(N)` — each node is enqueued and removed once.
- **Auxiliary space:** `O(W)` for the queue; the temporary `curr` deque holds at most one value.
- **Output space:** `O(H)` for `getLeftView()`, one value per level. The print version writes directly to output.

**Quick recall:** Enqueue left before right → choose the first removed node (`i == 1`).

---

## 8. Boundary Traversal of a Binary Tree

**Practice:** [Code360 — Boundary Traversal of a Binary Tree](https://www.naukri.com/code360/problems/boundary-traversal_790725?leftPanelTabValue=PROBLEM&count=25&page=1&search=&sort_entity=order&sort_order=ASC)  
**Goal:** Return the outer boundary of the tree in anti-clockwise order:

1. Root (once).
2. Left boundary from top to bottom, excluding leaf nodes.
3. All leaf nodes from left to right.
4. Right boundary from bottom to top, excluding leaf nodes.

### Tree and expected output

```text
          1
         / \
        2   3
       / \  / \
      4   5 6   7
     /      / \
    8      9  10
```

| Part | Values added | Why |
|---|---|---|
| Root | `1` | Add the root first. |
| Left boundary | `2, 4` | Follow left when available; otherwise follow right. Skip leaves. |
| Leaf nodes | `8, 5, 9, 10, 7` | Visit leaves left to right. |
| Right boundary | `3` | Follow right when available; otherwise follow left. Add while recursion returns. |

**Output:** `[1, 2, 4, 8, 5, 9, 10, 7, 3]`

### Approach A — Recursive implementation

#### Java implementation — submitted code

```java
import java.util.*;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        //including root Node 
        ans.add(root.data);
        if(root.left == null && root.right == null) return ans;

        //including root.left Node 
        leftBoundry(root.left, ans); 
        //all leaf node 
        leafNode(root, ans);      
        //including root.right Node 
        rightBoundry(root.right, ans);
        return ans;
    }
    public static void leftBoundry(TreeNode root, List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        ans.add(root.data);
        if(root.left != null) leftBoundry(root.left, ans);  
        else leftBoundry(root.right, ans);
    }
    public static void leafNode(TreeNode root, List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) ans.add(root.data);
        leafNode(root.left, ans);  
        leafNode(root.right, ans);
    }
    public static void rightBoundry(TreeNode root, List<Integer> ans){
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        if(root.right != null) rightBoundry(root.right, ans);  
        else rightBoundry(root.left, ans);
        ans.add(root.data);
    }
}
```

### How the three helper methods work

**`leftBoundry(root, ans)` — top to bottom**

- Stop for `null` or a leaf. Leaves are added by `leafNode()` instead.
- Add the current non-leaf node before the recursive call.
- Prefer the left child; if it does not exist, continue through the right child.

**`leafNode(root, ans)` — left to right**

- Visit the complete tree in left-first DFS order.
- Add a node only when both children are `null`.
- This collects every leaf once, including leaves that lie on the left or right edge.

**`rightBoundry(root, ans)` — bottom to top**

- Stop for `null` or a leaf to avoid duplicating leaves.
- Prefer the right child; if it does not exist, continue through the left child.
- Add the current node after the recursive call. This return-time addition reverses the boundary order without another list.

### Important edge cases

| Tree shape | Expected result | Why |
|---|---|---|
| Empty tree | `[]` | `root == null` is checked before accessing children. |
| Single node `1` | `[1]` | Add root, then return because it is already a leaf. |
| Left-skewed tree `1 → 2 → 3` | `[1, 2, 3]` | Left boundary excludes leaf `3`; leaf traversal adds it. |
| Right-skewed tree `1 → 2 → 3` | `[1, 3, 2]` | The leaf `3` is added first; non-leaf right-boundary node `2` is added bottom-up. |

**Important:** The root is handled separately. The helper methods exclude leaves, and the leaf traversal handles them. This prevents duplicate boundary values.

### Complexity

- **Time:** `O(N)` — the boundary helpers and leaf traversal together visit nodes only a constant number of times.
- **Auxiliary space:** `O(H)` for recursive call stacks, where `H` is tree height.
- **Output space:** `O(N)` for the returned boundary list.

**Quick recall:** Root → Left boundary (preorder-style) → Leaves (left to right) → Right boundary (postorder-style).

### Approach B — Iterative implementation (loops + stacks)

This is the same boundary traversal, but the helper methods avoid recursion:

- `leftBoundry()` uses a `while` loop and moves down the left boundary.
- `leafNode()` uses a stack to perform left-to-right DFS.
- `rightBoundry()` stores non-leaf boundary values in a stack, then pops them in reverse order.

#### Java implementation — submitted code (kept unchanged)

```java
import java.util.*;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        //including root Node 
        ans.add(root.data);
        if(root.left == null && root.right == null) return ans;

        //including root.left Node 
        leftBoundry(root.left, ans); 
        //all leaf node 
        leafNode(root, ans);      
        //including root.right Node 
        rightBoundry(root.right, ans);
        return ans;
    }
    public static void leftBoundry(TreeNode root, List<Integer> ans){
        while(root != null) {
            if(root.left == null && root.right == null) break;
            ans.add(root.data);
            if(root.left != null) root = root.left;
            else root = root.right;
        }
    }
    public static void leafNode(TreeNode root, List<Integer> ans){
        if(root == null) return;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            if(top.left == null && top.right == null) ans.add(top.data);
            if(top.right != null) st.push(top.right);
            if(top.left != null) st.push(top.left);
        }
    }
    public static void rightBoundry(TreeNode root, List<Integer> ans){
       if(root == null) return;
        Deque<Integer> st = new ArrayDeque<>();
        while(root != null){
            if(root.left == null && root.right == null) break;
            st.push(root.data);
            if(root.right != null) root = root.right;
            else root = root.left;
        }
        while(!st.isEmpty()){
            ans.add(st.pop());
        }

    }
}
```

#### Dry run — Code360 Sample Input 1

```text
          10
         /  \
        5    20
       / \  /  \
      3  8 18  25
        /
       7
```

Expected boundary: `[10, 5, 3, 7, 18, 25, 20]`.

**1. Root**

```text
ans = [10]
```

**2. Left boundary — `leftBoundry(root.left, ans)`**

| Current node | Action | `ans` |
|---:|---|---|
| `5` | Not a leaf, add it; prefer left child `3` | `[10, 5]` |
| `3` | Leaf, stop without adding it here | `[10, 5]` |

The leaf `3` is deliberately left for `leafNode()`.

**3. Leaves — `leafNode(root, ans)`**

The stack pushes the right child first and the left child second. Because it is LIFO, the left child is popped first.

| Popped `top` | Stack after adding its children (top first) | Action / `ans` |
|---:|---|---|
| `10` | `[5, 20]` | Not a leaf |
| `5` | `[3, 8, 20]` | Not a leaf |
| `3` | `[8, 20]` | Leaf → `[10, 5, 3]` |
| `8` | `[7, 20]` | Not a leaf |
| `7` | `[20]` | Leaf → `[10, 5, 3, 7]` |
| `20` | `[18, 25]` | Not a leaf |
| `18` | `[25]` | Leaf → `[10, 5, 3, 7, 18]` |
| `25` | `[]` | Leaf → `[10, 5, 3, 7, 18, 25]` |

**Why push right before left?** The stack reverses insertion order. Pushing right, then left makes left pop first, so leaves are collected left to right.

**4. Right boundary — `rightBoundry(root.right, ans)`**

| Current node | Action | Stack (top first) |
|---:|---|---|
| `20` | Non-leaf: push `20`, then follow right to `25` | `[20]` |
| `25` | Leaf: stop without pushing it | `[20]` |
| Pop | Add `20` to `ans` | `[10, 5, 3, 7, 18, 25, 20]` |

Final output: `[10, 5, 3, 7, 18, 25, 20]`.

#### Where you got stuck — mistakes to remember

| Earlier mistake | Why it failed | Correct rule in this implementation |
|---|---|---|
| Adding the current node after moving to its child in the right boundary | It could add a leaf immediately, then `leafNode()` added the same leaf again; it also built the boundary in top-down order. | Push the current **non-leaf** value before moving. Pop the stack after the walk. |
| Following `root.left` first in the right boundary | That walks the wrong side when a right child exists. | Prefer `root.right`; use `root.left` only when the right child is absent. |
| Adding leaves inside left/right boundary methods | The same boundary leaf could appear twice. | Both boundary methods stop at a leaf. `leafNode()` is the only method that adds leaves. |
| Checking `root.left` / `root.right` inside the stack loop | `root` is the traversal's starting reference, not the node just popped. | Check `top.left` and `top.right`, because `top` is the current popped node. Your submitted code now does this correctly. |
| Pushing left before right in `leafNode()` | The right node would be popped first, reversing the intended leaf order. | Push right first, then left; LIFO visits left first. |
| Forgetting the root-only case | The root could be added once as root and again as a leaf, or a single-node tree could return an empty list. | Check `root == null`, add root once, then return if it has no children. |

#### Important edge cases for revision

| Tree | Expected boundary | What this checks |
|---|---|---|
| Empty tree | `[]` | `root == null` is handled before accessing children. |
| Single node `1` | `[1]` | Root is added once; return before `leafNode()` can add it again. |
| Left-skewed: `1` has left `2`, and `2` has left `3` | `[1, 2, 3]` | Left boundary excludes leaf `3`; leaf traversal adds it. |
| Right-skewed: `1` has right `2`, and `2` has right `3` | `[1, 3, 2]` | Leaf `3` is added before non-leaf right-boundary node `2`. |
| Root has only a right leaf `2` | `[1, 2]` | The leaf is not added by `rightBoundry()`; it is added by `leafNode()`. |

**Do not use `ans.contains(top.data)` to remove duplicates.** The correct way is to keep leaf nodes out of both boundary walks. Different tree nodes may also hold the same value, so values alone are not node identities.

#### Why the right-boundary stack works

For a right boundary `20 → 25` (where `25` is a leaf):

```text
Walk down: push 20
Stop at leaf 25 without pushing it
Stack top: 20
Pop: add 20
```

The stack naturally reverses the top-to-bottom collection into bottom-to-top output. No `Collections.reverse()` or extra list is needed.

#### Complexity — iterative approach

- **Time:** `O(N)` — left boundary, leaf traversal, and right boundary together visit nodes only a constant number of times.
- **Auxiliary space:** `O(H)` for the DFS stack and right-boundary stack, where `H` is tree height.
- **Output space:** `O(N)` for `ans`.

**Quick recall:** Root once → left boundary (stop before leaf) → leaves using right-then-left stack pushes → right boundary (push non-leaves, follow right else left, then pop).

### Recursive vs iterative — what changes?

| Part | Recursive approach | Iterative approach |
|---|---|---|
| Left boundary | Recursive call, then continue down left (else right) | `while` loop, continue down left (else right) |
| Leaves | Recursive DFS: left call before right call | Stack DFS: push right, then left so left pops first |
| Right boundary | Add the node after the recursive call returns | Push non-leaf values while going down, then pop |
| How bottom-up order is achieved | Function return order | Stack LIFO order |
| Extra call stack | `O(H)` | No recursion; explicit stacks use `O(H)` |

The boundary output and the rules about excluding leaves are identical in both approaches. Only the way the traversal is controlled changes.

---

## Final Pattern Comparison

| Problem | Which nodes are selected / how output changes |
|---|---|
| Level Order | Keep all nodes in each level, left to right |
| Zigzag | Keep all nodes; alternate direction inside each level |
| Flat Zigzag | Same zigzag order, but append all levels into one list |
| Flat Level Order | Append all levels in normal left-to-right order |
| Bottom-Up Level Order | Keep normal order inside levels; reverse the order of levels |
| Right Side View | Keep the last node processed at each level |
| Left View | Keep the first node processed at each level |
| Boundary Traversal | Root → left boundary → leaves left to right → right boundary bottom to top |

## Self-Revision Checklist

- [ ] Explain why `currLevelSize` must be saved before the `for` loop.
- [ ] Trace the queue after each level on paper.
- [ ] Explain why zigzag changes the current-level insertion order, not the queue order.
- [ ] Explain the difference between reversing `curr` and reversing `ans`.
- [ ] Explain why right view selects the last node and left view selects the first node.
- [ ] For Boundary Traversal, add root once, exclude leaves from both boundaries, and collect leaves left to right.
- [ ] Explain why the iterative leaf stack pushes right before left, and why the right-boundary stack is popped.
- [ ] Reimplement each BFS / boundary pattern without looking at the code.
