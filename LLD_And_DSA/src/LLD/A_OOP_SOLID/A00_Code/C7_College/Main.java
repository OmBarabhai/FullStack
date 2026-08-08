package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class Main {

    public static void main(String[] args) {
        College c0 = new College();
        College c1 = new College(832,"GH Raisoni","Pune",321);
        College c2 = new College(332,"Sanmati","Washim",424);
        College c3 = new College(233,"HVPM","Amravati",341);
        System.out.println(
                c0.collegeId + " " +
                        c0.collegeName + " " +
                        c0.city + " " +
                        c0.totalStudent
        );

        System.out.println(
                c1.collegeId + " " +
                        c1.collegeName + " " +
                        c1.city + " " +
                        c1.totalStudent
        );

        System.out.println(
                c2.collegeId + " " +
                        c2.collegeName + " " +
                        c2.city + " " +
                        c2.totalStudent
        );

        System.out.println(
                c3.collegeId + " " +
                        c3.collegeName + " " +
                        c3.city + " " +
                        c3.totalStudent
        );

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ College is a Class (Blueprint).

        ✔ c1, c2 and c3 are Objects (Instances).

        ✔ Every call to new College() creates a new
          object in Heap Memory.

        ✔ c1, c2 and c3 are reference variables stored
          in the Stack Memory (inside main()).

        ✔ Every College object stores its own
          independent information.

        ✔ Changing one College object's data does not
          affect another College object.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

              +----------------------+
              | main()               |
              |                      |
              | c1 ------+           |
              | c2 ----+ |           |
              | c3 --+ | |           |
              +------|-|-|-----------+
                     | | |
                     | | |
                     V V V

                    Heap Memory

        c1 -----------> College Object 1
                        collegeId     = 832
                        collegeName   = "GH Raisoni"
                        city          = "Pune"
                        totalStudent  = 321

        c2 -----------> College Object 2
                        collegeId     = 332
                        collegeName   = "Sanmati"
                        city          = "Washim"
                        totalStudent  = 424

        c3 -----------> College Object 3
                        collegeId     = 233
                        collegeName   = "HVPM"
                        city          = "Amravati"
                        totalStudent  = 341

        ==================================================
        Interview Answer
        ==================================================

        Q. Can multiple College objects exist at the same time?

        Ans:

        Yes.

        A single College class can create multiple
        College objects.

        Every object is stored separately in Heap Memory
        and maintains its own independent state.

        ==================================================
        */
    }
}