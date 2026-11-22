package LLD.A_OOP_SOLID.B_Constructors;

public class Student {
    String name;
    int age;

    Student() { //Default Constructor
        /*
         * ✔ Default Constructor → No parameters.
         * */
        this("Unknown",0);
        System.out.println("Student Object Created.");
    }

    Student(String name) {
        /*
        *Constructor Overloading...
        **Parameterized Constructor → Accepts values.
        ***Constructor***
        same name as a class
        No Return Type
        Runs Automatically
        Initializes object

        ***Method***
        Any valid name
        Has return type
        Called manually
        Performs an action

        */
        this.name = name;
    }

    Student(String name, int age) {
/*
        Constructor Overloading...
        Constructor Overloading → Multiple constructors with different parameters.
        A parameterized constructor initializes an object with values.
        this.name --> Instance Variable Which we Initialize Globally
        name --> This is Constructor Parameter

*/
        this.name = name;
        this.age = age;
        System.out.println(name + " " + age);
    }
}

class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Om");
        Student s3 = new Student("Om", 22);
            /*
            Java selects the constructor that matches the arguments.
            * */
        System.out.println(s2.name);
        System.out.println(s2.age);

    }
}
