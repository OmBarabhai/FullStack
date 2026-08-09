public class R1G63DivideTwoNumbersRecursively {

    public static int computeQuo(int absN, int absM) {

        // Base Case
        if (absN < absM) {
            return 0;
        }

        // Subtract divisor and count 1
        return 1 + computeQuo(absN - absM, absM);
    }

    public static int divideTwoNumbersRecursively(int n, int m) {

        int sign = 1;

        // Determine sign
        if ((n < 0 && 0 < m) || (0 < n && m < 0)) {
            sign = -1;
        }

        int absN = Math.abs(n);
        int absM = Math.abs(m);

        int quo = computeQuo(absN, absM);

        return quo * sign;
    }

    public static void main(String[] args) {

        System.out.println(divideTwoNumbersRecursively(10, 3));
    }
}

/*
R1 QUICK REVISION

Idea:
Repeated subtraction.

10 / 3

10 - 3 = 7 → 1
7 - 3  = 4 → 1
4 - 3  = 1 → 1
1 < 3       → STOP

Return:
0 → 1 → 2 → 3

Answer = 3

Base:
absN < absM → 0

Recursive:
1 + computeQuo(absN - absM, absM)

Time: O(n/m)
Space: O(n/m)
*/