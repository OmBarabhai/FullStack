# P4 — Hospital Encapsulation — Solution

## Objective

Protect patient information using **Encapsulation**.

The `Patient` fields are private, and the object is modified through a controlled method.

---

# Fields

```java
private int patientId;
private String name;
private int age;
private String disease;
```

All fields are `private`.

---

# Tasks Completed

- Made all patient fields `private`.
- Created a custom `setPatient()` method.
- Used `this` to initialize the object fields.
- Added age validation.
- Created Getters for all fields.
- Created a `Patient` object.
- Initialized patient data using `setPatient()`.
- Read patient data using Getters.

---

# Solution

## Patient.java

```java
package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String disease;

    public void setPatient(int patientId, String name, int age, String disease) {

        if (age >= 0) {
            this.age = age;
        }

        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDisease() {
        return disease;
    }
}
```

---

## Main.java

```java
package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Main {

    public static void main(String[] args) {

        Patient p = new Patient();

        p.setPatient(32, "Kim", 35, "Headache");

        System.out.println(p.getAge());
        System.out.println(p.getPatientId());
        System.out.println(p.getName());
        System.out.println(p.getDisease());
    }
}
```

---

# Expected Output

```text
35
32
Kim
Headache
```

---

# How Encapsulation Is Applied

Before Encapsulation, patient fields could be accessed directly:

```java
Patient p = new Patient();

p.patientId = 32;
p.name = "Kim";
p.age = 35;
p.disease = "Headache";
```

After Encapsulation, the fields are hidden:

```java
private int patientId;
private String name;
private int age;
private String disease;
```

The object is modified through:

```java
p.setPatient(32, "Kim", 35, "Headache");
```

And read using:

```java
p.getPatientId();
p.getName();
p.getAge();
p.getDisease();
```

---

# Age Validation

The `setPatient()` method validates age:

```java
if (age >= 0) {
    this.age = age;
}
```

Therefore:

```java
p.setPatient(32, "Kim", 35, "Headache");
```

stores:

```text
age = 35
```

But:

```java
p.setPatient(32, "Kim", -5, "Headache");
```

will not update the age field.

The validation protects the object's state.

---

# Getter Flow

Example:

```java
System.out.println(p.getName());
```

Flow:

```text
Main
 ↓
getName()
 ↓
private name
 ↓
return value
```

The same applies to:

```text
getPatientId()
getAge()
getDisease()
```

---

# Setter-Style Method

This problem uses:

```java
setPatient()
```

instead of separate methods such as:

```text
setPatientId()
setName()
setAge()
setDisease()
```

`setPatient()` updates multiple fields together and validates the age while doing so.

It is a **custom controlled modification method** rather than a standard one-field Setter.

---

# Role of `this`

For example:

```java
this.patientId = patientId;
```

Here:

```text
this.patientId
    ↓
current object's field

patientId
    ↓
method parameter
```

So:

```java
this.patientId = patientId;
```

means:

```text
current Patient object's patientId = parameter patientId
```

The same idea applies to:

```java
this.name = name;
this.age = age;
this.disease = disease;
```

---

# Why Direct Access Is Not Allowed

Because the fields are:

```java
private
```

This is not allowed from `Main`:

```java
p.age = -10;
```

Instead:

```java
p.setPatient(...);
```

allows the `Patient` class to validate the data before changing its state.

---

# Encapsulation Flow

```text
private fields
      ↓
setPatient()
      ↓
validation
      ↓
object state updated
      ↓
Getters
      ↓
read data
```

---

# Interview Questions

### Q1. Why are Patient fields private?

To prevent direct access to the object's internal data.

### Q2. Why use `setPatient()`?

It provides controlled modification of the Patient object's fields.

### Q3. Why is age validated?

To prevent an invalid negative age from being stored.

### Q4. Why do we use `this.age = age`?

`this.age` refers to the current object's field, while `age` refers to the method parameter.

### Q5. Is `setPatient()` a standard Setter?

No. It is a custom method that modifies multiple private fields at once.

---

# What You Learned

- `private` hides patient data.
- `setPatient()` provides controlled modification.
- Getters provide controlled read access.
- Validation protects the patient's state.
- `this` distinguishes instance variables from parameters.
- Encapsulation prevents direct field access.

---

# Success Checklist

- [x] Made all Patient fields `private`.
- [x] Created `setPatient()`.
- [x] Created `getPatientId()`.
- [x] Created `getName()`.
- [x] Created `getAge()`.
- [x] Created `getDisease()`.
- [x] Used `this`.
- [x] Added age validation.
- [x] Created a Patient object.
- [x] Initialized patient data through a controlled method.
- [x] Printed data using Getters.
- [x] Understood data hiding and controlled access.

---

# Status

**P4 — Hospital Encapsulation → ✅ DONE**

---

# Next Practice

➡️ **P5 — Employee Encapsulation**
