package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Product {
    int productId;
    String productName;
    double price;
    String category;

    Product() {
        this(0, "Unknown", 0.0, "Unknown");
    }

    Product(int productId, String productName, double price, String category) {
        this.price = price;
        this.productId = productId;
        this.category = category;
        this.productName = productName;
    }
}
