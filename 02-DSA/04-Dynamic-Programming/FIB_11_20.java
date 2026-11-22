public class FIB_11_20 {

    /*
     * Problem 11 : Store First N Fibonacci Numbers in an Array
     *
     * Algorithm:
     * 1. Create an array of size N.
     * 2. Generate Fibonacci numbers.
     * 3. Store each number in the array.
     * 4. Print the array.
     *
     * Dry Run (N = 5):
     * 0 1 1 2 3
     *
     * Time  : O(n)
     * Space : O(n)
     */
    static void fibonacci11(int n) {
        long[] fib = new long[n];

        long a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        for (long x : fib) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    /*
     * Problem 12 : Reverse Print First N Fibonacci Numbers
     *
     * Algorithm:
     * 1. Store Fibonacci numbers in an array.
     * 2. Print the array from last to first.
     *
     * Dry Run (N = 5):
     * 3 2 1 1 0
     *
     * Time  : O(n)
     * Space : O(n)
     */
    static void fibonacci12(int n) {

        long[] fib = new long[n];

        long a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        for (int i = n - 1; i >= 0; i--) {
            System.out.print(fib[i] + " ");
        }

        System.out.println();
    }

    /*
     * Problem 13 : Largest Fibonacci Number Less Than N
     *
     * Algorithm:
     * 1. Generate Fibonacci numbers.
     * 2. Stop before crossing N.
     * 3. Return previous Fibonacci number.
     *
     * Dry Run (N = 100):
     * Answer = 89
     *
     * Time  : O(k)
     * Space : O(1)
     */
    static long fibonacci13(long n) {

        long a = 0, b = 1;

        while (b < n) {
            long c = a + b;
            a = b;
            b = c;
        }

        return a;
    }

    /*
     * Problem 14 : Smallest Fibonacci Number Greater Than N
     *
     * Algorithm:
     * 1. Generate Fibonacci numbers.
     * 2. Stop when current number becomes greater than N.
     * 3. Return current number.
     *
     * Dry Run (N = 100):
     * Answer = 144
     *
     * Time  : O(k)
     * Space : O(1)
     */
    static long fibonacci14(long n) {

        long a = 0, b = 1;

        while (a <= n) {
            long c = a + b;
            a = b;
            b = c;
        }

        return a;
    }

    /*
     * Problem 15 : Difference Between Consecutive Fibonacci Numbers
     *
     * Algorithm:
     * 1. Store Fibonacci numbers.
     * 2. Print difference of adjacent numbers.
     *
     * Dry Run (N = 5):
     * 1 0 1 1
     *
     * Time  : O(n)
     * Space : O(n)
     */
    static void fibonacci15(int n) {

        long[] fib = new long[n];

        long a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        for (int i = 0; i < n - 1; i++) {
            System.out.print((fib[i + 1] - fib[i]) + " ");
        }

        System.out.println();
    }

    /*
     * Problem 16 : Print Fibonacci Numbers Divisible by 3
     *
     * Algorithm:
     * 1. Generate first N Fibonacci numbers.
     * 2. Check divisibility by 3.
     * 3. Print matching numbers.
     *
     * Dry Run (N = 10):
     * 0 3 21
     *
     * Time  : O(n)
     * Space : O(1)
     */
    static void fibonacci16(int n) {

        long a = 0, b = 1;

        for (int i = 0; i < n; i++) {

            if (a % 3 == 0) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    /*
     * Problem 17 : Sum of Even Fibonacci Numbers
     *
     * Algorithm:
     * 1. Generate first N Fibonacci numbers.
     * 2. Add only even numbers.
     * 3. Return sum.
     *
     * Dry Run (N = 10):
     * 0 + 2 + 8 + 34 = 44
     *
     * Time  : O(n)
     * Space : O(1)
     */
    static long fibonacci17(int n) {

        long a = 0, b = 1;
        long sum = 0;

        for (int i = 0; i < n; i++) {

            if ((a & 1) == 0)
                sum += a;

            long c = a + b;
            a = b;
            b = c;
        }

        return sum;
    }

    /*
     * Problem 18 : Sum of Odd Fibonacci Numbers
     *
     * Algorithm:
     * 1. Generate first N Fibonacci numbers.
     * 2. Add only odd numbers.
     * 3. Return sum.
     *
     * Dry Run (N = 10):
     * 1+1+3+5+13+21 = 44
     *
     * Time  : O(n)
     * Space : O(1)
     */
    static long fibonacci18(int n) {

        long a = 0, b = 1;
        long sum = 0;

        for (int i = 0; i < n; i++) {

            if ((a & 1) == 1)
                sum += a;

            long c = a + b;
            a = b;
            b = c;
        }

        return sum;
    }

    /*
     * Problem 19 : Find Index of a Fibonacci Number
     *
     * Algorithm:
     * 1. Generate Fibonacci numbers.
     * 2. Count index.
     * 3. Return index if found.
     * 4. Else return -1.
     *
     * Dry Run (13):
     * Answer = 7
     *
     * Time  : O(k)
     * Space : O(1)
     */
    static int fibonacci19(long n) {

        long a = 0, b = 1;

        int index = 0;

        while (a < n) {

            long c = a + b;
            a = b;
            b = c;

            index++;
        }

        return a == n ? index : -1;
    }

    /*
     * Problem 20 : Print Fibonacci Numbers in a Range
     *
     * Algorithm:
     * 1. Generate Fibonacci numbers.
     * 2. Print numbers between start and end.
     *
     * Dry Run (10,100):
     * 13 21 34 55 89
     *
     * Time  : O(k)
     * Space : O(1)
     */
    static void fibonacci20(long start, long end) {

        long a = 0, b = 1;

        while (a <= end) {

            if (a >= start) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Problem11");
        fibonacci11(n);

        System.out.println("Problem12");
        fibonacci12(n);

        System.out.println("Problem13");
        System.out.println(fibonacci13(100));

        System.out.println("Problem14");
        System.out.println(fibonacci14(100));

        System.out.println("Problem15");
        fibonacci15(n);

        System.out.println("Problem16");
        fibonacci16(n);

        System.out.println("Problem17");
        System.out.println(fibonacci17(n));

        System.out.println("Problem18");
        System.out.println(fibonacci18(n));

        System.out.println("Problem19");
        System.out.println(fibonacci19(13));

        System.out.println("Problem20");
        fibonacci20(10, 100);
    }
}