package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE01ZeroOneKnapsack {
    public static int solve(int[] weight, int[] value, int capacity, int idx) {
        if (idx >= weight.length) {
            return 0;
        }
        if (weight[idx] <= capacity) {
            int take =value[idx] + solve(weight, value, capacity - weight[idx], idx + 1);
            int notTake = solve(weight, value, capacity, idx + 1);
            return Math.max(take, notTake);
        }
        return solve(weight,value,capacity,idx+1);
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4, 6, 7};
        int[] value = {1, 4, 5, 7, 6};
        int W = 7;
        System.out.println(solve(weight, value, W, 0));
    }
}

/*
===========================================================
HE01 — 0/1 KNAPSACK
RECURSION TREE + DRY RUN
===========================================================

Input:

weight = [1, 3, 4]
value  = [1, 4, 5]
capacity = 4

We use:

solve(weight, value, capacity, idx)


At every item:

    if weight[idx] <= capacity

        TAKE
        NOT-TAKE

    otherwise

        ONLY NOT-TAKE


===========================================================
RECURSION TREE
===========================================================


                         solve(cap=4, idx=0)
                              weight=1
                         /                  \
                     TAKE                  NOT-TAKE
                      |                       |
             value=1 + solve(3,1)       solve(4,1)
                      |                       |
                 capacity=3              capacity=4
                 idx=1                    idx=1
                  /   \                    /   \
               TAKE  NOT-TAKE           TAKE  NOT-TAKE
                |       |                 |       |
          4 + solve   solve(3,2)     4+solve   solve(4,2)
             (0,2)       (3,2)          (0,2)      (4,2)
               |           |              |          |
              5           5               5          5


Let's calculate the leaves properly:

LEFT SIDE:

TAKE item 1
capacity = 3
value = 1

        item 3 (weight=3)

        TAKE:
        value = 1 + 4
        capacity = 0
        → 5

        NOT-TAKE:
        value = 1
        → 1

Therefore:

max(5, 1) = 5


RIGHT SIDE:

NOT-TAKE item 1
capacity = 4
value = 0

        item 3 (weight=3)

        TAKE:
        value = 4

        Remaining capacity = 1

        item 4 (weight=4)
        cannot take
        → 4

        NOT-TAKE:
        skip item 3

        item 4 (weight=4)
        TAKE:
        value = 5

Therefore:

max(4, 5) = 5


ROOT:

max(5, 5)

= 5


ANSWER:

5


===========================================================
DRY RUN
===========================================================


START:

capacity = 4
idx = 0
item = weight 1, value 1


-----------------------------------------------------------
BRANCH 1 — TAKE item 1
-----------------------------------------------------------

Take weight 1:

capacity:

4 - 1 = 3

value:

0 + 1 = 1

Now:

solve(capacity=3, idx=1)


-----------------------------------------------------------
ITEM 2
-----------------------------------------------------------

weight = 3
value = 4

It fits:

3 <= 3


TAKE:

value = 1 + 4
     = 5

capacity:

3 - 3
= 0


No capacity remains.

Remaining items cannot be taken.

Return:

5


NOT-TAKE:

Skip item 2.

Current value remains:

1

Item 3 has:

weight = 4

capacity = 3

4 > 3

Cannot take.

Return:

1


Compare:

take = 5
notTake = 1

Math.max(5, 1)

= 5


So:

solve(3,1) = 5


-----------------------------------------------------------
BACK TO ROOT
-----------------------------------------------------------

TAKE branch returned:

5


-----------------------------------------------------------
BRANCH 2 — NOT-TAKE item 1
-----------------------------------------------------------

Don't take item 1.

capacity remains:

4

idx = 1


ITEM 2:

weight = 3
value = 4

It fits.

Two choices:


TAKE item 2:

capacity:

4 - 3 = 1

value:

4


Now item 3:

weight = 4

capacity = 1

4 > 1

Cannot take.

Return:

4


NOT-TAKE item 2:

capacity = 4

value = 0


ITEM 3:

weight = 4
value = 5

It fits.

TAKE:

capacity:

4 - 4 = 0

value:

5

Return:

5


Compare:

take = 4
notTake = 5

Math.max(4, 5)

= 5


So:

solve(4,1) = 5


-----------------------------------------------------------
ROOT
-----------------------------------------------------------

TAKE item 1:

5

NOT-TAKE item 1:

5


Therefore:

Math.max(5, 5)

= 5


ANSWER:

5


===========================================================
IMPORTANT: WHY "TAKE" CHANGES CAPACITY
===========================================================

If:

capacity = 4
weight[idx] = 3

TAKE:

new capacity = 4 - 3
              = 1


And:

value[idx] = 4

So:

take =
    4
    +
    best value with capacity 1


===========================================================
IMPORTANT: WHY NOT-TAKE DOES NOT CHANGE CAPACITY
===========================================================

If we don't take the item:

capacity stays the same.

Example:

capacity = 4

NOT-TAKE

→ capacity = 4


===========================================================
WHY Math.max()?
===========================================================

Every branch gives us a possible total value.

Example:

TAKE     = 5
NOT-TAKE = 1

We want the better choice:

Math.max(5, 1)

= 5


===========================================================
CORE PATTERN
===========================================================

                ITEM
                 |
          Does it fit?
          /          \
        YES           NO
         |             |
     TAKE +         NOT-TAKE
     NOT-TAKE          |
         |             |
     Math.max()      recurse


TAKE:

value[idx]
+
solve(capacity - weight[idx])


NOT-TAKE:

solve(capacity)


===========================================================
TC / SC
===========================================================

TC = O(2^N)

SC = O(N)

Because each item can create:

    TAKE
       \
        or
       /
    NOT-TAKE

and recursion depth is N.
*/