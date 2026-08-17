package DSA.A_Recursion.L_Parentheses_Expression_Partition;

import java.util.ArrayList;
import java.util.List;

public class K121GenerateParentheses {
    public static void solve(int n, int open, int close, List<String> res,StringBuilder sb){
        if(close == n){
            res.add(sb.toString());
            return;
        }
        if(open<n){
            sb.append("({");
            solve(n,open+1,close,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append("})");
            solve(n,open,close+1,res,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args) {
        List<String> res =new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        solve(3,0,0,res,sb);
        System.out.println(res);
    }
}