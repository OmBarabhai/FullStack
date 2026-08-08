# Constructors

## Part 1 – Introduction

> **"A Constructor is a special member of a class that initializes an object when it is created."**

---

# Learning Goals

After this part, you will be able to:

- Understand what a constructor is.
- Know why constructors are used.
- Know when constructors execute.
- Differentiate a constructor from a method.

---

# Why Do We Need Constructors?

Suppose we have a `Student` class.

Without constructors:

```java
Student s1 = new Student();

s1.rollNumber = 1;
s1.name = "Om";
s1.age = 22;
s1.course = "CSE";
```

We first create the object and then assign values one by one.

If we create many objects, this code becomes repetitive.

Constructors solve this problem by initializing the object during creation.

---

# What is a Constructor?

A constructor is a special member of a class that is automatically called whenever an object is created.

Its primary purpose is to initialize the object's data.

Example:

```java
Student s1 = new Student();
```

When `new Student()` executes, Java automatically calls the constructor.

---

# Real-World Analogy

Think of buying a new phone.

Before you start using it:

- Language is selected.
- Date and time are set.
- Initial settings are applied.

Similarly, before an object is used, Java executes the constructor to prepare it.

---

# Where Are Constructors Used?

Constructors are used in almost every class.

Examples:

- Student
- Employee
- BankAccount
- Product
- Car
- Book
- Movie
- User

---

# Key Points

- A constructor initializes an object.
- It executes automatically.
- It is called when an object is created.
- It makes object creation easier and cleaner.

---

# Quick Revision

✔ Initializes objects.

✔ Runs automatically.

✔ Called during object creation.

✔ Makes code cleaner.

---
# Constructors

## Part 2 – Constructor Types

> **"Constructors can initialize objects in different ways depending on the information available during object creation."**

---

# Learning Goals

After this part, you will be able to:

- Understand the Default Constructor.
- Understand the Parameterized Constructor.
- Understand Constructor Overloading.
- Know when to use each constructor.

---

# 1. Default Constructor

A **Default Constructor** is a constructor with no parameters.

If you do not write any constructor, Java automatically provides one.

Example:

```java
class Student {

    Student() {
        System.out.println("Student Created");
    }

}
```

Creating an object:

```java
Student s1 = new Student();
```

Output

```
Student Created
```

### When to Use?

- When an object does not need initial values.
- When values will be assigned later.

---

# 2. Parameterized Constructor

A **Parameterized Constructor** accepts values while creating an object.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
```

Creating an object:

```java
Student s1 = new Student("Om", 22);
```

Now the object is initialized immediately.

---

# 3. Constructor Overloading

A class can have multiple constructors with different parameter lists.

Example:

```java
class Student {

    Student() {

    }

    Student(String name) {

    }

    Student(String name, int age) {

    }

}
```

Creating objects:

```java
Student s1 = new Student();

Student s2 = new Student("Om");

Student s3 = new Student("Om", 22);
```

Java automatically calls the matching constructor.

---

# Default Constructor vs Parameterized Constructor

| Default Constructor | Parameterized Constructor |
|---------------------|---------------------------|
| No parameters | Accepts parameters |
| Initializes with default values | Initializes with user-provided values |
| Easy object creation | Flexible object creation |

---

# Constructor vs Method

| Constructor | Method |
|-------------|--------|
| Same name as class | Any valid name |
| No return type | Has return type |
| Runs automatically | Called manually |
| Initializes object | Performs an action |

---

# Quick Revision

✔ Default Constructor → No parameters.

✔ Parameterized Constructor → Accepts values.

✔ Constructor Overloading → Multiple constructors with different parameters.

✔ Java selects the constructor that matches the arguments.

---
# Constructors

## Part 3 – Practical Implementation

> **"The best way to understand constructors is by writing code and upgrading existing projects."**

---

# Learning Goals

After this part, you will be able to:

- Create a Default Constructor.
- Create a Parameterized Constructor.
- Use the `this` keyword.
- Perform Constructor Overloading.
- Upgrade your existing projects using constructors.

---

# Step 1 – Default Constructor

A default constructor has **no parameters**.

Example:

```java
class Student {

    Student() {
        System.out.println("Student Object Created");
    }

}
```

Creating an object:

```java
Student s1 = new Student();
```

Output

```
Student Object Created
```

---

# Step 2 – Parameterized Constructor

A parameterized constructor initializes an object with values.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
```

Creating an object:

```java
Student s1 = new Student("Om", 22);

System.out.println(s1.name);
System.out.println(s1.age);
```

Output

```
Om
22
```

---

# Step 3 – Constructor Overloading

One class can have multiple constructors.

Example:

```java
class Student {

    Student() {

    }

    Student(String name) {

    }

    Student(String name, int age) {

    }

}
```

Java automatically chooses the matching constructor.

---

# Step 4 – The `this` Keyword

`this` refers to the current object.

Example:

```java
class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
```

Here,

- `this.name` → Instance variable
- `name` → Constructor parameter

---

# Step 5 – Constructor Chaining

One constructor can call another constructor using `this()`.

Example:

```java
class Student {

    Student() {
        this("Unknown", 0);
    }

    Student(String name, int age) {
        System.out.println(name + " " + age);
    }

}
```

Creating an object:

```java
Student s1 = new Student();
```

Output

```
Unknown 0
```

---

# Practice Projects

Upgrade all Class & Object projects using constructors.

- P1 – Student
- P2 – Bank
- P3 – Library
- P4 – Hospital
- P5 – Employee
- P6 – Amazon
- P7 – College
- P8 – Movie Booking
- P9 – Car Rental
- P10 – Inventory

---

# Before Constructors

```java
Student s1 = new Student();

s1.name = "Om";
s1.age = 22;
s1.course = "CSE";
```

---

# After Constructors

```java
Student s1 = new Student(
        1,
        "Om",
        22,
        "CSE"
);
```

Cleaner and easier to maintain.

---

# Object Creation Flow

```text
new Student()

↓

Heap Memory Allocated

↓

Default Values Assigned

↓

Constructor Executes

↓

Object Initialized

↓

Reference Returned
```

---

# Quick Revision

✔ Default Constructor

✔ Parameterized Constructor

✔ Constructor Overloading

✔ `this` Keyword

✔ Constructor Chaining

✔ Upgrade all Practice Projects

---
# Constructors

## Part 4 – Interview & Revision

> **"Revision makes concepts permanent. Practice makes them interview-ready."**

---

# Learning Goals

After this part, you will be able to:

- Revise all constructor concepts quickly.
- Answer common interview questions.
- Avoid common mistakes.
- Complete constructor practice confidently.

---

# Quick Revision

## Constructor

- Initializes an object.
- Runs automatically when an object is created.
- Has the same name as the class.
- Has no return type.

---

## Default Constructor

- No parameters.
- Created automatically by Java if no constructor is written.

---

## Parameterized Constructor

- Accepts parameters.
- Initializes an object with user-provided values.

---

## Constructor Overloading

- Multiple constructors in the same class.
- Different parameter lists.
- Java chooses the matching constructor automatically.

---

## `this` Keyword

- Refers to the current object.
- Resolves ambiguity between instance variables and parameters.
- Can call another constructor using `this()`.

---

## Constructor Chaining

- One constructor calls another constructor.
- Uses `this()`.
- Helps avoid duplicate code.

---

# Common Mistakes

❌ Giving a constructor a return type.

```java
void Student() {

}
```

This is a method, not a constructor.

---

❌ Constructor name different from class name.

```java
StudentData() {

}
```

Not a constructor.

---

❌ Forgetting `this`.

```java
name = name;
```

Both refer to the constructor parameter.

Correct:

```java
this.name = name;
```

---

❌ Calling a constructor like a normal method.

```java
Student();
```

Constructors are executed only when creating an object.

---

❌ Forgetting constructor parameters.

```java
Student s1 = new Student();
```

when only

```java
Student(String name)
```

exists.

---

# Interview Questions

## Basic

- What is a constructor?
- Why do we use constructors?
- When is a constructor executed?
- Can a constructor return a value?

---

## Intermediate

- Difference between constructor and method?
- What is a default constructor?
- What is a parameterized constructor?
- What is constructor overloading?
- What is the `this` keyword?

---

## Advanced

- Can constructors be inherited?
- Can constructors be overridden?
- Can constructors be private?
- What is constructor chaining?
- What happens internally when `new` is executed?

---

# Practice Checklist

Complete these projects using constructors.

- [x] P1 – Student
- [x] P2 – Bank
- [x] P3 – Library
- [x] P4 – Hospital
- [x]  P5 – Employee
- [x] P6 – Amazon
- [x] P7 – College
- [x] P8 – Movie Booking
- [x] P9 – Car Rental
- [x] P10 – Inventory

---

# Constructor Learning Checklist

- [x] I can create a default constructor.
- [x] I can create a parameterized constructor.
- [x] I can overload constructors.
- [x] I can use the `this` keyword.
- [x] I can perform constructor chaining.
- [x] I can explain object creation using constructors.
- [x] I can answer constructor interview questions.

---

# Summary

✔ Constructors initialize objects.

✔ Constructors execute automatically.

✔ Constructors have the same name as the class.

✔ Constructors do not have a return type.

✔ Constructors can be overloaded.

✔ `this` refers to the current object.

✔ Constructor chaining reduces duplicate code.

✔ Constructors are one of the core concepts of Object-Oriented Programming.

---

# Next Topic

➡ **Encapsulation**