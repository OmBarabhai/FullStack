package LLD.A_OOP_SOLID.A00_Code.C0_Inheritance;

class Dog extends Animal {
//    Dog(){
//        super("Animal is parent extended by Child Dog And This is Parent ");
//        System.out.println("Dog Const...");
//    }
//    void bark(){
//        System.out.println("Dog Barking");
//    }
    String name = "Dog";
    void display(){
        System.out.println(this.name);
        System.out.println(super.name);
    }

}