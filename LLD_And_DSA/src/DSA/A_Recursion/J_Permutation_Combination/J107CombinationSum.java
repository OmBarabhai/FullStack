package DSA.A_Recursion.J_Permutation_Combination;

import java.util.ArrayList;

public class J107CombinationSum {
    public static void solve(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> op, int idx, int[] arr, int tar) {
        if (idx >= arr.length) {
            return;
        }
        if (tar == 0) {
            ans.add(new ArrayList<>(op));
            return;
        }
        if (tar < 0) {
            return;
        }
        op.add(arr[idx]);
        solve(ans, op, idx, arr, tar - arr[idx]);
        op.remove(op.size() - 1);
        solve(ans, op, idx + 1, arr, tar);
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> op = new ArrayList<>();
        int[] arr = {2, 3, 6, 7};
        int tar = 7;
        solve(ans, op, 0, arr, tar);
        System.out.println(ans);
    }
}

/*
* ===========================================================
J107 — COMBINATION SUM
arr = [2,3,6,7]
target = 7
===========================================================


                      idx=0, tar=7, op=[]
                              |
                    ---------------------
                    |                   |
                  TAKE                SKIP
                    |                   |
                 take 2              skip 2
                    |                   |
                 idx=0                idx=1
                 tar=5                tar=7
                 [2]                   []
                    |                   |
             --------------        ------------
             |            |        |          |
           TAKE          SKIP    TAKE       SKIP
             |             |        |          |
           take 2        skip 2    take 3     skip 3
             |             |        |          |
          idx=0          idx=1    idx=1       idx=2
          tar=3          tar=5    tar=4       tar=7
          [2,2]          [2]      [3]         []
             |             |        |          |
          --------       -----    -----      -----
          |      |       |   |    |   |      |   |
        TAKE    SKIP    TAKE SKIP TAKE SKIP  TAKE SKIP
          |       |       |    |    |    |      |    |
        +2      skip2   +3  skip3  +3 skip3   +6   skip6
          |       |       |    |    |    |      |    |
       tar=1    tar=3   tar=2 tar=4 tar=1 tar=4 tar=1 tar=7
       [2,2,2]  [2,2]   [2,3] [2]  [3,3] [3] [6]  []
          |        |       |      |     |     |    |    |
        TAKE    ...      ...    ...   ...   ...  ...  SKIP 7
          |
       tar=-1
          |
       RETURN
********************************************************************
                     arr[idx]
                     /    \
                  TAKE    SKIP
                    |        |
               same idx    idx + 1
                    |        |
              reuse allowed next candidate
********************************************************************
Time Complexity

Let:

T = target
m = smallest candidate
n = number of candidates

Because numbers can be reused, the maximum useful depth is approximately:

T / m

At each level there can be branching between taking and skipping candidates, so a simple interview-level upper bound is exponential in the target/depth:

O(2^(T/m))

A more output-aware description is:

Time = exponential in the recursion depth
      + cost of copying every valid combination

The exact number of solutions depends heavily on the input.

Space Complexity

Maximum recursion depth is roughly:

T / m

So auxiliary recursion + current path:

O(T / m)

excluding the returned answer list.

If including output:

O(number_of_solutions × T/m)

approximately, because every stored combination can contain up to T/m elements.
* */