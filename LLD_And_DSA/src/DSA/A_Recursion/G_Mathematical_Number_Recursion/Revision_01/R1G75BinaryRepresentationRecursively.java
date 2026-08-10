package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

import java.util.ArrayList;
import java.util.List;

public class R1G75BinaryRepresentationRecursively {
    public static void solve(int n ,List<String> ans,int idx){
        if (ans.size() == n){
            return;
        }
        String curr = ans.get(idx);
        ans.add(curr+"0");
        if(ans.size() == n){
            return;
        }
        ans.add(curr + "1");
        solve(n,ans,idx+1);

    }
    public static List<String> generateBin(int n){
        List<String> ans= new ArrayList<>();
        if(n<=0){
            return ans;
        }
        ans.add("1");
        if(n==1){
            return ans;
        }
        solve(n,ans,0);
        return ans;

    }
    public static void main(String[] args) {
        List<String> res = generateBin(5);
        System.out.println(res);

    }
}