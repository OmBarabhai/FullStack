# L — Parentheses / Expression / Partition
## Part 1 — K121–K124

> **Core pattern**
>
> ```text
> STATE → LEGAL CHOICES → CHOOSE → RECURSE → UNDO
> ```
>
> The goal is to recognize the pattern and rebuild the solution.

---

# K121 — Generate Parentheses

## Pattern

```text
Constraint Backtracking
```

At each position, we may try:

```text
(
)
```

but the rules decide whether each choice is legal.

---

## State

```text
sb          = current string
openCount   = number of '(' used
closeCount  = number of ')' used
n           = required number of pairs
```

---

## Rules

### Add `(`

```text
openCount < n
```

We still have opening brackets available.

### Add `)`

```text
closeCount < openCount
```

There must be an unmatched `(` to close.

Example:

```text
"(()"

open = 2
close = 1

close < open
1 < 2 → TRUE
```

So `)` is allowed.

But:

```text
"())"

open = 1
close = 2
```

cannot continue because:

```text
2 < 1 → FALSE
```

That invalid branch is never generated.

---

## Base Case

```java
if (closeCount == n) {
    ans.add(sb.toString());
    return;
}
```

All required pairs are complete.

---

## Code Shape

```java
if (openCount < n) {
    sb.append('(');
    solve(...);
    sb.deleteCharAt(sb.length() - 1);
}

if (closeCount < openCount) {
    sb.append(')');
    solve(...);
    sb.deleteCharAt(sb.length() - 1);
}
```

Memory:

```text
CHECK
→ CHOOSE
→ RECURSE
→ UNDO
```

---

# K121 — Recursion Tree (`n = 2`)

```text
                         ""
                    open=0 close=0
                          |
                         "("
                    open=1 close=0
                       /      \
                     "(("      "()"
                 o=2,c=0     o=1,c=1
                     |           |
                   "(()"       "()("
                 o=2,c=1     o=2,c=1
                     |           |
                   "(())"      "()()"
                 o=2,c=2     o=2,c=2
```

Answers:

```text
(())
()()
```

Notice:

```text
")" never appears at the root
```

because:

```text
closeCount < openCount
0 < 0 → false
```

---

# K121 — Important Backtracking Flow

This is the key sequence:

```text
sb = "("
   ↓
choose '('
   ↓
"(("
   ↓
recurse
   ↓
child finishes
   ↓
return
   ↓
undo '('
   ↓
"("
   ↓
parent tries ')'
   ↓
"()"
```

### Important distinction

```text
RETURN
→ goes back to the parent call

UNDO
→ actually changes StringBuilder

NEXT CHOICE
→ parent continues with another branch
```

So:

```text
"(("
→ delete last '('
→ "("
```

It never becomes:

```text
")("
```

The `)` comes from the **next branch**:

```java
sb.append(')');
```

---

# K121 — Why `StringBuilder` Needs Undo

`StringBuilder` is mutable and shared.

Example:

```text
"("
 ↓ add '('
"(("
 ↓ recurse
return
 ↓ undo
"("
```

Without:

```java
sb.deleteCharAt(sb.length() - 1);
```

the next branch would inherit the previous branch's character.

### Rule

```text
Whatever mutable state you change before recursion,
restore after recursion.
```

---

# K121 — Why Counters Do NOT Need Undo

For:

```java
int openCount
int closeCount
```

the recursive call receives values.

Example:

```text
Parent:
openCount = 1

Child:
openCount + 1 = 2
```

When the child returns:

```text
Parent still has openCount = 1
```

So we do not need:

```java
openCount--;
closeCount--;
```

Memory:

```text
int
→ child gets a value

StringBuilder
→ same mutable object
→ explicit undo
```

---

# K121 — Why `()` Can Become `()()`

After:

```text
()
```

we have:

```text
open = 1
close = 1
```

We can still add `(` because:

```text
open < n
```

So:

```text
()
 ↓
()(
 ↓
()()
```

The second `)` closes the second `(`.

---

# K121 — Recognition

When the problem says:

```text
Generate all balanced / valid parentheses
```

think:

```text
STATE
→ open / close counts

CHOICES
→ '(' / ')'

CONSTRAINTS
→ open < n
→ close < open

BASE
→ close == n

BACKTRACK
→ append → recurse → delete
```

---

# K122 — Balanced Parentheses

## Pattern

```text
Same constraint-backtracking pattern as K121
```

The important difference is the meaning of `n`.

### K121 / K123

```text
n = number of pairs
```

Example:

```text
n = 3
→ 3 '(' + 3 ')'
→ total length 6
```

### K122

Your supplied version treats:

```text
n = total length
```

So:

```text
n = 6
→ 3 '(' + 3 ')'
```

---

## K122 Counter Scaling

Your version uses:

```java
openCount + 2
closeCount + 2
```

So the counters are scaled by `2`.

For:

```text
n = 6
```

three actual opening brackets give:

```text
openCount = 6
```

and three closing brackets give:

```text
closeCount = 6
```

Therefore completion is checked with:

```text
closeCount == n
```

The validity rule is still:

```text
closeCount < openCount
```

because both counters use the same scale.

---

## K121 vs K122

| | K121 / K123 | K122 |
|---|---|---|
| `n` means | number of pairs | total length |
| Core recursion | same | same |
| Closing rule | `close < open` | `close < open` |
| Backtracking | same | same |

### Memory

```text
K121/K123
→ n = pairs

K122
→ n = total length

CORE
→ same recursion
```

---

# K123 — Reinforcement

K123 should reinforce the same parenthesis pattern.

Revise:

```text
STATE
→ sb, open, close

CHOICES
→ '(' / ')'

RULES
→ open < required
→ close < open

BASE
→ required amount completed

BACKTRACK
→ append → recurse → delete
```

Think:

```text
K121 = learn
K122 = same pattern + different n meaning
K123 = reinforce
```

Do not build a completely new mental algorithm unless the actual problem/code introduces a new rule.

---

# K124 — Brace Expansion

## Pattern

```text
Parsing
+
Choice Generation
+
Backtracking
```

The input itself tells us where choices exist.

Example:

```text
a{b,c}d
```

There are:

```text
normal character → one choice
{b,c}            → two choices
```

---

## State

```text
idx = current input position
str = original string
sb  = current answer
res = completed answers
```

---

## Base Case

```java
if (idx >= str.length()) {
    res.add(sb.toString());
    return;
}
```

Meaning:

```text
whole input processed
→ save current answer
```

---

# K124 — Normal Character

For:

```text
abc
↑
idx
```

there is only one choice.

```java
sb.append(str.charAt(idx));

solve(idx + 1, str, sb, res);

sb.deleteCharAt(sb.length() - 1);
```

Memory:

```text
NORMAL CHAR
→ APPEND
→ RECURSE(idx + 1)
→ UNDO
```

---

# K124 — Brace Group

Suppose:

```text
a{b,c}d
  ↑
 idx
```

When `idx` points to `{`, the whole group must be handled together.

First find its closing `}`.

---

## Why `end++`?

```java
int end = idx + 1;

while (str.charAt(end) != '}') {
    end++;
}
```

Example:

```text
a{b,c}d
  ↑   ↑
 idx  }
```

The scan moves:

```text
b
↓
,
↓
c
↓
}
```

So:

```text
end = position of closing '}'
```

Memory:

```text
end = move forward until the group ends
```

---

# K124 — Why `choices = idx + 1`

The opening brace is at:

```text
idx
```

We do not want `{` to become a choice.

So:

```java
int choices = idx + 1;
```

starts at the first character inside the group.

---

# K124 — Why `choices < end`

`end` points to:

```text
}
```

The closing brace is not a choice.

Therefore:

```java
choices < end
```

processes only:

```text
inside the braces
```

For:

```text
{a,b}
```

the loop sees:

```text
a
,
b
```

but not:

```text
}
```

---

# K124 — Why `choices`, Not `idx`

They have different jobs.

```text
idx
→ where the recursive processing currently is

choices
→ which candidate inside the current group is being tested
```

Example:

```text
a{a,b}a
  ↑ ↑
 idx choices
```

At one point:

```text
idx = 1
choices = 2
```

So:

```text
idx
→ {

choices
→ a
```

The loop must move `choices`, not `idx`.

---

# K124 — Why Ignore `,`

The comma is only a separator.

```text
{a,b,c}
```

means:

```text
a
b
c
```

not:

```text
a
,
b
,
c
```

So:

```java
if (str.charAt(choices) != ',')
```

skips the separator.

---

# K124 — Why `solve(end + 1, ...)`

This is the most important index transition.

Suppose:

```text
a{b,c}d
```

and:

```text
end = position of '}'
```

After choosing `b` or `c`, the **whole `{b,c}` group is already processed**.

Therefore the next unprocessed character is:

```text
end + 1
```

So:

```java
solve(end + 1, str, sb, res);
```

means:

```text
continue after the entire brace group
```

---

# K124 — Why NOT `idx + 1`

`idx + 1` points to the first character **inside** the group.

But the loop is already handling those choices.

Using `idx + 1` again would process the same group a second time.

Therefore:

```text
NORMAL CHARACTER
→ idx + 1

WHOLE BRACE GROUP
→ end + 1
```

### General Rule

```text
Next index = first unprocessed input position
```

---

# K124 — Recursion Tree

For:

```text
a{b,c}d
```

```text
             a{b,c}d
                 |
                 a
                 |
               {b,c}
               /   \
              b     c
              |     |
              d     d
              |     |
             abd   acd
```

---

# K124 — Backtracking

First branch:

```text
choose b
→ sb = "ab"
→ recurse
→ "abd"
→ save
→ undo
→ "a"
```

Then:

```text
choose c
→ sb = "ac"
→ recurse
→ "acd"
→ save
→ undo
```

Memory:

```text
CHOOSE
→ RECURSE
→ UNDO
→ NEXT CHOICE
```

---

# K124 — Recognition

When a problem says:

```text
Generate all strings by choosing one option
from each group
```

think:

```text
FIND CURRENT GROUP
→ FIND ITS CHOICES
→ CHOOSE ONE
→ RECURSE AFTER GROUP
→ UNDO
→ NEXT CHOICE
```

This same pattern can appear in:

```text
brace expansion
phone keypad
character alternatives
template generation
```

---

# K121 vs K124

| | K121 | K124 |
|---|---|---|
| Choices | `(` / `)` | input-defined group choices |
| Main control | constraints | parsing |
| State | `open, close, sb` | `idx, sb` |
| Base | all pairs complete | input complete |
| Recursion | next bracket state | next input position |
| Undo | StringBuilder | StringBuilder |

### Shared pattern

```text
CHOOSE
→ RECURSE
→ UNDO
```

### Main difference

```text
K121:
"Can I legally add this bracket?"

K124:
"What choices does this input group contain?"
```

---

# Explicit Branches vs Loop

This is important for recognizing new problems.

## Explicit branches

Use when there are a few known choices:

```java
if (condition1) {
    choose1();
    solve(...);
    undo1();
}

if (condition2) {
    choose2();
    solve(...);
    undo2();
}
```

K121:

```text
(
)
```

---

## Loop over choices

Use when choices come from input:

```java
for (each choice) {
    choose;
    solve;
    undo;
}
```

K124:

```text
{a,b,c}
```

### Memory

```text
few known choices
→ explicit branches

many/input-defined choices
→ loop
```

---

# Do Not Memorize `idx + 1`

A common recursion habit is:

```text
"just use idx + 1"
```

Do not do that automatically.

Ask:

```text
What does idx represent?

What exactly did I just consume?

Where is the FIRST UNPROCESSED position?
```

Examples:

```text
normal character
→ consume one character
→ idx + 1

brace group
→ consume entire group
→ end + 1
```

---

# K121–K124 Pattern Recognition Checklist

Before coding:

```text
1. What is my STATE?

2. What are my CHOICES?

3. Which choices are LEGAL?

4. What is the BASE CASE?

5. What does one recursive call represent?

6. What input has been consumed?

7. Where is the FIRST UNPROCESSED position?

8. What changes before recursion?

9. What must be UNDONE?

10. Is the next choice represented by:
    another branch?
    or a loop?

11. Am I generating, counting, or checking?
```

---

# One-Page Memory

```text
K121
BALANCED PARENTHESES

OPEN  → open < n
CLOSE → close < open
BASE  → close == n

APPEND
→ RECURSE
→ DELETE
```

```text
K122
SAME PARENTHESIS PATTERN
BUT:
n = total length
```

```text
K123
REINFORCE SAME PARENTHESIS PATTERN
```

```text
K124
NORMAL CHAR
→ idx + 1

BRACE GROUP
→ find }
→ choices = idx + 1
→ choices < end
→ ignore ','
→ recurse(end + 1)
→ undo
```

---

# Final Mental Model

```text
STATE
 ↓
AVAILABLE CHOICES
 ↓
IS CHOICE LEGAL?
 ↓
CHOOSE
 ↓
RECURSE
 ↓
RETURN
 ↓
UNDO
 ↓
NEXT CHOICE
```

> **Backtracking = explore one legal choice completely, restore the previous state, then let the parent explore the next legal choice.**
