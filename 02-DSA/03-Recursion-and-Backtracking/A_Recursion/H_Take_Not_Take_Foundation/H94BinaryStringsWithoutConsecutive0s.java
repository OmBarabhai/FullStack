package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H94BinaryStringsWithoutConsecutive0s {
    public static void solve(int n, int prev, int idx, StringBuilder sb) {
        if (idx >= n) {
            System.out.println(sb);
            return;
        }
        sb.append("1");
        solve(n, 1, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (prev == 1) {
            sb.append("0");
            solve(n, 0, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    public static void main(String[] args) {
        int prev = 1;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        int n = 3;
        solve(n, prev, idx, sb);
    }
}
/*
===========================================================
H94 — BINARY STRINGS WITHOUT CONSECUTIVE 0s
===========================================================

Input:

n = 3

Goal:

Generate all binary strings of length N
which do NOT contain consecutive 0s.

Valid:

111
110
101
011
010

Invalid:

000
001
100
because they contain "00".


===========================================================
RECURSION STATE
===========================================================

solve(n, prev, idx, sb)

idx  = current position
prev = previous character

prev = 1
    ↓
0 is allowed

prev = 0
    ↓
0 is NOT allowed

1 is ALWAYS allowed.


===========================================================
MAIN RULE
===========================================================

We always try:

    ADD 1
        ↓
    recurse
        ↓
    backtrack


Then:

    if prev == 1

        ADD 0
            ↓
        recurse
            ↓
        backtrack


Why?

Because we don't want:

    00

Therefore:

If previous character is 0:

    current character CANNOT be 0.

If previous character is 1:

    current character can be 0 or 1.


===========================================================
RECURSION TREE
===========================================================

n = 3


                         ""
                       prev=1
                      /      \
                   ADD 1    ADD 0
                     |         |
                    "1"       "0"
                  prev=1     prev=0
                  /   \          |
              ADD 1  ADD 0     ADD 1
                /       \         |
              "11"      "10"     "01"
             prev=1    prev=0   prev=1
             /  \         |       /  \
           111 110       101     011 010


LEAVES:

111
110
101
011
010


Notice:

From "10":

prev = 0

Therefore:

    ADD 1 → allowed
    ADD 0 → NOT allowed

So:

    10 → 101

but NOT:

    100


===========================================================
DRY RUN
===========================================================

n = 3

START:

idx = 0
prev = 1
sb = ""


-----------------------------------------------------------
STEP 1 — ADD 1
-----------------------------------------------------------

sb = "1"

prev = 1
idx = 1


From "1":

We can add 1.

sb = "11"

prev = 1
idx = 2


ADD 1:

sb = "111"

idx = 3

BASE CASE:

idx >= n

PRINT:

111


BACKTRACK:

sb = "11"


Now ADD 0:

sb = "110"

prev = 0
idx = 3

BASE CASE

PRINT:

110


BACKTRACK:

sb = "11"

BACKTRACK:

sb = "1"


-----------------------------------------------------------
STEP 2 — From "1", ADD 0
-----------------------------------------------------------

sb = "10"

prev = 0
idx = 2


Now:

prev == 0

Therefore:

    0 is NOT allowed.

Only 1 can be added.


ADD 1:

sb = "101"

prev = 1
idx = 3

BASE CASE

PRINT:

101


BACKTRACK:

sb = "10"


BACKTRACK:

sb = "1"


BACKTRACK:

sb = ""


-----------------------------------------------------------
STEP 3 — ROOT ADD 0
-----------------------------------------------------------

sb = "0"

prev = 0
idx = 1


Because:

prev = 0

we CANNOT add another 0.

Therefore:

ONLY ADD 1.


sb = "01"

prev = 1
idx = 2


Now prev = 1.

Therefore:

    ADD 1
    ADD 0


ADD 1:

sb = "011"

idx = 3

PRINT:

011


BACKTRACK:

sb = "01"


ADD 0:

sb = "010"

idx = 3

PRINT:

010


BACKTRACK:

sb = "01"


BACKTRACK:

sb = "0"


BACKTRACK:

sb = ""


===========================================================
FINAL OUTPUT
===========================================================

111
110
101
011
010


===========================================================
IMPORTANT DIFFERENCE FROM H93
===========================================================

H93:

No consecutive 1s

    prev = 1
        ↓
    cannot add 1


H94:

No consecutive 0s

    prev = 0
        ↓
    cannot add 0


So H93 and H94 are the same recursion pattern,
but the restricted character is reversed.


===========================================================
TC / SC
===========================================================

TC = O(2^N)

SC = O(N)

Recursion depth = N
StringBuilder length = N

*/