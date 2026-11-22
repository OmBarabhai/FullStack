package DSA.A_Recursion.H_Take_Not_Take_Foundation.H_Take_Not_Take_Extra;

public class HE02TargetSum {
    public static int solve(int[] nums,int idx,int cal,int k){
        if (idx >= nums.length) {
            if (cal == k) {
                return 1;
            }
            return 0;
        }
        int plus  = solve(nums, idx + 1, cal + nums[idx], k);
        int minus = solve(nums, idx + 1, cal - nums[idx], k);
        return plus + minus;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 1;
        int cal = 0;
        int idx = 0;
        System.out.println(solve(nums,idx,cal,k));
    }
}


/*
===========================================================
HE02 — TARGET SUM
===========================================================

Input:

nums = [1, 1, 1]
target = 1

For every element we have TWO choices:

    + nums[idx]
    - nums[idx]

We count how many complete paths produce target = 1.


===========================================================
RECURSION TREE
===========================================================

                         sum = 0
                        idx = 0
                       /       \
                    +1          -1
                    /             \
                 sum=1           sum=-1
                idx=1             idx=1
                /   \             /   \
              +1     -1         +1     -1
              /       \         /       \
           sum=2     sum=0    sum=0     sum=-2
           idx=2     idx=2    idx=2      idx=2
            /  \      /  \      /  \      /  \
          +1   -1   +1   -1   +1   -1   +1   -1
           |    |    |    |    |    |    |    |
          3    1     1   -1   1   -1   -1   -3

At idx = 3:

    sum = 3  → target 1 → invalid → 0
    sum = 1  → target 1 → VALID   → 1

    sum = 1  → target 1 → VALID   → 1
    sum = -1 → invalid             → 0

    sum = 1  → VALID               → 1
    sum = -1 → invalid              → 0

    sum = -1 → invalid              → 0
    sum = -3 → invalid              → 0


Therefore:

First subtree:
    0 + 1 = 1

Second subtree:
    1 + 0 = 1

Third subtree:
    1 + 0 = 1

Fourth subtree:
    0 + 0 = 0


Total:

    1 + 1 + 1 + 0
    = 3


===========================================================
DRY RUN
===========================================================

Start:

idx = 0
cal = 0
target = 1


-----------------------------------------------------------
ELEMENT 1
-----------------------------------------------------------

Choose +

cal = 0 + 1
    = 1

idx = 1


Choose + again:

cal = 1 + 1
    = 2

idx = 2


Choose +:

cal = 2 + 1
    = 3

idx = 3

BASE CASE:

3 == 1 ?

FALSE

return 0


Backtrack.

Choose -:

cal = 2 - 1
    = 1

idx = 3

BASE CASE:

1 == 1 ?

TRUE

return 1


So:

solve(sum=2)
    = 0 + 1
    = 1


-----------------------------------------------------------
BACK TO sum = 1
-----------------------------------------------------------

The first element was +1.

Now choose - for the second element:

cal = 1 - 1
    = 0

idx = 2


Choose +:

cal = 0 + 1
    = 1

idx = 3

BASE CASE:

1 == 1 ?

TRUE

return 1


Choose -:

cal = 0 - 1
    = -1

idx = 3

BASE CASE:

-1 == 1 ?

FALSE

return 0


Therefore:

solve(sum=0)
    = 1 + 0
    = 1


First major branch:

plus = 1
minus = 1

Therefore:

solve(root)
    = 1 + 1
    = 2


But there is also the branch beginning with -1.


-----------------------------------------------------------
ROOT — CHOOSE -1
-----------------------------------------------------------

cal = 0 - 1
    = -1

idx = 1


Choose +:

cal = -1 + 1
    = 0

idx = 2


Choose +:

cal = 0 + 1
    = 1

idx = 3

BASE CASE:

1 == 1 ?

TRUE

return 1


Choose -:

cal = 0 - 1
    = -1

BASE CASE:

-1 == 1 ?

FALSE

return 0


Therefore:

this branch = 1


-----------------------------------------------------------
FINAL
-----------------------------------------------------------

Valid paths are:

+ + -
+ - +
- + +


Their sums:

+1 +1 -1 = 1
+1 -1 +1 = 1
-1 +1 +1 = 1


Total valid ways:

3


===========================================================
CORE PATTERN
===========================================================

At every element:

                    nums[idx]
                   /         \
                  +           -
                  |           |
             cal + num    cal - num
                  |           |
                recurse     recurse


At the end:

    cal == target
         ↓
       return 1

    cal != target
         ↓
       return 0


Then:

    plus + minus

because we are COUNTING valid ways.


===========================================================
IMPORTANT DIFFERENCE FROM HE01
===========================================================

HE01 — Knapsack:

    TAKE / NOT-TAKE
         ↓
    Math.max()


HE02 — Target Sum:

    PLUS / MINUS
         ↓
    plus + minus


HE01 asks:

    "What is the maximum value?"


HE02 asks:

    "How many valid ways exist?"


===========================================================
TC / SC
===========================================================

TC = O(2^N)

SC = O(N)

At every element:

    2 choices

Therefore:

    2^N paths

Maximum recursion depth:

    N
*/