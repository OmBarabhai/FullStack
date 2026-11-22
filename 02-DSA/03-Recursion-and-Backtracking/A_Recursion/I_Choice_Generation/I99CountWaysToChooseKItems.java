package DSA.A_Recursion.I_Choice_Generation;

import java.util.ArrayList;
import java.util.List;

public class I99CountWaysToChooseKItems {
    public static int solve(int n, int idx, int k) {
        if (k == 0) {
            return 1;
        }
        if (idx >= n) {
            return 0;
        }

        int take = solve(n, idx + 1, k - 1);
        int notTake = solve(n, idx + 1, k);

        return take + notTake;
    }
    public static void main(String[] args) {
        System.out.println(solve(4, 0, 2));
    }
}

/*
===========================================================
I99 — COUNT WAYS TO CHOOSE K ITEMS
RECURSION TREE + DRY RUN
===========================================================

INPUT:

n = 4
k = 2

Meaning:

We have 4 items:

    1
    2
    3
    4

We need to choose exactly 2 items.


Possible combinations:

    {1,2}
    {1,3}
    {1,4}
    {2,3}
    {2,4}
    {3,4}

Answer:

    6


===========================================================
RECURSION STATE
===========================================================

solve(n, idx, k)

idx = current item
k   = how many more items we need to select


At every item:

                    current item
                    /          \
                 TAKE        NOT-TAKE
                   |              |
                k - 1            k
                   |              |
              idx + 1         idx + 1


===========================================================
BASE CASE 1
===========================================================

if (k == 0)

    We have successfully selected
    exactly K items.

    return 1


Why 1?

Because this complete path represents
ONE valid combination.


Example:

    selected: {1,3}

    k = 0

    return 1


===========================================================
BASE CASE 2
===========================================================

if (idx >= n)

    We have no items left.

    But k is still greater than 0.

    Therefore we cannot complete the combination.

    return 0


===========================================================
RECURSION TREE
===========================================================

For:

    n = 4
    k = 2


                         solve(0,2)
                         /       \
                     TAKE       NOT-TAKE
                     item 1      item 1
                       |            |
                    (1,1)        (1,2)
                    /   \         /   \
                 TAKE   NOT    TAKE   NOT
                  2       2      2       2
                 /         \    /         \
              (2,0)       (2,1)(2,1)     (2,2)


Important:

First value = idx
Second value = k


===========================================================
DETAILED TREE
===========================================================

Start:

                    (idx=0, k=2)
                     /          \
                  TAKE        NOT-TAKE
                   /              \
             (idx=1,k=1)      (idx=1,k=2)
               /    \            /    \
            TAKE   NOT         TAKE   NOT
             /       \           /       \
        (2,0)       (2,1)     (2,1)     (2,2)


Continue:


(2,0)
  |
  k == 0
  |
 return 1


So:

    TAKE → TAKE

represents selecting:

    item 1
    item 2

Combination:

    {1,2}


-----------------------------------------------------------

(2,1)

We still need 1 item.

TAKE item 3:

    (3,0)

    k == 0

    return 1

This represents:

    {1,3}


NOT-TAKE item 3:

    (3,1)

Now take item 4:

    (4,0)

    k == 0

    return 1

This represents:

    {1,4}


NOT-TAKE item 4:

    (4,1)

    idx >= n

    return 0

There are no more items.


Therefore:

    solve(2,1)

    = 1 + 1

    = 2


These are:

    {1,3}
    {1,4}


===========================================================
DRY RUN — FIRST ROOT BRANCH
===========================================================

Start:

idx = 0
k = 2


TAKE item 1

    idx = 1
    k = 1


TAKE item 2

    idx = 2
    k = 0


BASE:

    k == 0

return 1

This is:

    {1,2}


Backtrack.


NOT-TAKE item 2

    idx = 2
    k = 1


TAKE item 3

    idx = 3
    k = 0

return 1

This is:

    {1,3}


Backtrack.


NOT-TAKE item 3

    idx = 3
    k = 1


TAKE item 4

    idx = 4
    k = 0

return 1

This is:

    {1,4}


Backtrack.


NOT-TAKE item 4

    idx = 4
    k = 1

idx >= n

return 0


Therefore:

    first root branch

    = 1 + 1 + 1

    = 3


Combinations starting with item 1:

    {1,2}
    {1,3}
    {1,4}


===========================================================
SECOND ROOT BRANCH
===========================================================

Now:

NOT-TAKE item 1

idx = 1
k = 2


We still need 2 items.


TAKE item 2:

idx = 2
k = 1


TAKE item 3:

idx = 3
k = 0

return 1

Combination:

    {2,3}


NOT-TAKE item 3:

idx = 3
k = 1


TAKE item 4:

idx = 4
k = 0

return 1

Combination:

    {2,4}


Therefore this branch gives:

    2


Now:

NOT-TAKE item 2

idx = 2
k = 2


Only item 3 and item 4 remain.

But we need 2 items.

TAKE item 3:

idx = 3
k = 1


TAKE item 4:

idx = 4
k = 0

return 1

Combination:

    {3,4}


NOT-TAKE item 4:

idx = 4
k = 1

No items remain.

return 0


So:

    this branch = 1


Therefore:

second root branch:

    2 + 1

    = 3


Combinations:

    {2,3}
    {2,4}
    {3,4}


===========================================================
FINAL CALCULATION
===========================================================

TAKE item 1 branch:

    3


NOT-TAKE item 1 branch:

    3


Therefore:

    3 + 3

    = 6


FINAL ANSWER:

    6


===========================================================
WHY take CHANGES k
===========================================================

Suppose:

    k = 2

and we TAKE an item.

We have selected one item.

So:

    k = 2 - 1

    = 1


Therefore:

    TAKE:

        solve(idx + 1, k - 1)


===========================================================
WHY notTake DOES NOT CHANGE k
===========================================================

Suppose:

    k = 2

and we SKIP the current item.

We have selected nothing.

Therefore:

    k remains 2


So:

    NOT-TAKE:

        solve(idx + 1, k)


===========================================================
WHY idx ALWAYS INCREASES
===========================================================

Each item can be selected only once.

After processing an item:

    idx → idx + 1


So:

    TAKE:

        idx + 1
        k - 1


    NOT-TAKE:

        idx + 1
        k


This guarantees:

    no item is selected twice.


===========================================================
IMPORTANT DIFFERENCE FROM I98
===========================================================

I98:

    At every position:

    choose ANY array element

    → reuse allowed


I99:

    Process items from left to right.

    TAKE current item
    OR
    NOT-TAKE current item

    → each item can be used once.


Therefore I99 is essentially:

    Take / Not-Take

with an additional state:

    k = number of items still needed.


===========================================================
CONNECTION TO nCk
===========================================================

I99 calculates:

    n choose k

For:

    n = 4
    k = 2


    4C2

    = 4! / (2! × 2!)

    = 6


But recursion calculates it
without using the formula:


    solve(n, idx + 1, k - 1)
              +
    solve(n, idx + 1, k)


This is the recursive idea behind:

    nCk


===========================================================
TC / SC
===========================================================

At every item:

    TAKE
    NOT-TAKE

So the recursion tree has:

    O(2^N)

nodes approximately.

TC = O(2^N)

SC = O(N)

Maximum recursion depth:

    N


===========================================================
CORE PATTERN
===========================================================

                    CURRENT ITEM
                         |
                  ┌──────┴──────┐
                  ↓             ↓
                TAKE         NOT-TAKE
                  |             |
             idx + 1        idx + 1
             k - 1             k
                  |             |
               recurse       recurse
                  \              /
                   \           /
                   take + notTake


BASE:

    k == 0
       ↓
      1

    idx == n
       ↓
      0
*/