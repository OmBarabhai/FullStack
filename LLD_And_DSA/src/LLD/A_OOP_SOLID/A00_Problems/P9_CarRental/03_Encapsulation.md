# P9 — Car Rental Encapsulation — Solution

## Objective

Protect rental car information using **Encapsulation**.

The `Car` fields are private, and controlled access is provided through a method for setting the data and Getters for reading it.

---

# Fields

```java
private String brand;
private String model;
private String color;
private double rentPerDay;
```

---

# Solution

## Car.java

```java
package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Car {

    private String brand;
    private String model;
    private String color;
    private double rentPerDay;

    public void getCar(
            String brand,
            String model,
            String color,
            double rentPerDay
    ) {
        this.brand = brand;
        this.model = model;
        this.color = color;

        if (rentPerDay > 0) {
            this.rentPerDay = rentPerDay;
        }
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Main {

    public static void main(String[] args) {

        Car c = new Car();

        c.getCar(
                "Toyota",
                "Fortuner",
                "Black",
                12200
        );

        System.out.println(c.getRentPerDay());
        System.out.println(c.getColor());
        System.out.println(c.getModel());
        System.out.println(c.getBrand());
    }
}
```

---

# Expected Output

```text
12200.0
Black
Fortuner
Toyota
```

---

# Encapsulation Applied

The fields are:

```java
private String brand;
private String model;
private String color;
private double rentPerDay;
```

Therefore, direct access from `Main` is blocked:

```java
c.brand = "Toyota";   // ❌
c.model = "Fortuner"; // ❌
```

Instead, controlled access is used:

```java
c.getCar("Toyota", "Fortuner", "Black", 12200);
```

And values are read using:

```java
c.getBrand();
c.getModel();
c.getColor();
c.getRentPerDay();
```

---

# Rent Validation

The rent is only updated when:

```java
rentPerDay > 0
```

```java
if (rentPerDay > 0) {
    this.rentPerDay = rentPerDay;
}
```

So an invalid value such as:

```java
c.getCar("Toyota", "Fortuner", "Black", -5000);
```

will not store `-5000` as the rent.

---

# Role of `this`

Example:

```java
this.brand = brand;
```

means:

```text
this.brand
    ↓
current Car object's field

brand
    ↓
method parameter
```

So:

```text
current object's brand = parameter brand
```

---

# Getter Flow

```text
Main
 ↓
getBrand()
 ↓
private brand
 ↓
return value
```

The same applies to:

```text
getModel()
getColor()
getRentPerDay()
```

---

# Important Note

Your method is currently named:

```java
getCar(...)
```

Although it is modifying the object.

A more conventional name would be:

```java
setCar(...)
```

But your current implementation still demonstrates the Encapsulation concept correctly.

---

# What You Learned

* `private` hides Car data.
* Controlled methods modify the object.
* Getters provide read access.
* Validation protects `rentPerDay`.
* `this` refers to the current object's fields.
* Direct field access from `Main` is blocked.

---

# Success Checklist

* [x] Made all Car fields `private`.
* [x] Created controlled modification method.
* [x] Created Getters.
* [x] Used `this`.
* [x] Added rent validation.
* [x] Created a Car object.
* [x] Used Getters to read data.
* [x] Understood direct field access is blocked.

---

# Status

**P9 — Car Rental Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P10 — Inventory Encapsulation**
