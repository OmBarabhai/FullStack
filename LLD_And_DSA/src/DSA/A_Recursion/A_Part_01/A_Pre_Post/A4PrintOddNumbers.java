package DSA.A_Recursion.A_Part_01.A_Pre_Post;

/*
=========================================================
            PROBLEM 04 : PRINT ODD NUMBERS
=========================================================

Date Started  : 01-08-2026
Pattern       : Pre- / Post-Order
Type          : POST ORDER
Difficulty    : 🟢 Easy
Interview     : ⭐⭐⭐⭐☆

---------------------------------------------------------
Problem Statement

Print all odd numbers from 1 to N using recursion.

Example

Input

9

Output

1 3 5 7 9

---------------------------------------------------------
Core Idea

This is still a POST ORDER problem.

The recursion pattern does not change.

Only the current work is conditional.

Pattern

Smaller Problem

↓

Current Work (if odd)

Formula

printOddNumbers(n-1)

↓

if(odd)

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

3. Check if current number is odd.

4. If yes, print it.

=========================================================
*/

public class A4PrintOddNumbers {

    public static void printOddNumbers(int n){

        if(n <= 0){
            return;
        }

        // Smaller Problem
        printOddNumbers(n-1);

        // Current Work
        if((n & 1) == 1){
            System.out.print(n + " ");
        }

    }

    public static void main(String[] args){

        printOddNumbers(9);

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

Print 1

↑

n = 2

Even

Don't Print

↑

n = 3

Odd

Print 3

↑

n = 4

Even

Don't Print

↑

n = 5

Odd

Print 5

↑

n = 6

Even

Don't Print

↑

n = 7

Odd

Print 7

↑

n = 8

Even

Don't Print

↑

n = 9

Odd

Print 9

---------------------------------------------------------
Final Output

1 3 5 7 9

=========================================================
                RECURSION TREE
=========================================================

printOddNumbers(9)
        |
        v
printOddNumbers(8)
        |
        v
printOddNumbers(7)
        |
        v
printOddNumbers(6)
        |
        v
printOddNumbers(5)
        |
        v
printOddNumbers(4)
        |
        v
printOddNumbers(3)
        |
        v
printOddNumbers(2)
        |
        v
printOddNumbers(1)
        |
        v
printOddNumbers(0)

return

↑

Print 1

↑

Skip 2

↑

Print 3

↑

Skip 4

↑

Print 5

↑

Skip 6

↑

Print 7

↑

Skip 8

↑

Print 9

=========================================================
                CALL STACK
=========================================================

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

(Call Stack)

=========================================================
Interview Questions

Q1. Why is this POST ORDER?

Answer

Because the recursive call
happens first.

Printing happens only while
returning.

---------------------------------------------------------

Q2. Does checking odd numbers
change the recursion pattern?

No.

Only the current work changes.

The recursion pattern remains
POST ORDER.

---------------------------------------------------------

Q3. How do we print

9 7 5 3 1 ?

Move

if((n&1)==1)

above

printOddNumbers(n-1)

It becomes PRE ORDER.

=========================================================
Common Mistakes

❌

Using

(n&1)==0

Prints even numbers.

-----------------------------------

❌

Printing before recursion

Output

9 7 5 3 1

-----------------------------------

❌

Calling

printOddNumbers(n)

Infinite recursion.

=========================================================
Pattern Recognition

Question says

Print

AFTER recursion

↓

POST ORDER

Condition

(even / odd)

does NOT change
the recursion pattern.

=========================================================
Pattern Comparison

PRE ORDER

Current Work

↓

Recursive Call

Output

9 7 5 3 1

-----------------------------------

POST ORDER

Recursive Call

↓

Current Work

Output

1 3 5 7 9

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