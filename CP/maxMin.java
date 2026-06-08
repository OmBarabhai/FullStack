import java.util.*;

public class maxMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(),b = sc.nextLong(), c = sc.nextLong();
        System.out.println(Math.min(a, Math.min(b, c))+ " " +  Math.max(a, Math.max(b, c)));
    }
}
