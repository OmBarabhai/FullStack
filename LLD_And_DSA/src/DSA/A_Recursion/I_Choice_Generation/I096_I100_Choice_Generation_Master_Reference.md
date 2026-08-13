# I096–I100 — Choice Generation Master Reference

> Long-term reference for the **Choice / Generation** family.
>
> The goal is not to memorize five solutions. The goal is to recognize the decision tree and derive the code for a new problem.

## 1. Problems

According to the master roadmap:

```text
096 — All Strings From Character Set {a,b}
097 — All Strings From Digits 0–2
098 — Print All Choices From an Array Recursively
099 — Count Ways to Choose K Items
100 — Include/Exclude Subset Framework Practice
```

I96–I100 are the **Choice / Generation** group. The source describes the transition from earlier TAKE/SKIP recursion to multiple choices. fileciteturn61file0L437-L469

---

## 2. The Big Transition

### TAKE / NOT-TAKE

```text
                 element
                 /      \
              TAKE      SKIP
                ↓          ↓
             recurse    recurse
```

Exactly two choices.

### Choice Generation

```text
                 state
            /      |      \
        choice1 choice2 choice3
           ↓       ↓       ↓
        recurse recurse recurse
```

One recursive branch for each valid choice.

The source explicitly describes this transition as:

```text
TAKE
SKIP

        ↓

choice 1
choice 2
choice 3
...
```

fileciteturn61file0L453-L469

---

# 3. Master Pattern

```java
for (each valid choice) {

    choose();

    recurse();

    undo();
}
```

Mental model:

```text
STATE
  ↓
AVAILABLE CHOICES
  ↓
CHOOSE
  ↓
EXPLORE
  ↓
UNDO
  ↓
NEXT CHOICE
```

This is the core Choice Backtracking pattern. fileciteturn56file8L605-L627

---

# 4. The Four Questions Before Coding

For every new choice problem ask:

```text
1. What is my STATE?
2. What are my CHOICES?
3. What is the BASE CASE?
4. What must I UNDO?
```

Then ask:

```text
Can a choice be reused?
Does order matter?
Can duplicates occur?
Am I printing, counting, or checking?
```

---

# 5. I096 — Strings From {a,b}

Choices:

```text
a
b
```

For length 3:

```text
aaa
aab
aba
abb
baa
bab
bba
bbb
```

Tree:

```text
                             ""
                         /        \
                       /            \
                      a              b
                   /     \        /      \
                  aa     ab      ba      bb
                 / \     / \    /  \    /  \
               aaa aab aba abb baa bab bba bbb
```

State:

```text
position + path
```

Choices:

```text
a,b
```

Base:

```text
path.length() == n
```

Modification:

```text
append
```

Undo:

```text
delete last
```

Pattern:

```text
append
→ recurse(position + 1)
→ delete last
```

---

# 6. I097 — Strings From Digits 0–2

Same recursion as I096.

Only the choice set changes:

```text
I096:
a,b

I097:
0,1,2
```

For length 2:

```text
00
01
02
10
11
12
20
21
22
```

Tree:

```text
                    ""
              /      |      \
             0       1       2
           / | \    / | \   / | \
          0  1  2  0  1  2 0  1  2
```

Key lesson:

> Do not create a new recursion template when only the choice set changes.

---

# 7. I096 vs I097 — What Actually Changes?

```text
SAME STATE:
    position + path

SAME TRANSITION:
    choose
    recurse
    undo

DIFFERENT:
    choice set
```

So:

```text
I096 → 2 choices
I097 → 3 choices
```

General principle:

> **Identify the choice set separately from the recursion pattern.**

---

# 8. I098 — Choices From an Array

Example:

```text
arr = [A,B,C]
```

At a position, possible choices come from the input:

```text
A
B
C
```

State may be:

```text
position + path
```

Choices:

```java
for (int i = 0; i < arr.length; i++)
```

Generic structure:

```java
for (each valid arr[i]) {

    path.add(arr[i]);

    solve(...);

    path.remove(path.size() - 1);
}
```

The important change from I096/I097:

```text
choices now come from INPUT
```

not a hard-coded character set.

---

# 9. I099 — Count Ways to Choose K Items

The roadmap identifies I099 as the bridge into:

```text
n choose k
```

and then combinations. fileciteturn59file0L22-L43

The key difference is the output:

```text
I096–I098:
generate / print

I099:
COUNT
```

Related idea:

```text
Generate:
    visit valid leaves

Count:
    return number of valid leaves
```

For a two-branch recursion:

```java
return include + exclude;
```

For a multi-choice recursion:

```text
total ways
=
ways(choice1)
+
ways(choice2)
+
ways(choice3)
+ ...
```

The state must represent:

```text
how many items have been chosen
+
what choices remain
```

---

# 10. I099 → J105/J106

This is an important bridge:

```text
I099
Count ways to choose K
      ↓
J105/J106
Generate combinations of size K
```

The difference is:

```text
COUNT
→ return a number

GENERATE
→ store actual paths
```

Same decision space, different requested output.

---

# 11. I100 — Include/Exclude Framework

I100 reinforces the earlier two-choice model:

```text
TAKE
OR
SKIP
```

So keep the distinction clear:

```text
I096–I098
→ many-choice generation

I099
→ count K selections

I100
→ include/exclude framework
```

The master roadmap shows this progression before J101 begins permutation/combination backtracking. fileciteturn59file0L204-L231

---

# 12. Choice Generation vs Include/Exclude

## Include / Exclude

```text
                 element
                /       \
             TAKE       SKIP
```

## Choice Generation

```text
                 state
             /     |     \
          choice choice choice
```

Remember:

```text
2 fundamentally different decisions
→ TAKE / SKIP

many possible choices
→ FOR EACH CHOICE
```

---

# 13. Universal Undo Rule

Whatever you modify, undo exactly that modification.

```text
path.add(x)
→ path.remove(last)

sb.append(x)
→ sb.deleteCharAt(last)

used[i] = true
→ used[i] = false

visited[r][c] = true
→ visited[r][c] = false

swap(...)
→ swap(...) again
```

Golden rule:

```text
CHOOSE
  ↓
MODIFY
  ↓
RECURSE
  ↓
UNDO
```

---

# 14. Why I096/I097 Naturally Use Append/Delete

For a generated string:

```text
path = "ab"
```

choose:

```text
a
```

then:

```text
path = "aba"
```

After the branch returns:

```text
path = "ab"
```

So:

```text
append
→ recurse
→ delete last
```

There is no reason to force permutation-style `swap()` here.

---

# 15. Reuse vs No Reuse

This is one of the most important questions for a NEW problem:

> **Can I choose the same option again?**

### I096/I097

If the problem says construct a string of fixed length from a choice set, repeated choices can be allowed.

Example:

```text
aaa
aab
bbb
```

So after choosing `a`, `a` may still be available.

### Combination-style problems

Often we do NOT want to go backward or reuse earlier candidates.

Then state changes may use:

```text
i + 1
```

or another mechanism.

Do not memorize `i + 1` as a universal recursion rule.

---

# 16. `i + 1` Is Not Universal

Ask:

> What should be available at the next recursive level?

Examples:

```text
Fixed-length string:
    position → position + 1

Combination:
    chosen i → next candidate i + 1

Permutation:
    next unfixed position

Reuse allowed:
    the same choice may remain available
```

The transition must come from the problem's meaning.

---

# 17. Common Choice-Backtracking Mistakes

The source explicitly lists these Choice Backtracking mistakes: fileciteturn56file9L761-L771

```text
❌ Forgetting Undo
❌ Wrong Loop Index
❌ Duplicate Answers
❌ Infinite Recursion
❌ Wrong Stopping Condition
```

These should be your first debugging checklist.

---

# 18. Mistake: Forgetting Undo

Wrong:

```java
for (char ch : choices) {

    sb.append(ch);

    solve(...);
}
```

The next branch sees old characters still in the state.

Correct:

```java
sb.append(ch);

solve(...);

sb.deleteCharAt(sb.length() - 1);
```

---

# 19. Mistake: Wrong Loop Range

Always ask:

```text
What are the legal choices?
```

Then derive the loop.

Example:

```text
I097 choices = {0,1,2}
```

Therefore:

```java
for (char ch = '0'; ch <= '2'; ch++)
```

or an equivalent choice collection.

Do not guess the bounds.

---

# 20. Mistake: Wrong Base Case

The base case must mean:

> **A complete valid answer has been formed.**

Examples:

```text
fixed string:
    position == n

choose K:
    selected == k

array traversal:
    idx == arr.length
```

Do not use a variable just because it "looks like" the completion variable.

Ask:

```text
What exactly means COMPLETE?
```

---

# 21. Mistake: Infinite Recursion

Before calling recursion, ask:

> **What changed?**

Examples:

```text
position + 1
remaining - 1
idx + 1
selected + 1
```

If the state does not move toward the base case, recursion may never terminate.

---

# 22. Mistake: Duplicate Answers

Duplicate answers can happen when:

```text
the same state can be reached through
multiple equivalent choices
```

Ask:

```text
Are input choices unique?
Can the same value occur multiple times?
Can two branches produce the same result?
```

If yes, decide whether you need:

```text
Set
sorted duplicate skip
boolean[]
another constraint-specific state
```

Do not add a Set automatically.

---

# 23. Mistake: Reuse Confusion

Ask:

```text
Can I reuse the choice?
```

If YES:

```text
keep it available in the next state
```

If NO:

```text
remove it / move beyond it / mark it used
```

This single question separates many later backtracking problems.

---

# 24. Fixed-Length String Choice Tree

General:

```text
M choices
N positions
```

If every choice is available at every position:

```text
number of leaves = M^N
```

Examples:

```text
I096:
2^3 = 8

I097:
3^2 = 9
```

This gives the intuition for the branching factor.

---

# 25. Complexity Intuition

If there are:

```text
M choices
N positions
```

then:

```text
M^N
```

states/leaves may be generated.

If every answer has length N and must be copied:

```text
O(N × M^N)
```

Auxiliary recursion/path:

```text
O(N)
```

excluding output.

For I098 and I099 the exact complexity depends on:

```text
number of choices
+
whether reuse is allowed
+
what is being generated or counted
```

---

# 26. Generate vs Count vs Check

The same recursion tree can answer different questions.

## Generate

```text
visit each valid leaf
store the path
```

## Count

```text
return number of valid leaves
```

## Boolean / Check

```text
return whether at least one valid leaf exists
```

Typical combination:

```text
COUNT:
    branch1 + branch2

CHECK:
    branch1 || branch2
```

Generation:

```text
explore both/all branches
store valid leaves
```

---

# 27. I096–I100 Relationship

```text
I096
fixed position + 2 choices
       ↓
I097
fixed position + 3 choices
       ↓
I098
choices from input array
       ↓
I099
count K selections
       ↓
I100
include/exclude framework
       ↓
J101+
permutation / combination
```

This progression is part of the roadmap's intended bridge toward permutations and combinations. fileciteturn61file0L204-L231

---

# 28. Choice Generation → Permutation

The important question changes from:

```text
"What option can I put here?"
```

to:

```text
"Which UNUSED element can I put here?"
```

Permutation then adds:

```text
used[]
```

or an in-place swap representation.

The source's next family explicitly begins with permutation/combination problems. fileciteturn60file0L48-L71

---

# 29. Choice Generation → Combination

The question becomes:

```text
"Which candidate can I choose now
without creating a different ordering?"
```

Therefore:

```text
start
→ choose i
→ recurse(i+1)
```

This is the bridge to J105/J106.

---

# 30. NEW-PROBLEM CHECKLIST

Before writing code:

```text
1. What is the STATE?

2. What is the current position/index?

3. What choices are available?

4. How many choices are there?

5. Can a choice be reused?

6. Does order matter?

7. What does a COMPLETE answer mean?

8. What is the BASE CASE?

9. What changes before recursion?

10. What must be UNDONE?

11. Can duplicate answers occur?

12. Do I need pruning?

13. What does the recursive call change?

14. What does the function return:
       generate?
       count?
       boolean?

15. What is the branching factor?

16. What is the time/space complexity?
```

---

# 31. Derive Code Instead of Memorizing

Example problem:

> Generate strings of length N using `{a,b}`.

Derive:

```text
STATE:
position + path

CHOICES:
a,b

BASE:
position == N

MODIFY:
append

RECURSE:
position + 1

UNDO:
delete last
```

That is enough to reconstruct the implementation.

---

# 32. Another New Problem

> Generate length-N strings using digits `0,1,2`.

Derive:

```text
STATE:
position + path

CHOICES:
0,1,2

BASE:
position == N

MODIFY:
append

RECURSE:
position + 1

UNDO:
delete last
```

Only the choice set changed.

The recursion pattern did not.

---

# 33. NEW Array Choice Problem

If:

```text
arr = [A,B,C]
```

and each position may choose any array element:

```text
STATE:
position + path

CHOICES:
arr[i]

BASE:
required length reached

MODIFY:
path.add(arr[i])

RECURSE:
next position

UNDO:
remove last
```

The choice source changed.

The core pattern stayed the same.

---

# 34. Personal-Issue Note

I checked the available master/source files for I096–I100.

They clearly document:

```text
the five I problems
the Choice Generation pattern
the transition from TAKE/SKIP
the {a,b} example
the common mistake checklist
the bridge toward combinations
```

fileciteturn61file0L437-L469

However, the retrieved files do **not** contain the full individual code attempts and correction history for each of your I096–I100 attempts.

So this document does **not invent personal mistakes** that cannot be verified.

For now, use the verified mistake checklist:

```text
Forget Undo
Wrong Loop Index
Duplicate Answers
Infinite Recursion
Wrong Stopping Condition
```

When an actual old I096–I100 code attempt is available, add a revision block:

```text
MY MISTAKE
    ↓
WHY IT WAS WRONG
    ↓
HOW I SHOULD DETECT IT
    ↓
WHAT PATTERN IT TEACHES
```

---

# 35. Final I96–I100 Memory Card

```text
CHOICE GENERATION

STATE
  ↓
AVAILABLE CHOICES
  ↓
CHOOSE ONE
  ↓
MODIFY STATE
  ↓
RECURSE
  ↓
UNDO
  ↓
NEXT CHOICE
```

Specializations:

```text
2 choices
→ TAKE / SKIP

many choices
→ CHOICE GENERATION

many choices + order matters
→ PERMUTATION

many choices + order doesn't matter
→ COMBINATION
```

---

# 36. Final Interview/OA Questions

When AI is unavailable, ask yourself:

```text
What is my state?

What choices do I have?

What does one recursive call mean?

What is complete?

What changes before recursion?

What must be restored?

Can I reuse a choice?

Does order matter?

Can duplicates occur?

Do I need pruning?

Am I generating, counting, or checking?

How many branches does each node have?
```

If you can answer these questions, you can derive the code instead of recalling it.

---

# 37. One-Line Rule

> **Choice Backtracking = at the current state, try every valid choice, recursively explore it, undo the state change, and then try the next choice.**
