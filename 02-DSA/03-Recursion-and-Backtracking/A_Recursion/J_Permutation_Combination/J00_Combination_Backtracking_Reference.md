# J — Combination Backtracking Reference

> Long-term reference for combination problems: `start`, path add/remove, why `i+1` matters, combination vs permutation, duplicate handling, and how to derive new problems.

## 1. Core idea

Combination means **order does not matter**.

```text
[1,2] == [2,1]
```

For `n=4, k=2`:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

## 2. Why combination differs from permutation

### Permutation

Order matters:

```text
[1,2] and [2,1] are different
```

Typical:

```text
position
→ swap
→ recurse
→ swap back
```

### Combination

Order does not matter:

```text
[1,2] and [2,1] are the same
```

Typical:

```text
start
→ choose i
→ path.add(i)
→ recurse(i+1)
→ path.remove(last)
```

## 3. Main state: `start`

`start` means:

> **The smallest candidate currently allowed to choose.**

Example:

```text
n=4
start=1
```

Candidates:

```text
1,2,3,4
```

Choose `1`:

```text
path=[1]
start=2
```

Now only:

```text
2,3,4
```

are allowed.

This prevents:

```text
[1,1]
[2,1]
[3,1]
```

## 4. Path state

Combinations naturally use a separate mutable path:

```java
List<Integer> path
```

Example:

```text
path=[]
choose 1 → [1]
choose 3 → [1,3]
```

Backtracking undo:

```java
path.remove(path.size() - 1);
```

## 5. Core combination pattern

```text
START
  ↓
FOR each i from start to n
  ↓
CHOOSE i
  ↓
path.add(i)
  ↓
RECURSE with i+1
  ↓
path.remove(last)
  ↓
NEXT i
```

Code shape:

```java
static void solve(
        int n,
        int k,
        List<List<Integer>> ans,
        List<Integer> path,
        int start) {

    if (path.size() == k) {
        ans.add(new ArrayList<>(path));
        return;
    }

    for (int i = start; i <= n; i++) {
        path.add(i);
        solve(n, k, ans, path, i + 1);
        path.remove(path.size() - 1);
    }
}
```

Initial call:

```java
solve(n, k, ans, path, 1);
```

## 6. Why base case is `path.size() == k`

`start` tells us where choices may begin.

It does **not** tell us how many elements we have selected.

So completion is:

```java
if (path.size() == k) {
    ans.add(new ArrayList<>(path));
    return;
}
```

Example:

```text
k=2
path=[1]    → size 1 → continue
path=[1,3]  → size 2 → store
```

## 7. Why `new ArrayList<>(path)`?

`path` is mutable.

Wrong:

```java
ans.add(path);
```

Later backtracking changes `path`.

Correct:

```java
ans.add(new ArrayList<>(path));
```

This stores a snapshot.

## 8. Why `i + 1`?

After choosing `i`, the next candidate must be larger.

Example:

```text
choose 1
↓
next start = 2
↓
2,3,4 allowed
```

This prevents both:

```text
[1,1]
[2,1]
```

and ensures increasing order inside each combination.

## 9. Complete tree for `n=4, k=2`

```text
                         []
          /        /        \        \
         1         2         3         4
       / | \      / \        |
      2  3  4    3   4       4
      |  |  |    |   |       |
    [1,2][1,3][1,4][2,3][2,4][3,4]
```

## 10. Detailed transition

Start:

```text
path=[]
start=1
```

Choose `1`:

```text
path=[1]
next start=2
```

Choose `2`:

```text
path=[1,2]
```

Now:

```text
path.size()==k
```

Store `[1,2]`.

Undo:

```text
path=[1]
```

Try `3` → `[1,3]`.

Undo.

Try `4` → `[1,4]`.

Return to `[]`, then choose `2`, etc.

## 11. Why we do NOT use swap here

Permutation asks:

> Which element should occupy this position?

Combination asks:

> Which elements should I select, starting from this boundary?

Therefore:

```text
Permutation → position + swap
Combination → start + path
```

Do not force the permutation template into combinations.

## 12. Why basic combinations do not need explicit Take/Not-Take

Take/Not-Take can express choices:

```text
TAKE
  ↓
recurse

NOT TAKE
  ↓
recurse
```

But for generating combinations, the loop already represents the choice space:

```text
for i = start ... n
```

So the cleaner structure is:

```text
choose i
→ recurse i+1
→ undo
```

## 13. Relation to Take/Not-Take

Conceptually combinations still involve include/exclude choices.

The loop compresses repeated skip decisions into:

```java
for (int i = start; i <= n; i++)
```

So both are recursion/backtracking, but with different state representations.

## 14. Tail-recursion doubt

Basic combination backtracking is normally **not tail recursion**:

```java
path.add(i);
solve(...);
path.remove(path.size() - 1);
```

The recursive call is not the final operation because undo is required after it returns.

The same is true for in-place permutation:

```java
swap(...);
solve(...);
swap(...);
```

Do not force backtracking into tail recursion.

The important concept is state management and restoration.

## 15. `start` vs permutation `idx`

### Permutation

```text
idx = position currently being fixed
```

Example:

```text
idx=2 → position 2
idx=1 → position 1
idx=0 → position 0
```

### Combination

```text
start = smallest candidate currently allowed
```

Example:

```text
start=1 → 1..n
start=2 → 2..n
start=4 → 4..n
```

This distinction prevents many recursion mistakes.

## 16. Set in combinations

Basic combinations from `1..n` do not need a Set because:

```text
candidates are unique
+
start/i+1 prevents repeated orderings
```

A Set may become relevant when input values contain duplicates and unique combinations are required.

## 17. `while` and combinations

The adjacent-duplicate `while` idea is useful when:

```text
input contains duplicates
+
input is sorted
+
equal candidates are adjacent
+
we need to skip duplicate choices at the same depth
```

Classic example:

```text
Combination Sum II
```

Do not add `while` automatically. First identify the invariant:

```text
Are duplicates adjacent?
Do I need to skip a duplicate candidate at this level?
```

## 18. Same-level duplicate pruning

For a sorted input such as:

```text
[1,1,2]
```

if at the same recursion level `1` has already been chosen as the first candidate, choosing the next adjacent `1` would repeat the branch.

Typical logic in such problems is conceptually:

```text
if i > start AND nums[i] == nums[i-1]
    skip
```

or an equivalent duplicate-run skip.

Important:

```text
same level → duplicate candidate can be skipped
deeper level → same value may be allowed
```

## 19. Path add/remove vs swap

### Combination

```text
path.add(i)
→ recurse
→ path.remove(last)
```

### Permutation

```text
swap(i, idx)
→ recurse
→ swap(i, idx)
```

Both are:

```text
CHOOSE
→ MODIFY
→ RECURSE
→ UNDO
```

## 20. How to recognize a new combination problem

Ask:

```text
1. Does order NOT matter?
2. Do I need combinations/subsets of choices?
3. What is my current path?
4. What is my start boundary?
5. Can I only move forward?
6. What is the stopping condition?
7. Is completion based on path.size()?
8. Are duplicate input values possible?
9. If yes, are duplicates adjacent because the input is sorted?
10. What must I undo after recursion?
```

Then derive:

```text
start
→ for each candidate
→ add
→ recurse(i+1)
→ remove
```

## 21. Interview explanation

> Because order does not matter, I maintain a `start` boundary so that after choosing a number I only consider larger candidates. I add the chosen number to the path, recurse from `i+1`, and remove it after returning. When the path contains `k` elements, I copy it into the answer.

## 22. Complexity

For generating all `k`-combinations from `n` elements:

```text
Number of results = C(n,k)
```

Output-sensitive time:

```text
O(k × C(n,k))
```

Auxiliary recursion/path space:

```text
O(k)
```

Output space:

```text
O(k × C(n,k))
```

## 23. Permutation vs Combination

| Feature | Permutation | Combination |
|---|---|---|
| Order | Matters | Does not matter |
| Main state | Position `idx` | `start` boundary |
| Typical state change | `swap` | `path.add` |
| Undo | `swap back` | `remove last` |
| Backward selection | allowed by design | not allowed |
| Duplicate pruning | same-level `Set` when needed | sorted same-level skip when needed |
| Example | `[1,2]`, `[2,1]` both | only one of them |

## 24. One-line recognition rule

```text
ORDER MATTERS
→ PERMUTATION
→ position + swap + recurse + swap back
```

```text
ORDER DOES NOT MATTER
→ COMBINATION
→ start + add + recurse(i+1) + remove
```

## 25. Universal rule across both

Both are backtracking:

```text
STATE
 ↓
CHOICE
 ↓
MODIFY
 ↓
RECURSE
 ↓
UNDO
```

The state representation changes:

```text
Permutation → current position + in-place swap
Combination → start boundary + path add/remove
```

That is the transferable skill.

---

# 29. IMPORTANT BUG TO AVOID — `start + 1` vs `idx + 1`

This is one of the most important combination-recursion details.

Consider:

```java
for (int idx = start; idx <= n; idx++) {

    path.add(idx);

    solve(n, k, idx + 1, ans, path);

    path.remove(path.size() - 1);
}
```

The recursive call must use:

```java
idx + 1
```

NOT:

```java
start + 1
```

## Why?

`start` is the beginning of the current level.

`idx` is the **actual candidate we just chose**.

Therefore the next recursion must begin after the chosen candidate.

```text
start
  ↓
try idx
  ↓
choose idx
  ↓
next start = idx + 1
```

Example:

```text
n = 4
k = 2

start = 1
```

At the root:

```text
idx = 1
idx = 2
idx = 3
idx = 4
```

Suppose:

```text
idx = 3
```

is chosen.

Then:

```text
path = [3]
```

The next valid candidates are:

```text
4
```

So:

```text
next start = 4
```

which is:

```java
idx + 1
```

NOT:

```java
start + 1
```

because:

```text
start + 1 = 2
```

would incorrectly allow:

```text
[3,2]
```

which is not a new combination; it is the same unordered choice as `[2,3]`.

## Mental model

```text
start = where THIS LEVEL begins searching

idx = candidate THIS ITERATION chooses

after choosing idx:

next start = idx + 1
```

### Remember

```text
FOR:
    idx = start ... n

CHOOSE:
    idx

RECURSE:
    idx + 1

UNDO:
    remove last
```

This is the correct combination state transition.
