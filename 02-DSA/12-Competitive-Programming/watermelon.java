
import java.util.*;

public class watermelon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();

        if (w > 2 && (w & 1) == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

import java.util.*;
 
public class watermelon {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
       
        if (w<2 && (w & 1) == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
 
        }
    }
}
