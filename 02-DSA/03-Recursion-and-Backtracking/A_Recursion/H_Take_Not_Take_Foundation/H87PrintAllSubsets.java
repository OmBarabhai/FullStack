package DSA.A_Recursion.H_Take_Not_Take_Foundation;

import java.util.ArrayList;
import java.util.List;

public class H87PrintAllSubsets {
    public static void printAllSubsets(int[] arr, int idx, List<Integer>op){
        if(idx>=arr.length){
            System.out.println(op);
            return;
        }
        op.add(arr[idx]);
        printAllSubsets(arr,idx+1,op);
        op.remove(op.size()-1);
        printAllSubsets(arr,idx+1,op);

    }
    public static void main(String[] args) {
        List<Integer> op = new ArrayList<>();
        int[] arr = {1, 2, 3};
        int idx = 0;
        printAllSubsets(arr, idx,op);
    }
}