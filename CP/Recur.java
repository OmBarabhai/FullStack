
import java.util.Scanner;

public class Recur {

    static int fact(int n) {
        if (n == 0) {
            return 1;
        }
        return n * fact(n - 1);
    }

    static int pow(int n) {
        if (n == 0) {
            return 1;
        }
        return 2 * pow(n - 1);
    }

    static int fib(int n) {
        System.out.println("Enter: " + n);

        if (n == 1) {
            System.out.println("Return 1");
            return 1;
        }

        if (n == 0) {
            System.out.println("Return 0");
            return 0;
        }

        int ans = fib(n - 1) + fib(n - 2);

        System.out.println("fib(" + n + ") = " + ans);

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // long a = sc.nextLong(),b = sc.nextLong(), c = sc.nextLong();
        // System.out.println(Math.min(a, Math.min(b, c))+ " " +  Math.max(a, Math.max(b, c)));
        int n = sc.nextInt();
        int fact = fact(n);

        System.out.println(fact);
        int pow = pow(n);

        System.out.println(pow);
        int fib = fib(n);

        System.out.println(fib);

    }
}
