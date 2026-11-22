package LLD.A_OOP_SOLID.A00_Code.C0_Inheritance;

public class Student extends Person {
    int rollNum;
    String course;
    Student(String name, int rollNum){
        super(name);
        this.rollNum = rollNum;
        System.out.println(name+" "+ rollNum);
    }

    void displayStudent(){
        System.out.println(rollNum);
        System.out.println(course);
    }
}
