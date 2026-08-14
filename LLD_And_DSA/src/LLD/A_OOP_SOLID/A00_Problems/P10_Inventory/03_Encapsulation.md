# P10 — Inventory Encapsulation — Solution

## Objective

Protect inventory item information using **Encapsulation**.

The `Items` fields are private, and controlled access is provided through `setItems()` and Getters.

---

# Fields

```java
private int itemId;
private String itemName;
private int quantity;
private double price;
```

---

# Solution

## Items.java

```java
package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;

public class Items {

    private int itemId;
    private String itemName;
    private int quantity;
    private double price;

    public void setItems(int itemId, String itemName, int quantity, double price) {

        this.itemId = itemId;

        if (quantity >= 0) {
            this.quantity = quantity;
        }

        if (price > 0) {
            this.price = price;
        }

        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;

public class Main {

    public static void main(String[] args) {

        Items i = new Items();

        i.setItems(
                101,
                "Keyboard",
                50,
                999.99
        );

        System.out.println(i.getItemId());
        System.out.println(i.getItemName());
        System.out.println(i.getQuantity());
        System.out.println(i.getPrice());
    }
}
```

---

# Expected Output

```text
101
Keyboard
50
999.99
```

---

# Encapsulation Applied

The fields are private:

```java
private int itemId;
private String itemName;
private int quantity;
private double price;
```

Therefore, direct access from `Main` is blocked:

```java
i.itemId = 101;       // ❌
i.quantity = 50;     // ❌
i.price = 999.99;    // ❌
```

Instead, controlled modification is done through:

```java
i.setItems(
        101,
        "Keyboard",
        50,
        999.99
);
```

And the values are read using:

```java
i.getItemId();
i.getItemName();
i.getQuantity();
i.getPrice();
```

---

# Quantity Validation

Quantity must satisfy:

```text
quantity >= 0
```

The validation is:

```java
if (quantity >= 0) {
    this.quantity = quantity;
}
```

Therefore:

```java
i.setItems(101, "Keyboard", -10, 999.99);
```

will not store `-10` as the quantity.

---

# Price Validation

Price must satisfy:

```text
price > 0
```

The validation is:

```java
if (price > 0) {
    this.price = price;
}
```

Therefore:

```java
i.setItems(101, "Keyboard", 50, -500);
```

will not store `-500` as the price.

---

# Role of `this`

Example:

```java
this.itemName = itemName;
```

means:

```text
this.itemName
    ↓
current object's field

itemName
    ↓
method parameter
```

So:

```text
current Items object's itemName
        =
parameter itemName
```

The same applies to:

```java
this.itemId = itemId;
this.quantity = quantity;
this.price = price;
```

---

# Getter Flow

Example:

```java
System.out.println(i.getQuantity());
```

Flow:

```text
Main
 ↓
getQuantity()
 ↓
private quantity
 ↓
return value
```

The same idea applies to:

```text
getItemId()
getItemName()
getPrice()
```

---

# Important Observation

This solution uses:

```java
setItems(...)
```

instead of separate setters such as:

```text
setItemId()
setItemName()
setQuantity()
setPrice()
```

`setItems()` is a **custom method that modifies multiple private fields together** and validates the numeric values.

That is acceptable for this practice because the main goal is controlled access to the object's state.

---

# What You Learned

- `private` hides inventory data.
- `setItems()` provides controlled modification.
- Getters provide controlled read access.
- Quantity validation prevents negative stock values.
- Price validation prevents invalid negative prices.
- `this` refers to the current object's fields.
- Direct field access from `Main` is blocked.

---

# Success Checklist

- [x] Made all Items fields `private`.
- [x] Created `setItems()`.
- [x] Created `getItemId()`.
- [x] Created `getItemName()`.
- [x] Created `getQuantity()`.
- [x] Created `getPrice()`.
- [x] Used `this`.
- [x] Added quantity validation.
- [x] Added price validation.
- [x] Created an Items object.
- [x] Used controlled access.
- [x] Printed data using Getters.

---

# Status

**P10 — Inventory Encapsulation → ✅ DONE**

---

# Encapsulation Practice Complete

```text
P1 Student       ✅
P2 Bank          ✅
P3 Library       ✅
P4 Hospital      ✅
P5 Employee      ✅
P6 Amazon        ✅
P7 College       ✅
P8 Movie Booking ✅
P9 Car Rental    ✅
P10 Inventory    ✅
```

**Part 3 — Encapsulation Practice Problems → ✅ COMPLETE**

---

# Next Part

➡️ **Part 4 — Advanced Encapsulation**
