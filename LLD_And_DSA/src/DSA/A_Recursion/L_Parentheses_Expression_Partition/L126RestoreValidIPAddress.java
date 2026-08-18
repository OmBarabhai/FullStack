package DSA.A_Recursion.L_Parentheses_Expression_Partition;

import java.util.ArrayList;import java.util.List;
public class L126RestoreValidIPAddress {
    public static void solve(String str,StringBuilder sb,List<String> res,int idx,int parts){
        if(idx>=str.length() && parts == 4){
            res.add(sb.toString());
            return;
        }
        if(parts == 4){
            return;
        }
        int currPart = 0;
        for(int choices = idx;choices< str.length();choices++){

            if(choices > idx && str.charAt(idx) == '0'){
                break;
            }
            currPart = currPart * 10 + (str.charAt(choices) - '0');
            if(currPart >  255){
                break;
            }
            int sbBeforeLen = sb.length();

            if(parts > 0){
                sb.append('.');
            }
            sb.append(currPart);
            solve(str,sb,res,choices+1,parts+1);
            sb.setLength(sbBeforeLen);
        }
    }
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        String str = "25525511135";
        int parts = 0;
        solve(str,sb,res,0,parts);
        System.out.println(res);
    }
}