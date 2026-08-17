package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class J110SubsetsWithDuplicates {
    public static void subsetsWithDup(int[] nums, int idx, List<List<Integer>> ans, List<Integer> op) {
        if (idx < 0) {
            ans.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[idx]);
        subsetsWithDup(nums, idx - 1, ans, op);
        op.remove(op.size() - 1);
        while (idx > 0 && nums[idx] == nums[idx - 1]) {
            idx--;
        }
        subsetsWithDup(nums, idx - 1, ans, op);
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int[] nums = {4,4,1,4};
        Arrays.sort(nums);
        int idx = nums.length - 1;
        subsetsWithDup(nums, idx, ans, op);
        System.out.println(ans);
    }
}