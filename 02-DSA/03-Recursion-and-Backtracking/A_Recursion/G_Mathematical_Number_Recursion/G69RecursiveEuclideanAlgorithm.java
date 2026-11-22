package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G69RecursiveEuclideanAlgorithm {

    // Method to calculate GCD using recursion
    public static int GCD(int n, int m) {

        // Base Case:
        // When m becomes 0, n is the GCD
        if (m == 0) {
            return n;
        }

        // Recursive Case:
        // Reduce the problem using Euclidean Algorithm
        return GCD(m, n % m);
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

/*
    Dry Run:

    GCD(48, 18)
        ↓
    GCD(18, 48 % 18)
        ↓
    GCD(18, 12)
        ↓
    GCD(12, 18 % 12)
        ↓
    GCD(12, 6)
        ↓
    GCD(6, 12 % 6)
        ↓
    GCD(6, 0)
        ↓
    m == 0
        ↓
    return n
        ↓
    return 6

    Answer = 6
*/