
public class strRep {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String str = "XYZAXYZBXYZC";
        String sub = "XYZ";
        sb.append(str.replaceAll(sub, " "));
        System.out.println(sb.toString().trim());

        StringBuilder sb1 = new StringBuilder();
        String str1 = "LIELIEILIEAMLIECOOL";
        String sub1 = "LIE";
        sb1.append(str1.replaceAll(sub1, " "));
        System.out.println(sb1.toString().trim());

    }
}
