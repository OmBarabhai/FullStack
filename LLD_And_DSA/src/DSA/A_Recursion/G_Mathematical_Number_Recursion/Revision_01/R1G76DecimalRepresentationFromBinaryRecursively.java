public class R1G76DecimalRepresentationFromBinaryRecursively {
    public static int binaryToDecimal(String bin){
        if(bin.length() - 1 == 0){
            return 1;
        }
        char last = bin.charAt(bin.length()-1);
        String rem = bin.substring(0,bin.length()-1);
        int prev = binaryToDecimal(rem);
        int lastDig = last - '0';
        return prev * 2 + last;
    }
    public static void main(String[] args) {

    }
}