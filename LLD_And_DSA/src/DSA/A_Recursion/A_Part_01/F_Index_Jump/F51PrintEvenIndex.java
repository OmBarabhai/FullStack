package DSA.A_Recursion.A_Part_01.F_Index_Jump;

public class F51PrintEvenIndex {

    /*
     * =========================================
     * Problem : Print Even Index
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printEvenIndex(arr, idx + k, k)
     * prints all remaining even indices.
     *
     * Current Work:
     * Print the current index.
     *
     * Formula
     *
     * print(idx)
     *
     * printEvenIndex(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printEvenIndex(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return;
        }

        // Current Work
        System.out.print(idx + " ");

        // Recursive Jump
        printEvenIndex(arr, idx + k, k);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        System.out.print("Even Indices : ");

        printEvenIndex(arr, 0, 2);
    }
}

/*
=================================================
Problem : Print Even Index
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print all even indices
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Output

0 2 4 6

-------------------------------------------------

Faith

printEvenIndex(arr, idx + k, k)

prints all remaining
even indices.

-------------------------------------------------

Current Work

Print

Current Index

-------------------------------------------------

Formula

print(idx)

↓

printEvenIndex(arr, idx + k, k)

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 0

Print 0

↓

Index 2

Print 2

↓

Index 4

Print 4

↓

Index 6

Print 6

↓

Index 8

Stop

-------------------------------------------------

Recursion Tree

print(0)
│
└──print(2)
     │
     └──print(4)
          │
          └──print(6)
               │
               └──print(8)

-------------------------------------------------

Algorithm

1. Start from index 0.

2. Print the current index.

3. Jump by k.

4. Repeat until
   index goes out of bounds.

-------------------------------------------------

Mental Model

Visit

0

↓

2

↓

4

↓

6

↓

Stop

Never visit

1

3

5

7

-------------------------------------------------

Pattern Recognition

Questions containing

• Print Even Indices

• Alternate Traversal

• Fixed Step Traversal

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + 1
  instead of idx + k.

- Wrong base case.

- Starting from index 1.

-------------------------------------------------

Time Complexity

O(n / k)

-------------------------------------------------

Space Complexity

O(n / k)

(Call Stack)

-------------------------------------------------

Interview Uses

• Alternate Traversal

• Fixed Step Processing

• Index Jump Recursion

=================================================
*/