package LLD.A_OOP_SOLID.Practice.P3_Library;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book();
        b1.title = "Atomic Habits";
        b1.author = "James Clear";
        b1.price = 550;
        b1.category = "Self Help";

        Book b2 = new Book();
        b2.title = "Clean Code";
        b2.author = "Robert C. Martin";
        b2.price = 699;
        b2.category = "Programming";

        Book b3 = new Book();
        b3.title = "Effective Java";
        b3.author = "Joshua Bloch";
        b3.price = 850;
        b3.category = "Programming";

        Book b4 = new Book();
        b4.title = "The Alchemist";
        b4.author = "Paulo Coelho";
        b4.price = 399;
        b4.category = "Fiction";

        Book b5 = new Book();
        b5.title = "Rich Dad Poor Dad";
        b5.author = "Robert Kiyosaki";
        b5.price = 450;
        b5.category = "Finance";

        System.out.println(b1.title + " " + b1.author + " " + b1.price + " " + b1.category);
        System.out.println(b2.title + " " + b2.author + " " + b2.price + " " + b2.category);
        System.out.println(b3.title + " " + b3.author + " " + b3.price + " " + b3.category);
        System.out.println(b4.title + " " + b4.author + " " + b4.price + " " + b4.category);
        System.out.println(b5.title + " " + b5.author + " " + b5.price + " " + b5.category);

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Book is a Class (Blueprint).

        ✔ b1, b2, b3, b4 and b5 are Objects (Instances).

        ✔ Every call to new Book() creates a new object
          in Heap Memory.

        ✔ b1, b2, b3, b4 and b5 are reference variables
          stored in the Stack Memory (inside main()).

        ✔ Every Book object stores its own independent
          information.

        ✔ Changing one object's data does not affect
          another object.

        ==================================================
        Memory Diagram
        ==================================================

                     Stack Memory

               +----------------------+
               | main()               |
               |                      |
               | b1 -------+          |
               | b2 ----+  |          |
               | b3 --+ |  |          |
               | b4 -|-|--|----+      |
               | b5-|-|--|--+ |       |
               +----|-|--|--|-|-------+
                    | |  |  | |
                    | |  |  | |
                    V V  V  V V

                     Heap Memory

        b1 -----------> Book Object 1
                        title    = "Atomic Habits"
                        author   = "James Clear"
                        price    = 550
                        category = "Self Help"

        b2 -----------> Book Object 2
                        title    = "Clean Code"
                        author   = "Robert C. Martin"
                        price    = 699
                        category = "Programming"

        b3 -----------> Book Object 3
                        title    = "Effective Java"
                        author   = "Joshua Bloch"
                        price    = 850
                        category = "Programming"

        b4 -----------> Book Object 4
                        title    = "The Alchemist"
                        author   = "Paulo Coelho"
                        price    = 399
                        category = "Fiction"

        b5 -----------> Book Object 5
                        title    = "Rich Dad Poor Dad"
                        author   = "Robert Kiyosaki"
                        price    = 450
                        category = "Finance"

        ==================================================
        Interview Answer
        ==================================================

        Q. Can every object store different values?
        Explain why.

        Ans:

        Yes.

        Every Book object is created independently using
        the 'new' keyword.

        Each object gets its own memory location in Heap
        Memory. Therefore, every object has its own copy
        of the instance variables (title, author, price
        and category).

        Changing one Book object's data does not affect
        another Book object because they are different
        objects stored at different memory locations.

        ==================================================
        */
    }
}