# B — Singly Linked List — Revision Focus
## Pointer Reasoning • Position Logic • Head/Tail/Size • Deletion • Dry Runs • Debugging

> **Goal:** Strengthen the exact Linked List reasoning that appears while implementing a custom Singly Linked List.
>
> Keep revision focused on **how pointers move and why each line works**, rather than memorizing complete methods.

---

# 1. Revision Order

| Pattern | Focus | Priority |
|---|---|---|
| 1. Position Mapping | 1-based position → Node location | ⭐⭐⭐⭐⭐ |
| 2. Previous / Current / Next | Pointer roles and movement | ⭐⭐⭐⭐⭐ |
| 3. Link Reconnection | Insert / delete pointer changes | ⭐⭐⭐⭐⭐ |
| 4. Head / Tail / Size | State consistency | ⭐⭐⭐⭐⭐ |
| 5. Empty List | `null` safety | ⭐⭐⭐⭐⭐ |
| 6. One-Node List | Head/tail boundary | ⭐⭐⭐⭐⭐ |
| 7. First / Last / Middle | Case identification | ⭐⭐⭐⭐⭐ |
| 8. Tail Deletion | Reach previous tail | ⭐⭐⭐⭐⭐ |
| 9. Position Deletion | `position - 2` + bypass | ⭐⭐⭐⭐⭐ |
| 10. Delete by Value | `prev.next` candidate pattern | ⭐⭐⭐⭐⭐ |
| 11. Update Position | Locate existing Node | ⭐⭐⭐⭐ |
| 12. Size Management | `++`, `--`, reset | ⭐⭐⭐⭐ |
| 13. Return Flow | Prevent duplicate execution | ⭐⭐⭐⭐ |
| 14. Dry Run | Pointer-state tracing | ⭐⭐⭐⭐⭐ |
| 15. Debugging | Find state divergence | ⭐⭐⭐⭐⭐ |
| 16. Complete Reconstruction | Build class from memory | ⭐⭐⭐⭐⭐ |

---

# 2. Pattern 1 — Position Mapping

## Core Idea

The list uses **1-based positions**.

```text
10 → 20 → 30 → 40 → 50
↑
head
```

```text
position 1 → 10
position 2 → 20
position 3 → 30
position 4 → 40
position 5 → 50
```

### Pattern Memory

```text
To reach the node BEFORE position p:

move p - 2 times from head
```

### Example

```text
position = 2
p - 2 = 0
→ prev = head
→ prev is Node 10
```

```text
position = 3
p - 2 = 1
→ prev moves once
→ prev is Node 20
```

```text
position = 4
p - 2 = 2
→ prev moves twice
→ prev is Node 30
```

### Remember

```text
p - 2
→ not a magic formula

It means:
"reach the Node immediately before the target."
```

---

# 3. Pattern 2 — Previous / Current / Next

This is the main pointer vocabulary.

```text
10 → 20 → 30 → 40
     ↑     ↑
    prev  curr
```

If:

```java
prev = 20;
curr = 30;
```

then:

```text
prev.data      → 20
curr.data      → 30
prev.next      → curr
curr.next      → 40
```

### Pointer Movement

```java
prev = curr;
curr = curr.next;
```

means:

```text
OLD:
prev → 20
curr → 30

NEW:
prev → 30
curr → 40
```

### Pattern Memory

```text
prev
→ Node before target

curr
→ Node currently being processed

curr.next
→ Node after curr
```

---

# 4. Pattern 3 — Link Reconnection

## Insert

Before:

```text
10 → 20 → 40
```

Want:

```text
10 → 20 → 30 → 40
```

Suppose:

```text
prev = 20
newNode = 30
```

### Step 1

```java
newNode.next = prev.next;
```

Now:

```text
30 → 40
```

### Step 2

```java
prev.next = newNode;
```

Final:

```text
10 → 20 → 30 → 40
```

### Pattern Memory

```text
NEW → OLD NEXT
PREV → NEW
```

---

## Delete

Before:

```text
10 → 20 → 30 → 40
          ↑
         curr
```

Suppose:

```text
prev = 20
curr = 30
```

### Reconnect

```java
prev.next = curr.next;
```

Final:

```text
10 → 20 → 40
```

Optional cleanup:

```java
curr.next = null;
```

Now:

```text
curr → 30 → null
```

### Pattern Memory

```text
DELETE
→ previous skips current
```

---

# 5. Pattern 4 — Head / Tail / Size Consistency

Every structural operation affects some combination of:

```text
head
tail
size
```

After a modification ask:

```text
1. What is head?
2. What is tail?
3. What is size?
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
size == 1
```

### Multiple Nodes

```text
head != tail
tail.next == null
```

### Pattern Memory

```text
Every mutation
→ repair list state
```

---

# 6. Pattern 5 — Empty List Safety

Before using:

```java
head.data
head.next
tail.data
```

ask:

```text
Can head / tail be null?
```

### Safe order

```java
if (head == null) {
    return;
}
```

Then access:

```java
head.data
```

### Important Methods

Practice the empty-list question for:

```text
getHead()
getTail()
deleteAtHead()
deleteAtTail()
deleteValue()
search()
updateValue()
```

### Remember

```text
NULL CHECK
→ before dereference
```

---

# 7. Pattern 6 — One-Node List

For:

```text
10
```

we have:

```text
head == tail
size == 1
head.next == null
```

### After deleting the only Node

```text
head = null
tail = null
size = 0
```

### Practice

```text
deleteAtHead()
deleteAtTail()
deleteAtPosition(1)
deleteValue(10)
```

### Pattern Memory

```text
ONE NODE
→ head and tail are the same Node
```

---

# 8. Pattern 7 — First / Last / Middle

Before coding a structural operation:

```text
Is target first?
Is target last?
Is target middle?
```

### First

```text
position == 1
```

### Last

```text
position == size
```

### Middle

```text
1 < position < size
```

### Pattern Memory

```text
FIRST → HEAD
LAST → TAIL
MIDDLE → REWIRE
```

---

# 9. Pattern 8 — Insertion Boundary

For insertion:

```text
1 ... size + 1
```

Example:

```text
10 → 20 → 30
size = 3
```

Valid insertion positions:

```text
1
2
3
4
```

Position `4` means:

```text
after the current last Node
```

So:

```java
addAtPosition(4, 40);
```

creates:

```text
10 → 20 → 30 → 40
```

But:

```java
updatePosition(4, 40);
deleteAtPosition(4);
```

are invalid when:

```text
size = 3
```

### Remember

```text
INSERT
→ 1 ... size + 1

UPDATE / DELETE
→ 1 ... size
```

---

# 10. Pattern 9 — Delete at Tail

Example:

```text
10 → 20 → 30 → 40
size = 4
```

Need:

```text
temp → 30
```

because `30` is the Node before the tail.

### Loop

```java
Node temp = head;

for (int i = 1; i <= size - 2; i++) {
    temp = temp.next;
}
```

For `size = 4`:

```text
i = 1 → temp = 20
i = 2 → temp = 30
```

Stop.

### Reconnect

```java
temp.next = null;
tail = temp;
size--;
```

### Why `size - 2`?

You want the Node at:

```text
size - 1
```

Starting from position `1` requires:

```text
(size - 1) - 1
= size - 2
```

### Pattern Memory

```text
FIND PREVIOUS TAIL
→ BREAK OLD TAIL LINK
→ MOVE TAIL
→ size--
```

---

# 11. Pattern 10 — Delete at Position

Example:

```text
10 → 20 → 30 → 40 → 50
```

Delete:

```text
position = 3
```

### Step 1 — Find previous

```text
p - 2
= 3 - 2
= 1
```

Therefore:

```text
prev = 20
```

### Step 2 — Current

```java
Node curr = prev.next;
```

Therefore:

```text
curr = 30
```

### Step 3 — Skip

```java
prev.next = curr.next;
```

Now:

```text
20 → 40
```

### Step 4 — Disconnect

```java
curr.next = null;
```

### Step 5 — Size

```java
size--;
```

Final:

```text
10 → 20 → 40 → 50
```

### Pattern Memory

```text
FIND PREVIOUS
→ GET CURRENT
→ SKIP CURRENT
→ DISCONNECT
→ size--
```

---

# 12. Pattern 11 — Delete by Value

Core pattern:

```text
prev → candidate
```

For:

```text
10 → 20 → 30 → 40
```

and:

```text
prev = 20
```

the candidate is:

```java
prev.next
```

which is:

```text
30
```

### Therefore

```java
if (prev.next.data == value)
```

means:

```text
"Is the Node after prev the one I want?"
```

### Core algorithm

```text
EMPTY?
 ↓
HEAD TARGET?
 ↓
delete head

otherwise:

prev = head
 ↓
check prev.next
 ↓
target?
 ├── YES → bypass
 └── NO  → prev = prev.next
```

### Reconnect

```java
Node curr = prev.next;

prev.next = curr.next;
curr.next = null;
size--;
```

### Tail case

If:

```java
curr == tail
```

then:

```java
tail = prev;
```

### Practice

Use:

```text
10 → 20 → 30 → 40
```

Try deleting:

```text
10
30
40
99
```

---

# 13. Pattern 12 — Update by Position

Update does not create a Node.

Example:

```text
10 → 20 → 30
```

Update position `2` to `99`.

Final:

```text
10 → 99 → 30
```

### Algorithm

```text
FIND EXISTING NODE
        ↓
CHANGE data
```

### Compare

Insert:

```text
create Node
change links
size++
```

Update:

```text
find Node
change data
size unchanged
```

### Pattern Memory

```text
UPDATE
→ DATA ONLY
```

---

# 14. Pattern 13 — Update by Value

Example:

```text
10 → 20 → 20 → 30
```

Call:

```java
updateValue(20, 99);
```

Current implementation changes the:

```text
FIRST occurrence
```

Final:

```text
10 → 99 → 20 → 30
```

### Pattern

```text
START HEAD
→ CHECK CURRENT
→ CHANGE
→ RETURN
```

---

# 15. Pattern 14 — Size Management

| Operation | Size |
|---|---:|
| `addAtHead()` | `+1` |
| `addAtTail()` | `+1` |
| `addAtPosition()` | `+1` |
| `updatePosition()` | `0` |
| `updateValue()` | `0` |
| `deleteAtHead()` | `-1` |
| `deleteAtTail()` | `-1` |
| `deleteAtPosition()` | `-1` |
| `deleteValue()` | `-1` |
| `clear()` | reset to `0` |

### Pattern Memory

```text
CREATE NODE
→ size++

REMOVE NODE
→ size--

CHANGE DATA
→ size unchanged
```

---

# 16. Pattern 15 — Return Flow

When a method delegates:

```java
if (position == 1) {
    addAtHead(data);
    return;
}
```

### Why?

```text
SPECIAL CASE
→ already handled
→ stop this method
```

Otherwise the general logic could execute again.

### Pattern Memory

```text
SPECIAL CASE
→ DELEGATE
→ RETURN
```

Common cases:

```text
position == 1
position == size + 1
empty list
one-node list
```

---

# 17. Pattern 16 — Dry Run

Do not immediately code.

First trace.

Example:

```text
10 → 20 → 30 → 40 → 50
```

Delete:

```text
position = 4
```

Write:

```text
position = 4
size = 5
prev = 30
curr = 40
curr.next = 50
prev.next becomes 50
final size = 4
```

Final:

```text
10 → 20 → 30 → 50
```

### Paper Rule

For tricky pointer operations write:

```text
head =
tail =
size =
prev =
curr =
next =
```

---

# 18. Pattern 17 — Debugging Flow

```text
STATE
 ↓
TRACE ONE LINE
 ↓
UPDATE POINTERS
 ↓
DRAW AGAIN
 ↓
COMPARE WITH EXPECTED
```

### Debug Checklist

```text
1. Is the boundary correct?
2. Did I start from the correct Node?
3. Did each pointer move?
4. Did I skip a Node?
5. Did I lose a reference?
6. Did I update the correct link?
7. Can a pointer become null?
8. Did head change?
9. Did tail change?
10. Did size change exactly once?
11. Is tail.next still null?
12. Is every Node reachable?
```

---

# 19. Pattern 18 — Bug Shapes

## Pointer movement

```text
prev moves
but curr does not
```

Ask:

```text
Should these pointers preserve a relationship?
```

## Null dereference

```java
head.data
```

before checking:

```java
head == null
```

Ask:

```text
Can this reference be null?
```

## Tail consistency

```text
head = null
```

but:

```text
tail != null
```

Ask:

```text
Did the last Node disappear?
```

## Size consistency

```text
Node removed
but size unchanged
```

Ask:

```text
actual Nodes == size?
```

## Boundary

```text
size + 1
```

used for deletion/update.

Ask:

```text
Does this operation create a Node
or target an existing Node?
```

---

# 20. Pattern 19 — Position Drill

For:

```text
10 → 20 → 30 → 40 → 50
```

| Position | `p - 2` | Previous | Target |
|---:|---:|---:|---:|
| 2 | 0 | 10 | 20 |
| 3 | 1 | 20 | 30 |
| 4 | 2 | 30 | 40 |
| 5 | 3 | 40 | 50 |

### Say it this way

```text
I am not directly finding the target.

I am finding the Node immediately before it.

Therefore I move position - 2 times.
```

---

# 21. Pattern 20 — First / Last / Middle Drill

For:

```text
10 → 20 → 30 → 40 → 50
size = 5
```

```text
position 1
→ FIRST
→ HEAD

position 5
→ LAST
→ TAIL

positions 2, 3, 4
→ MIDDLE
→ REWIRE
```

### Pattern Memory

```text
FIRST → HEAD
LAST → TAIL
MIDDLE → POINTER REWIRING
```

---

# 22. Pattern 21 — Method Reconstruction

## Insert at Position

```text
VALIDATE
→ HEAD?
→ TAIL?
→ FIND PREVIOUS
→ CREATE
→ CONNECT
→ size++
```

## Delete at Position

```text
VALIDATE
→ HEAD?
→ TAIL?
→ FIND PREVIOUS
→ GET CURRENT
→ SKIP
→ size--
```

## Delete by Value

```text
EMPTY?
→ HEAD?
→ CHECK prev.next
→ SKIP
→ FIX TAIL
→ size--
```

## Update Position

```text
VALIDATE
→ FIND NODE
→ CHANGE DATA
```

### Pattern Memory

```text
UNDERSTAND
→ DRAW
→ POINTERS
→ CODE
```

---

# 23. Revision Drills

## Drill A — Pointer State

Given:

```text
10 → 20 → 30 → 40
```

If:

```text
prev = 20
curr = 30
```

answer:

```text
prev.next = ?
curr.next = ?
```

---

## Drill B — Position

Given:

```text
10 → 20 → 30 → 40 → 50
```

For:

```text
position 3
```

answer:

```text
prev = ?
curr = ?
```

For:

```text
position 5
```

answer:

```text
prev = ?
curr = ?
```

---

## Drill C — Delete by Value

Given:

```text
10 → 20 → 30 → 40
```

Delete:

```text
20
30
40
99
```

For each:

```text
prev?
curr?
tail?
size?
final list?
```

---

## Drill D — Empty / One Node

Test:

```text
[]
[10]
[10 → 20]
```

with:

```text
deleteAtHead
deleteAtTail
deleteAtPosition(1)
deleteValue
```

---

## Drill E — Broken Code

Given buggy code, answer:

```text
What is wrong?
Which pointer becomes incorrect?
At which line does the state diverge?
How should the pointer move?
```

Only then correct it.

---

# 24. Revision Priority

## ⭐⭐⭐⭐⭐ Master

```text
Position - 2 reasoning
Prev / Curr movement
Link reconnection
Head / Tail / Size
Empty list
One-node list
Delete at Tail
Delete at Position
Delete by Value
Dry Run
Debugging
```

## ⭐⭐⭐⭐ Understand Well

```text
Update Position
Update Value
Return flow
First / Last / Middle
Insertion boundaries
```

## ⭐⭐⭐ Quick Revision

```text
getSize
isEmpty
getHead
getTail
clear
printList
```

---

# 25. What To Memorize

Do NOT memorize complete methods.

Memorize the shapes:

```text
POSITION
→ move position - 2 times
→ reach previous
```

```text
INSERT
→ new.next = prev.next
→ prev.next = new
```

```text
DELETE
→ prev.next = curr.next
```

```text
TRAVERSAL
→ check current
→ move current.next
```

```text
DELETE VALUE
→ check prev.next
```

```text
TAIL DELETE
→ find previous tail
→ previous.next = null
→ tail = previous
```

```text
HEAD DELETE
→ head = head.next
→ if head == null → tail = null
```

```text
UPDATE
→ change data
→ size unchanged
```

```text
INSERT
→ size++

DELETE
→ size--
```

```text
FIRST
→ HEAD

LAST
→ TAIL

MIDDLE
→ REWIRE
```

---

# 26. Final Pattern Map

```text
POSITION LOGIC
        ↓
PREV / CURR / NEXT
        ↓
LINK RECONNECTION
        ↓
HEAD / TAIL / SIZE
        ↓
EMPTY / ONE NODE
        ↓
FIRST / LAST / MIDDLE
        ↓
INSERTION
        ↓
DELETION
        ↓
DELETE BY VALUE
        ↓
UPDATE
        ↓
DRY RUN
        ↓
DEBUGGING
        ↓
COMPLETE RECONSTRUCTION
```

---

# 27. Definition of Done

You are done with this revision when a random Singly Linked List operation makes you automatically answer:

```text
What is the target Node?

Where should my pointer start?

How many times should it move?

What does prev mean?

What does curr mean?

What is curr.next?

Which link changes?

Could I lose a reference?

Can head change?

Can tail change?

Does size change?

What happens for an empty list?

What happens for one Node?

What should the final list look like?

Why does the code work?
```

Then code.

---

# 28. Final Self-Test

Without looking at the implementation, reconstruct:

```text
addAtHead()
addAtTail()
addAtPosition()

search()
searchPosition()

updatePosition()
updateValue()

deleteAtHead()
deleteAtTail()
deleteAtPosition()
deleteValue()
```

For every method:

```text
1. Explain the algorithm.
2. Draw the pointer state.
3. State boundary cases.
4. State head / tail / size changes.
5. State time complexity.
6. Write Java from memory.
7. Dry run one example.
```

## Final Goal

```text
SEE PROBLEM
    ↓
IDENTIFY CASE
    ↓
IDENTIFY POINTERS
    ↓
TRACE
    ↓
REWIRE
    ↓
VERIFY
    ↓
CODE
```

> The goal is not to remember `position - 2`, `prev.next`, or `curr.next` as isolated syntax.
>
> The goal is to understand what each pointer represents so the correct Java code can be reconstructed naturally.
