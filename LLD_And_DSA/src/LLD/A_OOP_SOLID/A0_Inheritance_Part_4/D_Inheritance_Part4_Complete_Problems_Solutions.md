# D_Inheritance — Part 4: Method Overriding + Runtime Polymorphism
# Complete Problems + Solutions

## Position

Part 1 — Inheritance Fundamentals ✅
Part 2 — extends + super + Constructors ✅
Part 3 — Inheritance Practice ✅
Part 4 — Method Overriding + Runtime Polymorphism ✅

This file contains **only Part 4**. Part 5 is not included.

## Learning Goals

- Method overriding
- `@Override`
- Parent reference + child object
- Upcasting
- Runtime method dispatch
- Runtime polymorphism
- `super.method()`
- Reference type vs object type
- Overriding vs overloading

---

# P1 — Animal → Dog

## Problem

Create `Animal.sound()`. Create `Dog extends Animal` and override `sound()`.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
```

### Output

```text
Dog barks
```

### Lesson

The child provides its own implementation of the inherited method. This is **method overriding**.

---

# P2 — Animal → Cat

## Problem

Create `Cat extends Animal`, override `sound()`, then use:

```java
Animal a = new Cat();
a.sound();
```

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}
```

### Cat.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

public class Main {
    public static void main(String[] args) {
        Animal a = new Cat();
        a.sound();
    }
}
```

### Output

```text
Cat meows
```

### Lesson

```text
Reference type → Animal
Object type    → Cat
```

The actual object is `Cat`, so `Cat.sound()` executes.

---

# P3 — Vehicle → Car

## Problem

Create `Vehicle.start()`. Create `Car extends Vehicle` and override `start()`.

## Solution

### Vehicle.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Vehicle {
    void start() {
        System.out.println("Vehicle starts");
    }
}
```

### Car.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Car extends Vehicle {
    @Override
    void start() {
        System.out.println("Car starts with key");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

public class Main {
    public static void main(String[] args) {
        Car c = new Car();
        c.start();
    }
}
```

### Output

```text
Car starts with key
```

---

# P4 — Employee Hierarchy

## Problem

Create:

```text
Employee
 ├── Developer
 ├── Manager
 └── Tester
```

Each child overrides `work()`.

## Solution

### Employee.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Employee {
    void work() {
        System.out.println("Employee works");
    }
}
```

### Developer.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Developer extends Employee {
    @Override
    void work() {
        System.out.println("Developer writes code");
    }
}
```

### Manager.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Manager extends Employee {
    @Override
    void work() {
        System.out.println("Manager manages team");
    }
}
```

### Tester.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Tester extends Employee {
    @Override
    void work() {
        System.out.println("Tester tests application");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

public class Main {
    public static void main(String[] args) {
        Developer d = new Developer();
        Manager m = new Manager();
        Tester t = new Tester();

        d.work();
        m.work();
        t.work();
    }
}
```

### Output

```text
Developer writes code
Manager manages team
Tester tests application
```

### Lesson

Same parent method, different child implementations.

---

# P5 — Parent Reference + Child Object

## Problem

Create:

```java
Animal a1 = new Dog();
Animal a2 = new Cat();
```

Then call both `sound()` methods.

## Solution

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();
        a2.sound();
    }
}
```

### Output

```text
Dog barks
Cat meows
```

### Lesson

```text
Animal a1 = new Dog();

Reference type → Animal
Actual object  → Dog
```

This is **upcasting** and introduces runtime polymorphism.

---

# P6 — super.method()

## Problem

`Dog.sound()` must call the parent `Animal.sound()` and then print its own message.

## Solution

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Animal {
    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        super.sound();
        System.out.println("Dog sound");
    }
}

public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
```

### Output

```text
Animal sound
Dog sound
```

### Flow

```text
Dog.sound()
    ↓
super.sound()
    ↓
Animal.sound()
    ↓
back to Dog.sound()
```

---

# P7 — Payment System

## Problem

Create:

```text
Payment
 ├── CreditCardPayment
 ├── UPIPayment
 └── CashPayment
```

Override `pay()` in each child.

## Solution

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Payment {
    void pay() {
        System.out.println("Processing payment");
    }
}

class CreditCardPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paying using Credit Card");
    }
}

class UPIPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paying using UPI");
    }
}

class CashPayment extends Payment {
    @Override
    void pay() {
        System.out.println("Paying using Cash");
    }
}

public class Main {
    public static void main(String[] args) {
        Payment p1 = new CreditCardPayment();
        Payment p2 = new UPIPayment();
        Payment p3 = new CashPayment();

        p1.pay();
        p2.pay();
        p3.pay();
    }
}
```

### Output

```text
Paying using Credit Card
Paying using UPI
Paying using Cash
```

### Lesson

One parent reference type can work with different child objects.

---

# P8 — Shape

## Problem

Create:

```text
Shape
 ├── Circle
 └── Rectangle
```

Override `calculateArea()`.

## Solution

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Shape {
    void calculateArea() {
        System.out.println("Area calculation");
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = Math.PI * radius * radius;
        System.out.println("Circle Area: " + area);
    }
}

class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void calculateArea() {
        double area = length * width;
        System.out.println("Rectangle Area: " + area);
    }
}

public class Main {
    public static void main(String[] args) {
        Shape s1 = new Circle(5);
        Shape s2 = new Rectangle(10, 5);

        s1.calculateArea();
        s2.calculateArea();
    }
}
```

### Output

```text
Circle Area: 78.53981633974483
Rectangle Area: 50.0
```

---

# P9 — Constructor + Overriding

## Problem

Create `Animal` and `Dog`. Both have constructors. `Dog` overrides `sound()`. Test:

```java
Animal a = new Dog();
a.sound();
```

## Solution

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Animal {
    Animal() {
        System.out.println("Animal Constructor");
    }

    void sound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {
    Dog() {
        System.out.println("Dog Constructor");
    }

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.sound();
    }
}
```

### Output

```text
Animal Constructor
Dog Constructor
Dog barks
```

### Important

Two separate mechanisms:

```text
Construction:
new Dog()
    ↓
Animal constructor
    ↓
Dog constructor

Method call:
a.sound()
    ↓
actual object = Dog
    ↓
Dog.sound()
```

---

# P10 — Employee Polymorphism ⭐

## Problem

Create:

```text
Employee
 ├── Developer
 ├── Manager
 └── Tester
```

Parent:

```java
String name;
Employee(String name);
void work();
```

Each child overrides `work()`.

Use parent references:

```java
Employee e1 = new Developer("Om");
Employee e2 = new Manager("Rahul");
Employee e3 = new Tester("Amit");
```

## Solution

### Employee.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    void work() {
        System.out.println("Employee works");
    }
}
```

### Developer.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Developer extends Employee {
    Developer(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Developer writes code");
    }
}
```

### Manager.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Manager extends Employee {
    Manager(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Manager manages team");
    }
}
```

### Tester.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

class Tester extends Employee {
    Tester(String name) {
        super(name);
    }

    @Override
    void work() {
        System.out.println("Tester tests application");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Developer("Om");
        Employee e2 = new Manager("Rahul");
        Employee e3 = new Tester("Amit");

        e1.work();
        e2.work();
        e3.work();
    }
}
```

### Output

```text
Developer writes code
Manager manages team
Tester tests application
```

---

# Part 4 Core Mental Model

```text
Parent Class
     ↓
Common Method
     ↓
Child Overrides Method
     ↓
Parent Reference
     ↓
Child Object
     ↓
Method Call
     ↓
Runtime Checks Actual Object
     ↓
Child Implementation Runs
```

Example:

```java
Employee e = new Developer();
e.work();
```

```text
Employee
   ↓
Reference Type

Developer
   ↓
Actual Object

e.work()
   ↓
Developer.work()
```

---

# Overriding Rules

1. Same method signature.
2. Return type must be compatible.
3. Child cannot reduce access visibility.
4. Private methods are not overridden.
5. Static methods are hidden, not runtime-overridden.
6. Use `@Override`.

---

# Overriding vs Overloading

```text
Overriding
→ parent + child
→ same signature
→ runtime method selection

Overloading
→ different parameter list
→ compile-time method selection
```

Example overriding:

```java
class Animal {
    void sound() {}
}

class Dog extends Animal {
    @Override
    void sound() {}
}
```

Example overloading:

```java
void add(int a, int b)
void add(int a, int b, int c)
```

---

# Interview Revision

## Q1. What is method overriding?

A child class provides its own implementation of an inherited instance method with the same signature.

## Q2. Why use `@Override`?

To tell the compiler that the method is intended to override a parent method and catch mistakes.

## Q3. What is runtime polymorphism?

The overridden implementation is selected based on the actual object at runtime.

## Q4. What does this mean?

```java
Animal a = new Dog();
```

```text
Reference type → Animal
Object type    → Dog
```

## Q5. Which method executes?

```java
Animal a = new Dog();
a.sound();
```

`Dog.sound()` executes if `Dog` overrides `sound()`.

## Q6. What is upcasting?

Treating a child object through a parent reference.

```java
Animal a = new Dog();
```

## Q7. What does `super.sound()` do?

Calls the parent implementation of `sound()`.

## Q8. What is the difference between overriding and overloading?

```text
Overriding
→ parent + child
→ same signature
→ runtime

Overloading
→ different parameters
→ compile time
```

---

# Part 4 Final Checklist

```text
[ ] Method overriding understood
[ ] @Override understood
[ ] Parent reference + child object understood
[ ] Upcasting understood
[ ] Runtime method dispatch understood
[ ] Runtime polymorphism understood
[ ] Dynamic method dispatch understood
[ ] super.method() understood
[ ] Reference type vs object type understood
[ ] Overriding vs overloading understood
[ ] Multiple child classes practiced
[ ] P1–P10 completed
```

# Completion

```text
D_Inheritance

Part 1 ✅
Part 2 ✅
Part 3 ✅
Part 4 ✅
```

# Next

Part 5 — Inheritance + Polymorphism Advanced Practice / Design Mastery
