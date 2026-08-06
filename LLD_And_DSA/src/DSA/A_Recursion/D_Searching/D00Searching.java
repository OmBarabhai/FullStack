package DSA.A_Recursion.D_Searching;

/*
=========================================================
            PATTERN 04 : RECURSIVE SEARCHING
=========================================================

Definition
----------

Do NOT search the entire array yourself.

Search only the current element.

If the answer is not found,

trust recursion to search the
remaining part.

---------------------------------------------------------

Core Formula

Current Element

        ↓

Check Current

        ↓

Found?

        ↓

Yes

↓

Return Answer

        ↓

No

↓

Ask Recursion

        ↓

Return Recursive Answer

---------------------------------------------------------

Mental Model

"I don't search everything."

"I only search my current position."

"If I don't find the answer,

I trust recursion."

---------------------------------------------------------

Recognition

If the question asks

✓ Search

✓ Find

✓ Contains

✓ Exists

✓ First Occurrence

✓ Last Occurrence

✓ Index

✓ Position

✓ Locate

Immediately think

Recursive Searching

---------------------------------------------------------

Common Formula

if(currentMatches){

    return currentAnswer;

}

return function(smallerProblem);

---------------------------------------------------------

Used In

✓ Contains Element

✓ First Occurrence

✓ Last Occurrence

✓ First Even Index

✓ Last Even Index

✓ First Odd Index

✓ Last Odd Index

✓ First Positive Index

✓ Last Positive Index

✓ First Negative Index

✓ Linear Search

✓ Tree Search

✓ Graph DFS

=========================================================
*/

public class D00Searching {

    /*
    =========================================================
    Problem 1 : Contains Element

    Faith

    containsElement(arr, idx+1)

    tells whether the target
    exists in the remaining array.

    Current Work

    Compare

    arr[idx]

    with

    target

    =========================================================
    */

    /*
    See:
    D31ContainsElement.java
    */

    /*
    =========================================================
    Problem 2 : First Occurrence
    =========================================================
    */

    /*
    See:
    D32FirstOccurrence.java
    */

    /*
    =========================================================
    Problem 3 : Last Occurrence
    =========================================================
    */

    /*
    See:
    D33LastOccurrence.java
    */

    /*
    =========================================================
    Problem 4 : First Even Index
    =========================================================
    */

    /*
    See:
    D34FirstEvenIndex.java
    */

    /*
    =========================================================
    Problem 5 : Last Even Index
    =========================================================
    */

    /*
    See:
    D35LastEvenIndex.java
    */

    /*
    =========================================================
    Problem 6 : First Odd Index
    =========================================================
    */

    /*
    See:
    D36FirstOddIndex.java
    */

    /*
    =========================================================
    Problem 7 : Last Odd Index
    =========================================================
    */

    /*
    See:
    D37LastOddIndex.java
    */

    /*
    =========================================================
    Problem 8 : First Positive Index
    =========================================================
    */

    /*
    See:
    D38FirstPositiveIndex.java
    */

    /*
    =========================================================
    Problem 9 : Last Positive Index
    =========================================================
    */

    /*
    See:
    D39LastPositiveIndex.java
    */

    /*
    =========================================================
    Problem 10 : First Negative Index
    =========================================================
    */

    /*
    See:
    D40FirstNegativeIndex.java
    */

    /*
    =========================================================

                    PATTERN SUMMARY

    Step 1

    Check Current Element

            ↓

    Step 2

    Found?

            ↓

    YES

            ↓

    Return Answer

            ↓

    NO

            ↓

    Search Remaining

            ↓

    Return Recursive Answer

    ---------------------------------------------------------

    Remember

    Search only one element.

    If not found,

    trust recursion.

    ---------------------------------------------------------

    Common Mistakes

    ❌ Wrong base case.

    ❌ Forgetting to check the
       current element.

    ❌ Returning before recursion.

    ❌ Returning value instead
       of index.

    ❌ Forgetting to return
       the recursive call.

    ---------------------------------------------------------

    Interview Frequency

    ⭐⭐⭐⭐⭐

    Foundation For

    ✓ Linear Search

    ✓ Tree Search

    ✓ Graph DFS

    ✓ Backtracking

    ✓ Binary Tree Search

    =========================================================
    */

    public static void main(String[] args) {

        System.out.println("See individual files for:");

        System.out.println("• Contains Element");

        System.out.println("• First Occurrence");

        System.out.println("• Last Occurrence");

        System.out.println("• First Even Index");

        System.out.println("• Last Even Index");

        System.out.println("• First Odd Index");

        System.out.println("• Last Odd Index");

        System.out.println("• First Positive Index");

        System.out.println("• Last Positive Index");

        System.out.println("• First Negative Index");
    }
}