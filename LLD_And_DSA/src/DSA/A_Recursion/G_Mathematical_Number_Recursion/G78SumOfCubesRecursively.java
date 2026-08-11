package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G78SumOfCubesRecursively {
    public static int sumOfCubes(int n) {
        if (n == 0) {
            return 0;
        }
        return sumOfCubes(n - 1) + (n * n * n);
    }

    public static void main(String[] args) {
        System.out.println(sumOfCubes(2));// 1^3 = 1 , 2^3 = 8 SO 1+8 = 9
    }
}