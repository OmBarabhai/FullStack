# B — Singly Linked List
## Part 1 — Node Basics • Head/Tail • Insert • Traverse • Search • Update • Delete

> **Goal:** Learn the Linked List pattern behind each operation.
> Keep the README short enough for revision and problem solving.

---

# 1. Pattern Order

| Pattern | Methods | Priority |
|---|---|---|
| 1. Node / List Setup | `Node`, constructor | ⭐⭐⭐⭐⭐ |
| 2. Head Insertion | `addAtHead` | ⭐⭐⭐⭐⭐ |
| 3. Tail Insertion | `addAtTail` | ⭐⭐⭐⭐⭐ |
| 4. Position Insertion | `addAtPosition` | ⭐⭐⭐⭐⭐ |
| 5. Traversal / Printing | `printList` | ⭐⭐⭐⭐⭐ |
| 6. Access / State | `getSize`, `isEmpty`, `getHead`, `getTail` | ⭐⭐⭐⭐ |
| 7. Search | `search`, `searchPos` | ⭐⭐⭐⭐ |
| 8. Update | `updatePos`, `updateValue` | ⭐⭐⭐⭐ |
| 9. Deletion | `deleteAtHead`, `deleteAtTail`, `deleteAtPos`, `deleteValue` | ⭐⭐⭐⭐⭐ |
| 10. Clear | `clear` | ⭐⭐⭐ |

---

# 2. Core Pattern

```text
UNDERSTAND THE LIST
        ↓
IDENTIFY POINTERS
        ↓
CHECK BOUNDARY
        ↓
READ / CHANGE NODE
        ↓
UPDATE HEAD / TAIL / SIZE
        ↓
VERIFY LIST
```

For pointer changes:

```text
OLD LINK
   ↓
PRESERVE REFERENCE
   ↓
CHANGE LINK
   ↓
VERIFY CONNECTION
```

---

# 3. Node Structure

```java
static class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
```

### Remember

```text
data → value
next → reference to next Node / null
```

---

# 4. Node vs Reference

```java
Node a = new Node(10);
```

→ creates a new Node.

```java
Node b = a;
```

→ `b` refers to the same Node.

```java
a = a.next;
```

→ moves the reference to the next existing Node.

### Memory

```text
new Node(...) → CREATE
Node b = a   → COPY REFERENCE
a = a.next   → MOVE REFERENCE
```

---

# 5. Head / Tail / Size

Normal list:

```text
head
 ↓
10 → 20 → 30 → null
             ↑
            tail
```

### Empty

```text
head = null
tail = null
size = 0
```

### One Node

```text
head == tail
head.next == null
tail.next == null
size == 1
```

---

# 6. Add at Head

## Algorithm

```text
CREATE NEW NODE
        ↓
LIST EMPTY?
   ↙         ↘
 YES          NO
 ↓             ↓
head=new     new.next=head
tail=new     head=new
        ↓
      size++
```

### Core Pointer Pattern

```text
new → old head
head → new
```

### Complexity

```text
Time  : O(1)
Space : O(1) extra
```

---

# 7. Add at Tail

## Algorithm

```text
CREATE NEW NODE
        ↓
LIST EMPTY?
   ↙         ↘
 YES          NO
 ↓             ↓
head=new     tail.next=new
tail=new     tail=new
        ↓
      size++
```

### Core Pointer Pattern

```text
old tail → new
tail → new
```

### Complexity

```text
Time  : O(1)
Space : O(1) extra
```

---

# 8. Add at Position

Valid insertion positions:

```text
1 ... size + 1
```

Special cases:

```text
position == 1
→ addAtHead()

position == size + 1
→ addAtTail()
```

Middle:

```text
FIND PREVIOUS
      ↓
CREATE NEW NODE
      ↓
new.next = previous.next
      ↓
previous.next = new
      ↓
size++
```

### Pointer Pattern

Before:

```text
10 → 20 → 30
↑
prev
```

After inserting `99`:

```text
10 → 99 → 20 → 30
```

### Remember

```text
previous → new → old next
```

### Complexity

```text
Time  : O(n)
Space : O(1) extra
```

---

# 9. Traversal / Print

## `printList()`

```text
START AT HEAD
      ↓
PROCESS CURRENT
      ↓
MOVE current.next
      ↓
STOP AT null
```

### Code Memory

```java
Node temp = head;

while (temp != null) {
    System.out.print(temp.data + " -> ");
    temp = temp.next;
}
```

### Remember

```text
temp = head
temp = temp.next
stop at null
```

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 10. Access / State

## `getSize()`

```text
return size
```

```text
O(1)
```

## `isEmpty()`

```java
return head == null;
```

## `getHead()`

```text
head exists
→ return head.data

head null
→ return -1
```

## `getTail()`

```text
tail exists
→ return tail.data

tail null
→ return -1
```

---

# 11. Clear List

## `clear()`

```text
head = null
tail = null
size = 0
```

### Remember

```text
HEAD NULL
TAIL NULL
SIZE ZERO
```

### Complexity

```text
Time  : O(1)
Space : O(1)
```

---

# 12. Search by Value

## `search(int tar)`

```text
START FROM HEAD
      ↓
CHECK CURRENT DATA
      ↓
FOUND?
 ↙         ↘
YES        NO
 ↓          ↓
true      MOVE NEXT
           ↓
         repeat
```

### Remember

```text
CHECK → MOVE → REPEAT
```

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 13. Search Position

## `searchPos(int tar)`

### Algorithm

```text
pos = 1
temp = head
      ↓
check temp.data
      ↓
found → return pos
      ↓
temp = temp.next
pos++
      ↓
repeat
```

### Important

The current implementation returns `pos` when the value is not found.

For a normal API, `-1` is also common, but keep the current method behavior explicit while revising.

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 14. Update by Position

## `updatePos(int pos, int newData)`

### Algorithm

```text
CHECK POSITION
      ↓
START HEAD
      ↓
MOVE TO TARGET
      ↓
CHANGE data
```

### Core Pattern

```text
FIND NODE
→ CHANGE DATA
```

This changes the value, not the links.

---

# 15. Position Boundary Rule

Insertion:

```text
1 ... size + 1
```

Update / Delete:

```text
1 ... size
```

Why?

```text
Insertion
→ can create a new position at size + 1

Update / Delete
→ target Node must already exist
```

This is a reusable Linked List rule.

---

# 16. Update by Value

## Intended Pattern

```text
START HEAD
   ↓
CHECK CURRENT
   ↓
FOUND?
   ↓
CHANGE DATA
   ↓
RETURN
```

### Important traversal order

Correct:

```java
if (temp.data == oldVal) {
    temp.data = newVal;
    return;
}
temp = temp.next;
```

Do not move first and then access `temp.data`, because the current Node can be skipped and `temp` may become `null`.

### Remember

```text
CHECK CURRENT
→ MOVE NEXT
```

---

# 17. Delete at Head

## Algorithm

```text
EMPTY?
  ↓
YES → stop
NO
 ↓
head = head.next
 ↓
size--
 ↓
head == null?
 ↓
tail = null
```

### Remember

```text
MOVE HEAD
→ CHECK EMPTY
→ FIX TAIL
```

### Complexity

```text
Time  : O(1)
Space : O(1)
```

---

# 18. Delete at Tail

A singly linked list does not have a `prev` pointer from tail.

Therefore:

```text
FIND PREVIOUS TAIL
      ↓
previous.next = null
      ↓
tail = previous
      ↓
size--
```

### Special case

If:

```text
head == tail
```

the list has one Node.

Then:

```text
head = null
tail = null
size = 0
```

### Complexity

```text
Time  : O(n)
Space : O(1)
```

---

# 19. Delete at Position

## Core Pointer Pattern

Before:

```text
previous → target → forward
```

After:

```text
previous → forward
```

### Core steps

```text
FIND PREVIOUS
      ↓
fwd = prev.next
      ↓
prev.next = fwd.next
      ↓
size--
```

### Important cases

```text
position == 1
→ head deletion

position == size
→ tail deletion

middle position
→ previous / target / forward
```

The current method still needs full boundary handling for these cases.

---

# 20. Delete by Value

## Intended Pattern

```text
START HEAD
      ↓
FIND TARGET
      ↓
KEEP PREVIOUS
      ↓
SKIP TARGET
      ↓
size--
```

Middle deletion:

```text
prev → target → next

prev → next
```

Important cases:

```text
empty
one Node
target at head
target at tail
target in middle
target absent
duplicate values
```

The current implementation does not yet complete these transitions.

---

# 21. Size Invariant

Insertion:

```text
successful insertion
→ size++
```

Deletion:

```text
successful deletion
→ size--
```

No actual mutation:

```text
→ size should not change
```

### Final check

```text
actual Node count == size
```

---

# 22. Head / Tail Invariants

After a correct operation:

```text
EMPTY
head == null
tail == null
size == 0
```

```text
ONE NODE
head == tail
head.next == null
tail.next == null
```

```text
NON-EMPTY
head != null
tail != null
tail.next == null
```

---

# 23. Search / Update / Delete Family

These operations are connected.

```text
SEARCH
→ FIND NODE
```

```text
UPDATE
→ FIND NODE
→ CHANGE data
```

```text
DELETE
→ FIND NODE
→ CHANGE LINK
→ UPDATE size
```

### Important distinction

```text
UPDATE
→ data changes

DELETE
→ links change
```

---

# 24. Pointer Change Patterns

## Insert

```text
previous → oldNext

new → oldNext

previous → new
```

Final:

```text
previous → new → oldNext
```

## Delete

```text
previous → target → next
```

Change:

```text
previous → next
```

These two patterns cover a large amount of Singly Linked List logic.

---

# 25. Traversal Order Rule

For simple search/update/traversal:

```text
CHECK CURRENT
      ↓
MOVE NEXT
```

Example:

```java
while (temp != null) {
    if (temp.data == target) {
        ...
    }
    temp = temp.next;
}
```

Avoid:

```java
temp = temp.next;
if (temp.data == target)
```

because the current Node is skipped and `temp` can become `null`.

---

# 26. Debugging Checklist

When a method behaves incorrectly:

```text
1. Check boundary
2. Check starting Node
3. Check pointer movement
4. Check current-before-next order
5. Check null possibility
6. Check target Node
7. Check saved references
8. Check changed links
9. Check head
10. Check tail
11. Check size
12. Print final list
```

---

# 27. Complexity Map

| Method | Time | Extra Space |
|---|---:|---:|
| `addAtHead` | O(1) | O(1) |
| `addAtTail` | O(1) | O(1) |
| `addAtPosition` | O(n) | O(1) |
| `printList` | O(n) | O(1) |
| `getSize` | O(1) | O(1) |
| `isEmpty` | O(1) | O(1) |
| `getHead` | O(1) | O(1) |
| `getTail` | O(1) | O(1) |
| `clear` | O(1) | O(1) |
| `search` | O(n) | O(1) |
| `searchPos` | O(n) | O(1) |
| `updatePos` | O(n) | O(1) |
| `updateValue` | O(n) | O(1) |
| `deleteAtHead` | O(1) | O(1) |
| `deleteAtTail` | O(n) | O(1) |
| `deleteAtPos` | O(n) | O(1) |
| `deleteValue` | O(n) | O(1) |

---

# 28. Current Code Checkpoints

These methods are the important places to debug and refine next:

```text
updatePos()
updateValue()
deleteAtPos()
deleteValue()
```

Test them with:

```text
empty list
one Node
two Nodes
head target
tail target
middle target
missing target
duplicate values
invalid position
```

The goal is to understand the state transition, not simply patch the code.

---

# 29. Manual Revision Questions

Before looking at the implementation:

```text
1. What does Node.next store?

2. What does head represent?

3. What does tail represent?

4. Why is addAtHead O(1)?

5. Why is addAtTail O(1)?

6. Why is addAtPosition O(n)?

7. Why is deleteAtTail O(n)?

8. Which operations need the previous Node?

9. What happens for one Node?

10. Why is size + 1 valid for insertion?

11. Why is size + 1 invalid for update/delete?

12. Why should search check current before moving?

13. What happens when temp becomes null?

14. What should tail become after deleting the only Node?

15. Which operations change data?

16. Which operations change links?

17. Which operations change size?

18. What must always be true about tail.next?
```

---

# 30. Pattern Map

```text
NODE SETUP
    ↓
head / tail / size
    ↓

INSERTION
    ├── Head
    ├── Tail
    └── Position
    ↓

TRAVERSAL
    ↓

SEARCH
    ├── boolean
    └── position
    ↓

UPDATE
    ├── position
    └── value
    ↓

DELETION
    ├── Head
    ├── Tail
    ├── Position
    └── Value
    ↓

STATE
    ├── getSize
    ├── isEmpty
    ├── getHead
    ├── getTail
    └── clear
```

---

# 31. What To Memorize

Do not memorize the whole class.

Memorize the pointer shapes:

```text
HEAD INSERT
new → old head
head → new
```

```text
TAIL INSERT
old tail → new
tail → new
```

```text
POSITION INSERT
previous → new → old next
```

```text
POSITION DELETE
previous → target → next
previous → next
```

```text
TRAVERSAL
current = current.next
```

```text
SEARCH
check → move → repeat
```

```text
UPDATE
find → change data
```

```text
DELETE
find → change link → size--
```

---

# 32. Final One-Page Memory Sheet

```text
NODE
data + next

HEAD
first Node

TAIL
last Node

EMPTY
head = null
tail = null
size = 0

ONE NODE
head == tail

INSERT HEAD
new.next = head
head = new

INSERT TAIL
tail.next = new
tail = new

INSERT POSITION
new.next = prev.next
prev.next = new

TRAVERSAL
temp = temp.next

SEARCH
check current
then move

UPDATE
change data

DELETE
skip target

SIZE
insert → ++
delete → --

TAIL
tail.next = null
```

---

# 33. Definition of Done

You are ready to move deeper into Singly Linked Lists when you can see a new operation and identify:

```text
What Node am I on?
        ↓
What does each pointer represent?
        ↓
What is the boundary?
        ↓
Do I need to read data or change links?
        ↓
Can head change?
        ↓
Can tail change?
        ↓
Which reference must I preserve?
        ↓
What should the final list look like?
        ↓
Does size change?
```

Then derive the Java implementation from the pointer diagram.

---

# 34. Current Section Status

| # | Operation | Status |
|---:|---|:---:|
| 1 | Node structure | ✅ |
| 2 | Head / Tail / Size | ✅ |
| 3 | Add at Head | ✅ |
| 4 | Add at Tail | ✅ |
| 5 | Add at Position | ✅ |
| 6 | Print / Traversal | ✅ |
| 7 | Access / State | ✅ |
| 8 | Search | ✅ |
| 9 | Update by Position | ✅ |
| 10 | Update by Value | 🔄 |
| 11 | Delete at Head | ✅ |
| 12 | Delete at Tail | 🔄 |
| 13 | Delete at Position | 🔄 |
| 14 | Delete by Value | 🔄 |
| 15 | Clear | ✅ |

---

# 35. Next Learning Focus

```text
Traversal
    ↓
Search variations
    ↓
Fix / complete deletion patterns
    ↓
Reverse Linked List
    ↓
Slow / Fast Pointer
    ↓
Cycle Detection
```

The next new concept should build from traversal, because traversal is the base operation behind many later Linked List patterns.
