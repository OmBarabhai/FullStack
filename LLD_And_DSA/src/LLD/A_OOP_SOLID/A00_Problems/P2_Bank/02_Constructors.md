# P2 - Bank Account System

## Objective

Upgrade the Bank Account System by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Requirements

Modify the existing `BankAccount` class.

## Fields

- accountNumber
- holderName
- balance
- accountType

---

# Tasks

## Task 1

Create a **Parameterized Constructor**.

---

## Task 2

Create **3 BankAccount objects** using the constructor.

---

## Task 3

Initialize all object data through the constructor.

---

## Task 4

Print all account details.

---

# Expected Learning

After completing this practice, you should understand:

- Parameterized Constructor
- Object Initialization
- `this` Keyword
- Constructor Execution
- Cleaner Object Creation

---

# Solution

## BankAccount.java

```java
public class BankAccount {

    int accountNumber;
    String holderName;
    double balance;
    String accountType;

    BankAccount(int accountNumber,
                String holderName,
                double balance,
                String accountType) {

        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
        this.accountType = accountType;
    }
}
```

---

## Main.java

```java
BankAccount b1 = new BankAccount(
        3212321,
        "Om",
        3212213.12,
        "Saving"
);

BankAccount b2 = new BankAccount(
        32123231,
        "Sahil",
        32132.12,
        "Current"
);

BankAccount b3 = new BankAccount(
        322113231,
        "Pavan",
        32133312.12,
        "Saving"
);
```

---

# Challenge

Explain the difference between:

```java
BankAccount b1 = new BankAccount();
```

and

```java
BankAccount b1 = new BankAccount(
        3212321,
        "Om",
        3212213.12,
        "Saving"
);
```

### Answer

`BankAccount()` calls the **Default Constructor** (if available).

`BankAccount(...)` calls the **Parameterized Constructor**, which initializes the object with the provided values.

The second approach is preferred because it:

- Initializes objects immediately.
- Reduces repetitive code.
- Produces cleaner and more maintainable code.

---

# Upgrade

### Before (Class & Object)

```java
BankAccount b1 = new BankAccount();

b1.accountNumber = 3212321;
b1.holderName = "Om";
b1.balance = 3212213.12;
b1.accountType = "Saving";
```

### After (Constructors)

```java
BankAccount b1 = new BankAccount(
        3212321,
        "Om",
        3212213.12,
        "Saving"
);
```

---

# Success Checklist

- [x] Created a Parameterized Constructor.
- [x] Created 3 BankAccount objects.
- [x] Initialized objects using the constructor.
- [x] Printed all account details.
- [x] Understood the `this` keyword.
- [x] Reduced repetitive code using constructors.

---

# Key Takeaways

- Constructors initialize objects.
- Constructors execute automatically when an object is created.
- The `this` keyword initializes instance variables.
- Parameterized constructors make object creation cleaner.
- Constructors improve code readability and maintainability.

---

# Next Practice

➡ **P3 - Library Management**