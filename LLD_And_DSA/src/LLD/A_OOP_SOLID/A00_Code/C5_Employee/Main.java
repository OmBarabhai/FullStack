package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Main {

    public static void main(String[] args) {
        Employee e0 = new Employee();
        Employee e1 = new Employee(93,"Anv",42434.00,"IT");
        Employee e2 = new Employee(94,"Anie",342434.00,"Marketing");
        Employee e3 = new Employee(95,"Anuj",542434.00,"Manufacturing");
        Employee e4 = new Employee(96, "Rahul", 65234.00, "HR");
        Employee e5 = new Employee(97, "Priya", 75434.00, "Finance");
        System.out.println(e1.name + " " + e1.id + " " + e1.salary + " " + e1.department);
        System.out.println(e2.name + " " + e2.id + " " + e2.salary + " " + e2.department);
        System.out.println(e3.name + " " + e3.id + " " + e3.salary + " " + e3.department);
        System.out.println(e4.name + " " + e4.id + " " + e4.salary + " " + e4.department);
        System.out.println(e5.name + " " + e5.id + " " + e5.salary + " " + e5.department);
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