package DSA.A_Recursion.A_Part_01.B_Current_Contribution;

public class B11SumOfN {

    public static int sumOfN(int n) {

        // Base Case
        if (n == 0) {
            return 0;
        }

        // Current Contribution + Smaller Problem
        return n + sumOfN(n - 1);
    }

    public static void main(String[] args) {

        int n = 10;

        System.out.println("Sum of First " + n + " Natural Numbers = " + sumOfN(n));
    }
}

/*
=========================================
Problem 11 : Sum of N
Pattern : Current Contribution
Folder : B_Current_Contribution
=========================================

Question
--------
Find the sum of the first N natural numbers using recursion.

Example
-------
Input:
n = 5

Output:
15

Explanation:
1 + 2 + 3 + 4 + 5 = 15

-----------------------------------------
Approach
-----------------------------------------

Current Contribution
+
Smaller Problem

Current Contribution:
n

Smaller Problem:
sumOfN(n - 1)

Formula

sum(5)
=
5 + sum(4)

-----------------------------------------
Dry Run
-----------------------------------------

sumOfN(4)

Current Contribution = 4

Smaller Problem = sumOfN(3)

↓

sumOfN(3)

Current Contribution = 3

Smaller Problem = sumOfN(2)

↓

sumOfN(2)

Current Contribution = 2

Smaller Problem = sumOfN(1)

↓

sumOfN(1)

Current Contribution = 1

Smaller Problem = sumOfN(0)

↓

sumOfN(0)

Base Case

return 0

-----------------------------------------
Returning Phase
-----------------------------------------

sumOfN(1)

1 + 0 = 1

↓

sumOfN(2)

2 + 1 = 3

↓

sumOfN(3)

3 + 3 = 6

↓

sumOfN(4)

4 + 6 = 10

-----------------------------------------
Recursion Tree
-----------------------------------------

sum(4)
│
├── 4
└── sum(3)
      │
      ├── 3
      └── sum(2)
            │
            ├── 2
            └── sum(1)
                  │
                  ├── 1
                  └── sum(0)
                        │
                        └── 0

-----------------------------------------
Pattern
-----------------------------------------

Answer
=
Current Contribution
+
Smaller Problem

return n + sumOfN(n - 1);

-----------------------------------------
Base Case
-----------------------------------------

if (n == 0)
    return 0;

-----------------------------------------
Time Complexity
-----------------------------------------

O(n)

-----------------------------------------
Space Complexity
-----------------------------------------

O(n)

-----------------------------------------
Interview Learning
-----------------------------------------

✔ Learn how to combine the current value with the recursive answer.
✔ Foundation for Factorial, Product, Sum of Digits, Sum of Array, etc.
✔ This is the core pattern of "Current Contribution".
*/