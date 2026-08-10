package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * G75 - Binary Representation Recursively
 *
 * ============================================================
 * CORE IDEA
 * ============================================================
 *
 * Here we use a simpler version of the G73 pattern.
 *
 * Instead of maintaining:
 *
 *     currLevel
 *     nextLevel
 *     ans
 *
 * we use:
 *
 *     ans + idx
 *
 * The answer list itself acts as the WORK QUEUE.
 *
 *
 * Example:
 *
 *     ans = [1, 10, 11, 100, 101]
 *            ^
 *           idx
 *
 * idx tells us which already-generated number should
 * produce the next two binary numbers.
 *
 *
 * ============================================================
 * RECURSION TREE
 * ============================================================
 *
 *                         1
 *                      /     \
 *                    10       11
 *                   /  \     /  \
 *                 100 101   110 111
 *
 *
 * We do not need separate level lists because the order
 * inside ans already gives us the pending work.
 *
 *
 * ============================================================
 * IMPORTANT PATTERN
 * ============================================================
 *
 * 1. ans contains generated values.
 * 2. idx points to the next value to process.
 * 3. curr = ans.get(idx)
 * 4. Generate curr + "0"
 * 5. Generate curr + "1"
 * 6. Move idx forward.
 * 7. Recursively process the next value.
 *
 *
 * ============================================================
 * DRY RUN: n = 5
 * ============================================================
 *
 * Initial:
 *
 * ans = [1]
 * idx = 0
 *
 *
 * STEP 1
 * -------
 *
 * curr = ans.get(0)
 *      = 1
 *
 * Generate:
 *
 * 1 + 0 = 10
 * 1 + 1 = 11
 *
 * ans = [1, 10, 11]
 *
 * idx = 1
 *
 *
 * STEP 2
 * -------
 *
 * curr = ans.get(1)
 *      = 10
 *
 * Generate:
 *
 * 10 + 0 = 100
 * 10 + 1 = 101
 *
 * ans = [1, 10, 11, 100, 101]
 *
 * ans.size() == 5
 *
 * STOP.
 *
 * Final result:
 *
 * [1, 10, 11, 100, 101]
 *
 *
 * ============================================================
 * WHY DO WE NEED THE SECOND BASE CHECK?
 * ============================================================
 *
 * Suppose:
 *
 * n = 4
 *
 * ans = [1, 10, 11]
 *
 * idx = 1
 * curr = 10
 *
 * First child:
 *
 * 10 + 0 = 100
 *
 * ans = [1, 10, 11, 100]
 *
 * Now ans.size() == 4.
 *
 * We must STOP before adding:
 *
 * 10 + 1 = 101
 *
 * Otherwise we would generate 5 values.
 *
 *
 * ============================================================
 * PERMANENT PATTERN
 * ============================================================
 *
 *        ans = generated values + pending work
 *                         |
 *                         v
 *                       idx
 *                         |
 *                         v
 *                  ans.get(idx)
 *                         |
 *                 +-------+-------+
 *                 |               |
 *              + "0"           + "1"
 *                 |               |
 *                 +-------+-------+
 *                         |
 *                    add to ans
 *                         |
 *                       idx + 1
 *                         |
 *                      recurse
 *
 *
 * KEY IDEA:
 *
 * "The answer list itself can act as the work queue."
 *
 * This removes the need for separate currLevel and
 * nextLevel lists in this particular problem.
 */
public class G75BinaryRepresentationRecursively {

    /**
     * Recursive helper.
     *
     * @param n   total number of binary numbers required
     * @param ans answer list AND work queue
     * @param idx index of the next value to expand
     */
    public static void solve(int n, List<String> ans, int idx) {

        // --------------------------------------------------------
        // BASE CASE:
        //
        // We already have n binary numbers.
        // Nothing more needs to be generated.
        // --------------------------------------------------------
        if (ans.size() == n) {
            return;
        }

        // --------------------------------------------------------
        // Get the current value that needs to be expanded.
        //
        // Example:
        //
        // ans = [1, 10, 11]
        // idx = 1
        //
        // curr = ans.get(1)
        //      = "10"
        // --------------------------------------------------------
        String curr = ans.get(idx);

        // --------------------------------------------------------
        // Generate the 0-child.
        //
        // Example:
        //
        // curr = "10"
        // curr + "0" = "100"
        // --------------------------------------------------------
        ans.add(curr + "0");

        // --------------------------------------------------------
        // IMPORTANT:
        //
        // If adding the 0-child reaches n,
        // stop before generating the 1-child.
        //
        // Example:
        //
        // n = 4
        // ans = [1, 10, 11]
        //
        // Add 100:
        // ans = [1, 10, 11, 100]
        //
        // We must stop here.
        // --------------------------------------------------------
        if (ans.size() == n) {
            return;
        }

        // --------------------------------------------------------
        // Generate the 1-child.
        //
        // Example:
        //
        // curr = "10"
        // curr + "1" = "101"
        // --------------------------------------------------------
        ans.add(curr + "1");

        // --------------------------------------------------------
        // Move to the next already-generated value.
        //
        // Example:
        //
        // idx = 0 -> process 1
        // idx = 1 -> process 10
        // idx = 2 -> process 11
        // --------------------------------------------------------
        solve(n, ans, idx + 1);
    }

    /**
     * Generates the first n binary representations.
     *
     * Example:
     *
     * n = 5
     *
     * Result:
     *
     * [1, 10, 11, 100, 101]
     */
    public static List<String> generateBin(int n) {

        List<String> ans = new ArrayList<>();

        // Edge case:
        // If no numbers are requested, return empty list.
        if (n <= 0) {
            return ans;
        }

        // First binary representation.
        ans.add("1");

        // If only one number is required,
        // the answer is already complete.
        if (n == 1) {
            return ans;
        }

        // Start recursion from the first element.
        solve(n, ans, 0);

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        List<String> result = generateBin(n);

        System.out.println("Generated Binary Numbers: " + result);

        // Expected:
        // Generated Binary Numbers: [1, 10, 11, 100, 101]
    }
}
