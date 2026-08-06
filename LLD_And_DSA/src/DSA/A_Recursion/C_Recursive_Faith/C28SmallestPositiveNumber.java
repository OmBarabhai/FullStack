package DSA.A_Recursion.C_Recursive_Faith;

public class C28SmallestPositiveNumber {

    /*
     * =========================================
     * Problem : Smallest Positive Number
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * smallestPositiveIndex(arr, idx + 1)
     * returns the index of the smallest
     * positive number in the remaining array.
     *
     * Current Work:
     * Compare the current positive number
     * with the recursive answer.
     *
     * Return -1 if no positive number exists.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int smallestPositiveIndex(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return -1;
        }

        // Recursive Faith
        int smallestIndexFromRemaining = smallestPositiveIndex(arr, idx + 1);

        // Ignore non-positive numbers
        if (arr[idx] <= 0) {
            return smallestIndexFromRemaining;
        }

        // No positive number found yet
        if (smallestIndexFromRemaining == -1) {
            return idx;
        }

        // Current Work
        if (arr[idx] < arr[smallestIndexFromRemaining]) {
            return idx;
        }

        return smallestIndexFromRemaining;
    }

    public static void main(String[] args) {

        int[] arr = {-122, -122, 192, 2, 3, 11, 2, 4, -21, -211};

        int index = smallestPositiveIndex(arr, 0);

        if (index == -1) {
            System.out.println("No Positive Number Found");
        } else {
            System.out.println("Smallest Positive Index : " + index);
            System.out.println("Smallest Positive Value : " + arr[index]);
        }
    }
}

/*
=================================================
Problem : Smallest Positive Number
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question

Find the index of the smallest
positive number using recursion.

-------------------------------------------------

Example

Input

{-122,-122,192,2,3,11,2,4,-21,-211}

Output

Index : 6

Value : 2

-------------------------------------------------

Faith

smallestPositiveIndex(arr, idx + 1)

returns

The index of the smallest positive
number in the remaining array.

-------------------------------------------------

Current Work

1. Ignore non-positive numbers.

2. If recursion found no positive
   number, return current index.

3. Otherwise compare

arr[idx]

with

arr[smallestIndexFromRemaining]

Return the index of the smaller
positive number.

-------------------------------------------------

Formula

int smallestIndexFromRemaining =
smallestPositiveIndex(arr, idx + 1);

if(arr[idx] <= 0)
    return smallestIndexFromRemaining;

if(smallestIndexFromRemaining == -1)
    return idx;

if(arr[idx] < arr[smallestIndexFromRemaining])
    return idx;

return smallestIndexFromRemaining;

-------------------------------------------------

Dry Run

{-122,-122,192,2,3,11,2,4,-21,-211}

↓

smallestPositiveIndex(0)

↓

...

↓

smallestPositiveIndex(10)

↓

return -1

↑

-211

↓

return -1

↑

-21

↓

return -1

↑

4

↓

return index 7

↑

2

↓

2 < 4

↓

return index 6

↑

11

↓

return index 6

↑

3

↓

return index 6

↑

2

↓

2 == 2

↓

return index 6

↑

192

↓

return index 6

↑

-122

↓

return index 6

↑

-122

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

Common Mistakes

❌ Returning the value instead of
the index.

❌ Forgetting to ignore
non-positive numbers.

❌ Wrong base case.

❌ Comparing before checking
whether recursion returned -1.

-------------------------------------------------

Interview Uses

✓ Smallest Positive Number

✓ Conditional Minimum

✓ Recursive Faith

✓ Array Searching

✓ Divide & Conquer

=================================================
*/