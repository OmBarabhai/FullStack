package DSA.A_Recursion.I_Choice_Generation;

public class I97AllStringsFromDigits012 {
    public static void solve(int n, int idx, StringBuilder sb) {
        if (idx >= n) {
            System.out.print(STR."\{sb} ");
            return;
        }
        for (int i = 0; i < n; i++) {
            sb.append((char) ('0' + i));
            solve(n, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println();
    }
    public static void solve_RecursionChoices(int n, int idx, StringBuilder sb) {
        if (idx >= n) {
            System.out.print(STR."\{sb} ");
            return;
        }
        sb.append("0");
        solve_RecursionChoices(n, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("1");
        solve_RecursionChoices(n, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append("2");
        solve_RecursionChoices(n, idx + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println();
    }
    public static void main(String[] args) {
        solve(3, 0, new StringBuilder());
        solve_RecursionChoices(3, 0, new StringBuilder());
    }
}

/*
===========================================================
I97 — GENERATE ALL STRINGS FROM DIGITS {0,1,2}
RECURSION TREE + DRY RUN
===========================================================

INPUT:

n = 3

At every position, there are THREE choices:

    0
    1
    2


===========================================================
METHOD 1 — LOOP VERSION
===========================================================

solve(n, idx, sb)

At every index:

    for i = 0; i < n; i++

For n = 3:

    i = 0 → '0'
    i = 1 → '1'
    i = 2 → '2'


So the loop automatically creates:

    0
    1
    2


===========================================================
RECURSION TREE
===========================================================

For understanding, use n = 2:


                         ""
                      idx = 0
                   /      |      \
                  0       1       2
                  |       |       |
                idx=1   idx=1   idx=1
                /|\     /|\     /|\
               0 1 2   0 1 2   0 1 2
               | | |   | | |   | | |
              00 01 02 10 11 12 20 21 22


LEAVES:

00
01
02
10
11
12
20
21
22


===========================================================
DRY RUN — LOOP VERSION
===========================================================

START:

n = 2
idx = 0
sb = ""


-----------------------------------------------------------
ROOT
-----------------------------------------------------------

for loop starts:

i = 0

append:

'0'

sb = "0"

call:

solve(2, 1, "0")


-----------------------------------------------------------
SECOND LEVEL
-----------------------------------------------------------

i = 0

append '0'

sb = "00"

idx = 2

BASE CASE:

idx >= n

2 >= 2 → TRUE

PRINT:

00


BACKTRACK:

delete last character

sb = "0"


i = 1

append '1'

sb = "01"

idx = 2

PRINT:

01


BACKTRACK:

sb = "0"


i = 2

append '2'

sb = "02"

idx = 2

PRINT:

02


BACKTRACK:

sb = "0"


Return to root.

BACKTRACK:

sb = ""


-----------------------------------------------------------
ROOT — i = 1
-----------------------------------------------------------

append '1'

sb = "1"

call:

solve(2, 1, "1")


Second level:

i = 0

→ "10"

PRINT


i = 1

→ "11"

PRINT


i = 2

→ "12"

PRINT


BACKTRACK:

sb = ""


-----------------------------------------------------------
ROOT — i = 2
-----------------------------------------------------------

append '2'

sb = "2"

call:

solve(2, 1, "2")


Second level:

i = 0

→ "20"

PRINT


i = 1

→ "21"

PRINT


i = 2

→ "22"

PRINT


BACKTRACK:

sb = ""


===========================================================
FINAL OUTPUT FOR n = 2
===========================================================

00
01
02
10
11
12
20
21
22


===========================================================
FOR n = 3
===========================================================

There are three choices at EACH position:

    0
    1
    2


Therefore:

    3 × 3 × 3

    = 27 strings


Example path:

""
 ↓
choose 0
 ↓
"0"
 ↓
choose 1
 ↓
"01"
 ↓
choose 2
 ↓
"012"


PRINT:

012


===========================================================
BACKTRACKING
===========================================================

The loop follows:

    append
       ↓
    recurse
       ↓
    delete


Example:

sb = "01"

append '2'

sb = "012"

recurse

PRINT 012

BACKTRACK:

sb = "01"


Now the next choice can be tried:

append another choice.


So the same StringBuilder is reused.


===========================================================
METHOD 2 — HARD-CODED RECURSION
===========================================================

Instead of:

    for (int i = 0; i < n; i++)


we manually write:

    append 0
    recurse
    undo

    append 1
    recurse
    undo

    append 2
    recurse
    undo


This creates the EXACT SAME recursion tree.


===========================================================
HARD-CODED TREE
===========================================================

                         ""
                      idx = 0
                   /      |      \
                  0       1       2
                  |       |       |
                idx=1   idx=1   idx=1
                /|\     /|\     /|\
               0 1 2   0 1 2   0 1 2
               | | |   | | |   | | |
              00 01 02 10 11 12 20 21 22


===========================================================
HARD-CODED DRY RUN
===========================================================

START:

sb = ""


ADD 0:

sb = "0"

    ADD 0:
        "00"
        PRINT

    BACKTRACK

    ADD 1:
        "01"
        PRINT

    BACKTRACK

    ADD 2:
        "02"
        PRINT

    BACKTRACK


BACKTRACK ROOT:

sb = ""


ADD 1:

sb = "1"

    ADD 0:
        "10"
        PRINT

    ADD 1:
        "11"
        PRINT

    ADD 2:
        "12"
        PRINT


BACKTRACK ROOT:

sb = ""


ADD 2:

sb = "2"

    ADD 0:
        "20"
        PRINT

    ADD 1:
        "21"
        PRINT

    ADD 2:
        "22"
        PRINT


FINAL:

00
01
02
10
11
12
20
21
22


===========================================================
LOOP VS HARD-CODED
===========================================================

LOOP:

    for each choice
        choose
        recurse
        undo


HARD-CODED:

    choose 0
    recurse
    undo

    choose 1
    recurse
    undo

    choose 2
    recurse
    undo


Both create the SAME recursion tree.


===========================================================
CORE PATTERN OF I97
===========================================================

H PATTERN:

    TAKE
    NOT-TAKE

I97:

    CHOICE 0
    CHOICE 1
    CHOICE 2


GENERAL CHOICE GENERATION:

    for every possible choice

        choose
        ↓
        recurse
        ↓
        undo


===========================================================
TC / SC
===========================================================

There are:

    3 choices

at every position.

Therefore:

    3^N strings

Each string has length N.

TC = O(N × 3^N)

SC = O(N)

because:

    recursion depth = N
    StringBuilder length = N
*/