package DSA.A_Recursion.D_Searching;

public class D36FirstOddIndex {

    /*
     * =========================================
     * Problem : First Odd Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * firstOddIndex(arr, idx + 2, target)
     * returns the first odd index
     * containing the target in the
     * remaining array.
     *
     * Current Work:
     * Check whether the current
     * odd index contains the target.
     *
     * Formula
     *
     * if(arr[idx] == target)
     *     return idx;
     *
     * return firstOddIndex(arr, idx + 2, target);
     *
     * Time  : O(n/2)
     * Space : O(n/2)
     * =========================================
     */

    public static int firstOddIndex(int[] arr, int idx, int target) {

        // Base Case
        if (idx >= arr.length) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return firstOddIndex(arr, idx + 2, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        System.out.println("First Odd Index of 3   : " + firstOddIndex(arr, 1, 3));

        System.out.println("First Odd Index of 100 : " + firstOddIndex(arr, 1, 100));

        System.out.println("First Odd Index of 500 : " + firstOddIndex(arr, 1, 500));
    }
}

/*
=================================================
Problem : First Odd Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the first odd index
containing the target element
using recursion.

-------------------------------------------------

Example

Input

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

3

Output

5

-------------------------------------------------

Faith

firstOddIndex(arr, idx + 2, target)

returns

The first odd index containing
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

return firstOddIndex(arr, idx + 2, target);

-------------------------------------------------

Dry Run

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

3

↓

Index 1

↓

2 != 3

↓

Index 3

↓

4 != 3

↓

Index 5

↓

3 == 3

↓

return 5

-------------------------------------------------

Recursion Tree

firstOddIndex(1)
│
└──firstOddIndex(3)
     │
     └──firstOddIndex(5)
          │
          └──return 5

-------------------------------------------------

Returning Phase

Index 5

↓

return 5

↑

Index 3

↓

return 5

↑

Index 1

↓

return 5

-------------------------------------------------

Algorithm

1. Start from the first odd index.

2. Compare the current odd index
   with the target.

3. If found, return the index.

4. Otherwise move to the next
   odd index.

-------------------------------------------------

Mental Model

Search only odd indices.

Ignore every even index.

The first match found while
moving forward is the

First Odd Index.

-------------------------------------------------

Common Mistakes

❌ Starting from index 0.

❌ Using idx+1 instead of idx+2.

❌ Returning the value instead
of the index.

❌ Wrong base case.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ First Odd Index

✓ Search

✓ Odd Positions

✓ Jump By 2

↓

Think

Recursive Searching

+

Index Jump

-------------------------------------------------

Time Complexity

O(n/2)

-------------------------------------------------

Space Complexity

O(n/2)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ First Odd Index

✓ Recursive Searching

✓ Jump Recursion

✓ Array Traversal

=================================================
*/