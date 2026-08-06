# Class & Object

# Part 1 – Introduction & Fundamentals

> **"Class and Object are the foundation of Object-Oriented Programming (OOP). Every Java application—from a simple Student Management System to large-scale systems like Amazon, Uber, or IRCTC—is built by designing classes and creating objects from them."**

---

# Table of Contents

1. Introduction
2. Why Object-Oriented Programming?
3. What is a Class?
4. What is an Object?
5. Class vs Object
6. Real-World Examples
7. First Java Program
8. Memory Overview
9. Best Practices
10. Common Mistakes
11. Interview Questions
12. Coding Exercises
13. Summary

---

# 1. Introduction

Before writing any Java application, we first identify the **real-world entities** involved in the problem.

For example, consider an Online Shopping System.

```
Online Shopping System

↓

Customer

Product

Cart

Order

Payment
```

Each of these entities becomes a **Java Class**.

During program execution, Java creates **Objects** from these classes to represent real data.

Everything in Object-Oriented Programming begins with this simple idea.

---

# 2. Why Object-Oriented Programming?

Imagine building an application without Classes.

You would have:

- Hundreds of variables
- Thousands of functions
- Difficult maintenance
- Duplicate code
- Poor scalability

Object-Oriented Programming solves these problems by organizing code into **Objects**.

Each object represents a real-world entity with its own data and behavior.

Example

```
Bank System

↓

Customer

Account

ATM

Transaction
```

Instead of writing everything together, each entity becomes a separate class.

Benefits of OOP

- Better Code Organization
- Code Reusability
- Easier Maintenance
- Real-World Modeling
- Scalability
- Easier Team Collaboration

---

# 3. What is a Class?

## Definition

A **Class** is a blueprint or template used to create objects.

It defines:

- State (Variables / Fields)
- Behavior (Methods)

A Class describes **what an object should look like**, but it does not contain actual data.

---

## Real-World Analogy

Blueprint

↓

House

A blueprint describes how to build a house.

It is **not** the house itself.

Similarly,

A Class describes an object.

It is **not** the object.

---

## Java Example

```java
class Student {

    String name;
    int age;

}
```

Here,

`Student` is a Class.

It defines what every student object should contain.

---

# 4. What is an Object?

## Definition

An **Object** is a real instance of a Class.

Objects contain actual values.

Example

```
Student Class

↓

Object

↓

Name = Om

Age = 22
```

Now real data exists.

---

## Java Example

```java
Student student = new Student();
```

Here,

`student`

is an Object created from the `Student` class.

---

# 5. Class vs Object

| Class | Object |
|--------|---------|
| Blueprint | Instance |
| Logical Entity | Physical Entity |
| Defines Structure | Holds Actual Data |
| Created Once | Can Create Many |
| No Real Data | Stores Real Values |

---

Example

```
Class

↓

Car

↓

Objects

↓

BMW

Audi

Tesla
```

One Class can create many Objects.

---

# 6. Real-World Examples

### Student Management

```
Class

↓

Student

↓

Objects

↓

Om

Rahul

Amit
```

---

### Library

```
Class

↓

Book

↓

Objects

↓

Java Programming

Python Basics

Clean Code
```

---

### Bank

```
Class

↓

BankAccount

↓

Objects

↓

Saving Account

Current Account
```

---

### Movie Booking

```
Class

↓

Movie

↓

Objects

↓

Avengers

Interstellar

Inception
```

---

# 7. First Java Program

Create a Class

```java
class Student {

    String name;
    int age;

}
```

Create an Object

```java
Student s1 = new Student();
```

Assign Values

```java
s1.name = "Om";
s1.age = 22;
```

Print Values

```java
System.out.println(s1.name);
System.out.println(s1.age);
```

Output

```
Om
22
```

---

# 8. Memory Overview

When the following statement executes,

```java
Student s1 = new Student();
```

Java performs these steps.

```
Load Class

↓

Create Object

↓

Allocate Memory

↓

Return Reference

↓

Store Reference in s1
```

In the next part, we will study Stack Memory, Heap Memory, Reference Variables, the `new` keyword, and Object Lifecycle in detail.

---

# 9. Best Practices

✅ Use meaningful Class names.

✅ One Class should represent one concept.

✅ Use PascalCase for Class names.

Example

```java
Student
BankAccount
MovieTicket
```

❌ Avoid

```java
student
abc
test
```

---

# 10. Common Mistakes

❌ Thinking a Class stores actual data.

❌ Thinking an Object and a Reference Variable are the same.

❌ Forgetting to create an object using `new`.

❌ Creating unnecessary objects.

❌ Using poor class names.

---

# 11. Interview Questions

- What is a Class?
- What is an Object?
- What is the difference between a Class and an Object?
- Can one Class create multiple Objects?
- Does a Class occupy memory?
- Why do we use the `new` keyword?
- What happens when an object is created?

---

# 12. Coding Exercises

## Exercise 1

Create a Class named `Car`.

Fields

- brand
- model
- price

---

## Exercise 2

Create a Class named `Employee`.

Fields

- id
- name
- salary

---

## Exercise 3

Create a Class named `Book`.

Fields

- title
- author
- price

---

## Exercise 4

Create a Class named `Movie`.

Fields

- movieName
- duration
- rating

---

## Exercise 5

Create five `Student` objects and print their details.

---

# 13. Summary

- A Class is a blueprint.
- An Object is an instance of a Class.
- A Class defines structure and behavior.
- Objects contain actual data.
- One Class can create many Objects.
- Classes and Objects form the foundation of Java OOP and Low-Level Design.

---

# Next Part

➡️ **Part 2 – Memory, Object Creation, Reference Variables & Object Lifecycle**

You'll learn:

- Stack Memory
- Heap Memory
- Reference Variables
- `new` Keyword
- Object Creation Process
- Object Lifecycle
- Garbage Collection
- Memory Diagrams
- Dry Runs
- Interview Questions

# Class & Object

# Part 2 – Object Creation & Memory

> **Goal:** Understand what happens internally when an object is created and how Java manages memory.

---

# Table of Contents

1. Object Creation
2. The `new` Keyword
3. Reference Variable
4. Stack vs Heap Memory
5. Memory Diagram
6. Object Lifecycle
7. Common Mistakes
8. Practice
9. Interview Questions
10. Summary

---

# 1. Object Creation

Consider the following statement:

```java
Student s1 = new Student();
```

Although it looks like a single line, Java performs several operations internally.

```
Student s1 = new Student();

        │

        ▼

Load Class

        │

        ▼

Allocate Heap Memory

        │

        ▼

Initialize Default Values

        │

        ▼

Call Constructor

        │

        ▼

Return Reference

        │

        ▼

Store Reference in s1
```

---

# 2. The `new` Keyword

The `new` keyword is responsible for creating an object.

Example

```java
Student s1 = new Student();
```

What `new` does:

- Allocates memory in the Heap.
- Initializes instance variables with default values.
- Calls the constructor.
- Returns a reference to the created object.

Without `new`, an object is **not** created.

Example

```java
Student s1;
```

This only creates a reference variable.

No object exists yet.

---

# 3. Reference Variable

A reference variable stores the address of an object.

```java
Student s1 = new Student();
```

```
s1

↓

0x1A2B3C
```

Important:

- `s1` is **not** the object.
- `s1` only points to the object stored in memory.

---

# 4. Stack vs Heap Memory

## Stack Memory

Stores:

- Local variables
- Method calls
- Reference variables

Example

```
Stack

┌───────────────┐
│ s1            │
│ 0x1A2B3C      │
└───────────────┘
```

---

## Heap Memory

Stores:

- Objects
- Arrays
- Instance variables

Example

```
Heap

┌─────────────────────┐
│ Student Object      │
│---------------------│
│ name = null         │
│ age  = 0            │
└─────────────────────┘
```

---

# 5. Memory Diagram

Code

```java
Student s1 = new Student();

s1.name = "Om";
s1.age = 22;
```

Memory

```
                 Stack

┌─────────────────────────┐
│ s1                      │
│        │                │
└────────┼────────────────┘
         │
         ▼

                 Heap

┌─────────────────────────┐
│ Student Object          │
│-------------------------│
│ name = "Om"             │
│ age  = 22               │
└─────────────────────────┘
```

---

# 6. Object Lifecycle

```
Class

↓

Object Created

↓

Memory Allocated

↓

Object Used

↓

Reference Lost

↓

Garbage Collector Removes Object
```

An object remains in memory as long as it is reachable.

---

# 7. Common Mistakes

❌ Thinking the reference variable is the object.

❌ Thinking objects are stored in Stack Memory.

❌ Forgetting the `new` keyword.

❌ Assuming every reference variable creates a new object.

Example

```java
Student s1 = new Student();

Student s2 = s1;
```

Only **one object** exists.

Both references point to the same object.

---

# 8. Practice

## Exercise 1

Create a `Student` object.

Draw its Stack and Heap memory.

---

## Exercise 2

Create three `Car` objects.

Draw the memory representation.

---

## Exercise 3

Predict the output.

```java
Student s1 = new Student();
Student s2 = s1;

s1.name = "Om";

System.out.println(s2.name);
```

---

## Exercise 4

Explain each step performed by Java for:

```java
Employee e1 = new Employee();
```

---

# 9. Interview Questions

### Q1. What happens internally when `new` is executed?

### Q2. What is a reference variable?

### Q3. Where are objects stored?

### Q4. Where are reference variables stored?

### Q5. What is the difference between Stack and Heap?

### Q6. Can two reference variables point to the same object?

### Q7. Does `new` return an object or a reference?

---

# 10. Summary

✔ `new` creates an object.

✔ Objects are stored in Heap Memory.

✔ Reference variables are stored in Stack Memory.

✔ A reference variable stores the address of an object.

✔ Multiple reference variables can point to the same object.

✔ Understanding memory is essential before learning Constructors.

---
# Class & Object

# Part 3 – Real World Modelling & Implementation

> **Goal:** Learn how to identify real-world entities, convert them into Java classes, create objects, and build simple object-oriented applications.

---

# Table of Contents

1. From Problem to Class
2. Identifying Classes
3. Identifying Attributes
4. Identifying Behaviors
5. Building Your First Model
6. Multiple Objects
7. Object Interaction
8. Mini Projects
9. Practice Problems
10. Best Practices
11. Summary

---

# 1. From Problem to Class

The first step in Object-Oriented Programming is **not writing code**.

The first step is understanding the problem.

Example

```
Library System
```

Ask yourself

```
What are the real-world things?

↓

Book

Student

Librarian

Library

Issue Record
```

These become your Java Classes.

---

# 2. Identifying Classes

Example

```
Online Shopping
```

```
Customer

Product

Cart

Order

Payment

Address
```

↓

Classes

```java
Customer

Product

Cart

Order

Payment

Address
```

---

Another Example

```
Hospital
```

↓

```
Patient

Doctor

Appointment

Medicine

Receptionist
```

↓

Java Classes

```java
Patient

Doctor

Appointment

Medicine

Receptionist
```

---

# 3. Identifying Attributes

Every class contains data.

Example

```
Student
```

Ask

"What information should every student have?"

↓

```
Roll Number

Name

Age

Course
```

Java

```java
class Student {

    int rollNumber;

    String name;

    int age;

    String course;

}
```

---

Example

```
Car
```

↓

```
Brand

Model

Price

Color
```

↓

```java
class Car {

    String brand;

    String model;

    double price;

    String color;

}
```

---

# 4. Identifying Behaviors

Objects do work.

That work becomes methods.

Example

```
Student
```

↓

```
Study

AttendClass

SubmitAssignment
```

↓

```java
void study(){}

void attendClass(){}

void submitAssignment(){}
```

---

Example

```
Bank Account
```

↓

```
Deposit

Withdraw

Check Balance
```

↓

```java
deposit()

withdraw()

checkBalance()
```

---

# 5. Building Your First Model

Requirement

```
Student Management System
```

Step 1

Identify Class

```
Student
```

Step 2

Identify Attributes

```
rollNumber

name

age

course
```

Step 3

Identify Behaviors

```
study()

display()

updateCourse()
```

Final Design

```
Student

----------------

rollNumber

name

age

course

----------------

study()

display()

updateCourse()
```

Now you are ready to write Java code.

---

# 6. Multiple Objects

One class can create many objects.

```
Student Class

↓

Student 1

↓

Student 2

↓

Student 3

↓

Student 4
```

Example

```java
Student s1 = new Student();

Student s2 = new Student();

Student s3 = new Student();
```

Each object stores different data.

```
s1

Name = Om

Age = 22

-------------------

s2

Name = Rahul

Age = 20

-------------------

s3

Name = Amit

Age = 21
```

---

# 7. Object Interaction

Objects can work together.

Example

```
Library

↓

contains

↓

Books
```

```
Customer

↓

places

↓

Order
```

```
Doctor

↓

treats

↓

Patient
```

This interaction becomes the foundation of relationships, which you will study in the next chapter.

---

# 8. Mini Projects

Build each project from scratch.

## Project 1

Student Management

Classes

```
Student
```

---

## Project 2

Library

Classes

```
Book

Student

Library
```

---

## Project 3

Bank

Classes

```
Customer

Account
```

---

## Project 4

Movie Booking

Classes

```
Movie

Customer

Ticket
```

---

## Project 5

Hospital

Classes

```
Patient

Doctor

Appointment
```

---

# 9. Practice Problems

## Beginner

Create

- Student
- Employee
- Car
- Book
- Mobile

---

## Intermediate

Create

- Bank Account
- Product
- Movie
- Laptop
- College

---

## Challenge

Design classes for

- ATM
- Hotel
- Food Delivery
- Parking Lot
- Railway Reservation

Only identify

- Classes
- Attributes
- Behaviors

No coding yet.

---

# 10. Best Practices

✅ Use nouns for class names.

```
Student

Book

Car

Employee
```

---

✅ Use verbs for method names.

```
deposit()

withdraw()

display()

study()
```

---

✅ One class should represent one concept.

---

✅ Keep classes focused.

Avoid creating one class that performs many unrelated tasks.

---

# Summary

Whenever you receive a problem,

always follow this approach.

```
Understand Problem

↓

Identify Classes

↓

Identify Attributes

↓

Identify Behaviors

↓

Write Class

↓

Create Objects

↓

Test

↓

Improve
```

This is exactly how software engineers begin designing object-oriented systems.

---
# Class & Object

# Part 4 – Interview Mastery, Assignments & Revision

> **Goal:** Strengthen your understanding through interview questions, assignments, debugging exercises, and a quick revision sheet.

---

# Table of Contents

1. Interview Questions
2. Output-Based Questions
3. Debugging Exercises
4. Assignments
5. Real Interview Scenarios
6. Quick Revision Sheet
7. Summary
8. Next Topic

---

# 1. Interview Questions

## Basic Questions

### Q1. What is a Class?

---

### Q2. What is an Object?

---

### Q3. What is the difference between a Class and an Object?

---

### Q4. Can one Class create multiple Objects?

---

### Q5. Why do we need Objects?

---

### Q6. What does the `new` keyword do?

---

### Q7. Where are Objects stored?

---

### Q8. Where are Reference Variables stored?

---

### Q9. Can two Reference Variables point to the same Object?

---

### Q10. What happens internally when Java executes

```java
Student s1 = new Student();
```

---

# 2. Output-Based Questions

## Question 1

Predict the output.

```java
class Student {

    String name;

}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();

        System.out.println(s1.name);

    }

}
```

---

## Question 2

```java
class Student {

    int age;

}

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student();

        System.out.println(s1.age);

    }

}
```

---

## Question 3

```java
Student s1 = new Student();

Student s2 = s1;

s1.name = "Om";

System.out.println(s2.name);
```

Predict the output and explain why.

---

## Question 4

How many objects are created?

```java
Student s1 = new Student();

Student s2 = new Student();

Student s3 = s1;
```

---

## Question 5

Draw the Stack and Heap memory for

```java
Student s1 = new Student();

Student s2 = s1;
```

---

# 3. Debugging Exercises

## Exercise 1

Find the mistake.

```java
Student s1;

s1.name = "Om";
```

---

## Exercise 2

Find the mistake.

```java
Student s1 = null;

System.out.println(s1.name);
```

---

## Exercise 3

Predict the error.

```java
Student s1;

System.out.println(s1);
```

---

## Exercise 4

Explain the problem.

```java
Student s1 = new Student();

Student s2 = s1;

s2.name = "Rahul";
```

Will `s1.name` also change?

Why?

---

# 4. Assignments

## Assignment 1

Design a **Student** class.

Requirements

- rollNumber
- name
- age
- course

Create three objects and print their details.

---

## Assignment 2

Design an **Employee** class.

Requirements

- id
- name
- salary
- department

---

## Assignment 3

Design a **Book** class.

Requirements

- title
- author
- price

---

## Assignment 4

Design a **Car** class.

Requirements

- brand
- model
- color
- price

---

## Assignment 5

Design a **Movie** class.

Requirements

- movieName
- duration
- rating

---

## Assignment 6

Identify the classes for the following systems.

### Library Management

### Hospital Management

### Food Delivery

### ATM System

### Parking Lot

Only identify

- Classes
- Attributes
- Behaviors

No coding.

---

# 5. Real Interview Scenarios

## Scenario 1

You are asked to design a **Banking System**.

What classes would you create first?

---

## Scenario 2

You are asked to design a **Library System**.

Which objects will be created during execution?

---

## Scenario 3

A company asks you to design a **Movie Booking System**.

How would you identify classes?

---

## Scenario 4

You need to design a **Parking Lot**.

List the first five classes you would create.

---

# 6. Quick Revision Sheet

## Remember

```
Real World

↓

Identify Entities

↓

Create Classes

↓

Create Objects

↓

Assign Values

↓

Objects Interact

↓

Build Application
```

---

### Class

✔ Blueprint

✔ Logical Entity

✔ Defines Structure

---

### Object

✔ Instance of Class

✔ Stores Actual Data

✔ Lives in Heap Memory

---

### Reference Variable

✔ Stores Object Address

✔ Lives in Stack Memory

---

### `new`

✔ Creates Object

✔ Allocates Heap Memory

✔ Calls Constructor

✔ Returns Reference

---

### Memory

```
Stack

↓

Reference Variables

--------------------

Heap

↓

Objects
```

---

# 7. Summary

After completing this chapter, you should be able to:

- Explain Class and Object confidently.
- Identify classes from any real-world problem.
- Create Java classes and objects.
- Understand Stack and Heap memory.
- Explain object creation internally.
- Answer beginner interview questions.
- Build small object-oriented applications.

This chapter is the foundation of everything in Java OOP and Low-Level Design.

---

# Chapter Complete ✅

You now understand:

✔ Why OOP exists

✔ What is a Class

✔ What is an Object

✔ Class vs Object

✔ Object Creation

✔ Stack & Heap Memory

✔ Reference Variables

✔ Real-World Modelling

✔ Best Practices

✔ Common Mistakes

✔ Interview Questions

✔ Coding Exercises

✔ Assignments

---

# Next Topic

➡ **02 – Constructors**

You'll learn:

- Why Constructors are needed
- Default Constructor
- Parameterized Constructor
- Constructor Overloading
- `this()` Constructor Chaining
- Object Initialization
- Constructor Best Practices
- Memory Flow During Construction
- Practice Problems
- Interview Questions