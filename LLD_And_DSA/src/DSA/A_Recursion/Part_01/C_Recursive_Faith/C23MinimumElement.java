package DSA.A_Recursion.Part_01.C_Recursive_Faith;

public class C23MinimumElement {

    /*
     * =========================================
     * Problem : Minimum Element
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * minimumElement(arr, idx + 1)
     * returns the minimum element
     * from the remaining array.
     *
     * Current Work:
     * Compare the current element
     * with the recursive answer.
     *
     * Formula
     *
     * int minFromRemaining =
     * minimumElement(arr, idx + 1);
     *
     * if(arr[idx] < minFromRemaining)
     *     return arr[idx];
     *
     * return minFromRemaining;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int minimumElement(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        // Recursive Faith
        int minFromRemaining = minimumElement(arr, idx + 1);

        // Current Work
        if (arr[idx] < minFromRemaining) {
            return arr[idx];
        }

        return minFromRemaining;
    }

    public static void main(String[] args) {

        int[] chars = {'A', 'B', 'C', 'Z', 'F'};

        System.out.println("Minimum Character : " + (char) minimumElement(chars, 0));

        int[] nums = {12, 8, 21, 3, 18, 9};

        System.out.println("Minimum Number    : " + minimumElement(nums, 0));
    }
}

/*
=================================================
Problem : Minimum Element
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the minimum element of an array
using recursion.

-------------------------------------------------

Example

Input

{12,8,21,3,18,9}

Output

3

-------------------------------------------------

Faith

minimumElement(arr, idx + 1)

returns

The minimum element
of the remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

the recursive answer.

-------------------------------------------------

Formula

int minFromRemaining =
minimumElement(arr, idx + 1);

if(arr[idx] < minFromRemaining)
    return arr[idx];

return minFromRemaining;

-------------------------------------------------

Dry Run

Array

{12,8,21,3}

↓

minimumElement(0)

↓

minimumElement(1)

↓

minimumElement(2)

↓

minimumElement(3)

↓

return 3

↑

Compare

21 < 3

↓

return 3

↑

Compare

8 < 3

↓

return 3

↑

Compare

12 < 3

↓

return 3

-------------------------------------------------

Recursion Tree

minimumElement(0)
│
└──minimumElement(1)
     │
     └──minimumElement(2)
          │
          └──minimumElement(3)
               │
               └──return 3

-------------------------------------------------

Returning Phase

minimumElement(3)

↓

return 3

↑

minimumElement(2)

↓

Compare

21 < 3

↓

return 3

↑

minimumElement(1)

↓

Compare

8 < 3

↓

return 3

↑

minimumElement(0)

↓

Compare

12 < 3

↓

return 3

-------------------------------------------------

Algorithm

1. Reach the last element.

2. Trust recursion to return
   the minimum element of the
   remaining array.

3. Compare the current element
   with the recursive answer.

4. Return whichever is smaller.

-------------------------------------------------

Mental Model

I do NOT find the minimum of the
remaining array.

I trust recursion has already done it.

I only compare

Current Element

with

Recursive Answer.

-------------------------------------------------

Common Mistakes

❌ Passing minimum as a parameter
   (Accumulator Pattern).

❌ Wrong base case.

❌ Forgetting to compare the
   current element.

❌ Returning the recursive answer
   without comparison.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Minimum Element

✓ Smallest Element

✓ Smallest Value

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

✓ Minimum Element

✓ Recursive Faith

✓ Divide & Conquer

✓ Tree Minimum

✓ Segment Tree

=================================================
*/