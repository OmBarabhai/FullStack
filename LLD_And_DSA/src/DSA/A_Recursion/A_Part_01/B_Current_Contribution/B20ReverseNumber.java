package DSA.A_Recursion.A_Part_01.B_Current_Contribution;

public class B20ReverseNumber {

    /*
     * =========================================
     * Solution 1 : Current Contribution
     * Pattern : Current Contribution
     * Time  : O(d²)
     * Space : O(d)
     * =========================================
     */
    public static int reverseNumber(int n) {

        if (n == 0) {
            return 0;
        }

        int lastDigit = n % 10;

        int remaining = n / 10;

        int digits = countDigits(remaining);

//      int placeValue = (int) Math.pow(10, digits);
        int placeValue = power(10,digits);
        return lastDigit * placeValue + reverseNumber(remaining);
    }

    /*
     * =========================================
     * Helper Method
     * Count Number of Digits
     * =========================================
     */
    public static int countDigits(int n) {

        if (n == 0) {
            return 0;
        }

        return 1 + countDigits(n / 10);
    }
    public static int power(int x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * power(x, n - 1);
    }

    /*
     * =========================================
     * Solution 2 : Helper Recursion (Interview)
     * Time  : O(d)
     * Space : O(d)
     * =========================================
     */
    public static int reverseNumberHelper(int n) {
        return reverse(n, 0);
    }

    private static int reverse(int n, int ans) {

        if (n == 0) {
            return ans;
        }

        ans = ans * 10 + (n % 10);

        return reverse(n / 10, ans);
    }

    /*
     * =========================================
     * Solution 3 : Iterative
     * Time  : O(d)
     * Space : O(1)
     * =========================================
     */
    public static int reverseNumberIterative(int n) {

        int reverse = 0;

        while (n > 0) {

            reverse = reverse * 10 + (n % 10);

            n /= 10;
        }

        return reverse;
    }

    /*
     * =========================================
     * Solution 4 : StringBuilder
     * Time  : O(d)
     * Space : O(d)
     * =========================================
     */
    public static int reverseNumberString(int n) {

        String str = String.valueOf(n);

        String reverse = new StringBuilder(str).reverse().toString();

        return Integer.parseInt(reverse);
    }

    public static void main(String[] args) {

        int n = 78327;

        System.out.println("Current Contribution : "
                + reverseNumber(n));

        System.out.println("Helper Recursion     : "
                + reverseNumberHelper(n));

        System.out.println("Iterative            : "
                + reverseNumberIterative(n));

        System.out.println("StringBuilder        : "
                + reverseNumberString(n));
    }
}

/*
=================================================
Problem 20 : Reverse Number
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Reverse a given number using recursion.

Example
-------

Input

n = 78327

Output

72387

-------------------------------------------------
Approach 1
(Current Contribution)
-------------------------------------------------

Current Contribution

×

Place Value

+

Smaller Problem

Formula

reverseNumber(n)

=

(lastDigit × 10^(digits of remaining))

+

reverseNumber(remaining)

-------------------------------------------------
Dry Run
-------------------------------------------------

reverseNumber(78327)

↓

7 × 10000

+

reverseNumber(7832)

↓

70000 + 2387

↓

72387

-------------------------------------------------
Returning Phase
-------------------------------------------------

reverse(7)

7

↓

reverse(78)

87

↓

reverse(783)

387

↓

reverse(7832)

2387

↓

reverse(78327)

72387

-------------------------------------------------
Recursion Tree
-------------------------------------------------

reverse(78327)
│
├──70000
└──reverse(7832)
      │
      ├──2000
      └──reverse(783)
            │
            ├──300
            └──reverse(78)
                  │
                  ├──80
                  └──reverse(7)
                        │
                        ├──7
                        └──reverse(0)

-------------------------------------------------
Pattern
-------------------------------------------------

Current Contribution

=

(lastDigit × PlaceValue)

+

Smaller Problem

-------------------------------------------------
Base Case
-------------------------------------------------

if (n == 0)
    return 0;

-------------------------------------------------
Approach 2
(Helper Recursion)
-------------------------------------------------

Maintain an answer.

Every recursive call

ans = ans * 10 + lastDigit

Example

78327

↓

7

↓

72

↓

723

↓

7238

↓

72387

-------------------------------------------------
Approach 3
(Iterative)
-------------------------------------------------

Same logic as helper recursion.

Use while loop.

-------------------------------------------------
Complexities
-------------------------------------------------

Current Contribution

Time  : O(d²)

Space : O(d)

Helper Recursion

Time  : O(d)

Space : O(d)

Iterative

Time  : O(d)

Space : O(1)

StringBuilder

Time  : O(d)

Space : O(d)

where

d = Number of Digits

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

✔ Reverse Integer (LeetCode 7)

✔ Reverse String

✔ Reverse Array

✔ Reverse Linked List

✔ Palindrome Number

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Place Value Concept

✔ Helper Recursion

✔ Tail Recursion

✔ Iterative Conversion

✔ One of the most important recursion problems.
*/