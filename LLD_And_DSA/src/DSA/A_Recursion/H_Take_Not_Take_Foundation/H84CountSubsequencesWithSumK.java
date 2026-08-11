package DSA.A_Recursion.H_Take_Not_Take_Foundation;

class H84CountSubsequencesWithSumK{
        public static int solve(int[] arr, int k, int idx,int sum){
            if(idx>=arr.length){
                if(sum == k){
                    return 1;
                }
                return 0;
            }
            int take = solve(arr,k,idx+1,sum+arr[idx]);
            int notTake = solve(arr,k,idx+1,sum);
            return take + notTake;
        }


    public static  void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        int idx = 0;
        int sum = 0;
        System.out.println( solve(arr,k,idx,sum));
    }
}