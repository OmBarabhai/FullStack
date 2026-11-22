# 🔒 PART 1 — EXPRESSION → GRID / MAZE BACKTRACKING

> Goal: strengthen recursion by learning how the **state changes** when recursion moves from strings/partitions to a grid.

---

## 1. What this part is teaching

```text
Simple recursion
      ↓
Backtracking
      ↓
Partition recursion
      ↓
Grid recursion
      ↓
State = (row, col)
      ↓
Try directions
      ↓
Validate
      ↓
Recurse
      ↓
Undo / Backtrack
      ↓
Counting recursion
      ↓
DP recognition
```

The important shift is:

```java
// Earlier
solve(idx, ...)

// Grid
solve(row, col, ...)
```

---

# 2. Master Grid Pattern

When a problem asks you to move through a matrix:

```text
(row, col)
    ↓
try a move
    ↓
is the next cell valid?
    ↓
YES → move
    ↓
recurse
    ↓
return
    ↓
undo state
    ↓
try next move
```

### Recognition

Think **Grid Backtracking** when you see:

- matrix / grid
- maze
- paths
- move up/down/left/right
- visit cells
- find all paths
- word search
- cannot reuse a cell
- obstacles / blocked cells

---

# 3. Universal Grid Template

```java
static void solve(int row, int col, ...) {

    // BASE CASE

    // mark current state

    // try direction 1
    // if valid → recurse

    // try direction 2
    // if valid → recurse

    // try direction 3
    // if valid → recurse

    // try direction 4
    // if valid → recurse

    // UNDO current state
}
```

For four directions:

```text
        U
        ↑
L ←   CELL   → R
        ↓
        D
```

Coordinates:

```java
D → row + 1
U → row - 1
R → col + 1
L → col - 1
```

---

# 4. The Most Important Rule: Validate Before Moving

Do not directly access:

```java
grid[newRow][newCol]
```

until you know the coordinates are valid.

A reusable validator:

```java
static boolean isValid(
        int[][] grid,
        boolean[][] visited,
        int row,
        int col,
        int n) {

    if (row < 0 || col < 0 || row >= n || col >= n) {
        return false;
    }

    if (grid[row][col] == 0) {
        return false;
    }

    if (visited[row][col]) {
        return false;
    }

    return true;
}
```

Mental order:

```text
1. Inside grid?
2. Open cell?
3. Not already visited?
4. Then recurse.
```

---

# 5. Problem 141 — Rat in a Maze

## Core idea

Find **all valid paths** from:

```text
(0,0) → (n-1,n-1)
```

Cells with `0` are blocked.

Because movement can go in four directions, we need `visited`.

### Pattern

```text
current cell
     ↓
mark visited
     ↓
try D
try L
try R
try U
     ↓
unmark current cell
```

---

## Recursion Tree — small example

For:

```text
1 1
1 1
```

Start `(0,0)`:

```text
                 (0,0)
                /     \
              D         R
              ↓         ↓
           (1,0)      (0,1)
              |           |
              R           D
              ↓           ↓
           (1,1)        (1,1)
```

Paths:

```text
DR
RD
```

The tree represents **different choices**.

---

## Why `visited` is necessary

Suppose movement is four-directional.

Without `visited`:

```text
A → B
↑   ↓
D ← C
```

The recursion could keep doing:

```text
A → B → A → B → A → ...
```

So:

```java
visited[row][col] = true;
```

means:

> "This cell belongs to my current path. Do not enter it again."

---

## The critical backtracking line

```java
visited[row][col] = false;
```

Meaning:

> "I have finished exploring every path that uses this cell from this point. Restore it so another path can use it."

This is **not optional** in four-direction path search.

---

## Correct movement structure

```java
visited[row][col] = true;

if (isValid(... row + 1, col))
    solve(... row + 1, col, ...);

if (isValid(... row, col - 1))
    solve(... row, col - 1, ...);

if (isValid(... row, col + 1))
    solve(... row, col + 1, ...);

if (isValid(... row - 1, col))
    solve(... row - 1, col, ...);

visited[row][col] = false;
```

---

# 6. Problem 142 — Maze Paths

This is the simpler version.

If movement is restricted to:

```text
Right
Down
```

there is no need to explore four directions.

Mental tree:

```text
                 START
                /     \
              R         D
             / \       / \
            R   D     R   D
```

The important idea:

> Every cell asks: "What happens if I go Right?" and "What happens if I go Down?"

This naturally gives:

```java
return solve(row, col + 1)
     + solve(row + 1, col);
```

when the function is a **counting** function.

---

# 7. Problem 143 — Maze Paths With Obstacles

Now add blocked cells.

At every state:

```text
Is this cell outside?
       ↓
      YES → 0 paths

Is this cell blocked?
       ↓
      YES → 0 paths

Is this the destination?
       ↓
      YES → 1 path

Otherwise:
       ↓
Right + Down
```

### Important base-case thinking

Do not think:

> "I need to stop when I reach the edge."

Think:

> "A path that goes outside contributes ZERO."

That is why:

```java
if (row >= rows || col >= cols) {
    return 0;
}
```

works.

---

## Why your earlier `rowIdx == 0 || colIdx == 0` check was wrong

That condition means:

```text
If I am on the first row OR first column,
stop.
```

But the first row/column can contain perfectly valid paths.

Example:

```text
S → → E
```

Being on:

```text
row == 0
```

does NOT mean failure.

The real invalid condition is:

```java
row >= rows || col >= cols
```

---

# 8. Problem 144 — Count Maze Paths

This is where recursion starts becoming **DP-recognition practice**.

If the problem asks:

> How many ways can I reach the destination?

Then the recursive meaning should be:

```text
solve(row, col)
=
number of paths from (row,col) to destination
```

Therefore:

```java
return solve(row + 1, col)
     + solve(row, col + 1);
```

Base:

```java
if (outside || blocked)
    return 0;

if (destination)
    return 1;
```

---

## Recursion Tree

For a small open `2 x 2` grid:

```text
                 (0,0)
                /     \
               D       R
              /         \
           (1,0)       (0,1)
              |           |
              R           D
              |           |
           (1,1)        (1,1)
             1             1
```

At `(0,0)`:

```text
paths = paths through D + paths through R
      = 1 + 1
      = 2
```

### The key insight

The recursion is correct.

The problem is **repeated work**.

For a bigger grid, the same state can be reached through multiple paths:

```text
solve(2,2)
```

may be calculated many times.

That is exactly the signal:

```text
Correct recursion
       ↓
Repeated same state
       ↓
Overlapping subproblems
       ↓
Memoization / DP
```

---

# 9. Why Your Count-Maze Recursion Gets TLE

Your recursive idea:

```java
return solve(row + 1, col, grid)
     + solve(row, col + 1, grid);
```

is logically correct.

But it recomputes states.

Example:

```text
             (0,0)
            /     \
         (1,0)    (0,1)
           \        /
            (1,1)
```

Both branches can reach the same state.

Without memoization:

```text
solve(1,1)
```

is calculated again and again.

So:

> **TLE does not automatically mean your recursion idea is wrong.**

It can mean:

> "The recursive model is correct, but it needs DP."

This is an important distinction for your future problem solving.

---

# 10. Problem 144 Variant — Directional Maze + Count + Maximum Adventure

You also practiced a grid problem where each cell determines allowed movement:

```text
1 → Right only
2 → Down only
3 → Right OR Down
```

And the answer contains:

```text
[number of valid paths, maximum path sum]
```

This is a useful extension of the maze pattern.

---

## State

You need:

```text
(row, col)
+
current sum
```

because the answer is not only a count.

You are tracking two things:

```text
number of paths
maximum adventure
```

---

## Why your `sum` starts with the entry value

If:

```text
grid[0][0] = 3
```

then the path has already visited the entry.

So:

```java
int sum = grid[0][0];
```

Then when moving:

```java
sum + grid[newRow][newCol]
```

adds the newly visited cell.

---

## Recursion meaning

At every cell:

```text
What directions does this cell allow?
        ↓
validate destination cell
        ↓
move
        ↓
add its value to sum
        ↓
recurse
```

At destination:

```java
count++;
max = Math.max(max, sum);
```

---

## Direction condition

For:

```text
1 = Right
2 = Down
3 = Right + Down
```

Think:

```text
if cell == 2 or 3
    try Down

if cell == 1 or 3
    try Right
```

Do not accidentally use the **current coordinates** to decide the direction.  
The **value of the current cell** decides which moves are allowed.

---

# 11. Important Difference: Four-Direction Maze vs Right/Down Maze

### Rat in a Maze

```text
D L R U
```

Because movement can go backwards, you need:

```java
visited[][]
```

### Right/Down Maze

```text
D R
```

Movement never goes backward.

Usually:

```java
visited[][]
```

is unnecessary.

This distinction is important.

---

# 12. Backtracking vs Counting Recursion

These two can look similar but behave differently.

### Generate all paths

```java
ans.add(path);
```

You need to maintain path state.

```text
choose
 ↓
recurse
 ↓
undo
```

### Count paths

```java
return down + right;
```

You don't need to store every path.

```text
solve
 ↓
count branch 1
 +
count branch 2
```

This naturally leads toward DP.

---

# 13. Your Main Weaknesses to Strengthen

These are the concepts you should actively check during revision.

## A. Coordinate meaning

Always know:

```text
row → vertical
col → horizontal
```

```java
row + 1 → down
row - 1 → up
col + 1 → right
col - 1 → left
```

---

## B. Boundary condition

Do not mix:

```java
row >= rows
```

with:

```java
row == rows - 1
```

They mean different things.

```text
row == rows - 1
→ last valid row

row >= rows
→ outside grid
```

---

## C. `idx + 1` vs `choice + 1` thinking

For grid problems there is a similar idea:

> The next recursive state must represent the cell you actually chose.

So if you calculate:

```java
newRow
newCol
```

recurse using those exact coordinates.

Do not automatically move by `+1` without asking:

> "Which cell did my choice select?"

---

## D. Direction-label discipline

Always match:

```text
D → row + 1
U → row - 1
R → col + 1
L → col - 1
```

Do not let the letter and coordinate become mismatched.

---

## E. `visited` lifetime

Remember:

```java
visited[row][col] = true;

recurse(...);

visited[row][col] = false;
```

The last line means:

> Restore the state for the parent so another branch can use this cell.

---

## F. Return-value thinking

Before writing recursion, ask:

```text
Am I returning:
- all paths?
- one valid path?
- number of paths?
- maximum?
- minimum?
- boolean?
```

Examples:

```java
all paths → add to result

count → left + right

boolean → left || right

maximum → Math.max(...)

minimum → Math.min(...)
```

This prevents mixing **generation recursion** with **counting recursion**.

---

# 14. Recursion Tree vs DP Table

The recursion tree helps you understand the recursive solution.

The repeated states help you recognize DP.

```text
                (0,0)
               /     \
            (1,0)    (0,1)
             /          \
          (1,1)        (1,1)
```

Notice:

```text
same state
(1,1)
```

appears twice.

That is the clue:

```text
Same state + different paths
        ↓
Overlapping subproblems
        ↓
Memoization can help
```

Do not jump to DP just because the problem is a grid.

First understand:

```text
state
choices
base case
recursive relation
```

Then check for repeated states.

---

# 15. Master Grid Template

### Four-direction backtracking

```java
static void solve(int row, int col, ...) {

    if (isDestination(row, col)) {
        // answer
        return;
    }

    visited[row][col] = true;

    for (each direction) {

        int newRow = row + dr;
        int newCol = col + dc;

        if (isValid(newRow, newCol)) {
            solve(newRow, newCol, ...);
        }
    }

    visited[row][col] = false;
}
```

### Right/Down counting

```java
static int solve(int row, int col, ...) {

    if (outside || blocked) {
        return 0;
    }

    if (destination) {
        return 1;
    }

    int down = solve(row + 1, col, ...);
    int right = solve(row, col + 1, ...);

    return down + right;
}
```

---

# 16. Problem Recognition Cheat Sheet

| Situation | Think |
|---|---|
| All paths | Backtracking |
| Four directions | `visited[][]` usually needed |
| Right + Down only | Simple grid recursion |
| Obstacles | Validate / prune |
| Count paths | Return counts |
| Maximum path value | Return/update maximum |
| Same `(row,col)` repeated | Think memoization / DP |
| Word Search | Grid + index + visited |
| Many words | Larger search space + pruning |

---

# 17. Small Algorithm to Memorize

```text
row, col
   ↓
what choices are allowed?
   ↓
calculate next cell
   ↓
valid?
   ↓
recurse
   ↓
return
   ↓
undo if state was changed
```

For four-direction problems:

```text
(row,col)
   ↓
D
L
R
U
```

For right/down problems:

```text
(row,col)
   ↓
D
R
```

---

# 18. Final Master Checklist

Before solving a new grid recursion problem, ask:

- [ ] What is my state? `(row,col)`?
- [ ] What are my allowed directions?
- [ ] Can I move backward?
- [ ] Do I need `visited[][]`?
- [ ] What makes a cell invalid?
- [ ] What is the destination?
- [ ] Am I generating, counting, checking, maxing, or minimizing?
- [ ] What exactly does `solve(row,col)` return?
- [ ] What does each recursive call represent?
- [ ] If I changed state, where do I undo it?
- [ ] Are the same states being recomputed?
- [ ] If yes, is this a DP transition?

---

# 19. Problem Tracker

| # | Problem | Pattern | Status | R1 | R2 | R3 |
|---:|---|---|:---:|:---:|:---:|:---:|
| 141 | Rat in a Maze | 4-direction backtracking | ☑️ | ⬜ | ⬜ | ⬜ |
| 142 | Maze Paths | Right/Down recursion | ☑️ | ⬜ | ⬜ | ⬜ |
| 143 | Maze Paths with Obstacles | Grid + pruning | ☑️ | ⬜ | ⬜ | ⬜ |
| 144 | Count Maze Paths | Counting recursion → DP recognition | ☑️ | ⬜ | ⬜ | ⬜ |
| 144-V | Directional Maze + Maximum Adventure | Count + optimization | ☑️ | ⬜ | ⬜ | ⬜ |
| 145 | Word Search | Grid + index + visited | ⬜ | ⬜ | ⬜ | ⬜ |
| 146 | Word Search II | Grid + multi-word search | ⬜ | ⬜ | ⬜ | ⬜ |

---

# 20. Final Mental Model

```text
GRID RECURSION

             STATE
          (row, col)
              ↓
           CHOICES
        directions
              ↓
          VALIDATE
              ↓
           RECURSE
              ↓
       ┌──────────────┐
       │              │
   GENERATE         COUNT
       │              │
   backtrack       return sum
       │              │
   undo state      repeated state?
                      ↓
                     DP
```

> **Do not memorize a maze solution.**
>
> Learn to identify:
>
> **STATE → CHOICES → VALIDATION → RECURSE → RETURN → UNDO → REPEATED STATE?**
