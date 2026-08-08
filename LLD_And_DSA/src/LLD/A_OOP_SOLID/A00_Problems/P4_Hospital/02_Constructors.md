# P4 - Hospital Management

## Objective

Upgrade the Hospital Management project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Requirements

Modify the existing `Patient` class.

## Fields

- patientId
- name
- age
- disease

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

- patientId
- name
- age
- disease

---

## Task 3

Use **Constructor Chaining** by calling the Parameterized Constructor from the Default Constructor.

---

## Task 4

Create **4 Patient objects** using the Parameterized Constructor.

---

## Task 5

Create **1 Patient object** using the Default Constructor.

---

## Task 6

Print all patient details.

---

# Expected Learning

After completing this practice, you should understand:

- Default Constructor
- Parameterized Constructor
- Constructor Chaining
- Object Initialization
- Constructor Execution
- `this` Keyword
- Cleaner Object Creation

---

# Solution

## Patient.java

```java
package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Patient {

    int patientId;
    String name;
    int age;
    String disease;

    // Default Constructor
    Patient() {
        this(0, "Unknown", 0, "Unknown");
    }

    // Parameterized Constructor
    Patient(int patientId, String name, int age, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Main {

    public static void main(String[] args) {

        // Default Constructor
        Patient p0 = new Patient();

        // Parameterized Constructor
        Patient p1 = new Patient(
                32,
                "Kim",
                35,
                "Headache"
        );

        Patient p2 = new Patient(
                33,
                "John",
                42,
                "Fever"
        );

        Patient p3 = new Patient(
                34,
                "Sara",
                28,
                "Cold"
        );

        Patient p4 = new Patient(
                35,
                "Rahul",
                31,
                "Fracture"
        );

        System.out.println(
                p0.patientId + " " +
                p0.name + " " +
                p0.age + " " +
                p0.disease
        );

        System.out.println(
                p1.patientId + " " +
                p1.name + " " +
                p1.age + " " +
                p1.disease
        );

        System.out.println(
                p2.patientId + " " +
                p2.name + " " +
                p2.age + " " +
                p2.disease
        );

        System.out.println(
                p3.patientId + " " +
                p3.name + " " +
                p3.age + " " +
                p3.disease
        );

        System.out.println(
                p4.patientId + " " +
                p4.name + " " +
                p4.age + " " +
                p4.disease
        );
    }
}
```

---

# Challenge

Explain the difference between:

```java
Patient p0 = new Patient();
```

and

```java
Patient p1 = new Patient(
    32,
    "Kim",
    35,
    "Headache"
);
```

### `Patient p0 = new Patient();`

Calls the **Default Constructor**.

```java
Patient() {
    this(0, "Unknown", 0, "Unknown");
}
```

The Default Constructor then calls the Parameterized Constructor.

This is called **Constructor Chaining**.

---

### `Patient p1 = new Patient(...);`

Directly calls the **Parameterized Constructor**.

The supplied values are used to initialize the object's fields.

---

# What is Constructor Chaining?

Constructor Chaining means one constructor calls another constructor in the same class.

Example:

```java
Patient() {
    this(0, "Unknown", 0, "Unknown");
}
```

Here:

```java
this(...)
```

calls the Parameterized Constructor.

---

# What does `this` mean?

In:

```java
this.patientId = patientId;
```

- `this.patientId` → instance variable of the current object.
- `patientId` → constructor parameter.

Similarly:

```java
this.name = name;
this.age = age;
this.disease = disease;
```

initialize the current object's fields.

---

# Upgrade

### Before — Class & Object

```java
Patient p1 = new Patient();

p1.patientId = 32;
p1.name = "Kim";
p1.age = 35;
p1.disease = "Headache";
```

### After — Constructors

```java
Patient p1 = new Patient(
    32,
    "Kim",
    35,
    "Headache"
);
```

---

# Success Checklist

- [x] Created `Patient` class.
- [x] Added all required fields.
- [x] Created a Default Constructor.
- [x] Created a Parameterized Constructor.
- [x] Used Constructor Chaining.
- [x] Created 4 Patient objects using the Parameterized Constructor.
- [x] Created 1 Patient object using the Default Constructor.
- [x] Printed all patient details.
- [x] Used `this` correctly.
- [x] Understood constructor-based initialization.

---

# Key Takeaways

- Constructors initialize objects during object creation.
- A Default Constructor can call a Parameterized Constructor.
- `this(...)` is used for Constructor Chaining.
- `this.field` refers to the current object's instance variable.
- Parameterized Constructors reduce repetitive assignments.
- Constructors make object creation cleaner.

---

# Next Practice

➡ **P5 - Employee Management**