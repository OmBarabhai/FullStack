package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H95BinaryStringsWithExactlyKOnes {
    public static void solve(int n, int k, int idx, int ones, StringBuilder sb) {
        if(idx>=n){
            if(ones == k) {
                System.out.println(sb);
            }
            return;
        }
        if(ones < k){
            sb.append("1");
            solve(n,k,idx+1,ones+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("0");
        solve(n,k,idx+1,ones,sb);
        sb.deleteCharAt(sb.length()-1);
    }

    public static void main(String[] args) {
        int k = 3;
        int idx = 0;
        int ones = 0;
        StringBuilder sb = new StringBuilder();
        int n = 4;
        solve(n, k, idx, ones, sb);
    }
}


/*
===========================================================
H95 — BINARY STRINGS WITH EXACTLY K ONES
===========================================================

Input:

n = 4
k = 3

Goal:

Generate all binary strings of length N
containing EXACTLY K ones.


Expected output:

0111
1011
1101
1110


===========================================================
RECURSION STATE
===========================================================

solve(n, k, idx, ones, sb)

n     = length of binary string
k     = required number of 1s
idx   = current position
ones  = number of 1s currently selected
sb    = current binary string


IMPORTANT:

ones is NOT the previous character.

ones means:

    "How many 1s have I used so far?"


===========================================================
TWO CHOICES
===========================================================

CHOICE 1 → ADD 1

We can add 1 only when:

    ones < k

After adding 1:

    ones = ones + 1


CHOICE 2 → ADD 0

0 does not increase the number of ones.

Therefore:

    ones stays the same.


===========================================================
BASE CASE
===========================================================

if (idx >= n)

means:

    The string has reached length N.

Now check:

    ones == k

If TRUE:

    print string

If FALSE:

    don't print.


===========================================================
RECURSION TREE
===========================================================

For:

n = 4
k = 3


                              ""
                         ones = 0
                         idx = 0
                       /          \
                    ADD 1        ADD 0
                      /             \
                    "1"              "0"
                  ones=1           ones=0
                   /   \            /   \
                ADD1   ADD0      ADD1   ADD0
                  /       \        /       \
                "11"     "10"    "01"      "00"
              ones=2    ones=1   ones=1    ones=0

The tree continues until idx = 4.


Valid leaves are ONLY those with:

    ones = 3


Valid:

0111 → 3 ones
1011 → 3 ones
1101 → 3 ones
1110 → 3 ones


Invalid:

0000 → 0 ones
0011 → 2 ones
0101 → 2 ones
1111 → 4 ones


===========================================================
IMPORTANT PRUNING
===========================================================

Suppose:

k = 3

and:

ones = 3

Then:

    ones < k

becomes:

    3 < 3

FALSE.

Therefore we cannot add another 1.

So:

    "111"

cannot become:

    "1111"

Only 0 is allowed:

    "1110"


===========================================================
DRY RUN
===========================================================

START:

n = 4
k = 3
idx = 0
ones = 0
sb = ""


-----------------------------------------------------------
PATH 1
-----------------------------------------------------------

ADD 0

sb = "0"
ones = 0
idx = 1


ADD 0

sb = "00"
ones = 0
idx = 2


ADD 0

sb = "000"
ones = 0
idx = 3


ADD 0

sb = "0000"
ones = 0
idx = 4

BASE CASE:

ones == k?

0 == 3 → FALSE

Don't print.


BACKTRACK:

sb = "000"


Now ADD 1:

sb = "0001"
ones = 1
idx = 4

1 == 3 → FALSE

Don't print.


Backtrack.


-----------------------------------------------------------
PATH 2
-----------------------------------------------------------

Eventually:

0 → 1 → 1 → 1

sb = "0111"

ones = 3
idx = 4

BASE CASE:

3 == 3 → TRUE

PRINT:

0111


-----------------------------------------------------------
PATH 3
-----------------------------------------------------------

1 → 0 → 1 → 1

sb = "1011"

ones = 3

PRINT:

1011


-----------------------------------------------------------
PATH 4
-----------------------------------------------------------

1 → 1 → 0 → 1

sb = "1101"

ones = 3

PRINT:

1101


-----------------------------------------------------------
PATH 5
-----------------------------------------------------------

1 → 1 → 1 → 0

sb = "1110"

ones = 3

PRINT:

1110


===========================================================
WHY "1111" IS NOT GENERATED
===========================================================

After:

    1
    1
    1

we have:

    ones = 3
    k = 3

Condition:

    ones < k

becomes:

    3 < 3

FALSE.

Therefore the code does NOT execute:

    sb.append("1");

So:

    1111

is never generated.


===========================================================
BACKTRACKING
===========================================================

After every recursive call:

    sb.deleteCharAt(sb.length() - 1);


Example:

sb = "0111"

After returning:

sb = "011"

Then another choice can be explored.


Pattern:

    append
       ↓
    recurse
       ↓
    remove


===========================================================
CORE PATTERN
===========================================================

                    current index
                         |
                  /             \
               ADD 1           ADD 0
                 |                |
            ones + 1          ones same
                 |                |
              recurse          recurse


ADD 1:

if (ones < k)


ADD 0:

always allowed


BASE:

if (idx >= n)

    if (ones == k)
        print


===========================================================
TC / SC
===========================================================

TC = O(N × 2^N)

SC = O(N)

Why TC?

There can be up to 2^N binary strings,
and printing a string costs O(N).

Why SC?

Maximum recursion depth = N
StringBuilder length = N.

*/