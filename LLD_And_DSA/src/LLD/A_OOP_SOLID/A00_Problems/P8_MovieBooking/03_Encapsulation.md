# P8 — Movie Booking Encapsulation — Solution

## Objective

Protect movie information using **Encapsulation**.

The `Movie` fields are private, and controlled access is provided through `setMovie()` and Getters.

---

# Fields

```java
private String movieName;
private String duration;
private String language;
private double rating;
```

---

# Solution

## Movie.java

```java
package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Movie {

    private String movieName;
    private String duration;
    private String language;
    private double rating;

    public void setMovie(
            String movieName,
            String duration,
            String language,
            double rating
    ) {
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;

        if (0 <= rating && rating <= 5.0) {
            this.rating = rating;
        }
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public double getRating() {
        return rating;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C8_MovieBooking;

public class Main {

    public static void main(String[] args) {

        Movie m = new Movie();

        m.setMovie(
                "Animal",
                "3 hr",
                "Hindi",
                4.6
        );

        System.out.println(m.getDuration());
        System.out.println(m.getMovieName());
        System.out.println(m.getLanguage());
        System.out.println(m.getRating());
    }
}
```

---

# Expected Output

```text
3 hr
Animal
Hindi
4.6
```

---

# Rating Validation

The rating is accepted only when:

```text
0 <= rating <= 5
```

This code performs the validation:

```java
if (0 <= rating && rating <= 5.0) {
    this.rating = rating;
}
```

Therefore:

```java
m.setMovie("Animal", "3 hr", "Hindi", 4.6);
```

is valid.

But:

```java
m.setMovie("Animal", "3 hr", "Hindi", 6.5);
```

will not update the rating.

---

# Encapsulation Applied

The fields are:

```java
private
```

so they are protected from direct access.

Instead of:

```java
m.movieName = "Animal";
m.rating = 4.6;
```

we use:

```java
m.setMovie("Animal", "3 hr", "Hindi", 4.6);
```

To read the data:

```java
m.getMovieName();
m.getDuration();
m.getLanguage();
m.getRating();
```

---

# Role of `this`

For example:

```java
this.movieName = movieName;
```

means:

```text
this.movieName
    ↓
current object's field

movieName
    ↓
method parameter
```

So:

```text
current Movie object's movieName
        =
parameter movieName
```

---

# Getter Flow

```text
Main
 ↓
getMovieName()
 ↓
private movieName
 ↓
return value
```

The same applies to:

```text
getDuration()
getLanguage()
getRating()
```

---

# Why Use `setMovie()`?

Instead of directly modifying four fields, the object provides one controlled method:

```java
setMovie(...)
```

This method:

* updates the movie details
* validates the rating
* protects the private fields

---

# Interview Questions

### Q1. Why are Movie fields private?

To prevent direct access to the object's internal data.

### Q2. How do we read private Movie data?

Using Getters.

### Q3. Why is rating validated?

To prevent invalid ratings outside the allowed range `0–5`.

### Q4. Why use `this.rating = rating`?

`this.rating` refers to the current object's field, while `rating` refers to the method parameter.

### Q5. What does Encapsulation provide here?

It provides **controlled access and validation** for the Movie object's state.

---

# Success Checklist

* [x] Made all Movie fields `private`.
* [x] Created `setMovie()`.
* [x] Created `getMovieName()`.
* [x] Created `getDuration()`.
* [x] Created `getLanguage()`.
* [x] Created `getRating()`.
* [x] Used `this`.
* [x] Added rating validation.
* [x] Created a Movie object.
* [x] Used controlled access.
* [x] Printed data using Getters.

---

# Status

**P8 — Movie Booking Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P9 — Car Rental Encapsulation**
