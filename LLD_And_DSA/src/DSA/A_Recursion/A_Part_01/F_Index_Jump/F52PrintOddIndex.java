package DSA.A_Recursion.A_Part_01.F_Index_Jump;

public class F52PrintOddIndex {

    /*
     * =========================================
     * Problem : Print Odd Index
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printOddIndex(arr, idx + k, k)
     * prints all remaining
     * odd indices.
     *
     * Current Work:
     * Print the current odd index.
     *
     * Formula
     *
     * print(idx)
     *
     * printOddIndex(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printOddIndex(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return;
        }

        // Current Work
        System.out.print(idx + " ");

        // Recursive Jump
        printOddIndex(arr, idx + k, k);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        System.out.print("Odd Indices : ");

        printOddIndex(arr, 1, 2);
    }
}

/*
=================================================
Problem : Print Odd Index
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print all odd indices
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Output

1 3 5 7

-------------------------------------------------

Faith

printOddIndex(arr, idx + k, k)

prints all remaining
odd indices.

-------------------------------------------------

Current Work

Print

Current Index

-------------------------------------------------

Formula

print(idx)

↓

printOddIndex(arr, idx + k, k)

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 1

Print 1

↓

Index 3

Print 3

↓

Index 5

Print 5

↓

Index 7

Print 7

↓

Index 9

Stop

-------------------------------------------------

Recursion Tree

print(1)
│
└──print(3)
     │
     └──print(5)
          │
          └──print(7)
               │
               └──print(9)

-------------------------------------------------

Algorithm

1. Start from index 1.

2. Print the current index.

3. Jump by k.

4. Repeat until
   index goes out of bounds.

-------------------------------------------------

Mental Model

Visit

1

↓

3

↓

5

↓

7

↓

Stop

Never visit

0

2

4

6

-------------------------------------------------

Pattern Recognition

Questions containing

• Print Odd Indices

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

- Starting from index 0.

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