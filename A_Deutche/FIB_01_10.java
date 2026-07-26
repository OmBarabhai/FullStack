import java.util.Scanner;

public class FIB_01_10 {

    /*
        * Problem 1 : Print First N Fibonacci Numbers
        *
        * Algorithm:
        * 1. Start with first = 0 and second = 1.
        * 2. Print the current Fibonacci number.
        * 3. Generate the next Fibonacci number.
        * 4. Update first and second.
        * 5. Repeat N times.
        *
        * Dry Run (N = 5):
        * 0 1 1 2 3
        *
        * Time  : O(n)
        * Space : O(1)
     */
    static void fibonacci1(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /*
        * Problem 2 : Print Nth Fibonacci Number
        *
        * Algorithm:
        * 1. Handle n = 0 and n = 1.
        * 2. Generate Fibonacci numbers up to the nth position.
        * 3. Return the nth Fibonacci number.
        *
        * Dry Run (N = 7):
        * 0 1 1 2 3 5 8 13
        * Answer = 13
        *
        * Time  : O(n)
        * Space : O(1)
     */
    static long fibonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long c = a + b;
            a = b;
            b = c;
        }
        return n == 1 ? 1 : b;
    }

    /*
         * Problem 3 : Print Fibonacci Numbers <= N
         *
         * Algorithm:
         * 1. Start with 0 and 1.
         * 2. Print the current Fibonacci number.
         * 3. Generate the next Fibonacci number.
         * 4. Stop when the number becomes greater than N.
         *
         * Dry Run (N = 20):
         * 0 1 1 2 3 5 8 13
         *
         * Time  : O(k)
         * Space : O(1)
         *
         * (k = Number of Fibonacci numbers <= N)
     */
    static void fibonacci3(long n) {
        long a = 0, b = 1;
        while (a <= n) {
            System.out.print(a + " ");
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /*
        * Problem 4 : Count Fibonacci Numbers <= N
        *
        * Algorithm:
        * 1. Start with 0 and 1.
        * 2. Count every Fibonacci number.
        * 3. Generate the next Fibonacci number.
        * 4. Stop when the number becomes greater than N.
        *
        * Dry Run (N = 20):
        * 0 1 1 2 3 5 8 13
        * Count = 8
        *
        * Time  : O(k)
        * Space : O(1)
     */
    static int fibonacci4(long n) {
        long a = 0, b = 1;
        int count = 0;
        while (a <= n) {
            count++;
            long c = a + b;
            a = b;
            b = c;
        }
        return count;
    }

    /*
         * Problem 5 : Sum of First N Fibonacci Numbers
         *
         * Algorithm:
         * 1. Generate the first N Fibonacci numbers.
         * 2. Add each number to the sum.
         * 3. Print the final sum.
         *
         * Dry Run (N = 5):
         * 0 + 1 + 1 + 2 + 3 = 7
         *
         * Time  : O(n)
         * Space : O(1)
     */
    static long fibonacci5(int n) {
        long a = 0, b = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a;
            long c = a + b;
            a = b;
            b = c;
        }
        return sum;
    }

    /*
         * Problem 6 : Check Whether a Number is Fibonacci
         *
         * Algorithm:
         * 1. Generate Fibonacci numbers.
         * 2. Stop when the current number is >= N.
         * 3. If current number equals N, return true.
         * 4. Otherwise, return false.
         *
         * Dry Run (N = 21):
         * 0 1 1 2 3 5 8 13 21
         * Answer = YES
         *
         * Time  : O(k)
         * Space : O(1)
     */
    static boolean fibonacci6(long n) {
        long a = 0, b = 1;
        while (a < n) {
            long c = a + b;
            a = b;
            b = c;
        }
        return a == n;
    }

    /*
         * Problem 7 : Print Even Fibonacci Numbers
         *
         * Algorithm:
         * 1. Generate the first N Fibonacci numbers.
         * 2. Check if the number is even.
         * 3. Print only even Fibonacci numbers.
         *
         * Dry Run (N = 10):
         * 0 1 1 2 3 5 8 13 21 34
         * Output = 0 2 8 34
         *
         * Time  : O(n)
         * Space : O(1)
     */
    static void fibonacci7(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            if ((a & 1) != 1) {
                System.out.print(a + " ");
            }
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /*
        * Problem 8 : Print Odd Fibonacci Numbers
        *
        * Algorithm:
        * 1. Generate the first N Fibonacci numbers.
        * 2. Check if the number is odd.
        * 3. Print only odd Fibonacci numbers.
        *
        * Dry Run (N = 10):
        * 0 1 1 2 3 5 8 13 21 34
        * Output = 1 1 3 5 13 21
        *
        * Time  : O(n)
        * Space : O(1)
     */
    static void fibonacci8(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            if ((a & 1) == 1) {
                System.out.print(a + " ");
            }
            long c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    /*
        * Problem 9 : Increasing Fibonacci Pattern
        *
        * Algorithm:
        * 1. Generate the first N Fibonacci numbers.
        * 2. Store them in an array.
        * 3. Print one more number in each row.
        *
        * Dry Run (N = 5):
        * 0
        * 0 1
        * 0 1 1
        * 0 1 1 2
        * 0 1 1 2 3
        *
        * Time  : O(n²)
        * Space : O(n)
     */
    static void fibonacci9(int n) {
        long[] fib = new long[n];
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fib[i] = a;
            long c = a + b;
            a = b;
            b = c;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(fib[j] + " ");
            }
            System.out.println();
        }
    }

    /*
        * Problem 10 : Decreasing Fibonacci Pattern
        *
        * Algorithm:
        * 1. Generate the first N Fibonacci numbers.
        * 2. Store them in an array.
        * 3. Print one less number in each row.
        *
        * Dry Run (N = 5):
        * 0 1 1 2 3
        * 0 1 1 2
        * 0 1 1
        * 0 1
        * 0
        *
        * Time  : O(n²)
        * Space : O(n)
     */
    static void fibonacci10(int n) {
        long[] fib = new long[n];
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            fib[i] = a;
            long c = a + b;
            a = b;
            b = c;
        }
        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(fib[j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println("Problem1");
        fibonacci1(n);
        System.out.println("Problem2");
        System.out.println(fibonacci2(n));
        System.out.println("Problem3");
        fibonacci3(n);
        System.out.println("Problem4");
        System.out.println(fibonacci4(n));
        System.out.println("Problem5");
        System.out.println(fibonacci5(n));
        System.out.println("Problem6");
        System.out.println(fibonacci6(n) ? "YES" : "NO");
        System.out.println("Problem7");
        fibonacci7(n);
        System.out.println("Problem 8");
        fibonacci8(n);
        System.out.println("Problem9");
        fibonacci9(n);
        System.out.println("Problem10");
        fibonacci10(n);

        sc.close();
    }
}
