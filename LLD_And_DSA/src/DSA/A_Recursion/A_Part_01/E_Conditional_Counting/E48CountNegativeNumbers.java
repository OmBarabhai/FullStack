package DSA.A_Recursion.A_Part_01.E_Conditional_Counting;

public class E48CountNegativeNumbers {

    /*
     * =========================================
     * Problem : Count Negative Numbers
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countNegativeNumbers(arr, idx + 1)
     * returns the number of negative numbers
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is negative.
     *
     * Formula
     *
     * int count =
     * countNegativeNumbers(arr, idx + 1);
     *
     * if(arr[idx] < 0)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countNegativeNumbers(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countNegativeNumbers(arr, idx + 1);

        // Current Work
        if (arr[idx] < 0) {
            return count + 1;
        }

        return count;
    }

    /*
     * =========================================
     * Alternate Solution
     * Direct Recursive Style
     * =========================================
     */

    public static int countNegativeNumbersDirect(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] < 0) {
            return 1 + countNegativeNumbersDirect(arr, idx + 1);
        }

        // Recursive Call
        return countNegativeNumbersDirect(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {
                -12, 5, 18, -9, 24,
                0, -42, 7, 50, -13
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Negative Numbers : "
                + countNegativeNumbers(arr, 0));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Negative Numbers : "
                + countNegativeNumbersDirect(arr, 0));
    }
}

/*
=================================================
Problem : Count Negative Numbers
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of negative numbers
in an array using recursion.

-------------------------------------------------

Example

Input

{-5,2,8,-1,0,6}

Output

2

-------------------------------------------------

Faith

countNegativeNumbers(arr, idx + 1)

returns

The number of negative numbers
in the remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

<

0

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countNegativeNumbers(arr, idx + 1);

if(condition){

    return count + 1;

}

return count;

-------------------------------------------------

Two Approaches

Approach 1

Recursive Faith

int count =
recursion(...);

if(condition)
    return count + 1;

return count;

Advantages

- Easy to understand

- Best for beginners

- Used in interview explanations

-------------------------------------------------

Approach 2

Direct Recursive

if(condition)
    return 1 + recursion(...);

return recursion(...);

Advantages

- Shorter code

- Cleaner implementation

- Same Time Complexity

-------------------------------------------------

Algorithm

1. Reach the end of the array.

2. Trust recursion to count
   the remaining elements.

3. Check whether the current
   element is negative.

4. If true,
   add one to the recursive count.

5. Otherwise,
   return the recursive count.

-------------------------------------------------

Mental Model

Current Element

↓

Ask Recursion

↓

Receive Count

↓

Negative Number?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

- Count Negative Numbers

- Count Negative Elements

- Frequency of Negative Numbers

↓

Think

Conditional Counting

-------------------------------------------------

Pattern Summary

Ask Recursion

↓

Receive Count

↓

Check Condition

↓

Condition True ?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Common Mistakes

- Counting zero as negative

- Wrong base case

- Forgetting recursive answer

- Returning 1 directly

- Mixing counting logic
  with searching logic

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

- Filtering

- Frequency Counting

- Conditional Counting

- Statistics

- Recursive Processing

=================================================
*/