package DSA.A_Recursion.D_Searching;

public class D35LastEvenIndex {

    /*
     * =========================================
     * Problem : Last Even Index
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * lastEvenIndex(arr, idx - 2, target)
     * returns the last even index
     * containing the target in the
     * remaining left part of the array.
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
     * return lastEvenIndex(arr, idx - 2, target);
     *
     * Time  : O(n/2)
     * Space : O(n/2)
     * =========================================
     */

    public static int lastEvenIndex(int[] arr, int idx, int target) {

        // Base Case
        if (idx < 0) {
            return -1;
        }

        // Current Check
        if (arr[idx] == target) {
            return idx;
        }

        // Recursive Search
        return lastEvenIndex(arr, idx - 2, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777, 100, 3, 100};

        int startIndex;

        if (((arr.length - 1) & 1) == 0) {
            startIndex = arr.length - 1;
        } else {
            startIndex = arr.length - 2;
        }

        System.out.println("Last Even Index of 3   : " + lastEvenIndex(arr, startIndex, 3));

        System.out.println("Last Even Index of 100 : " + lastEvenIndex(arr, startIndex, 100));

        System.out.println("Last Even Index of 500 : " + lastEvenIndex(arr, startIndex, 500));
    }
}

/*
=================================================
Problem : Last Even Index
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Find the last even index
containing the target element
using recursion.

-------------------------------------------------

Example

Input

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

100

Output

10

-------------------------------------------------

Faith

lastEvenIndex(arr, idx - 2, target)

returns

The last even index containing
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

return lastEvenIndex(arr, idx - 2, target);

-------------------------------------------------

Time Complexity

O(n/2)

-------------------------------------------------

Space Complexity

O(n/2)

(Call Stack)

=================================================

-------------------------------------------------

Dry Run

Example 1

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

100

↓

Start From

Index 10

↓

100 == 100

↓

Found

↓

return 10

-------------------------------------------------

Example 2

Array

{1,2,3,4,99,3,21,-777,100,3,100}

Target

3

↓

Start

Index 10

↓

100 != 3

↓

Index 8

↓

100 != 3

↓

Index 6

↓

21 != 3

↓

Index 4

↓

99 != 3

↓

Index 2

↓

3 == 3

↓

return 2

-------------------------------------------------

Recursion Tree

Searching Target = 3

lastEvenIndex(10)
│
└──lastEvenIndex(8)
     │
     └──lastEvenIndex(6)
          │
          └──lastEvenIndex(4)
               │
               └──lastEvenIndex(2)
                    │
                    └──return 2

-------------------------------------------------

Returning Phase

Index 2

↓

return 2

↑

Index 4

↓

return 2

↑

Index 6

↓

return 2

↑

Index 8

↓

return 2

↑

Index 10

↓

return 2

-------------------------------------------------

Algorithm

1. Start from the last even index.

2. Compare the current even index
   with the target.

3. If found, return the index.

4. Otherwise move to the previous
   even index.

-------------------------------------------------

Mental Model

Search only even indices.

Ignore every odd index.

The first match found while
moving backwards is the

Last Even Index.

-------------------------------------------------

Common Mistakes

❌ Starting from the last index
instead of the last even index.

❌ Using idx-1 instead of idx-2.

❌ Forgetting to adjust the
starting index for even-length arrays.

❌ Returning the value instead
of the index.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Last Even Index

✓ Reverse Search

✓ Even Positions

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

✓ Last Even Index

✓ Reverse Recursive Search

✓ Jump Recursion

✓ Recursive Searching

✓ Array Traversal

=================================================

*/

