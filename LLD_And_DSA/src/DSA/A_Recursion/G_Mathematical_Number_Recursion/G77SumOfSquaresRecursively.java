package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G77SumOfSquaresRecursively {
    public static int sumOfSquares(int n){
        if(n == 0){
            return 0;
        }

        return sumOfSquares(n-1) + (n * n);
    }
    public static void main(String[] args) {
        System.out.println(sumOfSquares(5));
    }
}