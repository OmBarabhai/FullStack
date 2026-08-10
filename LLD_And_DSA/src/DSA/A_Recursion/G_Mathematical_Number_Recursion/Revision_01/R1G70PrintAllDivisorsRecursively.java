package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class R1G70PrintAllDivisorsRecursively {
    public static List<Integer> findDiv(int n, List<Integer> ans, int idx){
        if(idx > n){
            return ans;
        }
        if(n%idx == 0){
            ans.add(idx);
        }

        return findDiv(n,ans,idx+1);
    }
    public static List<Integer> printAllDivisorsRecursively(int n){
        List<Integer> ans = new ArrayList<>();
        return findDiv(n,ans,1);

    }
    public static  void findDivOpt(int n, List<Integer> ans ,int idx){
        if(idx * idx > n){
            return;
        }
        if(n % idx == 0){
            ans.add(idx);
            if(idx != n/idx){
                ans.add(n/idx);
            }
        }
        findDivOpt(n,ans,idx+1);

    }
    public static List<Integer> printDivisors(int n){
        List<Integer> ans = new ArrayList<>();
        findDivOpt(n,ans,1);
        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        int n = 10;

        // Basic recursive approach
        List<Integer> basicResult = printAllDivisorsRecursively(n);

        System.out.println("Basic Recursive: " + basicResult);

        // Optimized recursive approach
        List<Integer> optimizedResult = printDivisors(n);

        System.out.println("Optimized Recursive: " + optimizedResult);
    }
}