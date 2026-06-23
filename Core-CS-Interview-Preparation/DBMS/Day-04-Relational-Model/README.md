# 🚀 Day 04 - Relational Model

> Core foundation of RDBMS, Keys, Constraints, Functional Dependency, and Normalization

---

# 📌 What is Relational Model?

Relational Model represents data in the form of tables.

Each table is called a relation.

Structure:

```text
Relation (Table)
Rows → Tuples
Columns → Attributes
````

Example:

| Student_ID | Name   | Age |
| ---------- | ------ | --- |
| 101        | Om     | 22  |
| 102        | Sahil  | 21  |

Here:

* Table = Relation
* Row = Tuple
* Column = Attribute

---

# 📌 Basic Terminology

---

## Relation

A table in database.

Example:

Student

---

## Tuple

A row inside a relation.

Example:

(101, Om, 22)

---

## Attribute

Column of a relation.

Example:

Student_ID, Name, Age

---

## Degree

Number of attributes.

Formula:

Degree = Total Columns

Example:

Student(ID, Name, Age)

Degree = 3

---

## Cardinality

Number of tuples.

Formula:

Cardinality = Total Rows

Example:

5 rows = cardinality 5

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

Example:

Correct:

| ID | Name  |
| -- | ----  |
| 1  | Om    |
| 2  | Sahil |

Wrong:

Phone = 123,456

Reason:

Not atomic.

---

# 📌 Types of Keys

Most important topic.

---

## Super Key

Any attribute(s) that uniquely identify rows.

Example:

ID
ID + Email
ID + Phone

Rule:

Can have extra attributes.

---

## Candidate Key

Minimal super key.

Example:

ID
Email

Rule:

No extra attribute.

---

## Primary Key

Chosen candidate key.

Rules:

* Unique
* Not Null

Example:

Student_ID

---

## Alternate Key

Candidate key not selected.

Example:

Email if ID is primary.

---

## Composite Key

Combination of multiple attributes.

Example:

(Student_ID, Course_ID)

Used in many-to-many.

---

## Foreign Key

Used to connect tables.

Example:

Orders(Customer_ID)

References:

Customer(Customer_ID)

---

## Surrogate Key

Artificially generated key.

Example:

Auto Increment ID
UUID

Used when natural key unavailable.

---

# 📌 Key Hierarchy

Super Key
↓
Candidate Key
↓
Primary Key

Memory:

Not all super keys are candidate keys.

---

# 📌 Integrity Constraints

Maintains data consistency.

---

## Domain Constraint

Values must belong to domain.

Example:

Age > 0

---

## Entity Integrity Constraint

Primary key cannot be NULL.

Wrong:

Student_ID = NULL

---

## Referential Integrity Constraint

Foreign key must match existing primary key.

Example:

Order.Customer_ID must exist in Customer table.

---

## Key Constraints

### NOT NULL

Value cannot be null.

---

### UNIQUE

No duplicates.

---

### DEFAULT

Default value if not provided.

Example:

Status = Active

---

### CHECK

Condition validation.

Example:

Age >= 18

---

# 📌 Functional Dependency (FD)

Very important.

Definition:

If one attribute determines another.

Syntax:

X → Y

Meaning:

Knowing X gives Y.

Example:

Student_ID → Student_Name

Because ID uniquely identifies name.

---

# 📌 Types of Functional Dependency

---

## 1. Trivial FD

Y is subset of X.

Example:

(ID, Name) → ID

---

## 2. Non-Trivial FD

Y is not subset of X.

Example:

ID → Name

---

## 3. Completely Non-Trivial FD

No common attributes.

Rule:

X ∩ Y = NULL

Example:

ID → Salary

---

## 4. Transitive Dependency

Indirect dependency.

Formula:

X → Y
Y → Z
then X → Z

Example:

EmpID → DeptNo
DeptNo → DeptName

Then:

EmpID → DeptName

Very important for 3NF.

---

# 📌 Armstrong Rules

Important.

---

## Reflexivity

If B ⊆ A

Then:

A → B

---

## Augmentation

If:

A → B

Then:

AC → BC

---

## Transitivity

If:

A → B
B → C

Then:

A → C

---

# 📌 Normalization (Introduction)

Normalization is process of reducing redundancy.

Goal:

* remove duplicate data
* remove anomalies
* improve consistency

---

# Problems Without Normalization

---

## Insertion Anomaly

Cannot insert data independently.

---

## Update Anomaly

Need multiple updates.

Risk of inconsistency.

---

## Deletion Anomaly

Deleting one row removes important data.

---

# Why Normalize?

✅ Less redundancy
✅ Better consistency
✅ Better maintenance
✅ Faster searching
✅ Better integrity

---

# 📌 Coding Ninjas Important MCQ Concepts

Important:

Q. Functional dependency is relationship between?

Answer:

Attributes

---

Q. Indirect dependency is?

Answer:

Transitive dependency

---

Q. Functional dependency constraints are based on?

Answer:

Key

---

Q. Which dependency absent here?

EmpNo → EName, Salary, DeptNo
DeptNo → DName

Answer:

Partial dependency absent

---

# 📌 Interview Questions

### Difference between Degree and Cardinality?

Degree = Columns
Cardinality = Rows

---

### Difference between Super key and Candidate key?

Super key can have extra attributes.

Candidate key is minimal.

---

### What is functional dependency?

One attribute determines another.

---

### What is transitive dependency?

Indirect dependency.

---

### Why normalization?

To remove redundancy.

---

# 📌 Quick Revision

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

Normalization = remove redundancy

---

# 🎯 Placement Focus

Must know:

⭐ Relation terminology
⭐ Keys hierarchy
⭐ Integrity constraints
⭐ Functional dependency
⭐ Transitive dependency
⭐ Normalization intro

Next:

➡ Day 05 - Normalization (1NF, 2NF, 3NF, BCNF)

```
