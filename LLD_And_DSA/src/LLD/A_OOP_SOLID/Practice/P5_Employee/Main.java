package LLD.A_OOP_SOLID.Practice.P5_Employee;

public class Main {

    public static void main(String[] args) {

        Employee e1 = new Employee();
        e1.name = "Anv";
        e1.id = 93;
        e1.salary = 42434.00;
        e1.department = "IT";

        Employee e2 = new Employee();
        e2.name = "Anie";
        e2.id = 94;
        e2.salary = 342434.00;
        e2.department = "Marketing";

        Employee e3 = new Employee();
        e3.name = "Anuj";
        e3.id = 95;
        e3.salary = 542434.00;
        e3.department = "Manufacturing";

        System.out.println(e1.name + " " + e1.id + " " + e1.salary + " " + e1.department);
        System.out.println(e2.name + " " + e2.id + " " + e2.salary + " " + e2.department);
        System.out.println(e3.name + " " + e3.id + " " + e3.salary + " " + e3.department);

        /*
        ==================================================
        Concept Learned
        ==================================================

        ✔ Employee is a Class (Blueprint).

        ✔ e1, e2 and e3 are Objects (Instances).

        ✔ Every call to new Employee() creates a new
          object in Heap Memory.

        ✔ e1, e2 and e3 are reference variables stored
          in the Stack Memory (inside main()).

        ✔ Each Employee object has its own independent
          data (state).

        ✔ Changing one object's data does not affect
          another object because each object occupies
          a different memory location.

        ==================================================
        Memory Diagram
        ==================================================

                  Stack Memory

             +-------------------+
             | main()            |
             |                   |
             | e1 ------+        |
             | e2 ----+ |        |
             | e3 --+ | |        |
             +-------|-|-|--------+
                     | | |
                     | | |
                     v v v

                  Heap Memory

        +---------------------------+
        | Employee Object 1         |
        |---------------------------|
        | id = 93                   |
        | name = "Anv"              |
        | salary = 42434.00         |
        | department = "IT"         |
        +---------------------------+

        +---------------------------+
        | Employee Object 2         |
        |---------------------------|
        | id = 94                   |
        | name = "Anie"             |
        | salary = 342434.00        |
        | department = "Marketing"  |
        +---------------------------+

        +---------------------------+
        | Employee Object 3         |
        |---------------------------|
        | id = 95                   |
        | name = "Anuj"             |
        | salary = 542434.00        |
        | department = "Manufacturing"|
        +---------------------------+

        ==================================================
        Interview Answer
        ==================================================

        Q. Why does each Employee object have different values?

        Ans:
        Every Employee object is created independently in
        Heap Memory using the 'new' keyword. Each object
        has its own separate memory location, so every
        object stores its own state independently. Changing
        one object does not affect the others.

        ==================================================
        */
    }
}