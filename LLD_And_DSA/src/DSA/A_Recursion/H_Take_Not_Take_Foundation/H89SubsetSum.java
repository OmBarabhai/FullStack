package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H89SubsetSum {
    public static boolean subsetSum(int[] arr, int idx, List<Integer> op, int sum, int tar) {
        if (idx >= arr.length) {
            return sum == tar;
        }
        op.add(arr[idx]);
        if (subsetSum(arr, idx + 1, op, sum + arr[idx], tar) == true) {
            return true;
        }
        op.remove(op.size() - 1);
        if (subsetSum(arr, idx + 1, op, sum, tar) == true) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> op = new ArrayList<>();
        int[] arr = {1, 2, 3};
        int idx = 0;
        int sum = 0;
        int tar = 10;
        System.out.println(subsetSum(arr, idx, op, sum, tar));
    }
}