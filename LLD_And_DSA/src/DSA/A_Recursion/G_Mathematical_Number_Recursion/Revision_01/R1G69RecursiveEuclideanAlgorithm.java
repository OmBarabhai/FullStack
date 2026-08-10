package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

public class R1G69RecursiveEuclideanAlgorithm {
    public static int GCD(int n,int m){
        if(m == 0){
            return n;
        }
        return GCD(m,n%m);
    }
    public static void main(String[] args) {
        // Input numbers
        int n = 48;
        int m = 18;

        // Call GCD method
        int result = GCD(n, m);

        // Print the result
        System.out.println("GCD of " + n + " and " + m + " = " + result);
    }
}