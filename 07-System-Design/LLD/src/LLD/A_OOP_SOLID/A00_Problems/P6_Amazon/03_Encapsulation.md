# P6 — Amazon Encapsulation — Solution

## Objective

Protect product information using **Encapsulation**.

The `Product` fields are private, and controlled access is provided through `setProduct()` and Getters.

---

# Fields

```java
private int productId;
private String productName;
private double price;
private String category;
```

---

# Solution

## Product.java

```java
package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private String category;

    public void setProduct(int productId, String productName, double price, String category) {

        if (price > 0) {
            this.price = price;
        }

        this.productId = productId;
        this.category = category;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C6_Amazon;

public class Main {

    public static void main(String[] args) {

        Product p = new Product();

        p.setProduct(
                123,
                "iPhone",
                122232.22,
                "Mobile"
        );

        System.out.println(p.getPrice());
        System.out.println(p.getProductName());
        System.out.println(p.getCategory());
        System.out.println(p.getProductId());
    }
}
```

---

# Expected Output

```text
122232.22
iPhone
Mobile
123
```

---

# Encapsulation Applied

Previously, product fields could be accessed directly:

```java
p.productId = 123;
p.productName = "iPhone";
p.price = 122232.22;
p.category = "Mobile";
```

Now the fields are:

```java
private
```

and outside code uses:

```java
p.setProduct(...);
```

to modify the object's state.

---

# Price Validation

Inside `setProduct()`:

```java
if (price > 0) {
    this.price = price;
}
```

Therefore:

```java
p.setProduct(123, "iPhone", -500, "Mobile");
```

does not store `-500` as the price.

The class controls the data before updating the field.

---

# Getter Flow

```text
Main
 ↓
getPrice()
 ↓
private price
 ↓
return price
```

Similarly:

```text
getProductId()
getProductName()
getCategory()
```

provide controlled read access.

---

# `this` Keyword

For example:

```java
this.productName = productName;
```

means:

```text
this.productName
    ↓
current object's field

productName
    ↓
method parameter
```

So:

```text
current Product object's productName
        =
method parameter productName
```

---

# Important Observation

This solution uses:

```java
setProduct(...)
```

instead of separate:

```text
setProductId()
setProductName()
setPrice()
setCategory()
```

`setProduct()` is a **custom method that modifies multiple private fields together**.

This is acceptable for this practice because the important concept is **controlled access to private state**.

---

# What You Learned

* `private` hides Product data.
* `setProduct()` provides controlled modification.
* Getters provide controlled read access.
* `this` refers to the current object's fields.
* Price validation protects the object's state.
* Direct field access is prevented.

---

# Success Checklist

* [x] Made all Product fields `private`.
* [x] Created `setProduct()`.
* [x] Created `getProductId()`.
* [x] Created `getProductName()`.
* [x] Created `getPrice()`.
* [x] Created `getCategory()`.
* [x] Used `this`.
* [x] Added price validation.
* [x] Created a Product object.
* [x] Used controlled access.
* [x] Printed data using Getters.

---

# Status

**P6 — Amazon Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P7 — College Encapsulation**
