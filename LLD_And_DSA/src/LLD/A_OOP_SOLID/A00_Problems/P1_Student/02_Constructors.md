# P1 - Student Management

## Objective

Upgrade the Student Management project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Requirements

Modify the existing `Student` class.

## Fields

- rollNumber
- name
- age
- course

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

---

## Task 3

Create **5 Student objects** using the Parameterized Constructor.

---

## Task 4

Print all student details.

---

# Expected Learning

After completing this practice, you should understand:

- Default Constructor
- Parameterized Constructor
- Object Initialization
- `this` Keyword

---

# Solution

## Student.java

```java
package LLD.A_OOP_SOLID.A00_Problems.P1_Student;

public class Student {

    int rollNumber;
    String name;
    int age;
    String course;

    // Default Constructor
    Student() {

    }

    // Parameterized Constructor
    Student(int rollNumber, String name, int age, String course) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Problems.P1_Student;

import LLD.A_OOP_SOLID.A00_Code.C1_Student.Student;

public class Main {

    public static void main(String[] args) {

        Student s1 = new Student(21, "Om", 22, "CSE");
        Student s2 = new Student(22, "Sahil", 22, "CSE");
        Student s3 = new Student(23, "Pavan", 22, "CSE");
        Student s4 = new Student(24, "Nakul", 22, "IT");
        Student s5 = new Student(25, "Shiva", 24, "BA");

        System.out.println(s1.rollNumber + " " + s1.name + " " + s1.age + " " + s1.course);
        System.out.println(s2.rollNumber + " " + s2.name + " " + s2.age + " " + s2.course);
        System.out.println(s3.rollNumber + " " + s3.name + " " + s3.age + " " + s3.course);
        System.out.println(s4.rollNumber + " " + s4.name + " " + s4.age + " " + s4.course);
        System.out.println(s5.rollNumber + " " + s5.name + " " + s5.age + " " + s5.course);
    }
}
```

---

# Challenge

Explain the difference between:

```java
Student s1 = new Student();
```

and

```java
Student s1 = new Student(1, "Om", 22, "CSE");
```

### Answer

`Student()` calls the **Default Constructor**, which creates an object without initializing custom values.

`Student(1, "Om", 22, "CSE")` calls the **Parameterized Constructor**, which initializes the object with the given values during object creation.

The second approach is preferred because it:

- Reduces repetitive code.
- Initializes the object immediately.
- Makes the code cleaner and easier to maintain.

---

# Upgrade

### Before (Class & Object)

```java
Student s1 = new Student();

s1.rollNumber = 1;
s1.name = "Om";
s1.age = 22;
s1.course = "CSE";
```

### After (Constructors)

```java
Student s1 = new Student(
    1,
    "Om",
    22,
    "CSE"
);
```

---

# Success Checklist

- [x] Created a Default Constructor.
- [x] Created a Parameterized Constructor.
- [x] Created 5 Student objects.
- [x] Printed all student details.
- [x] Understood the purpose of `this`.
- [x] Understood why constructors reduce repetitive code.

---

# Key Takeaways

- Constructors initialize objects.
- Constructors execute automatically when an object is created.
- Parameterized constructors make object creation cleaner.
- The `this` keyword refers to the current object.
- Constructors improve code readability and maintainability.

---

# Next Practice

➡ **P2 – Bank Account System**