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
