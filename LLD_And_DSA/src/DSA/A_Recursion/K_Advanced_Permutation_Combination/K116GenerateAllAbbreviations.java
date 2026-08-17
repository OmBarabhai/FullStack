package DSA.A_Recursion.K_Advanced_Permutation_Combination;

import java.util.ArrayList;
import java.util.Collections;

public class K116GenerateAllAbbreviations {
    public static void solve(String str,StringBuilder sb,int count,int idx,ArrayList<String> ans){
            int len = sb.length();
            if(idx >= str.length()){
                if(count > 0){
                    sb.append(count);
                }
                ans.add(sb.toString());
                sb.setLength(len);

                return;
            }
            solve(str,sb,count+1,idx+1,ans);
            if(count > 0){
                sb.append(count);
            }
            sb.append(str.charAt(idx));
            solve(str,sb,0,idx+1,ans);
            sb.setLength(len);
    }/*
	                        abc
                       idx=0,count=0,sb=""
                              |
                 ???????????????????????????
                 ?                         ?
            ABBREVIATE a                KEEP a
                 ?                         ?
          idx=1,count=1               idx=1,count=0
          sb=""                       sb="a"
                 ?                         ?
        ???????????????????        ?????????????????
        ?                 ?        ?               ?
   ABBREVIATE b       KEEP b    ABBREVIATE b     KEEP b
        ?                 ?         ?               ?
 count=2,sb=""        sb="1b"    sb="a"          sb="ab"
 idx=2,count=2        count=0    count=1         count=0
        ?                 ?        ?               ?
    ?????????         ????????    ???????         ???????
    ?       ?         ?      ?     ?     ?         ?     ?
   ABBR    KEEP      ABBR   KEEP  ABBR KEEP     ABBR  KEEP
    c        c         c      c    c    c        c     c
    ?        ?         ?      ?    ?    ?        ?     ?
    ?        ?         ?      ?    ?    ?        ?     ?
   "3"     "2c"      "1b1" "1bc" "a2" "a1c"  "ab1" "abc"

*/
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        int idx = 0;
        String str = "ABC";
        StringBuilder sb =new StringBuilder();
        int count = 0;
        solve(str,sb,count,idx,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}