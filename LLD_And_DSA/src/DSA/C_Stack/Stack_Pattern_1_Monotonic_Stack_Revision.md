# STACK — PATTERN 1 MASTER REVISION
## Monotonic Stack — NGE / NSE / PGE / PSE + Distance / Span / Visibility / Structure Variations

> **Goal:** one global template first. Every problem below is a variation of that template.  
> Revise the **thinking** first, then the short problem-specific addition.

---

# 1. GLOBAL TEMPLATE — USE THIS FIRST

```text
PROBLEM
  ↓
What exactly is required?
  ↓
Nearest / First / ALL?
  ↓
Previous / Next?
  ↓
Greater / Smaller?
  ↓
Is a monotonic stack actually needed?
  ↓
What does the stack store?
  ├── index
  ├── value
  └── pair / multiple stacks
  ↓
Which direction?
  ├── Next     → usually right → left
  └── Previous → usually left → right
  ↓
When is the top useless?
  ├── Greater wanted → pop <= current
  └── Smaller wanted → pop >= current
  ↓
What does peek() represent?
  ↓
What does the remaining top mean?
  ↓
What is the empty-stack answer?
  ↓
What is the required output?
  ├── value
  ├── index
  ├── distance
  ├── span
  └── count
```

### One-line template

```text
IDENTIFY → STORE → DIRECTION → POP → TOP → ANSWER → PUSH
```

---

# 2. FOUR CORE MONOTONIC-STACK FORMS

| Pattern | Answer side | Scan | Pop while | Surviving top |
|---|---|---|---|---|
| NGE | Right | Right → Left | `arr[top] <= current` | nearest greater |
| NSE | Right | Right → Left | `arr[top] >= current` | nearest smaller |
| PGE | Left | Left → Right | `arr[top] <= current` | nearest greater |
| PSE | Left | Left → Right | `arr[top] >= current` | nearest smaller |

Derive:

```text
Next
→ answer is on RIGHT
→ scan RIGHT → LEFT

Previous
→ answer is on LEFT
→ scan LEFT → RIGHT

Greater
→ smaller/equal candidate cannot help
→ pop <= current

Smaller
→ greater/equal candidate cannot help
→ pop >= current
```

---

# 3. GLOBAL DRY-RUN TEMPLATE

```text
CURRENT:
STACK BEFORE:

TOP REPRESENTS:

TOP INDEX:
TOP VALUE:

Does TOP satisfy the required relationship?
    YES → keep
    NO  → pop

Why is it useless?

Repeat while needed.

REMAINING TOP:

ANSWER:

PUSH CURRENT

STACK AFTER:
```

Core thought:

```text
The stack stores candidates that can still matter.
```

---

# 4. INDEX vs VALUE

## Index stack

When:

```java
st.push(i);
```

then:

```text
st.peek()       → INDEX
arr[st.peek()]  → VALUE
```

Example:

```text
arr = [10, 5, 12, 3]

st.peek() = 2
arr[st.peek()] = 12
```

Read it:

```text
peek()
↓
index
↓
arr[index]
↓
value
```

## Value stack

When:

```java
st.push(arr[i]);
```

then:

```text
st.peek() → VALUE
```

## Pair stack

When:

```java
st.push(new Pair(value, index));
```

one stack item contains:

```text
value + index
```

Use this when both pieces of information are needed.

---

# 5. peek / pop / push

```text
[ 2 | 5 | 8 ]
            ↑
           TOP
```

```java
st.peek()
```

→ inspect `8`  
→ stack unchanged.

```java
st.pop()
```

→ remove `8`.

```java
st.push(x)
```

→ add `x`.

Pattern meaning:

```text
peek → inspect
pop  → reject useless candidate
push → save current for future elements
```

---

# 6. WHY `while`

Suppose:

```text
current = 8

top candidates:
3, 5, 6, 10
```

For a greater pattern:

```text
8 >= 3  → pop
8 >= 5  → pop
8 >= 6  → pop
8 >= 10 → stop
```

Therefore:

```text
while
→ remove every currently useless candidate

if
→ remove at most one
```

After every pop:

```text
new top = next candidate
```

and it must be checked.

---

# 7. WHY THE POP CONDITION WORKS

For **greater**:

```text
candidate <= current
→ candidate is not greater
→ candidate cannot answer current
→ pop
```

For **smaller**:

```text
candidate >= current
→ candidate is not smaller
→ candidate cannot answer current
→ pop
```

For strict greater/smaller relationships, equality is removed too.

---

# 8. NGE — NEXT GREATER ELEMENT

### Meaning

```text
nearest/first greater element on the RIGHT
```

Derive:

```text
Next
→ RIGHT
→ scan RIGHT → LEFT

Greater
→ pop <= current
```

### Base code

```java
Stack<Integer> st = new Stack<>();
int[] ans = new int[n];

for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
        st.pop();
    }

    ans[i] = st.isEmpty() ? -1 : arr[st.peek()];

    st.push(i);
}
```

### Unique addition

```text
This is the base Pattern 1 form:
INDEX STACK + direct VALUE answer
```

---

# 9. NGE II — CIRCULAR ARRAY

### Global pattern

Still:

```text
NEXT + GREATER
```

so the monotonic condition remains:

```text
pop <= current
```

### Unique addition

The right side wraps around:

```text
last → first
```

So the candidate range must cover the circular continuation.

Your practiced code uses a stack setup before the main right-to-left NGE pass.

Revision idea:

```text
NGE stays the same.
Only the searchable right side becomes circular.
```

---

# 10. NSE — NEXT SMALLER ELEMENT

### Meaning

```text
nearest/first smaller element on the RIGHT
```

Derive:

```text
Next → right → left
Smaller → pop >= current
```

### Base code

```java
while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
    st.pop();
}

ans[i] = st.isEmpty() ? -1 : arr[st.peek()];
st.push(i);
```

### Unique addition

Only the relationship changes:

```text
NGE → pop <=
NSE → pop >=
```

---

# 11. PGE — PREVIOUS GREATER ELEMENT

### Meaning

```text
nearest/first greater element on the LEFT
```

Derive:

```text
Previous → left → right
Greater  → pop <= current
```

### Base code

```java
for (int i = 0; i < n; i++) {

    while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
        st.pop();
    }

    pge[i] = st.isEmpty() ? -1 : st.peek();

    st.push(i);
}
```

### Unique addition

Here the stored result can be the:

```text
CANDIDATE INDEX
```

so:

```text
pge[i]      → index
arr[pge[i]] → value
```

---

# 12. PSE — PREVIOUS SMALLER ELEMENT

### Meaning

```text
nearest/first smaller element on the LEFT
```

Derive:

```text
Previous → left → right
Smaller  → pop >= current
```

### Base code

```java
while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
    st.pop();
}

pse[i] = st.isEmpty() ? -1 : st.peek();
st.push(i);
```

### Unique addition

PSE is:

```text
PGE
+
switch Greater → Smaller
```

So the main change is:

```text
pop <=
→
pop >=
```

---

# 13. NGE I — HASHMAP + VALUE STACK

### Structure

```text
A = query array
B = reference array
```

Think:

```text
B → build knowledge
A → query knowledge
```

### Unique addition

The stack stores values:

```java
st.push(B[i]);
```

so:

```text
st.peek() → VALUE
```

The map stores:

```text
VALUE → NGE VALUE
```

Short form:

```java
for (int i = m - 1; i >= 0; i--) {

    while (!st.isEmpty() && B[i] >= st.peek()) {
        st.pop();
    }

    int answer = st.isEmpty() ? -1 : st.peek();

    map.put(B[i], answer);
    st.push(B[i]);
}
```

Then:

```java
map.get(A[i])
```

uses the query value as the key.

---

# 14. NGE I — TWO-STAGE DRY RUN

### Stage 1

```text
B
↓
monotonic stack
↓
value → NGE map
```

For each value:

```text
current = B[i]
check top
pop useless values
remaining top = NGE
map.put(current, answer)
push current
```

### Stage 2

```text
A
↓
map.get(A[i])
↓
answer
```

### Unique structural idea

```text
Normal NGE:
index → answer

NGE I:
value → answer
```

---

# 15. LOOP-BOUND RULE FOR TWO ARRAYS

If:

```text
A size = n
B size = m
```

then:

```text
traversing A → use n
traversing B → use m
```

Example:

```java
for (int i = m - 1; i >= 0; i--)
```

means:

```text
this loop is traversing B
```

---

# 16. MAP KEY / VALUE CHECK

If:

```java
map.put(B[i], answer);
```

then:

```text
KEY   = B[i] value
VALUE = NGE answer
```

Therefore:

```java
map.get(A[i])
```

asks:

```text
“What is the stored answer for this actual value?”
```

while:

```java
map.get(i)
```

asks for the key represented by an index.

General rule:

```text
What did I use as the key in put()?
Use the same kind of thing in get().
```

---

# 17. DAILY TEMPERATURES — NGE + DISTANCE

### Global pattern

```text
Next Greater
```

### Unique addition

The output is not the greater temperature.

It is:

```text
future index - current index
```

Therefore:

```text
STACK = INDEXES
```

Short form:

```java
while (!st.isEmpty()
       && temperatures[st.peek()] <= temperatures[i]) {
    st.pop();
}

days[i] = st.isEmpty()
        ? 0
        : st.peek() - i;

st.push(i);
```

Pattern lesson:

```text
candidate relationship stays NGE
answer calculation becomes DISTANCE
```

---

# 18. STOCK SPAN — PGE + SPAN

### Global pattern

```text
Previous Greater
```

### Unique addition

The answer is a span based on the previous greater boundary.

Concept:

```text
previous greater index
↓
current index - boundary index
↓
span
```

When no previous greater exists:

```text
boundary = -1
span = i - (-1)
```

---

# 19. STOCK SPAN — PAIR STACK

Your `calculateSpan` code uses:

```java
class Pair {
    int idx;
    int val;
}
```

and:

```java
Stack<Pair> st;
```

### Unique addition

One stack item contains both:

```text
value + index
```

So:

```java
st.peek().val
```

is used for comparison, while:

```java
st.peek().idx
```

is used for the span boundary.

Short form:

```java
while (!st.isEmpty() && st.peek().val <= arr[i]) {
    st.pop();
}

span[i] = st.isEmpty()
        ? i - (-1)
        : i - st.peek().idx;

st.push(new Pair(arr[i], i));
```

---

# 20. ONLINE STOCK SPANNER — STREAMING VARIATION

Your class uses:

```java
Stack<Integer> index;
Stack<Integer> value;
int idx;
```

### Unique addition

There is no full array traversal.

```text
price arrives
↓
process immediately
↓
return span
```

Two synchronized stacks hold:

```text
value stack → price
index stack → position
```

When one candidate is removed:

```java
value.pop();
index.pop();
```

Both pieces are removed together.

Empty-stack case:

```java
span = idx + 1;
```

which represents:

```text
no previous greater boundary
→ boundary = -1
→ span = idx - (-1)
```

---

# 21. VISIBLE PEOPLE — MONOTONIC STACK + COUNT

Your implementation uses:

```java
st.push(heights[i]);
```

so:

```text
STACK = VALUES
```

### Unique addition

The output is a:

```text
COUNT
```

For current height:

```text
pop shorter/equal people
+
count each popped person
+
if a taller blocker remains, count it
```

Short form:

```java
while (!st.isEmpty() && st.peek() <= heights[i]) {
    count++;
    st.pop();
}

if (!st.isEmpty()) {
    count++;
}
```

The core stack relationship remains monotonic; the output calculation changes to visibility count.

---

# 22. LINKED LIST → ARRAY → NGE

A singly linked list naturally moves:

```text
head → next → next → ...
```

but NGE processing is commonly:

```text
right → left
```

### Unique addition

Change the representation:

```text
Linked List
↓
count nodes
↓
copy values into array
↓
run NGE
```

Node meanings:

```text
temp       → Node
temp.data  → value
temp.next  → next Node
```

Count with:

```java
while (temp != null)
```

so the last node is included.

---

# 23. LINKED-LIST NGE — VALUE STACK VARIATION

Your latest solution uses:

```java
st.push(arrVal[n - 1]);
```

and:

```java
st.push(arrVal[i]);
```

Therefore:

```text
STACK = VALUES
```

So:

```java
st.peek()
```

already returns the candidate value.

### Unique addition

```text
Linked List
+
array conversion
+
value-stack NGE
```

The NGE logic itself remains the same.

---

# 24. SENTINELS

Always read the problem statement.

Possible conventions:

```text
-1 → no answer
0  → no answer, when specified
```

Keep these meanings separate:

```text
index sentinel
```

and:

```text
answer sentinel
```

Never do:

```java
arr[-1]
```

when `-1` means:

```text
no valid candidate index
```

---

# 25. ARRAY BOUNDARIES

Valid indexes:

```text
0 ... n - 1
```

If using:

```java
arr[i + 1]
```

then:

```text
i + 1 < n
→ i < n - 1
```

Therefore a loop using `arr[i + 1]` must stop before `n - 1`.

The last element has no right neighbour.

---

# 26. IMMEDIATE vs NEAREST vs ALL

## Immediate

```text
immediate smaller
immediate greater
```

means:

```text
direct neighbour
```

Example:

```java
arr[i + 1]
```

No monotonic stack is automatically needed.

## Nearest / First

Strong Pattern 1 signal:

```text
next greater
previous greater
next smaller
previous smaller
nearest greater
nearest smaller
first greater/smaller
```

## ALL

If the problem asks:

```text
all smaller
all greater
count all smaller
count all greater
```

do not automatically use the standard nearest-element stack.

First classify:

```text
ONE nearest/first
vs
ALL qualifying elements
```

---

# 27. SAME PATTERN, DIFFERENT ANSWER

The candidate relationship can remain the same while the output changes:

```text
NGE
│
├── value
│
├── index
│
└── distance
      └── Daily Temperatures

PGE
│
├── value/index
│
└── span
      └── Stock Span
```

Another variation:

```text
monotonic candidates
+
count
→ visibility
```

So always ask:

```text
What does the surviving top give me?
What does the problem actually want me to output?
```

---

# 28. STRUCTURE VARIATIONS YOU HAVE PRACTICED

```text
ARRAY
  ↓
NGE / NSE / PGE / PSE

ARRAY + HASHMAP
  ↓
value → answer

ARRAY + PAIR
  ↓
(value, index)

STREAMING
  ↓
online PGE + span

LINKED LIST
  ↓
array conversion
  ↓
NGE

CIRCULAR ARRAY
  ↓
expanded/wrapped candidate range
  ↓
NGE
```

---

# 29. SOLVED PATTERN 1 SET

```text
☑️ Next Greater Element I
☑️ Next Greater Element II
☑️ Next Smaller Element
☑️ Previous Greater Element
☑️ Previous Smaller Element
☑️ Daily Temperatures
☑️ Stock Span
☑️ Online Stock Span
☑️ Visible People in a Queue
☑️ Next Greater Node in Linked List
```

### Variation coverage

```text
☑️ index stack
☑️ value stack
☑️ pair stack
☑️ synchronized stacks
☑️ HashMap
☑️ circular input
☑️ linked-list input
☑️ online input
☑️ value output
☑️ index output
☑️ distance output
☑️ span output
☑️ count output
```

---

# 30. PROBLEMS KEPT FOR LATER STACK PATTERNS

These are important Stack Part 2 problems, but they are not Pattern 1 core:

```text
Largest Rectangle in Histogram
Maximal Rectangle
Histogram boundary problems
Contribution / subarray problems
```

Pattern 1 should stay focused on:

```text
nearest/first
+
greater/smaller
+
distance/span/visibility variations
```

---

# 31. REVISION DRILL

## Pass 1 — Derive the four

Without code:

```text
NGE → direction + pop
NSE → direction + pop
PGE → direction + pop
PSE → direction + pop
```

## Pass 2 — Identify storage

```java
st.push(i)
```

→ index

```java
st.push(arr[i])
```

→ value

```java
st.push(new Pair(arr[i], i))
```

→ pair

## Pass 3 — Dry run

Write:

```text
current
stack
top
comparison
pop
new top
answer
push
```

## Pass 4 — Identify the variation

Ask:

```text
What changed?

value → distance?
value → span?
array → circular?
array → linked list?
offline → online?
direct answer → HashMap?
index stack → value stack?
```

## Pass 5 — New problem

Close the sheet and derive:

```text
IDENTIFY → STORE → DIRECTION → POP → TOP → ANSWER → PUSH
```

---

# 32. FINAL MASTER CHECK

For a new problem, explain:

```text
1. What exactly is required?
2. Immediate, nearest/first, or ALL?
3. Previous or next?
4. Greater or smaller?
5. Why is a stack useful?
6. What does the stack store?
7. Why index/value/pair?
8. Which direction?
9. Why is the top useful?
10. Why is a popped candidate useless?
11. Why while?
12. What does peek() represent?
13. If peek is an index, what does arr[peek] represent?
14. What happens when the stack is empty?
15. What sentinel is required?
16. What is the final output: value/index/distance/span/count?
17. What is the one unique variation from the global template?
```

---

# 33. MASTER MENTAL TEMPLATE

```text
IDENTIFY
   ↓
STORE
   ↓
DIRECTION
   ↓
POP USELESS CANDIDATES
   ↓
TOP = BEST SURVIVING CANDIDATE
   ↓
CONVERT TOP INTO REQUIRED ANSWER
   ↓
PUSH CURRENT
```

### Final line

```text
Pattern 1 = one global monotonic-stack idea
           + small variations in storage, direction, structure, and output.
```
