import java.util.*;

public class problem71A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            // String arr[] = s.split(" ");
            int count = 0;
            if (s.length() > 10) {
                for (char i = 0; i < s.length() - 2; i++) {
                    // char ch = s.charAt(i);
                    count++;
                }
                System.out.println(""+s.charAt(0) + count + s.charAt(s.length()-1));

            }else System.out.println(s);
        }
    }
}
