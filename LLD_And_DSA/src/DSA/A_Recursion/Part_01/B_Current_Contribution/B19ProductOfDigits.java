package DSA.A_Recursion.Part_01.B_Current_Contribution;

import java.math.BigInteger;

public class B19ProductOfDigits {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(d)
     * Space : O(d)
     * =========================================
     */
    public static int productOfDigits(int n) {

        if (n == 0) {
            return 1;
        }

        return (n % 10) * productOfDigits(n / 10);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(d)
     * Space : O(1)
     * =========================================
     */
    public static int productOfDigitsIterative(int n) {

        int product = 1;

        while (n > 0) {

            product *= (n % 10);

            n /= 10;
        }

        return product;
    }

    /*
     * =========================================
     * Solution 3 : long
     * Safe for larger answers
     * =========================================
     */
    public static long productOfDigitsLong(long n) {

        if (n == 0) {
            return 1L;
        }

        return (n % 10) * productOfDigitsLong(n / 10);
    }

    /*
     * =========================================
     * Solution 4 : BigInteger
     * Unlimited Size
     * =========================================
     */
    public static BigInteger productOfDigitsBigInteger(BigInteger n) {

        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        }

        BigInteger lastDigit = n.mod(BigInteger.TEN);

        return lastDigit.multiply(
                productOfDigitsBigInteger(n.divide(BigInteger.TEN))
        );
    }

    public static void main(String[] args) {

        int n = 234;

        System.out.println("Recursive : "
                + productOfDigits(n));

        System.out.println("Iterative : "
                + productOfDigitsIterative(n));

        System.out.println("Long : "
                + productOfDigitsLong(n));

        System.out.println("BigInteger : "
                + productOfDigitsBigInteger(
                new BigInteger("234")));
    }
}

/*
=================================================
Problem 19 : Product of Digits
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Find the product of all digits of a number using recursion.

Example
-------

Input

n = 234

Output

24

Explanation

2 × 3 × 4 = 24

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

×

Smaller Problem

Current Contribution

n % 10

×

Smaller Problem

productOfDigits(n / 10)

Formula

productOfDigits(n)

=

(n % 10)

×

productOfDigits(n / 10)

-------------------------------------------------
Dry Run
-------------------------------------------------

productOfDigits(234)

↓

4 × productOfDigits(23)

↓

4 × (3 × productOfDigits(2))

↓

4 × (3 × (2 × productOfDigits(0)))

↓

4 × 3 × 2 × 1

↓

24

-------------------------------------------------
Returning Phase
-------------------------------------------------

productOfDigits(0)

1

↓

productOfDigits(2)

2

↓

productOfDigits(23)

6

↓

productOfDigits(234)

24

-------------------------------------------------
Recursion Tree
-------------------------------------------------

productOfDigits(234)
│
├──4
└──productOfDigits(23)
      │
      ├──3
      └──productOfDigits(2)
            │
            ├──2
            └──productOfDigits(0)
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

return (n % 10) * productOfDigits(n / 10);

-------------------------------------------------
Base Case
-------------------------------------------------

if (n == 0)
    return 1;

-------------------------------------------------
Why return 1 instead of 0?
-------------------------------------------------

1 is the multiplicative identity.

Any number × 1 = Same Number

Example

2 × 3 × 4 × 1 = 24

If we returned 0

2 × 3 × 4 × 0 = 0

The answer would always become 0.

-------------------------------------------------
Complexities
-------------------------------------------------

Recursive

Time  : O(d)

Space : O(d)

Iterative

Time  : O(d)

Space : O(1)

where

d = Number of Digits

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

Used for

✔ Very large products

✔ Competitive Programming

✔ Interview Follow-up

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

Related Problems

✔ Sum of Digits

✔ Count Digits

✔ Reverse Number

✔ Digital Root

✔ Product of Array

✔ Largest Digit

✔ Smallest Digit

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Extract Digit using (n % 10)

✔ Remove Last Digit using (n / 10)

✔ Multiplicative Identity (1)

✔ Foundation for digit-based recursion problems
*/