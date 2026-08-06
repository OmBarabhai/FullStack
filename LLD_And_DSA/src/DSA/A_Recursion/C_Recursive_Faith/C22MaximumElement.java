package DSA.A_Recursion.C_Recursive_Faith;

public class C22MaximumElement {

    /*
     * =========================================
     * Problem : Maximum Element
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * maximumElement(arr, idx + 1)
     * returns the maximum element
     * from the remaining array.
     *
     * Current Work:
     * Compare the current element
     * with the recursive answer.
     *
     * Formula
     *
     * int maxFromRemaining =
     * maximumElement(arr, idx + 1);
     *
     * if(arr[idx] > maxFromRemaining)
     *     return arr[idx];
     *
     * return maxFromRemaining;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int maximumElement(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        // Recursive Faith
        int maxFromRemaining = maximumElement(arr, idx + 1);

        // Current Work
        if (arr[idx] > maxFromRemaining) {
            return arr[idx];
        }

        return maxFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 88, 32, 1, 2, 4};

        System.out.println("Maximum Element : " + maximumElement(arr, 0));
    }
}

/*
=================================================
Problem : Maximum Element
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the maximum element of an array
using recursion.

-------------------------------------------------

Example

Input

{1,2,88,32,1,2,4}

Output

88

-------------------------------------------------

Faith

maximumElement(arr, idx + 1)

returns

The maximum element
of the remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

the recursive answer.

-------------------------------------------------

Formula

int maxFromRemaining =
maximumElement(arr, idx + 1);

if(arr[idx] > maxFromRemaining)
    return arr[idx];

return maxFromRemaining;

-------------------------------------------------

Dry Run

Array

{1,2,88,32}

↓

maximumElement(0)

↓

maximumElement(1)

↓

maximumElement(2)

↓

maximumElement(3)

↓

return 32

↑

Compare

88 > 32

↓

return 88

↑

Compare

2 > 88

↓

return 88

↑

Compare

1 > 88

↓

return 88

-------------------------------------------------

Recursion Tree

maximumElement(0)
│
└──maximumElement(1)
     │
     └──maximumElement(2)
          │
          └──maximumElement(3)
               │
               └──return 32

-------------------------------------------------

Returning Phase

maximumElement(3)

↓

return 32

↑

maximumElement(2)

↓

Compare

88 > 32

↓

return 88

↑

maximumElement(1)

↓

Compare

2 > 88

↓

return 88

↑

maximumElement(0)

↓

Compare

1 > 88

↓

return 88

-------------------------------------------------

Algorithm

1. Reach the last element.

2. Trust recursion to return
   the maximum element of the
   remaining array.

3. Compare the current element
   with the recursive answer.

4. Return whichever is larger.

-------------------------------------------------

Mental Model

I do NOT find the maximum of the
remaining array.

I trust recursion has already done it.

I only compare

Current Element

with

Recursive Answer.

-------------------------------------------------

Common Mistakes

❌ Passing maximum as a parameter
   (Accumulator Pattern).

❌ Wrong base case.

❌ Forgetting to compare the
   current element.

❌ Returning the recursive answer
   without comparison.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Maximum Element

✓ Largest Element

✓ Greatest Value

↓

Think

Recursive Faith

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ Maximum Element

✓ Recursive Faith

✓ Divide & Conquer

✓ Tree Maximum

✓ Segment Tree

=================================================
*/