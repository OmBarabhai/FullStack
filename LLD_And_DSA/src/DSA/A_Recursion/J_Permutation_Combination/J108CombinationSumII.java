package DSA.A_Recursion.J_Permutation_Combination;

import java.util.*;

public class J108CombinationSumII {
    public static void combinations(int n, int k, int start, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> op) {
        if (op.size() == k) {
            ans.add(new ArrayList<>(op));
            return;
        }
        for (int idx = start; idx > 0; idx--) {
            op.add(idx);
            /*
            idx = 1 [1, 2], [1, 3], [1, 4],
            idx = 2 [2, 3], [2, 4],
            idx = 3 [3, 4]
            */
            combinations(n, k, idx - 1, ans, op);
            op.remove(op.size() - 1);
        }
    }

    public static void combinationSum2(int[] arr, ArrayList<ArrayList<Integer>> ans_1, ArrayList<Integer> op_1, int tar, int idx) {
        if (tar == 0) {
            ans_1.add(new ArrayList<>(op_1));
            return;
        }

        if (idx < 0) {
            return;
        }
        if (tar < 0) {
            return;
        }

        op_1.add(arr[idx]);
        combinationSum2(arr, ans_1, op_1, tar - arr[idx], idx-1);
        op_1.remove(op_1.size() - 1);
        while (idx > 0 && arr[idx] == arr[idx-1]){
            idx--;
        }
        combinationSum2(arr, ans_1, op_1, tar , idx - 1);
    }

    public static void main(String[] args) {

        // 77. combinations
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> op = new ArrayList<>();
        int n = 4;
        int k = 2;
        int start = n;
        combinations(n, k, start, ans, op);
        System.out.println(ans);
        // 40. Combination Sum II
        ArrayList<ArrayList<Integer>> ans_1 = new ArrayList<>();
        ArrayList<Integer> op_1 = new ArrayList<>();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
        int target = 8;
        int idx = arr.length - 1;
        combinationSum2(arr, ans_1, op_1, target, idx);
        System.out.println(ans_1);
    }
}