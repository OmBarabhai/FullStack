package DSA.A_Recursion.C_Recursive_Faith;

/*
=========================================================
            PATTERN 03 : RECURSIVE FAITH
=========================================================

Definition
----------

Do NOT solve the smaller problem yourself.

Trust recursion.

Recursion already knows the answer for the
remaining smaller problem.

Your job is only to

1. Receive the recursive answer.
2. Compare it with the current answer.
3. Return the better answer.

---------------------------------------------------------

Core Formula

Current Problem

        ↓

Ask Recursion

        ↓

Receive Recursive Answer

        ↓

Compare Current

        With

Recursive Answer

        ↓

Return Better Answer

---------------------------------------------------------

Mental Model

"I don't solve everything."

"I trust recursion to solve
the remaining problem."

"I only compare my current answer
with the recursive answer."

---------------------------------------------------------

Recognition

If the question asks

✓ Maximum
✓ Minimum
✓ Largest
✓ Smallest
✓ Best
✓ Compare
✓ Sorted
✓ Index
✓ Valid

Immediately think

Recursive Faith

---------------------------------------------------------

Common Formula

RecursiveAnswer

=

function(smallerProblem)

↓

Compare

↓

Return Better Answer

---------------------------------------------------------

Used In

✓ Maximum Element

✓ Minimum Element

✓ Maximum Index

✓ Minimum Index

✓ Largest Even Index

✓ Largest Odd Index

✓ Smallest Positive Index

✓ Largest Positive Index

✓ Smallest Negative Index

✓ Trees

✓ Binary Search Tree

✓ Divide & Conquer

=========================================================
*/

public class C00RecursiveFaith {

    /*
    =========================================================
    Problem 1 : Check Sorted Array

    Faith

    sorted(arr, idx+1)

    already tells whether the
    remaining array is sorted.

    Current Work

    Compare

    arr[idx]

    with

    arr[idx+1]

    =========================================================
    */

    public static boolean sorted(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return true;
        }

        if (arr[idx] > arr[idx + 1]) {
            return false;
        }

        return sorted(arr, idx + 1);
    }

    /*
    =========================================================
    Problem 2 : Maximum Element

    Faith

    maxElement(arr, idx+1)

    returns the maximum element
    from the remaining array.

    Current Work

    Compare current element
    with recursive answer.

    =========================================================
    */

    public static int maxElement(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        int maxRest = maxElement(arr, idx + 1);

        if (arr[idx] > maxRest) {
            return arr[idx];
        }

        return maxRest;
    }

    /*
    =========================================================
    Problem 3 : Minimum Element
    =========================================================
    */

    public static int minElement(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return arr[idx];
        }

        int minRest = minElement(arr, idx + 1);

        if (arr[idx] < minRest) {
            return arr[idx];
        }

        return minRest;
    }

    /*
    =========================================================
    Problem 4 : Maximum Index
    =========================================================
    */

    public static int maxIndex(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return idx;
        }

        int maxIdx = maxIndex(arr, idx + 1);

        if (arr[idx] > arr[maxIdx]) {
            return idx;
        }

        return maxIdx;
    }

    /*
    =========================================================
    Problem 5 : Minimum Index
    =========================================================
    */

    public static int minIndex(int[] arr, int idx) {

        if (idx == arr.length - 1) {
            return idx;
        }

        int minIdx = minIndex(arr, idx + 1);

        if (arr[idx] < arr[minIdx]) {
            return idx;
        }

        return minIdx;
    }

    /*
    =========================================================
    Problem 6 : Largest Even Index
    =========================================================
    */

    /*
    See:
    C26LargestEvenNumber.java
    */

    /*
    =========================================================
    Problem 7 : Largest Odd Index
    =========================================================
    */

    /*
    See:
    C27LargestOddNumber.java
    */

    /*
    =========================================================
    Problem 8 : Smallest Positive Index
    =========================================================
    */

    /*
    See:
    C28SmallestPositiveNumber.java
    */

    /*
    =========================================================
    Problem 9 : Largest Positive Index
    =========================================================
    */

    /*
    See:
    C29LargestPositiveNumber.java
    */

    /*
    =========================================================
    Problem 10 : Smallest Negative Index
    =========================================================
    */

    /*
    See:
    C30SmallestNegativeNumber.java
    */

    /*
    =========================================================

                    PATTERN SUMMARY

    Step 1

    Ask Recursion

            ↓

    Step 2

    Receive Recursive Answer

            ↓

    Step 3

    Compare Current

            ↓

    Step 4

    Return Better Answer

    ---------------------------------------------------------

    Remember

    Never solve the smaller problem.

    Trust recursion.

    Only compare.

    ---------------------------------------------------------

    Common Mistakes

    ❌ Solving the smaller problem yourself.

    ❌ Forgetting the recursive answer.

    ❌ Returning current answer directly.

    ❌ Comparing before recursion.

    ❌ Wrong base case.

    ---------------------------------------------------------

    Interview Frequency

    ⭐⭐⭐⭐⭐

    Foundation For

    ✓ Trees

    ✓ Binary Search Tree

    ✓ Divide & Conquer

    ✓ Dynamic Programming

    ✓ Greedy Comparison

    ✓ Recursive Searching

    =========================================================
    */

    public static void main(String[] args) {

        int[] arr = {4, 7, 2, 9, 1, 8};

        System.out.println("Sorted : "
                + sorted(new int[]{1, 2, 3, 4, 5}, 0));

        System.out.println("Maximum Element : "
                + maxElement(arr, 0));

        System.out.println("Minimum Element : "
                + minElement(arr, 0));

        System.out.println("Maximum Index : "
                + maxIndex(arr, 0));

        System.out.println("Minimum Index : "
                + minIndex(arr, 0));

        System.out.println();

        System.out.println("See individual files for:");

        System.out.println("• Largest Even Index");

        System.out.println("• Largest Odd Index");

        System.out.println("• Smallest Positive Index");

        System.out.println("• Largest Positive Index");

        System.out.println("• Smallest Negative Index");
    }
}