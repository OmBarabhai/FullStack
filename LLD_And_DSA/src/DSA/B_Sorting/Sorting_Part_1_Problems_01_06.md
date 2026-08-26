# Sorting — Part 1
## Problems 01–06
### Bubble Sort • Selection Sort • Insertion Sort • Recursive Bubble • Recursive Insertion • Recursive Selection

> **Purpose:** Build the foundation for sorting and recursive sorting.
>
> This file focuses on the reasoning needed to derive the code: variable meaning, index/value separation, boundaries, movement direction, active ranges, recursive state, base cases, recursive progress, tracing, and pattern recognition.

---

# 1. Part 1 Map

| # | Problem | Core Pattern |
|---:|---|---|
| 01 | Bubble Sort | Adjacent comparison + repeated passes |
| 02 | Selection Sort | Minimum index + one final swap |
| 03 | Insertion Sort | Shift larger values + insert |
| 04 | Recursive Bubble Sort | One pass + smaller active range |
| 05 | Recursive Insertion Sort | Sort `n-1` + insert last value |
| 06 | Recursive Selection Sort | Fix current position + recurse to next |

The first three establish the iterative algorithms.

The next three show how the same ideas can be expressed recursively.

---

# 2. Core Sorting Thinking

Before coding:

```text
Understand problem
      ↓
Identify pattern
      ↓
Define variables
      ↓
Index or value?
      ↓
Identify active / processed / unprocessed portion
      ↓
Identify pointer direction
      ↓
Define boundaries
      ↓
Design algorithm
      ↓
Code
      ↓
Trace
      ↓
Debug
      ↓
Analyze complexity
      ↓
Try variation
      ↓
Explain in interview
```

For recursive problems, add:

```text
What does each parameter represent?
        ↓
What work happens in this call?
        ↓
What work is delegated to recursion?
        ↓
How does the state progress?
        ↓
When does the problem become trivial?
```

---

# 3. Index vs Value

Keep these two categories separate.

```text
i       → INDEX
j       → INDEX
mini    → INDEX

arr[i]      → VALUE
arr[j]      → VALUE
arr[mini]   → VALUE

temp        → usually VALUE
```

For recursive sorting:

```text
n
```

does not automatically mean index or size.

It may mean:

```text
SIZE
INDEX
LAST ACTIVE INDEX
CURRENT POSITION
ACTIVE BOUNDARY
OTHER STATE
```

So always define:

```text
n = __________________
```

before coding.

---

# 4. Boundary Reasoning

If code accesses:

```java
arr[j + 1]
```

ask:

```text
What is the largest valid j?
```

If:

```text
j--
```

ask:

```text
What happens when j == -1?
```

If code accesses:

```java
arr[j - 1]
```

ask:

```text
What is the minimum valid j?
```

Remember:

```text
array length = number of elements
last valid index = length - 1
```

Example:

```text
length = 5

indexes:
0 1 2 3 4
```

---

# 5. Problem 01 — Bubble Sort

## Core Pattern

```text
Adjacent comparison
        ↓
Adjacent swap
        ↓
Repeat passes
        ↓
Largest unsorted element moves right
```

Core condition:

```java
arr[j] > arr[j + 1]
```

Core swap:

```java
int temp = arr[j];
arr[j] = arr[j + 1];
arr[j + 1] = temp;
```

### Defining identity

> Bubble Sort is recognized by **repeated comparison and swapping of adjacent elements**.

---

## Example

```text
[5, 1, 4, 2, 8]
```

Pass 1:

```text
5 > 1 → [1, 5, 4, 2, 8]
5 > 4 → [1, 4, 5, 2, 8]
5 > 2 → [1, 4, 2, 5, 8]
5 > 8 → no swap
```

End of pass:

```text
[1, 4, 2, 5, 8]
```

The largest element is now fixed at the end.

---

## Loop Roles

### Outer loop

```text
number of passes
```

### Inner loop

```text
adjacent comparisons
```

Because:

```java
arr[j + 1]
```

is accessed, the basic inner boundary must prevent `j + 1` from going outside the array.

---

## Optimized Bubble Sort

```java
for (int i = 0; i < arr.length; i++) {

    boolean swapped = false;

    for (int j = 0; j < arr.length - 1 - i; j++) {

        if (arr[j] > arr[j + 1]) {

            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;

            swapped = true;
        }
    }

    if (!swapped) {
        break;
    }
}
```

Why can the inner range shrink?

```text
after each pass
→ one more largest element is already fixed
```

---

## Complexity

Basic:

```text
Best    O(n²)
Average O(n²)
Worst   O(n²)
Space   O(1)
```

Optimized:

```text
Best    O(n)
Average O(n²)
Worst   O(n²)
Space   O(1)
```

Properties:

```text
In-place → Yes
Stable   → Yes
```

---

## Recognition

```text
adjacent
→ compare
→ swap
→ repeat
```

means:

```text
Bubble Sort
```

---

# 6. Problem 02 — Selection Sort

## Core Pattern

```text
Current position
        ↓
Search remaining portion
        ↓
Find minimum
        ↓
Remember minimum INDEX
        ↓
One final swap
```

Core implementation:

```java
for (int i = 0; i < arr.length; i++) {

    int mini = i;

    for (int j = i + 1; j < arr.length; j++) {

        if (arr[j] < arr[mini]) {
            mini = j;
        }
    }

    int temp = arr[i];
    arr[i] = arr[mini];
    arr[mini] = temp;
}
```

---

## Critical Variable Meaning

```text
mini → INDEX
arr[mini] → VALUE
```

Example:

```java
int mini = 3;
```

means:

```text
current minimum is at index 3
```

Then:

```java
arr[mini]
```

means:

```text
the value at index 3
```

---

## Why `j = i + 1`?

At the beginning of each pass:

```text
positions before i
→ already fixed
```

The current position:

```text
i
```

already provides the initial minimum candidate:

```java
mini = i;
```

Therefore the remaining search begins at:

```text
i + 1
```

---

## Recognition

```text
find minimum
→ remember minimum index
→ swap once
→ advance current position
```

means:

```text
Selection Sort
```

---

## Complexity

```text
Best    O(n²)
Average O(n²)
Worst   O(n²)
Space   O(1)
```

Standard implementation:

```text
In-place → Yes
Stable   → No
```

---

# 7. Problem 03 — Insertion Sort

## Core Pattern

```text
Take current value
        ↓
Save it in temp
        ↓
Move backward through sorted portion
        ↓
Shift larger values RIGHT
        ↓
Insert temp
```

Core structure:

```java
for (int i = 1; i < arr.length; i++) {

    int temp = arr[i];
    int j = i - 1;

    while (j >= 0 && arr[j] > temp) {

        arr[j + 1] = arr[j];
        j--;
    }

    arr[j + 1] = temp;
}
```

---

## Variable Meaning

```text
i    → current element index
temp → current value
j    → backward-moving index
```

---

## Shift Direction

Suppose:

```text
[1, 5, 4]
```

and:

```text
temp = 4
j = 1
```

Since:

```text
5 > 4
```

the larger value must move right.

Therefore:

```text
source      destination
arr[j]  →   arr[j + 1]
```

which gives:

```java
arr[j + 1] = arr[j];
```

After shifting:

```text
[1, 5, 5]
```

Then:

```java
j--;
```

---

## Final Insertion Position

After the shift loop:

```text
j
```

is one position before the insertion position.

Therefore:

```text
insertion position = j + 1
```

and:

```java
arr[j + 1] = temp;
```

---

## Condition Meaning

```java
while (j >= 0 && arr[j] > temp)
```

contains two separate responsibilities:

```text
j >= 0
→ boundary / safe access

arr[j] > temp
→ sorting condition
```

Both must be true.

---

## Complexity

```text
Best    O(n)
Average O(n²)
Worst   O(n²)
Space   O(1)
```

Properties:

```text
In-place → Yes
Stable   → Yes
```

---

## Recognition

```text
take value
→ move backward
→ shift larger values right
→ insert value
```

means:

```text
Insertion Sort
```

---

# 8. Problem 04 — Recursive Bubble Sort

Recursive Bubble Sort keeps the Bubble Sort operation but replaces the repeated outer passes with recursion.

## Core Pattern

```text
Perform one complete Bubble pass
        ↓
Largest active element becomes fixed
        ↓
Reduce active range
        ↓
Recursive call
```

---

## Parameter Meaning

In this state model:

```text
n → active boundary / last active index
```

Example:

```text
n = 4
```

means the current pass is operating on an active range that reaches index `4`.

---

## Current Work vs Recursive Work

### Current call

```text
Perform one complete Bubble pass
```

### Recursive call

```text
Sort the smaller active portion
```

The pass should be understood as one complete unit of work.

---

## Recursive Progress

Example:

```text
n = 4
↓
n = 3
↓
n = 2
↓
n = 1
↓
stop
```

The important idea:

> The recursive state moves toward a smaller remaining problem.

---

## Base-Case Reasoning

Do not memorize a particular condition.

First answer:

```text
What does n mean?
```

Then:

```text
When is the active range already trivially sorted?
```

That answer determines the base case.

---

# 9. Problem 05 — Recursive Insertion Sort

Recursive Insertion Sort changes the order in which the Insertion Sort work is expressed.

## Core Pattern

```text
Sort first n - 1 elements recursively
        ↓
First n - 1 elements are sorted
        ↓
Take arr[n - 1]
        ↓
Insert it into sorted portion
```

---

## Parameter Meaning

In this model:

```text
n → SIZE of the portion being sorted
```

Therefore:

```java
arr[n - 1]
```

is the last element of the current portion.

This is different from the meaning of `n` in Recursive Bubble or Recursive Selection.

---

## Current Work vs Recursive Work

### Recursive work

```text
sort first n - 1 elements
```

### Current work

```text
insert arr[n - 1]
```

This separation makes the recursive design easier to derive.

---

## State Progress

```text
n
↓
n - 1
↓
n - 2
↓
...
```

The recursive problem gets smaller until it reaches the base case.

Then, while returning:

```text
sorted smaller portion
+
current last value
```

is handled by insertion.

---

# 10. Problem 06 — Recursive Selection Sort

Recursive Selection Sort keeps the Selection Sort operation and makes the outer position recursive.

## Core Pattern

```text
Current position n
        ↓
Find minimum in remaining portion
        ↓
Swap minimum with arr[n]
        ↓
Move to next position
        ↓
Recursive call
```

---

## Parameter Meaning

For this state model:

```text
n → CURRENT POSITION being fixed
```

This is different from:

```text
Recursive Bubble
→ active boundary

Recursive Insertion
→ size of current portion
```

---

## Active Range

When:

```text
n = current position
```

think:

```text
positions before n
→ already fixed

position n
→ currently being fixed

positions after n
→ still unsorted
```

Therefore the remaining search begins at:

```text
n + 1
```

---

## Core Structure

```java
static void selectionSortRec(int[] arr, int n) {

    if (n >= arr.length - 1) {
        return;
    }

    int mini = n;

    for (int i = n + 1; i < arr.length; i++) {

        if (arr[i] < arr[mini]) {
            mini = i;
        }
    }

    int temp = arr[n];
    arr[n] = arr[mini];
    arr[mini] = temp;

    selectionSortRec(arr, n + 1);
}
```

---

## Recursive Direction

Because:

```text
n = current position
```

the next state is:

```text
n + 1
```

Therefore:

```text
0 → 1 → 2 → 3 → ...
```

The direction is derived from the state meaning.

Do not memorize:

```text
recursive selection = n + 1
```

without knowing why.

---

## Base Case

Eventually:

```text
n = last index
```

and there is no remaining unsorted position.

Therefore recursion stops.

Again:

```text
state meaning
→ remaining work
→ base case
```

---

# 11. Recursive Sorting Comparison

| Algorithm | Meaning of `n` | Current Work | Recursive Work | State Direction |
|---|---|---|---|---|
| Recursive Bubble | active boundary / last active index | one complete Bubble pass | smaller active range | decreases |
| Recursive Insertion | size of current portion | insert last value | sort first `n-1` | decreases |
| Recursive Selection | current position | find min + swap | next position | increases |

This comparison is one of the most important ideas in Part 1.

The same variable name can represent completely different state.

---

# 12. Current Work vs Recursive Work

Before implementing recursion, explicitly write:

```text
CURRENT WORK:
____________________________

RECURSIVE WORK:
____________________________

NEXT STATE:
____________________________
```

### Recursive Bubble

```text
Current:
one Bubble pass

Recursive:
smaller active range

Next state:
smaller boundary
```

### Recursive Insertion

```text
Current:
insert current last value

Recursive:
sort first n - 1

Next state:
smaller size
```

### Recursive Selection

```text
Current:
find minimum + swap

Recursive:
fix next position

Next state:
n + 1
```

---

# 13. Recursive-State Rules

Before coding any recursive sorting algorithm:

```text
STATE:
____________________________

What does each parameter represent?
____________________________

CURRENT WORK:
____________________________

RECURSIVE WORK:
____________________________

NEXT STATE:
____________________________

BASE CASE:
____________________________
```

If these are unclear, the implementation should not be started yet.

---

# 14. Recursive Progress

A recursive call must make meaningful progress toward completion.

That progress can look different:

```text
Bubble:
n → n - 1

Insertion:
n → n - 1

Selection:
n → n + 1
```

These are all correct because the underlying states are different.

The universal rule is:

> **The remaining problem must become smaller or closer to completion.**

Ask:

```text
What changes after the call?

What becomes smaller?

What moves?

What portion becomes permanently solved?

Will the next call eventually reach the base case?
```

---

# 15. Base-Case Reasoning

For every recursive algorithm:

```text
1. What does the parameter mean?
2. What work remains?
3. When is that work already solved?
4. What happens if recursion continues?
```

The base case should come from those answers.

Do not memorize base cases independently from the state.

---

# 16. Size vs Index vs Boundary

Example:

```text
array = [4, 2, 7, 1, 9]
```

Then:

```text
size = 5
last index = 4
```

But:

```text
n = 4
```

could mean:

```text
last active index
```

or:

```text
current position
```

or something else.

The number itself does not determine its meaning.

The algorithm does.

---

# 17. Off-by-One Reasoning

Understand every `+1` and `-1`.

### `j + 1`

Usually:

```text
next array position
```

### `j - 1`

Usually:

```text
previous array position
```

### `n + 1`

In Recursive Selection here:

```text
next position to fix
```

### `n - 1`

In Recursive Insertion here:

```text
smaller portion size
```

The operation is meaningful only because the state meaning is known.

---

# 18. Comparison / Modification Mapping

Always connect the elements being compared to the elements being changed.

### Bubble

```text
compare:
arr[j], arr[j+1]

modify:
arr[j], arr[j+1]
```

### Selection

```text
find:
mini index

modify:
arr[current], arr[mini]
```

### Insertion

```text
compare:
arr[j], temp

modify:
move arr[j] to arr[j+1]

then:
place temp
```

---

# 19. Shift Direction

Insertion Sort:

```text
larger value
    ↓
move RIGHT
```

Therefore:

```java
arr[j + 1] = arr[j];
```

Visual:

```text
[1, 5, 4]
    ↑  ↑
    j temp

5 → right

[1, 5, 5]
```

Then:

```text
j--
```

and the search continues.

---

# 20. Manual Tracing

## Bubble

Track:

```text
i
j
arr[j]
arr[j+1]
comparison
swap
array
```

## Selection

Track:

```text
i / n
mini
scan index
candidate value
minimum value
minimum update
swap
array
```

## Insertion

Track:

```text
i
temp
j
arr[j]
comparison
shift
j--
insertion position
array
```

## Recursive Bubble

Track:

```text
n
current pass
i
comparison
swap
array
next n
```

## Recursive Insertion

Track:

```text
n
recursive depth
temp
j
shift
j--
insertion
return
```

## Recursive Selection

Track:

```text
n
mini
scan index
comparison
minimum update
swap
next n
return
```

Do not assume a trace is understood just because the final array is correct.

The state changes should be explainable.

---

# 21. Complexity

| Algorithm | Best | Average | Worst | Extra Space |
|---|---:|---:|---:|---:|
| Bubble | O(n²) basic / O(n) optimized | O(n²) | O(n²) | O(1) |
| Selection | O(n²) | O(n²) | O(n²) | O(1) |
| Insertion | O(n) | O(n²) | O(n²) | O(1) |
| Recursive Bubble | O(n²) | O(n²) | O(n²) | recursion stack |
| Recursive Insertion | O(n) | O(n²) | O(n²) | recursion stack |
| Recursive Selection | O(n²) | O(n²) | O(n²) | recursion stack |

For recursive versions, explain:

```text
algorithmic operations
+
call-stack usage
```

rather than memorizing only the final Big-O.

---

# 22. Edge Cases

Test:

```text
[]
[1]
[1, 2, 3]
[3, 2, 1]
[1, 1, 1]
[-3, 5, -1, 0]
[2, 1, 2, 1]
```

For recursive versions:

```text
n = 0
n = 1
n = 2
n = arr.length - 1
n = arr.length
```

The exact valid range depends on what `n` represents.

Ask:

```text
Does recursion stop?

Are indexes valid?

Does the active range make sense?

Does the state progress?
```

---

# 23. Pattern Recognition Test

### Bubble

```text
Adjacent comparison
+
Adjacent swap
+
Repeated passes
```

### Selection

```text
Find minimum
+
Remember minimum index
+
One swap
```

### Insertion

```text
Take current value
+
Shift larger values
+
Insert
```

### Recursive Bubble

```text
One Bubble pass
+
smaller active range
```

### Recursive Insertion

```text
Sort n - 1
+
insert last value
```

### Recursive Selection

```text
Fix current position
+
find minimum
+
swap
+
move to next position
```

---

# 24. Pre-Coding Checklist

Before coding:

```text
[ ] What is the problem asking?
[ ] What algorithm/pattern fits?
[ ] What does every variable represent?
[ ] Index or value?
[ ] What portion is already processed?
[ ] What portion remains?
[ ] Which direction does each pointer move?
[ ] What are the valid boundaries?
[ ] What array access occurs?
[ ] If recursive, what does each parameter mean?
[ ] What is the current work?
[ ] What is the recursive work?
[ ] What is the next state?
[ ] What is the base case?
[ ] How does recursion make progress?
[ ] What is the expected complexity?
```

---

# 25. Post-Coding Checklist

After coding:

```text
[ ] Explain the algorithm without code
[ ] Explain every variable
[ ] Explain every loop
[ ] Explain every condition
[ ] Trace a small example
[ ] Explain boundary handling
[ ] Explain base case
[ ] Explain recursive progress
[ ] Explain current vs recursive work
[ ] State time complexity
[ ] State space complexity
[ ] Test edge cases
[ ] Solve a small variation
[ ] Explain in interview form
```

---

# 26. Hint Ladder

When stuck:

```text
Hint 1 → conceptual direction
Hint 2 → variable/state clue
Hint 3 → pseudocode
Hint 4 → partial skeleton
Hint 5 → exact bug explanation
Full solution → only when needed / explicitly requested
```

After seeing a full solution:

```text
explain it
→ trace it
→ modify it
→ reimplement later
```

---

# 27. Independence Score

```text
0 → could not start
1 → needed complete solution
2 → needed major hints
3 → needed several hints
4 → needed minor hints
5 → solved independently
```

Also track:

```text
attempts
hints
ability to explain
ability to trace
ability to solve a variation
```

A working submission is not automatically mastery.

---

# 28. Mastery Levels

```text
Level 0 — Never attempted
Level 1 — Understands explanation
Level 2 — Can follow code
Level 3 — Can implement with hints
Level 4 — Can implement independently
Level 5 — Can implement + explain + debug
Level 6 — Can solve variations
Level 7 — Interview ready
```

---

# 29. Final Pattern Map

```text
                         SORTING
                            |
          +-----------------+-----------------+
          |                 |                 |
       Bubble            Selection         Insertion
          |                 |                 |
   adjacent swap       minimum index     shift + insert
          |                 |                 |
          +-----------------+-----------------+
                            |
                     RECURSIVE FORMS
                            |
        +-------------------+-------------------+
        |                   |                   |
 Rec. Bubble         Rec. Insertion       Rec. Selection
        |                   |                   |
 one pass +           sort n-1 +           fix current +
 smaller range        insert last          next position
```

---

# 30. The Most Important Comparison

```text
Bubble
→ move larger values right through adjacent swaps

Selection
→ find the smallest remaining value and place it

Insertion
→ shift larger values right and insert the current value
```

Recursive forms:

```text
Recursive Bubble
→ current pass + smaller active boundary

Recursive Insertion
→ smaller sorted portion + current insertion

Recursive Selection
→ current position + next position
```

---

# 31. Final Rules

```text
1. Define every variable before using it.

2. Separate INDEX from VALUE.

3. Define exactly what n means before recursion.

4. Derive n+1 / n-1 from the state meaning.

5. Check boundaries whenever an index moves.

6. In Insertion Sort, larger values move RIGHT.

7. After shifting, insertion occurs at j+1.

8. Bubble = adjacent comparison + adjacent swap.

9. Selection = minimum index + one swap.

10. Insertion = shift + insert.

11. Separate current work from recursive work.

12. Every recursive call must make meaningful progress.

13. Base case comes from the state meaning.

14. Size and last index are different concepts.

15. Trace the state, not only the final output.

16. Explain WHY the algorithm works.

17. Correct code is not the final goal.
    Independent reasoning is.
```

---

## Part 1 Status

```text
01 ✅ Bubble Sort
02 ✅ Selection Sort
03 ✅ Insertion Sort
04 ✅ Recursive Bubble Sort
05 ✅ Recursive Insertion Sort
06 ✅ Recursive Selection Sort
```

**Sorting Part 1 complete — Problems 01–06.**

Next: **Problem 07 — Sort Colors**.
