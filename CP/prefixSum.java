import java.util.Scanner;

public class prefixSum {

    static long f(long x) {
        return x * (x + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long l = sc.nextLong();
            long r = sc.nextLong();
            if (l > r) {
                long temp = l;
                l = r;
                r = temp;
            }
            long ans = f(r) - f(l - 1);
            System.out.println(ans);
        }

    }
}
