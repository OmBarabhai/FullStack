package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;


public class R1G68JosephusProblem {
    public static int findWinnerZeroBased(int n,int k){
        if(n == 1){
            return 0;
        }
        int winner = findWinnerZeroBased(n-1,k);
        return (winner + k) % n;
    }
    public static int findWinnerOneBased(int n, int k){
        if(n == 1){
            return 1;
        }
        int winner = findWinnerOneBased(n-1,k);
        return (winner + k - 1) % n + 1;
    }
    public static void main(String[] args) {
        int n = 5;
        int k = 2;

        int answerZeroBased = findWinnerZeroBased(n, k);

        int answerOneBased = findWinnerOneBased(n, k);

        System.out.println("0-Based Approach = " + answerZeroBased);

        System.out.println("1-Based Approach = " + answerOneBased);
    }
}