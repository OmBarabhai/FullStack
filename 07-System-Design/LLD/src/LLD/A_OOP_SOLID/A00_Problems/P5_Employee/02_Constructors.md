# P5 - Employee Management

## Objective

Upgrade the Employee Management project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Requirements

Modify the existing `Employee` class.

## Fields

- id
- name
- salary
- department

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

- id
- name
- salary
- department

---

## Task 3

Create **5 Employee objects** using the Parameterized Constructor.

---

## Task 4

Create **1 Employee object** using the Default Constructor.

---

## Task 5

Print all employee details.

---

# Solution

## Employee.java

```java
package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Employee {

    int id;
    String name;
    double salary;
    String department;

    // Default Constructor
    Employee() {
        this(0, "Unknown", 0.0, "Unknown");
    }

    // Parameterized Constructor
    Employee(int id, String name, double salary, String department) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Main {

    public static void main(String[] args) {

        // Default Constructor
        Employee e0 = new Employee();

        // Parameterized Constructor
        Employee e1 = new Employee(
                93,
                "Anv",
                42434.00,
                "IT"
        );

        Employee e2 = new Employee(
                94,
                "Anie",
                342434.00,
                "Marketing"
        );

        Employee e3 = new Employee(
                95,
                "Anuj",
                542434.00,
                "Manufacturing"
        );

        Employee e4 = new Employee(
                96,
                "Rahul",
                65234.00,
                "HR"
        );

        Employee e5 = new Employee(
                97,
                "Priya",
                75434.00,
                "Finance"
        );

        System.out.println(
                e0.name + " " +
                e0.id + " " +
                e0.salary + " " +
                e0.department
        );

        System.out.println(
                e1.name + " " +
                e1.id + " " +
                e1.salary + " " +
                e1.department
        );

        System.out.println(
                e2.name + " " +
                e2.id + " " +
                e2.salary + " " +
                e2.department
        );

        System.out.println(
                e3.name + " " +
                e3.id + " " +
                e3.salary + " " +
                e3.department
        );

        System.out.println(
                e4.name + " " +
                e4.id + " " +
                e4.salary + " " +
                e4.department
        );

        System.out.println(
                e5.name + " " +
                e5.id + " " +
                e5.salary + " " +
                e5.department
        );
    }
}
```

---

# Constructor Flow

### Default Constructor

```java
Employee e0 = new Employee();
```

Calls:

```java
Employee() {
    this(0, "Unknown", 0.0, "Unknown");
}
```

The Default Constructor then calls the Parameterized Constructor.

This is called **Constructor Chaining**.

---

### Parameterized Constructor

```java
Employee e1 = new Employee(
    93,
    "Anv",
    42434.00,
    "IT"
);
```

Directly calls:

```java
Employee(int id, String name, double salary, String department)
```

---

# Understanding `this`

```java
this.id = id;
```

Here:

```text
this.id
   ↓
Instance variable of current Employee object

id
   ↓
Constructor parameter
```

Similarly:

```java
this.name = name;
this.salary = salary;
this.department = department;
```

---

# What You Learned

- Default Constructor
- Parameterized Constructor
- Constructor Chaining
- Object Initialization
- `this` Keyword
- Cleaner Object Creation
- Constructor execution during `new`

---

# Challenge

Explain:

### 1. Which constructor is called?

```java
Employee e0 = new Employee();
```

**Answer:** Default Constructor.

---

### 2. Which constructor is called?

```java
Employee e1 = new Employee(
    93,
    "Anv",
    42434.00,
    "IT"
);
```

**Answer:** Parameterized Constructor.

---

### 3. Why use constructors?

Instead of:

```java
Employee e1 = new Employee();

e1.id = 93;
e1.name = "Anv";
e1.salary = 42434.00;
e1.department = "IT";
```

We can write:

```java
Employee e1 = new Employee(
    93,
    "Anv",
    42434.00,
    "IT"
);
```

The object is initialized immediately during creation.

---

# Success Checklist

- [x] Created `Employee` class.
- [x] Added all required fields.
- [x] Created Default Constructor.
- [x] Created Parameterized Constructor.
- [x] Used Constructor Chaining.
- [x] Created 5 parameterized Employee objects.
- [x] Created 1 default Employee object.
- [x] Printed all 6 Employee objects.
- [x] Used `this` correctly.
- [x] Understood constructor-based initialization.

---

# Next Practice

➡ **P6 - Amazon Product Management**