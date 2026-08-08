package LLD.A_OOP_SOLID.A00_Code.C1_Student;

public class Student {
    /*Class Object*/

    int rollNumber;
    String name;
    int age;
    String course;

    /*Constructor*/
    Student(){

    }
    Student(int rollNumber,String name,int age,String course){
        this.name = name;
        this.age = age;
        this.rollNumber = rollNumber;
        this.course = course;
    }


}
