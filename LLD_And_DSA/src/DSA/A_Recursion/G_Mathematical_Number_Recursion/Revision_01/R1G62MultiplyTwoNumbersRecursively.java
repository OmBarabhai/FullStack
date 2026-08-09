package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;



public class R1G62MultiplyTwoNumbersRecursively {

    public static long multiply(long n, long m) {

        if (m == 0) {
            return 0;
        }

        if (m < 0) {
            return -multiply(n, -m);
        }

        long half = multiply(n, m / 2);

        if ((m & 1) == 0) {
            return half + half;
        }

        return n + half + half;
    }

    public static void main(String[] args) {

        System.out.println(multiply(5, 4));
        System.out.println(multiply(-5, 4));

    }
}

/*

                 multiply(5,4)
                       |
                    m / 2
                       ↓
                 multiply(5,2)
                       |
                    m / 2
                       ↓
                 multiply(5,1)
                       |
                    m / 2
                       ↓
                 multiply(5,0)
                       |
                    BASE CASE
                       ↓
                     return 0
                       ↑
                       |
                 m = 1 → ODD
                   5 + 0 + 0
                       |
                    return 5
                       ↑
                       |
                 m = 2 → EVEN
                     5 + 5
                       |
                    return 10
                       ↑
                       |
                 m = 4 → EVEN
                    10 + 10
                       |
                    return 20


R1 QUICK REVISION

Pattern:
Recursive multiplication using divide by 2.

Idea:
n × m
→ repeatedly divide m by 2
→ double n

Base:
m == 0 → 0

Example:
5 × 4

   5 × 4
→ 10 × 4/2
→ 20 × 2/2
→ 40 × 0
→ return 0

Time: O(log m)
Space: O(log m)
*/