# Pattern 2 — Level Order, Views & Positional Traversals

> **Status:** In progress  
> **Language:** Java

## Revision Navigation

| No. | Problem | Platform | Status |
|---:|---|---|---|
| 1 | Binary Tree Level Order Traversal | LeetCode 102 | [x] Practised; revise independently |
| 2 | Binary Tree Zigzag Level Order Traversal | LeetCode 103 | [x] Practised; revise independently |
| 3 | ZigZag Traversal (flat level-order output) | Code360 | [x] Practised; revise independently |
| 4 | Level Order Traversal (flat level-order output) | Code360 | [x] Practised; revise independently |
| 5 | Binary Tree Level Order Traversal II | LeetCode 107 | [x] Practised; revise independently |
| 6 | Binary Tree Right Side View | LeetCode 199 | [x] Practised; revise independently |
| 7 | Left View of a Binary Tree | GeeksforGeeks | Print and return implementations added; revise independently |

---

## 1. LeetCode 102 — Binary Tree Level Order Traversal

**Problem:** [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)

**Goal:** Return the node values grouped by level, from left to right.

### Core Logic — BFS + Queue

1. Add the root to the queue.
2. Save `Q.size()` before processing a level. This is the number of nodes in the current level.
3. Remove exactly that many nodes, add each node's value to the level list, and enqueue its non-null children.
4. Add the completed level list to the answer. Repeat until the queue is empty.

**Key idea:** Save the level size before the loop. Nodes added while processing the current level belong to the next level.

### Complete Concise Implementation

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

### Mistakes Fixed From the Attempts

- Add `front.val` to the current level list, not the children's values.
- Process all nodes from one level together, not just one node per `while` iteration.
- Do not use `i <= Q.size()` as the loop condition because the queue size changes when children are added. Save it first: `int currLevelSize = Q.size()`.
- For `root == null`, return the empty `ans` list, not `null`.

### Dry Run

Example:

```text
        3
       / \\
      9   20
         /  \\
        15   7
```

| Level | Queue at start | Saved currLevelSize | Values collected | Queue after level |
|---:|---|---:|---|---|
| 1 | `[3]` | 1 | `[3]` | `[9, 20]` |
| 2 | `[9, 20]` | 2 | `[9, 20]` | `[15, 7]` |
| 3 | `[15, 7]` | 2 | `[15, 7]` | `[]` |

**Output:** `[[3], [9, 20], [15, 7]]`

### Complexity

- **Time:** `O(N)` — each node is enqueued and removed once.
- **Auxiliary space:** `O(W)` — the queue stores at most a level's worth of nodes, where `W` is the maximum tree width.

### Quick Recall

`Queue + saved level size + process exactly currLevelSize nodes = Level Order Traversal.`

---

## 2. LeetCode 103 — Binary Tree Zigzag Level Order Traversal

**Problem:** [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

**Goal:** Return the node values level by level, alternating the direction at each level: left to right, then right to left.

### Core Logic — BFS + Queue + Current-Level List

1. Use `Q` for normal BFS. Save `Q.size()` before processing each level, then process exactly that many nodes.
2. Use `op` to build the current level. When `leftToRight` is `true`, insert values with `addLast()`; otherwise, insert with `addFirst()`.
3. Enqueue the left and right children normally. After completing the level, add `op` to `ans` and toggle `leftToRight`.

**Key idea:** The queue always visits nodes in normal BFS order. Only the insertion direction in the current level's deque changes. Do not use `currLevelSize % 2` to decide the direction; alternate it with the boolean flag.

### Java Implementation

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

### Why `List<Integer>` Supports `addFirst()` and `addLast()` (Java 21+)

Your implementation is valid when using **Java 21 or later**. Java 21 added the `SequencedCollection` interface, and `List` extends it. This gives lists methods such as `addFirst()` and `addLast()`.

```java
List<Integer> curr = new ArrayList<>();

if (rightToLeft) {
    curr.addFirst(front.val); // Insert at the beginning
} else {
    curr.addLast(front.val);  // Insert at the end
}
```

- `addFirst(value)` places the value at the beginning of the list.
- `addLast(value)` places the value at the end of the list.
- These methods are available on `List` implementations such as `ArrayList` starting with Java 21. They are not available when compiling with Java 20 or earlier.

**Performance note:** `ArrayList.addFirst()` shifts existing elements, so it takes `O(k)` time for a level containing `k` values. `addLast()` is amortized `O(1)`. For better performance when inserting at both ends, use `Deque<Integer> curr = new ArrayDeque<>()`; its `addFirst()` and `addLast()` operations are amortized `O(1)`.

### Dry Run

Example tree:

```text
        3
       / \
      9   20
         /  \
        15   7
```

| Level | Direction | Values processed from `Q` | Insertions into `op` | Completed level |
|---:|---|---|---|---|
| 0 | Left to right | `3` | `addLast(3)` | `[3]` |
| 1 | Right to left | `9`, `20` | `addFirst(9)`, then `addFirst(20)` | `[20, 9]` |
| 2 | Left to right | `15`, `7` | `addLast(15)`, then `addLast(7)` | `[15, 7]` |

**Output:** `[[3], [20, 9], [15, 7]]`

### Complexity

- **Time:** With `ArrayList`, `addFirst()` shifts the values already collected in that level. The worst-case time can therefore be `O(N²)` for a wide tree. `addLast()` is amortized `O(1)`.
- **Auxiliary space:** `O(W)` — the BFS queue and current-level list store at most a level's worth of nodes, where `W` is the maximum tree width.

### Quick Recall

`BFS + saved level size + addLast/addFirst + toggle direction = Zigzag Level Order Traversal.`


---

## 3. Code360 — ZigZag Traversal (Flat List)

**Problem:** ZigZag Traversal — Code360

**Goal:** Traverse the tree level by level, alternating the direction at each level, and return all values in one flat `List<Integer>`.

### Core Logic — BFS + Current-Level List + Reverse

1. Add the root to the queue. The queue always processes nodes in normal BFS order: left child first, then right child.
2. At the start of each level, save `Q.size()` in `currLevelSize`. This freezes the number of nodes that belong to the current level.
3. Use the `for` loop to remove exactly `currLevelSize` nodes. Add each node's value to `curr` in normal left-to-right order, and enqueue its non-null children.
4. When `rightToLeft` is `true`, reverse the current level using `Collections.reverse(curr)`.
5. Append the current level to the final flat answer with `ans.addAll(curr)`, then toggle the direction for the next level.

**Why the `for` loop is needed:** It is not related to returning a list of lists. It makes sure every node in the current level is processed before the direction changes. The `while` loop handles the whole tree; the `for` loop handles one level at a time.

### Java Implementation — `Collections.reverse()`

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

### Deque Implementation — Java 6+

This implementation works with **Java 6 and later**, not just Java 17. `Deque` and `ArrayDeque` are available from Java 6. Here, `curr` is a `Deque<Integer>`, so `addFirst()` and `addLast()` can be used without relying on the Java 21 `List` methods.

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

### How This Deque Version Works

- `Q` is still the BFS queue. It always removes nodes in normal left-to-right order and adds the left child before the right child.
- `curr` is a separate deque containing only the values of the current level.
- When `rightToLeft == false`, `addLast()` keeps the values in the order they are processed.
- When `rightToLeft == true`, `addFirst()` places each new value at the beginning. This makes the current level appear in reverse order without calling `Collections.reverse()`.
- `ans.addAll(curr)` appends the completed level to the final flat list. Then the boolean is toggled for the next level.

### Visual Dry Run — `Deque` Version

Example tree:

```text
              1
            /   \
           2     3
          / \   / \
         4   5  6   7
```

The queue always processes each level from left to right. Only the way values enter `curr` changes.

**Level 1 — left to right (`rightToLeft = false`)**

```text
Queue removes: 1
addLast(1):    [1]
```

Completed level: `[1]`

**Level 2 — right to left (`rightToLeft = true`)**

```text
Queue removes: 2, then 3

Start:         []
addFirst(2):   [2]
addFirst(3):   [3, 2]
```

Notice: the queue still removes `2` before `3`. `addFirst()` changes only the order inside `curr`.

Completed level: `[3, 2]`

**Level 3 — left to right (`rightToLeft = false`)**

```text
Queue removes: 4, then 5, then 6, then 7

Start:         []
addLast(4):    [4]
addLast(5):    [4, 5]
addLast(6):    [4, 5, 6]
addLast(7):    [4, 5, 6, 7]
```

Completed level: `[4, 5, 6, 7]`

**Final flat output:** `[1, 3, 2, 4, 5, 6, 7]`

### Why Use This Instead of `Collections.reverse()`?

| `ArrayList` + `Collections.reverse()` | `Deque` + `addFirst()` / `addLast()` |
|---|---|
| First collect the level in normal order. | Insert each value at the required end while processing the level. |
| Reverse the whole current-level list on alternate levels. | No separate reverse operation is needed. |
| Reversing a level of `k` values takes `O(k)` time. | Adding at either end of an `ArrayDeque` takes amortized `O(1)` per value. |
| Total time across all levels is `O(N)`. | Total time across all levels is also `O(N)`. |

**Important:** Both approaches are already `O(N)` overall. The deque version avoids the separate reversal step and is a natural fit when values must be inserted at both ends. It does not change the BFS traversal or skip any nodes.

### Complexity — `Deque` Version

- **Time:** `O(N)` — each node is enqueued and removed once, and each value is inserted into `curr` once using an amortized `O(1)` end operation.
- **Auxiliary space:** `O(W)` — the BFS queue and current-level deque store at most a level's worth of nodes/values, where `W` is the maximum tree width. The returned `ans` is output space.

### Understand the Variables

| Variable | Purpose |
|---|---|
| `Q` | Stores tree nodes for BFS. It always enqueues left child before right child. |
| `currLevelSize` | Number of nodes to process in the current level; save it before adding children. |
| `curr` | Stores values for only the current level, initially in normal left-to-right order. |
| `rightToLeft` | Controls whether the current level must be reversed. It starts as `false`, so the root level stays left to right. |
| `ans` | Final flat result containing all completed levels. |

### Dry Run

Example tree:

```text
              1
            /   \
           2     3
          / \   / \
         4   5  6   7
```

| Level | `rightToLeft` at start | Nodes removed from queue | `curr` before reverse | `curr` after direction is applied | `ans` after `ans.addAll(curr)` |
|---:|---|---|---|---|---|
| 1 | `false` | `[1]` | `[1]` | `[1]` | `[1]` |
| 2 | `true` | `[2, 3]` | `[2, 3]` | `[3, 2]` | `[1, 3, 2]` |
| 3 | `false` | `[4, 5, 6, 7]` | `[4, 5, 6, 7]` | `[4, 5, 6, 7]` | `[1, 3, 2, 4, 5, 6, 7]` |

**Output:** `[1, 3, 2, 4, 5, 6, 7]`

### Why These Operations Matter

```java
curr.add(front.data);
```

Collects the current level in the normal BFS order.

```java
if (rightToLeft) {
    Collections.reverse(curr);
}
```

Reverses only the current level when its direction must be right to left. It does not change the queue or the order in which the next level's nodes are discovered.

```java
ans.addAll(curr);
```

Appends every value from the completed level to the final flat list. Use `addAll()` because `ans` expects individual `Integer` values; `ans.add(curr)` would try to add a whole list as one element and is incompatible with `List<Integer>`.

```java
rightToLeft = !rightToLeft;
```

Changes direction once, after the entire level has been processed—not after each node.

### Complexity

- **Time:** `O(N)` — each node is enqueued and removed once, and reversing all current-level lists takes at most `O(N)` total across the tree.
- **Auxiliary space:** `O(W)` — the queue and current-level list store at most a level's worth of nodes, where `W` is the maximum tree width. The returned `ans` is output space.

### Quick Recall

`BFS + save level size + collect normal order + reverse alternate levels + addAll = Flat ZigZag Traversal.`


---

## 4. Code360 — Level Order Traversal (Flat List)

**Goal:** Visit the tree level by level from left to right and return all node values in one flat `List<Integer>`.

### Core Logic — BFS + Saved Level Size

1. Add the root to the queue.
2. At the start of each level, save `Q.size()` in `currLevelSize`. This tells us exactly how many nodes belong to this level.
3. Remove exactly `currLevelSize` nodes. Add each removed node's value to `curr`, then add its non-null left and right children to the queue.
4. After processing the level, use `ans.addAll(curr)` to append that level's values to the final flat answer.
5. Continue until the queue is empty.

**Important:** The queue stores tree nodes and controls BFS order. `curr` only collects the values from the current level. In this code, `curr` is a `Deque<Integer>`, but it is used with ordinary `add()` and `addAll()`; it does not perform any reversal.

### Your Implementation — `Deque<Integer>`

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

### Java Version Compatibility

This code is **not specific to Java 17**. `Deque` and `ArrayDeque` have been available since **Java 6**, so this implementation works on Java 6 and later (including Java 8, 11, 17, and newer versions). It does not require Java 21's `List.addFirst()` or `List.addLast()` methods.

### Visual Dry Run

Example tree:

```text
              1
            /   \\
           2     3
          / \\   / \\
         4   5  6   7
```

**Level 1**

```text
Tree node processed: 1
Q before: [1]
currLevelSize = 1
curr: [] -> [1]
Q after: [2, 3]
ans after addAll: [1]
```

**Level 2**

```text
Tree nodes processed: 2, then 3
Q before: [2, 3]
currLevelSize = 2
curr: [] -> [2] -> [2, 3]
Q after: [4, 5, 6, 7]
ans after addAll: [1, 2, 3]
```

**Level 3**

```text
Tree nodes processed: 4, then 5, then 6, then 7
Q before: [4, 5, 6, 7]
currLevelSize = 4
curr: [] -> [4] -> [4, 5] -> [4, 5, 6] -> [4, 5, 6, 7]
Q after: []
ans after addAll: [1, 2, 3, 4, 5, 6, 7]
```

**Final output:** `[1, 2, 3, 4, 5, 6, 7]`

### Why Do We Need Both `while` and `for`?

- `while (!Q.isEmpty())` repeats until every level has been processed.
- `currLevelSize = Q.size()` records how many nodes are in the current level before their children are added.
- `for (int i = 1; i <= currLevelSize; i++)` processes exactly those current-level nodes. Newly added children wait in the queue for the next `while` iteration.

Without the saved `currLevelSize`, the loop could also process children added during the same level, so the level boundary would be lost.

### Why `Deque<Integer> curr` and `ans.addAll(curr)`?

- `curr.add(frontNode.data)` appends the current node's value to the end of the current-level deque. `Deque` supports `add()` as an end-insertion operation.
- `ans.addAll(curr)` copies all values from the completed level into the final `List<Integer>` in iteration order.
- Because `ans` is a flat list, `addAll()` is appropriate. It appends individual integer values, not the deque as one nested element.
- A `List<Integer>` could also be used for `curr`; using `Deque<Integer>` here is valid, but it is not necessary because this level-order version only appends values.

### Complexity

- **Time:** `O(N)` — each node is enqueued once, removed once, and its value is added once.
- **Auxiliary space:** `O(W)` — the queue and current-level deque hold up to a level's worth of nodes/values, where `W` is the maximum tree width. The returned `ans` is output space.

### Quick Recall

`BFS queue + save level size + collect current level + addAll = Flat Level Order Traversal.`


---

## 5. LeetCode 107 — Binary Tree Level Order Traversal II

**Problem:** [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

**Goal:** Return the tree's level-order traversal from the bottom level to the root level. Values inside each level must remain in normal left-to-right order.

### Core Logic — BFS + Current-Level Deque + Reverse Outer List

1. Use `Q` for normal BFS. Add the root first and process nodes from left to right.
2. At the start of each level, save `Q.size()` in `currLevelSize`. This freezes the number of nodes belonging to that level.
3. Create `curr` to collect only the values from the current level. Remove exactly `currLevelSize` nodes, append each value using `curr.add()`, and enqueue the node's non-null left and right children.
4. After the complete level has been processed, convert `curr` into a `List` and add it to `ans` with `ans.add(new ArrayList<>(curr))`.
5. Once BFS has processed every level, reverse `ans` using `Collections.reverse(ans)`. This reverses the order of the level-lists, not the values inside each level.

**Important distinction:** Do not reverse `curr`. The nodes inside every level must stay left to right. Only the order of the completed levels changes from top-to-bottom to bottom-to-top.

### Your Implementation

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

### Understand the Important Lines

**1. Save the number of nodes in the current level**

```java
int currLevelSize = Q.size();
```

At this moment, the queue contains the nodes waiting to be processed at the current level. Store that count before adding children. During the `for` loop, children are added to the queue, but they must wait for the next level. The saved `currLevelSize` makes the loop process only the nodes that were already in the queue at the start of this level.

**2. Collect values in their normal left-to-right order**

```java
curr.add(frontNode.val);
```

`curr` is a `Deque<Integer>`. Its `add()` method appends the value at the end, so the values remain in the same order in which BFS removes their nodes: left to right. No `addFirst()` or level reversal is needed.

**3. Convert the current deque into a list before adding it**

```java
ans.add(new ArrayList<>(curr));
```

- `ans` has type `List<List<Integer>>`, so each item added to it must be a `List<Integer>`.
- `curr` has type `Deque<Integer>`, so `ans.add(curr)` would be a type mismatch.
- `new ArrayList<>(curr)` creates a list containing the deque's values in iteration order. That completed level is then stored as one row in `ans`.

**4. Reverse the completed levels, not the values inside them**

```java
Collections.reverse(ans);
```

`ans` is a list of level-lists. Reversing it changes the order of those level-lists while keeping each individual level unchanged. This is exactly what bottom-up level order requires.

### Visual Dry Run

Example tree:
```text
              1
            /   \
           2     3
          / \   / \
         4   5  6   7
```

**Traversal order:** BFS / level order, visiting each level from left to right.

**Level 1 — process node `1`**

```text
Queue before:       [1]
currLevelSize:      1
Remove:             1
curr:               [] -> [1]
Add children:       2, 3
Queue after:        [2, 3]
ans after level:    [[1]]
```

**Level 2 — process nodes `2`, then `3`**

```text
Queue before:       [2, 3]
currLevelSize:      2
Remove 2:           curr = [2]
Add children:       4, 5
Remove 3:           curr = [2, 3]
Add children:       6, 7
Queue after:        [4, 5, 6, 7]
ans after level:    [[1], [2, 3]]
```

**Level 3 — process nodes `4`, `5`, `6`, then `7`**

```text
Queue before:       [4, 5, 6, 7]
currLevelSize:      4
Remove 4:           curr = [4]
Remove 5:           curr = [4, 5]
Remove 6:           curr = [4, 5, 6]
Remove 7:           curr = [4, 5, 6, 7]
Queue after:        []
ans after level:    [[1], [2, 3], [4, 5, 6, 7]]
```

**Now reverse `ans` once BFS is finished:**

```text
Before Collections.reverse(ans):
[
  [1],
  [2, 3],
  [4, 5, 6, 7]
]

After Collections.reverse(ans):
[
  [4, 5, 6, 7],
  [2, 3],
  [1]
]
```

**Final output:** `[[4, 5, 6, 7], [2, 3], [1]]`

### Why Reverse `ans` Instead of `curr`?

| Operation | What it reverses | Result for this example |
|---|---|---|
| `Collections.reverse(curr)` | Values inside one level | `[3, 2]` instead of `[2, 3]` — not wanted |
| `Collections.reverse(ans)` | Order of the level-lists | Bottom level first, with values inside each level unchanged — correct |

The BFS part builds the levels in their natural order: root first, bottom level last. Reversing the outer list after BFS is complete changes only the level order. There is no need to change how the queue visits nodes.

### Complexity

- **Time:** `O(N)` — every node is enqueued and removed once. Reversing the outer `ans` list takes `O(L)`, where `L` is the number of levels; since `L <= N`, the total remains `O(N)`.
- **Auxiliary space:** `O(W)` for the BFS queue and current-level deque, where `W` is the maximum tree width. The returned `ans` stores all `N` node values and is output space.

### Quick Recall

`Normal BFS + collect each level left to right + add each level to ans + reverse ans once = Bottom-Up Level Order Traversal.`


---

## 6. LeetCode 199 — Binary Tree Right Side View

**Problem:** [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

**Goal:** Return the value of the rightmost visible node at every level, starting from the root.

### Core Logic — BFS + Saved Level Size + Last Processed Node

1. Add the root to the queue. If the root is `null`, return the empty answer.
2. At the start of each level, save `Q.size()` in `currLevelSize`. This tells the `for` loop exactly how many nodes belong to this level.
3. Set `lastNodeRight` to a starting value. Process exactly `currLevelSize` nodes from left to right.
4. For every removed node, enqueue its left child first and its right child second. Then assign its value to `lastNodeRight`.
5. After the `for` loop finishes, `lastNodeRight` contains the value of the last node processed at this level. Add it to `ans`.
6. Repeat for every level.

**Why does the last processed node work?** The queue processes each level from left to right because children are enqueued left first and right second. Therefore, the last node removed from a level is its rightmost node. This also works when a level has only a left child: that left child is the only node visible from the right at that level.

### Your Implementation

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

### Understand the Important Lines

**1. Freeze the current level's node count**

```java
int currLevelSize = Q.size();
```

The queue may grow when children are added. Saving the count before the `for` loop ensures that only the nodes already waiting at the start of this level are processed now. Their children are processed in the next `while` iteration.

**2. Keep the queue in left-to-right BFS order**

```java
if (frontNode.left != null) {
    Q.add(frontNode.left);
}
if (frontNode.right != null) {
    Q.add(frontNode.right);
}
```

Enqueueing left before right makes nodes come out of the queue from left to right at each level. Do not swap these two insertions when using the `lastNodeRight` approach.

**3. Keep updating the candidate rightmost value**

```java
lastNodeRight = frontNode.val;
```

This line runs for every node in the current level. Each processed node replaces the previous candidate. After the final iteration, the variable holds the value of the last (rightmost) node in that level.

**4. Add one answer per completed level**

```java
ans.add(lastNodeRight);
```

This line is outside the `for` loop, so only one value is added after the whole level has been processed.

### Visual Dry Run

Example tree:

```text
          1
         / \
        2   3
       /     \
      4       5
```

**Traversal order:** BFS / level order. The queue visits each level from left to right. The right-side view takes the final node processed at each level.

**Level 1 — process node `1`**

```text
Queue before:       [1]
currLevelSize:      1
Remove:             1
lastNodeRight:      1
Add children:       2, 3
Queue after:        [2, 3]
ans after level:    [1]
```

**Level 2 — process nodes `2`, then `3`**

```text
Queue before:       [2, 3]
currLevelSize:      2
Remove 2:           lastNodeRight = 2
Add child:          4
Remove 3:           lastNodeRight = 3
Add child:          5
Queue after:        [4, 5]
ans after level:    [1, 3]
```

Notice that `lastNodeRight` first becomes `2`, then gets overwritten by `3`. Node `3` is the last node processed at this level.

**Level 3 — process nodes `4`, then `5`**

```text
Queue before:       [4, 5]
currLevelSize:      2
Remove 4:           lastNodeRight = 4
Remove 5:           lastNodeRight = 5
Queue after:        []
ans after level:    [1, 3, 5]
```

**Final output:** `[1, 3, 5]`

### Important Edge Case — Only a Left Child

```text
        1
       /
      2
       \
        3
```

At the second level, node `2` is the only node. It is still the last node processed at that level, so it is included in the right-side view. At the next level, node `3` is the only node and is also included.

**Output:** `[1, 2, 3]`

The right-side view means the node visible from the right, not necessarily a node that has a right child or is itself a right child.

### Why `lastNodeRight` Is Initialized Inside the `while` Loop

```java
int lastNodeRight = 0;
```

It is reset for every level because each level needs its own rightmost value. The value `0` is only an initial placeholder: the `for` loop always runs at least once while the queue is non-empty, and the variable is assigned a node value before it is added to `ans`. So a tree node whose value is `0` is also handled correctly.

### Complexity

- **Time:** `O(N)` — every node is enqueued once, removed once, and processed once.
- **Auxiliary space:** `O(W)` — the BFS queue stores at most a level's worth of nodes, where `W` is the maximum tree width. The returned `ans` stores one value per level and is output space.

### Quick Recall

`BFS + save currLevelSize + enqueue left then right + keep overwriting lastNodeRight + add once per level = Right Side View.`

---

## 7. GeeksforGeeks — Left View of a Binary Tree

**Problem:** [Left View of a Binary Tree](https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1)

**Goal:** Print the first node visible at every level when the tree is viewed from the left side.

### Core Logic — BFS + First Node of Each Level

- Process the tree level by level using a queue.
- Save `Q.size()` before processing a level so only the nodes at that level are removed in the current `for` loop.
- Since left children are enqueued before right children, the first node removed at each level (`i == 1`) is the leftmost node of that level.

### Java Implementation — Updated Submitted Code

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

### Dry Run

Example tree:

```text
          1
        /   \\
       2     3
        \\   / \\
         5  6   7
```

| Level | Queue at start | First node removed (`i == 1`) | Printed | Queue after level |
|---:|---|---:|---:|---|
| 1 | `[1]` | 1 | 1 | `[2, 3]` |
| 2 | `[2, 3]` | 2 | 2 | `[5, 6, 7]` |
| 3 | `[5, 6, 7]` | 5 | 5 | `[]` |

**Output:** `1 2 5`

### Important Points

- `sizeCurrLevel = Q.size()` stores the number of nodes in the current level.
- `i == 1` selects the first node removed at that level.
- Enqueue left before right to preserve left-to-right BFS order.
- The submitted code assumes a non-null root. If the input can be an empty tree, return before calling `Q.add(root)`, because `ArrayDeque` does not accept `null`.

### Complexity

- **Time:** `O(N)` — every node is enqueued and removed once.
- **Auxiliary space:** `O(W)` — the queue stores up to the maximum width of the tree.
- **Output space:** `O(1)` — values are printed directly rather than stored in a result collection.

### Quick Recall

`BFS + save level size + print the first node (`i == 1`) + enqueue left before right = Left View.`

### Alternative Implementation — Return the Left View in an ArrayList

This version uses the same BFS idea, but instead of printing each visible node, it returns the left-view values in an `ArrayList<Integer>`.

### Java Implementation — Submitted Code

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

### How This Version Works

1. **Create the answer list:** `ans` stores one left-view value for each level.
2. **Handle an empty tree:** When `root == null`, return the empty list immediately. This also avoids adding `null` to an `ArrayDeque`.
3. **Start BFS:** Add the root to `Q`. The queue processes nodes level by level.
4. **Save the current level size:** `size_currLvl = Q.size()` records how many nodes belong to this level before their children are added.
5. **Process the level:** The `for` loop removes exactly `size_currLvl` nodes. Each node's left child is added before its right child, preserving left-to-right order for the next level.
6. **Select the leftmost node:** `i` starts at `1`, so `i == 1` is true only for the first node removed at the current level. Its value is added to `curr`.
7. **Store the selected value:** After the level is fully processed, `ans.addAll(curr)` appends that level's selected value to the answer. `curr` is newly created for every level and contains either one value or no values.
8. **Return the result:** Once the queue is empty, `ans` contains the leftmost visible node from every level, from top to bottom.

**Why does the first removed node represent the left view?** The queue is FIFO, and children are always enqueued left before right. Therefore nodes at each next level are removed from left to right. The first one removed is the leftmost node at that level.

### Dry Run

Example tree:

```text
          1
        /   \\
       2     3
        \\   / \\
         5  6   7
```

| Level | Queue at start | `size_currLvl` | First node (`i == 1`) | `curr` | `ans` after level |
|---:|---|---:|---:|---|---|
| 1 | `[1]` | 1 | 1 | `[1]` | `[1]` |
| 2 | `[2, 3]` | 2 | 2 | `[2]` | `[1, 2]` |
| 3 | `[5, 6, 7]` | 3 | 5 | `[5]` | `[1, 2, 5]` |

**Returned value:** `[1, 2, 5]`

### Why Use `curr` and `ans.addAll(curr)`?

- `curr` is a temporary deque for the current level's selected value. Since the code adds a value only when `i == 1`, it contains at most one element.
- `ans.addAll(curr)` transfers that selected value to the final `ArrayList` after the entire level has been processed.
- The temporary `curr` is valid but not essential; the same selected value could be added directly to `ans` inside `if (i == 1)`. This revision keeps your submitted structure unchanged so the role of each operation stays clear.

### Difference Between the Two Left View Methods

| `printLeftView()` | `getLeftView()` |
|---|---|
| Prints each selected value using `System.out.print()`. | Returns the selected values in an `ArrayList<Integer>`. |
| Does not build a result collection. | Uses `ans` as the result collection. |
| The submitted version assumes a non-null root. | Checks `root == null` and returns an empty list. |

### Complexity

Let `N` be the number of nodes, `W` the maximum width, and `H` the number of levels.

- **Time:** `O(N)` — each node is enqueued and removed once. Each level contributes at most one value to the result.
- **Auxiliary space:** `O(W)` for the BFS queue. `curr` holds at most one integer, so it uses `O(1)` additional temporary space.
- **Output space:** `O(H)` — one value is stored for each level.

### Quick Recall

`BFS + save level size + choose the first removed node (`i == 1`) + enqueue left before right + add to ans = Left View.`


