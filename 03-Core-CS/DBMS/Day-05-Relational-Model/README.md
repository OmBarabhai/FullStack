# 🚀 Day 05 - Relational Model + Keys + Constraints

> Core foundation of RDBMS, Keys, Constraints, Functional Dependency, and Normalization Basics

---

# 📌 What is Relational Model?

Relational model stores data in the form of tables.

Each table is called a relation.

Structure:

```text
Relation (Table)
Rows → Tuples
Columns → Attributes
```

Example:

| Student_ID | Name  | Age |
| ---------- | ----- | --- |
| 101        | Om    | 22  |
| 102        | Sahil | 21  |

Here:

* Table = Relation
* Row = Tuple
* Column = Attribute

---

# 📌 Basic Terminology

## Relation

A table in database.

Example:

```text
Student
```

---

## Tuple

Single row inside relation.

Example:

```text
(101, Om, 22)
```

---

## Attribute

Column in relation.

Example:

```text
Student_ID, Name, Age
```

---

## Degree

Total number of attributes.

Formula:

```text
Degree = Number of Columns
```

Example:

```text
Student(ID, Name, Age)
Degree = 3
```

---

## Cardinality

Total number of tuples.

Formula:

```text
Cardinality = Number of Rows
```

Example:

```text
5 rows = Cardinality 5
```

---

# 📌 Properties of Relation

Important interview point.

Rules:

* Relation name must be unique
* Attribute names must be unique
* Order of rows does not matter
* Order of columns does not matter
* Values must be atomic
* Duplicate rows not allowed

---

# 📌 Types of Keys

---

## Super Key

Any attribute(s) that uniquely identify rows.

Examples:

```text
ID
ID + Email
ID + Phone
```

Can have extra attributes.

Visual:

![SuperKey](../Images/Chapter_3/SuperKeyTable.png)
```

Observation:

* EmpSSN uniquely identifies employee
* EmpNum also uniquely identifies employee
* Combination of both also works
* A super key may contain unnecessary extra attributes

---

## Candidate Key

Minimal super key.

Examples:

```text
ID
Email
```

No extra attributes.

Visual:

![CandidateKey](../Images/Chapter_3/CandidateKeyTable.png)
```

Observation:

* ID uniquely identifies row
* Minimal and sufficient
* No extra field required

---

## Primary Key

Chosen candidate key.

Rules:

* Unique
* Not Null

Example:

```text
Student_ID
```

---

## Alternate Key

Candidate key not chosen as primary.

Example:

```text
Email
```

---

## Composite Key

Combination of multiple attributes.

Example:

```text
(Student_ID, Course_ID)
```

Used in many-to-many relationships.

---

## Foreign Key

Used to connect tables.

Visual:

![ForeignKey](../Images/Chapter_3/FK.png)
```

Observation:

Foreign key links child table with parent table.

Example:

```text
Orders.CustomerID → Customers.CustomerID
```

Maintains referential integrity.

---

# 📌 Key Comparison Table

| Key Type      | Extra Attributes Allowed | Unique |
| ------------- | ------------------------ | ------ |
| Super Key     | Yes                      | Yes    |
| Candidate Key | No                       | Yes    |
| Primary Key   | No                       | Yes    |
| Foreign Key   | No                       | No     |

Interview shortcut:

```text
Super Key > Candidate Key > Primary Key
```

---

# 📌 Integrity Constraints

Maintains consistency.

---

## Domain Constraint

Values must belong to valid domain.

Example:

```text
Age > 0
```

---

## Entity Integrity Constraint

Primary key cannot be NULL.

Wrong:

```text
Student_ID = NULL
```

---

## Referential Integrity Constraint

Foreign key must exist in parent table.

Example:

```text
Order.Customer_ID must exist in Customer table
```

---

## Key Constraints

### NOT NULL

Cannot be empty.

---

### UNIQUE

No duplicate values.

---

### DEFAULT

Default value if not provided.

Example:

```text
Status = Active
```

---

### CHECK

Validation rule.

Example:

```text
Age >= 18
```

---

# 📌 Functional Dependency (Basics)

Very important.

Definition:

If one attribute determines another.

Syntax:

```text
X → Y
```

Meaning:

Knowing X gives Y.

Example:

```text
Student_ID → Student_Name
```

Because Student_ID uniquely determines name.

---

# 📌 Types of Functional Dependency

---

## Trivial FD

Y is subset of X.

Example:

```text
(ID, Name) → ID
```

---

## Non-Trivial FD

Y is not subset of X.

Example:

```text
ID → Name
```

---

## Completely Non-Trivial FD

No common attributes.

Rule:

```text
X ∩ Y = NULL
```

Example:

```text
ID → Salary
```

---

## Transitive Dependency

Indirect dependency.

Example:

```text
EmpID → DeptNo
DeptNo → DeptName
EmpID → DeptName
```

Important for normalization.

---

# 📌 Armstrong Rules

Used to derive new functional dependencies.

---

## Reflexivity

If:

```text
B ⊆ A
```

Then:

```text
A → B
```

---

## Augmentation

If:

```text
A → B
```

Then:

```text
AC → BC
```

---

## Transitivity

If:

```text
A → B
B → C
```

Then:

```text
A → C
```

---

# 📌 Interview Questions

### Difference between Degree and Cardinality?

```text
Degree = Columns
Cardinality = Rows
```

---

### Super Key vs Candidate Key?

Super key may contain extra attributes.

Candidate key is minimal.

---

### What is Functional Dependency?

One attribute determines another.

---

### What is Transitive Dependency?

Indirect dependency between attributes.

---

# 📌 Quick Revision

```text
Relation = Table
Tuple = Row
Attribute = Column
Degree = Columns
Cardinality = Rows

Super Key > Candidate Key > Primary Key

FD = X → Y

Trivial = subset
Non-trivial = not subset
Transitive = indirect
```

---

# 🎯 Placement Focus

Must know:

⭐ Relation terminology
⭐ Degree vs Cardinality
⭐ Types of Keys
⭐ Integrity Constraints
⭐ Functional Dependency
⭐ Armstrong Rules
⭐ Key hierarchy

Next:

```text
Day-06 → Functional Dependency + Normalization
```
