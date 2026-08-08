package DSA.A_Recursion.Part_01.F_Index_Jump;

public class F60SumAlternateElements {

    /*
     * =========================================
     * Problem : Sum Alternate Elements
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * sumAlternateElements(arr, idx + k, k)
     * returns the sum of all
     * remaining alternate elements.
     *
     * Current Work:
     * Add the current element.
     *
     * Formula
     *
     * return arr[idx]
     *      + sumAlternateElements(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static int sumAlternateElements(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return 0;
        }

        // Current Contribution + Recursive Faith
        int sum = arr[idx] + sumAlternateElements(arr, idx + k, k);

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100
        };

        int k = 2;

        System.out.println("Sum of Alternate Elements : "
                + sumAlternateElements(arr, 0, k));
    }
}

/*
=================================================
Problem : Sum Alternate Elements
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Find the sum of
alternate elements
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80,90,100}

Output

250

(10 + 30 + 50 + 70 + 90)

-------------------------------------------------

Faith

sumAlternateElements(arr, idx + k, k)

returns

The sum of all
remaining alternate elements.

-------------------------------------------------

Current Work

Add

Current Element

-------------------------------------------------

Formula

return arr[idx]

+

sumAlternateElements(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array

10 20 30 40 50 60 70 80 90 100

↓

Index 0

10

↓

Index 2

30

↓

Index 4

50

↓

Index 6

70

↓

Index 8

90

↓

Index 10

0

↑

90

↑

160

↑

210

↑

240

↑

250

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
                    │
                    └──sum(10)

-------------------------------------------------

Returning Phase

sum(10)

↓

0

↑

sum(8)

↓

90

↑

sum(6)

↓

160

↑

sum(4)

↓

210

↑

sum(2)

↓

240

↑

sum(0)

↓

250

-------------------------------------------------

Algorithm

1. Stop when the index
   goes out of bounds.

2. Trust recursion to
   compute the remaining sum.

3. Add the current element.

4. Return the total sum.

-------------------------------------------------

Mental Model

Current Element

+

Remaining Alternate Elements

↓

Final Sum

-------------------------------------------------

Pattern Recognition

Questions containing

• Sum Alternate Elements

• Skip One Element

• Alternate Contribution

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Using idx + 1
  instead of idx + 2.

- Forgetting to add
  the current element.

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