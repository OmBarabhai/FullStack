package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class J101GeneratePermutations {
    public static void swap(int[] nums, int st, int en) {
        int temp = nums[st];
        nums[st] = nums[en];
        nums[en] = temp;
    }
    public static void solve(int[] nums, List<List<Integer>> ans, int idx) {
        if (idx < 0) {
            List<Integer> currOp = new ArrayList<>();
            for (int num : nums) {
                currOp.add(num);
            }
            ans.add(currOp);
            return;
        }
        for (int i = idx; i >= 0; i--) {
            swap(nums, i, idx);
            solve(nums, ans, idx - 1);
            swap(nums, i, idx);
        }
    }
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = {1, 2, 3, 4};
        solve(arr, ans, arr.length - 1);
        System.out.println(ans);
    }
}


/*
===========================================================
J101 — GENERATE PERMUTATIONS
RECURSION TREE + DRY RUN
USING YOUR SWAP APPROACH
===========================================================

INPUT:

nums = [1, 2, 3]


YOUR APPROACH:

solve(nums, idx, ans)

idx means:

    "The position at idx is currently being fixed."


At every call:

    for (int i = idx; i >= 0; i--)

        choose element i
        ↓
        swap(i, idx)
        ↓
        recurse(idx - 1)
        ↓
        swap(i, idx)       ← UNDO


===========================================================
BASE CASE
===========================================================

if (idx < 0)

All positions have been fixed.

Therefore:

    copy nums
    add it to ans

Example:

    [1,2,3]

is copied into the answer.


===========================================================
IMPORTANT IDEA
===========================================================

You are fixing positions:

    idx = 2
       ↓
    fix position 2

    idx = 1
       ↓
    fix position 1

    idx = 0
       ↓
    fix position 0

    idx = -1
       ↓
    complete permutation


===========================================================
START
===========================================================

nums = [1,2,3]

solve(nums, 2)


===========================================================
ROOT: idx = 2
===========================================================

We need to fix position 2.

Current array:

    [1,2,3]

Loop:

    i = 2
    i = 1
    i = 0


-----------------------------------------------------------
BRANCH 1
-----------------------------------------------------------

i = 2

swap(2,2)

Array:

    [1,2,3]

Position 2 is now fixed as:

    3


Call:

    solve(nums, 1)


                    [1,2,3]
                        |
                   fix index 2
                        |
                     choose 3
                        |
                    solve(1)


===========================================================
idx = 1
===========================================================

Current:

    [1,2,3]

We need to fix position 1.

Loop:

    i = 1
    i = 0


-----------------------------------------------------------
BRANCH 1.1
-----------------------------------------------------------

i = 1

swap(1,1)

Array:

    [1,2,3]

Position 1 fixed as:

    2


Call:

    solve(0)


-----------------------------------------------------------
idx = 0
-----------------------------------------------------------

Current:

    [1,2,3]

Loop:

    i = 0


swap(0,0)

Array:

    [1,2,3]

Call:

    solve(-1)


-----------------------------------------------------------
BASE CASE
-----------------------------------------------------------

idx < 0

TRUE

Copy:

    [1,2,3]

Add to answer.

Permutation:

    123


Return.

UNDO:

swap(0,0)

Array remains:

    [1,2,3]


Return to idx = 1.

UNDO:

swap(1,1)

Array remains:

    [1,2,3]


-----------------------------------------------------------
BRANCH 1.2
-----------------------------------------------------------

Now at:

    idx = 1

i = 0


swap(0,1)

Array becomes:

    [2,1,3]


Position 1 is now fixed as:

    1


Call:

    solve(0)


-----------------------------------------------------------
idx = 0
-----------------------------------------------------------

i = 0

swap(0,0)

Array:

    [2,1,3]


Call:

    solve(-1)


BASE CASE:

add:

    [2,1,3]

Permutation:

    213


Return.

UNDO:

swap(0,0)

Array:

    [2,1,3]


Return to idx = 1.

UNDO:

swap(0,1)

Array returns to:

    [1,2,3]


===========================================================
END OF ROOT BRANCH i = 2
===========================================================


We found:

    123
    213


===========================================================
ROOT BRANCH 2
===========================================================

Return to:

    solve(nums, 2)

Array is restored:

    [1,2,3]


Now:

    i = 1


swap(1,2)

Array:

    [1,3,2]


Position 2 is now fixed as:

    2


Call:

    solve(1)


===========================================================
idx = 1
===========================================================

Current:

    [1,3,2]


-----------------------------------------------------------
BRANCH 2.1
-----------------------------------------------------------

i = 1

swap(1,1)

Array:

    [1,3,2]


Call:

    solve(0)


Then:

    swap(0,0)

Array:

    [1,3,2]


Base case:

    [1,3,2]

Permutation:

    132


-----------------------------------------------------------
BRANCH 2.2
-----------------------------------------------------------

Back at:

    idx = 1

i = 0


swap(0,1)

Array:

    [3,1,2]


Call:

    solve(0)


Base case gives:

    [3,1,2]

Permutation:

    312


UNDO:

swap(0,1)

Array:

    [1,3,2]


Then return to root.

UNDO root:

swap(1,2)

Array:

    [1,2,3]


===========================================================
ROOT BRANCH 3
===========================================================

Now:

    i = 0


swap(0,2)

Array:

    [3,2,1]


Position 2 fixed as:

    1


Call:

    solve(1)


===========================================================
idx = 1
===========================================================

Current:

    [3,2,1]


-----------------------------------------------------------
BRANCH 3.1
-----------------------------------------------------------

i = 1

swap(1,1)

Array:

    [3,2,1]


Call:

    solve(0)


Base case:

    [3,2,1]

Permutation:

    321


-----------------------------------------------------------
BRANCH 3.2
-----------------------------------------------------------

i = 0

swap(0,1)

Array:

    [2,3,1]


Call:

    solve(0)


Base case:

    [2,3,1]

Permutation:

    231


UNDO:

swap(0,1)

Array:

    [3,2,1]


Return.

UNDO ROOT:

swap(0,2)

Array restored:

    [1,2,3]


===========================================================
COMPLETE RECURSION TREE
===========================================================


                         [1,2,3]
                            |
                      fix index 2
                    /      |      \
                  /       |        \
              choose 3  choose 2   choose 1
                 |          |            |
             [1,2,3]     [1,3,2]      [3,2,1]
                |            |            |
            fix idx 1     fix idx 1    fix idx 1
              /   \         /   \         /   \
             2     1       3     1       2     3
             |     |       |     |       |     |
          [1,2,3][2,1,3] [1,3,2][3,1,2] [3,2,1][2,3,1]
             |     |        |     |      |      |
          fix 0  fix 0    fix 0 fix 0  fix 0  fix 0
             |     |        |     |      |      |
            123   213      132   312    321    231


FINAL PERMUTATIONS:

    123
    213
    132
    312
    321
    231


Order can differ depending on loop direction,
but all 6 permutations are generated.


===========================================================
WHY SWAP?
===========================================================

Suppose:

    nums = [1,2,3]

At:

    idx = 2

If:

    i = 1


We do:

    swap(1,2)


Array:

    [1,3,2]


Now 2 is fixed at position 2.

The remaining positions can be recursively arranged.


So swap means:

    "Choose this element for the current position."


===========================================================
WHY SWAP BACK?
===========================================================

This is the most important backtracking step.

Suppose:

    [1,3,2]

was created by:

    swap(1,2)


After that branch finishes,

we must restore:

    [1,2,3]


Therefore:

    swap(1,2)

again.


So:

    CHOOSE
       ↓
    SWAP
       ↓
    RECURSE
       ↓
    SWAP BACK


===========================================================
WHY NO used[]?
===========================================================

Your approach does not need:

    boolean[] used


because the array itself stores the state.

When an element is swapped into the fixed position,
it is effectively selected.


Example:

    [1,3,2]

means:

    position 2 → 2 is fixed

The remaining prefix:

    [1,3]

is still available for recursion.


===========================================================
YOUR idx DIRECTION
===========================================================

Your code works RIGHT → LEFT.

Start:

    idx = 2

Then:

    idx = 1

Then:

    idx = 0

Then:

    idx = -1


This means:

    current idx = position being fixed


===========================================================
WHY LOOP IS i >= 0
===========================================================

At:

    idx = 2

all elements:

    index 0
    index 1
    index 2

are available.

So:

    i = 2
    i = 1
    i = 0


At:

    idx = 1

only:

    index 0
    index 1

are available.

So:

    i = 1
    i = 0


At:

    idx = 0

only:

    i = 0


This is why:

    for (int i = idx; i >= 0; i--)


===========================================================
TIME COMPLEXITY
===========================================================

Number of permutations:

    N!

For every permutation,
we copy N elements into a list.

Therefore:

    TC = O(N × N!)


===========================================================
SPACE COMPLEXITY
===========================================================

Recursion depth:

    O(N)

Temporary array operations:

    O(1) extra

But the answer itself stores:

    N!

permutations × N elements.

Output space:

    O(N × N!)


Auxiliary recursion space:

    O(N)


===========================================================
CORE J101 PATTERN
===========================================================

                 CURRENT POSITION
                        |
              choose an element
                        |
                     SWAP
                        |
                     RECURSE
                        |
                    SWAP BACK
                        |
                  next choice


MEMORY:

    CHOOSE
       ↓
      SWAP
       ↓
    RECURSE
       ↓
    SWAP BACK


This is the key transition from:

    INCLUDE / EXCLUDE

to:

    TRUE BACKTRACKING
*/