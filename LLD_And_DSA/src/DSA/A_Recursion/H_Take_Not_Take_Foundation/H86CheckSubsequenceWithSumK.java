package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H86CheckSubsequenceWithSumK {
    public static boolean check(int[] arr, int sum, int k, List<Integer> op, int idx) {
        if (idx >= arr.length) {
            if (sum == k) {
                return true;
            }
            return false;
        }
        op.add(arr[idx]);
        if (check(arr, sum + arr[idx], k, op, idx + 1) == true) {
            return true;
        }
        op.remove(op.size() - 1);
        if (check(arr, sum, k, op, idx + 1) == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> op = new ArrayList<>();
        int[] arr = {1, 2, 3};
        int sum = 0;
        int idx = 0;
        int k = 3;
        System.out.println(check(arr, sum, k, op, idx));
    }
}