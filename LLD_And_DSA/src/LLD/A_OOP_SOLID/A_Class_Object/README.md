# Class & Object

## Part 1 – Introduction

> **"Class and Object are the foundation of Object-Oriented Programming. Everything in Java starts with creating classes and objects."**

---

# Learning Goals

After this part, you will be able to:

- Understand why OOP is used.
- Understand what a Class is.
- Understand what an Object is.
- Differentiate between Class and Object.

---

# Why OOP?

Without OOP:

- Too many variables
- Too many functions
- Duplicate code
- Difficult maintenance

OOP solves these problems by organizing code into **Classes** and **Objects**.

---

# What is a Class?

A **Class** is a blueprint or template used to create objects.

It defines:

- State (Fields)
- Behavior (Methods)

Example:

```java
class Student {

    String name;
    int age;

}
```

`Student` is a class.

---

# What is an Object?

An **Object** is an instance of a class.

Objects store actual values.

Example:

```java
Student s1 = new Student();
```

Here,

- `Student` → Class
- `s1` → Reference Variable
- `new Student()` → Object

---

# Class vs Object

| Class | Object |
|--------|--------|
| Blueprint | Instance |
| Defines Structure | Stores Data |
| Created Once | Can Create Many |

---

# Real-World Example

```text
Blueprint
    ↓
 House

Class
    ↓
Student

Objects
    ↓
Om
Rahul
Amit
```

---

# Key Points

✔ Class is a blueprint.

✔ Object is an instance.

✔ One class can create multiple objects.

✔ Objects store actual data.

---

# Quick Revision

- Class → Blueprint
- Object → Instance
- One Class → Many Objects
- Object stores data

---
# Class & Object

## Part 2 – Object Creation & Memory

> **"A class defines the blueprint, and an object brings that blueprint to life by occupying memory."**

---

# Learning Goals

After this part, you will be able to:

- Create objects.
- Understand the `new` keyword.
- Understand reference variables.
- Differentiate Stack and Heap memory.
- Explain how an object is created in Java.

---

# Creating an Object

Syntax:

```java
ClassName referenceVariable = new ClassName();
```

Example:

```java
Student s1 = new Student();
```

Here,

- `Student` → Class
- `s1` → Reference Variable
- `new Student()` → Creates a new object

---

# The `new` Keyword

The `new` keyword is used to create an object.

When Java executes:

```java
Student s1 = new Student();
```

It:

- Creates a new object.
- Allocates memory in the Heap.
- Returns the object's memory address.
- Stores the address in `s1`.

---

# Reference Variable

A reference variable does **not** store the object.

It stores the **address** of the object.

Example:

```java
Student s1 = new Student();
```

Here,

`s1` points to the Student object.

---

# Memory Representation

```text
            Stack Memory

        s1
         │
         │
         ▼

            Heap Memory

     +--------------------+
     | Student Object     |
     |--------------------|
     | name = null        |
     | age  = 0           |
     +--------------------+
```

---

# Object Creation Flow

```text
Student s1 = new Student();

        │
        ▼

Create Object

        ▼

Allocate Heap Memory

        ▼

Assign Default Values

        ▼

Return Object Reference

        ▼

Store Reference in s1
```

---

# Default Values

When an object is created, Java automatically initializes instance variables.

| Data Type | Default Value |
|-----------|---------------|
| int | 0 |
| double | 0.0 |
| boolean | false |
| char | '\u0000' |
| String | null |
| Object | null |

---

# Stack vs Heap

| Stack Memory | Heap Memory |
|--------------|-------------|
| Stores reference variables | Stores objects |
| Automatically managed | Used for dynamic object allocation |
| Faster | Larger memory area |

---

# Key Points

✔ `new` creates an object.

✔ Objects are stored in Heap Memory.

✔ Reference variables are stored in Stack Memory.

✔ A reference variable points to an object.

✔ Every object occupies its own memory location.

---

# Quick Revision

- `new` → Creates an object.
- Reference Variable → Stores object address.
- Stack → Stores references.
- Heap → Stores objects.
- One object = One separate memory location.

---
# Class & Object

## Part 3 – Real-World Modeling & Best Practices

> **"A class models a real-world entity, and objects represent individual instances of that entity."**

---

# Learning Goals

After this part, you will be able to:

- Design classes from real-world problems.
- Create multiple objects from a single class.
- Understand object independence.
- Follow good coding practices.
- Avoid common beginner mistakes.

---

# Real-World Modeling

Everything around us can be represented using classes and objects.

| Real World | Class | Object |
|------------|-------|--------|
| Student | Student | Om, Rahul |
| Bank Account | BankAccount | Account1, Account2 |
| Car | Car | BMW, Audi |
| Book | Book | Atomic Habits, Clean Code |
| Movie | Movie | Avengers, Inception |
| Employee | Employee | Emp101, Emp102 |

A **Class** defines the structure.

An **Object** stores actual values.

---

# One Class → Multiple Objects

Example:

```java
Student s1 = new Student();
Student s2 = new Student();
Student s3 = new Student();
```

Every object has its own memory.

```text
Student Class
      │
      ▼

 ┌─────────────┐
 │ Student     │
 └─────────────┘
      │
      ├──────────────┬──────────────┐
      ▼              ▼              ▼

 Student 1      Student 2      Student 3

 name=Om        name=Rahul     name=Amit
 age=22         age=20         age=21
```

---

# Object Independence

Each object stores its own data.

Example:

```java
Student s1 = new Student();
Student s2 = new Student();

s1.name = "Om";
s2.name = "Rahul";
```

Output

```text
s1.name → Om

s2.name → Rahul
```

Changing one object does **not** affect another object.

---

# Why?

Each object occupies a separate memory location in the Heap.

```text
Stack

s1 ───────┐

s2 ────┐  │
        │  │
        ▼  ▼

Heap

Student Object 1
name = Om

Student Object 2
name = Rahul
```

Both objects are independent.

---

# Best Practices

✔ One class should represent one real-world entity.

✔ Choose meaningful class names.

✔ Choose meaningful field names.

✔ Create multiple objects from one class instead of creating multiple classes.

✔ Keep related data inside the same class.

---

# Common Mistakes

❌ Creating a new class for every object.

```java
Student1

Student2

Student3
```

Correct:

```java
Student
```

Create multiple objects.

---

❌ Thinking every object shares the same data.

Every object has its own independent state.

---

❌ Forgetting to create an object.

```java
Student s1;

s1.name = "Om";
```

This only declares a reference variable.

No object exists.

---

❌ Using one object for multiple people.

```java
Student s1 = new Student();

s1.name = "Om";

s1.name = "Rahul";
```

The previous value is replaced.

Create separate objects instead.

---

# Mini Practice

Create classes for:

- Mobile
- Laptop
- Employee
- Bank Account
- Movie
- Hospital
- Library
- Product
- College
- Inventory

For each class:

- Create multiple objects.
- Assign different values.
- Print the details.

---

# Quick Revision

✔ A class models a real-world entity.

✔ Objects are created from a class.

✔ One class can create many objects.

✔ Every object stores its own data.

✔ Every object occupies its own memory.

✔ Changing one object does not affect another.

---
# Class & Object

## Part 4 – Interview & Revision

> **"Revision strengthens concepts. Practice builds confidence. Interviews test both."**

---

# Learning Goals

After this part, you will be able to:

- Revise Class & Object quickly.
- Answer common interview questions.
- Avoid beginner mistakes.
- Verify your understanding before moving to Constructors.

---

# Quick Revision

## Class

- A Class is a blueprint or template.
- It defines the structure of objects.
- It contains fields and methods.

Example:

```java
class Student {

    String name;
    int age;

}
```

---

## Object

- An Object is an instance of a class.
- It stores actual data.
- Multiple objects can be created from one class.

Example:

```java
Student s1 = new Student();
Student s2 = new Student();
```

---

## Memory

- Reference variables are stored in **Stack Memory**.
- Objects are stored in **Heap Memory**.
- Every object has its own memory location.

---

## Object Creation

```text
Class

↓

new Keyword

↓

Heap Memory Allocation

↓

Object Created

↓

Reference Returned

↓

Stored in Reference Variable
```

---

# Common Mistakes

❌ Thinking a class is an object.

```java
Student
```

This is a class.

---

❌ Forgetting to create an object.

```java
Student s1;
```

Only a reference variable is created.

---

❌ Assuming all objects share the same data.

Each object stores its own independent values.

---

❌ Creating multiple classes for similar objects.

Wrong:

```java
Student1

Student2

Student3
```

Correct:

```java
Student
```

Create multiple objects.

---

# Interview Questions

## Basic

- What is a Class?
- What is an Object?
- What is the difference between a Class and an Object?
- Why do we create objects?

---

## Intermediate

- What does the `new` keyword do?
- Where are objects stored?
- Where are reference variables stored?
- Can one class create multiple objects?
- Why are objects independent?

---

## Advanced

- Explain Stack Memory and Heap Memory.
- Draw the memory diagram after creating two objects.
- Explain the object creation process.
- What happens internally when `new` is executed?

---

# Practice Checklist

Complete these projects using only **Class & Object**.

- [ ] P1 – Student Management
- [ ] P2 – Bank Account System
- [ ] P3 – Library Management
- [ ] P4 – Hospital Management
- [ ] P5 – Employee Management
- [ ] P6 – Amazon Product System
- [ ] P7 – College System
- [ ] P8 – Movie Booking
- [ ] P9 – Car Rental
- [ ] P10 – Inventory System

---

# Self-Assessment Checklist

- [ ] I can create a class.
- [ ] I can create multiple objects.
- [ ] I can assign values to objects.
- [ ] I can access object fields.
- [ ] I understand the `new` keyword.
- [ ] I understand reference variables.
- [ ] I can explain Stack and Heap Memory.
- [ ] I can draw a memory diagram.
- [ ] I can model real-world entities using classes.

---

# Summary

✔ Class is a blueprint.

✔ Object is an instance of a class.

✔ One class can create multiple objects.

✔ Objects store actual data.

✔ Objects are stored in Heap Memory.

✔ Reference variables are stored in Stack Memory.

✔ Every object has its own independent state.

✔ Class & Object form the foundation of Object-Oriented Programming.

---

# What's Next?

➡ **Constructors**

In the next topic, you'll learn how to initialize objects automatically instead of assigning values one by one after object creation.