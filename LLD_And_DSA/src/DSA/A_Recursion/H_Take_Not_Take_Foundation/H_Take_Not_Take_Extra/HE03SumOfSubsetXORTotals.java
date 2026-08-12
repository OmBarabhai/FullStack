package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE03SumOfSubsetXORTotals {
    public static int solve(int[] nums,int idx,int xorSum){
        if(idx>=nums.length){
            return xorSum;
        }
        int take = solve(nums,idx+1,xorSum^nums[idx]);
        int notTake = solve(nums,idx+1,xorSum);
        return take + notTake;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int xorSum = 0;
        int idx =0;
        System.out.println(solve(nums,idx,xorSum));
    }
}

/*
===========================================================
HE03 — SUM OF ALL SUBSET XOR TOTALS
===========================================================

Input:

nums = [1, 2, 3, 4]

Initial:

idx = 0
xorSum = 0


===========================================================
CORE RECURSION
===========================================================

For every element:

                    nums[idx]
                   /         \
                TAKE        NOT-TAKE
                  |             |
        xorSum ^ nums[idx]     xorSum
                  |             |
               idx + 1       idx + 1


TAKE:

    xorSum = xorSum ^ nums[idx]


NOT-TAKE:

    xorSum stays unchanged


At idx == nums.length:

    return xorSum


The returned values from both branches are added:

    take + notTake


===========================================================
RECURSION TREE
===========================================================

For understanding, first look at:

nums = [1, 2, 3]

                              (idx=0, xor=0)
                               /          \
                            TAKE        NOT-TAKE
                             +1             +0
                              /               \
                       (idx=1,xor=1)     (idx=1,xor=0)
                         /      \           /      \
                      TAKE    NOT       TAKE     NOT
                       +2       +0        +2        +0
                       /         \        /          \
                (2, xor=3)   (2,xor=1) (2,xor=2)  (2,xor=0)
                  /   \         /  \      /  \        /  \
                +3    -      +3   -    +3   -      +3   -
                 |           |         |           |
              xor=0        xor=2     xor=1       xor=3
              xor=3^3      xor=1^3   xor=2^3     xor=0^3


===========================================================
LEAF VALUES FOR [1,2,3]
===========================================================

Every leaf represents one subset.

Path:

NOT 1
NOT 2
NOT 3

Subset:

[]

XOR:

0


Path:

TAKE 1
NOT 2
NOT 3

Subset:

[1]

XOR:

1


Path:

NOT 1
TAKE 2
NOT 3

Subset:

[2]

XOR:

2


Path:

NOT 1
NOT 2
TAKE 3

Subset:

[3]

XOR:

3


Path:

TAKE 1
TAKE 2
NOT 3

Subset:

[1,2]

XOR:

1 ^ 2 = 3


Path:

TAKE 1
NOT 2
TAKE 3

Subset:

[1,3]

XOR:

1 ^ 3 = 2


Path:

NOT 1
TAKE 2
TAKE 3

Subset:

[2,3]

XOR:

2 ^ 3 = 1


Path:

TAKE 1
TAKE 2
TAKE 3

Subset:

[1,2,3]

XOR:

1 ^ 2 ^ 3 = 0


Therefore the returned leaf values are:

0
1
2
3
3
2
1
0


Total:

0 + 1 + 2 + 3 + 3 + 2 + 1 + 0

= 12


===========================================================
DRY RUN
===========================================================

Start:

idx = 0
xorSum = 0


-----------------------------------------------------------
ROOT — nums[0] = 1
-----------------------------------------------------------

TAKE 1:

xorSum:

0 ^ 1 = 1

Call:

solve(idx=1, xorSum=1)


NOT-TAKE 1:

xorSum stays:

0

Call:

solve(idx=1, xorSum=0)


-----------------------------------------------------------
TAKE 1 BRANCH
-----------------------------------------------------------

Current:

idx = 1
xorSum = 1


TAKE 2:

1 ^ 2 = 3

Call:

solve(idx=2, xorSum=3)


From xor = 3:

TAKE 3:

3 ^ 3 = 0

idx = 3

BASE CASE:

return 0


NOT-TAKE 3:

xor remains:

3

idx = 3

BASE CASE:

return 3


Therefore:

solve(2,3)

= 0 + 3

= 3


-----------------------------------------------------------
BACK TO xor = 1
-----------------------------------------------------------

NOT-TAKE 2:

xor remains:

1

Call:

solve(idx=2, xorSum=1)


TAKE 3:

1 ^ 3 = 2

BASE:

return 2


NOT-TAKE 3:

xor remains:

1

BASE:

return 1


Therefore:

solve(2,1)

= 2 + 1

= 3


Therefore the TAKE-1 branch:

3 + 3

= 6


-----------------------------------------------------------
ROOT — NOT-TAKE 1
-----------------------------------------------------------

Current:

idx = 1
xorSum = 0


TAKE 2:

0 ^ 2 = 2


From xor = 2:

TAKE 3:

2 ^ 3 = 1

return 1


NOT-TAKE 3:

return 2


Therefore:

solve(2,2)

= 1 + 2

= 3


NOT-TAKE 2:

xor remains:

0


TAKE 3:

0 ^ 3 = 3

return 3


NOT-TAKE 3:

return 0


Therefore:

solve(2,0)

= 3 + 0

= 3


NOT-TAKE-1 branch:

3 + 3

= 6


===========================================================
FINAL ROOT CALCULATION
===========================================================

TAKE 1 branch:

6


NOT-TAKE 1 branch:

6


Therefore:

6 + 6

= 12


Answer for:

nums = [1,2,3]

is:

12


===========================================================
FOR YOUR ACTUAL INPUT
===========================================================

nums = [1,2,3,4]

There are:

2^4 = 16

subsets.

Each leaf returns its subset's XOR value.

The parent adds:

    take + notTake

until the root gets the total.

Final answer:

28


===========================================================
WHY idx + 1 IN BOTH BRANCHES?
===========================================================

This is important.

Every number can be used:

    at most once

Therefore after processing nums[idx]:

    TAKE     → idx + 1
    NOT-TAKE → idx + 1


This is different from Coin Change.

Coin Change allows reuse:

    TAKE     → same idx
    NOT-TAKE → idx + 1


===========================================================
TC / SC
===========================================================

TC = O(2^N)

There are 2 choices for every element.

Therefore:

    2^N paths


SC = O(N)

Maximum recursion depth:

    N


===========================================================
CORE PATTERN
===========================================================

                CURRENT ELEMENT
                       |
                ┌──────┴──────┐
                ↓             ↓
              TAKE        NOT-TAKE
                ↓             ↓
        xor ^ nums[idx]      xor
                ↓             ↓
             idx + 1       idx + 1
                \             /
                 \           /
                 take + notTake
*/