package DSA.A_Recursion.A_Part_01.B_Current_Contribution;

import java.math.BigInteger;

public class B12Factorial {

    /*
     * =========================================
     * Solution 1 : Recursion (Recommended)
     * Pattern : Current Contribution
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static int factorial(int n) {

        // Base Case
        if (n == 0) {
            return 1;
        }

        // Current Contribution × Smaller Problem
        return n * factorial(n - 1);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(n)
     * Space : O(1)
     * =========================================
     */
    public static int factorialIterative(int n) {

        int fact = 1;

        for (int i = 2; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    /*
     * =========================================
     * Solution 3 : long
     * Safe till 20!
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static long factorialLong(int n) {

        if (n == 0) {
            return 1L;
        }

        return n * factorialLong(n - 1);
    }

    /*
     * =========================================
     * Solution 4 : BigInteger
     * Unlimited Size
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static BigInteger factorialBigInteger(int n) {

        if (n == 0) {
            return BigInteger.ONE;
        }

        return BigInteger.valueOf(n)
                .multiply(factorialBigInteger(n - 1));
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Recursive      : " + factorial(n));
        System.out.println("Iterative      : " + factorialIterative(n));
        System.out.println("Long           : " + factorialLong(n));
        System.out.println("BigInteger     : " + factorialBigInteger(n));
    }
}

/*
=================================================
Problem 12 : Factorial
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------
Find the factorial of a number using recursion.

Example
-------
Input:
n = 5

Output:
120

Explanation:
5! = 5 × 4 × 3 × 2 × 1

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

×

Smaller Problem

Current Contribution:
n

Smaller Problem:
factorial(n - 1)

Formula

factorial(n)
=
n × factorial(n - 1)

-------------------------------------------------
Dry Run
-------------------------------------------------

factorial(4)

↓

4 × factorial(3)

↓

3 × factorial(2)

↓

2 × factorial(1)

↓

1 × factorial(0)

↓

Base Case

return 1

-------------------------------------------------
Returning Phase
-------------------------------------------------

factorial(1)

1 × 1 = 1

↓

factorial(2)

2 × 1 = 2

↓

factorial(3)

3 × 2 = 6

↓

factorial(4)

4 × 6 = 24

-------------------------------------------------
Recursion Tree
-------------------------------------------------

factorial(4)
│
├── 4
└── factorial(3)
      │
      ├── 3
      └── factorial(2)
            │
            ├── 2
            └── factorial(1)
                  │
                  ├── 1
                  └── factorial(0)
                        │
                        └── 1

-------------------------------------------------
Pattern
-------------------------------------------------

Current Contribution

×

Smaller Problem

return n * factorial(n - 1);

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

-------------------------------------------------
Data Type Guide
-------------------------------------------------

int
----
Safe till 12!

13! overflows int.

long
-----
Safe till 20!

21! overflows long.

BigInteger
----------
No fixed limit.

Used for:
• Very large factorials
• Competitive Programming
• Interview follow-up questions

Example

import java.math.BigInteger;

-------------------------------------------------
Which One Should I Use?
-------------------------------------------------

n <= 12
Use int

n <= 20
Use long

n > 20
Use BigInteger

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

Q. Why is the base case n == 0?

Because

0! = 1

by mathematical definition.

Q. Why isn't memoization useful?

Each factorial value is computed only once.

There are no overlapping subproblems.

Q. Can factorial be solved iteratively?

Yes.

It reduces recursion stack space from O(n) to O(1).

-------------------------------------------------
Learning
-------------------------------------------------

✔ First Current Contribution problem.
✔ Learn multiplication with recursive answers.
✔ Foundation for:
    - Power
    - Product of Array
    - Product of Digits
    - Exponentiation
*/