package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class J104UniquePermutationsOfString {
    public static void swap(StringBuilder sb, int st, int en) {
            char temp = sb.charAt(st);
            sb.setCharAt(st, sb.charAt(en));
            sb.setCharAt(en, temp);
        }
        public static void solve(List<String> ans, StringBuilder sb, int idx) {
            if (idx < 0) {
                ans.add(sb.toString());
                return;
            }
            Set<Character> unique = new HashSet<>();
            for (int i = idx; i >= 0; i--) {
                if (unique.contains(sb.charAt(i))) {
                    continue;
                }
                unique.add(sb.charAt(i));
                swap(sb, i, idx);
                solve(ans, sb, idx - 1);
                swap(sb, i, idx);
            }
    }
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String str = "BBC";
        StringBuilder sb = new StringBuilder(str);
        int idx = str.length() - 1;
        solve(ans, sb, idx);
        System.out.println(ans);
    }
}

/*
===========================================================
J104 — UNIQUE PERMUTATIONS OF A STRING
===========================================================

PROBLEM
-------

Generate all UNIQUE permutations of a string.

The input string may contain duplicate characters.

Example:

    Input:
        "AAB"

    Output:

        AAB
        ABA
        BAA


===========================================================
CORE IDEA
===========================================================

This problem builds directly on J103.

J103:

    STRING
      +
    SWAP
      +
    RECURSION
      +
    SWAP BACK


J104 adds one new idea:

    DUPLICATE CHARACTER HANDLING


So:

    SWAP
      +
    SET PER RECURSION LEVEL


===========================================================
CORE RECURSION PATTERN
===========================================================

At every recursion level:

    CURRENT POSITION
           ↓
        CHOOSE
           ↓
    CHECK DUPLICATE
       /       \
    USED       NEW
      ↓          ↓
    SKIP        SWAP
                  ↓
                RECURSE
                  ↓
              SWAP BACK


Memory:

    CHOOSE
       ↓
    CHECK DUPLICATE
       ↓
      SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


This is BACKTRACKING
with duplicate pruning.


===========================================================
WHAT DOES idx MEAN?
===========================================================

idx means:

    "The position currently being fixed."


Example:

    sb = "AAB"

Initially:

    idx = 2


Therefore:

    position 2 is currently being fixed.


Then:

    idx = 1

means:

    position 1 is currently being fixed.


Then:

    idx = 0

means:

    position 0 is currently being fixed.


Finally:

    idx = -1

means:

    all positions are fixed.


===========================================================
INITIAL STATE
===========================================================

Input:

    s = "AAB"


Create:

    StringBuilder sb = new StringBuilder(s);


Therefore:

    sb = "AAB"


Then:

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

    sb = one complete UNIQUE permutation


We do:

    ans.add(sb.toString());


Important:

    sb.toString()

creates a String snapshot.

The StringBuilder itself continues changing
during backtracking.


===========================================================
WHY STRINGBUILDER?
===========================================================

String is immutable.

We cannot modify:

    s.charAt(i)


StringBuilder is mutable.

We can modify:

    setCharAt()


Therefore:

    StringBuilder = CURRENT STATE


and:

    swap()

changes that state in-place.


===========================================================
SWAP FUNCTION
===========================================================

    char temp = sb.charAt(st);

    sb.setCharAt(st, sb.charAt(en));

    sb.setCharAt(en, temp);


Example:

    AAB

swap(1,2)

Before:

    A A B
      ↑ ↑
      1 2


After:

    A B A


So:

    B

has been selected for position 2.


Therefore:

    SWAP = CHOOSE CHARACTER FOR CURRENT POSITION


===========================================================
WHY Set<Character> unique?
===========================================================

The input may contain duplicate characters.

Example:

    AAB


At the root:

    idx = 2


Available choices:

    i = 2 → B
    i = 1 → A
    i = 0 → A


The two A choices produce the SAME
choice value for the same position.


Therefore we need to remember:

    "Which characters have already been
     chosen for THIS recursion level?"


We create:

    Set<Character> unique = new HashSet<>();


===========================================================
VERY IMPORTANT:
SET IS CREATED FOR EACH LEVEL
===========================================================

This line:

    Set<Character> unique = new HashSet<>();

is INSIDE solve().

Therefore every recursive call gets
a fresh Set.


Example:

    solve(idx = 2)
        unique = {}


        ↓ recurse


    solve(idx = 1)
        unique = {}


        ↓ recurse


    solve(idx = 0)
        unique = {}


This means:

    The Set only remembers choices made
    at the CURRENT recursion level.


It does NOT mean:

    "This character can never be used again."


A character can absolutely be used
at a deeper recursion level.


===========================================================
ROOT DRY RUN
INPUT = "AAB"
===========================================================

Initial:

    sb = AAB
    idx = 2


We need to fix:

    position 2


Current:

    A A B


Loop:

    i = 2
    i = 1
    i = 0


Set:

    unique = {}


-----------------------------------------------------------
ROOT BRANCH 1
-----------------------------------------------------------

i = 2

Character:

    B


Check:

    unique.contains('B')

Result:

    false


Add:

    unique = {B}


Swap:

    swap(2,2)


String:

    AAB


Position 2:

    B


Recurse:

    solve(idx = 1)


===========================================================
LEVEL 2
CURRENT = AAB
idx = 1
===========================================================

New recursion level.

Therefore:

    unique = {}


We need to fix:

    position 1


Available:

    i = 1
    i = 0


-----------------------------------------------------------
LEVEL 2 — i = 1
-----------------------------------------------------------

Character:

    A


Check:

    unique.contains('A')

false.


Add:

    unique = {A}


Swap:

    swap(1,1)


String:

    AAB


Recurse:

    solve(idx = 0)


===========================================================
LEVEL 3
idx = 0
===========================================================

New Set:

    unique = {}


Only:

    i = 0


Character:

    A


Add:

    unique = {A}


swap(0,0)


String:

    AAB


Recurse:

    solve(idx = -1)


===========================================================
BASE CASE
===========================================================

Store:

    AAB


ans:

    [AAB]


Return.

Undo:

    swap(0,0)


Return to idx = 1.


-----------------------------------------------------------
LEVEL 2 — SECOND CHOICE
-----------------------------------------------------------

Now:

    i = 0


Character:

    A


Current Set:

    {A}


Check:

    unique.contains('A')


Result:

    true


Therefore:

    continue;


This branch is SKIPPED.


WHY?

Because at this same recursion level:

    position 1

we already chose character:

    A


Choosing the same A again would produce
a duplicate permutation.


===========================================================
BACK TO ROOT
===========================================================

Return from:

    solve(idx = 1)


Undo root branch:

    swap(2,2)


String remains:

    AAB


Root Set:

    {B}


-----------------------------------------------------------
ROOT BRANCH 2
-----------------------------------------------------------

i = 1

Character:

    A


Check:

    unique.contains('A')

false.


Add:

    unique = {B,A}


Swap:

    swap(1,2)


Before:

    A A B


After:

    A B A


So:

    position 2 = A


Recurse:

    solve(idx = 1)


===========================================================
LEVEL 2
CURRENT = ABA
===========================================================

Fresh Set:

    unique = {}


i = 1

Character:

    B


Add:

    unique = {B}


swap(1,1)


String:

    ABA


Recurse.

At idx = 0:

    A


Base case:

    ABA


Store:

    ABA


Undo.


-----------------------------------------------------------
LEVEL 2 — i = 0
-----------------------------------------------------------

Current:

    ABA


Character:

    A


Set:

    {B}


A is not present.

Therefore:

    unique = {B,A}


Swap:

    swap(0,1)


String:

    BAA


Recurse.


Base case:

    BAA


Store:

    BAA


Undo.


===========================================================
ROOT BRANCH 3
===========================================================

Return to root.

Original state restored:

    AAB


Root Set:

    {B,A}


Now:

    i = 0


Character:

    A


Check:

    unique.contains('A')

true.


Therefore:

    continue;


This branch is skipped.


===========================================================
FINAL UNIQUE ANSWER
===========================================================

    AAB
    ABA
    BAA


Only 3 results.


===========================================================
COMPLETE RECURSION TREE
===========================================================


                         AAB
                          |
                       idx = 2
                          |
                ---------------------
                |         |         |
              i=2       i=1       i=0
               B          A         A
               |          |         X
               |          |       DUPLICATE
             AAB         ABA
               |          |
             idx=1      idx=1
             /   \      /   \
            A     A    B     A
            |     X    |     |
           AAB   DUP   ABA   BAA
            |           |     |
         OUTPUT      OUTPUT OUTPUT


Root duplicate:

    i = 1 → A
    i = 0 → A

Second A is skipped.


===========================================================
WHY SET MUST BE AT THE CURRENT LEVEL
===========================================================

Suppose:

    idx = 2

and we choose:

    A


Then:

    A

is stored in the root-level Set.


But when recursion moves to:

    idx = 1

we create:

    NEW Set


Why?

Because now we are making choices
for a DIFFERENT position.


So:

    SAME LEVEL
        +
    SAME CHARACTER
        =
    DUPLICATE → SKIP


But:

    DIFFERENT LEVEL
        +
    SAME CHARACTER
        =
    ALLOWED


This distinction is extremely important.


===========================================================
WHY NOT ONE GLOBAL SET?
===========================================================

A global Set would incorrectly mean:

    "Once A is used, never use A again."


That is NOT what permutations mean.


Example:

    AAB


A must appear multiple times in the
same final permutation.


We only want to prevent:

    choosing the same A twice
    as the SAME position choice.


Therefore:

    Set = PER RECURSION LEVEL


===========================================================
J103 vs J104
===========================================================

J103 — Normal String Permutations

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


J104 — Unique String Permutations

    CHOOSE
       ↓
    ALREADY USED
    AT THIS LEVEL?
       ↓
    YES → SKIP
       ↓
     NO
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


So J104 is:

    J103
      +
    duplicate pruning


===========================================================
YOUR WHILE-LOOP IDEA
===========================================================

Earlier you used an idea like:

    while (adjacent values are equal)
        move forward


That is NOT the main duplicate rule
for this problem.


Why?

Because the real question here is:

    "Have I already chosen this CHARACTER
     at this recursion level?"


Therefore we use:

    Set<Character>


Your while-loop idea is useful when:

    data is sorted
        ↓
    duplicates are adjacent
        ↓
    we want to skip consecutive duplicates


Typical examples:

    3Sum
    4Sum
    Combination Sum II
    Subsets II
    Remove Duplicates from Sorted Array


Memory:

    WHILE
    =
    skip adjacent duplicate run


    SET
    =
    skip repeated CHOICE
    at the SAME recursion level


===========================================================
BACKTRACKING / RESTORE
===========================================================

Example:

    AAB

Choose:

    swap(1,2)

Becomes:

    ABA


Explore this entire branch.


After returning:

    swap(1,2)


Restores:

    AAB


Then the next root choice
starts from the correct state.


Therefore:

    CHOOSE
       ↓
     SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


The SAME StringBuilder object is being modified.


===========================================================
WHY sb.toString()?
===========================================================

At base case:

    sb = AAB


We do:

    sb.toString()


This creates a String snapshot:


    "AAB"


Then recursion continues changing sb.


The stored String does NOT change.


Therefore:

    StringBuilder
        =
    mutable working state


    String
        =
    immutable answer snapshot


===========================================================
TIME COMPLEXITY
===========================================================

If all characters are unique:

    N!


possible permutations.


Each result has length N.


Therefore output generation is approximately:

    O(N × N!)


With duplicates, the number of unique
permutations is smaller.


If character frequencies are:

    c1, c2, ..., ck


then unique permutations are:

    N! / (c1! × c2! × ... × ck!)


===========================================================
SPACE COMPLEXITY
===========================================================

Recursion depth:

    O(N)


Set at each level:

    O(N)


Answer storage:

    O(N × number of unique permutations)


===========================================================
CORE J104 PATTERN
===========================================================

                         POSITION idx
                              |
                         choose i
                              |
                    already used value?
                       /             \
                     YES             NO
                      |               |
                    SKIP             SWAP
                                      |
                                   RECURSE
                                      |
                                  SWAP BACK


===========================================================
MOST IMPORTANT MEMORY
===========================================================

DO NOT MEMORIZE:

    Set code
    swap code
    recursion code


REMEMBER THE QUESTIONS:

    1. What position am I fixing?

    2. What choices can fill it?

    3. Can two choices have the same value?

    4. Have I already chosen this value
       at this SAME recursion level?

    5. If yes:
           skip

    6. If no:
           choose
           swap
           recurse
           undo


===========================================================
J104 TAKEAWAY
===========================================================

J103:

    NORMAL PERMUTATION

    CHOOSE
    SWAP
    RECURSE
    UNDO


J104:

    UNIQUE PERMUTATION

    CHOOSE
    CHECK SAME-LEVEL DUPLICATE
    SWAP
    RECURSE
    UNDO


This is the transition from:

    BASIC BACKTRACKING

to:

    BACKTRACKING + DUPLICATE PRUNING


===========================================================
INTERVIEW / OA RECOGNITION
===========================================================

When you see:

    "Generate all permutations"

think:

    PERMUTATION


Then ask:

    Are duplicate values present?


NO:

    swap + recursion + undo


YES:

    swap
    +
    Set at current level
    +
    recursion
    +
    undo


The key transferable idea is:

    SAME LEVEL
        +
    SAME VALUE
        ↓
    SKIP


===========================================================
FINAL MENTAL MODEL
===========================================================

                  CURRENT POSITION
                         |
                      choices
                         |
                 duplicate value?
                    /        \
                  yes         no
                   |           |
                 skip         swap
                               |
                            recurse
                               |
                           swap back
                               |
                           next choice


This is the complete mental model
for Unique String Permutations.
*/