package DSA.A_Recursion.C_Recursive_Faith;

public class C30SmallestNegativeNumber {

    /*
     * =========================================
     * Problem : Smallest Negative Number
     * Pattern : Recursive Faith
     *
     * Faith:
     * smallestNegativeIndex(arr, idx + 1)
     * returns the index of the smallest
     * negative number in the remaining array.
     *
     * Current Work:
     * Compare the current negative
     * element with the recursive answer.
     *
     * Return -1 if no negative number exists.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int smallestNegativeIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Recursive Faith
        int smallestNegativeIndexFromRemaining =
                smallestNegativeIndex(arr, idx + 1);

        // Ignore non-negative numbers
        if (arr[idx] >= 0) {
            return smallestNegativeIndexFromRemaining;
        }

        // No negative number found
        if (smallestNegativeIndexFromRemaining == -1) {
            return idx;
        }

        // Current Work
        if (arr[idx] < arr[smallestNegativeIndexFromRemaining]) {
            return idx;
        }

        return smallestNegativeIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {-122, -122, 192, 2, 3, 11, 2, 4, -21, -211};

        int index = smallestNegativeIndex(arr, 0);

        if (index == -1) {
            System.out.println("No Negative Number Found");
        } else {
            System.out.println("Smallest Negative Index : " + index);
            System.out.println("Smallest Negative Value : " + arr[index]);
        }
    }
}

/*
=================================================
Problem : Smallest Negative Number
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the smallest
negative number using recursion.

-------------------------------------------------

Example

Input

{-122,-122,192,2,3,11,2,4,-21,-211}

Output

Index : 9

Value : -211

-------------------------------------------------

Faith

smallestNegativeIndex(arr, idx + 1)

returns

The index of the smallest negative
number in the remaining array.

-------------------------------------------------

Current Work

1. Ignore non-negative numbers.

2. If recursion found no negative
   number, return current index.

3. Otherwise compare

arr[idx]

with

arr[smallestNegativeIndexFromRemaining]

Return the index of the smaller
negative number.

-------------------------------------------------

Formula

int smallestNegativeIndexFromRemaining =
smallestNegativeIndex(arr, idx + 1);

if(arr[idx] >= 0)
    return smallestNegativeIndexFromRemaining;

if(smallestNegativeIndexFromRemaining == -1)
    return idx;

if(arr[idx] < arr[smallestNegativeIndexFromRemaining])
    return idx;

return smallestNegativeIndexFromRemaining;

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

=================================================
*/