package DSA.A_Recursion.G_Mathematical_Number_Recursion;

import java.util.ArrayList;
import java.util.List;

public class G74GenerateGrayCodeRecursively {

    public static void solve(int n, List<Integer> partial, List<List<Integer>> res) {

        // Base case: 2^n numbers are generated
        if (partial.size() == (1 << n)) {
            res.add(new ArrayList<>(partial));
            return;
        }

        // Try changing every bit
        for (int idx = 0; idx < n; idx++) {

            int last = partial.get(partial.size() - 1);

            // Flip the idx-th bit
            int temp = last ^ (1 << idx);

            // Continue only if the number is not already used
            if (!partial.contains(temp)) {

                // Choose
                partial.add(temp);

                // Explore
                solve(n, partial, res);

                // Undo choice
                partial.remove(partial.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int n = 3;

        List<Integer> partial = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        partial.add(0);

        solve(n, partial, res);

        System.out.println(res.get(0));
    }
}

/*
============================================================
G74 - GENERATE GRAY CODE RECURSIVELY
============================================================

n = 3

Required numbers:
2^3 = 8

Start:
[0]


============================================================
DRY RUN
============================================================

last = 0

idx = 0

temp = 0 ^ (1 << 0)
     = 0 ^ 1
     = 1

[0, 1]


------------------------------------------------------------

last = 1

idx = 0

temp = 1 ^ 1
     = 0

0 already exists → skip


idx = 1

temp = 1 ^ 2
     = 3

[0, 1, 3]


------------------------------------------------------------

last = 3

idx = 0

temp = 3 ^ 1
     = 2

[0, 1, 3, 2]


------------------------------------------------------------

last = 2

idx = 0 → 3 → already exists
idx = 1 → 0 → already exists
idx = 2

temp = 2 ^ 4
     = 6

[0, 1, 3, 2, 6]


------------------------------------------------------------

6 → 7

[0, 1, 3, 2, 6, 7]


7 → 5

[0, 1, 3, 2, 6, 7, 5]


5 → 4

[0, 1, 3, 2, 6, 7, 5, 4]


size = 8

SAVE


============================================================
RECURSION TREE
============================================================

                    [0]
                     |
                  idx 0
                     |
                    [1]
                     |
                  idx 1
                     |
                   [3]
                     |
                  idx 0
                     |
                   [2]
                     |
                  idx 2
                     |
                   [6]
                     |
                  idx 0
                     |
                   [7]
                     |
                  idx 1
                     |
                   [5]
                     |
                  idx 0
                     |
                   [4]
                     |
                   SAVE


============================================================
BACKTRACKING
============================================================

Choose:
partial.add(temp)

Explore:
solve(n, partial, res)

Undo:
partial.remove(partial.size() - 1)


Pattern:

CHOOSE
   ↓
RECURSE
   ↓
UNDO


============================================================
KEY IDEAS
============================================================

1 << n
→ 2^n
→ total Gray Code numbers

1 << idx
→ selects the bit to flip

last ^ (1 << idx)
→ flips one bit

partial.contains(temp)
→ prevents duplicate numbers

new ArrayList<>(partial)
→ saves a copy of the completed path

============================================================
OUTPUT
============================================================

[0, 1, 3, 2, 6, 7, 5, 4]

*/