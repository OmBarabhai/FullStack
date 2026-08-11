package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H91PartitionWithMinimumDifference {
    public static int solve(int[] arr, int idx, int sumA, int tot) {
        if (idx >= arr.length) {
            // Whatever is not selected in Group A
            // automatically belongs to Group B.
            int sumB = tot - sumA;
            // Return the difference between the two groups.
            return Math.abs(sumA - sumB);
        }
        // Min(Take,NotTake);

        // TAKE:
        // Put arr[idx] into Group A.

        // NOT-TAKE:
        // Do not put arr[idx] into Group A.
        // Therefore, sumA remains unchanged.

        // We want the minimum difference.
        return Math.min(solve(arr, idx + 1, sumA + arr[idx], tot), solve(arr, idx + 1, sumA, tot));
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9};
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        int idx = 0;
        int sumA = 0;
        int ans = solve(arr, idx, sumA, total);
        System.out.println(ans);
    }
}


/*
@RecursionTree 🌳

RECURSION TREE
arr = [1, 2, 3]
total = 6


                         solve(idx=0, sumA=0)
                                  |
                           arr[0] = 1
                         /             \
                      TAKE           NOT-TAKE
                       |                 |
                  sumA = 1           sumA = 0
                    /   \             /   \
                TAKE   NOT-TAKE   TAKE   NOT-TAKE
                 2        2        2        2
                 |        |        |        |
              sumA=3    sumA=1  sumA=2    sumA=0
                / \       / \      / \       / \
              T3  NT3   T3  NT3  T3  NT3   T3  NT3
               |    |    |    |    |    |     |    |
              6     3    4    1    5    2     3    0
               \    /    \    /    \    /     \    /
                \  /      \  /      \  /       \  /
                 MIN       MIN      MIN        MIN
                  ↓         ↓        ↓          ↓
                  3         1        2          0

Now combine upward:

LEFT SUBTREE:
min(3, 1) = 1

RIGHT SUBTREE:
min(2, 0) = 0

ROOT:
min(1, 0) = 0

ANSWER = 0


At every leaf:

sumB = total - sumA

difference = |sumA - sumB|

*/
//========================================+++++++++++++==================================================
/*
DRY RUN
arr = [1, 2, 3]
total = 6


1. Start

idx = 0
sumA = 0


2. TAKE 1

sumA = 0 + 1 = 1
idx = 1


3. TAKE 2

sumA = 1 + 2 = 3
idx = 2


4. TAKE 3

sumA = 3 + 3 = 6
idx = 3

BASE CASE:

sumB = 6 - 6 = 0

difference = |6 - 0|
           = 6

return 6


5. Backtrack to sumA = 3

NOT-TAKE 3

sumA = 3
idx = 3

sumB = 6 - 3 = 3

difference = |3 - 3|
           = 0

return 0


TAKE 2 branch:

min(6, 0)
= 0


6. Backtrack to sumA = 1

NOT-TAKE 2

sumA = 1
idx = 2


TAKE 3:

sumA = 1 + 3
     = 4

sumB = 6 - 4
     = 2

difference = |4 - 2|
           = 2


NOT-TAKE 3:

sumA = 1

sumB = 6 - 1
     = 5

difference = |1 - 5|
           = 4


min(2, 4)
= 2


7. TAKE 1 subtree:

min(0, 2)
= 0


8. NOT-TAKE 1

sumA = 0

Then the right subtree is explored.

Its best difference is also 0.


9. Final:

min(0, 0)
= 0


ANSWER = 0

One valid partition:

Group A = [1, 2]
sumA = 3

Group B = [3]
sumB = 3

difference = 0

2 × 2 × 2 × ... × 2
       N times

= 2^N

TC = O(2^N)

SC = O(N)
*/