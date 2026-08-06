package DSA.A_Recursion.E_Conditional_Counting;

public class E42CountEqualToX {

    /*
     * =========================================
     * Problem : Count Equal To X
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countEqualToX(arr, idx + 1, x)
     * returns the number of elements
     * equal to x in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is equal to x.
     *
     * Formula
     *
     * int count =
     * countEqualToX(arr, idx + 1, x);
     *
     * if(arr[idx] == x)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countEqualToX(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countEqualToX(arr, idx + 1, x);

        // Current Work
        if (arr[idx] == x) {
            return count + 1;
        }

        return count;
    }

    /*
     * =========================================
     * Alternate Solution
     * Direct Recursive Style
     * =========================================
     */

    public static int countEqualToXDirect(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] == x) {
            return 1 + countEqualToXDirect(arr, idx + 1, x);
        }

        // Recursive Call
        return countEqualToXDirect(arr, idx + 1, x);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 20, 40, 20, 50, 20, 60, 20};

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Count of 20 : " + countEqualToX(arr, 0, 20));

        System.out.println("Count of 10 : " + countEqualToX(arr, 0, 10));

        System.out.println("Count of 99 : " + countEqualToX(arr, 0, 99));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Count of 20 : " + countEqualToXDirect(arr, 0, 20));

        System.out.println("Count of 10 : " + countEqualToXDirect(arr, 0, 10));

        System.out.println("Count of 99 : " + countEqualToXDirect(arr, 0, 99));
    }
}