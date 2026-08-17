package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class K112GenerateAllKSubsets {
    public static void solve(int[] nums, int start, List<List<Integer>> ans, List<Integer> op, int k, int count) {
        if(count > k){
            return;
        }
        if (count == k) {
            ans.add(new ArrayList<>(op));
            return;
        }

        for (int idx = start; idx > 0; idx--) {
            op.add(idx);
            solve(nums,  idx - 1, ans, op, k, count + 1);
            op.remove(op.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 2;
        int count = 0;
        int idx = nums.length-1;
        solve(nums,  idx, ans, op, k, count);
        System.out.println(ans);
    }
}