package DSA.A_Recursion.Part_01.C_Recursive_Faith;

public class C27LargestOddNumber {

    /*
     * =========================================
     * Problem : Largest Odd Number
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * largestOddIndex(arr, idx + 1)
     * returns the index of the
     * largest odd number in the
     * remaining array.
     *
     * Current Work:
     * Compare the current odd element
     * with the recursive answer.
     *
     * Return -1 if no odd number exists.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int largestOddIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Recursive Faith
        int largestOddIndexFromRemaining = largestOddIndex(arr, idx + 1);

        // Ignore Even Numbers
        if ((arr[idx] & 1) == 0) {
            return largestOddIndexFromRemaining;
        }

        // No Odd Number Found Yet
        if (largestOddIndexFromRemaining == -1) {
            return idx;
        }

        // Current Work
        if (arr[idx] > arr[largestOddIndexFromRemaining]) {
            return idx;
        }

        return largestOddIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {12, 3, 2, 1, 20, 18, 7};

        int index = largestOddIndex(arr, 0);

        if (index == -1) {
            System.out.println("No Odd Number Found");
        } else {
            System.out.println("Largest Odd Index : " + index);
            System.out.println("Largest Odd Value : " + arr[index]);
        }
    }
}

/*
=================================================
Problem : Largest Odd Number
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the largest odd
number using recursion.

-------------------------------------------------

Example

Input

{12,3,2,1,20,18,7}

Output

Index : 6

Value : 7

-------------------------------------------------

Faith

largestOddIndex(arr, idx + 1)

returns

The index of the largest odd number
in the remaining array.

-------------------------------------------------

Current Work

1. Ignore even numbers.

2. If recursion found no odd number,
   return current index.

3. Otherwise compare

arr[idx]

with

arr[largestOddIndexFromRemaining]

Return the index of the larger
odd number.

-------------------------------------------------

Formula

int largestOddIndexFromRemaining =
largestOddIndex(arr, idx + 1);

if(current is even)
    return largestOddIndexFromRemaining;

if(largestOddIndexFromRemaining == -1)
    return idx;

if(arr[idx] > arr[largestOddIndexFromRemaining])
    return idx;

return largestOddIndexFromRemaining;

-------------------------------------------------

Dry Run

{12,3,2,1,20,18,7}

↓

largestOddIndex(0)

↓

largestOddIndex(1)

↓

largestOddIndex(2)

↓

largestOddIndex(3)

↓

largestOddIndex(4)

↓

largestOddIndex(5)

↓

largestOddIndex(6)

↓

largestOddIndex(7)

↓

return -1

↑

7 is odd

↓

return index 6

↑

18 is even

↓

return index 6

↑

20 is even

↓

return index 6

↑

1 < 7

↓

return index 6

↑

2 is even

↓

return index 6

↑

3 < 7

↓

return index 6

↑

12 is even

↓

return index 6

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ Largest Odd Number

✓ Conditional Maximum

✓ Recursive Faith

✓ Array Searching

✓ Divide & Conquer

=================================================
*/