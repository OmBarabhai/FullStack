package LLD.A_OOP_SOLID.A00_Code.C1_Student;

import LLD.A_OOP_SOLID.C_Encapsulation.Student;

public class Main {

    public static void main(String[] args) {
//
//        Student s1 = new Student(21, "Om", 22, "CSE");
//        Student s2 = new Student(22, "Sahil", 22, "CSE");
//        Student s3 = new Student(23, "Pavan", 22, "CSE");
//        Student s4 = new Student(24, "Nakul", 22, "IT");
//        Student s5 = new Student(25, "Shiva", 24, "BA");
//
//        System.out.println(STR."\{s1.rollNumber} \{s1.name} \{s1.age} \{s1.course}");
//        System.out.println(STR."\{s2.rollNumber} \{s2.name} \{s2.age} \{s2.course}");
//        System.out.println(STR."\{s3.rollNumber} \{s3.name} \{s3.age} \{s3.course}");
//        System.out.println(STR."\{s4.rollNumber} \{s4.name} \{s4.age} \{s4.course}");
//        System.out.println(STR."\{s5.rollNumber} \{s5.name} \{s5.age} \{s5.course}");

        /*
        ==================================================
        Concept Learned - Constructors
        ==================================================

        ✔ Student has two constructors.

        ✔ Default Constructor:
            Student()

        ✔ Parameterized Constructor:
            Student(int rollNumber, String name,
                    int age, String course)

        ✔ Objects are initialized during creation.

        ✔ Constructor executes automatically when
          'new Student(...)' is called.

        ✔ 'this' keyword initializes the instance variables.

        ==================================================
        */
        Student s1 = new Student();


        s1.setRollNumber(27);
        System.out.println(s1.getRollNumber());

        s1.setName("Om");
        System.out.println(s1.getName());

        s1.setAge(-12);
        System.out.println(s1.getAge());
        s1.setAge(12);
        System.out.println(s1.getAge());
        s1.setCourse("CSE");
        System.out.println(s1.getCourse());
    }
}