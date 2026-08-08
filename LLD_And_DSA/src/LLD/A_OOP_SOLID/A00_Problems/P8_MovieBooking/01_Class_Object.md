# P8 - Movie Booking

## Objective

Practice creating objects and assigning values manually using **Class & Object**.

---

# Prerequisites

* Class
* Object

---

# Problem Statement

Create a `Movie` class with the following fields:

* movieName
* duration
* language
* rating

Create **5 Movie objects**, assign values manually, and print their details.

---

# Requirements

* Create a `Movie` class.
* Create **5 Movie objects**.
* Assign values manually.
* Print all movie details.

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

}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Main {

    public static void main(String[] args) {

        Movie m1 = new Movie();
        m1.movieName = "Animal";
        m1.duration = "3 hr";
        m1.language = "Hindi";
        m1.rating = 4.6;

        Movie m2 = new Movie();
        m2.movieName = "Dhurandhar";
        m2.duration = "3.4 hr";
        m2.language = "Hindi";
        m2.rating = 4.3;

        Movie m3 = new Movie();
        m3.movieName = "Avengers Endgame";
        m3.duration = "3 hr";
        m3.language = "English";
        m3.rating = 5.0;

        Movie m4 = new Movie();
        m4.movieName = "Avatar";
        m4.duration = "3.2 hr";
        m4.language = "Hindi";
        m4.rating = 5.0;

        Movie m5 = new Movie();
        m5.movieName = "Inception";
        m5.duration = "3 hr";
        m5.language = "English";
        m5.rating = 4.9;

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

# Memory Representation

```text
                Stack Memory

        m1 ──────────────┐
        m2 ───────────┐  │
        m3 ────────┐  │  │
        m4 ─────┐  │  │  │
        m5 ──┐  │  │  │  │
             │  │  │  │  │
             ▼  ▼  ▼  ▼  ▼

                Heap Memory

        Movie Object 1

        movieName = "Animal"
        duration  = "3 hr"
        language  = "Hindi"
        rating    = 4.6

        ----------------------------

        Movie Object 2

        movieName = "Dhurandhar"
        duration  = "3.4 hr"
        language  = "Hindi"
        rating    = 4.3

        ----------------------------

        Movie Object 3

        movieName = "Avengers Endgame"
        duration  = "3 hr"
        language  = "English"
        rating    = 5.0

        ----------------------------

        Movie Object 4

        movieName = "Avatar"
        duration  = "3.2 hr"
        language  = "Hindi"
        rating    = 5.0

        ----------------------------

        Movie Object 5

        movieName = "Inception"
        duration  = "3 hr"
        language  = "English"
        rating    = 4.9
```

---

# What You Learned

* A Class is a blueprint.
* An Object is an instance of a class.
* `new` creates an object.
* Objects are stored in Heap Memory.
* Reference variables are stored in Stack Memory.
* Every object has its own independent state.
* One class can create multiple objects.

---

# Interview Question

### Why is every movie an object?

A `Movie` is a real-world entity with its own properties:

```text
movieName
duration
language
rating
```

The `Movie` class acts as a blueprint.

Every time:

```java
new Movie()
```

is executed, a separate `Movie` object is created.

Therefore, each movie can have its own values.

---

# Success Checklist

* [x] Created `Movie` class.
* [x] Added all required fields.
* [x] Created 5 Movie objects.
* [x] Assigned values manually.
* [x] Printed all movie details.
* [x] Understood Stack and Heap Memory.
* [x] Understood object independence.
* [x] Understood why each movie is an object.

---

# Next Upgrade

In **02_Constructors.md**, replace manual assignments with constructors.

### Before

```java
Movie m1 = new Movie();

m1.movieName = "Animal";
m1.duration = "3 hr";
m1.language = "Hindi";
m1.rating = 4.6;
```

### After

```java
Movie m1 = new Movie(
    "Animal",
    "3 hr",
    "Hindi",
    4.6
);
```

**P8 Class & Object → ✅ DONE**
