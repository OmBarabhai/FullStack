
import java.util.Scanner;

public class sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(),c = sc.nextInt();
        int x = a, y = b, z = c;
        // 
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        if (b > c) {
            int temp = b;
            b = c;
            c = temp;
            if (a > b) {
                temp = a;
                a = b;
                b = temp;
            }
        }
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println();
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

        
    }
}
