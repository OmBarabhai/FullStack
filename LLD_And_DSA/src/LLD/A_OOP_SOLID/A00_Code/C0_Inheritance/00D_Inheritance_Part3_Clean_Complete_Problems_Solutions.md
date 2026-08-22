# D_Inheritance — Part 3: Complete Practice Problems + Solutions

## Purpose

This file is the **final clean revision file for D_Inheritance — Part 3**.

Part 1 and Part 2 already covered the theory and mechanics.

Part 3 is where the concepts were practiced through real coding problems.

```text
Part 1 → Inheritance Fundamentals ✅
Part 2 → extends + super + Constructors ✅
Part 3 → Inheritance Practice ✅
Part 4 → Method Overriding + Runtime Polymorphism ⏳
Part 5 → Advanced Inheritance / Design Mastery ⏳
```

This file contains **only Part 3**.

It does not include Part 4 or Part 5 material.

---

# Part 3 Learning Goals

After completing these problems, you should be comfortable with:

- creating a parent class
- creating a child class with `extends`
- identifying an IS-A relationship
- reusing inherited fields and methods
- adding child-specific members
- using `super()`
- using `super(...)`
- understanding constructor chaining
- using `super.method()`
- distinguishing `this` and `super`
- combining parent and child state

---

# Practice Map

```text
P1  → Animal → Dog
P2  → Person → Student
P3  → Vehicle → Car
P4  → Employee → Manager
P5  → Constructor Chain
P6  → super(...)
P7  → Inherited Methods
P8  → super.method()
P9  → this vs super
P10 → Employee → Developer ⭐
```

---

# P1 — Animal → Dog

## Objective

Practice the most basic parent-child inheritance relationship.

```text
Animal
   ↓
  Dog
```

## Problem

Create an `Animal` parent class with:

```java
void eat()
```

Create a `Dog` child class with:

```java
void bark()
```

Then create a `Dog` object and call both methods.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Animal {

    void eat() {
        System.out.println("Animal eating..");
    }
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Dog extends Animal {

    void bark() {
        System.out.println("Dog Barking");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.bark();
    }
}
```

## Expected Output

```text
Animal eating..
Dog Barking
```

## What You Practiced

```text
Animal
  ↓
parent

Dog
  ↓
child

eat()
  ↓
inherited from Animal

bark()
  ↓
defined by Dog
```

## Key Lesson

The child can use an accessible parent method without declaring the same method again.

---

# P2 — Person → Student

## Objective

Practice parent fields, child fields, and a child constructor.

```text
Person
   ↓
Student
```

## Problem

Parent:

```text
name
age
displayPerson()
```

Child:

```text
rollNum
course
displayStudent()
```

The child should also call the parent constructor using `super(name)`.

## Solution

### Person.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Person {

    String name;
    int age;

    Person(String name) {
        this.name = name;
    }

    void displayPerson() {
        System.out.println(name);
        System.out.println(age);
    }
}
```

### Student.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Student extends Person {

    int rollNum;
    String course;

    Student(String name, int rollNum) {

        super(name);

        this.rollNum = rollNum;

        System.out.println(name + " " + rollNum);
    }

    void displayStudent() {
        System.out.println(rollNum);
        System.out.println(course);
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Student s = new Student("Om", 27);

        s.age = 21;
        s.course = "CSE";

        s.displayStudent();
        s.displayPerson();
    }
}
```

## Expected Output

```text
Om 27
27
CSE
Om
21
```

## What You Practiced

```text
Person
 ├── name
 ├── age
 └── displayPerson()

Student extends Person
 ├── rollNum
 ├── course
 └── displayStudent()
```

The child uses:

```java
super(name);
```

to invoke the parent constructor.

---

# P3 — Vehicle → Car

## Objective

Practice a real-world IS-A relationship.

```text
Vehicle
   ↓
  Car
```

## Problem

Parent:

```text
brand
speed
start()
```

Child:

```text
numOfDoors
drive()
```

## Solution

### Vehicle.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Vehicle {

    String brand;
    int speed;

    void start() {
        System.out.println("Vehicle started");
    }
}
```

### Car.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Car extends Vehicle {

    int numOfDoors;

    void drive() {
        System.out.println("Car is driving");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Car c = new Car();

        c.brand = "Toyota";
        c.numOfDoors = 4;
        c.speed = 400;

        c.start();
        c.drive();
    }
}
```

## Expected Output

```text
Vehicle started
Car is driving
```

## What You Practiced

`Car` can use:

```text
Inherited:
brand
speed
start()

Own:
numOfDoors
drive()
```

## Design Check

```text
Car IS-A Vehicle ✅
```

So inheritance makes sense.

---

# P4 — Employee → Manager

## Objective

Practice inheritance with a child-specific field and `super(...)`.

## Problem

Parent:

```text
employeeId
name
```

Child:

```text
bonus
```

The child constructor should initialize parent fields with:

```java
super(employeeId, name);
```

## Solution

### Employee.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Employee {

    int employeeId;
    String name;

    Employee(int employeeId, String name) {

        this.employeeId = employeeId;
        this.name = name;
    }
}
```

### Manager.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Manager extends Employee {

    double bonus;

    Manager(double bonus, int employeeId, String name) {

        super(employeeId, name);

        this.bonus = bonus;
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Manager m = new Manager(5000, 101, "Om");

        System.out.println(
                m.bonus + " " +
                        m.employeeId + " " +
                        m.name
        );
    }
}
```

## Expected Output

```text
5000.0 101 Om
```

## Constructor Flow

```text
new Manager(...)
       ↓
Manager constructor
       ↓
super(employeeId, name)
       ↓
Employee constructor
       ↓
Manager.bonus
```

---

# P5 — Constructor Chain

## Objective

Understand constructor execution order in inheritance.

## Problem

Create:

```text
Animal
   ↓
Dog
```

Both classes should have constructors.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Animal {

    Animal() {
        System.out.println("Animal Constructor");
    }
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Dog extends Animal {

    Dog() {

        super();

        System.out.println("Dog Constructor");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();
    }
}
```

## Expected Output

```text
Animal Constructor
Dog Constructor
```

## Execution Flow

```text
new Dog()
    ↓
Animal()
    ↓
Dog()
```

## Key Lesson

The parent constructor executes before the child constructor.

The explicit:

```java
super();
```

is valid here.

If the parent has an accessible no-argument constructor, Java can also insert the call implicitly when the child constructor does not explicitly invoke another parent constructor.

---

# P6 — Parameterized `super(...)`

## Objective

Practice passing child-constructor values into the parent constructor.

## Problem

Create:

```text
Person
   ↓
Student
```

Parent constructor:

```java
Person(String name)
```

Child constructor:

```java
Student(String name, int rollNumber)
```

Use:

```java
super(name);
```

## Solution

### Person.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Person {

    String name;

    Person(String name) {
        this.name = name;
    }
}
```

### Student.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Student extends Person {

    int rollNumber;

    Student(String name, int rollNumber) {

        super(name);

        this.rollNumber = rollNumber;
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Student s = new Student("Om", 101);

        System.out.println(s.name);
        System.out.println(s.rollNumber);
    }
}
```

## Expected Output

```text
Om
101
```

## Key Idea

```java
super(name);
```

means:

```text
Call Person(String name)
```

The child constructor initializes:

```text
parent state
+
child state
```

---

# P7 — Inherited Methods

## Objective

Practice using a parent method directly from a child object.

## Problem

Parent:

```java
void eat()
```

Child:

```java
void bark()
```

The child should not redefine `eat()`.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Animal {

    void eat() {
        System.out.println("Animal eating");
    }
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Dog extends Animal {

    void bark() {
        System.out.println("Dog barking");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.bark();
    }
}
```

## Expected Output

```text
Animal eating
Dog barking
```

## Why Does `d.eat()` Work?

Because:

```text
eat()
```

belongs to the parent:

```text
Animal
```

and is inherited by `Dog`.

---

# P8 — `super.method()`

## Objective

Practice explicitly calling the parent implementation of a method.

## Problem

Parent:

```java
void sound()
```

Child defines its own `sound()` and calls the parent version first.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Dog extends Animal {

    void sound() {

        super.sound();

        System.out.println("Dog sound");
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.sound();
    }
}
```

## Expected Output

```text
Animal sound
Dog sound
```

## Execution Flow

```text
d.sound()
    ↓
Dog.sound()
    ↓
super.sound()
    ↓
Animal.sound()
    ↓
back to Dog.sound()
    ↓
Dog sound
```

## Key Lesson

```java
super.sound();
```

explicitly calls the parent's version.

This problem is still part of the inheritance mechanics practiced before moving to the dedicated overriding/polymorphism topic.

---

# P9 — `this` vs `super`

## Objective

Understand the difference between the current class member and the parent member when both use the same name.

## Problem

Parent:

```java
String name = "Animal";
```

Child:

```java
String name = "Dog";
```

Inside `display()` print both.

## Solution

### Animal.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Animal {

    String name = "Animal";
}
```

### Dog.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(this.name);
        System.out.println(super.name);
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Dog d = new Dog();

        d.display();
    }
}
```

## Expected Output

```text
Dog
Animal
```

## Meaning

```text
this.name
    ↓
current class field
    ↓
Dog

super.name
    ↓
parent field
    ↓
Animal
```

## Memory Trick

```text
this
 ↓
current

super
 ↓
parent
```

---

# P10 — Employee → Developer ⭐

## Objective

This is the final integration problem for Part 3.

Combine:

```text
Inheritance
+
Parent fields
+
Child fields
+
Constructor chaining
+
super(...)
+
Child-specific method
```

## Problem

Create:

```text
Employee
   ↓
Developer
```

### Employee

Fields:

```text
employeeId
name
salary
```

Constructor:

```java
Employee(int employeeId, String name, int salary)
```

### Developer

Fields:

```text
programmingLang
experience
```

Constructor:

```java
Developer(
    employeeId,
    name,
    salary,
    programmingLang,
    experience
)
```

Use:

```java
super(employeeId, name, salary);
```

Add:

```java
displayDev()
```

to show all data.

## Solution

### Employee.java

This follows the structure you practiced.

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Employee {

    int employeeId;
    String name;
    int salary;

    Employee(int employeeId, String name, int salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
    }
}
```

### Developer.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Developer extends Employee {

    private String programmingLang;
    private int experience;

    Developer(
            int employeeId,
            String name,
            int salary,
            String programmingLang,
            int experience
    ) {

        super(employeeId, name, salary);

        this.programmingLang = programmingLang;
        this.experience = experience;
    }

    void displayDev() {

        System.out.println(employeeId);
        System.out.println(name);
        System.out.println(salary);
        System.out.println(experience);
        System.out.println(programmingLang);
    }
}
```

### Main.java

```java
package LLD.A_OOP_SOLID.A0_Inheritance_Part_3;

public class Main {

    public static void main(String[] args) {

        Developer d =
                new Developer(
                        101,
                        "Jhon",
                        40332,
                        "C#",
                        4
                );

        d.displayDev();
    }
}
```

## Expected Output

```text
101
Jhon
40332
4
C#
```

## What This Problem Combines

```text
Employee
 ├── employeeId
 ├── name
 └── salary
        ↑
      inherited
        ↑
Developer
 ├── programmingLang
 └── experience
```

Constructor flow:

```text
new Developer(...)
       ↓
Developer constructor
       ↓
super(employeeId, name, salary)
       ↓
Employee constructor
       ↓
Developer fields initialized
```

## Key Lesson

This is the complete pattern you should now recognize:

```java
class Developer extends Employee
```

means:

```text
Developer IS-A Employee
```

and:

```java
super(employeeId, name, salary);
```

means:

```text
initialize the Employee part
```

---

# Part 3 — Complete Concept Map

```text
                     INHERITANCE
                          ↓
                     Parent Class
                          ↓
                        extends
                          ↓
                      Child Class
                          ↓
              ┌───────────┴───────────┐
              ↓                       ↓
       Parent Members          Child Members
              ↓                       ↓
       inherited fields         own fields
       inherited methods        own methods
              ↓
          Constructors
              ↓
           super(...)
              ↓
      Constructor Chaining
              ↓
        super.method()
              ↓
        Parent Behavior
              ↓
         this vs super
```

---

# Part 3 — Practice Progression

| Problem | Main Concept | Status |
|---|---|---|
| P1 | Basic `extends` | ✅ |
| P2 | Parent + child members | ✅ |
| P3 | IS-A relationship | ✅ |
| P4 | Constructor + `super(...)` | ✅ |
| P5 | Constructor chaining | ✅ |
| P6 | Parameterized `super(...)` | ✅ |
| P7 | Inherited methods | ✅ |
| P8 | `super.method()` | ✅ |
| P9 | `this` vs `super` | ✅ |
| P10 | Employee → Developer integration | ✅ |

---

# Important Part 3 Lessons

## 1. Parent vs Child

```text
Parent
→ common state/behavior

Child
→ specialized state/behavior
```

---

## 2. `extends`

```java
class Developer extends Employee
```

creates class inheritance.

---

## 3. `super(...)`

```java
super(...);
```

calls a parent constructor.

---

## 4. Constructor Chaining

```text
Parent constructor
      ↓
Child constructor
```

---

## 5. Inherited Methods

If the parent contains:

```java
void eat()
```

the child can use:

```java
d.eat();
```

without copying the method.

---

## 6. `super.method()`

```java
super.sound();
```

explicitly calls the parent implementation.

---

## 7. `this` vs `super`

```text
this  → current class/object context
super → parent class context
```

---

## 8. IS-A

```text
Dog IS-A Animal
Car IS-A Vehicle
Student IS-A Person
Developer IS-A Employee
```

Inheritance is appropriate when the relationship genuinely represents this kind of specialization.

---

# Part 3 Interview Revision

### Q1. What is inheritance?

A child class can acquire accessible members from a parent class and represent an appropriate IS-A relationship.

### Q2. Which keyword is used for class inheritance?

```java
extends
```

### Q3. What is the parent class?

The class being extended.

### Q4. What is the child class?

The class that extends the parent.

### Q5. What does `super(...)` do?

It calls a constructor of the parent class.

### Q6. What is constructor chaining?

The execution of constructors through an inheritance chain, from the parent toward the child.

### Q7. Why does the parent constructor run first?

Because the parent part must be initialized before the child part.

### Q8. Can a child use an inherited method?

Yes, when that member is accessible.

### Q9. What does `super.method()` do?

It explicitly calls the parent implementation of a method.

### Q10. What does `this` mean?

The current object/current class context.

### Q11. What does `super` mean?

The parent class context.

### Q12. What is IS-A?

An inheritance relationship.

Example:

```text
Developer IS-A Employee
```

### Q13. What is HAS-A?

A relationship where one object contains or uses another object, such as:

```text
Car HAS-A Engine
```

---

# Part 3 Final Checklist

```text
[ ] I can identify the parent.
[ ] I can identify the child.
[ ] I can use extends.
[ ] I can identify IS-A.
[ ] I can identify common parent members.
[ ] I can add child-specific members.
[ ] I can write child constructors.
[ ] I can use super().
[ ] I can use super(...).
[ ] I understand constructor chaining.
[ ] I understand inherited methods.
[ ] I understand super.method().
[ ] I understand this vs super.
[ ] I can combine parent and child state.
[ ] I can build a basic real-world inheritance hierarchy.
[ ] I completed P1–P10.
```

---

# D_Inheritance — Part 3 Status

```text
Part 1 — Fundamentals                         ✅
Part 2 — extends + super + Constructors      ✅
Part 3 — Inheritance Practice                ✅
```

## Part 3 COMPLETE ✅

The next topic is intentionally **not included in this file**:

```text
D_Inheritance — Part 4
Method Overriding + Runtime Polymorphism
```
