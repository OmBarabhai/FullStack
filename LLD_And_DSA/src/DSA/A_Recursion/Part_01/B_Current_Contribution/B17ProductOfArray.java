package DSA.A_Recursion.Part_01.B_Current_Contribution;

import java.math.BigInteger;

public class B17ProductOfArray {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static int productOfArray(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        return arr[idx] * productOfArray(arr, idx + 1);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(n)
     * Space : O(1)
     * =========================================
     */
    public static int productOfArrayIterative(int[] arr) {

        int product = 1;

        for (int num : arr) {
            product *= num;
        }

        return product;
    }

    /*
     * =========================================
     * Solution 3 : long
     * Safe for larger answers
     * =========================================
     */
    public static long productOfArrayLong(long[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        return arr[idx] * productOfArrayLong(arr, idx + 1);
    }

    /*
     * =========================================
     * Solution 4 : BigInteger
     * Unlimited Size
     * =========================================
     */
    public static BigInteger productOfArrayBigInteger(BigInteger[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        return arr[idx].multiply(productOfArrayBigInteger(arr, idx + 1));
    }

    public static void main(String[] args) {

        int[] arr = {3, 4, 3, 29, 9};

        System.out.println("Recursive : "
                + productOfArray(arr, 0));

        System.out.println("Iterative : "
                + productOfArrayIterative(arr));

        long[] longArr = {3, 4, 3, 29, 9};

        System.out.println("Long : "
                + productOfArrayLong(longArr, 0));

        BigInteger[] bigArr = {
                BigInteger.valueOf(3),
                BigInteger.valueOf(4),
                BigInteger.valueOf(3),
                BigInteger.valueOf(29),
                BigInteger.valueOf(9)
        };

        System.out.println("BigInteger : "
                + productOfArrayBigInteger(bigArr, 0));
    }
}

/*
=================================================
Problem 17 : Product of Array
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Find the product of all elements in an array using recursion.

Example
-------

Input

arr = {3,4,3,29,9}

Output

9396

Explanation

3 × 4 × 3 × 29 × 9 = 9396

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

×

Smaller Problem

Current Contribution

arr[idx]

×

Smaller Problem

productOfArray(arr, idx + 1)

Formula

productOfArray(arr, idx)

=

arr[idx]

×

productOfArray(arr, idx + 1)

-------------------------------------------------
Dry Run
-------------------------------------------------

arr = {3,4,3}

product(0)

↓

3 × product(1)

↓

3 × (4 × product(2))

↓

3 × (4 × 3)

↓

36

-------------------------------------------------
Returning Phase
-------------------------------------------------

product(2)

3

↓

product(1)

4 × 3 = 12

↓

product(0)

3 × 12 = 36

-------------------------------------------------
Recursion Tree
-------------------------------------------------

product(0)
│
├──3
└──product(1)
      │
      ├──4
      └──product(2)
            │
            └──3

-------------------------------------------------
Pattern
-------------------------------------------------

Answer

=

Current Contribution

×

Smaller Problem

return arr[idx] * productOfArray(arr, idx + 1);

-------------------------------------------------
Base Case
-------------------------------------------------

if (idx == arr.length - 1)
    return arr[idx];

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
---
Suitable for small products.

long
----
Suitable for larger products.

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

✔ Sum of Array

✔ Maximum Element

✔ Minimum Element

✔ Product Except Self

✔ Prefix Product

✔ Suffix Product

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Array Traversal using Index

✔ Foundation for recursive array problems

✔ Multiplication while returning from recursion
*/