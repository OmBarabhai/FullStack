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

