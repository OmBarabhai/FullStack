package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class K113SubsetsOfString {
    public static void solve(StringBuilder sb ,String str, int idx, List<String>ans){
        if(idx >= str.length()){
            ans.add(sb.toString());
            return;
        }
        sb.append(str.charAt(idx));
        solve(sb,str,idx+1,ans);
        sb.deleteCharAt(sb.length() - 1);
        solve(sb,str,idx+1,ans);

    }
    public static void main(String[] args) {
        List<String>ans = new ArrayList<>();
        String str = "ABC";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        solve(sb,str,idx,ans);
        System.out.println(ans);
    }
}