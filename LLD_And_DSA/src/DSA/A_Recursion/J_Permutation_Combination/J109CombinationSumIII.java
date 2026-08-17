package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class J109CombinationSumIII {
    public static void combinationSum3(int[] nums,int idx,List<List<Integer>> ans,List<Integer> op,int tar,int k,int count){
        if(count > k){
            return;
        }
        if(tar<0){
            return;
        }
        if(count == k){
            if(tar == 0){
                ans.add(new ArrayList<>(op));
            }
            return;
        }
        if(idx<0){
            return;
        }
        op.add(nums[idx]);
        combinationSum3(nums,idx-1,ans,op,tar-nums[idx],k,count+1);
        op.remove(op.size()-1);
        combinationSum3(nums,idx-1,ans,op,tar,k,count);
    }
    public static void main(String[] args) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        int idx = arr.length - 1;
        int tar = 7;
        int k = 3;
        int count = 0;
        combinationSum3(arr,idx,ans,op,tar,k,count);
        System.out.println(ans);
    }
}