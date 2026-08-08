# P6 - Amazon Product

## Objective

Upgrade the Amazon Product project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation
- Constructors

---

# Requirements

Modify the existing `Product` class.

## Fields

- productId
- productName
- price
- category

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

- productId
- productName
- price
- category

---

## Task 3

Create **5 Product objects** using the Parameterized Constructor.

---

## Task 4

Create **1 Product object** using the Default Constructor.

---

## Task 5

Print all product details.

---

# Solution

## Product.java

```java
package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Product {

    int productId;
    String productName;
    double price;
    String category;

    // Default Constructor
    Product() {
        this(0, "Unknown", 0.0, "Unknown");
    }

    // Parameterized Constructor
    Product(int productId, String productName,
            double price, String category) {

        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Main {

    public static void main(String[] args) {

        // Default Constructor
        Product p0 = new Product();

        // Parameterized Constructor
        Product p1 = new Product(
                123,
                "iPhone",
                122232.22,
                "Mobile"
        );

        Product p2 = new Product(
                332,
                "Rolex",
                12223222.22,
                "Watch"
        );

        Product p3 = new Product(
                192,
                "MacBook",
                1222323.22,
                "Laptop"
        );

        Product p4 = new Product(
                77,
                "Jordan",
                1313343.22,
                "Shoes"
        );

        Product p5 = new Product(
                92,
                "Atomic Habits",
                1343.22,
                "Books"
        );

        System.out.println(
                p0.productId + " " +
                p0.productName + " " +
                p0.price + " " +
                p0.category
        );

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
    }
}
```

---

# Constructor Flow

### Default Constructor

```java
Product p0 = new Product();
```

Calls:

```java
Product() {
    this(0, "Unknown", 0.0, "Unknown");
}
```

The Default Constructor calls the Parameterized Constructor.

This is called **Constructor Chaining**.

---

### Parameterized Constructor

```java
Product p1 = new Product(
    123,
    "iPhone",
    122232.22,
    "Mobile"
);
```

Directly calls:

```java
Product(
    int productId,
    String productName,
    double price,
    String category
)
```

---

# Understanding `this`

```java
this.productId = productId;
```

Here:

```text
this.productId
      ↓
Instance variable of current Product object

productId
      ↓
Constructor parameter
```

Similarly:

```java
this.productName = productName;
this.price = price;
this.category = category;
```

---

# Challenge Answers

### Which constructor is called here?

```java
Product p0 = new Product();
```

**Default Constructor**

---

### Which constructor is called here?

```java
Product p1 = new Product(
    123,
    "iPhone",
    122232.22,
    "Mobile"
);
```

**Parameterized Constructor**

---

### Why is the constructor approach better?

Instead of:

```java
Product p1 = new Product();

p1.productId = 123;
p1.productName = "iPhone";
p1.price = 122232.22;
p1.category = "Mobile";
```

We can write:

```java
Product p1 = new Product(
    123,
    "iPhone",
    122232.22,
    "Mobile"
);
```

The object is initialized during creation.

---

# What You Learned

- Default Constructor
- Parameterized Constructor
- Constructor Chaining
- `this` Keyword
- Object Initialization
- Constructor Execution
- Cleaner Object Creation

---

# Success Checklist

- [x] Created `Product` class.
- [x] Added all required fields.
- [x] Created Default Constructor.
- [x] Created Parameterized Constructor.
- [x] Used Constructor Chaining.
- [x] Created 5 Product objects using Parameterized Constructor.
- [x] Created 1 Product object using Default Constructor.
- [x] Printed all 6 Product objects.
- [x] Used `this` correctly.
- [x] Understood constructor-based initialization.

---

# Next Practice

➡ **P7 - College Management**