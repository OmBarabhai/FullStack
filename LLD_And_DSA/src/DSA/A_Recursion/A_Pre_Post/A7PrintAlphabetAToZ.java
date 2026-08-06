package DSA.A_Recursion.A_Pre_Post;

/*
=========================================================
           PROBLEM 07 : PRINT ALPHABET A TO Z
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐⭐☆☆

---------------------------------------------------------
Problem Statement

Print all uppercase English alphabets from
A to Z using recursion.

Example

Input

A

Output

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

---------------------------------------------------------
Core Idea

Current Work

↓

Recursive Call

Print the current alphabet first.

Then solve the smaller problem.

---------------------------------------------------------
Formula

Print Current Character

↓

printAlphabetAToZ(nextCharacter)

---------------------------------------------------------
Base Case

if(ch > 'Z'){
    return;
}

---------------------------------------------------------
Algorithm

1. Check the base case.
2. Print the current alphabet.
3. Move to the next alphabet.
4. Repeat until 'Z'.

=========================================================
*/

public class A7PrintAlphabetAToZ {

    public static void printAlphabetAToZ(char ch){

        // Base Case
        if(ch > 'Z'){
            return;
        }

        // Current Work
        System.out.print(ch + " ");

        // Smaller Problem
        printAlphabetAToZ((char)(ch + 1));

    }

    public static void main(String[] args){

        printAlphabetAToZ('A');

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

ch = 'A'

---------------------------------------------------------
GOING DOWN

main()

↓

printAlphabetAToZ('A')

Print A

↓

printAlphabetAToZ('B')

Print B

↓

printAlphabetAToZ('C')

Print C

↓

...

↓

printAlphabetAToZ('Y')

Print Y

↓

printAlphabetAToZ('Z')

Print Z

↓

printAlphabetAToZ('[')

Base Case

return

---------------------------------------------------------
COMING UP

printAlphabetAToZ('[')

↓

return

↑

printAlphabetAToZ('Z')

↓

return

↑

printAlphabetAToZ('Y')

↓

return

↑

...

↑

printAlphabetAToZ('B')

↓

return

↑

printAlphabetAToZ('A')

↓

return

↑

main()

---------------------------------------------------------
Output

A B C D E F G H I J K L M N O P Q R S T U V W X Y Z

=========================================================
                RECURSION TREE
=========================================================

printAlphabetAToZ('A')
            |
            v
printAlphabetAToZ('B')
            |
            v
printAlphabetAToZ('C')
            |
            v
...
            |
            v
printAlphabetAToZ('Y')
            |
            v
printAlphabetAToZ('Z')
            |
            v
printAlphabetAToZ('[')

return

=========================================================
                CALL STACK
=========================================================

PUSH

A

↓

B

↓

C

↓

...

↓

Y

↓

Z

↓

[

----------------------

POP

[

↓

Z

↓

Y

↓

...

↓

C

↓

B

↓

A

=========================================================
Time Complexity

26 alphabets are visited once.

Time

O(26)

≈ O(1)

=========================================================
Space Complexity

Maximum recursion depth is 26.

Space

O(26)

≈ O(1)

=========================================================
ASCII / Character Explanation

'A' = 65

'B' = 66

...

'Z' = 90

Adding 1 to a character moves to the next
ASCII character.

'A' + 1

↓

'B'

Because

char + int

returns an int,

we must cast it back to char.

(char)(ch + 1)

=========================================================
Interview Questions

Q1. Why is this PRE ORDER?

Answer

Current work (printing)

happens BEFORE

the recursive call.

---------------------------------------------------------

Q2. Why write

(char)(ch + 1) ?

Answer

Because

ch + 1

returns an int.

We convert it back to char.

---------------------------------------------------------

Q3. Why is the base case

ch > 'Z' ?

Answer

After printing 'Z',

the next character becomes '['.

There are no more uppercase English letters,

so recursion stops.

---------------------------------------------------------

Q4. Why use characters instead of ASCII numbers?

Answer

Using

'A'

and

'Z'

makes the code easier to read and understand.

=========================================================
Common Mistakes

❌ Forgetting the cast

printAlphabetAToZ(ch + 1);

Compilation Error

Correct

printAlphabetAToZ((char)(ch + 1));

-----------------------------------

❌ Wrong Base Case

if(ch == 'Z')
    return;

'A' to 'Y' are printed.

'Z' is skipped.

-----------------------------------

Correct

if(ch > 'Z')

-----------------------------------

❌ Using

(char)(ch - 1)

instead of

(char)(ch + 1)

prints the wrong direction.

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

✅ PRE ORDER

Base Case

✅ Remembered

Dry Run

✅ Done

Recursion Tree

✅ Done

Call Stack

✅ Understood

Time Complexity

✅ Explained

Space Complexity

✅ Explained

Solved Without Notes

✅

Explained Without Notes

✅

Interview Ready

✅

=========================================================
*/


