# STACK — PATTERN 3 MASTER REVISION
## Matrix + Stack — Binary Matrix → Histogram → Largest Rectangle

> **Goal:** Pattern 3 reuses Pattern 2 instead of introducing a completely new stack idea.
>
> ```text
> 2D binary matrix
>      ↓
> convert each row into histogram heights
>      ↓
> Pattern 2: PSE + NSE
>      ↓
> Largest Rectangle
>      ↓
> maximum rectangle over all rows
> ```
>
> **Global idea first. Problem-specific code stays short.**

---

# 1. GLOBAL TEMPLATE

```text
MATRIX
  ↓
Process one row at a time
  ↓
Maintain HEIGHT of consecutive 1s in each column
  ↓
Current row becomes a HISTOGRAM
  ↓
Solve Largest Rectangle in Histogram
  ↓
Update global maximum
```

The stack part is still:

```text
Histogram
   ↓
PSE + NSE
   ↓
usable width
   ↓
height × width
```

So:

```text
Pattern 2 = histogram
Pattern 3 = matrix → repeated histograms
```

---

# 2. RECOGNITION

Strong signals:

```text
binary matrix
0 / 1 matrix
all 1s
largest rectangle
maximum rectangle
consecutive 1s
rectangle of 1s
```

Think:

```text
MATRIX
↓
Can each row be represented as heights?
↓
YES
↓
HISTOGRAM
↓
Pattern 2
```

---

# 3. THE MOST IMPORTANT TRANSFORMATION

Suppose:

```text
matrix

1 1 0 1
1 1 1 1
0 1 1 1
```

For every column maintain:

```text
height[col]
=
number of consecutive 1s ending at current row
```

### Row 1

```text
1 1 0 1
```

becomes:

```text
height = [1, 1, 0, 1]
```

### Row 2

```text
1 1 1 1
```

update:

```text
height = [2, 2, 1, 2]
```

### Row 3

```text
0 1 1 1
```

update:

```text
height = [0, 3, 2, 3]
```

Every row now behaves like:

```text
a histogram
```

---

# 4. GLOBAL DRY RUN

For every matrix row:

```text
ROW:
COLUMN:
MATRIX[row][col]:

Is it '1'?
    YES → height[col]++
    NO  → height[col] = 0

CURRENT HISTOGRAM:

Largest Rectangle in Histogram:
    PSE
    NSE
    width
    area

Update max
```

The main question is:

```text
What does height[col] mean right now?
```

Answer:

```text
How many consecutive 1s end at this row in this column.
```

---

# 5. HEIGHT UPDATE

Core code:

```java
if (matrix[row][col] == '1') {
    height[col]++;
} else {
    height[col] = 0;
}
```

Read it:

```text
Current cell = 1
→ continue the vertical run
→ increase height

Current cell = 0
→ rectangle cannot cross this position
→ reset height to 0
```

### Unique addition

Pattern 2 worked directly on:

```text
heights[]
```

Pattern 3 creates `heights[]` repeatedly from:

```text
matrix[][]
```

---

# 6. WHY `height[col] = 0`?

Suppose before the row:

```text
height = [3, 2, 4]
```

Current row:

```text
1 0 1
```

After update:

```text
3+1 = 4
2 → 0
4+1 = 5
```

So:

```text
height = [4, 0, 5]
```

Why reset the middle column?

Because a zero means:

```text
there is no consecutive vertical chain of 1s here
```

Any rectangle of 1s cannot continue through that column from earlier rows.

---

# 7. CORE HISTOGRAM STEP

After updating one row:

```java
int area = maxAreaHelp(height);
```

That helper is Pattern 2:

```text
PSE
+
NSE
+
width
+
area
```

Then:

```java
maxArea = Math.max(maxArea, area);
```

### Unique addition

There is now a second maximum:

```text
histogram maximum
+
matrix maximum
```

So:

```text
row maximum
→ update global maximum
```

---

# 8. MAXIMAL RECTANGLE — MASTER STRUCTURE

```java
public int maximalRectangle(char[][] matrix) {

    int maxArea = 0;

    int rowLen = matrix.length;
    int colLen = matrix[0].length;

    int[] height = new int[colLen];

    for (int row = 0; row < rowLen; row++) {

        for (int col = 0; col < colLen; col++) {

            if (matrix[row][col] == '1') {
                height[col]++;
            } else {
                height[col] = 0;
            }
        }

        int area = maxAreaHelp(height);

        maxArea = Math.max(maxArea, area);
    }

    return maxArea;
}
```

Do not memorize this as a new algorithm.

Think:

```text
for each row
    build histogram
    solve Pattern 2
    update maximum
```

---

# 9. HISTOGRAM HELPER — REUSE PATTERN 2

The helper can use:

```text
NSE
PSE
```

and then:

```text
start = pse[i] + 1
end   = nse[i] - 1
width = end - start + 1
area  = width * height[i]
```

So Pattern 3 is literally:

```text
Matrix
→ histogram
→ Pattern 2 helper
```

---

# 10. ROW / COLUMN MEANING

When reading:

```java
matrix[row][col]
```

remember:

```text
row = which row?
col = which column?
```

Example:

```text
matrix[2][3]
```

means:

```text
row 2
column 3
```

The height array is indexed by:

```text
column
```

because each column keeps one vertical run:

```text
height[col]
```

---

# 11. MATRIX → HISTOGRAM DRY RUN

Example:

```text
matrix =
1 1 0
1 1 1
1 0 1
```

### Row 0

```text
1 1 0

height:
[1, 1, 0]
```

Histogram:

```text
█ █
█ █
```

Largest rectangle:

```text
2 × 1 = 2
```

---

### Row 1

Input row:

```text
1 1 1
```

Update:

```text
height[0] = 2
height[1] = 2
height[2] = 1
```

So:

```text
[2, 2, 1]
```

The rectangle:

```text
2 2
```

has:

```text
height = 2
width = 2
area = 4
```

---

### Row 2

Input:

```text
1 0 1
```

Update:

```text
height[0] = 3
height[1] = 0
height[2] = 2
```

So:

```text
[3, 0, 2]
```

Largest rectangle here:

```text
max(3, 2) = 3
```

Global answer remains:

```text
4
```

---

# 12. HOW TO THINK ABOUT A RECTANGLE

For any row:

```text
height array
```

represents:

```text
vertical height of consecutive 1s
```

A histogram rectangle then represents:

```text
a rectangle of 1s ending at the current row
```

Therefore:

```text
histogram rectangle
=
matrix rectangle whose bottom edge is current row
```

This is the key proof idea.

Every all-1 rectangle has some bottom row.

When we process that bottom row:

```text
its columns appear in height[]
```

and the histogram algorithm can find it.

---

# 13. WHY THE TRANSFORMATION WORKS

Suppose an all-1 rectangle ends at row `r`.

For every column inside that rectangle:

```text
matrix[r][col] = 1
```

and the previous rows underneath also contain `1`.

So:

```text
height[col]
```

is at least the rectangle's height.

The histogram therefore contains the exact horizontal span needed for that rectangle.

So:

```text
every matrix rectangle
→ represented by a histogram at its bottom row
```

and checking every row finds the maximum.

---

# 14. INDEX vs VALUE INSIDE THE HELPER

The same Pattern 2 rule remains.

If:

```java
st.push(i);
```

then:

```text
st.peek()          → index
height[st.peek()]  → height value
```

Always write both during a dry run:

```text
TOP INDEX
TOP HEIGHT
```

The matrix does not change the meaning of the stack.

---

# 15. PSE + NSE INSIDE MAXIMAL RECTANGLE

For histogram:

```text
PSE[i] = nearest smaller to left
NSE[i] = nearest smaller to right
```

Then:

```text
start = PSE[i] + 1
end   = NSE[i] - 1
width = end - start + 1
area  = height[i] * width
```

Pattern 3 does not change this.

Only:

```text
height[]
```

is created from the matrix.

---

# 16. DUPLICATE HEIGHTS

In the histogram helper, your practiced comparison is:

```java
height[st.peek()] >= height[i]
```

So equal heights are popped.

The important reasoning remains:

```text
equal is not smaller
```

and the implementation chooses one representative boundary.

The matrix layer does not change this tie rule.

---

# 17. EMPTY BOUNDARIES

Inside the histogram helper:

```text
no smaller on LEFT
→ PSE = -1

no smaller on RIGHT
→ NSE = n
```

Then:

```text
start = PSE + 1
end = NSE - 1
```

These are boundaries, not values to access.

Never:

```java
height[-1]
height[n]
```

---

# 18. TWO LEVELS OF MAXIMUM

Pattern 3 has:

```text
LEVEL 1
largest rectangle in current histogram

LEVEL 2
largest rectangle among all row histograms
```

So code naturally has:

```java
int area = maxAreaHelp(height);

maxArea = Math.max(maxArea, area);
```

### Unique addition

Pattern 2:

```text
one histogram → one answer
```

Pattern 3:

```text
many histograms → global maximum
```

---

# 19. BOUNDARIES OF THE MATRIX

Before coding, check:

```text
matrix.length
matrix[0].length
```

Meanings:

```text
matrix.length
→ number of rows

matrix[0].length
→ number of columns
```

Then:

```java
for (int row = 0; row < rowLen; row++)
```

and:

```java
for (int col = 0; col < colLen; col++)
```

---

# 20. IMPORTANT EMPTY-MATRIX CASE

If the platform/problem allows:

```text
matrix = []
```

then:

```java
matrix[0]
```

is invalid.

So a production-safe implementation should consider:

```java
if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
    return 0;
}
```

Whether you need this exact guard depends on the stated constraints.

The important reasoning is:

```text
Before matrix[0]
→ know that at least one row exists.
```

---

# 21. OTHER MATRIX + STACK VARIATIONS

Once the main transformation is understood, related problems may change only the final calculation.

### Maximum Rectangle of 1s

```text
matrix
→ heights
→ histogram
→ max area
```

Same Pattern 3.

### Count All-1 Rectangles

```text
matrix
→ heights
→ histogram-style counting
```

The input transformation remains the same, but the output is:

```text
COUNT
```

not:

```text
MAX AREA
```

### Count Submatrices With All Ones

Same broad matrix-to-height idea can appear, but the final calculation counts multiple rectangles instead of taking only the maximum.

Do not force every matrix problem into the same exact `largestRectangleArea()` helper.

---

# 22. WHAT DOES NOT BELONG TO THIS EXACT STACK PATTERN?

A matrix problem containing `1`s does not automatically mean Pattern 3.

Examples:

```text
Largest Square of 1s
```

has a different DP-style structure.

So ask:

```text
Is the question asking for a rectangle?
Can each row become histogram heights?
Does width + height define the answer?
```

If yes:

```text
Pattern 3 candidate
```

If not:

```text
do not force the histogram stack
```

---

# 23. GLOBAL DRY RUN FOR A NEW MATRIX PROBLEM

```text
ROW = current row

HEIGHT BEFORE = ?

For each column:
    cell = matrix[row][col]

    if cell is 1:
        height[col]++
    else:
        height[col] = 0

HEIGHT AFTER = ?

Now ask:
    Is this histogram problem?

If yes:
    PSE
    NSE
    width
    area

ROW ANSWER = ?

GLOBAL ANSWER = max(previous, row answer)
```

---

# 24. NEW-PROBLEM CHECKLIST

Before code:

```text
1. Is this a binary matrix?
2. Is the required object a rectangle?
3. Can each column hold consecutive-1 height?
4. What does height[col] mean?
5. What happens on 1?
6. What happens on 0?
7. After one row, is this a histogram?
8. Can I reuse Pattern 2?
9. What are PSE/NSE?
10. What is width?
11. Is output max area, count, or something else?
12. Is there an empty-matrix case?
```

---

# 25. PROBLEM → UNIQUE ADDITION MAP

| Problem | Global idea | Unique addition |
|---|---|---|
| Maximal Rectangle | Matrix → Histogram → Pattern 2 | update heights row by row |
| Maximum Rectangle of 1s | Matrix → Histogram | same transformation |
| Binary Matrix Largest Rectangle | Matrix → Histogram | same transformation |
| Row-wise Histogram Construction | Matrix → Heights | state construction only |
| Count All-1 Rectangles | Matrix → Heights | count instead of maximum |
| Count Submatrices With All Ones | Matrix → Heights | multiple-rectangle contribution |
| Larger constrained binary rectangle | Matrix → Heights | final calculation changes |

---

# 26. SOLVED PATTERN 3

```text
☑️ Maximal Rectangle
```

Your practiced implementation demonstrates:

```text
☑️ row traversal
☑️ column traversal
☑️ height[] construction
☑️ reset height on 0
☑️ reuse histogram helper
☑️ PSE + NSE
☑️ width
☑️ area
☑️ global maximum
```

---

# 27. REVISION DRILL

### Drill 1 — Height

Given:

```text
previous height = [2, 1, 3, 0]
current row    = [1, 0, 1, 1]
```

derive the new:

```text
height = ?
```

### Drill 2 — Histogram

Given:

```text
height = [2, 2, 1]
```

identify the largest rectangle.

### Drill 3 — Boundary

Given:

```text
PSE[i] = 1
NSE[i] = 5
```

calculate:

```text
start
end
width
```

### Drill 4 — Meaning

Explain:

```text
height[col]
```

in one sentence.

### Drill 5 — Transformation

Explain:

```text
matrix
→ height[]
→ histogram
→ Pattern 2
```

---

# 28. MASTER MENTAL TEMPLATE

```text
MATRIX
   ↓
ONE ROW AT A TIME
   ↓
UPDATE height[col]
   ↓
CURRENT ROW = HISTOGRAM
   ↓
PSE + NSE
   ↓
WIDTH
   ↓
AREA / COUNT
   ↓
GLOBAL ANSWER
```

One line:

```text
MATRIX → HEIGHTS → HISTOGRAM → BOUNDARIES → RESULT
```

---

# 29. FINAL PATTERN 3 MINDSET

Do not memorize:

```text
Maximal Rectangle code
```

Think:

```text
“What does one row tell me?”

“How many consecutive 1s are above each column?”

“Can I turn this row into a histogram?”

“Can I reuse Pattern 2?”

“What does the histogram result represent in the matrix?”

“Do I need maximum or count?”
```

The key bridge is:

```text
Pattern 2:
HISTOGRAM → BOUNDARY → AREA

Pattern 3:
MATRIX → HISTOGRAM → BOUNDARY → AREA
```

That is Pattern 3.
