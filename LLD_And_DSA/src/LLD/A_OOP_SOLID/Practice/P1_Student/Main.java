package LLD.A_OOP_SOLID.Practice.P1_Student;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();
        s1.rollNumber = 21;
        s1.name = "Om";
        s1.age = 22;
        s1.course = "CSE";

        Student s2 = new Student();
        s2.rollNumber = 22;
        s2.name = "Sahil";
        s2.age = 22;
        s2.course = "CSE";

        Student s3 = new Student();
        s3.rollNumber = 23;
        s3.name = "Pavan";
        s3.age = 22;
        s3.course = "CSE";

        Student s4 = new Student();
        s4.rollNumber = 24;
        s4.name = "Nakul";
        s4.age = 22;
        s4.course = "CSE";

        Student s5 = new Student();
        s5.rollNumber = 25;
        s5.name = "Shiva";
        s5.age = 24;
        s5.course = "CSE";

        System.out.println(STR."\{s1.rollNumber} \{s1.name} \{s1.age} \{s1.course}");
        System.out.println(STR."\{s2.rollNumber} \{s2.name} \{s2.age} \{s2.course}");
        System.out.println(STR."\{s3.rollNumber} \{s3.name} \{s3.age} \{s3.course}");
        System.out.println(STR."\{s4.rollNumber} \{s4.name} \{s4.age} \{s4.course}");
        System.out.println(STR."\{s5.rollNumber} \{s5.name} \{s5.age} \{s5.course}");

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Student is a Class (Blueprint).

        ✔ s1, s2, s3, s4 and s5 are Objects (Instances).

        ✔ Every call to new Student() creates a new
          Student object in Heap Memory.

        ✔ s1, s2, s3, s4 and s5 are reference variables
          stored in the Stack Memory (inside main()).

        ✔ Every Student object stores its own
          independent information.

        ✔ Changing one Student object's data does not
          affect another Student object.

        ==================================================
        Memory Diagram
        ==================================================

                    Stack Memory

              +----------------------+
              | main()               |
              |                      |
              | s1 ------+           |
              | s2 ----+ |           |
              | s3 --+ | |           |
              | s4 -|-|--|----+      |
              | s5-|-|--|--+ |       |
              +----|-|--|--|-|-------+
                   | |  |  | |
                   | |  |  | |
                   V V  V  V V

                    Heap Memory

        s1 -----------> Student Object 1
                        rollNumber = 21
                        name       = "Om"
                        age        = 22
                        course     = "CSE"

        s2 -----------> Student Object 2
                        rollNumber = 22
                        name       = "Sahil"
                        age        = 22
                        course     = "CSE"

        s3 -----------> Student Object 3
                        rollNumber = 23
                        name       = "Pavan"
                        age        = 22
                        course     = "CSE"

        s4 -----------> Student Object 4
                        rollNumber = 24
                        name       = "Nakul"
                        age        = 22
                        course     = "CSE"

        s5 -----------> Student Object 5
                        rollNumber = 25
                        name       = "Shiva"
                        age        = 24
                        course     = "CSE"

        ==================================================
        Interview Answer
        ==================================================

        Q. Why does each Student object have different values?

        Ans:

        Every Student object is created independently
        using the 'new' keyword.

        Each object gets its own memory location in
        Heap Memory.

        The reference variables (s1, s2, s3, s4 and s5)
        are stored in the stack frame of the main()
        method.

        Since every object has its own memory location,
        each object stores its own independent state.

        Therefore, changing one Student object's data
        does not affect another Student object.

        ==================================================
        */
    }
}