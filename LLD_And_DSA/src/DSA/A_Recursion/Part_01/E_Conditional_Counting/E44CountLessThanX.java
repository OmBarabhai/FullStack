package DSA.A_Recursion.Part_01.E_Conditional_Counting;

public class E44CountLessThanX {

    /*
     * =========================================
     * Problem : Count Less Than X
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countLessThanX(arr, idx + 1, x)
     * returns the number of elements
     * less than x in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is less than x.
     *
     * Formula
     *
     * int count =
     * countLessThanX(arr, idx + 1, x);
     *
     * if(arr[idx] < x)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countLessThanX(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countLessThanX(arr, idx + 1, x);

        // Current Work
        if (arr[idx] < x) {
            return count + 1;
        }

        return count;
    }

    /*
     * =========================================
     * Alternate Solution
     * Direct Recursive Style
     * =========================================
     *
     * Instead of storing the recursive answer,
     * immediately return
     *
     * 1 + recursion(...)
     *
     * when the condition is true.
     */

    public static int countLessThanXDirect(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] < x) {
            return 1 + countLessThanXDirect(arr, idx + 1, x);
        }

        // Recursive Call
        return countLessThanXDirect(arr, idx + 1, x);
    }

    public static void main(String[] args) {

        int[] arr = {
                12, 5, 19, 8, 25,
                30, 7, 14, 40, 3
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Less than 10 : "
                + countLessThanX(arr, 0, 10));

        System.out.println("Less than 20 : "
                + countLessThanX(arr, 0, 20));

        System.out.println("Less than 50 : "
                + countLessThanX(arr, 0, 50));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Less than 10 : "
                + countLessThanXDirect(arr, 0, 10));

        System.out.println("Less than 20 : "
                + countLessThanXDirect(arr, 0, 20));

        System.out.println("Less than 50 : "
                + countLessThanXDirect(arr, 0, 50));
    }
}

/*
=================================================
Problem : Count Less Than X
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of elements
less than x using recursion.

-------------------------------------------------

Example

Input

{5,12,8,20,25}

x = 10

Output

2

-------------------------------------------------

Faith

countLessThanX(arr, idx + 1, x)

returns

The number of elements
less than x in the
remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

<

x

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countLessThanX(arr, idx + 1, x);

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
   element is less than x.

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

Current < X ?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

- Count Less Than X

- Numbers Smaller Than X

- Count Elements Below Limit

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

- Using <= instead of <

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