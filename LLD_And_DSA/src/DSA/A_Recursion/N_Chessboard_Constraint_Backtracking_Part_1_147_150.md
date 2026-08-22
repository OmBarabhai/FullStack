# N — Chessboard / Constraint Backtracking
## Part 1 — Problems 147–149
### N-Queens • N-Queens II • Sudoku Solver • Knight Tour

> **Purpose:** Strengthen recursion + backtracking problem solving, not memorize solutions.

---

## 1. Core Pattern

```text
CHOOSE
  ↓
CHECK CONSTRAINT
  ↓
MAKE CHOICE
  ↓
RECURSE
  ↓
SUCCESS? → return success
  ↓
FAILURE
  ↓
UNDO
  ↓
TRY NEXT CHOICE
```

| Problem | State | Choice | Constraint | Return |
|---|---|---|---|---|
| N-Queens | current column | row | row + diagonals | collect boards |
| N-Queens II | current column | row | row + diagonals | count |
| Sudoku | current empty cell / board | `1`–`9` | row + column + box | boolean |

---

## 2. Core Revision Focus

I understand:

```text
place → recurse → remove
```

but I often struggle to convert that idea into exact code.

Main weaknesses to revise:

- defining the recursive state
- deriving the base case
- understanding current vs next state
- parameter ordering
- loop-variable discipline
- row/column confusion
- recursive return values
- collection vs counting vs boolean recursion
- knowing exactly what must be undone
- distinguishing `return false` from undo
- writing code before defining state/choice/constraint/base/make/recurse/undo

### Before coding any backtracking problem

```text
STATE:
CHOICE:
CONSTRAINT:
BASE:
MAKE:
RECURSE:
UNDO:
RETURN:
```

---

# 3. 147 — N-Queens

## Mental Model

Process **one column at a time**.

```text
colIdx = current column being solved
```

For that column:

```text
try row 0
try row 1
try row 2
...
try row n-1
```

For each valid row:

```text
place Q
   ↓
solve(next column)
   ↓
remove Q
   ↓
try next row
```

### State / Choice / Constraint

```text
STATE      → current column
CHOICE     → row
CONSTRAINT → no same row / diagonal conflict
MAKE       → board[row][col] = 'Q'
RECURSE    → col + 1
UNDO       → board[row][col] = '.'
```

---

## 4. N-Queens Base Case

`colIdx` means:

```text
next/current column that needs a Queen
```

Therefore:

```text
colIdx < n → columns remain
colIdx == n → all columns completed
```

So:

```java
if (colIdx >= n) {
    // complete valid arrangement
}
```

### Revision rule

Do not memorize the condition.

Ask:

> What does my state variable represent?

Then derive the base case.

---

## 5. N-Queens Safety Check

Because we build:

```text
left → right
```

only already-processed positions need checking.

For `(rowIdx, colIdx)` check:

```text
Same row
← ← ←

Upper-left diagonal
↖ ↖ ↖

Lower-left diagonal
↙ ↙ ↙
```

No right-side check is needed because those columns have not been processed yet.

### Important principle

```text
recursion order
      ↓
determines
      ↓
what previous state must be checked
```

---

## 6. Java Rule — Traversal Variables

Keep original coordinates separate from traversal variables.

If:

```java
int row = rowIdx;
int col = colIdx;
```

then both the condition and update should use:

```java
row
col
```

Correct:

```java
while (col >= 0) {
    ...
    col--;
}
```

Incorrect habit:

```java
while (colIdx >= 0) {
    ...
    col--;
}
```

because `colIdx` never changes.

Same rule for diagonals:

```java
while (row >= 0 && col >= 0) {
    ...
    row--;
    col--;
}
```

---

## 7. N-Queens Core Skeleton

```java
for (int row = 0; row < n; row++) {

    if (isSafe(row, colIdx)) {

        board[row][colIdx] = 'Q';

        solve(colIdx + 1);

        board[row][colIdx] = '.';
    }
}
```

Memorize the pattern:

```text
isSafe
  ↓
PLACE
  ↓
RECURSE
  ↓
UNDO
```

---

## 8. N-Queens Recursion Tree

Conceptually:

```text
column 0
├── row 0
│   ├── column 1 → row 0 ✗
│   ├── column 1 → row 1 ✗
│   └── column 1 → row 2
│       └── column 2 → ...
│
├── row 1
│   ├── column 1 → row 0
│   │   └── ...
│   ├── column 1 → row 1 ✗
│   └── column 1 → row 2 ✗
│
└── row 2
    └── ...
```

The branches represent **choices**.

A failed branch:

```text
return
→ undo
→ try next choice
```

---

## 9. Backtracking Meaning

Example:

```text
Column 0 → Row 0
Column 1 → Row 2
Column 2 → impossible
```

The failed branch returns.

Then:

```java
board[row][col] = '.';
```

restores the previous state.

Mental model:

```text
MAKE CHOICE
    ↓
EXPLORE
    ↓
FAILED
    ↓
UNDO
    ↓
TRY NEXT CHOICE
```

Returning does not automatically remove the Queen.

---

# 10. 148 — N-Queens II

The search pattern is almost the same.

Difference:

```text
N-Queens
→ give all boards

N-Queens II
→ count boards
```

Therefore the return behavior changes.

### Counting skeleton

```java
int count = 0;

for (...) {
    if (safe) {
        place();

        count += solve(nextState);

        undo();
    }
}

return count;
```

---

## 11. Why Base Case Returns `1`

At:

```java
if (colIdx == n)
```

a complete valid board exists.

Therefore:

```text
one successful leaf
→ contributes 1
```

So:

```java
return 1;
```

not `0`.

### Counting tree

```text
solve(column)
   |
   +-- row 0 → solve(next) → 2
   |
   +-- row 1 → solve(next) → 1
   |
   +-- row 2 → solve(next) → 3
   |
   ↓
2 + 1 + 3 = 6
```

Hence:

```java
count += solve(nextState);
```

is essential.

---

# 12. Collection vs Count vs Boolean

### Collection

```text
What are all solutions?
```

```java
ans.add(solution);
```

### Count

```text
How many solutions?
```

```java
count += solve(...);
```

### Boolean

```text
Does any solution exist?
```

```java
if (solve(...)) {
    return true;
}
```

Never blindly copy the previous problem's return structure.

When the question changes, redesign the return behavior.

---

# 13. Counting Weakness

For counting:

```text
0   = no solutions from this state
1+  = number of solutions
```

Do not use:

```java
return -1;
```

as a generic failure value.

Counting is:

```text
sum of child solution counts
```

---

# 14. Current vs Next State

If:

```java
colIdx
```

means current column:

```java
board[rowIdx][colIdx] = 'Q';
```

then:

```java
solve(colIdx + 1);
```

means:

```text
child solves the remaining problem
starting from the next column
```

Visual:

```text
current column = c
       ↓
choose row r
       ↓
place Q at (r,c)
       ↓
next state = c + 1
```

This is a key revision point.

---

# 15. 149 — Sudoku Solver

Sudoku uses the same engine with different state and constraints.

```text
CHOOSE
→ CHECK
→ PLACE
→ RECURSE
→ IF FAILURE → UNDO
→ TRY NEXT CHOICE
```

---

## 16. Sudoku Recursive Contract

Think about:

```java
solveSudokuHelp(board)
```

as:

> "Can I solve the Sudoku from the current board state?"

Therefore:

```text
true
→ current state can eventually be solved

false
→ current state cannot lead to a solution
```

Define this meaning before coding.

---

# 17. Sudoku Components

| Component | Meaning |
|---|---|
| State | board / current empty cell |
| Choice | `'1'` to `'9'` |
| Constraint | row + column + 3×3 box |
| Base | no empty cell |
| Make | place digit |
| Recurse | solve remaining board |
| Undo | replace with `'.'` |
| Return | boolean |

---

# 18. Sudoku Base Case

```java
if (!findEmptyCell(emptyCell, board)) {
    return true;
}
```

Flow:

```text
find empty cell
      ↓
none exists
      ↓
board is complete
      ↓
success
      ↓
return true
```

This differs from simple index recursion because Sudoku progress is represented by the changing board / next empty cell.

Mental question:

> Have I completed the entire construction?

---

# 19. `findEmptyCell()`

Its responsibility:

```text
find the next empty cell
```

Return:

```text
true  → found an empty cell
false → no empty cell remains
```

Coordinates:

```java
emptyCell[0] = row;
emptyCell[1] = col;
```

Flow:

```text
find empty
   ↓
get row
   ↓
get column
   ↓
try digits there
```

### Dimension habit

For a general matrix, columns are:

```java
board[0].length
```

not:

```java
board.length
```

Sudoku is square, so the original habit can appear to work, but the more correct habit is important.

---

# 20. Sudoku `safeToPlace()`

This function is only a **constraint checker**.

It is not recursion.

A digit is safe when:

```text
ROW OK
AND
COLUMN OK
AND
3×3 BOX OK
```

So:

```text
SAFE = row && column && box
```

If the same digit is already present in any required area:

```text
return false
```

If all checks pass:

```text
return true
```

---

# 21. Sudoku 3×3 Box Formula

```java
int firstRowIdx = rowIdx - rowIdx % 3;
int firstColIdx = colIdx - colIdx % 3;
```

Examples:

```text
rows 0,1,2 → box starts at 0
rows 3,4,5 → box starts at 3
rows 6,7,8 → box starts at 6
```

Same for columns.

Then:

```java
int actualRowIdx = firstRowIdx + i;
int actualColIdx = firstColIdx + j;
```

walk through that 3×3 box.

Remember the idea:

```text
row
 ↓
find which group of 3
 ↓
find that group's starting index
```

---

# 22. Sudoku Core Recursion

```java
for (char val = '1'; val <= '9'; val++) {

    if (safeToPlace(board, rowIdx, colIdx, val)) {

        board[rowIdx][colIdx] = val;

        if (solveSudokuHelp(board)) {
            return true;
        }

        board[rowIdx][colIdx] = '.';
    }
}

return false;
```

Read it as:

```text
try digit
  ↓
valid?
  ↓
place
  ↓
ask child to solve remaining board
  ↓
child succeeds?
  ├── YES → true
  └── NO  → undo
             ↓
          try next digit
```

---

# 23. Why Place Before Recursion?

If I choose:

```text
5
```

I must first modify the board:

```java
board[row][col] = '5';
```

because the child must see my decision.

Otherwise the child receives the wrong state.

Pattern:

```text
MAKE
 ↓
RECURSE WITH CHANGED STATE
```

---

# 24. `return false` vs Undo

This is one of my most important weaknesses.

They are different.

### `return false`

Means:

```text
"This branch failed."
```

It communicates information to the parent.

### Undo

```java
board[row][col] = '.';
```

means:

```text
"Restore the state so another branch can be tried."
```

Memory:

```text
FALSE = communication
UNDO  = state restoration
```

---

# 25. Boolean Return Propagation

Successful path:

```text
Depth 0 solve()
   ↓
Depth 1 solve()
   ↓
Depth 2 solve()
   ↓
SOLVED
   ↓
true
```

Then:

```text
Depth 2 → true
Depth 1 → true
Depth 0 → true
```

because each caller does:

```java
if (solveSudokuHelp(board)) {
    return true;
}
```

Once success is found:

```text
stop searching
propagate true upward
```

---

# 26. Boolean Failure Flow

```text
try 5
 ↓
place 5
 ↓
recurse
 ↓
dead end
 ↓
false
 ↓
undo 5
 ↓
try 6
```

The `false` tells us the branch failed.

The undo makes the board usable for the next branch.

---

# 27. Sudoku Backtracking Tree

Conceptual tree:

```text
current empty cell
├── 1 → invalid
│
├── 2
│   └── next cell
│       ├── 1 → dead end
│       └── 4 → ...
│   → failure → undo 2
│
├── 3 → invalid
│
└── 5
    └── next cells
        └── eventually solved
            ↓
           true
```

Choices create branches.

Dead branches cause:

```text
false → undo → next choice
```

Successful branches cause:

```text
true → true → true → final success
```

---

# 28. N-Queens vs Sudoku

| Feature | N-Queens | Sudoku |
|---|---|---|
| State | current column | current empty cell / board |
| Choice | row | 1–9 |
| Constraint | row + diagonals | row + column + box |
| Make | place Q | place digit |
| Recurse | next column | next empty cell |
| Undo | remove Q | `'.'` |
| Return | collection | boolean |

The surface problem changes.

The recursion skeleton remains:

```text
choice
→ constraint
→ make
→ recurse
→ undo
```

---

# 29. Pattern Recognition

Do not memorize:

```text
N-Queens code
Sudoku code
```

Instead recognize:

```text
BACKTRACKING ENGINE
```

Only these change:

```text
STATE
CHOICE
CONSTRAINT
BASE CASE
RETURN TYPE
```

This is the skill needed for new problems.

---

# 30. Revision Checkpoints

### N-Queens

```text
[ ] colIdx = current column
[ ] colIdx + 1 = next state
[ ] base = colIdx == n
[ ] try every row
[ ] check row
[ ] check upper-left diagonal
[ ] check lower-left diagonal
[ ] traversal variables are updated correctly
[ ] place before recurse
[ ] undo after recurse
```

### N-Queens II

```text
[ ] count, don't collect
[ ] return int
[ ] complete board contributes 1
[ ] count += solve(...)
[ ] don't ignore recursive return value
[ ] no fake -1 failure
[ ] undo after child returns
```

### Sudoku

```text
[ ] recursive contract is boolean
[ ] find empty cell
[ ] try 1..9
[ ] check row
[ ] check column
[ ] check box
[ ] place before recurse
[ ] inspect child return
[ ] undo only after failure
[ ] true propagates upward
[ ] false after all choices fail
```

---

# 31. Universal Backtracking Skeleton — Boolean

```java
boolean solve(state) {

    if (complete) {
        return true;
    }

    for (choice : choices) {

        if (valid(choice)) {

            make(choice);

            if (solve(newState)) {
                return true;
            }

            undo(choice);
        }
    }

    return false;
}
```

---

# 32. Universal Backtracking Skeleton — Count

```java
int solve(state) {

    if (complete) {
        return 1;
    }

    int count = 0;

    for (choice : choices) {

        if (valid(choice)) {

            make(choice);

            count += solve(newState);

            undo(choice);
        }
    }

    return count;
}
```

---

# 33. Manual Revision Drill

Before looking at code, explain:

1. What does `colIdx` mean?
2. Why does `colIdx == n` mean success?
3. Why are only left-side Queen conflicts checked?
4. Why do we try every row?
5. Why must the Queen be removed?
6. Why does N-Queens II return `1` at a complete board?
7. Why must we use `count += solve(...)`?
8. What does `solveSudokuHelp(board)` mean?
9. Why does no empty Sudoku cell mean `true`?
10. What are Sudoku's three constraints?
11. What does `row - row % 3` calculate?
12. Why must a Sudoku digit be placed before recursion?
13. When exactly do we undo it?
14. Why does `true` propagate upward?
15. Why is `return false` different from undo?
16. What is the state in N-Queens?
17. What is the state in Sudoku?
18. What is the choice in each?
19. What is the undo in each?
20. Can I derive the skeleton without seeing the solution?

---

# 34. Final One-Page Memory Sheet

## N-Queens

```text
STATE      → column
CHOICE     → row
CHECK      → row + diagonals
MAKE       → Q
RECURSE    → next column
UNDO       → .
BASE       → column == n
RETURN     → collect
```

## N-Queens II

```text
STATE      → column
CHOICE     → row
CHECK      → row + diagonals
MAKE       → Q
RECURSE    → next column
UNDO       → .
BASE       → column == n
RETURN     → count
SUCCESS    → 1
```

## Sudoku

```text
STATE      → board / empty cell
CHOICE     → 1..9
CHECK      → row + column + box
MAKE       → digit
RECURSE    → remaining empty cells
UNDO       → .
BASE       → no empty cell
RETURN     → boolean
SUCCESS    → true
FAILURE    → false
```

---

# 35. Final Rule

Before coding a new backtracking problem:

```text
STATE:
CHOICE:
CONSTRAINT:
BASE:
MAKE:
RECURSE:
UNDO:
RETURN:
```

If I can answer these clearly, I am not memorizing the solution — I am deriving it.

---

## Section Status

| # | Problem | Status |
|---:|---|:---:|
| 147 | N-Queens | ✅ |
| 148 | N-Queens II | ✅ |
| 149 | Sudoku Solver | ✅ |
| 150 | Knight's Tour | ✅ |
| 151 | Crossword Puzzle Solver | ⬜ |
| 152 | Graph Coloring Backtracking | ⬜ |
| 153 | Hamiltonian Path | ⬜ |
| 154 | Hamiltonian Cycle | ⬜ |

**N Part 1 ends at Problem 149.**

**Next:** Problem 150 — Knight's Tour.

---

# 31. Important Pattern Extension — BUILD vs VALIDATE

The Knight Tour problem adds an important distinction to the backtracking pattern.

Do not automatically assume every search problem needs:

```text
visited
board modification
undo
```

First ask:

> **Am I constructing a solution, or validating a solution that is already given?**

## Construction Backtracking

Examples:

```text
N-Queens
Sudoku
```

The solution is not complete yet:

```text
CHOOSE
   ↓
CHECK CONSTRAINT
   ↓
MAKE / MODIFY STATE
   ↓
RECURSE
   ↓
FAIL?
   ↓
UNDO
   ↓
TRY NEXT CHOICE
```

### N-Queens

```text
choose row
→ place Q
→ recurse to next column
→ remove Q
```

### Sudoku

```text
choose digit
→ place digit
→ recurse
→ remove digit if the branch fails
```

---

## Validation / Verification Recursion

Sometimes the complete configuration is already given.

Then we are not constructing it.

We are checking whether it satisfies the required rule:

```text
CURRENT STATE
    ↓
TRY / CHECK NEXT STATE
    ↓
VALID?
    ↓
RECURSE
    ↓
RETURN RESULT
```

There may be no need for:

```text
board modification
StringBuilder
visited
undo
```

when the actual problem does not require them.

---

# 32. Knight Tour — The Key Lesson

In Knight Tour validation, the board already contains:

```text
0 → 1 → 2 → 3 → ...
```

So the task is to verify the sequence.

The conceptual state is:

```text
(row, col, idx)
```

where:

```text
row, col = current position
idx      = current move number
```

The next required value is:

```text
idx + 1
```

So the search is:

```text
current position
      ↓
try 8 knight moves
      ↓
inside board?
      ↓
destination contains idx + 1?
      ↓
recurse
```

The important lesson is:

> **Do not carry state from an earlier backtracking problem automatically. Derive the state from the current problem.**

---

# 33. Build vs Validate — Quick Comparison

| Question | Construction | Validation |
|---|---|---|
| Is the solution being created? | Yes | No, it is given |
| Main action | choose + make | check next state |
| Modify board/state? | Usually yes | Only if required |
| Undo? | Usually yes | Only if required |
| Typical return | list / count / boolean | boolean / validity |

Memory:

```text
BUILD
→ MAKE
→ RECURSE
→ UNDO

VALIDATE
→ CHECK
→ RECURSE
→ RETURN
```

---

# 34. Do Not Turn This Into a New Rule to Memorize

Do not memorize:

```text
validation → never visited
construction → always visited
```

That would create another problem.

Instead ask:

```text
What is my state?
Can state repeat?
What information must I remember?
What did I change?
What must be restored?
```

The **problem**, not the category name, decides the exact implementation.

---

# 35. Why This Belongs in Part 1

Part 1 is the foundation for how I should **derive backtracking**, not a collection of six unrelated code solutions.

The progression is now:

```text
N-Queens
   ↓
construct a board
   ↓
make → recurse → undo

N-Queens II
   ↓
same search tree
   ↓
return counts

Sudoku
   ↓
same engine
   ↓
boolean success / failure

Knight Tour insight
   ↓
not every search constructs a solution
   ↓
sometimes we validate an existing state
```

This is useful because it prevents blindly copying:

```text
visited
StringBuilder
undo
```

into every new problem.

---

# 36. Final Backtracking Recognition

Before coding a new problem:

```text
1. Am I constructing something?
2. Or am I validating something already given?
3. What is my recursive state?
4. What are my choices?
5. What is the constraint?
6. What is success?
7. What is failure?
8. What state do I modify?
9. What must I undo?
10. Can the same state repeat?
```

Then derive the code.

---

# 37. Part 1 Scope

```text
147 ✅ N-Queens
148 ✅ N-Queens II
149 ✅ Sudoku Solver
```

Part 1 now strengthens:

```text
Construction Backtracking
+
Boolean Backtracking
+
Counting Backtracking
+
Constraint Checking
+
Build vs Validate recognition
```

The deeper Knight Tour problem-specific material can stay in the later N part when that problem is actually being completed.

---

# 38. 150 — Knight Tour Validation

This problem adds another important recursion pattern to the N section.

The board is **already given**.

We are not constructing a knight tour.

We are checking whether the existing numbered sequence is a valid knight-tour sequence.

This is therefore a **validation recursion** problem.

---

## Knight Tour — What Does the State Mean?

A useful recursive state is:

```text
(row, col, idx)
```

Meaning:

```text
row, col → current knight position
idx      → current move number
```

For example:

```text
solve(grid, 2, 3, 5)
```

means:

```text
current position = (2,3)
current move     = 5
```

So:

```java
grid[2][3] == 5
```

and the next required move is:

```text
6
```

---

## Why `idx + 1`?

There are two related uses.

### Check

```java
grid[nextRow][nextCol] == idx + 1
```

means:

> Is this destination the next required move?

### Recurse

```java
solve(grid, nextRow, nextCol, idx + 1)
```

means:

> I successfully moved to the next number, so the new current move is `idx + 1`.

Mental sequence:

```text
0 → 1 → 2 → 3 → 4 → ...
```

---

## Base Case

An `n × n` board contains:

```text
n * n
```

cells.

If numbering starts at `0`, the final number is:

```text
n * n - 1
```

Therefore:

```java
if (idx >= n * n - 1) {
    return true;
}
```

means:

```text
the final required move has been reached
→ complete valid sequence
→ true
```

Do not memorize the condition alone.

Ask:

> What does `idx` represent, and what event means the entire validation is complete?

---

## Knight Movement

A knight has 8 possible moves:

```text
(+2,+1)
(+2,-1)
(-2,+1)
(-2,-1)

(+1,+2)
(+1,-2)
(-1,+2)
(-1,-2)
```

Typical arrays:

```java
int[] dr = {
    2, 2, -2, -2,
    1, 1, -1, -1
};

int[] dc = {
    1, -1, 1, -1,
    2, -2, 2, -2
};
```

Remember:

```text
dr = row change
dc = column change
```

They work as a pair.

Example:

```text
dr[i] = 2
dc[i] = -1
```

means:

```text
row + 2
col - 1
```

---

## Next Position

```java
int nextRow = row + dr[i];
int nextCol = col + dc[i];
```

Meaning:

> Apply the `i`th knight movement to the current position.

Example:

```text
current = (2,2)
move    = (+2,-1)

next = (4,1)
```

---

## Boundary Check Comes First

Never access:

```java
grid[nextRow][nextCol]
```

before confirming:

```java
0 <= nextRow < n
0 <= nextCol < n
```

Otherwise a move such as:

```text
row = 0
row - 2 = -2
```

would cause an array-index error.

Safe order:

```text
calculate next position
        ↓
boundary check
        ↓
read grid[nextRow][nextCol]
```

---

## The Main Constraint

After the next position is inside the board:

```java
if (grid[nextRow][nextCol] == idx + 1)
```

asks:

> Is this physically valid knight movement also the correct next numbered cell?

Example:

```text
current idx = 4
next required = 5
```

If a valid knight move reaches:

```text
grid[nextRow][nextCol] = 8
```

then:

```text
8 != 5
```

so that branch is rejected.

---

# 39. Why Knight Tour Needs No `visited`, Undo, or Board Modification

This is a major pattern lesson.

The board already contains:

```text
0 → 1 → 2 → 3 → ...
```

The sequence itself tells us exactly which move must come next.

Therefore we do not need to maintain:

```text
visited
StringBuilder
board changes
undo
```

for this validation approach.

Contrast:

### N-Queens / Sudoku

```text
solution is being constructed
→ modify state
→ recurse
→ undo
```

### Knight Tour validation

```text
solution already exists
→ check next state
→ recurse
→ return
```

Important rule:

> **Do not carry `visited` or undo logic from one backtracking problem into another without deriving whether the current problem actually needs it.**

---

# 40. Knight Tour Recursion Flow

```text
                 (row,col,idx)
                       |
                 try 8 moves
                       |
               inside board?
                  /         \
                NO           YES
                |              |
              skip       grid[next] == idx+1?
                           /          \
                         NO            YES
                         |               |
                       skip           recurse
                                         |
                                      next state
```

A successful chain looks like:

```text
0
 ↓
1
 ↓
2
 ↓
3
 ↓
...
 ↓
n*n-1
 ↓
true
```

A failed chain looks like:

```text
0
 ↓
1
 ↓
2
 ↓
3
 ↓
no valid next number
 ↓
false
```

---

# 41. Knight Tour Revision Checkpoints

### Mistake: returning true too early

Finding one valid `idx + 1` is not enough.

Wrong idea:

```java
if (grid[nextRow][nextCol] == idx + 1) {
    return true;
}
```

Why?

Because the remaining sequence still has to be validated.

Correct idea:

```java
if (grid[nextRow][nextCol] == idx + 1) {

    if (solve(grid,
              nextRow,
              nextCol,
              idx + 1)) {
        return true;
    }
}
```

---

### Mistake: recurse outside the next-value check

Do not do:

```java
if (grid[nextRow][nextCol] == idx + 1) {
    // ...
}

return solve(...);
```

because the recursive call would happen even when the destination is not the required next number.

Correct flow:

```text
boundary valid?
      ↓
next value correct?
      ↓
recurse
```

---

### Mistake: forgetting the boundary check

Always:

```text
boundary
→ then grid access
```

not:

```text
grid access
→ then boundary
```

---

### Mistake: incorrect movement pair

`dr[i]` and `dc[i]` must form one valid knight move.

Keep the pairs together:

```text
(+2,+1)
(+2,-1)
(-2,+1)
(-2,-1)
(+1,+2)
(+1,-2)
(-1,+2)
(-1,-2)
```

---

### Mistake: automatically using `visited`

Do not assume:

```text
grid problem → visited
```

Instead ask:

```text
Am I constructing a path?
Can I create cycles?
Does the existing state already identify what comes next?
```

For this validation problem:

```text
no visited
no undo
no board modification
```

---

# 42. 147–150 — Unified Pattern

Now the N section contains four useful variations:

```text
147 N-Queens
    ↓
construct
    ↓
choose row
    ↓
check constraint
    ↓
place
    ↓
recurse
    ↓
undo

148 N-Queens II
    ↓
same search tree
    ↓
COUNT leaves

149 Sudoku
    ↓
construct
    ↓
choose digit
    ↓
check constraint
    ↓
place
    ↓
boolean recurse
    ↓
undo on failure

150 Knight Tour
    ↓
validate existing configuration
    ↓
choose possible move
    ↓
check boundary
    ↓
check next required number
    ↓
recurse
    ↓
no undo
```

This is the exact pattern evolution I should remember.

---

# 43. Final Recognition Rule for N

Before writing code, ask:

```text
1. Am I CONSTRUCTING or VALIDATING?
2. What is my recursive STATE?
3. What are my CHOICES?
4. What is the CONSTRAINT?
5. What is the BASE CASE?
6. What STATE do I modify?
7. What exactly must I UNDO?
8. What does solve() RETURN?
9. Can I stop immediately after success?
10. Am I adding unnecessary state from another problem?
```

If I answer these first, I am deriving the solution rather than copying a template.

---

# 44. Part 1 Scope Updated

```text
147 ✅ N-Queens
148 ✅ N-Queens II
149 ✅ Sudoku Solver
150 ✅ Knight Tour
```

Part 1 now contains:

```text
Construction Backtracking
+
Constraint Backtracking
+
Boolean Backtracking
+
Counting Backtracking
+
Validation Recursion
+
Build vs Validate recognition
```

**N Part 1 ends at Problem 150.**

Next learning problem:

```text
151 — Crossword Puzzle Solver
```

