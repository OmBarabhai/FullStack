package DSA.A_Recursion.Part_01.D_Searching;

public class D32FirstOccurrence {

    /*
     * =========================================
     * Problem : First Occurrence
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * firstOccurrence(arr, idx + 1, target)
     * returns the index of the first
     * occurrence of the target in the
     * remaining array.
     *
     * Current Work:
     * Check whether the current
     * element is equal to the target.
     *
     * Formula
     *
     * if(arr[idx] == target)
     *     return idx;
     *
     * return firstOccurrence(arr, idx + 1, target);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int firstOccurrence(int[] arr, int idx, int target) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return firstOccurrence(arr, idx + 1, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        System.out.println("First Occurrence of 3   : " + firstOccurrence(arr, 0, 3));

        System.out.println("First Occurrence of 100 : " + firstOccurrence(arr, 0, 100));

        System.out.println("First Occurrence of 500 : " + firstOccurrence(arr, 0, 500));
    }
}

/*
=================================================
Problem : First Occurrence
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the index of the first
occurrence of a target element
using recursion.

-------------------------------------------------

Example

Input

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

3

Output

2

-------------------------------------------------

Faith

firstOccurrence(arr, idx + 1, target)

returns

The index of the first occurrence
of the target in the remaining array.

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

return firstOccurrence(arr, idx + 1, target);

-------------------------------------------------

Dry Run

Array

{1,2,3,4}

Target

3

↓

firstOccurrence(0)

↓

Check

1 == 3

↓

No

↓

firstOccurrence(1)

↓

Check

2 == 3

↓

No

↓

firstOccurrence(2)

↓

Check

3 == 3

↓

Yes

↓

return 2

-------------------------------------------------

Recursion Tree

firstOccurrence(0)
│
└──firstOccurrence(1)
     │
     └──firstOccurrence(2)
          │
          └──return 2

-------------------------------------------------

Returning Phase

firstOccurrence(2)

↓

return 2

↑

firstOccurrence(1)

↓

return 2

↑

firstOccurrence(0)

↓

return 2

-------------------------------------------------

Algorithm

1. Check the base case.

2. Compare the current element
   with the target.

3. If found, return the current index.

4. Otherwise, trust recursion
   to search the remaining array.

-------------------------------------------------

Mental Model

I do NOT search the entire array.

I check only the current element.

If it is the target,

I immediately return its index.

Otherwise,

I trust recursion to search
the remaining array.

-------------------------------------------------

Common Mistakes

❌ Returning the value instead
   of the index.

❌ Wrong base case.

❌ Forgetting to return
   the recursive call.

❌ Continuing recursion after
   finding the first occurrence.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ First Occurrence

✓ First Index

✓ Search

✓ Find

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

✓ First Occurrence

✓ Recursive Search

✓ Linear Search

✓ Tree Search

✓ Graph DFS

=================================================
*/