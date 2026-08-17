package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class K114LetterCasePermutation {
    public static void solve(String s,ArrayList<String>ans,int idx,StringBuilder sb ){
        if(idx>=s.length()){
            ans.add(sb.toString());
            return;
        }
        if(Character.isLetter(s.charAt(idx))){
            sb.append(Character.toUpperCase(s.charAt(idx)));
            solve(s,ans,idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append(Character.toLowerCase(s.charAt(idx)));
            solve(s,ans,idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }else{
            sb.append(s.charAt(idx));
            solve(s,ans,idx+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<String>ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String s = "0Om07";
        int idx = 0;
        solve(s,ans,idx,sb);
        System.out.println(ans);
    }
}


