package DSA.A_Recursion.L_Parentheses_Expression_Partition;

import java.util.*;

public class L125ExpressionAddOperators {

    public static void solve(List<String> res, String numbs, StringBuilder sb, int idx, long prev, long curr, int target) {
        if (idx >= numbs.length()) {
            if (curr == target) {
                res.add(sb.toString());
            }
            return;
        }
        long number = 0;
        for (int choices = idx; choices < numbs.length(); choices++) {
            number = number * 10 + (numbs.charAt(choices) - '0');
            if (choices > idx && numbs.charAt(choices) == '0') {
                break;
            }
            int beforeSbLength = sb.length();
            if (idx == 0) {
                sb.append(numbs.charAt(choices));
                solve(res, numbs, sb, choices + 1, number, number, target);
                sb.setLength(beforeSbLength);
            } else {
                sb.append('+').append(number);
                solve(res, numbs, sb, choices + 1, number, curr + number, target);
                sb.setLength(beforeSbLength);

                sb.append('-').append(number);
                solve(res, numbs, sb, choices + 1, -number, curr - number, target);
                sb.setLength(beforeSbLength);

                sb.append('*').append(number);
                solve(res, numbs, sb, choices + 1, prev * number, (curr - prev) + (curr * number), target);
                sb.setLength(beforeSbLength);
            }
            sb.setLength(beforeSbLength);

        }
    }

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        String str = "2233";
        int target = 9;
        StringBuilder sb = new StringBuilder();
        long prev = 0;
        long curr = 0;
        int idx = 0;
        solve(res, str, sb, idx, prev, curr, target);
        System.out.println(res);
    }
}