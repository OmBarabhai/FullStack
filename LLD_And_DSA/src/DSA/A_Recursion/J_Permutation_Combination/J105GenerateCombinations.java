package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;
import java.util.List;

public class J105GenerateCombinations {
    public static void solve(int n, int k, int start, List<List<Integer>> ans, List<Integer> op) {
        if (op.size() == k) {
            ans.add(new ArrayList<>(op));
            return;
        }
        for (int idx = start; idx <= n; idx++) {//start = 1 {1, 2, 3, 4} n = 4
            op.add(idx);
            /*
            [1, 2], [1, 3], [1, 4],
            [2, 3], [2, 4],
            [3, 4]
            */
            solve(n, k, idx + 1,ans,op);

            /*
            start 1 = i + 1 [1 -> 2] = [2]
                      i + 1 [2 -> 3] = [3]
                      i + 1 [3 -> 4] = [4]

            start 2 = i + 2 [2 -> 3] = [3]
                      i + 1 [2 -> 3] = [4]

            start 3 = i +  2 [3 -> 4] = [4]
            */
            op.remove(op.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, 1, ans, new ArrayList<>());
        System.out.println(ans);

    }
}

/*
===========================================================
J105 — GENERATE COMBINATIONS
===========================================================

PROBLEM
-------

Generate all combinations of size K
from the numbers:

    1 ... N

Example:

    n = 4
    k = 2


Answer:

    [1,2]
    [1,3]
    [1,4]
    [2,3]
    [2,4]
    [3,4]


IMPORTANT:

    ORDER DOES NOT MATTER


Therefore:

    [1,2]

and:

    [2,1]

represent the SAME combination.


===========================================================
1. CORE DIFFERENCE:
   PERMUTATION VS COMBINATION
===========================================================

PERMUTATION:

    ORDER MATTERS

    [1,2] != [2,1]


COMBINATION:

    ORDER DOES NOT MATTER

    [1,2] == [2,1]


Therefore the recursion strategy is different.


-----------------------------------------------------------
PERMUTATION
-----------------------------------------------------------

Usually:

    position
       ↓
    choose element
       ↓
      SWAP
       ↓
    RECURSE
       ↓
   SWAP BACK


-----------------------------------------------------------
COMBINATION
-----------------------------------------------------------

Usually:

    START
       ↓
    choose i
       ↓
    ADD i to path
       ↓
    RECURSE with i + 1
       ↓
    REMOVE i
       ↓
    NEXT CHOICE


===========================================================
2. CORE COMBINATION PATTERN
===========================================================

The main pattern is:

    START
      ↓
    CHOOSE i
      ↓
    ADD i
      ↓
    RECURSE(i + 1)
      ↓
    REMOVE LAST
      ↓
    NEXT i


This is:

    PATH-BASED BACKTRACKING


Unlike permutation,
we are not modifying the input array/string in-place.


===========================================================
3. WHAT IS THE STATE?
===========================================================

For J105 the important state is:


    path
      +
    start


Where:

    path
    =
    numbers selected so far


and:

    start
    =
    smallest number we are currently
    allowed to choose


Example:

    path = []

    start = 1


Available:

    1 2 3 4


Choose:

    1


Now:

    path = [1]

and:

    start = 2


So the next choices are:

    2 3 4


===========================================================
4. WHAT DOES start MEAN?
===========================================================

This is the MOST IMPORTANT VARIABLE
in basic combinations.


    start
       =
    "The first candidate I am allowed
     to choose at this recursion level."


Example:

    start = 1

Candidates:

    1 2 3 4


After choosing:

    i = 2


the next start is:

    i + 1 = 3


Therefore:

    candidates = 3 4


This prevents going backward.


===========================================================
5. `start` VS `idx`
===========================================================

This caused confusion with permutation.


For PERMUTATION:

    idx
    =
    position currently being fixed


Example:

    idx = 2
    ↓
    fix position 2


For COMBINATION:

    start
    =
    smallest candidate currently allowed


Example:

    start = 2
    ↓
    choices may begin at 2


DO NOT confuse them.


-----------------------------------------------------------
PERMUTATION
-----------------------------------------------------------

    idx = position


-----------------------------------------------------------
COMBINATION
-----------------------------------------------------------

    start = next allowed candidate


===========================================================
6. WHY DO WE USE A PATH?
===========================================================

A combination is simply:

    a group of selected numbers


So we keep:

    List<Integer> op


Example:

    op = []


Choose 1:

    op = [1]


Choose 3:

    op = [1,3]


Now:

    op.size() = 2


If:

    k = 2


we have a complete combination.


===========================================================
7. BASE CASE
===========================================================

The combination is complete when:

    op.size() == k


Therefore:

    if (op.size() == k) {

        ans.add(new ArrayList<>(op));

        return;
    }


IMPORTANT:

Do NOT use:

    start == k


because:

    start
    =
    next candidate


while:

    op.size()
    =
    number of chosen elements


These are different concepts.


===========================================================
8. WHY `new ArrayList<>(op)`?
===========================================================

`op` is mutable.


Example:

    op = [1,2]


We store it:

    ans.add(new ArrayList<>(op));


Now the answer contains a COPY.


Later:

    op.remove(...)


may change:

    op


but does NOT change the stored answer.


Therefore:

    op
    =
    mutable working state


    new ArrayList<>(op)
    =
    answer snapshot


===========================================================
9. WHY `ADD`?
===========================================================

Suppose:

    path = []


Choose:

    i = 1


Do:

    path.add(1)


Now:

    path = [1]


This means:

    "I have chosen 1."


Then recurse.


Therefore:

    ADD = CHOOSE


===========================================================
10. WHY REMOVE AFTER RECURSION?
===========================================================

Suppose:

    path = []


Choose 1:

    path = [1]


Explore:

    [1,2]
    [1,3]
    [1,4]


After this entire branch is finished,
we must return to:

    []


So:

    path.remove(path.size() - 1);


restores the previous state.


Therefore:

    CHOOSE
       ↓
    ADD
       ↓
    RECURSE
       ↓
    REMOVE


This is BACKTRACKING.


===========================================================
11. WHY NOT `SWAP`?
===========================================================

Permutation naturally asks:

    "Which element should occupy
     this current position?"


Therefore:

    SWAP


Combination asks:

    "Which candidates should I select?"


Therefore:

    PATH + ADD/REMOVE


Forcing swap into basic combinations
makes the state harder to understand.


The natural model is:

    start + path


===========================================================
12. WHY `i + 1`?
===========================================================

This is the MOST IMPORTANT TRANSITION.


Suppose:

    n = 4
    k = 2


Start:

    start = 1


Choose:

    i = 1


Now:

    path = [1]


What may we choose next?


Only:

    2
    3
    4


So:

    next start = 2


which is:

    i + 1


Therefore:

    solve(..., i + 1, ...)


NOT:

    solve(..., start + 1, ...)


===========================================================
13. `start + 1` VS `i + 1`
===========================================================

This caused an important bug while learning.


Suppose:

    start = 1


Current loop:

    i = 1
    i = 2
    i = 3
    i = 4


If:

    i = 3


is chosen:


    path = [3]


Next candidates should be:

    4


Therefore:

    next start = 4


which is:

    i + 1


But:

    start + 1 = 2


would incorrectly allow:

    2


giving:

    [3,2]


That is invalid duplicate ordering
because:

    [2,3]

is the same combination.


Therefore:


    FOR:
        i = start ... n


    CHOOSE:
        i


    RECURSE:
        i + 1


    UNDO:
        remove last


This is the correct state transition.


===========================================================
14. WHY COMBINATIONS NEVER GO BACKWARD
===========================================================

Because order does not matter.


Suppose:

    path = [2]


We only allow:

    3
    4


We do NOT allow:

    1


Why?


Because choosing:

    1


would generate:

    [2,1]


which represents the same combination as:

    [1,2]


So:

    i + 1


maintains increasing order.


===========================================================
15. COMPLETE CODE PATTERN
===========================================================

    public static void solve(
            int n,
            int k,
            int start,
            List<List<Integer>> ans,
            List<Integer> op) {

        if (op.size() == k) {

            ans.add(new ArrayList<>(op));

            return;
        }

        for (int i = start; i <= n; i++) {

            // CHOOSE
            op.add(i);

            // RECURSE
            solve(n, k, i + 1, ans, op);

            // UNDO
            op.remove(op.size() - 1);
        }
    }


Initial call:

    solve(n, k, 1, ans, new ArrayList<>());


===========================================================
16. DRY RUN
   n = 4, k = 2
===========================================================

Initial:

    path = []
    start = 1


Candidates:

    1 2 3 4


-----------------------------------------------------------
ROOT CHOICE: i = 1
-----------------------------------------------------------

Choose:

    path.add(1)


Now:

    path = [1]


Recurse:

    start = 2


Available:

    2 3 4


-----------------------------------------------------------
CHOOSE 2
-----------------------------------------------------------

    path = [1,2]


Now:

    path.size() = 2


and:

    k = 2


Therefore:

    COMPLETE


Store:

    [1,2]


Return.


UNDO:

    remove 2


Back to:

    [1]


-----------------------------------------------------------
CHOOSE 3
-----------------------------------------------------------

    path = [1,3]


Complete.


Store:

    [1,3]


Undo:

    [1]


-----------------------------------------------------------
CHOOSE 4
-----------------------------------------------------------

    path = [1,4]


Complete.


Store:

    [1,4]


Undo:

    []


===========================================================
ROOT CHOICE: i = 2
===========================================================

Choose:

    path = [2]


Next start:

    3


Available:

    3 4


Choose:

    3


Result:

    [2,3]


Undo.


Choose:

    4


Result:

    [2,4]


Undo.


Return to:

    []


===========================================================
ROOT CHOICE: i = 3
===========================================================

path:

    [3]


Next start:

    4


Choose:

    4


Result:

    [3,4]


Undo.


Return.


===========================================================
ROOT CHOICE: i = 4
===========================================================

path:

    [4]


Next start:

    5


No valid candidate remains.

Therefore no size-2 combination can be completed.


Return.


===========================================================
17. COMPLETE RECURSION TREE
===========================================================


                         []
             /            |            |            \
            1             2            3             4
          / | \          / \            |
         2  3  4        3   4           4
         |  |  |        |   |           |
       [1,2][1,3][1,4][2,3][2,4]      [3,4]


FINAL:

    [1,2]
    [1,3]
    [1,4]
    [2,3]
    [2,4]
    [3,4]


===========================================================
18. TREE WITH STATE
===========================================================


ROOT:

    path = []
    start = 1


        |
        | choose 1
        ↓

    path = [1]
    start = 2


        |
        | choose 2
        ↓

    path = [1,2]
    start = 3


        |
        | path.size() == k
        ↓

    STORE [1,2]


        |
        | undo
        ↓

    path = [1]


Then choose 3:

    [1,3]


Then choose 4:

    [1,4]


Then:

    undo 1


Back to:

    []


This is what the mutable path is doing
during the recursion.


===========================================================
19. WHY THE LOOP ALREADY HANDLES
    THE "SKIP" BRANCH
===========================================================

You may know:

    TAKE
    NOT TAKE


For basic combinations we can think
of the same choices differently.


Suppose:

    candidates = 1,2,3,4


At the current level:

    choose 1

then recursively explore
everything after 1.


When that branch returns,
the loop automatically moves to:

    choose 2


Then:

    choose 3


Then:

    choose 4


So the loop naturally explores the alternatives.


Therefore we often write:

    for (int i = start; i <= n; i++)


instead of explicitly writing:

    TAKE
       ↓
    NOT TAKE


Both are valid recursion ideas,
but the loop is the more natural
representation for basic combination
generation.


===========================================================
20. TAKE / NOT-TAKE VS CHOICE LOOP
===========================================================

TAKE / NOT-TAKE:

    candidate
       /   \
    TAKE   SKIP
      |      |
   recurse recurse


Useful for:

    subsequences
    subset counting
    include/exclude decisions


CHOICE LOOP:

    for each candidate
        choose
        recurse
        undo


Natural for:

    combinations
    permutations
    many backtracking generation problems


Important:

    Both are recursion.

    They simply represent the
    choice space differently.


===========================================================
21. TAIL RECURSION DOUBT
===========================================================

Combination backtracking is normally
NOT tail recursion.


Why?


Because after:

    solve(...)


we still execute:

    op.remove(...)


Example:

    op.add(i);

    solve(...);

    op.remove(op.size() - 1);


The recursive call is not the final operation.


Therefore:

    backtracking
    ≠
    tail recursion


Do not force this problem
into tail recursion.


The important thing is:

    correct STATE
    correct CHOICE
    correct RECURSION
    correct UNDO


===========================================================
22. WHY `op.remove()` IS THE UNDO
===========================================================

Before recursion:

    op.add(i)


After recursion:

    op.remove(last)


Exactly reverses the state change.


Therefore:

    ADD
      ↓
    RECURSE
      ↓
    REMOVE


General backtracking rule:


    MODIFY
      ↓
    RECURSE
      ↓
    UNDO


Always identify the undo operation
before writing the recursive call.


===========================================================
23. DO WE NEED `boolean[]`?
===========================================================

Not for basic:

    combine(n,k)


because the state itself is:

    start


and candidates are naturally processed
in increasing order.


We do not need to remember:

    "Have I used index i?"


We simply ensure:

    next start = i + 1


Therefore previously used values
cannot be chosen again.


===========================================================
24. DO WE NEED `Set`?
===========================================================

Not for:

    1 ... n


because every candidate is unique.


Example:

    1 2 3 4


There are no duplicate values.


The `start` rule also prevents
duplicate ordering.


So:

    basic combinations
        ↓
    no Set needed


If the INPUT contains duplicates
and the problem asks for UNIQUE
combinations, duplicate handling
becomes necessary.


===========================================================
25. WHERE YOUR WHILE-LOOP IDEA FITS
===========================================================

Your earlier duplicate idea was:

    while (adjacent values are equal)
        skip


This is useful when:

    input is sorted
        ↓
    duplicates are adjacent
        ↓
    we want to skip duplicate candidates


A common combination-style example:

    Combination Sum II


Typical conceptual rule:

    same-level duplicate candidate
        ↓
    skip


Sometimes this can be written as:

    while


and sometimes more cleanly as:

    if (i > start && nums[i] == nums[i-1])
        continue;


The exact form depends on the problem.


===========================================================
26. IMPORTANT:
    DO NOT USE WHILE AUTOMATICALLY
===========================================================

Before using a while duplicate skip,
ask:

    1. Is the data sorted?

    2. Are equal values adjacent?

    3. Am I trying to skip a duplicate
       choice at the SAME recursion level?

    4. Is skipping the entire duplicate run safe?


If yes:

    while / adjacent skip
    may be appropriate.


If not:

    do not force the while technique.


===========================================================
27. BASIC COMBINATION VS UNIQUE COMBINATION
===========================================================

J105:

    numbers are:

    1 ... n

All values are unique.


So:

    start
      ↓
    i
      ↓
    i + 1


is enough.


A unique-input combination problem
may look like:

    [1,1,2,2]


Then the question becomes:

    "Have I already chosen the same
     value at this recursion level?"


Now duplicate pruning is required.


===========================================================
28. COMBINATION vs PERMUTATION
===========================================================

PERMUTATION:

    ORDER MATTERS

    [1,2] != [2,1]


    position
       ↓
    choose
       ↓
    swap
       ↓
    recurse
       ↓
    swap back


COMBINATION:

    ORDER DOES NOT MATTER

    [1,2] == [2,1]


    start
       ↓
    choose i
       ↓
    add
       ↓
    recurse(i+1)
       ↓
    remove


This distinction should be
automatic in interviews.


===========================================================
29. HOW TO RECOGNIZE A NEW
    COMBINATION PROBLEM
===========================================================

Ask:


    1. Does ORDER MATTER?


    If NO:
        combination candidate


    2. Do I need to CHOOSE a fixed
       number of elements?


    If YES:
        path + size


    3. Can I prevent repeated ordering
       by moving forward?


    If YES:
        start index


    4. What is the current state?


        path
        +
        start


    5. What is the choice?


        i from start to allowed end


    6. What is the recursive state?


        i + 1


    7. What is the undo?


        remove last


    8. When is the answer complete?


        path.size() == k


This derives the solution
instead of memorizing it.


===========================================================
30. INTERVIEW / OA EXPLANATION
===========================================================

A strong explanation:


    "Order does not matter in combinations,
     so I maintain a start index to ensure
     that I only choose values after the
     previously selected value.

     I add each candidate to the current path,
     recursively continue from i + 1,
     and remove the candidate after returning
     to restore the previous state.

     Once the path contains k elements,
     I copy it into the result."


===========================================================
31. COMPLEXITY
===========================================================

Number of combinations:

    C(n,k)


where:

    C(n,k) = n! / (k!(n-k)!)


Each answer contains:

    k


elements.


Therefore output-sensitive time:

    O(k × C(n,k))


Auxiliary recursion/path space:

    O(k)


Output space:

    O(k × C(n,k))


===========================================================
32. IMPORTANT STATE TRANSITION
===========================================================

This is the most important line:


    solve(n, k, i + 1, ans, op);


Why?

Because:

    i
    =
    candidate we JUST CHOSE


Therefore:

    i + 1
    =
    first candidate allowed
    at the NEXT recursion level


Do NOT write:

    start + 1


unless the problem's state specifically
requires that.


The rule is:


    CURRENT LEVEL:
        start


    CURRENT CHOICE:
        i


    NEXT LEVEL:
        i + 1


===========================================================
33. QUICK STATE TABLE
===========================================================

Example:

    n = 4
    k = 2


-----------------------------------------------------------
STATE 1
-----------------------------------------------------------

    path = []
    start = 1


Choices:

    1 2 3 4


-----------------------------------------------------------
STATE 2
-----------------------------------------------------------

Choose:

    i = 2


Then:

    path = [2]
    start = 3


Choices:

    3 4


-----------------------------------------------------------
STATE 3
-----------------------------------------------------------

Choose:

    i = 4


Then:

    path = [2,4]
    start = 5


Now:

    path.size() == 2


STORE.


===========================================================
34. MOST IMPORTANT MEMORY
===========================================================

COMBINATION:


    START
      ↓
    choose i
      ↓
    add i
      ↓
    recurse(i + 1)
      ↓
    remove i
      ↓
    next i


BASE:

    path.size() == k


STATE:

    path + start


WHY i+1?

    Prevent going backward.


UNDO:

    remove last.


===========================================================
35. FINAL MENTAL MODEL
===========================================================


                         PATH
                           |
                         START
                           |
                    choose candidate i
                           |
                       path.add(i)
                           |
                 path.size() == k?
                    /             \
                  YES              NO
                   |                |
                 STORE         recurse(i+1)
                                    |
                              path.remove(last)
                                    |
                                next candidate


===========================================================
36. THE REAL SKILL
===========================================================

Do NOT memorize:

    for loop
    start
    i + 1
    remove


Understand WHY:


    ORDER DOES NOT MATTER
          ↓
    never go backward
          ↓
    need START boundary
          ↓
    choose i
          ↓
    next candidates begin at i + 1
          ↓
    path stores chosen elements
          ↓
    path.size() == k → complete
          ↓
    remove → restore state


This lets you derive
new combination problems independently.
*/