# P2 - Bank Account System

## Objective

Practice creating Bank Account objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Problem Statement

Create a `BankAccount` class with the following fields:

- accountNumber
- holderName
- balance
- accountType

Create **3 BankAccount objects**, assign values manually, and print their details.

---

# Requirements

- Create a `BankAccount` class.
- Create **3 BankAccount objects**.
- Assign values manually.
- Print all account details.

---

# Solution

## BankAccount.java

```java
public class BankAccount {

    int accountNumber;
    String holderName;
    double balance;
    String accountType;

}
```

---

## Main.java

```java
BankAccount b1 = new BankAccount();
b1.accountNumber = 3212321;
b1.holderName = "Om";
b1.balance = 3212213.12;
b1.accountType = "Saving";

BankAccount b2 = new BankAccount();
b2.accountNumber = 32123231;
b2.holderName = "Sahil";
b2.balance = 32132.12;
b2.accountType = "Current";

BankAccount b3 = new BankAccount();
b3.accountNumber = 322113231;
b3.holderName = "Pavan";
b3.balance = 32133312.12;
b3.accountType = "Saving";
```

---

# Memory Representation

```text
                    Stack Memory

            b1 ───────────────┐

            b2 ────────────┐  │

            b3 ────────┐   │  │
                        │   │  │
                        ▼   ▼  ▼

                    Heap Memory

          BankAccount Object 1

          accountNumber = 3212321
          holderName    = "Om"
          balance       = 3212213.12
          accountType   = "Saving"

          -----------------------------

          BankAccount Object 2

          accountNumber = 32123231
          holderName    = "Sahil"
          balance       = 32132.12
          accountType   = "Current"

          -----------------------------

          BankAccount Object 3

          accountNumber = 322113231
          holderName    = "Pavan"
          balance       = 32133312.12
          accountType   = "Saving"
```

---

# What You Learned

- A Class is a blueprint.
- An Object is an instance of a class.
- The `new` keyword creates an object.
- Objects are stored in Heap Memory.
- Reference variables are stored in Stack Memory.
- Every object stores its own independent data.
- Multiple objects can be created from the same class.

---

# Interview Question

### Where is each BankAccount object stored in memory?

Every time `new BankAccount()` is executed, Java creates a new object in **Heap Memory**.

The reference variables (`b1`, `b2`, `b3`) are stored in the **Stack Memory** inside the `main()` method.

Each reference variable points to a different `BankAccount` object, so every object stores its own independent data.

---

# Success Checklist

- [x] Created a BankAccount class.
- [x] Added all required fields.
- [x] Created 3 BankAccount objects.
- [x] Assigned different values manually.
- [x] Printed all account details.
- [x] Understood Stack & Heap Memory.
- [x] Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
BankAccount b1 = new BankAccount();

b1.accountNumber = 3212321;
b1.holderName = "Om";
b1.balance = 3212213.12;
b1.accountType = "Saving";
```

### After

```java
BankAccount b1 = new BankAccount(
    3212321,
    "Om",
    3212213.12,
    "Saving"
);
```