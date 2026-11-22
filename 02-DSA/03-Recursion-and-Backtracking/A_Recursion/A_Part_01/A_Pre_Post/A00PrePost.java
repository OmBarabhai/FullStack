package DSA.A_Recursion.A_Part_01.A_Pre_Post;

/*
=========================================================
           PATTERN 01 : EXECUTION ORDER
              (PRE ORDER & POST ORDER)
=========================================================

Definition
----------
Execution Order tells us WHEN the current work is performed
relative to the recursive call.

Every recursive problem follows one of these two patterns.

---------------------------------------------------------

Pattern 1 : PRE ORDER

Current Work
      ↓
Recursive Call

---------------------------------------------------------

Pattern 2 : POST ORDER

Recursive Call
      ↓
Current Work

=========================================================

Execution Flow

GOING DOWN

↓

Recursive Calls

↓

Base Case

↓

COMING BACK

↓

Returning Phase

↓

Function Ends

---------------------------------------------------------

Remember

Pre Order
---------
Work while GOING DOWN.

Post Order
----------
Work while COMING BACK.

=========================================================

Recognition

If the question contains

✓ Print
✓ Display
✓ Visit
✓ Traverse
✓ Reverse Print

Immediately think

PRE ORDER

or

POST ORDER

=========================================================

Used In

✓ Basic Printing Problems
✓ Tree Traversals
✓ DFS
✓ Graph Traversal
✓ Backtracking
✓ Recursive Faith
✓ Current Contribution
✓ Divide & Conquer
✓ Dynamic Programming

=========================================================
*/

public class A00PrePost {

    /*
    =========================================================
    Problem 1 : Print N to 1

    Pattern
    -------
    PRE ORDER

    Formula
    -------
    print(n)

    recursion(n-1)

    Dry Run

    print(4)

    Print 4

       ↓

    print(3)

    Print 3

       ↓

    print(2)

    Print 2

       ↓

    print(1)

    Print 1

       ↓

    Stop

    Output

    4 3 2 1

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static void printNto1(int n){

        if(n==0){
            return;
        }

        System.out.print(n + " ");

        printNto1(n-1);
    }

    /*
    =========================================================
    Problem 2 : Print 1 to N

    Pattern
    -------
    POST ORDER

    Formula
    -------
    recursion(n-1)

    print(n)

    Dry Run

    print(4)

       ↓

    print(3)

       ↓

    print(2)

       ↓

    print(1)

       ↓

    Stop

       ↑

    Print 1

       ↑

    Print 2

       ↑

    Print 3

       ↑

    Print 4

    Output

    1 2 3 4

    Time  : O(n)

    Space : O(n)

    =========================================================
    */

    public static void print1toN(int n){

        if(n==0){
            return;
        }

        print1toN(n-1);

        System.out.print(n + " ");
    }

    /*
    =========================================================
    Problem 3 : Print Elements at Even Index

    Pattern
    -------
    PRE ORDER

    Formula
    -------
    print(arr[idx])

    recursion(idx+2)

    =========================================================
    */

    public static void printEvenIndex(int[] arr,int idx){

        if(idx>=arr.length){
            return;
        }

        System.out.print(arr[idx]+" ");

        printEvenIndex(arr,idx+2);
    }

    /*
    =========================================================
    Problem 4 : Print Elements at Even Index Reverse

    Pattern
    -------
    POST ORDER

    Formula
    -------
    recursion(idx+2)

    print(arr[idx])

    =========================================================
    */

    public static void printEvenIndexReverse(int[] arr,int idx){

        if(idx>=arr.length){
            return;
        }

        printEvenIndexReverse(arr,idx+2);

        System.out.print(arr[idx]+" ");
    }

    /*
    =========================================================

                    PRE vs POST

    ---------------------------------------------------------

    PRE ORDER

    Current Work

          ↓

    Recursive Call

    Output

    N → 1

    Examples

    ✓ Print N to 1
    ✓ Print Even Numbers
    ✓ Print Odd Numbers
    ✓ Print Alphabet A → Z
    ✓ Print Multiples Of K
    ✓ Print Powers Of 2

    ---------------------------------------------------------

    POST ORDER

    Recursive Call

          ↓

    Current Work

    Output

    1 → N

    Examples

    ✓ Print 1 to N
    ✓ Print Even Numbers Reverse
    ✓ Print Odd Numbers Reverse
    ✓ Print Alphabet Z → A

    =========================================================

    Common Mistakes

    ❌ Printing before recursion instead of after.

    ❌ Missing base case.

    ❌ Forgetting return.

    ❌ Thinking recursion executes immediately.

    ---------------------------------------------------------

    Time Complexity

    O(n)

    ---------------------------------------------------------

    Space Complexity

    O(n)

    (Call Stack)

    ---------------------------------------------------------

    Interview Uses

    ✓ Binary Tree Traversals

    ✓ DFS

    ✓ Graph Traversal

    ✓ Backtracking

    ✓ Maze Problems

    ✓ Current Contribution

    ✓ Recursive Faith

    ✓ Divide & Conquer

    ✓ Dynamic Programming

    ---------------------------------------------------------

    Golden Rule

    BEFORE recursion

        =

    PRE ORDER

    ----------------------------

    AFTER recursion

        =

    POST ORDER

    ----------------------------

    Every recursion problem first

    GOES DOWN

    then

    COMES BACK.

    Understanding these two phases
    makes every future recursion
    pattern much easier.

    =========================================================
    */

    public static void main(String[] args){

        int[] arr = {10,20,30,40,50,60,70};

        System.out.println("Print N to 1");
        printNto1(5);

        System.out.println("\n");

        System.out.println("Print 1 to N");
        print1toN(5);

        System.out.println("\n");

        System.out.println("Print Even Index");
        printEvenIndex(arr,0);

        System.out.println("\n");

        System.out.println("Print Even Index Reverse");
        printEvenIndexReverse(arr,0);
    }
}