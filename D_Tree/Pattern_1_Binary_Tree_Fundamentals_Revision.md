# Pattern 1 — Binary Tree Fundamentals & DFS Traversals

> **Status:** In progress  
> **Language:** Java

## Revision Navigation

| No. | Topic | Status |
|---:|---|---|
| 1 | Create a Binary Tree using Java nodes | [x] Practiced |
| 2 | Recursive display and call structure | [x] Practiced |
| 3 | Preorder Traversal | [x] Practiced |
| 4 | Inorder Traversal | [x] Practiced |
| 5 | Postorder Traversal | [x] Practiced |

---

## 1. Binary Tree Node Structure

A Binary Tree node stores a value and references to its left and right children.

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

- `val`: data stored in the node.
- `left`: reference to the left child.
- `right`: reference to the right child.
- `Node(int val)`: constructor that initializes the value.

New nodes have `null` child references by default.

## 2. Constructing the Example Tree

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

```text
             3
           /   \
          4     2
         / \   / \
       -1   1 6   9
```

- `3` is the root.
- `4` and `2` are children of `3`.
- `-1` and `1` are children of `4`.
- `6` and `9` are children of `2`.
- `-1`, `1`, `6`, and `9` are leaf nodes.

**Important mental model:** Every node can be treated as the root of its own subtree. A recursive function solves the same task for the left and right subtrees.

## 3. Recursive Display — The Basic Structure

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

## 4. Why the Original `display()` Method Repeated Output

The submitted method placed six different print-and-recursion arrangements inside one recursive method.

Every call to `display()` for a non-null node executed all six arrangements. Each arrangement also called `display()` recursively. This caused repeated work and confusing repeated output.

**Better structure:** Use one traversal order per method. Keep preorder, inorder, and postorder in separate methods.

## 5. Three Fundamental DFS Traversals

The recursive calls are the same in all three traversals. Only the position of the visit operation changes.

### 5.1 Preorder — Node, Left, Right

```java
private static void preorder(Node root) {
    if (root == null) {
        return;
    }

    System.out.print(root.val + " ");

    preorder(root.left);
    preorder(root.right);
}
```

The current node is processed before either subtree.

**Output:**

```text
3 4 -1 1 2 6 9
```

### 5.2 Inorder — Left, Node, Right

```java
private static void inorder(Node root) {
    if (root == null) {
        return;
    }

    inorder(root.left);

    System.out.print(root.val + " ");

    inorder(root.right);
}
```

The left subtree is processed first, then the current node, then the right subtree.

**Output:**

```text
-1 4 1 3 6 2 9
```

### 5.3 Postorder — Left, Right, Node

```java
private static void postorder(Node root) {
    if (root == null) {
        return;
    }

    postorder(root.left);
    postorder(root.right);

    System.out.print(root.val + " ");
}
```

Both subtrees are processed before the current node.

**Output:**

```text
-1 1 4 6 9 2 3
```

### 5.4 LeetCode 94 — Inorder Traversal

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

**How it works:**
1. Create `ans` once and pass the same list to every recursive call.
2. Visit the left subtree, add the current node using `ans.add(root.val)`, then visit the right subtree.
3. When recursion finishes, return the completed list.

**Remember:** Inorder = **Left → Node → Right**. For the tree `1` with children `2` and `3`, the result is `[2, 1, 3]`.


### 5.5 LeetCode 144 — Preorder Traversal

```java
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalHelper(root, ans);
        return ans;
    }

    public void preorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }
}
```

**How it works:** Create `ans` once and pass the same list into every recursive call. Add the current node first, then traverse left and right.

**Remember:** Preorder = **Node → Left → Right**. For `1` with children `2` and `3`, output is `[1, 2, 3]`.


### 5.6 LeetCode 145 — Postorder Traversal

```java
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }

    public void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if(root == null){
            return;
        }
        postorderTraversalHelper(root.left,ans);
        postorderTraversalHelper(root.right,ans);
        ans.add(root.val);
    }
}
```

**How it works:** Pass the same `ans` list through recursion. Visit the left subtree, then the right subtree, and add the current node last.

**Remember:** Postorder = **Left → Right → Node**. For `1` with children `2` and `3`, output is `[2, 3, 1]`.

## 6. Compare the Traversals

| Traversal | Order | When is the node processed? |
|---|---|---|
| Preorder | Node → Left → Right | Before recursive calls |
| Inorder | Left → Node → Right | Between recursive calls |
| Postorder | Left → Right → Node | After recursive calls |

```text
Preorder  = N L R
Inorder   = L N R
Postorder = L R N
```

`N` = current Node, `L` = Left subtree, `R` = Right subtree.

## 7. Dry Run — Preorder

Tree:

```text
             3
           /   \
          4     2
         / \   / \
       -1   1 6   9
```

Logic:

```java
System.out.print(root.val + " ");
preorder(root.left);
preorder(root.right);
```

| Step | Current node | Action | Result so far |
|---:|---:|---|---|
| 1 | 3 | Print 3 | `3` |
| 2 | 4 | Print 4 | `3 4` |
| 3 | -1 | Print -1 | `3 4 -1` |
| 4 | null | Return | `3 4 -1` |
| 5 | null | Return | `3 4 -1` |
| 6 | 1 | Print 1 | `3 4 -1 1` |
| 7 | null | Return | `3 4 -1 1` |
| 8 | null | Return | `3 4 -1 1` |
| 9 | 2 | Print 2 | `3 4 -1 1 2` |
| 10 | 6 | Print 6 | `3 4 -1 1 2 6` |
| 11 | null | Return | `3 4 -1 1 2 6` |
| 12 | null | Return | `3 4 -1 1 2 6` |
| 13 | 9 | Print 9 | `3 4 -1 1 2 6 9` |

**Final output:** `3 4 -1 1 2 6 9`

### How does recursion return?

When `preorder(-1)` reaches its null children, those calls return. Execution resumes in the caller, `preorder(4)`, and continues with node `1`. Once node `4`'s subtree is complete, execution returns to node `3` and continues with its right subtree.

A `return` exits only the current function call; it does not terminate every active recursive call.

## 8. Complexity Analysis

Let `N` be the number of nodes and `H` be the tree height.

| Complexity | Value | Explanation |
|---|---|---|
| Time | `O(N)` | Every node is visited once. |
| Auxiliary space | `O(H)` | Recursive call stack. |
| Output space | `O(N)` | If storing traversal values in a list. |

For a balanced tree, stack space is approximately `O(log N)`. For a skewed tree, it can be `O(N)`. When printing directly, there is no result list, but the recursive stack is still needed.

## 9. Common Mistakes

1. Forgetting `if (root == null) return;`.
2. Putting the print statement in the wrong position.
3. Mixing multiple traversal orders inside one recursive method.
4. Thinking `return` stops the entire program instead of the current call.
5. Forgetting that a recursive call processes the complete subtree rooted at that node.
6. Ignoring skewed trees, which can create deep recursive call stacks.

## 10. Quick Recall

| Interview clue | Think about |
|---|---|
| Parent before children | Preorder |
| Left, parent, right | Inorder |
| Children before parent | Postorder |
| Empty child | `if (root == null) return;` |
| Process both subtrees | Recursive calls on `root.left` and `root.right` |

### Traversal templates

**Preorder**
```java
if (root == null) return;
visit(root);
preorder(root.left);
preorder(root.right);
```

**Inorder**
```java
if (root == null) return;
inorder(root.left);
visit(root);
inorder(root.right);
```

**Postorder**
```java
if (root == null) return;
postorder(root.left);
postorder(root.right);
visit(root);
```

## 11. Self-Revision Checklist

- [ ] I can explain `left`, `right`, and `val`.
- [ ] I can create a Binary Tree by connecting nodes.
- [ ] I understand why new nodes have null children initially.
- [ ] I can explain the `root == null` base case.
- [ ] I can explain how execution returns to the parent call.
- [ ] I can implement preorder independently.
- [ ] I can implement inorder independently.
- [ ] I can implement postorder independently.
- [ ] I can dry-run all three traversals.
- [ ] I can explain time and auxiliary-space complexity.

---

## Next Lesson — Size of a Binary Tree

We will derive this formula from the meaning of tree size:

```text
size(root) = 1 + size(root.left) + size(root.right)
```

Then we will identify the base case, write the Java implementation, and complete a step-by-step dry run.
