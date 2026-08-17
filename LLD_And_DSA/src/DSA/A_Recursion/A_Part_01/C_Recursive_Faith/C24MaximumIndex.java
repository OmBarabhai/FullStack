package DSA.A_Recursion.A_Part_01.C_Recursive_Faith;

public class C24MaximumIndex {

    /*
     * =========================================
     * Problem : Maximum Index
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * maximumIndex(arr, idx + 1)
     * returns the index of the
     * maximum element in the
     * remaining array.
     *
     * Current Work:
     * Compare the current element
     * with the element present at
     * the recursive index.
     *
     * Formula
     *
     * int maxIndexFromRemaining =
     * maximumIndex(arr, idx + 1);
     *
     * if(arr[idx] > arr[maxIndexFromRemaining])
     *     return idx;
     *
     * return maxIndexFromRemaining;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int maximumIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length - 1) {
            return idx;
        }

        // Recursive Faith
        int maxIndexFromRemaining = maximumIndex(arr, idx + 1);

        // Current Work
        if (arr[idx] > arr[maxIndexFromRemaining]) {
            return idx;
        }

        return maxIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] nums = {12, 3, 2, 1, 2, 1};

        int[] chars = {'a', 'b', 'c', 'd', 'z', 'f', 'g'};

        System.out.println("Maximum Index (Numbers) : " + maximumIndex(nums, 0));

        System.out.println("Maximum Value (Numbers) : " + nums[maximumIndex(nums, 0)]);

        System.out.println("Maximum Index (Characters) : " + maximumIndex(chars, 0));

        System.out.println("Maximum Character : " + (char) chars[maximumIndex(chars, 0)]);
    }
}

/*
=================================================
Problem : Maximum Index
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the maximum
element using recursion.

-------------------------------------------------

Example

Input

{12,3,2,1,2,1}

Output

Index : 0

Value : 12

-------------------------------------------------

Faith

maximumIndex(arr, idx + 1)

returns

The index of the maximum element
in the remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

arr[maxIndexFromRemaining]

-------------------------------------------------

Formula

int maxIndexFromRemaining =
maximumIndex(arr, idx + 1);

if(arr[idx] > arr[maxIndexFromRemaining])
    return idx;

return maxIndexFromRemaining;

-------------------------------------------------

Dry Run

Array

{12,3,2,1}

↓

maximumIndex(0)

↓

maximumIndex(1)

↓

maximumIndex(2)

↓

maximumIndex(3)

↓

return index 3

↑

Compare

2 > 1

↓

return index 2

↑

Compare

3 > 2

↓

return index 1

↑

Compare

12 > 3

↓

return index 0

-------------------------------------------------

Recursion Tree

maximumIndex(0)
│
└──maximumIndex(1)
     │
     └──maximumIndex(2)
          │
          └──maximumIndex(3)
               │
               └──return index 3

-------------------------------------------------

Returning Phase

maximumIndex(3)

↓

return index 3

↑

maximumIndex(2)

↓

Compare

2 > 1

↓

return index 2

↑

maximumIndex(1)

↓

Compare

3 > 2

↓

return index 1

↑

maximumIndex(0)

↓

Compare

12 > 3

↓

return index 0

-------------------------------------------------

Algorithm

1. Reach the last element.

2. Trust recursion to return
   the index of the maximum
   element in the remaining array.

3. Compare the current element
   with the element at the
   recursive index.

4. Return the better index.

-------------------------------------------------

Mental Model

I do NOT search for the maximum
index of the remaining array.

I trust recursion has already
found it.

I only compare

Current Element

with

Recursive Answer.

-------------------------------------------------

Common Mistakes

❌ Returning the value instead
   of the index.

❌ Comparing indices instead of
   array values.

❌ Wrong base case.

❌ Forgetting to compare the
   current element.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Maximum Index

✓ Largest Index

✓ Index of Maximum

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

✓ Maximum Index

✓ Largest Index

✓ Recursive Faith

✓ Divide & Conquer

✓ Tree Recursion

=================================================
*/