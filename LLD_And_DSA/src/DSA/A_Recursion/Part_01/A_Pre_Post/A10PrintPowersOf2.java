package DSA.A_Recursion.Part_01.A_Pre_Post;

/*
=========================================================
           PROBLEM 10 : PRINT POWERS OF 2
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐☆☆☆

---------------------------------------------------------
Problem Statement

Print all powers of 2 from 2⁰ to 2ⁿ
using recursion.

Example

Input

n = 4

Output

1 2 4 8 16

---------------------------------------------------------
Core Idea

Current Work

↓

Recursive Call

Print the current power.

Then generate the next power.

---------------------------------------------------------
Formula

Print Current Power

↓

printPowersOf2(currentPower × 2,
               currentExponent + 1,
               maxExponent)

---------------------------------------------------------
Parameters

currentPower

Current value of 2^x

-----------------------------------

currentExponent

Current exponent

-----------------------------------

maxExponent

Last exponent to print

---------------------------------------------------------
Base Case

if(currentExponent > maxExponent){
    return;
}

---------------------------------------------------------
Algorithm

1. Check the base case.
2. Print current power.
3. Multiply current power by 2.
4. Increase exponent.
5. Solve the smaller problem.

=========================================================
*/

public class A10PrintPowersOf2 {

    public static void printPowersOf2(int currentPower,
                                      int currentExponent,
                                      int maxExponent){

        // Base Case
        if(currentExponent > maxExponent){
            return;
        }

        // Current Work
        System.out.print(currentPower + " ");

        // Smaller Problem
        printPowersOf2(
                currentPower * 2,
                currentExponent + 1,
                maxExponent
        );
        // currentPower 1 2 4 8 16 32  // currentExponent 1 2 3 4 5  return

    }

    public static void main(String[] args){
        printPowersOf2(1,0,4);
    }

}

/*
=========================================================
                UNDERSTANDING PARAMETERS
=========================================================

currentPower

Stores the current power of 2.

Example

1

↓

2

↓

4

↓

8

↓

16

---------------------------------------------------------

currentExponent

Stores which exponent we are printing.

0

↓

1

↓

2

↓

3

↓

4

---------------------------------------------------------

maxExponent

Maximum exponent allowed.

Example

maxExponent = 4

Means print

2⁰

2¹

2²

2³

2⁴

=========================================================
                    DRY RUN
=========================================================

Function Call

printPowersOf2(1,0,4)

---------------------------------------------------------

Call 1

currentPower = 1

currentExponent = 0

maxExponent = 4

0 > 4 ?

No

Print

1

↓

Recursive Call

printPowersOf2(2,1,4)

---------------------------------------------------------

Call 2

currentPower = 2

currentExponent = 1

1 > 4 ?

No

Print

2

↓

Recursive Call

printPowersOf2(4,2,4)

---------------------------------------------------------

Call 3

currentPower = 4

currentExponent = 2

Print

4

↓

Recursive Call

printPowersOf2(8,3,4)

---------------------------------------------------------

Call 4

currentPower = 8

currentExponent = 3

Print

8

↓

Recursive Call

printPowersOf2(16,4,4)

---------------------------------------------------------

Call 5

currentPower = 16

currentExponent = 4

Print

16

↓

Recursive Call

printPowersOf2(32,5,4)

---------------------------------------------------------

Call 6

currentPower = 32

currentExponent = 5

5 > 4

YES

return

=========================================================
GOING DOWN

print(1,0)

↓

print(2,1)

↓

print(4,2)

↓

print(8,3)

↓

print(16,4)

↓

print(32,5)

Base Case

=========================================================
COMING UP

return

↑

return

↑

return

↑

return

↑

return

↑

main()

Nothing is printed while returning because
printing already happened before recursion.

=========================================================
RECURSION TREE
=========================================================

print(1,0)
      |
      v
print(2,1)
      |
      v
print(4,2)
      |
      v
print(8,3)
      |
      v
print(16,4)
      |
      v
print(32,5)

return

=========================================================
CALL STACK
=========================================================

PUSH

(1,0)

↓

(2,1)

↓

(4,2)

↓

(8,3)

↓

(16,4)

↓

(32,5)

------------------------

POP

(32,5)

↓

(16,4)

↓

(8,3)

↓

(4,2)

↓

(2,1)

↓

(1,0)

=========================================================
OUTPUT

1 2 4 8 16

=========================================================
Time Complexity

One recursive call for every exponent.

Time

O(n)

=========================================================
Space Complexity

Maximum recursion depth = n + 1

Space

O(n)

=========================================================
Interview Questions

Q1. Why do we need currentExponent?

Answer

currentPower alone cannot tell us
which exponent we are printing.

Example

16

Could be

2⁴

We need currentExponent to know
when to stop recursion.

---------------------------------------------------------

Q2. Why multiply by 2?

Every next power is

Previous Power × 2

1

↓

2

↓

4

↓

8

↓

16

---------------------------------------------------------

Q3. Why is this PRE ORDER?

Because printing happens

BEFORE

the recursive call.

=========================================================
Common Mistakes

❌ Using

if(currentPower > maxExponent)

Wrong

We must compare exponents,
not powers.

-----------------------------------

❌ Forgetting

currentExponent + 1

Recursion never reaches the base case.

-----------------------------------

❌ Multiplying by anything other than 2

Sequence becomes incorrect.

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