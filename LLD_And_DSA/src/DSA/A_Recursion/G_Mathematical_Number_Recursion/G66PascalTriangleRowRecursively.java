package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.*;

/*
 * =========================================================
 * G66 — Pascal's Triangle Recursively
 * Pattern : Mathematical / Recursive Number Pattern
 * Platform: LeetCode 118 / LeetCode 119 style
 *
 * =========================================================
 * PROBLEM
 * =========================================================
 *
 * Generate Pascal's Triangle.
 *
 * Example:
 *
 * numRows = 5
 *
 *          1
 *        1   1
 *      1   2   1
 *    1   3   3   1
 *  1   4   6   4   1
 *
 *
 * =========================================================
 * CORE IDEA
 * =========================================================
 *
 * Every inner value is created from the two values
 * directly above it.
 *
 *
 *             3
 *            / \
 *           1   2
 *
 *       3 = 1 + 2
 *
 *
 * Formula:
 *
 * pascal(row, col)
 *
 * =
 *
 * pascal(row - 1, col - 1)
 * +
 * pascal(row - 1, col)
 *
 *
 * Easy memory:
 *
 * TOP-LEFT + TOP = CURRENT
 *
 *
 * =========================================================
 * BASE CASE
 * =========================================================
 *
 * First element of every row = 1
 *
 * Last element of every row = 1
 *
 * Therefore:
 *
 * col == 0 → 1
 * col == row → 1
 *
 *
 * =========================================================
 */

public class G66PascalTriangleRowRecursively {

    /*
     * =====================================================
     * RECURSIVE HELPER
     * =====================================================
     *
     * Calculates ONE value in Pascal's Triangle.
     *
     * Example:
     *
     * pascal(3, 1)
     *
     * Row 3:
     *
     * [1, 3, 3, 1]
     *
     * Answer = 3
     */
    public static int pascal(int row, int col) {

        // -------------------------------------------------
        // BASE CASE
        // -------------------------------------------------
        //
        // First element of every row is 1.
        //
        // Example:
        //
        // [1, 3, 3, 1]
        //  ↑
        //
        // Last element of every row is also 1.
        //
        // [1, 3, 3, 1]
        //          ↑
        //
        if (col == 0 || col == row) {
            return 1;
        }


        // -------------------------------------------------
        // RECURSIVE CASE
        // -------------------------------------------------
        //
        // Current value =
        //
        // TOP-LEFT + TOP
        //
        //
        //             CURRENT
        //             /     \
        //        TOP-LEFT    TOP
        //
        return pascal(row - 1, col - 1) + pascal(row - 1, col);
    }


    /*
     * =====================================================
     * GENERATE COMPLETE PASCAL'S TRIANGLE
     * =====================================================
     */
    public List<List<Integer>> generate(int numRows) {

        // Stores all rows.
        List<List<Integer>> ans = new ArrayList<>();


        // Create every row.
        for (int row = 0; row < numRows; row++) {

            // Create current row.
            List<Integer> currRow = new ArrayList<>();


            // Every row has:
            //
            // row + 1 elements
            //
            // Row 0 → 1 element
            // Row 1 → 2 elements
            // Row 2 → 3 elements
            //
            for (int col = 0; col <= row; col++) {

                // Calculate current value recursively.
                currRow.add(pascal(row, col));
            }


            // Add completed row.
            ans.add(currRow);
        }


        return ans;
    }


    /*
     * =====================================================
     * MAIN — LOCAL TESTING
     * =====================================================
     */
    public static void main(String[] args) {

        // Number of rows we want.
        int numRows = 5;

        // Create Solution object.
        G66PascalTriangleRowRecursively solution = new G66PascalTriangleRowRecursively();

        // Generate Pascal's Triangle.
        List<List<Integer>> result = solution.generate(numRows);

        // Print result.
        System.out.println("Pascal's Triangle:");

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}


/*
 * =========================================================
 * DRY RUN — numRows = 4
 * =========================================================
 *
 *
 * =========================================================
 * ROW 0
 * =========================================================
 *
 * row = 0
 * col = 0
 *
 * pascal(0, 0)
 *
 * col == 0
 *
 * → 1
 *
 * Row:
 *
 * [1]
 *
 *
 * =========================================================
 * ROW 1
 * =========================================================
 *
 * row = 1
 *
 * col = 0:
 *
 * pascal(1,0)
 * → 1
 *
 *
 * col = 1:
 *
 * pascal(1,1)
 *
 * col == row
 *
 * → 1
 *
 *
 * Row:
 *
 * [1, 1]
 *
 *
 * =========================================================
 * ROW 2
 * =========================================================
 *
 * row = 2
 *
 * col = 0:
 *
 * pascal(2,0)
 * → 1
 *
 *
 * col = 1:
 *
 * pascal(2,1)
 *
 * Not a boundary.
 *
 * Therefore:
 *
 * pascal(1,0)
 * +
 * pascal(1,1)
 *
 * =
 *
 * 1 + 1
 *
 * = 2
 *
 *
 * col = 2:
 *
 * pascal(2,2)
 * → 1
 *
 *
 * Row:
 *
 * [1, 2, 1]
 *
 *
 * =========================================================
 * ROW 3
 * =========================================================
 *
 * row = 3
 *
 * col = 0:
 *
 * pascal(3,0)
 * → 1
 *
 *
 * col = 1:
 *
 * pascal(3,1)
 *
 * =
 *
 * pascal(2,0)
 * +
 * pascal(2,1)
 *
 * =
 *
 * 1 + 2
 *
 * = 3
 *
 *
 * col = 2:
 *
 * pascal(3,2)
 *
 * =
 *
 * pascal(2,1)
 * +
 * pascal(2,2)
 *
 * =
 *
 * 2 + 1
 *
 * = 3
 *
 *
 * col = 3:
 *
 * pascal(3,3)
 * → 1
 *
 *
 * Row:
 *
 * [1, 3, 3, 1]
 *
 *
 * =========================================================
 * FINAL OUTPUT — numRows = 4
 * =========================================================
 *
 * [1]
 * [1, 1]
 * [1, 2, 1]
 * [1, 3, 3, 1]
 *
 *
 * =========================================================
 * ONE VALUE DRY RUN — pascal(3,1)
 * =========================================================
 *
 * pascal(3,1)
 *
 *        ↓
 *
 * pascal(2,0) + pascal(2,1)
 *
 *        ↓              ↓
 *
 *       1        pascal(1,0) + pascal(1,1)
 *
 *                       ↓
 *
 *                    1 + 1
 *
 *                       ↓
 *
 *                       2
 *
 *
 * Therefore:
 *
 * 1 + 2
 *
 * = 3
 *
 *
 * =========================================================
 * RECURSION FLOW
 * =========================================================
 *
 * pascal(3,1)
 *      ↓
 * pascal(2,0) + pascal(2,1)
 *      ↓              ↓
 *      1        pascal(1,0) + pascal(1,1)
 *                       ↓
 *                    1 + 1
 *                       ↓
 *                       2
 *
 * Final:
 *
 * 1 + 2 = 3
 *
 *
 * =========================================================
 * CONNECTION WITH G64 — nCr
 * =========================================================
 *
 * G64:
 *
 * nCr
 * =
 * (n-1)C(r-1)
 * +
 * (n-1)Cr
 *
 *
 * G66:
 *
 * pascal(row,col)
 * =
 * pascal(row-1,col-1)
 * +
 * pascal(row-1,col)
 *
 *
 * SAME RECURSIVE IDEA.
 *
 *
 * G64:
 *
 * CHOOSE + DON'T CHOOSE
 *
 *
 * G66:
 *
 * TOP-LEFT + TOP
 *
 *
 * =========================================================
 * PATTERN RECOGNITION
 * =========================================================
 *
 * If you see:
 *
 * Pascal Triangle
 *        +
 * Current value depends on two values above
 *
 * Think:
 *
 * TOP-LEFT + TOP
 *
 *
 * =========================================================
 * REVISION CARD
 * =========================================================
 *
 * G66 — Pascal Triangle
 *
 * Base:
 *
 * col == 0 → 1
 * col == row → 1
 *
 *
 * Recursive:
 *
 * pascal(row,col)
 *
 * =
 *
 * pascal(row-1,col-1)
 * +
 * pascal(row-1,col)
 *
 *
 * Mental Model:
 *
 *       TOP-LEFT   TOP
 *            \     /
 *              +
 *              ↓
 *           CURRENT
 *
 *
 * ONE-LINE MEMORY:
 *
 * "PASCAL = TOP-LEFT + TOP"
 *
 *
 * =========================================================
 * IMPORTANT
 * =========================================================
 *
 * This recursive helper is excellent for learning the
 * recursion pattern.
 *
 * However, the same values can be calculated repeatedly.
 *
 * So for large input:
 *
 * Pure Recursion
 *       ↓
 * repeated work
 *       ↓
 * slower
 *
 * Later:
 *
 * Recursion
 *       ↓
 * Memoization
 *       ↓
 * DP
 *
 * =========================================================
 */