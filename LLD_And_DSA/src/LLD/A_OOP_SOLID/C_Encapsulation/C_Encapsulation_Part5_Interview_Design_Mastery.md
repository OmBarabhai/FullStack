# C_Encapsulation — Part 5: Interview + Design Mastery

Part 5 is the **final Encapsulation revision layer**.

The focus is no longer on writing basic Getters and Setters. The goal is to decide **how an object should expose and protect its internal state**.

---

# Learning Goals

After this part, you should be able to:

- Explain Encapsulation in an interview.
- Explain Data Hiding.
- Decide when to use a Getter.
- Decide when to use a Setter.
- Understand why every field does not need a Setter.
- Understand read-only access.
- Understand controlled modification.
- Explain business methods.
- Explain validation.
- Identify poor Encapsulation design.
- Explain Encapsulation with Constructors.

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

Example:

```java
private double balance;

public double getBalance() {
    return balance;
}
```

Sensitive internal data does not always need to be exposed.

---

# 5. Does Every Field Need a Setter?

**No.**

Some fields should only change through controlled operations.

Example:

```java
private double balance;
```

Instead of:

```java
setBalance()
```

use:

```java
deposit()
withdraw()
```

when those are the valid operations.

---

# 6. Setter vs Business Method

### Setter

```java
account.setBalance(50000);
```

A Setter directly changes an internal value.

### Business Method

```java
account.deposit(50000);
```

A business method asks the object to perform an operation and can enforce rules.

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

---

# 8. Sensitive Data

Some internal data should not be exposed.

Example:

```java
class User {

    private String password;
}
```

We should carefully consider whether to provide:

```java
getPassword()
```

Instead, the object may provide:

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

After initialization, the field cannot be reassigned.

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

Ask:

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

```text
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

```text
Prevent direct access
        ↓
private
```

### Encapsulation

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

### Q2. Why are fields made private?

To prevent direct uncontrolled access to the object's internal data.

### Q3. What is a Getter?

A method used to read a private field.

### Q4. What is a Setter?

A method used to modify a private field.

### Q5. Does every field need a Setter?

**No.**

Some fields should only change through controlled methods.

### Q6. Can a field have only a Getter?

**Yes.**

This provides read-only access from outside.

### Q7. Why is `deposit()` better than `setBalance()`?

Because `deposit()` represents a meaningful operation and can enforce business rules.

### Q8. Why is validation important?

Validation prevents invalid values from entering the object's state.

### Q9. What is controlled access?

Providing access to internal data through methods that can enforce rules and restrictions.

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

- [ ] I can explain Encapsulation.
- [ ] I understand Data Hiding.
- [ ] I understand `private`.
- [ ] I can create Getters.
- [ ] I can create Setters.
- [ ] I know when not to create a Setter.
- [ ] I understand read-only access.
- [ ] I understand validation.
- [ ] I understand business methods.
- [ ] I understand controlled state changes.
- [ ] I understand Encapsulation + Constructors.
- [ ] I understand `final` for fixed state.
- [ ] I can explain Encapsulation in an interview.

---

# Next Topic

➡️ **D_Inheritance**
