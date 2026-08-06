package DSA.A_Recursion.A_Pre_Post;

/*
=========================================================
                PROBLEM 02 : PRINT N TO 1
=========================================================

Date Started  : 01-08-2026
Pattern       : Pre / Post Order
Type          : PRE ORDER
Difficulty    : 🟢 Easy
Interview     : ⭐⭐⭐⭐⭐

---------------------------------------------------------
Problem Statement

Print numbers from N to 1 using recursion.

Example

Input

4

Output

4 3 2 1

---------------------------------------------------------
Core Idea

Current Work

↓

BEFORE recursion

↓

Smaller Problem

Therefore

PRE ORDER

Formula

print(n)

↓

printNTo1(n-1)

---------------------------------------------------------
Base Case

if(n <= 0){
    return;
}

---------------------------------------------------------
Algorithm

1. Check base case.

2. Print current number.

3. Solve smaller problem.

=========================================================
*/

public class A1PrintNTo1 {

    public static void printNTo1(int n){

        if(n <= 0){
            return;
        }

        // Current Work
        System.out.print(n + " ");

        // Smaller Problem
        printNTo1(n - 1);

    }

    public static void main(String[] args){

        printNTo1(4);

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

n = 4

---------------------------------------------------------
GOING DOWN (Recursive Calls)

main()

↓

printNTo1(4)

Print 4

↓

printNTo1(3)

Print 3

↓

printNTo1(2)

Print 2

↓

printNTo1(1)

Print 1

↓

printNTo1(0)

---------------------------------------------------------
BASE CASE

n <= 0

return

No printing happens here.

---------------------------------------------------------
COMING UP (Returning)

printNTo1(1)

↓

return

↑

printNTo1(2)

↓

return

↑

printNTo1(3)

↓

return

↑

printNTo1(4)

↓

return

↑

main()

---------------------------------------------------------
Final Output

4 3 2 1

=========================================================
                RECURSION TREE
=========================================================

printNTo1(4)
      |
      v
printNTo1(3)
      |
      v
printNTo1(2)
      |
      v
printNTo1(1)
      |
      v
printNTo1(0)

return

↑

return

↑

return

↑

return

↑

return

=========================================================
                CALL STACK
=========================================================

PUSH

main()

↓

printNTo1(4)

↓

printNTo1(3)

↓

printNTo1(2)

↓

printNTo1(1)

↓

printNTo1(0)

-------------------------

POP

printNTo1(1)

↓

printNTo1(2)

↓

printNTo1(3)

↓

printNTo1(4)

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

Q1. Why is this PRE ORDER?

Answer

Because the current work
(printing)

happens BEFORE

the recursive call.

---------------------------------------------------------

Q2. Why doesn't it print while returning?

Because printing has already
been completed before the
recursive call.

Returning only removes stack
frames.

---------------------------------------------------------

Q3. What happens if we move

System.out.print()

below

printNTo1(n-1)?

Answer

It becomes POST ORDER.

Output

1 2 3 4

---------------------------------------------------------

Q4. Why use n <= 0 instead of n == 0?

Using

n <= 0

also safely handles
negative input and prevents
infinite recursion.

=========================================================
Common Mistakes

❌

printNTo1(n);

Infinite recursion

-----------------------------------

❌

Printing after recursion

Output

1 2 3 4

-----------------------------------

❌

Missing base case

StackOverflowError

=========================================================
Pattern Recognition

If

Current Work

↓

Recursive Call

Think

PRE ORDER

---------------------------------------------------------

Remember

BEFORE recursion

=

Forward Order

=========================================================
Comparison

PRE ORDER

Current Work

↓

Recursive Call

Output

4 3 2 1

-----------------------------------

POST ORDER

Recursive Call

↓

Current Work

Output

1 2 3 4

=========================================================
Revision Checklist

Date Solved

✅ 01-08-2026

Pattern

☐ Remembered

Base Case

☐ Remembered

Dry Run

☐ Done

Recursion Tree

☐ Done

Call Stack

☐ Understood

Solved Without Notes

☐ Done

Explained Without Notes

☐ Done
Variation Solved

☐ Done

Interview Ready

☐ Done

=========================================================
*/