package DSA.A_Recursion.A_Part_01.E_Conditional_Counting;

public class E50CountMultiplesOfK {

    /*
     * =========================================
     * Problem : Count Multiples Of K
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countMultiplesOfK(arr, idx + 1, k)
     * returns the number of elements
     * divisible by k in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is divisible by k.
     *
     * Formula
     *
     * int count =
     * countMultiplesOfK(arr, idx + 1, k);
     *
     * if(arr[idx] % k == 0)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countMultiplesOfK(int[] arr, int idx, int k) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countMultiplesOfK(arr, idx + 1, k);

        // Current Work
        if (arr[idx] % k == 0) {
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

    public static int countMultiplesOfKDirect(int[] arr, int idx, int k) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] % k == 0) {
            return 1 + countMultiplesOfKDirect(arr, idx + 1, k);
        }

        // Recursive Call
        return countMultiplesOfKDirect(arr, idx + 1, k);
    }

    public static void main(String[] args) {

        int[] arr = {
                12, 5, 18, 9, 24,
                30, 7, 14, 40, 3
        };

        int k = 3;

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Multiples of " + k + " : "
                + countMultiplesOfK(arr, 0, k));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Multiples of " + k + " : "
                + countMultiplesOfKDirect(arr, 0, k));
    }
}

/*
=================================================
Problem : Count Multiples Of K
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of elements
that are divisible by k
using recursion.

-------------------------------------------------

Example

Input

{12,5,18,9,24,30}

k = 3

Output

5

-------------------------------------------------

Faith

countMultiplesOfK(arr, idx + 1, k)

returns

The number of elements
divisible by k
in the remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

%

k

==

0

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countMultiplesOfK(arr, idx + 1, k);

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
   element is divisible by k.

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

Divisible By K?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

- Count Multiples Of K

- Count Divisible Numbers

- Count Numbers Divisible By K

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

- Forgetting k can be zero
  (validate if required)

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

- Filtering

- Conditional Counting

- Divisibility Problems

- Recursive Processing

=================================================
*/