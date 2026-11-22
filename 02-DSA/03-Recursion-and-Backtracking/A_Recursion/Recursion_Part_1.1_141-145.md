# Recursion — Part 2.4
## Grid / Maze Recursion & Backtracking
### Problems 141–145 — Clean Revision File

> Purpose: strengthen the exact grid-recursion pattern, your recurring confusions, and how to recognize when the pattern changes. Keep this as a revision/practice file, not a theory dump.

---

# 1. Problems Covered

| # | Problem | Core Pattern | Status |
|---:|---|---|:---:|
| 141 | Rat in a Maze | DFS + 4 directions + visited + backtracking | ☑️ |
| 142 | Maze Paths | Grid recursion + movement + path generation/counting | ☑️ |
| 143 | Maze Paths with Obstacles | Grid recursion + validity + counting | ☑️ |
| 144 | Directional Maze | Restricted movement + count + maximum | ☑️ |
| 145 | Unique Paths with Obstacles | Grid recursion + obstacles + counting → DP recognition | ☑️ |

---

# 2. The Pattern You Should Reconstruct

```text
STATE
  ↓
CHOICES / DIRECTIONS
  ↓
VALIDATE NEXT POSITION
  ↓
MOVE
  ↓
RECURSE
  ↓
RETURN / UNDO
```

Before writing code:

```text
1. Where am I?             → (row, col)
2. Where can I go?
3. Is the next cell valid?
4. What is the base case?
5. What should this branch return?
6. Do I need visited?
7. If I changed state, what must I undo?
8. Can the same state be reached again?
```

---

# 3. Coordinate Memory

Use this every time:

```text
             col →
          0   1   2
row 0    [ ][ ][ ]
 ↓
row 1    [ ][ ][ ]
row 2    [ ][ ][ ]
```

```text
row → vertical movement
col → horizontal movement
```

Directions:

```text
D → (row + 1, col)
U → (row - 1, col)
R → (row, col + 1)
L → (row, col - 1)
```

### Important

Never decide `L` / `R` from the order in which you wrote the code.

Think from coordinates:

```text
col + 1 = R
col - 1 = L
```

---

# 4. Problem 141 — Rat in a Maze

## State

```text
(row, col)
+
current path
+
visited
```

Because all four directions are available, we can potentially return to an already visited cell.

Therefore:

```text
4 directions
    ↓
cycles possible
    ↓
visited required
```

## Core Pattern

```text
current cell
    ↓
try D
try L
try R
try U
    ↓
validate
    ↓
recurse
    ↓
unmark current cell
```

## Recursion Tree

For a simple open 2×2 maze:

```text
                    (0,0)
                   /     \
                  D       R
                 /         \
              (1,0)       (0,1)
                 |           |
                 R           D
                 |           |
              (1,1) ✓     (1,1) ✓
```

Each edge means:

```text
choose direction
      ↓
move to next cell
      ↓
recurse from there
```

## `visited` Backtracking

```java
visited[row][col] = true;

// explore all valid directions

visited[row][col] = false;
```

Mental model:

```text
ENTER
  ↓
MARK
  ↓
EXPLORE
  ↓
RETURN
  ↓
UNMARK
```

The final `false` means:

> This cell is no longer part of the CURRENT path, so another branch may use it.

---

# 5. Problem 141 — Validity Template

Check the next position before accessing the grid:

```java
static boolean isValid(int row, int col,
                       int[][] grid,
                       boolean[][] visited,
                       int n) {

    if (row < 0 || col < 0 || row >= n || col >= n)
        return false;

    if (grid[row][col] == 0)
        return false;

    if (visited[row][col])
        return false;

    return true;
}
```

### Order to remember

```text
BOUNDARY
   ↓
BLOCKED?
   ↓
VISITED?
   ↓
VALID
```

Why boundary first?

Because this is dangerous:

```java
grid[row][col]
```

if `row` or `col` is outside the grid.

---

# 6. Problem 142 — Maze Paths

This is a simpler grid-recursion pattern.

The important question is:

> What directions does the problem actually allow?

If movement only goes toward the destination:

```text
no backward movement
    ↓
no cycle
    ↓
visited usually unnecessary
```

For counting:

```text
path from child 1
+
path from child 2
=
paths from current cell
```

Generic form:

```java
return solve(next1) + solve(next2);
```

### Generation vs Counting

```text
GENERATE PATHS
→ keep StringBuilder / path
→ store answers

COUNT PATHS
→ return int
→ don't store every path
```

---

# 7. Problem 143 — Maze Paths With Obstacles

Core recursive meaning:

> `solve(row, col)` = number of valid paths from this cell to the destination.

Template:

```java
static int solve(int row, int col, int[][] grid) {

    if (row >= rows || col >= cols)
        return 0;

    if (grid[row][col] == 1)
        return 0;

    if (row == rows - 1 && col == cols - 1)
        return 1;

    return solve(row + 1, col, grid)
         + solve(row, col + 1, grid);
}
```

## Boundary Weakness to Remember

You previously confused:

```java
col >= rows
```

with the correct condition.

For a rectangular grid:

```text
row → rows
col → cols
```

Therefore:

```java
row >= rows
col >= cols
```

---

# 8. Problem 143 — Base Case Order

Think in this order:

```text
OUTSIDE?
   ↓ yes → 0

BLOCKED?
   ↓ yes → 0

DESTINATION?
   ↓ yes → 1

OTHERWISE
   ↓
explore children
```

So:

```text
invalid branch → 0
successful branch → 1
normal branch → combine children
```

For counting:

```text
child answers → SUM
```

---

# 9. Why 143 Can Become TLE

Correct recursion can still be inefficient.

Example:

```text
             (0,0)
            /     \
         (1,0)   (0,1)
            \     /
             (1,1)
```

The same state can be calculated more than once.

This creates:

```text
same state repeatedly
        ↓
overlapping subproblems
        ↓
memoization
        ↓
DP
```

Important:

> TLE does not automatically mean your recursive idea is wrong.

First ask:

```text
Is the recursion logically correct?
        ↓
Are states repeating?
        ↓
Can I cache the result?
```

---

# 10. Problem 144 — Directional Maze

Each cell controls the choices:

```text
1 → Right
2 → Down
3 → Right + Down
```

So don't blindly try four directions.

Pattern:

```text
current cell value
      ↓
allowed direction(s)
      ↓
validate
      ↓
recurse
```

## State

```text
(row, col)
+
current adventure sum
```

The answer contains:

```text
total valid paths
+
maximum adventure
```

So this problem combines:

```text
COUNTING + OPTIMIZATION
```

---

# 11. Problem 144 — Recursion Tree

For:

```text
3 2
1 3
```

```text
                         (0,0)=3
                        /        \
                    Right       Down
                      |            |
                   (0,1)=2     (1,0)=1
                      |            |
                    Down         Right
                      |            |
                   (1,1)=3      (1,1)=3
                      |            |
                    sum=8        sum=7
```

Therefore:

```text
total paths = 2
maximum     = 8
```

---

# 12. Understanding `sum + grid[next]`

If:

```text
current sum = 3
next cell   = 2
```

after moving:

```text
new sum = 3 + 2
        = 5
```

Therefore:

```java
sum + grid[nextRow][nextCol]
```

means:

> Add the value of the cell I am entering.

Starting value is already included:

```java
int sum = grid[0][0];
```

So do NOT add the starting cell twice.

---

# 13. Count vs Maximum

At destination:

```java
count++;
```

means:

```text
I found ONE complete valid path.
```

Maximum:

```java
max = Math.max(max, sum);
```

means:

```text
Is this completed path better than my previous best?
```

Keep them mentally separate:

```text
count → HOW MANY?
max   → HOW GOOD IS THE BEST?
```

---

# 14. Problem 145 — Unique Paths With Obstacles

Your recursive solution was:

```java
static int solve(int row, int col, int[][] obstacleGrid) {

    int rows = obstacleGrid.length;
    int cols = obstacleGrid[0].length;

    if (row >= rows || col >= cols)
        return 0;

    if (obstacleGrid[row][col] == 1)
        return 0;

    if (row == rows - 1 && col == cols - 1)
        return 1;

    return solve(row + 1, col, obstacleGrid)
         + solve(row, col + 1, obstacleGrid);
}
```

This is the **correct recursive model**.

You got TLE.

That is useful learning, because it reveals the next pattern.

---

# 15. Problem 145 — Why TLE Happens

The state is only:

```text
(row, col)
```

Different paths can reach the same cell.

Example:

```text
                 (0,0)
                /     \
             (1,0)   (0,1)
                \       /
                 (1,1)
```

Both branches can ask:

```text
How many paths are there from (1,1)?
```

Pure recursion calculates it again.

So:

```text
recursive state
      ↓
same (row,col) appears again
      ↓
overlapping subproblem
      ↓
memoization / DP
```

This is the important bridge from recursion to DP.

---

# 16. 143 vs 145 — Why They Feel Similar

Both use:

```text
(row, col)
    ↓
check boundary
    ↓
check obstacle
    ↓
destination
    ↓
down + right
```

That is intentional.

The important lesson is:

> Sometimes recursion gives the correct answer but is too slow.

So when you see:

```text
same parameters
+
same question
+
same result
```

think:

```text
CACHE IT
```

---

# 17. Do We Need `visited` in 143 / 145?

No.

Movement is:

```text
Down
Right
```

You cannot move:

```text
Up
Left
```

Therefore you cannot return to a previous cell through these moves.

So:

```text
D/R only
   ↓
no cycle
   ↓
no visited
```

This is different from Rat in a Maze:

```text
D/U/L/R
   ↓
cycles possible
   ↓
visited
```

Never blindly copy the Rat-in-a-Maze template.

---

# 18. Your Main Weaknesses to Strengthen

## 1. Coordinate confusion

Always write:

```text
row = vertical
col = horizontal
```

and:

```text
D → row + 1
U → row - 1
R → col + 1
L → col - 1
```

---

## 2. Current vs next position

Keep this distinction:

```text
current = (row, col)

next = (nextRow, nextCol)
```

Don't mix the two.

---

## 3. Boundary reasoning

Before accessing:

```java
grid[row][col]
```

ask:

```text
Is row valid?
Is col valid?
```

For rectangular grids:

```text
row >= rows
col >= cols
```

---

## 4. Base-case meaning

Don't memorize:

```java
if (...) return ...;
```

Ask what the return means.

```text
outside   → invalid → 0
blocked   → invalid → 0
destination → success → 1
```

---

## 5. Direction labels

Your previous L/R confusion came from attaching the letter to the wrong coordinate update.

Fix it permanently:

```text
y + 1 → R
y - 1 → L
```

---

## 6. Understanding backtracking

Remember:

```text
mark
 ↓
explore
 ↓
return
 ↓
unmark
```

`visited[x][y] = false` means:

> Remove this cell from the current path so a different branch can use it.

---

## 7. Counting vs generating

Ask first:

```text
Do I need the actual paths?
```

If yes:

```text
StringBuilder / path
result list
```

If no:

```text
return count
```

---

## 8. TLE diagnosis

Don't immediately change working recursion.

Ask:

```text
Are the same states repeating?
```

If yes:

```text
memoization
```

This is one of the most important lessons from 143/145.

---

# 19. Reusable Grid Template

Do not memorize a giant implementation.

Reconstruct:

```java
static int solve(int row, int col, ...) {

    // invalid state
    if (...) return ...;

    // destination
    if (...) return ...;

    // choose allowed moves

    int answer1 = solve(...);
    int answer2 = solve(...);

    // combine
    return answer1 + answer2;
}
```

For backtracking with cycles:

```java
visited[row][col] = true;

explore choices;

visited[row][col] = false;
```

For path generation:

```text
choose
→ append
→ recurse
→ remove
```

For grid traversal:

```text
current cell
→ next cell
→ validate
→ recurse
→ restore
```

---

# 20. Recognition Guide

When you see a new grid problem:

### Case A — Four-direction movement

```text
D/U/L/R
```

Think:

```text
DFS
+
visited
+
backtracking
```

### Case B — Only forward movement

```text
D/R
```

Think:

```text
recursion
+
counting
```

Usually no `visited`.

### Case C — Obstacles

Add:

```text
blocked → invalid
```

### Case D — Same `(row,col)` appears repeatedly

Think:

```text
overlapping subproblem
→ memoization
→ DP
```

### Case E — Need actual paths

Think:

```text
path / StringBuilder
+
backtracking
```

### Case F — Need number of paths

Think:

```text
child answers → SUM
```

### Case G — Need best path

Think:

```text
child answers → MAX
```

---

# 21. One Master Recursion Tree

The general grid tree should look like:

```text
                         CURRENT
                       /    |    \
                    choice choice choice
                     /       |       \
                  NEXT     NEXT      NEXT
                   |         |         |
                recurse   recurse   recurse
                   |         |         |
                answer    answer    answer
                    \        |       /
                     \       |      /
                      COMBINE ANSWERS
```

For counting:

```text
answers → SUM
```

For maximum:

```text
answers → MAX
```

For boolean:

```text
answers → OR
```

For generation:

```text
store completed paths
```

---

# 22. Final Master Memory

```text
GRID RECURSION
```

```text
(row, col)
    ↓
What moves are allowed?
    ↓
Is next position valid?
    ↓
Move
    ↓
Recurse
    ↓
What does this branch return?
    ↓
Combine
    ↓
Undo if state was changed
```

For cycles:

```text
enter
 ↓
visited = true
 ↓
explore
 ↓
return
 ↓
visited = false
```

For counting:

```text
child counts → SUM
```

For maximum:

```text
child values → MAX
```

For repeated states:

```text
recursion
   ↓
same state again
   ↓
overlapping subproblem
   ↓
memoization
   ↓
DP
```

---

# 23. Revision Checklist

Before solving a new grid recursion problem, answer these without coding:

```text
□ What is my state?
□ What are my choices?
□ What does row mean?
□ What does col mean?
□ Which direction changes row?
□ Which direction changes col?
□ What makes a position invalid?
□ What is the destination?
□ What does the base case return?
□ Can I revisit a cell?
□ Do I need visited?
□ Am I generating, counting, checking, or optimizing?
□ What should each recursive call return?
□ How do I combine child answers?
□ If I changed state, what must I undo?
□ Can the same state occur through different paths?
□ If yes, is memoization needed?
```

---

# 24. Final Rule

> **Do not memorize the Rat in a Maze code.**

Instead reconstruct:

```text
WHERE AM I?
    ↓
WHERE CAN I GO?
    ↓
IS IT VALID?
    ↓
WHAT HAPPENS AFTER I MOVE?
    ↓
WHAT DOES THE CHILD RETURN?
    ↓
HOW DO I COMBINE IT?
    ↓
WHAT MUST I UNDO?
```

That is the reusable recursion skill behind Problems **141–145**.
