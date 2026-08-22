# D_Inheritance — Part 5: Inheritance + Polymorphism Advanced Practice / Design Mastery

## Purpose

Part 5 is the **advanced practice and design layer** of Inheritance.

You have already learned:

```text
Part 1 → Inheritance Fundamentals
Part 2 → extends + super + Constructors
Part 3 → Inheritance Practice
Part 4 → Method Overriding + Runtime Polymorphism
```

Now the goal is to combine those concepts and use inheritance correctly in small designs.

This part is **not about learning another large syntax topic**.

It is about answering:

> Can I design and reason about an inheritance hierarchy correctly?

---

# Learning Goals

After completing Part 5, you should be able to:

- Design a parent-child hierarchy from a requirement.
- Identify a genuine IS-A relationship.
- Separate common behavior from child-specific behavior.
- Use constructors correctly across an inheritance hierarchy.
- Use `super(...)` when parent state must be initialized.
- Override methods correctly.
- Use `@Override`.
- Use parent references with child objects.
- Predict runtime polymorphism.
- Understand reference type vs object type.
- Use `super.method()` when parent behavior must also run.
- Avoid inheritance when the relationship is actually HAS-A.
- Review a small inheritance design for common mistakes.
- Explain the complete inheritance → polymorphism flow in an interview.

---

# Concepts

## 1. Inheritance Is a Design Relationship

Inheritance should not be selected only because two classes share fields or methods.

The first question is:

```text
Is Child actually an IS-A Parent?
```

Good:

```text
Dog IS-A Animal
Car IS-A Vehicle
Developer IS-A Employee
Manager IS-A Employee
```

Bad:

```text
Engine IS-A Car       ❌
Battery IS-A Phone    ❌
Department IS-A College ❌
```

Those are not natural inheritance relationships.

For those cases, another relationship such as HAS-A may be more appropriate.

---

# 2. Common State and Behavior Belong in the Parent

Suppose:

```text
Employee
├── name
├── employeeId
└── work()

Developer
└── programmingLanguage

Manager
└── teamSize

Tester
└── testingTool
```

The common state and behavior belong in `Employee`.

Child-specific information belongs in the child.

```text
Employee
   ↓
Common state + common behavior
   ↓
Developer / Manager / Tester
   ↓
Specialized state + specialized behavior
```

Do not duplicate the same common fields in every child.

---

# 3. Constructor Flow in a Hierarchy

For:

```java
Employee e = new Developer("Om");
```

The object is a `Developer`, but the parent portion must be initialized first.

Conceptually:

```text
new Developer("Om")
        ↓
Employee constructor
        ↓
Developer constructor
```

If the parent requires arguments:

```java
super("Om");
```

must be used appropriately by the child constructor.

Remember:

```text
super(...)
→ parent constructor
```

---

# 4. Overriding + Runtime Polymorphism

The core flow from Part 4 remains:

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
Employee e = new Developer("Om");
e.work();
```

If `Developer` overrides `work()`:

```text
Reference type → Employee
Object type    → Developer

e.work()
   ↓
Developer.work()
```

---

# 5. Reference Type vs Object Type

This is one of the most important interview distinctions.

Given:

```java
Employee e = new Developer("Om");
```

Remember:

```text
Reference Type → Employee
Actual Object  → Developer
```

The reference type controls what members are available through the reference.

The actual object determines which overridden implementation runs.

Example:

```java
e.work();
```

If `Developer` overrides `work()`:

```text
Developer.work()
```

runs.

But if `Developer` has:

```java
void writeCode()
```

and `writeCode()` is not declared in `Employee`, this does not work:

```java
e.writeCode(); // ❌
```

because the reference type is `Employee`.

---

# 6. Upcasting

This is valid:

```java
Employee e = new Developer("Om");
```

because:

```text
Developer IS-A Employee
```

This is called **upcasting**.

The child object is being treated through a parent reference.

```text
Developer object
       ↓
Employee reference
```

Upcasting is especially useful for runtime polymorphism.

---

# 7. `super.method()` in Advanced Design

Sometimes the child wants to extend the parent's behavior rather than completely replace it.

Example:

```java
class Employee {

    void work() {
        System.out.println("Employee works");
    }
}

class Developer extends Employee {

    @Override
    void work() {
        super.work();
        System.out.println("Developer writes code");
    }
}
```

Output:

```text
Employee works
Developer writes code
```

The design means:

```text
Parent behavior
      +
Child-specific behavior
```

Do not use `super.method()` automatically.

Use it when the parent implementation is actually useful to the child behavior.

---

# Advanced Practice Problems

Solve each problem yourself before reading the solution.

The progression intentionally moves from hierarchy design to runtime polymorphism and then to design review.

---

# P1 — Employee Hierarchy Design

## Objective

Design a basic employee hierarchy.

Create:

```text
Employee
├── Developer
├── Manager
└── Tester
```

### Parent Requirements

`Employee` should contain:

```java
String name;
int employeeId;
```

Constructor:

```text
Employee(employeeId, name)
```

Method:

```java
void work()
```

Default output:

```text
Employee works
```

### Child Requirements

`Developer`:

```text
work() → Developer writes code
```

`Manager`:

```text
work() → Manager manages team
```

`Tester`:

```text
work() → Tester tests application
```

### Main

Create:

```java
Employee e1 = new Developer(101, "Om");
Employee e2 = new Manager(102, "Rahul");
Employee e3 = new Tester(103, "Amit");
```

Call:

```java
e1.work();
e2.work();
e3.work();
```

### Expected Output

```text
Developer writes code
Manager manages team
Tester tests application
```

### Main Lesson

One parent reference type can represent multiple child objects.

---

# P2 — Employee Array Polymorphism

## Objective

Use runtime polymorphism with an array.

Using the hierarchy from P1:

```java
Employee[] employees = {
    new Developer(101, "Om"),
    new Manager(102, "Rahul"),
    new Tester(103, "Amit")
};
```

Loop through:

```java
for (Employee e : employees) {
    e.work();
}
```

### Expected Output

```text
Developer writes code
Manager manages team
Tester tests application
```

### Questions

1. What is the type of `e`?
2. What is the actual object during each iteration?
3. Why does a different `work()` execute?
4. Is this compile-time or runtime polymorphism?

### Expected Answers

```text
1. Employee
2. Developer / Manager / Tester
3. Runtime method dispatch selects the overridden method.
4. Runtime polymorphism.
```

---

# P3 — Payment System Design

## Objective

Use polymorphism in a realistic design.

Create:

```text
Payment
├── CreditCardPayment
├── UPIPayment
└── CashPayment
```

Parent:

```java
class Payment {

    void pay() {
        System.out.println("Processing payment");
    }
}
```

Override `pay()` in every child.

Expected behavior:

```text
CreditCardPayment → Paying using Credit Card
UPIPayment        → Paying using UPI
CashPayment       → Paying using Cash
```

Create:

```java
Payment[] payments = {
    new CreditCardPayment(),
    new UPIPayment(),
    new CashPayment()
};
```

Loop through the array and call:

```java
pay();
```

### Expected Output

```text
Paying using Credit Card
Paying using UPI
Paying using Cash
```

### Design Lesson

The caller can work with the parent type without knowing the concrete child implementation.

---

# P4 — Shape Calculation

## Objective

Combine inheritance, overriding, and runtime polymorphism.

Create:

```text
Shape
├── Circle
└── Rectangle
```

Parent:

```java
void calculateArea()
```

Circle:

```text
area = π × radius × radius
```

Rectangle:

```text
area = length × width
```

Use:

```java
Shape s1 = new Circle(5);
Shape s2 = new Rectangle(4, 6);
```

Call:

```java
s1.calculateArea();
s2.calculateArea();
```

### Expected Result

Circle:

```text
78.54...
```

Rectangle:

```text
24.0
```

The exact formatting may depend on how you print the value.

### Main Lesson

The same method call:

```java
calculateArea()
```

can produce different behavior depending on the actual object.

---

# P5 — Constructor + Runtime Polymorphism

## Objective

Separate constructor execution from overridden method execution.

Create:

```text
Animal
└── Dog
```

Parent:

```java
Animal() {
    System.out.println("Animal Constructor");
}

void sound() {
    System.out.println("Animal sound");
}
```

Child:

```java
Dog() {
    System.out.println("Dog Constructor");
}

@Override
void sound() {
    System.out.println("Dog barks");
}
```

Create:

```java
Animal a = new Dog();
a.sound();
```

### Expected Output

```text
Animal Constructor
Dog Constructor
Dog barks
```

### Critical Lesson

Do not mix these two mechanisms:

```text
Object construction
        ↓
Parent constructor
        ↓
Child constructor

Method call
        ↓
Runtime dispatch
        ↓
Overridden child method
```

Constructor selection is not runtime method overriding.

---

# P6 — Parent Behavior + Child Behavior

## Objective

Use `super.method()` intentionally.

Create:

```java
class Employee {

    void work() {
        System.out.println("Employee performs general work");
    }
}
```

Create:

```java
class Developer extends Employee {

    @Override
    void work() {
        super.work();
        System.out.println("Developer writes code");
    }
}
```

### Expected Output

```text
Employee performs general work
Developer writes code
```

### Question

Why is `super.work()` useful here?

### Expected Answer

Because the child wants to retain the parent's behavior and add specialized behavior.

---

# P7 — Find the Design Error

## Objective

Identify an incorrect inheritance relationship.

Consider:

```java
class Engine {
}

class Car extends Engine {
}
```

### Question

Is this good inheritance design?

### Answer

No.

The relationship:

```text
Car IS-A Engine
```

is false.

A better conceptual relationship is:

```text
Car HAS-A Engine
```

For example:

```java
class Car {

    Engine engine;
}
```

### Main Lesson

Do not use inheritance only because one object contains or uses another object.

---

# P8 — Reference Type Trap

## Objective

Test reference type vs object type.

Given:

```java
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

    void run() {
        System.out.println("Dog runs");
    }
}
```

Now:

```java
Animal a = new Dog();
```

Determine which statements compile:

```java
a.sound();
a.run();
```

### Answer

```java
a.sound(); // ✅
a.run();   // ❌
```

Why?

```text
Reference type = Animal
```

`Animal` exposes `sound()` but does not declare `run()`.

However:

```java
a.sound();
```

executes:

```text
Dog.sound()
```

because the actual object is `Dog`.

### Key Rule

```text
Reference type
→ controls accessible members

Actual object
→ controls overridden implementation
```

---

# P9 — Design a Notification Hierarchy

## Objective

Apply the same design pattern to a different domain.

Create:

```text
Notification
├── EmailNotification
├── SMSNotification
└── PushNotification
```

Parent:

```java
void send()
```

Child behavior:

```text
EmailNotification → Sending Email
SMSNotification   → Sending SMS
PushNotification  → Sending Push Notification
```

Create:

```java
Notification[] notifications = {
    new EmailNotification(),
    new SMSNotification(),
    new PushNotification()
};
```

Loop through them:

```java
for (Notification n : notifications) {
    n.send();
}
```

### Expected Output

```text
Sending Email
Sending SMS
Sending Push Notification
```

### Design Question

Why is this better than writing separate unrelated code for every notification type?

### Expected Reason

Because the caller can work through one common parent type while each child supplies its own implementation.

---

# P10 ⭐ — Final Inheritance + Polymorphism Design Challenge

## Objective

Design a complete small hierarchy without blindly copying the previous examples.

### Requirement

Build:

```text
Employee
├── Developer
├── Manager
└── Tester
```

### Parent State

```text
employeeId
name
salary
```

Use private fields where appropriate.

### Parent Constructor

```text
Employee(employeeId, name, salary)
```

### Parent Method

```java
void displayBasicInfo()
```

Print:

```text
Employee ID
Name
Salary
```

### Parent Behavior

```java
void work()
```

Default:

```text
Employee works
```

### Developer

Additional field:

```text
programmingLanguage
```

Override:

```text
work() → Developer writes Java code
```

### Manager

Additional field:

```text
teamSize
```

Override:

```text
work() → Manager manages team
```

### Tester

Additional field:

```text
testingTool
```

Override:

```text
work() → Tester tests application
```

### Constructors

Each child constructor must correctly initialize the parent state using:

```java
super(...);
```

### Main

Create:

```java
Employee e1 =
    new Developer(101, "Om", 50000, "Java");

Employee e2 =
    new Manager(102, "Rahul", 70000, 8);

Employee e3 =
    new Tester(103, "Amit", 45000, "Selenium");
```

Call:

```java
e1.work();
e2.work();
e3.work();
```

Also create:

```java
Employee[] employees = { e1, e2, e3 };
```

Loop through the array and call:

```java
displayBasicInfo();
work();
```

### Expected Behavior

Each object should display its own common employee information and its own overridden work behavior.

The exact formatting is your implementation choice.

### Design Requirements

Your solution should demonstrate:

```text
Inheritance
+
Encapsulation
+
Constructor chaining
+
super(...)
+
Method overriding
+
@Override
+
Upcasting
+
Runtime polymorphism
```

This is the final integration problem for Inheritance.

---

# Practice Progression

Solve in this order:

```text
P1 Employee hierarchy
        ↓
P2 Employee array
        ↓
P3 Payment system
        ↓
P4 Shape
        ↓
P5 Constructor + overriding
        ↓
P6 super.method()
        ↓
P7 Design error
        ↓
P8 Reference type trap
        ↓
P9 Notification hierarchy
        ↓
P10 Employee design challenge ⭐
```

---

# Difficulty Progression

| Problem | Main Focus |
|---|---|
| P1 | Hierarchy design |
| P2 | Polymorphism with arrays |
| P3 | Real-world polymorphism |
| P4 | Polymorphism + calculations |
| P5 | Constructors + overriding |
| P6 | Parent + child behavior |
| P7 | IS-A vs HAS-A design |
| P8 | Reference type vs object type |
| P9 | Generalizing polymorphic design |
| P10 | Complete inheritance design |

---

# Design Rules

## Rule 1 — Check IS-A First

Before writing:

```java
class Child extends Parent
```

ask:

```text
Child IS-A Parent?
```

If the answer is no, stop.

---

## Rule 2 — Put Common State in the Parent

If every child needs the same state, consider placing that state in the parent.

Example:

```text
Employee
├── employeeId
├── name
└── salary
```

rather than repeating those fields in every employee subtype.

---

## Rule 3 — Put Specialized Behavior in the Child

Example:

```text
Developer → writes code
Manager   → manages team
Tester    → tests application
```

These behaviors can be represented through overriding when they share a common parent operation such as:

```java
work();
```

---

## Rule 4 — Use `@Override`

Prefer:

```java
@Override
void work() {
}
```

It communicates intent and allows the compiler to detect an incorrect override.

---

## Rule 5 — Use `super(...)` for Parent Construction

If the parent has a parameterized constructor:

```java
Employee(int employeeId, String name, double salary)
```

the child should initialize that parent state through:

```java
super(employeeId, name, salary);
```

---

## Rule 6 — Use `super.method()` Only When Needed

Use:

```java
super.work();
```

when the parent implementation is genuinely part of the child behavior.

Do not add it just because inheritance exists.

---

## Rule 7 — Understand the Two Types

For:

```java
Employee e = new Developer();
```

memorize:

```text
Employee
→ reference type

Developer
→ actual object type
```

Then:

```text
What can I call?
→ reference type

Which overridden implementation runs?
→ actual object
```

---

## Rule 8 — Do Not Confuse Overriding and Overloading

### Overriding

```text
Parent + Child
Same signature
Runtime method dispatch
Runtime polymorphism
```

### Overloading

```text
Different parameter list
Method selection based on arguments
Compile-time resolution
```

---

## Rule 9 — Do Not Force Inheritance

If the relationship is:

```text
Car HAS-A Engine
```

do not write:

```java
class Car extends Engine
```

Use an object relationship instead.

---

## Rule 10 — Keep the Parent General

A good parent represents behavior/state common to its children.

Avoid creating a parent that contains details belonging only to one child.

---

# Common Mistakes

## Mistake 1 — Thinking Parent Reference Means Parent Object

Wrong:

```java
Employee e = new Developer();
```

means:

```text
Employee object
```

Correct:

```text
Reference type → Employee
Actual object → Developer
```

---

## Mistake 2 — Thinking Parent Reference Calls Parent Override

Given:

```java
Employee e = new Developer();
e.work();
```

If `Developer` overrides `work()`, the `Developer` implementation runs.

The reference type does not force the parent implementation.

---

## Mistake 3 — Calling Child-Only Methods Through Parent Reference

Given:

```java
Employee e = new Developer();
```

This may fail:

```java
e.writeCode(); // ❌
```

if `writeCode()` is only declared in `Developer`.

---

## Mistake 4 — Confusing Constructor Execution With Runtime Dispatch

Given:

```java
Animal a = new Dog();
```

construction is:

```text
Animal constructor
↓
Dog constructor
```

But:

```java
a.sound();
```

can dispatch to:

```text
Dog.sound()
```

if `Dog` overrides it.

These are different mechanisms.

---

## Mistake 5 — Forgetting `super(...)`

If the parent requires constructor arguments, the child cannot simply ignore the parent initialization.

Example:

```java
class Employee {

    Employee(int id) {
    }
}
```

Then a child constructor needs to properly invoke the matching parent constructor.

---

## Mistake 6 — Using Inheritance for Code Reuse Alone

Two classes sharing a method does not automatically mean one should extend the other.

The relationship must make semantic sense.

---

## Mistake 7 — Duplicating Parent State

Avoid:

```java
class Employee {
    String name;
}

class Developer extends Employee {
    String name; // ❌ unnecessary duplicate
}
```

The inherited `name` already belongs to the parent design.

---

# Concept Explanation

## The Complete Inheritance + Polymorphism Chain

Memorize this flow:

```text
Inheritance
     ↓
Parent + Child relationship
     ↓
Common behavior in Parent
     ↓
Child overrides behavior
     ↓
Parent reference can refer to Child
     ↓
Upcasting
     ↓
Method call
     ↓
Runtime checks actual object
     ↓
Overridden child implementation
     ↓
Runtime Polymorphism
```

Example:

```java
Employee e = new Developer();
e.work();
```

Think:

```text
Employee
   ↓
reference type

Developer
   ↓
actual object

work()
   ↓
overridden

Developer.work()
   ↓
runtime dispatch
```

---

# Interview Revision

## Q1. Why should inheritance be used?

For a genuine IS-A relationship and to represent/reuse common state and behavior appropriately.

---

## Q2. What is upcasting?

Treating a child object through a parent reference.

```java
Employee e = new Developer();
```

---

## Q3. What controls accessible members?

The reference type.

---

## Q4. What determines which overridden method executes?

The actual object at runtime.

---

## Q5. What is runtime polymorphism?

When an overridden method is selected based on the actual object during runtime.

---

## Q6. What is dynamic method dispatch?

The runtime mechanism through which an overridden instance method is selected based on the actual object.

---

## Q7. Why use `@Override`?

To explicitly indicate an intended override and allow the compiler to catch mistakes.

---

## Q8. What does `super.method()` do?

It explicitly invokes the parent implementation of that method.

---

## Q9. What is the difference between `super(...)` and `super.method()`?

```text
super(...)
→ parent constructor

super.method()
→ parent method
```

---

## Q10. What is the difference between overriding and overloading?

```text
Overriding
→ Parent + Child
→ Same signature
→ Runtime dispatch

Overloading
→ Different parameter list
→ Compile-time method selection
```

---

## Q11. Can private methods be overridden?

No. Private methods are not inherited in a way that permits overriding.

---

## Q12. Are static methods overridden?

Static methods are hidden rather than overridden in the runtime-polymorphic sense.

---

## Q13. Why does this work?

```java
Employee e = new Developer();
```

Because:

```text
Developer IS-A Employee
```

---

## Q14. Why might this fail?

```java
Employee e = new Developer();
e.writeCode();
```

Because `writeCode()` may be available only through the `Developer` type and not declared in `Employee`.

---

## Q15. When should inheritance NOT be used?

When the relationship is not genuinely IS-A.

Example:

```text
Car HAS-A Engine
```

---

# Interview Whiteboard Test

Without running code, predict the output:

```java
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

Expected:

```text
Animal Constructor
Dog Constructor
Dog barks
```

Reasoning:

```text
new Dog()
    ↓
Animal constructor
    ↓
Dog constructor

a.sound()
    ↓
actual object = Dog
    ↓
Dog.sound()
```

If you cannot predict this without executing the code, Part 4/5 concepts are not yet strong enough.

---

# Final Checklist

- [ ] Can identify a genuine IS-A relationship.
- [ ] Can decide what belongs in the parent.
- [ ] Can decide what belongs in the child.
- [ ] Can design a parent-child hierarchy.
- [ ] Can use `extends`.
- [ ] Can initialize parent state with `super(...)`.
- [ ] Understand constructor execution order.
- [ ] Can override methods correctly.
- [ ] Use `@Override`.
- [ ] Understand upcasting.
- [ ] Understand parent reference + child object.
- [ ] Understand reference type vs object type.
- [ ] Can predict runtime method dispatch.
- [ ] Understand runtime polymorphism.
- [ ] Can use `super.method()` intentionally.
- [ ] Can distinguish overriding from overloading.
- [ ] Can identify inheritance design mistakes.
- [ ] Can distinguish IS-A from HAS-A.
- [ ] Can solve P1–P10 without copying.
- [ ] Can explain the complete inheritance + polymorphism flow in an interview.

---

# Completion Status

```text
D_Inheritance — Part 1 ✅
D_Inheritance — Part 2 ✅
D_Inheritance — Part 3 ✅
D_Inheritance — Part 4 ⏳
D_Inheritance — Part 5 ⏳
```

Part 5 is complete as a study/practice file when you finish P1–P10 and can explain the final inheritance + polymorphism flow without notes.

Do not mark Part 4 or Part 5 as completed merely because the Markdown file was created.

---

# Next Part

After Part 5 is explicitly completed, the next major OOP topic is:

```text
E — Polymorphism
```

Do not start the next Part automatically.

Finish and explicitly mark the current Part as completed first.
