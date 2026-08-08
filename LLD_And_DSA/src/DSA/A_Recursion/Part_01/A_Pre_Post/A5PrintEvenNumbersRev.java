package DSA.A_Recursion.Part_01.A_Pre_Post;

/*
=========================================================
        PROBLEM 05 : PRINT EVEN NUMBERS (REVERSE)
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐⭐⭐☆

---------------------------------------------------------
Problem Statement

Print all even numbers from N to 1 using recursion.

Example

Input

9

Output

8 6 4 2

---------------------------------------------------------
Core Idea

Current Work

↓

Recursive Call

Print first.

Then solve the smaller problem.

---------------------------------------------------------
Formula

if(current is even)

↓

print current

↓

printEvenNumbersRev(n-1)

---------------------------------------------------------
Base Case

if(n == 0){
    return;
}

---------------------------------------------------------
Algorithm

1. Check base case.

2. Check current number is even.

3. Print current number.

4. Solve smaller problem.

=========================================================
*/

public class A5PrintEvenNumbersRev {

    public static void printEvenNumbersRev(int n){

        if(n == 0){
            return;
        }

        // Current Work

        if((n & 1) == 0){
            System.out.print(n + " ");
        }

        // Smaller Problem

        printEvenNumbersRev(n - 1);

    }

    public static void main(String[] args){

        printEvenNumbersRev(9);

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

printEvenNumbersRev(9)

9 is odd

Skip

↓

printEvenNumbersRev(8)

8 is even

Print 8

↓

printEvenNumbersRev(7)

7 is odd

Skip

↓

printEvenNumbersRev(6)

6 is even

Print 6

↓

printEvenNumbersRev(5)

5 is odd

Skip

↓

printEvenNumbersRev(4)

4 is even

Print 4

↓

printEvenNumbersRev(3)

3 is odd

Skip

↓

printEvenNumbersRev(2)

2 is even

Print 2

↓

printEvenNumbersRev(1)

1 is odd

Skip

↓

printEvenNumbersRev(0)

Base Case

return

---------------------------------------------------------
COMING UP

printEvenNumbersRev(0)

↓

return

↑

printEvenNumbersRev(1)

↓

return

↑

printEvenNumbersRev(2)

↓

return

↑

printEvenNumbersRev(3)

↓

return

↑

printEvenNumbersRev(4)

↓

return

↑

printEvenNumbersRev(5)

↓

return

↑

printEvenNumbersRev(6)

↓

return

↑

printEvenNumbersRev(7)

↓

return

↑

printEvenNumbersRev(8)

↓

return

↑

printEvenNumbersRev(9)

↓

return

↑

main()

---------------------------------------------------------
Output

8 6 4 2

=========================================================
                RECURSION TREE
=========================================================

printEvenNumbersRev(9)
          |
          v
printEvenNumbersRev(8)
          |
          v
printEvenNumbersRev(7)
          |
          v
printEvenNumbersRev(6)
          |
          v
printEvenNumbersRev(5)
          |
          v
printEvenNumbersRev(4)
          |
          v
printEvenNumbersRev(3)
          |
          v
printEvenNumbersRev(2)
          |
          v
printEvenNumbersRev(1)
          |
          v
printEvenNumbersRev(0)

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

Q2. Why use (n & 1) == 0 ?

Answer

It checks whether n is even.

It is equivalent to

n % 2 == 0

---------------------------------------------------------

Q3. Can we optimize this solution?

Answer

Yes.

Instead of checking every number,

we can jump directly by 2.

Example

8

↓

6

↓

4

↓

2

This reduces the number of recursive calls,
although the recursion pattern remains the same.

---------------------------------------------------------

Q4. Why is the base case n == 0 ?

Answer

When n becomes 0,

there are no positive even numbers left to print.

=========================================================
Common Mistakes

❌ Printing after recursion

Changes output to

2 4 6 8

-----------------------------------

❌ Forgetting base case

Causes infinite recursion.

-----------------------------------

❌ Calling

printEvenNumbersRev(n)

instead of

printEvenNumbersRev(n-1)

Infinite recursion.

-----------------------------------

❌ Writing

(n & 1) == 1

Prints odd numbers.

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

☐ Done

Explained Without Notes

☐ Done

Interview Ready

☐ Done

=========================================================
*/