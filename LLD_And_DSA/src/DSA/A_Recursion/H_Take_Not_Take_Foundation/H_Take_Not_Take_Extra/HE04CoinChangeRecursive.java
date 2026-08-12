package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE04CoinChangeRecursive {
    public static int solve(int[] coins,int amt){
        if(amt == 0){
            return 0;
        }
        if(amt<0){
            return Integer.MAX_VALUE;
        }
        int mini = Integer.MAX_VALUE;
        for(int coin : coins){
            int res = solve(coins,amt - coin);
            if(res != Integer.MAX_VALUE) {
                mini = Math.min(res + 1, mini);
            }
        }
        return mini;
    }
    public static void main(String[] args) {
        int[] coins = {1,2,3,4,5};
        int amt = 10;
        int ans = solve(coins,amt);
        if(ans == Integer.MAX_VALUE){
            ans = -1;
        }
        System.out.println(ans);
    }
}

/*
===========================================================
HE04 — COIN CHANGE RECURSIVE
RECURSION TREE + DRY RUN
===========================================================

Use a small example:

coins = [1, 2]
amount = 4

Our code:

solve(coins, amt)

At every amount:

    try coin 1
    try coin 2

For every coin:

    remaining = amt - coin

    solve(remaining)

    result + 1
        ↑
    because we used one coin


===========================================================
BASE CASES
===========================================================

1.

amt == 0

    return 0

Meaning:

    We successfully formed the target.

    No more coins are required.


2.

amt < 0

    return Integer.MAX_VALUE

Meaning:

    We went beyond the target.

    This path is invalid.


===========================================================
RECURSION TREE
===========================================================

coins = [1, 2]
amount = 4


                         solve(4)
                        /        \
                     coin 1     coin 2
                       /          \
                   solve(3)      solve(2)
                  /      \       /      \
               coin1    coin2  coin1   coin2
                 /        \      /       \
             solve(2)   solve(1) solve(1) solve(0)
             /   \       /  \     /  \
           1      2     1    2   1    2
          /        \   /      \  /      \
      solve(1)  solve(0) solve(0) solve(-1)
       /   \
      1     2
     /       \
 solve(0)   solve(-1)


===========================================================
LEAF VALUES
===========================================================

solve(0)

    return 0


solve(-1)

    return Integer.MAX_VALUE


So invalid paths do NOT become an answer.


===========================================================
DRY RUN
===========================================================

START:

solve(4)


-----------------------------------------------------------
COIN = 1
-----------------------------------------------------------

Use coin 1:

remaining:

4 - 1 = 3

Call:

solve(3)


-----------------------------------------------------------
solve(3)
-----------------------------------------------------------

Try coin 1:

3 - 1 = 2

solve(2)


-----------------------------------------------------------
solve(2)
-----------------------------------------------------------

Try coin 1:

2 - 1 = 1

solve(1)


-----------------------------------------------------------
solve(1)
-----------------------------------------------------------

Try coin 1:

1 - 1 = 0

solve(0)

return 0


We used coin 1.

Therefore:

0 + 1 = 1


Try coin 2:

1 - 2 = -1

solve(-1)

return Integer.MAX_VALUE

Invalid.

Therefore:

solve(1) = 1


-----------------------------------------------------------
BACK TO solve(2)
-----------------------------------------------------------

First choice:

coin 1

result:

solve(1) = 1

We used one coin.

Therefore:

1 + 1 = 2


Second choice:

coin 2

2 - 2 = 0

solve(0)

return 0

We used one coin:

0 + 1 = 1


Now:

mini = min(2, 1)

mini = 1


Therefore:

solve(2) = 1


This represents:

2

One coin is enough.


-----------------------------------------------------------
BACK TO solve(3)
-----------------------------------------------------------

First choice:

coin 1

solve(2) = 1

Use one more coin:

1 + 1 = 2


Second choice:

coin 2

3 - 2 = 1

solve(1) = 1

Use one more coin:

1 + 1 = 2


Therefore:

solve(3)

= min(2, 2)

= 2


Possible optimal solutions:

1 + 1 + 1

OR

1 + 2


Actually:

1 + 2 = 3

uses 2 coins.


-----------------------------------------------------------
BACK TO solve(4)
-----------------------------------------------------------

First choice:

coin 1

solve(3) = 2

Use one coin:

2 + 1 = 3


Second choice:

coin 2

solve(2) = 1

Use one coin:

1 + 1 = 2


Therefore:

solve(4)

= min(3, 2)

= 2


Optimal:

2 + 2

Answer:

2


===========================================================
IMPORTANT: WHY +1?
===========================================================

Suppose:

amount = 4

we choose coin = 2

remaining:

4 - 2 = 2


Suppose:

solve(2) returns:

1

That means:

    one coin is required to make 2


But we already used coin 2.

So:

    total coins
    =
    1 current coin
    +
    1 remaining coin

    = 2


That's why:

    result + 1


===========================================================
IMPORTANT: WHY Integer.MAX_VALUE?
===========================================================

Suppose:

coins = [2]

amount = 3


solve(3)

Take coin 2:

3 - 2 = 1

solve(1)

Take coin 2:

1 - 2 = -1

solve(-1)

return Integer.MAX_VALUE


There is no valid way.

Therefore:

answer = -1


Your main handles it:

if(ans == Integer.MAX_VALUE) {
    ans = -1;
}


===========================================================
CORE PATTERN
===========================================================

                  amount
                 /      \
             coin 1    coin 2
                |          |
          amount-1    amount-2
                |          |
              recurse    recurse
                \          /
                 Math.min()


For EVERY coin:

    remaining = amount - coin

    result = solve(remaining)

    coins used = result + 1


Then:

    mini = Math.min(mini, result + 1)


===========================================================
DIFFERENCE FROM HE01
===========================================================

HE01 — 0/1 Knapsack:

    TAKE
        ↓
    idx + 1

Because item cannot be reused.


HE04 — Coin Change:

    Choose coin
        ↓
    amount decreases
        ↓
    SAME coin can be chosen again


Example:

amount = 4
coin = 2

    solve(4)
       ↓
    solve(2)
       ↓
    solve(0)

The same coin 2 was used twice.


===========================================================
TC / SC
===========================================================

TC = O(N^A)

where:

N = number of coins
A = amount

More simply:

    exponential in amount

because every amount tries every coin.

SC = O(A)

Maximum recursion depth can reach A
when the smallest coin is 1.


===========================================================
FINAL ANSWER
===========================================================

coins = [1, 2]
amount = 4

Best:

2 + 2

Number of coins:

2

Therefore:

solve(4) = 2
*/