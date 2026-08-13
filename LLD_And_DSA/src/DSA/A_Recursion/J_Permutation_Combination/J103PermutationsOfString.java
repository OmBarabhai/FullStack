package DSA.A_Recursion.J_Permutation_Combination;

import java.util.*;

public class J103PermutationsOfString {
    public static void swap(StringBuilder s, int st, int en) {
        char temp = s.charAt(st);
        s.setCharAt(st, s.charAt(en));
        s.setCharAt(en, temp);

    }
    public static void solve(ArrayList<String> ans, StringBuilder sb, int idx) {
        if (idx<0) {
            ans.add(sb.toString());
            return;
        }

        for (int i = idx; i >= 0; i--) {

            swap(sb, i, idx);
            solve(ans, sb, idx - 1);
            swap(sb, i, idx);
        }

    }
    public ArrayList<String> permutation(String s) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);
        solve(ans, sb, s.length() - 1);
        Collections.sort(ans);
        return ans;

    }
}

/*
===========================================================
J103 — PERMUTATIONS OF A STRING
===========================================================

PROBLEM
-------

Generate all permutations of a given string.

Example:

    Input:
        "ABC"

    Output:
        ABC
        ACB
        BAC
        BCA
        CAB
        CBA


===========================================================
CORE IDEA
===========================================================

This is the SAME SWAP-BASED PERMUTATION
approach that we used for arrays.

The only difference:

    int[] array
        ↓
    StringBuilder

Why StringBuilder?

    String is immutable.

    StringBuilder is mutable.

So we can swap characters directly.


===========================================================
CORE RECURSION PATTERN
===========================================================

At every recursion level:

    CURRENT POSITION
           ↓
        CHOOSE
           ↓
         SWAP
           ↓
        RECURSE
           ↓
       SWAP BACK


Memory:

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


This is TRUE BACKTRACKING.


===========================================================
WHAT DOES idx MEAN?
===========================================================

idx means:

    "The position currently being fixed."


Example:

    sb = "ABC"

Initially:

    idx = 2

So:

    position 2 is being fixed.


Then:

    idx = 1

means:

    position 1 is being fixed.


Then:

    idx = 0

means:

    position 0 is being fixed.


Finally:

    idx = -1

means:

    all positions are fixed.


===========================================================
INITIAL STATE
===========================================================

Input:

    s = "ABC"


We create:

    StringBuilder sb = new StringBuilder(s);


Therefore:

    sb = "ABC"


And:

    idx = s.length() - 1

so:

    idx = 2


Call:

    solve(ans, sb, 2)


===========================================================
BASE CASE
===========================================================

if (idx < 0)

All positions have been fixed.

Therefore:

    sb contains one complete permutation.


We do:

    ans.add(sb.toString());


Important:

    sb.toString()

creates a String snapshot.

The StringBuilder will continue changing
during backtracking.


===========================================================
WHY STRINGBUILDER?
===========================================================

String:

    "ABC"

is immutable.

We cannot do:

    s.charAt(i) = ...


StringBuilder:

    "ABC"

is mutable.

We can do:

    setCharAt()


Therefore our swap function is:

    char temp = s.charAt(st);

    s.setCharAt(st, s.charAt(en));

    s.setCharAt(en, temp);


===========================================================
SWAP MEANING
===========================================================

Suppose:

    sb = "ABC"

and:

    idx = 2
    i = 1


We do:

    swap(sb, 1, 2)


Before:

    A B C
      ↑ ↑
      1 2


After:

    A C B


Now:

    B

has been selected for position 2.


Therefore:

    SWAP = CHOOSE CHARACTER FOR CURRENT POSITION


===========================================================
WHY LOOP FROM idx TO 0?
===========================================================

At:

    idx = 2

all three characters are available:

    i = 2
    i = 1
    i = 0


At:

    idx = 1

only positions:

    i = 1
    i = 0

are available.


At:

    idx = 0

only:

    i = 0


So:

    for (int i = idx; i >= 0; i--)


means:

    "Choose one of the still-unfixed characters."


===========================================================
WHY RECURSE WITH idx - 1?
===========================================================

After choosing the character for position idx,

that position is fixed.

So we move to the previous position.

Example:

    idx = 2
       ↓
    fix position 2

    idx = 1
       ↓
    fix position 1

    idx = 0
       ↓
    fix position 0

    idx = -1
       ↓
    complete permutation


===========================================================
DRY RUN
===========================================================

INPUT:

    "ABC"


Initial:

    sb = "ABC"
    idx = 2


===========================================================
ROOT — idx = 2
===========================================================

Current:

    ABC

We need to fix position 2.


Loop:

    i = 2
    i = 1
    i = 0


-----------------------------------------------------------
BRANCH 1
-----------------------------------------------------------

i = 2

swap:

    swap(2,2)


String:

    ABC


Position 2 is:

    C


Recurse:

    solve(idx = 1)


-----------------------------------------------------------
idx = 1
-----------------------------------------------------------

Current:

    ABC

Need to fix position 1.


Loop:

    i = 1
    i = 0


-----------------------------------------------------------
BRANCH 1.1
-----------------------------------------------------------

i = 1

swap(1,1)

String:

    ABC


Position 1:

    B


Recurse:

    solve(idx = 0)


-----------------------------------------------------------
idx = 0
-----------------------------------------------------------

Current:

    ABC

Only:

    i = 0


swap(0,0)

String:

    ABC


Recurse:

    solve(idx = -1)


-----------------------------------------------------------
BASE CASE
-----------------------------------------------------------

idx < 0

Therefore:

    ABC

is stored.


Permutation:

    ABC


Return.

UNDO:

    swap(0,0)


Return to idx = 1.


UNDO:

    swap(1,1)


-----------------------------------------------------------
BRANCH 1.2
-----------------------------------------------------------

At:

    idx = 1

Now:

    i = 0


swap(0,1)


ABC
↑ ↑
0 1


becomes:

    BAC


Position 1 is now:

    A


Recurse:

    solve(idx = 0)


At idx = 0:

    swap(0,0)


String:

    BAC


Base case:

    idx = -1


Store:

    BAC


Return.

UNDO.

Then:

    swap(0,1)


String returns to:

    ABC


Return to root.


===========================================================
ROOT BRANCH 2
===========================================================

Restore:

    ABC


Now:

    i = 1


swap(1,2)


ABC

becomes:

    ACB


Position 2:

    B


Recurse:

    solve(idx = 1)


-----------------------------------------------------------
idx = 1
-----------------------------------------------------------

Current:

    ACB


BRANCH 2.1

i = 1

swap(1,1)


ACB


Recurse:

    solve(idx = 0)


Base:

    ACB


Store:

    ACB


-----------------------------------------------------------
BRANCH 2.2
-----------------------------------------------------------

i = 0


swap(0,1)


ACB

becomes:

    CAB


Recurse.

Base:

    CAB


Store:

    CAB


Undo.

Return to root.


===========================================================
ROOT BRANCH 3
===========================================================

Restore:

    ABC


Now:

    i = 0


swap(0,2)


ABC

becomes:

    CBA


Position 2:

    A


Recurse:

    solve(idx = 1)


-----------------------------------------------------------
idx = 1
-----------------------------------------------------------

Current:

    CBA


BRANCH 3.1

i = 1

swap(1,1)


CBA


Base eventually gives:

    CBA


Store.


-----------------------------------------------------------
BRANCH 3.2

i = 0


swap(0,1)


CBA

becomes:

    BCA


Base eventually gives:

    BCA


Store.


Undo.


===========================================================
FINAL PERMUTATIONS
===========================================================

    ABC
    BAC
    ACB
    CAB
    CBA
    BCA


Order can differ depending on loop direction,

but all:

    3! = 6

permutations are generated.


===========================================================
COMPLETE RECURSION TREE — STRING PERMUTATION
INPUT = "ABC"
===========================================================


                         ABC
                          |
                       idx = 2
                          |
              ---------------------------
              |             |             |
            i = 2         i = 1         i = 0
              |             |             |
         swap(2,2)     swap(1,2)     swap(0,2)
              |             |             |
             ABC           ACB           CBA
              |             |             |
           idx = 1      idx = 1      idx = 1
              |             |             |
           --------       --------       --------
           |      |       |      |       |      |
         i = 1  i = 0   i = 1  i = 0   i = 1  i = 0
           |      |       |      |       |      |
      swap(1,1) swap(0,1) swap(1,1) swap(0,1) swap(1,1) swap(0,1)
           |      |       |      |       |      |
          ABC    BAC     ACB    CAB     CBA    BCA
           |      |       |      |       |      |
        idx=0   idx=0   idx=0   idx=0   idx=0   idx=0
           |      |       |      |       |      |
        swap(0,0) ...   ...    ...     ...    ...
           |      |       |      |       |      |
         ABC    BAC     ACB    CAB     CBA    BCA
           |      |       |      |       |      |
        idx=-1  idx=-1  idx=-1  idx=-1  idx=-1  idx=-1
           |      |       |      |       |      |
         OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT OUTPUT


===========================================================
LEVEL 1 — FIX POSITION 2
===========================================================

Starting state:

    ABC

Indices:

    0   1   2
    A   B   C
            ↑
          idx=2


                    ABC
                /    |    \
               /     |     \
              /      |      \
           i=2      i=1      i=0
            |         |        |
        swap(2,2) swap(1,2) swap(0,2)
            |         |        |
           ABC       ACB      CBA


Meaning:

    swap(2,2)
        ↓
    C stays at index 2

    swap(1,2)
        ↓
    B moves to index 2

    swap(0,2)
        ↓
    A moves to index 2


Therefore:

    ABC → position 2 = C
    ACB → position 2 = B
    CBA → position 2 = A


===========================================================
LEVEL 2 — BRANCH: ABC
POSITION 2 FIXED = C
===========================================================

Current state:

    ABC

Indices:

    0   1   2
    A   B   C
        ↑
      idx=1


                    ABC
                   /   \
                  /     \
               i=1       i=0
                |          |
            swap(1,1)   swap(0,1)
                |          |
               ABC        BAC


Meaning:

    swap(1,1)
        ↓
    B stays at index 1

    swap(0,1)
        ↓
    A moves to index 1


Then:

    ABC → position 1 = B
    BAC → position 1 = A


===========================================================
LEVEL 2 — BRANCH: ACB
POSITION 2 FIXED = B
===========================================================

Current state:

    ACB

Indices:

    0   1   2
    A   C   B
        ↑
      idx=1


                    ACB
                   /   \
                  /     \
               i=1       i=0
                |          |
            swap(1,1)   swap(0,1)
                |          |
               ACB        CAB


Meaning:

    swap(1,1)
        ↓
    C stays at index 1

    swap(0,1)
        ↓
    A moves to index 1


Then:

    ACB → position 1 = C
    CAB → position 1 = A


===========================================================
LEVEL 2 — BRANCH: CBA
POSITION 2 FIXED = A
===========================================================

Current state:

    CBA

Indices:

    0   1   2
    C   B   A
        ↑
      idx=1


                    CBA
                   /   \
                  /     \
               i=1       i=0
                |          |
            swap(1,1)   swap(0,1)
                |          |
               CBA        BCA


Meaning:

    swap(1,1)
        ↓
    B stays at index 1

    swap(0,1)
        ↓
    C and B exchange places


Then:

    CBA → position 1 = B
    BCA → position 1 = C


===========================================================
LEVEL 3 — FINAL POSITION
===========================================================

At every branch:

    idx = 0

Only:

    i = 0

is possible.

So the state does not change:

    ABC → swap(0,0) → ABC
    BAC → swap(0,0) → BAC
    ACB → swap(0,0) → ACB
    CAB → swap(0,0) → CAB
    CBA → swap(0,0) → CBA
    BCA → swap(0,0) → BCA


Then:

    idx = -1

which is the base case.


===========================================================
LEAF / BASE CASE
===========================================================

    ABC → idx=-1 → OUTPUT ABC
    BAC → idx=-1 → OUTPUT BAC
    ACB → idx=-1 → OUTPUT ACB
    CAB → idx=-1 → OUTPUT CAB
    CBA → idx=-1 → OUTPUT CBA
    BCA → idx=-1 → OUTPUT BCA


===========================================================
FINAL ANSWER
===========================================================

    ABC
    BAC
    ACB
    CAB
    CBA
    BCA


===========================================================
ONE-LINE TREE
===========================================================

                         ABC
                    /     |     \
                   C      B      A
                   |      |      |
                 ABC     ACB    CBA
                /  \    /  \    /  \
               B    A  C    A  B    C
               |    |  |    |  |    |
              ABC  BAC ACB  CAB CBA  BCA
               ↓    ↓  ↓    ↓  ↓    ↓
              OUT  OUT OUT  OUT OUT  OUT


===========================================================
SWAP FLOW REFERENCE
===========================================================

ROOT:

    ABC
     |
     |-- swap(2,2) --> ABC
     |
     |-- swap(1,2) --> ACB
     |
     |-- swap(0,2) --> CBA


FROM ABC:

    ABC
     |
     |-- swap(1,1) --> ABC
     |
     |-- swap(0,1) --> BAC


FROM ACB:

    ACB
     |
     |-- swap(1,1) --> ACB
     |
     |-- swap(0,1) --> CAB


FROM CBA:

    CBA
     |
     |-- swap(1,1) --> CBA
     |
     |-- swap(0,1) --> BCA


===========================================================
BACKTRACKING / RESTORE
===========================================================

Example:

    ABC
     |
    swap(0,1)
     ↓
    BAC
     |
    recurse
     ↓
    BAC produced
     |
    swap(0,1)  ← UNDO
     ↓
    ABC


Another:

    ABC
     |
    swap(1,2)
     ↓
    ACB
     |
    recurse
     ↓
    ACB / CAB
     |
    swap(1,2)  ← UNDO
     ↓
    ABC


Another:

    ABC
     |
    swap(0,2)
     ↓
    CBA
     |
    recurse
     ↓
    CBA / BCA
     |
    swap(0,2)  ← UNDO
     ↓
    ABC


===========================================================
FINAL MENTAL MODEL
===========================================================

    idx = current position to fix

            ↓

    choose i

            ↓

    swap(i, idx)

            ↓

    recurse(idx - 1)

            ↓

    swap(i, idx)   ← RESTORE

            ↓

    next choice
===========================================================
WHY SWAP BACK?
===========================================================

Suppose:

    ABC

We choose:

    swap(1,2)


String becomes:

    ACB


After finishing that branch,

we MUST restore:

    ABC


So that the next root choice starts
from the original state.


Therefore:

    swap
       ↓
    recurse
       ↓
    swap back


This is BACKTRACKING.


===========================================================
WHY DON'T WE NEED A PATH STRING?
===========================================================

We do NOT use:

    sb.append(...)
    sb.deleteCharAt(...)


because the StringBuilder itself is
our current state.


The array/string is modified directly:

    swap
       ↓
    recurse
       ↓
    undo


So:

    StringBuilder = current permutation state


This is the same idea as the integer-array
swap permutation approach.


===========================================================
WHY DON'T WE NEED used[]?
===========================================================

We don't need:

    boolean[] used


because the current StringBuilder already
stores which characters are being used
for the fixed positions.


When a character is swapped into idx:

    that position becomes fixed.


The remaining prefix:

    [0 ... idx-1]

is available for recursion.


===========================================================
IMPORTANT DIFFERENCE FROM UNIQUE PERMUTATIONS
===========================================================

This problem assumes we generate normal permutations.

Example:

    "ABC"


All characters are different.

Therefore:

    ABC
    ACB
    BAC
    BCA
    CAB
    CBA


If the input contains duplicates:

    "AAB"


this normal permutation logic generates
duplicate results.

That becomes:

    UNIQUE PERMUTATIONS


For unique permutations, we add:

    Set<Character> used

at each recursion level.

Mental model:

    NORMAL PERMUTATION
        ↓
    CHOOSE + SWAP + RECURSE + UNDO


    UNIQUE PERMUTATION
        ↓
    SAME LEVEL
        ↓
    SAME CHARACTER ALREADY USED?
        ↓
    SKIP
        ↓
    otherwise CHOOSE


===========================================================
YOUR WHILE-LOOP LEARNING
===========================================================

Earlier you were trying:

    while (adjacent values are equal)
        move forward


That technique is useful when:

    data is sorted
        ↓
    duplicates are adjacent
        ↓
    we want to skip duplicate runs


Example:

    [1,1,1,2,2,3]


A while loop can skip:

    1 → 1 → 1


Common examples:

    3Sum
    4Sum
    Combination Sum II
    Subsets II
    Remove Duplicates from Sorted Array


For UNIQUE PERMUTATIONS, the important question is:

    "Have I already chosen this
     CHARACTER at this recursion level?"


Therefore:

    Set<Character> used


is the more appropriate mental model.


===========================================================
TIME COMPLEXITY
===========================================================

There are:

    N!

permutations.


Each completed permutation is converted
using:

    sb.toString()


which costs:

    O(N)


Therefore:

    Time = O(N × N!)


For N distinct characters.


===========================================================
SPACE COMPLEXITY
===========================================================

Recursion depth:

    O(N)


The answer stores:

    N! strings

each of length N.


Output space:

    O(N × N!)


Auxiliary recursion space:

    O(N)


===========================================================
CORE PATTERN
===========================================================

                    POSITION idx
                         |
                    choose i
                         |
                       SWAP
                         |
                      RECURSE
                         |
                    SWAP BACK
                         |
                    next choice


MEMORY:

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


===========================================================
INTERVIEW / OA RECOGNITION
===========================================================

When you see:

    "Generate all permutations"

think:

    PERMUTATION


Then ask:

    Does order matter?
        YES

    Do I need every arrangement?
        YES

    Are duplicates present?
        YES / NO


If NO duplicates:

    SWAP
    RECURSE
    SWAP BACK


If duplicates:

    SWAP
    + Set at current level
    RECURSE
    SWAP BACK


===========================================================
MOST IMPORTANT MEMORY
===========================================================

Do NOT memorize the code.

Remember:

    Current position
          ↓
    Choose an element
          ↓
        Swap
          ↓
      Recurse
          ↓
      Undo swap


That pattern can be transferred from:

    int[]
        ↓
    StringBuilder


The DATA TYPE changes.

The RECURSION PATTERN stays the same.


===========================================================
J103 TAKEAWAY
===========================================================

Normal String Permutation:

    StringBuilder
        +
    idx
        +
    swap
        +
    recursion
        +
    swap back


Pattern:

    TRUE BACKTRACKING


This should prepare us for:

    J104
    UNIQUE STRING PERMUTATIONS

where the only major new idea is:

    DUPLICATE CHARACTER HANDLING
*/