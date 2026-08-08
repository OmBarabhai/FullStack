package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G62 — Multiply Two Numbers Recursively
 * Pattern : Mathematical / Divide-by-2 Recursion
 * Platform: Coding Ninjas / Interview
 *
 * Problem:
 * Multiply two numbers using recursion.
 *
 * Example:
 *
 * first  = 5
 * second = 7
 *
 * Answer = 35
 *
 * ---------------------------------------------------------
 * BASIC IDEA
 * ---------------------------------------------------------
 *
 * Instead of:
 *
 * first + first + first + ...
 *
 * which can create O(n) recursion,
 * we divide second by 2.
 *
 *
 * EVEN:
 *
 * first × second
 *
 * = (first × 2) × (second / 2)
 *
 *
 * ODD:
 *
 * first × second
 *
 * = first + (first × 2) × (second / 2)
 *
 *
 * BASE CASE:
 *
 * second == 0
 * → 0
 *
 *
 * Time  : O(log n)
 * Space : O(log n)
 * =========================================================
 */

public class G62MultiplyTwoNumbersRecursively {

    // MOD required by the OA problem
    static final long MOD = 1000000007L;


    /*
     * =====================================================
     * RECURSIVE MULTIPLICATION
     * =====================================================
     */
    public static long multiplyTwoNumbersRecursively(
            long first,
            long second) {

        // -------------------------------------------------
        // BASE CASE
        // -------------------------------------------------
        //
        // Anything multiplied by 0 is 0.
        //
        // Example:
        //
        // 50 × 0 = 0
        //
        if (second == 0) {
            return 0;
        }


        // -------------------------------------------------
        // NEGATIVE SECOND
        // -------------------------------------------------
        //
        // Example:
        //
        // 5 × (-3)
        //
        // = -(5 × 3)
        //
        if (second < 0) {
            return -multiplyTwoNumbersRecursively(
                    first,
                    -second
            );
        }


        // -------------------------------------------------
        // KEEP FIRST WITHIN MOD RANGE
        // -------------------------------------------------
        //
        // We only need the remainder modulo MOD.
        //
        // Example:
        //
        // 1,000,000,010 % 1,000,000,007
        // = 3
        //
        first = first % MOD;


        // -------------------------------------------------
        // HALF OF SECOND
        // -------------------------------------------------
        //
        // This is the main optimization.
        //
        // Instead of:
        //
        // second → second - 1 → second - 1
        //
        // we do:
        //
        // second → second / 2
        //
        long half = second / 2;


        // -------------------------------------------------
        // DOUBLE FIRST
        // -------------------------------------------------
        //
        // If we halve second,
        // we compensate by doubling first.
        //
        // Example:
        //
        // 5 × 8
        //
        // = 10 × 4
        //
        long doubleFirst = (first * 2) % MOD;


        // =================================================
        // EVEN CASE
        // =================================================
        //
        // Example:
        //
        // 5 × 8
        //
        // second = 8
        // half = 4
        // doubleFirst = 10
        //
        // Therefore:
        //
        // 5 × 8
        // = 10 × 4
        //
        if ((second & 1) == 0) {

            return multiplyTwoNumbersRecursively(
                    doubleFirst,
                    half
            ) % MOD;
        }


        // =================================================
        // ODD CASE
        // =================================================
        //
        // Example:
        //
        // 5 × 7
        //
        // Take one 5 out:
        //
        // 5 × 7
        // = 5 + 5 × 6
        //
        // 6 is even:
        //
        // 5 × 6
        // = 10 × 3
        //
        // Therefore:
        //
        // 5 × 7
        // = 5 + 10 × 3
        //
        return (
                first
                        + multiplyTwoNumbersRecursively(
                        doubleFirst,
                        half
                )
        ) % MOD;
    }


    /*
     * =====================================================
     * CODING NINJAS REQUIRED METHOD
     * =====================================================
     */
    public static int recursiveProduct(int m, int n) {

        long result =
                multiplyTwoNumbersRecursively(m, n);

        // Keep result positive.
        //
        // Example:
        //
        // -1 % MOD
        // is negative in Java.
        //
        // Adding MOD makes it positive.
        result = (result + MOD) % MOD;

        return (int) result;
    }


    /*
     * =====================================================
     * MAIN — LOCAL TESTING
     * =====================================================
     */
    public static void main(String[] args) {

        long first = 5;
        long second = 7;

        long result =
                multiplyTwoNumbersRecursively(
                        first,
                        second
                );

        System.out.println("Answer = " + result);
    }
}


/*
 * =========================================================
 * DRY RUN 1 — 5 × 7
 * =========================================================
 *
 * Call:
 *
 * multiply(5, 7)
 *
 *
 * second = 7
 * half = 7 / 2 = 3
 * doubleFirst = 5 × 2 = 10
 *
 * 7 is ODD
 *
 * Therefore:
 *
 * 5 + multiply(10, 3)
 *
 *
 * ---------------------------------------------------------
 *
 * multiply(10, 3)
 *
 * half = 3 / 2 = 1
 * doubleFirst = 10 × 2 = 20
 *
 * 3 is ODD
 *
 * Therefore:
 *
 * 10 + multiply(20, 1)
 *
 *
 * ---------------------------------------------------------
 *
 * multiply(20, 1)
 *
 * half = 1 / 2 = 0
 * doubleFirst = 20 × 2 = 40
 *
 * 1 is ODD
 *
 * Therefore:
 *
 * 20 + multiply(40, 0)
 *
 *
 * ---------------------------------------------------------
 *
 * multiply(40, 0)
 *
 * Base Case
 *
 * → 0
 *
 *
 * =========================================================
 * COMING BACK
 * =========================================================
 *
 * multiply(20, 1)
 *
 * = 20 + 0
 * = 20
 *
 *
 * multiply(10, 3)
 *
 * = 10 + 20
 * = 30
 *
 *
 * multiply(5, 7)
 *
 * = 5 + 30
 * = 35
 *
 *
 * FINAL:
 *
 * 5 × 7 = 35
 *
 *
 * =========================================================
 * RECURSION TREE
 * =========================================================
 *
 * multiply(5,7)
 *      |
 *      └── multiply(10,3)
 *                |
 *                └── multiply(20,1)
 *                          |
 *                          └── multiply(40,0)
 *                                      |
 *                                      └── 0
 *
 *
 * =========================================================
 * DRY RUN 2 — 5 × 8
 * =========================================================
 *
 * multiply(5,8)
 *
 * 8 is EVEN
 *
 * half = 4
 * doubleFirst = 10
 *
 * → multiply(10,4)
 *
 *
 * multiply(10,4)
 *
 * 4 is EVEN
 *
 * half = 2
 * doubleFirst = 20
 *
 * → multiply(20,2)
 *
 *
 * multiply(20,2)
 *
 * 2 is EVEN
 *
 * half = 1
 * doubleFirst = 40
 *
 * → multiply(40,1)
 *
 *
 * multiply(40,1)
 *
 * 1 is ODD
 *
 * → 40 + multiply(80,0)
 *
 * → 40 + 0
 * → 40
 *
 *
 * FINAL:
 *
 * 5 × 8 = 40
 *
 *
 * =========================================================
 * MOD (%) — VERY SIMPLE
 * =========================================================
 *
 * % means:
 *
 * REMAINDER
 *
 *
 * Example:
 *
 * 10 % 3
 *
 * 3 × 3 = 9
 *
 * 10 - 9 = 1
 *
 * Therefore:
 *
 * 10 % 3 = 1
 *
 *
 * ---------------------------------------------------------
 *
 * Example:
 *
 * 25 % 7
 *
 * 7 × 3 = 21
 *
 * 25 - 21 = 4
 *
 * Therefore:
 *
 * 25 % 7 = 4
 *
 *
 * =========================================================
 * OUR MOD
 * =========================================================
 *
 * MOD = 1,000,000,007
 *
 *
 * Example:
 *
 * 1,000,000,010 % 1,000,000,007
 *
 * Remove one complete MOD:
 *
 * 1,000,000,010
 * -1,000,000,007
 * ----------------
 *          3
 *
 * Answer = 3
 *
 *
 * =========================================================
 * WHY DOES NINJA USE MOD?
 * =========================================================
 *
 * Example:
 *
 * 40923 × 88555
 *
 * Actual answer:
 *
 * 3,623,936,265
 *
 *
 * Java int maximum:
 *
 * 2,147,483,647
 *
 * So int is not enough.
 *
 * We use long.
 *
 *
 * Then the problem wants:
 *
 * 3,623,936,265 % 1,000,000,007
 *
 *
 * Remove three complete MODs:
 *
 * 1,000,000,007 × 3
 * = 3,000,000,021
 *
 *
 * Subtract:
 *
 * 3,623,936,265
 * -3,000,000,021
 * ----------------
 *   623,936,244
 *
 *
 * Final:
 *
 * 623,936,244
 *
 *
 * =========================================================
 * LONG VS MOD
 * =========================================================
 *
 * They solve DIFFERENT problems.
 *
 *
 * long:
 *
 * "Can Java store this number?"
 *
 *
 * MOD:
 *
 * "What remainder does the problem want?"
 *
 *
 * Example:
 *
 * 3,623,936,265
 *
 * long → can store it.
 *
 * Then:
 *
 * 3,623,936,265 % MOD
 *
 * → 623,936,244
 *
 *
 * =========================================================
 * WHY APPLY MOD DURING RECURSION?
 * =========================================================
 *
 * We have:
 *
 * first = first % MOD
 *
 * and:
 *
 * doubleFirst = (first * 2) % MOD
 *
 *
 * This prevents the values from becoming unnecessarily large.
 *
 *
 * Important property:
 *
 * (a + b) % MOD
 *
 * is the same as:
 *
 * ((a % MOD) + (b % MOD)) % MOD
 *
 *
 * Example with small MOD = 7:
 *
 * a = 10
 * b = 12
 *
 *
 * Normal:
 *
 * (10 + 12) % 7
 * = 22 % 7
 * = 1
 *
 *
 * Reduce first:
 *
 * 10 % 7 = 3
 * 12 % 7 = 5
 *
 * Then:
 *
 * (3 + 5) % 7
 * = 8 % 7
 * = 1
 *
 *
 * Same result.
 *
 *
 * Therefore we can safely use MOD during recursion.
 *
 *
 * =========================================================
 * MOD IN OUR ODD CASE
 * =========================================================
 *
 * Code:
 *
 * return (
 *     first
 *     + recursiveResult
 * ) % MOD;
 *
 *
 * Think:
 *
 * current contribution
 *       +
 * recursive contribution
 *       ↓
 *     total
 *       ↓
 *    % MOD
 *
 *
 * Example:
 *
 * first = 900,000,000
 * recursiveResult = 300,000,000
 *
 * Total:
 *
 * 1,200,000,000
 *
 * Apply MOD:
 *
 * 1,200,000,000
 * -1,000,000,007
 * ----------------
 *   199,999,993
 *
 *
 * =========================================================
 * PATTERN CONNECTION WITH G61
 * =========================================================
 *
 * G61 — Fast Exponentiation:
 *
 * n
 * ↓
 * n / 2
 * ↓
 * half
 * ↓
 * square
 * ↓
 * add x if odd
 *
 *
 * G62 — Multiplication:
 *
 * second
 * ↓
 * second / 2
 * ↓
 * half
 * ↓
 * double first
 * ↓
 * add first if odd
 *
 *
 * SAME BIG IDEA:
 *
 * BIG PROBLEM
 *      ↓
 * DIVIDE STATE BY 2
 *      ↓
 * SOLVE SMALLER PROBLEM
 *      ↓
 * COMBINE
 *
 *
 * =========================================================
 * HOW TO RECOGNIZE THIS PATTERN
 * =========================================================
 *
 * If an OA says:
 *
 * • Use recursion
 * • Numbers can be very large
 * • Simple repeated recursion is too slow
 * • Need multiplication / mathematical calculation
 *
 * Think:
 *
 * Can I divide one parameter by 2?
 *
 * If YES:
 *
 * HALF
 *   ↓
 * TRANSFORM
 *   ↓
 * RECURSE
 *   ↓
 * COMBINE
 *
 *
 * =========================================================
 * REVISION CARD
 * =========================================================
 *
 * G62 — Recursive Multiplication
 *
 * Base:
 *
 * second == 0
 * → 0
 *
 * Half:
 *
 * second / 2
 *
 * Double:
 *
 * first × 2
 *
 * EVEN:
 *
 * multiply(doubleFirst, half)
 *
 * ODD:
 *
 * first + multiply(doubleFirst, half)
 *
 * Large values:
 *
 * long
 *
 * Required remainder:
 *
 * % MOD
 *
 * Complexity:
 *
 * Time  = O(log n)
 * Space = O(log n)
 *
 *
 * CORE MEMORY:
 *
 * "HALVE SECOND
 *  → DOUBLE FIRST
 *  → ADD FIRST IF ODD
 *  → APPLY MOD"
 *
 * =========================================================
 */