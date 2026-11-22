package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class K115PhoneKeypadCombinations {
    public static void solve(String digits,String[] lettersStr,List<String> ans,StringBuilder sb, int idx){
        if(idx>=digits.length()){
            ans.add(sb.toString());
            return;
        }
        int currDigIdx = digits.charAt(idx) - '0';
        String currStrAtDig = lettersStr[currDigIdx];
        for(int i = 0;i<currStrAtDig.length();i++){
            sb.append(currStrAtDig.charAt(i));
            solve(digits,lettersStr,ans,sb,idx+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        String digits = "293";
        String[] lettersStr = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        solve(digits,lettersStr,ans,sb,idx);
        System.out.println(ans);
    }
}