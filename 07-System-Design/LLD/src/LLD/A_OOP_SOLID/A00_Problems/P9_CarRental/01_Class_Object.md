# P9 - Car Rental — Class & Object

## Objective

Practice creating rental car objects and assigning values manually using **Class & Object**.

---

# Prerequisites

* Class
* Object
* Object Creation

---

# Problem Statement

Create a `Car` class with the following fields:

* brand
* model
* color
* rentPerDay

Create **4 Car objects**, assign values manually, and print their details.

---

# Requirements

* Create a `Car` class.
* Create **4 Car objects**.
* Assign values manually.
* Print all car details.

---

# Solution

## Car.java

```java
package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Car {

    String brand;
    String model;
    String color;
    double rentPerDay;

}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Main {

    public static void main(String[] args) {

        Car c1 = new Car();
        c1.brand = "Toyota";
        c1.model = "Fortuner";
        c1.color = "Black";
        c1.rentPerDay = 12200;

        Car c2 = new Car();
        c2.brand = "Land Rover";
        c2.model = "Defender";
        c2.color = "Violet";
        c2.rentPerDay = 50000;

        Car c3 = new Car();
        c3.brand = "BMW";
        c3.model = "M3";
        c3.color = "Blue";
        c3.rentPerDay = 35000;

        Car c4 = new Car();
        c4.brand = "Mercedes";
        c4.model = "G-Wagon";
        c4.color = "White";
        c4.rentPerDay = 45000;

        System.out.println(
                c1.brand + " " +
                c1.model + " " +
                c1.color + " " +
                c1.rentPerDay
        );

        System.out.println(
                c2.brand + " " +
                c2.model + " " +
                c2.color + " " +
                c2.rentPerDay
        );

        System.out.println(
                c3.brand + " " +
                c3.model + " " +
                c3.color + " " +
                c3.rentPerDay
        );

        System.out.println(
                c4.brand + " " +
                c4.model + " " +
                c4.color + " " +
                c4.rentPerDay
        );
    }
}
```

---

# Memory Representation

After:

```java
Car c1 = new Car();
Car c2 = new Car();
```

the references point to two separate objects.

```text
                Stack Memory

        +----------------------+
        | main()               |
        |                      |
        | c1 -----------+      |
        | c2 --------+  |      |
        +-------------|-|------+
                      | |
                      | |
                      ▼ ▼

                Heap Memory

        +----------------------------+
        | Car Object 1               |
        |----------------------------|
        | brand      = "Toyota"      |
        | model      = "Fortuner"    |
        | color      = "Black"       |
        | rentPerDay = 12200         |
        +----------------------------+

        +----------------------------+
        | Car Object 2               |
        |----------------------------|
        | brand      = "Land Rover"  |
        | model      = "Defender"    |
        | color      = "Violet"      |
        | rentPerDay = 50000         |
        +----------------------------+
```

---

# Explanation

### 1. `c1` and `c2`

`c1` and `c2` are **reference variables** associated with the `main()` stack frame.

### 2. `new Car()`

Every time:

```java
new Car()
```

is executed, a separate `Car` object is created.

### 3. Independent State

Each `Car` object has its own:

* `brand`
* `model`
* `color`
* `rentPerDay`

Therefore:

```java
c1.color = "Black";
```

does not change:

```java
c2.color
```

because they refer to different objects.

---

# Interview Question

### Why can two Car objects have different values even though they come from the same class?

Because the `Car` class is a **blueprint**, while each `new Car()` creates a separate object.

Each object has its own instance variables and therefore maintains its own state.

---

# What You Learned

* Class is a blueprint.
* Object is an instance of a class.
* `new` creates a new object.
* Multiple objects can be created from one class.
* Each object has independent state.
* Reference variables refer to different objects.
* Objects are created in Heap Memory.

---

# Success Checklist

* [x] Created `Car` class.
* [x] Added all required fields.
* [x] Created 4 Car objects.
* [x] Assigned different values.
* [x] Printed all car details.
* [x] Understood object independence.
* [x] Drew Stack and Heap memory.
* [x] Understood that each object has its own state.

---

# Next Upgrade

➡ **P9 - Car Rental — Constructors**

You will replace:

```java
Car c1 = new Car();

c1.brand = "Toyota";
c1.model = "Fortuner";
c1.color = "Black";
c1.rentPerDay = 12200;
```

with:

```java
Car c1 = new Car(
    "Toyota",
    "Fortuner",
    "Black",
    12200
);
```
