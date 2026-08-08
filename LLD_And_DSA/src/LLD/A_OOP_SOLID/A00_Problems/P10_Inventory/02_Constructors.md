# P10 - Inventory System — Constructors

## Objective

Upgrade the Inventory System by using **Constructors** to initialize inventory items instead of assigning values manually.

---

# Prerequisites

* Class
* Object
* Object Creation
* Constructors
* Parameterized Constructor
* `this` Keyword

---

# Requirements

Modify the existing `Items` class.

## Fields

* `itemId`
* `itemName`
* `quantity`
* `price`

---

# Tasks

## Task 1 — Default Constructor

Create a **Default Constructor**.

Example:

```java
Items() {
    this(0, "Unknown", 0, 0.0);
}
```

---

## Task 2 — Parameterized Constructor

Create a **Parameterized Constructor**.

The constructor should initialize:

* `itemId`
* `itemName`
* `quantity`
* `price`

Example:

```java
Items(int itemId, String itemName, int quantity, double price) {
    this.itemId = itemId;
    this.itemName = itemName;
    this.quantity = quantity;
    this.price = price;
}
```

---

## Task 3 — Create Inventory Objects

Create **5 inventory items** using the Parameterized Constructor.

Example:

```java
Items i1 = new Items(
    101,
    "Keyboard",
    50,
    999.99
);
```

Create four more objects with different values.

---

## Task 4 — Create Default Object

Create **1 inventory item** using the Default Constructor.

```java
Items i0 = new Items();
```

The object should receive:

```text
itemId   = 0
itemName = "Unknown"
quantity = 0
price    = 0.0
```

---

## Task 5 — Print Details

Print the details of all 6 objects.

---

# Challenge

Explain the difference between:

```java
Items i0 = new Items();
```

and:

```java
Items i1 = new Items(
    101,
    "Keyboard",
    50,
    999.99
);
```

Answer:

* Which constructor is called in each case?
* Why is the second approach preferred?
* What is the purpose of the `this` keyword?
* What happens when `new Items(...)` is executed?
* Why can the Default Constructor call the Parameterized Constructor?
* What is Constructor Chaining?

---

# Rules

❌ No Getters & Setters

❌ No Arrays

❌ No Collections

❌ No manual field assignment after object creation

Use only:

**Class + Object + Constructors**

---

# Upgrade

## Before — Class & Object

```java
Items i1 = new Items();

i1.itemId = 101;
i1.itemName = "Keyboard";
i1.quantity = 50;
i1.price = 999.99;
```

Here, the object is created first and its fields are assigned separately.

---

## After — Constructors

```java
Items i1 = new Items(
    101,
    "Keyboard",
    50,
    999.99
);
```

Here, the object is initialized during object creation.

---

# Constructor Flow

```text
Items i0 = new Items();

        ↓

Default Constructor

Items() {
    this(0, "Unknown", 0, 0.0);
}

        ↓

Parameterized Constructor

Items(int itemId,
      String itemName,
      int quantity,
      double price)

        ↓

Object initialized
```

---

# Understanding `this`

Consider:

```java
Items(int itemId, String itemName, int quantity, double price) {

    this.itemId = itemId;
    this.itemName = itemName;
    this.quantity = quantity;
    this.price = price;
}
```

The left side refers to the **current object's fields**.

The right side refers to the **constructor parameters**.

```text
this.itemId       = itemId
      ↑               ↑
      |               |
current object     parameter
field
```

Example:

```java
Items i1 = new Items(101, "Keyboard", 50, 999.99);
```

During constructor execution:

```text
this.itemId = 101
this.itemName = "Keyboard"
this.quantity = 50
this.price = 999.99
```

---

# Constructor Chaining

The Default Constructor:

```java
Items() {
    this(0, "Unknown", 0, 0.0);
}
```

calls the Parameterized Constructor.

This is called **Constructor Chaining**.

```text
new Items()
     ↓
Items()
     ↓
this(...)
     ↓
Parameterized Constructor
     ↓
Object initialized
```

### Why use it?

It avoids repeating initialization logic.

Instead of:

```java
Items() {
    itemId = 0;
    itemName = "Unknown";
    quantity = 0;
    price = 0.0;
}
```

we reuse:

```java
Items() {
    this(0, "Unknown", 0, 0.0);
}
```

---

# Memory Representation

```text
                 Stack Memory

        i0 ────────────────┐
        i1 ──────────────┐ │
        i2 ────────────┐ │ │
        i3 ──────────┐ │ │ │
        i4 ────────┐ │ │ │ │
        i5 ──────┐ │ │ │ │ │
                ↓ ↓ ↓ ↓ ↓ ↓

                 Heap Memory

        +-------------------------+
        | Items Object 0          |
        |-------------------------|
        | itemId   = 0            |
        | itemName = "Unknown"    |
        | quantity = 0             |
        | price    = 0.0           |
        +-------------------------+

        +-------------------------+
        | Items Object 1          |
        |-------------------------|
        | itemId   = 101          |
        | itemName = "Keyboard"   |
        | quantity = 50            |
        | price    = 999.99        |
        +-------------------------+

        +-------------------------+
        | Items Object 2          |
        |-------------------------|
        | itemId   = 102          |
        | itemName = "Mouse"      |
        | quantity = 80            |
        | price    = 599.99        |
        +-------------------------+

        ...and so on
```

Each `new Items(...)` creates a **separate object**.

---

# Interview Questions

## Q1. Which constructor is called here?

```java
Items i0 = new Items();
```

**Answer:** Default Constructor.

---

## Q2. Which constructor is called here?

```java
Items i1 = new Items(
    101,
    "Keyboard",
    50,
    999.99
);
```

**Answer:** Parameterized Constructor.

---

## Q3. Why is the parameterized constructor useful?

It allows us to initialize an object with its required values **at the time of object creation**.

---

## Q4. What does `this` refer to?

`this` refers to the **current object**.

---

## Q5. What happens when `new Items(...)` executes?

Conceptually:

```text
1. Memory for a new Items object is created.
2. Constructor is selected based on arguments.
3. Constructor initializes the object's fields.
4. A reference to the object is returned.
5. The reference is assigned to i1.
```

---

## Q6. Why can the Default Constructor call the Parameterized Constructor?

Because Java supports **constructor chaining** using:

```java
this(...)
```

The `this(...)` call must be the **first statement** inside the constructor.

---

# Success Checklist

* [ ] Created `Items` class.
* [ ] Added all required fields.
* [ ] Created Default Constructor.
* [ ] Created Parameterized Constructor.
* [ ] Created 5 inventory objects using Parameterized Constructor.
* [ ] Created 1 object using Default Constructor.
* [ ] Printed all inventory details.
* [ ] Used `this` correctly.
* [ ] Understood Constructor Chaining.
* [ ] Understood constructor-based initialization.
* [ ] Understood object creation flow.
* [ ] Understood Stack and Heap representation.

---

# Final Challenge

Without looking at your previous constructor solutions:

1. Create the `Items` class.
2. Add the four fields.
3. Create a Default Constructor.
4. Create a Parameterized Constructor.
5. Use `this` correctly.
6. Create 5 objects using the Parameterized Constructor.
7. Create 1 object using the Default Constructor.
8. Print all details.
9. Explain Constructor Chaining.
10. Draw the Stack and Heap memory representation.

---

# Topic Completion

After completing P10:

**Class & Object → Constructors** ✅

You have now practiced **Class & Object and Constructors across 10 real-world problems**:

| #   | Problem        | Class & Object | Constructors |
| --- | -------------- | -------------- | ------------ |
| P1  | Student        | ✅              | ✅            |
| P2  | Bank Account   | ✅              | ✅            |
| P3  | Library        | ✅              | ✅            |
| P4  | Hospital       | ✅              | ✅            |
| P5  | Employee       | ✅              | ✅            |
| P6  | Amazon Product | ✅              | ✅            |
| P7  | College        | ✅              | ✅            |
| P8  | Movie Booking  | ✅              | ✅            |
| P9  | Car Rental     | ✅              | ✅            |
| P10 | Inventory      | ✅              | ✅            |

### Current Progress

```text
A — Class & Object       ✅
B — Constructors         ✅
```

---

# Next Topic

➡️ **C — Encapsulation**

Next, you will learn how to protect object data using:

* `private`
* Getters
* Setters
* Data Hiding
* Controlled Access
* Validation
* Encapsulation in real-world classes
