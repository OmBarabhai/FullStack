package DSA.A_Recursion.A_Part_01.C_Recursive_Faith;

public class C26LargestEvenNumber {

    /*
     * =========================================
     * Problem : Largest Even Number
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * largestEvenIndex(arr, idx + 1)
     * returns the index of the
     * largest even number in the
     * remaining array.
     *
     * Current Work:
     * Compare the current even element
     * with the recursive answer.
     *
     * Return -1 if no even number exists.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int largestEvenIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Recursive Faith
        int largestEvenIndexFromRemaining = largestEvenIndex(arr, idx + 1);

        // Current element is odd
        if ((arr[idx] & 1) == 1) {
            return largestEvenIndexFromRemaining;
        }

        // No even number found in remaining array
        if (largestEvenIndexFromRemaining == -1) {
            return idx;
        }

        // Current Work
        if (arr[idx] > arr[largestEvenIndexFromRemaining]) {
            return idx;
        }

        return largestEvenIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {12, 3, 2, 1, 20, 18, 7};

        int index = largestEvenIndex(arr, 0);

        if (index == -1) {
            System.out.println("No Even Number Found");
        } else {
            System.out.println("Largest Even Index : " + index);
            System.out.println("Largest Even Value : " + arr[index]);
        }
    }
}

/*
=================================================
Problem : Largest Even Number
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the largest even
number using recursion.

-------------------------------------------------

Example

Input

{12,3,2,1,20,18,7}

Output

Index : 4

Value : 20

-------------------------------------------------

Faith

largestEvenIndex(arr, idx + 1)

returns

The index of the largest even number
in the remaining array.

-------------------------------------------------

Current Work

1. Ignore odd numbers.

2. If recursion found no even number,
   return current index.

3. Otherwise compare

arr[idx]

with

arr[largestEvenIndexFromRemaining]

Return the index of the larger
even number.

-------------------------------------------------

Formula

int largestEvenIndexFromRemaining =
largestEvenIndex(arr, idx + 1);

if(current is odd)
    return largestEvenIndexFromRemaining;

if(largestEvenIndexFromRemaining == -1)
    return idx;

if(arr[idx] > arr[largestEvenIndexFromRemaining])
    return idx;

return largestEvenIndexFromRemaining;

-------------------------------------------------

Dry Run

{12,3,2,1,20,18,7}

↓

largestEvenIndex(0)

↓

largestEvenIndex(1)

↓

largestEvenIndex(2)

↓

largestEvenIndex(3)

↓

largestEvenIndex(4)

↓

largestEvenIndex(5)

↓

largestEvenIndex(6)

↓

largestEvenIndex(7)

↓

return -1

↑

7 is odd

↓

return -1

↑

18 is even

↓

return index 5

↑

20 > 18

↓

return index 4

↑

1 is odd

↓

return index 4

↑

2 < 20

↓

return index 4

↑

3 is odd

↓

return index 4

↑

12 < 20

↓

return index 4

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Common Mistakes

❌ Returning the value instead of index.

❌ Forgetting to ignore odd numbers.

❌ Wrong base case.

❌ Comparing with an invalid index.

-------------------------------------------------

Interview Uses

✓ Largest Even Number

✓ Conditional Maximum

✓ Recursive Faith

✓ Array Searching

✓ Divide & Conquer

=================================================
*/