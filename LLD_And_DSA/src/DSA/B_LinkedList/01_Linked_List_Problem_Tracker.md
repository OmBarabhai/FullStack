# B — Singly Linked List — Part 1
## Core Foundation • Pointer Patterns • Classic Interview Problems

> **Goal:** Complete the entire core Singly Linked List interview track in one Part.
>
> Part 1 covers the foundation plus every major pattern that repeatedly appears in coding rounds:
>
> ```text
> References
> → Node Design
> → List State
> → Traversal / Search
> → Insert / Delete
> → Dummy Node
> → Two Pointers
> → Fast / Slow
> → Fixed Gap
> → Reverse
> → Cycle
> → Merge / Intersection
> → Palindrome
> → Reorder / Swap / Odd-Even
> → Rotate
> → Add Two Numbers
> → Random Problem Recognition
> ```
>
> **Part 1 = 65 problems.**
> There is no separate Part 0.

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild the method from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only where needed |

**Tracker Key**

`☑️` completed · `R1/R2/R3` = revision completed · `🟢/🟡/🔴` = strong / medium / needs practice

---

# 2. Part 1 Pattern Map

```text
A — Foundation
    References
    Node
    List State
    Traversal
    Search
    Length

B — Core Operations
    Insert
    Delete
    Update
    Dummy Node

C — Two Pointer Patterns
    Middle
    Kth from End
    One-Pass Gap

D — Reversal
    Iterative
    Recursive
    Partial

E — Cycle
    Detect
    Count
    Remove

F — Multi-List / Shared Structure
    Merge
    Intersection

G — Interview Integration
    Palindrome
    Swap
    Odd-Even
    Rotate
    Reorder
    Add Two Numbers
```

---

# 3. Pattern A — Foundation

## Pattern Memory

```text
new Node(...) → create object

Node b = a
→ copy reference

a = a.next
→ move reference
```

```text
Node
├── data
└── next → Node / null
```

```text
head → first Node
tail → last Node
size → number of Nodes
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
```

### Traversal

```text
START HEAD
→ CHECK CURRENT
→ MOVE NEXT
→ STOP AT NULL
```

### Core rule

```text
check current
→ move second
```

## Problems
|  # | Problem                       | Platform     | Diff. | Interview | Status | R1 | R2 | R3 | Pattern      |
|---:|-------------------------------|--------------|:-----:|:---------:|:------:|:--:|:--:|:--:|--------------|
| 01 | Design Node Class             | Custom       |  🟢   |   ⭐⭐⭐⭐⭐   |   ☑️   | ⬜  | ⬜  | ⬜  | Node         |
| 02 | Build Singly Linked List      | Custom       |  🟢   |   ⭐⭐⭐⭐⭐   |   ☑️   | ⬜  | ⬜  | ⬜  | Design       |
| 03 | Build List from Array         | Custom       |  🟢   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Construction |
| 04 | Convert Array to Linked List  | Custom       |  🟢   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Construction |
| 05 | Traverse Linked List          | Custom       |  🟢   |   ⭐⭐⭐⭐⭐   |   ☑️   | ⬜  | ⬜  | ⬜  | Traversal    |
| 06 | Print Linked List             | GFG          |  🟢   |   ⭐⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | Traversal    |
| 07 | Print in Reverse Recursively  | GFG          |  🟡   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Recursion    |
| 08 | Traverse Circular Linked List | Custom       |  🟡   |    ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Circular     |
| 09 | Search in Linked List         | GFG          |  🟢   |   ⭐⭐⭐⭐⭐   |   ☑️   | ⬜  | ⬜  | ⬜  | Search       |
| 10 | Search Recursively            | GFG          |  🟡   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Recursion    |
| 11 | Search in Sorted List         | Custom       |  🟢   |    ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Search       |
| 12 | Count Occurrences             | GFG          |  🟢   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Traversal    |
| 13 | Remove Linked List Elements   | LeetCode 203 |  🟢   |   ⭐⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | Dummy        |
| 14 | Delete Head Using Dummy       | Custom       |  🟢   |   ⭐⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Dummy        |
| 15 | Merge Two Lists with Dummy    | LeetCode 21  |  🟢   |   ⭐⭐⭐⭐⭐   |   ⬜    | ⬜  | ⬜  | ⬜  | Dummy        |
| 16 | Length of Linked List         | GFG          |  🟢   |   ⭐⭐⭐⭐⭐   |   ☑️   | ⬜  | ⬜  | ⬜  | Length       |
| 17 | Count Nodes Iteratively       | Custom       |  🟢   |   ⭐⭐⭐⭐    |   ☑️   | ⬜  | ⬜  | ⬜  | Length       |
| 18 | Count Nodes Recursively       | GFG          |  🟢   |    ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Recursion    |
| 19 | Length of Circular List       | Custom       |  🟡   |    ⭐⭐⭐    |   ⬜    | ⬜  | ⬜  | ⬜  | Circular     |
---

# 4. Pattern B — Core Operations

## Head / Tail / Position Rules

```text
INSERT
→ valid positions: 1 ... size + 1

UPDATE / DELETE
→ valid positions: 1 ... size
```

## Insert

```text
HEAD
→ new.next = head
→ head = new
```

```text
TAIL
→ tail.next = new
→ tail = new
```

```text
POSITION
→ find previous
→ new.next = previous.next
→ previous.next = new
```

## Delete

```text
HEAD
→ head = head.next
```

```text
TAIL
→ find previous tail
→ previous.next = null
→ tail = previous
```

```text
POSITION
→ previous.next = target.next
```

```text
VALUE
→ find target
→ bypass target
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 20 | Insert at Head | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ☑️ | ⬜ | ⬜ | ⬜ | Insert |
| 21 | Delete Head Node | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ☑️ | ⬜ | ⬜ | ⬜ | Delete |
| 22 | Insert at Tail | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ☑️ | ⬜ | ⬜ | ⬜ | Insert |
| 23 | Delete Tail Node | GFG | 🟡 | ⭐⭐⭐⭐⭐ | 🔄 | ⬜ | ⬜ | ⬜ | Delete |
| 24 | Insert at Position | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ☑️ | ⬜ | ⬜ | ⬜ | Insert |
| 25 | Insert After Given Node | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rewire |
| 26 | Insert Before Given Node | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rewire |
| 27 | Sorted Insert | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Insert |
| 28 | Insert into Circular Sorted List | LeetCode 708 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 29 | Insert into Doubly Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL |
| 30 | Delete Node at Position | GFG | 🟡 | ⭐⭐⭐⭐⭐ | 🔄 | ⬜ | ⬜ | ⬜ | Delete |
| 31 | Delete Node by Key | GFG | 🟡 | ⭐⭐⭐⭐⭐ | 🔄 | ⬜ | ⬜ | ⬜ | Delete |
| 32 | Delete Node Given Only Node | LeetCode 237 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Trick |
| 33 | Remove Linked List Elements | LeetCode 203 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy |
| 34 | Delete Entire Linked List | GFG | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Utility |
| 35 | Delete from Circular Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |

---

# 5. Pattern C — Two Pointers / Fast-Slow / Gap

## Middle

```text
slow → one step
fast → two steps
```

## Fixed Gap

```text
move first pointer k steps
→ move both together
→ second reaches target relation
```

## Recognition

```text
middle
nth from end
kth from end
one pass
two pointers
```

↓

Think:

> **Two Pointer State**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 36 | Middle using Two Pointers | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Pointer |
| 37 | Kth Node from End | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap |
| 38 | One-Pass Pointer Distance | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap |
| 39 | Middle of Linked List | LeetCode 876 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Slow/Fast |
| 40 | First Middle Node | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Slow/Fast |
| 41 | Second Middle Node | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Slow/Fast |
| 42 | Split List into Two Halves | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Slow/Fast |
| 43 | Nth Node from End | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap |
| 44 | Remove Nth Node From End | LeetCode 19 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap + Dummy |
| 45 | Kth Node from End One Pass | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap |
| 46 | Kth Node from Beginning | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Position |

---

# 6. Pattern D — Reversal

## Core Pattern

```text
prev
current
next
```

```text
save next
→ current.next = prev
→ move prev
→ move current
```

## Recognition

```text
reverse
reverse recursively
reverse section
```

↓

Think:

> **Pointer Reversal**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 47 | Reverse Linked List | LeetCode 206 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse |
| 48 | Reverse Linked List Recursively | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse + Recursion |
| 49 | Reverse Linked List II | LeetCode 92 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Partial |
| 50 | Reverse First K Nodes | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Segment |

---

# 7. Pattern E — Cycle

## Detection

```text
slow → 1
fast → 2
```

If:

```text
slow == fast
```

a cycle exists.

## Removal

```text
detect
→ locate entry
→ disconnect cycle
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 51 | Linked List Cycle | LeetCode 141 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Floyd |
| 52 | Detect Loop in Linked List | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Floyd |
| 53 | Count Nodes in Loop | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Floyd |
| 54 | Remove Loop | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Floyd |

---

# 8. Pattern F — Merge / Intersection / Integration

## Merge

```text
dummy
→ compare current nodes
→ attach smaller
→ advance
```

## Intersection

```text
A reaches end
→ switch to B

B reaches end
→ switch to A

Pointers synchronize
```

## Palindrome

```text
middle
→ reverse second half
→ compare halves
```

## Reorder

```text
middle
→ reverse second half
→ merge alternating
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 55 | Merge Two Sorted Lists | LeetCode 21 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy |
| 56 | Intersection of Two Lists | LeetCode 160 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Sync |
| 57 | Merge Two Sorted Lists | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Merge |
| 58 | Y-Shaped List Intersection | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Sync |
| 59 | Palindrome Linked List | LeetCode 234 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Middle + Reverse |
| 60 | Remove Nth Node — Integration | LeetCode 19 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Gap + Dummy |
| 61 | Swap Nodes in Pairs | LeetCode 24 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rewire |
| 62 | Odd Even Linked List | LeetCode 328 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rewire |
| 63 | Rotate List | LeetCode 61 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Length + Rewire |
| 64 | Reorder List | LeetCode 143 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Middle + Reverse + Merge |
| 65 | Add Two Numbers | LeetCode 2 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy + Carry |

---

# 9. Part 1 Pattern Recognition

```text
Traversal
→ current = current.next

Search
→ check → move → repeat

Dummy
→ head may change / uniform rewiring

Two Pointer
→ distance relationship

Fast + Slow
→ middle / half / cycle

Fixed Gap
→ Nth / Kth from end

Reverse
→ prev / current / next

Cycle
→ Floyd

Merge
→ dummy + two pointers

Intersection
→ synchronize pointer paths

Palindrome
→ middle + reverse + compare

Reorder
→ middle + reverse + merge

Swap
→ local rewiring

Odd / Even
→ separate chains + connect

Rotate
→ length + connect + break

Add Two Numbers
→ carry + dummy + synchronized traversal
```

---

# 10. Random Problem Drill

Before coding an unseen Part 1 problem:

```text
1. What is being asked?
2. Which pattern matches?
3. What pointers are needed?
4. What boundary can break it?
5. What reference must be preserved?
6. What changes in one iteration?
7. What invariant remains?
8. What is the complexity?
```

Write:

```text
PATTERN:
POINTERS:
BOUNDARY:
STATE CHANGE:
COMPLEXITY:
```

Then code.

---

# 11. Part 1 Mastery Gate

Part 1 is complete when you can recognize these without being told:

```text
Traversal
Search
Insertion
Deletion
Dummy Node
Two Pointer
Fast / Slow
Fixed Gap
Reverse
Cycle
Merge
Intersection
Palindrome
Reorder
Swap
Odd / Even
Rotate
Add Two Numbers
```

The goal:

```text
PROBLEM STATEMENT
→ RECOGNIZE PATTERN
→ SELECT POINTER TECHNIQUE
→ BUILD STATE
→ CODE
→ TRACE
```

---

# 12. Part 1 Complexity Map

| Pattern | Typical Time | Extra Space |
|---|---:|---:|
| Traversal | O(n) | O(1) |
| Search | O(n) | O(1) |
| Insert Head | O(1) | O(1) |
| Insert Tail | O(1) with tail | O(1) |
| Insert Position | O(n) | O(1) |
| Delete Head | O(1) | O(1) |
| Delete Tail | O(n) | O(1) |
| Delete Position | O(n) | O(1) |
| Middle | O(n) | O(1) |
| Nth from End | O(n) | O(1) |
| Reverse | O(n) | O(1) iterative |
| Cycle Detection | O(n) | O(1) |
| Merge Two | O(n+m) | O(1) |
| Intersection | O(n+m) | O(1) |
| Palindrome | O(n) | O(1) extra |
| Reorder | O(n) | O(1) extra |
| Rotate | O(n) | O(1) |

---

# 13. Part 1 Final Completion

```text
FOUNDATION
☑ References
☑ Node
☑ Head / Tail / Size
☑ States / Invariants

CORE OPERATIONS
☑ Traversal
☑ Search
☑ Insert
☑ Delete
☑ Update
☑ Dummy Node

POINTER PATTERNS
☑ Two Pointer
☑ Fast / Slow
☑ Fixed Gap
☑ Reverse
☑ Cycle

INTERVIEW INTEGRATION
☑ Merge
☑ Intersection
☑ Palindrome
☑ Reorder
☑ Swap
☑ Odd / Even
☑ Rotate
☑ Add Two Numbers
```

> **Part 1 = 65 problems.**
> After this, do not restart the basic Linked List material.

---

# 14. Transition to Part 2

Part 2 begins with:

```text
Cycle Entry / Cycle Math
→ Advanced / Partial Reversal
→ K-Group Reversal
→ Partition
→ Multi-List Algorithms
→ Linked List Sorting
→ Random Pointer
→ Multilevel
→ Doubly
→ Circular
→ Design
→ Cache
→ Advanced Integration
```

