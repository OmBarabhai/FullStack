# P9 - Car Rental — Constructors

## Objective

Upgrade the Car Rental project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation
- Constructors
- Parameterized Constructor
- `this` Keyword

---

# Requirements

Modify the existing `Car` class.

## Fields

- brand
- model
- color
- rentPerDay

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

- brand
- model
- color
- rentPerDay

---

## Task 3

Create **4 Car objects** using the Parameterized Constructor.

---

## Task 4

Create **1 Car object** using the Default Constructor.

---

## Task 5

Print all car details.

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

    Car() {
        this("Unknown", "Unknown", "Unknown", 0.0);
    }

    Car(String brand, String model, String color, double rentPerDay) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.rentPerDay = rentPerDay;
    }
}