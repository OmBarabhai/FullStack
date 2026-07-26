
public class FIB_21_40 {

    /*
 * Problem 21 : Print Fibonacci Numbers Between Two Numbers
 *
 * Algorithm:
 * 1. Start with first = 0 and second = 1.
 * 2. Generate Fibonacci numbers.
 * 3. Print numbers lying between start and end (inclusive).
 * 4. Stop when current Fibonacci number becomes greater than end.
 *
 * Dry Run (start = 10, end = 100):
 * 13 21 34 55 89
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static void fibonacci21(long start, long end) {

        long a = 0;
        long b = 1;

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

    /*
 * Problem 22 : Count Fibonacci Numbers Between Two Numbers
 *
 * Algorithm:
 * 1. Start with first = 0 and second = 1.
 * 2. Generate Fibonacci numbers.
 * 3. Count numbers lying between start and end.
 * 4. Stop when current Fibonacci number becomes greater than end.
 *
 * Dry Run (start = 10, end = 100):
 * Fibonacci Numbers:
 * 13 21 34 55 89
 *
 * Count = 5
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static int fibonacci22(long start, long end) {

        long a = 0;
        long b = 1;

        int count = 0;

        while (a <= end) {

            if (a >= start) {
                count++;
            }

            long c = a + b;
            a = b;
            b = c;
        }

        return count;
    }

    /*
 * Problem 23 : Continuous Fibonacci Triangle
 *
 * Algorithm:
 * 1. Start with first = 0 and second = 1.
 * 2. Print one number in first row.
 * 3. Print two numbers in second row.
 * 4. Continue Fibonacci sequence without restarting.
 *
 * Dry Run (N = 4):
 *
 * 0
 * 1 1
 * 2 3 5
 * 8 13 21 34
 *
 * Time  : O(n²)
 * Space : O(1)
     */
    static void fibonacci23(int n) {

        long a = 0;
        long b = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= i; j++) {

                System.out.print(a + " ");

                long c = a + b;
                a = b;
                b = c;
            }

            System.out.println();
        }
    }

    /*
 * Problem 24 : Reverse Continuous Fibonacci Triangle
 *
 * Algorithm:
 * 1. Generate all Fibonacci numbers required.
 * 2. Store them in an array.
 * 3. Print rows in reverse order.
 *
 * Dry Run (N = 4):
 *
 * 8 13 21 34
 * 2 3 5
 * 1 1
 * 0
 *
 * Time  : O(n²)
 * Space : O(n)
     */
    static void fibonacci24(int n) {

        int total = n * (n + 1) / 2;

        long[] fib = new long[total];

        long a = 0;
        long b = 1;

        for (int i = 0; i < total; i++) {

            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        int index = total;

        for (int row = n; row >= 1; row--) {

            index -= row;

            for (int j = index; j < index + row; j++) {
                System.out.print(fib[j] + " ");
            }

            System.out.println();
        }
    }

    /*
 * Problem 25 : Right Aligned Increasing Fibonacci Pattern
 *
 * Algorithm:
 * 1. Generate first N Fibonacci numbers.
 * 2. Store them in an array.
 * 3. Print leading spaces.
 * 4. Print Fibonacci numbers from index 0 to current row.
 *
 * Dry Run (N = 5):
 *
 *         0
 *       0 1
 *     0 1 1
 *   0 1 1 2
 * 0 1 1 2 3
 *
 * Time  : O(n²)
 * Space : O(n)
     */
    static void fibonacci25(int n) {

        long[] fib = new long[n];

        long a = 0;
        long b = 1;

        for (int i = 0; i < n; i++) {

            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        for (int i = 1; i <= n; i++) {

            // spaces
            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            // fibonacci numbers
            for (int j = 0; j < i; j++) {
                System.out.print(fib[j] + " ");
            }

            System.out.println();
        }
    }

    /*
 * Problem 26 : Right Aligned Decreasing Fibonacci Pattern
 *
 * Algorithm:
 * 1. Generate first N Fibonacci numbers.
 * 2. Store them in an array.
 * 3. Print increasing spaces.
 * 4. Print one less Fibonacci number every row.
 *
 * Dry Run (N = 5):
 *
 * 0 1 1 2 3
 *   0 1 1 2
 *     0 1 1
 *       0 1
 *         0
 *
 * Time  : O(n²)
 * Space : O(n)
     */
    static void fibonacci26(int n) {

        long[] fib = new long[n];

        long a = 0;
        long b = 1;

        for (int i = 0; i < n; i++) {

            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        for (int i = n; i >= 1; i--) {

            // spaces
            for (int s = 0; s < n - i; s++) {
                System.out.print("  ");
            }

            // fibonacci numbers
            for (int j = 0; j < i; j++) {
                System.out.print(fib[j] + " ");
            }

            System.out.println();
        }
    }

    /*
 * Problem 27 : Fibonacci Pyramid
 *
 * Algorithm:
 * 1. Start with first = 0 and second = 1.
 * 2. Print leading spaces.
 * 3. Print Fibonacci numbers continuously.
 *
 * Dry Run (N = 4):
 *
 *       0
 *     1 1
 *   2 3 5
 * 8 13 21 34
 *
 * Time  : O(n²)
 * Space : O(1)
     */
    static void fibonacci27(int n) {

        long a = 0;
        long b = 1;

        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {

                System.out.print(a + " ");

                long c = a + b;
                a = b;
                b = c;
            }

            System.out.println();
        }
    }

    /*
 * Problem 28 : Inverted Fibonacci Pyramid
 *
 * Algorithm:
 * 1. Generate all Fibonacci numbers needed.
 * 2. Store them in an array.
 * 3. Print rows from bottom to top.
 *
 * Dry Run (N = 4):
 *
 * 8 13 21 34
 *   2 3 5
 *     1 1
 *       0
 *
 * Time  : O(n²)
 * Space : O(n)
     */
    static void fibonacci28(int n) {

        int total = n * (n + 1) / 2;

        long[] fib = new long[total];

        long a = 0;
        long b = 1;

        for (int i = 0; i < total; i++) {

            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        int index = total;

        for (int row = n; row >= 1; row--) {

            index -= row;

            for (int s = 0; s < n - row; s++) {
                System.out.print("  ");
            }

            for (int j = index; j < index + row; j++) {
                System.out.print(fib[j] + " ");
            }

            System.out.println();
        }
    }

    /*
 * Problem 29 : Fibonacci Diamond
 *
 * Time  : O(n²)
 * Space : O(1)
     */
    static void fibonacci29(int n) {

        long a = 0;
        long b = 1;

        // Upper Half
        for (int i = 1; i <= n; i++) {

            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {

                System.out.print(a + " ");

                long c = a + b;
                a = b;
                b = c;
            }

            System.out.println();
        }

        // Lower Half
        for (int i = n - 1; i >= 1; i--) {

            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }

            for (int j = 1; j <= i; j++) {

                System.out.print(a + " ");

                long c = a + b;
                a = b;
                b = c;
            }

            System.out.println();
        }
    }

    /*
 * Problem 30 : Zig-Zag Fibonacci Pattern
 *
 * Algorithm:
 * Odd Rows    -> Right to Left
 * Even Rows   -> Left to Right
 *
 * Time  : O(n²)
 * Space : O(n)
     */
    static void fibonacci30(int n) {

        int total = n * (n + 1) / 2;

        long[] fib = new long[total];

        long a = 0;
        long b = 1;

        for (int i = 0; i < total; i++) {

            fib[i] = a;

            long c = a + b;
            a = b;
            b = c;
        }

        int index = 0;

        for (int row = 1; row <= n; row++) {

            if (row % 2 == 0) {

                for (int j = index; j < index + row; j++) {
                    System.out.print(fib[j] + " ");
                }

            } else {

                for (int j = index + row - 1; j >= index; j--) {
                    System.out.print(fib[j] + " ");
                }
            }

            index += row;
            System.out.println();
        }
    }

    /*
 * Problem 31 : Print First N Fibonacci Numbers in Reverse Order
 *
 * Algorithm:
 * 1. Store first N Fibonacci numbers in an array.
 * 2. Traverse the array from last index to first.
 * 3. Print each element.
 *
 * Dry Run (N = 7):
 * Array : 0 1 1 2 3 5 8
 *
 * Output:
 * 8 5 3 2 1 1 0
 *
 * Time  : O(n)
 * Space : O(n)
     */
    static void fibonacci31(int n) {

        long[] fib = new long[n];

        long a = 0;
        long b = 1;

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
 * Problem 32 : Check Whether a Number is the Sum of
 *              Two Consecutive Fibonacci Numbers
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Check whether current pair sums to n.
 * 3. If found return true.
 * 4. Else continue until sum exceeds n.
 *
 * Example:
 * Input : 8
 *
 * Output:
 * Yes
 * 3 + 5 = 8
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static boolean fibonacci32(long n) {

        long a = 0;
        long b = 1;

        while (a + b <= n) {

            if (a + b == n) {

                System.out.println("Yes");
                System.out.println(a + " + " + b + " = " + n);

                return true;
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println("No");

        return false;
    }

    /*
    * Problem 33 : Find the Closest Fibonacci Number
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Stop when current >= n.
 * 3. Compare previous and current.
 * 4. Print the closest Fibonacci number.
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static void fibonacci33(long n) {

        long a = 0;
        long b = 1;

        while (b < n) {

            long c = a + b;
            a = b;
            b = c;
        }

        long diff1 = n - a;
        long diff2 = b - n;

        if (diff1 < diff2) {
            System.out.println("Closest Fibonacci : " + a);
        } else if (diff2 < diff1) {
            System.out.println("Closest Fibonacci : " + b);
        } else {
            System.out.println("Both are equally close : " + a + " " + b);
        }
    }

    /*
 * Problem 34 : Find Previous and Next Fibonacci Numbers
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Stop when current >= n.
 * 3. Print previous and next Fibonacci numbers.
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static void fibonacci34(long n) {

        long a = 0;
        long b = 1;

        while (b < n) {

            long c = a + b;
            a = b;
            b = c;
        }

        if (b == n) {
            System.out.println(n + " is a Fibonacci Number.");
        }

        System.out.println("Previous : " + a);
        System.out.println("Next     : " + b);
    }

    /*
 * Problem 35 : Print Fibonacci Numbers at Prime Indices
 *
 * Algorithm:
 * 1. Generate first N Fibonacci numbers.
 * 2. Check whether index is prime.
 * 3. Print Fibonacci number at prime indices.
 *
 * Time  : O(n√n)
 * Space : O(1)
     */
    static void fibonacci35(int n) {

        long a = 0;
        long b = 1;

        for (int index = 0; index < n; index++) {

            if (isPrime(index)) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    static boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    /*
 * Problem 36 : Print Every Alternate Fibonacci Number
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Print Fibonacci numbers at even indices.
 *
 * Time  : O(n)
 * Space : O(1)
     */
    static void fibonacci36(int n) {

        long a = 0;
        long b = 1;

        for (int index = 0; index < n; index++) {

            if (index % 2 == 0) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    /*
 * Problem 37 : Product of First N Fibonacci Numbers
 *
 * Algorithm:
 * 1. Generate first N Fibonacci numbers.
 * 2. Multiply each number into product.
 * 3. Print the final product.
 *
 * Time  : O(n)
 * Space : O(1)
     */
    static void fibonacci37(int n) {

        long a = 0;
        long b = 1;

        long product = 1;

        for (int i = 0; i < n; i++) {

            product *= a;

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println("Product : " + product);
    }

    /*
 * Problem 38 : Largest Fibonacci Number Less Than or Equal to a Limit
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Stop when current Fibonacci number exceeds limit.
 * 3. Print previous Fibonacci number.
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static void fibonacci38(long limit) {

        long a = 0;
        long b = 1;

        while (b <= limit) {

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println("Largest Fibonacci <= " + limit + " : " + a);
    }

    /*
 * Problem 39 : Print Fibonacci Numbers Ending with a Given Digit
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Check last digit using %10.
 * 3. Print matching numbers.
 *
 * Time  : O(k)
 * Space : O(1)
     */

    static void fibonacci39(long limit, int digit) {

        long a = 0;
        long b = 1;

        while (a <= limit) {

            if (a % 10 == digit) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    /*
 * Problem 40 : Print Fibonacci Numbers Divisible by K
 *
 * Algorithm:
 * 1. Generate Fibonacci numbers.
 * 2. Check divisibility using %.
 * 3. Print matching numbers.
 *
 * Time  : O(k)
 * Space : O(1)
     */
    static void fibonacci40(long limit, int k) {

        long a = 0;
        long b = 1;

        while (a <= limit) {

            if (a % k == 0) {
                System.out.print(a + " ");
            }

            long c = a + b;
            a = b;
            b = c;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("============== Problem 21 ==============");
        fibonacci21(10, 100);

        System.out.println("\n============== Problem 22 ==============");
        System.out.println("Count : " + fibonacci22(10, 100));

        System.out.println("\n============== Problem 23 ==============");
        fibonacci23(4);

        System.out.println("\n============== Problem 24 ==============");
        fibonacci24(4);

        System.out.println("\n============== Problem 25 ==============");
        fibonacci25(5);

        System.out.println("\n============== Problem 26 ==============");
        fibonacci26(5);

        System.out.println("\n============== Problem 27 ==============");
        fibonacci27(4);

        System.out.println("\n============== Problem 28 ==============");
        fibonacci28(4);

        System.out.println("\n============== Problem 29 ==============");
        fibonacci29(4);

        System.out.println("\n============== Problem 30 ==============");
        fibonacci30(5);

        System.out.println("\n============== Problem 31 ==============");
        fibonacci31(7);

        System.out.println("\n============== Problem 32 ==============");
        fibonacci32(8);

        System.out.println("\n============== Problem 33 ==============");
        fibonacci33(30);

        System.out.println("\n============== Problem 34 ==============");
        fibonacci34(25);

        System.out.println("\n============== Problem 35 ==============");
        fibonacci35(10);

        System.out.println("\n============== Problem 36 ==============");
        fibonacci36(10);

        System.out.println("\n============== Problem 37 ==============");
        fibonacci37(6);

        System.out.println("\n============== Problem 38 ==============");
        fibonacci38(1000);

        System.out.println("\n============== Problem 39 ==============");
        fibonacci39(1000, 5);

        System.out.println("\n============== Problem 40 ==============");
        fibonacci40(1000, 5);

    }
}
