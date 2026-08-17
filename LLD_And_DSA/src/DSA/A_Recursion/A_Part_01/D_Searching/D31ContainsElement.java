package DSA.A_Recursion.A_Part_01.D_Searching;

public class D31ContainsElement {

    /*
     * =========================================
     * Problem : Contains Element
     * Pattern : Recursive Searching
     * Folder  : D_Searching
     *
     * Faith:
     * containsElement(arr, idx + 1, target)
     * tells whether the target exists
     * in the remaining array.
     *
     * Current Work:
     * Check whether the current
     * element is equal to the target.
     *
     * Formula
     *
     * if(arr[idx] == target)
     *     return true;
     *
     * return containsElement(arr, idx + 1, target);
     *
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */

    public static boolean containsElement(int[] arr, int idx, int target) {

        // Base Case
        if (idx == arr.length) {
            return false;
        }

        // Current Check
        if (arr[idx] == target) {
            return true;
        }

        // Recursive Search
        return containsElement(arr, idx + 1, target);
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 99, 3, 21, -777};

        System.out.println("Contains 3   : " + containsElement(arr, 0, 3));

        System.out.println("Contains 100 : " + containsElement(arr, 0, 100));
    }
}

/*
=================================================
Problem : Contains Element
Pattern : Recursive Searching
Folder  : D_Searching
=================================================

Question

Check whether a target element
exists in the array using recursion.

-------------------------------------------------

Example

Input

Array

{1,2,3,4,99,3,21,-777}

Target

3

Output

true

-------------------------------------------------

Faith

containsElement(arr, idx + 1, target)

returns

Whether the target exists in the
remaining array.

-------------------------------------------------

Current Work

Compare

arr[idx]

with

target

-------------------------------------------------

Formula

if(arr[idx] == target)
    return true;

return containsElement(arr, idx + 1, target);

-------------------------------------------------

Dry Run

Array

{1,2,3,4}

Target

3

↓

containsElement(0)

↓

Check

1 == 3

↓

No

↓

containsElement(1)

↓

Check

2 == 3

↓

No

↓

containsElement(2)

↓

Check

3 == 3

↓

Yes

↓

return true

-------------------------------------------------

Recursion Tree

containsElement(0)
│
└──containsElement(1)
     │
     └──containsElement(2)
          │
          └──return true

-------------------------------------------------

Returning Phase

containsElement(2)

↓

return true

↑

containsElement(1)

↓

return true

↑

containsElement(0)

↓

return true

-------------------------------------------------

Algorithm

1. Check the base case.

2. Compare the current element
   with the target.

3. If found, return true.

4. Otherwise, trust recursion
   to search the remaining array.

-------------------------------------------------

Mental Model

I do NOT search the entire array.

I check only the current element.

If it is not the answer,

I trust recursion to search
the remaining array.

-------------------------------------------------

Common Mistakes

❌ Wrong base case.

❌ Forgetting to check the
   current element.

❌ Returning false before
   checking every element.

❌ Forgetting to return the
   recursive call.

-------------------------------------------------

Pattern Recognition

Questions containing

✓ Contains

✓ Search

✓ Exists

✓ Find

↓

Think

Recursive Searching

-------------------------------------------------

Time Complexity

O(n)

-------------------------------------------------

Space Complexity

O(n)

(Call Stack)

-------------------------------------------------

Interview Uses

✓ Contains Element

✓ Linear Search

✓ Recursive Search

✓ Tree Search

✓ Graph DFS

=================================================
*/