# J — Permutation Backtracking Reference

> Long-term reference for permutation problems: state, in-place swap, undo, duplicate pruning, `Set` vs `boolean[]`, and adjacent-duplicate `while` techniques.

## 1. Core idea

Permutation means **order matters**.

```text
[1,2] != [2,1]
```

For `[1,2,3]`:

```text
123
132
213
231
312
321
```

## 2. In-place swap backtracking

```java
swap(sb, i, idx);
solve(ans, sb, idx - 1);
swap(sb, i, idx);
```

Pattern:

```text
CHOOSE
  ↓
SWAP
  ↓
RECURSE
  ↓
SWAP BACK
  ↓
NEXT CHOICE
```

The same mutable array/StringBuilder is modified and restored.

## 3. What does `idx` mean?

In the right-to-left swap pattern:

```text
idx = position currently being fixed
```

For `ABC`:

```text
idx=2 → fix position 2
idx=1 → fix position 1
idx=0 → fix position 0
idx=-1 → complete permutation
```

## 4. Why `i = idx ... 0`?

At `idx=2`, candidates are `2,1,0`.
At `idx=1`, candidates are `1,0`.
At `idx=0`, candidate is `0`.

So:

```java
for (int i = idx; i >= 0; i--)
```

means: try each still-unfixed element for the current position.

## 5. Why swap?

Example:

```text
ABC
idx=2, i=1
```

`swap(1,2)` gives:

```text
ACB
```

`B` has been selected for position `2`.

Therefore:

```text
SWAP = CHOOSE ELEMENT FOR CURRENT POSITION
```

## 6. Why swap back?

```text
ABC
 ↓ swap(1,2)
ACB
 ↓ recurse
branch finished
 ↓ swap(1,2)
ABC
```

Without the second swap, the next branch starts from the wrong state.

## 7. String vs StringBuilder

`String` is immutable. Use `StringBuilder` for an in-place string permutation.

```java
StringBuilder sb = new StringBuilder(s);
```

Correct swap:

```java
static void swap(StringBuilder sb, int st, int en) {
    char temp = sb.charAt(st);
    sb.setCharAt(st, sb.charAt(en));
    sb.setCharAt(en, temp);
}
```

## 8. Base case

```java
if (idx < 0) {
    ans.add(sb.toString());
    return;
}
```

All positions are fixed, so store a snapshot.

`sb.toString()` matters because `sb` keeps changing during backtracking.

## 9. Unique permutations

J104 adds duplicate pruning.

Question:

> Have I already chosen this **VALUE** at this **same recursion level**?

Use:

```java
Set<Character> unique = new HashSet<>();
```

inside each `solve()` call.

Example `AAB` at the root:

```text
i=2 → B → unique={B}
i=1 → A → unique={B,A}
i=0 → A → A already used → SKIP
```

Final:

```text
AAB
ABA
BAA
```

## 10. Why Set is inside `solve()`

Every recursion level gets a fresh Set:

```text
solve(idx=2) → unique={}
        ↓
solve(idx=1) → unique={}
        ↓
solve(idx=0) → unique={}
```

The Set means only:

> values already chosen as candidates for THIS level.

It does not mean the value can never be used deeper.

## 11. `Set` vs `boolean[]`

### Set

Tracks **values**:

```text
"Have I already chosen this value at this level?"
```

Typical:

```text
Unique Permutations
same-level duplicate pruning
```

### boolean[]

Tracks **elements / indices**:

```text
"Has this element/index been used in the current path?"
```

Typical:

```text
Permutation with path + used[]
Arrangement problems
```

Do not substitute one for the other blindly.

## 12. Your `while` duplicate idea

An adjacent-duplicate `while` is a different technique:

```java
while (i + 1 < n && arr[i] == arr[i + 1]) {
    i++;
}
```

Use this when data is sorted/grouped and duplicates are adjacent.

Typical situations:

```text
3Sum
4Sum
Combination Sum II
Subsets II
Remove Duplicates from Sorted Array
```

Mental model:

```text
WHILE → SKIP ADJACENT DUPLICATES
```

For J104, the key is:

```text
same VALUE + same recursion level → Set
```

## 13. In-place vs path-based permutation

### In-place

```text
swap
→ recurse
→ swap back
```

### Path + used[]

```text
used[i]=true
path.add(...)
→ recurse
path.remove(last)
used[i]=false
```

Both are backtracking; the state representation differs.

## 14. Universal undo rule

```text
swap(...)       → swap again
path.add(x)     → remove last
used[i]=true    → used[i]=false
visited=true    → visited=false
count++         → count--
```

**Undo exactly what you changed.**

## 15. New-problem checklist

When you see a new permutation problem ask:

```text
1. Does order matter?
2. Do I need every arrangement?
3. What is my current state?
4. What position am I fixing?
5. What candidates can fill it?
6. Are duplicate values present?
7. Are duplicates adjacent because the data is sorted?
8. Do I need same-level duplicate pruning?
9. What do I modify before recursion?
10. What do I undo after recursion?
11. What is the base case?
```

## 16. Interview explanation

> I fix one position at a time. For every candidate, I swap it into the current position, recursively arrange the remaining positions, and swap it back so the next candidate starts from the original state. For duplicates, I keep a Set of values already chosen at the current recursion level.

## 17. Complexity

With `N` distinct elements:

```text
N! permutations
```

Copying each result of length `N` gives approximately:

```text
O(N × N!)
```

Auxiliary recursion:

```text
O(N)
```

Output storage:

```text
O(N × number of generated permutations)
```

## 18. One-line mental model

```text
PERMUTATION

Fix position
  ↓
Choose any available element
  ↓
Swap into position
  ↓
Recurse
  ↓
Swap back
  ↓
Next choice
```

Unique:

```text
same value already used at this level?
  ↓
yes → skip
no  → swap → recurse → swap back
```
