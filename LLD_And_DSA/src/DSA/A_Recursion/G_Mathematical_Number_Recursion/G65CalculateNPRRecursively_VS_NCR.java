package DSA.A_Recursion.G_Mathematical_Number_Recursion;
/*
 * =========================================================
 * G64 — nCr vs G65 — nPr
 * =========================================================
 *
 * IMPORTANT DIFFERENCE
 *
 * nCr → Combination
 *      Order DOES NOT matter
 *
 * nPr → Permutation
 *      Order DOES matter
 *
 *
 * =========================================================
 * G64 — nCr
 * =========================================================
 *
 * MAIN IDEA:
 *
 * CHOOSE
 *    OR
 * DON'T CHOOSE
 *
 * Therefore:
 *
 * nCr
 * =
 * (n-1)C(r-1)
 * +
 * (n-1)Cr
 *
 *
 * BASE CASES:
 *
 * n < r → 0
 *
 * r == 0 → 1
 *
 * n == r → 1
 *
 *
 * IMPORTANT MISTAKE:
 *
 * nC1 is NOT always 1.
 *
 * Example:
 *
 * 5C1 = 5
 *
 * So:
 *
 * r == 1 → DO NOT return 1
 *
 *
 * =========================================================
 * G65 — nPr
 * =========================================================
 *
 * MAIN IDEA:
 *
 * ARRANGE / PICK ONE
 *
 * Therefore:
 *
 * nPr
 * =
 * n × (n-1)P(r-1)
 *
 *
 * BASE CASES:
 *
 * n < r → 0
 *
 * r == 0 → 1
 *
 *
 * IMPORTANT MISTAKE:
 *
 * nPr does NOT have:
 *
 * n == r → 1
 *
 * Example:
 *
 * 5P5 = 5 × 4 × 3 × 2 × 1
 *     = 120
 *
 *
 * =========================================================
 */

public class G65CalculateNPRRecursively_VS_NCR {

    /*
     * =====================================================
     * G64 — nCr
     * =====================================================
     *
     * nCr = CHOOSE + DON'T CHOOSE
     *
     * TWO recursive calls.
     */
    public static long nCr(int n, int r) {

        // Cannot choose more items than available.
        if (n < r) {
            return 0;
        }

        // Base Case:
        //
        // nC0 = 1
        // nCn = 1
        if (r == 0 || n == r) {
            return 1;
        }

        // CHOOSE current item
        //
        // +
        //
        // DON'T CHOOSE current item
        return nCr(n - 1, r - 1)
                + nCr(n - 1, r);
    }


    /*
     * =====================================================
     * G65 — nPr
     * =====================================================
     *
     * nPr = n × (n-1)P(r-1)
     *
     * ONE recursive call.
     */
    public static long nPr(int n, int r) {

        // Cannot arrange more items than available.
        if (n < r) {
            return 0;
        }

        // Base Case:
        //
        // nP0 = 1
        //
        // There is one way to arrange zero items.
        if (r == 0) {
            return 1;
        }

        // Choose one item:
        // n choices
        //
        // Then arrange the remaining r-1 items.
        return n * nPr(n - 1, r - 1);
    }


    /*
     * =====================================================
     * MAIN — TEST
     * =====================================================
     */
    public static void main(String[] args) {

        // -------------------------
        // G64 — Combination
        // -------------------------

        System.out.println("5C2 = " + nCr(5, 2));

        // 5C2 = 10


        // -------------------------
        // G65 — Permutation
        // -------------------------

        System.out.println("5P2 = " + nPr(5, 2));

        // 5P2 = 20


        // -------------------------
        // Important Difference
        // -------------------------

        System.out.println("5C5 = " + nCr(5, 5));

        // 5C5 = 1

        System.out.println("5P5 = " + nPr(5, 5));

        // 5P5 = 120
    }
}


/*
 * =========================================================
 * QUICK DRY RUN
 * =========================================================
 *
 *
 * G64 — 5C2
 *
 * 5C2
 * ↓
 * 4C1 + 4C2
 *
 * CHOOSE
 * +
 * DON'T CHOOSE
 *
 *
 * =========================================================
 *
 *
 * G65 — 5P2
 *
 * 5P2
 * ↓
 * 5 × 4P1
 * ↓
 * 5 × 4 × 3P0
 * ↓
 * 5 × 4 × 1
 * ↓
 * 20
 *
 *
 * =========================================================
 * MEMORY
 * =========================================================
 *
 * nCr
 * ↓
 * TWO BRANCHES
 * ↓
 * ADD
 *
 *
 * nPr
 * ↓
 * ONE BRANCH
 * ↓
 * MULTIPLY
 *
 *
 * =========================================================
 * BASE CASE MEMORY
 * =========================================================
 *
 * nCr:
 *
 * n < r       → 0
 * r == 0      → 1
 * n == r      → 1
 *
 *
 * nPr:
 *
 * n < r       → 0
 * r == 0      → 1
 *
 *
 * =========================================================
 * MOST IMPORTANT
 * =========================================================
 *
 * nCr:
 *
 * "CHOOSE OR DON'T CHOOSE"
 *
 *
 * nPr:
 *
 * "CHOOSE ONE AND ARRANGE"
 *
 * =========================================================
 */