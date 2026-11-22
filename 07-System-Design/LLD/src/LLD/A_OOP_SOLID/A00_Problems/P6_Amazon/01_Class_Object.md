# P6 - Amazon Product

## Objective

Practice creating objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object

---

# Problem Statement

Create a `Product` class with the following fields:

- productId
- productName
- price
- category

Create **5 Product objects**, assign values manually, and print their details.

---

# Requirements

- Create a `Product` class.
- Create **5 Product objects**.
- Assign values manually.
- Print all product details.

---

# Solution

## Product.java

```java
public class Product {

    int productId;
    String productName;
    double price;
    String category;

}
```

---

## Main.java

```java
Product p1 = new Product();
p1.productId = 123;
p1.productName = "iPhone";
p1.price = 122232.22;
p1.category = "Mobile";

Product p2 = new Product();
p2.productId = 332;
p2.productName = "Rolex";
p2.price = 12223222.22;
p2.category = "Watch";

Product p3 = new Product();
p3.productId = 192;
p3.productName = "MacBook";
p3.price = 1222323.22;
p3.category = "Laptop";

Product p4 = new Product();
p4.productId = 77;
p4.productName = "Jordan";
p4.price = 1313343.22;
p4.category = "Shoes";

Product p5 = new Product();
p5.productId = 92;
p5.productName = "Atomic Habits";
p5.price = 1343.22;
p5.category = "Books";

System.out.println(
    p1.productId + " " +
    p1.productName + " " +
    p1.price + " " +
    p1.category
);

System.out.println(
    p2.productId + " " +
    p2.productName + " " +
    p2.price + " " +
    p2.category
);

System.out.println(
    p3.productId + " " +
    p3.productName + " " +
    p3.price + " " +
    p3.category
);

System.out.println(
    p4.productId + " " +
    p4.productName + " " +
    p4.price + " " +
    p4.category
);

System.out.println(
    p5.productId + " " +
    p5.productName + " " +
    p5.price + " " +
    p5.category
);
```

---

# Memory Representation

```text
                Stack Memory

        p1 ──────────────┐
        p2 ───────────┐  │
        p3 ────────┐  │  │
        p4 ─────┐  │  │  │
        p5 ──┐  │  │  │  │
             │  │  │  │  │
             ▼  ▼  ▼  ▼  ▼

                Heap Memory

        Product Object 1

        productId   = 123
        productName = "iPhone"
        price       = 122232.22
        category    = "Mobile"

        ----------------------------

        Product Object 2

        productId   = 332
        productName = "Rolex"
        price       = 12223222.22
        category    = "Watch"

        ----------------------------

        Product Object 3

        productId   = 192
        productName = "MacBook"
        price       = 1222323.22
        category    = "Laptop"

        ----------------------------

        Product Object 4

        productId   = 77
        productName = "Jordan"
        price       = 1313343.22
        category    = "Shoes"

        ----------------------------

        Product Object 5

        productId   = 92
        productName = "Atomic Habits"
        price       = 1343.22
        category    = "Books"
```

---

# What You Learned

- A Class is a blueprint.
- An Object is an instance of a class.
- The `new` keyword creates an object.
- Objects are stored in Heap Memory.
- Reference variables are stored in Stack Memory.
- Every object stores its own independent data.
- Instance variables represent the object's state.

---

# Interview Question

### Which fields represent the object's state?

The object's state is represented by its **instance variables**.

For the `Product` class:

```text
productId
productName
price
category
```

Each Product object has its own values for these fields.

For example:

```java
p1.price = 122232.22;
p2.price = 12223222.22;
```

The two objects have different states.

---

# Success Checklist

- Created a Product class.
- Created 5 Product objects.
- Assigned values manually.
- Printed all product details.
- Understood Stack and Heap Memory.
- Understood object independence.
- Identified instance variables as object state.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
Product p1 = new Product();

p1.productId = 123;
p1.productName = "iPhone";
p1.price = 122232.22;
p1.category = "Mobile";
```

### After

```java
Product p1 = new Product(
    123,
    "iPhone",
    122232.22,
    "Mobile"
);
```