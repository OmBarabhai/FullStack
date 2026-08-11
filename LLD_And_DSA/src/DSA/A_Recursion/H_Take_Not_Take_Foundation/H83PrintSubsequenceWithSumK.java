package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H83PrintSubsequenceWithSumK {
    public static void solve(int[] arr,int idx,int sum,int k,List<Integer> curr){
        if(idx >= arr.length){
            if(sum == k){
                System.out.println(curr);
            }
            return;
        }
        curr.add(arr[idx]);
        solve(arr,idx+1,sum+arr[idx],k,curr);
        curr.remove(curr.size()-1);
        solve(arr,idx+1,sum,k,curr);
    }
    public static void main(String[] args) {
        List<Integer> curr =new ArrayList<>();
        int idx = 0;
        int sum = 0;
        int k = 3;
        int[] arr= {1,2,3};
        solve(arr,idx,sum,k,curr);
    }
}