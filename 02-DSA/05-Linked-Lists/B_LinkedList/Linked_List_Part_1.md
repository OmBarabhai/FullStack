# 🚀 Linked List Master Progress Tracker (Part 1)

> Goal: Build a rock-solid Singly Linked List foundation, master pointer patterns, and create a clean bridge toward Trees and Graphs.
>
> Covers Problems 1–65.
>
> The learning order is dependency-based: each pattern is introduced only after the required pointer/reference concept is understood.

---

# Legend

| Symbol | Meaning |
|---|---|
| ⬜ | Not Started |
| 🟨 | In Progress |
| ✅ | Completed |
| 🔄 | Needs Revision |

---

# Difficulty

🟢 Easy

🟡 Medium

🔴 Hard

---

# Interview Frequency

⭐⭐⭐⭐⭐ Very Frequently Asked

⭐⭐⭐⭐ Frequently Asked

⭐⭐⭐ Moderate

⭐⭐ Rare

⭐ Very Rare

---

# Revision Schedule

| Revision | When | What to do |
|---|---|---|
| R0 | Same Day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild pointer state from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only where weak |

> Revision rule: strong problems rest, medium problems get another recall, weak problems repeat.

---

# Part 1 Roadmap

```text
Pattern A
Node + References + Traversal
        ↓
Pattern B
Core Operations
        ↓
Pattern C
Dummy Node
        ↓
Pattern D
Two Pointers / Fast-Slow / Gap
        ↓
Pattern E
Reversal
        ↓
Pattern F
Cycle Detection
        ↓
Pattern G
Merge / Intersection / Integration
        ↓
Pattern H
Circular Linked List
```

---

# Pattern A — Node, References & Traversal

**Problems 1–14**

## Purpose

Build the memory model and traversal language before changing links.

## Core Memory

```text
Node
├── data
└── next → Node / null
```

```text
new Node(...)
→ creates a new object

Node b = a
→ copies a reference

a = a.next
→ moves a reference
```

```text
head → first Node
tail → last Node
size → number of Nodes
```

## Empty State

```text
head = null
tail = null
size = 0
```

## One Node

```text
head == tail
head.next == null
```

## Traversal Pattern

```text
START AT HEAD
→ CHECK CURRENT
→ MOVE NEXT
→ STOP AT NULL
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 1 | Design Node Class | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 2 | Build Singly Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 3 | Build List from Array | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 4 | Convert Array to Linked List | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 5 | Traverse Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 6 | Print Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 7 | Length of Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 8 | Count Nodes Iteratively | Custom | 🟢 | ⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 9 | Search in Linked List | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 10 | Search in Sorted Linked List | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 11 | Count Occurrences | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 12 | Search Recursively | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 13 | Count Nodes Recursively | GFG | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 14 | Print in Reverse Recursively | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern B — Core Operations

**Problems 15–27**

## Purpose

Learn how to change the linked structure safely.

## 1-Based Position Rules

```text
INSERT
→ valid positions: 1 ... size + 1

UPDATE / DELETE
→ valid positions: 1 ... size
```

## Core Patterns

### Insert at Head

```text
new.next = head
head = new
```

### Insert at Tail

```text
tail.next = new
tail = new
```

### Insert at Position

```text
find previous
→ new.next = previous.next
→ previous.next = new
```

### Delete Head

```text
head = head.next
```

### Delete Tail

```text
find previous tail
→ previous.next = null
→ tail = previous
```

### Delete Position

```text
previous.next = target.next
```

### Delete Value

```text
find target
→ bypass target
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 15 | Insert at Head | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 16 | Delete Head Node | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 17 | Insert at Tail | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 18 | Delete Tail Node | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 19 | Insert at Position | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 20 | Insert After Given Node | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 21 | Insert Before Given Node | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 22 | Sorted Insert | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 23 | Delete Node at Position | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 24 | Delete Node by Key | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ✅ | ⬜ | ⬜ | ⬜ | DONE |
| 25 | Delete Node Given Only Node | LeetCode 237 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 26 | Remove Linked List Elements | LeetCode 203 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 27 | Delete Entire Linked List | GFG | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern C — Dummy Node

**Problems 28–30**

## Purpose

Learn sentinel-based pointer manipulation after normal head handling is comfortable.

## Core Idea

```text
dummy
  ↓
head
  ↓
node
  ↓
node
  ↓
null
```

```text
dummy stays before real head
→ head changes become easier to handle
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 28 | Delete Head Using Dummy | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 29 | Merge Two Lists with Dummy | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 30 | Remove Linked List Elements | LeetCode 203 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern D — Two Pointers / Fast-Slow / Gap

**Problems 31–42**

## Purpose

Build relative-pointer reasoning and one-pass state management.

## Middle

```text
slow → 1 step
fast → 2 steps
```

## Fixed Gap

```text
move first pointer k steps
→ move both together
→ maintain fixed distance
```

## Recognition

```text
middle
kth from end
nth from end
one pass
two pointers
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 31 | Middle Using Two Pointers | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 32 | Middle of Linked List | LeetCode 876 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 33 | First Middle Node | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 34 | Second Middle Node | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 35 | Split List into Two Halves | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 36 | Kth Node from End | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 37 | Nth Node from End | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 38 | One-Pass Pointer Distance | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 39 | Kth Node from End One Pass | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 40 | Remove Nth Node From End | LeetCode 19 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 41 | Kth Node from Beginning | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 42 | One-Pass Distance Variation | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern E — Reversal

**Problems 43–46**

## Purpose

Master `prev / current / next` and safe pointer rewiring.

## Core State

```text
prev
current
next
```

## Small Algorithm

```text
SAVE NEXT
→ CHANGE CURRENT.NEXT
→ MOVE PREV
→ MOVE CURRENT
```

## Recognition

```text
reverse
reverse recursively
reverse section
reverse first k
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 43 | Reverse Linked List | LeetCode 206 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 44 | Reverse Linked List Recursively | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 45 | Reverse Linked List II | LeetCode 92 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 46 | Reverse First K Nodes | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern F — Cycle Detection

**Problems 47–50**

## Purpose

Learn structures where traversal does not naturally end at `null`.

## Detection

```text
slow → 1 step
fast → 2 steps
```

```text
slow == fast
→ cycle exists
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 47 | Linked List Cycle | LeetCode 141 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 48 | Detect Loop in Linked List | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 49 | Count Nodes in Loop | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 50 | Remove Loop | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern G — Merge / Intersection / Integration

**Problems 51–61**

## Purpose

Combine multiple pointer patterns into interview-level problems.

## Merge

```text
dummy
→ compare
→ attach
→ advance
```

## Intersection

```text
A reaches end
→ switch to B

B reaches end
→ switch to A

pointers synchronize
```

## Palindrome

```text
middle
→ reverse second half
→ compare
```

## Reorder

```text
middle
→ reverse second half
→ merge alternately
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 51 | Merge Two Sorted Lists | LeetCode 21 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 52 | Merge Two Lists with Dummy | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 53 | Intersection of Two Lists | LeetCode 160 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 54 | Y-Shaped List Intersection | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 55 | Palindrome Linked List | LeetCode 234 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 56 | Swap Nodes in Pairs | LeetCode 24 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 57 | Odd Even Linked List | LeetCode 328 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 58 | Rotate List | LeetCode 61 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 59 | Reorder List | LeetCode 143 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 60 | Remove Nth Node — Integration | LeetCode 19 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 61 | Add Two Numbers | LeetCode 2 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Pattern H — Circular Linked List

**Problems 62–65**

## Purpose

Only introduce circular structure after normal Singly Linked List pointer reasoning is strong.

## Mental Model

Normal:

```text
10 → 20 → 30 → null
```

Circular:

```text
10 → 20 → 30
↑         ↓
└─────────┘
```

## Core Rule

```text
DO NOT WAIT FOR NULL
→ STOP AT THE STARTING NODE
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Notes |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 62 | Traverse Circular Linked List | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 63 | Insert into Circular Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 64 | Delete from Circular Linked List | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |
| 65 | Circular List Integration | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | |

---

# Part 1 Pattern Recognition

| See this | Think this |
|---|---|
| Traverse | `current = current.next` |
| Search | CHECK → MOVE |
| Insert | CREATE → CONNECT → RECONNECT |
| Delete | FIND → BYPASS → DISCONNECT |
| Update | FIND EXISTING NODE → CHANGE DATA |
| Dummy | Simplify head changes |
| Middle | Slow / Fast |
| Kth / Nth from end | Fixed gap |
| Reverse | Prev / Current / Next |
| Cycle | Floyd |
| Merge | Dummy + compare + attach |
| Intersection | Synchronize paths |
| Palindrome | Middle + Reverse + Compare |
| Reorder | Middle + Reverse + Merge |
| Swap | Local rewiring |
| Odd / Even | Separate chains + connect |
| Rotate | Length + connect + break |
| Circular | Stop at start |

---

# Pointer State Checklist

Before coding:

```text
CURRENT:
What Node am I standing on?

PREVIOUS:
Do I need the Node before current?

NEXT:
Will changing a link make me lose the rest?

HEAD:
Can the first Node change?

TAIL:
Can the last Node change?

SIZE:
Does the number of Nodes change?
```

---

# Boundary Checklist

Before coding:

```text
[ ] Empty list
[ ] One Node
[ ] Two Nodes
[ ] Head
[ ] Tail
[ ] Middle
[ ] Invalid position
[ ] Duplicate values
[ ] Target not found
```

---

# Main Weakness Tracker

Pay extra attention to these recurring mistakes:

```text
1. Reference vs new Node
2. Position vs index
3. Finding the previous Node
4. Knowing where a pointer must stop
5. CHECK → MOVE order
6. INSERT vs UPDATE vs DELETE
7. head / tail / size consistency
8. Empty-list handling
9. One-node handling
10. Tail/head boundary handling
11. Preserving references before rewiring
12. Updating BOTH directions in DLL later
```

---

# Dry-Run Template

For every pointer problem:

```text
PATTERN:
POINTERS:
START:
TARGET:
BOUNDARY:
STATE CHANGE:
RECONNECT:
HEAD AFTER:
TAIL AFTER:
SIZE AFTER:
TIME:
SPACE:
```

Then code.

---

# Graph Connection

Linked List is mainly useful for:

```text
Reference / Pointer Thinking
↓
Two Pointer Thinking
↓
Cycle / State Reasoning
↓
Trees
↓
Graphs
```

The transferable mental model is:

```text
CURRENT STATE
↓
WHAT CAN I REACH?
↓
HOW DO I MOVE?
↓
WHAT STATE MUST I PRESERVE?
↓
WHEN DO I STOP?
```

Structural analogy:

```text
Linked List:
current → next

Tree:
current → left / right

Graph:
current → neighbors
```

Recursion remains the stronger direct foundation for:

```text
Backtracking
Trees
DFS
Divide & Conquer
Dynamic Programming
```

---

# Part 1 Completion Gate

Do not mark Part 1 complete only because all 65 problems are solved.

You should be able to:

```text
[ ] Implement Singly Linked List from memory
[ ] Explain Node references
[ ] Explain head / tail / size
[ ] Handle empty and one-node cases
[ ] Traverse without hesitation
[ ] Search without notes
[ ] Insert without memorizing
[ ] Delete without memorizing
[ ] Recognize dummy-node situations
[ ] Solve middle-node problems
[ ] Solve kth/nth-from-end problems
[ ] Reverse iteratively
[ ] Reverse recursively
[ ] Detect cycles
[ ] Remove cycles
[ ] Merge lists
[ ] Find intersections
[ ] Solve palindrome
[ ] Reorder / swap / odd-even
[ ] Rotate
[ ] Handle circular lists
[ ] Recognize patterns in unseen statements
```

Final goal:

```text
UNSEEN PROBLEM
↓
IDENTIFY STRUCTURE
↓
RECOGNIZE PATTERN
↓
CHOOSE POINTERS
↓
CHECK BOUNDARIES
↓
PROTECT REFERENCES
↓
REWIRE
↓
VERIFY
↓
DRY RUN
↓
COMPLEXITY
```

---

# Final Part 1 Map

```text
01–14  → Node / References / Traversal
15–27  → Core Operations
28–30  → Dummy Node
31–42  → Two Pointers / Fast-Slow / Gap
43–46  → Reversal
47–50  → Cycle Detection
51–61  → Merge / Intersection / Integration
62–65  → Circular Linked List

TOTAL = 65 PROBLEMS
```

---

# After Part 1

Do not restart beginner Linked List material.

Use:

```text
Linked List Part 1
        ↓
Stack
        ↓
Queue
        ↓
Trees
        ↓
Graphs
```

Return later for:

```text
Advanced Linked List
↓
Doubly Linked List
↓
Circular Doubly Linked List
↓
Random Pointer
↓
Multilevel Linked List
↓
LRU / Cache
↓
Advanced Linked List Integration
```

> **Part 1 = complete core Singly Linked List pattern language.**
>
> Finish it systematically before adding more Linked List variants.
