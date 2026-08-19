# L — Parentheses / Expression / Partition
## Part 2 — Problems 125–126
### Expression Add Operators + Restore IP Addresses

> **Shared pattern**
>
> ```text
> CHOOSE NEXT PIECE
> → VALIDATE / UPDATE STATE
> → RECURSE
> → UNDO
> → NEXT CHOICE
> ```
>
> The important difference is the **state**.

---

# L125 — Expression Add Operators

## 1. Pattern

Think of this problem when you see:

```text
DIGIT STRING
+
INSERT OPERATORS
+
GENERATE ALL EXPRESSIONS
+
TARGET / EVALUATION
```

The recursion has two levels of choice:

```text
1. Choose the next NUMBER
2. Choose the OPERATOR
```

```text
DIGIT STRING
      ↓
CHOOSE NEXT NUMBER
      ↓
FIRST NUMBER?
  /          \
YES           NO
 |             |
initialize    + / - / *
state            |
                  ↓
               UPDATE
                  ↓
               RECURSE
                  ↓
                 UNDO
```

---

# 2. State — Do Not Mix These

```text
idx
→ where the NEXT NUMBER starts

choices
→ last digit index of the CURRENT NUMBER

currNum
→ actual numeric value currently being built

curr
→ value of the COMPLETE expression so far

prev
→ signed contribution of the PREVIOUS operand

sb
→ expression being constructed
```

### The critical distinction

```text
idx
→ LOCATION

choices
→ LOCATION

currNum
→ CURRENT VALUE

prev
→ PREVIOUS SIGNED OPERAND

curr
→ WHOLE EXPRESSION VALUE
```

This `idx / choices / currNum / curr / prev` distinction is one of the main things to strengthen for this problem. fileciteturn42file0L120-L175

---

# 3. `idx` vs `choices` vs `currNum`

Example:

```text
digits = "1234"
idx = 0
```

The loop tries:

```text
choices = 0 → "1"
choices = 1 → "12"
choices = 2 → "123"
choices = 3 → "1234"
```

So:

```text
idx
→ WHERE THE NUMBER STARTS

choices
→ WHERE THE NUMBER ENDS

currNum
→ WHAT NUMBER IT ACTUALLY IS
```

Example:

```text
idx = 1
choices = 2
currNum = 23
```

These are three different facts.

### Memory

```text
INDEX ≠ VALUE
```

---

# 4. Building `currNum`

```java
currNum =
    currNum * 10
    + (digits.charAt(choices) - '0');
```

For:

```text
digits = "123"
```

start:

```text
currNum = 0
```

Then:

```text
choices = 0
0 * 10 + 1 = 1

choices = 1
1 * 10 + 2 = 12

choices = 2
12 * 10 + 3 = 123
```

So the loop creates:

```text
1
12
123
```

Memory:

```text
OLD NUMBER × 10 + NEW DIGIT
```

---

# 5. Why the Next Index Is `choices + 1`

Suppose:

```text
digits = "12345"
idx = 0
choices = 2
```

Current number:

```text
"123"
```

Consumed positions:

```text
0 1 2
```

First unused position:

```text
3
```

Therefore:

```java
choices + 1
```

means:

```text
FIRST UNPROCESSED DIGIT
```

General rule:

```text
CURRENT NUMBER
= idx ... choices

NEXT NUMBER START
= choices + 1
```

Do not memorize `+1`.

Ask:

```text
"What was the last position consumed?"
```

Then:

```text
last consumed + 1
```

---

# 6. Leading Zero

Allowed:

```text
0
```

Not allowed:

```text
01
005
0007
```

Condition:

```java
if (choices > idx && digits.charAt(idx) == '0') {
    break;
}
```

For:

```text
digits = "023"
idx = 0
```

First:

```text
choices = 0
0 > 0 → false
```

So:

```text
"0"
```

is allowed.

Next:

```text
choices = 1
1 > 0 → true
```

Candidate becomes:

```text
"02"
```

Invalid.

Longer candidates also begin with zero:

```text
"023"
```

Therefore:

```text
break
```

Memory:

```text
choices == idx
→ one digit
→ "0" allowed

choices > idx
→ multi-digit
→ leading zero
→ STOP
```

---

# 7. First Number Is Special

At:

```text
idx == 0
```

there is no operator before the first number.

If:

```text
currNum = 12
```

initialize:

```text
sb   = "12"
curr = 12
prev = 12
```

Do not create:

```text
+12
-12
*12
```

Memory:

```text
FIRST NUMBER
→ initialize state

LATER NUMBER
→ choose operator
```

---

# 8. `+` Transition

Suppose:

```text
curr = 5
currNum = 2
```

Choose:

```text
+2
```

Then:

```text
newCurr = 5 + 2 = 7
newPrev = 2
```

The new previous contribution is:

```text
+2
```

Memory:

```text
+ → curr + currNum
    prev = +currNum
```

---

# 9. `-` Transition

For:

```text
5 - 2
```

we get:

```text
newCurr = 5 - 2
        = 3
```

But:

```text
newPrev = -2
```

because the operand contributed negatively.

Memory:

```text
- → curr - currNum
    prev = -currNum
```

---

# 10. Multiplication — The Formula You Must Understand

Suppose:

```text
5 + 2
```

Current state:

```text
curr = 7
prev = 2
```

Now choose:

```text
* 3
```

Correct result:

```text
5 + (2 * 3)
= 11
```

Wrong shortcut:

```text
curr * 3
= 21
```

because that would mean:

```text
(5 + 2) * 3
```

---

## Step 1 — Remove old `prev`

`curr` already includes:

```text
+2
```

So:

```text
curr - prev
= 7 - 2
= 5
```

Now only the part before `+2` remains.

---

## Step 2 — Multiply previous operand

```text
prev * currNum
= 2 * 3
= 6
```

---

## Step 3 — Put the new product back

```text
5 + 6
= 11
```

Therefore:

```java
newCurr =
    (curr - prev)
    + (prev * currNum);

newPrev =
    prev * currNum;
```

### Paper memory

```text
WHOLE EXPRESSION
- OLD PREV
+ OLD PREV × NEW NUMBER
```

Or:

```text
*
→ REMOVE
→ MULTIPLY
→ PUT BACK
```

---

# 11. Why `newPrev = prev * currNum`

After:

```text
5 + 2 * 3
```

the newest effective operand is:

```text
2 * 3 = 6
```

So:

```text
prev = 6
```

not:

```text
prev = 3
```

This matters for:

```text
5 + 2 * 3 * 4
```

After:

```text
5 + 2 * 3
```

state:

```text
curr = 11
prev = 6
```

Next `*4`:

```text
(curr - prev) + (prev * 4)

(11 - 6) + (6 * 4)

5 + 24

= 29
```

Correct:

```text
5 + 2*3*4 = 29
```

---

# 12. Signed `prev`

For:

```text
5 - 2 * 3
```

before multiplication:

```text
curr = 3
prev = -2
currNum = 3
```

Formula:

```text
(curr - prev) + (prev * currNum)
```

becomes:

```text
3 - (-2) + (-2 * 3)
```

```text
3 + 2 - 6
= -1
```

Correct:

```text
5 - (2 * 3)
= -1
```

Therefore:

```text
prev
→ SIGNED previous operand contribution
```

not simply:

```text
previous number
```

The supplied practice record shows that signed `prev`, `curr` meaning, and the multiplication replacement formula were the biggest conceptual sticking points. fileciteturn42file0L464-L699

---

# 13. L125 Recursion Tree

Use:

```text
digits = "123"
target = 6
```

First number:

```text
                         ""
                    /     |      \
                   1      12      123
```

Take the `1` branch:

```text
                         "1"
                    /      |      \
                  +2       -2      *2
                   |        |       |
                "1+2"     "1-2"   "1*2"
                / | \      / | \    / | \
              +3 -3 *3  +3 -3 *3 +3 -3 *3
```

The tree means:

```text
LEVEL 1
→ choose next number

LEVEL 2
→ choose operator

LEAF
→ complete expression
```

---

# 14. Backtracking With `setLength()`

This is important because several characters may be appended at once.

Suppose:

```text
sb = "1"
```

Save:

```java
int lenBefore = sb.length();
```

Therefore:

```text
lenBefore = 1
```

Choose:

```text
+23
```

Now:

```text
sb = "1+23"
```

Recursion explores everything below this choice.

When recursion returns:

```java
sb.setLength(lenBefore);
```

means:

```text
keep only the first 1 character
```

So:

```text
"1+23"
   ↓
"1"
```

Now the parent can try:

```text
-23
```

or:

```text
*23
```

### Visual

```text
PARENT
"1"
 |
 | choose "+23"
 ↓
"1+23"
 |
 | recurse
 ↓
deeper branches
 |
 | RETURN
 ↓
setLength(1)
 ↓
"1"
 |
 | next choice
 ↓
"-23"
```

---

# 15. Why `setLength()` Instead of `deleteCharAt()`

If a branch adds:

```text
+123
```

that is multiple characters.

One:

```java
deleteCharAt(...)
```

would remove only:

```text
3
```

and leave:

```text
+12
```

which corrupts the parent state.

`setLength(oldLength)` removes everything that was added after the saved point.

Memory:

```text
ONE CHARACTER
→ deleteCharAt()

MULTIPLE CHARACTERS
→ save length + setLength()
```

This backtracking issue was explicitly present in your practice record. fileciteturn42file0L297-L400

---

# 16. L125 Code Template

```java
long currNum = 0;

for (int choices = idx; choices < digits.length(); choices++) {

    if (choices > idx && digits.charAt(idx) == '0') {
        break;
    }

    currNum =
        currNum * 10
        + (digits.charAt(choices) - '0');

    int lenBefore = sb.length();

    if (idx == 0) {

        sb.append(currNum);

        solve(
            digits, target, res, sb,
            currNum,
            currNum,
            choices + 1
        );

        sb.setLength(lenBefore);

    } else {

        // +
        sb.append('+').append(currNum);

        solve(
            digits, target, res, sb,
            curr + currNum,
            currNum,
            choices + 1
        );

        sb.setLength(lenBefore);

        // -
        sb.append('-').append(currNum);

        solve(
            digits, target, res, sb,
            curr - currNum,
            -currNum,
            choices + 1
        );

        sb.setLength(lenBefore);

        // *
        sb.append('*').append(currNum);

        solve(
            digits, target, res, sb,
            (curr - prev) + (prev * currNum),
            prev * currNum,
            choices + 1
        );

        sb.setLength(lenBefore);
    }
}
```

---

# 17. How to Recognize / Modify L125

### Recognition

```text
digit string
+
insert operators
+
generate all expressions
+
target
```

Then:

```text
CHOOSE NUMBER
→ CHOOSE OPERATOR
→ UPDATE curr/prev
→ RECURSE
→ RESTORE
```

### Variations

Only `+` and `-`:

```text
remove *
→ multiplication-specific state may disappear
```

Different operators:

```text
same recursion skeleton
+
new operator state formula
```

Different precedence:

```text
check whether curr/prev
still contains enough information
```

---

# L126 — Restore Valid IP Addresses

## 18. Pattern

```text
STRING PARTITION
→ TRY 1–3 DIGITS
→ BUILD PART
→ VALIDATE
→ CHOOSE
→ RECURSE
→ UNDO
```

---

# 19. State

```text
idx
→ START of current part

choices
→ END of current part

currPart
→ numeric VALUE of current part

parts
→ NUMBER of IP parts created

sb
→ current IP path
```

Keep these separate:

```text
idx      → position
choices  → position
currPart → value
parts    → count
```

---

# 20. L126 Recursion Tree

Use:

```text
str = "23579"
```

At the root:

```text
                         23579
                        idx=0
                    /     |      \
                   2      23      235
                  / \      |       |
                next     next     next
```

Suppose we choose:

```text
235
```

Then:

```text
idx = 0
choices = 2
parts = 0
```

Positions used:

```text
0 1 2
```

Next unprocessed position:

```text
3
```

So:

```text
next idx = choices + 1 = 3
parts = 1
```

Each recursive level means:

```text
CHOOSE ONE MORE IP PART
```

---

# 21. Why `choices + 1`

Example:

```text
2 3 5 7 9
0 1 2 3 4
```

If:

```text
idx = 0
choices = 2
```

current part:

```text
235
```

last consumed:

```text
2
```

first unused:

```text
3
```

Therefore:

```text
choices + 1
```

means:

```text
FIRST UNPROCESSED POSITION
```

Memory:

```text
CURRENT PART
= idx ... choices

NEXT PART
= choices + 1
```

---

# 22. Why `parts + 1`

Start:

```text
parts = 0
```

After first part:

```text
parts = 1
```

After second:

```text
parts = 2
```

After third:

```text
parts = 3
```

After fourth:

```text
parts = 4
```

Therefore:

```java
parts + 1
```

means:

```text
ONE MORE IP SEGMENT HAS BEEN CREATED
```

---

# 23. Dot Logic — `parts > 0`

```java
if (parts > 0) {
    sb.append('.');
}
```

means:

```text
parts == 0
→ FIRST part
→ no dot

parts > 0
→ later part
→ add dot first
```

Example:

```text
255
.255
.11
.135
```

Final:

```text
255.255.11.135
```

Memory:

```text
DOT GOES BETWEEN PARTS
```

---

# 24. Leading Zero — `choices > idx`

For:

```text
"023"
idx = 0
```

First:

```text
choices = 0
```

```text
0 > 0 → false
```

Therefore:

```text
"0"
```

is allowed.

Next:

```text
choices = 1
```

```text
1 > 0 → true
```

Candidate:

```text
"02"
```

Invalid.

Longer:

```text
"023"
```

is also invalid.

So:

```text
break
```

prunes all longer candidates.

---

# 25. Building `currPart`

```java
currPart =
    currPart * 10
    + (str.charAt(choices) - '0');
```

For:

```text
235
```

```text
0
→ 2
→ 23
→ 235
```

Same pattern as L125:

```text
OLD VALUE × 10 + NEW DIGIT
```

---

# 26. `currPart` vs `choices`

Example:

```text
str = "312"
choices = 2
currPart = 312
```

So:

```java
if (choices > 255)
```

is wrong because:

```text
choices = POSITION
```

but the IP rule is about:

```text
currPart = VALUE
```

Correct:

```java
if (currPart > 255) {
    break;
}
```

Memory:

```text
choices
→ WHERE

currPart
→ WHAT
```

---

# 27. Why `currPart > 255` Can Break

Once:

```text
currPart = 256
```

longer values become:

```text
2560
25600
...
```

They cannot return to `0–255`.

Therefore:

```text
currPart > 255
→ STOP THIS LOOP
```

This is pruning.

---

# 28. Base Case

Valid IP:

```text
all digits consumed
AND
exactly 4 parts created
```

```java
if (idx == str.length() && parts == 4) {
    ans.add(sb.toString());
    return;
}

if (parts == 4) {
    return;
}
```

Mental table:

```text
all digits + 4 parts
→ VALID

all digits + fewer than 4
→ incomplete

4 parts + leftover digits
→ invalid
```

---

# 29. L126 `setLength()` Backtracking

Suppose:

```text
sb = "2"
```

Save:

```java
int lenBefore = sb.length();
```

So:

```text
lenBefore = 1
```

Choose:

```text
35
```

Since:

```text
parts > 0
```

we add:

```text
.35
```

Now:

```text
sb = "2.35"
```

Recursion explores all deeper branches.

When it returns:

```java
sb.setLength(lenBefore);
```

restores:

```text
"2.35"
   ↓
"2"
```

Then the parent can try another part.

### Visual

```text
PARENT
"2"
 |
 | choose ".35"
 ↓
"2.35"
 |
 | recurse
 ↓
deeper branches
 |
 | RETURN
 ↓
setLength(1)
 ↓
"2"
 |
 | next choice
 ↓
".3"
```

Exactly the same principle as L125.

---

# 30. L126 Code Template

```java
int currPart = 0;

for (int choices = idx;
     choices < str.length() && choices < idx + 3;
     choices++) {

    if (choices > idx && str.charAt(idx) == '0') {
        break;
    }

    currPart =
        currPart * 10
        + (str.charAt(choices) - '0');

    if (currPart > 255) {
        break;
    }

    int lenBefore = sb.length();

    if (parts > 0) {
        sb.append('.');
    }

    sb.append(currPart);

    solve(
        str,
        ans,
        sb,
        choices + 1,
        parts + 1
    );

    sb.setLength(lenBefore);
}
```

---

# 31. Mini Dry Run — `"02300"`

Start:

```text
idx = 0
parts = 0
sb = ""
```

First part:

```text
0
```

Now:

```text
sb = "0"
parts = 1
idx = 1
```

Remaining:

```text
2300
```

One valid route:

```text
0
→ 2
→ 30
→ 0
```

Result:

```text
0.2.30.0
```

Another:

```text
0
→ 23
→ 0
→ 0
```

Result:

```text
0.23.0.0
```

Important transitions:

```text
choices + 1
parts + 1
```

---

# 32. L125 vs L126

| | L125 | L126 |
|---|---|---|
| Main job | build expressions | build IP parts |
| Main choice | next number | next part |
| Extra choice | operator | none |
| State | `idx, curr, prev` | `idx, currPart, parts` |
| Validation | expression target | IP rules |
| Special logic | multiplication precedence | leading zero + <=255 + 1–3 digits |
| Backtracking | `setLength()` | `setLength()` |
| Next position | `choices + 1` | `choices + 1` |

Shared:

```text
CHOOSE
→ RECURSE
→ UNDO
```

Different:

```text
STATE
+
VALIDATION
```

---

# 33. The Bigger Pattern

These two problems teach:

```text
STRING
→ CHOOSE NEXT PIECE
→ PROCESS / VALIDATE PIECE
→ RECURSE ON REMAINING INPUT
→ RESTORE
```

L125:

```text
piece = number
+
operator
```

L126:

```text
piece = IP segment
```

The reusable skill is:

```text
Identify what ONE recursive choice consumes.
```

---

# 34. Your Main Weaknesses to Strengthen

The practice record shows the recurring difficult areas were:

```text
1. INDEX vs VALUE
2. idx vs choices
3. curr vs prev
4. signed prev
5. multiplication replacement formula
6. first number special handling
7. StringBuilder backtracking
8. setLength() vs deleteCharAt()
9. correct next index
10. validating the VALUE instead of the POSITION
```

The important correction is not to memorize more code.

Before coding, write:

```text
What does every parameter MEAN?
```

Then:

```text
What does one recursive call CONSUME?
```

Then:

```text
What exactly must I UNDO?
```

This is the main skill to strengthen from this problem. fileciteturn42file0L864-L948

---

# 35. Revision Tests You Should Be Able to Explain

## L125

```text
1. Why is idx an index and not a number?
2. What exactly does choices represent?
3. How does currNum become 1 → 12 → 123?
4. Why is choices + 1 the next index?
5. Why can "0" exist but "01" cannot?
6. Why is the first number special?
7. What does curr represent?
8. What does prev represent?
9. Why is prev signed?
10. Why can't multiplication simply use curr * number?
11. Why do we remove prev from curr?
12. Why is newPrev = prev * number?
13. How does 5 - 2 * 3 become -1?
14. How does setLength(lenBefore) restore the parent string?
15. Why is deleteCharAt() insufficient for "+123"?
```

## L126

```text
1. What exactly does idx represent?
2. What exactly does choices represent?
3. Why is choices + 1 the next idx?
4. Why is parts + 1 necessary?
5. Why is the dot only when parts > 0?
6. Why is "0" valid but "01" invalid?
7. Why does choices > idx detect the extension?
8. Why is currPart checked instead of choices?
9. Why can currPart > 255 break the loop?
10. Why only 1–3 digits?
11. Why exactly 4 parts?
12. How does setLength(lenBefore) restore the IP path?
```

---

# 36. Rebuild Test

Before seeing code, try to reconstruct:

### L125

```text
CHOOSE NUMBER
→ if first: initialize
→ otherwise + / - / *
→ update curr / prev
→ recurse from choices + 1
→ restore sb
```

### L126

```text
TRY 1–3 DIGITS
→ build currPart
→ validate
→ add dot if needed
→ recurse from choices + 1
→ parts + 1
→ restore sb
```

If you can derive these from the problem statement, you are no longer dependent on memorizing the solution.

---

# 37. Final Memory Sheet

```text
L125

idx
→ number START

choices
→ number END

currNum
→ current number

curr
→ whole expression

prev
→ signed previous operand

+ → curr + number
    prev = number

- → curr - number
    prev = -number

* → (curr - prev) + prev*number
    prev = prev*number

NEXT
→ choices + 1

BACKTRACK
→ setLength(oldLength)
```

```text
L126

idx
→ part START

choices
→ part END

currPart
→ part VALUE

parts
→ part COUNT

DOT
→ parts > 0

VALID
→ no leading zero
→ <= 255
→ 1–3 digits

NEXT
→ choices + 1

COUNT
→ parts + 1

BACKTRACK
→ setLength(oldLength)
```

### Shared pattern

```text
CHOOSE
→ VALIDATE / UPDATE
→ RECURSE
→ RETURN
→ UNDO
→ NEXT CHOICE
```
