package DSA.A_Recursion.Part_01.D_Searching;

public class D34FirstEvenIndex {

    /*
     * =========================================
     * Problem : First Even Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * firstEvenIndex(arr, idx + 2, target)
     * returns the first even index
     * containing the target in the
     * remaining array.
     *
     * Current Work:
     * Check whether the current
     * even index contains the target.
     *
     * Formula
     *
     * if(arr[idx] == target)
     *     return idx;
     *
     * return firstEvenIndex(arr, idx + 2, target);
     *
     * Time  : O(n/2)
     * Space : O(n/2)
     * =========================================
     */

    public static int firstEvenIndex(int[] arr, int idx, int target) {

        // Base Case
        if (idx >= arr.length) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return firstEvenIndex(arr, idx + 2, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        System.out.println("First Even Index of 3   : " + firstEvenIndex(arr, 0, 3));

        System.out.println("First Even Index of 100 : " + firstEvenIndex(arr, 0, 100));

        System.out.println("First Even Index of 500 : " + firstEvenIndex(arr, 0, 500));
    }
}

/*
=================================================
Problem : First Even Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the first even index
containing the target element
using recursion.

-------------------------------------------------

Example

Input

Array

{1,2,3,4,99,3,21,-777,100}

Target

100

Output

8

-------------------------------------------------

Faith

firstEvenIndex(arr, idx + 2, target)

returns

The first even index containing
the target in the remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

target

-------------------------------------------------

Formula

if(arr[idx] == target)
    return idx;

return firstEvenIndex(arr, idx + 2, target);

-------------------------------------------------

Dry Run

Array

{1,2,3,4,99,3,21,-777,100}

Target

100

↓

Index 0

↓

Not Found

↓

Index 2

↓

Not Found

↓

Index 4

↓

Not Found

↓

Index 6

↓

Not Found

↓

Index 8

↓

Found

↓

return 8

-------------------------------------------------

Algorithm

1. Start from index 0.

2. Check the current even index.

3. If found, return the index.

4. Otherwise, jump by 2.

-------------------------------------------------

Mental Model

Search only even indices.

Skip every odd index.

-------------------------------------------------

Time Complexity

O(n/2)

-------------------------------------------------

Space Complexity

O(n/2)

(Call Stack)

=================================================
*/