package DSA.A_Recursion.Part_01.E_Conditional_Counting;

/*
=========================================================
          PATTERN 05 : CONDITIONAL COUNTING
=========================================================

Definition
----------

Conditional Counting is a recursion pattern
where recursion returns the count from the
remaining array, and the current function
decides whether to increase that count.

Unlike Searching

✓ We never stop early.

Unlike Recursive Faith

✓ We are not comparing values.

We simply

1. Ask recursion for the count.

2. Check the current element.

3. Add 1 if the condition is true.

4. Return the final count.

---------------------------------------------------------

Core Formula

Current Element

        ↓

Ask Recursion

        ↓

Receive Count

        ↓

Condition True ?

      /       \

    YES        NO

     |          |

Count + 1     Count

---------------------------------------------------------

Mental Model

"I don't count the whole array."

"I trust recursion to count
everything after me."

"I only decide whether
the current element
contributes

0

or

1."

---------------------------------------------------------

Recognition

Whenever the question asks

✓ Count

✓ Frequency

✓ Number Of

✓ Total

✓ Occurrences

✓ Filter

✓ Matching Elements

Immediately think

Conditional Counting

---------------------------------------------------------

Generic Formula

int count =
recursion(smallerProblem);

if(condition){

    return count + 1;

}

return count;

---------------------------------------------------------

Direct Recursive Formula

if(condition){

    return 1 + recursion(smallerProblem);

}

return recursion(smallerProblem);

---------------------------------------------------------

Used In

✓ Count Occurrences

✓ Count Equal To X

✓ Count Greater Than X

✓ Count Less Than X

✓ Count Even Numbers

✓ Count Odd Numbers

✓ Count Positive Numbers

✓ Count Negative Numbers

✓ Count Zeroes

✓ Count Multiples Of K

=========================================================
*/

public class E00ConditionalCounting {

    /*
    =========================================================
    Problem 1 : Count Occurrences
    =========================================================
    */

    public static int countOccurrences(int[] arr, int idx, int target) {

        if (idx == arr.length) {
            return 0;
        }

        int count = countOccurrences(arr, idx + 1, target);

        if (arr[idx] == target) {
            return count + 1;
        }

        return count;
    }

    /*
    =========================================================
    Problem 2 : Count Greater Than X
    =========================================================
    */

    public static int countGreaterThanX(int[] arr, int idx, int x) {

        if (idx == arr.length) {
            return 0;
        }

        int count = countGreaterThanX(arr, idx + 1, x);

        if (arr[idx] > x) {
            return count + 1;
        }

        return count;
    }

    /*
    =========================================================
    Problem 3 : Count Even Numbers
    =========================================================
    */

    public static int countEvenNumbers(int[] arr, int idx) {

        if (idx == arr.length) {
            return 0;
        }

        int count = countEvenNumbers(arr, idx + 1);

        if ((arr[idx] & 1) == 0) {
            return count + 1;
        }

        return count;
    }

    /*
    =========================================================
    Problem 4 : Count Positive Numbers
    =========================================================
    */

    public static int countPositiveNumbers(int[] arr, int idx) {

        if (idx == arr.length) {
            return 0;
        }

        int count = countPositiveNumbers(arr, idx + 1);

        if (arr[idx] > 0) {
            return count + 1;
        }

        return count;
    }

    /*
    =========================================================

                    PATTERN SUMMARY

    Step 1

    Reach Base Case

            ↓

    Step 2

    Ask Recursion

            ↓

    Step 3

    Receive Count

            ↓

    Step 4

    Check Current Element

            ↓

    Step 5

    If Condition True

    Count + 1

    Otherwise

    Count

    ---------------------------------------------------------

    Remember

    Trust recursion.

    Never stop early.

    Every element must be visited.

    Only the condition changes.

    ---------------------------------------------------------

    Common Mistakes

    - Returning 1 immediately.

    - Forgetting recursive answer.

    - Wrong base case.

    - Returning current answer
      instead of recursive count.

    - Mixing Searching
      and Counting.

    ---------------------------------------------------------

    Interview Frequency

    ★★★★★

    Foundation For

    ✓ Frequency Counting

    ✓ Tree Node Counting

    ✓ Graph Traversal Counting

    ✓ Dynamic Programming

    ✓ Backtracking State Counting

    =========================================================
    */

    public static void main(String[] args) {

        int[] arr = {12, -5, 18, 0, 24, -7, 30, 8, 0, 15};

        System.out.println("Count Occurrences (0) : " + countOccurrences(arr, 0, 0));

        System.out.println("Count Greater Than 10 : " + countGreaterThanX(arr, 0, 10));

        System.out.println("Count Even Numbers    : " + countEvenNumbers(arr, 0));

        System.out.println("Count Positive Numbers: " + countPositiveNumbers(arr, 0));

        System.out.println();

        System.out.println("See individual files for:");

        System.out.println("- Count Equal To X");

        System.out.println("- Count Less Than X");

        System.out.println("- Count Odd Numbers");

        System.out.println("- Count Negative Numbers");

        System.out.println("- Count Zeroes");

        System.out.println("- Count Multiples Of K");
    }
}