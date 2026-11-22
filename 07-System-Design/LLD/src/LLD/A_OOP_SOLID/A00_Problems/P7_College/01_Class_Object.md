# P7 - College System

## Objective

Practice creating `College` objects and assigning values manually using **Class & Object**.

---

# Prerequisites

* Class
* Object

---

# Problem Statement

Create a `College` class with the following fields:

* collegeId
* collegeName
* city
* totalStudent

Create **3 College objects**, assign values manually, and print their details.

---

# Requirements

* Create a `College` class.
* Create **3 College objects**.
* Assign values manually.
* Print all college details.

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

}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class Main {

    public static void main(String[] args) {

        College c1 = new College();
        c1.collegeId = 832;
        c1.collegeName = "GH Raisoni";
        c1.city = "Pune";
        c1.totalStudent = 321;

        College c2 = new College();
        c2.collegeId = 332;
        c2.collegeName = "Sanmati";
        c2.city = "Washim";
        c2.totalStudent = 424;

        College c3 = new College();
        c3.collegeId = 233;
        c3.collegeName = "HVPM";
        c3.city = "Amravati";
        c3.totalStudent = 341;

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

# Memory Representation

```text
                Stack Memory

        c1 ──────────────┐
        c2 ───────────┐  │
        c3 ────────┐  │  │
                   │  │  │
                   ▼  ▼  ▼

                Heap Memory

        College Object 1

        collegeId    = 832
        collegeName  = "GH Raisoni"
        city         = "Pune"
        totalStudent = 321

        ----------------------------

        College Object 2

        collegeId    = 332
        collegeName  = "Sanmati"
        city         = "Washim"
        totalStudent = 424

        ----------------------------

        College Object 3

        collegeId    = 233
        collegeName  = "HVPM"
        city         = "Amravati"
        totalStudent = 341
```

---

# What You Learned

* A Class is a blueprint.
* An Object is an instance of a class.
* `new` creates a new object.
* Objects are stored in Heap Memory.
* Reference variables are stored in Stack Memory.
* One class can create multiple objects.
* Each object has its own independent state.

---

# Interview Question

### Can multiple College objects exist at the same time?

**Yes.**

A single `College` class can create multiple objects.

```java
College c1 = new College();
College c2 = new College();
College c3 = new College();
```

Each object has its own independent data.

---

# Success Checklist

* [x] Created `College` class.
* [x] Added required fields.
* [x] Created 3 College objects.
* [x] Assigned values manually.
* [x] Printed all college details.
* [x] Understood Stack and Heap Memory.
* [x] Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, replace manual field assignments with constructors.

### Before

```java
College c1 = new College();

c1.collegeId = 832;
c1.collegeName = "GH Raisoni";
c1.city = "Pune";
c1.totalStudent = 321;
```

### After

```java
College c1 = new College(
    832,
    "GH Raisoni",
    "Pune",
    321
);
```
