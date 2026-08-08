package LLD.A_OOP_SOLID.A00_Code.C3_Library;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book("Atomic Habits","James Clear",550,"Self Help");
        Book b2 = new Book("Clean Code","Robert C. Martin",699,"Programming");
        Book b3 = new Book("Effective Java","Joshua Bloch",850,"Programming");
        Book b4 = new Book("The Alchemist","Paulo Coelho",399,"Fiction");
        Book b5 = new Book("Rich Dad Poor Dad","Robert Kiyosaki",450,"Finance");
        Book b6 = new Book();

        System.out.println(b1.title + " " + b1.author + " " + b1.price + " " + b1.category);
        System.out.println(b2.title + " " + b2.author + " " + b2.price + " " + b2.category);
        System.out.println(b3.title + " " + b3.author + " " + b3.price + " " + b3.category);
        System.out.println(b4.title + " " + b4.author + " " + b4.price + " " + b4.category);
        System.out.println(b5.title + " " + b5.author + " " + b5.price + " " + b5.category);
        System.out.println(b6.title + " " + b6.author + " " + b6.price + " " + b6.category);


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