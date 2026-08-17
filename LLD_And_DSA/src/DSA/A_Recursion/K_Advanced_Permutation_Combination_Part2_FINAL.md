# K — Advanced Permutation / Combination
## Part 2 — K116 to K120

> **Main new ideas:** pending state, direct K-th selection, unused-element permutation, and generic password generation.

---

# Pattern 6 — Choice + Pending State

## K116 — Generate All Abbreviations ⭐⭐⭐⭐⭐

### Pattern

Every character has two choices:

```text
ABBREVIATE
or
KEEP
```

But abbreviation is stored as a **pending count**.

### State

```text
idx   = current character
count = consecutive abbreviated characters not written yet
sb    = finalized abbreviation built so far
```

### The Most Important Idea

Suppose:

```text
ABC
```

and we abbreviate:

```text
A
B
```

Then:

```text
count = 2
sb    = ""
```

We do **not** write `2` yet.

If we KEEP `C`:

```text
write count → 2
write C     → 2C
```

### Algorithm

```text
if idx == length:
    if count > 0:
        append count
    save answer
    return

ABBREVIATE:
    recurse(idx + 1, count + 1)

KEEP:
    if count > 0:
        append count

    append current character

    recurse(idx + 1, count = 0)

    restore StringBuilder
```

### Why `count` is needed

Consecutive abbreviations:

```text
A + B
```

must become:

```text
2
```

not:

```text
11
```

So:

```text
ABBREVIATE → count++
```

### Why KEEP Writes Count First

If:

```text
A abbreviated
B abbreviated
C kept
```

then:

```text
count = 2
```

KEEP must produce:

```text
2C
```

not:

```text
C2
```

Therefore:

```text
WRITE COUNT
→ WRITE CHARACTER
```

### Why Base Case Writes Count

All characters can be abbreviated:

```text
A → count 1
B → count 2
C → count 3
```

At the end:

```text
sb = ""
count = 3
```

So the final answer must be:

```text
3
```

### Backtracking

Your implementation saves:

```java
int len = sb.length();
```

and later:

```java
sb.setLength(len);
```

This restores the exact StringBuilder state before that branch.

### Tiny Dry Runs

```text
ABC → 3
```

```text
A abbreviated → count 1
B abbreviated → count 2
C abbreviated → count 3
END → write 3
```

```text
ABC → 2C
```

```text
A abbreviated → count 1
B abbreviated → count 2
C kept → write 2, then C
```

```text
ABC → 1B1
```

```text
A abbreviated → count 1
B kept → write 1B, reset count
C abbreviated → count 1
END → write 1
```

### Recursion Shape

```text
                    current char
                    /          \
             ABBREVIATE       KEEP
                  |              |
              count + 1      flush count
                  |              |
               recurse        append char
                                 |
                              count = 0
```

### Memory

```text
ABBR → COUNT++
KEEP → FLUSH COUNT → CHAR → RESET
END  → FLUSH COUNT
```

---

# Pattern 7 — Factorial Block Selection

## K117 — Permutation Sequence ⭐⭐⭐⭐⭐

## K118 — K-th Permutation Using Recursion ⭐⭐⭐⭐⭐

> These two problems use the same important mathematical idea. K118 is the recursive implementation you should be able to rebuild.

---

## Core Pattern

Do **not** generate all permutations.

Instead:

```text
FACTORIAL
 ↓
BLOCK SIZE
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

---

## Why `block = (size - 1)!`

Suppose:

```text
nums = [1,2,3,4]
```

If we choose the first number, then:

```text
3 numbers remain
```

Those 3 numbers can be arranged in:

```text
3! = 6
```

ways.

Therefore each possible first number owns a block of:

```text
(size - 1)!
```

permutations.

So:

```java
int block = fact(nums.size() - 1);
```

means:

```text
How many permutations start with each possible next number?
```

---

## Why `idx = (k - 1) / block`

`k` is 1-based.

Java list indexes are 0-based.

So first:

```text
k - 1
```

converts the position to 0-based.

Then:

```java
int idx = (k - 1) / block;
```

tells us **which block contains the K-th permutation**.

### Example

```text
nums = [1,2,3,4]
k = 8

block = 3! = 6

idx = (8 - 1) / 6
    = 1
```

So:

```text
nums[1] = 2
```

The answer starts with:

```text
2
```

---

## Why `nums.remove(idx)`

Once:

```text
2
```

has been selected as the current position, it cannot be selected again.

So:

```text
[1,2,3,4]
      ↓
select 2
      ↓
[1,3,4]
```

The recursive problem now uses only the remaining numbers.

---

## Why `k = (k - 1) % block + 1`

Original `k` means:

```text
K-th permutation among ALL current permutations.
```

After selecting the correct block, we need:

```text
K-th permutation INSIDE that block.
```

So:

```java
k = (k - 1) % block + 1;
```

### Example

```text
k = 8
block = 6
```

```text
(8 - 1) % 6 + 1
= 7 % 6 + 1
= 2
```

Meaning:

```text
8th overall
→ 2nd inside the selected block
```

### Why not `k % block`?

At:

```text
k = 6
block = 6
```

the local answer must be:

```text
6
```

but:

```text
6 % 6 = 0
```

Therefore the 1-based-safe formula is:

```text
(k - 1) % block + 1
```

---

# K118 — Exact Recursive Flow

### Base Case

```java
if (nums.size() == 1) {
    sb.append(nums.get(0));
    return;
}
```

One number remains.

There is only one possible continuation.

### Full Algorithm

```text
if one number remains:
    append it
    return

block = (size - 1)!

idx = (k - 1) / block

select nums[idx]
append selected

remove selected

k = (k - 1) % block + 1

recurse on smaller list
```

---

## Full Dry Run — `n = 4, k = 8`

### Step 1

```text
nums = [1,2,3,4]
k = 8

block = 3! = 6

idx = (8 - 1) / 6
    = 1

select 2
```

Now:

```text
sb = "2"
nums = [1,3,4]
```

Update K:

```text
k = (8 - 1) % 6 + 1
  = 2
```

---

### Step 2

```text
nums = [1,3,4]
k = 2

block = 2! = 2

idx = (2 - 1) / 2
    = 0

select 1
```

Now:

```text
sb = "21"
nums = [3,4]
```

Update K:

```text
k = (2 - 1) % 2 + 1
  = 1
```

---

### Step 3

```text
nums = [3,4]
k = 1

block = 1! = 1

idx = (1 - 1) / 1
    = 0

select 3
```

Now:

```text
sb = "213"
nums = [4]
```

Update K:

```text
k = 1
```

---

### Step 4 — Base Case

```text
nums = [4]
```

Append:

```text
4
```

Final:

```text
2134
```

---

## Why There Is No Normal Backtracking Undo

K111/K113/K115 explore multiple branches:

```text
choose
→ recurse
→ undo
→ next choice
```

K118 does something different:

```text
block calculation
→ tells us exactly which branch contains K
→ follow only that branch
```

So it does not need to generate the whole permutation tree.

The recursion path is:

```text
[1,2,3,4]
    ↓ choose 2
[1,3,4]
    ↓ choose 1
[3,4]
    ↓ choose 3
[4]
```

### Memory

```text
BLOCK
→ INDEX
→ SELECT
→ REMOVE
→ LOCAL K
→ RECURSE
```

---

# K119 — Print All Arrangements of Characters

## Pattern

```text
PERMUTATION
```

At each position:

```text
choose any UNUSED character
```

### Algorithm

```text
if all positions filled:
    print/store arrangement
    return

for every unused character:
    choose character
    mark used
    recurse
    unmark used
```

### Tree Idea

For:

```text
ABC
```

```text
          ""
       /   |   \
      A    B    C
     / \  / \  / \
   AB AC BA BC CA CB
    |  |  |  |  |  |
   ABC ACB BAC BCA CAB CBA
```

Total:

```text
3! = 6
```

### Important Difference

K111:

```text
TAKE / SKIP
```

K119:

```text
CURRENT POSITION
→ choose ANY UNUSED character
```

### Memory

```text
POSITION
→ TRY UNUSED
→ CHOOSE
→ RECURSE
→ UNDO
```

---

# K120 — Generate All Possible Passwords

## Pattern

```text
FIXED LENGTH
+
CHOOSE ONE CHARACTER FROM ALLOWED SET
```

### Algorithm

```text
if password length reached:
    save password
    return

for every allowed character:
    append
    recurse to next position
    remove
```

### Core Template

```java
for (char ch : choices) {
    sb.append(ch);
    solve(...);
    sb.deleteCharAt(sb.length() - 1);
}
```

### Example

Allowed choices:

```text
a, b, 1
```

Length:

```text
2
```

Then:

```text
aa
ab
a1
ba
bb
b1
1a
1b
11
```

Total:

```text
3^2 = 9
```

### Memory

```text
POSITION
→ ALLOWED CHOICES
→ APPEND
→ RECURSE
→ REMOVE
```

---

# K116–K120 Pattern Map

```text
K116
KEEP / ABBREVIATE
       +
PENDING COUNT

K117 / K118
FACTORIAL BLOCKS
       ↓
DIRECT K-th SELECTION

K119
POSITION
       ↓
UNUSED CHARACTER
       ↓
PERMUTATION

K120
POSITION
       ↓
ALLOWED CHARACTER
       ↓
GENERATE ALL
```

---

# K111–K120 Final Pattern Map

```text
K111
TAKE / SKIP
      ↓
K112
LOOP → CHOOSE → RECURSE → UNDO
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
K117 / K118
BLOCK → INDEX → SELECT → REMOVE → LOCAL K → RECURSE
      ↓
K119
POSITION → UNUSED CHARACTER
      ↓
K120
POSITION → ALLOWED CHOICES
```

---

# K — One-Page Memory

```text
K111 → TAKE / SKIP
K112 → LOOP CHOICES + UNDO
K113 → TAKE / SKIP STRING
K114 → LETTER UPPER/LOWER
K115 → DIGIT → LETTER LOOP
K116 → ABBR COUNT / KEEP FLUSH
K117 → FACTORIAL BLOCK
K118 → BLOCK → INDEX → SELECT → REMOVE → LOCAL K → RECURSE
K119 → UNUSED CHARACTER PERMUTATION
K120 → ALLOWED CHARACTER GENERATION
```

---

# Final Revision Checklist

```text
1. What is the current STATE?

2. Where do the choices come from?

3. Is this TAKE/SKIP or LOOP-based?

4. What changes after CHOOSE?

5. What must be UNDONE?

6. Is there extra state carried through recursion?
   Example: K116 → count

7. Can the answer be selected directly?
   Example: K118 → factorial blocks

8. What is the BASE CASE?

9. What exactly does the recursive call solve?
