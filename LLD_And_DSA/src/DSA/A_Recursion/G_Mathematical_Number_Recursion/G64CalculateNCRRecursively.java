package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G64 — Binomial Coefficient (nCr)
 * Pattern : Mathematical / Branching Recursion
 * Platform: Coding Ninjas / Interview
 *
 * Problem:
 *
 * Given N and R, calculate:
 *
 *        N
 *       C
 *        R
 *
 * Example:
 *
 * 5C2 = 10
 *
 *
 * =========================================================
 * CORE IDEA
 * =========================================================
 *
 * nCr means:
 *
 * "Choose R items from N items."
 *
 *
 * The recursive formula is:
 *
 * nCr
 *
 * =
 *
 * (n-1)C(r-1)
 * +
 * (n-1)Cr
 *
 *
 * Think:
 *
 *              nCr
 *             /   \
 *            /     \
 *       CHOOSE    DON'T CHOOSE
 *          |           |
 *    (n-1)C(r-1)    (n-1)Cr
 *
 *
 * =========================================================
 * BASE CASES
 * =========================================================
 *
 * n < r
 *     → 0
 *
 * Cannot choose more items than available.
 *
 *
 * r == 0
 *     → 1
 *
 * Choosing nothing has one way.
 *
 *
 * n == r
 *     → 1
 *
 * Choosing all items has one way.
 *
 *
 * =========================================================
 * IMPORTANT
 * =========================================================
 *
 * nC1 = n
 *
 * So DO NOT write:
 *
 * if (r == 1) return 1;
 *
 * Example:
 *
 * 5C1 = 5
 *
 * =========================================================
 */

public class G64CalculateNCRRecursively {

    /*
     * Calculate nCr using pure recursion.
     */
    public static int calculateBinomialCoefficient(
            int n,
            int r) {

        // -----------------------------------------------
        // INVALID CASE
        // -----------------------------------------------
        //
        // Example:
        //
        // 2C4
        //
        // Cannot choose 4 items from 2 items.
        //
        if (n < r) {
            return 0;
        }


        // -----------------------------------------------
        // BASE CASE
        // -----------------------------------------------
        //
        // nC0 = 1
        //
        // Example:
        //
        // 5C0 = 1
        //
        // nCn = 1
        //
        // Example:
        //
        // 5C5 = 1
        //
        if (r == 0 || n == r) {
            return 1;
        }


        // -----------------------------------------------
        // RECURSIVE CASE
        // -----------------------------------------------
        //
        // nCr
        //
        // =
        //
        // (n-1)C(r-1)
        // +
        // (n-1)Cr
        //
        //
        // First branch:
        //
        // CHOOSE
        //
        // (n-1)C(r-1)
        //
        //
        // Second branch:
        //
        // DON'T CHOOSE
        //
        // (n-1)Cr
        //
        return calculateBinomialCoefficient(
                n - 1,
                r - 1
        )
                +
                calculateBinomialCoefficient(
                        n - 1,
                        r
                );
    }


    public static void main(String[] args) {

        int n = 5;
        int r = 2;

        int result =
                calculateBinomialCoefficient(n, r);

        System.out.println("nCr = " + result);
    }
}


/*
 * =========================================================
 * DRY RUN — 5C2
 * =========================================================
 *
 * Start:
 *
 * calculate(5,2)
 *
 *
 * n < r?
 *
 * 5 < 2 → NO
 *
 *
 * r == 0 OR n == r?
 *
 * 2 == 0 → NO
 * 5 == 2 → NO
 *
 *
 * Therefore:
 *
 * calculate(4,1)
 * +
 * calculate(4,2)
 *
 *
 * =========================================================
 * LEFT BRANCH — 4C1
 * =========================================================
 *
 * calculate(4,1)
 *
 * n < r?
 *
 * 4 < 1 → NO
 *
 * r == 0?
 *
 * NO
 *
 * n == r?
 *
 * 4 == 1 → NO
 *
 *
 * Therefore:
 *
 * calculate(3,0)
 * +
 * calculate(3,1)
 *
 *
 * ---------------------------------------------------------
 *
 * calculate(3,0)
 *
 * r == 0
 *
 * → 1
 *
 *
 * ---------------------------------------------------------
 *
 * calculate(3,1)
 *
 * =
 *
 * calculate(2,0)
 * +
 * calculate(2,1)
 *
 *
 * calculate(2,0)
 * → 1
 *
 *
 * calculate(2,1)
 *
 * =
 *
 * calculate(1,0)
 * +
 * calculate(1,1)
 *
 * → 1 + 1
 * → 2
 *
 *
 * Therefore:
 *
 * 3C1 = 3
 *
 *
 * Therefore:
 *
 * 4C1 = 4
 *
 *
 * =========================================================
 * RIGHT BRANCH — 4C2
 * =========================================================
 *
 * calculate(4,2)
 *
 * =
 *
 * calculate(3,1)
 * +
 * calculate(3,2)
 *
 *
 * Notice:
 *
 * calculate(3,1)
 *
 * was already calculated in the left branch.
 *
 * This is called:
 *
 * REPEATED SUBPROBLEM
 *
 *
 * This repeated work is why pure recursion becomes slow.
 *
 *
 * =========================================================
 * FINAL RESULT
 * =========================================================
 *
 * 5C2
 *
 * =
 *
 * 4C1 + 4C2
 *
 * =
 *
 * 4 + 6
 *
 * =
 *
 * 10
 *
 *
 * FINAL:
 *
 * 5C2 = 10
 *
 *
 * =========================================================
 * RECURSION TREE — SIMPLE VIEW
 * =========================================================
 *
 *                 5C2
 *                /   \
 *               /     \
 *             4C1     4C2
 *            /  \     /  \
 *          3C0  3C1  3C1  3C2
 *           |    |    |    |
 *           1    ...  ...  ...
 *
 *
 * Notice:
 *
 *       3C1
 *      ↙   ↘
 *
 * appears more than once.
 *
 *
 * =========================================================
 * WHY TLE?
 * =========================================================
 *
 * Pure recursion creates TWO branches:
 *
 *                 nCr
 *                /   \
 *               /     \
 *             ...     ...
 *
 *
 * For every branch, more branches are created.
 *
 *
 * At the same time,
 * the same values are calculated again.
 *
 *
 * Example:
 *
 * 3C1
 *
 * can be calculated multiple times.
 *
 *
 * Therefore:
 *
 * Pure recursion
 *       ↓
 * repeated calculations
 *       ↓
 * many recursive calls
 *       ↓
 * TLE for large N
 *
 *
 * =========================================================
 * VERY IMPORTANT LEARNING
 * =========================================================
 *
 * The recursion logic is CORRECT.
 *
 * The problem is PERFORMANCE.
 *
 *
 * So:
 *
 * Recursion correctness
 *        ≠
 * Efficient solution
 *
 *
 * Later:
 *
 * Pure Recursion
 *       ↓
 * Memoization
 *       ↓
 * DP
 *
 *
 * =========================================================
 * PATTERN RECOGNITION
 * =========================================================
 *
 * If you see:
 *
 * nCr
 * combinations
 * choose / don't choose
 * two recursive branches
 *
 * Think:
 *
 * CHOOSE
 *    OR
 * DON'T CHOOSE
 *
 *
 * Formula:
 *
 * nCr
 * =
 * (n-1)C(r-1)
 * +
 * (n-1)Cr
 *
 *
 * =========================================================
 * G64 CORE MEMORY
 * =========================================================
 *
 * Base:
 *
 * n < r → 0
 *
 * r == 0 → 1
 *
 * n == r → 1
 *
 *
 * Recursive:
 *
 *          nCr
 *           ↓
 *   CHOOSE   +  DON'T CHOOSE
 *    ↓             ↓
 * (n-1)C(r-1) + (n-1)C(r)
 *
 *
 * Mental Model:
 *
 * "TAKE IT OR DON'T TAKE IT."
 *
 *
 * =========================================================
 * COMPLEXITY
 * =========================================================
 *
 * Pure recursive version:
 *
 * Time  : O(2^n) approximately
 * Space : O(n)
 *
 * Why?
 *
 * Two branches are created repeatedly.
 *
 * =========================================================
 */