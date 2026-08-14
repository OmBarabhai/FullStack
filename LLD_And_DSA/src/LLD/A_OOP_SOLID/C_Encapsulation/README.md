# C_Encapsulation — Part 1: Introduction

> **Encapsulation means bundling data and the methods that work on that data inside one class, while controlling direct access to the data.**

---

## Learning Goals

After this part, you should be able to:

* Understand what Encapsulation is.
* Understand Data Hiding.
* Understand why fields are made `private`.
* Understand controlled access.
* Understand why Getters and Setters are used.

---

## Why Do We Need Encapsulation?

Without Encapsulation, a field like `balance` can be changed directly from outside the class, which can create invalid or unsafe data. Encapsulation solves this by making the class control how its data is accessed and modified.

---

## What is Encapsulation?

Encapsulation combines data and behavior inside a class and provides controlled access to that data. In Java, this is usually done with `private` fields, `public` getters, `public` setters, and validation inside methods.

---

## Data Hiding

Data Hiding means preventing direct access to internal data. If a field is `private`, outside code cannot access it directly.

---

## Why Use `private`?

`private` means the field can only be directly accessed inside its own class. Outside code cannot modify it directly.

---

## Controlled Access

Instead of changing data directly, we use methods such as setters. This gives the class a chance to validate the value before storing it.

---

## Getter

A Getter is used to read private data. It returns the value of the field without exposing the field directly.

---

## Setter

A Setter is used to modify private data. It can also validate the value before updating the field.

---

## Getter vs Setter

A Getter reads data, while a Setter changes data. Getters usually return a value, while Setters usually return `void`.

---

## Real-World Analogy

Think of an ATM: you do not directly touch the bank’s internal data. You use controlled operations like withdraw and deposit. Encapsulation works the same way.

---

## Quick Revision

* Encapsulation protects object data.
* `private` hides fields from outside classes.
* Getters provide controlled read access.
* Setters provide controlled write access.
* Validation can be added inside setters.

---

## Interview Answer

Encapsulation is wrapping data and methods inside a class and controlling access to that data.

---

## Success Checklist

* Understand Encapsulation.
* Understand Data Hiding.
* Understand `private`.
* Understand Getter.
* Understand Setter.
* Understand controlled access.
* Understand why direct field access can be dangerous.

---
# C_Encapsulation — Part 2: `private`, Getters & Setters

> **Encapsulation protects an object's data by restricting direct access and providing controlled ways to read or modify it.**

---

## Learning Goals

After this part, you should be able to:

* Make fields `private`
* Understand why direct access stops working
* Create Getters
* Create Setters
* Use `this` inside Setters
* Read private data using Getters
* Modify private data using Setters
* Understand controlled access

---

# 1. Making Fields `private`

### Before Encapsulation

```java
class Student {

    String name;
    int age;
}
```

Outside code can directly modify them:

```java
Student s = new Student();

s.name = "Om";
s.age = 22;
```



---

# 2. After Encapsulation

Make the fields `private`:

```java
class Student {

    private String name;
    private int age;
}
```

Now this is not allowed:

```java
Student s = new Student();

s.name = "Om";   // ERROR
s.age = 22;      // ERROR
```

Because `name` and `age` are private.

---

# 3. What Does `private` Mean?

```java
private int age;
```

Means:

> **Only the class itself can directly access `age`.**

Think:

```text
Outside Class
      |
      X
      |
private field
```

Direct access is blocked.

---

# 4. Why Do We Need Getters?

If a field is private, outside code cannot read it directly.

So we create a **Getter**.

```java
class Student {

    private String name;

    public String getName() {
        return name;
    }
}
```

Now:

```java
Student s = new Student();

System.out.println(s.getName());
```

The Getter provides controlled access to the private field.

---

# 5. Getter Syntax

General syntax:

```java
public dataType getFieldName() {
    return fieldName;
}
```

Example:

```java
private int age;

public int getAge() {
    return age;
}
```

For `String`:

```java
private String name;

public String getName() {
    return name;
}
```

For `double`:

```java
private double salary;

public double getSalary() {
    return salary;
}
```



---

# 6. Why Does Getter Return the Field?

Suppose:

```java
private int age;
```

and:

```java
public int getAge() {
    return age;
}
```

If:

```text
age = 22
```

then:

```java
System.out.println(s.getAge());
```

returns:

```text
22
```

Flow:

```text
s.getAge()
    ↓
getAge()
    ↓
return age
    ↓
22
```



---

# 7. What Is a Setter?

A **Setter** is used to modify a private field.

Example:

```java
private String name;

public void setName(String name) {
    this.name = name;
}
```

Usage:

```java
Student s = new Student();

s.setName("Om");
```

Now:

```text
name = "Om"
```



---

# 8. Setter Syntax

General structure:

```java
public void setFieldName(dataType value) {
    this.fieldName = value;
}
```

Example:

```java
private int age;

public void setAge(int age) {
    this.age = age;
}
```

Usage:

```java
s.setAge(22);
```



---

# 9. Why Do We Use `this`?

Look at:

```java
private int age;

public void setAge(int age) {
    this.age = age;
}
```

There are **two `age`s**:

```text
this.age
   ↑
instance variable

age
 ↑
parameter
```

Therefore:

```java
this.age = age;
```

means:

```text
current object's age = parameter age
```



---

# 10. Understand `this` With an Object

Suppose:

```java
Student s = new Student();

s.setAge(22);
```

Inside:

```java
public void setAge(int age) {
    this.age = age;
}
```

Java understands:

```text
this.age → s object's age

age → 22
```

Therefore:

```text
s.age = 22
```



---

# 11. Complete Example

```java
class Student {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
```

Usage:

```java
public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();

        s1.setName("Om");
        s1.setAge(22);

        System.out.println(s1.getName());
        System.out.println(s1.getAge());
    }
}
```

Output:

```text
Om
22
```



---

# 12. Before vs After

### Without Encapsulation

```java
Student s1 = new Student();

s1.name = "Om";
s1.age = 22;
```

Direct access to fields.

### With Encapsulation

```java
Student s1 = new Student();

s1.setName("Om");
s1.setAge(22);
```

Reading:

```java
System.out.println(s1.getName());
System.out.println(s1.getAge());
```

Flow:

```text
Outside
   ↓
Getter / Setter
   ↓
private fields
```



---

# 13. Getter vs Setter

| Getter                         | Setter                    |
| ------------------------------ | ------------------------- |
| Reads data                     | Changes data              |
| Usually starts with `get`      | Usually starts with `set` |
| Returns a value                | Usually returns `void`    |
| Normally does not modify state | Modifies state            |



Example Getter:

```java
public double getBalance() {
    return balance;
}
```

Example Setter:

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```



---

# 14. The Real Power — Validation

This is where Encapsulation becomes useful.

Without Encapsulation:

```java
student.age = -10;
```

Anyone can directly modify the data.

With Encapsulation:

```java
public void setAge(int age) {

    if (age > 0) {
        this.age = age;
    }
}
```

Now the class controls what data can enter the object.

---

# 15. Complete Flow to Remember

```text
              Student Object
           +-------------------+
           |                   |
           | private name      |
           | private age       |
           |                   |
           +-------------------+
                 ↑       ↑
                 |       |
              Getter   Setter
                 |       |
                Read   Modify
```



---

# 16. Easy Memory Trick

Remember:

```text
private
   ↓
Hide Data
   ↓
Getter → READ
Setter → CHANGE
   ↓
Validation
   ↓
Controlled Object
```



---

# Interview Questions

### Q1. Why do we make fields private?

To prevent direct access to the object's internal data.

### Q2. What is a Getter?

A method used to read a private field.

### Q3. What is a Setter?

A method used to modify a private field.

### Q4. Why use a Setter instead of direct access?

Because the Setter gives the class control over how data is modified and can validate the value.

### Q5. Why use `this.age = age`?

`this.age` refers to the current object's instance variable, while `age` refers to the method parameter.

---

# Practice Before Part 3

Create this yourself **without copying the solution**:

```java
class Student {

    private int rollNumber;
    private String name;
    private int age;
    private String course;
}
```

Create:

```text
getRollNumber()
setRollNumber()

getName()
setName()

getAge()
setAge()

getCourse()
setCourse()
```

For `age`, add:

```java
if (age >= 0)
```

inside `setAge()`.

---

# Success Checklist

* [ ] I understand `private`.
* [ ] I know why direct access fails.
* [ ] I can create a Getter.
* [ ] I can create a Setter.
* [ ] I understand `this`.
* [ ] I can read private data using a Getter.
* [ ] I can modify private data using a Setter.
* [ ] I can add validation inside a Setter.

---# C_Encapsulation — Part 3: Practice Problems

Now we move from **understanding Getter/Setter → actually coding Encapsulation**.

Part 3 is **coding practice**. Your actual Java solutions remain inside `A00_Code`, while the corresponding problem + solution files remain inside `A00_Problems`.

The same 10 projects are reused:

```text
P1 Student
P2 Bank
P3 Library
P4 Hospital
P5 Employee
P6 Amazon
P7 College
P8 Movie Booking
P9 Car Rental
P10 Inventory
```

---

# Practice Rule

For every problem:

```text
private fields
      ↓
Getter
      ↓
Setter
      ↓
Validation where required
      ↓
Controlled access
```

Do not directly access private fields from `Main`.

---

# P1 — Student Encapsulation

## Objective

Convert the existing `Student` class into an encapsulated class.

### Fields

```java
private int rollNumber;
private String name;
private int age;
private String course;
```

### Tasks

* Make all fields `private`.
* Create Getter and Setter for every field.
* Use `this` inside every Setter.
* Create a Student object.
* Set values using Setters.
* Read values using Getters.

### Validation

Inside `setAge()`:

```text
age >= 0
```

Invalid age should not update the object.

### Example Usage

```java
Student s1 = new Student();

s1.setRollNumber(101);
s1.setName("Om");
s1.setAge(22);
s1.setCourse("Computer Science");

System.out.println(s1.getRollNumber());
System.out.println(s1.getName());
System.out.println(s1.getAge());
System.out.println(s1.getCourse());
```

---

# P2 — Bank Account Encapsulation

## Objective

Protect the bank account balance.

### Fields

```java
private int accountNumber;
private String accountHolder;
private double balance;
```

### Tasks

Create:

```text
getAccountNumber()
setAccountNumber()

getAccountHolder()
setAccountHolder()

getBalance()
```

Do **not** create:

```text
setBalance()
```

Instead create:

```text
deposit()
withdraw()
```

### Rules

`deposit(amount)`:

```text
amount > 0
```

`withdraw(amount)`:

```text
amount > 0
AND
amount <= balance
```

Otherwise, balance should not change.

### Example

```java
BankAccount account = new BankAccount();

account.setAccountNumber(1001);
account.setAccountHolder("Om");

account.deposit(5000);
account.withdraw(1500);

System.out.println(account.getBalance());
```

Expected:

```text
3500.0
```

### Main Concept

```text
private balance
      ↓
deposit()
withdraw()
      ↓
validation
      ↓
controlled balance
```

---

# P3 — Library Book Encapsulation

## Objective

Protect book information using Encapsulation.

### Fields

```java
private String title;
private String author;
private int price;
private String category;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 5 Book objects.
* Set values using Setters.
* Print values using Getters.

### Validation

Price must be:

```text
price > 0
```

Invalid price should not update the object.

### Challenge

Why should the `price` field not be directly accessible?

---

# P4 — Hospital Patient Encapsulation

## Objective

Protect patient information.

### Fields

```java
private int patientId;
private String name;
private int age;
private String disease;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 4 Patient objects.
* Set values using Setters.
* Print details using Getters.

### Validation

Age must satisfy:

```text
age >= 0
```

### Challenge

Why should age validation be handled inside the Setter?

---

# P5 — Employee Encapsulation

## Objective

Protect employee information and validate salary.

### Fields

```java
private int employeeId;
private String name;
private String department;
private double salary;
```

### Tasks

Create:

```text
getEmployeeId()
setEmployeeId()

getName()
setName()

getDepartment()
setDepartment()

getSalary()
setSalary()
```

### Validation

Salary must be:

```text
salary > 0
```

Example:

```java
employee.setSalary(-5000);
```

The salary should not change.

### Challenge

Why is validation inside `setSalary()` useful?

---

# P6 — Amazon Product Encapsulation

## Objective

Protect product information.

### Fields

```java
private int productId;
private String productName;
private double price;
private String category;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 5 Product objects.
* Set values using Setters.
* Print values using Getters.

### Validation

Price must be:

```text
price > 0
```

### Challenge

Which field represents the most important value to protect with validation?

---

# P7 — College Encapsulation

## Objective

Protect college information.

### Fields

```java
private int collegeId;
private String collegeName;
private String city;
private int totalStudent;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 3 College objects.
* Set values using Setters.
* Print details using Getters.

### Validation

```text
collegeId > 0
totalStudent >= 0
```

### Challenge

Why should `totalStudent` not accept a negative value?

---

# P8 — Movie Booking Encapsulation

## Objective

Protect movie information.

### Fields

```java
private String movieName;
private String duration;
private String language;
private double rating;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 5 Movie objects.
* Set values using Setters.
* Print details using Getters.

### Validation

Rating must satisfy:

```text
0 <= rating <= 5
```

### Challenge

What happens if the Setter allows a rating of `8.5`?

---

# P9 — Car Rental Encapsulation

## Objective

Protect rental car information.

### Fields

```java
private String brand;
private String model;
private String color;
private double rentPerDay;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 4 Car objects.
* Set values using Setters.
* Print details using Getters.

### Validation

```text
rentPerDay > 0
```

### Challenge

Why should `rentPerDay` be validated before storing it?

---

# P10 — Inventory Encapsulation

## Objective

Protect inventory information.

### Fields

```java
private int itemId;
private String itemName;
private int quantity;
private double price;
```

### Tasks

* Make all fields `private`.
* Create Getters and Setters.
* Create 5 inventory objects.
* Set values using Setters.
* Print details using Getters.

### Validation

```text
quantity >= 0
price > 0
```

Example:

```java
item.setQuantity(-10);
```

The quantity should not change.

---

# Practice Order

Complete them in this order:

```text
P1 Student
   ↓
P2 Bank
   ↓
P3 Library
   ↓
P4 Hospital
   ↓
P5 Employee
   ↓
P6 Amazon
   ↓
P7 College
   ↓
P8 Movie Booking
   ↓
P9 Car Rental
   ↓
P10 Inventory
```

These correspond directly to your existing `A00_Problems/P1...P10` folders.

---

# Difficulty Progression

| Problem       | Main Focus                  |
| ------------- | --------------------------- |
| P1 Student    | `private` + Getter + Setter |
| P2 Bank       | Controlled modification     |
| P3 Library    | Getter/Setter + validation  |
| P4 Hospital   | Validation                  |
| P5 Employee   | Setter validation           |
| P6 Amazon     | Data protection             |
| P7 College    | Numeric validation          |
| P8 Movie      | Range validation            |
| P9 Car Rental | Controlled numeric data     |
| P10 Inventory | Multiple validations        |

---

# Your Rule for Every Problem

Before looking at any solution:

```text
1. Create the class
2. Make fields private
3. Create Getters
4. Create Setters
5. Add validation
6. Create objects
7. Set values using Setters
8. Read values using Getters
9. Test invalid values
```

---

# Part 3 Goal

By completing P1–P10, you should naturally understand:

```text
private field
      ↓
Getter → READ
      ↓
Setter → MODIFY
      ↓
Validation
      ↓
Controlled Object State
```

And for fields such as `balance`:

```text
private balance
      ↓
Getter → READ
      ↓
deposit()/withdraw()
      ↓
Controlled Modification
```

---

# Part 3 Checklist

* [x] Completed P1 Student.
* [x] Completed P2 Bank.
* [x] Completed P3 Library.
* [x] Completed P4 Hospital.
* [x] Completed P5 Employee.
* [x] Completed P6 Amazon.
* [x] Completed P7 College.
* [x] Completed P8 Movie Booking.
* [x] Completed P9 Car Rental.
* [x] Completed P10 Inventory.
* [x] Can use `private` fields.
* [x] Can create Getters.
* [x] Can create Setters.
* [x] Can use `this`.
* [x] Can add validation.
* [x] Understand controlled access.

---

# Next Part
# C_Encapsulation — Part 4: Advanced Encapsulation

Part 4 focuses on **designing encapsulated classes properly**.

The main idea is to understand that Encapsulation is not simply:

> **"Make fields private and generate Getters/Setters."**

It is about **controlling how object state is accessed and modified**.

---

# Learning Goals

After this part, you should understand:

* Why every field does not need a Setter.
* Why some state should only be changed through business methods.
* How validation protects object state.
* Read-only access.
* Controlled state transitions.
* Why business methods can be better than direct Setters.
* How Encapsulation protects the validity of an object.

---

# 1. Every Field Does Not Need a Setter

A common beginner approach is:

```java
private double balance;

public double getBalance() {
    return balance;
}

public void setBalance(double balance) {
    this.balance = balance;
}
```

But this gives outside code complete control over the value.

For example:

```java
account.setBalance(-50000);
```

The object can now be placed into an invalid state.

So the important question is:

> **Does every private field need a Setter?**

The answer is:

**No.**

Some fields should only change through controlled operations.

---

# 2. Setter vs Business Method

Compare:

```java
account.setBalance(50000);
```

with:

```java
account.deposit(50000);
```

A Setter says:

```text
"Set your internal value to this."
```

A business method says:

```text
"Perform this valid operation."
```

For a bank account:

```text
deposit()
withdraw()
```

are meaningful operations that can enforce rules.

---

# 3. Controlled Modification

A better design is:

```java
private double balance;

public void deposit(double amount) {

    if (amount > 0) {
        balance += amount;
    }
}
```

And:

```java
public void withdraw(double amount) {

    if (amount > 0 && amount <= balance) {
        balance -= amount;
    }
}
```

Now:

```text
Outside Code
      ↓
Business Method
      ↓
Validation
      ↓
Internal State
```

The object controls its own state.

---

# 4. Read-Only Access

A field can have a Getter without a Setter.

Example:

```java
class Product {

    private int productId;

    public int getProductId() {
        return productId;
    }
}
```

Outside code can read:

```java
product.getProductId();
```

but cannot directly modify the field.

This gives **read-only access from outside the class**.

---

# 5. Sensitive Data

Not every private field should even have a Getter.

For example:

```java
class User {

    private String password;
}
```

We should think carefully before exposing:

```java
getPassword()
```

Instead, the object may provide an operation such as:

```java
changePassword()
```

The important design question is:

> **What does the outside world actually need to access?**

---

# 6. Validation

Encapsulation allows the class to validate data before changing its state.

Example:

```java
private int age;

public void setAge(int age) {

    if (age >= 0 && age <= 100) {
        this.age = age;
    }
}
```

Now:

```java
student.setAge(22);
```

is valid.

But:

```java
student.setAge(-5);
student.setAge(150);
```

can be rejected.

The important idea is that validation is kept close to the state it protects.

---

# 7. Object State

An object's **state** means the current values stored in its fields.

Example:

```java
class BankAccount {

    private double balance;
}
```

If:

```text
balance = 50000
```

then `50000` is part of the object's current state.

Encapsulation protects that state from uncontrolled modification.

```text
Object State
     ↓
Controlled Access
     ↓
Valid Changes Only
```

---

# 8. State Transition

Business methods allow an object to change its state through meaningful operations.

Example:

```java
account.deposit(5000);
```

Before:

```text
balance = 10000
```

After:

```text
balance = 15000
```

The outside code did not directly write:

```java
balance = 15000;
```

Instead, it asked the object to perform a valid operation.

Similarly, a `Door` can expose:

```java
open();
close();
isOpen();
```

rather than:

```java
setOpen(true);
```

This is called **controlled state transition**.

---

# 9. Encapsulation + Constructors

Encapsulation can also work together with Constructors.

Example:

```java
class Employee {

    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;

        if (salary > 0) {
            this.salary = salary;
        }
    }
}
```

The object can therefore begin life with a valid state:

```text
Object Creation
      ↓
Constructor
      ↓
Validation
      ↓
Valid Initial State
```

This combines the concepts you already learned:

```text
Class & Object
      +
Constructors
      +
Encapsulation
```

---

# 10. `final` and Encapsulation

Some values should not change after initialization.

Example:

```java
private final int employeeId;
```

The value can be initialized during construction:

```java
Employee(int employeeId) {
    this.employeeId = employeeId;
}
```

After initialization, the field cannot be reassigned.

This is useful for values that represent fixed identity, such as:

```text
Employee ID
Account ID
Product ID
ISBN
```

---

# 11. Weak vs Better Design

### Weak

```java
private double balance;

public void setBalance(double balance) {
    this.balance = balance;
}
```

Outside code can do:

```java
account.setBalance(-50000);
```

### Better

```java
private double balance;

public void deposit(double amount) {

    if (amount > 0) {
        balance += amount;
    }
}

public void withdraw(double amount) {

    if (amount > 0 && amount <= balance) {
        balance -= amount;
    }
}
```

Now the object controls its own state.

---

# 12. The Main Design Question

When deciding whether to create a Getter or Setter, ask:

> **Who should be allowed to read or change this state, and under what conditions?**

Do not automatically create:

```text
Getter
+
Setter
```

for every field.

Think about the responsibility of the object.

---

# Encapsulation Progression

```text
Public Field
     ↓
private Field
     ↓
Getter / Setter
     ↓
Validation
     ↓
Controlled Modification
     ↓
Business Methods
     ↓
Protected Object State
```

---

# Quick Revision

```text
private
   ↓
Hide Data

Getter
   ↓
Read Data

Setter
   ↓
Modify Data

Validation
   ↓
Reject Invalid Data

Business Method
   ↓
Perform Valid Operation

Encapsulation
   ↓
Protect Object State
```

---

# Interview Questions

### Q1. Does every private field need a Setter?

**No.**

### Q2. Can a field have only a Getter?

**Yes.** This provides read-only access from outside.

### Q3. Why is `deposit()` better than `setBalance()`?

Because `deposit()` represents a meaningful operation and can enforce business rules.

### Q4. Why should sensitive fields not always have Getters?

Because some internal data should not be exposed outside the class.

### Q5. What is the real purpose of Encapsulation?

To **control access to internal state and protect the object from invalid or uncontrolled changes**.

---

# Part 4 Checklist

* [x] Understand that every field does not need a Setter.
* [x] Understand business methods.
* [x] Understand read-only access.
* [x] Understand sensitive data protection.
* [x] Understand validation.
* [x] Understand object state.
* [x] Understand controlled state transitions.
* [x] Understand Encapsulation + Constructors.
* [x] Understand `final` for fixed state.
* [x] Understand how to design controlled access.

---

# Next Part

➡️ **Part 5 — Interview + Design Mastery**


# C_Encapsulation — Part 5: Interview + Design Mastery

Part 5 is the **final Encapsulation revision layer**.

The focus is no longer on writing basic Getters and Setters. The goal is to decide **how an object should expose and protect its internal state**.

---

# Learning Goals

After this part, you should be able to:

* Explain Encapsulation in an interview.
* Explain Data Hiding.
* Decide when to use a Getter.
* Decide when to use a Setter.
* Understand why every field does not need a Setter.
* Understand read-only access.
* Understand controlled modification.
* Explain business methods.
* Explain validation.
* Identify poor Encapsulation design.
* Explain Encapsulation with Constructors.

---

# 1. What Is Encapsulation?

Encapsulation means:

```text
Bundle data + methods together
          ↓
Hide internal data
          ↓
Control access
          ↓
Protect object state
```

In Java, this is commonly achieved using:

```text
private fields
+
public methods
+
validation
```

---

# 2. What Is Data Hiding?

Data Hiding means preventing direct access to an object's internal fields.

Example:

```java
class Student {

    private int age;
}
```

Outside code cannot do:

```java
student.age = 22;
```

Instead, access is provided through methods.

---

# 3. Why Do We Use `private`?

`private` prevents direct access to a field from outside its class.

Example:

```java
private double balance;
```

This protects the object's internal state.

```text
Outside Code
     ↓
  private field
     ✕
Direct Access
```

---

# 4. Does Every Field Need a Getter?

**No.**

A field should have a Getter only when outside code needs to read that information.

For example:

```java
private double balance;

public double getBalance() {
    return balance;
}
```

Here, the balance is readable.

But sensitive internal data does not always need to be exposed.

---

# 5. Does Every Field Need a Setter?

**No.**

This is one of the most important Encapsulation concepts.

For example:

```java
private double balance;
```

A normal:

```java
setBalance()
```

may allow invalid changes.

Instead:

```java
deposit()
withdraw()
```

can control how the balance changes.

---

# 6. Setter vs Business Method

### Setter

```java
account.setBalance(50000);
```

This directly tells the object what its internal value should be.

### Business Method

```java
account.deposit(50000);
```

This tells the object to perform an operation.

The business method can enforce rules.

```text
deposit()
    ↓
validation
    ↓
balance update
```

---

# 7. Read-Only Property

A field can have:

```text
Getter ✅
Setter ❌
```

Example:

```java
class Product {

    private int productId;

    public int getProductId() {
        return productId;
    }
}
```

Outside code can read:

```java
product.getProductId();
```

but cannot change the ID through a Setter.

This creates **read-only access** from outside the class.

---

# 8. Sensitive Data

Some internal data should not be exposed.

Example:

```java
class User {

    private String password;
}
```

We should carefully consider whether this should exist:

```java
getPassword()
```

Instead, the object may provide an operation such as:

```java
changePassword()
```

The important question is:

> **What does the outside world actually need to access?**

---

# 9. Validation

Validation protects object state.

Example:

```java
private int age;

public void setAge(int age) {

    if (age >= 0 && age <= 100) {
        this.age = age;
    }
}
```

Valid:

```java
student.setAge(22);
```

Invalid:

```java
student.setAge(-5);
student.setAge(150);
```

The class controls what values can enter the object.

---

# 10. Object State

Object state means the current values stored in the object's fields.

Example:

```java
private double balance;
```

If:

```text
balance = 50000
```

then `50000` is part of the object's state.

Encapsulation protects this state.

```text
Internal State
      ↓
Controlled Access
      ↓
Valid Changes
```

---

# 11. Controlled State Transition

An object should often change its state through meaningful operations.

Example:

```java
account.deposit(5000);
```

rather than:

```java
account.setBalance(55000);
```

Another example:

```java
door.open();
door.close();
door.isOpen();
```

rather than:

```java
door.setOpen(true);
```

The object controls how its state changes.

---

# 12. Encapsulation + Constructors

Encapsulation can work together with Constructors.

Example:

```java
class Employee {

    private int id;
    private String name;
    private double salary;

    Employee(int id, String name, double salary) {

        this.id = id;
        this.name = name;

        if (salary > 0) {
            this.salary = salary;
        }
    }
}
```

Flow:

```text
Object Creation
      ↓
Constructor
      ↓
Validation
      ↓
Valid Initial State
```

---

# 13. `final` and Encapsulation

Some values should not change after initialization.

Example:

```java
private final int employeeId;
```

Initialize it in the constructor:

```java
Employee(int employeeId) {
    this.employeeId = employeeId;
}
```

After initialization, it cannot be reassigned.

Typical examples:

```text
Employee ID
Account ID
Product ID
ISBN
```

when they should remain fixed.

---

# 14. Weak Encapsulation Design

Example:

```java
class BankAccount {

    private double balance;

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
```

The problem is:

```java
account.setBalance(-50000);
```

The class has allowed an invalid state.

---

# 15. Better Encapsulation Design

```java
class BankAccount {

    private double balance;

    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
        }
    }
}
```

Now the object controls the balance.

---

# 16. How To Decide Getter vs Setter

Ask these questions:

### Getter

> Does outside code need to read this value?

### Setter

> Should outside code be allowed to freely change this value?

### Business Method

> Does this value need to change through a specific operation or business rule?

This is the important design thinking behind Encapsulation.

---

# 17. Common Beginner Mistake

Do not automatically write:

```java
getX()
setX()
```

for every field.

Instead think:

```text
Field
 ↓
Should it be visible?
 ↓
Should it be modifiable?
 ↓
If yes, under what rules?
```

---

# 18. Encapsulation vs Data Hiding

### Data Hiding

Focuses on:

```text
Prevent direct access
        ↓
private
```

### Encapsulation

Focuses on:

```text
Bundle data + behavior
        ↓
Control access
        ↓
Validate changes
        ↓
Protect state
```

Data Hiding is an important part of Encapsulation.

---

# 19. Interview Questions

### Q1. What is Encapsulation?

Encapsulation is the concept of bundling data and methods inside a class while controlling access to the object's internal state.

---

### Q2. Why are fields made private?

To prevent direct uncontrolled access to the object's internal data.

---

### Q3. What is a Getter?

A method used to read a private field.

---

### Q4. What is a Setter?

A method used to modify a private field.

---

### Q5. Does every field need a Setter?

**No.**

Some fields should only change through controlled methods.

---

### Q6. Can a field have only a Getter?

**Yes.**

This provides read-only access from outside.

---

### Q7. Why is `deposit()` better than `setBalance()`?

Because `deposit()` represents a meaningful operation and can enforce business rules.

---

### Q8. Why is validation important?

Validation prevents invalid values from entering the object's state.

---

### Q9. What is controlled access?

Providing access to internal data through methods that can enforce rules and restrictions.

---

### Q10. What is the real purpose of Encapsulation?

To:

```text
Hide internal state
      ↓
Control access
      ↓
Validate changes
      ↓
Protect object state
```

---

# Final Revision

```text
private
   ↓
Hide Data

Getter
   ↓
Read Data

Setter
   ↓
Modify Data

Validation
   ↓
Protect Data

Business Method
   ↓
Controlled Operation

Encapsulation
   ↓
Protected Object State
```

---

# Encapsulation Complete

Your complete learning progression is:

```text
Part 1
Encapsulation Fundamentals
        ↓
Part 2
private + Getter + Setter
        ↓
Part 3
10 Real-World Practice Problems
        ↓
Part 4
Advanced Encapsulation Concepts
        ↓
Part 5
Interview + Design Mastery
        ↓
ENCAPSULATION ✅
```

---

# Final Success Checklist

* [x] I can explain Encapsulation.
* [x] I understand Data Hiding.
* [x] I understand `private`.
* [x] I can create Getters.
* [x] I can create Setters.
* [x] I know when not to create a Setter.
* [x] I understand read-only access.
* [x] I understand validation.
* [x] I understand business methods.
* [x] I understand controlled state changes.
* [x] I understand Encapsulation + Constructors.
* [x] I understand `final` for fixed state.
* [x] I can explain Encapsulation in an interview.

---

# Next Topic

➡️ **D_Inheritance**
