package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;
public class Main {
    public static void main(String[] args) {
        Items i = new Items();
        i.setItems(101,"Keyboard",50,999.99);
        System.out.println(i.getItemId());
        System.out.println(i.getItemName());
        System.out.println(i.getQuantity());
        System.out.println(i.getPrice());

//        Items i1 = new Items(101,"Keyboard",50,999.99);
//        Items i2 = new Items(102,"Mouse",80,599.99);
//        Items i3 = new Items(103,"Monitor",25,12999.99);
//        Items i4 = new Items(104,"Laptop",15,65999.99);
//        Items i5 = new Items(105,"Headphones",40, 2499.99);
//        System.out.println(i0.itemId + " " + i0.itemName + " " + i0.quantity + " " + i0.price);
//        System.out.println(i1.itemId + " " + i1.itemName + " " + i1.quantity + " " + i1.price);
//        System.out.println(i2.itemId + " " + i2.itemName + " " + i2.quantity + " " + i2.price);
//        System.out.println(i3.itemId + " " + i3.itemName + " " + i3.quantity + " " + i3.price);
//        System.out.println(i4.itemId + " " + i4.itemName + " " + i4.quantity + " " + i4.price);
//        System.out.println(i5.itemId + " " + i5.itemName + " " + i5.quantity + " " + i5.price);

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Items is a Class (Blueprint).

        ✔ i1, i2, i3, i4 and i5 are Objects (Instances).

        ✔ Every call to new Items() creates a new
          object in Heap Memory.

        ✔ i1, i2, i3, i4 and i5 are reference variables
          stored in the Stack Memory (inside main()).

        ✔ Every Items object stores its own
          independent information.

        ✔ Changing one object's data does not affect
          another object.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

        i1 --------------------+
                               |
        i2 ----------------+   |
                            |  |
                            ▼  ▼

                    Heap Memory

        +--------------------------------+
        | Items Object 1                 |
        |--------------------------------|
        | itemId   = 101                 |
        | itemName = "Keyboard"          |
        | quantity = 50                  |
        | price    = 999.99              |
        +--------------------------------+

        +--------------------------------+
        | Items Object 2                 |
        |--------------------------------|
        | itemId   = 102                 |
        | itemName = "Mouse"             |
        | quantity = 80                  |
        | price    = 599.99              |
        +--------------------------------+

        (Similarly for i3, i4 and i5)

        ==================================================
        Final Challenge Answer
        ==================================================

        1. Items is a Class (Blueprint).

        2. i1, i2, i3, i4 and i5 are Objects created
           from the Items class.

        3. The reference variables are stored in
           Stack Memory.

        4. The actual Items objects are stored in
           Heap Memory.

        5. Every object has its own independent state,
           so changing one object does not affect
           another object.

        ==================================================
        */
    }
}