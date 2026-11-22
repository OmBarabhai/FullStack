import java.util.ArrayList;
import java.util.List;

public class K118KthPermutationUsingRecursion {
    public static int fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static void solve(List<String> nums, int k, StringBuilder sb) {
        if (nums.size() == 1) {
            sb.append(nums.get(0));
            return;
        }
        int block = fact(nums.size() - 1);
        /*
        Suppose nums = [1,2,3,4] and you want the K-th permutation.
        For each possible first digit, there are (nums.size()-1)! permutations.
        Example: With 4 numbers, each first digit (1, 2, 3, 4) leads to 6 permutations (since 3! = 6).
        So, if K=8:

        The first 6 permutations start with 1.
        The next 6 start with 2.
        Since 8 > 6, the first digit must be 2.
        */
        int idx = (k - 1) / block;
        String selected = nums.get(idx);
        sb.append(selected);
        nums.remove(idx);
        /*
        (k - 1) / block tells you which group (or "block") the K-th permutation falls into.
        Each block starts with a different digit from nums.
        Subtracting 1 from K makes it zero-based, matching list indices.
        For example, if block = 6 and k = 8, then idx = (8-1)/6 = 1, so you pick the digit at index 1 in nums.
        */
        k = (k - 1) % block + 1;
        /*
        After picking a digit, you?re left with a smaller list and a smaller set of permutations.
        The updated k tells you which permutation to pick within the new, smaller list.
        For example, if you originally wanted the 8th permutation, and you?ve chosen the block starting with ?2?, you now want the 2nd permutation of the remaining numbers (since 8th overall is 2nd in this block).
        Let?s dry run with nums = [1,2,3,4], k = 8:

        block = 3! = 6
        idx = (8-1)/6 = 1 ? pick nums[1] = 2
        Remove 2: nums = [1,3,4]
        Update k: k = (8-1)%6 + 1 = 2
        Next, repeat with nums = [1,3,4], k = 2
        */
        /*solve(nums, k, sb);
        Dry Run Example:
        Suppose nums = [1, 2, 3, 4],k = 8

        block = 3 ! = 6
        idx = (8 - 1) / 6 = 1 ? pick nums[1] = 2
        Append '2' to sb, remove '2' from nums ?nums = [1, 3, 4]

        Now, update k:
        k = (8 - 1) % 6 + 1 = 2

        Next recursive call:
        nums = [1, 3, 4],k = 2
        block = 2 ! = 2
        idx = (2 - 1) / 2 = 0 ? pick nums[0] = 1
        Append '1', remove '1' ? nums = [3, 4]
        k = (2 - 1) % 2 + 1 = 1

        Next:
        nums = [3, 4],k = 1
        block = 1 ! = 1
        idx = (1 - 1) / 1 = 0 ? pick nums[0] = 3
        Append '3', remove '3' ? nums = [4]
        k = (1 - 1) % 1 + 1 = 1

        Finally:
        nums = [4],append '4'

        Result:
        "2134"
*/
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 8;
        List<String> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(String.valueOf(i));
        }
        StringBuilder sb = new StringBuilder();
        solve(nums, k, sb);
        System.out.println(sb.toString());
    }
}