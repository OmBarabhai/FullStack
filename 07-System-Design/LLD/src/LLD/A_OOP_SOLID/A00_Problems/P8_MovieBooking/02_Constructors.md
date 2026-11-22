# P8 - Movie Booking — Constructors

## Objective

Upgrade the Movie Booking project by using **Constructors** to initialize objects instead of assigning values manually.

---

# Prerequisites

- Class
- Object
- Object Creation
- Constructors

---

# Requirements

Modify the existing `Movie` class.

## Fields

- movieName
- duration
- language
- rating

---

# Tasks

## Task 1

Create a **Default Constructor**.

---

## Task 2

Create a **Parameterized Constructor**.

The constructor should initialize:

- movieName
- duration
- language
- rating

---

## Task 3

Create **5 Movie objects** using the Parameterized Constructor.

---

## Task 4

Create **1 Movie object** using the Default Constructor.

---

## Task 5

Print all movie details.

---

# Solution

## Movie.java

```java
package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Movie {

    String movieName;
    String duration;
    String language;
    double rating;

    // Default Constructor
    Movie() {
        this("Unknown", "Unknown", "Unknown", 0.0);
    }

    // Parameterized Constructor
    Movie(String movieName, String duration,
          String language, double rating) {

        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
        this.rating = rating;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Main {

    public static void main(String[] args) {

        // Default Constructor
        Movie m0 = new Movie();

        // Parameterized Constructor
        Movie m1 = new Movie(
                "Animal",
                "3 hr",
                "Hindi",
                4.6
        );

        Movie m2 = new Movie(
                "Dhurandhar",
                "3.4 hr",
                "Hindi",
                4.3
        );

        Movie m3 = new Movie(
                "Avengers Endgame",
                "3 hr",
                "English",
                5.0
        );

        Movie m4 = new Movie(
                "Avatar",
                "3.2 hr",
                "Hindi",
                5.0
        );

        Movie m5 = new Movie(
                "Inception",
                "3 hr",
                "English",
                4.9
        );

        System.out.println(
                m0.movieName + " " +
                m0.duration + " " +
                m0.language + " " +
                m0.rating
        );

        System.out.println(
                m1.movieName + " " +
                m1.duration + " " +
                m1.language + " " +
                m1.rating
        );

        System.out.println(
                m2.movieName + " " +
                m2.duration + " " +
                m2.language + " " +
                m2.rating
        );

        System.out.println(
                m3.movieName + " " +
                m3.duration + " " +
                m3.language + " " +
                m3.rating
        );

        System.out.println(
                m4.movieName + " " +
                m4.duration + " " +
                m4.language + " " +
                m4.rating
        );

        System.out.println(
                m5.movieName + " " +
                m5.duration + " " +
                m5.language + " " +
                m5.rating
        );
    }
}
```

---

# Constructor Flow

## Default Constructor

```java
Movie m0 = new Movie();
```

Flow:

```text
new Movie()
     ↓
Default Constructor
     ↓
this("Unknown", "Unknown", "Unknown", 0.0)
     ↓
Parameterized Constructor
```

This is called **Constructor Chaining**.

---

## Parameterized Constructor

```java
Movie m1 = new Movie(
    "Animal",
    "3 hr",
    "Hindi",
    4.6
);
```

Directly calls:

```java
Movie(
    String movieName,
    String duration,
    String language,
    double rating
)
```

---

# Understanding `this`

```java
this.movieName = movieName;
```

Here:

```text
this.movieName
      ↓
Current Movie object's instance variable

movieName
      ↓
Constructor parameter
```

Similarly:

```java
this.duration = duration;
this.language = language;
this.rating = rating;
```

---

# Challenge Answers

### 1. Which constructor is called?

```java
Movie m0 = new Movie();
```

**Default Constructor**

---

### 2. Which constructor is called?

```java
Movie m1 = new Movie(
    "Animal",
    "3 hr",
    "Hindi",
    4.6
);
```

**Parameterized Constructor**

---

### 3. Why is the constructor approach preferred?

Before:

```java
Movie m1 = new Movie();

m1.movieName = "Animal";
m1.duration = "3 hr";
m1.language = "Hindi";
m1.rating = 4.6;
```

After:

```java
Movie m1 = new Movie(
    "Animal",
    "3 hr",
    "Hindi",
    4.6
);
```

The object is initialized directly when it is created.

---

### 4. What does `this` mean?

`this` refers to the **current Movie object**.

```java
this.movieName = movieName;
```

means:

```text
current object's movieName = constructor's movieName
```

---

### 5. Why can the Default Constructor call the Parameterized Constructor?

Because Java allows one constructor to call another constructor using:

```java
this(...)
```

Example:

```java
Movie() {
    this("Unknown", "Unknown", "Unknown", 0.0);
}
```

This avoids duplicating initialization logic.

---

# What You Learned

- Default Constructor
- Parameterized Constructor
- Constructor Overloading
- Constructor Chaining
- `this` Keyword
- Object Initialization
- Cleaner Object Creation

---

# Success Checklist

- [x] Created `Movie` class.
- [x] Added all required fields.
- [x] Created Default Constructor.
- [x] Created Parameterized Constructor.
- [x] Created 5 Movie objects using Parameterized Constructor.
- [x] Created 1 Movie object using Default Constructor.
- [x] Printed all 6 Movie objects.
- [x] Used `this` correctly.
- [x] Used Constructor Chaining.
- [x] Understood constructor-based initialization.

---

# Before vs After

### Before — Class & Object

```java
Movie m1 = new Movie();

m1.movieName = "Animal";
m1.duration = "3 hr";
m1.language = "Hindi";
m1.rating = 4.6;
```

### After — Constructor

```java
Movie m1 = new Movie(
    "Animal",
    "3 hr",
    "Hindi",
    4.6
);
```

---

# Next Practice

➡ **P9 - Car Rental — Class & Object**