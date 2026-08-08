package DSA.A_Recursion.Part_01.D_Searching;

public class D39LastPositiveIndex {

    /*
     * =========================================
     * Problem : Last Positive Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * lastPositiveIndex(arr, idx - 1)
     * returns the last index
     * containing a positive number
     * in the remaining left part
     * of the array.
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
     * return lastPositiveIndex(arr, idx - 1);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int lastPositiveIndex(int[] arr, int idx) {

        // Base Case
        if (idx < 0) {
            return -1;
        }

        // Current Check
        if (arr[idx] > 0) {
            return idx;
        }

        // Recursive Search
        return lastPositiveIndex(arr, idx - 1);
    }

    public static void main(String[] args) {

        int[] arr = {-1, -2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        int index = lastPositiveIndex(arr, arr.length - 1);

        System.out.println("Last Positive Index : " + index);

        if (index != -1) {
            System.out.println("Last Positive Value : " + arr[index]);
        } else {
            System.out.println("No Positive Number Found");
        }
    }
}

/*
=================================================
Problem : Last Positive Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the index of the last
positive number using recursion.

-------------------------------------------------

Example

Input

{-1,-2,3,4,99,3,21,-777,100,3,100}

Output

10

-------------------------------------------------

Faith

lastPositiveIndex(arr, idx - 1)

returns

The last index containing
a positive number in the
remaining left part of the array.

-------------------------------------------------

Current Work

Check

arr[idx] > 0

-------------------------------------------------

Formula

if(arr[idx] > 0)
    return idx;

return lastPositiveIndex(arr, idx - 1);

-------------------------------------------------

Dry Run

Array

{-1,-2,3,4,99,3,21,-777,100,3,100}

↓

Index 10

↓

100 > 0

↓

Yes

↓

return 10

-------------------------------------------------

Recursion Tree

lastPositiveIndex(10)
│
└──return 10

-------------------------------------------------

Returning Phase

Index 10

↓

return 10

-------------------------------------------------

Algorithm

1. Start from the last index.

2. Check whether the current
   number is positive.

3. If positive, return the index.

4. Otherwise search the
   remaining left part.

-------------------------------------------------

Mental Model

Search from right to left.

The first positive number
found while moving backwards
is the

Last Positive Index.

-------------------------------------------------

Common Mistakes

❌ Returning the value instead
of the index.

❌ Wrong base case.

❌ Using idx+1 instead of idx-1.

❌ Forgetting to search backwards.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Last Positive

✓ Positive Index

✓ Reverse Search

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

✓ Last Positive Index

✓ Recursive Search

✓ Reverse Linear Search

✓ Array Traversal

=================================================
*/