# H — Take / Not-Take Foundation

> **Goal:** Recognize the two-branch decision tree and derive the recursion from the state.

---

# Pattern 1 — Print / Generate

## H81 — Print All Subsequences ⭐⭐⭐⭐⭐

**Pattern:** Every element has two choices.

### Algorithm

```text
idx == n
→ save current path

TAKE
→ add arr[idx]
→ recurse(idx + 1)
→ remove last

NOT-TAKE
→ recurse(idx + 1)
```

### Memory

```text
TAKE → RECURSE → UNDO → NOT-TAKE → RECURSE
```

### State

```text
idx = current element
op  = selected elements
```

### Recursion Tree

```text
                    []
                 /      \
              TAKE     NOT-TAKE
               10         |
               |          |
             [10]         []
             /  \        /  \
           +20  -20    +20   -20
```

For `n` elements:

```text
subsequences = 2^n
```

---

## H87 — Print All Subsets ⭐⭐⭐⭐⭐

**Pattern:** Same TAKE / NOT-TAKE structure.

### Algorithm

```text
if idx == n:
    print path
    return

add arr[idx]
recurse(idx + 1)
remove last

recurse(idx + 1)
```

### Memory

```text
SUBSET = TAKE OR SKIP EVERY ELEMENT
```

### Important

```text
Subsequence / Subset
→ same include-exclude decision tree
```

---

# Pattern 2 — Count

## H82 — Count Subsequences ⭐⭐⭐⭐

**Pattern:** Same tree, but return the number of valid leaves.

### Algorithm

```text
if idx == n:
    return 1

take    = count(idx + 1)
notTake = count(idx + 1)

return take + notTake
```

### Memory

```text
COUNT = LEFT + RIGHT
```

### Important

`return 1` at the leaf means:

```text
this path represents one subsequence
```

So:

```text
N elements
→ 2^N subsequences
```

---

## H88 — Count Subsets ⭐⭐⭐⭐

**Pattern:** Same as H82.

### Algorithm

```text
if idx == n:
    return 1

take    = count(idx + 1)
notTake = count(idx + 1)

return take + notTake
```

### Memory

```text
H82 and H88 use the SAME recursion tree.
Only the problem name changes.
```

---

## H84 — Count Subsequences With Sum K ⭐⭐⭐⭐⭐

**Pattern:** TAKE / NOT-TAKE + running sum.

### State

```text
idx = current element
sum = current selected sum
k   = target sum
```

### Algorithm

```text
if idx == n:
    return sum == k ? 1 : 0

take =
    solve(idx + 1, sum + arr[idx])

notTake =
    solve(idx + 1, sum)

return take + notTake
```

### Memory

```text
TAKE    → sum + arr[idx]
NOT TAKE → sum
COUNT   → take + notTake
```

---

# Pattern 3 — Print Only Valid Paths

## H83 — Print Subsequence With Sum K ⭐⭐⭐⭐⭐

**Pattern:** TAKE / NOT-TAKE + target validation.

### State

```text
idx
sum
k
curr
```

### Algorithm

```text
if idx == n:
    if sum == k:
        print curr
    return

TAKE:
    add arr[idx]
    recurse(sum + arr[idx])
    remove

NOT-TAKE:
    recurse(sum)
```

### Memory

```text
TAKE → ADD → RECURSE → REMOVE
SKIP → RECURSE
```

### Key Difference

```text
H83 → print every valid path
H84 → count every valid path
```

---

## H85 — Print One Subsequence With Sum K ⭐⭐⭐⭐⭐

**Pattern:** Stop as soon as one valid answer is found.

### Algorithm

```text
if idx == n:
    if sum == k:
        print
        return true
    return false

TAKE:
    add
    if recurse():
        return true
    remove

NOT-TAKE:
    if recurse():
        return true

return false
```

### Memory

```text
FOUND?
→ YES → STOP EVERYTHING
→ NO  → TRY NEXT BRANCH
```

### Key Idea

The boolean return value travels upward:

```text
valid answer
↓
true
↓
parent stops
```

---

# Pattern 4 — Boolean Existence

## H86 — Check Subsequence With Sum K ⭐⭐⭐⭐⭐

**Pattern:** Find whether at least one valid subsequence exists.

### Algorithm

```text
if idx == n:
    return sum == k

TAKE:
    if recurse(sum + arr[idx]):
        return true

UNDO

NOT-TAKE:
    if recurse(sum):
        return true

return false
```

### Memory

```text
CHECK = TAKE || NOT-TAKE
```

### Important

```text
H85
→ print the first valid subsequence

H86
→ only return true/false
```

The recursion tree can be similar; the required output changes the return strategy.

---

# Pattern 5 — Target Transformation

## H89 — Subset Sum ⭐⭐⭐⭐⭐

**Pattern:** Boolean TAKE / NOT-TAKE with target existence.

### State

```text
idx
sum
target
```

### Algorithm

```text
if idx == n:
    return sum == target

take:
    sum + arr[idx]

notTake:
    sum
```

### Memory

```text
TARGET EXISTS?
→ TAKE || NOT-TAKE
```

### Relation

```text
H83 → print valid sum-K paths
H84 → count valid sum-K paths
H85 → print one valid sum-K path
H86 → check existence
H89 → same existence idea as subset sum
```

---

# Pattern 6 — Partition

## H90 — Partition Into Two Equal Subsets ⭐⭐⭐⭐⭐

**Pattern:** Convert partition into subset-sum.

### Step 1

```text
total = sum(arr)
```

If:

```text
total is odd
```

then:

```text
return false
```

### Step 2

```text
target = total / 2
```

Now ask:

```text
Can one subset make target?
```

### Algorithm

```text
if idx < 0:
    return sum == target

TAKE:
    sum + arr[idx]

NOT-TAKE:
    sum

return take || notTake
```

### Memory

```text
EQUAL PARTITION
→ TARGET = TOTAL / 2
→ SUBSET SUM
```

---

# Pattern 7 — Optimization

## H91 — Partition With Minimum Difference ⭐⭐⭐⭐⭐

**Pattern:** TAKE / NOT-TAKE + minimum result.

### State

```text
idx
sumA
total
```

Group B is automatic:

```text
sumB = total - sumA
```

### Algorithm

```text
if idx == n:
    sumB = total - sumA
    return abs(sumA - sumB)

take =
    solve(idx + 1, sumA + arr[idx])

notTake =
    solve(idx + 1, sumA)

return min(take, notTake)
```

### Memory

```text
TAKE / NOT-TAKE
→ calculate leaf difference
→ return MIN
```

### Recursion Tree

```text
                 sumA = 0
                 /       \
             TAKE       NOT-TAKE
               1            0
              / \          / \
             T   N        T   N
            +2   0       +2   0
             |            |
           continue     continue
```

At each leaf:

```text
sumB = total - sumA
difference = |sumA - sumB|
```

Then:

```text
MIN(left, right)
```

---

# Pattern 8 — Binary Choice With Constraints

## H92 — Generate All Binary Strings of Length N ⭐⭐⭐⭐⭐

**Pattern:** Two choices at every position.

### Algorithm

```text
if idx == n:
    print string
    return

add 0
recurse(idx + 1)
remove

add 1
recurse(idx + 1)
remove
```

### Memory

```text
EACH POSITION
→ 0 OR 1
```

### Recursion Tree

For `n = 3`:

```text
              ""
             /  \
            0    1
           / \  / \
         00 01 10 11
         /\/\ /\/\
       000 001 010 011
       100 101 110 111
```

### Complexity

```text
2^N strings
→ O(N × 2^N) when printing
→ O(N) auxiliary space
```

---

## H93 — Binary Strings Without Consecutive 1s ⭐⭐⭐⭐⭐

**Pattern:** Binary generation + previous-state constraint.

### State

```text
idx
prev
sb
```

`prev` tells us the previous bit.

### Rule

```text
prev == 0
→ 0 OR 1 allowed

prev == 1
→ only 0 allowed
```

### Algorithm

```text
always try 0
→ next prev = 0

if prev == 0:
    try 1
    → next prev = 1
```

### Memory

```text
PREVIOUS BIT CONTROLS CURRENT CHOICES
```

### Tree

```text
                 ""
               prev=0
              /      \
             0        1
           p=0      p=1
           / \        |
          0   1       0
```

`11` is never created.

---

## H94 — Binary Strings Without Consecutive 0s ⭐⭐⭐⭐

**Pattern:** Same as H93, but the restricted bit is reversed.

### Rule

```text
prev == 1
→ 0 OR 1 allowed

prev == 0
→ only 1 allowed
```

### Memory

```text
H93 → after 1, no more 1
H94 → after 0, no more 0
```

Same recursion pattern, different constraint.

---

## H95 — Binary Strings With Exactly K Ones ⭐⭐⭐⭐⭐

**Pattern:** Binary generation + count constraint.

### State

```text
idx
ones
k
sb
```

### Algorithm

```text
if idx == n:
    if ones == k:
        print
    return

if ones < k:
    add 1
    recurse(ones + 1)
    remove

add 0
recurse(ones)
remove
```

### Memory

```text
1 → ones + 1
0 → ones unchanged
```

### Important Pruning

If:

```text
ones == k
```

then another `1` is not allowed.

So:

```text
ones < k
```

controls the `1` branch.

---

# H81–H95 Pattern Comparison

| Problem | Main Pattern | Output | Extra State |
|---|---|---|---|
| H81 | Take / Not-Take | All subsequences | `path` |
| H82 | Take / Not-Take | Count | — |
| H83 | Take / Not-Take + Sum | Print all valid | `sum` |
| H84 | Take / Not-Take + Sum | Count valid | `sum` |
| H85 | Take / Not-Take + Sum | Print one | `sum + boolean` |
| H86 | Take / Not-Take + Sum | Check | `sum + boolean` |
| H87 | Take / Not-Take | All subsets | `path` |
| H88 | Take / Not-Take | Count subsets | — |
| H89 | Take / Not-Take + Target | Check | `sum` |
| H90 | Partition → Subset Sum | Check | `target` |
| H91 | Partition Optimization | Minimum difference | `sumA, total` |
| H92 | Binary Choices | Generate | — |
| H93 | Binary + Constraint | Generate | `prev` |
| H94 | Binary + Constraint | Generate | `prev` |
| H95 | Binary + Exact Count | Generate | `ones, k` |

---

# Output Strategy

The recursion tree is similar, but the **return strategy changes**.

## Generate / Print

```text
visit every valid leaf
→ print/store
```

## Count

```text
return left + right
```

## Check

```text
return left || right
```

## Print One

```text
if left found:
    stop

otherwise:
    search right
```

## Minimum

```text
return min(left, right)
```

### Memory

```text
GENERATE → visit leaves
COUNT    → +
CHECK    → ||
ONE      → true stops search
MIN      → min
```

---

# Core Take / Not-Take Tree

```text
                    current element
                    /              \
                 TAKE            NOT-TAKE
                   |                  |
              state changes       state stays
                   |                  |
                RECURSE            RECURSE
                   \                  /
                    \                /
                     return answer
```

---

# What Changes in Each Problem?

```text
H81
→ path

H82
→ answer = count

H83
→ path + sum

H84
→ sum + count

H85
→ sum + boolean stop

H86
→ boolean existence

H87
→ path / subset

H88
→ subset count

H89
→ target existence

H90
→ total/2 target

H91
→ minimum difference

H92
→ 0 / 1 choice

H93
→ previous bit

H94
→ previous bit, opposite restriction

H95
→ number of ones
```

---

# Key Connections

## H81 ↔ H87

```text
Subsequence
and
Subset
```

use the same fundamental:

```text
TAKE / NOT-TAKE
```

---

## H83 ↔ H84 ↔ H85 ↔ H86

Same sum-K decision tree.

Only the answer changes:

```text
H83 → print all
H84 → count all
H85 → print one
H86 → true / false
```

---

## H89 ↔ H90

```text
Subset Sum
      ↓
Equal Partition
      ↓
target = total / 2
```

---

## H92 ↔ H93 ↔ H94 ↔ H95

```text
H92
pure 0/1 generation
      ↓
H93
constraint: no "11"
      ↓
H94
constraint: no "00"
      ↓
H95
constraint: exactly K ones
```

The base recursion remains:

```text
CHOOSE
→ RECURSE
→ UNDO
```

Only the state/constraints change.

---

# Common Mistakes

```text
❌ Forgetting the NOT-TAKE branch
❌ Forgetting to undo the TAKE branch
❌ Changing state in SKIP incorrectly
❌ Wrong base case
❌ Continuing after exact count is reached
❌ Wrong target/sum update
❌ Not pruning an impossible branch
❌ Using previous state incorrectly
```

### Debugging Questions

```text
What does TAKE change?

What does NOT-TAKE change?

What exactly means COMPLETE?

What should be returned from a valid leaf?

What should happen after one valid answer is found?

What constraint controls the next choice?
```

---

# Universal H Template

```java
void solve(int idx, State state) {

    if (baseCase) {
        processAnswer();
        return;
    }

    // TAKE
    changeState();

    solve(idx + 1, state);

    undoState();

    // NOT-TAKE
    solve(idx + 1, state);
}
```

For count:

```java
return take + notTake;
```

For check:

```java
return take || notTake;
```

For minimum:

```java
return Math.min(take, notTake);
```

---

# Pattern Recognition

When you see:

```text
subsequence
subset
include/exclude
take/skip
choose or ignore
```

think:

```text
TAKE / NOT-TAKE
```

When you see:

```text
sum K
```

add:

```text
sum / target
```

When you see:

```text
count K
```

add:

```text
count / remaining K
```

When you see:

```text
minimum / maximum
```

think:

```text
TAKE result
NOT-TAKE result
→ min / max
```

When you see:

```text
valid binary strings
```

ask:

```text
What previous state controls the next choice?
```

---

# H — One-Page Memory

```text
H81 → TAKE / NOT-TAKE → print all
H82 → TAKE / NOT-TAKE → count
H83 → TAKE / NOT-TAKE + sum → print all
H84 → TAKE / NOT-TAKE + sum → count
H85 → TAKE / NOT-TAKE + sum → print one
H86 → TAKE / NOT-TAKE + sum → boolean
H87 → TAKE / NOT-TAKE → subsets
H88 → TAKE / NOT-TAKE → subset count
H89 → TAKE / NOT-TAKE → subset sum check
H90 → total/2 → subset sum
H91 → TAKE / NOT-TAKE → min difference
H92 → 0 / 1
H93 → no consecutive 1s → prev
H94 → no consecutive 0s → prev
H95 → exactly K ones → ones
```

---

# Final Checklist

```text
1. What is my STATE?
2. What does TAKE change?
3. What does NOT-TAKE change?
4. What is the BASE CASE?
5. Am I PRINTING, COUNTING, CHECKING, or OPTIMIZING?
6. Do I need a running sum?
7. Do I need a count?
8. Does a previous choice constrain the next choice?
9. Can I prune?
10. What must I UNDO?
```
