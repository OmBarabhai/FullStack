package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H82CountSubsequences {
    public  static int count(int[] arr,int idx){
        if(idx >= arr.length){
            return 1;
        }
        int take = count(arr,idx+1);
        int notTake = count(arr,idx+1);
        return take + notTake;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,30};
        int idx = 0;
        System.out.println(count(arr,idx));
    }
}