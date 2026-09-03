# C — Stack — Part 2
## Monotonic Stack • Histogram • Matrix • Greedy Stack • Advanced Design • Hard Interview Problems

> **Goal:** Master the advanced Stack patterns that repeatedly appear in interviews.
>
> Part 2 assumes Part 1 is complete.
>
> **Part 2 = 60 problems.**

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain invariant + dry run |
| R1 | 2–3 days | Rebuild the state from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only if weak |

---

# 2. Part 2 Pattern Map

```text
A — Monotonic Stack
    next greater
    next smaller
    previous greater
    previous smaller
    span

B — Boundary / Histogram
    nearest smaller
    left boundary
    right boundary
    largest rectangle

C — Matrix + Stack
    histogram rows
    maximal rectangle
    binary matrix

D — Greedy Stack
    remove digits
    lexicographic minimization
    most competitive subsequence

E — Advanced Expression / Simulation
    longest valid parentheses
    calculator
    nested state

F — Special Stack Design
    min stack
    max stack
    N stacks
    constant-time extra operations

G — Hard Integration
    subarray minimums
    subarray ranges
    constrained stack problems
```

---

# 3. Pattern A — Monotonic Stack ⭐

## Purpose

Solve problems asking for the nearest element that is greater or smaller.

## Recognition

```text
Next Greater
Next Smaller
Previous Greater
Previous Smaller
Nearest Greater
Nearest Smaller
Span
```

↓

Think:

> **MONOTONIC STACK**

## Core pattern

```text
for each current element:

    while stack is not empty
    AND current makes stack.top() useless:
        pop

    answer for popped item = current
    push current
```

The exact comparison determines whether the stack is increasing or decreasing.

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|:---:|---|
| 51 | Next Greater Element I | LeetCode 496 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NGE |
| 52 | Next Greater Element II | LeetCode 503 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular NGE |
| 53 | Next Smaller Element | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NSE |
| 54 | Previous Greater Element | GFG/Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PGE |
| 55 | Previous Smaller Element | GFG/Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PSE |
| 56 | Nearest Greater to Left | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PGE |
| 57 | Nearest Smaller to Left | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PSE |
| 58 | Nearest Greater to Right | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NGE |
| 59 | Nearest Smaller to Right | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NSE |
| 60 | Daily Temperatures | LeetCode 739 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | NGE |
| 61 | Stock Span | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | PGE |
| 62 | Online Stock Span | LeetCode 901 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Span |

### Pattern memory

```text
“nearest greater/smaller”
→ monotonic stack
```

---

# 4. Pattern B — Boundary / Histogram ⭐

## Core idea

For every bar:

```text
left smaller
+
right smaller
```

Then calculate:

```text
width = right - left - 1

area = height × width
```

## Recognition

```text
histogram
largest rectangle
maximum area
rectangle using consecutive elements
```

↓

Think:

> **Nearest Smaller + Width**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|---:|---|
| 63 | Largest Rectangle in Histogram | LeetCode 84 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 64 | Largest Rectangle in Histogram — Two Pass | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundaries |
| 65 | Largest Rectangle — One Pass Stack | Interview | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | One Pass |
| 66 | Largest Rectangle With Equal Heights | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 67 | Maximum Rectangle Area From Bars | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 68 | Sum of Subarray Minimums | LeetCode 907 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundaries |
| 69 | Sum of Subarray Ranges | LeetCode 2104 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Min/Max |
| 70 | Find the Sum of Subarray Minimums — Contribution | Interview | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Contribution |
| 71 | Maximum Width Ramp | LeetCode 962 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Decreasing Stack |
| 72 | Remove Nodes From Linked List | LeetCode 2487 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |

---

# 5. Pattern C — Matrix + Stack

## Core idea

Convert each row of a binary matrix into a histogram.

```text
row 1 → heights
row 2 → update heights
row 3 → update heights
...
```

For each row:

```text
largest rectangle in histogram
```

## Recognition

```text
matrix of 0/1
largest rectangle
maximum area
consecutive ones
```

↓

Think:

> **Matrix → Histogram → Monotonic Stack**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|---:|---|
| 73 | Maximal Rectangle | LeetCode 85 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix + Histogram |
| 74 | Maximum Rectangle of 1s | GFG | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix |
| 75 | Binary Matrix Largest Rectangle | Custom | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 76 | Row-wise Histogram Construction | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 77 | Largest Square of 1s | GFG / LeetCode 221 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Comparison |
| 78 | Largest Plus / Cross of 1s | Interview | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix State |
| 79 | Count All-1 Rectangles | LeetCode 1504 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix |
| 80 | Count Submatrices With All Ones | GFG | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Histogram |
| 81 | Maximum Binary Rectangle With Constraints | Interview | 🔴 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matrix |
| 82 | Maximal Rectangle — Optimized Row Processing | Custom | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Optimization |

---

# 6. Pattern D — Greedy Stack

## Purpose

Use the stack to keep the best possible prefix while removing elements that make the result worse.

## Recognition

```text
remove K elements
smallest number
lexicographically smallest
most competitive
keep best subsequence
current element makes previous choice worse
```

↓

Think:

> **Greedy + Monotonic Stack**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 83 | Remove K Digits | LeetCode 402 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy |
| 84 | Most Competitive Subsequence | LeetCode 1673 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy |
| 85 | Create Maximum Number | LeetCode 321 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy Stack |
| 86 | Remove Duplicate Letters | LeetCode 316 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy |
| 87 | Smallest Subsequence of Distinct Characters | LeetCode 1081 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy |
| 88 | Final Prices With Special Discount | LeetCode 1475 | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 89 | Make Array Zero by Subtracting Equal Amounts | Interview | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack Insight |
| 90 | Build Array With Stack Operations | LeetCode 1441 | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 91 | Build an Array With Permitted Operations | Custom | 🟢 | ⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 92 | Stack-Based Lexicographic Selection | Interview | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy |

### Pattern memory

```text
current is better than previous
+
previous can be safely removed
→ POP
```

---

# 7. Pattern E — Advanced Expression / Simulation

## Recognition

```text
nested expression
multiple operators
most recent unresolved state
matching + index
collision / elimination
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|:---:|:---:|---|
| 93 | Longest Valid Parentheses | LeetCode 32 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack Index |
| 94 | Basic Calculator | LeetCode 224 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |
| 95 | Basic Calculator II | LeetCode 227 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |
| 96 | Basic Calculator III | LeetCode 772 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Nested Expression |
| 97 | Decode String | LeetCode 394 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Nested Stack |
| 98 | Asteroid Collision | LeetCode 735 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 99 | Verify Preorder Serialization of Binary Tree | LeetCode 331 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 100 | Remove Invalid Parentheses — Stack Thinking | Interview | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Constraint |

---

# 8. Pattern F — Special Stack Design

## Core idea

Normal stack gives:

```text
push
pop
top
```

But the problem asks for another operation in O(1).

Therefore:

```text
store extra state
→ maintain invariant
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|:---:|:---:|---|
| 101 | Min Stack | LeetCode 155 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Auxiliary State |
| 102 | Min Stack Using One Stack | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Encoding |
| 103 | Max Stack | LeetCode 716 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 104 | N Stacks in an Array | GFG/Interview | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Shared Storage |
| 105 | Two Stacks in One Array | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Shared Storage |
| 106 | Stack With Get Minimum in O(1) | Interview | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Invariant |
| 107 | Stack With Get Maximum in O(1) | Interview | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Invariant |
| 108 | Design Stack With Middle Operation | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | DLL/Stack |
| 109 | Delete Middle in O(1) Design | Interview | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |
| 110 | Stack With O(1) Middle Element | Interview | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |

### Pattern memory

```text
Question asks:
"Can I get X in O(1)?"

→ maintain X while pushing/popping
```

---

# 9. Pattern G — Hard Integration

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|:---:|:---:|---|
| 111 | Sum of Subarray Minimums | LeetCode 907 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Contribution |
| 112 | Sum of Subarray Ranges | LeetCode 2104 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Contribution |
| 113 | Trapping Rain Water | LeetCode 42 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack / Boundary |
| 114 | Number of Visible People in a Queue | LeetCode 1944 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Visibility |
| 115 | Car Fleet | LeetCode 853 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic Reasoning |
| 116 | Maximum Width Ramp | LeetCode 962 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Decreasing Stack |
| 117 | Valid Subarray Size | LeetCode 2334 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundaries |
| 118 | Maximum Subarray Min-Product | LeetCode 1856 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 119 | Steps to Make Array Non-Decreasing | LeetCode 2289 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 120 | Sum of Total Strength of Wizards | LeetCode 2281 | 🔴 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Advanced Contribution |

---

# 10. Part 2 Recognition Sheet

```text
nearest greater / smaller
→ MONOTONIC STACK
```

```text
histogram
→ NEAREST SMALLER
→ WIDTH
→ AREA
```

```text
binary matrix + largest rectangle
→ HISTOGRAM EACH ROW
→ MONOTONIC STACK
```

```text
remove K to make result smallest
→ GREEDY MONOTONIC STACK
```

```text
current makes previous worse
→ POP previous
```

```text
O(1) min/max operation
→ AUXILIARY STATE
```

```text
subarray minimum / maximum contribution
→ BOUNDARIES + MONOTONIC STACK
```

---

# 11. Stack Mastery Test

You are Stack-ready when you can solve these without notes:

### Foundation

- [ ] Implement Stack using Array
- [ ] Implement Stack using Linked List
- [ ] Push / Pop / Peek
- [ ] Overflow / Underflow

### Recursion + Stack

- [ ] Insert at Bottom
- [ ] Reverse Stack
- [ ] Delete Middle
- [ ] Sort Stack

### Matching / Expressions

- [ ] Valid Parentheses
- [ ] Redundant Brackets
- [ ] Infix → Postfix
- [ ] Postfix Evaluation
- [ ] Basic Calculator

### Monotonic Stack

- [ ] Next Greater
- [ ] Next Smaller
- [ ] Previous Greater
- [ ] Previous Smaller
- [ ] Stock Span
- [ ] Daily Temperatures

### Advanced

- [ ] Largest Rectangle in Histogram
- [ ] Maximal Rectangle
- [ ] Sum of Subarray Minimums
- [ ] Remove K Digits
- [ ] Remove Duplicate Letters
- [ ] Longest Valid Parentheses
- [ ] Min Stack
- [ ] N Stacks in Array

---

# 12. Final Stack Pattern Map

```text
                 STACK
                   │
      ┌────────────┼────────────┐
      ↓            ↓            ↓
     LIFO       MATCHING      NESTED
      │            │            │
   reverse      brackets     expressions
   undo         valid         decode
      │            │            │
      └────────────┼────────────┘
                   ↓
          MONOTONIC STACK
                   │
       ┌───────────┼───────────┐
       ↓           ↓           ↓
   NGE / NSE    HISTOGRAM   CONTRIBUTION
       │           │           │
   span etc.    rectangle    subarrays
```

> **Main goal:** Do not memorize 120 Stack solutions.
>
> Learn to recognize:
>
> ```text
> LIFO
> → Stack
>
> Nested / matching
> → Stack
>
> Nearest greater/smaller
> → Monotonic Stack
>
> Histogram
> → Monotonic Stack + boundaries
>
> Greedy removal
> → Monotonic Stack
>
> O(1) special operation
> → Stack + extra state
> ```
