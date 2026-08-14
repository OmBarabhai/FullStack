# P3 — Library Encapsulation — Solution

## Objective

Protect book information using **Encapsulation**.

The `Book` fields are private, and controlled access is provided through methods.

---

# Fields

```java
private String title;
private String author;
private int price;
private String category;
```

All fields are `private`, so they cannot be accessed directly from `Main`.

---

# Tasks Completed

- Made all fields `private`.
- Created a method to initialize book data.
- Created Getters for all fields.
- Used `this` to refer to the current object's fields.
- Added price validation.
- Created a `Book` object.
- Initialized the object through `setBook()`.
- Read the data using Getters.

---

# Solution

## Book.java

```java
package LLD.A_OOP_SOLID.A00_Code.C3_Library;

public class Book {

    private String title;
    private String author;
    private int price;
    private String category;

    public void setBook(String title, String author, int price, String category) {

        this.author = author;
        this.title = title;

        if (price > 0) {
            this.price = price;
        }

        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }
}
```

---

# Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C3_Library;

public class Main {

    public static void main(String[] args) {

        Book b1 = new Book();

        b1.setBook(
                "Atomic Habits",
                "James Clear",
                550,
                "Self Help"
        );

        System.out.println(b1.getPrice());
        System.out.println(b1.getAuthor());
        System.out.println(b1.getTitle());
        System.out.println(b1.getCategory());
    }
}
```

---

# Expected Output

```text
550
James Clear
Atomic Habits
Self Help
```

---

# How Encapsulation Is Applied

Before Encapsulation, the fields could be accessed directly:

```java
b1.title = "Atomic Habits";
b1.author = "James Clear";
b1.price = 550;
b1.category = "Self Help";
```

After Encapsulation:

```java
b1.setBook(
        "Atomic Habits",
        "James Clear",
        550,
        "Self Help"
);
```

The fields remain hidden:

```text
private title
private author
private price
private category
```

---

# Getter Flow

To read the title:

```java
System.out.println(b1.getTitle());
```

Flow:

```text
Main
 ↓
getTitle()
 ↓
private title
 ↓
return value
```

The same idea applies to:

```text
getAuthor()
getPrice()
getCategory()
```

---

# Controlled Price Validation

The price is validated inside `setBook()`:

```java
if (price > 0) {
    this.price = price;
}
```

Therefore:

```java
b1.setBook(
        "Atomic Habits",
        "James Clear",
        -100,
        "Self Help"
);
```

will not store `-100` as the price.

The class controls the value before updating the field.

---

# Role of `this`

Inside:

```java
this.title = title;
```

there are two `title` values:

```text
this.title
    ↓
current object's field

title
    ↓
method parameter
```

So:

```java
this.title = title;
```

means:

```text
current object's title = parameter title
```

The same applies to:

```java
this.author = author;
this.price = price;
this.category = category;
```

---

# Important Encapsulation Concept

The object does not expose its fields directly.

Instead:

```text
private fields
      ↓
controlled methods
      ↓
Getter → READ
      ↓
setBook() → MODIFY + VALIDATE
```

This protects the internal state of the `Book` object.

---

# Interview Questions

### Q1. Why are the Book fields private?

To prevent direct access to the object's internal data.

### Q2. How do we read the private fields?

Using:

```text
getTitle()
getAuthor()
getPrice()
getCategory()
```

### Q3. Why is `price` validated?

To prevent an invalid price such as a negative value from being stored.

### Q4. Why do we use `this.title = title`?

`this.title` refers to the current object's field, while `title` refers to the method parameter.

### Q5. Is `setBook()` a normal Setter?

It is a **custom method that modifies multiple private fields at once** rather than a traditional one-field-per-setter design.

---

# What You Learned

- `private` hides the internal fields.
- Getters provide controlled read access.
- `setBook()` provides controlled modification.
- Validation can be performed before changing state.
- `this` distinguishes instance variables from parameters.
- Encapsulation protects the `Book` object's state.

---

# Success Checklist

- [x] Made all Book fields `private`.
- [x] Created controlled modification using `setBook()`.
- [x] Created Getter for `title`.
- [x] Created Getter for `author`.
- [x] Created Getter for `price`.
- [x] Created Getter for `category`.
- [x] Used `this`.
- [x] Added price validation.
- [x] Created a Book object.
- [x] Printed values through Getters.
- [x] Understood controlled access.

---

# Status

**P3 — Library Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P4 — Hospital Encapsulation**
