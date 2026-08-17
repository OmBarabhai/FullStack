# Combination 3 — Combination Sum III

## Problem
Choose exactly `k` distinct numbers from `1` to `9` whose sum is exactly `n`.

## Core Pattern
**Combination / Include-Exclude Backtracking**

At each index:
- **Take** `nums[idx]`
- **Skip** `nums[idx]`

We move forward with `idx + 1`, so numbers are not reused and order is not permuted.

## State

```java
solve(nums, idx, count, tar, ans, op, k)
```

| Variable | Meaning |
|---|---|
| `idx` | Current number being considered |
| `count` | Number of numbers selected so far |
| `tar` | Remaining target |
| `op` | Current combination |
| `k` | Required number of selected numbers |
| `ans` | Valid combinations |

### Key Rule

```text
TAKE → count + 1
SKIP → count unchanged
```

`count` means **how many numbers have actually been selected**.

## Base Cases

### Exactly `k` numbers

```java
if (count == k) {
    if (tar == 0) {
        ans.add(new ArrayList<>(op));
    }
    return;
}
```

So:

```text
count == k && tar == 0 → valid → add
count == k && tar != 0 → invalid → return
```

Reaching `tar == 0` before selecting `k` numbers is not automatically valid.

### Target negative

```java
if (tar < 0) {
    return;
}
```

Because all candidates are positive.

### No candidates left

```java
if (idx >= nums.length) {
    return;
}
```

## TAKE Branch

```java
op.add(nums[idx]);

solve(
    nums,
    idx + 1,
    count + 1,
    tar - nums[idx],
    ans,
    op,
    k
);

op.remove(op.size() - 1);
```

Mental model:

```text
choose
↓
count increases
↓
target decreases
↓
recurse
↓
UNDO
```

## SKIP Branch

```java
solve(
    nums,
    idx + 1,
    count,
    tar,
    ans,
    op,
    k
);
```

Mental model:

```text
don't choose
↓
count unchanged
↓
target unchanged
↓
move forward
```

## Why Backtracking?

We temporarily add a number:

```java
op.add(nums[idx]);
```

After exploring that choice, remove it:

```java
op.remove(op.size() - 1);
```

Pattern:

```text
choose → explore → undo → try another choice
```

## Why `idx + 1`?

The candidates are:

```text
1 2 3 4 5 6 7 8 9
```

After deciding about one number, move forward.

This guarantees:
- no number is reused
- no backward movement
- no duplicate orderings such as `[1,2]` and `[2,1]`

This is a **combination**, so order does not matter.

## Example

For:

```text
k = 3
n = 7
```

One valid path:

```text
take 1 → target 6, count 1
take 2 → target 4, count 2
take 4 → target 0, count 3
```

Result:

```text
[1, 2, 4]
```

## Mistakes We Identified

### Wrong

```java
if (idx < count)
```

`idx` and `count` represent different things.

### Correct

```text
idx   → current position
count → selected numbers
```

### Unnecessary duplicate skipping

A duplicate-skipping loop is unnecessary because:

```java
int[] nums = {1,2,3,4,5,6,7,8,9};
```

contains no duplicates.

Do not blindly reuse a technique from another problem.

## Pattern Recognition

When you see:

```text
choose exactly k
+
from candidates
+
each candidate at most once
+
order does not matter
```

Think:

```text
Combination Backtracking
        ↓
Include / Exclude
```

## Questions Before Coding

1. What does `idx` represent?
2. What does `count` represent?
3. What does `tar` represent?
4. What are the choices?
5. What changes on TAKE?
6. What changes on SKIP?
7. What is the base case?
8. Where do I undo?
9. Can an element be reused?
10. Does order matter?
11. Are duplicates actually present?

## Revision Test

Without looking at the implementation, reconstruct:

```text
TAKE:
idx   → ?
count → ?
tar   → ?

SKIP:
idx   → ?
count → ?
tar   → ?
```

Then implement the recursion from scratch.

## Current Learning Status

- Pattern: **Combination / Include-Exclude Backtracking**
- State understanding: **Good**
- `count` meaning: **Understood**
- TAKE vs SKIP: **Understood**
- Base-case reasoning: **Understood**
- Backtracking / undo: **Understood**
- Duplicate handling: **Recognized as unnecessary here**
- Independent implementation: **Needs more practice**
- Unfamiliar variation: **Next checkpoint**

## Next Step

Do not memorize the code.

Reconstruct:

```text
state
→ choices
→ base case
→ TAKE
→ UNDO
→ SKIP
```

Then solve a variation without looking at this implementation.
