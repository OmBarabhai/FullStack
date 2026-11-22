package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Product {
    private int productId;
    private String productName;
   private double price;
    private String category;

    public void setProduct(int productId, String productName, double price, String category) {
        if(price > 0){
            this.price = price;
        }
        this.productId = productId;
        this.category = category;
        this.productName = productName;
    }
    public int getProductId(){
        return productId;
    }
    public String getCategory(){
        return category;
    }
    public double getPrice(){
        return price;
    }
    public String getProductName(){
        return productName;
    }
}
