package DSA.A_Recursion.Part_01.E_Conditional_Counting;

public class E46CountOddNumbers {

    /*
     * =========================================
     * Problem : Count Odd Numbers
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countOddNumbers(arr, idx + 1)
     * returns the number of odd numbers
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is odd.
     *
     * Formula
     *
     * int count =
     * countOddNumbers(arr, idx + 1);
     *
     * if((arr[idx] & 1) == 1)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countOddNumbers(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countOddNumbers(arr, idx + 1);

        // Current Work
        if ((arr[idx] & 1) == 1) {
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

    public static int countOddNumbersDirect(int[] arr, int idx) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if ((arr[idx] & 1) == 1) {
            return 1 + countOddNumbersDirect(arr, idx + 1);
        }

        // Recursive Call
        return countOddNumbersDirect(arr, idx + 1);
    }

    public static void main(String[] args) {

        int[] arr = {
                12, 5, 18, 9, 24,
                31, 42, 7, 50, 13
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Odd Numbers : "
                + countOddNumbers(arr, 0));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Odd Numbers : "
                + countOddNumbersDirect(arr, 0));
    }
}

/*
=================================================
Problem : Count Odd Numbers
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of odd numbers
in an array using recursion.

-------------------------------------------------

Example

Input

{12,5,18,9,24}

Output

2

-------------------------------------------------

Faith

countOddNumbers(arr, idx + 1)

returns

The number of odd numbers
in the remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

is odd

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countOddNumbers(arr, idx + 1);

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
   element is odd.

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

Odd Number?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

- Count Odd Numbers

- Count Odd Elements

- Frequency of Odd Numbers

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

- Using % incorrectly

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