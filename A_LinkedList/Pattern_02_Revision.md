# Linked List — Pattern 2: Insert, Delete, Update & Dummy Node

**Purpose:** Revise common linked-list operations by understanding exactly which reference moves and which link changes.

**Code labels**
- **Your original code:** the exact code was available in the earlier discussion.
- **Reference code:** beginner-readable example; it is not presented as your original submission.

> For the custom operations below, the exact method bodies you previously submitted were not recoverable from the available history. The methods use a simple `Node` with `int data` and `Node next`. On a platform, use the `Node` definition supplied by that platform.

---

## 1. First recognise the operation

| Task | What to locate | Main link/reference change |
|---|---|---|
| Insert at head | No traversal needed | `newNode.next = head`, then return `newNode` |
| Insert at tail | Last node | `last.next = newNode` |
| Insert at position | Node before the position | Preserve the old suffix first |
| Delete head | Current head | Return `head.next` |
| Delete tail | Node before the tail | Set `prev.next = null` |
| Delete at position | Node before the target | Bypass the target |
| Update a value | Target node | Change `node.data`; links stay unchanged |
| Remove every matching value | Candidate after a predecessor | Dummy node + inspect `curr.next` |
| Merge two sorted lists | Current smallest node | Dummy output start + output `tail` |
| Given only the node to delete | Its successor | Copy successor's value, then bypass it |

## 2. Insert at head

**Platform/status:** Custom-style operation. Original method not found; this is reference code.

```java
static Node insertAtHead(Node head, int data) {
    Node newNode = new Node(data);

    // Connect the new node to the old list first.
    newNode.next = head;

    // The new node is now the first node.
    return newNode;
}
```

### Dry run

Before: `head → 20 → 30 → null`  
Insert `10`.

1. Create `newNode` containing `10`.
2. `newNode.next = head` connects `10` to `20`.
3. Return `newNode`.

After: `head → 10 → 20 → 30 → null`

**Remember:** The caller must use the returned head, for example `head = insertAtHead(head, 10)`.

**Edge case:** If the list is empty, `newNode.next` becomes `null` and the new node is the head.

---

## 3. Insert at tail

**Platform/status:** Custom-style operation. Original method not found; this is reference code.

```java
static Node insertAtTail(Node head, int data) {
    Node newNode = new Node(data);

    // Empty list: the new node becomes the head.
    if (head == null) {
        return newNode;
    }

    Node temp = head;

    // Stop at the last node, whose next is null.
    while (temp.next != null) {
        temp = temp.next;
    }

    // Attach the new node after the old last node.
    temp.next = newNode;

    // The head has not changed.
    return head;
}
```

### Dry run

Before: `10 → 20 → null`; insert `30`.

- `temp` starts at `10`, then moves to `20`.
- `20.next == null`, so the loop stops.
- `temp.next = newNode` makes the list `10 → 20 → 30 → null`.

**Why `temp.next != null`?** We want `temp` to stop *on* the last node, not move to `null`.

**Complexity:** `O(n)` time when only `head` is supplied. If a list class maintains a `tail` reference, appending can be `O(1)`.

---

## 4. Your submitted code — Insert at a 0-based position

**Platform:** Code360-style method signature provided by you.  
**Status:** Your original code, preserved as submitted.

```java
import java.util.*;
import java.io.*;

/************************************************************

 Following is the linkedList class structure:

 class Node<T> {
 T data;
 Node<T> next;

 public Node(T data) {
 this.data = data;
 }
 }

 ************************************************************/

public class Solution {

    static Node insert(Node head, int n, int pos, int val) {
        if(pos == 0){
            Node newNode = new Node(val);
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node prev = head;

        for(int i = 0; i < pos - 1; i++){
            if(prev != null){
                prev = prev.next;
            }
        }
        
        Node temp = prev;
        if(temp != null){
            temp = temp.next;
            prev.next = new Node(val);
            prev = prev.next;
            prev.next = temp;
        }
        return head;

    }
}
```

### How your code works

This method treats `pos` as a **zero-based index**:

- `pos = 0`: insert before the old head.
- `pos = 1`: insert after the old head (at index `0`).
- `pos = 2`: insert after the node at index `1`.
- `pos = n`: append after the old last node when the list has `n` nodes.

### Step-by-step dry run: insert `25` at `pos = 2`

Initial list and position:

```text
index:  0       1       2
head → 10  →   20  →   40  → null
```

| Step | Statement/action | `prev` points to | `temp` points to | Link/result |
|---:|---|---:|---:|---|
| 1 | `prev = head` | `10` | not assigned | List unchanged |
| 2 | Loop iteration `i = 0`; `prev = prev.next` | `20` | not assigned | List unchanged |
| 3 | `Node temp = prev` | `20` | `20` | List unchanged |
| 4 | `temp = temp.next` | `20` | `40` | Old successor saved |
| 5 | `prev.next = new Node(val)` | `20` | `40` | `20.next` now points to new node `25` |
| 6 | `prev = prev.next` | `25` | `40` | `prev` moves onto new node |
| 7 | `prev.next = temp` | `25` | `40` | `25.next` reconnects to `40` |

After:

```text
head → 10 ──→ 20 ──→ 25 ──→ 40 ──→ null
```

The key is that `temp` saves the old `20.next` (`40`) before that link is overwritten.

### Pointer roles in your method

| Name | Role |
|---|---|
| `head` | First node; it changes only when `pos == 0` |
| `prev` | Walks to the node before the insertion position |
| `temp` | Holds the old next node so the rest of the list stays connected |
| `new Node(val)` | Creates the node to insert |
| `n` | Passed into the method but not used by this implementation |

### Quick checks

- **Valid positions `0` through `n`:** the insertion link order is correct.
- **Negative position:** the method does not reject it; with a non-empty list, a negative `pos` can fall through and insert after the head. If invalid positions should be ignored, add `if (pos < 0 || pos > n) return head;` before changing any pointers.
- **Empty list:** `pos == 0` works. A positive position leaves the list empty because `prev` is `null`.
- **One node:** `pos == 1` appends after the head; the inserted node's `next` becomes `null`.

**Core memory:** Find the previous node → save its old next node → connect previous to new node → connect new node to the saved node.

---

## 5. Position indexing reminder

Your submitted insert method uses **zero-based positions** (`pos == 0` means insert at the head). Keep this distinction in mind when reading problems that describe positions starting from `1`; the pointer idea is the same, but the index calculations differ.

For your insert code, remember the link order: find the previous node → save its old next node → connect previous to the new node → connect the new node to the saved node.

---

## 6. Your submitted code — Delete at a 0-based position

**Platform:** Code360-style method supplied by you.  
**Status:** Your original code, preserved as submitted. The review and corrected reference version follow it.

### Your original code

```java
/****************************************************************

Following is the Node class already written for the Linked List

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
    }
}

*****************************************************************/

public class Solution {
    public static Node<Integer> deleteNode(Node<Integer> head, int pos) {
        int size = 0;
        Node<Integer> temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        if (pos < 0 || pos > size + 1) {
            return head;
        }
        if (pos == 0) {
            return head.next;
        }
        for (int i = 0; i <= pos - 2; i++) {
            if (temp != null && temp.next.next != null) {
                temp = temp.next;
            }
        }
        temp.next = temp.next.next;
        return head;
    }
}
```

### What your code is trying to do

Your `pos` is **zero-based** because `pos == 0` deletes the head. So, for a list with `size` nodes, valid positions are `0` through `size - 1`.

- Count the nodes into `size`.
- If `pos == 0`, return the second node as the new head.
- Otherwise, move `temp` to the node before the one to delete.
- Bypass the target with `temp.next = temp.next.next`.

### Step-by-step dry run for a valid position

Delete `pos = 2` from `10 → 20 → 30 → 40 → null`. The target is the node at index `2`, which contains `30`.

First, the counting loop sets `size = 4`. Then `temp = head`, so `temp` starts at `10`.

Your loop is `for (int i = 0; i <= pos - 2; i++)`. With `pos = 2`, its condition is `i <= 0`, so it runs exactly once.

| Step | `i` / action | Where `temp` points | List links |
|---:|---|---:|---|
| 1 | Before the loop | `10` | `10 → 20 → 30 → 40 → null` |
| 2 | `i = 0`: guard is true; execute `temp = temp.next` | `20` | Unchanged |
| 3 | Loop ends because next `i = 1` fails `1 <= 0` | `20` | Unchanged |
| 4 | Evaluate `temp.next.next` | `40` | `20.next` currently points to `30` |
| 5 | Assign `temp.next = temp.next.next` | `20` | `20.next` now points directly to `40` |

After:

```text
head → 10 ──→ 20 ─────────→ 40 ──→ null
```

So `temp` ends at `20`, the node immediately before the target `30`. Notice that the list's links do not change while `temp` moves; the actual deletion happens only at `temp.next = temp.next.next`.

### Important boundary checks

There are a few cases to correct before relying on the submitted method:

1. **Empty list and `pos == 0`:** `head.next` throws a `NullPointerException`, because `head` is `null`.
2. **Position validation:** `pos > size + 1` is too permissive. With zero-based indexing, `pos >= size` is out of range. For example, `size == 3` and `pos == 3` should not delete the tail.
3. **Loop guard:** `temp != null && temp.next.next != null` does not check whether `temp.next` is `null` before reading `temp.next.next`. This can also throw a `NullPointerException`.
4. **Out-of-range positions:** because the loop can stop early while `temp` stays at the previous node, the final assignment may delete the tail instead of ignoring the invalid position.

### Correction summary — without duplicating the full method

For a zero-based position, validate `pos < 0 || pos >= size` before changing links. Handle `pos == 0` separately, then move to index `pos - 1` and bypass the target. Also ensure the list is non-empty before accessing `head.next`, and avoid reading `temp.next.next` unless `temp.next` is known to exist.

### Recall rule

- Delete index `0` → return `head.next`.
- Delete index `pos > 0` → reach index `pos - 1`, then bypass its `next` node.
- Reject `pos < 0` and `pos >= size` before pointer changes.

**Complexity:** `O(n)` time because this version first counts the nodes and then may traverse again; `O(1)` auxiliary space.

---

## 7. Delete the head

**Platform/status:** Custom-style operation. Original method not found; this is reference code.

```java
static Node deleteHead(Node head) {
    if (head == null) {
        return null;
    }

    return head.next;
}
```

Before: `10 → 20 → 30 → null`  
Returned head: node `20`  
After: `20 → 30 → null`

The old head is no longer part of the returned chain. The caller should use the returned value:

```java
head = deleteHead(head);
```

**Edge case:** Deleting the only node returns `null`.

---

## 8. Delete the tail

**Platform/status:** Custom-style operation. Original method not found; this is reference code.

```java
static Node deleteTail(Node head) {
    if (head == null) {
        return null;
    }

    // A one-node list becomes empty.
    if (head.next == null) {
        return null;
    }

    Node temp = head;

    // Stop at the node before the last node.
    while (temp.next.next != null) {
        temp = temp.next;
    }

    // Detach the old last node.
    temp.next = null;

    return head;
}
```

Before: `10 → 20 → 30 → null`

The loop stops with `temp` at `20`, because `temp.next` is the last node (`30`) and `temp.next.next` is `null`.

After `temp.next = null`: `10 → 20 → null`

**Loop difference:**
- To *find the last node*: `temp.next != null`
- To *find the node before the last*: `temp.next.next != null`

---

## 9. Position indexing reminder for deletion

Your submitted delete method uses **zero-based positions** (`pos == 0` means delete the head). A 1-based problem counts the head as position `1`, so translate the position before applying the same predecessor-and-bypass idea. This file keeps your submitted implementation rather than duplicating a second deletion method.

---

## 10. Update a value at a 1-based position

**Platform/status:** Custom-style operation. Original method not found; this is reference code.

```java
static Node updateAtPosition(Node head, int pos, int newValue) {
    if (head == null || pos < 1) {
        return head;
    }

    Node temp = head;

    for (int i = 1; temp != null && i < pos; i++) {
        temp = temp.next;
    }

    // If the position exists, change only the stored value.
    if (temp != null) {
        temp.data = newValue;
    }

    return head;
}
```

Example: `10 → 20 → 30`; update position `2` to `99`.

After: `10 → 99 → 30`

**Key distinction:** Updating changes `temp.data`. It does not need to change `temp.next`.

---

## 11. LeetCode 203 — Remove Linked List Elements

**Platform:** [LeetCode 203](https://leetcode.com/problems/remove-linked-list-elements/)  
**Status:** Your recursive solution, preserved below.

### Idea

Remove **all** nodes whose values equal `val`. The dummy node sits before the original head, so deleting the original head uses the same rule as deleting any later node. Your helper inspects `curr.next`, the candidate after `curr`.

### Your original recursive code

```java
class Solution {
    public ListNode solve(ListNode curr, int val, ListNode dummy) {
        if (curr.next == null) {
            return dummy.next;
        }

        if (curr.next.val == val) {
            curr.next = curr.next.next;
        } else {
            curr = curr.next;
        }

        return solve(curr, val, dummy);
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        return solve(curr, val, dummy);
    }
}
```

### How to trace your recursion

- If `curr.next == null`, no candidate remains; return `dummy.next`.
- If `curr.next.val == val`, bypass that node using `curr.next = curr.next.next`. Keep `curr` in place because the replacement `curr.next` might also match.
- Otherwise, keep the candidate and move `curr = curr.next`.
- Recurse again to process the remaining chain.

### Step-by-step recursive dry run: `1 → 2 → 2 → 3`, `val = 2`

Initial chain:

```text
dummy → 1 → 2a → 2b → 3 → null
         ↑
        curr
```

| Call | `curr` at call start | `curr.next` | Action in this call | `curr` passed to next call |
|---:|---:|---:|---|---|
| 1 | `dummy` | `1` | `1` is not `2`; move forward | node `1` |
| 2 | node `1` | `2a` | Bypass `2a` with `curr.next = curr.next.next` | same node `1` |
| 3 | node `1` | `2b` | Bypass `2b` the same way | same node `1` |
| 4 | node `1` | `3` | `3` is not `2`; move forward | node `3` |
| 5 | node `3` | `null` | Base case; return `dummy.next` | return begins |

After deleting `2a`, `1.next` points to `2b`. The next recursive call checks `2b` without moving `curr`, so both adjacent matches are removed.

Final chain returned by `dummy.next`:

```text
dummy → 1 → 3 → null
         ↑
      returned head
```

**Call-stack note:** each recursive call waits for the next call to return. The base case returns the same `dummy.next` result back through the waiting calls.

**Recall rule:** Delete → `curr` stays. Keep → `curr` moves. End → return `dummy.next`.

**Complexity:** `O(n)` time and `O(n)` call-stack space. For very long lists, recursion may cause `StackOverflowError` in Java.

---

## 12. LeetCode 21 — Merge Two Sorted Lists

**Platform:** [LeetCode 21](https://leetcode.com/problems/merge-two-sorted-lists/)  
**Status:** Your original submission, preserved below. No duplicate solution is included.

### Your original submitted code

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode newHead = dummy;
        ListNode newTail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = list1;
                list1 = list1.next;
                newTail = newTail.next;
            } else {
                newTail.next = list2;
                list2 = list2.next;
                newTail = newTail.next;
            }
        }
        if (list1 != null) {
            newTail.next = list1;
        }
        if (list2 != null) {
            newTail.next = list2;
        }
        newHead = newHead.next;
        dummy.next = null;
        return newHead;
    }
}
```

### What each reference does

| Reference | Job |
|---|---|
| `list1` | Current unmerged node in the first input list |
| `list2` | Current unmerged node in the second input list |
| `dummy` | Helper node before the merged result |
| `newHead` | Starts at `dummy`, then moves to the first real result node |
| `newTail` | Tracks the last node attached to the merged result |

### Step-by-step dry run using your variable names

Inputs:

```text
list1: 1a → 2 → 4a → null
list2: 1b → 3 → 4b → null
```

Initially, `dummy` is a helper node and both `newHead` and `newTail` point to it.

| Step | Compare | Node attached through `newTail.next` | Input pointer advanced | `newTail` after move | Result chain after the step |
|---:|---|---|---|---|---|
| 1 | `1a < 1b` is false | `1b` from `list2` | `list2` moves to `3` | `1b` | `1b` |
| 2 | `1a < 3` is true | `1a` from `list1` | `list1` moves to `2` | `1a` | `1b → 1a` |
| 3 | `2 < 3` is true | `2` from `list1` | `list1` moves to `4a` | `2` | `1b → 1a → 2` |
| 4 | `4a < 3` is false | `3` from `list2` | `list2` moves to `4b` | `3` | `1b → 1a → 2 → 3` |
| 5 | `4a < 4b` is false | `4b` from `list2` | `list2` moves to `null` | `4b` | `1b → 1a → 2 → 3 → 4b` |
| Finish | `list2 == null` | Attach remaining `list1` chain (`4a`) | No loop step needed | Remains `4b` | `1b → 1a → 2 → 3 → 4b → 4a` |

The values are therefore:

```text
1 → 1 → 2 → 3 → 4 → 4
```

Your `<` comparison selects from `list2` first when values are equal. This is still sorted. In each loop step, the code attaches one node, advances only the selected input pointer, and then advances `newTail`. After the loop, the remaining chain is already sorted, so your code attaches it directly.

### The last three lines

```java
newHead = newHead.next;
dummy.next = null;
return newHead;
```

`newHead` moves from the dummy node to the first real node. Clearing `dummy.next` is unnecessary but does not break the returned chain, because `newHead` already points to the first real node. Your solution can work as written; this is a simplification opportunity, not a correctness bug.

**Complexity:** `O(n + m)` time and `O(1)` auxiliary space. The method relinks existing nodes rather than copying every node.

---

## 13. LeetCode 237 — Delete Node in a Linked List

**Status:** Your original code recovered from our earlier discussion.  
Platform: [LeetCode 237](https://leetcode.com/problems/delete-node-in-a-linked-list/)

### Your original code

```java
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}
```

### Why this problem is different

The method receives the node to delete, but it does not receive the head or the previous node. A singly linked node cannot move backward to change its predecessor's `next`.

Instead, copy the next node's value into the supplied node, then bypass the next node.

### Dry run

Starting chain: `4 → 5 → 1 → 9`  
The supplied `node` points to the node containing `5`.

**Line 1:** `node.val = node.next.val;`

The supplied node now stores `1`. For a moment, the values appear as `4 → 1 → 1 → 9`.

**Line 2:** `node.next = node.next.next;`

The supplied node now points directly to `9`, bypassing the successor that contained `1`.

Final values: `4 → 1 → 9`

**Boundary:** The problem guarantees `node` is not the tail. This technique cannot delete a tail node because a tail has no successor to copy.

**Complexity:** `O(1)` time, `O(1)` auxiliary space.

---

## 14. Dummy node — the idea to retain

A dummy node is a helper node placed before the real head. It makes the code simpler when the real head might change.

```text
Before:
head ──→ A ──→ B ──→ null

With dummy:
dummy ──→ A ──→ B ──→ null
  |
dummy.next points to the real head
```

After deleting `A`, the dummy can point to `B`. Return `dummy.next`, not `dummy`, because the dummy is only a helper.

Common uses in this pattern:
- Remove nodes that match a value (LC 203)
- Merge two sorted lists (LC 21)

---

## 15. Quick comparison

| Similar operations | Difference |
|---|---|
| Insert at head vs insert elsewhere | Head insertion returns a new head; other insertions connect through a previous node |
| Delete head vs delete middle | Head deletion changes the returned head; middle deletion bypasses a target |
| Delete at position vs delete by value | Position tells you where; value tells you what to search for |
| Delete first match vs LC 203 | First-match deletion stops after one match; LC 203 removes every matching node |
| Ordinary deletion vs LC 237 | Ordinary deletion uses the predecessor; LC 237 copies the successor because only the target node is supplied |
| `curr = curr.next` vs `curr.next = ...` | First moves a reference; second changes a link |
| `dummy` vs `tail` | `dummy` preserves the output start; `tail` tracks the output end |

## 16. Complexity recap

| Operation | Time | Extra space |
|---|---:|---:|
| Insert at head | `O(1)` | `O(1)` |
| Insert at tail (head only) | `O(n)` | `O(1)` |
| Insert at position | `O(n)` | `O(1)` |
| Delete head | `O(1)` | `O(1)` |
| Delete tail | `O(n)` | `O(1)` |
| Delete at position | `O(n)` | `O(1)` |
| Update at position | `O(n)` | `O(1)` |
| LC 203: remove all matches | `O(n)` | `O(1)` |
| LC 21: merge lists of lengths `n`, `m` | `O(n + m)` | `O(1)` |
| LC 237: delete given non-tail node | `O(1)` | `O(1)` |

## 17. Pointer check before you run the code

- [ ] Before inserting, can I identify the node before the insertion point?
- [ ] When inserting between nodes, do I preserve the old suffix before reconnecting `prev`?
- [ ] When deleting, can I identify both `prev` and `target`?
- [ ] Am I returning the correct head after inserting/deleting at position 1?
- [ ] In LC 203, do I keep `curr` still after deletion and move it only when keeping a node?
- [ ] In LC 21, do I advance only the selected input list and then advance `tail`?
- [ ] In LC 237, do I remember that the supplied node cannot be the tail?

## 18. Spaced revision tracker

Mark a round complete after you can explain or reconstruct the operation without looking.

| Operation / problem | R1: 2–3 days | R2: ~7 days | R3: ~30 days |
|---|:---:|:---:|:---:|
| Insert at head / tail | ⬜ | ⬜ | ⬜ |
| Insert at position | ⬜ | ⬜ | ⬜ |
| Delete head / tail | ⬜ | ⬜ | ⬜ |
| Delete at position | ⬜ | ⬜ | ⬜ |
| Update at position | ⬜ | ⬜ | ⬜ |
| LC 203 — Remove Linked List Elements | ⬜ | ⬜ | ⬜ |
| LC 21 — Merge Two Sorted Lists | ⬜ | ⬜ | ⬜ |
| LC 237 — Delete Node Given Only Node | ⬜ | ⬜ | ⬜ |

## 19. Close-the-notes recall

Try to answer these aloud before checking the file:

1. Why does insert-at-position connect `newNode.next` before changing `prev.next`?
2. Why does tail deletion stop at `temp.next.next == null`?
3. Why does LC 203 inspect `curr.next` rather than `curr`?
4. After deleting a node in LC 203, why does `curr` stay where it is?
5. Why does LC 21 return `dummy.next`?
6. Why can LC 237 not delete the tail?

**Next pattern:** Pattern 3 — Two Pointers, Middle Node, and Kth/Nth from End.
