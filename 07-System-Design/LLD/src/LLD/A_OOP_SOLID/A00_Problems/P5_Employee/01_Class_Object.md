# P5 - Employee Management

## Objective

Practice creating objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object

---

# Problem Statement

Create an `Employee` class with the following fields:

- id
- name
- salary
- department

Create **5 Employee objects**, assign values manually, and print their details.

---

# Requirements

- Create an `Employee` class.
- Create **5 Employee objects**.
- Assign values manually.
- Print all employee details.

---

# Solution

## Employee.java

```java
public class Employee {

    int id;
    String name;
    double salary;
    String department;

}
```

---

## Main.java

```java
Employee e1 = new Employee();
e1.name = "Anv";
e1.id = 93;
e1.salary = 42434.00;
e1.department = "IT";

Employee e2 = new Employee();
e2.name = "Anie";
e2.id = 94;
e2.salary = 342434.00;
e2.department = "Marketing";

Employee e3 = new Employee();
e3.name = "Anuj";
e3.id = 95;
e3.salary = 542434.00;
e3.department = "Manufacturing";

Employee e4 = new Employee();
e4.name = "Rahul";
e4.id = 96;
e4.salary = 65234.00;
e4.department = "HR";

Employee e5 = new Employee();
e5.name = "Priya";
e5.id = 97;
e5.salary = 75434.00;
e5.department = "Finance";

System.out.println(
    e1.name + " " + e1.id + " " +
    e1.salary + " " + e1.department
);

System.out.println(
    e2.name + " " + e2.id + " " +
    e2.salary + " " + e2.department
);

System.out.println(
    e3.name + " " + e3.id + " " +
    e3.salary + " " + e3.department
);

System.out.println(
    e4.name + " " + e4.id + " " +
    e4.salary + " " + e4.department
);

System.out.println(
    e5.name + " " + e5.id + " " +
    e5.salary + " " + e5.department
);
```

---

# Memory Representation

```text
                Stack Memory

        e1 ──────────────┐
        e2 ───────────┐  │
        e3 ────────┐  │  │
        e4 ─────┐  │  │  │
        e5 ──┐  │  │  │  │
             │  │  │  │  │
             ▼  ▼  ▼  ▼  ▼

                Heap Memory

        Employee Object 1

        id         = 93
        name       = "Anv"
        salary     = 42434.00
        department = "IT"

        ----------------------------

        Employee Object 2

        id         = 94
        name       = "Anie"
        salary     = 342434.00
        department = "Marketing"

        ----------------------------

        Employee Object 3

        id         = 95
        name       = "Anuj"
        salary     = 542434.00
        department = "Manufacturing"

        ----------------------------

        Employee Object 4

        id         = 96
        name       = "Rahul"
        salary     = 65234.00
        department = "HR"

        ----------------------------

        Employee Object 5

        id         = 97
        name       = "Priya"
        salary     = 75434.00
        department = "Finance"
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

### Why does each Employee object have different values?

Every time `new Employee()` is executed, Java creates a new object in Heap Memory.

Each object has its own memory location and stores its own data independently.

Therefore, changing one Employee object's data does not affect another object.

---

# Success Checklist

- Created an Employee class.
- Created 5 Employee objects.
- Assigned values manually.
- Printed all employee details.
- Understood Stack and Heap Memory.
- Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
Employee e1 = new Employee();

e1.id = 93;
e1.name = "Anv";
e1.salary = 42434.00;
e1.department = "IT";
```

### After

```java
Employee e1 = new Employee(
    93,
    "Anv",
    42434.00,
    "IT"
);
```