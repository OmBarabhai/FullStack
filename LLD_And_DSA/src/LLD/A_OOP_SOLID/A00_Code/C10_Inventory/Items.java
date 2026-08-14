package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;

public class Items {
    private int itemId;
    private String itemName;
    private int quantity;
    private double price;

    public void setItems(int itemId, String itemName, int quantity, double price) {
        this.itemId = itemId;
        if (quantity >= 0) {
            this.quantity = quantity;
        }
        if(price> 0) {
            this.price = price;
        }
        this.itemName = itemName;
    }
    public int getItemId(){
        return itemId;
    }
    public String getItemName(){
        return itemName;
    }
    public int getQuantity(){
        return quantity;
    }
    public double getPrice(){
        return price;
    }
}
