package DSA.A_Recursion.Part_01.F_Index_Jump;

public class F53PrintEvenIndexReverse {

    /*
     * =========================================
     * Problem : Print Even Index Reverse
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printEvenIndexReverse(arr, idx - k, k)
     * prints all remaining
     * even indices in reverse order.
     *
     * Current Work:
     * Print the current even index.
     *
     * Formula
     *
     * print(idx)
     *
     * printEvenIndexReverse(arr, idx - k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printEvenIndexReverse(int[] arr, int idx, int k) {

        // Base Case
        if (idx < 0) {
            return;
        }

        // Current Work
        System.out.print(idx + " ");

        // Recursive Jump
        printEvenIndexReverse(arr, idx - k, k);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        int startIdx;

        if ((arr.length & 1) == 0) {
            startIdx = arr.length - 2;
        } else {
            startIdx = arr.length - 1;
        }

        System.out.print("Even Indices Reverse : ");

        printEvenIndexReverse(arr, startIdx, 2);
    }
}

/*
=================================================
Problem : Print Even Index Reverse
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print all even indices
in reverse order
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Output

6 4 2 0

-------------------------------------------------

Faith

printEvenIndexReverse(arr, idx - k, k)

prints all remaining
even indices
in reverse order.

-------------------------------------------------

Current Work

Print

Current Index

-------------------------------------------------

Formula

print(idx)

↓

printEvenIndexReverse(arr, idx - k, k);

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 6

Print 6

↓

Index 4

Print 4

↓

Index 2

Print 2

↓

Index 0

Print 0

↓

Index -2

Stop

-------------------------------------------------

Recursion Tree

print(6)
│
└──print(4)
     │
     └──print(2)
          │
          └──print(0)
               │
               └──print(-2)

-------------------------------------------------

Algorithm

1. Find the last even index.

2. Print the current index.

3. Jump backward by k.

4. Stop when the index
   becomes negative.

-------------------------------------------------

Mental Model

Visit

6

↓

4

↓

2

↓

0

↓

Stop

Never visit

7

5

3

1

-------------------------------------------------

Pattern Recognition

Questions containing

• Print Even Indices Reverse

• Reverse Alternate Traversal

• Fixed Step Reverse Traversal

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + k
  instead of idx - k.

- Wrong base case.

- Wrong starting index.

- Using print after
  the recursive call.

-------------------------------------------------

Time Complexity

O(n / k)

-------------------------------------------------

Space Complexity

O(n / k)

(Call Stack)

-------------------------------------------------

Interview Uses

• Reverse Alternate Traversal

• Fixed Step Processing

• Index Jump Recursion

=================================================
*/