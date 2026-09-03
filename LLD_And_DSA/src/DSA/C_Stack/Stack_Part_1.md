# C — Stack — Part 1
## Core Foundation • Stack Manipulation • Parentheses • Expression Basics

> **Goal:** Build a strong Stack foundation before moving to monotonic stack, histogram, deque, and advanced design problems.
>
> This is **pattern-wise**, not lecture-wise.
>
> **Part 1 = 50 problems.**

---

# 1. Revision

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close notes → explain pattern + dry run |
| R1 | 2–3 days | Rebuild the solution from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only if weak |

**Revision rule:** strong problems rest; medium problems get another recall; weak problems repeat.

**Tracker Key**

`⬜` Not Started · `🟨` In Progress · `☑️` Completed · `🔄` Needs Revision

---

# 2. Part 1 Pattern Map

```text
A — Stack Foundation
    LIFO
    top
    push / pop / peek
    array / linked list

B — Basic Stack Manipulation
    reverse
    insert at bottom
    delete middle
    sort stack
    recursion + stack

C — Parentheses / Matching
    valid parentheses
    balanced brackets
    redundant brackets
    bracket balance

D — Expression Processing
    infix
    postfix
    prefix
    conversion
    evaluation

E — Stack Applications
    recursive simulation
    undo-like behavior
    simple elimination
    stack-based simulation
```

---

# 3. Pattern A — Stack Foundation

## Pattern Memory

```text
STACK = LIFO

Last In
   ↓
First Out
```

### Core operations

```text
push(x)
→ add x at top

pop()
→ remove top

peek()/top()
→ read top without removing

isEmpty()
→ check whether stack has no element
```

### Array stack

```text
top = -1

push:
top++
stack[top] = x

pop:
read stack[top]
top--
```

### Linked-list stack

```text
top → first node

push:
new.next = top
top = new

pop:
value = top.data
top = top.next
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

> **LIFO → Stack**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|:---:|:---:|:---:|---|
| 01 | Design Stack Using Array | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Array |
| 02 | Design Stack Using Linked List | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Linked |
| 03 | Push Operation | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Push |
| 04 | Pop Operation | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Pop |
| 05 | Peek / Top Operation | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Peek |
| 06 | Check Empty Stack | Custom | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 07 | Stack Size | Custom | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |
| 08 | Handle Stack Overflow | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundary |
| 09 | Handle Stack Underflow | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Boundary |

### Master the state

```text
EMPTY
→ top = -1

ONE ELEMENT
→ top points to one item

FULL ARRAY STACK
→ top = capacity - 1
```

---

# 4. Pattern B — Basic Stack Manipulation

## Core idea

A stack only gives direct access to the top.

To reach something deeper:

```text
POP
→ temporarily remove top
→ work on smaller stack
→ PUSH back
```

With recursion:

```text
remove top
→ recurse
→ rebuild
```

## Recognition

```text
reverse stack
insert at bottom
delete middle
sort stack
modify an item below top
```

↓

Think:

> **Pop → Solve Smaller Stack → Rebuild**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|---:|---|
| 10 | Reverse a String Using Stack | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | LIFO |
| 11 | Check Palindrome Using Stack | GFG | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | LIFO |
| 12 | Insert Element at Bottom of Stack | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 13 | Reverse a Stack Using Recursion | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 14 | Delete Middle Element of Stack | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 15 | Sort a Stack Using Recursion | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Recursion |
| 16 | Remove an Element From Stack | Custom | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Filtering |
| 17 | Insert an Element at Correct Position | Custom | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Rebuild |
| 18 | Preserve Stack Order After Processing | Custom | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | State |

### Pattern memory

```text
TOP
↓
POP
↓
RECURSE
↓
REINSERT
```

---

# 5. Pattern C — Parentheses / Matching

## Core idea

Opening brackets create an obligation.

```text
(
[
{
```

Store them.

Closing bracket resolves the most recent opening bracket.

```text
)
]
}
```

Therefore:

```text
OPENING → PUSH
CLOSING → MATCH TOP → POP
```

## Recognition

```text
balanced
valid
nested
matching
brackets
parentheses
redundant
```

↓

Think:

> **Opening = remember | Closing = validate**

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|:---:|:---:|---|
| 19 | Valid Parentheses | LeetCode 20 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matching |
| 20 | Balanced Parentheses | GFG | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Matching |
| 21 | Redundant / Duplicate Brackets | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |
| 22 | Minimum Add to Make Parentheses Valid | LeetCode 921 | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Balance |
| 23 | Remove Outermost Parentheses | LeetCode 1021 | 🟢 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Depth |
| 24 | Minimum Number of Swaps for Bracket Balancing | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Balance |
| 25 | Longest Valid Parentheses | LeetCode 32 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Stack Index |
| 26 | Valid Parenthesis String | LeetCode 678 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Greedy / Stack |

### Core rule

```text
At the end:
stack must be empty
```

and

```text
Every closing bracket must match stack.top()
```

---

# 6. Pattern D — Expression Processing

## Pattern Memory

```text
OPERAND
→ output / value stack

OPERATOR
→ stack based on precedence
```

### Precedence idea

```text
()
↓
* /
↓
+ -
```

For conversion:

```text
read token
→ operand?
→ output

operator?
→ compare precedence
→ pop higher/equal precedence when appropriate
→ push current operator
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|---:|---|
| 27 | Infix to Postfix | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 28 | Infix to Prefix | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 29 | Postfix Evaluation | GFG | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Evaluation |
| 30 | Prefix Evaluation | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Evaluation |
| 31 | Postfix to Infix | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 32 | Prefix to Infix | GFG | 🟡 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 33 | Postfix to Prefix | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 34 | Prefix to Postfix | GFG | 🟡 | ⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Conversion |
| 35 | Basic Calculator | LeetCode 224 | 🔴 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |
| 36 | Basic Calculator II | LeetCode 227 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Expression |

### Recognition

```text
expression
+
operator precedence
+
nested operations

→ STACK
```

---

# 7. Pattern E — Stack Applications / Simulation

These problems make you choose Stack because the problem itself creates a **“most recent unresolved item”**.

## Recognition

```text
undo
collision
elimination
nested state
temporary reversal
recent unresolved element
```

## Problems

| # | Problem | Platform | Difficulty | Interview | Status | R1 | R2 | R3 | Pattern |
|---:|---|---|:---:|:---:|:---:|---:|---:|:---:|---|
| 37 | Backspace String Compare | LeetCode 844 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 38 | Remove All Adjacent Duplicates in String | LeetCode 1047 | 🟢 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Elimination |
| 39 | Remove All Adjacent Duplicates II | LeetCode 1209 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Counting Stack |
| 40 | Asteroid Collision | LeetCode 735 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 41 | Simplify Path | LeetCode 71 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Path Stack |
| 42 | Decode String | LeetCode 394 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Nested State |
| 43 | Evaluate Reverse Polish Notation | LeetCode 150 | 🟡 | ⭐⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Value Stack |
| 44 | Baseball Game | LeetCode 682 | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Simulation |
| 45 | Make The String Great | LeetCode 1544 | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Elimination |
| 46 | Removing Stars From a String | LeetCode 2390 | 🟢 | ⭐⭐⭐⭐ | ⬜ | ⬜ | ⬜ | ⬜ | Undo |

---

# 8. Part 1 Recognition Sheet

```text
LIFO
→ STACK
```

```text
Nested brackets
→ STACK
```

```text
Opening / closing matching
→ STACK
```

```text
Operator precedence
→ STACK
```

```text
Expression evaluation
→ STACK
```

```text
Reverse
→ STACK can help
```

```text
Recent unresolved item
→ STACK
```

```text
Undo / remove previous
→ STACK
```

---

# 9. Part 1 Mastery Test

Before Part 2, solve these without notes:

- [ ] Implement Stack using Array
- [ ] Implement Stack using Linked List
- [ ] Push / Pop / Peek
- [ ] Insert at Bottom
- [ ] Reverse Stack Recursively
- [ ] Delete Middle
- [ ] Sort Stack Recursively
- [ ] Valid Parentheses
- [ ] Redundant Brackets
- [ ] Infix → Postfix
- [ ] Postfix Evaluation
- [ ] Reverse Polish Notation
- [ ] Decode String
- [ ] Asteroid Collision
- [ ] Simplify Path

## Part 1 completion rule

You should be able to answer:

> **“Why is Stack the right data structure here?”**

before writing code.

If you can identify **LIFO / nested state / most-recent unresolved state**, you are ready for Part 2.
