package DSA.A_Recursion.I_Choice_Generation;

import java.util.ArrayList;
import java.util.List;

public class I100IncludeExcludeSubsetFramework {
    public static void solve(int[] arr,List<Integer> ans,int idx){
        if(idx>=arr.length){
            System.out.println(ans);
            return;
        }
        ans.add(arr[idx]);
        solve(arr,ans,idx+1);
        ans.remove(ans.size()-1);
        solve(arr,ans,idx+1);
    }
    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = {11,22,33,44};
        solve(arr,ans,0);
    }
}

/*
===========================================================
I100 — INCLUDE / EXCLUDE SUBSET FRAMEWORK
RECURSION TREE + DRY RUN
===========================================================

INPUT:

arr = [11, 22, 33, 44]


===========================================================
CORE IDEA
===========================================================

For every element we have TWO choices:

                 current element
                 /             \
            INCLUDE          EXCLUDE
               |                |
            recurse          recurse


INCLUDE:

    Add arr[idx] to ans.

    Then:

    solve(idx + 1)


EXCLUDE:

    Do not add arr[idx].

    Then:

    solve(idx + 1)


After INCLUDE recursion finishes:

    remove the element

This is BACKTRACKING.


===========================================================
BASE CASE
===========================================================

if (idx >= arr.length)

    Every element has been processed.

    Therefore:

    ans is one complete subset.

    print(ans)

    return


===========================================================
RECURSION TREE
===========================================================

For easier understanding, use:

arr = [11, 22, 33]


                         []
                        idx=0
                       /     \
                 INCLUDE     EXCLUDE
                   11           |
                   |            |
                 [11]           []
                 /  \          /  \
              INC   EXC     INC   EXC
               22     |       11     |
               |      |       |      |
           [11,22]  [11]     [22]    []
            /  \     /  \     / \    / \
          +33  -33 +33 -33  +33 -33 +33 -33


Leaves:

[]
[11]
[22]
[33]
[11,22]
[11,33]
[22,33]
[11,22,33]


===========================================================
DRY RUN
===========================================================

START:

idx = 0
ans = []


-----------------------------------------------------------
ELEMENT = 11
-----------------------------------------------------------

INCLUDE 11:

ans = [11]

call:

solve(idx = 1)


-----------------------------------------------------------
ELEMENT = 22
-----------------------------------------------------------

INCLUDE 22:

ans = [11,22]

call:

solve(idx = 2)


-----------------------------------------------------------
ELEMENT = 33
-----------------------------------------------------------

INCLUDE 33:

ans = [11,22,33]

call:

solve(idx = 3)


BASE CASE:

idx >= arr.length

3 >= 3

TRUE

PRINT:

[11,22,33]


BACKTRACK:

remove 33

ans = [11,22]


-----------------------------------------------------------
EXCLUDE 33
-----------------------------------------------------------

Do not add 33.

ans remains:

[11,22]

call:

solve(idx = 3)


BASE CASE

PRINT:

[11,22]


BACKTRACK TO 22.


-----------------------------------------------------------
EXCLUDE 22
-----------------------------------------------------------

Before this branch:

ans = [11]

So:

solve(idx = 2)


INCLUDE 33:

ans = [11,33]

PRINT:

[11,33]


BACKTRACK:

ans = [11]


EXCLUDE 33:

ans = [11]

PRINT:

[11]


So the INCLUDE-11 branch produces:

[11,22,33]
[11,22]
[11,33]
[11]


===========================================================
BACK TO ROOT
===========================================================

Now we BACKTRACK 11:

ans = []


-----------------------------------------------------------
EXCLUDE 11
-----------------------------------------------------------

We skip 11.

ans = []

call:

solve(idx = 1)


Current element:

22


INCLUDE 22:

ans = [22]


INCLUDE 33:

ans = [22,33]

PRINT:

[22,33]


BACKTRACK:

ans = [22]


EXCLUDE 33:

PRINT:

[22]


BACKTRACK:

ans = []


EXCLUDE 22:

ans = []


INCLUDE 33:

ans = [33]

PRINT:

[33]


BACKTRACK:

ans = []


EXCLUDE 33:

PRINT:

[]


===========================================================
FINAL OUTPUT
===========================================================

[11,22,33]
[11,22]
[11,33]
[11]
[22,33]
[22]
[33]
[]


Order can vary depending on
whether INCLUDE or EXCLUDE is explored first.


===========================================================
WHY REMOVE() IS NECESSARY
===========================================================

Suppose:

ans = [11,22,33]

After printing:

[11,22,33]

we return to the parent.

If we do NOT remove 33:

ans would still be:

[11,22,33]

Then the EXCLUDE branch would incorrectly contain 33.

So we do:

    ans.remove(ans.size() - 1)


to restore the previous state:

    [11,22]


This is:

    CHOOSE
       ↓
    RECURSE
       ↓
    UNDO


===========================================================
INCLUDE / EXCLUDE FLOW
===========================================================

For every arr[idx]:


1. INCLUDE

    ans.add(arr[idx])

    solve(idx + 1)


2. UNDO

    ans.remove(ans.size() - 1)


3. EXCLUDE

    solve(idx + 1)


===========================================================
WHY THIS GENERATES ALL SUBSETS
===========================================================

Every element has exactly two decisions:

    INCLUDE
    EXCLUDE


For N elements:

    2 choices × 2 choices × ... × 2 choices

    = 2^N


For:

    N = 4

we get:

    2^4 = 16 subsets


===========================================================
I100 CONNECTION TO H
===========================================================

H:

    TAKE
    NOT-TAKE


I100:

    INCLUDE
    EXCLUDE


They are the SAME recursion structure.

The important difference is that I100
is treated as a reusable general framework.


===========================================================
I100 CONNECTION TO NEXT SECTION
===========================================================

H / I100:

    INCLUDE / EXCLUDE


Next:

    PERMUTATION


Permutation changes the question from:

    "Should I include this element?"

to:

    "Which available element should I place here?"


So:

    INCLUDE / EXCLUDE
            ↓
    CHOICE FROM AVAILABLE ELEMENTS
            ↓
         PERMUTATION


===========================================================
TC / SC
===========================================================

There are:

    2^N subsets.


If printing each subset costs O(N):

    TC = O(N × 2^N)


Recursion depth:

    N


Current list size:

    N


Therefore:

    SC = O(N)

excluding the output storage.


===========================================================
CORE PATTERN
===========================================================

                     ELEMENT
                    /       \
               INCLUDE     EXCLUDE
                  |            |
              add element     skip
                  |            |
               recurse       recurse
                  |
                UNDO


Remember:

    INCLUDE
       ↓
    RECURSE
       ↓
    REMOVE
       ↓
    EXCLUDE
       ↓
    RECURSE
*/