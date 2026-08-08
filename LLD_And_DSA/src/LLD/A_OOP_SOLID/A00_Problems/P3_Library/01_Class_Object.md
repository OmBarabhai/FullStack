# P3 - Library Management

## Objective

Practice creating Book objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Problem Statement

Create a `Book` class with the following fields:

- title
- author
- price
- category

Create **5 Book objects**, assign values manually, and print their details.

---

# Requirements

- Create a `Book` class.
- Create **5 Book objects**.
- Assign values manually.
- Print all book details.

---

# Solution

## Book.java

```java
public class Book {

    String title;
    String author;
    int price;
    String category;

}
```

---

## Main.java

```java
Book b1 = new Book();
b1.title = "Atomic Habits";
b1.author = "James Clear";
b1.price = 550;
b1.category = "Self Help";

Book b2 = new Book();
b2.title = "Clean Code";
b2.author = "Robert C. Martin";
b2.price = 699;
b2.category = "Programming";

Book b3 = new Book();
b3.title = "Effective Java";
b3.author = "Joshua Bloch";
b3.price = 850;
b3.category = "Programming";

Book b4 = new Book();
b4.title = "The Alchemist";
b4.author = "Paulo Coelho";
b4.price = 399;
b4.category = "Fiction";

Book b5 = new Book();
b5.title = "Rich Dad Poor Dad";
b5.author = "Robert Kiyosaki";
b5.price = 450;
b5.category = "Finance";
```

---

# Memory Representation

```text
                    Stack Memory

            b1 ───────────────┐

            b2 ────────────┐  │

            b3 ─────────┐  │  │

            b4 ──────┐  │  │  │

            b5 ───┐  │  │  │  │
                  │  │  │  │  │
                  ▼  ▼  ▼  ▼  ▼

                    Heap Memory

            Book Object 1

            title    = "Atomic Habits"
            author   = "James Clear"
            price    = 550
            category = "Self Help"

            -----------------------------

            Book Object 2

            title    = "Clean Code"
            author   = "Robert C. Martin"
            price    = 699
            category = "Programming"

            -----------------------------

            Book Object 3

            title    = "Effective Java"
            author   = "Joshua Bloch"
            price    = 850
            category = "Programming"

            -----------------------------

            Book Object 4

            title    = "The Alchemist"
            author   = "Paulo Coelho"
            price    = 399
            category = "Fiction"

            -----------------------------

            Book Object 5

            title    = "Rich Dad Poor Dad"
            author   = "Robert Kiyosaki"
            price    = 450
            category = "Finance"
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

### Can every object store different values? Explain why.

Yes.

Every time `new Book()` is executed, Java creates a new object in **Heap Memory**.

Each object has its own memory location and its own copy of the instance variables (`title`, `author`, `price`, and `category`).

Therefore, changing one Book object's data does **not** affect another Book object because every object is independent.

---

# Success Checklist

- [x] Created a Book class.
- [x] Added all required fields.
- [x] Created 5 Book objects.
- [x] Assigned different values manually.
- [x] Printed all book details.
- [x] Understood Stack & Heap Memory.
- [x] Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
Book b1 = new Book();

b1.title = "Atomic Habits";
b1.author = "James Clear";
b1.price = 550;
b1.category = "Self Help";
```

### After

```java
Book b1 = new Book(
    "Atomic Habits",
    "James Clear",
    550,
    "Self Help"
);
```