package DSA.A_Recursion.G_Mathematical_Number_Recursion;

/*
 * =========================================================
 * G68 — Josephus Problem
 * LeetCode 1823 — Find the Winner of the Circular Game
 * Pattern : Recursion / Reduce + Transform
 * =========================================================
 *
 * Example:
 *
 *     n = 5
 *     k = 2
 *
 * People:
 *
 *     1  2  3  4  5
 *
 * Elimination:
 *
 *     2 → 4 → 1 → 5
 *
 * Winner:
 *
 *     3
 *
 *
 * =========================================================
 * KISS INTUITION
 * =========================================================
 *
 * BIG PROBLEM
 *      ↓
 * SMALLER PROBLEM
 *      ↓
 * SOLVE SMALLER
 *      ↓
 * TRANSFORM ANSWER
 *      ↓
 * CURRENT ANSWER
 *
 *
 * Main recursive reduction:
 *
 *     n → n - 1
 *
 *
 * Think:
 *
 *     "Solve the smaller circle first."
 *
 *
 * =========================================================
 * THE IMPORTANT PATTERN
 * =========================================================
 *
 * General recursion pattern:
 *
 *     solve(n)
 *
 *         ↓
 *
 *     solve(n - 1)
 *
 *         ↓
 *
 *     smallerAnswer
 *
 *         ↓
 *
 *     transform smallerAnswer
 *
 *         ↓
 *
 *     currentAnswer
 *
 *
 * Josephus is one example of this
 * REDUCE + TRANSFORM pattern.
 *
 *
 * =========================================================
 * TWO VALID INDEXING APPROACHES
 * =========================================================
 *
 *
 * APPROACH 1 — 0-BASED
 *
 * Positions:
 *
 *     0  1  2  3  4
 *
 * Base:
 *
 *     n == 1 → 0
 *
 * Formula:
 *
 *     (winner + k) % n
 *
 * Final:
 *
 *     index + 1
 *
 *
 *
 * APPROACH 2 — 1-BASED
 *
 * People:
 *
 *     1  2  3  4  5
 *
 * Base:
 *
 *     n == 1 → 1
 *
 * Formula:
 *
 *     (winner + k - 1) % n + 1
 *
 * Final:
 *
 *     no extra +1
 *
 *
 * =========================================================
 * IMPORTANT
 * =========================================================
 *
 * DO NOT MIX THE TWO APPROACHES.
 *
 *
 * 0-BASED:
 *
 *     base = 0
 *     formula = (winner + k) % n
 *     final = +1
 *
 *
 * 1-BASED:
 *
 *     base = 1
 *     formula = (winner + k - 1) % n + 1
 *     final = nothing
 *
 *
 * =========================================================
 */


public class G68JosephusProblem {


    /*
     * =====================================================
     * APPROACH 1 — 0-BASED INDEX
     * =====================================================
     *
     * Helper returns:
     *
     *     0-based winner INDEX
     *
     *
     * Example:
     *
     *     0  1  2  3  4
     *              ↑
     *            winner
     *
     * means person:
     *
     *     3
     */
    private static int josephusZeroBased(int n, int k) {

        // -------------------------------------------------
        // BASE CASE
        // -------------------------------------------------
        //
        // One person means only index 0 exists.
        //
        if (n == 1) {
            return 0;
        }

        // -------------------------------------------------
        // SOLVE SMALLER PROBLEM
        // -------------------------------------------------
        //
        // n → n - 1
        //
        int winner = josephusZeroBased(n - 1, k);

        // -------------------------------------------------
        // TRANSFORM
        // -------------------------------------------------
        //
        // + k
        //     → shift the winner
        //
        // % n
        //     → circular wrap-around
        //
        return (winner + k) % n;
    }


    /*
     * =====================================================
     * 0-BASED PUBLIC METHOD
     * =====================================================
     *
     * Helper returns an INDEX.
     *
     * Problem wants a PERSON NUMBER.
     *
     * Therefore:
     *
     *     index + 1
     */
    public static int findWinnerZeroBased(int n, int k) {

        return josephusZeroBased(n, k) + 1;
    }


    /*
     * =====================================================
     * APPROACH 2 — 1-BASED
     * =====================================================
     *
     * Here we directly work with:
     *
     *     1  2  3  4  5
     *
     * The method returns the actual
     * person number.
     */
    public static int findWinnerOneBased(int n, int k) {

        // -------------------------------------------------
        // BASE CASE
        // -------------------------------------------------
        //
        // One person remains.
        //
        // That person's number is 1.
        //
        if (n == 1) {
            return 1;
        }

        // -------------------------------------------------
        // SOLVE SMALLER PROBLEM
        // -------------------------------------------------
        //
        int winner = findWinnerOneBased(n - 1, k);

        // -------------------------------------------------
        // TRANSFORM
        // -------------------------------------------------
        //
        // 1-based Josephus formula:
        //
        //     (winner + k - 1) % n + 1
        //
        //
        // k - 1:
        //     adjusts the 1-based position
        //
        // % n:
        //     circular wrap-around
        //
        // + 1:
        //     returns to 1-based numbering
        //
        return (winner + k - 1) % n + 1;
    }


    /*
     * =====================================================
     * MAIN — COMPARE BOTH APPROACHES
     * =====================================================
     */
    public static void main(String[] args) {

        int n = 5;
        int k = 2;

        int answerZeroBased = findWinnerZeroBased(n, k);

        int answerOneBased = findWinnerOneBased(n, k);

        System.out.println("0-Based Approach = " + answerZeroBased);

        System.out.println("1-Based Approach = " + answerOneBased);
    }
}


/*
 * =========================================================
 * DRY RUN — BOTH APPROACHES
 * =========================================================
 *
 * Input:
 *
 *     n = 5
 *     k = 2
 *
 *
 * =========================================================
 * APPROACH 1 — 0-BASED
 * =========================================================
 *
 * Going Down:
 *
 *     josephus(5)
 *          ↓
 *     josephus(4)
 *          ↓
 *     josephus(3)
 *          ↓
 *     josephus(2)
 *          ↓
 *     josephus(1)
 *
 *
 * Base:
 *
 *     josephus(1) = 0
 *
 *
 * Coming Back:
 *
 *
 * josephus(2):
 *
 *     (0 + 2) % 2
 *
 *     = 0
 *
 *
 * josephus(3):
 *
 *     (0 + 2) % 3
 *
 *     = 2
 *
 *
 * josephus(4):
 *
 *     (2 + 2) % 4
 *
 *     = 0
 *
 *
 * josephus(5):
 *
 *     (0 + 2) % 5
 *
 *     = 2
 *
 *
 * Helper answer:
 *
 *     2
 *
 * This is an INDEX.
 *
 *
 * Convert:
 *
 *     2 + 1 = 3
 *
 *
 * Final:
 *
 *     3
 *
 *
 * =========================================================
 * APPROACH 2 — 1-BASED
 * =========================================================
 *
 * Going Down:
 *
 *     find(5)
 *       ↓
 *     find(4)
 *       ↓
 *     find(3)
 *       ↓
 *     find(2)
 *       ↓
 *     find(1)
 *
 *
 * Base:
 *
 *     find(1) = 1
 *
 *
 * Coming Back:
 *
 *
 * find(2):
 *
 *     (((1 + 2 - 1) % 2) + 1)
 *     -> ((2) % 2)
 *     -> ((0) + 1)
 *     -> (1)
 *     = 1
 *
 *
 * find(3):
 *
 *     (((1 + 2 - 1) % 3) + 1)
 *     -> ((2) % 3) --> 2/3 --> 2 - 0 --> Rem = 2
 *     -> ((Rem = 2) + 1)
 *     = 3
 *
 *
 * find(4):
 *
 *     (3 + 2 - 1) % 4 + 1
 *     -> ((4) % 4) --> 4/4 --> 4 - 4 --> Rem = 0
 *     -> ((Rem = 0) + 1)
 *     = 1
 *
 *
 * find(5):
 *
 *     (1 + 2 - 1) % 5 + 1
 *     -> ((2) % 5) --> 2/5 --> 2 - 0 --> Rem = 2
 *     -> ((Rem = 2) + 1)
 *     = 3
 *
 *
 * Final:
 *
 *     3
 *
 *
 * =========================================================
 * BOTH GIVE THE SAME ANSWER
 * =========================================================
 *
 *
 * 0-Based:
 *
 *     helper → 2
 *     convert → 2 + 1
 *     answer → 3
 *
 *
 * 1-Based:
 *
 *     directly → 3
 *
 *
 * =========================================================
 * WHY 0-BASED FORMULA IS SIMPLER
 * =========================================================
 *
 * 0-based:
 *
 *     (winner + k) % n
 *
 *
 * 1-based:
 *
 *     (winner + k - 1) % n + 1
 *
 *
 * The 0-based version is mathematically
 * cleaner because array indexes naturally start at 0.
 *
 *
 * =========================================================
 * WHY 1-BASED VERSION IS EASY TO READ
 * =========================================================
 *
 * It matches the problem directly:
 *
 *     Person 1
 *     Person 2
 *     Person 3
 *     ...
 *
 *
 * Base:
 *
 *     one person → person 1
 *
 *
 * Therefore it can sometimes feel
 * more intuitive while learning.
 *
 *
 * =========================================================
 * ACTUAL GAME — n = 5, k = 2
 * =========================================================
 *
 * Start:
 *
 *     1  2  3  4  5
 *
 *
 * Count:
 *
 *     1 → 2
 *
 * Remove:
 *
 *     2
 *
 *
 * Next start:
 *
 *     3
 *
 *
 * Count:
 *
 *     3 → 4
 *
 * Remove:
 *
 *     4
 *
 *
 * Next start:
 *
 *     5
 *
 *
 * Count:
 *
 *     5 → 1
 *
 * Remove:
 *
 *     1
 *
 *
 * Next start:
 *
 *     3
 *
 *
 * Count:
 *
 *     3 → 5
 *
 * Remove:
 *
 *     5
 *
 *
 * Remaining:
 *
 *     3
 *
 *
 * Winner:
 *
 *     3
 *
 *
 * =========================================================
 * REUSABLE RECURSION PATTERN
 * =========================================================
 *
 * This is MORE important than Josephus itself.
 *
 *
 * When you see:
 *
 *     BIG PROBLEM
 *          ↓
 *     SMALLER SAME PROBLEM
 *
 * Ask:
 *
 *     1. What is becoming smaller?
 *
 *     2. What is the base case?
 *
 *     3. What does the recursive function return?
 *
 *     4. How can I transform that answer
 *        into the current answer?
 *
 *
 * General template:
 *
 *
 *     solve(problem) {
 *
 *         if (baseCase) {
 *             return baseAnswer;
 *         }
 *
 *         answer = solve(smallerProblem);
 *
 *         return transform(answer);
 *     }
 *
 *
 * Josephus:
 *
 *
 *     solve(n)
 *          ↓
 *     solve(n - 1)
 *          ↓
 *     transform(winner)
 *
 *
 * =========================================================
 * HOW TO RECOGNIZE THIS PATTERN
 * =========================================================
 *
 * Look for:
 *
 *     "Find answer for n"
 *
 * where:
 *
 *     n can become n - 1
 *
 * and:
 *
 *     the n - 1 problem has the SAME structure.
 *
 *
 * Then think:
 *
 *     "Can I solve n - 1 first?"
 *
 *
 * If YES:
 *
 *     solve smaller
 *          ↓
 *     transform smaller answer
 *
 *
 * =========================================================
 * DEBUGGING CHECKLIST
 * =========================================================
 *
 * If answer is wrong, check:
 *
 *
 * 1. BASE CASE
 *
 *     0-based → return 0
 *
 *     1-based → return 1
 *
 *
 * 2. RECURSIVE SIZE
 *
 *     n - 1
 *
 *
 * 3. RETURN MEANING
 *
 *     Is it an index?
 *
 *     Or an actual person number?
 *
 *
 * 4. FORMULA
 *
 * 0-based:
 *
 *     (winner + k) % n
 *
 *
 * 1-based:
 *
 *     (winner + k - 1) % n + 1
 *
 *
 * 5. DON'T MIX THEM
 *
 *
 * =========================================================
 * COMPLEXITY
 * =========================================================
 *
 * One recursive call per n.
 *
 *     n
 *      ↓
 *     n - 1
 *      ↓
 *     n - 2
 *      ↓
 *     ...
 *      ↓
 *     1
 *
 *
 * Time:
 *
 *     O(n)
 *
 * Space:
 *
 *     O(n)
 *
 * because of recursion stack.
 *
 *
 * =========================================================
 * FINAL REVISION CARD
 * =========================================================
 *
 *
 * JOSEPHUS = REDUCE + TRANSFORM
 *
 *
 * Reduce:
 *
 *     n → n - 1
 *
 *
 * Solve:
 *
 *     smaller problem
 *
 *
 * Transform:
 *
 *     smaller answer
 *          ↓
 *     current answer
 *
 *
 * 0-BASED:
 *
 *     base = 0
 *
 *     formula:
 *
 *     (winner + k) % n
 *
 *     final:
 *
 *     + 1
 *
 *
 * 1-BASED:
 *
 *     base = 1
 *
 *     formula:
 *
 *     (winner + k - 1) % n + 1
 *
 *     final:
 *
 *     nothing
 *
 *
 * =========================================================
 * ONE-LINE MEMORY
 * =========================================================
 *
 *     "Solve n-1, then transform its answer for n."
 *
 * =========================================================
 */