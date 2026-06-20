# 🚀 Day 02 - ER Model

> Permanent DBMS Notes for Interviews, Revision, and Career Use

---

# 📌 What is ER Model?

ER Model (Entity Relationship Model) is a conceptual database design model.

It represents:

- Entities
- Attributes
- Relationships

before converting them into tables.

---

### Interview Answer

ER model is used to design the structure of a database at a high level. It helps identify objects, their properties, and how they are related.

---

### One-Liner

ER Model = blueprint of database design.

---

# 📌 Why does it matter?

Before writing SQL tables, we need to understand:

- what data exists
- how data connects
- what relationships exist

Without ER model:

- schema becomes messy
- redundancy increases
- relationships become hard to manage

ER modeling solves this.

---

# 📌 Core Idea

Think:

```text
Real World → Database
```

Steps:

1. Find entities
2. Find attributes
3. Find relationships
4. Define cardinality
5. Define participation
6. Convert to tables

---

# 📌 Worked Example 1 - Building a College Database

Suppose we want to build a college management system.

Step 1: Identify entities

```text
Student
Teacher
Course
Department
```

---

Step 2: Add attributes

Student:

```text
Student(ID, Name, Age)
```

Teacher:

```text
Teacher(ID, Name, Subject)
```

Course:

```text
Course(CourseID, Title, Credits)
```

Department:

```text
Department(DeptID, DeptName)
```

---

Step 3: Define relationships

```text
Student ENROLLS Course
Teacher TEACHES Course
Teacher BELONGS Department
```

Final ER:

```text
Student ---- Enrolls ---- Course
Teacher ---- Teaches ---- Course
Teacher ---- Belongs ---- Department
```

This is how real systems start.

---

# 📌 Key Concepts

---

# 1. Entity

An entity is a real-world object that can be uniquely identified.

Examples:

- Student
- Employee
- Order
- Product

---

## Strong Entity

Independent entity.

Has its own primary key.

![Strong Entity](../Images/Chapter_2/StrongEntity.png)

---

## Weak Entity

Depends on another entity.

Cannot exist alone.

![Weak Entity](../Images/Chapter_2/WeakEntity.png)

---

# 📌 Worked Example 2 - Strong vs Weak Entity

Banking system:

Strong Entity:

```text
Account(AccountID, Balance)
```

Weak Entity:

```text
Transaction(TransactionID, Amount)
```

Why weak?

Because transaction must belong to an account.

Flow:

```text
Account ---- Has ---- Transaction
```

Memory:

Strong = Parent
Weak = Child

---

## Recursive Entity

Entity related to itself.

Example:

Employee manages Employee.

![Recursive Entity](../Images/Chapter_2/RecursiveEntity.png)

---

## Composite Entity

Used to break many-to-many relationships.

Acts like bridge entity.

![Composite Entity](../Images/Chapter_2/CompositeEntity.png)

---

# 2. Entity Set

Collection of similar entities.

Example:

All students = Student entity set

---

# 3. Attribute

Properties of entities.

Example:

Student → Name, Age, Address

---

## Simple Attribute

Cannot be divided.

Example:

Age

![Attribute](../Images/Chapter_2/Attribute.png)

---

## Composite Attribute

Can be divided.

Example:

Name → First + Middle + Last

![Composite Attribute](../Images/Chapter_2/Compositeattribute.png)

---

## Derived Attribute

Calculated from another attribute.

Example:

Age from DOB

![Derived Attribute](../Images/Chapter_2/Derivedattribute.png)

---

## Multi-Valued Attribute

Can have multiple values.

Example:

Phone Numbers

![Multi-Valued Attribute](../Images/Chapter_2/Multi-valuedattribute.png)

---

# 4. Relationship

Shows connection between entities.

Example:

Writer writes Novel

Consumer buys Novel

---

## ER Model Diagram

![ER Model](../Images/Chapter_2/ER_MODEL.png)

---

# 📌 Worked Example 3 - Relationship & Cardinality

Example:

Students and Courses

One student can join many courses.

One course can have many students.

So:

```text
Student ↔ Course = Many-to-Many
```

To store this:

```text
Enrollment(StudentID, CourseID)
```

This bridge table converts many-to-many into relational tables.

Very important for joins.

---

# 5. Cardinality

Defines how many entities participate.

---

## One-to-One (1:1)

One entity connects to one entity.

Example:

Person ↔ Passport

![One To One](../Images/Chapter_2/Relationships/1to1.png)

---

## One-to-Many (1:N)

One entity connects to many.

Example:

Department → Employees

![One To Many](../Images/Chapter_2/Relationships/1toMany.png)

---

## Many-to-One (N:1)

Many entities connect to one.

Example:

Employees → Department

![Many To One](../Images/Chapter_2/Relationships/Manyto1.png)

---

## Many-to-Many (M:N)

Many entities connect to many.

Example:

Students ↔ Courses

![Many To Many](../Images/Chapter_2/Relationships/ManyToMany.png)

---

# 6. Participation

Defines mandatory or optional involvement.

---

## Total Participation

Every entity must participate.

---

## Partial Participation

Participation is optional.

![Participation](../Images/Chapter_2/Relationships/TotAndPartPartition.png)

---

### Memory Trick

Total Participation = must participate
Partial Participation = may participate

---

# 📌 Flow

```text
Real World Problem
        ↓
Identify Entities
        ↓
Find Attributes
        ↓
Find Relationships
        ↓
Define Cardinality
        ↓
Define Participation
        ↓
Draw ER Diagram
        ↓
Convert to Tables
```

---

# 📌 Real World Example

College Database:

Entities:

- Student
- Teacher
- Course

Relationships:

- Student enrolls in Course
- Teacher teaches Course

Attributes:

Student:

- RollNo
- Name
- Age

Teacher:

- ID
- Name
- Subject

Course:

- Code
- Title

This is how actual database design starts.

---

# 📌 Interview Questions

### What is ER model?

Conceptual design of database.

---

### What is entity?

A uniquely identifiable object.

---

### Strong vs Weak entity?

Strong = independent
Weak = dependent

---

### What is attribute?

Property of an entity.

---

### What is relationship?

Connection between entities.

---

### What is cardinality?

Defines maximum relationship count.

---

### What is participation?

Defines mandatory/optional involvement.

---

### What is recursive entity?

Entity related to itself.

---

### What is composite entity?

Bridge entity for many-to-many.

---

# 📌 Common Mistakes

❌ Entity = Entity Set
✔ Entity is one object

❌ Cardinality = Participation
✔ Different concepts

❌ Composite Attribute = Multi-valued Attribute
✔ Different

❌ Weak Entity = Strong Entity
✔ Weak depends on another

---

# 📌 Quick Revision

- ER Model = conceptual DB design
- Entity = object
- Entity Set = collection
- Attribute = property
- Strong Entity = independent
- Weak Entity = dependent
- Recursive Entity = self relation
- Composite Entity = bridge entity
- Relationship = connection
- Cardinality = max count
- Participation = mandatory/optional

---

# 📌 Interview One-Liners

- ER Model = DB blueprint
- Entity = real-world object
- Attribute = property
- Relationship = connection
- Weak entity = dependent
- Strong entity = independent
- Cardinality = max relationship count
- Participation = required or optional

---

# 📌 Practical / Industry Notes

ER model is used before:

- database creation
- backend development
- API design
- system design

Used heavily in:

- banking
- e-commerce
- HRMS
- ERP

Helps reduce design mistakes.

---

# 📌 Placement / Career Takeaway

Focus heavily on:

✔ Entity
✔ Attributes
✔ Relationships
✔ Cardinality
✔ Participation
✔ Weak Entity
✔ Many-to-Many conversion

Next:

```text
Extended ER Model
→ Relational Model
→ Keys
→ Constraints
→ SQL
```
