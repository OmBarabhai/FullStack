# P4 - Hospital Management

## Objective

Practice creating objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object

---

# Problem Statement

Create a `Patient` class with the following fields:

- patientId
- name
- age
- disease

Create **4 Patient objects**, assign values manually, and print their details.

---

# Requirements

- Create a `Patient` class.
- Create **4 Patient objects**.
- Assign values manually.
- Print all patient details.

---

# Solution

## Patient.java

```java
public class Patient {

    int patientId;
    String name;
    int age;
    String disease;

}
````

---

## Main.java

```java
Patient p1 = new Patient();
p1.patientId = 32;
p1.name = "Kim";
p1.age = 35;
p1.disease = "Headache";

Patient p2 = new Patient();
p2.patientId = 33;
p2.name = "John";
p2.age = 42;
p2.disease = "Fever";

Patient p3 = new Patient();
p3.patientId = 34;
p3.name = "Sara";
p3.age = 28;
p3.disease = "Cold";

Patient p4 = new Patient();
p4.patientId = 35;
p4.name = "Rahul";
p4.age = 31;
p4.disease = "Fracture";

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
```

---

# Memory Representation

```text
                Stack Memory

        p1 ──────────────┐
        p2 ───────────┐  │
        p3 ────────┐  │  │
        p4 ─────┐  │  │  │
                │  │  │  │
                ▼  ▼  ▼  ▼

                Heap Memory

        Patient Object 1

        patientId = 32
        name      = "Kim"
        age       = 35
        disease   = "Headache"

        ----------------------------

        Patient Object 2

        patientId = 33
        name      = "John"
        age       = 42
        disease   = "Fever"

        ----------------------------

        Patient Object 3

        patientId = 34
        name      = "Sara"
        age       = 28
        disease   = "Cold"

        ----------------------------

        Patient Object 4

        patientId = 35
        name      = "Rahul"
        age       = 31
        disease   = "Fracture"
```

---

# What You Learned

* A Class is a blueprint.
* An Object is an instance of a class.
* The `new` keyword creates an object.
* Objects are stored in Heap Memory.
* Reference variables are stored in Stack Memory.
* Every object stores its own independent data.

---

# Interview Question

### Can every Patient object store different values?

Yes.

Every time `new Patient()` is executed, Java creates a new object in Heap Memory.

Each object has its own memory location and stores its own data independently.

Therefore, changing one Patient object's data does not affect another object.

---

# Success Checklist

* Created a Patient class.
* Created 4 Patient objects.
* Assigned values manually.
* Printed all patient details.
* Understood Stack and Heap Memory.
* Understood object independence.

---

# Next Upgrade

In **02_Constructors.md**, you'll replace manual assignments with constructors.

### Before

```java
Patient p1 = new Patient();

p1.patientId = 32;
p1.name = "Kim";
p1.age = 35;
p1.disease = "Headache";
```

### After

```java
Patient p1 = new Patient(
        32,
        "Kim",
        35,
        "Headache"
);
```

