import java.util.Scanner;

public class lastDig {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String m = sc.next();
        int x = n.charAt(n.length() - 1) - '0';
        int y = m.charAt(m.length() - 1) - '0';
        System.out.print(x + y);

        // int a = sc.nextInt();
        // int b = sc.nextInt();
        // System.out.println((a%10) + (b%10));
    }
}
