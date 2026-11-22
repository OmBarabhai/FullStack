# P7 - College System — Constructors

## Objective

Upgrade the College Management project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

* Class
* Object
* Object Creation
* Constructors

---

# Requirements

Modify the existing `College` class.

## Fields

* collegeId
* collegeName
* city
* totalStudent

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

* collegeId
* collegeName
* city
* totalStudent

---

## Task 3

Create **3 College objects** using the Parameterized Constructor.

---

## Task 4

Create **1 College object** using the Default Constructor.

---

## Task 5

Print all college details.

---

# Solution

## College.java

```java
package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class College {

    int collegeId;
    String collegeName;
    String city;
    int totalStudent;

    // Default Constructor
    College() {
        this(0, "Unknown", "Unknown", 0);
    }

    // Parameterized Constructor
    College(int collegeId, String collegeName,
            String city, int totalStudent) {

        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.city = city;
        this.totalStudent = totalStudent;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class Main {

    public static void main(String[] args) {

        // Default Constructor
        College c0 = new College();

        // Parameterized Constructor
        College c1 = new College(
                832,
                "GH Raisoni",
                "Pune",
                321
        );

        College c2 = new College(
                332,
                "Sanmati",
                "Washim",
                424
        );

        College c3 = new College(
                233,
                "HVPM",
                "Amravati",
                341
        );

        System.out.println(
                c0.collegeId + " " +
                c0.collegeName + " " +
                c0.city + " " +
                c0.totalStudent
        );

        System.out.println(
                c1.collegeId + " " +
                c1.collegeName + " " +
                c1.city + " " +
                c1.totalStudent
        );

        System.out.println(
                c2.collegeId + " " +
                c2.collegeName + " " +
                c2.city + " " +
                c2.totalStudent
        );

        System.out.println(
                c3.collegeId + " " +
                c3.collegeName + " " +
                c3.city + " " +
                c3.totalStudent
        );
    }
}
```

---

# Constructor Flow

### Default Constructor

```java
College c0 = new College();
```

Flow:

```text
new College()
      ↓
Default Constructor
      ↓
this(0, "Unknown", "Unknown", 0)
      ↓
Parameterized Constructor
```

This is called **Constructor Chaining**.

---

### Parameterized Constructor

```java
College c1 = new College(
    832,
    "GH Raisoni",
    "Pune",
    321
);
```

Directly calls:

```java
College(
    int collegeId,
    String collegeName,
    String city,
    int totalStudent
)
```

---

# Understanding `this`

```java
this.collegeId = collegeId;
```

```text
this.collegeId
      ↓
Current object's instance variable

collegeId
      ↓
Constructor parameter
```

Similarly:

```java
this.collegeName = collegeName;
this.city = city;
this.totalStudent = totalStudent;
```

---

# Challenge Answers

### 1. Which constructor is called?

```java
College c0 = new College();
```

**Default Constructor**

---

### 2. Which constructor is called?

```java
College c1 = new College(
    832,
    "GH Raisoni",
    "Pune",
    321
);
```

**Parameterized Constructor**

---

### 3. Why is the second approach preferred?

Instead of:

```java
College c1 = new College();

c1.collegeId = 832;
c1.collegeName = "GH Raisoni";
c1.city = "Pune";
c1.totalStudent = 321;
```

we can initialize everything during object creation:

```java
College c1 = new College(
    832,
    "GH Raisoni",
    "Pune",
    321
);
```

This makes object creation cleaner and reduces repetitive assignments.

---

### 4. What does `this` do?

`this` refers to the **current object**.

```java
this.collegeId = collegeId;
```

means:

```text
current object's collegeId = constructor's collegeId
```

---

# What You Learned

* Default Constructor
* Parameterized Constructor
* Constructor Overloading
* Constructor Chaining
* `this` Keyword
* Object Initialization
* Cleaner Object Creation

---

# Success Checklist

* [x] Created `College` class.
* [x] Added all required fields.
* [x] Created Default Constructor.
* [x] Created Parameterized Constructor.
* [x] Created 3 College objects using Parameterized Constructor.
* [x] Created 1 College object using Default Constructor.
* [x] Printed all college details.
* [x] Used `this` correctly.
* [x] Used Constructor Chaining.
* [x] Understood constructor-based initialization.

---

# Before vs After

### Before — Class & Object

```java
College c1 = new College();

c1.collegeId = 832;
c1.collegeName = "GH Raisoni";
c1.city = "Pune";
c1.totalStudent = 321;
```

### After — Constructor

```java
College c1 = new College(
    832,
    "GH Raisoni",
    "Pune",
    321
);
```

---

# Next Practice

➡ **P8 - Movie Booking — Constructors**
