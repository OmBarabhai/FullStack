package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * G73 - Generate Binary Numbers Recursively
 * <p>
 * ============================================================
 * CORE IDEA
 * ============================================================
 * <p>
 * Start with:
 * <p>
 * 1
 * /     \
 * 10       11
 * /  \     /  \
 * 100 101   110 111
 * <p>
 * Every current binary number generates two children:
 * <p>
 * curr + "0"
 * curr + "1"
 * <p>
 * We process the numbers LEVEL BY LEVEL.
 * <p>
 * <p>
 * ============================================================
 * WHY currLevel AND nextLevel?
 * ============================================================
 * <p>
 * currLevel = numbers that we are processing NOW.
 * <p>
 * nextLevel = children generated from currLevel.
 * <p>
 * Example:
 * <p>
 * currLevel = [10, 11]
 * <p>
 * Processing:
 * <p>
 * 10 -> 100, 101
 * 11 -> 110, 111
 * <p>
 * Therefore:
 * <p>
 * nextLevel = [100, 101, 110, 111]
 * <p>
 * After the current level is completely processed,
 * nextLevel becomes the new currLevel.
 * <p>
 * <p>
 * ============================================================
 * IMPORTANT RECURSION PATTERN
 * ============================================================
 * <p>
 * 1. Check whether n numbers have been generated.
 * 2. Process the current level.
 * 3. Generate children into nextLevel.
 * 4. Add generated numbers to ans.
 * 5. When the current level is finished,
 * recursively process nextLevel.
 * <p>
 * <p>
 * ============================================================
 * DRY RUN: n = 5
 * ============================================================
 * <p>
 * Initial:
 * <p>
 * ans       = [1]
 * currLevel = [1]
 * count     = 1
 * <p>
 * <p>
 * LEVEL 1
 * --------
 * <p>
 * curr = 1
 * <p>
 * 1 + 0 = 10
 * 1 + 1 = 11
 * <p>
 * ans       = [1, 10, 11]
 * nextLevel = [10, 11]
 * count     = 3
 * <p>
 * <p>
 * LEVEL 2
 * --------
 * <p>
 * currLevel = [10, 11]
 * <p>
 * Process 10:
 * <p>
 * 10 + 0 = 100
 * 10 + 1 = 101
 * <p>
 * ans   = [1, 10, 11, 100, 101]
 * count = 5
 * <p>
 * count == n
 * <p>
 * STOP.
 * <p>
 * We do NOT generate 110 and 111 because we already
 * generated the required 5 numbers.
 * <p>
 * Final:
 * <p>
 * [1, 10, 11, 100, 101]
 * <p>
 * <p>
 * ============================================================
 * TWO DIFFERENT BASE CONDITIONS
 * ============================================================
 * <p>
 * count[0] == n
 * <p>
 * Means:
 * "The whole problem is finished. We have enough numbers."
 * <p>
 * idx == currLevel.size()
 * <p>
 * Means:
 * "The current level is finished."
 * <p>
 * These are NOT the same condition.
 * <p>
 * <p>
 * ============================================================
 * PERMANENT PATTERN TO REMEMBER
 * ============================================================
 * <p>
 * CURRENT LEVEL
 * |
 * process each value
 * |
 * +-----+-----+
 * |           |
 * + "0"       + "1"
 * |           |
 * +-----+-----+
 * |
 * nextLevel
 * |
 * current level finished
 * |
 * nextLevel becomes
 * the new current level
 * |
 * recurse
 * <p>
 * Remember the PATTERN, not the exact code.
 */
public class G73GenerateBinaryNumbersRecursively {

    /**
     * Recursively processes one level of binary numbers.
     *
     * @param n         total number of binary numbers required
     * @param nextLevel numbers generated for the next level
     * @param currLevel numbers currently being processed
     * @param ans       final answer list
     * @param count     shared counter because Java int is passed by value
     * @param idx       index of the current value inside currLevel
     */
    public static void solve(int n, List<String> nextLevel, List<String> currLevel, List<String> ans, int[] count, int idx) {

        // --------------------------------------------------------
        // BASE CASE 1:
        // We already generated n numbers.
        // Nothing more needs to be generated.
        // --------------------------------------------------------
        if (count[0] == n) {
            return;
        }

        // --------------------------------------------------------
        // BASE CASE 2 / LEVEL TRANSITION:
        //
        // idx == currLevel.size()
        // means every value in the current level was processed.
        //
        // Example:
        //
        // currLevel = [10, 11]
        // idx       = 2
        //
        // 2 == 2 -> current level is finished.
        //
        // So:
        // nextLevel becomes the new currLevel
        // new empty list becomes nextLevel
        // idx starts again from 0
        // --------------------------------------------------------
        if (idx == currLevel.size()) {
            solve(n, new ArrayList<>(), nextLevel, ans, count, 0);
            return;
        }

        // Get the current binary number.
        //
        // Example:
        //
        // currLevel = [10, 11]
        // idx = 0
        //
        // curr = "10"
        String curr = currLevel.get(idx);

        // --------------------------------------------------------
        // Generate the 0-child.
        //
        // Example:
        //
        // curr = "10"
        // curr + "0" = "100"
        // --------------------------------------------------------
        String zeroChild = curr + "0";

        nextLevel.add(zeroChild);
        ans.add(zeroChild);
        count[0]++;

        // If this was the nth required number, stop.
        if (count[0] == n) {
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
        String oneChild = curr + "1";

        nextLevel.add(oneChild);
        ans.add(oneChild);
        count[0]++;

        // If this was the nth required number, stop.
        if (count[0] == n) {
            return;
        }

        // Move to the next element of the CURRENT level.
        //
        // Example:
        //
        // currLevel = [10, 11]
        // idx = 0
        //
        // Next:
        // idx = 1 -> process 11
        solve(n, nextLevel, currLevel, ans, count, idx + 1);
    }

    /**
     * Generates the first n binary numbers.
     * <p>
     * Example:
     * <p>
     * n = 5
     * <p>
     * Result:
     * [1, 10, 11, 100, 101]
     */
    public static List<String> generateBinaryNumbers(int n) {

        List<String> ans = new ArrayList<>();
        List<String> nextLevel = new ArrayList<>();
        List<String> currLevel = new ArrayList<>();

        // Edge case:
        // No numbers requested.
        if (n <= 0) {
            return ans;
        }

        // The first binary number is 1.
        ans.add("1");

        // If only one number is required,
        // we already have the answer.
        if (n == 1) {
            return ans;
        }

        // First/current level starts with 1.
        currLevel.add("1");

        // One number has already been generated.
        //
        // int[] is used so recursive calls share the same
        // counter object.
        int[] count = {1};

        // Start recursion from index 0.
        solve(n, nextLevel, currLevel, ans, count, 0);

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        List<String> result = generateBinaryNumbers(n);

        System.out.println("Generated Binary Numbers: " + result);

        // Expected:
        // Generated Binary Numbers: [1, 10, 11, 100, 101]
    }
}
