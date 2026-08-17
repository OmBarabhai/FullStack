# I — Choice / Generation

> **Goal:** Recognize the choice tree and derive the recursion instead of memorizing separate solutions.

---

# Pattern 1 — Fixed Position + Multiple Choices

## I96 — All Strings From `{a,b}` ⭐⭐⭐⭐

**Pattern:** Each position has two choices.

### Algorithm

```text
position = current index

if position == n:
    print/store string

choose A
→ append
→ recurse(position + 1)
→ delete last

choose B
→ append
→ recurse(position + 1)
→ delete last
```

### Memory

```text
POSITION
→ A / B
→ RECURSE
→ UNDO
```

### Recursion Tree

```text
             ""
           /    \
          A      B
        /  \    /  \
      AA   AB  BA   BB
      ...       ...
```

For length `3`:

```text
AAA AAB ABA ABB
BAA BAB BBA BBB
```

### State

```text
idx  = current position
sb   = current string
```

### Base Case

```text
idx == n
→ complete string
```

---

## I97 — All Strings From Digits `{0,1,2}` ⭐⭐⭐⭐

**Pattern:** Same as I96; only the choice set changes.

### Algorithm

```text
position = current index

for each choice in {0,1,2}:
    append choice
    recurse(position + 1)
    delete last
```

### Memory

```text
POSITION
→ 0 / 1 / 2
→ RECURSE
→ UNDO
```

### Recursion Tree

```text
                ""
           /     |     \
          0      1      2
        / | \   / | \  / | \
       0  1  2  0 1 2 0 1 2
```

For length `2`:

```text
00 01 02
10 11 12
20 21 22
```

### Complexity

For `N` positions and `3` choices:

```text
outputs = 3^N
time    = O(N × 3^N)
space   = O(N)
```

---

# Pattern 2 — Choices From an Input Array

## I98 — Print All Choices From an Array ⭐⭐⭐⭐

**Pattern:** At each position, choose from the input array.

### Algorithm

```text
position = current index

if position == required length:
    print/store path

for each arr[i]:
    choose arr[i]
    recurse(position + 1)
    undo
```

### Memory

```text
INPUT ARRAY
→ TRY EVERY CHOICE
→ RECURSE
→ UNDO
```

### Core Template

```java
for (int i = 0; i < arr.length; i++) {
    path.add(arr[i]);
    solve(...);
    path.remove(path.size() - 1);
}
```

### Important Question

```text
Can I reuse arr[i]?
```

If yes:

```text
same choices remain available
```

If no:

```text
track used[]
```

Do not assume `i + 1` automatically. The problem decides the transition.

---

# Pattern 3 — Count Valid Choices

## I99 — Count Ways to Choose K Items ⭐⭐⭐⭐⭐

**Pattern:** Take / Not-Take + counting.

### State

```text
idx = current item
k   = items still needed
```

### Algorithm

```text
if k == 0:
    return 1

if idx >= n:
    return 0

take =
    solve(idx + 1, k - 1)

notTake =
    solve(idx + 1, k)

return take + notTake
```

### Memory

```text
TAKE     → k - 1
NOT TAKE → k
BOTH     → idx + 1

ANSWER = TAKE + NOT TAKE
```

### Recursion Tree

For `n = 4, k = 2`:

```text
                    (0,2)
                  /       \
              TAKE       NOT TAKE
               |             |
             (1,1)         (1,2)
             /   \         /   \
          (2,0) (2,1)   (2,1) (2,2)
            |      |       |      |
            1      ...     ...    ...
```

### Base Cases

```text
k == 0
→ one valid way
→ return 1

idx == n
→ not enough items remain
→ return 0
```

### Connection

```text
I99
↓
count ways to choose K
↓
nCk
↓
J105 / J106 generate the actual combinations
```

---

# Pattern 4 — Include / Exclude

## I100 — Include/Exclude Subset Framework ⭐⭐⭐⭐⭐

**Pattern:** Every element has exactly two decisions.

### Algorithm

```text
if idx == arr.length:
    process current subset
    return

INCLUDE:
    add arr[idx]
    recurse(idx + 1)
    remove

EXCLUDE:
    recurse(idx + 1)
```

### Memory

```text
INCLUDE
→ RECURSE
→ UNDO

EXCLUDE
→ RECURSE
```

### Recursion Tree

For:

```text
[11,22,33]
```

```text
                    []
                  /    \
              include  exclude
               11         |
               |          |
            [11]          []
            /  \         /  \
          +22  -22     +22  -22
           /      \      /      \
       [11,22]   [11]  [22]     []
         / \       /     / \      / \
       +33 -33  +33   +33 -33  +33 -33
```

Leaves:

```text
[11,22,33]
[11,22]
[11,33]
[11]
[22,33]
[22]
[33]
[]
```

### Base Case

```text
idx == arr.length
→ one complete subset
```

### Why Undo?

```text
add 33
→ recurse
→ remove 33
```

Without undo, the next branch would incorrectly inherit `33`.

### Complexity

```text
subsets = 2^N
time    = O(N × 2^N) when copying/printing each subset
space   = O(N) auxiliary
```

---

# I96–I100 Pattern Comparison

| Problem | Choices | Output | Main State |
|---|---|---|---|
| I96 | `A, B` | Strings | `idx, path` |
| I97 | `0, 1, 2` | Strings | `idx, path` |
| I98 | `arr[i]` | Strings/paths | `idx, path` |
| I99 | TAKE / NOT-TAKE | Count | `idx, k` |
| I100 | INCLUDE / EXCLUDE | Subsets | `idx, path` |

---

# Choice Generation vs Take / Not-Take

## Take / Not-Take

```text
               element
               /     \
            TAKE     SKIP
```

Exactly two decisions.

## Choice Generation

```text
                 state
            /      |      \
        choice1 choice2 choice3
```

One branch for every valid choice.

### Memory

```text
2 choices
→ TAKE / SKIP

many choices
→ FOR EACH CHOICE
```

---

# Universal Choice Backtracking

```text
STATE
  ↓
AVAILABLE CHOICES
  ↓
CHOOSE
  ↓
MODIFY STATE
  ↓
RECURSE
  ↓
UNDO
  ↓
NEXT CHOICE
```

### Universal Undo Rule

```text
path.add(x)
→ path.remove(last)

sb.append(x)
→ sb.deleteCharAt(last)

used[i] = true
→ used[i] = false

swap(...)
→ swap(...) again
```

> **Undo exactly what you changed.**

---

# Reuse vs No Reuse

Before coding, ask:

```text
Can I choose the same option again?
```

### Reuse allowed

```text
same choice can remain available
```

Example:

```text
fixed-length string generation
```

### Reuse not allowed

```text
remove / move past / mark used
```

The transition must come from the problem, not from a memorized `i + 1`.

---

# Generate vs Count

The recursion tree can answer different questions.

### Generate

```text
visit every valid leaf
→ store/print path
```

### Count

```text
return number of valid leaves
```

Typical counting:

```java
return take + notTake;
```

### Check

```text
return take || notTake;
```

Same decision tree, different answer type.

---

# Common Mistakes

```text
❌ Forgetting undo
❌ Wrong loop bounds
❌ Wrong base case
❌ State does not move toward base case
❌ Duplicate answers
❌ Reuse confusion
```

### Quick debugging questions

```text
What changed before recursion?

What is guaranteed to become smaller?

What exactly means COMPLETE?

What choices are legal?

What must be restored?
```

---

# Pattern Evolution

```text
I96
2 fixed choices
   ↓
I97
3 fixed choices
   ↓
I98
choices come from input
   ↓
I99
same choice idea + COUNT
   ↓
I100
general INCLUDE / EXCLUDE
   ↓
J101+
PERMUTATION / COMBINATION
```

---

# Quick Recognition

| Problem wording | Think |
|---|---|
| Build fixed-length strings | **Choice generation** |
| Choose from `{a,b}` | **2-way branching** |
| Choose from `{0,1,2}` | **3-way branching** |
| Choose from array | **Loop over choices** |
| Count ways to choose K | **TAKE / NOT-TAKE + count** |
| Generate all subsets | **INCLUDE / EXCLUDE** |
| Every branch modifies a path | **Backtracking** |

---

# One-Page Memory

```text
I96
POSITION → A/B → RECURSE → UNDO

I97
POSITION → 0/1/2 → RECURSE → UNDO

I98
POSITION → ARR[i] → RECURSE → UNDO

I99
TAKE → k-1
NOT TAKE → k
ANSWER = TAKE + NOT TAKE

I100
INCLUDE → RECURSE → UNDO
EXCLUDE → RECURSE
```

---

# Final Checklist

```text
1. What is my STATE?
2. What is my current position?
3. What choices are available?
4. How many choices are there?
5. Can a choice be reused?
6. What means COMPLETE?
7. What is the BASE CASE?
8. What changes before recursion?
9. What must be UNDONE?
10. Am I GENERATING, COUNTING, or CHECKING?
11. What is the branching factor?
12. What is the complexity?
```
