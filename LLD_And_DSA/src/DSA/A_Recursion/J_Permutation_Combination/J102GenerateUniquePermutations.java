package DSA.A_Recursion.J_Permutation_Combination;

import java.util.*;

public class J102GenerateUniquePermutations {

    // Swap two elements in the array.
    // We use swapping to place a chosen element
    // at the current position (idx).
    public static void swap(int[] arr, int st, int en) {
        int temp = arr[st];
        arr[st] = arr[en];
        arr[en] = temp;
    }

    public static void solve(int[] arr, List<List<Integer>> ans, int idx) {

        // Base case:
        // idx < 0 means every position has been fixed,
        // so the current array is one complete permutation.
        if (idx < 0) {
            List<Integer> op = new ArrayList<>();

            // Copy the current permutation into the answer.
            // We must create a new list because the array
            // will continue changing during backtracking.
            for (int curr : arr) {
                op.add(curr);
            }

            ans.add(op);
            return;
        }

        // A fresh Set is created for THIS recursion level.
        //
        // Its job is:
        // "Have I already used this VALUE for position idx?"
        //
        // It does NOT mean the value cannot be used again
        // in deeper recursion levels.
        Set<Integer> used = new HashSet<>();

        // Try every possible element that can be placed at idx.
        for (int i = idx; i >= 0; i--) {

            // If this value was already chosen at this
            // recursion level, using it again would create
            // a duplicate permutation.
            if (used.contains(arr[i])) {
                continue;
            }

            // Mark this value as used at the CURRENT level.
            used.add(arr[i]);

            // Choose:
            // Put arr[i] into position idx.
            swap(arr, idx, i);

            // Recurse:
            // Position idx is fixed.
            // Now solve the remaining positions.
            solve(arr, ans, idx - 1);

            // Undo:
            // Restore the array so the next choice can
            // start from the previous state.
            swap(arr, idx, i);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        // Start by fixing the last position.
        // Then move toward index 0 recursively.
        int idx = nums.length - 1;

        solve(nums, ans, idx);

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        System.out.println(permuteUnique(arr));
    }
}


/*
===========================================================
J102 — GENERATE UNIQUE PERMUTATIONS
LEETCODE 47
===========================================================

PROBLEM
-------

Generate all UNIQUE permutations of an array
that may contain duplicate values.

Example:

nums = [1,1,2]

Output:

[1,1,2]
[1,2,1]
[2,1,1]


===========================================================
CORE IDEA
===========================================================

This problem is:

    PERMUTATION
        +
    DUPLICATE HANDLING


Normal permutation:

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


Unique permutation adds:

    SAME RECURSION LEVEL
           ↓
    SAME VALUE ALREADY USED?
       ↓            ↓
      YES           NO
       ↓             ↓
     SKIP          CHOOSE


===========================================================
WHAT DOES idx MEAN?
===========================================================

idx means:

    "The position currently being fixed."


Example:

    [1,1,2]

idx = 2

means:

    fix position 2


Then:

    idx = 1

means:

    fix position 1


Then:

    idx = 0

means:

    fix position 0


Then:

    idx = -1

means:

    all positions are fixed.


===========================================================
BASE CASE
===========================================================

if (idx < 0)

All positions have been fixed.

Therefore:

    current array = complete permutation

We copy the array and add it to ans.


===========================================================
WHY DO WE USE SWAPPING?
===========================================================

Suppose:

    arr = [1,2,3]
    idx = 2


If:

    i = 1

we do:

    swap(1,2)

Array becomes:

    [1,3,2]


This means:

    2 has been chosen for position 2.


So:

    SWAP = CHOOSE AN ELEMENT FOR CURRENT POSITION


===========================================================
WHY RECURSE WITH idx - 1?
===========================================================

After position idx is fixed,

we only need to arrange the remaining positions.

So:

    solve(idx - 1)

Example:

    idx = 2
        ↓
    fix position 2
        ↓
    idx = 1
        ↓
    fix position 1
        ↓
    idx = 0
        ↓
    fix position 0


===========================================================
WHY SWAP BACK?
===========================================================

This is the BACKTRACKING step.

Example:

    [1,3,2]

was created using:

    swap(1,2)


After finishing that branch,

we must restore:

    [1,2,3]


Therefore:

    swap(1,2)

again restores the old state.


The complete pattern is:

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


===========================================================
WHY DO WE NEED Set<Integer> used?
===========================================================

The input may contain duplicates.

Example:

    [1,1,2]


At idx = 2:

    i = 2 → value 2
    i = 1 → value 1
    i = 0 → value 1


The two values at:

    i = 1
    i = 0

are the SAME VALUE.

If we process both branches,

we can generate the same permutation more than once.


Therefore we create:

    Set<Integer> used = new HashSet<>();

for EACH recursion level.


===========================================================
IMPORTANT: THE SET IS PER LEVEL
===========================================================

This is extremely important.

Every call:

    solve(..., idx)

creates a NEW Set.

Example:

    idx = 2
    used = {}

then recurse:

    idx = 1
    used = {}

then recurse:

    idx = 0
    used = {}


Why?

Because the Set means:

    "Which VALUES have already been used
     for THIS CURRENT POSITION?"

It does NOT mean:

    "This value can never be used again."


===========================================================
DUPLICATE EXAMPLE
===========================================================

Input:

    [1,1,2]


ROOT:

    idx = 2

Current:

    [1,1,2]


used = {}


Choice:

    i = 2

value:

    2

used:

    {2}


Swap:

    swap(2,2)

Array:

    [1,1,2]


Recurse:

    solve(idx = 1)


-----------------------------------------------------------
idx = 1
-----------------------------------------------------------

New Set:

    used = {}


i = 1

value = 1

used:

    {1}


swap(1,1)

Array:

    [1,1,2]


Recurse:

    solve(idx = 0)


-----------------------------------------------------------
idx = 0
-----------------------------------------------------------

New Set:

    used = {}


i = 0

value = 1

used:

    {1}


swap(0,0)

Array:

    [1,1,2]


Recurse:

    solve(-1)


-----------------------------------------------------------
BASE CASE
-----------------------------------------------------------

Store:

    [1,1,2]


Return.

Undo:

    swap(0,0)


-----------------------------------------------------------
BACK TO idx = 1
-----------------------------------------------------------

Now:

    i = 0

value:

    1


Check:

    used.contains(1)

Result:

    true


Therefore:

    continue;


We DO NOT create this branch.

This avoids choosing value 1 twice
for the same recursion level.


===========================================================
SECOND ROOT CHOICE
===========================================================

Back to:

    idx = 2

Next:

    i = 1

value:

    1


used at root:

    {2}


1 is not present.

So:

    used = {2,1}


Swap:

    swap(2,1)


Array:

    [1,2,1]


Recurse:

    solve(idx = 1)


This produces:

    [1,2,1]


===========================================================
THIRD ROOT CHOICE
===========================================================

Back to root:

    used = {2,1}


Now:

    i = 0

value:

    1


Check:

    used.contains(1)

TRUE


Therefore:

    continue;


This branch is skipped.


===========================================================
FINAL RESULT
===========================================================

For:

    [1,1,2]

we get:

    [1,1,2]
    [1,2,1]
    [2,1,1]


Exactly 3 unique permutations.

===========================================================
J102 — UNIQUE PERMUTATION
Input: [1,1,2]
===========================================================


                           [1,1,2]
                            idx=2
                              |
                  Set at idx=2 = {}
                              |
             +----------------+----------------+
             |                |                |
          i=2 → 2          i=1 → 1          i=0 → 1
             |                |                |
          use {2}          use {2,1}       1 already used
             |                |                |
          SWAP(2,2)        SWAP(1,2)          X
             |                |             SKIP
             ↓                ↓
         [1,1,2]          [1,2,1]
             |                |
           idx=1            idx=1
             |                |
       Set at idx=1 = {}   Set at idx=1 = {}
             |                |
          +--+--+          +--+--+
          |     |           |     |
       i=1→1 i=0→1       i=1→2 i=0→1
          |     |           |     |
       use 1   1 used    use 2   use 1
          |     X           |      |
       SWAP(1,1) SKIP    SWAP(1,1) SWAP(0,1)
          |                 |      |
          ↓                 ↓      ↓
      [1,1,2]           [1,2,1] [2,1,1]
          |                 |      |
        idx=0             idx=0  idx=0
          |                 |      |
       i=0→1             i=0→1  i=0→2
          |                 |      |
          ↓                 ↓      ↓
      [1,1,2]           [1,2,1] [2,1,1]
          |                 |      |
        OUTPUT            OUTPUT OUTPUT

The X means:

    same VALUE was already chosen
    at that recursion level.

                      [1,1,2]
                        |
                      idx=2
                       |
                    Set = {}
                 /     |      \
                /      |       \
             i=2      i=1      i=0
              |         |         |
            value 2   value 1   value 1
              |         |         |
            add 2     add 1     1 already
              |         |       chosen at idx=2
              |         |         |
              |         |         X
              |         |       SKIP
              |         |
          [1,1,2]   [1,2,1]
             |           |
           idx=1       idx=1
             |           |
          Set={}       Set={}
          /   \        /   \
       i=1   i=0    i=1    i=0
        |      |      |      |
        1      1      2      1
        |      X      |      |
        |    duplicate |      |
        |             |      |
     [1,1,2]       [1,2,1] [2,1,1]
        |              |       |
      idx=0          idx=0   idx=0
        |              |       |
      OUTPUT         OUTPUT  OUTPUT
===========================================================
WHY NOT boolean[] used?
===========================================================

For normal permutation generation,

we can use:

    boolean[] used


But this swapping approach already stores
the chosen state directly inside the array.

For UNIQUE permutations,
we additionally need:

    Set<Integer> used


because we are tracking:

    duplicate VALUES chosen at the SAME LEVEL


These are two different ideas.


===========================================================
WHY NOT YOUR WHILE-LOOP?
===========================================================

Your earlier idea was:

    while (idx > 0 && arr[idx - 1] == arr[idx]) {
        idx--;
    }


That checks:

    "Are neighboring values equal?"


But Unique Permutations needs:

    "Have I already chosen this VALUE
     at this recursion level?"


Those are different questions.


Example:

    [1,2,1]


The two 1s are NOT adjacent.

Therefore an adjacent-value while loop
cannot reliably solve the duplicate problem here.


The Set handles:

    used.contains(value)

regardless of where the duplicate occurs.


===========================================================
WHERE IS THE WHILE-LOOP IDEA USEFUL?
===========================================================

Your while-loop idea is still valuable.

It is useful when:

    1. Data is sorted/grouped
    2. Duplicate values become adjacent
    3. We want to skip a whole duplicate run


Typical pattern:

    while (i + 1 < n && arr[i] == arr[i + 1]) {
        i++;
    }


Common problems:

    3Sum
    4Sum
    Combination Sum II
    Subsets II
    Remove Duplicates from Sorted Array
    Duplicate skipping in sorted arrays


Mental model:

    SORTED DATA
         ↓
    DUPLICATES ADJACENT
         ↓
    WHILE
         ↓
    SKIP DUPLICATE RUN


For Unique Permutations:

    SAME LEVEL
         ↓
    SAME VALUE AGAIN?
         ↓
    SET
         ↓
    SKIP


===========================================================
COMPLEXITY
===========================================================

For N distinct elements:

    Number of permutations = N!

Each completed permutation contains N elements.

Therefore output-related complexity is:

    O(N × N!)


For duplicate inputs, the number of unique permutations
is smaller:

    N! / (c1! × c2! × ... × ck!)

where c1, c2, ... are frequencies of repeated values.


Auxiliary recursion space:

    O(N)


The answer itself requires space for all generated
permutations.


===========================================================
CORE PATTERN
===========================================================


             CURRENT POSITION
                    |
                    ↓
              CHOOSE VALUE
                    |
                    ↓
             DUPLICATE HERE?
              /          \
            YES           NO
             |             |
           SKIP           SWAP
                           |
                         RECURSE
                           |
                       SWAP BACK


===========================================================
MEMORY
===========================================================

Normal permutation:

    CHOOSE
      ↓
    SWAP
      ↓
    RECURSE
      ↓
   SWAP BACK


Unique permutation:

    CHOOSE
      ↓
    SAME VALUE USED
    AT THIS LEVEL?
      ↓
    SKIP / SWAP
      ↓
    RECURSE
      ↓
   SWAP BACK


The real pattern is NOT:

    "memorize this code."


The real pattern is:

    1. What position am I fixing?
    2. What choices can fill it?
    3. Are duplicate values present?
    4. Have I already chosen this value
       at this recursion level?
    5. Choose
    6. Recurse
    7. Undo


This is the transferable interview/OA skill.
*/