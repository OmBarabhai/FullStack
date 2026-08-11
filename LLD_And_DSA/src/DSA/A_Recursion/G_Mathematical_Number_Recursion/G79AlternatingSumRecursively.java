package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G79AlternatingSumRecursively {
    public static int alternatingSum(int n){
        if(n <= 0){
            return 0;
        }
        return n - alternatingSum(n - 1);
    }
    public static void main(String[] args) {
        System.out.println(alternatingSum(5));
    }
}