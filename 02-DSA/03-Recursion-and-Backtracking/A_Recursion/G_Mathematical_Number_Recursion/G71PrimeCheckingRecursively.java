package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G71PrimeCheckingRecursively {

    // Recursive method to check whether n is prime
    public static boolean solve(int n, int idx) {

        // BASE CASE:
        // If idx has crossed sqrt(n),
        // no divisor was found.
        if (idx * idx > n) {
            return true;
        }

        // CURRENT WORK:
        // If idx divides n, n is not prime.
        if (n % idx == 0) {
            return false;
        }

        // RECURSIVE CASE:
        // Check the next possible divisor.
        return solve(n, idx + 1);
    }

    // Starting method
    public static boolean isPrime(int n) {

        // 0 and 1 are not prime.
        if (n <= 1) {
            return false;
        }

        // Start checking from 2.
        return solve(n, 2);
    }

    public static void main(String[] args) {

        System.out.println(isPrime(7));   // true
        System.out.println(isPrime(25));  // false
        System.out.println(isPrime(1));   // false
    }
}

/*
G71 — QUICK REVISION

Prime:
n > 1
and no divisor except 1 and n.

Base Cases:
n <= 1      → false
idx * idx > n → true

Current Work:
n % idx == 0 → false

Recursive Case:
solve(n, idx + 1)

Start:
idx = 2

Example: n = 7

solve(7, 2)
    ↓
7 % 2 != 0
    ↓
solve(7, 3)
    ↓
3 * 3 > 7
    ↓
true

Example: n = 25

solve(25, 2)
    ↓
25 % 2 != 0
    ↓
solve(25, 3)
    ↓
25 % 3 != 0
    ↓
solve(25, 4)
    ↓
25 % 4 != 0
    ↓
solve(25, 5)
    ↓
25 % 5 == 0
    ↓
false

Time: O(√n)
Space: O(√n)
*/