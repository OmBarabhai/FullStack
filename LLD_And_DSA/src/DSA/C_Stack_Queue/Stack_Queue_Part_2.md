# B — Stack + Queue — Part 2
## Advanced Monotonic Stack • Deque • Sliding Window • Design • BFS Integration • Capstone

> **Goal:** Finish Stack + Queue at an interview-ready level without restarting Part 1.
>
> Part 2 assumes the Part 1 patterns are already comfortable.
>
> **Part 2 = 60 problems.**
>
> The progression is:
>
> ```text
> Advanced Monotonic Stack
> → Histogram / Rectangle
> → Binary Matrix
> → Monotonic Deque
> → Sliding Window Maximum
> → Design Structures
> → Cache / Frequency Structures
> → Queue in BFS
> → Multi-Source BFS
> → Hard Interview Integration
> ```

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain invariant + dry run |
| R1 | 2–3 days | Rebuild the pointer/index state from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only where needed |

**Revision rule:** do not repeat every problem equally. Repeat weak patterns.

---

# 2. Part 2 Roadmap

| Section | Focus | Problems |
|---|---|---:|
| A | Advanced Monotonic Stack | 12 |
| B | Histogram / Rectangle / Matrix | 10 |
| C | Monotonic Deque / Sliding Window | 10 |
| D | Design / Special Structures | 10 |
| E | Queue + BFS Integration | 10 |
| F | Hard Interview Integration | 8 |
| **Total** | | **60** |

---

# 3. Section A — Advanced Monotonic Stack

## Pattern H — Monotonic Stack State

### Purpose

Turn repeated “find the next/previous greater or smaller item” work into linear-time processing.

### Core pattern

```text
scan
→ pop elements whose answer is now known
→ assign answer
→ push current
```

### Recognition

```text
nearest
next
previous
first greater
first smaller
span
distance to greater/smaller
```

↓

Think:

> **Each element enters and leaves the stack once.**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 61 | Daily Temperatures | LeetCode 739 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NGE |
| 62 | Next Greater Element II | LeetCode 503 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular NGE |
| 63 | Next Greater Node in Linked List | LeetCode 1019 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | LL + Stack |
| 64 | Stock Span | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PGE |
| 65 | Online Stock Span | LeetCode 901 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Streaming |
| 66 | Final Prices With Special Discount | LeetCode 1475 | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NSE |
| 67 | Sum of Subarray Minimums | LeetCode 907 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundaries |
| 68 | Sum of Subarray Ranges | LeetCode 2104 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Min + Max |
| 69 | Number of Visible People in a Queue | LeetCode 1944 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Visibility |
| 70 | Remove Nodes From Linked List | LeetCode 2487 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 71 | Most Competitive Subsequence | LeetCode 1673 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy Stack |
| 72 | Remove K Digits | LeetCode 402 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy Stack |

### Pattern memory

```text
CURRENT can make previous elements obsolete
→ POP them
→ CURRENT becomes their answer / replacement
```

---

# 4. Section B — Histogram / Rectangle / Matrix ⭐

## Pattern I — Boundary Expansion

### Core idea

```text
For each bar:
find first smaller on left
find first smaller on right
```

Then:

```text
width
×
height
```

## Recognition

```text
histogram
largest rectangle
maximum area
binary matrix rectangle
first smaller on both sides
```

↓

Think:

> **Nearest Smaller + Width**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 73 | Largest Rectangle in Histogram | LeetCode 84 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 74 | Largest Rectangle in Histogram — Two Pass | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | L/R Boundaries |
| 75 | Largest Rectangle — Single Stack Pass | Interview | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | One Pass |
| 76 | Maximal Rectangle | LeetCode 85 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix + Histogram |
| 77 | Maximum Area of Rectangle of 1s | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix |
| 78 | Largest Rectangle in Binary Matrix — Row Histogram | Custom | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 79 | Maximal Square | LeetCode 221 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix Comparison |
| 80 | Trapping Rain Water | LeetCode 42 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundary |
| 81 | Container With Most Water | LeetCode 11 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Pointer |
| 82 | Asteroid Collision | LeetCode 735 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |

### Pattern memory

```text
HISTOGRAM
→ nearest smaller left
→ nearest smaller right
→ width = right - left - 1
→ area = height × width
```

---

# 5. Section C — Monotonic Deque / Sliding Window

## Pattern J — Monotonic Deque

### Purpose

Maintain the best candidate for a moving window.

### Core idea

```text
window moves right
→ remove expired indices from front
→ remove weaker candidates from back
→ front = best answer
```

### Recognition

```text
sliding window
maximum in every window
minimum in every window
fixed K
stream / moving range
```

↓

Think:

> **Deque = front expiry + back dominance**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 83 | Sliding Window Maximum | LeetCode 239 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic Deque |
| 84 | Sliding Window Minimum | GFG | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic Deque |
| 85 | Sliding Window Maximum — Index Deque | Interview | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Index State |
| 86 | First Negative Number in Every Window | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Queue |
| 87 | Sum of Minimums in Sliding Windows | Custom | 🔴 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque |
| 88 | Longest Continuous Subarray With Absolute Diff ≤ Limit | LeetCode 1438 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Deques |
| 89 | Shortest Subarray With Sum at Least K | LeetCode 862 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Prefix + Deque |
| 90 | Constrained Subsequence Sum | LeetCode 1425 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DP + Deque |
| 91 | Jump Game VI | LeetCode 1696 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DP + Deque |
| 92 | Maximum Value of Equation | LeetCode 1499 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque Optimization |

### Pattern memory

```text
Need max/min in every moving window?
→ MONOTONIC DEQUE
```

---

# 6. Section D — Design / Special Structures

## Pattern K — Design

### Core idea

```text
STATE
→ INVARIANTS
→ API
→ operation complexity
→ edge cases
```

The goal is not just to solve one function. The goal is to maintain a data-structure invariant after every operation.

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 93 | Min Stack | LeetCode 155 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Auxiliary State |
| 94 | Max Stack | LeetCode 716 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 95 | Implement Stack With O(1) Min | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Encoding/Stack |
| 96 | N Stacks in an Array | Interview/GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Shared Storage |
| 97 | N Queues in an Array | Custom | 🔴 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Shared Storage |
| 98 | Design Circular Deque | LeetCode 641 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque |
| 99 | Design a Blocking/Bounded Queue | Interview | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 100 | Implement Queue With Dynamic Array | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Resizing |
| 101 | Design Queue Using Two Stacks — Amortized O(1) | Interview | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Amortized |
| 102 | Design Stack Using One Queue | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rotation |

### Pattern memory

```text
special operation
→ store extra information
→ maintain invariant on push/pop
```

For Min Stack:

```text
top value
+
minimum-so-far
```

---

# 7. Section E — Queue + BFS Integration

## Pattern L — Queue as Traversal State

### Purpose

Queue becomes much more important once graphs and trees arrive.

### Core idea

```text
START
→ enqueue

while queue not empty:
    remove front
    process
    add newly discovered states
```

### Recognition

```text
level order
minimum number of steps
shortest path in unweighted graph
multi-source spread
time by levels
nearest source
```

↓

Think:

> **BFS = Queue + Visited/State**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 103 | Binary Tree Level Order Traversal | LeetCode 102 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS |
| 104 | Binary Tree Zigzag Level Order | LeetCode 103 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS + Direction |
| 105 | Rotting Oranges | LeetCode 994 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Multi-Source BFS |
| 106 | Flood Fill | LeetCode 733 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS/DFS |
| 107 | Number of Islands — BFS Version | LeetCode 200 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS Grid |
| 108 | Shortest Path in Binary Matrix | LeetCode 1091 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS Shortest |
| 109 | 01 Matrix | LeetCode 542 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Multi-Source |
| 110 | Walls and Gates | Interview | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Multi-Source |
| 111 | Word Ladder | LeetCode 127 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS State |
| 112 | Open the Lock | LeetCode 752 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | BFS State |

### Pattern memory

```text
minimum steps in an unweighted graph
→ BFS
→ Queue
```

For multi-source BFS:

```text
put ALL sources in queue first
→ process level by level
```

---

# 8. Section F — Hard Interview Integration

## Pattern M — Mixed Recognition

These are not “pure Stack” or “pure Queue” problems. Their purpose is to force you to recognize which pattern is hiding underneath the problem.

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 113 | Trapping Rain Water | LeetCode 42 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack / Two Pointer |
| 114 | Basic Calculator | LeetCode 224 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack + Expression |
| 115 | Basic Calculator II | LeetCode 227 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack + Expression |
| 116 | Longest Valid Parentheses | LeetCode 32 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack |
| 117 | Asteroid Collision | LeetCode 735 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 118 | Remove K Digits | LeetCode 402 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy Stack |
| 119 | LRU Cache | LeetCode 146 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL + HashMap |
| 120 | LFU Cache | LeetCode 460 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |

---

# 9. Master Pattern Recognition

When you see:

```text
LIFO
→ STACK
```

```text
FIFO
→ QUEUE
```

```text
Nested / matching
→ STACK
```

```text
Next greater / smaller
→ MONOTONIC STACK
```

```text
Histogram / rectangle
→ MONOTONIC STACK
```

```text
Maximum / minimum in each fixed window
→ MONOTONIC DEQUE
```

```text
Minimum steps / shortest path in unweighted graph
→ BFS + QUEUE
```

```text
Multiple starting points spreading simultaneously
→ MULTI-SOURCE BFS
```

```text
Special O(1) operation
→ DESIGN AUXILIARY STATE
```

```text
LRU
→ HASHMAP + DOUBLY LINKED LIST
```

---

# 10. Final Stack + Queue Mastery Test

You should be able to solve these from memory:

### Stack

- [ ] Implement Stack
- [ ] Reverse Stack recursively
- [ ] Sort Stack recursively
- [ ] Valid Parentheses
- [ ] Redundant Brackets
- [ ] Infix → Postfix
- [ ] Postfix Evaluation
- [ ] Min Stack
- [ ] Next Greater Element
- [ ] Next Smaller Element
- [ ] Stock Span
- [ ] Daily Temperatures
- [ ] Largest Rectangle in Histogram
- [ ] Maximal Rectangle
- [ ] Sum of Subarray Minimums
- [ ] Remove K Digits
- [ ] Longest Valid Parentheses

### Queue / Deque

- [ ] Implement Queue
- [ ] Circular Queue
- [ ] Deque
- [ ] Reverse Queue
- [ ] Queue using 2 Stacks
- [ ] Stack using 2 Queues
- [ ] Sliding Window Maximum
- [ ] Sliding Window Minimum
- [ ] First Negative in Every Window
- [ ] Shortest Subarray ≥ K

### BFS

- [ ] Level Order Traversal
- [ ] Rotting Oranges
- [ ] Number of Islands
- [ ] Shortest Path in Binary Matrix
- [ ] 01 Matrix
- [ ] Word Ladder
- [ ] Open the Lock

---

# 11. Suggested Completion Order

```text
PART 1
↓
Stack Basics
↓
Stack Manipulation
↓
Parentheses / Expressions
↓
Queue Basics
↓
Circular Queue / Deque
↓
Stack ↔ Queue Conversion
↓
Monotonic Stack Basics
↓
PART 2
↓
Advanced Monotonic Stack
↓
Histogram
↓
Binary Matrix
↓
Monotonic Deque
↓
Sliding Window
↓
Design
↓
BFS
↓
Hard Integration
```

> **End Goal:** Do not memorize 120 solutions. Learn to identify the underlying **Stack, Queue, Monotonic Stack, Monotonic Deque, or BFS state pattern** first.
