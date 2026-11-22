package DSA.A_Recursion.A_Part_01.B_Current_Contribution;

public class B15CountDigits {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(d)
     * Space : O(d)
     * =========================================
     */
    public static int countDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return 1 + countDigits(n / 10);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(d)
     * Space : O(1)
     * =========================================
     */
    public static int countDigitsIterative(int n) {

        int count = 0;

        while (n > 0) {

            count++;

            n /= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        int n = 179;

        System.out.println("Recursive : " + countDigits(n));

        System.out.println("Iterative : " + countDigitsIterative(n));
    }
}

/*
=================================================
Problem 15 : Count Digits
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Count the total number of digits in a number using recursion.

Example
-------

Input

n = 179

Output

3

Explanation

Digits are

1

7

9

Total Digits = 3

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

+

Smaller Problem

Current Contribution

1

+

Smaller Problem

countDigits(n / 10)

Formula

countDigits(n)

=

1 + countDigits(n / 10)

-------------------------------------------------
Dry Run
-------------------------------------------------

countDigits(179)

↓

1 + countDigits(17)

↓

1 + (1 + countDigits(1))

↓

1 + (1 + (1 + countDigits(0)))

↓

1 + 1 + 1 + 0

↓

3

-------------------------------------------------
Returning Phase
-------------------------------------------------

countDigits(0)

0

↓

countDigits(1)

1

↓

countDigits(17)

2

↓

countDigits(179)

3

-------------------------------------------------
Recursion Tree
-------------------------------------------------

countDigits(179)
│
├── 1
└── countDigits(17)
      │
      ├── 1
      └── countDigits(1)
            │
            ├── 1
            └── countDigits(0)
                  │
                  └── 0

-------------------------------------------------
Pattern
-------------------------------------------------

Answer

=

Current Contribution

+

Smaller Problem

return 1 + countDigits(n / 10);

-------------------------------------------------
Base Case
-------------------------------------------------

if (n == 0)
    return 0;

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
Edge Case
-------------------------------------------------

If the input is

n = 0

then mathematically it has

1 digit.

For that case, use

if (n == 0)
    return 1;

Otherwise, for positive numbers, the current solution is correct.

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

Related Problems

✔ Sum of Digits

✔ Product of Digits

✔ Reverse Number

✔ Digital Root

✔ Largest Digit

✔ Smallest Digit

✔ Count Even Digits

✔ Count Odd Digits

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Remove Last Digit using (n / 10)

✔ Every recursive call contributes exactly one digit

✔ Foundation for all digit-based recursion problems
*/