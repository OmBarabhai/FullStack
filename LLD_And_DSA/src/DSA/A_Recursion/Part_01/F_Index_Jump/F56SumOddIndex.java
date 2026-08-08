package DSA.A_Recursion.Part_01.F_Index_Jump;

public class F56SumOddIndex {

    /*
     * =========================================
     * Problem : Sum Odd Index
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * sumOddIndex(arr, idx + k, k)
     * returns the sum of all
     * remaining odd indices.
     *
     * Current Work:
     * Add the current odd index.
     *
     * Formula
     *
     * return idx
     *      + sumOddIndex(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static int sumOddIndex(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return 0;
        }

        // Current Contribution + Recursive Faith
        int sum = idx + sumOddIndex(arr, idx + k, k);

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        System.out.println("Sum of Odd Indices : "
                + sumOddIndex(arr, 1, 2));
    }
}

/*
=================================================
Problem : Sum Odd Index
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Find the sum of all
odd indices
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Odd Indices

1 3 5 7

Output

16

-------------------------------------------------

Faith

sumOddIndex(arr, idx + k, k)

returns

The sum of all
remaining odd indices.

-------------------------------------------------

Current Work

Add

Current Index

-------------------------------------------------

Formula

return idx

+

sumOddIndex(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 1

↓

Index 3

↓

Index 5

↓

Index 7

↓

Index 9

↓

0

↑

7

↑

12

↑

15

↑

16

-------------------------------------------------

Recursion Tree

sum(1)
│
└──sum(3)
     │
     └──sum(5)
          │
          └──sum(7)
               │
               └──sum(9)

-------------------------------------------------

Returning Phase

sum(9)

↓

0

↑

sum(7)

↓

7

↑

sum(5)

↓

12

↑

sum(3)

↓

15

↑

sum(1)

↓

16

-------------------------------------------------

Algorithm

1. Stop when the index
   goes out of bounds.

2. Trust recursion to
   compute the remaining sum.

3. Add the current odd index.

4. Return the total.

-------------------------------------------------

Mental Model

Current Index

+

Remaining Odd Indices

↓

Final Answer

-------------------------------------------------

Pattern Recognition

Questions containing

• Sum Odd Indices

• Alternate Contribution

• Fixed Step Summation

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + 1
  instead of idx + k.

- Forgetting to return
  the computed sum.

- Wrong base case.

- Returning only the
  recursive answer.

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