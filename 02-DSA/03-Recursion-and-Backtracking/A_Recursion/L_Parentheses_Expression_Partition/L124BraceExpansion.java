package DSA.A_Recursion.L_Parentheses_Expression_Partition;

import java.util.ArrayList;
import java.util.List;

public class L124BraceExpansion {
    public static void solve(int idx, String str, StringBuilder sb, List<String> res) {
        if (idx >= str.length()) {
            res.add(sb.toString());
            return;
        }
        if (Character.isLetter(str.charAt(idx))) {
            sb.append(str.charAt(idx));
            solve(idx + 1, str, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (str.charAt(idx) == '{') {
            int end = idx + 1;
            while (str.charAt(end) != '}') {
                end++;//why end ++
            }
            for (int choices = idx + 1; choices < end; choices++) {//why end and idx+1
                if (str.charAt(choices) != ',') {//choices not idx
                    sb.append(str.charAt(choices));//choices not idx
                    solve(end + 1, str, sb, res);//why end +1
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        solve(0, "a{a,b}a", sb, res);
        System.out.println(res);
    }
}

