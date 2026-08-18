# L — Parentheses / Expression / Partition
## Part 2 — L125–L126
### Deep Revision: Pattern + Code Template + Recognition

---

# L125 — Expression Add Operators

## Pattern

```text
DIGIT STRING
→ CHOOSE NEXT NUMBER
→ CHOOSE OPERATOR
→ UPDATE STATE
→ RECURSE
→ UNDO
```

## State

```text
idx     = next unprocessed digit
curr    = whole expression value so far
prev    = signed previous operand contribution
currNum = number currently being tested
sb      = current expression
```

### Keep these separate

```text
currNum → current candidate number

curr    → complete expression value

prev    → signed contribution of previous operand
```

Example:

```text
1 - 2

curr = -1
prev = -2
currNum = 2
```

---

## First Number

At:

```text
idx == 0
```

there is no operator before the first number.

So:

```text
curr = number
prev = number
sb   = number
```

Memory:

```text
FIRST NUMBER
→ initialize state

LATER NUMBER
→ + / - / *
```

---

## Operator Rules

### `+`

```java
curr + currNum
prev = currNum
```

### `-`

```java
curr - currNum
prev = -currNum
```

Why signed?

Because:

```text
1 - 2 * 3
```

needs:

```text
prev = -2
```

so:

```text
prev * 3 = -6
```

### `*`

Multiplication has precedence.

For:

```text
1 + 2 * 3
```

current state before `*`:

```text
curr = 3
prev = 2
```

Remove old contribution:

```text
curr - prev
= 1
```

Multiply:

```text
prev * 3
= 6
```

Put it back:

```text
1 + 6
= 7
```

Formula:

```java
newCurr = (curr - prev) + (prev * currNum);
newPrev = prev * currNum;
```

Memory:

```text
* → REMOVE OLD PREV → MULTIPLY → PUT BACK
```

---

## Why `prev` Changes After `*`

For:

```text
1 + 2 * 3
```

the latest multiplicative contribution becomes:

```text
6
```

So:

```text
prev = 6
```

This matters for:

```text
1 + 2 * 3 * 4
```

Then:

```text
curr = 7
prev = 6
```

Next:

```text
(7 - 6) + (6 * 4)
= 25
```

Correct:

```text
1 + 24 = 25
```

---

## Number Construction

```java
currNum = currNum * 10
         + (digits.charAt(choices) - '0');
```

Example:

```text
123

0
→ 0*10 + 1 = 1
→ 1*10 + 2 = 12
→ 12*10 + 3 = 123
```

Memory:

```text
OLD NUMBER × 10 + NEW DIGIT
```

---

## Leading Zero

Allowed:

```text
0
```

Not:

```text
01
005
```

Condition:

```java
if (choices > idx && digits.charAt(idx) == '0') {
    break;
}
```

Meaning:

```text
choices == idx
→ first digit
→ "0" allowed

choices > idx
→ trying to extend "0"
→ invalid
→ break
```

---

## StringBuilder Backtracking

Before a branch:

```java
int len = sb.length();
```

Then:

```text
append
→ recurse
→ restore
```

Use:

```java
sb.setLength(len);
```

because a branch may append several characters:

```text
+123
```

Memory:

```text
SAVE LENGTH
→ MODIFY
→ RECURSE
→ RESTORE
```

---

## L125 Code Template

```java
long currNum = 0;

for (int choices = idx; choices < digits.length(); choices++) {

    if (choices > idx && digits.charAt(idx) == '0') {
        break;
    }

    currNum = currNum * 10
            + (digits.charAt(choices) - '0');

    int len = sb.length();

    if (idx == 0) {

        sb.append(currNum);

        solve(
            digits, target, res,
            sb,
            currNum,
            currNum,
            choices + 1
        );

        sb.setLength(len);

    } else {

        // +
        sb.append('+').append(currNum);
        solve(
            digits, target, res,
            sb,
            curr + currNum,
            currNum,
            choices + 1
        );
        sb.setLength(len);

        // -
        sb.append('-').append(currNum);
        solve(
            digits, target, res,
            sb,
            curr - currNum,
            -currNum,
            choices + 1
        );
        sb.setLength(len);

        // *
        sb.append('*').append(currNum);
        solve(
            digits, target, res,
            sb,
            (curr - prev) + (prev * currNum),
            prev * currNum,
            choices + 1
        );
        sb.setLength(len);
    }
}
```

---

## L125 Recognition in New Problems

If a problem says:

```text
insert operators into a digit string
generate expressions
reach a target
```

derive:

```text
1. Choose next number length.
2. Build the number.
3. First number? Initialize.
4. Otherwise choose operator.
5. Update expression state.
6. Recurse from choices + 1.
7. Restore StringBuilder.
```

### If the problem changes

```text
remove *
→ multiplication state may no longer be needed

change operators
→ operator branches change

change target
→ final validation changes

add new precedence
→ state may need more information
```

---

# L126 — Restore Valid IP Addresses

## Pattern

```text
STRING PARTITION
→ CHOOSE 1–3 DIGITS
→ BUILD PART
→ VALIDATE
→ ADD PART
→ RECURSE
→ UNDO
```

---

# State

```text
idx      = start of current IP part
choices  = end of current IP part
currPart = numeric value of current part
parts    = number of IP parts already created
sb       = current IP string
```

### Most important distinction

```text
idx
→ START

choices
→ END

currPart
→ VALUE

parts
→ COUNT
```

---

# Why the Loop Uses `choices`

Suppose:

```text
str = "23579"
idx = 0
```

The current IP part can be:

```text
"2"
"23"
"235"
```

The loop:

```java
for (int choices = idx; choices < str.length(); choices++)
```

tries the possible ending positions.

### Iteration 1

```text
choices = 0

current part = "2"
currPart = 2
next idx = choices + 1 = 1
```

### Iteration 2

```text
choices = 1

current part = "23"
currPart = 23
next idx = 2
```

### Iteration 3

```text
choices = 2

current part = "235"
currPart = 235
next idx = 3
```

### Memory

```text
CURRENT PART
= idx ... choices

NEXT PART
= choices + 1
```

---

# Why `choices + 1`

Suppose:

```text
idx = 0
choices = 2
```

Then the chosen part is:

```text
positions 0,1,2
```

So:

```text
next unused position = 3
```

Therefore:

```java
solve(..., choices + 1, ...)
```

means:

```text
continue at the FIRST DIGIT NOT USED
```

This is the real reason.

Not:

```text
"because recursion usually uses +1"
```

but:

```text
because choices is the LAST consumed position.
```

---

# Why `parts + 1`

Every recursive call has just selected exactly one IP segment.

So:

```text
parts = 0
→ choose first segment
→ parts = 1
```

Then:

```text
parts = 1
→ choose second segment
→ parts = 2
```

Therefore:

```java
parts + 1
```

means:

```text
one more IP part has been created
```

---

# Why `if (parts > 0)`

```java
if (parts > 0) {
    sb.append('.');
}
```

Means:

```text
parts == 0
→ first part
→ no dot

parts > 0
→ part 2/3/4
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
dot goes BETWEEN parts,
never before the first part.
```

---

# `choices > idx` — Leading Zero

Suppose:

```text
str = "023"
idx = 0
```

### First iteration

```text
choices = 0
```

Then:

```text
choices > idx
0 > 0 → false
```

So:

```text
"0"
```

is allowed.

### Second iteration

```text
choices = 1
```

Now:

```text
choices > idx
1 > 0 → true
```

and:

```text
str.charAt(idx) == '0'
```

is also true.

So we are trying:

```text
"02"
```

Invalid.

Therefore:

```java
break;
```

### Memory

```text
choices == idx
→ one digit
→ 0 allowed

choices > idx
→ more than one digit
→ leading zero
→ stop
```

---

# Why `break`, Not `continue`

Suppose:

```text
"023"
```

If:

```text
"02"
```

is invalid because of the leading zero, then:

```text
"023"
```

is also invalid.

So all longer candidates are invalid.

Therefore:

```text
invalid leading-zero extension
→ break
```

This is pruning.

---

# Number Construction

```java
currPart =
    currPart * 10
    + (str.charAt(choices) - '0');
```

Example:

```text
str = "235"

0
→ 0*10 + 2 = 2

→ 2*10 + 3 = 23

→ 23*10 + 5 = 235
```

Memory:

```text
OLD VALUE × 10 + NEW DIGIT
```

---

# `currPart > 255` — Validate the Value

For:

```text
str = "312"
```

at:

```text
choices = 2
```

the index is:

```text
2
```

but the IP value is:

```text
312
```

So:

```java
if (choices > 255)
```

checks the wrong thing.

Correct:

```java
if (currPart > 255) {
    break;
}
```

Because the rule is about:

```text
VALUE
```

not:

```text
INDEX
```

Memory:

```text
choices
→ position

currPart
→ value
```

---

# Why `currPart > 255` Can Break

Once:

```text
currPart = 256
```

longer values can only become:

```text
2560
25600
...
```

They cannot become smaller.

So:

```text
currPart > 255
→ all longer candidates invalid
→ break
```

Again:

```text
detect impossible
→ prune
```

---

# Base Case

A valid IP needs:

```text
all digits consumed
AND
exactly 4 parts
```

So:

```java
if (idx == str.length() && parts == 4) {
    ans.add(sb.toString());
    return;
}
```

Also stop when:

```text
parts == 4
```

because a fifth part is impossible.

Mental table:

```text
all digits + 4 parts
→ VALID

all digits + fewer than 4 parts
→ invalid/incomplete

4 parts + leftover digits
→ invalid
```

---

# L126 Mini Dry Run — `"02300"`

Start:

```text
idx = 0
parts = 0
sb = ""
```

First part choices:

```text
"0"
```

is allowed.

Choose:

```text
0
```

Now:

```text
sb = "0"
parts = 1
next idx = 1
```

Remaining:

```text
2300
```

At `idx = 1`, choices can create:

```text
2
23
230
```

One valid path:

```text
0
→ 2
→ 30
→ 0
```

gives:

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

gives:

```text
0.23.0.0
```

This shows why the recursive index must always move to:

```text
choices + 1
```

---

# L126 Recursion Tree Shape

For:

```text
23579
```

the first level is:

```text
                       23579
                    idx = 0
                  /     |      \
                 2      23      235
                / \      |       |
              next     next    next
```

Every level means:

```text
choose the next IP part
```

and updates:

```text
idx
parts
sb
```

---

# L126 Code Template

```java
private static void solve(
        String str,
        List<String> ans,
        StringBuilder sb,
        int idx,
        int parts) {

    if (idx == str.length() && parts == 4) {
        ans.add(sb.toString());
        return;
    }

    if (parts == 4) {
        return;
    }

    int currPart = 0;

    for (int choices = idx;
         choices < str.length() && choices < idx + 3;
         choices++) {

        // "0" is valid, but "01" / "001" is not.
        if (choices > idx && str.charAt(idx) == '0') {
            break;
        }

        // Build 1-, 2-, or 3-digit value.
        currPart =
                currPart * 10
                + (str.charAt(choices) - '0');

        // IP segment must be 0..255.
        if (currPart > 255) {
            break;
        }

        int len = sb.length();

        // Dot goes only between parts.
        if (parts > 0) {
            sb.append('.');
        }

        sb.append(currPart);

        // choices is the last consumed index.
        solve(
                str,
                ans,
                sb,
                choices + 1,
                parts + 1
        );

        // Restore previous path.
        sb.setLength(len);
    }
}
```

---

# How to Recognize L126 Pattern in a New Problem

Look for:

```text
SPLIT A STRING
+
FIXED NUMBER OF PARTS
+
EACH PART HAS SMALL LENGTH LIMIT
+
EACH PART HAS VALIDITY RULES
```

Then derive:

```text
FOR EACH POSSIBLE PART LENGTH
→ BUILD PART
→ VALIDATE
→ CHOOSE
→ RECURSE
→ UNDO
```

Examples of variations:

```text
split into K numbers
split into K valid dates
split into valid numeric tokens
split into dictionary-valid chunks
```

The validation changes.

The recursion structure remains.

---

# How to Modify the L126 Template

### Maximum part length changes

Current:

```text
1–3
```

If maximum is `K`:

```java
choices < idx + K
```

### Maximum value changes

Current:

```text
255
```

If limit is `M`:

```java
if (currPart > M) {
    break;
}
```

### Number of parts changes

Current:

```text
4
```

If required number is `K`:

```text
parts == K
```

and stop creating more than `K`.

The recursion stays the same.

---

# L125 vs L126

```text
L125
→ choose next number
→ choose operator
→ update expression state
```

```text
L126
→ choose next part
→ validate part
→ update part count
```

Shared:

```text
CHOOSE
→ RECURSE
→ UNDO
```

Different:

```text
STATE
```

That is the main recognition lesson.

---

# Final L126 Memory

```text
idx
→ START of current part

choices
→ LAST digit of current part

choices + 1
→ NEXT UNPROCESSED position

currPart
→ numeric VALUE

parts
→ number of PARTS created

parts == 0
→ no dot

parts > 0
→ add dot

VALID PART
→ 1–3 digits
→ no leading zero
→ <= 255

VALID ANSWER
→ all digits consumed
→ exactly 4 parts
```

### One-Line Algorithm

```text
TRY 1–3 DIGITS
→ BUILD VALUE
→ VALIDATE
→ ADD PART
→ RECURSE(choices + 1, parts + 1)
→ RESTORE
```

---

# Revision Test

Before looking at code:

```text
1. Why is idx the START of the current part?

2. Why is choices the END of the current part?

3. Why is choices + 1 the next idx?

4. Why does parts + 1 happen?

5. Why is the dot added only when parts > 0?

6. Why does "0" pass?

7. Why does "01" fail?

8. Why is currPart checked instead of choices?

9. Why can currPart > 255 use break?

10. Why does the loop need a maximum of 3 digits?

11. Why must an answer have exactly 4 parts?

12. What part of the template changes if the maximum
    part length changes?

13. What part changes if the maximum value changes?

14. What is the reusable pattern beyond IP addresses?
```
