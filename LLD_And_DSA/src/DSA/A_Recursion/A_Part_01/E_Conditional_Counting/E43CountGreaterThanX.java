package DSA.A_Recursion.A_Part_01.E_Conditional_Counting;

public class E43CountGreaterThanX {

    /*
     * =========================================
     * Problem : Count Greater Than X
     * Pattern : Conditional Counting
     * Folder  : E_Conditional_Counting
     *
     * Faith:
     * countGreaterThanX(arr, idx + 1, x)
     * returns the number of elements
     * greater than x in the remaining array.
     *
     * Current Work:
     * Check whether the current element
     * is greater than x.
     *
     * Formula
     *
     * int count =
     * countGreaterThanX(arr, idx + 1, x);
     *
     * if(arr[idx] > x)
     *     return count + 1;
     *
     * return count;
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static int countGreaterThanX(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Recursive Faith
        int count = countGreaterThanX(arr, idx + 1, x);

        // Current Work
        if (arr[idx] > x) {
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

    public static int countGreaterThanXDirect(int[] arr, int idx, int x) {

        // Base Case
        if (idx == arr.length) {
            return 0;
        }

        // Current Work
        if (arr[idx] > x) {
            return 1 + countGreaterThanXDirect(arr, idx + 1, x);
        }

        // Recursive Call
        return countGreaterThanXDirect(arr, idx + 1, x);
    }

    public static void main(String[] args) {

        int[] arr = {
                12, 5, 19, 8, 25,
                30, 7, 14, 40, 3
        };

        System.out.println("========== Recursive Faith ==========");

        System.out.println("Greater than 10 : "
                + countGreaterThanX(arr, 0, 10));

        System.out.println("Greater than 20 : "
                + countGreaterThanX(arr, 0, 20));

        System.out.println("Greater than 50 : "
                + countGreaterThanX(arr, 0, 50));

        System.out.println();

        System.out.println("========== Direct Recursive ==========");

        System.out.println("Greater than 10 : "
                + countGreaterThanXDirect(arr, 0, 10));

        System.out.println("Greater than 20 : "
                + countGreaterThanXDirect(arr, 0, 20));

        System.out.println("Greater than 50 : "
                + countGreaterThanXDirect(arr, 0, 50));
    }
}

/*
=================================================
Problem : Count Greater Than X
Pattern : Conditional Counting
Folder  : E_Conditional_Counting
=================================================

Question

Count the number of elements
greater than x using recursion.

-------------------------------------------------

Example

Input

{5,12,8,20,25}

x = 10

Output

3

-------------------------------------------------

Faith

countGreaterThanX(arr, idx + 1, x)

returns

The number of elements
greater than x in the
remaining array.

-------------------------------------------------

Current Work

Check

arr[idx]

>

x

If true

add 1

otherwise

return recursive answer.

-------------------------------------------------

Generic Formula

int count =
countGreaterThanX(arr, idx + 1, x);

if(condition){

    return count + 1;

}

return count;

-------------------------------------------------

Algorithm

1. Reach the end of the array.

2. Trust recursion to count
   the remaining elements.

3. Check whether the current
   element is greater than x.

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

Current > X ?

↓

YES

Count + 1

↓

NO

Count

-------------------------------------------------

Pattern Recognition

Questions containing

* Count Greater Than X

* Numbers Larger Than X

* Count Elements Above Limit

↓

Think

Conditional Counting

-------------------------------------------------

Common Mistakes

- Using >= instead of >

- Wrong base case

- Forgetting recursive answer

- Returning 1 directly

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

* Filtering

* Frequency Counting

* Conditional Counting

* Statistics

=================================================
*/