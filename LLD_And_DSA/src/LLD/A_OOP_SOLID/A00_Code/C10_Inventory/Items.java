package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;

public class Items {
    int itemId;
    String itemName;
    int quantity;
    double price;
    Items(){
        this(0,"Unknown",0,0.0);
    }
    Items(int itemId,String itemName,int quantity,double price){
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.itemName = itemName;
    }
}
