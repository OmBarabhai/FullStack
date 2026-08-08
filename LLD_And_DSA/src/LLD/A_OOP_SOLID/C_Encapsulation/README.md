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

---
# C_Encapsulation — Part 3: Practice Problems

Now we move from **understanding Getter/Setter → actually coding Encapsulation**.

Part 3 is **problem practice**, separate from the theory/notes. Your goal is to write the code yourself first.

---

# P1 — Student Encapsulation

## Objective

Convert the `Student` class into a properly encapsulated class.

### Fields

```java
private int rollNumber;
private String name;
private int age;
private String course;
```

### Tasks

1. Create all fields as `private`.
2. Create Getter and Setter for every field.
3. Use `this` inside every Setter.
4. Create one `Student` object.
5. Set values using Setters.
6. Print values using Getters.

### Validation

Inside:

```java
setAge()
```

allow the age only when:

```java
age >= 0
```

### Expected usage

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

**Don't copy the class implementation yet. Write it yourself.**

---

# P2 — Bank Account Encapsulation

## Objective

Protect the bank account's balance.

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

For `balance`, **do not create a normal Setter**.

Instead create:

```java
deposit()
withdraw()
```

### Rules

`deposit(amount)`:

```text
amount > 0
```

then add it to balance.

`withdraw(amount)`:

```text
amount > 0
AND
amount <= balance
```

then subtract it.

Otherwise, don't modify the balance.

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

This is the important jump from **simple Getter/Setter Encapsulation to real object protection**. The source material uses the same `BankAccount → balance → deposit/withdraw → validation` progression.

---

# P3 — Employee Encapsulation

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

Create Getter/Setter for:

```text
employeeId
name
department
```

For salary:

```text
getSalary()
setSalary()
```

### Validation

Salary must be:

```text
salary > 0
```

If invalid:

```java
employee.setSalary(-5000);
```

the salary should **not change**.

### Example

```java
Employee e1 = new Employee();

e1.setEmployeeId(101);
e1.setName("Om");
e1.setDepartment("Engineering");
e1.setSalary(50000);

System.out.println(e1.getEmployeeId());
System.out.println(e1.getName());
System.out.println(e1.getDepartment());
System.out.println(e1.getSalary());
```

---

# P4 — Product Encapsulation

## Objective

Protect product information.

### Fields

```java
private int productId;
private String productName;
private double price;
private int quantity;
```

### Tasks

Create Getter/Setter for all fields.

### Validation

#### Price

```text
price > 0
```

#### Quantity

```text
quantity >= 0
```

Invalid values should not modify the object.

Example:

```java
product.setPrice(-100);
product.setQuantity(-20);
```

should be rejected.

---

# P5 — Mobile Phone Encapsulation

## Objective

Protect mobile phone information.

### Fields

```java
private String brand;
private String model;
private double price;
private int batteryPercentage;
```

### Validation

Price:

```text
price > 0
```

Battery:

```text
0 <= batteryPercentage <= 100
```

Example:

```java
mobile.setBatteryPercentage(120);
```

must not update the battery.

---

# P6 — Movie Encapsulation

## Objective

Protect movie information.

### Fields

```java
private String movieName;
private String language;
private double rating;
private int duration;
```

### Validation

Rating:

```text
0 <= rating <= 5
```

Duration:

```text
duration > 0
```

Example:

```java
movie.setRating(6.5);
```

must be rejected.

---

# P7 — Car Encapsulation

### Fields

```java
private String brand;
private String model;
private double rentPerDay;
```

### Validation

```text
rentPerDay > 0
```

Create:

```text
getBrand()
setBrand()

getModel()
setModel()

getRentPerDay()
setRentPerDay()
```

---

# P8 — College Encapsulation

### Fields

```java
private int collegeId;
private String collegeName;
private String city;
private int totalStudents;
```

### Validation

```text
collegeId > 0
totalStudents >= 0
```

Create Getter/Setter for every field.

---

# P9 — Inventory Encapsulation

### Fields

```java
private int itemId;
private String itemName;
private int quantity;
private double price;
```

### Validation

```text
quantity >= 0
price > 0
```

Example:

```java
item.setQuantity(-10);
```

should not modify the quantity.

---

# P10 — ATM Encapsulation

This is the **most important practice problem** in Part 3.

### Fields

```java
private int pin;
private double balance;
```

### Methods

```text
getBalance()
setPin()

deposit()
withdraw()
changePin()
```

### Rules

#### Deposit

```text
amount > 0
```

#### Withdraw

```text
amount > 0
AND
amount <= balance
```

#### PIN

PIN must contain exactly 4 digits.

Do **not** create:

```java
setBalance()
```

The balance should only change through:

```java
deposit()
withdraw()
```

This reinforces the key idea that encapsulation isn't merely "make everything private and generate setters"; it is about **controlled access and validation**.

---

# Practice Order

Don't solve randomly.

```text
P1 Student
   ↓
P2 Bank Account
   ↓
P3 Employee
   ↓
P4 Product
   ↓
P5 Mobile
   ↓
P6 Movie
   ↓
P7 Car
   ↓
P8 College
   ↓
P9 Inventory
   ↓
P10 ATM
```

### Difficulty progression

| Problems | Focus                          |
| -------- | ------------------------------ |
| P1       | private + Getter + Setter      |
| P2       | Controlled modification        |
| P3       | Setter validation              |
| P4       | Multiple validations           |
| P5       | Range validation               |
| P6       | Range + validation             |
| P7       | Basic real-world encapsulation |
| P8       | Multiple fields                |
| P9       | Inventory validation           |
| P10      | **Real encapsulation design**  |

---

## Your rule for Part 3

For every problem:

**1. Write `Class`**

**2. Make fields `private`**

**3. Write Getter**

**4. Write Setter**

**5. Add validation where specified**

**6. Create object**

**7. Use Setter**

**8. Use Getter**

**9. Test invalid input**

Don't look at a solution until you have attempted the problem yourself.

### Part 3 Goal

By P10, you should be able to look at:

```java
private double balance;
```

and immediately think:

```text
❌ Don't expose balance directly

        ↓

Getter → read balance

        ↓

deposit/withdraw → controlled modification

        ↓

validation → protect object state
```


# C_Encapsulation — Part 4: Advanced / Interview Practice

Part 4 is **separate from your A00_Problems code**.

You already have:

```text
Part 1 → Encapsulation Fundamentals
Part 2 → Getter / Setter / private
Part 3 → Basic Encapsulation Practice Problems
Part 4 → Advanced Encapsulation + LLD Thinking
```

The goal now is to understand **when NOT to provide a Setter** and how to protect an object's state.

---

# Part 4 — Advanced Encapsulation

## P1 — Bank Account

### Goal

Design a properly encapsulated `BankAccount`.

### Fields

```java
private int accountNumber;
private String accountHolder;
private double balance;
```

### Rules

❌ No `setBalance()`

Balance can change only through:

```java
deposit()
withdraw()
```

### Methods

```text
getAccountNumber()
getAccountHolder()
getBalance()

setAccountNumber()
setAccountHolder()

deposit()
withdraw()
```

### Validation

```text
deposit > 0
withdraw > 0
withdraw <= balance
```

### Interview Question

**Why should `balance` not have a public Setter?**

---

# P2 — ATM

Create:

```java
class ATM
```

### Fields

```java
private double balance;
private int pin;
```

### Methods

```text
checkBalance()
deposit()
withdraw()
changePin()
```

### Rules

```text
PIN = exactly 4 digits

deposit > 0

withdraw > 0
withdraw <= balance
```

❌ No:

```java
setBalance()
```

### Interview Question

Why is:

```java
withdraw(500)
```

better than:

```java
setBalance(4500)
```

?

---

# P3 — Employee Salary

Create:

```java
class Employee
```

### Fields

```java
private int id;
private String name;
private double salary;
```

### Rules

Salary must always be:

```text
salary > 0
```

Create:

```text
getSalary()
setSalary()
increaseSalary()
```

Example:

```java
employee.increaseSalary(5000);
```

### Interview Question

Why can business methods sometimes be better than direct setters?

---

# P4 — Product Stock

Create:

```java
class Product
```

### Fields

```java
private int productId;
private String productName;
private double price;
private int stock;
```

### Methods

```text
getPrice()
setPrice()

getStock()

addStock()
removeStock()
```

### Rules

```text
price > 0
stock >= 0
removeStock <= stock
```

❌ No:

```java
setStock()
```

The stock should be controlled through:

```java
addStock()
removeStock()
```

---

# P5 — User Account

Create:

```java
class User
```

### Fields

```java
private String username;
private String password;
private String email;
```

### Rules

Password should not be directly exposed.

❌ Don't create:

```java
getPassword()
```

Create:

```text
changePassword()
```

### Challenge

Why is this better?

```java
user.changePassword("old123", "new123");
```

than:

```java
user.setPassword("new123");
```

---

# P6 — Shopping Cart

Create:

```java
class ShoppingCart
```

### Fields

```java
private double totalAmount;
private int itemCount;
```

### Methods

```text
getTotalAmount()
getItemCount()

addItem(price)
removeItem(price)
```

### Rules

```text
price > 0
itemCount cannot become negative
totalAmount cannot become negative
```

❌ No:

```java
setTotalAmount()
setItemCount()
```

---

# P7 — Temperature

Create:

```java
class Temperature
```

### Field

```java
private double celsius;
```

### Methods

```text
getCelsius()
setCelsius()

getFahrenheit()
```

Formula:

```text
F = (C × 9/5) + 32
```

### Challenge

Should `fahrenheit` be stored as another field?

Think about **state vs calculated value**.

---

# P8 — Library Book

Create:

```java
class LibraryBook
```

### Fields

```java
private String title;
private String author;
private boolean available;
```

### Methods

```text
getTitle()
getAuthor()
isAvailable()

borrowBook()
returnBook()
```

### Rules

If:

```text
available = false
```

then another person cannot borrow the book.

❌ Don't provide:

```java
setAvailable()
```

Instead:

```text
borrowBook()
returnBook()
```

control the state.

---

# P9 — Vehicle

Create:

```java
class Vehicle
```

### Fields

```java
private String brand;
private double speed;
```

### Methods

```text
getBrand()
getSpeed()

accelerate(amount)
brake(amount)
```

### Rules

```text
speed >= 0
```

Speed should never become negative.

❌ No:

```java
setSpeed()
```

---

# P10 — Digital Wallet ⭐

This is your final Part 4 problem.

Create:

```java
class Wallet
```

### Fields

```java
private String owner;
private double balance;
```

### Methods

```text
getOwner()
getBalance()

addMoney()
spendMoney()
```

### Rules

```text
addMoney > 0

spendMoney > 0

spendMoney <= balance
```

❌ No:

```java
setBalance()
```

### Example

```java
Wallet wallet = new Wallet();

wallet.addMoney(5000);
wallet.spendMoney(1200);

System.out.println(wallet.getBalance());
```

Expected:

```text
3800.0
```

---

# 🔥 Part 4 Core Concept

The most important progression is:

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
```

For example:

### Weak design

```java
private double balance;

public void setBalance(double balance) {
    this.balance = balance;
}
```

Anyone can do:

```java
account.setBalance(-50000);
```

---

### Better design

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

Now the object **controls its own state**.

---

# Part 4 Interview Checklist

You should be able to answer these without notes:

### 1. Why are fields private?

To prevent direct uncontrolled access to object state.

### 2. Is Encapsulation just Getter + Setter?

**No.**

Encapsulation is about **controlled access to internal state**.

### 3. Should every field have a Setter?

**No.**

Some state should only change through controlled methods.

### 4. Why no `setBalance()` in BankAccount?

Because it allows invalid or unauthorized state changes.

### 5. What is better?

```java
withdraw(500);
```

instead of:

```java
setBalance(balance - 500);
```

Because `withdraw()` can enforce business rules.

### 6. What is the main idea?

```text
Hide Data
    ↓
Control Access
    ↓
Validate Changes
    ↓
Protect Object State
```

---

## Part 4 Completion Target

After P1–P10, you should be comfortable designing:

```text
private fields
     +
controlled getters
     +
validated setters
     +
business methods
     +
protected object state
```

# C_Encapsulation — Part 5: Interview + Design Mastery

Part 5 is the **final Encapsulation practice layer**.
The focus is no longer on writing basic getters/setters. The goal is to decide **how much access an object should expose**.

---

# P1 — Getter or No Getter?

Consider:

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }
}
```

### Questions

1. Why is `balance` private?
2. Why is `getBalance()` public?
3. Should `setBalance()` exist?
4. What could go wrong if `setBalance()` is public?

---

# P2 — Setter or Business Method?

Compare:

### Approach A

```java
account.setBalance(account.getBalance() + 500);
```

### Approach B

```java
account.deposit(500);
```

### Questions

* Which design better represents a Bank Account?
* Why?
* Where should validation happen?
* Who should control the balance?

---

# P3 — Password Protection

Design:

```java
class User {

    private String username;
    private String password;
}
```

### Decide which methods should exist:

```text
getUsername()
setUsername()

getPassword()
setPassword()

changePassword()
```

### Challenge

You must decide:

* Should password have a Getter?
* Should password have a Setter?
* How should password be changed?

---

# P4 — Immutable Field

Create:

```java
class Employee {

    private final int employeeId;
    private String name;
    private double salary;
}
```

### Questions

* Why should `employeeId` not have a Setter?
* When should it be initialized?
* Can it be changed after initialization?
* What does `final` add to the design?

---

# P5 — Read-Only Property

Create:

```java
class Product {

    private int productId;
    private String productName;
    private double price;
}
```

Make `productId` **read-only** after object creation.

You should be able to do:

```java
System.out.println(product.getProductId());
```

but not:

```java
product.setProductId(500);
```

### Goal

Understand:

```text
private + Getter
```

without a Setter.

---

# P6 — Write-Only Property

Consider a password:

```java
private String password;
```

Design the class so that:

```java
user.changePassword("old", "new");
```

is possible, but:

```java
user.getPassword();
```

is not available.

### Question

Why can this be safer than exposing the password?

---

# P7 — Controlled State Transition

Create:

```java
class Door {

    private boolean open;
}
```

Do **not** create:

```java
setOpen()
```

Instead create:

```java
open()
close()
isOpen()
```

Expected behavior:

```text
open()  → open = true
close() → open = false
isOpen() → returns current state
```

### Core Lesson

The outside world tells the object **what action to perform**, rather than directly changing its internal state.

---

# P8 — Encapsulation With Validation

Create:

```java
class Student {

    private int age;
}
```

Implement:

```java
setAge()
getAge()
```

Rules:

```text
0 <= age <= 100
```

Test:

```java
student.setAge(22);    // valid
student.setAge(-5);    // invalid
student.setAge(150);   // invalid
```

### Challenge

Where should the validation exist?

```text
Main?
Constructor?
Setter?
```

Explain your choice.

---

# P9 — Identify the Encapsulation Violation

Find the problem:

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
```

Then redesign it.

Expected direction:

```java
deposit()
withdraw()
```

instead of unrestricted:

```java
setBalance()
```

---

# P10 ⭐ — Mini LLD Encapsulation Challenge

Design a:

## `LibraryBook`

### Private fields

```java
private String isbn;
private String title;
private String author;
private boolean available;
```

### Requirements

A book should:

* expose its ISBN
* expose title
* expose author
* tell whether it is available
* allow borrowing
* allow returning
* prevent borrowing when already borrowed
* prevent returning when it wasn't borrowed

### Suggested API

```text
getIsbn()
getTitle()
getAuthor()
isAvailable()

borrowBook()
returnBook()
```

### Forbidden

```text
setAvailable()
setIsbn()
```

---

# 🔥 Part 5 — Decision Practice

For each field, decide:

| Field             | Getter? | Setter? | Business Method? |
| ----------------- | ------- | ------- | ---------------- |
| Bank balance      | ?       | ?       | ?                |
| User password     | ?       | ?       | ?                |
| Employee ID       | ?       | ?       | ?                |
| Product price     | ?       | ?       | ?                |
| Product stock     | ?       | ?       | ?                |
| Door state        | ?       | ?       | ?                |
| Book availability | ?       | ?       | ?                |

Don't immediately look for a memorized rule.

Think:

> **"Who should be allowed to change this state, and under what conditions?"**

---

# Interview Master Questions

You should now be able to answer these:

### 1. What is Encapsulation?

Bundling data and the methods that operate on that data while controlling access to the internal state.

### 2. Why use `private`?

To prevent direct uncontrolled access to internal state.

### 3. Does Encapsulation mean every field needs Getter and Setter?

**No.**

### 4. Why shouldn't every field have a Setter?

Because unrestricted setters can allow invalid or inappropriate state changes.

### 5. What is better than `setBalance()`?

```java
deposit()
withdraw()
```

because those methods represent valid operations and can enforce rules.

### 6. Can a field have only a Getter?

**Yes.**

That creates a read-only interface from outside the class.

### 7. Can a field have no Getter?

**Yes.**

Sensitive internal data may not need to be exposed.

### 8. What is the real purpose of Encapsulation?

```text
Hide internal state
       ↓
Control access
       ↓
Validate changes
       ↓
Protect object
       ↓
Maintain valid state
```

---

# 🏆 Encapsulation Complete

Your learning progression is now:

```text
Part 1
Fundamentals
    ↓
Part 2
private + Getter + Setter
    ↓
Part 3
Basic Coding Problems
    ↓
Part 4
Advanced Encapsulation
    ↓
Part 5
Interview + Design Decisions
```
