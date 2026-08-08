package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Main {

    public static void main(String[] args) {
        Car c0 = new Car();
        Car c1 = new Car("Toyota","Fortuner","Black", 12200);
        Car c2 = new Car("Land Rover","Defender","Violet",50000);
        Car c3 = new Car("BMW", "M3","Blue",35000);
        Car c4 = new Car("Mercedes","G-Wagon","White",45000);
        System.out.println(c0.brand + " " + c0.model + " " + c0.color + " " + c0.rentPerDay);

        System.out.println(c1.brand + " " + c1.model + " " + c1.color + " " + c1.rentPerDay);
        System.out.println(c2.brand + " " + c2.model + " " + c2.color + " " + c2.rentPerDay);
        System.out.println(c3.brand + " " + c3.model + " " + c3.color + " " + c3.rentPerDay);
        System.out.println(c4.brand + " " + c4.model + " " + c4.color + " " + c4.rentPerDay);

        /*
        =========================================================
                      MEMORY DIAGRAM
        =========================================================

                    Stack Memory

        c1 ----------------------+
                                |
        c2 ------------------+  |
                             |  |
                             ▼  ▼

                    Heap Memory

        +--------------------------------+
        | Car Object 1                   |
        |--------------------------------|
        | brand      = "Toyota"          |
        | model      = "Fortuner"        |
        | color      = "Black"           |
        | rentPerDay = 12200             |
        +--------------------------------+

        +--------------------------------+
        | Car Object 2                   |
        |--------------------------------|
        | brand      = "Land Rover"      |
        | model      = "Defender"        |
        | color      = "Violet"          |
        | rentPerDay = 50000             |
        +--------------------------------+

        =========================================================

        Explanation

        1. c1 and c2 are reference variables stored in Stack Memory.

        2. new Car() creates separate Car objects in Heap Memory.

        3. Each object stores its own values independently.

        4. Changing c1 does not affect c2 because they point to
           different objects.

        =========================================================
        */
    }
}