# M — Grid / Maze Backtracking
## Final Revision — Problems 141–146

> One connected revision file for the completed M section.
> Focus: pattern recognition, recursion state, backtracking, mistakes to avoid, and reusable templates.

---

## 1. Core Pattern

```text
(row, col)
    ↓
choose direction
    ↓
validate next cell
    ↓
move / mark
    ↓
recurse
    ↓
undo / unmark
```

### Pattern memory

```text
state → choices → validate → recurse → restore → next choice
```

---

## 2. Problem Progression

| # | Problem | Main Pattern | Status |
|---:|---|---|:---:|
| 141 | Rat in a Maze | Grid DFS + visited + path generation | ☑️ |
| 142 | Maze Paths | Grid recursion + direction choices | ☑️ |
| 143 | Maze Paths with Obstacles | Grid recursion + validity | ☑️ |
| 144 | Count Maze Paths | Same recursion, return count | ☑️ |
| 145 | Word Search | Grid DFS + character matching + backtracking | ☑️ |
| 146 | Word Search II | Word Search + Trie optimization | ☑️ |

---

# 3. Reusable Grid Backtracking Template

```java
static void solve(int row, int col,
                  boolean[][] visited,
                  StringBuilder path) {

    if (success) {
        // store answer
        return;
    }

    visited[row][col] = true;

    for (each direction) {

        int newRow = row + dr;
        int newCol = col + dc;

        if (isValid(newRow, newCol, visited)) {

            // choose
            path.append(direction);

            // explore
            solve(newRow, newCol, visited, path);

            // undo choice
            path.deleteCharAt(path.length() - 1);
        }
    }

    // undo cell choice
    visited[row][col] = false;
}
```

### Two different backtracking actions

```text
path:
append → recurse → delete

visited:
true → recurse → false
```

---

# 4. Problem 141 — Rat in a Maze

The main pattern:

```text
current cell
    ↓
try D/L/R/U
    ↓
is next cell valid?
    ↓
recurse
    ↓
unmark current cell
```

`visited` is needed because movement can include all four directions.

Without it:

```text
A → B → A → B → A → ...
```

### Important meaning of `visited`

It means:

> This cell is already used in the CURRENT path.

It does not mean:

> This cell can never be used again.

Therefore:

```java
visited[x][y] = true;

// explore all branches

visited[x][y] = false;
```

Another branch can use the cell later.

### Recursion tree — simple `D / R` example

```text
                         (0,0)
                        /     \
                     D /       \ R
                      /         \
                   (1,0)       (0,1)
                      |           |
                   R  |        D  |
                      |           |
                   (1,1)       (1,1)
                      ✓           ✓
```

Same tree as a step-by-step view:

```text
(0,0)
├── D → (1,0)
│        └── R → (1,1) ✓
│
└── R → (0,1)
         └── D → (1,1) ✓
```

The important point:

```text
D means: move to (row + 1, col)
R means: move to (row, col + 1)
```

Each branch means:

```text
choose → recurse
```

After a branch finishes:

```text
return → undo → try next branch
```

---

# 5. Problem 142 — Maze Paths

If movement is restricted, for example:

```text
D and R only
```

then cycles cannot occur.

The tree becomes:

```text
          (r,c)
          /            D     R
        /             next     next
```

### Recognition

Ask:

```text
Can my movement return to an already visited cell?
```

If **no**, `visited` may not be necessary.

If **yes**, carefully consider `visited`.

---

# 6. Problem 143 — Maze Paths With Obstacles

The recursion pattern does not fundamentally change.

### Recursion tree with an obstacle

Suppose one choice is blocked:

```text
                         (r,c)
                        /     \
                     D /       \ R
                      /         \
                 blocked       open
                    X             |
                                recurse
                                  |
                                next
```

The blocked branch is simply rejected:

```text
choose D
  ↓
isValid = false
  ↓
do not recurse
```

The open branch continues normally.

Only validity becomes stronger:

```text
inside grid?
blocked?
visited?
```

Typical helper:

```java
static boolean isValid(int r, int c) {

    if (r < 0 || r >= n || c < 0 || c >= n) {
        return false;
    }

    if (grid[r][c] == 0) {
        return false;
    }

    if (visited[r][c]) {
        return false;
    }

    return true;
}
```

Think:

```text
obstacle = invalid choice
```

---

# 7. Problem 144 — Count Maze Paths

Earlier problems generated paths.

Here we count them.

### Generation

```java
ans.add(path);
```

### Counting

```java
return solve(down) + solve(right);
```

The recursion tree can be the same.

Only the returned information changes.

Example:

```text
             cell
            /              D        R
       2 paths   1 path
            \    /
             3
```

### Recognition

If the question asks:

```text
How many ways?
How many paths?
How many arrangements?
```

think:

```text
return count(choice1) + count(choice2) + ...
```

---

# 8. Your Count-Maze TLE Lesson

You reached the correct recursive idea but got TLE.

The important lesson:

```text
recursion itself can be correct
but still inefficient
```

If the same state is calculated repeatedly:

```text
solve(row, col)
```

then we have:

```text
overlapping subproblems
```

This points toward:

```text
recursion
   ↓
repeated state
   ↓
memoization
   ↓
DP
```

This is an important bridge from recursion to dynamic programming.

---

# 9. Problem 145 — Word Search

The state becomes larger.

### Recursion tree

For a word such as `CAT`:

```text
                         C
                         |
                  match index 0
                         |
                  choose neighbor
                    /         \
                   A           X
                   |         mismatch
             match index 1
                   |
             choose neighbor
                /      \
               T        X
               |      mismatch
         match index 2
               |
            FOUND ✓
```

The tree is not only about `(row, col)`.

The recursion also tracks:

```text
word index
```

So the conceptual state is:

```text
(row, col, wordIndex)
```

Maze:

```text
(row, col)
```

Word Search:

```text
(row, col, wordIndex)
```

You need both:

```text
where am I?
```

and:

```text
which character am I matching?
```

### Core idea

```text
match current character
    ↓
mark cell
    ↓
try neighbors
    ↓
wordIndex + 1
    ↓
undo mark
```

### Template

```java
static boolean solve(int row, int col, int idx) {

    if (idx == word.length()) {
        return true;
    }

    if (invalid) {
        return false;
    }

    mark(row, col);

    for (each direction) {
        if (solve(newRow, newCol, idx + 1)) {
            return true;
        }
    }

    unmark(row, col);

    return false;
}
```

### Recognition

Whenever you see:

```text
grid + target word/string
```

ask:

```text
What character/index am I currently matching?
```

That usually becomes part of the recursion state.

---

# 10. Word Search Backtracking

Suppose:

```text
CAT
```

and we match:

```text
C → A → T
```

### One branch in detail

```text
choose C
   ↓
mark C cell
   ↓
recurse for A
   ↓
mark A cell
   ↓
recurse for T
   ↓
T fails
   ↓
unmark A
   ↓
try another A direction
```

If every choice from `A` fails:

```text
return to C
   ↓
unmark C
   ↓
try another C direction
```

This is why restoration is essential.

```text
undo T cell
```

Then try another direction.

If all choices from `A` fail:

```text
undo A cell
```

Then another branch from `C` can be explored.

The universal sequence is:

```text
choose
→ recurse
→ return/fail
→ undo
→ try next choice
```

---

# 11. One Recursion Tree to Remember

Use this mental model for the section:

```text
                         START
                           |
                    choose direction
                    /      |                         D       R      ...
                  /                       valid?       valid?
                |             |
              move          move
                |             |
             recurse       recurse
             /               choice   choice
            |        |
          recurse  recurse
             |
           return
             |
           UNDO
             |
       try next choice
```

Do not worry about drawing every grid cell.

The tree represents the **choices** being explored.

---

# 12. `visited` — Important Rule

Before exploring:

```java
visited[row][col] = true;
```

After all children finish:

```java
visited[row][col] = false;
```

Meaning:

```text
mark = use this cell in current path
unmark = restore state for another path
```

### Golden rule

```text
mark before exploring
unmark after exploring
```

---

# 13. `StringBuilder` Backtracking

For generated paths:

```java
path.append("D");

solve(...);

path.deleteCharAt(path.length() - 1);
```

Meaning:

```text
choose D
   ↓
explore everything starting with D
   ↓
return
   ↓
remove D
   ↓
try next direction
```

The recursive return does not automatically remove `"D"`.

Your code restores the previous state.

---

# 14. `setLength()` vs `deleteCharAt()`

### Remove one character

```java
sb.deleteCharAt(sb.length() - 1);
```

Use when exactly one character was added.

### Restore an entire previous state

```java
int before = sb.length();

sb.append(...);
solve(...);

sb.setLength(before);
```

Example:

```text
before = 3

abc
 ↓
append 123
 ↓
abc123
 ↓
setLength(3)
 ↓
abc
```

### Mental model

```text
save state
→ modify
→ recurse
→ restore saved state
```

---

# 15. Direction Table

Keep this exact mapping:

| Move | Row | Col |
|---|---:|---:|
| D | +1 | same |
| U | -1 | same |
| R | same | +1 |
| L | same | -1 |

Remember:

```text
D/U → row changes
L/R → column changes
```

Do not let the direction letter and coordinate change get mismatched.

---

# 16. Boundary Checking

Never access:

```java
grid[newRow][newCol]
```

before proving the coordinates are valid.

Check:

```java
if (newRow < 0 || newRow >= rows ||
    newCol < 0 || newCol >= cols) {
    return false;
}
```

Then check:

```text
blocked?
visited?
character match?
other problem condition?
```

This prevents:

```text
IndexOutOfBoundsException
```

---

# 17. Count vs Generate vs Search

| Goal | Typical recursion result |
|---|---|
| Generate all paths | store successful paths |
| Count paths | return counts |
| Find whether path exists | boolean |
| Maximum/minimum value | return/update best value |
| Find word | boolean |
| Find many words | shared structure such as Trie + DFS |

Same backtracking skeleton can produce different answers.

---

# 18. Problem Recognition

When you see:

### "All possible paths"

Think:

```text
DFS + backtracking
```

### "Number of paths"

Think:

```text
recursive counts
```

### "Blocked cells"

Think:

```text
validity check
```

### "Cannot reuse a cell"

Think:

```text
visited / mark-unmark
```

### "Grid + word"

Think:

```text
(row, col, wordIndex)
+ DFS
+ backtracking
```

### "Many words + same board"

Think:

```text
Word Search pattern
+
Trie
```

---

# 19. Main Weaknesses to Check During Revision

## 1. State

Before coding, say:

```text
What does one recursive call represent?
```

Examples:

```text
(row, col)
(row, col, wordIndex)
```

---

## 2. Base case

Ask:

```text
What exactly means success?
What exactly means failure?
```

Do not use vague boundary conditions for success.

For destination:

```java
row == n - 1 && col == n - 1
```

For word matching:

```java
idx == word.length()
```

---

## 3. Next state

The recursive call must use the chosen next position:

```java
solve(newRow, newCol, ...)
```

---

## 4. Validate before accessing

Always establish:

```text
inside?
```

before reading:

```java
grid[newRow][newCol]
```

---

## 5. Mark and unmark

Remember:

```text
mark
→ explore ALL branches
→ unmark
```

Not:

```text
mark
→ one branch
→ forget to restore
```

---

## 6. Understand what the recursion returns

Ask:

```text
Am I generating?
Counting?
Searching?
Optimizing?
```

This determines whether the function should return:

```text
void
int
boolean
best value
```

---

## 7. Recognize repeated states

If recursion gets TLE:

```text
Is the same state being solved repeatedly?
```

If yes:

```text
memoization / DP may be required
```

---

# 20. Minimal Revision Templates

These templates represent the same recursion tree in different forms.


## Grid generation

```java
static void solve(int row, int col) {

    if (success) {
        // store
        return;
    }

    mark();

    for (each direction) {

        if (isValid(next)) {

            makeChoice();

            solve(next);

            undoChoice();
        }
    }

    unmark();
}
```

## Grid counting

```java
static int solve(int row, int col) {

    if (failure) {
        return 0;
    }

    if (success) {
        return 1;
    }

    return solve(choice1)
         + solve(choice2);
}
```

## Word search

```java
static boolean solve(int row, int col, int idx) {

    if (word complete) {
        return true;
    }

    if (invalid) {
        return false;
    }

    mark();

    for (each direction) {
        if (solve(nextRow, nextCol, idx + 1)) {
            return true;
        }
    }

    unmark();

    return false;
}
```

---

# 21. Final Revision Checklist

Before solving a new grid-backtracking problem:

```text
1. What is my recursive state?
2. What is success?
3. What is failure?
4. What are my choices?
5. How do row/col change?
6. What makes a choice invalid?
7. Do I need visited?
8. What am I returning/storing?
9. What must I undo?
10. Can the same state repeat?
```

If these are clear, coding becomes much easier.

---

# 22. Final Pattern Memory

### Complete backtracking flow

```text
                    CURRENT STATE
                         |
                    list choices
                         |
                 +-------+-------+
                 |               |
              choice 1         choice 2
                 |               |
              validate?       validate?
              /      \         /      \
            NO       YES      NO       YES
            |          |      |          |
          skip       choose  skip       choose
                       |                 |
                    mark/append       mark/append
                       |                 |
                    recurse           recurse
                       |                 |
                    return            return
                       |                 |
                    undo            undo
                       |                 |
                       +-------+---------+
                               |
                         next choice
                               |
                         all choices done
                               |
                           unmark
                               |
                             return
```

### The shortest version to remember

```text
state
 ↓
choice
 ↓
validate
 ↓
choose / mark
 ↓
recurse
 ↓
undo / unmark
 ↓
next choice
```

> **Backtracking = explore one choice completely, return to the previous state, restore it, then try the next choice.**

---

# 23. M Section Completion

```text
141 ☑️ Rat in a Maze
142 ☑️ Maze Paths
143 ☑️ Maze Paths with Obstacles
144 ☑️ Count Maze Paths
145 ☑️ Word Search
146 ☑️ Word Search II
```

## M — COMPLETE

The six problems should now be revised as **one connected Grid / Maze Backtracking pattern**, not as six unrelated problems.
