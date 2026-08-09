package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class G70PrintAllDivisorsRecursively {

    // ============================================================
    // APPROACH 1: BASIC RECURSIVE APPROACH
    // ============================================================

    /*
     * Idea:
     * Check every number from 1 to n.
     *
     * If idx divides n completely,
     * then idx is a divisor of n.
     *
     * Example:
     * n = 6
     *
     * 6 % 1 == 0 → 1 is divisor
     * 6 % 2 == 0 → 2 is divisor
     * 6 % 3 == 0 → 3 is divisor
     * 6 % 4 != 0
     * 6 % 5 != 0
     * 6 % 6 == 0 → 6 is divisor
     */

    public static List<Integer> allDivisors(int n, int idx, List<Integer> ans) {

        // BASE CASE:
        // We have checked every number from 1 to n.
        if (idx > n) {
            return ans;
        }

        // CURRENT WORK:
        // Check whether idx is a divisor of n.
        if (n % idx == 0) {
            ans.add(idx);
        }

        // RECURSIVE CASE:
        // Move to the next number.
        return allDivisors(n, idx + 1, ans);
    }

    // Starting method for basic recursion
    public static List<Integer> printAllDivisorsRecursively(int n) {

        List<Integer> ans = new ArrayList<>();

        int idx = 1;

        return allDivisors(n, idx, ans);
    }


    // ============================================================
    // APPROACH 2: OPTIMIZED RECURSIVE APPROACH
    // ============================================================

    /*
     * IMPORTANT IDEA:
     *
     * Divisors always come in pairs.
     *
     * Example:
     *
     * n = 10
     *
     * 1 × 10 = 10
     * 2 × 5  = 10
     *
     * So:
     *
     * if 2 is a divisor,
     * then 10 / 2 = 5 is also a divisor.
     *
     * Therefore, we only need to check up to sqrt(n).
     */

    public static void findDiv(int n, List<Integer> ans, int idx) {

        // BASE CASE:
        //
        // Once idx * idx > n,
        // we have crossed sqrt(n).
        //
        // No more divisor pairs are possible.
        if (n < idx * idx) { // 10 < 1 * 1 no --> 10 < 2 * 2 no --> 10 < 3 * 3 no --> 10 < 4 * 4 Yes Return
            return;
        }

        // CURRENT WORK:
        //
        // Check whether idx is a divisor.
        if (n % idx == 0) { // 10 % 1 == 0 --> 10 % 2 == 0  --> 10 % 3 != 0 --> 10 % 4 =

            // Add the smaller divisor.
            ans.add(idx); // add 1 --> add 2 --> skip -->

            // Add the paired/larger divisor.
            //
            // Example:
            // n = 10, idx = 2
            //
            // 10 / 2 = 5
            //
            // So add 5.
            //
            // Perfect square example:
            // n = 16, idx = 4
            //
            // 16 / 4 = 4
            //
            // We must NOT add 4 twice.
            if (idx != n / idx) { // 1 != 10 / 1 --> 1 != 5 --> 2 == 2
                ans.add(n / idx); //      add 10 --> add 5  --> 2 == 2 skip
            }
        }

        // RECURSIVE CASE:
        //
        // Check the next possible divisor.
        findDiv(n, ans, idx + 1);// [1, 10, 5, 2];
    }

    // Starting method for optimized recursion
    public static List<Integer> printDivisors(int n) {

        List<Integer> ans = new ArrayList<>();

        int idx = 1;

        // Start recursion.
        findDiv(n, ans, idx);

        // Divisors are discovered in pairs,
        // so they may not be in ascending order.
        //
        // Example:
        // [1, 10, 2, 5]
        //
        // After sorting:
        // [1, 2, 5, 10]
        Collections.sort(ans);

        return ans;
    }


    // ============================================================
    // MAIN
    // ============================================================

    public static void main(String[] args) {

        int n = 10;

        // Basic recursive approach
        List<Integer> basicResult = printAllDivisorsRecursively(n);

        System.out.println("Basic Recursive: " + basicResult);

        // Optimized recursive approach
        List<Integer> optimizedResult = printDivisors(n);

        System.out.println("Optimized Recursive: " + optimizedResult);
    }
}


/*
============================================================
G70 — DRY RUN
============================================================

Example:

n = 6


============================================================
PART 1: BASIC RECURSION
============================================================

Call:

allDivisors(6, 1, [])


RECURSION CHAIN
---------------

This is a CHAIN, not a branching tree,
because there is only ONE recursive call.


allDivisors(6, 1, [])
        |
        | 6 % 1 == 0
        | add 1
        ↓
allDivisors(6, 2, [1])
        |
        | 6 % 2 == 0
        | add 2
        ↓
allDivisors(6, 3, [1,2])
        |
        | 6 % 3 == 0
        | add 3
        ↓
allDivisors(6, 4, [1,2,3])
        |
        | 6 % 4 != 0
        ↓
allDivisors(6, 5, [1,2,3])
        |
        | 6 % 5 != 0
        ↓
allDivisors(6, 6, [1,2,3])
        |
        | 6 % 6 == 0
        | add 6
        ↓
allDivisors(6, 7, [1,2,3,6])
        |
        | 7 > 6
        ↓
      BASE CASE
        |
        ↓
      return


FINAL:

[1, 2, 3, 6]


============================================================
GOING DOWN
============================================================

The recursion goes forward:

1 → 2 → 3 → 4 → 5 → 6 → 7

                         ↓
                     BASE CASE


During this phase we check divisors.


============================================================
COMING BACK UP
============================================================

After reaching the base case,
the recursive calls return:

7 → 6 → 5 → 4 → 3 → 2 → 1


Important:

There is no extra work after the recursive call.

The list already contains the answer.

So each call simply returns the SAME list.


============================================================
WHY IS `ans` NOT LOST?
============================================================

All recursive calls receive the SAME List object.

Example:

First call:

ans = []


After idx = 1:

ans = [1]


After idx = 2:

ans = [1,2]


After idx = 3:

ans = [1,2,3]


After idx = 6:

ans = [1,2,3,6]


Therefore the final result is:

[1,2,3,6]


============================================================
PART 2: OPTIMIZED RECURSION
============================================================

Example:

n = 10


Start:

findDiv(10, [], 1)


RECURSION CHAIN
---------------

findDiv(10, [], 1)
        |
        | 10 % 1 == 0
        | add 1
        | add 10
        ↓
findDiv(10, [1,10], 2)
        |
        | 10 % 2 == 0
        | add 2
        | add 5
        ↓
findDiv(10, [1,10,2,5], 3)
        |
        | 10 % 3 != 0
        ↓
findDiv(10, [1,10,2,5], 4)
        |
        | 4 × 4 > 10
        ↓
      BASE CASE


Before sorting:

[1,10,2,5]


After:

[1,2,5,10]


============================================================
WHY CAN WE STOP AT sqrt(n)?
============================================================

For n = 10:

1 × 10 = 10
2 × 5  = 10


Divisor pairs:

1 ↔ 10
2 ↔ 5


Once we reach sqrt(10):

sqrt(10) ≈ 3.16


We only need to check:

1
2
3


Next:

idx = 4

4 × 4 = 16

16 > 10

Therefore:

STOP


============================================================
PERFECT SQUARE CASE
============================================================

Example:

n = 16


Divisor pairs:

1 × 16
2 × 8
4 × 4


When:

idx = 4

n / idx = 16 / 4 = 4


If we did:

ans.add(idx);
ans.add(n / idx);


we would get:

[1,16,2,8,4,4]


WRONG.


Therefore:

if (idx != n / idx)


For idx = 4:

4 != 4 → false

So we add 4 only once.


Correct:

[1,16,2,8,4]


After sorting:

[1,2,4,8,16]


============================================================
G70 RECURSION PATTERN
============================================================

Every call follows this pattern:


1. CHECK BASE CASE
        ↓
2. DO CURRENT WORK
        ↓
3. CALL SAME FUNCTION
   WITH idx + 1
        ↓
4. REPEAT
        ↓
5. BASE CASE
        ↓
6. RETURN


For BASIC:

BASE CASE:

idx > n


For OPTIMIZED:

BASE CASE:

idx × idx > n


CURRENT WORK:

if (n % idx == 0)


DIVISOR PAIR:

idx
n / idx


RECURSIVE CALL:

findDiv(n, ans, idx + 1)


============================================================
FINAL MEMORY TRICK
============================================================

G70 =

"Check index → find divisor → add pair
 → move index → stop at sqrt(n)"


Basic:

1 → 2 → 3 → ... → n


Optimized:

1 → 2 → 3 → ... → sqrt(n)


============================================================
*/