package DSA.A_Recursion.F_Index_Jump;

public class F59PrintAlternateElements {

    /*
     * =========================================
     * Problem : Print Alternate Elements
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printAlternateElements(arr, idx + k, k)
     * prints all remaining
     * alternate elements.
     *
     * Current Work:
     * Print the current element.
     *
     * Formula
     *
     * print(arr[idx]);
     *
     * printAlternateElements(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printAlternateElements(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return;
        }

        // Current Work
        System.out.print(arr[idx] + " ");

        // Recursive Jump
        printAlternateElements(arr, idx + k, k);
    }

    public static void main(String[] args) {

        int[] arr = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100
        };

        int k = 2;

        System.out.print("Alternate Elements : ");

        printAlternateElements(arr, 0, k);
    }
}

/*
=================================================
Problem : Print Alternate Elements
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print alternate elements
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80,90,100}

Output

10 30 50 70 90

-------------------------------------------------

Faith

printAlternateElements(arr, idx + k, k)

prints all remaining
alternate elements.

-------------------------------------------------

Current Work

Print

Current Element

-------------------------------------------------

Formula

print(arr[idx])

↓

printAlternateElements(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array

10 20 30 40 50 60 70 80 90 100

↓

Index 0

Print 10

↓

Index 2

Print 30

↓

Index 4

Print 50

↓

Index 6

Print 70

↓

Index 8

Print 90

↓

Index 10

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
                    │
                    └──print(10)

-------------------------------------------------

Algorithm

1. Start from index 0.

2. Print the current element.

3. Jump by 2.

4. Repeat until
   the index goes
   out of bounds.

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

8

↓

Stop

-------------------------------------------------

Pattern Recognition

Questions containing

• Print Alternate Elements

• Skip One Element

• Alternate Traversal

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + 1
  instead of idx + 2.

- Wrong base case.

- Forgetting to print
  the current element.

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