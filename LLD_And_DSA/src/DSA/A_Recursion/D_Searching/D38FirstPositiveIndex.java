package DSA.A_Recursion.D_Searching;

public class D38FirstPositiveIndex {

    /*
     * =========================================
     * Problem : First Positive Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * firstPositiveIndex(arr, idx + 1)
     * returns the first index
     * containing a positive number
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current
     * element is positive.
     *
     * Formula
     *
     * if(arr[idx] > 0)
     *     return idx;
     *
     * return firstPositiveIndex(arr, idx + 1);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int firstPositiveIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Current Check
        if (arr[idx] > 0) {
            return idx;
        }

        // Recursive Search
        return firstPositiveIndex(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {-1, -2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        int index = firstPositiveIndex(arr, 0);

        System.out.println("First Positive Index : " + index);

        if (index != -1) {
            System.out.println("First Positive Value : " + arr[index]);
        } else {
            System.out.println("No Positive Number Found");
        }
    }
}

/*
=================================================
Problem : First Positive Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the index of the first
positive number using recursion.

-------------------------------------------------

Example

Input

{-1,-2,3,4,99,3,21,-777,100,3,100}

Output

2

-------------------------------------------------

Faith

firstPositiveIndex(arr, idx + 1)

returns

The first index containing
a positive number in the
remaining array.

-------------------------------------------------

Current Work

Check

arr[idx] > 0

-------------------------------------------------

Formula

if(arr[idx] > 0)
    return idx;

return firstPositiveIndex(arr, idx + 1);

-------------------------------------------------

Dry Run

Array

{-1,-2,3,4}

↓

Index 0

↓

-1 > 0

↓

No

↓

Index 1

↓

-2 > 0

↓

No

↓

Index 2

↓

3 > 0

↓

Yes

↓

return 2

-------------------------------------------------

Recursion Tree

firstPositiveIndex(0)
│
└──firstPositiveIndex(1)
     │
     └──firstPositiveIndex(2)
          │
          └──return 2

-------------------------------------------------

Returning Phase

Index 2

↓

return 2

↑

Index 1

↓

return 2

↑

Index 0

↓

return 2

-------------------------------------------------

Algorithm

1. Start from index 0.

2. Check whether the current
   number is positive.

3. If positive, return the index.

4. Otherwise search the
   remaining array.

-------------------------------------------------

Mental Model

Check one element.

If it is positive,

return its index.

Otherwise,

trust recursion.

-------------------------------------------------

Common Mistakes

❌ Returning the value instead
of the index.

❌ Wrong base case.

❌ Using >= 0 instead of > 0.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ First Positive

✓ Positive Index

✓ Search

↓

Think

Recursive Searching

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ First Positive Index

✓ Recursive Search

✓ Linear Search

✓ Array Traversal

=================================================
*/