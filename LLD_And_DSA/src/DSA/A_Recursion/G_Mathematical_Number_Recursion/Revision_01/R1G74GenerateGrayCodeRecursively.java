package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

import java.util.ArrayList;
import java.util.List;

public class R1G74GenerateGrayCodeRecursively {
    public static boolean solve(int n,List<Integer> res,boolean[] visited){
        if(res.size() == (1 << n)){
            return true;
        }

        int last = res.get(res.size()-1);
        for(int idx = 0;idx<n;idx++){

            int xorLast = last ^ (1<<idx);
            if(!visited[xorLast] == true){
               visited[xorLast] = true;
               res.add(xorLast);
               if(solve(n,res,visited) == true){
                   return true;
               }
               res.remove(res.size()-1);
               visited[xorLast] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 3;
        List<Integer> res =  new ArrayList<>();
        boolean[] visited = new boolean[1<<n];
        res.add(0);
        visited[0] = true;
        solve(n,res,visited);
        System.out.println(res);
    }
}