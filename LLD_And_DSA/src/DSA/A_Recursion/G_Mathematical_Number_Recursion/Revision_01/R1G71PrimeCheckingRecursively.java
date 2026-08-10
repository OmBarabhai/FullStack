package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

public class R1G71PrimeCheckingRecursively {
    public static boolean isPrime(int n, int idx) {
        if (n <= 1) {
            return false;
        }
        if (idx * idx > n) {
            return true;
        }
        if (n % idx == 0) {
            return false;
        }
        return isPrime(n, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7, 2));   // true
        System.out.println(isPrime(25, 2));  // false
        System.out.println(isPrime(1, 2));   // false
    }
}