package DSA.A_Recursion.B_Current_Contribution;

import java.math.BigInteger;

public class B13Power {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(n)
     * Space : O(1)
     * =========================================
     */
    public static int powerIterative(int x, int n) {

        int ans = 1;

        for (int i = 1; i <= n; i++) {
            ans *= x;
        }

        return ans;
    }

    /*
     * =========================================
     * Solution 3 : long
     * Safe for larger values
     * =========================================
     */
    public static long powerLong(long x, int n) {

        if (n == 0) {
            return 1L;
        }

        return x * powerLong(x, n - 1);
    }

    /*
     * =========================================
     * Solution 4 : BigInteger
     * Unlimited Size
     * =========================================
     */
    public static BigInteger powerBigInteger(BigInteger x, int n) {

        if (n == 0) {
            return BigInteger.ONE;
        }

        return x.multiply(powerBigInteger(x, n - 1));
    }

    /*
     * =========================================
     * Solution 5 : Binary Exponentiation
     * (Recursive)
     * Time  : O(log n)
     * Space : O(log n)
     * =========================================
     */
    public static long fastPower(long x, int n) {

        if (n == 0) {
            return 1;
        }

        long half = fastPower(x, n / 2);

        if ((n & 1) == 0) {
            return half * half;
        }

        return x * half * half;
    }

    /*
     * =========================================
     * Solution 6 : Binary Exponentiation
     * (Iterative)
     * Time  : O(log n)
     * Space : O(1)
     * =========================================
     */
    public static long fastPowerIterative(long x, int n) {

        long ans = 1;

        while (n > 0) {

            if ((n & 1) == 1) {
                ans *= x;
            }

            x *= x;

            n /= 2;
        }

        return ans;
    }
    /*
     * =========================================
     * Solution 7 : LeetCode 50 - Pow(x, n)
     * Handles Negative Powers
     * Handles Integer.MIN_VALUE
     * Time  : O(log n)
     * Space : O(log n)
     * =========================================
     */
    public static double myPow(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return pow(x, N);
    }

    private static double pow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        double half = pow(x, n / 2);

        if ((n & 1) == 0) { // Even
            return half * half;
        }

        return x * half * half; // Odd
    }
    public static void main(String[] args) {

        int x = 2;
        int n = 10;

        System.out.println("Recursive                : " + power(x, n));

        System.out.println("Iterative                : " + powerIterative(x, n));

        System.out.println("Long                     : " + powerLong(x, n));

        System.out.println("BigInteger               : "
                + powerBigInteger(BigInteger.valueOf(x), n));

        System.out.println("Fast Power (Recursive)   : "
                + fastPower(x, n));

        System.out.println("Fast Power (Iterative)   : "
                + fastPowerIterative(x, n));

        System.out.println("LeetCode Pow(x,n)        : "
                + myPow(2, -10));
        System.out.println(myPow(2, Integer.MIN_VALUE));
    }
}

/*
=================================================
Problem 13 : Power (x^n)
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------
Find x raised to the power n using recursion.

Example
-------
Input

x = 2
n = 5

Output

32

Explanation

2 × 2 × 2 × 2 × 2 = 32

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

×

Smaller Problem

Current Contribution

x

Smaller Problem

power(x, n - 1)

Formula

power(x, n)

=

x × power(x, n - 1)

-------------------------------------------------
Dry Run
-------------------------------------------------

power(2,4)

↓

2 × power(2,3)

↓

2 × power(2,2)

↓

2 × power(2,1)

↓

2 × power(2,0)

↓

return 1

-------------------------------------------------
Returning Phase
-------------------------------------------------

power(2,0)

1

↓

power(2,1)

2 × 1 = 2

↓

power(2,2)

2 × 2 = 4

↓

power(2,3)

2 × 4 = 8

↓

power(2,4)

2 × 8 = 16

-------------------------------------------------
Recursion Tree
-------------------------------------------------

power(2,4)
│
├──2
└──power(2,3)
      │
      ├──2
      └──power(2,2)
            │
            ├──2
            └──power(2,1)
                  │
                  ├──2
                  └──power(2,0)
                        │
                        └──1

-------------------------------------------------
Pattern
-------------------------------------------------

Answer

=

Current Contribution

×

Smaller Problem

return x * power(x, n - 1);

-------------------------------------------------
Base Case
-------------------------------------------------

if (n == 0)
    return 1;

-------------------------------------------------
Complexities
-------------------------------------------------

Recursive

Time  : O(n)

Space : O(n)

Iterative

Time  : O(n)

Space : O(1)

Binary Exponentiation

Time  : O(log n)

Space : O(log n)

Binary Exponentiation (Iterative)

Time  : O(log n)

Space : O(1)

-------------------------------------------------
Data Type Guide
-------------------------------------------------

int
---
Suitable for small answers.

long
----
Suitable for larger answers.

BigInteger
----------
No fixed limit.

Used for:
✔ Very large powers
✔ Competitive Programming
✔ Interview Follow-up

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

Q. Can this be optimized?

Yes.

Instead of reducing exponent by 1 every call,

power(x, n - 1)

reduce it by half.

This is called

✔ Binary Exponentiation
✔ Fast Power

Time Complexity

O(log n)

LeetCode

Problem 50 : Pow(x, n)
-------------------------------------------------
Optimization
-------------------------------------------------

Simple Recursion

power(x, n - 1)

↓

Binary Exponentiation

power(x, n / 2)

-------------------------------------------------

Pattern Evolution

Current Contribution

↓

Divide & Conquer

↓

Binary Exponentiation

-------------------------------------------------

Related Problems

LeetCode 50  - Pow(x, n)

LeetCode 231 - Power of Two

LeetCode 326 - Power of Three

LeetCode 342 - Power of Four
-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern.
✔ Foundation for Binary Exponentiation.
✔ Frequently Asked Interview Problem.
✔ One of the most important recursion problems.
*/