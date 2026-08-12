package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE06RodCutting {
    public static int solve(int[] prices, int len, int idx) {
        if (len == 0) {
            return 0;
        }
        if (idx >= prices.length) {
            return 0;
        }
        int currCutLen = idx + 1;
        int take = 0;
        if (currCutLen <= len) {
            take = prices[idx] + solve(prices, len - currCutLen, idx);
        }
        int notTake = solve(prices, len, idx + 1);
        return Math.max(take, notTake);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 8};
        int length = 4;
        int idx = 0;
        int ans = solve(prices, length, idx);
        System.out.println(ans);
    }
}

/*
===========================================================
HE06 — ROD CUTTING
RECURSION TREE + DRY RUN
===========================================================

INPUT:

prices = [1, 2, 3, 8]
length = 4

Meaning:

cut length 1 → price 1
cut length 2 → price 2
cut length 3 → price 3
cut length 4 → price 8


===========================================================
CORE IDEA
===========================================================

At every idx:

    cutLength = idx + 1

We have TWO choices:

                    CURRENT CUT
                   /            \
                TAKE          NOT-TAKE
                  |                |
        use this cut length    skip this cut
                  |                |
        len - cutLength         same len
        SAME idx                idx + 1


TAKE:

    prices[idx]
    +
    solve(len - cutLength, idx)

IMPORTANT:

    idx stays SAME

because the same cut length can be reused.


NOT-TAKE:

    solve(len, idx + 1)

Move to the next possible cut length.


Finally:

    Math.max(take, notTake)

because we want MAXIMUM PROFIT.


===========================================================
BASE CASE 1
===========================================================

if (len == 0)

    return 0


Meaning:

    No rod length remains.

    No more profit can be obtained.


===========================================================
BASE CASE 2
===========================================================

if (idx >= prices.length)

    return 0


Meaning:

    No more cut lengths are available.


===========================================================
RECURSION TREE
===========================================================

Input:

length = 4
prices = [1,2,3,8]


                         solve(len=4, idx=0)
                         cutLength = 1
                              /       \
                           TAKE       NOT-TAKE
                            /             \
                  solve(3,0)            solve(4,1)
                  cut = 1               cut = 2
                   /   \                 /    \
                TAKE   NOT           TAKE    NOT
                 /       \             /        \
            solve(2,0) solve(3,1) solve(2,1) solve(4,2)


Remember:

TAKE → same idx
NOT-TAKE → idx + 1


===========================================================
IMPORTANT BRANCH — TAKE CUT LENGTH 4
===========================================================

We eventually reach:

    solve(len=4, idx=3)

Here:

    idx = 3

Therefore:

    cutLength = idx + 1
              = 4


prices[3] = 8


So TAKE is possible:

    4 - 4 = 0


TAKE:

    8 + solve(0,3)


solve(0,3):

    len == 0

    return 0


Therefore:

    take = 8 + 0
         = 8


This represents:

    [length 4]

    profit = 8


===========================================================
DRY RUN — MAIN PATH
===========================================================

START:

    solve(4,0)

idx = 0

cutLength = 1
price = 1


-----------------------------------------------------------
CHOICE 1 — TAKE CUT LENGTH 1
-----------------------------------------------------------

Take a piece of length 1.

Profit:

    +1

Remaining length:

    4 - 1 = 3


Because cut length 1 can be reused:

    idx stays 0


Call:

    solve(3,0)


-----------------------------------------------------------
solve(3,0)
-----------------------------------------------------------

Again:

    cutLength = 1
    price = 1


TAKE:

    1 + solve(2,0)


Again:

    solve(2,0)


TAKE:

    1 + solve(1,0)


Again:

    solve(1,0)


TAKE:

    1 + solve(0,0)


solve(0,0):

    return 0


Therefore:

    solve(1,0)
    = 1 + 0
    = 1


Then:

    solve(2,0)
    = 1 + 1
    = 2


Then:

    solve(3,0)
    = 1 + 2
    = 3


Therefore the path:

    1 + 1 + 1 + 1

gives:

    profit = 4


But this is NOT necessarily the best.


===========================================================
WHY NOT-TAKE EXISTS
===========================================================

At:

    solve(4,0)

NOT-TAKE means:

    "Don't use cut length 1."

So:

    solve(4,1)


Now:

    idx = 1

Therefore:

    cutLength = 2
    price = 2


===========================================================
TAKE CUT LENGTH 2
===========================================================

From:

    solve(4,1)

TAKE:

    price = 2

Remaining length:

    4 - 2 = 2


IMPORTANT:

    idx stays 1

because length 2 can be reused.


Call:

    solve(2,1)


Again:

    cutLength = 2
    price = 2


TAKE:

    2 + solve(0,1)


solve(0,1):

    return 0


Therefore:

    2 + 0 = 2


Going back:

    first cut = 2
    second cut = 2

Total:

    2 + 2 = 4


So this branch gives:

    profit = 4


===========================================================
BUT THEN WE CAN SKIP CUT LENGTH 2
===========================================================

From:

    solve(4,1)

NOT-TAKE:

    solve(4,2)


Now:

    idx = 2

cutLength = 3
price = 3


TAKE:

    3 + solve(1,2)


But:

    remaining length = 1

and:

    cutLength = 3

does NOT fit.

So:

    take = 0


NOT-TAKE:

    solve(4,3)


===========================================================
CUT LENGTH 4
===========================================================

Now:

    idx = 3

cutLength:

    3 + 1 = 4

price:

    prices[3] = 8


TAKE:

    8 + solve(0,3)


solve(0,3):

    return 0


Therefore:

    take = 8


NOT-TAKE:

    solve(4,4)


Now:

    idx >= prices.length

return 0


Therefore:

    notTake = 0


So:

    solve(4,3)

    = Math.max(8,0)

    = 8


===========================================================
GOING BACK UP
===========================================================

At:

    solve(4,2)

We had:

    TAKE cut length 3
        ↓
    impossible to complete with remaining length 1
        ↓
    take = 0


NOT-TAKE:

    solve(4,3)
        ↓
    8


Therefore:

    solve(4,2)

    = Math.max(0,8)

    = 8


At:

    solve(4,1)

We compare:

    TAKE:
        2 + solve(2,1)
        = 2 + 2
        = 4

    NOT-TAKE:
        solve(4,2)
        = 8


Therefore:

    solve(4,1)

    = Math.max(4,8)

    = 8


Finally at the root:

    solve(4,0)


TAKE cut length 1:

    1 + solve(3,0)

    = 1 + 4
    = 4


NOT-TAKE cut length 1:

    solve(4,1)

    = 8


Therefore:

    solve(4,0)

    = Math.max(4,8)

    = 8


===========================================================
FINAL BEST SOLUTION
===========================================================

The best choice is:

    cut length = 4


Price:

    8


So:

    4
    ↓
    price = 8


ANSWER:

    8


===========================================================
SMALL TREE SUMMARY
===========================================================


                         (4,0)
                       /       \
                   TAKE        NOT-TAKE
                  cut 1          (4,1)
                    |            /     \
                  (3,0)       TAKE    NOT-TAKE
                    |          cut 2    (4,2)
                  ...            |        |
                              (2,1)      ...
                                |
                              TAKE
                                |
                              (0,1)
                                |
                                0


From the NOT-TAKE side:

    (4,0)
       ↓
    skip 1
       ↓
    (4,1)
       ↓
    skip 2
       ↓
    (4,2)
       ↓
    skip 3
       ↓
    (4,3)
       ↓
    take 4
       ↓
    (0,3)
       ↓
      0


Profit:

    8 + 0

    = 8


===========================================================
MOST IMPORTANT DIFFERENCE FROM 0/1 KNAPSACK
===========================================================

0/1 Knapsack:

    TAKE
      ↓
    idx + 1

because item can be used only once.


Rod Cutting:

    TAKE
      ↓
    SAME idx

because the same cut length can be used again.


Example:

    cut length = 2

    length = 4


TAKE 2:

    4 - 2 = 2
    idx stays same


TAKE 2 AGAIN:

    2 - 2 = 0


So:

    2 + 2

is allowed.


===========================================================
TC / SC
===========================================================

TC = O(2^N) approximately for this take/not-take
recursive formulation.

SC = O(N)

where N = number of possible cut lengths.

The recursion depth is bounded by the rod length
when repeatedly taking the smallest cut.

===========================================================
CORE PATTERN
===========================================================

                 CUT LENGTH
                     |
              ┌──────┴──────┐
              ↓             ↓
            TAKE         NOT-TAKE
              ↓             ↓
       price[idx]       skip cut
       + recurse           |
              ↓             ↓
         SAME idx        idx + 1
              \             /
               \           /
                 Math.max()
*/