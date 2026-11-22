package LLD.A_OOP_SOLID.A00_Code.C0_Inheritance;

public class Person {
    String name;
    int age;
    Person(String name){
        this.name = name;
    }
    void displayPerson(){
        System.out.println(name);
        System.out.println(age);
    }
}
