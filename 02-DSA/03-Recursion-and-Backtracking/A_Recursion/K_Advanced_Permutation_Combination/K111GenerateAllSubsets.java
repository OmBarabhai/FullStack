package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class K111GenerateAllSubsets {
    public static void solve(int[] nums, int idx, List<List<Integer>>ans,List<Integer>op){
        if(idx<0){
            ans.add(new ArrayList<>(op));
            return;
        }
        op.add(nums[idx]);
        solve(nums,idx-1,ans,op);
        op.remove(op.size()-1);
//        while (idx > 0 && nums[idx] == nums[idx-1]){ // for duplicate nums = {1,1,3};
//            idx--;
//        }

        solve(nums,idx-1,ans,op);
    }
    public static void main(String[] args) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>op =new ArrayList<>();
        int[] nums = {1,3};
        int idx = nums.length-1;
        solve(nums,idx,ans,op);
        System.out.println(ans);
    }
}