package DSA.A_Recursion.H_Take_Not_Take_Foundation;

public class H92GenerateAllBinaryStringsOfLengthN {
    public static void solve(int n,int idx,StringBuilder sb){
        if(idx>=n){
            System.out.println(sb);
            return;
        }
        sb.append("0");
        solve(n,idx+1,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("1");
        solve(n,idx+1,sb);
        sb.deleteCharAt(sb.length()-1);

    }
    public static void main(String[] args) {
            int n = 4;
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            solve(n,idx,sb);
    }
}
/*
===========================================================
H92 — GENERATE ALL BINARY STRINGS OF LENGTH N
===========================================================

Input:

n = 4

We need to generate every possible binary string
of length 4.

At every position we have exactly TWO choices:

    0
    1

Therefore:

    2 choices × 2 choices × 2 choices × 2 choices

    = 2^4

Output:

0000
0001
0010
0011
0100
0101
0110
0111
1000
1001
1010
1011
1100
1101
1110
1111


===========================================================
RECURSION STATE
===========================================================

solve(n, idx, sb)

idx = current position we are filling

sb = binary string constructed so far


At every idx:

    TAKE 0
        ↓
    recurse
        ↓
    BACKTRACK

    TAKE 1
        ↓
    recurse
        ↓
    BACKTRACK


There is NO restriction here.

Both 0 and 1 are always allowed.


===========================================================
RECURSION TREE
===========================================================

For easier understanding, use n = 3:

                         ""
                       idx=0
                      /      \
                    0          1
                  idx=1      idx=1
                 /    \      /    \
                00     01   10     11
              idx=2  idx=2 idx=2 idx=2
              /  \    / \   / \    / \
            000 001 010 011 100 101 110 111


Leaves:

000
001
010
011
100
101
110
111


For n = 4, every leaf gets one more
0/1 choice.


The important structure is:

                         ""
                       /    \
                      0      1
                     / \    / \
                   00  01 10  11
                  / \  / \ / \ / \
                000 001 ... ... 111

Every level represents ONE position.

Level 0 → no characters
Level 1 → 1 character
Level 2 → 2 characters
Level 3 → 3 characters
Level 4 → complete string


===========================================================
DRY RUN
===========================================================

n = 3

Start:

idx = 0
sb = ""


-----------------------------------------------------------
STEP 1
-----------------------------------------------------------

Append 0:

sb = "0"

Call:

solve(n, 1, "0")


-----------------------------------------------------------
STEP 2
-----------------------------------------------------------

Append 0:

sb = "00"

Call:

solve(n, 2, "00")


Append 0:

sb = "000"

idx = 3

BASE CASE:

idx >= n

Print:

000


BACKTRACK:

remove last character

sb = "00"


Now append 1:

sb = "001"

idx = 3

BASE CASE

Print:

001


BACKTRACK:

sb = "00"


BACKTRACK:

sb = "0"


-----------------------------------------------------------
STEP 3
-----------------------------------------------------------

Now from "0":

Append 1:

sb = "01"

Call:

solve(n, 2, "01")


Append 0:

sb = "010"

idx = 3

Print:

010


BACKTRACK:

sb = "01"


Append 1:

sb = "011"

idx = 3

Print:

011


BACKTRACK:

sb = "01"

BACKTRACK:

sb = "0"


BACKTRACK:

sb = ""


-----------------------------------------------------------
STEP 4
-----------------------------------------------------------

Now root takes 1:

sb = "1"

Call:

solve(n, 1, "1")


From "1":

Append 0:

sb = "10"


Then:

    100
    101

are generated.


BACKTRACK.


Then append 1:

sb = "11"


Then:

    110
    111

are generated.


Final output:

000
001
010
011
100
101
110
111


===========================================================
WHY BACKTRACKING?
===========================================================

After exploring:

    sb = "000"

we remove the last character:

    sb = "00"

Then we can change the last choice:

    00 + 1

giving:

    001


So:

    append
       ↓
    recurse
       ↓
    remove

is the standard backtracking pattern.


===========================================================
CODE FLOW
===========================================================

sb.append("0");

solve(n, idx + 1, sb);

sb.deleteCharAt(sb.length() - 1);


Then:


sb.append("1");

solve(n, idx + 1, sb);

sb.deleteCharAt(sb.length() - 1);


Meaning:

    Choose 0
       ↓
    Explore everything
       ↓
    Undo 0
       ↓
    Choose 1
       ↓
    Explore everything
       ↓
    Undo 1


===========================================================
BASE CASE
===========================================================

if (idx >= n)

means:

    We have filled all N positions.

Therefore:

    System.out.println(sb);


Example:

n = 4

idx = 4

sb = "1011"

The string is complete.


===========================================================
TC / SC
===========================================================

Number of strings:

    2^N

Each string has N characters.

Therefore:

TC = O(N × 2^N)

SC = O(N)

Recursion depth = N
StringBuilder length = N


IMPORTANT:

The previous H81 problem also had 2^N subsequences,
but H92 explicitly generates binary strings.

H92:

    Every position → exactly 2 choices

    0 or 1
*/