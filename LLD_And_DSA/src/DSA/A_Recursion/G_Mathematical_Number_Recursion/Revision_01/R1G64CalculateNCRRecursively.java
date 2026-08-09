package DSA.A_Recursion.G_Mathematical_Number_Recursion.Revision_01;

public class R1G64CalculateNCRRecursively {

    public static int calculateNCRRecursively(int n, int r) {
        // Base Cases
        if (r == 0 || r == n) {
            return 1;
        }
        // Pascal's Identity
        return calculateNCRRecursively(n - 1, r - 1) + calculateNCRRecursively(n - 1, r);
    }

    public static void main(String[] args) {
        System.out.println(calculateNCRRecursively(5, 2)); // 10
    }
}

/*
R1 QUICK REVISION

NCR:
nCr = (n-1)C(r-1) + (n-1)Cr

Base:
r == 0 → 1
r == n → 1

Example:

  5C2
   ↓
4C1 + 4C2
   ↓
3C0 + 3C1 + 3C1 + 3C2
   ↓
1 + 3 + 3 + 3
   ↓
  10

Important:
The two recursive calls are NOT the same.

Correct:
(n-1, r-1)
(n-1, r)

Time: O(2^n)
Space: O(n)
*/