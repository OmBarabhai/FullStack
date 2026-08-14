package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Main {

    public static void main(String[] args) {
        Product p = new Product();
        p.setProduct(123,"iPhone",122232.22,"Mobile");
        System.out.println(p.getPrice());
        System.out.println(p.getProductName());
        System.out.println(p.getCategory());
        System.out.println(p.getProductId());
    }
}