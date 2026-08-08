# P3 - Library Management

## Objective

Upgrade the Library Management project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Requirements

Modify the existing `Book` class.

## Fields

- title
- author
- price
- category

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

---

## Task 3

Use **Constructor Chaining** by calling the Parameterized Constructor from the Default Constructor.

---

## Task 4

Create **5 Book objects** using the Parameterized Constructor.

---

## Task 5

Create **1 Book object** using the Default Constructor.

---

## Task 6

Print all book details.

---

# Expected Learning

After completing this practice, you should understand:

- Default Constructor
- Parameterized Constructor
- Constructor Chaining
- Object Initialization
- Constructor Execution
- `this` Keyword
- Cleaner Object Creation

---

# Solution

## Book.java

```java
package LLD.A_OOP_SOLID.A00_Problems.P3_Library;

public class Book {

    String title;
    String author;
    int price;
    String category;

    // Default Constructor
    Book() {
        this("Unknown", "Unknown", 0, "Unknown");
    }

    // Parameterized Constructor
    Book(String title, String author, int price, String category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }
}
```

---

## Main.java

```java
Book b1 = new Book("Atomic Habits", "James Clear", 550, "Self Help");
Book b2 = new Book("Clean Code", "Robert C. Martin", 699, "Programming");
Book b3 = new Book("Effective Java", "Joshua Bloch", 850, "Programming");
Book b4 = new Book("The Alchemist", "Paulo Coelho", 399, "Fiction");
Book b5 = new Book("Rich Dad Poor Dad", "Robert Kiyosaki", 450, "Finance");

Book b6 = new Book();
```

---

# Challenge

Explain the difference between:

```java
Book b1 = new Book();
```

and

```java
Book b2 = new Book(
    "Atomic Habits",
    "James Clear",
    550,
    "Self Help"
);
```

Answer the following:

- Which constructor is called in each case?
- What is Constructor Chaining?
- Why is the second approach preferred?
- What role does the `this` keyword play?

---

# Answer

### `Book b1 = new Book();`

- Calls the **Default Constructor**.
- Inside the Default Constructor,

```java
this("Unknown", "Unknown", 0, "Unknown");
```

calls the **Parameterized Constructor**.

This process is called **Constructor Chaining**.

---

### `Book b2 = new Book(...);`

- Directly calls the **Parameterized Constructor**.
- Initializes the object with the provided values.

---

### Why is the second approach preferred?

- Initializes objects immediately.
- Eliminates repetitive assignments.
- Produces cleaner and more readable code.
- Reduces the chance of forgetting to initialize fields.

---

### What is the role of `this`?

- `this(...)` calls another constructor in the same class.
- `this.title`, `this.author`, etc. refer to the current object's instance variables.

---

# Upgrade

## Before (Class & Object)

```java
Book b1 = new Book();

b1.title = "Atomic Habits";
b1.author = "James Clear";
b1.price = 550;
b1.category = "Self Help";
```

---

## After (Constructors)

```java
Book b1 = new Book(
    "Atomic Habits",
    "James Clear",
    550,
    "Self Help"
);
```

---

# Success Checklist

- [x] Created a Default Constructor.
- [x] Created a Parameterized Constructor.
- [x] Implemented Constructor Chaining.
- [x] Created 5 Book objects using the Parameterized Constructor.
- [x] Created 1 Book object using the Default Constructor.
- [x] Initialized objects using constructors.
- [x] Printed all book details.
- [x] Understood the `this` keyword.
- [x] Reduced repetitive code using constructors.

---

# Key Takeaways

- Constructors initialize objects automatically.
- The Default Constructor can call another constructor using `this(...)`.
- Constructor Chaining avoids duplicate initialization code.
- `this(...)` calls another constructor in the same class.
- `this.variable` refers to the current object's instance variable.
- Parameterized Constructors make object creation cleaner and more maintainable.

---

# Next Practice

➡ **P4 - Hospital Management**