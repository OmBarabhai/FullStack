package LLD.A_OOP_SOLID.A0_Inheritance_Part_4;

public class Dog extends Animal {
    @Override
    void sound(){
        System.out.println("Dog Bark");
    }
    void eat(){
        super.eat();
        System.out.println("All Dogs Can eat");
    }
}