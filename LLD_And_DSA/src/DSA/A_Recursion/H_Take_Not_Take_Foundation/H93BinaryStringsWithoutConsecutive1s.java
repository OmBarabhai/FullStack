package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H93BinaryStringsWithoutConsecutive1s {
    public static void solve(int n, int idx, int prev, StringBuilder sb) {
        if(idx >= n){
            System.out.println(sb);
            return;
        }
        sb.append("0");
        solve(n,idx+1,0,sb);
        sb.deleteCharAt(sb.length() -1);

        if(prev == 0){
            sb.append("1");
            solve(n,idx+1,1,sb);
            sb.deleteCharAt(sb.length() -1);

        }
    }

    public static void main(String[] args) {
        int n = 3;
        int idx = 0;
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        solve(n, idx, prev, sb);
    }
}

/*
===========================================================
H93 — BINARY STRINGS WITHOUT CONSECUTIVE 1s
===========================================================

Input:
n = 3

We need to generate all binary strings of length 3
which do NOT contain "11".

Valid:
000
001
010
100
101

Invalid:
011
110
111


===========================================================
RECURSION STATE
===========================================================

solve(n, idx, prev, sb)

idx  = current position
prev = previous character

prev = 0 → previous character was 0
prev = 1 → previous character was 1

Rules:

If prev == 0:
    We can add 0 OR 1

If prev == 1:
    We can add ONLY 0


===========================================================
IMPORTANT STATE CHANGE
===========================================================

When we add 0:

    prev becomes 0

When we add 1:

    prev becomes 1


Example:

"1"
 ↓
prev = 1

Add 0:

"10"
 ↓
prev = 0

Now 1 is allowed:

"101"


===========================================================
RECURSION TREE
===========================================================


                          ""
                     idx=0, prev=0
                       /        \
                    ADD 0      ADD 1
                      /          \
                     0            1
                 prev=0        prev=1
                  /   \            |
              ADD 0  ADD 1      ADD 0
                /       \          |
               00        01        10
            prev=0     prev=1    prev=0
             /  \         |       /  \
         ADD 0 ADD 1    ADD 0  ADD 0 ADD 1
           /      \        |      |      |
         000      001     010    100    101


LEAF OUTPUT:

000
001
010
100
101


===========================================================
WHY DOES "11" NEVER APPEAR?
===========================================================

Suppose we have:

"1"

prev = 1

At this point:

    if (prev == 0)

is false.

Therefore we CANNOT execute:

    add 1

Only 0 is allowed.

So:

"1"
 ↓
"10"

Never:

"11"


===========================================================
DRY RUN
===========================================================


START:

idx = 0
prev = 0
sb = ""


-----------------------------------------------------------
STEP 1
-----------------------------------------------------------

TAKE 0

sb = "0"
prev = 0
idx = 1


-----------------------------------------------------------
STEP 2
-----------------------------------------------------------

From "0":

TAKE 0

sb = "00"
prev = 0
idx = 2


TAKE 0

sb = "000"
prev = 0
idx = 3

idx >= n

PRINT:

000


BACKTRACK:

sb = "00"


Now TAKE 1:

sb = "001"
prev = 1
idx = 3

PRINT:

001


BACKTRACK:

sb = "00"

BACKTRACK:

sb = "0"


-----------------------------------------------------------
STEP 3
-----------------------------------------------------------

From "0":

TAKE 1

sb = "01"
prev = 1
idx = 2


Because prev = 1:

1 is NOT allowed.

Only 0:

sb = "010"
prev = 0
idx = 3

PRINT:

010


BACKTRACK:

sb = "01"

BACKTRACK:

sb = "0"


BACKTRACK:

sb = ""


-----------------------------------------------------------
STEP 4
-----------------------------------------------------------

From root:

TAKE 1

sb = "1"
prev = 1
idx = 1


Because prev = 1:

1 is NOT allowed.

Only 0:

sb = "10"
prev = 0
idx = 2


Now prev = 0.

Therefore we have TWO choices.


TAKE 0:

sb = "100"
prev = 0
idx = 3

PRINT:

100


BACKTRACK:

sb = "10"


TAKE 1:

sb = "101"
prev = 1
idx = 3

PRINT:

101


BACKTRACK:

sb = "10"


BACKTRACK:

sb = "1"


BACKTRACK:

sb = ""


===========================================================
FINAL OUTPUT
===========================================================

000
001
010
100
101


===========================================================
CORE PATTERN
===========================================================

At every index:

    Add 0
        ↓
    prev = 0
        ↓
    recurse


    Add 1
        ↓
    ONLY if prev == 0
        ↓
    prev = 1
        ↓
    recurse


===========================================================
TC / SC
===========================================================

TC = O(2^N)

SC = O(N)

Why?

Maximum recursion depth = N.

At each position there can be up to 2 choices.

Therefore the recursion tree is exponential.
*/