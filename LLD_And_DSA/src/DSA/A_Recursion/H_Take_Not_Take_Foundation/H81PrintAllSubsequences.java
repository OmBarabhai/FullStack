package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H81PrintAllSubsequences {
    public static void solve(int[] arr, List<Integer> op,List<List<Integer>>ans,int idx){
        if(idx >= arr.length){
            ans.add(new ArrayList<>(op));
            return;
        }
        op.add(arr[idx]);
        solve(arr,op,ans,idx+1);
        op.remove(op.size()-1);
        solve(arr,op,ans,idx+1);

    }
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int[] arr = {10,20,30,40};
        int idx = 0;
        solve(arr,op,ans,idx);
        System.out.println(ans);
    }
}
