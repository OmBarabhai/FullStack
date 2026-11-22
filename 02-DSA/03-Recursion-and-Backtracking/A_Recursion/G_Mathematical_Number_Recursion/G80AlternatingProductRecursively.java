package DSA.A_Recursion.G_Mathematical_Number_Recursion;

public class G80AlternatingProductRecursively {
    public static int alternatingProduct(int n){
        if(n <= 0){
            return 1;
        }
       return n * alternatingProduct(n-2);
    }

    public static void main(String[] args) {
        System.out.println(alternatingProduct(5)); //5 * 3 = 15, 15 * 1 = 15
    }
}