package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G61 — Fast Exponentiation
 * Pattern : Mathematical / Number Recursion
 * Platform: LeetCode 50 / GFG
 *
 * Problem:
 * Calculate x^n efficiently using recursion.
 *
 * Example:
 * x = 2
 * n = 10
 *
 * Answer = 1024
 *
 * Formula:
 *
 * n == 0
 *     → 1
 *
 * half = pow(x, n / 2)
 *
 * n is EVEN
 *     → half * half
 *
 * n is ODD
 *     → x * half * half
 *
 * Negative Exponent:
 *
 * x^(-n) = 1 / x^n
 *
 * Therefore:
 *
 * N = -N
 * x = 1 / x
 *
 * Example:
 *
 * 2^(-3)
 *     ↓
 * (1/2)^3
 *     ↓
 * 0.125
 *
 * Time  : O(log n)
 * Space : O(log n)
 * =========================================================
 */

public class G61FastExponentiation {

    // Calculates x^n using fast recursive exponentiation
    public static double pow(double x, long n) {

        // Base Case:
        // Any number raised to power 0 is 1
        if (n == 0) {
            return 1;
        }

        // Recursive Call:
        // Calculate x^(n/2)
        double half = pow(x, n / 2);

        // Even exponent:
        // x^n = x^(n/2) * x^(n/2)
        if ((n & 1) == 0) {
            return half * half;
        }

        // Odd exponent:
        // x^n = x * x^(n/2) * x^(n/2)
        return x * half * half;
    }

    // Handles both positive and negative exponents
    public static double fastExponentiation(double x, int n) {

        // Convert int to long before negating
        // This safely handles Integer.MIN_VALUE
        long N = n;

        /*
         * Negative Exponent:
         *
         * Rule:
         * x^(-n) = 1 / x^n
         *
         * Example:
         * 2^(-3) = 1 / 2^3 = 0.125
         *
         * Convert:
         * x = 2  →  x = 1 / 2
         * N = -3 →  N = 3
         *
         * Now calculate:
         * (1/2)^3
         */
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }

        return pow(x, N);
    }

    public static void main(String[] args) {

        double x = 2;
        int n = 10;

        double result = fastExponentiation(x, n);

        System.out.println("Answer = " + result);

//============================================================================================

        int nIsTwoPower = 16;

        boolean isTwoPower = isPowerOfTwo(nIsTwoPower);

        System.out.println("Is Power of Two = " + isTwoPower);
    }
//===========================================================================================
    public static boolean pow(long n) {

        // Base Case
        // 1 = 2^0
        if (n == 1) {
            return true;
        }

        // Invalid Cases
        //
        // n <= 0:
        // Cannot be a positive power of 2.
        //
        // (n & 1) != 0:
        // n is odd.
        //
        // The only odd power of 2 is 1,
        // which was already handled above.
        if (n <= 0 || (n & 1) != 0) {
            return false;
        }

        // Recursive Call
        //
        // Divide n by 2 and check again.
        return pow(n / 2);
    }

    public static boolean isPowerOfTwo(int n) {

        return pow(n);
    }


    /*
     * =========================================================
     * DRY RUN — n = 16
     * =========================================================
     *
     * Call:
     *
     * pow(16)
     *
     *
     * 16 == 1?
     * NO
     *
     * 16 <= 0?
     * NO
     *
     * 16 is odd?
     * NO
     *
     * Recursive:
     *
     * pow(16 / 2)
     *
     * ↓
     *
     * pow(8)
     *
     *
     * ---------------------------------------------------------
     *
     * pow(8)
     *
     * 8 == 1?
     * NO
     *
     * 8 is even.
     *
     * → pow(4)
     *
     *
     * ---------------------------------------------------------
     *
     * pow(4)
     *
     * 4 is even.
     *
     * → pow(2)
     *
     *
     * ---------------------------------------------------------
     *
     * pow(2)
     *
     * 2 is even.
     *
     * → pow(1)
     *
     *
     * ---------------------------------------------------------
     *
     * pow(1)
     *
     * Base Case:
     *
     * n == 1
     *
     * → true
     *
     *
     * =========================================================
     * RETURN
     * =========================================================
     *
     * pow(1)
     * → true
     *
     * pow(2)
     * → true
     *
     * pow(4)
     * → true
     *
     * pow(8)
     * → true
     *
     * pow(16)
     * → true
     *
     *
     * FINAL:
     *
     * 16 is a power of 2.
     *
     *
     * =========================================================
     * DRY RUN — n = 6
     * =========================================================
     *
     * pow(6)
     *
     * 6 == 1?
     * NO
     *
     * 6 <= 0?
     * NO
     *
     * 6 is odd?
     * NO
     *
     * → pow(3)
     *
     *
     * ---------------------------------------------------------
     *
     * pow(3)
     *
     * 3 == 1?
     * NO
     *
     * 3 is odd.
     *
     * → false
     *
     *
     * FINAL:
     *
     * 6 is NOT a power of 2.
     *
     *
     * =========================================================
     * DRY RUN — n = 10
     * =========================================================
     *
     * pow(10)
     *     ↓
     * pow(5)
     *     ↓
     * 5 is odd
     *     ↓
     * false
     *
     *
     * FINAL:
     *
     * 10 → false
     *
     *
     * =========================================================
     * DRY RUN — n = 1
     * =========================================================
     *
     * pow(1)
     *
     * n == 1
     *
     * → true
     *
     *
     * 1 = 2^0
     *
     *
     * =========================================================
     * WHY (n & 1)?
     * =========================================================
     *
     * We use:
     *
     *     (n & 1)
     *
     * to check whether n is odd or even.
     *
     *
     * EVEN:
     *
     * 8 in binary:
     *
     * 1000
     *
     * Last bit = 0
     *
     * 8 & 1 = 0
     *
     *
     * ODD:
     *
     * 7 in binary:
     *
     * 0111
     *
     * Last bit = 1
     *
     * 7 & 1 = 1
     *
     *
     * Therefore:
     *
     * (n & 1) == 0
     *     → EVEN
     *
     * (n & 1) != 0
     *     → ODD
     *
     *
     * =========================================================
     * PATTERN RECOGNITION
     * =========================================================
     *
     * If you see:
     *
     * • Power of 2
     * • Repeated division
     * • Number becomes half
     * • Reach 1
     *
     * Think:
     *
     * DIVIDE BY 2 RECURSION
     *
     *
     * Pattern:
     *
     * n
     * ↓
     * n / 2
     * ↓
     * n / 4
     * ↓
     * n / 8
     * ↓
     * ...
     * ↓
     * 1
     *
     *
     * =========================================================
     * CONNECTION WITH G61
     * =========================================================
     *
     * G61 Fast Exponentiation:
     *
     * n
     * ↓
     * n / 2
     * ↓
     * n / 4
     * ↓
     * ...
     *
     *
     * Power of Two:
     *
     * n
     * ↓
     * n / 2
     * ↓
     * n / 4
     * ↓
     * ...
     * ↓
     * 1
     *
     *
     * SAME CORE PATTERN:
     *
     * DIVIDE THE STATE BY 2
     *          ↓
     * SOLVE THE SMALLER STATE
     *
     *
     * =========================================================
     * COMPLEXITY
     * =========================================================
     *
     * Every call divides n by 2.
     *
     * Therefore:
     *
     * Time  : O(log n)
     * Space : O(log n)
     *
     *
     * =========================================================
     * REVISION CARD
     * =========================================================
     *
     * Power of Two
     *
     * Base:
     *
     * n == 1 → true
     *
     * Invalid:
     *
     * n <= 0 → false
     *
     * odd → false
     *
     * Recursive:
     *
     * pow(n / 2)
     *
     *
     * Mental Model:
     *
     * "KEEP HALVING UNTIL I REACH 1."
     *
     *
     * CORE:
     *
     * EVEN → DIVIDE BY 2
     * ODD  → FALSE
     * 1    → TRUE
     *
     * =========================================================
     */
//===========================================================================================================

}


/*
 * =========================================================
 * DRY RUN — POSITIVE EXPONENT
 * =========================================================
 *
 * Input:
 *
 * x = 2
 * n = 10
 *
 * Call:
 *
 * fastExponentiation(2, 10)
 *         ↓
 * pow(2, 10)
 *
 *
 * GOING DOWN
 *
 * pow(2, 10)
 *      ↓
 * pow(2, 5)
 *      ↓
 * pow(2, 2)
 *      ↓
 * pow(2, 1)
 *      ↓
 * pow(2, 0)
 *
 *
 * BASE CASE
 *
 * pow(2, 0)
 * → 1
 *
 *
 * COMING BACK
 *
 * 1. pow(2, 1)
 *
 * half = 1
 * 1 is ODD
 *
 * 2 * 1 * 1
 * = 2
 *
 *
 * 2. pow(2, 2)
 *
 * half = 2
 * 2 is EVEN
 *
 * 2 * 2
 * = 4
 *
 *
 * 3. pow(2, 5)
 *
 * half = 4
 * 5 is ODD
 *
 * 2 * 4 * 4
 * = 32
 *
 *
 * 4. pow(2, 10)
 *
 * half = 32
 * 10 is EVEN
 *
 * 32 * 32
 * = 1024
 *
 *
 * FINAL ANSWER:
 *
 * 2^10 = 1024
 *
 *
 * RECURSION FLOW:
 *
 * pow(2,10)
 *     ↓
 * pow(2,5)
 *     ↓
 * pow(2,2)
 *     ↓
 * pow(2,1)
 *     ↓
 * pow(2,0)
 *     ↓
 *     1
 *
 * RETURN:
 *
 * 1 → 2 → 4 → 32 → 1024
 *
 *
 * =========================================================
 * DRY RUN — NEGATIVE EXPONENT
 * =========================================================
 *
 * Input:
 *
 * x = 2
 * n = -3
 *
 * Step 1:
 *
 * N = -3
 *
 * N < 0 → TRUE
 *
 *
 * Step 2:
 *
 * N = -N
 * N = 3
 *
 *
 * Step 3:
 *
 * x = 1 / x
 * x = 1 / 2
 * x = 0.5
 *
 *
 * Original:
 *
 * 2^(-3)
 *
 * becomes:
 *
 * (1/2)^3
 *
 *
 * Now:
 *
 * pow(0.5, 3)
 *       ↓
 * pow(0.5, 1)
 *       ↓
 * pow(0.5, 0)
 *       ↓
 * 1
 *
 *
 * Return:
 *
 * pow(0.5, 1)
 * = 0.5 * 1 * 1
 * = 0.5
 *
 * pow(0.5, 3)
 * = 0.5 * 0.5 * 0.5
 * = 0.125
 *
 *
 * FINAL:
 *
 * 2^(-3) = 0.125
 *
 *
 * =========================================================
 * MENTAL MODEL
 * =========================================================
 *
 * Positive:
 *
 * n
 * ↓
 * n / 2
 * ↓
 * n / 4
 * ↓
 * n / 8
 * ↓
 * ...
 * ↓
 * 0
 *
 * Negative:
 *
 * x^(-n)
 * ↓
 * (1/x)^n
 * ↓
 * normal fast exponentiation
 *
 *
 * Core Idea:
 *
 * HALF → SQUARE → ADD x IF ODD
 *
 * Negative Exponent:
 *
 * MAKE n POSITIVE + CHANGE x TO 1/x
 * =========================================================
 */
/*
 * =========================================================
 * ADDITIONAL PROBLEM — Power of Two
 * Pattern : Mathematical / Divide-by-2 Recursion
 * Platform: LeetCode 231 style
 *
 * Problem:
 *
 * Given an integer n, determine whether n is a power of 2.
 *
 * Examples:
 *
 * 1  → true
 * 2  → true
 * 4  → true
 * 8  → true
 * 16 → true
 *
 * 6  → false
 * 10 → false
 * 0  → false
 * -2 → false
 *
 *
 * =========================================================
 * KEY IDEA
 * =========================================================
 *
 * A power of 2 can be repeatedly divided by 2
 * and eventually reach 1.
 *
 * Example:
 *
 * 16
 * ↓
 * 8
 * ↓
 * 4
 * ↓
 * 2
 * ↓
 * 1
 *
 * Therefore:
 *
 * 16 is a power of 2.
 *
 *
 * =========================================================
 * RECURSIVE THINKING
 * =========================================================
 *
 * We ask:
 *
 * "Can n be divided by 2?"
 *
 * If YES:
 *
 *     n → n / 2
 *
 * Then ask the same question again.
 *
 * If we reach:
 *
 *     n == 1
 *
 * → true
 *
 *
 * If n becomes:
 *
 *     0
 *     negative
 *     odd number other than 1
 *
 * → false
 *
 *
 * =========================================================
 * BASE CASE
 * =========================================================
 *
 * n == 1
 *     → true
 *
 *
 * =========================================================
 * INVALID CASE
 * =========================================================
 *
 * n <= 0
 *     → false
 *
 * OR
 *
 * n is odd
 *     → false
 *
 * Because powers of 2 are even except 1.
 *
 *
 * =========================================================
 * RECURSIVE FORMULA
 * =========================================================
 *
 * pow(n)
 *
 * if n == 1
 *     → true
 *
 * if n <= 0 OR n is odd
 *     → false
 *
 * otherwise:
 *
 *     pow(n / 2)
 *
 *
 * =========================================================
 * CODE
 * =========================================================
 */

