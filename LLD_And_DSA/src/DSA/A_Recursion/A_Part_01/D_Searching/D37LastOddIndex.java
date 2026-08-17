package DSA.A_Recursion.A_Part_01.D_Searching;

public class D37LastOddIndex {

    /*
     * =========================================
     * Problem : Last Odd Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * lastOddIndex(arr, idx - 2, target)
     * returns the last odd index
     * containing the target in the
     * remaining left part of the array.
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
     * return lastOddIndex(arr, idx - 2, target);
     *
     * Time  : O(n/2)
     * Space : O(n/2)
     * =========================================
     */

    public static int lastOddIndex(int[] arr, int idx, int target) {

        // Base Case
        if (idx < 0) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return lastOddIndex(arr, idx - 2, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        int startIndex;

        // Start from the last odd index
        if (((arr.length - 1) & 1) == 1) {
            startIndex = arr.length - 1;
        } else {
            startIndex = arr.length - 2;
        }

        System.out.println("Last Odd Index of 3   : " + lastOddIndex(arr, startIndex, 3));

        System.out.println("Last Odd Index of 100 : " + lastOddIndex(arr, startIndex, 100));

        System.out.println("Last Odd Index of 500 : " + lastOddIndex(arr, startIndex, 500));
    }
}

/*
=================================================
Problem : Last Odd Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the last odd index
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

9

-------------------------------------------------

Faith

lastOddIndex(arr, idx - 2, target)

returns

The last odd index containing
the target in the remaining
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

return lastOddIndex(arr, idx - 2, target);

-------------------------------------------------

Dry Run

Example 1

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

3

↓

Start

Index 9

↓

3 == 3

↓

Found

↓

return 9

-------------------------------------------------

Example 2

Target

100

↓

Index 9

↓

3 != 100

↓

Index 7

↓

-777 != 100

↓

Index 5

↓

3 != 100

↓

Index 3

↓

4 != 100

↓

Index 1

↓

2 != 100

↓

Index -1

↓

return -1

-------------------------------------------------

Recursion Tree

Searching Target = 100

lastOddIndex(9)
│
└──lastOddIndex(7)
     │
     └──lastOddIndex(5)
          │
          └──lastOddIndex(3)
               │
               └──lastOddIndex(1)
                    │
                    └──lastOddIndex(-1)

-------------------------------------------------

Returning Phase

Index -1

↓

return -1

↑

Index 1

↓

return -1

↑

Index 3

↓

return -1

↑

Index 5

↓

return -1

↑

Index 7

↓

return -1

↑

Index 9

↓

return -1

-------------------------------------------------

Algorithm

1. Start from the last odd index.

2. Compare the current odd index
   with the target.

3. If found, return the index.

4. Otherwise, move two positions
   to the previous odd index.

-------------------------------------------------

Mental Model

Search only odd indices.

Ignore every even index.

The first match found while
moving backwards is the

Last Odd Index.

-------------------------------------------------

Common Mistakes

❌ Starting from the last index
instead of the last odd index.

❌ Using idx-1 instead of idx-2.

❌ Forgetting to adjust the
starting index for even-length arrays.

❌ Returning the value instead
of the index.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Last Odd Index

✓ Reverse Search

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

✓ Last Odd Index

✓ Recursive Searching

✓ Reverse Search

✓ Jump Recursion

✓ Array Traversal

=================================================
*/