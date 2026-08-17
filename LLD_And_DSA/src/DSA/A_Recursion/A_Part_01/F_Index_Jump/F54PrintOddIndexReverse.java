package DSA.A_Recursion.A_Part_01.F_Index_Jump;

public class F54PrintOddIndexReverse {

    /*
     * =========================================
     * Problem : Print Odd Index Reverse
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printOddIndexReverse(arr, idx - k, k)
     * prints all remaining
     * odd indices in reverse order.
     *
     * Current Work:
     * Print the current odd index.
     *
     * Formula
     *
     * print(idx)
     *
     * printOddIndexReverse(arr, idx - k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printOddIndexReverse(int[] arr, int idx, int k) {

        // Base Case
        if (idx <= 0) {
            return;
        }

        // Current Work
        System.out.print(idx + " ");

        // Recursive Jump
        printOddIndexReverse(arr, idx - k, k);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        int startIdx;

        if ((arr.length & 1) == 1) {
            startIdx = arr.length - 2;
        } else {
            startIdx = arr.length - 1;
        }

        System.out.print("Odd Indices Reverse : ");

        printOddIndexReverse(arr, startIdx, 2);
    }
}

/*
=================================================
Problem : Print Odd Index Reverse
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print all odd indices
in reverse order
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Output

7 5 3 1

-------------------------------------------------

Faith

printOddIndexReverse(arr, idx - k, k)

prints all remaining
odd indices
in reverse order.

-------------------------------------------------

Current Work

Print

Current Index

-------------------------------------------------

Formula

print(idx)

↓

printOddIndexReverse(arr, idx - k, k);

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 7

Print 7

↓

Index 5

Print 5

↓

Index 3

Print 3

↓

Index 1

Print 1

↓

Index -1

Stop

-------------------------------------------------

Recursion Tree

print(7)
│
└──print(5)
     │
     └──print(3)
          │
          └──print(1)
               │
               └──print(-1)

-------------------------------------------------

Algorithm

1. Find the last odd index.

2. Print the current index.

3. Jump backward by k.

4. Stop when no odd indices remain.

-------------------------------------------------

Mental Model

Visit

7

↓

5

↓

3

↓

1

↓

Stop

Never visit

6

4

2

0

-------------------------------------------------

Pattern Recognition

Questions containing

• Print Odd Indices Reverse

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

- Using idx < 0
  instead of idx <= 0
  for odd-index traversal.

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