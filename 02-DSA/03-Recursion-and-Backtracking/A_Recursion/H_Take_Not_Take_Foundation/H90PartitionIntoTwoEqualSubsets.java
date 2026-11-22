package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.*;

public class H90PartitionIntoTwoEqualSubsets {
    public static boolean partitionIntoTwoEqualSubsets(int[] arr, int sum, int idx, List<Integer> op) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        if ((total & 1) != 0) {
            return false;
        }
        int tar = total / 2;
        return solve(arr, 0, arr.length - 1, op, tar);
    }

    public static boolean solve(int[] arr, int sum, int idx, List<Integer> op, int tar) {
        if (idx < 0) {
            return sum == tar;
        }
        op.add(arr[idx]);
        boolean take = solve(arr, sum + arr[idx], idx - 1, op, tar);
        if (take) {
            return true;
        }
        boolean notTake = solve(arr, sum, idx - 1, op, tar);
        return notTake;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        List<Integer> op = new ArrayList<>();

        System.out.println(partitionIntoTwoEqualSubsets(arr, 0, arr.length - 1, op));
    }
}