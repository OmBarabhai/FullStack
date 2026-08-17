package DSA.A_Recursion.A_Part_01.A_Pre_Post;

/*
=========================================================
           PROBLEM 08 : PRINT ALPHABET Z TO A
=========================================================

Date Started : 01-08-2026

Pattern      : PRE ORDER

Difficulty   : 🟢 Easy

Interview    : ⭐⭐⭐☆☆

---------------------------------------------------------
Problem Statement

Print all uppercase English alphabets from
Z to A using recursion.

Example

Input

Z

Output

Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

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

printAlphabetZToA(previousCharacter)

---------------------------------------------------------
Base Case

if(ch < 'A'){
    return;
}

---------------------------------------------------------
Algorithm

1. Check the base case.
2. Print the current alphabet.
3. Move to the previous alphabet.
4. Repeat until 'A'.

=========================================================
*/

public class A8PrintAlphabetZToA {

    public static void printAlphabetZToA(char ch){

        // Base Case
        if(ch < 'A'){
            return;
        }

        // Current Work
        System.out.print(ch + " ");

        // Smaller Problem
        printAlphabetZToA((char)(ch - 1));

    }

    public static void main(String[] args){

        printAlphabetZToA('Z');

    }

}

/*
=========================================================
                    DRY RUN
=========================================================

Input

ch = 'Z'

---------------------------------------------------------
GOING DOWN

main()

↓

printAlphabetZToA('Z')

Print Z

↓

printAlphabetZToA('Y')

Print Y

↓

printAlphabetZToA('X')

Print X

↓

...

↓

printAlphabetZToA('B')

Print B

↓

printAlphabetZToA('A')

Print A

↓

printAlphabetZToA('@')

Base Case

return

---------------------------------------------------------
COMING UP

printAlphabetZToA('@')

↓

return

↑

printAlphabetZToA('A')

↓

return

↑

printAlphabetZToA('B')

↓

return

↑

...

↑

printAlphabetZToA('Y')

↓

return

↑

printAlphabetZToA('Z')

↓

return

↑

main()

---------------------------------------------------------
Output

Z Y X W V U T S R Q P O N M L K J I H G F E D C B A

=========================================================
                RECURSION TREE
=========================================================

printAlphabetZToA('Z')
            |
            v
printAlphabetZToA('Y')
            |
            v
printAlphabetZToA('X')
            |
            v
...
            |
            v
printAlphabetZToA('B')
            |
            v
printAlphabetZToA('A')
            |
            v
printAlphabetZToA('@')

return

=========================================================
                CALL STACK
=========================================================

PUSH

Z

↓

Y

↓

X

↓

...

↓

B

↓

A

↓

@

----------------------

POP

@

↓

A

↓

B

↓

...

↓

X

↓

Y

↓

Z

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

...

'Y' = 89

'Z' = 90

Subtracting 1 from a character moves to the
previous ASCII character.

'Z' - 1

↓

'Y'

Because

char - int

returns an int,

we must cast it back to char.

(char)(ch - 1)

=========================================================
Interview Questions

Q1. Why is this PRE ORDER?

Answer

Current work (printing)

happens BEFORE

the recursive call.

---------------------------------------------------------

Q2. Why write

(char)(ch - 1) ?

Answer

Because

ch - 1

returns an int.

We convert it back to char.

---------------------------------------------------------

Q3. Why is the base case

ch < 'A' ?

Answer

After printing 'A',

the next character becomes '@'.

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

printAlphabetZToA(ch - 1);

Compilation Error

Correct

printAlphabetZToA((char)(ch - 1));

-----------------------------------

❌ Wrong Base Case

if(ch == 'A')
    return;

'A' is never printed.

-----------------------------------

Correct

if(ch < 'A')

-----------------------------------

❌ Using

(char)(ch + 1)

instead of

(char)(ch - 1)

causes the recursion to move in the wrong direction.

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