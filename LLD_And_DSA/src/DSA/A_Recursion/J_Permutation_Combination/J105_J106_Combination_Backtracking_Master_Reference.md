# J — Combination Backtracking Master Reference
# J105 + J106

> **Important:** J105 and J106 use the same core combination-backtracking pattern in our current track.
> Do not learn them as two unrelated templates.
>
> Master pattern:
>
> ```text
> START
>   ↓
> CHOOSE i
>   ↓
> ADD i
>   ↓
> RECURSE(i + 1)
>   ↓
> REMOVE LAST
>   ↓
> NEXT CHOICE
> ```

---

## 1. J105 vs J106

### J105 — Generate Combinations

Goal:

```text
Generate combinations from 1 ... n
```

Example:

```text
n = 4
k = 2
```

Output:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

### J106 — Combinations of Size K

The core recursion is the same:

```text
choose values from 1 ... n
and generate combinations containing k elements
```

So for our learning purposes:

```text
J105
  ↓
learn basic combination backtracking

J106
  ↓
reinforce the SAME pattern
```

### Do NOT memorize two separate templates.

Remember one:

```text
path + start
```

with:

```java
for (int i = start; i <= n; i++) {

    path.add(i);

    solve(n, k, i + 1, ans, path);

    path.remove(path.size() - 1);
}
```

---

# 2. Core Difference From Permutation

## Permutation

```text
ORDER MATTERS

[1,2] != [2,1]
```

Typical state:

```text
idx = position being fixed
```

Typical modification:

```text
swap
```

Pattern:

```text
position
  ↓
choose
  ↓
swap
  ↓
recurse
  ↓
swap back
```

## Combination

```text
ORDER DOES NOT MATTER

[1,2] == [2,1]
```

Typical state:

```text
start = smallest allowed candidate
```

Typical modification:

```text
path.add()
```

Pattern:

```text
start
  ↓
choose i
  ↓
add i
  ↓
recurse(i + 1)
  ↓
remove
```

---

# 3. The Most Important State

Combination state:

```text
path
+
start
```

### `path`

Numbers selected so far.

Example:

```text
path = [1,3]
```

### `start`

Smallest number that can be selected next.

Example:

```text
start = 4
```

means:

```text
4,5,6...
```

are the candidates that can be considered.

---

# 4. `start` Does NOT Mean "Current Answer Size"

This caused confusion earlier.

```text
path.size()
```

means:

```text
how many elements have I selected?
```

while:

```text
start
```

means:

```text
where can I start choosing from?
```

They are completely different pieces of state.

---

# 5. Base Case

A combination of size `k` is complete when:

```java
if (path.size() == k) {
    ans.add(new ArrayList<>(path));
    return;
}
```

Why?

Because:

```text
path.size()
=
number of selected elements
```

Therefore:

```text
path.size() == k
→ complete combination
```

Do NOT confuse this with:

```text
start == k
```

---

# 6. Why Copy the Path?

`path` is mutable.

Suppose:

```text
path = [1,2]
```

We store:

```java
ans.add(new ArrayList<>(path));
```

This creates a snapshot.

Later:

```java
path.remove(...)
```

changes the working path, but the stored answer stays:

```text
[1,2]
```

Therefore:

```text
path
→ mutable working state

new ArrayList<>(path)
→ answer snapshot
```

---

# 7. The Core Loop

```java
for (int i = start; i <= n; i++) {

    path.add(i);

    solve(n, k, i + 1, ans, path);

    path.remove(path.size() - 1);
}
```

Read it as:

```text
for every allowed candidate i
    choose i
    add i
    solve the remaining problem
    undo i
```

---

# 8. Why `i + 1`?

This is the most important transition.

Suppose:

```text
n = 4
k = 2
start = 1
```

Choose:

```text
i = 3
```

Then:

```text
path = [3]
```

The next candidate must be:

```text
4
```

Therefore:

```java
solve(..., i + 1, ...);
```

gives:

```text
start = 4
```

NOT:

```text
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

and `[3,2]` is the same unordered combination as `[2,3]`.

### Permanent rule

```text
CURRENT LEVEL:
    start

CURRENT CHOICE:
    i

NEXT LEVEL:
    i + 1
```

---

# 9. Why Combinations Never Go Backward

Because:

```text
[1,2]
```

and:

```text
[2,1]
```

are the same combination.

So we enforce:

```text
next start = i + 1
```

which guarantees:

```text
selected values are strictly increasing
```

Example:

```text
[1]
 ↓
2,3,4

[2]
 ↓
3,4

[3]
 ↓
4
```

---

# 10. Why `add()` and `remove()`?

The state is:

```text
path
```

So:

```text
CHOOSE
  ↓
path.add(i)
  ↓
RECURSE
  ↓
path.remove(last)
```

The `remove()` is the UNDO.

Universal rule:

```text
Whatever you modify
must be restored after recursion.
```

---

# 11. Why Not Swap?

Permutation asks:

> Which element should occupy this position?

So:

```text
swap
```

Combination asks:

> Which elements should I select?

So:

```text
path + start
```

Forcing the permutation swap model into basic combinations makes the state unnecessarily complicated.

---

# 12. Why Not Explicit Take / Not-Take?

Take/Not-Take recursion is valid:

```text
              candidate
              /       \
           TAKE       SKIP
```

But basic combination generation is naturally expressed with a choice loop:

```text
for i = start ... n
    choose i
    recurse
    undo
```

The loop already explores the alternative choices.

So:

```text
Take/Not-Take
→ explicit binary include/exclude choices

Choice-loop combination
→ one loop over all candidate choices
```

Both are recursion patterns, but they represent the choice space differently.

---

# 13. Tail Recursion

This backtracking is normally **not tail recursion**.

Example:

```java
path.add(i);

solve(...);

path.remove(path.size() - 1);
```

The recursive call is not the final operation.

There is still:

```java
path.remove(...)
```

after recursion.

So:

```text
backtracking
≠
tail recursion
```

Do not force tail recursion here.

---

# 14. J105 → J106 Learning Relationship

Treat them like this:

```text
J105
 ↓
Learn the basic combination pattern

    path
    start
    for loop
    add
    recurse(i + 1)
    remove


J106
 ↓
Reinforce the SAME pattern
```

### The important conclusion

There is no reason to memorize:

```text
J105 template

and separately

J106 template
```

Instead memorize one concept:

```text
COMBINATION BACKTRACKING
```

---

# 15. Complete Tree for `n = 4, k = 2`

```text
                         []
             /            |            |            \
            1             2            3             4
          / | \          / \            |
         2  3  4        3   4           4
         |  |  |        |   |           |
       [1,2][1,3][1,4][2,3][2,4]      [3,4]
```

Final:

```text
[1,2]
[1,3]
[1,4]
[2,3]
[2,4]
[3,4]
```

---

# 16. State Visualization

Start:

```text
path = []
start = 1
```

Choose `1`:

```text
path = [1]
start = 2
```

Choose `2`:

```text
path = [1,2]
start = 3
```

Now:

```text
path.size() == k
```

Store:

```text
[1,2]
```

Backtrack:

```text
remove 2
```

State:

```text
path = [1]
```

Next:

```text
choose 3
```

State:

```text
path = [1,3]
```

and so on.

---

# 17. Important J105/J106 Code

```java
public static void solve(
        int n,
        int k,
        int start,
        List<List<Integer>> ans,
        List<Integer> path) {

    // k elements selected
    if (path.size() == k) {
        ans.add(new ArrayList<>(path));
        return;
    }

    // Try every allowed candidate
    for (int i = start; i <= n; i++) {

        // CHOOSE
        path.add(i);

        // RECURSE
        // next candidate must be after i
        solve(n, k, i + 1, ans, path);

        // UNDO
        path.remove(path.size() - 1);
    }
}
```

Initial call:

```java
solve(n, k, 1, ans, new ArrayList<>());
```

---

# 18. Do We Need `boolean[]`?

For basic:

```text
combine(n,k)
```

No.

Why?

Because:

```text
start
+
i + 1
```

already prevents reusing earlier positions in the combination.

We do not need:

```java
boolean[] used
```

for this basic problem.

---

# 19. Do We Need a Set?

For basic:

```text
1 ... n
```

No.

All candidates are unique:

```text
1,2,3,4...
```

And the increasing `start` rule prevents duplicate orderings.

A Set becomes useful when the input itself contains duplicate values and the problem asks for unique combinations.

---

# 20. Where Your `while` Technique Fits

Your earlier duplicate technique:

```java
while (adjacent values are equal) {
    ...
}
```

is a different tool.

It is useful when:

```text
input is sorted
+
duplicates are adjacent
+
we want to skip a duplicate run
```

Examples:

```text
3Sum
4Sum
Combination Sum II
Subsets II
Remove Duplicates from Sorted Array
```

For combination problems with duplicate input, another common form is:

```java
if (i > start && nums[i] == nums[i - 1]) {
    continue;
}
```

The exact duplicate-pruning code depends on the problem.

Do not use a `while` automatically.

First ask:

```text
Are duplicates adjacent?
Are they sorted?
Am I skipping duplicates at the SAME recursion level?
Is the skip safe?
```

---

# 21. Combination With Unique Input vs Basic J105/J106

### J105/J106

Candidates are:

```text
1 ... n
```

No duplicate values.

Therefore:

```text
start
→ i
→ i + 1
```

is enough.

### Unique combination problems

Input might be:

```text
[1,1,2,2]
```

Now duplicate values can produce duplicate combinations.

We need an additional duplicate-pruning rule.

Usually this involves:

```text
sorted input
+
same-level duplicate skip
```

---

# 22. Complexity

Number of combinations:

```text
C(n,k)
=
n! / (k!(n-k)!)
```

Each result has `k` elements.

Output-sensitive time:

```text
O(k × C(n,k))
```

Auxiliary recursion/path:

```text
O(k)
```

Output:

```text
O(k × C(n,k))
```

---

# 23. How to Recognize a NEW Combination Problem

Ask:

```text
1. Does order matter?
```

If NO:

```text
combination candidate
```

Then:

```text
2. Do I need to choose a fixed number of elements?
```

If YES:

```text
path.size() == k
```

Then:

```text
3. Can I prevent repeated ordering by moving forward?
```

If YES:

```text
start
```

Then:

```text
4. What are my choices?
```

```text
i = start ... allowedEnd
```

Then:

```text
5. What is the next recursive state?
```

```text
i + 1
```

Then:

```text
6. What is the undo?
```

```text
remove last
```

This is how you derive the solution instead of memorizing it.

---

# 24. Interview / OA Explanation

A strong explanation:

> "Since order does not matter, I use a start index so that after selecting a value I only consider larger values. I add each candidate to the current path, recursively continue from `i + 1`, and remove it after returning to restore the previous state. When the path contains `k` elements, I copy it into the answer."

---

# 25. Final Mental Model

```text
                         PATH
                           |
                         START
                           |
                    choose candidate i
                           |
                       path.add(i)
                           |
                  path.size() == k?
                     /             \
                   YES              NO
                    |                |
                  STORE          recurse(i+1)
                                    |
                             path.remove(last)
                                    |
                              next candidate
```

---

# 26. Final Memory Card

```text
COMBINATION

ORDER DOES NOT MATTER
        ↓
never go backward
        ↓
use START
        ↓
choose i
        ↓
add i
        ↓
recurse(i + 1)
        ↓
remove i
        ↓
next i
```

Permanent state meaning:

```text
path
→ what I selected

start
→ what I am allowed to select next
```

Permanent transition:

```text
current choice = i
next start = i + 1
```

Permanent undo:

```text
add
→ remove
```

### J105/J106 takeaway

> **J105 and J106 should be treated as one core Combination Backtracking pattern, with J106 reinforcing the same state, transition, and undo logic rather than becoming a separate template.**
