# 00 — Backtracking & Permutation Master Reference

> **Purpose:** This is the reusable reference for the recursion/backtracking problems we are solving.
>
> Use it when you forget:
> - when to use `swap()` vs `add()/remove()`
> - when to use `Set` vs `boolean[]`
> - when to use a `while` loop for duplicates
> - what `idx` means
> - what the recursion state means
> - what must be undone
> - how in-place backtracking works
> - how to derive the code for a NEW problem instead of memorizing it

---

# 1. The Most Important Backtracking Idea

Backtracking is:

```text
STATE
  ↓
CHOOSE
  ↓
MODIFY STATE
  ↓
RECURSE
  ↓
UNDO STATE
  ↓
NEXT CHOICE
```

The question is not:

> "Which template should I memorize?"

The question is:

```text
1. What is my state?
2. What changes when I make a choice?
3. What recursive subproblem remains?
4. What must I restore after recursion?
```

Once these are clear, the implementation usually follows.

---

# 2. In-Place Backtracking — Your Current Pattern

Your permutation code uses:

```java
swap(sb, i, idx);
solve(ans, sb, idx - 1);
swap(sb, i, idx);
```

This is **in-place backtracking**.

The same mutable `StringBuilder` is shared through the recursive calls.

```text
CURRENT STATE
     ↓
  swap / modify
     ↓
   recurse
     ↓
 restore original state
```

## Core pattern

```text
CHOOSE
  ↓
SWAP
  ↓
RECURSE
  ↓
SWAP BACK
```

Example:

```text
ABC
 ↓
swap(1,2)
 ↓
ACB
 ↓
recurse
 ↓
finish branch
 ↓
swap(1,2)
 ↓
ABC
```

The second swap is the **UNDO**.

---

# 3. Why `swap back` Is Mandatory

Suppose:

```text
sb = ABC
```

Choose:

```java
swap(sb, 1, 2);
```

Now:

```text
sb = ACB
```

We recursively explore everything beginning with `ACB`.

After the recursive call returns, we want the next branch to start from:

```text
ABC
```

not:

```text
ACB
```

Therefore:

```java
swap(sb, 1, 2);
```

restores the previous state.

## Mental model

```text
PARENT
  |
  | choose
  ↓
MODIFIED STATE
  |
  | recurse
  ↓
ALL CHILDREN EXPLORED
  |
  | undo
  ↓
ORIGINAL STATE
  |
  ↓
NEXT CHOICE
```

---

# 4. Why You Do NOT Use `removeLast()` in Swap Permutations

Your current permutation approach does NOT build a separate path.

You modify the actual permutation state:

```java
swap(sb, i, idx);
```

Therefore the undo is:

```java
swap(sb, i, idx);
```

You do **not** do:

```java
removeLast();
```

because nothing was appended as the state-changing operation.

---

# 5. Path / List Backtracking

A different backtracking style is:

```java
path.add(arr[i]);

solve(...);

path.remove(path.size() - 1);
```

Here the state is a separate `path`.

## Pattern

```text
CHOOSE
  ↓
ADD TO PATH
  ↓
RECURSE
  ↓
REMOVE LAST
```

Example:

```text
path = []

choose 1
↓
path = [1]

recurse

return

remove 1
↓
path = []
```

## Therefore

```text
swap()      → swap back
add()       → remove
```

---

# 6. Universal Undo Table

| State change before recursion | Undo after recursion |
|---|---|
| `swap(a,b)` | `swap(a,b)` again |
| `path.add(x)` | `path.remove(path.size()-1)` |
| `used[i] = true` | `used[i] = false` |
| `visited[r][c] = true` | `visited[r][c] = false` |
| `count++` | `count--` when the count is path state |
| `set.add(x)` | `set.remove(x)` when the set is shared/path state |

The universal rule:

> **Undo exactly what you changed.**

---

# 7. String vs StringBuilder

This was one of your early doubts.

## `String`

```java
String s = "ABC";
```

`String` is immutable.

You can read:

```java
s.charAt(0);
```

but you cannot do:

```java
s.charAt(0) = 'X';   // wrong
```

## `StringBuilder`

```java
StringBuilder sb = new StringBuilder("ABC");
```

`StringBuilder` is mutable.

You can do:

```java
sb.setCharAt(0, 'X');
```

Therefore for in-place string permutation:

```text
String input
    ↓
StringBuilder mutable state
    ↓
swap characters
```

---

# 8. Correct StringBuilder Swap

```java
static void swap(StringBuilder sb, int st, int en) {

    char temp = sb.charAt(st);

    sb.setCharAt(st, sb.charAt(en));

    sb.setCharAt(en, temp);
}
```

## Important bug to avoid

Wrong:

```java
sb.setCharAt(en, sb.charAt(temp));
```

because `temp` is a character, not an index.

Correct:

```java
sb.setCharAt(en, temp);
```

---

# 9. `sb.toString()` at the Base Case

At the base case:

```java
ans.add(sb.toString());
```

Why not store the `StringBuilder` itself?

Because `sb` continues changing during backtracking.

`sb.toString()` creates an immutable snapshot.

Think:

```text
Current mutable state:
    sb = ACB

Store snapshot:
    "ACB"

Then sb may change later,
but "ACB" remains the stored answer.
```

---

# 10. What Does `idx` Mean?

This is one of the most important things to define before writing recursion.

For your J103/J104 style:

```text
idx = position currently being fixed
```

For:

```text
ABC
```

indices are:

```text
index:  0  1  2
value:  A  B  C
```

At:

```text
idx = 2
```

we fix position 2.

Then:

```text
idx = 1
```

we fix position 1.

Then:

```text
idx = 0
```

we fix position 0.

Then:

```text
idx = -1
```

everything is fixed.

---

# 11. The Meaning of a Recursive Call

When we write:

```java
solve(ans, sb, idx);
```

mentally read it as:

> "Generate all valid completions of the current state while fixing positions `0..idx`."

That is more useful than memorizing the function call.

For example:

```text
solve(sb, 2)

means:

position 2 is the next position to fix.
```

---

# 12. Why the Loop Is `i = idx ... 0`

At:

```text
idx = 2
```

all three positions are still available:

```text
i = 2
i = 1
i = 0
```

At:

```text
idx = 1
```

only positions 0 and 1 remain available:

```text
i = 1
i = 0
```

At:

```text
idx = 0
```

only:

```text
i = 0
```

Therefore:

```java
for (int i = idx; i >= 0; i--)
```

means:

> "Try each still-unfixed element as the candidate for the current position."

---

# 13. Full In-Place Permutation Pattern

For normal permutation:

```java
static void solve(StringBuilder sb, List<String> ans, int idx) {

    if (idx < 0) {
        ans.add(sb.toString());
        return;
    }

    for (int i = idx; i >= 0; i--) {

        swap(sb, i, idx);

        solve(ans, sb, idx - 1);

        swap(sb, i, idx);
    }
}
```

The actual meaning:

```text
fix idx
  ↓
try every candidate i
  ↓
swap candidate into idx
  ↓
idx is fixed
  ↓
recurse on idx - 1
  ↓
undo
  ↓
try next candidate
```

---

# 14. Complete Tree for `ABC`

```text
                         ABC
                          |
                       idx = 2
                  /       |       \
               i=2       i=1       i=0
                C         B         A
                |         |         |
               ABC       ACB       CBA
                |         |         |
             idx=1     idx=1     idx=1
             /   \     /   \     /   \
            B     A   C     A   B     C
            |     |   |     |   |     |
           ABC   BAC ACB   CAB CBA   BCA
            |     |   |     |   |     |
          OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT
```

Final:

```text
ABC
BAC
ACB
CAB
CBA
BCA
```

---

# 15. What Is Actually Happening In-Place?

This is extremely important.

There is only one mutable `StringBuilder`.

```text
ABC
```

Root branch:

```text
swap(1,2)
```

becomes:

```text
ACB
```

The recursive call receives the same object.

Then:

```text
swap(0,1)
```

might make:

```text
CAB
```

When that branch returns, we undo:

```text
CAB → ACB
```

Then we return farther upward and undo:

```text
ACB → ABC
```

So the state travels down the tree and comes back up.

```text
ROOT STATE
    ↓
modify
    ↓
CHILD STATE
    ↓
modify
    ↓
DEEPER STATE
    ↓
return
    ↓
restore
    ↓
PARENT STATE
```

That is **in-place backtracking**.

---

# 16. Unique Permutations — New Difficulty

J104 adds duplicate handling.

Normal permutation asks:

> "What can I choose?"

Unique permutation asks:

> "What can I choose, and have I already chosen this same VALUE at this level?"

Therefore:

```text
Permutation
    +
same-level duplicate pruning
```

---

# 17. Why `Set<Character>`?

Example:

```text
AAB
```

At the root:

```text
idx = 2
```

Choices:

```text
i = 2 → B
i = 1 → A
i = 0 → A
```

The two A choices are the same **value choice** for the same recursion level.

Therefore:

```java
Set<Character> unique = new HashSet<>();
```

Track:

```text
values already chosen at this level
```

Example:

```text
i = 2 → B
unique = {B}

i = 1 → A
unique = {B,A}

i = 0 → A
A already present
→ skip
```

---

# 18. The Most Important Meaning of the Set

The Set does NOT mean:

> "This character cannot be used anymore."

It means:

> **"This character has already been used as a choice for this current recursion level."**

That distinction is critical.

---

# 19. Why a New Set at Every Recursion Level?

You write:

```java
Set<Character> unique = new HashSet<>();
```

inside:

```java
solve(...)
```

Therefore:

```text
solve(idx = 2)
    unique = {}

        ↓

solve(idx = 1)
    unique = {}

        ↓

solve(idx = 0)
    unique = {}
```

Every level gets a fresh Set.

This is correct because each level asks:

> "Which values have I already used for THIS position?"

---

# 20. Why a Global Set Is Wrong

A global Set would imply:

```text
A used once
→ A can never be used again
```

That is incorrect for permutations.

For:

```text
AAB
```

the final permutation:

```text
AAB
```

contains A twice.

We only want:

```text
same VALUE
+
same recursion level
→ skip
```

---

# 21. `Set` vs `boolean[]`

This is one of the most important distinctions.

## `Set`

Tracks:

```text
VALUES
```

Question:

> "Have I already chosen this value at this recursion level?"

Example:

```java
Set<Character> unique
```

Typical:

```text
Unique Permutations
same-level duplicate pruning
```

---

## `boolean[]`

Tracks:

```text
ELEMENTS / INDICES
```

Question:

> "Has this element/index already been used in the current path/permutation?"

Example:

```java
boolean[] used
```

Typical:

```text
Permutation implementations
arrangement problems
element-used tracking
```

---

# 22. The Important Difference

```text
Set
 ↓
VALUE
 ↓
same recursion level
 ↓
avoid duplicate branch
```

vs.

```text
boolean[]
 ↓
ELEMENT / INDEX
 ↓
current path
 ↓
avoid reusing the same element
```

Do not replace one with the other blindly.

First identify what the problem is asking you to remember.

---

# 23. Why `boolean[]` Is Common in Other Permutation Code

Another valid permutation pattern is:

```java
boolean[] used
```

For:

```text
[1,2,3]
```

initially:

```text
used = [false,false,false]
```

Choose index 1:

```text
used[1] = true
```

Now that element cannot be chosen again in the same path until we undo:

```text
used[1] = false
```

This is a different representation from your in-place swapping pattern.

---

# 24. In-Place Swap vs `boolean[]`

Both can generate permutations.

## In-place

```text
current array/string is the state
        ↓
swap
        ↓
recurse
        ↓
swap back
```

## `boolean[]` + path

```text
used[] tracks selected elements
        ↓
path.add(...)
        ↓
recurse
        ↓
path.remove(...)
used[i] = false
```

The **backtracking principle is the same**.

Only the state representation is different.

---

# 25. Your `while`-Loop Doubt

You earlier tried something like:

```java
while (idx > 0 && arr[idx - 1] == arr[idx]) {
    idx--;
}
```

This is a valid kind of duplicate-skipping idea in the right context, but it is **not the main duplicate rule for your J104 unique-permutation solution**.

Why?

Because your `while` checks:

```text
adjacent values are equal
```

But J104 needs:

```text
same VALUE already chosen
at THIS recursion level
```

Those are different questions.

---

# 26. When the `while` Technique Is Useful

The `while` idea is especially useful when:

```text
DATA IS SORTED
      ↓
DUPLICATES ARE ADJACENT
      ↓
SKIP THE ENTIRE DUPLICATE RUN
```

Example:

```text
[1,1,1,2,2,3]
```

You can skip:

```text
1 → 1 → 1
```

Typical situations/problems:

```text
3Sum
4Sum
Combination Sum II
Subsets II
Remove Duplicates from Sorted Array
duplicate skipping in sorted two-pointer logic
```

---

# 27. `while` vs `Set`

Do not remember:

```text
while = duplicates
Set  = duplicates
```

Remember the reason.

### `while`

```text
Adjacent / grouped duplicates
usually because of sorted data
```

### `Set`

```text
Repeated VALUE choice
at the SAME recursion level
```

---

# 28. Example Where `while` Is Not Enough

Consider:

```text
[1,2,1]
```

The two 1s are not adjacent.

An adjacent duplicate check cannot directly answer:

> "Have I already chosen value 1 at this level?"

A Set can:

```java
used.contains(1)
```

Therefore:

```text
Adjacent duplicate run → while
Same-level duplicate choice → Set
```

---

# 29. What About `sort()`?

Sorting often appears in duplicate problems.

Why?

Because sorting groups equal values:

```text
[2,1,2,1,1]
```

becomes:

```text
[1,1,1,2,2]
```

Now adjacent duplicate skipping becomes possible.

So sorting is often useful when the duplicate technique depends on adjacency.

But your J104 Set-per-level approach does not depend on adjacent equal values.

---

# 30. `while` Is a Tool, Not a Pattern by Itself

Do not memorize:

> "Love Babbar used a while loop here."

Instead ask:

```text
What am I repeatedly skipping?
Why are those items adjacent?
What invariant makes skipping safe?
```

That reasoning transfers to new problems.

---

# 31. Backtracking With a Path

You will soon see problems where there is no useful in-place swap.

Example:

```text
subsets
subsequences
combination sum
choose K
maze path
```

Then a separate path is often natural:

```text
path.add(choice)
recurse
path.remove(last)
```

The same core idea still applies:

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

# 32. Backtracking With `boolean[][]` / Visited State

For grid problems you may later see:

```java
visited[row][col] = true;

solve(...);

visited[row][col] = false;
```

Same principle again:

```text
MARK
  ↓
RECURSE
  ↓
UNMARK
```

So the pattern generalizes:

```text
swap        → swap back
path.add    → remove
visited=1   → visited=0
used=true   → used=false
```

---

# 33. Backtracking State: The Real Skill

Before writing code, explicitly identify:

```text
STATE
```

Example J104:

```text
StringBuilder sb
idx
same-level used values
```

Then:

```text
CHOICES

i = idx ... 0
```

Then:

```text
VALIDITY

same value already used at this level?
```

Then:

```text
MODIFICATION

swap(sb, i, idx)
```

Then:

```text
RECURSION

idx - 1
```

Then:

```text
UNDO

swap(sb, i, idx)
```

That is the complete derivation.

---

# 34. A Reusable Backtracking Checklist

When seeing a NEW problem, ask these questions in order:

```text
1. What exactly is the STATE?

2. What position/index am I processing?

3. What are my CHOICES?

4. Are all choices always valid?

5. Do I need PRUNING?

6. Are duplicate VALUES possible?

7. Are duplicates adjacent because data is sorted?

8. Am I tracking a VALUE or an ELEMENT/INDEX?

9. Should I use:
      swap
      path
      boolean[]
      Set
      visited

10. What changes before recursion?

11. What must be undone after recursion?

12. What is the BASE CASE?

13. What does the returned state mean?

14. What is the time complexity?

15. Can I derive a variation from the same pattern?
```

---

# 35. The Most Important Rule About Templates

Templates are useful **after understanding**.

Bad learning:

```text
See code
 ↓
memorize code
 ↓
repeat code
```

Good learning:

```text
Understand state
 ↓
Understand choices
 ↓
Understand transition
 ↓
Understand undo
 ↓
Derive code
```

Your goal is:

> **I can rebuild the code when the problem changes.**

---

# 36. J101 → J103 → J104 Pattern Evolution

## J101 — Integer Permutation

```text
array
 ↓
fix idx
 ↓
swap
 ↓
recurse
 ↓
swap back
```

## J103 — String Permutation

Same pattern:

```text
StringBuilder
 ↓
fix idx
 ↓
swap
 ↓
recurse
 ↓
swap back
```

The **data type changed**.

The recursive pattern did not.

## J104 — Unique String Permutation

Add:

```text
same-level duplicate check
 ↓
Set<Character>
```

Therefore:

```text
J101
   ↓
J103
   ↓
J104

SWAP BACKTRACKING
   +
DUPLICATE PRUNING
```

This is exactly how pattern learning should happen.

---

# 37. What You Should Be Able to Say in an Interview

For a permutation problem:

> "I need to fix one position at a time. At each level I can choose any unfixed element. I swap that element into the current position, recursively solve the remaining prefix, and then swap it back to restore the state."

For unique permutations:

> "Because duplicate values may produce the same branch at the same recursion level, I keep a Set of values already chosen for the current level and skip repeated values."

For a path/subset problem:

> "I'm building a separate path, so after recursion I remove the last choice to restore the previous state."

For an element-used problem:

> "I need to track whether an individual element/index has already been used, so a boolean array is appropriate."

That is much stronger than reciting code.

---

# 38. The One Big Picture

```text
                         BACKTRACKING
                              |
                    ----------------------
                    |                    |
               STATE STYLE          DUPLICATE /
                    |                USAGE TRACKING
          ------------------          |
          |                |          |
       IN-PLACE           PATH        |
          |                |          |
        SWAP              ADD         |
          |                |          |
      swap back         remove        |
                                   ----+----
                                   |       |
                                  VALUE   ELEMENT
                                   |       |
                                  Set    boolean[]
```

Duplicate special case:

```text
If duplicates are adjacent/grouped
because of sorting:
        ↓
    while / pointer skip
```

---

# 39. Final Memory Card

```text
┌──────────────────────────────────────────────┐
│           BACKTRACKING QUICK CARD            │
├──────────────────────────────────────────────┤
│                                              │
│ STATE → CHOOSE → MODIFY → RECURSE → UNDO    │
│                                              │
│ swap       → swap back                      │
│ add        → remove                          │
│ true       → false                           │
│                                              │
│ VALUE      → Set                             │
│ ELEMENT    → boolean[]                       │
│                                              │
│ adjacent duplicate run → while              │
│ same-level duplicate VALUE → Set             │
│                                              │
│ in-place permutation → StringBuilder/array  │
│ path-based recursion → List/path             │
│                                              │
│ Always ask:                                  │
│ 1. What is my state?                         │
│ 2. What are my choices?                     │
│ 3. What changes?                             │
│ 4. What must be restored?                   │
│ 5. What is the base case?                   │
│                                              │
└──────────────────────────────────────────────┘
```

---

# 40. Final One-Line Principle

> **Backtracking = Make a choice → explore it → restore the state → try the next choice.**

The implementation technique (`swap`, `add/remove`, `Set`, `boolean[]`, `while`) is chosen **after you understand what the state and choice actually mean**.
