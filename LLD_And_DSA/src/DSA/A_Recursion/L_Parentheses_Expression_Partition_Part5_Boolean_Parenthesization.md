# L — Parentheses / Expression / Partition
## Part 5 — Boolean Parenthesization
### Interval / Partition Recursion → Memoization → Interval DP

> **Core pattern**
>
> ```text
> INTERVAL
> → TRY EVERY OPERATOR AS SPLIT
> → SOLVE LEFT TRUE/FALSE
> → SOLVE RIGHT TRUE/FALSE
> → COMBINE USING TRUTH TABLE
> → ACCUMULATE
> → MEMOIZE REPEATED STATES
> ```
>
> This is **not ordinary take/not-take backtracking**.
>
> The important state is:
>
> ```text
> (st, en, needTrue)
> ```

---

# 1. Problem

Given:

```text
T → True
F → False
```

and:

```text
& → AND
| → OR
^ → XOR
```

count the number of ways to parenthesize the expression so that the final result is:

```text
TRUE
```

Example:

```text
T|T&F^T
→ 4
```

The constraint can be as large as:

```text
|s| ≤ 100
```

so pure recursion is useful for learning the recurrence, but repeated states make memoization necessary for a robust solution.

---

# 2. Pattern Recognition

Look for:

```text
EXPRESSION / INTERVAL
+
PARTITION / SPLIT
+
LEFT SUBPROBLEM
+
RIGHT SUBPROBLEM
+
COUNT
```

Think:

```text
INTERVAL PARTITION
```

Because the same interval can appear again:

```text
INTERVAL PARTITION
→ OVERLAPPING SUBPROBLEMS
→ MEMOIZATION
→ INTERVAL DP
```

---

# 3. Core Idea

For:

```text
T | T & F ^ T
```

every operator can be the final split:

```text
T | T & F ^ T
  ↑

T | T & F ^ T
      ↑

T | T & F ^ T
          ↑
```

Each split creates:

```text
LEFT | OPERATOR | RIGHT
```

Then:

```text
solve(left)
solve(right)
```

and combine their possibilities.

---

# 4. Recursive Contract

This is the first thing to understand.

```java
solve(s, st, en, needTrue)
```

means:

> Count how many ways the expression from `st` to `en` can evaluate to the result requested by `needTrue`.

So:

```text
needTrue = true
→ count TRUE ways

needTrue = false
→ count FALSE ways
```

The complete recursive state is:

```text
(st, en, needTrue)
```

---

# 5. State Variables

```text
s
→ complete expression

st
→ START of current interval

en
→ END of current interval

i
→ operator / split position

needTrue
→ result required by current interval

leftTrue
→ ways LEFT becomes TRUE

leftFalse
→ ways LEFT becomes FALSE

rightTrue
→ ways RIGHT becomes TRUE

rightFalse
→ ways RIGHT becomes FALSE

trueWays
→ ways CURRENT split produces TRUE

falseWays
→ ways CURRENT split produces FALSE

ans
→ total contribution of ALL splits
```

The important distinction is:

```text
trueWays / falseWays
→ ONE SPLIT

ans
→ ALL SPLITS
```

This distinction is exactly where your current code is going wrong.

---

# 6. Base Case

When:

```java
st == en
```

there is only one operand.

If:

```text
s[st] = T
```

then:

```text
T → TRUE  = 1
T → FALSE = 0
```

If:

```text
s[st] = F
```

then:

```text
F → TRUE  = 0
F → FALSE = 1
```

Code:

```java
if (st == en) {

    if (needTrue) {
        return s.charAt(st) == 'T' ? 1 : 0;
    }

    return s.charAt(st) == 'F' ? 1 : 0;
}
```

Memory:

```text
ONE OPERAND
→ check T/F
→ return 1 or 0
```

---

# 7. Operator Positions

The expression always looks like:

```text
operand operator operand operator operand
```

Therefore if `st` points to an operand:

```text
st + 1 → operator
st + 2 → operand
st + 3 → operator
```

So:

```java
for (int i = st + 1; i < en; i += 2)
```

means:

```text
jump directly from operator to operator
```

---

# 8. Split

At:

```text
i
```

the expression is:

```text
LEFT | s[i] | RIGHT
```

Therefore:

```text
LEFT
→ st ... i-1

RIGHT
→ i+1 ... en
```

Memory:

```text
LEFT | OPERATOR | RIGHT
```

---

# 9. Four Possible Boolean States

For every split:

```text
LEFT
→ TRUE / FALSE

RIGHT
→ TRUE / FALSE
```

So there are four combinations:

```text
T / T
T / F
F / T
F / F
```

First calculate:

```java
int leftTrue = solve(..., true);
int leftFalse = solve(..., false);

int rightTrue = solve(..., true);
int rightFalse = solve(..., false);
```

Then use the operator truth table.

---

# 10. Why Counts Are Multiplied

Suppose:

```text
leftTrue = 3
rightFalse = 2
```

Then:

```text
3 × 2 = 6
```

Why?

Because:

```text
every one of the 3 left solutions
can pair with
every one of the 2 right solutions
```

So:

```text
leftCount × rightCount
```

means:

```text
number of LEFT/RIGHT combinations
```

This is the same Cartesian-product idea used in L137.

---

# 11. AND

Truth table:

```text
T & T = T
T & F = F
F & T = F
F & F = F
```

Therefore:

```java
trueWays =
    leftTrue * rightTrue;
```

and:

```java
falseWays =
      leftTrue * rightFalse
    + leftFalse * rightTrue
    + leftFalse * rightFalse;
```

---

# 12. OR

Truth table:

```text
T | T = T
T | F = T
F | T = T
F | F = F
```

Therefore:

```java
trueWays =
      leftTrue * rightTrue
    + leftTrue * rightFalse
    + leftFalse * rightTrue;
```

and:

```java
falseWays =
    leftFalse * rightFalse;
```

---

# 13. XOR

Truth table:

```text
T ^ T = F
T ^ F = T
F ^ T = T
F ^ F = F
```

Therefore:

```java
trueWays =
      leftTrue * rightFalse
    + leftFalse * rightTrue;
```

and:

```java
falseWays =
      leftTrue * rightTrue
    + leftFalse * rightFalse;
```

---

# 14. Derive Formulas Instead of Memorizing Them

For every operator:

```text
1. Write truth table.

2. Mark rows producing TRUE.

3. Mark rows producing FALSE.

4. Convert each row into:
   leftCount × rightCount

5. Add the valid rows.
```

Example:

```text
XOR TRUE:
T/F
F/T
```

becomes:

```text
leftTrue * rightFalse
+
leftFalse * rightTrue
```

This is the safest way to reconstruct the formulas.

---

# 15. The Most Important Counting Distinction

There are TWO levels of counting.

## Level 1 — Current Split

For one operator:

```text
trueWays
falseWays
```

means:

```text
How many ways does THIS split produce T/F?
```

## Level 2 — Entire Interval

Across every operator:

```text
ans
```

means:

```text
How many ways does the ENTIRE interval produce the requested result?
```

Therefore:

```text
trueWays / falseWays
→ per split

ans
→ all splits
```

---

# 16. Why Your Current Code Returns `8` Instead of `3`

This is the exact conceptual bug in the code you practiced.

You have:

```java
int trueWays = 0;
int falseWays = 0;

for (...) {

    ...

    if (&) {
        trueWays = ...;
        falseWays = ...;
    } else if (...) {
        trueWays = ...;
        falseWays = ...;
    }
}
```

Notice:

```text
trueWays
falseWays
```

are **OVERWRITTEN** on every split.

Then after the loop you do:

```java
int ans = trueWays + falseWays;
```

That does NOT mean:

```text
sum of all split contributions
```

It means:

```text
TRUE + FALSE contribution
of only the LAST split processed
```

That is the key reason the result is wrong.

---

# 17. The Correct Accumulation Structure

You need:

```java
int ans = 0;

for (...) {

    int trueWays = 0;
    int falseWays = 0;

    // calculate for THIS split

    if (needTrue) {
        ans += trueWays;
    } else {
        ans += falseWays;
    }
}

return ans;
```

The ownership is:

```text
ans
→ outside loop
→ survives every split

trueWays
→ inside loop
→ belongs to current split

falseWays
→ inside loop
→ belongs to current split
```

### Memory

```text
ONE SPLIT
→ trueWays / falseWays

ALL SPLITS
→ ans += ...
```

---

# 18. Why `ans = trueWays + falseWays` Is Wrong

Suppose three splits produce:

```text
split 1:
trueWays = 2
falseWays = 5

split 2:
trueWays = 1
falseWays = 3

split 3:
trueWays = 4
falseWays = 2
```

For:

```text
needTrue = true
```

the answer must be:

```text
2 + 1 + 4
= 7
```

Your pattern:

```text
ans = trueWays + falseWays
```

after the loop would use only split 3:

```text
4 + 2
= 6
```

Wrong.

You need:

```text
answer requested by needTrue
+
from EVERY split
```

---

# 19. Where `needTrue` Belongs

`needTrue` decides what gets added to `ans`.

```java
if (needTrue) {
    ans += trueWays;
} else {
    ans += falseWays;
}
```

So:

```text
needTrue
→ chooses which CURRENT split count contributes

ans
→ accumulates that choice across ALL splits
```

This is why `needTrue` cannot simply be ignored at the end.

---

# 20. Correct Pure Recursive Code

```java
class Solution {

    static int solve(
            String s,
            int st,
            int en,
            boolean needTrue) {

        // Base case.
        if (st == en) {

            if (needTrue) {
                return s.charAt(st) == 'T' ? 1 : 0;
            }

            return s.charAt(st) == 'F' ? 1 : 0;
        }

        // Total answer for ALL splits.
        int ans = 0;

        for (int i = st + 1; i < en; i += 2) {

            // Results of the LEFT interval.
            int leftTrue =
                solve(s, st, i - 1, true);

            int leftFalse =
                solve(s, st, i - 1, false);

            // Results of the RIGHT interval.
            int rightTrue =
                solve(s, i + 1, en, true);

            int rightFalse =
                solve(s, i + 1, en, false);

            // Results for THIS split only.
            int trueWays = 0;
            int falseWays = 0;

            if (s.charAt(i) == '&') {

                trueWays =
                    leftTrue * rightTrue;

                falseWays =
                      leftTrue * rightFalse
                    + leftFalse * rightTrue
                    + leftFalse * rightFalse;

            } else if (s.charAt(i) == '|') {

                trueWays =
                      leftTrue * rightTrue
                    + leftTrue * rightFalse
                    + leftFalse * rightTrue;

                falseWays =
                    leftFalse * rightFalse;

            } else { // '^'

                trueWays =
                      leftTrue * rightFalse
                    + leftFalse * rightTrue;

                falseWays =
                      leftTrue * rightTrue
                    + leftFalse * rightFalse;
            }

            // Add THIS split's requested result
            // to the answer of the ENTIRE interval.
            if (needTrue) {
                ans += trueWays;
            } else {
                ans += falseWays;
            }
        }

        return ans;
    }

    static int countWays(String s) {
        return solve(
            s,
            0,
            s.length() - 1,
            true
        );
    }
}
```

---

# 21. One-Split vs Whole-Interval Flow

This distinction should be visible in your head.

```text
solve(st, en, needTrue)
        |
        | ans = 0
        |
        +---- split 1
        |       |
        |   trueWays / falseWays
        |       |
        |   ans += requested
        |
        +---- split 2
        |       |
        |   trueWays / falseWays
        |       |
        |   ans += requested
        |
        +---- split 3
                |
            trueWays / falseWays
                |
            ans += requested

        ↓
    return ans
```

So:

```text
trueWays
falseWays
```

are temporary.

```text
ans
```

is cumulative.

---

# 22. Recursion Tree — `T^F|F`

Use:

```text
T ^ F | F
```

Operators:

```text
^
|
```

Root can split at either one.

```text
                         T^F|F
                       /       \
                    split ^    split |
                      /           \
                   T | F|F      T^F | F
                     |             |
                 solve(F|F)     solve(T^F)
```

### First split

```text
T | F|F
```

Left:

```text
T
```

Right:

```text
F|F
```

`F|F` can only be FALSE.

So:

```text
T | FALSE
= TRUE
```

### Second split

```text
T^F | F
```

Left:

```text
T^F
= TRUE
```

Right:

```text
F
= FALSE
```

So:

```text
TRUE ^ FALSE
= TRUE
```

Therefore:

```text
answer = 2
```

This matches the example.

---

# 23. Why the Recursion Tree Is Not a Normal Backtracking Tree

Earlier problems:

```text
Generate Parentheses
Restore IP
```

use:

```text
CHOOSE
→ MODIFY PATH
→ RECURSE
→ UNDO
```

Here:

```text
SPLIT INTERVAL
→ SOLVE LEFT
→ SOLVE RIGHT
→ COMBINE COUNTS
```

No:

```text
StringBuilder
append/remove
used[]
```

The child returns information.

---

# 24. Why TLE Happens

Pure recursion can repeatedly calculate:

```text
solve(st, en, needTrue)
```

for the same:

```text
st
en
needTrue
```

Example:

```text
solve(0,2,true)
```

can appear from multiple parent splits.

Same state:

```text
same interval
+
same required result
```

therefore same answer.

But pure recursion recalculates it.

This causes:

```text
overlapping subproblems
→ huge repeated work
→ TLE
```

---

# 25. Memoization State

Exactly the same recursive state becomes the memo key:

```text
(st, en, needTrue)
```

Conceptually:

```text
memo[st][en][0]
→ FALSE count

memo[st][en][1]
→ TRUE count
```

Flow:

```text
solve(state)
     ↓
memo already contains it?
   /       \
 YES       NO
  |         |
return    calculate
stored       ↓
value      store
            ↓
          return
```

---

# 26. Why This Becomes Interval DP

We already have:

```text
STATE
→ (st, en, needTrue)

CHOICES
→ every operator

LEFT
→ smaller interval

RIGHT
→ smaller interval

COMBINATION
→ truth table

OVERLAP
→ same states repeat
```

Therefore:

```text
Pure Recursion
      ↓
Memoization
      ↓
Top-Down DP
      ↓
Interval DP
```

This is the main bridge from recursion into dynamic programming.

---

# 27. L137 Connection

L137:

```text
EVERY OPERATOR
→ split
→ solve LEFT
→ solve RIGHT
→ combine EVERY RESULT
```

Boolean Parenthesization:

```text
EVERY OPERATOR
→ split
→ solve LEFT T/F
→ solve RIGHT T/F
→ combine using truth table
→ COUNT
```

Same family:

```text
INTERVAL PARTITION
```

Different returned information:

```text
L137
→ many numeric values

Boolean
→ two counts: TRUE / FALSE
```

---

# 28. L136 / L137 / Boolean Comparison

| Problem | Goal | Split |
|---|---|---|
| L136 | one correct expression value | correct split using precedence/associativity |
| L137 | all possible numeric values | every operator |
| Boolean Parenthesization | count TRUE/FALSE ways | every operator |

Memory:

```text
L136
→ ONE

L137
→ MANY

Boolean
→ COUNT T/F
```

---

# 29. Important Weakness — Do Not Mix `ans` Levels

This is the most important revision point from today's attempt.

Think:

```text
CURRENT SPLIT
→ trueWays
→ falseWays
```

Then:

```text
CURRENT INTERVAL
→ ans += requestedWays
```

So:

```text
trueWays / falseWays
→ temporary

ans
→ accumulator
```

If you put `ans` logic outside the loop incorrectly:

```text
trueWays + falseWays
```

you lose the contribution from earlier splits.

---

# 30. Important Weakness — Do Not Use `needTrue` as a Boolean Formula

`needTrue` does NOT change the truth table.

The truth table always calculates:

```text
trueWays
falseWays
```

Then:

```text
needTrue
```

only selects:

```text
which one contributes to ans
```

So the order is:

```text
1. Calculate left T/F
2. Calculate right T/F
3. Calculate current split T/F
4. Check needTrue
5. Add requested count to ans
```

---

# 31. Important Weakness — `trueWays` and `falseWays` Reset Per Split

Correct:

```java
for (...) {

    int trueWays = 0;
    int falseWays = 0;

    ...
}
```

Why?

Because they describe:

```text
THIS OPERATOR SPLIT
```

not the entire interval.

Meanwhile:

```java
int ans = 0;
```

must be outside the loop because it describes:

```text
ALL OPERATOR SPLITS
```

This variable ownership is extremely important.

---

# 32. Derive the Code on Paper

Before coding, write:

```text
solve(st,en,needTrue)

BASE:
st == en

TOTAL:
ans = 0

FOR EVERY OPERATOR:

    left T/F
    right T/F

    current split T/F

    if needTrue:
        ans += trueWays
    else:
        ans += falseWays

RETURN ans
```

Then fill the truth-table formulas.

This prevents the exact bug you just hit.

---

# 33. Rebuild Test

Before looking at code, explain:

### Why is `ans` outside the loop?

```text
Because every split contributes.
```

### Why are `trueWays/falseWays` inside?

```text
Because they describe one split.
```

### Why do we calculate both?

```text
Because a parent may need TRUE or FALSE.
```

### Why multiply counts?

```text
Every valid left arrangement pairs
with every valid right arrangement.
```

### Why memoize?

```text
Same (st,en,needTrue) repeats.
```

---

# 34. Clean Mental Model

```text
                    INTERVAL
                       |
                TRY EVERY OPERATOR
                       |
                +------+------+
                |             |
              LEFT          RIGHT
             T / F          T / F
                |             |
                +------ + ----+
                       |
                 TRUTH TABLE
                       |
                 T-WAYS / F-WAYS
                       |
                   needTrue?
                    /      \
                  YES      NO
                   |        |
              +trueWays  +falseWays
                    \      /
                      ans
                       |
                NEXT OPERATOR
                       |
                    return
```

---

# 35. Final Memory Card

```text
BOOLEAN PARENTHESIZATION

PATTERN
→ Interval / Partition Recursion

STATE
→ (st, en, needTrue)

BASE
→ st == en

CHOICE
→ every operator

LEFT
→ st ... i-1

RIGHT
→ i+1 ... en

LEFT/RIGHT STATE
→ TRUE + FALSE counts

CURRENT SPLIT
→ trueWays / falseWays

ALL SPLITS
→ ans

COUNTING
→ leftWays × rightWays

TRUTH TABLE
→ derive operator formulas

ACCUMULATION
→ ans += requestedWays

WHY TLE?
→ repeated (st,en,needTrue)

FIX
→ memoization

DP
→ Interval DP
```

### One-line algorithm

```text
INTERVAL
→ SPLIT
→ LEFT/RIGHT T/F
→ TRUTH TABLE
→ CURRENT SPLIT COUNT
→ ACCUMULATE
→ MEMOIZE
```

---

# 36. The Single Most Important Correction From Today's Attempt

Remember this exact distinction:

```text
trueWays / falseWays
        ↓
   ONE split only

      ans
        ↓
 ALL splits together
```

Therefore:

```text
❌ ans = trueWays + falseWays

✅ ans += needTrue ? trueWays : falseWays
```

and:

```text
✅ return ans
```

only after the operator loop finishes.

That is the main thing to lock in from this practice session.
