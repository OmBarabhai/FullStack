# STACK — PATTERN 2 MASTER REVISION
## Boundary / Histogram — PSE + NSE + Width + Area + Contribution

> **Goal:** Pattern 2 extends Pattern 1. Instead of only finding one nearest smaller element, use **both left and right smaller boundaries** to determine a valid range and then calculate an area or contribution.

---

# 1. GLOBAL TEMPLATE — USE THIS FIRST

```text
PROBLEM
  ↓
What does one element/bar control?
  ↓
Need LEFT boundary?
  ↓
Need RIGHT boundary?
  ↓
What blocks the range?
  ↓
Previous Smaller + Next Smaller
  ↓
Find usable range
  ↓
Calculate width / area / contribution
```

Core geometry:

```text
PSE[i] = first smaller bar on LEFT
NSE[i] = first smaller bar on RIGHT

usable start = PSE[i] + 1
usable end   = NSE[i] - 1

width = usable end - usable start + 1
      = NSE[i] - PSE[i] - 1
```

For histogram:

```text
area = height[i] × width
```

---

# 2. PATTERN 2 RECOGNITION

Strong signals:

```text
histogram
largest rectangle
maximum rectangle area
bars / heights
consecutive width
left boundary + right boundary
nearest smaller on both sides
```

Think:

```text
HISTOGRAM
   ↓
BOUNDARIES
   ↓
PSE + NSE
   ↓
WIDTH
   ↓
AREA
```

The main question is:

```text
How far can this element extend before a smaller element blocks it?
```

---

# 3. GLOBAL DRY RUN

For every important element/bar:

```text
CURRENT INDEX:
CURRENT HEIGHT / VALUE:

LEFT SMALLER INDEX:
RIGHT SMALLER INDEX:

USABLE START:
USABLE END:

WIDTH:
AREA / CONTRIBUTION:

ANSWER UPDATE:
```

Keep the Pattern 1 mental model:

```text
stack stores candidate indexes
        ↓
peek() = candidate index
        ↓
arr[peek()] = candidate value/height
```

---

# 4. WHY PSE + NSE?

Suppose:

```text
heights = [2, 1, 5, 6, 2, 3]
```

Take:

```text
i = 2
height = 5
```

We want the largest rectangle that can use height `5`.

Look LEFT:

```text
2 at index 1 is smaller than 5
→ it blocks further extension
```

Look RIGHT:

```text
2 at index 4 is smaller than 5
→ it blocks further extension
```

Therefore:

```text
PSE[2] = 1
NSE[2] = 4
```

Usable bars are:

```text
index 2 through index 3
```

So:

```text
start = 1 + 1 = 2
end   = 4 - 1 = 3
width = 3 - 2 + 1 = 2
area  = 5 × 2 = 10
```

---

# 5. SENTINEL BOUNDARIES

If there is no smaller bar on the left:

```text
PSE[i] = -1
```

If there is no smaller bar on the right:

```text
NSE[i] = n
```

These are boundary markers.

They are NOT valid array indexes to access.

Never do:

```java
arr[-1]
arr[n]
```

Use them in boundary arithmetic:

```text
start = PSE[i] + 1
end   = NSE[i] - 1
```

Example:

```text
PSE = -1
NSE = 5

start = 0
end   = 4
width = 5
```

---

# 6. WIDTH — EXPLICIT FORM FIRST

Use:

```java
int start = pse[i] + 1;
int end = nse[i] - 1;
int width = end - start + 1;
```

Example:

```text
PSE[i] = 1
NSE[i] = 5

start = 2
end   = 4
width = 4 - 2 + 1
      = 3
```

Compact form:

```text
width = NSE[i] - PSE[i] - 1
```

Learn the explicit form first because it shows the actual usable range.

---

# 7. GLOBAL NSE BOUNDARY TEMPLATE

```java
Stack<Integer> st = new Stack<>();
int[] nse = new int[n];

for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        st.pop();
    }

    nse[i] = st.isEmpty() ? n : st.peek();
    st.push(i);
}
```

Meaning:

```text
Next Smaller
→ answer is on RIGHT
→ scan RIGHT → LEFT
→ pop >= current
```

---

# 8. GLOBAL PSE BOUNDARY TEMPLATE

```java
Stack<Integer> st = new Stack<>();
int[] pse = new int[n];

for (int i = 0; i < n; i++) {

    while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        st.pop();
    }

    pse[i] = st.isEmpty() ? -1 : st.peek();
    st.push(i);
}
```

Meaning:

```text
Previous Smaller
→ answer is on LEFT
→ scan LEFT → RIGHT
→ pop >= current
```

The Pattern 2 core is therefore built directly from Pattern 1's NSE/PSE knowledge.

---

# 9. LARGEST RECTANGLE IN HISTOGRAM

## Global pattern

For each bar:

```text
Assume this bar is the limiting height.
        ↓
Find PSE
        ↓
Find NSE
        ↓
Find usable width
        ↓
height × width
        ↓
maximum area
```

## Two-pass template

```java
// NSE
for (int i = n - 1; i >= 0; i--) {

    while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        st.pop();
    }

    nse[i] = st.isEmpty() ? n : st.peek();
    st.push(i);
}

// PSE
st = new Stack<>();

for (int i = 0; i < n; i++) {

    while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
        st.pop();
    }

    pse[i] = st.isEmpty() ? -1 : st.peek();
    st.push(i);
}

// Area
for (int i = 0; i < n; i++) {

    int start = pse[i] + 1;
    int end = nse[i] - 1;
    int width = end - start + 1;
    int area = width * heights[i];

    maxArea = Math.max(maxArea, area);
}
```

### Unique addition

Pattern 1:

```text
find nearest smaller
```

Pattern 2:

```text
find nearest smaller on BOTH sides
→ treat them as boundaries
→ calculate range
→ calculate area
```

---

# 10. HISTOGRAM — DRY RUN

Example:

```text
heights = [2, 1, 5, 6, 2, 3]
```

For bar `5` at index `2`:

```text
left smaller  = index 1
right smaller = index 4
```

Therefore:

```text
usable range = [2 ... 3]
width = 2
area = 5 × 2 = 10
```

Visual:

```text
index:   0  1  2  3  4  5
height:  2  1  5  6  2  3
               ┌──┐
               │  │
               │  │  ← height 5
            ┌──┼──┤
            │  │  │
            └──┴──┘
               ←2→
```

The exact drawing is less important than the boundary idea:

```text
smaller LEFT blocker
        ↓
usable bars
        ↓
smaller RIGHT blocker
```

---

# 11. TWO-PASS vs ONE-PASS

## Two-pass

```text
Pass 1 → NSE
Pass 2 → PSE
Pass 3 → area
```

Useful for learning because:

```text
left boundary is explicit
right boundary is explicit
width is explicit
```

## One-pass

When the current smaller bar arrives:

```text
current smaller bar
        ↓
right boundary of popped bar is known
        ↓
new stack top gives left boundary
        ↓
calculate popped bar's area
```

### Unique addition

One-pass is not a new pattern.

It is:

```text
same PSE/NSE boundary idea
        ↓
calculated at the moment a boundary becomes known
```

---

# 12. STACK MEANING IN HISTOGRAM

The stack stores:

```text
INDEXES
```

Therefore:

```java
st.peek()
```

is:

```text
INDEX
```

and:

```java
heights[st.peek()]
```

is:

```text
HEIGHT
```

Dry-run with both:

```text
TOP INDEX:
TOP HEIGHT:
```

This keeps the Pattern 1 index/value model active inside Pattern 2.

---

# 13. WHY `>=` FOR PSE/NSE?

We want a **strictly smaller** boundary.

Therefore an equal height is not smaller:

```text
equal >= current
→ not a valid smaller boundary
→ pop
```

Your two-pass histogram implementation uses:

```java
heights[st.peek()] >= heights[i]
```

for both sides.

When implementing a different boundary problem, always check the exact wording and tie convention.

---

# 14. DO NOT PUSH THE SENTINEL `n`

If there is no smaller element on the right:

```text
NSE[i] = n
```

But:

```text
n
```
is not a valid array index.

So:

```text
nse[i] = n
```

is correct as a boundary.

But:

```java
st.push(n);
```

would make the stack contain an invalid array index for the normal index-stack template.

---

# 15. MAXIMAL RECTANGLE — MATRIX → HISTOGRAM

This is the bridge from one-dimensional histogram to a matrix.

For every matrix row:

```text
matrix row
↓
update histogram heights
↓
largest rectangle in histogram
```

### Height update

```java
if (matrix[row][col] == '1') {
    height[col]++;
} else {
    height[col] = 0;
}
```

Meaning:

```text
height[col]
=
number of consecutive 1s ending at current row
```

Then:

```java
int area = maxAreaHelp(height);
```

### Unique addition

```text
2D matrix
→ many 1D histograms
→ reuse Pattern 2 histogram logic
```

---

# 16. MAXIMAL RECTANGLE — ROW DRY RUN

Example:

```text
1 1 0
1 1 1
1 1 1
```

After row 1:

```text
1 1 0
```

After row 2:

```text
2 2 1
```

After row 3:

```text
3 3 2
```

Each row becomes:

```text
histogram
```

Then:

```text
PSE + NSE
→ largest rectangle
```

The matrix itself is not a new stack pattern.

It repeatedly creates the histogram input required by Pattern 2.

---

# 17. SUM OF SUBARRAY MINIMUMS — CONTRIBUTION

Pattern 2 can change from:

```text
area
```

to:

```text
contribution
```

Instead of thinking:

```text
height × width
```

think:

```text
How many subarrays use arr[i] as their minimum?
```

Find the smaller boundaries and count choices.

Conceptually:

```text
left choices × right choices
```

Then:

```text
contribution = arr[i] × left choices × right choices
```

### Unique addition

Histogram:

```text
height × width
```

Subarray minimums:

```text
value × number of valid left choices × number of valid right choices
```

Same boundary engine; different calculation.

---

# 18. SUM OF SUBARRAY RANGES

A range is:

```text
maximum - minimum
```

So conceptually:

```text
sum of ranges
=
sum of subarray maximums
-
sum of subarray minimums
```

Both sides can use monotonic boundary logic.

### Unique addition

Run the contribution idea for:

```text
minimum
```

and:

```text
maximum
```

Then combine them.

---

# 19. MAXIMUM WIDTH RAMP

A width ramp is about choosing useful index pairs.

A monotonic stack can preserve candidate left indexes that may produce a large width later.

### Unique addition

The stack is used as a:

```text
filtered candidate-index structure
```

rather than directly asking:

```text
what is my nearest smaller?
```

The reusable Pattern 2 lesson is:

```text
monotonic stack can preserve only the useful boundary/candidate indexes
```

---

# 20. REMOVE NODES FROM LINKED LIST

A similar monotonic idea appears with linked-list values.

Conceptually:

```text
current node
↓
if a larger value exists later
↓
current node can be removed
```

A monotonic stack can maintain the nodes that survive.

### Unique addition

The structure changes from:

```text
array indexes
```

to:

```text
linked-list nodes / values
```

but the survival idea is still:

```text
keep candidates that remain useful
remove dominated candidates
```

---

# 21. WHAT CHANGED FROM PATTERN 1?

Pattern 1:

```text
Find nearest greater/smaller.
```

Pattern 2:

```text
Find smaller boundaries on BOTH sides.
        ↓
Create a usable range.
        ↓
Calculate area / contribution / width.
```

Therefore:

```text
Pattern 1
PSE / NSE
      ↓
Pattern 2
PSE + NSE
      ↓
range
      ↓
calculation
```

---

# 22. PROBLEM → UNIQUE ADDITION MAP

| Problem | Global Pattern | Unique addition |
|---|---|---|
| Largest Rectangle in Histogram | PSE + NSE | width × height |
| Largest Rectangle — Two Pass | PSE + NSE | explicit boundary arrays |
| Largest Rectangle — One Pass | PSE + NSE | calculate when right boundary appears |
| Largest Rectangle With Equal Heights | PSE + NSE | duplicate/tie handling |
| Maximum Rectangle Area From Bars | PSE + NSE | area interpretation |
| Sum of Subarray Minimums | PSE + NSE | value × left choices × right choices |
| Sum of Subarray Ranges | min/max boundaries | max contribution − min contribution |
| Maximum Width Ramp | monotonic candidate stack | preserve useful index candidates |
| Remove Nodes From Linked List | monotonic survival | later larger values remove dominated nodes |
| Maximal Rectangle | histogram | matrix → repeated histograms |

---

# 23. YOUR PRACTICED CORE

```text
☑️ Largest Rectangle in Histogram
☑️ Maximal Rectangle
☑️ Remove Nodes From Linked List
```

Your Largest Rectangle implementation uses:

```text
NSE array
PSE array
explicit start/end
width
area
```

The important formula to recall is:

```text
start = PSE[i] + 1
end   = NSE[i] - 1
width = end - start + 1
area  = width × heights[i]
```

---

# 24. REVISION DRILL

### Drill 1 — Boundary

Given a bar:

```text
height[i] = ?
```

find:

```text
PSE[i] = ?
NSE[i] = ?
```

### Drill 2 — Geometry

Given:

```text
PSE = ?
NSE = ?
```

calculate:

```text
start
end
width
area
```

### Drill 3 — Sentinel

Explain why:

```text
PSE = -1
NSE = n
```

but:

```text
stack indexes = 0 ... n-1
```

### Drill 4 — Contribution

Ask:

```text
How many subarrays can use arr[i] as their minimum?
```

Then think:

```text
left choices
×
right choices
×
arr[i]
```

---

# 25. NEW-PROBLEM CHECKLIST

Before writing code:

```text
1. Is this about a range controlled by smaller/larger blockers?
2. Is it a histogram or rectangle problem?
3. Do I need the nearest smaller on the LEFT?
4. Do I need the nearest smaller on the RIGHT?
5. What does the stack store?
6. What are the boundary sentinels?
7. What is the usable start/end?
8. Am I calculating width, area, or contribution?
9. What happens with equal heights?
10. Would two passes be clearer, or can I derive a one-pass version?
```

---

# 26. MASTER MENTAL TEMPLATE

```text
IDENTIFY LIMITING ELEMENT
        ↓
LEFT SMALLER BOUNDARY
        ↓
RIGHT SMALLER BOUNDARY
        ↓
USABLE RANGE
        ↓
WIDTH / CHOICES
        ↓
AREA / CONTRIBUTION
        ↓
UPDATE ANSWER
```

One line:

```text
BOUNDARIES → RANGE → CALCULATION
```

---

# 27. FINAL MINDSET

Do not memorize the histogram code line by line.

Ask:

```text
What stops this bar on the left?
What stops this bar on the right?
What lies between those blockers?
What does the problem ask me to calculate from that range?
```

That is Pattern 2.
