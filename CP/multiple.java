import java.util.*;
public class multiple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if (A % B == 0 || B % A == 0) {
            System.out.print("Multiples");
        } else {
            System.out.print("No Multiples");
        }
    }
}
