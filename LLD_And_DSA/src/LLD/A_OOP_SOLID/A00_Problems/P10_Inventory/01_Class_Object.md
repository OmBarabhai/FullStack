# P10 - Inventory System — Class & Object

## Objective

Practice creating inventory objects and assigning values manually using **Class & Object**.

---

# Prerequisites

- Class
- Object
- Object Creation

---

# Problem Statement

Create an `Items` class representing products stored in a warehouse.

The class should contain:

- itemId
- itemName
- quantity
- price

Create **5 inventory objects**, assign values manually, and print their details.

---

# Requirements

- Create an `Items` class.
- Add all required fields.
- Create 5 `Items` objects.
- Assign values manually.
- Print all item details.
- Understand Object State.
- Understand Stack and Heap Memory.

---

# Solution

## Items.java

```java
package LLD.A_OOP_SOLID.A00_Code.C10_Inventory;

public class Items {

    int itemId;
    String itemName;
    int quantity;
    double price;

}