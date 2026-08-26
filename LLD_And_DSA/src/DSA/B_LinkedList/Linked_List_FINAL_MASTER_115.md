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

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 01 | Design Node Class | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Node |
| 02 | Build Singly Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 03 | Build List from Array | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Construction |
| 04 | Convert Array to Linked List | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Construction |
| 05 | Traverse Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Traversal |
| 06 | Print Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Traversal |
| 07 | Print in Reverse Recursively | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 08 | Traverse Circular Linked List | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 09 | Search in Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Search |
| 10 | Search Recursively | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 11 | Search in Sorted List | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Search |
| 12 | Count Occurrences | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Traversal |
| 13 | Remove Linked List Elements | LeetCode 203 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy |
| 14 | Delete Head Using Dummy | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy |
| 15 | Merge Two Lists with Dummy | LeetCode 21 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy |
| 16 | Length of Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Length |
| 17 | Count Nodes Iteratively | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Length |
| 18 | Count Nodes Recursively | GFG | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 19 | Length of Circular List | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |

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



---

# B — Singly Linked List — Part 2
## Advanced Pointer Manipulation • Multi-List Algorithms • Special Structures • Design • Capstone

> **Goal:** Finish Linked List without restarting Part 1.
>
> Part 2 assumes the complete Part 1 pattern set and focuses on:
>
> ```text
> advanced pointer combinations
> → multi-list algorithms
> → sorting
> → special Node structures
> → doubly / circular lists
> → design
> → cache
> → hard interview integration
> ```
>
> **Part 2 = 50 problems.**

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild the pointer state from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only where needed |

---

# 2. Part 2 Roadmap

| Section | Focus | Problems |
|---|---|---:|
| A | Advanced Pointer Manipulation | 10 |
| B | Multi-List Algorithms & Sorting | 11 |
| C | Special Linked List Structures | 14 |
| D | Design / Cache / Company Favorites | 15 |
| **Total** | | **50** |

---

# 3. Section A — Advanced Pointer Manipulation

## Pattern P — Reverse Variations

### Purpose

Master interview variations built on the basic reversal pattern.

### Core idea

```text
prev
current
next
```

The reversal operation stays the same.

Only:

```text
WHEN TO STOP
+
HOW TO RECONNECT
```

changes.

### Recognition

```text
Reverse K
Reverse Between
Reverse Alternate
Reverse Groups
```

↓

Think:

> **Pointer Reversal Pattern**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 66 | Reverse Nodes in k-Group | LeetCode 25 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse |
| 67 | Reverse Alternate k Nodes | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse |
| 68 | Reverse Every k Nodes (Recursive) | GFG | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse + Recursion |
| 69 | Reverse Even Length Groups | LeetCode 2074 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Group |
| 70 | Reverse Doubly Linked List | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL Reverse |

### Pattern memory

```text
BOUNDARY
→ REVERSE
→ RECONNECT
```

---

## Pattern Q — Partition & Rearrangement

### Purpose

Maintain multiple chains and connect them safely.

### Core idea

```text
CLASSIFY
→ APPEND TO CHAIN
→ CONTINUE
→ CONNECT CHAINS
```

### Recognition

```text
Partition
Segregate
Rearrange
Stable grouping
```

↓

Think:

> **Multi-Chain Pointer Manipulation**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 71 | Partition List | LeetCode 86 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Dummy Chains |
| 72 | Segregate Even and Odd Nodes | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Chains |
| 73 | Segregate 0s, 1s and 2s | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Chains |
| 74 | Rearrange Linked List in Zig-Zag | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reorder |
| 75 | Sort Linked List of 0s, 1s and 2s | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Grouping |

### Pattern memory

```text
CLASSIFY
→ APPEND
→ CONNECT
→ TERMINATE
```

---

# 4. Section B — Multi-List Algorithms & Sorting

## Pattern R — Multi-List Algorithms

### Purpose

Move from two-list processing to many-list processing.

### Core tools

```text
Dummy Node
Two Pointers
Divide & Conquer
Priority Queue
```

### Recognition

```text
Merge K Lists
Multiple Sorted Lists
Merge Streams
Many Lists
```

↓

Think:

> **Multi-List Processing**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 76 | Merge K Sorted Lists | LeetCode 23 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Heap |
| 77 | Merge K Sorted Linked Lists | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | D&C |
| 78 | Flattening a Linked List | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Merge |
| 79 | Flatten a Multilevel Doubly Linked List | LeetCode 430 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Flatten |
| 80 | Merge Nodes in Between Zeros | LeetCode 2181 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State Grouping |
| 81 | Splice Two Linked Lists | LeetCode 1669 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reconnect |

### Pattern memory

```text
MERGE TWO
→ REDUCE MANY TO FEW
→ REPEAT
```

---

## Pattern S — Linked List Sorting

### Purpose

Master sorting approaches suited to linked-list structure.

### Core idea

```text
FIND MIDDLE
→ SPLIT
→ SORT
→ MERGE
```

### Recognition

```text
Sort List
Merge Sort
Insertion Sort
O(n log n)
```

↓

Think:

> **Split → Sort → Merge**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 82 | Sort List | LeetCode 148 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Merge Sort |
| 83 | Merge Sort for Linked List | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Merge Sort |
| 84 | Insertion Sort List | LeetCode 147 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Insertion Sort |
| 85 | Quick Sort on Singly Linked List | GFG | 🔴 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Advanced |
| 86 | Sort a Nearly Sorted Linked List | Custom | 🔴 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Heap / Sort |

### Pattern memory

```text
MIDDLE
→ SPLIT
→ SORT
→ MERGE
```

---

# 5. Section C — Special Linked List Structures

## Pattern T — Random Pointer

### Purpose

Clone a structure where Nodes contain more than `next`.

```text
next
+
random
```

### Recognition

```text
Random Pointer
Clone
Deep Copy
Arbitrary Pointer
```

↓

Think:

> **Clone Objects + Clone Relationships**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 87 | Copy List with Random Pointer | LeetCode 138 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | HashMap |
| 88 | Clone a Linked List with Random Pointer | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Clone |
| 89 | Clone Random Pointer O(1) Extra Space | Custom | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Interleave |

### Pattern memory

```text
COPY NODES
→ COPY RELATIONSHIPS
→ SEPARATE
```

---

## Pattern U — Doubly Linked List

### Purpose

Master:

```text
prev
data
next
```

and keep both directions consistent.

### Recognition

```text
Previous Pointer
Bidirectional
Back / Forward
Doubly Linked List
```

↓

Think:

> **Two-Way Pointer Maintenance**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 90 | Insert in Doubly Linked List | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Prev/Next |
| 91 | Delete in Doubly Linked List | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Prev/Next |
| 92 | Reverse Doubly Linked List | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reverse |
| 93 | Design Browser History | LeetCode 1472 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL Application |

### Pattern memory

```text
CHANGE NEXT
→ FIX PREV
→ CHECK HEAD / TAIL
```

---

## Pattern V — Circular Linked List

### Purpose

Work with lists where the end reconnects to the beginning.

### Recognition

```text
Circular
Wrap Around
Last → First
Round Robin
```

↓

Think:

> **Circular Boundary**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 94 | Insert into Circular Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 95 | Delete from Circular Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 96 | Split Circular Linked List into Two Halves | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Slow/Fast |
| 97 | Circular Tour | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Application |

### Pattern memory

```text
DO NOT WAIT FOR NULL
→ STOP AT START
```

---

## Pattern W — Multi-Level Linked List

### Purpose

Handle child pointers and hierarchical linked structures.

### Recognition

```text
Child
Flatten
Multi-Level
Nested
```

↓

Think:

> **Hierarchical Pointer Structure**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 98 | Flatten a Multilevel Doubly Linked List | LeetCode 430 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DFS / Rewire |
| 99 | Flatten a Linked List | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Merge |
| 100 | Flatten Linked List — Recursive & Iterative | Custom | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Compare |

### Pattern memory

```text
SAVE NEXT
→ EXPLORE CHILD
→ CONNECT
→ RESTORE NEXT
```

---

# 6. Section D — Design / Cache / Company Favorites

## Pattern X — Design Problems

### Purpose

Build the data structure instead of solving one isolated operation.

### Core idea

```text
STATE
→ INVARIANTS
→ API
→ IMPLEMENT
→ TEST
```

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 101 | Design Linked List | LeetCode 707 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | API |
| 102 | Design Singly Linked List | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | API |
| 103 | Design Doubly Linked List | Custom | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | API |
| 104 | Implement Browser History | LeetCode 1472 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL |
| 105 | Design Circular Linked List | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |

---

## Pattern Y — Cache Design

### Purpose

Use a Linked List together with another data structure.

### Core idea

```text
HASH MAP
+
DOUBLY LINKED LIST
↓
FAST LOOKUP
+
FAST REORDER
```

### Recognition

```text
LRU
LFU
Cache
Eviction
O(1) get / put
```

↓

Think:

> **HashMap + Doubly Linked List**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 106 | LRU Cache | LeetCode 146 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | HashMap + DLL |
| 107 | LFU Cache | LeetCode 460 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Composite |
| 108 | Design LRU Cache from Scratch | Custom | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 109 | All O`one Data Structure | LeetCode 432 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Composite |

---

## Pattern Z — Advanced Company / Capstone

### Purpose

Finish by combining several known structures and patterns.

### Recognition

Do not search for one keyword.

Look for combinations:

```text
Complex pointer updates
Multiple lists
Design + algorithms
Linked structure + other DS
```

↓

Think:

> **Pattern Composition**

### Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 110 | Skip List — Concept + Operations | Concept | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Multi-level |
| 111 | Skiplist | LeetCode 1206 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Multi-level |
| 112 | Design Memory Allocator | LeetCode 2502 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Linked Blocks |
| 113 | Text Editor | LeetCode 2296 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Doubly List |
| 114 | Design Front Middle Back Queue | LeetCode 1670 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL / Deque |
| 115 | Linked List Pattern Revision Challenge | Custom | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Capstone |

---

# 7. Part 2 Pattern Recognition

```text
Cycle Entry
→ Floyd + reset

Partial / Group Reverse
→ boundary + prev/current/next + reconnect

Partition
→ multiple chains + reconnect

Merge K
→ heap OR divide-and-conquer

Sort
→ middle + split + merge

Random Pointer
→ HashMap OR interleaving

Multilevel
→ save next + flatten child + reconnect

Doubly
→ update prev + next together

Circular
→ stop at starting node

Design
→ state + invariants + API

LRU
→ HashMap + Doubly Linked List

Skip List
→ multi-level next pointers + probabilistic levels

Capstone
→ decompose into known patterns
```

---

# 8. Random Problem Drill

For every unseen Part 2 problem:

```text
1. What structure is being used?
2. Which Part 1 pattern is hidden inside?
3. What is NEW here?
4. What pointers are required?
5. Is a dummy / sentinel useful?
6. What reference can be lost?
7. What invariant must remain true?
8. What boundary cases matter?
9. What is the expected complexity?
```

Write:

```text
KNOWN PATTERN:
NEW IDEA:
POINTERS:
STATE:
BOUNDARY:
RECONNECT:
COMPLEXITY:
```

Then code.

---

# 9. Part 2 Mastery Ladder

```text
Level 1
Understand pattern

Level 2
Trace pointer state

Level 3
Implement with hints

Level 4
Implement independently

Level 5
Solve a variation

Level 6
Combine patterns

Level 7
Recognize from unseen statement

Level 8
Explain + defend in interview
```

---

# 10. Final Linked List Roadmap

```text
PART 1 — 65 Problems
│
├── Foundation
├── Core Operations
├── Dummy
├── Two Pointers
├── Fast / Slow
├── Fixed Gap
├── Reverse
├── Cycle
├── Merge / Intersection
└── Classic Interview Integration
        ↓
PART 2 — 50 Problems
│
├── Advanced Reversal / Partition
├── Multi-List
├── Sorting
├── Random Pointer
├── Multilevel
├── Doubly
├── Circular
├── Design
├── Cache
└── Company / Capstone
        ↓
TOTAL = 115 PROBLEMS
```

---

# 11. Final Completion Gate

Linked List is complete when:

```text
[ ] I can implement common Singly Linked List operations from memory.
[ ] I can recognize the major pointer patterns quickly.
[ ] I can solve random Part 1 problems without seeing the pattern name.
[ ] I can handle advanced Part 2 pointer combinations.
[ ] I can work with Doubly Linked Lists.
[ ] I can work with Circular Linked Lists.
[ ] I can clone Random Pointer Lists.
[ ] I can flatten Multilevel Lists.
[ ] I understand Merge K and Linked List Sorting.
[ ] I can design a Linked List API.
[ ] I can implement / explain LRU and understand LFU.
[ ] I understand Skip Lists at interview level.
[ ] I can decompose an unfamiliar Linked List problem into known patterns.
[ ] I can explain pointer changes and complexity clearly.
```

## Final Goal

```text
UNSEEN PROBLEM
      ↓
IDENTIFY STRUCTURE
      ↓
RECOGNIZE PATTERN
      ↓
IDENTIFY NEW TWIST
      ↓
DESIGN POINTER STATE
      ↓
PROTECT REFERENCES
      ↓
REWIRE
      ↓
VERIFY INVARIANTS
      ↓
CODE
      ↓
DRY RUN
      ↓
COMPLEXITY
```

> **After Part 1 + Part 2, close Linked List.**
> Do not create another beginner Linked List roadmap. Revisit these 115 problems by pattern and mixed practice when needed.
