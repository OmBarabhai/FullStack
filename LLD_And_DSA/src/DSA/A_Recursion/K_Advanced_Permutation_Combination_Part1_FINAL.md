# K — Advanced Permutation / Combination
## Part 1 — K111 to K115

> **Goal:** Understand how the choice space changes from explicit TAKE/SKIP to loop-based choices.

---

# Pattern 1 — TAKE / SKIP

## K111 — Generate All Subsets ⭐⭐⭐⭐⭐

### Pattern

```text
Every element
→ TAKE
→ SKIP
```

### State

```text
idx = current element
op  = current subset
```

### Algorithm

```text
if idx < 0:
    save op
    return

TAKE:
    add nums[idx]
    recurse(idx - 1)
    remove nums[idx]

SKIP:
    recurse(idx - 1)
```

### Why two recursive calls?

The current element has exactly two decisions:

```text
TAKE
  \
   recurse

SKIP
  \
   recurse
```

### Recursion Tree

For `[1,3]`:

```text
                 []
              /      \
           TAKE      SKIP
            1          |
           / \         |
         +3  -3       3
         /    \       / \
      [1,3]  [1]    [3] []
```

### Important Backtracking

```text
ADD
 ↓
RECURSE
 ↓
REMOVE
```

The remove restores the path before the other branch.

### Duplicate Note

The supplied code includes a commented duplicate-skip idea:

```java
while (idx > 0 && nums[idx] == nums[idx - 1]) {
    idx--;
}
```

For the current K111 example `[1,3]`, that logic is not used.

### Memory

```text
TAKE → RECURSE → UNDO → SKIP
```

---

# Pattern 2 — LOOP Creates the Choices

## K112 — Generate All K-Subsets ⭐⭐⭐⭐⭐

### Pattern

```text
FOR EACH CANDIDATE
→ CHOOSE
→ RECURSE
→ UNDO
```

### State

```text
start = current candidate boundary
op    = selected elements
k     = required size
count = selected count
```

### Algorithm

```text
if count > k:
    return

if count == k:
    save op
    return

for each allowed candidate:
    add candidate
    recurse with count + 1
    remove candidate
```

### The Important Difference From K111

K111:

```text
TAKE
→ recurse

SKIP
→ recurse
```

K112:

```text
for each candidate:
    choose
    → recurse
    → undo
```

The **loop itself moves to the next choice**.

So K112 does not need a separate:

```text
skip → recurse
```

branch.

### Small Tree

For candidates `1..4`, choosing `2`:

```text
             start=4
          /     |     |     \
         4      3     2      1
         |      |     |      |
      recurse recurse recurse recurse
```

### Important State Distinction

```text
count
→ how many are already selected

k
→ how many are required

start
→ where choices can continue
```

### Code Detail From Your Implementation

Your current code uses:

```java
op.add(idx);
```

So in that implementation `idx` is being used as the candidate value.

Do not confuse this with an array position in other problems.

### Memory

```text
LOOP
→ CHOOSE
→ RECURSE
→ UNDO
→ NEXT CHOICE
```

---

# Pattern 3 — TAKE / SKIP on a String

## K113 — Subsets of a String ⭐⭐⭐⭐⭐

### Pattern

Same decision tree as K111:

```text
TAKE
or
SKIP
```

### State

```text
idx = current character
sb  = current selected characters
```

### Algorithm

```text
if idx >= str.length():
    save sb
    return

TAKE:
    append str[idx]
    recurse(idx + 1)
    delete last

SKIP:
    recurse(idx + 1)
```

### Why `deleteCharAt()`?

The same `StringBuilder` is shared by all branches.

Example:

```text
sb = "AB"

TAKE C
→ "ABC"

return

UNDO
→ "AB"
```

Now the SKIP branch starts correctly from `"AB"`.

### Tree

For `"AB"`:

```text
                 ""
               /    \
             A       ""
            / \     / \
          AB   A   B   ""
```

### Memory

```text
APPEND → RECURSE → DELETE → SKIP
```

---

# Pattern 4 — Choice Depends on the Character

## K114 — Letter Case Permutation ⭐⭐⭐⭐⭐

### Pattern

```text
LETTER
→ UPPERCASE / lowercase

DIGIT
→ same digit
```

### State

```text
idx = current character
sb  = current answer
```

### Algorithm

```text
if idx == length:
    save answer
    return

if current char is a letter:
    choose uppercase
    recurse
    undo

    choose lowercase
    recurse
    undo

else:
    append digit
    recurse
    undo
```

### Tree Idea

For:

```text
a1b
```

```text
          a1b
         /   \
       A1b   a1b
```

The `1` does not branch.

### Why?

The current input character determines the choice count:

```text
letter → 2 choices
digit  → 1 choice
```

### Memory

```text
LETTER → UPPER / LOWER
DIGIT  → SAME
```

---

# Pattern 5 — FOR EACH AVAILABLE CHOICE

## K115 — Phone Keypad Combinations ⭐⭐⭐⭐⭐

### Pattern

```text
current digit
→ get its letters
→ try every letter
→ recurse
→ undo
```

### State

```text
idx = current digit
sb  = current combination
```

### Algorithm

```text
if idx >= digits.length():
    save sb
    return

digit = digits[idx]
letters = mapping[digit]

for every letter:
    append letter
    recurse(idx + 1)
    delete last
```

### Why This Uses a Loop

A digit can have different numbers of choices:

```text
2 → abc
7 → pqrs
```

So the recursion cannot be hard-coded as only two branches.

### Tiny Example

```text
digits = "23"

2 → a b c
3 → d e f
```

Tree:

```text
            ""
        /    |    \
       a     b     c
      /|\   /|\   /|\
     ad ae af ...
```

Total:

```text
3 × 3 = 9
```

### Important Code Detail

```java
digits.charAt(idx) - '0'
```

converts:

```text
'2' → 2
```

so:

```java
lettersStr[2]
```

gives:

```text
"abc"
```

### Memory

```text
DIGIT
→ GET LETTERS
→ LOOP
→ APPEND
→ RECURSE
→ DELETE
```

---

# K111–K115 Pattern Map

```text
K111
TAKE / SKIP
      ↓
K112
LOOP → CHOOSE → RECURSE → UNDO
      ↓
K113
TAKE / SKIP on characters
      ↓
K114
choice count depends on character
      ↓
K115
loop through letters of current digit
```

---

# The Main Recognition Rule

```text
TWO EXPLICIT DECISIONS
→ usually two recursive calls

MANY VALID CHOICES
→ usually loop + one recursive call
```

### K111 vs K112

```text
K111:
element
 /    \
TAKE  SKIP

K112:
start
 |
for each candidate
 |  |  |  |
 4  3  2  1
```

---

# Universal Choice Pattern

```text
STATE
 ↓
AVAILABLE CHOICES
 ↓
CHOOSE
 ↓
MODIFY
 ↓
RECURSE
 ↓
UNDO
 ↓
NEXT CHOICE
```

### Revision Checklist

```text
1. What is the state?
2. Where do the choices come from?
3. Is this TAKE/SKIP or a loop?
4. How many choices exist?
5. What changes before recursion?
6. What must be undone?
7. What is the base case?
```
