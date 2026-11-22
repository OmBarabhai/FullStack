package LLD.A_OOP_SOLID.A0_Inheritance_Part_4;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
        Animal a = new Cat();
        a.sound();
        Car v = new Car();
        v.start();
        Employee t = new Tester();
        Employee m = new Manager();
        Employee e = new Employee();
        Employee dev = new Developer();
        e.work();
        dev.work();
        t.work();
        m.work();
        d.eat();
        Payment p1 = new Payment();
        Payment p2 = new CreditCardPayment();
        Payment p3 = new UPIPayment();
        Payment p4 = new CashPayment();
        p1.pay();
        p2.pay();
        p3.pay();
        p4.pay();
        Shape s1 = new Circle();
        Shape s2 = new Rectangle();

        s1.calculateArea();
        s2.calculateArea();
    }
}