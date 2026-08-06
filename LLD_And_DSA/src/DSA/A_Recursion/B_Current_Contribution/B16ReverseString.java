package DSA.A_Recursion.B_Current_Contribution;

public class B16ReverseString {

    /*
     * =========================================
     * Solution 1 : Simple Recursion
     * Pattern : Current Contribution
     * Time  : O(n²)
     * Space : O(n)
     * =========================================
     */
    public static String reverseString(String str) {

        if (str.isEmpty()) {
            return "";
        }

        return reverseString(str.substring(1)) + str.charAt(0);
    }

    /*
     * =========================================
     * Solution 2 : Two Pointer Recursion
     * (Using Character Array)
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static void reverse(char[] arr, int left, int right) {

        if (left >= right) {
            return;
        }

        char temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left + 1, right - 1);
    }

    /*
     * =========================================
     * Solution 3 : Iterative
     * Time  : O(n)
     * Space : O(n)
     * =========================================
     */
    public static String reverseIterative(String str) {

        StringBuilder sb = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String str = "Om Rajput";

        System.out.println("Recursive          : " + reverseString(str));

        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        System.out.println("Two Pointer        : " + new String(arr));

        System.out.println("Iterative          : " + reverseIterative(str));
    }
}

/*
=================================================
Problem 16 : Reverse String
Pattern : Current Contribution
Folder : B_Current_Contribution
=================================================

Question
--------

Reverse a string using recursion.

Example
-------

Input

"Om Rajput"

Output

"tupjaR mO"

-------------------------------------------------
Approach
-------------------------------------------------

Current Contribution

+

Smaller Problem

Current Contribution

First Character

+

Smaller Problem

Reverse Remaining String

Formula

reverse(str)

=

reverse(str.substring(1))

+

str.charAt(0)

-------------------------------------------------
Dry Run
-------------------------------------------------

reverse("abc")

↓

reverse("bc") + 'a'

↓

reverse("c") + 'b' + 'a'

↓

reverse("") + 'c' + 'b' + 'a'

↓

"" + c + b + a

↓

"cba"

-------------------------------------------------
Returning Phase
-------------------------------------------------

reverse("")

""

↓

reverse("c")

"c"

↓

reverse("bc")

"cb"

↓

reverse("abc")

"cba"

-------------------------------------------------
Recursion Tree
-------------------------------------------------

reverse("abc")
│
└── reverse("bc")
      │
      └── reverse("c")
            │
            └── reverse("")
                  │
                  └── ""

Returning

↓

"c"

↓

"cb"

↓

"cba"

-------------------------------------------------
Pattern
-------------------------------------------------

Answer

=

Smaller Problem

+

Current Contribution

return reverseString(str.substring(1))
       + str.charAt(0);

-------------------------------------------------
Base Case
-------------------------------------------------

if (str.isEmpty())
    return "";

-------------------------------------------------
Complexities
-------------------------------------------------

Simple Recursion

Time  : O(n²)
Why is the Time Complexity O(n²)?

At first glance, it looks like the function makes only one recursive call at each level, so you might think the complexity should be O(n).

However, the expensive operation is not the recursion itself.

The expensive operation is:

str.substring(1)

Every recursive call creates a brand new String object.

-------------------------------------------------
What does substring(1) do?
-------------------------------------------------

Suppose

str = "abcdef"

Calling

str.substring(1)

creates

"bcdef"

The JVM copies the remaining characters into a new String.

This copy operation takes

O(length of remaining string)

-------------------------------------------------
Example
-------------------------------------------------

reverse("abcdef")

↓

substring creates

"bcdef"

Copies 5 characters

↓

reverse("bcdef")

↓

substring creates

"cdef"

Copies 4 characters

↓

reverse("cdef")

↓

Copies 3 characters

↓

reverse("def")

↓

Copies 2 characters

↓

reverse("ef")

↓

Copies 1 character

↓

reverse("f")

↓

Copies 0 characters

-------------------------------------------------
Total Work
-------------------------------------------------

Characters copied

5

+

4

+

3

+

2

+

1

+

0

=

15

For a string of length n

Work done

=

(n − 1)

+

(n − 2)

+

...

+

2

+

1

This sum is

n(n − 1) / 2

which simplifies to

O(n²)

-------------------------------------------------
Another Cost
-------------------------------------------------

This line

reverseString(str.substring(1)) + str.charAt(0)

also creates a new String while concatenating.

So each recursive return builds another new String object.

Therefore,

both

✔ substring()

and

✔ String concatenation (+)

increase the total running time.

-------------------------------------------------
Why is Space Complexity O(n)?
-------------------------------------------------

There are n recursive calls.

Each call waits for the next call to finish.

The recursive calls are stored on the Call Stack.

Example

reverse("abc")

↓

reverse("bc")

↓

reverse("c")

↓

reverse("")

Maximum stack depth = 4

Therefore

Space Complexity = O(n)

-------------------------------------------------
Can we optimize it?
-------------------------------------------------

Yes.

Instead of creating new String objects repeatedly,

convert the String into a character array

and swap characters from both ends.

Example

Input

"abcdef"

↓

Swap

a ↔ f

↓

Swap

b ↔ e

↓

Swap

c ↔ d

↓

Done

No substring()

No new String at every recursive call.

-------------------------------------------------
Optimized Complexity
-------------------------------------------------

Two Pointer Recursion

Time  : O(n)

Space : O(n)

Reason

Each character is visited only once.

No substring copying.

No repeated String creation.

-------------------------------------------------
Interview Insight
-------------------------------------------------

Many beginners think this solution is O(n)
because there is only one recursive call.

Interviewers expect you to notice that the hidden cost comes from

✔ substring()

✔ String concatenation (+)

These operations make the overall time complexity O(n²).

The optimized interview solution uses a character array with Two Pointer Recursion, reducing the time complexity to O(n).

Space : O(n)

Reason

substring() creates a new String
at every recursive call.


Two Pointer Recursion

Time  : O(n)

Space : O(n)

Iterative

Time  : O(n)

Space : O(n)

-------------------------------------------------
Interview Follow-up
-------------------------------------------------

Related Problems

✔ Reverse String (LeetCode 344)

✔ Reverse Words in a String

✔ Reverse Character Array

✔ Palindrome Check

✔ Reverse Vowels

✔ Reverse Every Word

-------------------------------------------------
Learning
-------------------------------------------------

✔ Current Contribution Pattern

✔ Smaller Problem First

✔ Returning Phase Builds Answer

✔ Introduction to String Recursion

✔ Two Pointer Recursion (Optimized)
*/