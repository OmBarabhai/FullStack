package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

public class R1G65CalculateNPRRecursively {

    public static int calculateNPRRecursively(int n, int r) {

        // Base Case:
        // nP0 = 1
        if (r == 0) {
            return 1;
        }

        // Recursive:
        // nPr = n × (n-1)P(r-1)
        return n * calculateNPRRecursively(n - 1, r - 1);
    }

    public static void main(String[] args) {

        System.out.println(calculateNPRRecursively(5, 2)); // 20
    }
}

/*
R1 QUICK REVISION

NPR:
nPr = n × (n-1)P(r-1)

Base:
r == 0 → 1

Example:

5P2
↓
5 × 4P1
↓
5 × 4 × 3P0
↓
5 × 4 × 1
↓
20

Recursion:
n decreases
r decreases

Time: O(r)
Space: O(r)
*/