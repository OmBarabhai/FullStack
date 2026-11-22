# L — Parentheses / Expression / Partition
## Part 6 — L139: Count Valid Parenthesizations
### Final Recursion Foundation Before Advanced Backtracking

> **This is the final Part 6 for the L section.**
>
> Problem 140 is intentionally not included because you decided to skip it for now.
>
> ```text
> COUNT VALID STRUCTURES
> → STATE
> → VALID CHOICES
> → RECURSE
> → RETURN COUNT
> ```
>
> The main purpose of this problem is to strengthen:
>
> ```text
> state definition
> +
> base cases
> +
> valid/invalid state
> +
> counting recursion
> +
> return-value meaning
> +
> USED vs REMAINING
> ```
>
> These are important foundations before moving into more advanced backtracking and later DP.

---

# 1. Problem

Given a length `n`, count the number of valid balanced-parentheses strings of length `n`.

Example:

```text
n = 2

()
```

Answer:

```text
1
```

Example:

```text
n = 4

(())
()()
```

Answer:

```text
2
```

---

# 2. First Observation — Odd `n`

A balanced parenthesis string must contain:

```text
same number of '(' and ')'
```

Therefore:

```text
n must be even
```

So:

```text
n is odd
→ impossible
→ return 0
```

Example:

```text
n = 3
→ 0
```

Memory:

```text
ODD LENGTH
→ 0
```

---

# 3. The Real Recursive State

The most important thing is deciding what the parameters mean.

A clean remaining-count state is:

```text
open
→ number of '(' still available

close
→ number of ')' still available
```

Example:

```text
n = 4

open = 2
close = 2
```

The initial state is:

```text
(2,2)
```

### Recursive meaning

```text
count(open, close)
```

means:

> "How many valid parenthesis strings can still be completed using this remaining state?"

That sentence is your recursive contract.

---

# 4. Do Not Mix USED and REMAINING

This problem becomes confusing very quickly when you switch meanings.

## Remaining-count version

```text
open
→ '(' still available

close
→ ')' still available
```

Then:

```text
open > 0
→ may place '('

close > open
→ may place ')'
```

## Used-count version

You could instead track:

```text
openUsed
closeUsed
```

Then:

```text
openUsed < n/2
→ may place '('

closeUsed < openUsed
→ may place ')'
```

These are both valid models.

But:

```text
DO NOT MIX THEM
```

For this revision sheet we use:

```text
REMAINING COUNTS
```

---

# 5. Why `close > open` Allows `)`

Suppose:

```text
open  = 1
close = 2
```

This means:

```text
one '(' remains
two ')' remain
```

If we place:

```text
')'
```

then:

```text
open  = 1
close = 1
```

The remaining counts are still possible.

So:

```text
close > open
→ one ')' can safely be used
```

But if:

```text
open = 2
close = 1
```

then:

```text
close > open
→ false
```

We cannot place `)` yet because there are too many opens still waiting to be closed.

Memory:

```text
REMAINING VERSION
→ ')' is allowed only when close > open
```

---

# 6. Why `)` Cannot Be the First Character

Initial:

```text
open = 2
close = 2
```

Check:

```text
close > open
2 > 2
→ false
```

So:

```text
')' is not allowed
```

Only:

```text
'('
```

can be chosen.

This guarantees the prefix never becomes invalid.

---

# 7. The Two Recursive Choices

At every valid state:

```text
CHOICE 1
→ '('

CHOICE 2
→ ')'
```

But:

```text
'('
→ only if open > 0

')'
→ only if close > open
```

So the recursion is:

```text
                     STATE
                    /     \
                 '('       ')'
                  |          |
             open - 1     close - 1
                  |          |
               recurse     recurse
```

---

# 8. Base Case — Complete Valid Path

If:

```text
open == 0
close == 0
```

then:

```text
all required brackets have been used
```

The path represents:

```text
ONE complete valid parenthesization
```

Therefore:

```text
return 1
```

This is a counting-recursion rule:

```text
ONE VALID COMPLETE PATH
→ 1
```

---

# 9. Invalid State

With the remaining-count interpretation, an invalid state is:

```text
close < open
```

because there are not enough closing brackets available to close all remaining opening brackets.

So:

```text
invalid
→ 0
```

The general counting rule:

```text
VALID COMPLETE
→ 1

INVALID
→ 0
```

---

# 10. Why We Add the Branch Counts

Suppose:

```text
count(open, close)
```

has two legal branches.

Then:

```text
ways with '('
+
ways with ')'
```

are separate sets of valid strings.

Therefore:

```java
ans =
    count(open - 1, close)
    +
    count(open, close - 1);
```

Memory:

```text
COUNT
→ SUM VALID BRANCHES
```

---

# 11. Recursion Tree — `n = 4`

Start:

```text
open = 2
close = 2
```

The valid prefix structure is:

```text
                         ""
                          |
                         "("
                    /           \
                  "(("           "()"
                  /                |
               "((("             "()("
                 |                  |
               "(())"             "()()"
```

Leaves:

```text
(())
()()
```

Therefore:

```text
2 valid paths
```

---

# 12. Tree With State

```text
                         ("", open=2, close=2)
                                      |
                                     "("
                                      |
                         ( "(", open=1, close=2 )
                             /                 \
                           "("                 ")"
                            |                   |
              ("((", open=0, close=2)   ("()", open=1, close=1)
                       |                     |
                     "("                   "("
                       |                     |
              ("(((", open=-1, close=2)   ("()(", open=0, close=1)
                 INVALID                     /       \
                                           "("         ")"
                                            |           |
                                         invalid     ("()()",0,0)
                                                       |
                                                     RETURN 1
```

The negative-looking state is exactly why the clean implementation checks:

```text
open > 0
```

before creating the `'('` branch.

So an invalid branch is:

```text
NOT CREATED
```

rather than recursed into with:

```text
open = -1
```

---

# 13. Clean Recursive Template

```java
static int count(int open, int close) {

    // Complete valid construction.
    if (open == 0 && close == 0) {
        return 1;
    }

    // Invalid remaining state.
    if (close < open) {
        return 0;
    }

    int ans = 0;

    // Choose '(' if any remain.
    if (open > 0) {
        ans += count(open - 1, close);
    }

    // Choose ')' only if it is safe.
    if (close > open) {
        ans += count(open, close - 1);
    }

    return ans;
}
```

Initial call:

```java
if ((n & 1) == 1) {
    return 0;
}

return count(n / 2, n / 2);
```

---

# 14. Why This Is Better Than Memorizing Conditions

Do not memorize:

```text
if (close > open)
```

as a random rule.

Derive it:

```text
close = number of ')' remaining
open  = number of '(' remaining
```

Then ask:

```text
Can I safely consume a ')'
right now?
```

Answer:

```text
Only if there are MORE closing brackets remaining
than opening brackets remaining.
```

Therefore:

```text
close > open
```

This is the state meaning → rule derivation.

That is what you want to strengthen in recursion.

---

# 15. Your Current Code — What Was Actually Confusing

Your current code uses:

```java
if (n == 0) {
    return 0;
}

if (n == 2) {
    return 1;
}

if (openCount > n) {
    return 1;
}

if (closeCount > openCount) {
    return 1;
}
```

The main problem is not syntax.

The problem is that these conditions do not clearly correspond to the recursive contract.

For example:

```text
return 1
```

means:

```text
ONE VALID COMPLETION
```

So every `return 1` should have a clear semantic reason.

Likewise:

```text
invalid
→ 0
```

not:

```text
invalid
→ 1
```

The stronger rule is:

```text
DEFINE STATE
→ DEFINE COMPLETE
→ DEFINE INVALID
→ THEN WRITE RECURSION
```

---

# 16. Important Variable Ownership

In this problem:

```text
open
→ remaining '('

close
→ remaining ')'

ans
→ total count from this state
```

At one recursive call:

```text
count(open, close)
```

the `ans` belongs to:

```text ALL valid completions from THIS state
```

not:

```text one branch
```

This is the same kind of distinction you learned in Boolean Parenthesization:

```text
CURRENT BRANCH RESULT
vs
WHOLE STATE RESULT
```

---

# 17. Compare With Boolean Parenthesization

This is an important connection.

### Boolean Parenthesization

```text
state = (st, en, needTrue)

choices = operators

return = count
```

### Valid Parentheses

```text
state = (open, close)

choices = '(' / ')'

return = count
```

Both use:

```text
COUNTING RECURSION
```

Both follow:

```text
state
→ valid choices
→ recursive counts
→ sum
```

Different state.

Same counting foundation.

---

# 18. Generate vs Count

This distinction should now be automatic.

### Generate

```text
choose
→ recurse
→ undo
→ store complete path
```

### Count

```text
choose
→ recurse
→ returned number
→ add numbers
```

Same recursion tree.

Different result strategy.

---

# 19. Why This Is Useful Before Advanced Backtracking

This problem trains you to separate:

```text
PATH
```

from:

```text
RETURN VALUE
```

In backtracking:

```text
path
→ what we built
```

In counting recursion:

```text
return value
→ how many solutions exist below this state
```

That distinction becomes very important in:

```text
DP
memoization
counting problems
```

---

# 20. From Recursion to Memoization

Suppose:

```text
count(open, close)
```

is called from multiple branches with the same state.

Example:

```text
count(1,2)
```

may be reached more than once.

The answer is always the same because:

```text
same state
→ same number of remaining choices
→ same number of valid completions
```

Therefore:

```text
same state
→ same answer
```

This is exactly the condition that makes memoization useful.

---

# 21. Memoization Shape

The state has two variables:

```text
open
close
```

Therefore:

```text
memo[open][close]
```

can store the result.

Conceptually:

```text
count(open, close)
        ↓
memo already known?
      /      \
    YES      NO
     |        |
  return    calculate
  memo         |
              store
               |
             return
```

This is a small example of the larger DP principle:

```text
STATE
→ REPEATED SUBPROBLEM
→ CACHE
```

---

# 22. Why This State Is Different From DP Interval State

Boolean Parenthesization:

```text
(st, en, needTrue)
```

Valid Parentheses:

```text
(open, close)
```

The important lesson:

```text
DP state is not always index-based.
```

The correct DP state is:

> The minimum information needed to completely describe the remaining subproblem.

This is one of the most important ideas to carry into DP.

---

# 23. Recognition Pattern

When you see:

```text
COUNT
+
VALID SEQUENCES
+
TWO COUNTERS / RESOURCE COUNTS
```

ask:

```text
What does each counter mean?

What choices reduce the counters?

What state is invalid?

What state means complete?

Can two different branches reach the same counter state?
```

If yes:

```text
COUNTING RECURSION
→ POSSIBLE MEMOIZATION
```

---

# 24. Complexity Awareness

Pure recursion explores a large branching tree.

At each step there may be:

```text
'('
')'
```

choices, subject to validity.

So the search is exponential in the naive view.

The important lesson is not a single memorized Big-O number.

It is:

```text
MANY RECURSIVE STATES
+
REPEATED STATES
→ MEMOIZATION CAN HELP
```

The number of valid outputs itself also grows rapidly.

---

# 25. Final Rebuild Test

Before looking at code, explain these in your own words:

```text
1. Why must odd n return 0?

2. What exactly do open and close mean?

3. Am I tracking USED or REMAINING?

4. Why can '(' be chosen only when open > 0?

5. Why can ')' be chosen only when close > open
   in the remaining-count model?

6. Why does open == 0 && close == 0 return 1?

7. Why does an invalid state return 0?

8. Why do we ADD the branch counts?

9. What does one recursive call represent?

10. Can the same (open, close) state occur again?

11. If yes, what optimization naturally follows?
```

---

# 26. Final Memory Card

```text
COUNT VALID PARENTHESES

INPUT
→ total length n

FIRST
→ odd n = 0

STATE
→ open / close REMAINING

CHOICES
→ '(' or ')'

'(' allowed
→ open > 0

')' allowed
→ close > open

BASE
→ open == 0 && close == 0
→ return 1

INVALID
→ return 0

COMBINE
→ add branch counts

REPEATED STATE
→ memoization opportunity
```

### One-line algorithm

```text
STATE → VALID OPEN/CLOSE CHOICES → RECURSE → SUM COUNTS
```

---

# 27. L-Folder Recursion Map

```text
Generate paths
      ↓
Take / Not-Take
      ↓
Choice Generation
      ↓
Advanced Backtracking
      ↓
String Partition
      ↓
Expression Divide & Conquer
      ↓
Interval / Boolean Counting
      ↓
Count Valid Structures
      ↓
MEMOIZATION / DP
```

The important transition is:

```text
"I can write recursion"
        ↓
"I understand exactly what the state means"
        ↓
"I know what the child returns"
        ↓
"I can identify repeated states"
        ↓
"I can convert recursion to DP"
```

---

# 28. Final Rule Before Moving to Advanced Backtracking

For every new recursion problem, force yourself to write these four lines first:

```text
STATE  = ?

CHOICES = ?

BASE = ?

RETURN = ?
```

Then write:

```text
What changes after each choice?
```

Then:

```text
Can the same state appear again?
```

If you can answer those without AI, your recursion foundation is becoming strong enough for the next stage.
