package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public  class G76DecimalRepresentationFromBinaryRecursively {

    public static int binaryToDecimal(String bin){
            if(bin.length() - 1 == 0){
                return 1;
            }
            char last = bin.charAt(bin.length()-1);
            String rem = bin.substring(0,bin.length() -1);
            int prev = binaryToDecimal(rem);
            int lastBit = last - '0';
            return prev * 2 + lastBit;
    }
    public static void main(String[] args) {
        System.out.println(binaryToDecimal("1011"));
    }
}

/*
 * G76 - Decimal Representation from Binary Recursively
 *
 * Example:
 *
 *     1011 -> 11
 *
 * ============================================================
 * CORE IDEA
 * ============================================================
 *
 * We remove the last binary digit recursively.
 *
 *     1011
 *      ↓
 *     101
 *      ↓
 *     10
 *      ↓
 *     1
 *
 * At the base case, "1" returns 1.
 *
 * While recursion returns back:
 *
 *     previous * 2 + currentBit
 *
 * ============================================================
 * RECURSION TREE
 * ============================================================
 *
 * binaryToDecimal("1011")
 *          |
 *          ↓
 * binaryToDecimal("101")
 *          |
 *          ↓
 * binaryToDecimal("10")
 *          |
 *          ↓
 * binaryToDecimal("1")
 *          |
 *          ↓
 *       return 1
 *
 *
 * ============================================================
 * UNWINDING / RETURN
 * ============================================================
 *
 * "1"
 *  ↓
 * 1
 *
 * "10"
 *  ↓
 * 1 * 2 + 0 = 2
 *
 * "101"
 *  ↓
 * 2 * 2 + 1 = 5
 *
 * "1011"
 *  ↓
 * 5 * 2 + 1 = 11
 *
 *
 * Final answer:
 *
 *     1011 -> 11
 *
 * ============================================================
 * PERMANENT PATTERN
 * ============================================================
 *
 * GOING DOWN:
 *
 *     Remove last digit
 *          ↓
 *     Solve smaller problem
 *
 * RETURNING UP:
 *
 *     previous * 2 + current bit
 *
 * So:
 *
 *     Binary → Decimal
 *
 *     recursion:
 *         smaller prefix
 *
 *     unwinding:
 *         previous * 2 + currentBit
 *

    public static int binaryToDecimal(String bin) {

        // BASE CASE:
        // When only one binary digit remains.
        //
        // Example:
        // "1" -> 1
        if (bin.length() - 1 == 0) {
            return 1;
        }

        // Get the last binary digit.
        //
        // Example:
        // "1011" -> '1'
        char last = bin.charAt(bin.length() - 1);

        // Remove the last digit.
        //
        // Example:
        // "1011" -> "101"
        String rem = bin.substring(0, bin.length() - 1);

        // Recursively convert the remaining prefix.
        //
        // Example:
        // binaryToDecimal("1011")
        //     -> binaryToDecimal("101")
        //         -> binaryToDecimal("10")
        //             -> binaryToDecimal("1")
        int prev = binaryToDecimal(rem);

        // Convert character '0'/'1' into integer 0/1.
        //
        // '0' - '0' = 0
        // '1' - '0' = 1
        int lastBit = last - '0';

        // Rebuild the decimal value while recursion returns.
        //
        // Example:
        //
        // "10":
        // 1 * 2 + 0 = 2
        //
        // "101":
        // 2 * 2 + 1 = 5
        //
        // "1011":
        // 5 * 2 + 1 = 11
        return prev * 2 + lastBit;
    }

    public static void main(String[] args) {

        System.out.println(binaryToDecimal("1011"));

        // Output:
        // 11
    }
}

 */