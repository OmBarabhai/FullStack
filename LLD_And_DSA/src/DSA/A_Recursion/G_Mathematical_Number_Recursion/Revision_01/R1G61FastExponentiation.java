public class R1G61FastExponentiation {

    public static double pow(double x, long n) {
        // Base Case
        if (n == 0) {
            return 1;
        }
        // Calculate x^(n/2)
        double half = pow(x, n / 2);
        // Even power
        if ((n & 1) == 0) {
            return half * half;
        }
        // Odd power
        return x * half * half;
    }
    public static double fastExponentiation(double x, int n) {
        long N = n;
        // Negative power:
        // x^(-n) = 1 / x^n
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }
    public static void main(String[] args) {
        System.out.println(fastExponentiation(2, 10));   // 1024
        System.out.println(fastExponentiation(2, -2));   // 0.25
    }
}
/*
R1 QUICK REVISION

Pattern:
Fast Exponentiation

Idea:
Divide exponent by 2 every time.

Base:
n == 0 → return 1

Even:
x^n = half × half

Odd:
x^n = x × half × half

Negative:
x^(-n) = 1 / x^n

Example:
2^10
→ 2^5
→ 2^2
→ 2^1
→ 2^0

Time: O(log n)
Space: O(log n)
*/