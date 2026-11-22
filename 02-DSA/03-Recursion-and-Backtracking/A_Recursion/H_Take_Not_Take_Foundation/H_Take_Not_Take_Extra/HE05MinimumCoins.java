package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE05MinimumCoins {
    public static int solve(int[] coins, int amt, int idx) {
        // Amount successfully created.
        if (amt == 0) {
            return 0;
        }
        // No valid solution.
        if (amt < 0 || idx >= coins.length) {
            return Integer.MAX_VALUE;
        }
        // TAKE:
        // Use current coin.
        // Same idx because the coin can be reused.
        int take = Integer.MAX_VALUE;
        int result = solve(coins, amt - coins[idx], idx);
        if (result != Integer.MAX_VALUE) {
            take = result + 1;
        }
        // NOT-TAKE:
        // Skip the current coin.
        int notTake = solve(coins, amt, idx + 1);
        return Math.min(take, notTake);
    }

    public static int solve(int[] coins, int amt) {
        if (amt == 0) {
            return 0;
        }
        if (amt < 0) {
            return Integer.MAX_VALUE;
        }
        int mini = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = solve(coins, amt - coin);

            if (res != Integer.MAX_VALUE) {
                mini = Math.min(res + 1, mini);
            }
        }
        return mini;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int amt = 10;

        int ans = solve(coins, amt, 0);

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);
        //=================================
        int[] coins_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int amt_1 = 10;

        int ans_1 = solve(coins_1, amt_1);
        if (ans_1 == Integer.MAX_VALUE) {
            ans_1 = -1;
        }
        System.out.println(ans_1);
    }
}
/*
===========================================================
HE05 — MINIMUM COINS
NO-LOOP TAKE / NOT-TAKE VERSION
RECURSION TREE + DRY RUN
===========================================================

INPUT:

coins = [1, 2, 3]
amount = 4

Call:

solve(coins, 4, 0)

idx = 0
coins[0] = 1


===========================================================
CORE RULE
===========================================================

TAKE:

    use coins[idx]

    amount = amount - coins[idx]

    idx stays SAME

    because the coin can be reused.


NOT-TAKE:

    skip coins[idx]

    amount stays SAME

    idx = idx + 1


Then:

    Math.min(take, notTake)


===========================================================
RECURSION TREE
===========================================================

                         solve(4, idx=0)
                         coin = 1
                        /               \
                    TAKE              NOT-TAKE
                      |                    |
                 solve(3,0)           solve(4,1)
                 coin = 1             coin = 2
                  /    \               /      \
               TAKE   NOT-TAKE      TAKE    NOT-TAKE
                 |        |            |        |
             solve(2,0) solve(3,1) solve(2,1) solve(4,2)


Continue:

solve(2,0)
   /       \
TAKE      NOT-TAKE
 |            |
solve(1,0)   solve(2,1)


solve(3,1)
   /       \
TAKE      NOT-TAKE
 |            |
solve(1,1)   solve(3,2)


solve(2,1)
   /       \
TAKE      NOT-TAKE
 |            |
solve(0,1)   solve(2,2)


===========================================================
MOST IMPORTANT PATH — USING COIN 1
===========================================================

Start:

solve(4,0)


TAKE coin 1:

4 - 1 = 3

idx stays 0

        ↓

solve(3,0)


TAKE coin 1:

3 - 1 = 2

idx stays 0

        ↓

solve(2,0)


TAKE coin 1:

2 - 1 = 1

idx stays 0

        ↓

solve(1,0)


TAKE coin 1:

1 - 1 = 0

idx stays 0

        ↓

solve(0,0)


BASE CASE:

amount == 0

return 0


Now return upward.


solve(1,0):

take = 0 + 1

take = 1


So:

solve(1,0) = 1


solve(2,0):

take = 1 + 1

take = 2


solve(2,0) can also explore
NOT-TAKE, but continue later.


solve(3,0):

using three 1-coins:

1 + 1 + 1

= 3 coins


solve(4,0):

using four 1-coins:

1 + 1 + 1 + 1

= 4 coins


===========================================================
NOW THE IMPORTANT NOT-TAKE BRANCH
===========================================================

At:

solve(4,0)


NOT-TAKE coin 1:

amount stays 4

idx becomes 1

        ↓

solve(4,1)


Now:

coins[1] = 2


===========================================================
TAKE COIN 2
===========================================================

solve(4,1)

TAKE:

4 - 2 = 2

idx stays 1

        ↓

solve(2,1)


Again:

TAKE coin 2:

2 - 2 = 0

idx stays 1

        ↓

solve(0,1)


BASE CASE:

return 0


Return upward:

solve(2,1):

take = 0 + 1

= 1


This means:

    amount 2
    can be made using ONE coin 2.


Now:

solve(4,1):

take = 1 + 1

= 2


This represents:

    2 + 2 = 4

Number of coins:

    2


===========================================================
COMPARE AT ROOT
===========================================================

From the coin 1 TAKE branch:

    1 + 1 + 1 + 1

    = 4 coins


From the coin 1 NOT-TAKE
→ coin 2 TAKE branch:

    2 + 2

    = 2 coins


Therefore:

    Math.min(4, 2)

    = 2


There are more branches using coin 3,
and they are also checked.


===========================================================
COIN 3 BRANCH
===========================================================

From:

solve(4,1)

NOT-TAKE coin 2:

        ↓

solve(4,2)


Now:

coins[2] = 3


TAKE:

4 - 3 = 1

        ↓

solve(1,2)


But:

coin 3 > amount 1

So TAKE is impossible.


NOT-TAKE:

        ↓

solve(4,3)


idx >= coins.length

return Integer.MAX_VALUE


Therefore this path cannot make 4
using only coin 3.


===========================================================
COMPLETE IMPORTANT TREE
===========================================================

                         solve(4,0)
                        /          \
                     TAKE        NOT-TAKE
                      1             skip 1
                      |                |
                  solve(3,0)       solve(4,1)
                  /      \          /       \
               TAKE    NOT       TAKE      NOT
                1        1         2         2
                |        |         |          |
            solve(2,0) solve(3,1) solve(2,1) solve(4,2)
              /  \       /  \       /  \       /  \
             1    N     2    N     2    N     3    N
             |          |          |          |
         solve(1,0) solve(1,1) solve(0,1) solve(1,2)
             |
          solve(0,0)


The successful optimal path is:

    solve(4,0)
         |
      NOT-TAKE 1
         |
      solve(4,1)
         |
       TAKE 2
         |
      solve(2,1)
         |
       TAKE 2
         |
      solve(0,1)
         |
        0


So:

    2 + 2 = 4

using:

    2 coins


===========================================================
WHY SAME idx ON TAKE?
===========================================================

This is the most important part.

At:

    solve(4,1)

we TAKE coin 2.

Remaining:

    4 - 2 = 2

We call:

    solve(2,1)

NOT:

    solve(2,2)


Why?

Because coin 2 can be reused.


Then:

    solve(2,1)

TAKE coin 2 again.

Remaining:

    2 - 2 = 0


Therefore:

    2 + 2 = 4


===========================================================
WHY idx + 1 ON NOT-TAKE?
===========================================================

Suppose:

    solve(4,0)

and we don't want coin 1.

We move to:

    idx + 1

Therefore:

    solve(4,1)


Now we start considering coin 2.


So:

NOT-TAKE:

    idx + 1


===========================================================
BASE CASES
===========================================================

amount == 0:

    return 0

Meaning:

    ZERO more coins are needed.


amount < 0:

    return Integer.MAX_VALUE

Meaning:

    INVALID PATH.


idx >= coins.length:

    return Integer.MAX_VALUE

Meaning:

    No coins remain and amount is still > 0.


===========================================================
FINAL ANSWER
===========================================================

coins = [1,2,3]
amount = 4


Possible valid solutions:

    1 + 1 + 1 + 1
    → 4 coins

    1 + 1 + 2
    → 3 coins

    2 + 2
    → 2 coins

    1 + 3
    → 2 coins


Minimum:

    2


Therefore:

    solve(4,0) = 2


===========================================================
TC / SC
===========================================================

TC = O(2^A) approximately

SC = O(A)

where A = amount.

The recursion can repeatedly TAKE the same coin,
so the depth can reach approximately A
when the smallest coin is 1.


===========================================================
CORE PATTERN
===========================================================

                  CURRENT COIN
                 /            \
              TAKE          NOT-TAKE
                |                |
        amount - coin           amount
          SAME idx             idx + 1
                |                |
             recurse          recurse
                 \              /
                  Math.min()
*/

/*
===========================================================
HE05 — MINIMUM COINS
RECURSION TREE + COMPLETE DRY RUN
===========================================================

INPUT:

coins = {1,2,3,4,5,6,7,8,9,10}
amount = 10


GOAL:

Find the MINIMUM number of coins needed
to make amount = 10.


===========================================================
CORE IDEA
===========================================================

For every coin:

    remaining = amount - coin

    solve(remaining)

    + 1
      ↑
      because we used ONE coin


Then:

    mini = Math.min(mini, result + 1)


===========================================================
BASE CASE 1
===========================================================

amt == 0

return 0


Meaning:

    The required amount has already been created.

    We need ZERO MORE coins.


Example:

    solve(0)

    → return 0


===========================================================
BASE CASE 2
===========================================================

amt < 0

return Integer.MAX_VALUE


Meaning:

    We went beyond the required amount.

    This path is INVALID.


===========================================================
IMPORTANT: WHY +1?
===========================================================

Suppose:

    amount = 10
    coin = 10

We use ONE coin:

    10

Remaining:

    10 - 10 = 0

Then:

    solve(0) = 0


But we already used coin 10.

Therefore:

    0 + 1 = 1


So:

    total coins = 1


===========================================================
RECURSION TREE — IMPORTANT BRANCHES
===========================================================


                         solve(10)
                             |
       -------------------------------------------------
       |             |             |                |
    coin=1        coin=2        coin=5           coin=10
       |             |             |                |
    solve(9)      solve(8)      solve(5)         solve(0)
                                                     |
                                                  return 0
                                                     |
                                               + 1 coin used
                                                     |
                                                   = 1


The root tries EVERY coin.


===========================================================
COIN = 10 BRANCH
===========================================================

                         solve(10)
                             |
                         choose 10
                             |
                             ↓
                         solve(0)
                             |
                         BASE CASE
                             |
                         return 0
                             |
                         + 1
                             |
                             ↓
                           1


Therefore:

    coin 10 gives:

    1 coin


Combination:

    [10]


===========================================================
COIN = 2 BRANCH
===========================================================

Now let's follow your question:

"What happens if we use coin 2?"


                         solve(10)
                             |
                         choose 2
                             |
                             ↓
                         solve(8)
                             |
                         choose 2
                             |
                             ↓
                         solve(6)
                             |
                         choose 2
                             |
                             ↓
                         solve(4)
                             |
                         choose 2
                             |
                             ↓
                         solve(2)
                             |
                         choose 2
                             |
                             ↓
                         solve(0)
                             |
                         BASE CASE
                             |
                         return 0


Now count the coins used:

    2
    +
    2
    +
    2
    +
    2
    +
    2

    = 10


Number of coins:

    5


So the recursive calculation is:


solve(0)
    = 0

solve(2)
    = 0 + 1
    = 1

solve(4)
    = 1 + 1
    = 2

solve(6)
    = 2 + 1
    = 3

solve(8)
    = 3 + 1
    = 4

solve(10)
    = 4 + 1
    = 5


Therefore:

    using only coin 2

    → 5 coins


===========================================================
COMPARE COIN 2 AND COIN 10
===========================================================


COIN 2:

10
↓
8
↓
6
↓
4
↓
2
↓
0

Coins used:

2 + 2 + 2 + 2 + 2

= 5 coins


COIN 10:

10
↓
0

Coins used:

10

= 1 coin


Therefore:

    Math.min(5, 1)

    = 1


===========================================================
ANOTHER BRANCH — COIN 5
===========================================================


solve(10)
    |
    | choose 5
    ↓
solve(5)
    |
    | choose 5
    ↓
solve(0)


Therefore:

    5 + 5 = 10

Coins used:

    2


So:

    coin 5 branch = 2


===========================================================
ANOTHER BRANCH — COIN 3
===========================================================


One possible path:

10
↓
7
↓
4
↓
1
↓
-2


At:

    solve(-2)

we return:

    Integer.MAX_VALUE


This path is invalid.


But another path can work:

10
↓
7
↓
4
↓
1
↓
0

For example:

    3 + 3 + 3 + 1

= 10

Coins used:

    4


So coin 3 can produce a valid solution,
but it is worse than coin 10.


===========================================================
ROOT'S MINI VALUE
===========================================================

The root tries:

coin 1
    ↓
some valid minimum

coin 2
    ↓
5

coin 3
    ↓
some valid minimum

coin 4
    ↓
some valid minimum

coin 5
    ↓
2

...

coin 10
    ↓
1


The important part:

    mini keeps the SMALLEST result.


Eventually:

    mini = 1


===========================================================
VISUAL COMPARISON
===========================================================


                  AMOUNT = 10
                       |
        +--------------+--------------+
        |              |              |
      coin 2         coin 5        coin 10
        |              |              |
        ↓              ↓              ↓
       8              5              0
        |              |              |
       6               0            DONE
        |              |
       4               |
        |              |
       2               |
        |              |
       0               |
        |              |
      DONE            DONE


coin 2:

    2 + 2 + 2 + 2 + 2
    = 5 coins


coin 5:

    5 + 5
    = 2 coins


coin 10:

    10
    = 1 coin


Therefore:

    minimum = 1


===========================================================
WHY solve(0) RETURNS 0
===========================================================

This is VERY important.

Do NOT think:

    solve(0) = answer

Instead:

    solve(0)
        ↓
    "How many MORE coins do I need?"
        ↓
    ZERO

Then the parent adds the coin it just used:

    solve(0) + 1

    = 0 + 1

    = 1


So:

    solve(0) = 0

does NOT mean the final answer is zero.


===========================================================
FULL LOGIC
===========================================================

For amount > 0:

    try every coin

        ↓

    amount - coin

        ↓

    recursively find minimum
    coins for remaining amount

        ↓

    + 1 for current coin

        ↓

    Math.min()


===========================================================
TC / SC
===========================================================

TC = O(N^A)

where:

    N = number of coins
    A = target amount

SC = O(A)

Maximum recursion depth is approximately A
when the smallest coin is 1.


===========================================================
FINAL ANSWER FOR YOUR INPUT
===========================================================

coins = {1,2,3,4,5,6,7,8,9,10}

amount = 10


Best:

    [10]

Number of coins:

    1


OUTPUT:

    1
*/