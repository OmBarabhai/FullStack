package DSA.A_Recursion.Part_01.A_Pre_Post;

/*
=========================================================
        PROBLEM 06 : PRINT ODD NUMBERS (REVERSE)
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐⭐⭐☆

---------------------------------------------------------
Problem Statement

Print all odd numbers from N to 1 using recursion.

Example

Input

9

Output

9 7 5 3 1

---------------------------------------------------------
Core Idea

Current Work

↓

Recursive Call

Print first.

Then solve the smaller problem.

---------------------------------------------------------
Formula

if(current is odd)

↓

print current

↓

printOddNumbersRev(n-1)

---------------------------------------------------------
Base Case

if(n == 0){
    return;
}

---------------------------------------------------------
Algorithm

1. Check base case.

2. Check current number is odd.

3. Print current number.

4. Solve smaller problem.

=========================================================
*/

public class A6PrintOddNumbersRev {

    public static void printOddNumbersRev(int n){

        if(n == 0){
            return;
        }

        // Current Work

        if((n & 1) == 1){
            System.out.print(n + " ");
        }

        // Smaller Problem

        printOddNumbersRev(n - 1);

    }

    public static void main(String[] args){

        printOddNumbersRev(9);

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

printOddNumbersRev(9)

9 is odd

Print 9

↓

printOddNumbersRev(8)

8 is even

Skip

↓

printOddNumbersRev(7)

7 is odd

Print 7

↓

printOddNumbersRev(6)

Skip

↓

printOddNumbersRev(5)

Print 5

↓

printOddNumbersRev(4)

Skip

↓

printOddNumbersRev(3)

Print 3

↓

printOddNumbersRev(2)

Skip

↓

printOddNumbersRev(1)

Print 1

↓

printOddNumbersRev(0)

Base Case

return

---------------------------------------------------------
COMING UP

printOddNumbersRev(0)

↓

return

↑

printOddNumbersRev(1)

↓

return

↑

printOddNumbersRev(2)

↓

return

↑

printOddNumbersRev(3)

↓

return

↑

printOddNumbersRev(4)

↓

return

↑

printOddNumbersRev(5)

↓

return

↑

printOddNumbersRev(6)

↓

return

↑

printOddNumbersRev(7)

↓

return

↑

printOddNumbersRev(8)

↓

return

↑

printOddNumbersRev(9)

↓

return

↑

main()

---------------------------------------------------------
Output

9 7 5 3 1

=========================================================
                RECURSION TREE
=========================================================

printOddNumbersRev(9)
        |
        v
printOddNumbersRev(8)
        |
        v
printOddNumbersRev(7)
        |
        v
printOddNumbersRev(6)
        |
        v
printOddNumbersRev(5)
        |
        v
printOddNumbersRev(4)
        |
        v
printOddNumbersRev(3)
        |
        v
printOddNumbersRev(2)
        |
        v
printOddNumbersRev(1)
        |
        v
printOddNumbersRev(0)

return

=========================================================
                CALL STACK
=========================================================

PUSH

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

----------------------

POP

0

↓

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

=========================================================
Time Complexity

Every number from N to 0 is visited once.

Time

O(n)

=========================================================
Space Complexity

Recursive calls remain in the call stack.

Space

O(n)

=========================================================
Interview Questions

Q1. Why is this PRE ORDER?

Answer

Current work (printing)

happens BEFORE

recursive call.

---------------------------------------------------------

Q2. Why use (n & 1) == 1 ?

Answer

It checks whether n is odd.

It is equivalent to

n % 2 != 0

---------------------------------------------------------

Q3. Can we optimize this solution?

Answer

Yes.

Instead of checking every number,

we can jump directly by 2.

Example

9

↓

7

↓

5

↓

3

↓

1

This reduces the number of recursive calls,
although the recursion pattern remains the same.

---------------------------------------------------------

Q4. Why is the base case n == 0 ?

Answer

When n becomes 0,

there are no positive odd numbers left to print.

=========================================================
Common Mistakes

❌ Printing after recursion

Changes output to

1 3 5 7 9

-----------------------------------

❌ Forgetting base case

Causes infinite recursion.

-----------------------------------

❌ Calling

printOddNumbersRev(n)

instead of

printOddNumbersRev(n-1)

Infinite recursion.

-----------------------------------

❌ Writing

(n & 1) == 0

Prints even numbers.

=========================================================
Pattern Recognition

Question says

Print

↓

Current Work

↓

Recursive Call

Think

PRE ORDER

=========================================================
Revision Checklist

Date Solved

✅ 01-08-2026

Pattern

☐ PRE ORDER

Base Case

☐ Remembered

Dry Run

☐ Done

Recursion Tree

☐ Done

Call Stack

☐ Understood

Time Complexity

☐ Explained

Space Complexity

☐ Explained

Solved Without Notes

☐

Explained Without Notes

☐

Interview Ready

☐

=========================================================
*/