package DSA.A_Recursion.C_Recursive_Faith;

public class C29LargestPositiveNumber {

    /*
     * =========================================
     * Problem : Largest Positive Number
     * Pattern : Recursive Faith
     *
     * Faith:
     * largestPositiveIndex(arr, idx + 1)
     * returns the index of the largest
     * positive number in the remaining array.
     *
     * Current Work:
     * Compare the current positive
     * element with the recursive answer.
     *
     * Return -1 if no positive number exists.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int largestPositiveIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Recursive Faith
        int largestPositiveIndexFromRemaining = largestPositiveIndex(arr, idx + 1);

        // Ignore non-positive numbers
        if (arr[idx] <= 0) {
            return largestPositiveIndexFromRemaining;
        }

        // No positive number found
        if (largestPositiveIndexFromRemaining == -1) {
            return idx;
        }

        // Current Work
        if (arr[idx] > arr[largestPositiveIndexFromRemaining]) {
            return idx;
        }

        return largestPositiveIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {-122, -122, 192, 2, 3, 11, 2, 4, -21, -211};

        int index = largestPositiveIndex(arr, 0);

        if (index == -1) {
            System.out.println("No Positive Number Found");
        } else {
            System.out.println("Largest Positive Index : " + index);
            System.out.println("Largest Positive Value : " + arr[index]);
        }
    }
}

/*
=================================================
Problem : Largest Positive Number
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the largest
positive number using recursion.

-------------------------------------------------

Example

Input

{-122,-122,192,2,3,11,2,4,-21,-211}

Output

Index : 2

Value : 192

-------------------------------------------------

Faith

largestPositiveIndex(arr, idx + 1)

returns

The index of the largest positive
number in the remaining array.

-------------------------------------------------

Current Work

1. Ignore non-positive numbers.

2. If recursion found no positive
   number, return current index.

3. Otherwise compare

arr[idx]

with

arr[largestPositiveIndexFromRemaining]

Return the index of the larger
positive number.

-------------------------------------------------

Formula

int largestPositiveIndexFromRemaining =
largestPositiveIndex(arr, idx + 1);

if(arr[idx] <= 0)
    return largestPositiveIndexFromRemaining;

if(largestPositiveIndexFromRemaining == -1)
    return idx;

if(arr[idx] > arr[largestPositiveIndexFromRemaining])
    return idx;

return largestPositiveIndexFromRemaining;

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

=================================================
*/