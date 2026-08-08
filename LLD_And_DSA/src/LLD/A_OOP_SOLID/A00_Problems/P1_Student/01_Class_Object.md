# P1 - Student Management

## Objective

Practice creating objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object

---

# Problem Statement

Create a `Student` class with the following fields:

- rollNumber
- name
- age
- course

Create **5 Student objects**, assign values manually, and print their details.

---

# Requirements

- Create a `Student` class.
- Create **5 Student objects**.
- Assign values manually.
- Print all student details.

---

# Solution

## Student.java

```java
public class Student {

    int rollNumber;
    String name;
    int age;
    String course;

}
```

---

## Main.java

```java
Student s1 = new Student();
s1.rollNumber = 21;
s1.name = "Om";
s1.age = 22;
s1.course = "CSE";

Student s2 = new Student();
s2.rollNumber = 22;
s2.name = "Sahil";
s2.age = 22;
s2.course = "CSE";

// Remaining students...
```

---

# Memory Representation

```text
                Stack Memory

        s1 ──────────────┐

        s2 ───────────┐  │
                      │  │
                      ▼  ▼

                Heap Memory

        Student Object 1

        rollNumber = 21
        name       = "Om"
        age        = 22
        course     = "CSE"

        ----------------------------

        Student Object 2

        rollNumber = 22
        name       = "Sahil"
        age        = 22
        course     = "CSE"
```

---

# What You Learned

- A Class is a blueprint.
- An Object is an instance of a class.
- The `new` keyword creates an object.
- Objects are stored in Heap Memory.
- Reference variables are stored in Stack Memory.
- Every object stores its own independent data.

---

# Interview Question

### Why does each Student object have different values?

Every time `new Student()` is executed, Java creates a new object in Heap Memory. Each object has its own memory location and stores its own data independently. Therefore, changing one object's data does not affect another object.

---

# Success Checklist

- [x] Created a Student class.
- [x] Created 5 Student objects.
- [x] Assigned values manually.
- [x] Printed all student details.
- [x] Understood Stack and Heap Memory.
- [x] Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
Student s1 = new Student();

s1.rollNumber = 21;
s1.name = "Om";
s1.age = 22;
s1.course = "CSE";
```

### After

```java
Student s1 = new Student(
        21,
        "Om",
        22,
        "CSE"
);
```