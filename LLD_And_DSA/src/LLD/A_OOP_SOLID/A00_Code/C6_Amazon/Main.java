package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Main {

    public static void main(String[] args) {
        Product p0 = new Product();

        Product p1 = new Product(123,"iPhone",122232.22,"Mobile");
        Product p2 = new Product(332,"Rolex",12223222.22,"Watch");
        Product p3 = new Product(192,"MacBook",1222323.22,"Laptop");
        Product p4 = new Product(77,"Jordan",1313343.22,"Shoes");
        Product p5 = new Product(92,"Atomic Habits",1343.22,"Books");
        System.out.println(
                p0.productId + " " +
                        p0.productName + " " +
                        p0.price + " " +
                        p0.category
        );
        System.out.println(
                p1.productId + " " +
                        p1.productName + " " +
                        p1.price + " " +
                        p1.category
        );

        System.out.println(
                p2.productId + " " +
                        p2.productName + " " +
                        p2.price + " " +
                        p2.category
        );

        System.out.println(
                p3.productId + " " +
                        p3.productName + " " +
                        p3.price + " " +
                        p3.category
        );

        System.out.println(
                p4.productId + " " +
                        p4.productName + " " +
                        p4.price + " " +
                        p4.category
        );

        System.out.println(
                p5.productId + " " +
                        p5.productName + " " +
                        p5.price + " " +
                        p5.category
        );

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Product is a Class (Blueprint).

        ✔ p1, p2, p3, p4 and p5 are Objects (Instances).

        ✔ Every call to new Product() creates a new
          object in Heap Memory.

        ✔ p1, p2, p3, p4 and p5 are reference variables
          stored in the Stack Memory (inside main()).

        ✔ Every Product object stores its own
          independent information.

        ✔ Changing one Product object's data does not
          affect another Product object.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

              +----------------------+
              | main()               |
              |                      |
              | p1 ------+           |
              | p2 ----+ |           |
              | p3 --+ | |           |
              | p4 -|-|--|----+      |
              | p5-|-|--|--+ |       |
              +----|-|--|--|-|-------+
                   | |  |  | |
                   | |  |  | |
                   V V  V  V V

                    Heap Memory

        p1 -----------> Product Object 1
                        productId   = 123
                        productName = "iPhone"
                        price       = 122232.22
                        category    = "Mobile"

        p2 -----------> Product Object 2
                        productId   = 332
                        productName = "Rolex"
                        price       = 12223222.22
                        category    = "Watch"

        p3 -----------> Product Object 3
                        productId   = 192
                        productName = "MacBook"
                        price       = 1222323.22
                        category    = "Laptop"

        p4 -----------> Product Object 4
                        productId   = 77
                        productName = "Jordan"
                        price       = 1313343.22
                        category    = "Shoes"

        p5 -----------> Product Object 5
                        productId   = 92
                        productName = "Atomic Habits"
                        price       = 1343.22
                        category    = "Books"

        ==================================================
        Interview Answer
        ==================================================

        Q. Which fields represent the object's state?

        Ans:

        The object's state is represented by its
        instance variables.

        For the Product class, the state includes:

        • productId
        • productName
        • price
        • category

        Each Product object stores its own state
        independently in Heap Memory.

        ==================================================
        */
    }
}