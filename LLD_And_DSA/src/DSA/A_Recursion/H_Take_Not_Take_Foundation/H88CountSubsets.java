package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H88CountSubsets {
    public static int countSubsets(int[] arr, int idx){
        if(idx>=arr.length){
            return 1;
        }
        int take = countSubsets(arr,idx+1);
        int notTake = countSubsets(arr,idx+1);
        return take + notTake;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int idx = 0;
        System.out.println(countSubsets(arr,idx));
    }
}