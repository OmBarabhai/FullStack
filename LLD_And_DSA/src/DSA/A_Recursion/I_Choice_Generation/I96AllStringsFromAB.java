package DSA.A_Recursion.I_Choice_Generation;

import java.util.ArrayList;

public class I96AllStringsFromAB {
    public static void solve(int idx, int n, StringBuilder sb) {
        if (idx >= n) {
            System.out.println(sb);
            return;
        }
        sb.append('A');
        solve(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('B');
        solve(idx + 1, n, sb);
        sb.deleteCharAt(sb.length() - 1);
    }

    public static void solve(String str, ArrayList<String> ans, int idx, StringBuilder sb) {
        if (idx >= str.length()) {
            ans.add(sb.toString());
            return;
        }
        if (str.charAt(idx) == '1') {
            sb.append('1');
            solve(str, ans, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (str.charAt(idx) == '0') {
            sb.append('0');
            solve(str, ans, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

        }
        if (str.charAt(idx) == '?') {
            sb.append('0');
            solve(str, ans, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);

            sb.append('1');
            solve(str, ans, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        solve(0, n, new StringBuilder());
//=========================================================
        ArrayList<String> ans = new ArrayList<>();
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        String str = "11??00";
        solve(str, ans, idx, sb);
        System.out.println(ans);
    }
}
/*
===========================================================
I96 — GENERATE ALL BINARY STRINGS FROM PATTERN
RECURSION TREE + DRY RUN
===========================================================

INPUT:

str = "1?0"


RULES:

'0'  → only 0
'1'  → only 1
'?'  → 0 OR 1


Expected output:

100
110


===========================================================
RECURSION STATE
===========================================================

solve(str, ans, idx, sb)

idx = current position in the input string

sb = string generated so far


===========================================================
BASE CASE
===========================================================

if (idx >= str.length())

    one complete string has been created

    add sb to ans

    return


===========================================================
RECURSION TREE
===========================================================


                         idx=0
                         str[0]='1'
                            |
                            1
                            |
                         "1"
                         idx=1
                            |
                         str[1]='?'
                         /       \
                       0           1
                      /             \
                   "10"             "11"
                  idx=2            idx=2
                     |                |
                 str[2]='0'       str[2]='0'
                     |                |
                     0                0
                     |                |
                   "100"            "110"
                  idx=3            idx=3
                     |                |
                BASE CASE        BASE CASE
                     |                |
                   PRINT            PRINT
                   100              110


===========================================================
DRY RUN
===========================================================


START:

str = "1?0"

idx = 0
sb = ""


-----------------------------------------------------------
STEP 1 — str[0] = '1'
-----------------------------------------------------------

Current character:

'1'

Only one choice:

    add '1'

sb:

"1"

Call:

solve(str, ans, 1, sb)


After recursive call returns:

BACKTRACK

remove '1'

sb:

""

-----------------------------------------------------------
STEP 2 — idx = 1
-----------------------------------------------------------

Current character:

str[1] = '?'


'?' gives TWO choices:

    0
    1


===========================================================
BRANCH 1 — CHOOSE 0
===========================================================

sb:

"10"


Call:

solve(str, ans, 2, sb)


-----------------------------------------------------------
STEP 3
-----------------------------------------------------------

idx = 2

str[2] = '0'


Only choice:

    add 0


sb:

"100"


Call:

solve(str, ans, 3, sb)


-----------------------------------------------------------
BASE CASE
-----------------------------------------------------------

idx = 3

str.length() = 3

Therefore:

idx >= str.length()

TRUE


Add:

"100"

to answer.


ANS:

[100]


Return.


BACKTRACK:

remove final '0'

sb:

"10"


Return to '?' branch.


BACKTRACK:

remove:

'0'

sb:

"1"


===========================================================
BRANCH 2 — CHOOSE 1
===========================================================

Now from:

sb = "1"

At '?':

choose '1'


sb:

"11"


Call:

solve(str, ans, 2, sb)


-----------------------------------------------------------
STEP 3
-----------------------------------------------------------

idx = 2

str[2] = '0'


Only choice:

    add 0


sb:

"110"


Call:

solve(str, ans, 3, sb)


-----------------------------------------------------------
BASE CASE
-----------------------------------------------------------

idx = 3

Complete string:

"110"


Add to answer.


ANS:

[100, 110]


Return.


BACKTRACK:

sb:

"11"


BACKTRACK:

sb:

"1"


Return from '?'.


BACKTRACK:

sb:

""


===========================================================
FINAL OUTPUT
===========================================================

100
110


===========================================================
IMPORTANT BACKTRACKING
===========================================================

For '?':


Choose 0:

    sb.append('0')
        ↓
    recurse
        ↓
    delete '0'


Then:


Choose 1:

    sb.append('1')
        ↓
    recurse
        ↓
    delete '1'


So:

    CHOOSE
       ↓
    RECURSE
       ↓
    UNDO


===========================================================
WHY FIXED CHARACTERS HAVE ONLY ONE BRANCH
===========================================================

For:

str[idx] = '0'

there is no choice.

Only:

    0

So:

    add 0
    recurse
    undo


For:

str[idx] = '1'

there is no choice.

Only:

    1

So:

    add 1
    recurse
    undo


For:

str[idx] = '?'

there are TWO choices:

    0
    1


===========================================================
GENERAL TREE
===========================================================

For:

    "1?0"

the tree is:


                         ""
                          |
                          1
                          |
                         "1"
                        /   \
                       0     1
                      /       \
                    "10"      "11"
                      |          |
                      0          0
                      |          |
                    "100"      "110"


Number of outputs:

    2

because there is:

    1 '?'


If there are:

    2 '?' → 4 outputs

    3 '?' → 8 outputs

    k '?' → 2^k outputs


===========================================================
TC / SC
===========================================================

Let:

    N = length of string
    K = number of '?' characters


Number of generated strings:

    2^K


Each complete string has length N.

Therefore:

TC = O(N × 2^K)

SC = O(N)

Recursion depth = N
StringBuilder length = N

===========================================================
CORE PATTERN
===========================================================

                current character
                       |
          ┌────────────┼────────────┐
          ↓            ↓            ↓
         '0'          '1'           '?'
          |            |           /   \
        add 0        add 1       add 0 add 1
          |            |           |     |
       recurse      recurse     recurse recurse
          |            |           |     |
        undo         undo        undo   undo
*/