package DSA.A_Recursion.D_Searching;

public class D33LastOccurrence {

    /*
     * =========================================
     * Problem : Last Occurrence
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * lastOccurrence(arr, idx - 1, target)
     * returns the index of the last
     * occurrence of the target in the
     * remaining left part of the array.
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
     * return lastOccurrence(arr, idx - 1, target);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int lastOccurrence(int[] arr, int idx, int target) {

        // Base Case
        if (idx < 0) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return lastOccurrence(arr, idx - 1, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        System.out.println("Last Occurrence of 3   : " + lastOccurrence(arr, arr.length - 1, 3));

        System.out.println("Last Occurrence of 100 : " + lastOccurrence(arr, arr.length - 1, 100));

        System.out.println("Last Occurrence of 500 : " + lastOccurrence(arr, arr.length - 1, 500));
    }
}

/*
=================================================
Problem : Last Occurrence
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the index of the last
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

9

-------------------------------------------------

Faith

lastOccurrence(arr, idx - 1, target)

returns

The index of the last occurrence
of the target in the remaining
left part of the array.

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

return lastOccurrence(arr, idx - 1, target);

-------------------------------------------------

Dry Run

Array

{1,2,3,4,99,3}

Target

3

↓

lastOccurrence(5)

↓

Check

3 == 3

↓

Yes

↓

return 5

-------------------------------------------------

Recursion Tree

lastOccurrence(5)
│
└──return 5

-------------------------------------------------

Returning Phase

lastOccurrence(5)

↓

return 5

-------------------------------------------------

Algorithm

1. Start from the last index.

2. Compare the current element
   with the target.

3. If found, return the current index.

4. Otherwise, trust recursion
   to search the remaining
   left part of the array.

-------------------------------------------------

Mental Model

I search from right to left.

The first match while moving
backwards is the last occurrence.

-------------------------------------------------

Common Mistakes

❌ Using

if(idx == 0)

instead of

if(idx < 0)

❌ Forgetting to check
the first element.

❌ Returning value instead
of index.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Last Occurrence

✓ Last Index

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

✓ Last Occurrence

✓ Reverse Search

✓ Recursive Search

✓ Tree Search

=================================================
*/