# B — Stack + Queue — Part 1
## Core Foundation • Basic Manipulation • Queue Foundation • Introductory Patterns

> **Goal:** Build a rock-solid Stack + Queue foundation before moving to advanced monotonic-stack, deque, design, and BFS-heavy problems.
>
> Part 1 is **pattern-wise**, not lecture-wise.
>
> **Part 1 = 60 problems.**
>
> The order is intentionally progressive:
>
> ```text
> References
> → Stack State
> → Stack Operations
> → Stack + Recursion
> → Parentheses
> → Expression Basics
> → Queue State
> → Queue Operations
> → Circular Queue
> → Deque Basics
> → Two Stacks / Two Queues
> → Monotonic Stack Introduction
> ```

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild the method from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only where needed |

**Revision rule:** strong problems rest; medium problems get another recall; weak problems repeat.

**Tracker Key**

`☑️` completed · `R1/R2/R3` = revision completed · `🟢/🟡/🔴` = strong / medium / weak

---

# 2. Part 1 Pattern Map

```text
A — Stack Foundation
    Node / Array
    top
    push / pop / peek
    empty / size

B — Stack Manipulation
    reverse
    insert at bottom
    reverse recursively
    sort recursively

C — Parentheses / Expression Basics
    balanced brackets
    redundant brackets
    infix / postfix
    postfix evaluation

D — Queue Foundation
    front / rear
    enqueue / dequeue
    peek / size
    array / linked list

E — Queue Variants
    circular queue
    deque
    queue using stacks
    stack using queues

F — Interview Integration
    first non-repeating character
    interleaving
    generation using queue
    simple simulation

G — Monotonic Stack Introduction
    next greater
    next smaller
    previous greater
    previous smaller
```

---

# 3. Pattern A — Stack Foundation

## Pattern Memory

```text
STACK = LIFO

push(x)
→ add at top

pop()
→ remove from top

peek()/top()
→ inspect top

isEmpty()
→ top == -1 / empty structure
```

## Core State

```text
top
size

Array Stack:
top starts at -1

Linked Stack:
top points to first node
```

## Recognition

```text
last inserted item needed first
undo
backtracking state
nested structure
reverse order
```

↓

Think:

> **LIFO State**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 01 | Implement Stack Using Array | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Array |
| 02 | Implement Stack Using Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Linked |
| 03 | Push Operation | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Push |
| 04 | Pop Operation | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Pop |
| 05 | Peek / Top Operation | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Peek |
| 06 | Check Empty Stack | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 07 | Stack Size | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 08 | Design Min/Max-Free Basic Stack API | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Design |

### Small algorithm

```text
PUSH
→ check capacity
→ top++
→ store

POP
→ check empty
→ read
→ top--

PEEK
→ check empty
→ read top
```

---

# 4. Pattern B — Stack Manipulation

## Core idea

```text
take top
→ solve smaller stack
→ put item back
```

For recursion:

```text
remove top elements temporarily
→ reach base case
→ rebuild stack
```

## Recognition

```text
insert at bottom
reverse stack
sort stack
preserve original order
```

↓

Think:

> **Pop → Smaller Stack → Rebuild**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 09 | Reverse a String Using Stack | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | LIFO |
| 10 | Check Palindrome Using Stack | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | LIFO |
| 11 | Insert Element at Bottom of Stack | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 12 | Reverse a Stack Using Recursion | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 13 | Sort a Stack Using Recursion | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 14 | Delete Middle Element of Stack | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 15 | Remove All Occurrences of an Element | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Filtering |
| 16 | Preserve Stack While Rebuilding | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |

### Pattern memory

```text
POP
→ RECURSE
→ INSERT / REBUILD
```

---

# 5. Pattern C — Parentheses / Expression Basics

## Pattern Memory

```text
opening bracket
→ PUSH

closing bracket
→ top must match
→ POP
```

## Recognition

```text
()
{}
[]
nested brackets
matching symbols
redundant brackets
expression validation
```

↓

Think:

> **Open = remember, Close = validate**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 17 | Valid Parentheses | LeetCode 20 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matching |
| 18 | Balanced Parentheses | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matching |
| 19 | Duplicate / Redundant Parentheses | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |
| 20 | Minimum Add to Make Parentheses Valid | LeetCode 921 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Balance |
| 21 | Remove Outermost Parentheses | LeetCode 1021 | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Depth |
| 22 | Minimum Number of Swaps for Bracket Balancing | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Balance |
| 23 | Infix to Postfix | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 24 | Evaluate Postfix Expression | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Evaluation |
| 25 | Infix Expression Evaluation | GFG / Interview | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Stacks |

### Core rule

```text
expression problem
→ operators need temporary storage
→ stack
```

---

# 6. Pattern D — Queue Foundation

## Pattern Memory

```text
QUEUE = FIFO

enqueue(x)
→ add at rear

dequeue()
→ remove from front

peek()
→ inspect front
```

## State

```text
front
rear
size
```

For an empty queue:

```text
front = -1
rear  = -1
```

or equivalent linked-list state.

## Recognition

```text
first come → first served
waiting line
processing order
BFS
scheduling
buffer
```

↓

Think:

> **FIFO State**

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 26 | Implement Queue Using Array | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Array |
| 27 | Implement Queue Using Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Linked |
| 28 | Enqueue | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Insert |
| 29 | Dequeue | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Delete |
| 30 | Front / Peek | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Peek |
| 31 | Rear / Back | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Peek |
| 32 | Queue Size | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 33 | Check Empty Queue | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 34 | Queue from Array Operations | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 35 | Queue Using Linked List with O(1) Enqueue | Interview | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Tail |

### Small algorithm

```text
ENQUEUE
→ add at rear

DEQUEUE
→ remove from front

PEEK
→ read front
```

---

# 7. Pattern E — Queue Variants

## Pattern memory

```text
Circular Queue
→ reuse freed array positions

Deque
→ insertion/deletion from both ends
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 36 | Implement Circular Queue | LeetCode 622 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 37 | Design Circular Queue | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 38 | Implement Deque | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque |
| 39 | Insert Front / Rear in Deque | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque |
| 40 | Delete Front / Rear in Deque | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Deque |
| 41 | Reverse a Queue | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion/Stack |
| 42 | Reverse First K Elements of Queue | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Queue + Stack |
| 43 | Interleave First Half with Second Half of Queue | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Reordering |

### Recognition

```text
wrap around
→ circular

both ends matter
→ deque

reverse only part
→ temporary stack + queue
```

---

# 8. Pattern F — Two Structures / Simulation

## Core idea

```text
Stack + Queue
or
Queue + Stack

→ simulate one ADT using another
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 44 | Implement Queue Using Two Stacks | LeetCode 232 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Stacks |
| 45 | Implement Stack Using Two Queues | LeetCode 225 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Two Queues |
| 46 | Implement Stack Using One Queue | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rotation |
| 47 | First Non-Repeating Character in a Stream | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Queue + Frequency |
| 48 | Generate Binary Numbers from 1 to N | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Queue Generation |

### Pattern memory

```text
Need FIFO
→ queue

Need LIFO
→ stack

Need to convert one behavior to the other
→ use two structures / reordering
```

---

# 9. Pattern G — Monotonic Stack Introduction ⭐

This is the bridge into the advanced Stack section.

## Core idea

```text
For every element:
find the nearest greater/smaller element
```

### Recognition

```text
Next Greater
Next Smaller
Previous Greater
Previous Smaller
Nearest Greater
Nearest Smaller
```

↓

Think:

> **Monotonic Stack**

## Basic invariant

For a decreasing monotonic stack:

```text
while stack not empty
AND
stack.top() <= current
    pop
```

For an increasing monotonic stack:

```text
while stack not empty
AND
stack.top() >= current
    pop
```

## Problems

| # | Problem | Platform | Diff. | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 49 | Next Greater Element I | LeetCode 496 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 50 | Next Greater Element II | LeetCode 503 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Circular |
| 51 | Next Smaller Element | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 52 | Previous Greater Element | Custom/GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 53 | Previous Smaller Element | Custom/GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 54 | Nearest Greater to Left | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 55 | Nearest Smaller to Left | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 56 | Nearest Greater to Right | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 57 | Nearest Smaller to Right | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |
| 58 | Stock Span Problem | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Previous Greater |
| 59 | Daily Temperatures | LeetCode 739 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Next Greater |
| 60 | Online Stock Span | LeetCode 901 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Monotonic |

### Final pattern memory

```text
ASK:
"nearest greater/smaller?"

YES
→ think MONOTONIC STACK
```

---

# 10. Part 1 Completion Test

Before starting Part 2, you should be able to recognize:

```text
LIFO                  → Stack
FIFO                  → Queue
Nested symbols        → Stack
Reverse                → Stack
Two ADTs simulation   → Stack + Queue
Both ends             → Deque
Wrap around           → Circular Queue
Nearest greater       → Monotonic Stack
Nearest smaller       → Monotonic Stack
```

## Part 1 Mastery Checklist

- [ ] Implement Stack without notes
- [ ] Implement Queue without notes
- [ ] Implement Circular Queue without notes
- [ ] Implement Deque without notes
- [ ] Reverse a Stack recursively
- [ ] Sort a Stack recursively
- [ ] Solve Valid Parentheses
- [ ] Convert Infix → Postfix
- [ ] Evaluate Postfix
- [ ] Implement Queue using 2 Stacks
- [ ] Implement Stack using 2 Queues
- [ ] Explain monotonic stack in your own words
- [ ] Solve Next Greater Element
- [ ] Solve Next Smaller Element
- [ ] Solve Stock Span
- [ ] Solve Daily Temperatures

> **Do not move to Part 2 until the monotonic-stack recognition pattern is clear.**
