package DSA.A_Recursion.Part_01.F_Index_Jump;

public class F58SumEveryKthElement {

    /*
     * =========================================
     * Problem : Sum Every Kth Element
     * Pattern : Index Jump
     * Folder  : F_Index_Jump
     *
     * Faith:
     * sumEveryKthElement(arr, idx + k, k)
     * returns the sum of all
     * remaining kth elements
     * starting from
     * the current index.
     *
     * Current Work:
     * Add the current
     * kth element.
     *
     * Formula
     *
     * return arr[idx]
     *      + sumEveryKthElement(arr, idx + k, k);
     *
     * Time  : O(n / k)
     * Space : O(n / k)
     * =========================================
     */

    public static int sumEveryKthElement(int[] arr, int idx, int k) {

        // Base Case
        if (idx >= arr.length) {
            return 0;
        }

        // Current Contribution + Recursive Faith
        int sum = arr[idx] + sumEveryKthElement(arr, idx + k, k);

        return sum;
    }

    public static void main(String[] args) {

        int[] arr = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100
        };

        int k = 3;

        System.out.println("Sum of Every " + k + "th Element : "
                + sumEveryKthElement(arr, k - 1, k));
    }
}

/*
=================================================
Problem : Sum Every Kth Element
Pattern : Index Jump
Folder  : F_Index_Jump
=================================================

Question

Find the sum of every
kth element
using recursion.

-------------------------------------------------

Example

Input

{10,20,30,40,50,60,70,80,90,100}

k = 3

Elements

30 60 90

Output

180

-------------------------------------------------

Faith

sumEveryKthElement(arr, idx + k, k)

returns

The sum of all remaining
every kth elements
starting from
the current index.

-------------------------------------------------

Current Work

Add

Current Element

-------------------------------------------------

Formula

return arr[idx]

+

sumEveryKthElement(arr, idx + k, k);

-------------------------------------------------

Dry Run

Array

10 20 30 40 50 60 70 80 90 100

↓

Index 2

30

↓

Index 5

60

↓

Index 8

90

↓

Index 11

0

↑

90

↑

150

↑

180

-------------------------------------------------

Recursion Tree

sum(2)
│
└──sum(5)
     │
     └──sum(8)
          │
          └──sum(11)

-------------------------------------------------

Returning Phase

sum(11)

↓

0

↑

sum(8)

↓

90

↑

sum(5)

↓

150

↑

sum(2)

↓

180

-------------------------------------------------

Algorithm

1. Start from index (k - 1).

2. Trust recursion to
   calculate the remaining sum.

3. Add the current element.

4. Return the total sum.

-------------------------------------------------

Mental Model

Current Element

+

Remaining Kth Elements

↓

Final Sum

-------------------------------------------------

Pattern Recognition

Questions containing

• Sum Every Kth Element

• Fixed Step Summation

• Skip K Elements

↓

Think

Index Jump

-------------------------------------------------

Common Mistakes

- Starting from index 0
  instead of (k - 1).

- Using idx + 1
  instead of idx + k.

- Forgetting to add
  the current element.

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

• Fixed Step Summation

• Skip Pattern Processing

• Index Jump Recursion

=================================================
*/