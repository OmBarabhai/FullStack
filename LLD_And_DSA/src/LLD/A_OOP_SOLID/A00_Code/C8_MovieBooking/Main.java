package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Main {

    public static void main(String[] args) {

        Movie m0 = new Movie();
        Movie m1 = new Movie("Animal","3 hr","Hindi",4.6);
        Movie m2 = new Movie("Dhurandhar","3.4 hr","Hindi",4.3);
        Movie m3 = new Movie("Avengers Endgame","3 hr","English",5.0);
        Movie m4 = new Movie("Avatar","3.2 hr","Hindi",5.0);
        Movie m5 = new Movie("Inception","3 hr","English",4.9);

        System.out.println(
                m0.movieName + " " +
                        m0.duration + " " +
                        m0.language + " " +
                        m0.rating
        );

        System.out.println(
                m1.movieName + " " +
                        m1.duration + " " +
                        m1.language + " " +
                        m1.rating
        );

        System.out.println(
                m2.movieName + " " +
                        m2.duration + " " +
                        m2.language + " " +
                        m2.rating
        );

        System.out.println(
                m3.movieName + " " +
                        m3.duration + " " +
                        m3.language + " " +
                        m3.rating
        );

        System.out.println(
                m4.movieName + " " +
                        m4.duration + " " +
                        m4.language + " " +
                        m4.rating
        );

        System.out.println(
                m5.movieName + " " +
                        m5.duration + " " +
                        m5.language + " " +
                        m5.rating
        );

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Movie is a Class (Blueprint).

        ✔ m1, m2, m3, m4 and m5 are Objects (Instances).

        ✔ Every call to new Movie() creates a new
          object in Heap Memory.

        ✔ m1, m2, m3, m4 and m5 are reference variables
          stored in the Stack Memory (inside main()).

        ✔ Every Movie object stores its own
          independent information.

        ✔ Changing one Movie object's data does not
          affect another Movie object.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

              +----------------------+
              | main()               |
              |                      |
              | m1 ------+           |
              | m2 ----+ |           |
              | m3 --+ | |           |
              | m4 -|-|--|----+      |
              | m5-|-|--|--+ |       |
              +----|-|--|--|-|-------+
                   | |  |  | |
                   | |  |  | |
                   V V  V  V V

                    Heap Memory

        m1 -----------> Movie Object 1
                        movieName = "Animal"
                        duration  = "3 hr"
                        language  = "Hindi"
                        rating    = 4.6

        m2 -----------> Movie Object 2
                        movieName = "Dhurandhar"
                        duration  = "3.4 hr"
                        language  = "Hindi"
                        rating    = 4.3

        m3 -----------> Movie Object 3
                        movieName = "Avengers Endgame"
                        duration  = "3 hr"
                        language  = "English"
                        rating    = 5.0

        m4 -----------> Movie Object 4
                        movieName = "Avatar"
                        duration  = "3.2 hr"
                        language  = "Hindi"
                        rating    = 5.0

        m5 -----------> Movie Object 5
                        movieName = "Inception"
                        duration  = "3 hr"
                        language  = "English"
                        rating    = 4.9

        ==================================================
        Interview Answer
        ==================================================

        Q. Why is every movie an object?

        Ans:

        A Movie is a real-world entity with its own
        properties such as movieName, duration,
        language and rating.

        The Movie class acts as a blueprint.

        Every time we create a Movie using
        new Movie(), Java creates a separate
        Movie object in Heap Memory.

        Since each movie has different values,
        every movie is represented as a separate
        object.

        ==================================================
        */
    }
}