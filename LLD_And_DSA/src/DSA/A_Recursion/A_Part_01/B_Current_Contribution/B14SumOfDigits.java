package DSA.A_Recursion.A_Part_01.B_Current_Contribution;

public class B14SumOfDigits {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(d)
     * Space : O(d)
     * =========================================
     */
    public static int sumOfDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return (n % 10) + sumOfDigits(n / 10);
    }

    /*
     * =========================================
     * Solution 2 : Iterative
     * Time  : O(d)
     * Space : O(1)
     * =========================================
     */
    public static int sumOfDigitsIterative(int n) {

        int sum = 0;

        while (n > 0) {

            sum += n % 10;

            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        int n = 3723;

        System.out.println("Recursive : " + sumOfDigits(n));

        System.out.println("Iterative : " + sumOfDigitsIterative(n));
    }
}

/*
=================================================
Problem 14 : Sum of Digits
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Find the sum of all digits of a number using recursion.

Example
-------

Input

n = 3723

Output

15

Explanation

3 + 7 + 2 + 3 = 15

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

+

Smaller Problem

Current Contribution

n % 10

+

Smaller Problem

sumOfDigits(n / 10)

Formula

sumOfDigits(n)

=

(n % 10)

+

sumOfDigits(n / 10)

-------------------------------------------------
Dry Run
-------------------------------------------------

sumOfDigits(3723)

↓

3 + sumOfDigits(372)

↓

3 + (2 + sumOfDigits(37))

↓

3 + (2 + (7 + sumOfDigits(3)))

↓

3 + (2 + (7 + (3 + sumOfDigits(0))))

↓

3 + 2 + 7 + 3 + 0

↓

15

-------------------------------------------------
Returning Phase
-------------------------------------------------

sumOfDigits(0)

0

↓

sumOfDigits(3)

3

↓

sumOfDigits(37)

10

↓

sumOfDigits(372)

12

↓

sumOfDigits(3723)

15

-------------------------------------------------
Recursion Tree
-------------------------------------------------

sumOfDigits(3723)
│
├── 3
└── sumOfDigits(372)
      │
      ├── 2
      └── sumOfDigits(37)
            │
            ├── 7
            └── sumOfDigits(3)
                  │
                  ├── 3
                  └── sumOfDigits(0)
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

return (n % 10) + sumOfDigits(n / 10);

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
Interview Follow-up
-------------------------------------------------

Related Problems

✔ Count Digits

✔ Product of Digits

✔ Reverse Number

✔ Digital Root

✔ Sum of Even Digits

✔ Sum of Odd Digits

✔ Largest Digit

✔ Smallest Digit

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Extract Digit using (n % 10)

✔ Remove Last Digit using (n / 10)

✔ Foundation for many digit recursion problems
*/