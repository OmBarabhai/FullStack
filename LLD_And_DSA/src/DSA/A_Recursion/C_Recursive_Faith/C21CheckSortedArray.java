package DSA.A_Recursion.C_Recursive_Faith;

public class C21CheckSortedArray {

    /*
     * =========================================
     * Problem : Check Sorted Array
     * Pattern : Recursive Faith
     * Folder  : C_Recursive_Faith
     *
     * Faith:
     * checkSortedArray(arr, idx + 1)
     * returns whether the remaining
     * array is sorted.
     *
     * Current Work:
     * Check only the current pair.
     *
     * If
     * arr[idx] > arr[idx + 1]
     *
     * return false.
     *
     * Otherwise,
     * trust recursion.
     *
     * Algorithm
     * ---------
     * 1. Check base case.
     * 2. Compare current pair.
     * 3. If current pair is not sorted,
     *    return false.
     * 4. Otherwise,
     *    trust recursion.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static boolean checkSortedArray(int[] arr, int idx) {

        // Base Case
        if (idx >= arr.length - 1) {
            return true;
        }

        // Current Work
        if (arr[idx] > arr[idx + 1]) {
            return false;
        }

        // Recursive Faith
        return checkSortedArray(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 9, 10, 22};

        System.out.println(checkSortedArray(arr, 0));
    }
}

/*
=================================================
Problem : Check Sorted Array
Pattern : Recursive Faith
Folder  : C_Recursive_Faith
=================================================

Question
--------

Check whether an array is sorted
in ascending order using recursion.

-------------------------------------------------

Example

Input

{2,3,4,9,10,22}

Output

true

-------------------------------------------------

Faith

checkSortedArray(arr, idx + 1)

returns

Whether the remaining array
is sorted.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

arr[idx + 1]

If

arr[idx] > arr[idx + 1]

↓

Return false.

Otherwise

↓

Trust recursion.

-------------------------------------------------

Formula

if(arr[idx] > arr[idx + 1])

    return false;

return checkSortedArray(arr, idx + 1);

-------------------------------------------------

Dry Run

Input

{2,3,4,9}

↓

check(0)

2 <= 3 ✔

↓

check(1)

3 <= 4 ✔

↓

check(2)

4 <= 9 ✔

↓

check(3)

Base Case

↓

true

↑

true

↑

true

↑

true

-------------------------------------------------

Recursion Tree

check(0)
│
└──check(1)
     │
     └──check(2)
          │
          └──check(3)
               │
               └──true

-------------------------------------------------

Returning Phase

check(3)

↓

true

↑

check(2)

↓

true

↑

check(1)

↓

true

↑

check(0)

↓

true

-------------------------------------------------

Algorithm

1. Check the base case.

2. Compare the current element
   with the next element.

3. If they are not sorted,
   return false immediately.

4. Otherwise,
   trust recursion to check
   the remaining array.

-------------------------------------------------

Common Mistakes

❌ Forgetting to return
the recursive call.

❌ Comparing

arr[idx]

with

arr[idx + 2]

instead of

arr[idx + 1]

❌ Missing the base case.

❌ Returning true too early.

-------------------------------------------------

Pattern Recognition

If the question asks

✓ Is Array Sorted?

✓ Is String Sorted?

✓ Increasing Order?

✓ Non-Decreasing Sequence?

↓

Think

Recursive Faith

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ Sorted Array

✓ Monotonic Array

✓ BST Validation

✓ Heap Validation

✓ Recursive Faith Pattern

=================================================
*/