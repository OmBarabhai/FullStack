````# Linked List — New Concepts Addendum
## Alternating Groups / Even-Length Groups

> **Purpose:** This is an add-on to the previous permanent Linked List notes.
> It intentionally avoids repeating the already-covered pointer reversal, `prevTail`, `groupStart`, `nextGroup`, `prev/curr/fwd`, dummy-node, and basic `isReverse` material.

---

# 1. New Problem Pattern: Expected Size vs Actual Size

This is the most important new distinction.

A group can have:

```text
EXPECTED size
```

and:

```text
ACTUAL size
```

These are not always equal.

Example:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
```

For increasing group sizes:

```text
Group 1 → expected 1
Group 2 → expected 2
Group 3 → expected 3
Group 4 → expected 4
```

But the list ends during Group 4.

So:

```text
Group 4:
expected = 4
actual   = 2
```

because only:

```text
7 → 8
```

remain.

### Permanent distinction

```text
expected = what the group is supposed to contain
actual   = what the list actually contains
```

Think:

```text
EXPECTED = plan
ACTUAL   = reality
```

---

# 2. Why One Variable Cannot Represent Both

Suppose:

```text
expected = 4
actual = 2
```

If you use one variable for both, you lose information.

You need to know:

```text
"Was this supposed to be a group of 4?"
```

and separately:

```text
"How many nodes did I actually get?"
```

These answers are different.

Use separate concepts:

```java
int groupSize;   // expected
int count;       // actual
```

### Rule

> One variable should answer one question.

---

# 3. `count++` Must Happen When a Node Is Consumed

Suppose you traverse:

```text
1 → 2 → 3
```

and want to count the nodes.

Correct:

```java
curr = curr.next;
count++;
```

The increment belongs to the event:

```text
"I successfully consumed one node."
```

So:

```text
visit 1 → count = 1
visit 2 → count = 2
visit 3 → count = 3
```

If you put:

```java
count++;
```

after the entire traversal loop, you count the **group**, not the nodes.

Wrong mental model:

```text
finish loop
→ count once
```

Correct mental model:

```text
consume node
→ count++
```

---

# 4. `groupSize` and `count` Have Different Lifetimes

For increasing groups:

```text
groupSize:
1 → 2 → 3 → 4 → ...

count:
reset for each group
```

Example:

```text
Group 1:
groupSize = 1
count = 1

Group 2:
groupSize = 2
count = 2

Group 3:
groupSize = 3
count = 3

Group 4:
groupSize = 4
count = 2
```

Notice:

```text
groupSize keeps growing
count keeps resetting
```

This is an important state-management pattern.

---

# 5. Group Number and Node Count Are Different

Do not confuse:

```text
Group 1
Group 2
Group 3
```

with:

```text
1 node
2 nodes
3 nodes
```

The group number determines the expected size in this problem:

```text
group number → expected size
```

But `count` tells you:

```text
actual nodes available
```
````
These may differ for the final group.

---

# 6. Even/Odd Decision Uses ACTUAL Count

For the LeetCode-style **Reverse Nodes in Even Length Groups** problem, the reversal decision is based on:

```text
actual group length
```

not the expected group size.

Example:

```text
expected size = 4
actual size = 2
```

Since:

```text
2 is even
```

the group is reversed.

So:

```text
7 → 8
```

becomes:

```text
8 → 7
```

### Permanent rule

```text
Expected size → tells how large the group was intended to be
Actual count  → tells whether the current group is even or odd
```

This is different from the alternating reverse/skip problem.

---

# 7. Do Not Mix Two Different Problem Rules

There are two related but different patterns.

## Pattern A — Alternating Reverse / Skip

Decision is based on group order:

```text
Group 1 → reverse
Group 2 → skip
Group 3 → reverse
Group 4 → skip
```

State:

```text
isReverse
```

## Pattern B — Reverse Even-Length Groups

Decision is based on:

```text
actual count % 2 == 0
```

Meaning:

```text
actual count even → reverse
actual count odd  → do not reverse
```

### Critical difference

```text
Alternating problem:
WHAT group number/state am I on?

Even-length problem:
HOW MANY nodes actually belong to this group?
```

Do not use one rule for the other.

---

# 8. Incomplete Group Can Be Even

This is the important edge case.

Suppose:

```text
expected = 4
actual = 2
```

The group is:

```text
7 → 8
```

It is:

```text
incomplete
```

and:

```text
even
```

Therefore, for the even-length-groups problem:

```text
reverse it
```

This is why checking only:

```text
complete?
```

is not enough.

You need:

```text
actual count
```

---

# 9. Example: Full Groups + Incomplete Group

Input:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
```

Expected group sizes:

```text
1
2
3
4
```

Actual sizes:

```text
1
2
3
2
```

Table:

| Group | Expected | Actual | Even? |
|---|---:|---:|---|
| 1 | 1 | 1 | No |
| 2 | 2 | 2 | Yes |
| 3 | 3 | 3 | No |
| 4 | 4 | 2 | Yes |

Therefore only Groups 2 and 4 reverse.

Result:

```text
1 → 3 → 2 → 4 → 5 → 6 → 8 → 7
```

The important learning point is:

```text
Group 4 expected = 4
Group 4 actual   = 2
decision         = based on 2
```

---

# 10. A Better Way to Think About Group Collection

When collecting a group, ask two questions:

```text
1. How many nodes SHOULD I try to collect?
2. How many nodes DID I actually collect?
```

During traversal:

```text
expected = groupSize
count = 0
```

For every available node:

```text
consume node
count++
```

Then after collection:

```text
count < expected
```

simply means:

```text
the group ended because the list ended
```

It does not automatically decide the operation.

---

# 11. Null Checking — Ask the Exact Question

One recurring source of confusion is checking the wrong pointer.

These are different statements:

```java
node != null
```

means:

> Does the node itself exist?

Whereas:

```java
node.next != null
```

means:

> Does this existing node have another node after it?

Example:

```text
5 → null
```

Here:

```java
node != null
```

is `true`.

But:

```java
node.next != null
```

is `false`.

So choose the check based on the operation you are about to perform.

### Mental habit

Before a null check, say the question in English.

For example:

```text
"I need to move to the next node."
```

Then ask:

```java
node.next != null
```

---

# 12. Loop Condition — Read It in English

For:

```java
while (prevTail.next != null)
```

read:

> Continue while there is another node.

For:

```java
while (prevTail.next == null)
```

read:

> Continue while there is no next node.

The second condition is usually the opposite of what a traversal wants.

Do not memorize the symbols. Translate them.

```text
== null → is null
!= null → exists / is not null
```

---

# 13. Why `complete` Is Often Not Enough

A variable like:

```java
boolean complete
```

can answer:

```text
Did I get the full expected group?
```

But it cannot answer:

```text
How many nodes actually did I get?
```

Example:

```text
complete = false
count = 2
```

This tells you much more than:

```text
complete = false
```

For even-length decisions, `count` is the important fact.

So don't use:

```text
complete
```

as a replacement for:

```text
count
```

---

# 14. State Reset Pattern

For every new group:

```text
count = 0
```

because you are starting a fresh measurement.

But:

```text
groupSize
```

changes only after finishing the group.

Conceptually:

```text
start group
↓
count = 0
↓
consume nodes
↓
count++
↓
decide using count
↓
increase groupSize
↓
next group
```

This order matters.

---

# 15. When to Increment `groupSize`

The expected size belongs to the **next group** after the current group is finished.

Conceptually:

```text
groupSize = 1

process group of expected size 1

groupSize++
→ now expected size is 2

process group of expected size 2

groupSize++
→ now expected size is 3
```

So:

```text
groupSize
```

represents the current expected group size, not the number of groups already completed unless those values happen to be the same.

---

# 16. A Useful State Table

For:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
```

use:

| Current group | `groupSize` | `count` | Decision |
|---|---:|---:|---|
| G1 | 1 | 1 | odd → keep |
| G2 | 2 | 2 | even → reverse |
| G3 | 3 | 3 | odd → keep |
| G4 | 4 | 2 | even → reverse |

This table is especially useful because it separates:

```text
expected
actual
decision
```

---

# 17. Why the Failing Test Is Valuable

When a final output differs only at the end, inspect:

```text
expected size
actual size
parity
```

Suppose the expected ending is:

```text
... → 18 → 17
```

but your output is:

```text
... → 17 → 18
```

That immediately suggests the final group may have been processed according to its **expected size** instead of its **actual size**.

This is a powerful debugging technique:

```text
Wrong output
→ identify wrong group
→ identify actual count
→ check decision rule
```

---

# 18. Modulo — Understand the Meaning, Not the Formula

For even/odd:

```java
count % 2 == 0
```

means:

> `count` has no remainder after division by 2.

Examples:

```text
1 % 2 = 1 → odd
2 % 2 = 0 → even
3 % 2 = 1 → odd
4 % 2 = 0 → even
```

So:

```java
if (count % 2 == 0)
```

means:

```text
if actual group size is even
```

The important word is:

```text
COUNT
```

not:

```text
GROUP SIZE EXPECTATION
```

---

# 19. Why Simulation Should Come Before `%`

Instead of memorizing:

```java
count % 2 == 0
```

first simulate:

```text
count = 1 → odd
count = 2 → even
count = 3 → odd
count = 4 → even
```

Then the formula becomes obvious:

```text
remainder 0 → even
remainder 1 → odd
```

The same principle applies to more complicated `%` patterns.

---

# 20. One Variable = One Meaning

Use this discipline:

```text
groupSize
→ expected size

count
→ actual size

isReverse
→ reverse/skip state

prevTail
→ processed-part anchor

groupStart
→ original first node of group

groupEnd
→ actual last node collected
```

Before creating a variable, complete this sentence:

```text
"This variable means __________."
```

If two variables have the same meaning, you may not need both.

If one variable has two meanings, redesign.

---

# 21. New Dry-Run Template

For these group-size problems, use:

```text
Group:
expected =
actual   =
even/odd =
decision =
```

Example:

```text
Group 4:
expected = 4
actual   = 2
even/odd = even
decision = reverse
```

This single four-line template catches many of the bugs you were making.

---

# 22. New Debugging Checklist

When a grouped linked-list answer is wrong, check in this order:

```text
1. Did I identify the correct group?
2. What size was expected?
3. How many nodes actually existed?
4. Did I use actual count for the decision?
5. Did I reset count for the new group?
6. Did I update groupSize at the correct time?
7. Did I check the correct null condition?
```

Only after these are correct should you inspect pointer reconnection.

---

# 23. What This Adds to Your Previous Notes

Your previous permanent notes already cover:

```text
pointer visualization
group boundaries
prevTail
groupStart
groupEnd
nextGroup
prev/curr/fwd
reversal
reconnection
alternating boolean state
scope
break / continue / return
save-before-change
```

This addendum adds the concepts that were missing:

```text
expected size vs actual size
groupSize vs count
count++ placement
count reset
groupSize progression
actual parity
incomplete-but-even group
alternating-rule vs even-length-rule
exact null-question thinking
state-table debugging
```

So this file is intentionally **not a second copy of the pointer notes**.

---

# Permanent Memory

```text
EXPECTED = PLAN
ACTUAL   = REALITY
```

```text
groupSize = expected size
count     = actual size
```

```text
count++ → when one node is actually consumed
```

```text
new group → count = 0
```

```text
even-length decision:
count % 2 == 0
```

```text
incomplete does NOT tell you reverse/skip
actual count does
```

```text
Alternating problem:
state decides

Even-length problem:
actual count decides
```

```text
Always ask the exact null question:
node exists?
or
node.next exists?
```

### The most important mental separation

```text
WHAT WAS EXPECTED?
        ↓
   groupSize

WHAT ACTUALLY EXISTED?
        ↓
      count

WHAT SHOULD I DO?
        ↓
 problem-specific rule
```
