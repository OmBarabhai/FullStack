# Doubly Linked List — Revision Focus
## Custom Design • Prev/Next Tracking • Boundaries • Rewiring • Size • Dry Run

> **Goal:** Strengthen the exact reasoning used while implementing your custom `DoublyLinkedList`.
>
> The focus is not generic DLL theory. The focus is:
>
> ```text
> prev / curr / next
> head / tail / size
> position - 2
> two-way rewiring
> head/tail boundaries
> one-node handling
> deletion
> dry runs
> debugging
> ```

---

# 1. Revision Order

| Pattern | Focus | Priority |
|---|---|---|
| 1 | DLL Node relationship | ⭐⭐⭐⭐⭐ |
| 2 | Head / Tail / Size | ⭐⭐⭐⭐⭐ |
| 3 | Forward / Backward direction | ⭐⭐⭐⭐⭐ |
| 4 | Previous / Current / Next | ⭐⭐⭐⭐⭐ |
| 5 | Position → Previous Node | ⭐⭐⭐⭐⭐ |
| 6 | Head insertion | ⭐⭐⭐⭐ |
| 7 | Tail insertion | ⭐⭐⭐⭐ |
| 8 | Position insertion | ⭐⭐⭐⭐⭐ |
| 9 | Head deletion | ⭐⭐⭐⭐⭐ |
| 10 | Tail deletion | ⭐⭐⭐⭐⭐ |
| 11 | Position deletion | ⭐⭐⭐⭐⭐ |
| 12 | Value deletion | ⭐⭐⭐⭐⭐ |
| 13 | Two-way invariant | ⭐⭐⭐⭐⭐ |
| 14 | Empty / one / two / middle / tail | ⭐⭐⭐⭐⭐ |
| 15 | Size consistency | ⭐⭐⭐⭐ |
| 16 | Dry-run pointer tracing | ⭐⭐⭐⭐⭐ |
| 17 | Bug finding | ⭐⭐⭐⭐⭐ |
| 18 | Complete reconstruction | ⭐⭐⭐⭐⭐ |

---

# 2. Pattern 1 — DLL Node Relationship

Your Node:

```java
static class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
```

### Mental model

```text
        next
Node  ─────────► Node
  ▲               │
  └────── prev ───┘
```

For:

```text
10 ⇄ 20 ⇄ 30
```

relationships are:

```text
10.next → 20
20.prev → 10

20.next → 30
30.prev → 20
```

### Core rule

```text
SINGLY
→ forward link

DOUBLY
→ forward + backward links
```

---

# 3. Pattern 2 — Head / Tail / Size

## Empty

```text
head = null
tail = null
size = 0
```

## One Node

```text
head == tail
head.prev == null
head.next == null
tail.prev == null
tail.next == null
size == 1
```

## Multiple Nodes

```text
head.prev == null
tail.next == null
```

### Important DLL invariants

```text
head.prev == null
tail.next == null
```

For adjacent Nodes:

```text
A.next == B
B.prev == A
```

### Pattern memory

```text
EVERY STRUCTURAL CHANGE
→ preserve both directions
```

---

# 4. Pattern 3 — Forward / Backward Traversal

## Forward

```java
Node temp = head;

while (temp != null) {
    System.out.print(temp.data);
    temp = temp.next;
}
```

Mental path:

```text
HEAD
 ↓
next
 ↓
next
 ↓
null
```

## Backward

```java
Node temp = tail;

while (temp != null) {
    System.out.print(temp.data);
    temp = temp.prev;
}
```

Mental path:

```text
TAIL
 ↓
prev
 ↓
prev
 ↓
null
```

### Pattern memory

```text
FORWARD
→ head + next

BACKWARD
→ tail + prev
```

---

# 5. Pattern 4 — Previous / Current / Next

For:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Suppose:

```text
prev = 20
curr = 30
next = 40
```

Then:

```text
prev.next → curr
curr.prev → prev

curr.next → next
next.prev → curr
```

### Think in pairs

```text
FORWARD:
prev.next → curr
curr.next → next
```

```text
BACKWARD:
curr.prev → prev
next.prev → curr
```

### Mental rule

Whenever `curr` is in the middle:

```text
prev ⇄ curr ⇄ next
```

---

# 6. Pattern 5 — Position Mapping

Your implementation uses **1-based positions**.

For:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50
```

```text
position 1 → 10
position 2 → 20
position 3 → 30
position 4 → 40
position 5 → 50
```

For middle insertion/deletion, your loop uses:

```java
for (int i = 1; i <= position - 2; i++) {
    prevNode = prevNode.next;
}
```

### Why `position - 2`?

You are not trying to reach the target.

You want:

```text
the Node immediately BEFORE target
```

For:

```text
position 2
```

```text
p - 2 = 0
→ prevNode stays at head
→ prevNode = position 1
```

For:

```text
position 3
```

```text
p - 2 = 1
→ move once
→ prevNode = position 2
```

For:

```text
position 4
```

```text
p - 2 = 2
→ move twice
→ prevNode = position 3
```

### Pattern memory

```text
TARGET POSITION p

previous Node
→ position p - 1

moves from head
→ p - 2
```

---

# 7. Pattern 6 — Add at Head

For:

```text
10 ⇄ 20 ⇄ 30
```

insert `5`.

Final:

```text
5 ⇄ 10 ⇄ 20 ⇄ 30
```

### Core links

```java
newNode.next = head;
head.prev = newNode;
head = newNode;
```

### Meaning

Before:

```text
newNode     5

head → 10
```

After:

```text
5.next → 10
10.prev → 5
head → 5
```

### Empty case

```text
head = newNode
tail = newNode
```

### Pattern memory

```text
NEW → OLD HEAD
OLD HEAD → NEW
HEAD → NEW
```

---

# 8. Pattern 7 — Add at Tail

For:

```text
10 ⇄ 20 ⇄ 30
```

insert `40`.

### Core links

```java
tail.next = newNode;
newNode.prev = tail;
tail = newNode;
```

### Meaning

```text
30.next → 40
40.prev → 30
tail → 40
```

### Pattern memory

```text
OLD TAIL → NEW
NEW → OLD TAIL
TAIL → NEW
```

### Complexity

```text
Time → O(1)
```

because `tail` is already known.

---

# 9. Pattern 8 — Add at Position

Example:

```text
10 ⇄ 20 ⇄ 40
```

insert `30` at position `3`.

Desired:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Suppose:

```text
prevNode = 20
currNext = 40
newNode = 30
```

### Four link updates

```java
currNext.prev = newNode;
newNode.next = currNext;

prevNode.next = newNode;
newNode.prev = prevNode;
```

### Before

```text
prev ⇄ currNext
```

### After

```text
prev ⇄ new ⇄ currNext
```

### Pattern memory

```text
NEXT SIDE
→ currNext.prev = new

PREVIOUS SIDE
→ prev.next = new

NEW NODE
→ new.prev = prev
→ new.next = currNext
```

### Important

A DLL insertion is not complete after changing only `next`.

Both directions must work.

---

# 10. Pattern 9 — Delete at Head

For:

```text
10 ⇄ 20 ⇄ 30
```

delete `10`.

Final:

```text
20 ⇄ 30
```

### Correct transition

```java
head = head.next;
head.prev = null;
size--;
```

### One-node case

For:

```text
10
```

delete:

```text
head = null;
tail = null;
size = 0;
```

### Pattern memory

```text
MOVE HEAD
→ new head.prev = null
→ CHECK EMPTY
→ FIX TAIL
→ size--
```

### Important boundary

After changing head:

```text
head == null?
```

must be considered before:

```java
head.prev
```

---

# 11. Pattern 10 — Delete at Tail

For:

```text
10 ⇄ 20 ⇄ 30
```

delete `30`.

Because DLL has `prev`:

```java
tail = tail.prev;
tail.next = null;
size--;
```

### One-node case

```text
head = null
tail = null
size = 0
```

### Why this is important

Singly:

```text
delete tail → need traversal
```

Doubly:

```text
delete tail → tail.prev
```

Therefore:

```text
DLL tail deletion → O(1)
```

### Pattern memory

```text
MOVE TAIL BACK
→ NEW TAIL.next = null
→ size--
```

---

# 12. Pattern 11 — Delete at Position

For:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50
```

delete position `3`.

Then:

```text
prevNode = 20
currNode = 30
nextNode = 40
```

Before:

```text
20 ⇄ 30 ⇄ 40
```

After:

```text
20 ⇄ 40
```

### Core code

```java
prevNode.next = currNode.next;
currNode.next.prev = prevNode;
```

### Conceptual version

```java
Node nextNode = currNode.next;

prevNode.next = nextNode;
nextNode.prev = prevNode;
```

### Cleanup

```java
currNode.next = null;
currNode.prev = null;
size--;
```

### Pattern memory

```text
PREVIOUS → NEXT
NEXT → PREVIOUS
CURRENT → disconnected
```

This is one of the most important DLL patterns.

---

# 13. Pattern 12 — Delete by Value

For:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

delete value `30`.

We find:

```text
currNode = 30
prevNode = 20
nextNode = 40
```

Then:

```java
prevNode.next = nextNode;
nextNode.prev = prevNode;
```

Final:

```text
10 ⇄ 20 ⇄ 40
```

### Tail case

If:

```text
nextNode == null
```

then:

```java
tail = prevNode;
```

### Head case

If:

```text
head.data == value
```

use:

```java
deleteAtHead();
```

### Pattern memory

```text
FIND CURRENT
→ GET PREV
→ GET NEXT
→ PREV.NEXT = NEXT
→ NEXT.PREV = PREV
→ FIX TAIL IF NEEDED
→ size--
```

---

# 14. Pattern 13 — DLL Boundary Cases

Every structural method should first identify:

```text
EMPTY
ONE NODE
TWO NODES
HEAD
TAIL
MIDDLE
INVALID POSITION
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
```

### Two Nodes

```text
10 ⇄ 20
```

This is especially useful for testing head/tail transitions.

### Head

```text
position == 1
```

### Tail

```text
position == size
```

### Middle

```text
1 < position < size
```

### Pattern memory

```text
FIRST → HEAD
LAST → TAIL
MIDDLE → BOTH LINKS
```

---

# 15. Pattern 14 — Size Management

| Operation | Size |
|---|---:|
| Add Head | `+1` |
| Add Tail | `+1` |
| Add Position | `+1` |
| Update | `0` |
| Delete Head | `-1` |
| Delete Tail | `-1` |
| Delete Position | `-1` |
| Delete Value | `-1` |
| Clear | `0` after reset |

### Important

When deleting the only Node:

```java
head = null;
tail = null;
size = 0;
```

Do not leave:

```text
head == null
tail != null
```

or:

```text
head == tail
size == 0
```

---

# 16. Pattern 15 — Two-Way Invariant

After every DLL mutation check:

```text
A.next == B
```

then:

```text
B.prev == A
```

For the boundaries:

```text
head.prev == null
tail.next == null
```

### This is the main DLL invariant

```text
FORWARD LINK
must agree with
BACKWARD LINK
```

---

# 17. Pattern 16 — Common DLL Bug Shapes

## Bug 1 — Update only `next`

```java
prev.next = nextNode;
```

but forget:

```java
nextNode.prev = prev;
```

Result:

```text
forward traversal looks correct
backward traversal is broken
```

---

## Bug 2 — Wrong backward pointer

For deletion:

```java
prevNode.prev = currNode;
```

is wrong.

You need:

```java
nextNode.prev = prevNode;
```

Think:

```text
NEXT → PREVIOUS
```

---

## Bug 3 — Delete head but forget `head.prev`

After:

```java
head = head.next;
```

new head must have:

```java
head.prev = null;
```

---

## Bug 4 — Delete tail using unnecessary traversal

DLL already provides:

```java
tail.prev
```

Use it.

---

## Bug 5 — Tail not updated

Deleting the last Node means:

```text
tail changed
```

Therefore:

```java
tail = prevNode;
```

---

## Bug 6 — Empty access

Bad:

```java
if (head.data == value)
```

when:

```text
head == null
```

Correct thought:

```text
CHECK NULL
→ THEN ACCESS DATA
```

---

# 18. Pattern 17 — Dry Run: Position Insertion

Given:

```text
10 ⇄ 20 ⇄ 40
H          T
```

Insert `30` at position `3`.

### Step 1

```text
p = 3
p - 2 = 1
```

Therefore:

```text
prevNode = 20
```

### Step 2

```text
currNext = prevNode.next
```

So:

```text
currNext = 40
```

### Step 3

Create:

```text
newNode = 30
```

### Step 4

Connect:

```text
20 ⇄ 30 ⇄ 40
```

### Final

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

---

# 19. Pattern 18 — Dry Run: Position Deletion

Given:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50
```

Delete position `3`.

### State

```text
position = 3
prevNode = 20
currNode = 30
nextNode = 40
```

### Before

```text
20 ⇄ 30 ⇄ 40
```

### Rewire

```text
20.next = 40
40.prev = 20
```

### After

```text
20 ⇄ 40
```

### Cleanup

```text
30.next = null
30.prev = null
```

---

# 20. Pattern 19 — Dry Run: Tail Deletion

Given:

```text
10 ⇄ 20 ⇄ 30
H          T
```

### Current

```text
tail = 30
tail.prev = 20
```

### Delete

```java
tail = tail.prev;
tail.next = null;
size--;
```

### Final

```text
10 ⇄ 20
H      T
```

No traversal required.

---

# 21. Pattern 20 — Code Tracing

Given:

```java
Node prevNode = head;

for (int i = 1; i <= position - 2; i++) {
    prevNode = prevNode.next;
}
```

For:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50
```

predict:

| Position | Moves | `prevNode` |
|---:|---:|---:|
| 2 | 0 | 10 |
| 3 | 1 | 20 |
| 4 | 2 | 30 |
| 5 | 3 | 40 |

### Pattern Memory

```text
prevNode
→ always stops one Node before target
```

---

# 22. Pattern 21 — Interview Checklist

Before every DLL operation answer:

```text
A. What are the edge cases?

B. Which Node do I need?

C. What does prev mean?

D. What does curr mean?

E. What does next mean?

F. Which next links change?

G. Which prev links change?

H. Does head change?

I. Does tail change?

J. Does size change?

K. Time complexity?
```

---

# 23. Pattern 22 — Revision Drills

## Drill A — Pointer State

Given:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

If:

```text
prev = 20
curr = 30
next = 40
```

answer:

```text
prev.next = ?
curr.prev = ?
curr.next = ?
next.prev = ?
```

---

## Drill B — Position

Given:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ 50
```

For:

```text
position = 3
```

answer:

```text
prevNode = ?
currNode = ?
nextNode = ?
```

---

## Drill C — Delete

Delete `30`:

```text
10 ⇄ 20 ⇄ 30 ⇄ 40
```

Answer:

```text
prev =
curr =
next =
prev.next =
next.prev =
tail =
size =
```

---

## Drill D — Boundary

Test:

```text
[]
[10]
[10 ⇄ 20]
[10 ⇄ 20 ⇄ 30]
```

with:

```text
deleteAtHead
deleteAtTail
deleteAtPosition
deleteValue
```

For every case state:

```text
head
tail
size
```

---

## Drill E — Bug Finding

Given:

```java
prevNode.next = nextNode;
```

Ask:

```text
What link is still missing?
```

Expected reasoning:

```text
nextNode.prev = prevNode
```

---

# 24. Revision Priority

## ⭐⭐⭐⭐⭐ Master

```text
prev / curr / next
next + prev rewiring
position - 2
head / tail / size
empty list
one-node list
delete head
delete tail
delete position
delete value
DLL invariants
dry runs
debugging
```

## ⭐⭐⭐⭐ Strong

```text
insert at position
update position
update value
forward / backward traversal
browser-history style movement
```

## ⭐⭐⭐ Quick Revision

```text
getSize
isEmpty
getHead
getTail
clear
search
searchPosition
```

---

# 25. What To Memorize

Do not memorize complete methods.

Memorize these shapes.

### Insert

```text
prev ⇄ next

prev ⇄ new ⇄ next
```

Code:

```java
prev.next = newNode;
newNode.prev = prev;

newNode.next = next;
next.prev = newNode;
```

### Delete

```text
prev ⇄ curr ⇄ next
```

becomes:

```text
prev ⇄ next
```

Code:

```java
prev.next = next;

if (next != null) {
    next.prev = prev;
}
```

### Head

```text
head = head.next;
head.prev = null;
```

### Tail

```text
tail = tail.prev;
tail.next = null;
```

### One Node

```text
head = null;
tail = null;
size = 0;
```

### Invariant

```text
head.prev == null
tail.next == null
A.next == B
B.prev == A
```

---

# 26. Final Pattern Map

```text
NODE
    ↓
HEAD / TAIL / SIZE
    ↓
FORWARD / BACKWARD
    ↓
PREV / CURR / NEXT
    ↓
POSITION - 2
    ↓
INSERT REWIRING
    ↓
DELETE REWIRING
    ↓
HEAD / TAIL BOUNDARIES
    ↓
ONE-NODE CASE
    ↓
TWO-WAY INVARIANT
    ↓
SIZE CONSISTENCY
    ↓
DRY RUN
    ↓
BUG FINDING
    ↓
COMPLETE RECONSTRUCTION
```

---

# 27. Definition of Done

For a random Doubly Linked List operation, you should automatically know:

```text
Which Node am I on?

Which Node is previous?

Which Node is current?

Which Node is next?

Which next references change?

Which prev references change?

Can head change?

Can tail change?

Does size change?

What happens if there is one Node?

Does forward traversal work?

Does backward traversal work?
```

Then code.

---

# 28. Final Self-Test

Without looking at your class, reconstruct:

```text
addAtHead()
addAtTail()
addAtPosition()

deleteAtHead()
deleteAtTail()
deleteAtPosition()
deleteValue()

updatePosition()
updateValue()

search()
searchPosition()
```

For every method:

```text
1. State edge cases.
2. Identify pointer roles.
3. Draw before state.
4. Draw after state.
5. State head/tail changes.
6. State size changes.
7. State both next/prev changes.
8. State complexity.
9. Write Java from memory.
10. Dry run one example.
```

## Final Goal

```text
SEE DLL PROBLEM
      ↓
IDENTIFY BOUNDARY
      ↓
IDENTIFY PREV / CURR / NEXT
      ↓
TRACE BOTH DIRECTIONS
      ↓
REWIRE NEXT
      ↓
REWIRE PREV
      ↓
FIX HEAD / TAIL
      ↓
FIX SIZE
      ↓
VERIFY FORWARD + BACKWARD
      ↓
CODE
```

> **The goal is not to memorize four pointer assignments.**
>
> The goal is to see:
>
> ```text
> prev ⇄ curr ⇄ next
> ```
>
> and naturally know how the structure must look after the operation.
