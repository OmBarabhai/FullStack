# D_Inheritance — Part 1: Fundamentals

Part 1 is only about **understanding the basic idea of Inheritance**.

Do not worry about `super`, method overriding, polymorphism, or advanced inheritance yet.

---

# Learning Goals

After Part 1, you should understand:

* What Inheritance is.
* Why Inheritance is used.
* Parent class.
* Child class.
* `extends`.
* IS-A relationship.
* Code reuse.
* Inherited methods.
* Basic inheritance structure.

---

# 1. What Is Inheritance?

Inheritance allows one class to **acquire accessible properties and methods from another class**.

Example:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}
```

Now:

```java
Dog d = new Dog();

d.eat();
```

Output:

```text
Eating
```

Why?

Because `Dog` inherits the `eat()` method from `Animal`.

---

# 2. Parent Class

The class whose properties and methods are inherited is called the:

```text
Parent Class
```

or:

```text
Superclass
```

Example:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

Here:

```text
Animal → Parent
```

---

# 3. Child Class

The class that inherits from another class is called the:

```text
Child Class
```

or:

```text
Subclass
```

Example:

```java
class Dog extends Animal {

}
```

Here:

```text
Dog → Child
```

---

# 4. `extends`

Java uses the `extends` keyword for class inheritance.

```java
class Dog extends Animal {

}
```

Read this as:

```text
Dog extends Animal
```

or:

```text
Dog inherits from Animal
```

---

# 5. Basic Structure

```text
        Animal
       Parent
          ↑
          |
       extends
          |
          |
         Dog
        Child
```

Or simply:

```text
Animal
   ↓
  Dog
```

---

# 6. Why Do We Use Inheritance?

One major reason is **code reuse**.

Without inheritance:

```java
class Dog {

    void eat() {
        System.out.println("Eating");
    }
}

class Cat {

    void eat() {
        System.out.println("Eating");
    }
}
```

The same method is repeated.

With inheritance:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}
```

Now both children can use:

```java
eat();
```

without rewriting it.

---

# 7. Inherited Method

Parent:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

Child:

```java
class Dog extends Animal {

}
```

Object:

```java
Dog d = new Dog();

d.eat();
```

The method is defined in `Animal`, but the `Dog` object can use it.

```text
Animal
  |
  | eat()
  ↓
Dog
  |
  | can use eat()
  ↓
Dog object
```

---

# 8. Child Can Have Its Own Methods

Inheritance does not mean the child can only use parent methods.

The child can add its own behavior.

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}
```

Now:

```java
Dog d = new Dog();

d.eat();
d.bark();
```

Output:

```text
Eating
Barking
```

So:

```text
Dog
 ↓
Inherited behavior → eat()
Own behavior       → bark()
```

---

# 9. IS-A Relationship

Inheritance represents an **IS-A relationship**.

Example:

```text
Dog IS-A Animal
```

Because:

```java
class Dog extends Animal
```

Other examples:

```text
Car IS-A Vehicle

Manager IS-A Employee

Student IS-A Person
```

This is an important interview concept.

---

# 10. IS-A vs HAS-A

### IS-A

Represents inheritance.

```text
Dog IS-A Animal
```

```java
class Dog extends Animal {
}
```

### HAS-A

Represents composition/association.

```text
Car HAS-A Engine
```

```java
class Car {

    Engine engine;
}
```

For now, remember:

```text
IS-A  → Inheritance
HAS-A → Object relationship
```

---

# 11. What Can the Child Use?

Example:

```java
class Animal {

    String name;

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}
```

The child can use accessible parent members:

```java
Dog d = new Dog();

d.name;
d.eat();
d.bark();
```

So the child has:

```text
Parent members
      +
Own members
```

---

# 12. Private Members

This is important because it connects with **Encapsulation**.

Consider:

```java
class Animal {

    private int age;
}
```

Child:

```java
class Dog extends Animal {

    void test() {

        age = 20; // ❌
    }
}
```

The child cannot directly access the parent's `private` field.

Why?

Because `private` means access is restricted to the class that declares it.

So:

```text
private
   ↓
Encapsulation protection
```

still applies during inheritance.

---

# 13. Getter With Inheritance

The parent can protect its field and provide a method to access it.

```java
class Animal {

    private int age;

    public int getAge() {
        return age;
    }
}

class Dog extends Animal {

}
```

Now:

```java
Dog d = new Dog();

System.out.println(d.getAge());
```

The child can use the parent's public method.

This is a good connection between:

```text
Encapsulation
      +
Inheritance
```

---

# 14. One Parent → Multiple Children

Inheritance can have multiple child classes.

Example:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}
```

Diagram:

```text
          Animal
         /      \
        ↓        ↓
       Dog      Cat
```

Both can use:

```java
eat();
```

This is called:

**Hierarchical Inheritance**

You will study inheritance types more deeply later.

---

# 15. Multilevel Example

Inheritance can also form a chain.

```java
class Animal {

}

class Mammal extends Animal {

}

class Dog extends Mammal {

}
```

Diagram:

```text
Animal
   ↓
Mammal
   ↓
 Dog
```

`Dog` is indirectly related to `Animal`.

This is:

**Multilevel Inheritance**

---

# 16. Basic Memory Understanding

Consider:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}
```

Then:

```java
Dog d = new Dog();
```

Conceptually:

```text
Stack
  |
  | d
  ↓
Heap
  |
  ↓
Dog Object
  |
  └── inherited Animal behavior
```

The important point for now:

```text
new Dog()
    ↓
creates a Dog object
```

and that object can use accessible inherited members.

---

# 17. Why Not Just Copy Methods?

Suppose:

```java
class Dog {

    void eat() {
        System.out.println("Eating");
    }
}
```

and:

```java
class Cat {

    void eat() {
        System.out.println("Eating");
    }
}
```

This duplicates code.

Instead:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

}

class Cat extends Animal {

}
```

Now the common behavior is placed in the parent.

```text
Common behavior
      ↓
Parent
      ↓
Children reuse it
```

---

# 18. Important Rule

Do **not** use inheritance just because two classes have similar fields.

Ask:

> **Is there a genuine IS-A relationship?**

Good:

```text
Dog IS-A Animal
Car IS-A Vehicle
Manager IS-A Employee
```

Bad example:

```text
Car IS-A Engine ❌
```

A car **HAS-A** engine.

---

# 19. Inheritance + Encapsulation

Inheritance does not remove Encapsulation.

Parent:

```java
class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }
}
```

Child:

```java
class Manager extends Employee {

}
```

The salary remains protected by the parent's encapsulation.

The child should use the parent's controlled interface rather than directly accessing the private field.

---

# Quick Revision

```text
Inheritance
     ↓
Parent + Child
     ↓
extends
     ↓
Code Reuse
     ↓
IS-A Relationship
     ↓
Inherited Members
```

---

# Interview Questions

### Q1. What is Inheritance?

Inheritance is an OOP mechanism where a child class acquires accessible properties and methods from a parent class.

### Q2. Which keyword is used for class inheritance?

```java
extends
```

### Q3. What is the parent class?

The class whose accessible members are inherited.

### Q4. What is the child class?

The class that inherits from the parent.

### Q5. Why is inheritance used?

Primarily for **code reuse and representing an IS-A relationship**.

### Q6. What is an IS-A relationship?

It represents inheritance.

Example:

```text
Dog IS-A Animal
```

### Q7. Can a child class have its own methods?

**Yes.**

### Q8. Can a child directly access a parent's private field?

**No.**

### Q9. Can multiple child classes inherit from one parent?

**Yes.**

Example:

```text
       Animal
       /    \
     Dog    Cat
```

---

# Part 1 Checklist

* [ ] Understand Inheritance.
* [ ] Understand Parent class.
* [ ] Understand Child class.
* [ ] Understand `extends`.
* [ ] Understand inherited methods.
* [ ] Understand code reuse.
* [ ] Understand IS-A.
* [ ] Understand IS-A vs HAS-A.
* [ ] Understand private members with inheritance.
* [ ] Understand inheritance + Encapsulation.
* [ ] Understand basic single inheritance.
* [ ] Understand basic hierarchical inheritance.
* [ ] Understand basic multilevel inheritance.

---

# Part 1 Completion Target

You should be able to look at:

```java
class Dog extends Animal {
}
```

and immediately understand:

```text
Dog
 ↓
Child class

Animal
 ↓
Parent class

extends
 ↓
Inheritance

Dog IS-A Animal
```

---

# Next Part

➡️ **Part 2 — `extends`, `super`, and Constructors**



# D_Inheritance — Part 2: `extends`, `super`, and Constructors

Part 2 builds directly on Part 1.

Now you will learn how the **parent and child constructors work**, how `super` connects the child to the parent, and how a child can access parent members.

---

# Learning Goals

After Part 2, you should understand:

* `extends`
* Parent constructor
* Child constructor
* `super()`
* `super(...)`
* `super` keyword
* Parent fields
* Parent methods
* Constructor chaining
* `this` vs `super`

---

# 1. `extends`

Inheritance between classes is created using:

```java
class Dog extends Animal {

}
```

Meaning:

```text
Dog
 ↓
inherits from
 ↓
Animal
```

So:

```text
Dog IS-A Animal
```

---

# 2. Parent Constructor + Child Constructor

Consider:

```java
class Animal {

    Animal() {
        System.out.println("Animal Constructor");
    }
}

class Dog extends Animal {

    Dog() {
        System.out.println("Dog Constructor");
    }
}
```

Create the object:

```java
Dog d = new Dog();
```

Output:

```text
Animal Constructor
Dog Constructor
```

The parent constructor executes before the child constructor.

---

# 3. Why Does Parent Constructor Run First?

A `Dog` object contains the parent portion as well.

Conceptually:

```text
Dog Object
 ├── Animal part
 └── Dog part
```

Therefore Java initializes the parent part first.

```text
new Dog()
    ↓
Animal constructor
    ↓
Dog constructor
```

---

# 4. `super()`

`super()` is used to call the parent class constructor.

Example:

```java
class Animal {

    Animal() {
        System.out.println("Animal");
    }
}

class Dog extends Animal {

    Dog() {
        super();

        System.out.println("Dog");
    }
}
```

Output:

```text
Animal
Dog
```

---

# 5. Important Rule About `super()`

If you don't explicitly write:

```java
super();
```

Java automatically inserts a call to the parent's no-argument constructor **if one is available**.

So:

```java
class Dog extends Animal {

    Dog() {
        System.out.println("Dog");
    }
}
```

is conceptually like:

```java
class Dog extends Animal {

    Dog() {
        super();

        System.out.println("Dog");
    }
}
```

---

# 6. Parent Constructor With Parameters

Suppose the parent has:

```java
class Animal {

    Animal(String name) {
        System.out.println("Animal: " + name);
    }
}
```

The child can call it using:

```java
class Dog extends Animal {

    Dog() {
        super("Tommy");
    }
}
```

Now:

```java
Dog d = new Dog();
```

Output:

```text
Animal: Tommy
```

---

# 7. `super(...)`

`super(...)` calls a constructor of the parent class.

Example:

```java
class Animal {

    Animal(String name, int age) {
        System.out.println(name);
        System.out.println(age);
    }
}

class Dog extends Animal {

    Dog() {
        super("Tommy", 5);
    }
}
```

Here:

```java
super("Tommy", 5);
```

calls:

```java
Animal(String name, int age)
```

---

# 8. `super()` Must Be First

A call to `super(...)` must appear as the first statement in a constructor.

Correct:

```java
Dog() {

    super("Tommy");

    System.out.println("Dog");
}
```

Incorrect:

```java
Dog() {

    System.out.println("Dog");

    super("Tommy"); // ❌
}
```

---

# 9. Parent Fields and `super`

Consider:

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(name);
        System.out.println(super.name);
    }
}
```

Output:

```text
Dog
Animal
```

Why?

```text
name
    ↓
current class field

super.name
    ↓
parent class field
```

---

# 10. `super` With Parent Methods

Suppose:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

Child:

```java
class Dog extends Animal {

    void sound() {

        super.sound();

        System.out.println("Dog sound");
    }
}
```

Now:

```java
Dog d = new Dog();

d.sound();
```

Output:

```text
Animal sound
Dog sound
```

`super.sound()` explicitly calls the parent's method.

---

# 11. `this` vs `super`

This is very important.

### `this`

Refers to the **current object/current class context**.

```java
this.name
```

### `super`

Refers to the **parent class portion**.

```java
super.name
```

Think:

```text
this
 ↓
Current class

super
 ↓
Parent class
```

---

# 12. Example — `this` and `super`

```java
class Animal {

    String name = "Animal";
}

class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(this.name);
        System.out.println(super.name);
    }
}
```

Output:

```text
Dog
Animal
```

---

# 13. Constructor Chaining

When inheritance is involved, constructors form a chain.

Example:

```java
class Animal {

    Animal() {
        System.out.println("Animal");
    }
}

class Mammal extends Animal {

    Mammal() {
        System.out.println("Mammal");
    }
}

class Dog extends Mammal {

    Dog() {
        System.out.println("Dog");
    }
}
```

Create:

```java
Dog d = new Dog();
```

Output:

```text
Animal
Mammal
Dog
```

Flow:

```text
new Dog()
    ↓
Animal()
    ↓
Mammal()
    ↓
Dog()
```

This is **constructor chaining**.

---

# 14. Constructor Chain Diagram

```text
             Dog()
              ↑
              |
           Mammal()
              ↑
              |
           Animal()
```

Execution happens from:

```text
Parent
  ↓
Child
```

So:

```text
Animal
   ↓
Mammal
   ↓
Dog
```

---

# 15. Parent Constructor With Child Constructor

Example:

```java
class Person {

    String name;

    Person(String name) {
        this.name = name;
    }
}

class Student extends Person {

    int rollNumber;

    Student(String name, int rollNumber) {

        super(name);

        this.rollNumber = rollNumber;
    }
}
```

Create:

```java
Student s = new Student("Om", 101);
```

Flow:

```text
new Student("Om", 101)
          ↓
super("Om")
          ↓
Person constructor
          ↓
this.rollNumber = 101
```

---

# 16. `super` vs `this`

### Constructor

```java
super(...);
```

calls the **parent constructor**.

```java
this(...);
```

calls another **constructor of the current class**.

Example:

```java
class Student {

    Student() {
        this("Unknown");
    }

    Student(String name) {
        System.out.println(name);
    }
}
```

So:

```text
this()
 ↓
same class constructor

super()
 ↓
parent class constructor
```

---

# 17. Parent Method + Child Method

A child can inherit a parent method:

```java
class Animal {

    void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {

}
```

Then:

```java
Dog d = new Dog();

d.eat();
```

The child uses the inherited method.

---

# 18. Calling Parent Method Explicitly

If the child has the same method:

```java
class Animal {

    void eat() {
        System.out.println("Animal eating");
    }
}

class Dog extends Animal {

    void eat() {

        super.eat();

        System.out.println("Dog eating");
    }
}
```

Then:

```java
Dog d = new Dog();

d.eat();
```

Output:

```text
Animal eating
Dog eating
```

This prepares you for **Method Overriding**, which will become important in Polymorphism.

---

# 19. Inheritance + Encapsulation

Your previous topic was Encapsulation.

These concepts work together.

Example:

```java
class Employee {

    private double salary;

    public double getSalary() {
        return salary;
    }
}
```

Child:

```java
class Manager extends Employee {

}
```

The child cannot directly access:

```java
salary
```

because it is private.

But it can use:

```java
getSalary()
```

because the method is public.

So:

```text
Encapsulation
      ↓
private data
      ↓
controlled access
      ↓
Inheritance
      ↓
Child uses parent's public/protected interface
```

---

# 20. Important Rules

Remember these:

### Rule 1

`extends` creates class inheritance.

### Rule 2

Parent constructor executes before child constructor.

### Rule 3

`super()` calls the parent constructor.

### Rule 4

`super(...)` can call a parameterized parent constructor.

### Rule 5

`super(...)` must be the first statement in a constructor.

### Rule 6

`super.method()` calls the parent method.

### Rule 7

`super.field` accesses the parent field when accessible.

### Rule 8

`this` refers to the current class/object context.

### Rule 9

`super` refers to the parent class context.

---

# Quick Revision

```text
extends
   ↓
Inheritance

super()
   ↓
Parent Constructor

super(...)
   ↓
Parameterized Parent Constructor

super.method()
   ↓
Parent Method

super.field
   ↓
Parent Field

this
   ↓
Current Class/Object

super
   ↓
Parent Class
```

---

# Interview Questions

### Q1. What is `extends`?

The keyword used to create inheritance between classes.

### Q2. What is `super()`?

It calls the parent class's constructor.

### Q3. When does the parent constructor execute?

Before the child constructor.

### Q4. What is constructor chaining?

The process where constructors execute through an inheritance hierarchy from parent to child.

### Q5. What does `super` mean?

It refers to the parent class portion of the current object.

### Q6. Difference between `this` and `super`?

```text
this
→ current class/object

super
→ parent class
```

### Q7. Can `super()` appear anywhere in a constructor?

**No.**

It must be the first statement.

### Q8. Can `super` call a parent method?

**Yes.**

```java
super.sound();
```

---

# Part 2 Checklist

* [ ] Understand `extends`.
* [ ] Understand parent constructor.
* [ ] Understand child constructor.
* [ ] Understand `super()`.
* [ ] Understand `super(...)`.
* [ ] Understand parent fields using `super`.
* [ ] Understand parent methods using `super`.
* [ ] Understand constructor chaining.
* [ ] Understand `this` vs `super`.
* [ ] Understand inheritance + Encapsulation.
* [ ] Understand why parent construction happens first.

---

# Part 2 Completion Target

You should be able to look at:

```java
class Student extends Person {

    Student(String name, int rollNumber) {

        super(name);

        this.rollNumber = rollNumber;
    }
}
```

and immediately understand:

```text
Student
   ↓
extends Person
   ↓
Student is child
Person is parent
   ↓
super(name)
   ↓
calls Person constructor
   ↓
this.rollNumber
   ↓
initializes Student's own field
```

---

# Next Part

➡️ **Part 3 — Inheritance Practice Problems**
# D_Inheritance — Part 3: Inheritance Practice Problems

Part 3 is the **coding practice layer**.

You already learned:

```text
Part 1 → Inheritance Fundamentals
Part 2 → extends + super + Constructors
Part 3 → Inheritance Practice
```

The goal is to stop only understanding inheritance theoretically and start **designing parent-child classes yourself**.

---

# Learning Goals

After completing Part 3, you should be able to:

* Create a parent class.
* Create a child class using `extends`.
* Reuse parent fields and methods.
* Call parent constructors using `super()`.
* Call parameterized parent constructors using `super(...)`.
* Understand constructor execution order.
* Identify an **IS-A relationship**.
* Avoid unnecessary duplication between parent and child classes.

---

# P1 — Animal → Dog

## Objective

Understand basic inheritance.

Create:

```java
class Animal {

    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}
```

Create:

```java
class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

### Main

Create:

```java
Dog d = new Dog();
```

Set:

```java
d.name = "Tommy";
```

Call:

```java
d.eat();
d.bark();
```

### Expected Output

```text
Animal is eating
Dog is barking
```

### Questions

1. Which class is the parent?
2. Which class is the child?
3. Where does `eat()` come from?
4. Where does `bark()` come from?
5. Is Dog an Animal?

---

# P2 — Person → Student

## Objective

Practice parent fields + child fields.

### Parent

```java
class Person {

    String name;
    int age;

    void displayPerson() {
        System.out.println(name);
        System.out.println(age);
    }
}
```

### Child

```java
class Student extends Person {

    int rollNumber;
    String course;

    void displayStudent() {
        System.out.println(rollNumber);
        System.out.println(course);
    }
}
```

### Main

Create:

```java
Student s = new Student();
```

Set:

```text
name = "Om"
age = 22
rollNumber = 101
course = "Computer Science"
```

Then call:

```java
s.displayPerson();
s.displayStudent();
```

### Core Lesson

The child can reuse the parent's members instead of declaring them again.

```text
Person
 ├── name
 ├── age
 └── displayPerson()

        ↓ extends

Student
 ├── rollNumber
 ├── course
 └── displayStudent()
```

---

# P3 — Vehicle → Car

## Objective

Understand inheritance through a real-world IS-A relationship.

### Parent

```java
class Vehicle {

    String brand;
    int speed;

    void start() {
        System.out.println("Vehicle started");
    }
}
```

### Child

```java
class Car extends Vehicle {

    int numberOfDoors;

    void drive() {
        System.out.println("Car is driving");
    }
}
```

### Main

Create a `Car`.

Set:

```text
brand = "Toyota"
speed = 100
numberOfDoors = 4
```

Call:

```java
start();
drive();
```

### Think

Why shouldn't `Car` declare another:

```java
String brand;
int speed;
```

if those properties already belong to `Vehicle`?

---

# P4 — Employee → Manager

## Objective

Practice inheritance with constructors.

### Parent

```java
class Employee {

    int employeeId;
    String name;

    Employee(int employeeId, String name) {

        this.employeeId = employeeId;
        this.name = name;
    }
}
```

### Child

Create:

```java
class Manager extends Employee
```

with:

```java
double bonus;
```

Create a constructor:

```text
Manager(employeeId, name, bonus)
```

Use:

```java
super(employeeId, name);
```

to initialize the parent portion.

### Main

Create:

```java
Manager m = new Manager(101, "Om", 50000);
```

Print:

```text
employeeId
name
bonus
```

### Core Lesson

```text
Manager constructor
       ↓
super(employeeId, name)
       ↓
Employee constructor
       ↓
Manager's own fields
```

---

# P5 — Animal → Dog Constructor Chain

## Objective

Understand constructor execution order.

Create:

```java
class Animal {

    Animal() {
        System.out.println("Animal Constructor");
    }
}
```

Then:

```java
class Dog extends Animal {

    Dog() {
        System.out.println("Dog Constructor");
    }
}
```

Create:

```java
Dog d = new Dog();
```

### Predict the output before running.

Expected:

```text
Animal Constructor
Dog Constructor
```

### Challenge

Explicitly add:

```java
super();
```

inside the `Dog` constructor.

Run again.

Ask yourself:

> Did the output change?

---

# P6 — Person → Student With `super(...)`

## Objective

Practice parameterized parent constructors.

### Parent

```java
class Person {

    String name;

    Person(String name) {
        this.name = name;
    }
}
```

### Child

Create:

```java
class Student extends Person {

    int rollNumber;

    Student(String name, int rollNumber) {

        super(name);

        this.rollNumber = rollNumber;
    }
}
```

### Main

```java
Student s = new Student("Om", 101);
```

Print:

```text
Om
101
```

### Important

Understand exactly what this does:

```java
super(name);
```

It calls:

```java
Person(String name)
```

---

# P7 — Parent Method + Child Method

## Objective

Understand inherited methods.

### Parent

```java
class Animal {

    void eat() {
        System.out.println("Animal eating");
    }
}
```

### Child

```java
class Dog extends Animal {

    void bark() {
        System.out.println("Dog barking");
    }
}
```

Create:

```java
Dog d = new Dog();
```

Call:

```java
d.eat();
d.bark();
```

### Think

`Dog` does not contain its own `eat()` method.

So why does this work?

```java
d.eat();
```

---

# P8 — `super` Method Practice

## Objective

Practice explicitly calling a parent method.

### Parent

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

### Child

Create:

```java
class Dog extends Animal {

    void sound() {

        super.sound();

        System.out.println("Dog sound");
    }
}
```

Create:

```java
Dog d = new Dog();
d.sound();
```

### Expected

```text
Animal sound
Dog sound
```

### Core Concept

```java
super.sound();
```

means:

> Call the parent version of `sound()`.

---

# P9 — Parent Field + `super`

## Objective

Understand `this` vs `super`.

Create:

```java
class Animal {

    String name = "Animal";
}
```

Child:

```java
class Dog extends Animal {

    String name = "Dog";

    void display() {

        System.out.println(this.name);
        System.out.println(super.name);
    }
}
```

Create:

```java
Dog d = new Dog();
d.display();
```

### Expected

```text
Dog
Animal
```

### Core Lesson

```text
this.name
    ↓
Dog's name

super.name
    ↓
Animal's name
```

---

# P10 ⭐ — Mini Inheritance Design

## Employee → Developer

This is the final and most important Part 3 problem.

### Parent Class

Create:

```java
class Employee
```

Fields:

```java
private int employeeId;
private String name;
private double salary;
```

Constructor:

```text
Employee(employeeId, name, salary)
```

Method:

```java
displayEmployee()
```

---

## Child Class

Create:

```java
class Developer extends Employee
```

Additional fields:

```java
private String programmingLanguage;
private int experience;
```

Constructor:

```text
Developer(
    employeeId,
    name,
    salary,
    programmingLanguage,
    experience
)
```

Use:

```java
super(employeeId, name, salary);
```

---

## Methods

Create:

```java
displayDeveloper()
```

The output should show:

```text
Employee ID
Name
Salary
Programming Language
Experience
```

---

## Example

```java
Developer d =
    new Developer(
        101,
        "Om",
        50000,
        "Java",
        2
    );
```

Then:

```java
d.displayEmployee();
d.displayDeveloper();
```

---

# Practice Order

Do not solve randomly.

```text
P1 Animal → Dog
        ↓
P2 Person → Student
        ↓
P3 Vehicle → Car
        ↓
P4 Employee → Manager
        ↓
P5 Constructor Chain
        ↓
P6 super(...)
        ↓
P7 Inherited Methods
        ↓
P8 super.method()
        ↓
P9 this vs super
        ↓
P10 Employee → Developer ⭐
```

---

# Difficulty Progression

| Problem | Main Focus                      |
| ------- | ------------------------------- |
| P1      | Basic `extends`                 |
| P2      | Parent + child members          |
| P3      | IS-A relationship               |
| P4      | Constructors + `super`          |
| P5      | Constructor chaining            |
| P6      | `super(...)`                    |
| P7      | Method inheritance              |
| P8      | `super.method()`                |
| P9      | `this` vs `super`               |
| P10     | **Complete inheritance design** |

---

# Your Rule for Part 3

For every problem:

```text
1. Identify Parent
        ↓
2. Identify Child
        ↓
3. Find common properties
        ↓
4. Put common properties in Parent
        ↓
5. Use extends
        ↓
6. Add child-specific properties
        ↓
7. Create constructors
        ↓
8. Use super(...) where required
        ↓
9. Create objects
        ↓
10. Test inherited members
```

---

# Important Design Question

Before creating inheritance, ask:

> **"Is the child actually an IS-A type of the parent?"**

Good:

```text
Dog IS-A Animal
Car IS-A Vehicle
Student IS-A Person
Manager IS-A Employee
Developer IS-A Employee
```

Bad:

```text
Engine IS-A Car       ❌
Battery IS-A Phone    ❌
Department IS-A College ❌
```

Those represent different relationships and should not automatically use inheritance.

---

# Part 3 Interview Checklist

You should be able to answer:

### 1. What is inheritance?

A mechanism where a child class acquires accessible properties and behavior from a parent class.

### 2. Which keyword creates class inheritance?

```java
extends
```

### 3. What is the parent class?

The class whose members are inherited.

### 4. What is the child class?

The class that extends another class.

### 5. Why use inheritance?

To represent an appropriate **IS-A relationship** and reuse common behavior.

### 6. What does `super()` do?

Calls the parent constructor.

### 7. What does `super(...)` do?

Calls a specific parameterized parent constructor.

### 8. Why does the parent constructor execute first?

The parent portion of the object must be initialized before the child portion.

### 9. Can a child use inherited methods?

Yes, when they are accessible.

### 10. What is `super.method()`?

It explicitly calls the parent class's method.

---

# Part 3 Completion Target

After P1–P10, you should be able to see:

```java
class Developer extends Employee
```

and immediately think:

```text
Developer
    ↓
IS-A
    ↓
Employee

Employee
 ├── employeeId
 ├── name
 └── salary

Developer
 ├── programmingLanguage
 └── experience
```

And when you see:

```java
super(employeeId, name, salary);
```

you should immediately understand:

```text
Developer Constructor
        ↓
super(...)
        ↓
Employee Constructor
        ↓
Initialize Employee state
        ↓
Initialize Developer state
```

---

# Part 3 Goal

By the end of Part 3, the basic inheritance flow should be clear:

```text
Parent Class
     ↓
extends
     ↓
Child Class
     ↓
Inherited Members
     ↓
Child-Specific Members
     ↓
super(...)
     ↓
Constructor Chaining
     ↓
Proper IS-A Design
```

➡️ **Next: Part 4 — Method Overriding + Runtime Polymorphism**

# D_Inheritance — Part 4: Method Overriding + Runtime Polymorphism

Part 4 focuses on the next major step after inheritance:

```text
Part 1 → Inheritance Fundamentals
Part 2 → extends + super + Constructors
Part 3 → Inheritance Practice
Part 4 → Method Overriding + Runtime Polymorphism
```

The goal is to understand that a child class can **provide its own implementation of an inherited method**, and Java can decide which implementation to execute **at runtime**.

---

# Learning Goals

After this part, you should understand:

* Method overriding
* Why overriding is needed
* `@Override`
* Parent reference → Child object
* Runtime method dispatch
* Upcasting
* Parent vs child implementation
* `super.method()`
* Overriding rules
* Inheritance + Polymorphism
* Dynamic method dispatch

---

# 1. What Is Method Overriding?

Suppose:

```java
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}
```

Now:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

The child `Dog` provides its own implementation of the inherited `sound()` method.

This is called:

> **Method Overriding**

---

# 2. Why Override a Method?

The parent can provide a common behavior:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

But different animals make different sounds.

```text
Animal
   ↓
sound()

Dog
   ↓
barks

Cat
   ↓
meows

Cow
   ↓
moos
```

Therefore each child can override the same method.

---

# 3. Basic Example

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

```java
class Cat extends Animal {

    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}
```

Now:

```java
Dog d = new Dog();
Cat c = new Cat();

d.sound();
c.sound();
```

Output:

```text
Dog barks
Cat meows
```

---

# 4. `@Override`

Use:

```java
@Override
```

above an overriding method.

Example:

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

`@Override` tells Java:

> "I intend to override a method from the parent class."

It also helps the compiler detect mistakes.

---

# 5. Parent Reference + Child Object ⭐

This is the most important concept of Part 4.

You can write:

```java
Animal a = new Dog();
```

Here:

```text
Reference type → Animal
Object type    → Dog
```

Diagram:

```text
Animal a
   |
   ↓
Dog Object
```

This is called:

> **Upcasting**

---

# 6. What Happens When We Call the Method?

Consider:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

Now:

```java
Animal a = new Dog();

a.sound();
```

What will execute?

```text
Dog barks
```

Not:

```text
Animal sound
```

Why?

Because the **actual object is Dog**.

Java chooses the overridden method based on the object at runtime.

This is called:

> **Runtime Polymorphism**

---

# 7. Runtime Method Dispatch

The important flow is:

```text
Animal a = new Dog();
       ↓
Reference type = Animal
       ↓
Actual object = Dog
       ↓
a.sound()
       ↓
Java checks actual object
       ↓
Dog.sound()
       ↓
"Dog barks"
```

This mechanism is called:

> **Dynamic Method Dispatch / Runtime Method Dispatch**

---

# 8. Very Important Example

```java
Animal a1 = new Dog();
Animal a2 = new Cat();
Animal a3 = new Cow();
```

All three references have the same type:

```text
Animal
```

But the objects are different:

```text
a1 → Dog
a2 → Cat
a3 → Cow
```

Now:

```java
a1.sound();
a2.sound();
a3.sound();
```

Output:

```text
Dog barks
Cat meows
Cow moos
```

This is the power of polymorphism.

---

# 9. One Parent Reference, Different Objects

Think:

```text
             Animal
                ↑
       ┌────────┼────────┐
       │        │        │
      Dog      Cat      Cow
```

We can write:

```java
Animal a;
```

Then:

```java
a = new Dog();
a.sound();
```

Then:

```java
a = new Cat();
a.sound();
```

Then:

```java
a = new Cow();
a.sound();
```

Same reference type:

```text
Animal
```

Different behavior:

```text
Dog
Cat
Cow
```

---

# 10. `super.method()` With Overriding

Suppose:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

Child:

```java
class Dog extends Animal {

    @Override
    void sound() {

        super.sound();

        System.out.println("Dog barks");
    }
}
```

Now:

```java
Dog d = new Dog();

d.sound();
```

Output:

```text
Animal sound
Dog barks
```

Why?

```java
super.sound();
```

explicitly calls the parent implementation.

---

# 11. `super` vs Overriding

Without `super`:

```java
@Override
void sound() {
    System.out.println("Dog barks");
}
```

Only the child implementation runs.

With:

```java
@Override
void sound() {

    super.sound();

    System.out.println("Dog barks");
}
```

Both implementations run.

```text
Parent method
     ↓
Child method
```

---

# 12. Parent Reference Can Call What?

Consider:

```java
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}
```

```java
class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Bark");
    }

    void run() {
        System.out.println("Running");
    }
}
```

Now:

```java
Animal a = new Dog();
```

You can call:

```java
a.eat();
a.sound();
```

But:

```java
a.run(); // ❌
```

Why?

Because the **reference type** is `Animal`.

The compiler only allows members available through the `Animal` reference.

---

# 13. Important Difference

Remember:

```java
Animal a = new Dog();
```

### What can you access?

The reference type controls **what can be called**:

```text
Animal reference
      ↓
Animal-visible methods
```

### Which overridden implementation runs?

The actual object controls **which overridden implementation executes**:

```text
Dog object
    ↓
Dog's overridden method
```

This distinction is extremely important.

---

# 14. Overriding Rules

For basic interview understanding, remember:

### Rule 1

The child method must have the same method signature.

Example:

```java
void sound()
```

must be overridden as:

```java
void sound()
```

---

### Rule 2

Return type must be compatible.

For basic practice, keep the same return type.

---

### Rule 3

The overriding method cannot reduce access visibility.

For example:

```java
public
```

cannot become:

```java
private
```

---

### Rule 4

`private` methods are not overridden.

---

### Rule 5

`static` methods are not overridden in the same runtime-polymorphic sense; they are hidden.

---

### Rule 6

Use:

```java
@Override
```

to make your intention explicit.

---

# 15. Overriding vs Overloading

Do not confuse these.

## Overriding

Parent → Child

Same method signature:

```java
class Animal {

    void sound() {}
}

class Dog extends Animal {

    @Override
    void sound() {}
}
```

```text
Inheritance
+
Same signature
```

---

## Overloading

Same class or inheritance hierarchy can have methods with different parameters:

```java
void add(int a, int b)

void add(int a, int b, int c)
```

```text
Different parameters
```

### Easy Memory Trick

```text
Overriding
→ Same method
→ Child changes behavior

Overloading
→ Same method name
→ Different parameters
```

---

# 16. Real-World Example — Payment

Parent:

```java
class Payment {

    void pay() {
        System.out.println("Processing payment");
    }
}
```

Child:

```java
class CreditCardPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Paying using Credit Card");
    }
}
```

Another child:

```java
class UpiPayment extends Payment {

    @Override
    void pay() {
        System.out.println("Paying using UPI");
    }
}
```

Now:

```java
Payment p1 = new CreditCardPayment();
Payment p2 = new UpiPayment();

p1.pay();
p2.pay();
```

Output:

```text
Paying using Credit Card
Paying using UPI
```

The parent reference provides a common interface, while each child provides its own behavior.

---

# 17. Real-World Example — Employee

Parent:

```java
class Employee {

    void work() {
        System.out.println("Employee works");
    }
}
```

Child:

```java
class Developer extends Employee {

    @Override
    void work() {
        System.out.println("Developer writes code");
    }
}
```

Another child:

```java
class Manager extends Employee {

    @Override
    void work() {
        System.out.println("Manager manages team");
    }
}
```

Now:

```java
Employee e1 = new Developer();
Employee e2 = new Manager();

e1.work();
e2.work();
```

Output:

```text
Developer writes code
Manager manages team
```

---

# 18. Polymorphism Diagram

```text
                 Employee
                    |
              work()
                    |
          ┌─────────┴─────────┐
          ↓                   ↓
      Developer             Manager
          |                   |
     work()              work()
          |                   |
    Write Code          Manage Team
```

From outside:

```java
Employee e;
```

But the behavior changes depending on the actual object.

---

# 19. Why Runtime Polymorphism Is Useful

Without polymorphism, you may write:

```java
Developer d = new Developer();
Manager m = new Manager();
Tester t = new Tester();
```

and handle each separately.

With polymorphism:

```java
Employee e;
```

you can work with different employee types through the common parent type.

Example:

```java
Employee[] employees = {
    new Developer(),
    new Manager(),
    new Tester()
};

for (Employee e : employees) {
    e.work();
}
```

Each object performs its own overridden implementation.

---

# 20. The Core Flow

This is the most important diagram in Part 4:

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
Animal a = new Dog();

a.sound();
```

Flow:

```text
Animal reference
      ↓
Dog object
      ↓
sound()
      ↓
Dog.sound()
```

---

# Practice Problems

Now write these yourself **before looking for solutions**.

---

# P1 — Animal Sound

Create:

```java
class Animal
```

with:

```java
void sound()
```

Create:

```java
class Dog extends Animal
```

Override:

```java
sound()
```

Output:

```text
Dog barks
```

---

# P2 — Animal → Cat

Create:

```java
class Cat extends Animal
```

Override:

```java
sound()
```

Output:

```text
Cat meows
```

Then:

```java
Animal a = new Cat();

a.sound();
```

Predict the output before running.

---

# P3 — Vehicle

Parent:

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}
```

Create:

```java
class Car extends Vehicle
```

Override:

```text
start()
```

Output:

```text
Car starts with key
```

---

# P4 — Employee

Parent:

```java
class Employee {

    void work() {
        System.out.println("Employee works");
    }
}
```

Create:

```java
Developer
Manager
Tester
```

Each should override:

```java
work()
```

with different output.

---

# P5 — Parent Reference

Create:

```java
Animal a1 = new Dog();
Animal a2 = new Cat();
```

Call:

```java
a1.sound();
a2.sound();
```

Understand why two different outputs occur.

---

# P6 — `super.method()`

Create:

```java
class Animal {

    void sound() {
        System.out.println("Animal sound");
    }
}
```

Dog should override `sound()` and call:

```java
super.sound();
```

Then print:

```text
Dog sound
```

Expected:

```text
Animal sound
Dog sound
```

---

# P7 — Payment System

Create:

```text
Payment
CreditCardPayment
UPIPayment
CashPayment
```

Parent:

```java
pay()
```

Override `pay()` in each child.

Then:

```java
Payment p1 = new CreditCardPayment();
Payment p2 = new UPIPayment();
Payment p3 = new CashPayment();
```

Call:

```java
p1.pay();
p2.pay();
p3.pay();
```

---

# P8 — Shape

Create:

```text
Shape
Circle
Rectangle
```

Parent:

```java
calculateArea()
```

Override it in:

```text
Circle
Rectangle
```

Use:

```java
Shape s1 = new Circle();
Shape s2 = new Rectangle();
```

Call:

```java
s1.calculateArea();
s2.calculateArea();
```

---

# P9 — Constructor + Overriding

Create:

```text
Animal
Dog
```

Animal constructor:

```java
Animal() {
    System.out.println("Animal Constructor");
}
```

Dog constructor:

```java
Dog() {
    System.out.println("Dog Constructor");
}
```

Dog should also override:

```java
sound()
```

Test:

```java
Animal a = new Dog();
a.sound();
```

Understand separately:

```text
Constructor execution
        ↓
Method execution
```

---

# P10 ⭐ — Mini Polymorphism Challenge

Design:

```text
Employee
   ↓
Developer
Manager
Tester
```

### Parent

```java
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

### Requirements

Each child must override:

```java
work()
```

Developer:

```text
Developer writes code
```

Manager:

```text
Manager manages team
```

Tester:

```text
Tester tests application
```

Create:

```java
Employee e1 = new Developer("Om");
Employee e2 = new Manager("Rahul");
Employee e3 = new Tester("Amit");
```

Call:

```java
e1.work();
e2.work();
e3.work();
```

Expected:

```text
Developer writes code
Manager manages team
Tester tests application
```

---

# Practice Order

```text
P1 Animal → Dog
       ↓
P2 Animal → Cat
       ↓
P3 Vehicle → Car
       ↓
P4 Employee hierarchy
       ↓
P5 Parent reference
       ↓
P6 super.method()
       ↓
P7 Payment
       ↓
P8 Shape
       ↓
P9 Constructor + Overriding
       ↓
P10 Employee Polymorphism ⭐
```

---

# Difficulty Progression

| Problem | Focus                             |
| ------- | --------------------------------- |
| P1      | Basic overriding                  |
| P2      | Multiple child implementations    |
| P3      | Real-world overriding             |
| P4      | Multiple child classes            |
| P5      | Parent reference + child object   |
| P6      | `super.method()`                  |
| P7      | Polymorphism                      |
| P8      | Polymorphism + calculations       |
| P9      | Constructors + overriding         |
| P10     | **Complete runtime polymorphism** |

---

# Interview Checklist

### Q1. What is method overriding?

When a child class provides its own implementation of an inherited parent method with the same signature.

### Q2. Why is `@Override` used?

To indicate that the method is intended to override a parent method and allow the compiler to catch mistakes.

### Q3. What is runtime polymorphism?

When an overridden method is selected based on the actual object at runtime.

### Q4. What does this mean?

```java
Animal a = new Dog();
```

```text
Reference type → Animal
Object type    → Dog
```

### Q5. Which `sound()` executes?

```java
Animal a = new Dog();
a.sound();
```

The `Dog` implementation executes if `Dog` overrides `sound()`.

### Q6. What is upcasting?

Treating a child object as a reference of its parent type.

```java
Animal a = new Dog();
```

### Q7. What does `super.sound()` do?

Calls the parent implementation of `sound()`.

### Q8. Overriding vs Overloading?

```text
Overriding
→ Parent + Child
→ Same signature
→ Runtime polymorphism

Overloading
→ Different parameter list
→ Compile-time method selection
```

---

# Part 4 Checklist

* [ ] Understand method overriding.
* [ ] Understand `@Override`.
* [ ] Understand parent reference + child object.
* [ ] Understand upcasting.
* [ ] Understand runtime polymorphism.
* [ ] Understand dynamic method dispatch.
* [ ] Understand `super.method()`.
* [ ] Understand reference type vs object type.
* [ ] Understand overriding vs overloading.
* [ ] Practice polymorphism with multiple child classes.
* [ ] Understand why polymorphism is useful.

---

# Part 4 Completion Target

You should be able to see:

```java
Employee e = new Developer();
```

and immediately understand:

```text
Employee
   ↓
Reference Type

Developer
   ↓
Actual Object

e.work()
   ↓
Runtime checks actual object
   ↓
Developer.work()
```

The central idea is:

```text
Inheritance
      ↓
Method Overriding
      ↓
Parent Reference
      ↓
Child Object
      ↓
Runtime Method Dispatch
      ↓
Runtime Polymorphism
```

---

# Next Part

➡️ **Part 5 — Inheritance + Polymorphism Advanced Practice / Design Mastery**
