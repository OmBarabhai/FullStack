package DSA.A_Recursion.Part_01.E_Conditional_Counting;

public class E41CountOccurrences {

    /*
     * =========================================
     * Problem : Count Occurrences
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countOccurrences(arr, idx + 1, target)
     * returns the number of occurrences
     * of the target in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * satisfies the condition.
     *
     * Formula
     *
     * int count =
     * countOccurrences(arr, idx + 1, target);
     *
     * if(arr[idx] == target)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countOccurrences(int[] arr, int idx, int target) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countOccurrences(arr, idx + 1, target);

        // Current Work
        if (arr[idx] == target) {
            return count + 1;
        }

        return count;
    }

    /*
     * =========================================
     * Alternate Solution
     * =========================================
     *
     * Direct Recursive Style
     *
     * Instead of storing the recursive answer,
     * immediately return
     *
     * 1 + recursion(...)
     *
     * whenever the condition is true.
     *
     * This solution is shorter,
     * but both approaches have
     * exactly the same complexity.
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countOccurrencesDirect(int[] arr, int idx, int target) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] == target) {
            return 1 + countOccurrencesDirect(arr, idx + 1, target);
        }

        // Recursive Call
        return countOccurrencesDirect(arr, idx + 1, target);
    }

    public static void main(String[] args) {

        int[] arr = {
                32, 34, 91, 2, 5, 6, 3,
                7, 30, 99, 22, 7, 32,
                66, 777, 7, 77, 67, 7
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Occurrences of 7   : "
                + countOccurrences(arr, 0, 7));

        System.out.println("Occurrences of 32  : "
                + countOccurrences(arr, 0, 32));

        System.out.println("Occurrences of 100 : "
                + countOccurrences(arr, 0, 100));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Occurrences of 7   : "
                + countOccurrencesDirect(arr, 0, 7));

        System.out.println("Occurrences of 32  : "
                + countOccurrencesDirect(arr, 0, 32));

        System.out.println("Occurrences of 100 : "
                + countOccurrencesDirect(arr, 0, 100));
    }
}

/*
=================================================
Problem : Count Occurrences
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of occurrences
of a target element in an array
using recursion.

-------------------------------------------------

Example

Input

{1,2,3,2,4,2}

Target

2

Output

3

-------------------------------------------------

Faith

countOccurrences(arr, idx + 1, target)

returns

The number of occurrences
of the target in the
remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

with

target

If equal

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countOccurrences(arr, idx + 1, target);

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

✓ Easy to understand

✓ Best for beginners

✓ Used in interview explanations

-------------------------------------------------

Approach 2

Direct Recursive

if(condition)
    return 1 + recursion(...);

return recursion(...);

Advantages

✓ Shorter code

✓ Cleaner implementation

✓ Same Time Complexity

-------------------------------------------------

Dry Run

Array

{2,5,2,7}

Target

2

↓

count(0)

↓

count(1)

↓

count(2)

↓

count(3)

↓

count(4)

↓

0

↑

7 != 2

↓

0

↑

2 == 2

↓

1

↑

5 != 2

↓

1

↑

2 == 2

↓

2

-------------------------------------------------

Recursion Tree

count(0)
│
└──count(1)
     │
     └──count(2)
          │
          └──count(3)
               │
               └──count(4)

-------------------------------------------------

Returning Phase

count(4)

↓

0

↑

count(3)

↓

0

↑

count(2)

↓

1

↑

count(1)

↓

1

↑

count(0)

↓

2

-------------------------------------------------

Algorithm

1. Reach the end of the array.

2. Trust recursion to count
   the remaining elements.

3. Check the current element.

4. If the condition is true,
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

Does Current Element
Satisfy The Condition?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Count Occurrences

✓ Count Frequency

✓ Count Matches

✓ Count Target

✓ Count Elements
  Satisfying Condition

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

❌ Returning 1 immediately.

❌ Forgetting recursive answer.

❌ Wrong base case.

❌ Returning current count
instead of recursive count.

❌ Mixing counting logic
with searching logic.

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ Frequency Counting

✓ Conditional Counting

✓ Filtering

✓ Statistics

✓ Recursive Processing

=================================================
*/