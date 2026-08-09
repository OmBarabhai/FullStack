package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

import java.util.ArrayList;
import java.util.List;

public class R1G66PascalTriangleRowRecursively {
    // Find value at a particular row and column
    public static int pascalTriangle(int row, int col) {

        // Boundary values are always 1
        if (col == 0 || col == row) {
            return 1;
        }

        // Pascal's Triangle:
        // value = upper-left + upper-right
        return pascalTriangle(row - 1, col - 1) + pascalTriangle(row - 1, col);
    }

    public static List<List<Integer>> pascalTriangleRow(int n) {

        List<List<Integer>> ans = new ArrayList<>();

        for (int row = 0; row < n; row++) {

            List<Integer> currentRow = new ArrayList<>();

            for (int col = 0; col <= row; col++) {

                currentRow.add(pascalTriangle(row, col));
            }

            ans.add(currentRow);
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(pascalTriangleRow(5));
    }
}

/*
R1 QUICK REVISION

Pattern:
Pascal Triangle + Recursion

Base:
col == 0 || col == row
→ 1

Recursive:
(row,col)
→ (row-1,col-1) + (row-1,col)

Example:

        1
       1 1
      1 2 1
     1 3 3 1
    1 4 6 4 1

For 2nd row, col 1:

pascalTriangle(2,1)
→ pascalTriangle(1,0)
 + pascalTriangle(1,1)
→ 1 + 1
→ 2

Important:
Each inner value comes from
the two values directly above it.

Time: O(2^n) approximately
Space: O(n) recursion depth
*/