package DSA.A_Recursion.Part_01.C_Recursive_Faith;

public class C25MinimumIndex {

    /*
     * =========================================
     * Problem : Index of Minimum Element
     * Pattern : Recursive Faith
     *
     * Faith:
     * minimumIndex(arr, idx + 1)
     * returns the index of the
     * minimum element in the
     * remaining array.
     *
     * Current Work:
     * Compare the current element
     * with the element at the
     * returned index.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int minimumIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length - 1) {
            return idx;
        }

        // Recursive Faith
        int minIndexFromRemaining = minimumIndex(arr, idx + 1);

        // Current Work
        if (arr[idx] < arr[minIndexFromRemaining]) {
            return idx;
        }

        return minIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {12, 3, 2, 1, 2, 1};

        int[] charArr = {'a', 'b', 'c', 'd', 'z', 'f', 'g'};

        System.out.println("Minimum Index (Numbers): " + minimumIndex(arr, 0));

        System.out.println("Minimum Value (Numbers): " + arr[minimumIndex(arr, 0)]);

        System.out.println("Minimum Index (Characters): " + minimumIndex(charArr, 0));

        System.out.println("Minimum Character: " + (char) charArr[minimumIndex(charArr, 0)]);
    }
}

/*
=================================================
Problem : Index of Minimum Element
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the minimum element
using recursion.

-------------------------------------------------

Example

Input

{12,3,2,1,2,1}

Output

3

-------------------------------------------------

Faith

minimumIndex(arr, idx + 1)

returns

The index of the minimum element
in the remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

arr[minIndexFromRemaining]

If

arr[idx] < arr[minIndexFromRemaining]

↓

Return idx

Otherwise

↓

Return minIndexFromRemaining

-------------------------------------------------

Formula

int minIndexFromRemaining =
minimumIndex(arr, idx + 1);

if(arr[idx] < arr[minIndexFromRemaining])
    return idx;

return minIndexFromRemaining;

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

=================================================
*/