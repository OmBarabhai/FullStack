
public class INC_DEC_41_50 {

    static void problem41(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void problem42(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void problem43(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void problem44(int n) {
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void problem45(int n) {
        for (int i = 1; i <= n; i++) {
            for (int s = 1; s <= n - i; s++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void problem46(int n) {
        for (int i = n; i >= 1; i--) {
            for (int s = 0; s < n - i; s++) {
                System.out.print("  ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void problem47(int n) {
        for (int i = 1; i <= n; i++) {
            int odd = 1;
            for (int j = 1; j <= i; j++) {
                System.out.print(odd + " ");
                odd += 2;
            }
            System.out.println();
        }
    }

    static void problem48(int n) {
        for (int i = 1; i <= n; i++) {
            int even = 2;
            for (int j = 1; j <= i; j++) {
                System.out.print(even + " ");
                even += 2;
            }
            System.out.println();
        }
    }

    static void problem49(int n) {
        for (int i = 1; i <= n; i++) {
            char ch = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    static void problem50(int n) {
        for (int i = n; i >= 1; i--) {
            char ch = 'A';
            for (int j = 1; j <= i; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("===== Problem 41 =====");
        problem41(5);
        System.out.println("\n===== Problem 42 =====");
        problem42(5);
        System.out.println("\n===== Problem 43 =====");
        problem43(5);
        System.out.println("\n===== Problem 44 =====");
        problem44(5);
        System.out.println("\n===== Problem 45 =====");
        problem45(5);
        System.out.println("\n===== Problem 46 =====");
        problem46(5);
        System.out.println("\n===== Problem 47 =====");
        problem47(5);
        System.out.println("\n===== Problem 48 =====");
        problem48(5);
        System.out.println("\n===== Problem 49 =====");
        problem49(5);
        System.out.println("\n===== Problem 50 =====");
        problem50(5);
    }
}
