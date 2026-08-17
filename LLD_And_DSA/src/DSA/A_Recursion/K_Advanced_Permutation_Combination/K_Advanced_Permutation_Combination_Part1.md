# K — Advanced Permutation / Combination
## Problems 111–115

> Revision goal: understand **why the recursion branches the way it does** so the code can be rebuilt from memory.

---

# K111 — Generate All Subsets

## Pattern

```text
Current element
   ↓
TAKE / INCLUDE
   ↓
RECURSE
   ↓
UNDO
   ↓
SKIP / EXCLUDE
   ↓
RECURSE
```

Every element has exactly **2 choices**.

## Small Algorithm

```text
if all elements processed:
    save current subset
    return

take current element
recurse
remove current element

skip current element
recurse
```

## Core Code Shape

```java
op.add(nums[idx]);
solve(nums, idx - 1, ans, op);
op.remove(op.size() - 1);

solve(nums, idx - 1, ans, op);
```

### Why are there 2 recursive calls?

Because the current element has two decisions:

```text
TAKE
SKIP
```

This is different from a loop-based choice problem.

## Recursion Tree

For `[1, 3]`:

```text
                 []
              /      \
           TAKE 1   SKIP 1
             /          \
          [1]            []
          / \            / \
       +3   -3       +3   -3
        /     \       /     \
     [1,3]   [1]     [3]     []
```

## Base Case

```java
if (idx < 0) {
    ans.add(new ArrayList<>(op));
    return;
}
```

At this point every element has received a TAKE/SKIP decision.

## Important Backtracking

```text
TAKE 1
 ↓
RECURSE
 ↓
REMOVE 1
 ↓
SKIP 1
```

`remove()` restores the list before exploring the other branch.

## TC / SC

```text
Number of subsets = 2^N

TC = O(N × 2^N)   // storing/copying each subset
SC = O(N)         // recursion + current path
```

## Memory Pattern

```text
TAKE → RECURSE → UNDO → SKIP → RECURSE
```

---

# K112 — Generate All K-Subsets

## Pattern

This uses **choice from a loop** rather than explicit TAKE/SKIP calls.

```text
for every possible candidate:
    choose
    recurse
    undo
```

## Small Algorithm

```text
if count == k:
    save current subset
    return

for each candidate:
    choose candidate
    recurse with count + 1
    remove candidate
```

## Important Difference From K111

K111:

```text
TAKE
SKIP
```

So there are two recursive calls.

K112:

```text
for candidate 1
    recurse

for candidate 2
    recurse

for candidate 3
    recurse
```

The **loop creates the choices**.

That is why there is only one recursive call inside the loop.

## Core Code Shape

```java
for (int idx = start; idx > 0; idx--) {
    op.add(idx);

    solve(nums, idx - 1, ans, op, k, count + 1);

    op.remove(op.size() - 1);
}
```

## Why `idx - 1`?

After choosing the current candidate, only earlier candidates are allowed.

```text
choose 4
 ↓
next candidates: 3, 2, 1
```

This prevents selecting the same candidate again and avoids duplicate ordering such as:

```text
[2,3]
[3,2]
```

## Recursion Tree

For candidates `1..4`, choose `k = 2`:

```text
                 start=4
             /     |     |     \
            4      3     2      1
           /|\    /|\    /\
          ...    ...    ...
```

The exact tree depends on the current `start`.

## Base Case

```java
if (count == k) {
    ans.add(new ArrayList<>(op));
    return;
}
```

A second guard:

```java
if (count > k) return;
```

prevents unnecessary work if the count passes `k`.

## K111 vs K112

| K111 | K112 |
|---|---|
| TAKE/SKIP | choose from loop |
| 2 recursive calls | 1 recursive call inside loop |
| processes one element | chooses among candidates |
| subset size can vary | subset size must equal `k` |

## Memory Pattern

```text
LOOP → CHOOSE → RECURSE → UNDO → NEXT CHOICE
```

---

# K113 — Subsets of a String

## Pattern

Same TAKE/SKIP framework as K111.

The only difference is the input is a `String`.

## Small Algorithm

```text
if idx reaches string length:
    save current string
    return

take current character
recurse
remove character

skip current character
recurse
```

## Core Code Shape

```java
sb.append(str.charAt(idx));
solve(sb, str, idx + 1, ans);

sb.deleteCharAt(sb.length() - 1);

solve(sb, str, idx + 1, ans);
```

## Why `deleteCharAt()`?

`StringBuilder` is reused.

Example:

```text
sb = "AB"

TAKE C
 ↓
"ABC"
 ↓
return
 ↓
remove C
 ↓
"AB"
```

Now the SKIP branch can correctly work with `"AB"`.

## Recursion Tree

For `"ABC"`:

```text
                    ""
                 /      \
              A           ""
            /   \        /   \
          AB     A      B     ""
         / \    / \    / \    / \
      ABC  AB  AC  A  BC  B  C   ""
```

There are:

```text
2^3 = 8
```

subsets.

## Important Difference From K112

K113 does **not** use a loop.

At each character:

```text
TAKE
SKIP
```

Therefore:

```text
2 recursive calls
```

## Memory Pattern

```text
CHAR → TAKE → RECURSE → UNDO → SKIP → RECURSE
```

---

# K114 — Letter Case Permutation

## Pattern

The current character decides how many choices exist.

```text
letter → UPPERCASE / lowercase
digit  → only digit
```

## Small Algorithm

```text
if complete:
    save string
    return

if current character is a letter:
    choose uppercase
    recurse
    undo

    choose lowercase
    recurse
    undo

else:
    keep digit
    recurse
    undo
```

## Core Code Shape

```java
if (Character.isLetter(s.charAt(idx))) {

    sb.append(Character.toUpperCase(s.charAt(idx)));
    solve(...);
    sb.deleteCharAt(sb.length() - 1);

    sb.append(Character.toLowerCase(s.charAt(idx)));
    solve(...);
    sb.deleteCharAt(sb.length() - 1);

} else {

    sb.append(s.charAt(idx));
    solve(...);
    sb.deleteCharAt(sb.length() - 1);
}
```

## Important Idea

Letters create branching.

Digits do not.

For:

```text
a1b
```

the tree is:

```text
        a1b
       /   \
     A1b   a1b
```

There are two letter choices for `a`, while `1` stays unchanged.

## Why Backtracking Is Still Required

After:

```text
A
```

is explored, remove it before trying:

```text
a
```

Pattern:

```text
UPPER → RECURSE → UNDO
LOWER → RECURSE → UNDO
```

## Memory Pattern

```text
LETTER → UPPER/LOWER
DIGIT  → SAME
```

---

# K115 — Phone Keypad Combinations

## Pattern

At every digit, choose **one character from that digit's letter group**.

```text
digit
 ↓
letters for digit
 ↓
choose one
 ↓
recurse
 ↓
undo
```

## Small Algorithm

```text
if all digits processed:
    save current string
    return

get letters mapped to current digit

for every letter:
    append letter
    recurse to next digit
    remove letter
```

## Core Code Shape

```java
int currDigIdx = digits.charAt(idx) - '0';
String currStrAtDig = lettersStr[currDigIdx];

for (int i = 0; i < currStrAtDig.length(); i++) {

    sb.append(currStrAtDig.charAt(i));

    solve(digits, lettersStr, ans, sb, idx + 1);

    sb.deleteCharAt(sb.length() - 1);
}
```

## Why `digits.charAt(idx) - '0'`?

It converts the character digit into its numeric index.

Example:

```text
'2' - '0' = 2
```

So:

```text
lettersStr[2] → "abc"
```

## Tiny Example

```text
digits = "23"

2 → abc
3 → def
```

Start with `2`:

```text
a
 ├── ad
 ├── ae
 └── af

b
 ├── bd
 ├── be
 └── bf

c
 ├── cd
 ├── ce
 └── cf
```

Total:

```text
3 × 3 = 9
```

## Why the Loop Is Important

Unlike K113:

```text
K113 → fixed 2 choices: TAKE / SKIP
```

K115:

```text
current digit → variable number of choices
```

The loop represents all letters available for that digit.

## Memory Pattern

```text
DIGIT → GET LETTERS → LOOP CHOICE → RECURSE → UNDO
```

---

# K111–K115 Pattern Map

```text
K111
TAKE / SKIP
    ↓
K113
TAKE / SKIP on characters
    ↓
K114
conditional 2 choices
    ↓
K115
loop through all available choices
```

The main thing to recognize:

```text
TWO EXPLICIT CHOICES
        ↓
two recursive calls

MANY CHOICES
        ↓
loop + one recursive call
```

---
