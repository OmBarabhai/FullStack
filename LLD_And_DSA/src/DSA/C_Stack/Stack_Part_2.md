# C — Stack — Part 2 MASTER TRACKER
## Monotonic Stack • Histogram • Matrix • Greedy Stack • Advanced Simulation • Stack Design • Contribution

> **Goal:** Finish Stack at an interview-ready level by mastering reusable templates, not isolated solutions.
>
> **This file is the single Part 2 tracker.**
>
> ```text
> NGE / NSE
> ↓
> PGE / PSE
> ↓
> Monotonic Stack Template
> ↓
> Span / Distance / Visibility
> ↓
> Histogram Boundary Template
> ↓
> Matrix → Histogram
> ↓
> Greedy Monotonic Stack
> ↓
> Advanced Stack Simulation
> ↓
> Stack Design
> ↓
> Contribution / Subarray Template
> ↓
> Hard Integration
> ```

# 1. Revision System

| Mark | When | What to do |
|---|---|---|
| R0 | Same day | Close solution → explain invariant + dry run |
| R1 | 2–3 days | Rebuild the template from memory |
| R2 | ~7 days | Solve / trace without notes |
| R3 | ~30 days | Quick recall; retry only if weak |

`⬜` Not Started · `🟨` In Progress · `☑️` Problem Solved · `🔄` Needs Revision

`🟢` Strong · `🟡` Medium · `🔴` Weak / unclear

> **Important:** A problem can be solved but the pattern can still be unmastered. Track them separately.

# 2. Part 2 Master Rule

For every problem, first write:

```text
1. What does the answer represent?
2. What does the stack store?
3. Which direction do I scan?
4. What makes the top useless?
5. What does the stack top mean?
6. When do I pop?
7. When do I push?
8. What do I return when the stack is empty?
```

Never start by copying a template.

# 3. Pattern A — Monotonic Stack CORE ⭐⭐⭐⭐⭐

## Recognition

```text
nearest greater
nearest smaller
next greater
next smaller
previous greater
previous smaller
first greater
first smaller
```

→ **Monotonic Stack**

## Canonical comparison table

| Problem | Direction | Stack keeps | Remove while |
|---|---|---|---|
| Next Greater | Right → Left | decreasing candidates | `top <= current` |
| Next Smaller | Right → Left | increasing candidates | `top >= current` |
| Previous Greater | Left → Right | decreasing candidates | `top <= current` |
| Previous Smaller | Left → Right | increasing candidates | `top >= current` |

## Master distinction

```text
st.push(i)
→ stack stores INDEX

st.push(arr[i])
→ stack stores VALUE
```

If stack stores indexes:

```text
st.peek()       → index
arr[st.peek()]  → value
```

Before coding, identify whether the answer wants:

```text
VALUE
INDEX
DISTANCE
COUNT
BOUNDARY
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 01 | Next Greater Element I | LeetCode 496 | 🟢 | NGE | ☑️ | ⬜ | ⬜ | ⬜ |
| 02 | Next Greater Element II | LeetCode 503 | 🟡 | Circular NGE | ☑️ | ⬜ | ⬜ | ⬜ |
| 03 | Next Smaller Element | Coding Ninjas / GFG | 🟢 | NSE | ☑️ | ⬜ | ⬜ | ⬜ |
| 04 | Previous Greater Element | GFG / Interview | 🟢 | PGE | ⬜ | ⬜ | ⬜ | ⬜ |
| 05 | Previous Smaller Element | GFG / Interview | 🟢 | PSE | ⬜ | ⬜ | ⬜ | ⬜ |
| 06 | Nearest Greater to Left | GFG | 🟡 | PGE | ⬜ | ⬜ | ⬜ | ⬜ |
| 07 | Nearest Smaller to Left | GFG | 🟡 | PSE | ⬜ | ⬜ | ⬜ | ⬜ |
| 08 | Nearest Greater to Right | GFG | 🟡 | NGE | ⬜ | ⬜ | ⬜ | ⬜ |
| 09 | Nearest Smaller to Right | GFG | 🟡 | NSE | ⬜ | ⬜ | ⬜ | ⬜ |
| 10 | Daily Temperatures | LeetCode 739 | 🟡 | NGE + Distance | ☑️ | ⬜ | ⬜ | ⬜ |
| 11 | Stock Span | GFG | 🟡 | PGE + Span | ☑️ | ⬜ | ⬜ | ⬜ |
| 12 | Online Stock Span | LeetCode 901 | 🟡 | Span | ☑️ | ⬜ | ⬜ | ⬜ |
| 13 | Number of Visible People in a Queue | LeetCode 1944 | 🟡 | Decreasing Stack | ☑️ | ⬜ | ⬜ | ⬜ |
| 14 | Next Greater Node in Linked List | LeetCode 1019 | 🟡 | NGE + Linked List | ⬜ | ⬜ | ⬜ | ⬜ |

> **Checkpoint:** NGE, NSE, PGE and PSE should each be reproducible from memory.

# 4. Pattern B — Circular Monotonic Stack

## Core idea

```text
array wraps around
↓
simulate two passes
↓
index = i % n
```

Typical structure:

```java
for (int i = 2 * n - 1; i >= 0; i--) {
    int idx = i % n;
}
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 15 | Next Greater Element II | LeetCode 503 | 🟡 | Circular NGE | ☑️ | ⬜ | ⬜ | ⬜ |
| 16 | Circular Next Smaller Element | GFG / Custom | 🟡 | Circular NSE | ⬜ | ⬜ | ⬜ | ⬜ |
| 17 | Circular Previous Greater | Custom | 🟡 | Circular PGE | ⬜ | ⬜ | ⬜ | ⬜ |
| 18 | Circular Previous Smaller | Custom | 🟡 | Circular PSE | ⬜ | ⬜ | ⬜ | ⬜ |

# 5. Pattern C — Histogram Boundary Template ⭐⭐⭐⭐⭐

For each bar:

```text
PSE → left boundary
NSE → right boundary
```

Your easier-to-understand version:

```text
start = PSE + 1
end   = NSE - 1

width = end - start + 1

area = height × width
```

Equivalent:

```text
width = NSE - PSE - 1
```

Why:

```text
PSE / NSE themselves are smaller boundary bars.
Only positions BETWEEN them are usable.
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 19 | Largest Rectangle in Histogram | LeetCode 84 | 🔴 | PSE + NSE + Width | ☑️ | ⬜ | ⬜ | ⬜ |
| 20 | Largest Rectangle — Two Pass | GFG | 🔴 | Same Boundary Template | ⬜ | ⬜ | ⬜ | ⬜ |
| 21 | Largest Rectangle — One Pass Stack | Interview | 🔴 | One-Pass Boundary | ⬜ | ⬜ | ⬜ | ⬜ |
| 22 | Largest Rectangle With Equal Heights | Controlled Practice | 🟡 | Histogram | ⬜ | ⬜ | ⬜ | ⬜ |
| 23 | Largest Rectangle With Zeros | Controlled Practice | 🟡 | Boundary Reset | ⬜ | ⬜ | ⬜ | ⬜ |
| 24 | Sum of Subarray Minimums | LeetCode 907 | 🔴 | Boundary Contribution | ⬜ | ⬜ | ⬜ | ⬜ |
| 25 | Sum of Subarray Ranges | LeetCode 2104 | 🟡 | Min + Max Contribution | ⬜ | ⬜ | ⬜ | ⬜ |
| 26 | Valid Subarray Size | LeetCode 2334 | 🔴 | Boundary Width | ⬜ | ⬜ | ⬜ | ⬜ |
| 27 | Maximum Subarray Min-Product | LeetCode 1856 | 🔴 | Boundary + Prefix Sum | ⬜ | ⬜ | ⬜ | ⬜ |

# 6. Pattern D — Matrix → Histogram → Stack ⭐⭐⭐⭐⭐

## Core idea

```text
char[][] matrix
↓
int[] height
↓
each row becomes a histogram
↓
Largest Rectangle in Histogram
```

Height update:

```java
if (matrix[row][col] == '1') {
    height[col]++;
} else {
    height[col] = 0;
}
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 28 | Maximal Rectangle | LeetCode 85 | 🔴 | Matrix → Histogram | ☑️ | ⬜ | ⬜ | ⬜ |
| 29 | Maximum Rectangle of 1s | GFG | 🔴 | Matrix Histogram | ⬜ | ⬜ | ⬜ | ⬜ |
| 30 | Row-wise Histogram Construction | Controlled Practice | 🟢 | Height State | ⬜ | ⬜ | ⬜ | ⬜ |
| 31 | Maximal Rectangle — Rebuild From Scratch | Interview Practice | 🔴 | Full Integration | ⬜ | ⬜ | ⬜ | ⬜ |
| 32 | Count Submatrices With All Ones | LeetCode 1504 / GFG | 🟡 | Matrix + Stack | ⬜ | ⬜ | ⬜ | ⬜ |

> **Checkpoint:** Write the matrix → height[] → histogram conversion without looking at old code.

# 7. Pattern E — Stack Simulation / Unresolved State ⭐⭐⭐⭐

Recognition:

```text
collision
nested state
remove previous
backspace
adjacent duplicates
undo
most recent unresolved item
```

Template:

```text
read current
↓
while previous state is invalid / dominated
    pop
↓
resolve current
↓
push current
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 33 | Asteroid Collision | LeetCode 735 | 🟡 | Collision Simulation | ☑️ | ⬜ | ⬜ | ⬜ |
| 34 | Remove All Adjacent Duplicates | LeetCode 1047 | 🟢 | Elimination | ☑️ | ⬜ | ⬜ | ⬜ |
| 35 | Remove All Adjacent Duplicates II | LeetCode 1209 | 🟡 | Counting Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 36 | Backspace String Compare | LeetCode 844 | 🟢 | Undo Simulation | ⬜ | ⬜ | ⬜ | ⬜ |
| 37 | Removing Stars From a String | LeetCode 2390 | 🟢 | Undo Simulation | ⬜ | ⬜ | ⬜ | ⬜ |
| 38 | Simplify Path | LeetCode 71 | 🟡 | Path Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 39 | Decode String | LeetCode 394 | 🟡 | Nested State | ⬜ | ⬜ | ⬜ | ⬜ |
| 40 | Baseball Game | LeetCode 682 | 🟢 | Simulation | ☑️ | ⬜ | ⬜ | ⬜ |
| 41 | Remove Nodes From Linked List | LeetCode 2487 | 🟡 | Monotonic Stack | ☑️ | ⬜ | ⬜ | ⬜ |

# 8. Pattern F — Expression Stack ⭐⭐⭐⭐

Recognition:

```text
infix
prefix
postfix
operator precedence
calculator
expression evaluation
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 42 | Evaluate Reverse Polish Notation | LeetCode 150 | 🟡 | Value Stack | ☑️ | ⬜ | ⬜ | ⬜ |
| 43 | Infix to Postfix | GFG | 🟡 | Operator Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 44 | Infix to Prefix | GFG | 🟡 | Operator Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 45 | Postfix to Infix | GFG | 🟡 | Conversion | ⬜ | ⬜ | ⬜ | ⬜ |
| 46 | Prefix to Infix | GFG | 🟡 | Conversion | ⬜ | ⬜ | ⬜ | ⬜ |
| 47 | Longest Valid Parentheses | LeetCode 32 | 🔴 | Stack + Index | ⬜ | ⬜ | ⬜ | ⬜ |
| 48 | Basic Calculator | LeetCode 224 | 🔴 | Expression Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 49 | Basic Calculator II | LeetCode 227 | 🟡 | Expression Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 50 | Verify Preorder Serialization | LeetCode 331 | 🟡 | Stack State | ⬜ | ⬜ | ⬜ | ⬜ |

# 9. Pattern G — Greedy + Monotonic Stack ⭐⭐⭐⭐⭐

Recognition:

```text
remove K
make smallest
lexicographically smallest
remove worse previous choices
keep best subsequence
```

Master rule:

```text
current is better
+
previous can safely be removed
→ POP
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 51 | Remove K Digits | LeetCode 402 | 🟡 | Greedy Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 52 | Most Competitive Subsequence | LeetCode 1673 | 🟡 | Greedy Monotonic | ⬜ | ⬜ | ⬜ | ⬜ |
| 53 | Remove Duplicate Letters | LeetCode 316 | 🟡 | Greedy + Frequency | ⬜ | ⬜ | ⬜ | ⬜ |
| 54 | Smallest Subsequence of Distinct Characters | LeetCode 1081 | 🟡 | Greedy Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 55 | Create Maximum Number | LeetCode 321 | 🔴 | Greedy Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 56 | Final Prices With a Special Discount | LeetCode 1475 | 🟢 | Monotonic Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 57 | Steps to Make Array Non-Decreasing | LeetCode 2289 | 🟡 | Monotonic Stack | ⬜ | ⬜ | ⬜ | ⬜ |

# 10. Pattern H — Special Stack Design ⭐⭐⭐⭐⭐

Recognition:

```text
Normal Stack
+
extra operation required in O(1)
```

→ maintain auxiliary state / invariant.

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 58 | Min Stack | LeetCode 155 | 🟡 | Auxiliary Minimum | ☑️ | ⬜ | ⬜ | ⬜ |
| 59 | Min Stack Using One Stack | GFG | 🟡 | Encoding / Invariant | ⬜ | ⬜ | ⬜ | ⬜ |
| 60 | Two Stacks in One Array | GFG | 🟡 | Shared Storage | ⬜ | ⬜ | ⬜ | ⬜ |
| 61 | N Stacks in an Array | GFG | 🔴 | Shared Storage | ⬜ | ⬜ | ⬜ | ⬜ |
| 62 | Max Stack | LeetCode 716 | 🔴 | Design | ⬜ | ⬜ | ⬜ | ⬜ |
| 63 | Stack With O(1) Middle Element | GFG / Interview | 🔴 | Design | ⬜ | ⬜ | ⬜ | ⬜ |

# 11. Pattern I — Contribution / Subarray ⭐⭐⭐⭐⭐

This is where PSE/NSE becomes more powerful.

Instead of:

```text
“What is the nearest smaller?”
```

we ask:

```text
“How many subarrays use this element
as the minimum / maximum?”
```

Core:

```text
left choices
×
right choices
×
current value
```

Typical minimum contribution:

```text
left choices  = i - PSE[i]
right choices = NSE[i] - i

contribution =
left choices × right choices × arr[i]
```

## Problems

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 64 | Sum of Subarray Minimums | LeetCode 907 | 🔴 | Contribution + PSE/NSE | ⬜ | ⬜ | ⬜ | ⬜ |
| 65 | Sum of Subarray Ranges | LeetCode 2104 | 🟡 | Min + Max Contribution | ⬜ | ⬜ | ⬜ | ⬜ |
| 66 | Valid Subarray Size | LeetCode 2334 | 🔴 | Boundary Width | ⬜ | ⬜ | ⬜ | ⬜ |
| 67 | Maximum Subarray Min-Product | LeetCode 1856 | 🔴 | Boundary + Prefix Sum | ⬜ | ⬜ | ⬜ | ⬜ |
| 68 | Sum of Total Strength of Wizards | LeetCode 2281 | 🔴 | Advanced Contribution | ⬜ | ⬜ | ⬜ | ⬜ |

# 12. Pattern J — Hard Monotonic Integration

| # | Problem | Platform | Difficulty | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|---|:---:|:---:|:---:|:---:|
| 69 | Trapping Rain Water — Stack Approach | LeetCode 42 | 🔴 | Monotonic Stack | ☑️* | ⬜ | ⬜ | ⬜ |
| 70 | Maximum Width Ramp | LeetCode 962 | 🟡 | Decreasing Stack | ⬜ | ⬜ | ⬜ | ⬜ |
| 71 | Car Fleet | LeetCode 853 | 🟡 | Monotonic Reasoning | ⬜ | ⬜ | ⬜ | ⬜ |
| 72 | Number of Visible People in a Queue | LeetCode 1944 | 🟡 | Decreasing Stack | ☑️ | ⬜ | ⬜ | ⬜ |
| 73 | Valid Subarray Size | LeetCode 2334 | 🔴 | Boundary | ⬜ | ⬜ | ⬜ | ⬜ |
| 74 | Maximum Subarray Min-Product | LeetCode 1856 | 🔴 | Contribution | ⬜ | ⬜ | ⬜ | ⬜ |
| 75 | Sum of Total Strength of Wizards | LeetCode 2281 | 🔴 | Advanced Contribution | ⬜ | ⬜ | ⬜ | ⬜ |

`* Problem is marked solved, but verify/rebuild the Stack approach separately if the accepted solution used another approach.`

# 13. YOUR CURRENT SOLVED STACK SET

Clearly evidenced from your supplied coding activity / code:

```text
☑️ Implement Stack With Linked List
☑️ Valid Parentheses
☑️ Baseball Game
☑️ Remove All Adjacent Duplicates
☑️ Asteroid Collision

☑️ Next Greater Element I
☑️ Next Greater Element II
☑️ Next Smaller Element
☑️ Daily Temperatures
☑️ Stock Span
☑️ Online Stock Span
☑️ Number of Visible People in a Queue

☑️ Min Stack
☑️ Evaluate Reverse Polish Notation
☑️ Remove Nodes From Linked List

☑️ Trapping Rain Water
☑️ Largest Rectangle in Histogram
☑️ Maximal Rectangle
```

# 14. Pattern Mastery Status

## Template 1 — NGE

```text
☑️ solved
→ revise
```

## Template 2 — NSE

```text
☑️ solved
→ revise
```

## Template 3 — PGE

```text
⬜ not yet explicitly solved
```

## Template 4 — PSE

```text
⬜ not yet explicitly solved
```

Therefore your **next target is PGE**, then **PSE**.

Do not jump to another hard problem before these two are comfortable.

# 15. Personal Monotonic Stack Master Template

### Value Stack

```java
Stack<Integer> st = new Stack<>();

for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && st.peek() >= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : st.peek();

    st.push(arr[i]);
}
```

### Index Stack

```java
Stack<Integer> st = new Stack<>();

for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? n : st.peek();

    st.push(i);
}
```

### Distance / Span

```text
current index - boundary index
```

### Histogram

```java
int start = pse[i] + 1;
int end = nse[i] - 1;

int width = end - start + 1;

int area = heights[i] * width;
```

### Contribution

```text
previous boundary
+
next boundary
↓
left choices
×
right choices
×
current value
```

# 16. Strict vs Non-Strict Comparisons

Never blindly copy `>`, `>=`, `<`, or `<=`.

Ask:

```text
Should equal values be removed?
Should equal values stay?
Could equal values cause duplicate counting?
```

For simple “strictly smaller” boundary problems:

```text
remove greater/equal
→ while (top >= current)
```

For “strictly greater”:

```text
remove smaller/equal
→ while (top <= current)
```

Contribution problems may intentionally use different strictness on the left and right to avoid double-counting equal minima/maxima.

# 17. Problem-Type Recognition

```text
Nearest greater/smaller
→ Monotonic Stack
```

```text
Span / waiting distance
→ Monotonic Stack + index difference
```

```text
Histogram
→ PSE + NSE + width
```

```text
Binary matrix + largest rectangle
→ Matrix → Histogram → Stack
```

```text
Current makes previous choice worse
→ Greedy Stack
```

```text
Nested / unresolved state
→ Stack simulation
```

```text
O(1) extra operation
→ Auxiliary Stack State
```

```text
Subarray min/max contribution
→ Boundaries + Contribution
```

# 18. Problems That Should NOT Be Forced Into Stack

Keep the Stack roadmap focused.

```text
Count Smaller Numbers After Self
→ Merge Sort / Fenwick / ordered structure
```

```text
Maximum Sum Rectangle
→ 2D Kadane / row compression
```

```text
General Queue problems
→ Queue
```

```text
General BFS
→ Queue
```

The fact that a `Stack` appears in an implementation does not automatically make the problem a Stack-pattern problem.

# 19. Revision of ONLY Problems You Solved

For your workflow:

```text
Solve
↓
☑️ mark
↓
pattern name
↓
what stack stores
↓
pop condition
↓
why pop is safe
↓
dry run
↓
R1
↓
R2
↓
R3
```

Do not revise every unsolved problem.

Only the problems you have actually solved become revision candidates.

# 20. Long-Run Stack Completion Order

```text
NGE ✅
↓
NSE ✅
↓
PGE
↓
PSE
↓
4-direction template mastery
↓
Daily Temperatures ✅
↓
Stock Span ✅
↓
Online Stock Span ✅
↓
Visible People ✅
↓
Histogram ✅
↓
One-Pass Histogram
↓
Maximal Rectangle ✅
↓
Trapping Rain Water Stack approach
↓
Remove K Digits
↓
Remove Duplicate Letters
↓
Most Competitive Subsequence
↓
Min Stack ✅
↓
Two Stacks
↓
N Stacks
↓
Subarray Minimums
↓
Subarray Ranges
↓
Valid Subarray Size
↓
Min-Product
↓
Advanced Contribution
```

# 21. FINAL STACK MASTERY TEST

### Monotonic Core

- [ ] NGE
- [ ] NSE
- [ ] PGE
- [ ] PSE
- [ ] Circular NGE

### Span / Distance

- [ ] Daily Temperatures
- [ ] Stock Span
- [ ] Online Stock Span
- [ ] Visible People

### Histogram

- [ ] Largest Rectangle
- [ ] One-Pass Histogram
- [ ] Maximal Rectangle

### Simulation / Expression

- [ ] Valid Parentheses
- [ ] RPN
- [ ] Asteroid Collision
- [ ] Decode String
- [ ] Simplify Path
- [ ] Longest Valid Parentheses

### Greedy

- [ ] Remove K Digits
- [ ] Remove Duplicate Letters
- [ ] Most Competitive Subsequence

### Design

- [ ] Min Stack
- [ ] Two Stacks in One Array
- [ ] N Stacks

### Contribution

- [ ] Sum of Subarray Minimums
- [ ] Sum of Subarray Ranges
- [ ] Valid Subarray Size
- [ ] Maximum Subarray Min-Product

# 22. Definition of Stack Mastery

You are finished when a new problem gives clues like:

```text
nearest
next / previous
greater / smaller
span
distance to next greater
histogram
largest rectangle
subarray minimum
remove K
current dominates previous
```

and your first thought is:

```text
“What monotonic stack state should I maintain?”
```

Then you immediately decide:

```text
VALUE or INDEX?
LEFT or RIGHT?
GREATER or SMALLER?
STRICT or NON-STRICT?
VALUE / INDEX / DISTANCE / COUNT / BOUNDARY / CONTRIBUTION?
```

> **The long-run goal is not 100+ memorized Stack solutions.**
>
> **The goal is one small set of templates that lets you solve their variations.**
