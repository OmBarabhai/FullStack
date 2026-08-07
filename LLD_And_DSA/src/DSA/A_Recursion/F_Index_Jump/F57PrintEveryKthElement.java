package DSA.A_Recursion.F_Index_Jump;

public class F57PrintEveryKthElement {

    /*
     * =========================================
     * Problem : Print Every Kth Element
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * printEveryKthElement(arr, idx + k, k)
     * prints all remaining
     * every kth elements
     * starting from
     * the current index.
     *
     * Current Work:
     * Print the current
     * kth element.
     *
     * Formula
     *
     * print(arr[idx]);
     *
     * printEveryKthElement(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static void printEveryKthElement(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return;
        }

        // Current Work
        System.out.print(arr[idx] + " ");

        // Recursive Jump
        printEveryKthElement(arr, idx + k, k);
    }

    public static void main(String[] args) {

        int[] arr = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100
        };

        int k = 3;

        System.out.print("Every " + k + "th Element : ");

        // Start from the kth element (1-based counting)
        printEveryKthElement(arr, k - 1, k);
    }
}

/*
=================================================
Problem : Print Every Kth Element
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Print every kth element
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80,90,100}

k = 3

Output

30 60 90

-------------------------------------------------

Faith

printEveryKthElement(arr, idx + k, k)

prints all remaining
every kth elements
starting from
the current index.

-------------------------------------------------

Current Work

Print

Current Element

-------------------------------------------------

Formula

print(arr[idx])

↓

printEveryKthElement(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array

10 20 30 40 50 60 70 80 90 100

↓

Index 2

Print 30

↓

Index 5

Print 60

↓

Index 8

Print 90

↓

Index 11

Stop

-------------------------------------------------

Recursion Tree

print(2)
│
└──print(5)
     │
     └──print(8)
          │
          └──print(11)

-------------------------------------------------

Algorithm

1. Start from index (k - 1).

2. Print the current element.

3. Jump by k.

4. Stop when the index
   goes out of bounds.

-------------------------------------------------

Mental Model

Visit

k - 1

↓

k - 1 + k

↓

k - 1 + 2k

↓

k - 1 + 3k

↓

Stop

-------------------------------------------------

Pattern Recognition

Questions containing

• Every Kth Element

• Fixed Step Traversal

• Skip K Elements

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Starting from index
  (k - 1).

- Using idx + 1
  instead of idx + k.

- Wrong base case.

-------------------------------------------------

Time Complexity

O(n / k)

-------------------------------------------------

Space Complexity

O(n / k)

(Call Stack)

-------------------------------------------------

Interview Uses

• Fixed Step Traversal

• Skip Pattern Processing

• Index Jump Recursion

=================================================
*/