package DSA.A_Recursion.A_Part_01.A_Pre_Post;

/*
=========================================================
           PROBLEM 09 : PRINT MULTIPLES OF K
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐⭐☆☆

---------------------------------------------------------
Problem Statement

Print all multiples of K from N to 1 using recursion.

Example

Input

N = 30

K = 5

Output

30 25 20 15 10 5

---------------------------------------------------------
Core Idea

Current Work

↓

Recursive Call

Print current number if it is divisible by K.

Then solve the smaller problem.

---------------------------------------------------------
Formula

if(current % k == 0)

↓

Print Current Number

↓

printMultiplesOfK(n-1, k)

---------------------------------------------------------
Base Case

if(n == 0){
    return;
}

---------------------------------------------------------
Algorithm

1. Check the base case.
2. Check whether the current number is a multiple of K.
3. Print the current number if true.
4. Solve the smaller problem.

=========================================================
*/

public class A9PrintMultiplesOfK {

    public static void printMultiplesOfK(int n, int k){

        // Base Case
        if(n == 0){
            return;
        }

        // Current Work
        if(n % k == 0){
            System.out.print(n + " ");
        }

        // Smaller Problem
        printMultiplesOfK(n - 1, k);

    }

    public static void main(String[] args){

        printMultiplesOfK(30, 5);

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

n = 30

k = 5

---------------------------------------------------------
GOING DOWN

main()

↓

printMultiplesOfK(30,5)

30 % 5 == 0

Print 30

↓

printMultiplesOfK(29,5)

29 % 5 != 0

Skip

↓

printMultiplesOfK(28,5)

Skip

↓

...

↓

printMultiplesOfK(25,5)

25 % 5 == 0

Print 25

↓

...

↓

20

Print 20

↓

...

↓

15

Print 15

↓

...

↓

10

Print 10

↓

...

↓

5

Print 5

↓

printMultiplesOfK(0,5)

Base Case

return

---------------------------------------------------------
COMING UP

printMultiplesOfK(0)

↓

return

↑

5

↓

return

↑

6

↓

return

↑

...

↑

29

↓

return

↑

30

↓

return

↑

main()

---------------------------------------------------------
Output

30 25 20 15 10 5

=========================================================
                RECURSION TREE
=========================================================

printMultiplesOfK(30)
            |
            v
printMultiplesOfK(29)
            |
            v
printMultiplesOfK(28)
            |
            v
...
            |
            v
printMultiplesOfK(2)
            |
            v
printMultiplesOfK(1)
            |
            v
printMultiplesOfK(0)

return

=========================================================
                CALL STACK
=========================================================

PUSH

30

↓

29

↓

28

↓

...

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

...

↓

28

↓

29

↓

30

=========================================================
Time Complexity

Every number from N to 1 is checked once.

Time

O(n)

=========================================================
Space Complexity

Maximum recursion depth is N.

Space

O(n)

=========================================================
Modulo (%) Explanation

A number is a multiple of K

if dividing it by K

leaves remainder 0.

Example

30 % 5 = 0

↓

30 is a multiple of 5

-----------------------------------

22 % 5 = 2

↓

22 is NOT a multiple of 5

=========================================================
Interview Questions

Q1. Why is this PRE ORDER?

Answer

Current work (printing)

happens BEFORE

the recursive call.

---------------------------------------------------------

Q2. Why use

n % k == 0 ?

Answer

Because every multiple of K

leaves remainder 0

when divided by K.

---------------------------------------------------------

Q3. Can this be optimized?

Answer

Yes.

Current solution checks

every number.

30

↓

29

↓

28

↓

...

↓

1

Instead,

start from the largest multiple of K

and jump by K.

30

↓

25

↓

20

↓

15

↓

10

↓

5

This reduces the number of recursive calls.

---------------------------------------------------------

Q4. What if

n < k ?

Answer

No positive multiple of K exists.

The recursion simply reaches the base case.

=========================================================
Common Mistakes

❌ Forgetting the base case

Causes infinite recursion.

-----------------------------------

❌ Writing

n % k == 1

instead of

n % k == 0

Prints incorrect numbers.

-----------------------------------

❌ Printing after recursion

Output becomes

5 10 15 20 25 30

instead of

30 25 20 15 10 5

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

✅  PRE ORDER

Base Case

✅  Remembered

Dry Run

✅  Done

Recursion Tree

✅  Done

Call Stack

✅  Understood

Time Complexity

✅  Explained

Space Complexity

✅  Explained

Solved Without Notes

✅

Explained Without Notes

✅

Interview Ready

✅

=========================================================
*/