package DSA.A_Recursion.A_Part_01.D_Searching;

public class D40FirstNegativeIndex {

    /*
     * =========================================
     * Problem : First Negative Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * firstNegativeIndex(arr, idx + 1)
     * returns the first index
     * containing a negative number
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current
     * element is negative.
     *
     * Formula
     *
     * if(arr[idx] < 0)
     *     return idx;
     *
     * return firstNegativeIndex(arr, idx + 1);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int firstNegativeIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Current Check
        if (arr[idx] < 0) {
            return idx;
        }

        // Recursive Search
        return firstNegativeIndex(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {-1, -2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        int index = firstNegativeIndex(arr, 0);

        System.out.println("First Negative Index : " + index);

        if (index != -1) {
            System.out.println("First Negative Value : " + arr[index]);
        } else {
            System.out.println("No Negative Number Found");
        }
    }
}

/*
=================================================
Problem : First Negative Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the index of the first
negative number using recursion.

-------------------------------------------------

Example

Input

{-1,-2,3,4,99,3,21,-777,100,3,100}

Output

0

-------------------------------------------------

Faith

firstNegativeIndex(arr, idx + 1)

returns

The first index containing
a negative number in the
remaining array.

-------------------------------------------------

Current Work

Check

arr[idx] < 0

-------------------------------------------------

Formula

if(arr[idx] < 0)
    return idx;

return firstNegativeIndex(arr, idx + 1);

-------------------------------------------------

Dry Run

Array

{-1,-2,3,4}

↓

Index 0

↓

-1 < 0

↓

Yes

↓

return 0

-------------------------------------------------

Recursion Tree

firstNegativeIndex(0)
│
└──return 0

-------------------------------------------------

Returning Phase

Index 0

↓

return 0

-------------------------------------------------

Algorithm

1. Start from index 0.

2. Check whether the current
   number is negative.

3. If negative, return the index.

4. Otherwise search the
   remaining array.

-------------------------------------------------

Mental Model

Search from left to right.

The first negative number
encountered is the

First Negative Index.

-------------------------------------------------

Common Mistakes

❌ Returning the value instead
of the index.

❌ Wrong base case.

❌ Using <= 0 instead of < 0.

❌ Forgetting to return the
recursive call.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ First Negative

✓ Negative Index

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

✓ First Negative Index

✓ Recursive Search

✓ Linear Search

✓ Array Traversal

=================================================
*/