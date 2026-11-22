package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G63 — Divide Two Integers Recursively
 * Pattern : Mathematical / Recursive Subtraction
 * Platform: Coding Ninjas / Interview
 *
 * Problem:
 * Divide two integers using recursion.
 *
 * Example:
 *
 * 17 / 5 = 3
 *
 * Because:
 *
 * 17 - 5 = 12   → 1 subtraction
 * 12 - 5 = 7    → 2 subtractions
 *  7 - 5 = 2    → 3 subtractions
 *
 * Now:
 *
 * 2 < 5
 *
 * Stop.
 *
 * Answer = 3
 *
 *
 * =========================================================
 * CORE IDEA
 * =========================================================
 *
 * Division = Repeated Subtraction
 *
 * Every successful subtraction:
 *
 * quotient + 1
 *
 *
 * Base Case:
 *
 * dividend < divisor
 *        ↓
 *        0
 *
 *
 * Recursive:
 *
 * 1 + divide(dividend - divisor, divisor)
 *
 *
 * Time  : O(dividend / divisor)
 * Space : O(dividend / divisor)
 * =========================================================
 */

public class G63DivideTwoNumbersRecursively {

    /*
     * =====================================================
     * COMPUTE POSITIVE QUOTIENT
     * =====================================================
     */

    public static int computeQuotient(int absDividend, int absDivisor) {

        // Base Case:
        //
        // We cannot subtract divisor anymore.
        //
        // Example:
        //
        // 2 / 5
        //
        // 2 < 5
        // → 0
        if (absDividend < absDivisor) {
            return 0;
        }

        // One successful subtraction
        // means one more count in quotient.
        return 1 + computeQuotient(absDividend - absDivisor, absDivisor);
    }


    /*
     * =====================================================
     * MAIN DIVISION METHOD
     * =====================================================
     */

    public static int divideTwoInteger(int dividend, int divisor) {

        // Cannot divide by zero.
        if (divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }


        // =================================================
        // SIGN
        // =================================================
        //
        // Start with positive answer.
        //
        int sign = 1;

        /*
         * If EXACTLY ONE number is negative,
         * the answer is negative.
         *
         * Easy table:
         *
         * Dividend | Divisor | Signs | Answer
         * ---------|---------|-------|--------
         *    17    |    5    | + / + |  +3
         *   -17    |    5    | - / + |  -3
         *    17    |   -5    | + / - |  -3
         *   -17    |   -5    | - / - |  +3
         *
         *
         * KISS:
         *
         * + / + → +
         * - / + → -
         * + / - → -
         * - / - → +
         *
         *
         * Remember:
         *
         * One negative  → negative
         * Two negatives  → positive
         *
         *
         * The condition below checks TWO possibilities:
         *
         * 1. dividend is negative AND divisor is positive
         *
         * OR
         *
         * 2. dividend is positive AND divisor is negative
         *
         * || means OR.
         */

        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {

            sign = -1;
        }


        // =================================================
        // ABSOLUTE VALUES
        // =================================================
        //
        // Now calculate the quotient using positive values.
        //
        // Example:
        //
        // -17 / 5
        //
        // becomes:
        //
        // 17 / 5
        //
        // We apply the negative sign at the end.
        //
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);


        // Calculate positive quotient.
        int quotient = computeQuotient(absDividend, absDivisor);


        // Apply the original sign.
        return quotient * sign;
    }


    /*
     * =====================================================
     * MAIN
     * =====================================================
     */

    public static void main(String[] args) {

        int dividend = 17;
        int divisor = 5;

        int result = divideTwoInteger(dividend, divisor);

        System.out.println("Quotient = " + result);
    }
}


/*
 * =========================================================
 * DRY RUN — 17 / 5
 * =========================================================
 *
 * Input:
 *
 * dividend = 17
 * divisor  = 5
 *
 *
 * Both are positive.
 *
 * sign = 1
 *
 *
 * Call:
 *
 * computeQuotient(17, 5)
 *
 *
 * ---------------------------------------------------------
 * CALL 1
 * ---------------------------------------------------------
 *
 * 17 < 5 ?
 *
 * NO
 *
 * Subtract:
 *
 * 17 - 5 = 12
 *
 * Count:
 *
 * +1
 *
 * Therefore:
 *
 * 1 + computeQuotient(12, 5)
 *
 *
 * ---------------------------------------------------------
 * CALL 2
 * ---------------------------------------------------------
 *
 * computeQuotient(12, 5)
 *
 * 12 < 5 ?
 *
 * NO
 *
 * 12 - 5 = 7
 *
 * Count:
 *
 * +1
 *
 * Therefore:
 *
 * 1 + computeQuotient(7, 5)
 *
 *
 * ---------------------------------------------------------
 * CALL 3
 * ---------------------------------------------------------
 *
 * computeQuotient(7, 5)
 *
 * 7 < 5 ?
 *
 * NO
 *
 * 7 - 5 = 2
 *
 * Count:
 *
 * +1
 *
 * Therefore:
 *
 * 1 + computeQuotient(2, 5)
 *
 *
 * ---------------------------------------------------------
 * CALL 4
 * ---------------------------------------------------------
 *
 * computeQuotient(2, 5)
 *
 * 2 < 5 ?
 *
 * YES
 *
 * → return 0
 *
 *
 * =========================================================
 * COMING BACK
 * =========================================================
 *
 * computeQuotient(2,5)
 *
 * → 0
 *
 *
 * computeQuotient(7,5)
 *
 * → 1 + 0
 * → 1
 *
 *
 * computeQuotient(12,5)
 *
 * → 1 + 1
 * → 2
 *
 *
 * computeQuotient(17,5)
 *
 * → 1 + 2
 * → 3
 *
 *
 * FINAL:
 *
 * 17 / 5 = 3
 *
 *
 * =========================================================
 * RECURSION FLOW
 * =========================================================
 *
 * compute(17,5)
 *       ↓
 * compute(12,5)
 *       ↓
 * compute(7,5)
 *       ↓
 * compute(2,5)
 *       ↓
 *       0
 *
 *
 * RETURN:
 *
 * 0 → 1 → 2 → 3
 *
 *
 * =========================================================
 * DRY RUN — 20 / 5
 * =========================================================
 *
 * compute(20,5)
 *       ↓
 * compute(15,5)
 *       ↓
 * compute(10,5)
 *       ↓
 * compute(5,5)
 *       ↓
 * compute(0,5)
 *
 *
 * Base:
 *
 * 0 < 5
 * → 0
 *
 *
 * Returning:
 *
 * 0 → 1 → 2 → 3 → 4
 *
 *
 * FINAL:
 *
 * 20 / 5 = 4
 *
 *
 * =========================================================
 * DRY RUN — 4 / 5
 * =========================================================
 *
 * compute(4,5)
 *
 * 4 < 5
 *
 * → 0
 *
 *
 * FINAL:
 *
 * 4 / 5 = 0
 *
 *
 * =========================================================
 * DRY RUN — (-17) / 5
 * =========================================================
 *
 * dividend = -17
 * divisor  = 5
 *
 *
 * Check sign:
 *
 * dividend < 0 → YES
 * divisor > 0  → YES
 *
 * Therefore:
 *
 * sign = -1
 *
 *
 * Now use absolute values:
 *
 * absDividend = 17
 * absDivisor  = 5
 *
 *
 * computeQuotient(17,5)
 *
 * → 3
 *
 *
 * Apply sign:
 *
 * 3 × -1
 * = -3
 *
 *
 * FINAL:
 *
 * -17 / 5 = -3
 *
 *
 * =========================================================
 * DRY RUN — 17 / (-5)
 * =========================================================
 *
 * dividend = 17
 * divisor  = -5
 *
 *
 * Check sign:
 *
 * dividend > 0 → YES
 * divisor < 0  → YES
 *
 * Therefore:
 *
 * sign = -1
 *
 *
 * Absolute values:
 *
 * 17 / 5
 *
 * → 3
 *
 *
 * Apply sign:
 *
 * 3 × -1
 * = -3
 *
 *
 * FINAL:
 *
 * 17 / -5 = -3
 *
 *
 * =========================================================
 * DRY RUN — (-17) / (-5)
 * =========================================================
 *
 * Both numbers are negative.
 *
 * Therefore:
 *
 * sign = 1
 *
 *
 * Absolute values:
 *
 * 17 / 5
 *
 * → 3
 *
 *
 * Apply sign:
 *
 * 3 × 1
 * = 3
 *
 *
 * FINAL:
 *
 * -17 / -5 = 3
 *
 *
 * =========================================================
 * HOW TO UNDERSTAND THE PATTERN
 * =========================================================
 *
 * Ask yourself:
 *
 * "How many times can I subtract divisor?"
 *
 *
 * Example:
 *
 * 17 / 5
 *
 *
 * 17
 * ↓ -5
 * 12    → 1
 *
 * ↓ -5
 * 7     → 2
 *
 * ↓ -5
 * 2     → 3
 *
 *
 * Stop:
 *
 * 2 < 5
 *
 *
 * Answer = 3
 *
 *
 * =========================================================
 * CONNECTION WITH G62
 * =========================================================
 *
 * G62 — Multiplication
 *
 * Multiplication
 *       ↓
 * Repeated Addition
 *
 *
 * G63 — Division
 *
 * Division
 *       ↓
 * Repeated Subtraction
 *
 *
 * Remember:
 *
 * MULTIPLY
 *     ↓
 * ADD
 *
 *
 * DIVIDE
 *     ↓
 * SUBTRACT
 *
 *
 * =========================================================
 * PATTERN RECOGNITION
 * =========================================================
 *
 * If the problem says:
 *
 * "Divide without using /"
 *
 * and recursion is required:
 *
 * Think:
 *
 * DIVISION
 *     ↓
 * REPEATED SUBTRACTION
 *     ↓
 * COUNT SUCCESSFUL SUBTRACTIONS
 *
 *
 * =========================================================
 * REVISION CARD
 * =========================================================
 *
 * G63 — Divide Two Integers
 *
 * Base:
 *
 * dividend < divisor
 * → 0
 *
 *
 * Recursive:
 *
 * 1 + divide(
 *     dividend - divisor,
 *     divisor
 * )
 *
 *
 * Sign:
 *
 * + / + → +
 * - / + → -
 * + / - → -
 * - / - → +
 *
 *
 * Mental Model:
 *
 * "HOW MANY TIMES CAN I SUBTRACT?"
 *
 *
 * CORE:
 *
 * SUBTRACT → COUNT → REPEAT
 *
 * =========================================================
 */