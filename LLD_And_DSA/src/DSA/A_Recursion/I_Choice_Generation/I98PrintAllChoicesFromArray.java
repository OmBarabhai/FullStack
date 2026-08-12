package DSA.A_Recursion.I_Choice_Generation;

import java.util.ArrayList;
import java.util.List;

public class I98PrintAllChoicesFromArray {
    public static void solve(int idx,int[] arr, List<Integer> ans){
        if(idx>=arr.length){
            System.out.println(ans);
            return;
        }
        for(int i =0;i<arr.length;i++){
            ans.add(arr[i]);
            solve(idx+1,arr,ans);
            ans.remove(ans.size()-1);
        }
    }

    public static void main(String[] args) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = {11,22,33};
        int idx = 0;
        solve(idx,arr,ans);
    }
}

/*
===========================================================
I98 — PRINT ALL CHOICES FROM AN ARRAY
RECURSION TREE + DRY RUN
===========================================================

INPUT:

arr = [11, 22, 33]

Goal:

At EVERY position, we can choose ANY element
from the array.

Therefore:

    position
       |
    ┌──┼──┐
    11 22 33


===========================================================
CORE RECURSION
===========================================================

solve(idx, arr, ans)

idx = current position
ans = current choice sequence


At each position:

    for every element in arr

        CHOOSE element
            ↓
        RECURSE
            ↓
        UNDO choice


This is:

    CHOOSE
       ↓
    RECURSE
       ↓
    BACKTRACK


===========================================================
BASE CASE
===========================================================

if (idx >= arr.length)

    A complete sequence has been created.

    print(ans)

    return


For:

    arr.length = 3

we stop when:

    idx == 3


===========================================================
RECURSION TREE
===========================================================

For easier understanding, use length = 2:

arr = [11,22,33]


                         []
                    idx = 0
                 /      |      \
               11       22       33
               |        |        |
             idx=1    idx=1    idx=1
             /|\      /|\      /|\
            11 22 33 11 22 33 11 22 33


Complete sequences:

[11,11]
[11,22]
[11,33]

[22,11]
[22,22]
[22,33]

[33,11]
[33,22]
[33,33]


===========================================================
DRY RUN
===========================================================

START:

idx = 0
ans = []


-----------------------------------------------------------
FIRST CHOICE — 11
-----------------------------------------------------------

Choose:

11

ans = [11]

Call:

solve(1, arr, ans)


Now:

idx = 1

Again we can choose ANY element.


Choose 11:

ans = [11,11]

idx = 2

BASE CASE:

print:

[11,11]


BACKTRACK:

remove 11

ans = [11]


Choose 22:

ans = [11,22]

idx = 2

BASE CASE:

print:

[11,22]


BACKTRACK:

ans = [11]


Choose 33:

ans = [11,33]

idx = 2

BASE CASE:

print:

[11,33]


BACKTRACK:

ans = []


-----------------------------------------------------------
SECOND CHOICE — 22
-----------------------------------------------------------

Choose:

22

ans = [22]

idx = 1


Choose 11:

[22,11]

PRINT


BACKTRACK


Choose 22:

[22,22]

PRINT


BACKTRACK


Choose 33:

[22,33]

PRINT


BACKTRACK:


ans = []


-----------------------------------------------------------
THIRD CHOICE — 33
-----------------------------------------------------------

Choose:

33

ans = [33]

idx = 1


Choose 11:

[33,11]

PRINT


BACKTRACK


Choose 22:

[33,22]

PRINT


BACKTRACK


Choose 33:

[33,33]

PRINT


BACKTRACK:


ans = []


===========================================================
FINAL OUTPUT FOR LENGTH 2
===========================================================

[11,11]
[11,22]
[11,33]

[22,11]
[22,22]
[22,33]

[33,11]
[33,22]
[33,33]


===========================================================
FOR arr = [11,22,33] AND LENGTH = 3
===========================================================

At each of 3 positions:

    3 choices

Therefore:

    3 × 3 × 3

    = 27 sequences


Examples:

[11,11,11]
[11,11,22]
[11,11,33]

[11,22,11]
[11,22,22]
[11,22,33]

...

[33,33,33]


===========================================================
WHY THE LOOP IS REQUIRED
===========================================================

Your previous code without a loop:

    ans.add(arr[idx]);
    solve(idx + 1, arr, ans);

makes only ONE choice:

    idx 0 → arr[0]
    idx 1 → arr[1]
    idx 2 → arr[2]


So it creates only:

    [11,22,33]


I98 needs:

    arr[0]
    OR
    arr[1]
    OR
    arr[2]

at EVERY position.

Therefore:

    for loop = required


===========================================================
LOOP VERSION
===========================================================

for (int i = 0; i < arr.length; i++) {

    ans.add(arr[i]);

    solve(idx + 1, arr, ans);

    // BACKTRACK
    ans.remove(ans.size() - 1);
}


The loop means:

    i = 0 → choose 11
    i = 1 → choose 22
    i = 2 → choose 33


===========================================================
BACKTRACKING
===========================================================

Suppose:

ans = [11,22]

After printing:

[11,22]

we remove:

22

Now:

ans = [11]

Then we can try:

33

giving:

[11,33]


So:

    CHOOSE
       ↓
    RECURSE
       ↓
    UNDO


is essential.


===========================================================
IMPORTANT DIFFERENCE FROM I97
===========================================================

I97:

    choices are fixed:

    0
    1
    2


I98:

    choices come from the array:

    arr[0]
    arr[1]
    arr[2]
    ...


General idea:

    position
       ↓
    iterate through choices
       ↓
    choose one
       ↓
    recurse
       ↓
    undo


===========================================================
REUSE
===========================================================

The same array element CAN be chosen again.

Example:

    [11,11]

is valid.

Also:

    [22,22]

and:

    [33,33]


Because every position independently chooses
from the complete array.


===========================================================
TC / SC
===========================================================

For:

    N elements
    N positions

Number of generated sequences:

    N^N


Each sequence has N elements.

Therefore:

TC = O(N × N^N)

SC = O(N)

Maximum recursion depth = N
Current path size = N


===========================================================
CORE PATTERN
===========================================================

                CURRENT POSITION
                       |
                ┌──────┼──────┐
                ↓      ↓      ↓
              arr[0] arr[1] arr[2]
                |      |      |
             recurse recurse recurse
                |      |      |
              undo    undo    undo


I98:

    MULTIPLE CHOICES
         ↓
       LOOP
         ↓
      CHOOSE
         ↓
      RECURSE
         ↓
       UNDO
*/