package DSA.A_Recursion.A_Part_01.A_Pre_Post;

/*
=========================================================
                PROBLEM 01 : PRINT 1 TO N
=========================================================

Date Started  : 01-08-2026
Pattern       : Pre / Post Order
Type          : POST ORDER
Difficulty    : 🟢 Easy
Interview     : ⭐⭐⭐⭐⭐

---------------------------------------------------------
Problem Statement

Print numbers from 1 to N using recursion.

Example

Input
6

Output
1 2 3 4 5 6

---------------------------------------------------------
Core Idea

Current Work

↓

AFTER recursion

Therefore

POST ORDER

Formula

print1ToN(n-1)

↓

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

3. Print current number.

=========================================================
*/

public class A2Print1ToN {

    public static void print1ToN(int n){

        if(n <= 0){
            return;
        }

        // Smaller Problem
        print1ToN(n-1);

        // Current Work
        System.out.print(n + " ");

    }

    public static void main(String[] args){

        print1ToN(6);

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

n = 6

---------------------------------------------------------
GOING DOWN (Recursive Calls)

main()

↓

print1ToN(6)

↓

print1ToN(5)

↓

print1ToN(4)

↓

print1ToN(3)

↓

print1ToN(2)

↓

print1ToN(1)

↓

print1ToN(0)

---------------------------------------------------------
BASE CASE

n <= 0

return

No printing happens here.

---------------------------------------------------------
COMING UP (Returning)

print1ToN(1)

↓

print 1

↑

print1ToN(2)

↓

print 2

↑

print1ToN(3)

↓

print 3

↑

print1ToN(4)

↓

print 4

↑

print1ToN(5)

↓

print 5

↑

print1ToN(6)

↓

print 6

---------------------------------------------------------
Final Output

1 2 3 4 5 6

=========================================================
                RECURSION TREE
=========================================================

print1ToN(6)
      |
      v
print1ToN(5)
      |
      v
print1ToN(4)
      |
      v
print1ToN(3)
      |
      v
print1ToN(2)
      |
      v
print1ToN(1)
      |
      v
print1ToN(0)

return

↑

1

↑

2

↑

3

↑

4

↑

5

↑

6

=========================================================
                CALL STACK
=========================================================

PUSH

main()

↓

print1ToN(6)

↓

print1ToN(5)

↓

print1ToN(4)

↓

print1ToN(3)

↓

print1ToN(2)

↓

print1ToN(1)

↓

print1ToN(0)

-------------------------

POP

print1ToN(1)

↓

print1ToN(2)

↓

print1ToN(3)

↓

print1ToN(4)

↓

print1ToN(5)

↓

print1ToN(6)

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

Because printing happens
AFTER the recursive call.

---------------------------------------------------------

Q2. Why is the base case n <= 0 ?

Because there are no numbers
left to print.

Using <= also safely handles
negative input.

---------------------------------------------------------

Q3. Why doesn't 6 print first?

Because recursion keeps calling
smaller problems until the
base case is reached.

Printing starts only while
returning.

=========================================================
Common Mistakes

❌ Printing before recursion

Output

6 5 4 3 2 1

-----------------------------------

❌ Wrong base case

if(n==1)

1 never gets printed.

-----------------------------------

❌ Calling

print1ToN(n)

Infinite recursion

StackOverflowError

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