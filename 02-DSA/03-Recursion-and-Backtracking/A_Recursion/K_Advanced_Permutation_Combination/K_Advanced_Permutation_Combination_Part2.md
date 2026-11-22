# K — Advanced Permutation / Combination
## Problems 116–120

> These problems are the more important revision section because the recursion state becomes richer.

---

# K116 — Generate All Abbreviations

## Pattern

At each character there are two decisions:

```text
ABBREVIATE current character
        OR
KEEP current character
```

But abbreviation uses a **count** instead of immediately writing the skipped characters.

## State

```text
idx   = current character
count = consecutive characters currently abbreviated
sb    = abbreviation built so far
```

The important idea:

```text
skip character → count++

keep character → first write count, then write character
```

## Small Algorithm

```text
if all characters processed:
    if count > 0:
        append count
    save result
    restore StringBuilder
    return

ABBREVIATE:
    count + 1
    recurse

KEEP:
    if count > 0:
        append count
    append current character
    recurse with count = 0
```

## Why `count`?

For:

```text
ABC
```

If we abbreviate:

```text
A
B
C
```

we do not write:

```text
123
```

We write:

```text
3
```

So consecutive skipped characters are compressed into one number.

## Tiny Tree

```text
                         ABC
                       /     \
                  ABBR A    KEEP A
                     |         |
                  count=1      A
                   / \        / \
              ABBR B KEEP B ABBR B KEEP B
```

Examples:

```text
ABC
AB1
A1C
A2
1BC
2C
3
```

## Critical Detail

When keeping a character:

```java
if (count > 0) {
    sb.append(count);
}
sb.append(str.charAt(idx));
```

The count must be written **before** the character.

Then:

```java
solve(..., 0, idx + 1, ...);
```

because the abbreviation run has ended.

## Why Save `len`?

```java
int len = sb.length();
```

After a branch changes `sb`, we restore:

```java
sb.setLength(len);
```

This returns the builder to exactly the state it had before that branch.

## Memory Pattern

```text
ABBR → count + 1 → RECURSE
KEEP → WRITE COUNT → WRITE CHAR → count=0 → RECURSE
```

---

# K117 — Permutation Sequence

## Core Idea

Instead of generating every permutation, find the required permutation directly.

For `n` numbers:

```text
first position
 ↓
groups of (n-1)! permutations
 ↓
select group
 ↓
remove selected number
 ↓
repeat
```

This is the same mathematical block idea used in K118.

## Small Algorithm

```text
create available numbers

while numbers remain:

    block = (remaining size - 1)!

    find which block contains k

    select that number

    remove it

    update k to its position inside the block
```

## Block Idea

For:

```text
[1,2,3,4]
```

fixing the first number leaves `3` numbers.

Therefore:

```text
3! = 6
```

permutations belong to each first-number block.

```text
1 → 6 permutations
2 → 6 permutations
3 → 6 permutations
4 → 6 permutations
```

So:

```text
k = 8
```

belongs to the block starting with `2`.

## Important Formula

```text
idx = (k - 1) / block
```

Why `k - 1`?

Because `k` is 1-based, while a Java list is 0-based.

Example:

```text
k = 8
block = 6

idx = (8 - 1) / 6
    = 7 / 6
    = 1
```

So select:

```text
nums[1] = 2
```

## Updated K

After selecting a block:

```text
k = (k - 1) % block + 1
```

For:

```text
k = 8
block = 6
```

```text
k = (8 - 1) % 6 + 1
  = 7 % 6 + 1
  = 2
```

So inside the selected block, we now need the:

```text
2nd permutation
```

## Why Remove the Selected Number?

Once a number is placed, it cannot be used again.

Example:

```text
[1,2,3,4]

choose 2

remaining:

[1,3,4]
```

The next position must come from this smaller list.

## Memory Pattern

```text
BLOCK → INDEX → SELECT → REMOVE → LOCAL K → REPEAT
```

---

# K118 — K-th Permutation Using Recursion

## Main Idea

This is the recursive form of the same block-selection method.

Do **not** generate all permutations.

At every recursion level:

```text
remaining numbers
      ↓
calculate block size
      ↓
find correct block
      ↓
select number
      ↓
remove number
      ↓
convert global k to local k
      ↓
recurse on smaller list
```

## Base Case

```java
if (nums.size() == 1) {
    sb.append(nums.get(0));
    return;
}
```

Only one number remains, so it must be the final character.

## Why

```java
block = fact(nums.size() - 1);
```

Suppose:

```text
nums = [1,2,3,4]
```

If the first number is fixed, there are `3` numbers left.

Those 3 numbers can be arranged in:

```text
3! = 6
```

ways.

Therefore each possible first number owns a block of:

```text
(n - 1)!
```

permutations.

## Why

```java
idx = (k - 1) / block;
```

`k` is 1-based.

Java list indexes are 0-based.

Subtracting 1 first converts:

```text
1,2,3,4,5,6
```

into:

```text
0,1,2,3,4,5
```

Then integer division tells us which block contains `k`.

### Example

```text
nums = [1,2,3,4]
k = 8
block = 3! = 6

idx = (8 - 1) / 6
    = 1
```

Select:

```text
nums[1] = 2
```

## Why Remove?

After choosing `2`:

```text
[1,2,3,4]
      ↓
choose 2
      ↓
[1,3,4]
```

`2` has already been used.

The remaining recursion only needs to arrange:

```text
[1,3,4]
```

## Why Update K?

Original `k` means:

```text
k-th permutation among ALL current permutations
```

After selecting the correct block, we need the position **inside that block**.

Use:

```java
k = (k - 1) % block + 1;
```

Example:

```text
k = 8
block = 6

local k = (8 - 1) % 6 + 1
        = 2
```

So after selecting `2`, the problem becomes:

```text
find the 2nd permutation of [1,3,4]
```

## Full Dry Run — n = 4, k = 8

### Step 1

```text
nums = [1,2,3,4]
k = 8

block = 3! = 6

idx = (8-1)/6
    = 1

select 2

nums = [1,3,4]

k = (8-1)%6 + 1
  = 2
```

Result so far:

```text
2
```

### Step 2

```text
nums = [1,3,4]
k = 2

block = 2! = 2

idx = (2-1)/2
    = 0

select 1

nums = [3,4]

k = (2-1)%2 + 1
  = 1
```

Result:

```text
21
```

### Step 3

```text
nums = [3,4]
k = 1

block = 1! = 1

idx = (1-1)/1
    = 0

select 3

nums = [4]

k = (1-1)%1 + 1
  = 1
```

Result:

```text
213
```

### Step 4 — Base Case

```text
nums = [4]
```

Append `4`.

Final:

```text
2134
```

## K118 Code Skeleton

```java
solve(nums, k, sb) {

    if (nums.size() == 1) {
        append remaining number;
        return;
    }

    block = (nums.size() - 1)!;

    idx = (k - 1) / block;

    select nums[idx];

    remove nums[idx];

    k = (k - 1) % block + 1;

    solve(smaller nums, k, sb);
}
```

## Memory Pattern

```text
BLOCK
  ↓
INDEX
  ↓
SELECT
  ↓
REMOVE
  ↓
LOCAL K
  ↓
RECURSE
```

This is the most important K118 sequence to remember.

---

# K119 — Print All Arrangements of Characters

## Pattern

Permutation generation.

Unlike subsets, we do not decide:

```text
TAKE / SKIP
```

Instead:

```text
Which unused character should occupy this position?
```

## Small Algorithm

```text
if every position is filled:
    print arrangement
    return

for every unused character:
    choose character
    mark used
    recurse
    unmark used
```

## Core Pattern

```text
POSITION
   ↓
TRY EVERY UNUSED CHARACTER
   ↓
CHOOSE
   ↓
RECURSE
   ↓
UNDO
```

## Tiny Example

For:

```text
ABC
```

first position:

```text
A
B
C
```

If we choose `A`:

```text
A
├── AB
│   ├── ABC
│   └── ...
└── AC
    └── ACB
```

Similarly:

```text
B → BAC, BCA
C → CAB, CBA
```

Total:

```text
3! = 6
```

## Important Difference From K111

K111:

```text
each element → TAKE / SKIP
```

K119:

```text
each position → choose ANY UNUSED element
```

That changes the branching structure.

## Memory Pattern

```text
POSITION → TRY UNUSED → CHOOSE → RECURSE → UNDO
```

---

# K120 — Generate All Possible Passwords

## Pattern

This is general **choice generation**.

At each password position:

```text
choose one character from the allowed character set
```

Then recurse to the next position.

## Small Algorithm

```text
if password length reached:
    save password
    return

for every allowed character:
    append character
    recurse
    remove character
```

## Tiny Example

Allowed characters:

```text
a, b, 1
```

Password length:

```text
2
```

Tree starts:

```text
        ""
     /   |   \
    a    b    1
   /|\  /|\  /|\
  ...  ...  ...
```

Number of passwords:

```text
choices ^ length
```

For:

```text
3 choices
length = 2
```

```text
3^2 = 9
```

## Core Code Shape

```java
for (char ch : choices) {

    sb.append(ch);

    solve(...);

    sb.deleteCharAt(sb.length() - 1);
}
```

## Why Backtracking?

The same `StringBuilder` is reused.

```text
choose a
 ↓
recurse
 ↓
remove a
 ↓
choose b
 ↓
recurse
```

Without removal, the next password would contain characters from the previous branch.

## Memory Pattern

```text
POSITION → LOOP CHOICES → APPEND → RECURSE → REMOVE
```

---

# K116–K120 Pattern Map

```text
K116
TAKE / KEEP
    +
COUNT STATE

K117 / K118
FACTORIAL BLOCKS
    ↓
DIRECTLY FIND K-TH PERMUTATION

K119
POSITION
    ↓
CHOOSE ANY UNUSED CHARACTER
    ↓
PERMUTATION

K120
POSITION
    ↓
CHOOSE FROM ALLOWED SET
    ↓
GENERATE ALL
```

---

# The Most Important Recognition Rules

## 1. TAKE / SKIP

Use when every item has two decisions:

```text
TAKE
SKIP
```

Pattern:

```text
choose
recurse
undo
recurse
```

Examples:

```text
K111
K113
```

---

## 2. LOOP + BACKTRACK

Use when the current position can choose from multiple candidates.

Pattern:

```text
for each choice:
    choose
    recurse
    undo
```

Examples:

```text
K115
K119
K120
```

---

## 3. Conditional Choices

The available choices depend on the current input.

Example:

```text
letter → uppercase / lowercase
digit  → unchanged
```

Example:

```text
K114
```

---

## 4. Extra State

Sometimes recursion needs more than `idx`.

Example:

```text
K116 → count
```

The extra state tells recursion what has happened to the current run.

---

## 5. Direct K-th Selection

Do not generate every permutation.

Use:

```text
BLOCK → INDEX → SELECT → REMOVE → LOCAL K → RECURSE
```

Examples:

```text
K117
K118
```

---

# Final K Folder Memory Sheet

```text
K111
TAKE / SKIP
        ↓
K112
LOOP CHOICE + UNDO
        ↓
K113
TAKE / SKIP on String
        ↓
K114
LETTER → UPPER / LOWER
DIGIT  → SAME
        ↓
K115
DIGIT → LETTERS → LOOP
        ↓
K116
ABBREVIATE / KEEP + COUNT
        ↓
K117
FACTORIAL BLOCK SELECTION
        ↓
K118
BLOCK → INDEX → SELECT → REMOVE → LOCAL K → RECURSE
        ↓
K119
POSITION → UNUSED CHARACTER
        ↓
K120
POSITION → ALLOWED CHOICES
```

# One Master Pattern

Most K problems reduce to:

```text
DEFINE CURRENT POSITION
        ↓
FIND AVAILABLE CHOICES
        ↓
CHOOSE
        ↓
UPDATE STATE
        ↓
RECURSE
        ↓
UNDO
```

But K117/K118 are different:

```text
COUNT PERMUTATIONS IN BLOCKS
        ↓
FIND BLOCK
        ↓
SELECT DIRECTLY
        ↓
REMOVE
        ↓
CONVERT K TO LOCAL K
        ↓
RECURSE
```
