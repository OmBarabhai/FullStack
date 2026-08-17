# J — Permutation / Combination

> **Goal:** Recognize the backtracking pattern and rebuild the code from the state.

---

# Pattern 1 — Permutation

## J101 — Generate Permutations ⭐⭐⭐⭐⭐

**Pattern:** Fix one position at a time using swap + backtracking.

### Algorithm

```text
idx = current position to fix

for each i from idx → 0:
    swap(i, idx)
    recurse(idx - 1)
    swap back
```

### Memory

```text
POSITION → CHOOSE → SWAP → RECURSE → SWAP BACK
```

### Base Case

```text
idx < 0
→ all positions fixed
→ save permutation
```

---

## J102 — Generate Unique Permutations ⭐⭐⭐⭐⭐

**Pattern:** Permutation + duplicate pruning.

### Algorithm

```text
At each recursion level:
    create used set

    for each candidate:
        if value already used at this level:
            skip

        mark value
        swap(value, idx)
        recurse(idx - 1)
        swap back
```

### Memory

```text
PERMUTATION
+
SAME-LEVEL DUPLICATE CHECK
```

Important:

```text
used = current recursion level only
```

---

## J103 — Permutations of a String ⭐⭐⭐⭐⭐

**Pattern:** Same swap-based permutation, but with `StringBuilder`.

### Algorithm

```text
idx = position to fix

for i = idx → 0:
    swap characters
    recurse(idx - 1)
    swap back
```

### Memory

```text
STRINGBUILDER
→ SWAP
→ RECURSE
→ SWAP BACK
```

### Base Case

```text
idx < 0
→ save current string
```

---

## J104 — Unique Permutations of a String ⭐⭐⭐⭐⭐

**Pattern:** String permutation + same-level duplicate pruning.

### Algorithm

```text
At each level:
    create Set<Character>

    for each candidate:
        if character already used:
            skip

        mark character
        swap
        recurse
        swap back
```

### Memory

```text
CHOOSE
→ CHECK DUPLICATE
→ SWAP
→ RECURSE
→ SWAP BACK
```

---

# Pattern 2 — Combination

## J105 — Generate Combinations ⭐⭐⭐⭐⭐

**Pattern:** Start-index + path backtracking.

Example:

```text
n = 4
k = 2

[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

### Algorithm

```text
start = first allowed candidate

for i = start → n:
    add i
    recurse(i + 1)
    remove i
```

### Base Case

```text
path.size() == k
→ save combination
→ return
```

### Memory

```text
START → CHOOSE → ADD → RECURSE(i+1) → REMOVE
```

### Important

```text
Permutation:
idx = position being fixed

Combination:
start = next allowed candidate
```

---

## J106 — Combinations of Size K ⭐⭐⭐⭐⭐

**Pattern:** Same combination pattern with explicit `k`.

### Algorithm

```text
if path.size() == k:
    save
    return

for i = start → n:
    add i
    recurse(i + 1)
    remove i
```

### Memory

```text
START + K
→ CHOOSE
→ RECURSE(i+1)
→ REMOVE
```

### Core State

```text
start = allowed candidate boundary
path  = selected elements
k     = required size
```

---

# Pattern 3 — Combination Sum

## J107 — Combination Sum ⭐⭐⭐⭐⭐

**Pattern:** Combination + target + reuse allowed.

### Algorithm

```text
if target == 0:
    save answer
    return

if target < 0 or no candidates:
    return

TAKE:
    add arr[idx]
    recurse with SAME idx
    remove

SKIP:
    recurse with idx + 1
```

### Memory

```text
TAKE  → SAME INDEX
SKIP  → NEXT INDEX
```

### Why same index?

```text
TAKE arr[idx]
→ element can be reused
```

---

## J108 — Combination Sum II ⭐⭐⭐⭐⭐

**Pattern:** Combination + target + no reuse + duplicates.

### Algorithm

```text
sort array

if target == 0:
    save
    return

if invalid:
    return

TAKE:
    add current
    recurse with idx - 1
    remove

SKIP:
    skip duplicate values
    recurse to next candidate
```

### Memory

```text
SORT
→ CHOOSE
→ NO REUSE
→ SKIP DUPLICATES
→ RECURSE
→ UNDO
```

### Important

```text
Reuse     → stay on same candidate
No reuse  → move to next candidate
```

---

## J109 — Combination Sum III ⭐⭐⭐⭐⭐

**Pattern:** Combination + exact `k` + target.

### State

```text
idx   = current array position
count = selected elements
k     = required elements
tar   = remaining target
path  = current selection
```

### Algorithm

```text
if count > k:
    return

if target < 0:
    return

if count == k:
    if target == 0:
        save answer
    return

if idx < 0:
    return

TAKE:
    add current
    count + 1
    recurse idx - 1
    remove

SKIP:
    recurse idx - 1
    count unchanged
```

### Memory

```text
COUNT = selected
K     = required

count == k
→ CHECK TARGET
→ STOP
```

---

## J110 — Subsets With Duplicates ⭐⭐⭐⭐⭐

**Pattern:** Subsets + duplicate skipping.

### Algorithm

```text
sort array

if idx < 0:
    save current subset
    return

TAKE:
    add nums[idx]
    recurse idx - 1
    remove

SKIP:
    skip adjacent duplicates
    recurse
```

### Memory

```text
TAKE
→ RECURSE
→ UNDO
→ SKIP DUPLICATES
→ RECURSE
```

### Duplicate condition

When checking:

```java
nums[idx - 1]
```

first prove:

```text
idx > 0
```

---

# Quick Pattern Comparison

| Problem | Main Pattern | Reuse | Duplicates | Main State |
|---|---|:---:|:---:|---|
| J101 | Permutation | — | ❌ | `idx` |
| J102 | Unique Permutation | — | ✅ | `idx + used` |
| J103 | String Permutation | — | ❌ | `idx` |
| J104 | Unique String Permutation | — | ✅ | `idx + Set` |
| J105 | Combination | ❌ | ❌ | `start + path` |
| J106 | Combination of K | ❌ | ❌ | `start + k + path` |
| J107 | Combination Sum | ✅ | ❌ | `idx + target + path` |
| J108 | Combination Sum II | ❌ | ✅ | `idx + target + path` |
| J109 | Combination Sum III | ❌ | ❌ | `idx + count + k + target + path` |
| J110 | Subsets II | ❌ | ✅ | `idx + path` |

---

# Core Difference — Permutation vs Combination

## Permutation

```text
ORDER MATTERS

123
132
213
231
312
321
```

Think:

```text
USED / POSITION
```

## Combination

```text
ORDER DOES NOT MATTER

12
13
23
```

Think:

```text
START INDEX
```

### Memory

```text
Permutation → "WHO GOES NEXT?"
Combination → "WHO IS STILL ALLOWED?"
```

---

# Reuse Rule

```text
Reuse allowed
    ↓
TAKE → same index
```

Example:

```text
J107
```

```text
Reuse not allowed
    ↓
TAKE → next index
```

Examples:

```text
J108
J109
```

---

# Duplicate Rule

If duplicate handling uses neighbors:

```java
nums[idx] == nums[idx - 1]
```

then equal values need to be adjacent.

Therefore:

```text
SORT
   ↓
GROUP EQUAL VALUES
   ↓
SKIP DUPLICATES
```

### Boundary Memory

```text
access idx - 1
→ require idx > 0
```

---

# Universal Backtracking Pattern

```text
STATE
 ↓
BASE CASE
 ↓
GENERATE CHOICES
 ↓
CHOOSE
 ↓
RECURSE
 ↓
UNDO
 ↓
NEXT CHOICE
```

For permutation:

```text
CHOOSE → SWAP → RECURSE → SWAP BACK
```

For combination:

```text
CHOOSE → ADD → RECURSE → REMOVE
```

---

# Simple Recursion Trees

## Permutation

```text
                    []
             /       |       \
            1        2        3
          /  \      /  \      /  \
        12   13   21   23   31   32
         |    |    |    |    |    |
        ...  ...  ...  ...  ...  ...
```

---

## Combination

```text
                 start
               /   |   \
              1    2    3
             / \   |
            2   3  3
            |   |  |
          [1,2][1,3][2,3]
```

---

## Combination Sum

```text
                  idx,target
                 /         \
              TAKE         SKIP
                |            |
          same idx        idx + 1
                |
             reuse
```

---

## Combination Sum III

```text
               idx
              /   \
           TAKE   SKIP
             |       |
        count + 1  count
             |
        idx - 1
```

---

# Complexity Memory

```text
Subsets
→ O(2^n)

Permutations
→ O(n!)
```

For generated output, include the cost of copying/storing each answer.

The exact complexity of target-based combination problems depends heavily on the input and number of generated combinations.

---

# Pattern Recognition

When you see:

```text
"arrange all"
"all permutations"
```

think:

```text
PERMUTATION
→ position
→ used/swap
→ backtrack
```

When you see:

```text
"choose K"
"choose elements"
"order doesn't matter"
```

think:

```text
COMBINATION
→ start
→ path
→ i + 1
```

When you see:

```text
"target sum"
"reuse allowed"
```

think:

```text
COMBINATION SUM
→ same index on TAKE
```

When you see:

```text
"target sum"
"each element once"
"duplicates"
```

think:

```text
COMBINATION SUM II
→ sort
→ no reuse
→ duplicate skip
```

When you see:

```text
"exactly K"
"target"
"1..9"
```

think:

```text
COMBINATION SUM III
→ count
→ k
→ target
→ no reuse
```

When you see:

```text
"subsets"
"duplicates"
```

think:

```text
SUBSETS II
→ sort
→ TAKE
→ UNDO
→ SKIP DUPLICATES
```

---

# J — One-Page Memory

```text
J101 → PERMUTATION
POSITION → SWAP → RECURSE → SWAP BACK

J102 → UNIQUE PERMUTATION
PERMUTATION + SAME-LEVEL DUPLICATE CHECK

J103 → STRING PERMUTATION
STRINGBUILDER + SWAP + RECURSE

J104 → UNIQUE STRING
SWAP + SET PER LEVEL

J105 → COMBINATION
START → ADD → RECURSE(i+1) → REMOVE

J106 → COMBINATION K
START + K

J107 → COMBINATION SUM
TAKE SAME INDEX

J108 → COMBINATION SUM II
NO REUSE + DUPLICATE SKIP

J109 → COMBINATION SUM III
COUNT + K + TARGET

J110 → SUBSETS II
SORT + TAKE + UNDO + SKIP DUPLICATES
```

---

# Final Mental Checklist

```text
1. What is my STATE?
2. What does each parameter mean?
3. What are my CHOICES?
4. Does ORDER matter?
5. Can I REUSE?
6. Are there DUPLICATES?
7. What is the BASE CASE?
8. What changes after TAKE?
9. What must I UNDO?
10. Where does the next recursion start?
```
