# L — Parentheses / Expression / Partition
## Part 4 — Problems 136–137
### Expression Evaluation by Recursion + Different Ways to Add Parentheses

> **Both problems look similar.**
>
> The recursion structure is related, but the **question asked by the problem is different**.
>
> ```text
> L136
> → ONE correct result
>
> L137
> → ALL possible results
> ```
>
> Shared divide-and-conquer idea:
>
> ```text
> FIND / CHOOSE SPLIT
> → SOLVE LEFT
> → SOLVE RIGHT
> → COMBINE
> ```
>
> But L136 uses **precedence + associativity** to choose the correct split, while L137 explores **every operator as a possible split**.

---

# PART 1 — L136
# Expression Evaluation by Recursion

## 1. Pattern

```text
Recursive Divide & Conquer
+
Expression Evaluation
+
ONE RESULT
```

This is **not traditional backtracking**.

There is no:

```text
append
→ recurse
→ undo
```

Instead:

```text
FIND CORRECT SPLIT
→ RECURSE LEFT
→ RECURSE RIGHT
→ COMBINE
→ RETURN ONE RESULT
```

The supplied L136 material classifies it exactly this way: recursive divide-and-conquer evaluation returning one result. fileciteturn46file1L1023-L1088

---

# 2. What Does `solve(arr, st, en)` Mean?

This is the most important idea.

```text
solve(arr, st, en)
```

means:

> Evaluate the expression represented by `arr[st...en]` and return its **one correct value**.

Example:

```text
solve(arr, 2, 4)
```

means:

```text
"I promise to return the correct value
of the expression from index 2 to index 4."
```

The parent does not calculate the child's expression itself.

It trusts:

```text
solve(left)
→ correct left value

solve(right)
→ correct right value
```

This is **recursive faith**.

---

# 3. State

```text
arr
→ original token array

st
→ start of current expression range

en
→ end of current expression range
```

The important property:

```text
child gets a SMALLER range
```

Example:

```text
0 ........ 8
```

after splitting:

```text
0 .. split-1
```

and:

```text
split+1 .. 8
```

---

# 4. Problem Example

Input:

```text
["100", "+", "200", "/", "2", "*", "5", "+", "7"]
```

Expression:

```text
100 + 200 / 2 * 5 + 7
```

Precedence:

```text
^
↓
* /
↓
+ -
```

Associativity:

```text
^   → right-to-left
* / → left-to-right
+ - → left-to-right
```

Expected result:

```text
607
```

---

# 5. The Most Important Insight — Why the Split Looks "Backwards"

Normal calculation says:

```text
HIGHER precedence first
```

But the recursion tree chooses the **outer operation**.

For:

```text
10 + 20 * 3
```

correct grouping is:

```text
10 + (20 * 3)
```

Tree:

```text
        +
       / \
     10   *
         / \
        20  3
```

Therefore:

```text
+ = outer/root operation
* = inner operation
```

So for recursive splitting:

```text
LOWER precedence
→ OUTER split

HIGHER precedence
→ DEEPER recursive work
```

This distinction is central.

---

# 6. Precedence Rule

```text
^
↓
* /
↓
+ -
```

When searching for the split:

```text
First look for + / -
If none:
    look for * /
If none:
    look for ^
```

Why?

Because the lowest-precedence operation is the operation performed last at the outer level.

---

# 7. Associativity Controls Which Occurrence We Choose

This is where the exact position of the operator matters.

## `+` and `-`

They are left-associative.

Example:

```text
10 - 5 - 2
```

means:

```text
(10 - 5) - 2
```

Therefore choose the:

```text
RIGHTMOST + / -
```

Tree:

```text
        -
       / \
    10-5  2
```

So:

```text
+ -
→ RIGHTMOST
```

---

## `*` and `/`

Also left-associative.

Example:

```text
20 / 5 * 2
```

means:

```text
(20 / 5) * 2
```

Therefore:

```text
* /
→ RIGHTMOST
```

No `break` while searching.

```java
for (int i = st; i < en; i++) {
    if (arr[i].equals("*") || arr[i].equals("/")) {
        splitIdxPos = i;
    }
}
```

The last matching position wins.

---

## `^`

Right-associative.

Example:

```text
2 ^ 3 ^ 2
```

means:

```text
2 ^ (3 ^ 2)
```

Therefore:

```text
^
→ LEFTMOST
```

Here `break` is intentional:

```java
for (int i = st; i < en; i++) {
    if (arr[i].equals("^")) {
        splitIdxPos = i;
        break;
    }
}
```

---

# 8. Rule Table

| Operator | Precedence | Associativity | Recursive Split |
|---|---|---|---|
| `+` | Low | Left → Right | Rightmost |
| `-` | Low | Left → Right | Rightmost |
| `*` | Medium | Left → Right | Rightmost |
| `/` | Medium | Left → Right | Rightmost |
| `^` | High | Right → Left | Leftmost |

### Permanent memory

```text
LEFT ASSOCIATIVE
→ RIGHTMOST SPLIT

RIGHT ASSOCIATIVE
→ LEFTMOST SPLIT
```

---

# 9. Why `break` Caused a Problem for `+`

Example:

```text
100 + 200 / 2 * 5 + 7
```

Two `+` operators:

```text
100 + 200 / 2 * 5 + 7
    ↑                 ↑
  first            rightmost
```

Because `+` is left-associative, the outermost operation is the **last** `+`.

If you do:

```java
if (...) {
    splitIdxPos = i;
    break;
}
```

you keep the first `+`.

That creates the wrong outer structure.

Correct:

```text
keep scanning
→ remember the latest +/-
```

This was an important debugging point in your L136 learning. fileciteturn46file1L1473-L1525

---

# 10. Split Process

Start with:

```java
int splitIdxPos = -1;
```

Meaning:

```text
no split found yet
```

Find the correct operator.

Suppose:

```text
splitIdxPos = 3
```

Then:

```text
LEFT
→ st ... splitIdxPos - 1

RIGHT
→ splitIdxPos + 1 ... en
```

Recursive calls:

```java
long leftVal =
    solve(arr, st, splitIdxPos - 1);

long rightVal =
    solve(arr, splitIdxPos + 1, en);
```

---

# 11. Base Case

If:

```java
if (st == en)
```

there is only one token.

Because valid input alternates:

```text
number operator number operator number
```

one remaining token must be a number.

So:

```java
return Long.parseLong(arr[st]);
```

Memory:

```text
ONE TOKEN
→ NUMBER
→ RETURN NUMBER
```

---

# 12. `Long.parseLong()` vs `char - '0'`

For:

```text
"100"
```

use:

```java
Long.parseLong("100")
```

because it is a `String`.

Do not use:

```java
arr[st] - '0'
```

because:

```text
arr[st]
→ String
```

not:

```text
char
```

The distinction:

```text
char → ch - '0'

String → parseInt / parseLong
```

---

# 13. Combine

After:

```text
leftVal
rightVal
```

use the selected operator.

```text
+
→ leftVal + rightVal

-
→ leftVal - rightVal

*
→ leftVal * rightVal

/
→ division

^
→ power(leftVal, rightVal)
```

The result is:

```text
ONE value
```

and is returned to the parent.

---

# 14. L136 Recursion Tree

For:

```text
10 + 20 * 3
```

the correct tree is:

```text
              +
             / \
           10   *
               / \
             20   3
```

Execution:

```text
solve(whole)
       |
       | choose outer +
       |
   solve(10) → 10
       |
   solve(20*3)
       |
       | choose *
       |
   solve(20) → 20
   solve(3)  → 3
       |
     20 * 3
       ↓
      60
       |
   10 + 60
       ↓
      70
```

Final:

```text
70
```

---

# 15. L136 — One Result vs Many Results

This is the key distinction from L137.

```text
L136
ONE expression
→ ONE correct result
```

Example:

```text
10 + 20 * 3
→ 70
```

The recursive function returns:

```java
long
```

or another numeric type.

---

# 16. L136 — No Backtracking

There is no:

```java
StringBuilder
add
remove
```

No:

```text
used[]
```

No:

```text
choose → undo
```

Instead:

```text
FIND CORRECT SPLIT
→ LEFT
→ RIGHT
→ COMBINE
→ RETURN
```

So classify it as:

```text
RECURSIVE DIVIDE & CONQUER
```

---

# 17. L136 — Complexity Lesson

Your L136 attempt reached:

```text
1110 / 1115
→ TLE
```

This is important because the algorithm was logically close, but the implementation repeatedly scanned recursive ranges.

Conceptually:

```text
solve(whole)
→ scan whole range

solve(left)
→ scan left range

solve(smaller)
→ scan again
```

So a major new recursion skill is:

```text
Correct recursion
+
Complexity awareness
```

Before submitting, ask:

```text
How many recursive calls?

How much does each call scan?

Am I repeating the same work?

What happens at maximum input?
```

---

# 18. Power Recursion Used by L136

For `^`, the recursive power pattern is:

```text
power(base, exponent)
```

Efficient recursion:

```java
long power(long n, long x) {

    if (x == 0) {
        return 1;
    }

    long half = power(n, x / 2);

    if ((x & 1) == 0) {
        return half * half;
    }

    return n * half * half;
}
```

Pattern:

```text
POWER
→ halve exponent
→ solve smaller exponent
→ reuse result
```

Complexity:

```text
O(log exponent)
```

Important:

```text
(x & 1)
```

checks the **exponent**, not the base.

This is called:

```text
Exponentiation by Squaring
```

---

# PART 2 — L137
# Different Ways to Add Parentheses

## 19. Pattern

L137 has a very similar recursion shape, but the question is completely different.

```text
Recursive Divide & Conquer
+
ALL POSSIBLE RESULTS
```

Core:

```text
CHOOSE EVERY OPERATOR AS A SPLIT
→ SOLVE LEFT
→ SOLVE RIGHT
→ COMBINE EVERY RESULT
→ RETURN LIST
```

---

# 20. What Is the Recursive Contract?

```java
diffWaysToCompute(expression)
```

means:

```text
"Return ALL possible results
this expression can produce."
```

Example:

```text
2-1-1
```

Possible groupings:

```text
(2-1)-1
= 0

2-(1-1)
= 2
```

So:

```text
[0, 2]
```

The function returns:

```java
List<Integer>
```

not one number.

---

# 21. What Are We Actually Choosing?

We are choosing:

```text
AN OPERATOR
```

Example:

```text
2*3-4
  ↑   ↑
  *   -
```

Every operator can become the final operation.

So every operator gives a possible split.

---

# 22. Split Example

Choose `*`:

```text
2 | 3-4
```

Then:

```text
LEFT  = "2"
RIGHT = "3-4"
```

Recursive calls:

```text
solve("2")
solve("3-4")
```

Now choose `-`:

```text
2*3 | 4
```

Then:

```text
LEFT  = "2*3"
RIGHT = "4"
```

So:

```text
EVERY OPERATOR
→ POSSIBLE SPLIT
```

---

# 23. Why L137 Does Not Use Precedence to Pick One Split

L137 is not asking:

```text
"What is the normal value of this expression?"
```

It asks:

```text
"What are ALL values if parentheses are inserted in different ways?"
```

Therefore:

```text
EVERY OPERATOR
→ MUST BE EXPLORED
```

This is the biggest difference from L136.

---

# 24. L137 Recursion Tree — `2-1-1`

```text
                         2-1-1
                       /       \
                 split #1     split #2
                    at -        at -
                   /              \
                  /                \
                2 | 1-1          2-1 | 1
                  |                  |
            solve(1-1)          solve(2-1)
                / \                / \
               1   1              2   1
                \ /                \ /
                 0                  1

                 ↓                  ↓
              2 - 0              1 - 1
                 ↓                  ↓
                 2                  0
```

Final:

```text
[2, 0]
```

Order can vary.

---

# 25. Base Case — L137

Eventually there is:

```text
NO OPERATOR
```

Example:

```text
"25"
```

Nothing remains to split.

So:

```java
if (ans.isEmpty()) {
    ans.add(Integer.parseInt(expression));
}
```

Memory:

```text
NO OPERATOR
→ NUMBER
→ LIST WITH ONE RESULT
```

Important difference from L136:

```text
L136:
"25" → 25

L137:
"25" → [25]
```

---

# 26. Combining Results — The Central L137 Idea

Suppose:

```text
leftAns = [2, 5]
rightAns = [3, 4]
```

We need every pair:

```text
2 with 3
2 with 4
5 with 3
5 with 4
```

Therefore:

```java
for (int leftVal : leftAns) {
    for (int rightVal : rightAns) {
        ...
    }
}
```

This is the Cartesian product:

```text
LEFT RESULTS × RIGHT RESULTS
```

---

# 27. Applying the Operator

If:

```text
ch == '+'
```

then:

```java
ans.add(leftVal + rightVal);
```

If:

```text
ch == '-'
```

then:

```java
ans.add(leftVal - rightVal);
```

If:

```text
ch == '*'
```

then:

```java
ans.add(leftVal * rightVal);
```

Each pair creates one possible result.

---

# 28. Why the Nested Loops Matter

Suppose:

```text
LEFT can produce:
[2, 5]

RIGHT can produce:
[3, 4]
```

If you only did:

```text
2 with 3
5 with 4
```

you would miss:

```text
2 with 4
5 with 3
```

Therefore:

```text
EVERY LEFT RESULT
×
EVERY RIGHT RESULT
```

is mandatory.

---

# 29. L137 Code Skeleton

```java
solve(expression) {

    ans = empty list;

    for (every operator) {

        left = expression before operator;
        right = expression after operator;

        leftAns = solve(left);
        rightAns = solve(right);

        for (every left result) {
            for (every right result) {

                combine using operator;

                add result;
            }
        }
    }

    if (no operator) {
        ans.add(number);
    }

    return ans;
}
```

This skeleton is more important than memorizing the full code.

---

# 30. L137 Code

```java
class Solution {

    public List<Integer> diffWaysToCompute(String expression) {

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                String left =
                    expression.substring(0, i);

                String right =
                    expression.substring(i + 1);

                List<Integer> leftAns =
                    diffWaysToCompute(left);

                List<Integer> rightAns =
                    diffWaysToCompute(right);

                for (int leftVal : leftAns) {

                    for (int rightVal : rightAns) {

                        if (ch == '+') {
                            ans.add(leftVal + rightVal);

                        } else if (ch == '-') {
                            ans.add(leftVal - rightVal);

                        } else {
                            ans.add(leftVal * rightVal);
                        }
                    }
                }
            }
        }

        if (ans.isEmpty()) {
            ans.add(Integer.parseInt(expression));
        }

        return ans;
    }
}
```

---

# 31. Why There Is No Undo in L137

L137 does not maintain a mutable path.

It does not do:

```text
append
→ recurse
→ delete
```

Instead:

```text
solve(left)
→ returns results

solve(right)
→ returns results

combine
→ creates new results
```

So:

```text
L137
→ returned-result divide & conquer
```

not:

```text
traditional backtracking
```

---

# 32. L136 vs L137 — The Most Important Table

| | L136 | L137 |
|---|---|---|
| Question | Evaluate expression correctly | Find all possible results |
| Pattern | Divide & Conquer | Divide & Conquer |
| Split | Correct split only | Every operator |
| Precedence | Important | Not used to eliminate splits |
| Associativity | Important | Not used to eliminate splits |
| Return | One value | `List<Integer>` |
| Base | One number | One number → list |
| Left recursion | One value | Many values |
| Right recursion | One value | Many values |
| Combine | One operation | Every left × every right |
| Undo | None | None |

### The one line to memorize

```text
L136 → ONE RESULT
L137 → ALL RESULTS
```

---

# 33. The Two Trees Are Different

## L136

```text
             solve(whole)
                   |
             choose CORRECT
                outer split
                   |
              /           \
         solve(left)   solve(right)
             |             |
          ONE value      ONE value
               \          /
                 COMBINE
                    |
              ONE RESULT
```

## L137

```text
             solve(whole)
              /    |    \
             /     |     \
         split1  split2  split3
           |       |       |
        left/right for EVERY split
           |       |       |
       many values ...
             \    |    /
          COMBINE ALL
               |
          MANY RESULTS
```

---

# 34. The Biggest Conceptual Difference

### L136

You know:

```text
which grouping is correct
```

because:

```text
precedence
+
associativity
```

tell you the outer operation.

Therefore:

```text
choose ONE correct split
```

### L137

The problem intentionally asks:

```text
what if we parenthesize in every possible way?
```

Therefore:

```text
explore ALL splits
```

This is the real reason the two algorithms differ.

---

# 35. Merge Sort Connection

Both problems resemble Merge Sort because of:

```text
SPLIT
→ RECURSE
→ COMBINE
```

But neither is Merge Sort.

### Merge Sort

```text
split around middle
→ sort left
→ sort right
→ merge arrays
```

### L136

```text
split at correct expression operator
→ evaluate left
→ evaluate right
→ arithmetic combine
```

### L137

```text
split at every operator
→ compute all left results
→ compute all right results
→ combine every pair
```

So the correct classification is:

```text
L136
→ Recursive Divide & Conquer Evaluation

L137
→ Recursive Divide & Conquer Enumeration
```

---

# 36. L136 Pattern Recognition

When a new problem says:

```text
Evaluate an expression
+
operators have precedence
+
need ONE correct answer
```

think:

```text
RECURSIVE EXPRESSION EVALUATION
```

Ask:

```text
1. What is the range/state?
2. What is the base case?
3. What is the outermost operation?
4. What precedence applies?
5. What associativity applies?
6. Which occurrence is the split?
7. What do left/right return?
8. How are they combined?
```

---

# 37. L137 Pattern Recognition

When a new problem says:

```text
Expression
+
different parenthesizations
+
ALL possible results
```

think:

```text
EVERY OPERATOR
→ SPLIT
→ SOLVE LEFT/RIGHT
→ COMBINE ALL RESULTS
```

Ask:

```text
1. What are the possible split points?
2. What does solve(left) return?
3. What does solve(right) return?
4. How do all result pairs combine?
5. What is the no-operator base case?
```

---

# 38. Common Confusions to Avoid

## Confusion 1 — "Operator always means split"

For L137:

```text
YES
→ every operator is a possible split
```

For L136:

```text
NO
→ only the correct outer operator becomes the split
```

---

## Confusion 2 — "Higher precedence should be the root"

For L136:

```text
NO
```

The higher-precedence operation is deeper.

Example:

```text
10 + (20 * 3)

       +
      / \
    10   *
```

So:

```text
LOWER precedence
→ OUTER split
```

---

## Confusion 3 — "Left/right are numbers"

Not necessarily.

Example:

```text
3 + 2 * 4
```

At `+`:

```text
left = "3"
right = "2*4"
```

At `*`:

```text
left = "3+2"
right = "4"
```

They are:

```text
SUBEXPRESSIONS
```

---

## Confusion 4 — `String` vs `char`

```text
char
→ ==

String
→ .equals()
```

Example:

```java
char ch = '+';

ch == '+'
```

but:

```java
String token = "+";

token.equals("+")
```

For L136 token arrays:

```java
arr[i].equals("+")
```

---

## Confusion 5 — `parseLong` vs `char - '0'`

```text
"100"
→ Long.parseLong("100")
```

while:

```text
'7'
→ '7' - '0'
```

Different data types.

---

## Confusion 6 — Returning a list vs a number

L136:

```text
solve(...)
→ long
```

L137:

```text
solve(...)
→ List<Integer>
```

Before writing recursion, always ask:

```text
WHAT DOES THE CHILD RETURN?
```

---

# 39. Rebuild Test — L136

Without looking at code, explain:

```text
10 + 20 * 3
```

You should be able to say:

```text
+ is the outer operation.

Why?
Because + has lower precedence.

solve(10)
→ 10

solve(20*3)
→ 60

10 + 60
→ 70
```

Then:

```text
10 - 5 - 2
```

You should say:

```text
- is left-associative
→ choose rightmost -
→ (10-5) - 2
```

And:

```text
2 ^ 3 ^ 2
```

should become:

```text
^ is right-associative
→ choose leftmost ^
→ 2 ^ (3^2)
```

---

# 40. Rebuild Test — L137

Without looking at code, explain:

```text
2-1-1
```

You should say:

```text
Try first -
→ 2 | 1-1
→ solve left
→ solve right
→ combine
→ result 2

Try second -
→ 2-1 | 1
→ solve left
→ solve right
→ combine
→ result 0

Return [2,0]
```

---

# 41. Performance Awareness

L137 can generate many results.

L136 can repeatedly rescan ranges.

So before moving to more advanced recursion, develop this habit:

```text
LOGIC CORRECT?
AND
HOW MUCH WORK IS REPEATED?
```

Ask:

```text
How many recursive calls?

How many splits?

How many results?

How many times do I scan the same expression?

Can the same subproblem appear again?

Would memoization help?
```

This is the next level after simply making recursion work.

---

# 42. Your Main Learning Points From 136–137

The important areas to strengthen are:

```text
1. Recursive contract
2. One result vs many results
3. Split selection
4. Precedence vs recursion-root position
5. Associativity
6. Rightmost vs leftmost
7. Left/right are subexpressions
8. Base case based on "nothing left to split"
9. Return types
10. String vs char
11. Combining recursive results
12. Cartesian product of results
13. Difference between divide-and-conquer and backtracking
14. Complexity / repeated work
```

These are more important than memorizing two implementations.

---

# 43. Universal Expression Recursion Map

```text
                EXPRESSION
                    |
          ┌─────────┴─────────┐
          |                   |
       L136                  L137
          |                   |
   ONE correct result    ALL possible results
          |                   |
    choose correct       every operator
        split              can split
          |                   |
    solve LEFT            solve LEFT
          |                   |
   solve RIGHT            solve RIGHT
          |                   |
      combine             combine ALL
          |                   |
    ONE result            MANY results
```

---

# 44. Final Memory Cards

## L136

```text
TYPE
→ Recursive Divide & Conquer

GOAL
→ ONE correct result

STATE
→ arr, st, en

BASE
→ st == en
→ parse number

SPLIT
→ choose correct outer operator

+ -
→ rightmost

* /
→ rightmost

^
→ leftmost

RECURSE
→ left range
→ right range

COMBINE
→ left op right

RETURN
→ ONE value
```

### One line

```text
CORRECT SPLIT → LEFT/RIGHT → COMBINE → ONE RESULT
```

---

## L137

```text
TYPE
→ Recursive Divide & Conquer

GOAL
→ ALL possible results

STATE
→ expression string

BASE
→ no operator
→ parse number into list

SPLIT
→ EVERY operator

RECURSE
→ solve LEFT
→ solve RIGHT

COMBINE
→ every left result
  × every right result

RETURN
→ LIST OF RESULTS

UNDO
→ NONE
```

### One line

```text
EVERY SPLIT → LEFT/RIGHT → COMBINE ALL → MANY RESULTS
```

---

# 45. Final Recognition Rule

When you see an expression recursion problem, first ask:

```text
"Am I supposed to find ONE correct evaluation,
or ALL possible evaluations?"
```

If:

```text
ONE
→ L136-style

ALL
→ L137-style
```

Then ask:

```text
Is this about NORMAL expression evaluation?
→ precedence + associativity matter

Is this about ALL parenthesizations?
→ every operator is explored
```

That single classification prevents you from mixing the two patterns.

---

# 46. Final Mental Model

```text
L136

DEFINE solve()
→ one correct answer

FIND correct outer split
→ solve LEFT
→ solve RIGHT
→ combine
→ return ONE


L137

DEFINE solve()
→ all possible answers

TRY EVERY operator as split
→ solve LEFT
→ solve RIGHT
→ combine EVERY pair
→ return ALL
```

### Shared foundation

```text
SPLIT
→ RECURSE
→ COMBINE
```

### Critical difference

```text
L136
→ SELECT ONE CORRECT SPLIT

L137
→ EXPLORE EVERY POSSIBLE SPLIT
```
