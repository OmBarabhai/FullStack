package DSA.A_Recursion.A_Part_01.E_Conditional_Counting;

public class E49CountZeroes {

    /*
     * =========================================
     * Problem : Count Zeroes
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countZeroes(arr, idx + 1)
     * returns the number of zeroes
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is zero.
     *
     * Formula
     *
     * int count =
     * countZeroes(arr, idx + 1);
     *
     * if(arr[idx] == 0)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countZeroes(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countZeroes(arr, idx + 1);

        // Current Work
        if (arr[idx] == 0) {
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

    public static int countZeroesDirect(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] == 0) {
            return 1 + countZeroesDirect(arr, idx + 1);
        }

        // Recursive Call
        return countZeroesDirect(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {
                0, 5, -2, 0, 8,
                0, -7, 10, 0, 15
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Zeroes : "
                + countZeroes(arr, 0));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Zeroes : "
                + countZeroesDirect(arr, 0));
    }
}

/*
=================================================
Problem : Count Zeroes
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of zeroes
in an array using recursion.

-------------------------------------------------

Example

Input

{0,5,-2,0,8}

Output

2

-------------------------------------------------

Faith

countZeroes(arr, idx + 1)

returns

The number of zeroes
in the remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

==

0

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countZeroes(arr, idx + 1);

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
   element is zero.

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

Current == 0 ?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

- Count Zeroes

- Count Zero Values

- Frequency of Zeroes

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

- Confusing zero with positive
  or negative

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

- Frequency Counting

- Data Validation

- Conditional Counting

- Statistics

- Recursive Processing

=================================================
*/