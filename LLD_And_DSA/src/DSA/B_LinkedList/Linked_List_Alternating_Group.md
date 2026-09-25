# Linked List — Permanent Revision Notes
## Alternating Group Reverse / Skip

> **Main goal:** Stop memorizing code. Build a stable mental model for **what each pointer means, where each group starts/ends, how reverse/skip state changes, and why the tail pointer moves differently after reverse vs skip.**

---

# 1. Problem — Understand It Before Coding

We process the list in groups of **up to `k` nodes**.

The operations alternate:

```text
Group 1 → REVERSE
Group 2 → SKIP
Group 3 → REVERSE
Group 4 → SKIP
...
```

Example:

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
k = 3
```

Groups:

```text
Group 1: 1 2 3 → REVERSE
Group 2: 4 5 6 → SKIP
Group 3: 7 8   → REVERSE
```

Result:

```text
3 → 2 → 1 → 4 → 5 → 6 → 8 → 7
```

## Critical rule

The final group can contain fewer than `k` nodes.

```text
fewer than k
≠
automatically skip
```

The action is still controlled by the alternating state.

---

# 2. The One Picture You Must Know

Before processing a group:

```text
prevTail → groupStart → ... → groupEnd → nextGroup
```

Meaning:

```text
prevTail
    ↓
last node of already processed part

groupStart
    ↓
first node of current group

groupEnd
    ↓
last node belonging to current group

nextGroup
    ↓
first node after current group
```

This is the foundation of the whole solution.

---

# 3. Pointer Dictionary

Use names that describe the pointer's job.

| Pointer | Meaning |
|---|---|
| `prevTail` | last node of already processed part |
| `groupStart` | first node of current group before processing |
| `groupEnd` | last node of current group |
| `nextGroup` | first node after current group |
| `prev` | head of currently reversed portion |
| `curr` | node currently being reversed |
| `fwd` | saved next node |
| `isReverse` | whether this group should be reversed |

The important distinction is:

```text
Group-level pointers:
prevTail, groupStart, groupEnd, nextGroup, isReverse

Reversal-level pointers:
prev, curr, fwd
```

Do not mix these jobs.

---

# 4. `prevTail` — The Anchor

`prevTail` means:

> The last node of the already processed portion.

Initial:

```text
dummy → 1 → 2 → 3 → 4 → 5
  ↑
prevTail
```

After processing the first group, suppose:

```text
dummy → 3 → 2 → 1 → 4 → 5
              ↑
           prevTail
```

Why is `prevTail = 1`?

Because `1` is the tail of the processed/reversed group.

Think:

```text
prevTail = "Where does the finished part end?"
```

This pointer is your anchor for the next group.

---

# 5. `groupStart`

Definition:

> The first node of the current group **before** any reversal.

Example:

```text
1 → 2 → 3
```

Initially:

```text
groupStart = 1
```

After reversal:

```text
3 → 2 → 1
```

`groupStart` is still the same node object:

```text
groupStart = 1
```

but its role has changed.

It is now:

```text
new tail
```

This is why the line:

```java
prevTail = groupStart;
```

is correct after reversal.

### Permanent idea

A variable can keep pointing to the same node even though the node's **position/role in the list changes**.

---

# 6. `groupEnd`

For a complete group:

```text
prevTail → 1 → 2 → 3 → 4
```

with:

```text
k = 3
```

we get:

```text
groupStart = 1
groupEnd = 3
```

So:

```text
prevTail → [1 → 2 → 3] → 4
```

`groupEnd` is simply:

> The last node included in this current group.

Using the name `groupEnd` is clearer than assuming a kth node always exists.

---

# 7. `nextGroup`

Definition:

> The first node after the current group.

Example:

```text
1 → 2 → 3 → 4 → 5
```

Current group:

```text
1 → 2 → 3
```

Then:

```text
groupEnd = 3
nextGroup = 4
```

Picture:

```text
prevTail → [1 → 2 → 3] → 4 → 5
                              ↑
                          nextGroup
```

This boundary is especially important for segment reversal.

---

# 8. Finding the Group End

The job of this phase is ONLY:

> Find where this group ends.

Do not mix this with `isReverse`.

Conceptual process:

```text
start at prevTail
move at most k times
if the list ends, the group is incomplete
```

Example:

```text
dummy → 1 → 2 → 3 → 4
k = 3
```

Start:

```text
groupEnd = dummy
```

Move 1:

```text
groupEnd = 1
```

Move 2:

```text
groupEnd = 2
```

Move 3:

```text
groupEnd = 3
```

Done.

The group is:

```text
1 2 3
```

---

# 9. Incomplete Group

Example:

```text
dummy → 1 → 2
k = 3
```

Attempt:

```text
move 1 → 1
move 2 → 2
move 3 → impossible
```

The group is incomplete.

The key question is:

```text
"Did I find k nodes?"
```

This is completely different from:

```text
"Should I reverse the group?"
```

---

# 10. Separate `isReverse` From Completeness

These are two independent facts.

```text
isReverse
→ What should I do?

group completeness
→ How many nodes exist?
```

Example:

```text
group has only 2 nodes
isReverse = true
```

This is valid.

It means:

```text
incomplete group + reverse
```

So:

```text
7 → 8
```

becomes:

```text
8 → 7
```

Do not force "incomplete" to mean "skip".

---

# 11. Alternating State

Start with:

```java
boolean isReverse = true;
```

After each group:

```java
isReverse = !isReverse;
```

State:

```text
true
false
true
false
...
```

Meaning:

```text
true  → reverse
false → skip
```

---

# 12. Why `isReverse` Must Live Outside the Loop

Wrong:

```java
while (...) {
    boolean isReverse = true;
}
```

This creates/resets the variable on every iteration.

So every group starts with:

```text
true
```

Correct:

```java
boolean isReverse = true;

while (...) {
    ...
    isReverse = !isReverse;
}
```

Now the state survives between iterations.

### General programming lesson

This is really about:

```text
scope + lifetime
```

not specifically linked lists.

---

# 13. Boolean Toggle

This:

```java
isReverse = !isReverse;
```

means:

```text
true  → false
false → true
```

Do not write:

```java
isReverse = false;
```

and expect alternation.

That only does:

```text
false → false
```

For alternating state, use:

```java
value = !value;
```

---

# 14. `break`, `continue`, `return`

Keep their meanings separate.

```text
break
→ leave current loop

continue
→ skip rest of current iteration

return
→ leave method
```

They control **execution**.

They do not directly change linked-list nodes.

Do not use `break` as a substitute for toggling state.

Do not expect `continue` to mean "skip two nodes".

---

# 15. Scope of `prev`

A common mistake is:

```java
if (isReverse) {
    Node prev = nextGroup;
}

prevTail.next = prev;
```

This is invalid because `prev` exists only inside the `if`.

If the variable is needed later:

```java
Node prev;

if (isReverse) {
    prev = nextGroup;
}
```

Braces `{ }` define a block scope.

---

# 16. Reverse the Group

For a group:

```text
1 → 2 → 3 → 4
```

where:

```text
group = 1 2 3
nextGroup = 4
```

initialize:

```java
Node prev = nextGroup;
Node curr = groupStart;
```

So:

```text
prev → 4

curr → 1 → 2 → 3 → 4
```

Why `prev = nextGroup`?

Because we are reversing a **segment**, not the whole list.

We want:

```text
3 → 2 → 1 → 4
```

not:

```text
3 → 2 → 1 → null
```

---

# 17. The Three-Pointer Reversal Pattern

```java
while (curr != nextGroup) {

    Node fwd = curr.next;

    curr.next = prev;

    prev = curr;
    curr = fwd;
}
```

Roles:

```text
prev = reversed portion
curr = not-yet-reversed portion
fwd  = saved future
```

Permanent sequence:

```text
SAVE
↓
CHANGE
↓
MOVE
↓
MOVE
```

Exactly:

```java
fwd = curr.next;
curr.next = prev;
prev = curr;
curr = fwd;
```

---

# 18. Why `fwd` Must Be Saved First

Suppose:

```text
1 → 2 → 3
```

and:

```text
curr = 1
```

If you do:

```java
curr.next = prev;
```

you overwrite the original:

```text
1 → 2
```

So before changing it:

```java
Node fwd = curr.next;
```

Now:

```text
fwd → 2
```

The future is safe.

General rule:

> If you are about to overwrite a link and still need the old link, save it first.

---

# 19. Detailed Reversal Dry Run

Suppose:

```text
1 → 2 → 3 → 4
```

Group:

```text
1 2 3
```

`nextGroup = 4`

Initial:

```text
prev = 4
curr = 1
```

### Iteration 1

```java
fwd = curr.next;
```

```text
fwd = 2
```

Then:

```java
curr.next = prev;
```

Now:

```text
1 → 4
```

Then:

```java
prev = curr;
```

```text
prev = 1
```

Then:

```java
curr = fwd;
```

```text
curr = 2
```

### Iteration 2

```text
fwd = 3
2.next = 1
prev = 2
curr = 3
```

Now:

```text
2 → 1 → 4
```

### Iteration 3

```text
fwd = 4
3.next = 2
prev = 3
curr = 4
```

Now:

```text
3 → 2 → 1 → 4
```

Since:

```text
curr == nextGroup
```

stop.

---

# 20. Most Important Reversal Fact

Before:

```text
groupStart → ... → groupEnd
```

After reverse:

```text
groupEnd → ... → groupStart
```

Therefore:

```text
old first → new tail
old last  → new head
```

So:

```text
prev = new group head
groupStart = new group tail
```

This explains why:

```java
prevTail.next = prev;
prevTail = groupStart;
```

---

# 21. Reconnect After Reversal

Suppose the larger list is:

```text
10 → 1 → 2 → 3 → 4
```

Current group:

```text
1 2 3
```

After reversal:

```text
3 → 2 → 1 → 4
```

But we still need:

```text
10 → 3 → 2 → 1 → 4
```

So:

```java
prevTail.next = prev;
```

Here:

```text
prevTail = 10
prev = 3
```

Therefore:

```text
10 → 3 → 2 → 1 → 4
```

---

# 22. Why `prevTail = groupStart` After Reverse

After:

```text
3 → 2 → 1 → 4
```

the old `groupStart` was:

```text
1
```

Now:

```text
1 = new tail
```

The next group must begin after `1`.

Therefore:

```java
prevTail = groupStart;
```

This means:

> Move the anchor to the new tail of the processed group.

---

# 23. What Happens When We Skip a Group?

Suppose:

```text
4 → 5 → 6
```

and:

```text
isReverse = false
```

Leave it unchanged:

```text
4 → 5 → 6
```

The tail is still:

```text
6
```

which is:

```java
groupEnd
```

Therefore:

```java
prevTail = groupEnd;
```

---

# 24. The Critical Tail Rule

After a **reverse**:

```java
prevTail = groupStart;
```

Because the old first node became the new tail.

After a **skip**:

```java
prevTail = groupEnd;
```

Because nothing changed.

### Memorize this:

```text
REVERSE → old start becomes tail
SKIP    → old end remains tail
```

---

# 25. Full Alternating Dry Run

Input:

```text
1 2 3 4 5 6 7 8
k = 3
```

Initial:

```text
isReverse = true
```

## Group 1

```text
1 2 3
```

Reverse:

```text
3 2 1
```

Now:

```text
prevTail = 1
isReverse = false
```

## Group 2

```text
4 5 6
```

Skip:

```text
4 5 6
```

Now:

```text
prevTail = 6
isReverse = true
```

## Group 3

Remaining:

```text
7 8
```

This group is incomplete.

But:

```text
isReverse = true
```

so reverse:

```text
8 7
```

Final:

```text
3 2 1 4 5 6 8 7
```

---

# 26. Important Invariant

At the beginning of each outer iteration:

```text
processed part → prevTail → current group → remaining part
```

More visually:

```text
dummy → [processed correctly] → prevTail → [current/remaining]
```

`prevTail` tells you exactly where the processed portion ends.

The next group begins at:

```java
prevTail.next
```

This invariant is your strongest tool for debugging.

---

# 27. Why You Should Not Move `prevTail` During Reversal

The inner reversal loop has one job:

```text
reverse this group
```

It should work with:

```text
prev
curr
fwd
```

Only after the group is fully reversed should you:

```text
connect
move prevTail
toggle state
```

This separation keeps the algorithm understandable.

---

# 28. Group-Level vs Pointer-Level Thinking

## Outer/group logic

Answers:

```text
Which group?
Where does it start?
Where does it end?
Should it reverse?
Where does processed work end?
```

Pointers:

```text
prevTail
groupStart
groupEnd
nextGroup
isReverse
```

## Inner reversal logic

Answers:

```text
How do I reverse this segment?
```

Pointers:

```text
prev
curr
fwd
```

Do not let these two layers become mixed.

---

# 29. Why a Failed Output Is Useful

Suppose the expected ending is:

```text
18 → 17
```

but your output is:

```text
17 → 18
```

Do not only think:

```text
wrong answer
```

Ask:

```text
Which group contains 17, 18?
Should that group reverse?
What is isReverse at that group?
Is the final group incomplete?
Where did prevTail end?
```

This turns the test failure into a pointer/state diagnosis.

---

# 30. Small Dry Runs Before Large Ones

Start with tiny inputs.

### Test 1

```text
1 → 2 → 3 → 4
k = 2
```

Groups:

```text
1 2 → reverse
3 4 → skip
```

Result:

```text
2 → 1 → 3 → 4
```

### Test 2

```text
1 → 2 → 3 → 4 → 5
k = 2
```

Groups:

```text
1 2 → reverse
3 4 → skip
5   → reverse
```

Result:

```text
2 → 1 → 3 → 4 → 5
```

### Test 3

```text
1 → 2
k = 3
```

Incomplete final group:

```text
1 2
```

Since first group is reverse:

```text
2 1
```

### Test 4

```text
1 → 2 → 3 → 4 → 5 → 6 → 7 → 8
k = 3
```

Result:

```text
3 → 2 → 1 → 4 → 5 → 6 → 8 → 7
```

---

# 31. Debugging Table

When confused, literally write this:

| Stage | `prevTail` | `groupStart` | `groupEnd` | `nextGroup` | `isReverse` | Action |
|---|---|---|---|---|---|---|
| Start | dummy | 1 | ? | ? | true | — |
| Group 1 | dummy | 1 | 3 | 4 | true | reverse |
| After G1 | 1 | — | — | — | false | done |
| Group 2 | 1 | 4 | 6 | 7 | false | skip |
| After G2 | 6 | — | — | — | true | done |
| Group 3 | 6 | 7 | 8/incomplete | null | true | reverse |

The goal is to make pointer state visible.

---

# 32. Common Mistakes — Permanent Lessons

## 1. Resetting `isReverse`

Wrong:

```java
while (...) {
    boolean isReverse = true;
}
```

Result: every iteration starts as reverse.

---

## 2. Using `isReverse` while finding the group

Finding the boundary and deciding the operation are separate jobs.

---

## 3. Starting reversal from `prevTail`

Wrong:

```java
curr = prevTail;
```

Correct:

```java
curr = groupStart;
```

Relationship:

```text
prevTail → groupStart → ... → groupEnd → nextGroup
```

---

## 4. Forgetting `nextGroup`

Without a clear boundary, segment reversal becomes difficult to control.

---

## 5. Changing `prevTail` inside the reversal loop

Finish the reversal first.

Then update the group anchor.

---

## 6. Forgetting to save `fwd`

Wrong idea:

```java
curr.next = prev;
```

before saving the old `curr.next`.

Correct:

```java
fwd = curr.next;
curr.next = prev;
```

---

## 7. Treating incomplete as skip

Incorrect:

```text
fewer than k → don't reverse
```

Correct:

```text
fewer than k
+
isReverse == true
→ reverse
```

---

## 8. Using the wrong tail after processing

```text
reverse → prevTail = groupStart
skip    → prevTail = groupEnd
```

---

## 9. Forgetting the correct scope

A pointer declared inside an `if` cannot automatically be used outside it.

---

# 33. The Algorithm as 5 Clear Phases

For every group:

```text
PHASE 1 — FIND
Find groupEnd.

PHASE 2 — IDENTIFY
groupStart = prevTail.next
nextGroup = groupEnd.next

PHASE 3 — DECIDE
isReverse?

PHASE 4 — PROCESS
reverse or leave unchanged

PHASE 5 — MOVE
Move prevTail to the new tail.
Toggle isReverse.
```

This is much easier to remember than a large block of code.

---

# 34. Pseudocode Mental Template

```text
prevTail = dummy
isReverse = true

while there are nodes:

    find up to k nodes
    identify groupStart
    identify groupEnd
    identify nextGroup

    if isReverse:
        reverse groupStart ... groupEnd
        connect prevTail to new group head
        prevTail = groupStart
    else:
        leave group unchanged
        prevTail = groupEnd

    isReverse = !isReverse
```

The goal is to understand this template before writing Java.

---

# 35. Universal Linked-List Pointer Rule

Whenever you see:

```java
node.next = something;
```

STOP and ask:

```text
1. Where is node pointing right now?
2. What is node.next right now?
3. Am I destroying a link?
4. Do I need to save that old link?
5. Where should node.next point afterward?
6. Which pointer must move after this?
```

This habit will help with many linked-list problems.

---

# 36. Permanent Mental Model

Do not memorize the final code.

Remember this:

```text
                CURRENT GROUP
                      ↓

prevTail → groupStart → ... → groupEnd → nextGroup
```

If reversing:

```text
prevTail → groupEnd → ... → groupStart → nextGroup
                                      ↑
                                 new tail
```

If skipping:

```text
prevTail → groupStart → ... → groupEnd → nextGroup
                                      ↑
                                 new tail
```

Therefore:

```text
REVERSE:
prevTail = groupStart

SKIP:
prevTail = groupEnd
```

And inside reversal:

```text
SAVE → CHANGE → MOVE
```

---

# 37. One-Page Cheat Sheet

```text
GROUP:

prevTail → [groupStart ... groupEnd] → nextGroup
```

```text
FIND:
groupEnd

IDENTIFY:
groupStart
nextGroup

REVERSE:

prev = nextGroup
curr = groupStart

while (curr != nextGroup) {
    fwd = curr.next
    curr.next = prev
    prev = curr
    curr = fwd
}

CONNECT:
prevTail.next = prev

MOVE:
prevTail = groupStart
```

For skip:

```text
DO NOT CHANGE LINKS
prevTail = groupEnd
```

Alternation:

```java
isReverse = !isReverse;
```

Critical facts:

```text
old first  → new tail after reverse
old last   → new head after reverse
```

```text
isReverse  = WHAT TO DO
groupEnd   = WHERE GROUP ENDS
prevTail   = WHERE PROCESSED PART ENDS
nextGroup  = WHERE NEXT PART STARTS
```

---

# 38. Final Permanent Questions

Before submitting any linked-list group problem, answer these without looking at code:

```text
1. What does prevTail represent?
2. What does groupStart represent?
3. What does groupEnd represent?
4. What does nextGroup represent?
5. Why is prev initialized to nextGroup?
6. Why must fwd be saved before curr.next changes?
7. Why does groupStart become the tail after reversal?
8. Why does groupEnd remain the tail after skip?
9. What does isReverse represent?
10. What happens when the final group has fewer than k nodes?
```

When these answers are automatic, the code becomes much easier to derive.

---

# Final Memory

```text
LIST STATE:

processed → prevTail → current group → remaining


REVERSE:

old start → new tail
old end   → new head


SKIP:

everything stays the same


REVERSAL POINTERS:

prev = reversed
curr = current
fwd  = saved future


GROUP POINTERS:

prevTail
groupStart
groupEnd
nextGroup


STATE:

true → reverse
false → skip
toggle with !isReverse


MASTER RULE:

SAVE THE LINK
CHANGE THE LINK
MOVE THE POINTER
VERIFY THE NEW STRUCTURE
```

---

# 39. Boolean Toggle — `!isReverse`

This small Java concept is important for the alternating-group logic.

Suppose:

```java
boolean isReverse = true;
```

After Group 1:

```java
isReverse = false;
```

Then:

```text
Group 1 → true  → REVERSE
Group 2 → false → SKIP
Group 3 → false → SKIP  ❌
Group 4 → false → SKIP  ❌
```

Why?

Because:

```java
isReverse = false;
```

means:

> **SET the variable to `false`.**

It does not remember the previous value or automatically switch again.

---

## `!` Means NOT

In Java:

```text
!true  → false
!false → true
```

Therefore:

```java
isReverse = !isReverse;
```

means:

> Take the current value of `isReverse` and replace it with the opposite value.

Step by step:

Start:

```java
boolean isReverse = true;
```

Current value:

```text
isReverse = true
```

Run:

```java
isReverse = !isReverse;
```

Right side first:

```text
!true = false
```

Then assignment:

```text
isReverse = false
```

Run the same line again:

```java
isReverse = !isReverse;
```

Now:

```text
!false = true
```

So:

```text
isReverse = true
```

The pattern becomes:

```text
true
 ↓
false
 ↓
true
 ↓
false
 ↓
true
```

---

## Think of a Light Switch

```text
ON  → OFF
OFF → ON
```

`!` means:

```text
OPPOSITE
```

So:

```java
isReverse = !isReverse;
```

is basically:

```text
FLIP THE SWITCH
```

---

## Set vs Flip

This distinction should be permanent.

```java
isReverse = false;
```

means:

```text
SET
make it false
```

while:

```java
isReverse = !isReverse;
```

means:

```text
FLIP
make it the opposite of what it currently is
```

---

## In Your Linked-List Problem

Start:

```java
boolean isReverse = true;
```

Group 1:

```text
isReverse = true
→ reverse
```

After Group 1:

```java
isReverse = !isReverse;
```

Now:

```text
isReverse = false
```

Group 2:

```text
false
→ skip
```

Toggle again:

```java
isReverse = !isReverse;
```

Now:

```text
true
```

Group 3:

```text
true
→ reverse
```

So the correct pattern is:

```text
Group 1   Group 2   Group 3   Group 4
  true     false      true     false
   ↓         ↓         ↓         ↓
 reverse     skip     reverse    skip
```

---

## Permanent Memory Line

```text
= false       → SET it to false
= !isReverse  → FLIP it
```

Or simply:

```text
! = OPPOSITE
```

Therefore:

```java
isReverse = !isReverse;
```

means:

```text
true  → false
false → true
```

For alternating logic, you need:

```text
FLIP
```

not:

```text
SET FALSE
```

