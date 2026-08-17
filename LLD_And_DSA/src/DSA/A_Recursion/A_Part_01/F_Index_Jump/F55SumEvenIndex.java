package DSA.A_Recursion.A_Part_01.F_Index_Jump;

public class F55SumEvenIndex {

    /*
     * =========================================
     * Problem : Sum Even Index
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * sumEvenIndex(arr, idx + k, k)
     * returns the sum of all
     * remaining even indices.
     *
     * Current Work:
     * Add the current even index.
     *
     * Formula
     *
     * return idx
     *      + sumEvenIndex(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static int sumEvenIndex(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return 0;
        }

        // Current Contribution + Recursive Faith
        int sum = idx + sumEvenIndex(arr, idx + k, k);

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70, 80};

        System.out.println("Sum of Even Indices : " + sumEvenIndex(arr, 0, 2));
    }
}

/*
=================================================
Problem : Sum Even Index
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Find the sum of all
even indices
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80}

Even Indices

0 2 4 6

Output

12

-------------------------------------------------

Faith

sumEvenIndex(arr, idx + k, k)

returns

The sum of all
remaining even indices.

-------------------------------------------------

Current Work

Add

Current Index

-------------------------------------------------

Formula

return idx

+

sumEvenIndex(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array Length = 8

↓

Index 0

↓

Index 2

↓

Index 4

↓

Index 6

↓

Index 8

↓

0

↑

6

↑

10

↑

12

↑

12

-------------------------------------------------

Recursion Tree

sum(0)
│
└──sum(2)
     │
     └──sum(4)
          │
          └──sum(6)
               │
               └──sum(8)

-------------------------------------------------

Returning Phase

sum(8)

↓

0

↑

sum(6)

↓

6

↑

sum(4)

↓

10

↑

sum(2)

↓

12

↑

sum(0)

↓

12

-------------------------------------------------

Algorithm

1. Stop when the index
   goes out of bounds.

2. Trust recursion to
   compute the remaining sum.

3. Add the current index.

4. Return the total.

-------------------------------------------------

Mental Model

Current Index

+

Remaining Even Indices

↓

Final Answer

-------------------------------------------------

Pattern Recognition

Questions containing

• Sum Even Indices

• Alternate Contribution

• Fixed Step Summation

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + 1
  instead of idx + k.

- Forgetting to add the
  current index.

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