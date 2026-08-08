package DSA.A_Recursion.Part_01.A_Pre_Post;

/*
=========================================================
            PROBLEM 03 : PRINT EVEN NUMBERS
=========================================================

Date Started  : 01-08-2026
Pattern       : Pre- / Post-Order
Type          : POST ORDER
Difficulty    : 🟢 Easy
Interview     : ⭐⭐⭐⭐☆

---------------------------------------------------------

 (n & 1) checks the last bit of the binary number.

 Odd Number  -> Last bit is 1
 Even Number -> Last bit is 0

 (n & 1) == 1  -> Odd Number
 (n & 1) != 1  -> Even Number

 Example

 5 = 0101
 1 = 0001
 ------------
 & = 0001

 Result = 1 (Odd)

 8 = 1000
 1 = 0001
 ------------
 & = 0000

 Result = 0 (Even)

----------------------------------------------------------

Problem Statement

Print all even numbers from 1 to N using recursion.

Example

Input

9

Output

2 4 6 8

---------------------------------------------------------
Core Idea

This is NOT an "Even Number" problem.

It is still a POST ORDER problem.

Only the current work is performed
conditionally.

Pattern

Smaller Problem

↓

Current Work (if even)

Formula

printEvenNumbers(n-1)

↓

if(even)

print(n)

---------------------------------------------------------
Base Case

if(n <= 0){
    return;
}

---------------------------------------------------------
Algorithm

1. Check base case.

2. Solve smaller problem.

3. Check whether current number is even.

4. If yes, print it.

=========================================================
*/

public class A3PrintEvenNumbers {

    public static void printEvenNumbers(int n){

        if(n <= 0){
            return;
        }

        // Smaller Problem
        printEvenNumbers(n-1);

        // Current Work
        if((n & 1) == 0){
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args){

        printEvenNumbers(9);

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

n = 9

---------------------------------------------------------
GOING DOWN

main()

↓

9

↓

8

↓

7

↓

6

↓

5

↓

4

↓

3

↓

2

↓

1

↓

0

---------------------------------------------------------
BASE CASE

n <= 0

return

---------------------------------------------------------
COMING UP

n = 1

Odd

Don't Print

↑

n = 2

Even

Print 2

↑

n = 3

Odd

Don't Print

↑

n = 4

Even

Print 4

↑

n = 5

Odd

Don't Print

↑

n = 6

Even

Print 6

↑

n = 7

Odd

Don't Print

↑

n = 8

Even

Print 8

↑

n = 9

Odd

Don't Print

---------------------------------------------------------
Output

2 4 6 8

=========================================================
Recursion Tree

printEvenNumbers(9)
        |
        v
printEvenNumbers(8)
        |
        v
printEvenNumbers(7)
        |
        v
printEvenNumbers(6)
        |
        v
printEvenNumbers(5)
        |
        v
printEvenNumbers(4)
        |
        v
printEvenNumbers(3)
        |
        v
printEvenNumbers(2)
        |
        v
printEvenNumbers(1)
        |
        v
printEvenNumbers(0)

return

↑

Check Odd

↑

Print 2

↑

Check Odd

↑

Print 4

↑

Check Odd

↑

Print 6

↑

Check Odd

↑

Print 8

↑

Check Odd

=========================================================
Call Stack

PUSH

main()

↓

9

↓

8

↓

7

↓

6

↓

5

↓

4

↓

3

↓

2

↓

1

↓

0

-------------------------

POP

1

↓

2

↓

3

↓

4

↓

5

↓

6

↓

7

↓

8

↓

9

↓

main()

=========================================================
Time Complexity

O(n)

=========================================================
Space Complexity

O(n)

=========================================================
Interview Questions

Q1. Why is this still POST ORDER?

Answer

Because recursion happens first.

Printing happens while returning.

---------------------------------------------------------

Q2. Does checking even numbers change the recursion pattern?

No.

Only the current work changes.

The recursion pattern remains POST ORDER.

---------------------------------------------------------

Q3. Can this be solved using PRE ORDER?

Yes.

Move

if((n & 1)==0)

above

printEvenNumbers(n-1)

Output will still be

2 4 6 8

because odd numbers are skipped.

=========================================================
Common Mistakes

❌

if(n==0)

instead of

n<=0

-----------------------------------

❌

printEvenNumbers(n);

Infinite recursion.

-----------------------------------

❌

Using

n%2==1

instead of

n%2==0

=========================================================
Pattern Recognition

Question says

Print

AFTER recursion

↓

POST ORDER

The condition (even/odd)

does NOT change the pattern.

=========================================================
Revision Checklist

Date Solved

✅ 01-08-2026

Pattern

✅  Remembered

Base Case

✅  Remembered

Dry Run

✅  Done

Recursion Tree

✅  Done

Call Stack

✅  Understood

Solved Without Notes

✅  Done

Explained Without Notes

✅  Done

Variation Solved

✅  Done

Interview Ready

✅  Done

=========================================================
*/