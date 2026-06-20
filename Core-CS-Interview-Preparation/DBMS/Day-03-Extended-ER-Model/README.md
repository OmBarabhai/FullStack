# 🚀 Day 04 - Extended ER Model

> Permanent DBMS Notes for Interviews, Revision, and Career Use

---

# 📌 What is Extended ER Model?

Extended ER Model (EER) is the advanced version of the ER model.

It adds extra abstraction to model complex systems.

```text
ER → Basic Modeling
EER → Advanced Modeling
```

Used when:

- hierarchy exists
- inheritance exists
- complex relationships exist

---

### Interview Answer

EER extends the ER model by adding concepts like inheritance, generalization, specialization, and aggregation to model real-world systems more effectively.

---

### One-Liner

EER = ER + advanced abstraction.

---

# 📌 Why does it matter?

Real-world systems are not flat.

Example:

A user can be:

- Customer
- Seller
- Admin

Using only ER:

- data duplication increases
- design becomes messy

EER solves this by introducing hierarchy.

Helps in:

- abstraction
- scalability
- cleaner schema design

---

# 📌 Core Concepts

EER introduces:

- Generalization
- Specialization
- Aggregation
- Relationship Degree
- Advanced Key Understanding

---

# 📌 Generalization

Bottom-up approach.

Combines similar lower-level entities into one higher-level entity.

Example:

```text
Savings Account + Current Account → Account
```

---

## Diagram

![Generalization](../Images/Chapter_2/ER_diagram/Generalization.png)

---

### Quick Definition

Generalization = combining similar entities.

---

# 📌 Worked Example - Generalization

Bank System:

Before:

```text
SavingsAccount(AccountNo, Balance, InterestRate)
CurrentAccount(AccountNo, Balance, OverdraftLimit)
```

Common fields:

- AccountNo
- Balance

After generalization:

```text
Account(AccountNo, Balance)
```

Subtypes:

```text
SavingsAccount
CurrentAccount
```

This removes duplication.

---

# 📌 Specialization

Top-down approach.

Break one general entity into multiple specialized entities.

Example:

```text
Person → Student + Teacher
```

---

## Diagram

![Specialization](../Images/Chapter_2/ER_diagram/Specialization.png)

---

### Quick Definition

Specialization = dividing one general entity.

---

# 📌 Worked Example - Specialization

University System:

General entity:

```text
Person(ID, Name, Phone)
```

Subtypes:

```text
Student(RollNo, Course)
Teacher(EmployeeID, Subject)
```

Common data stays in Person.

Specific data moves to subtypes.

Cleaner design.

---

# 📌 Generalization vs Specialization

| Generalization | Specialization |
| -------------- | -------------- |
| Bottom-up      | Top-down       |
| Merge entities | Split entity   |
| Creates parent | Creates child  |

Memory:

```text
Generalization = Merge
Specialization = Split
```

---

# 📌 Aggregation

Treats a relationship as an entity.

Used when relationship itself has meaning.

Example:

Employee works on Project
Manager manages that assignment.

---

## Diagram

![Aggregation](../Images/Chapter_2/ER_diagram/Aggregation.png)

---

### Quick Definition

Aggregation = abstraction over relationship.

---

# 📌 Worked Example - Aggregation

Company System:

Normal relation:

```text
Employee ---- WorksOn ---- Project
```

Now Manager supervises this relation.

So:

```text
Manager ---- Manages ---- (Employee WorksOn Project)
```

Here:

WorksOn becomes an aggregated entity.

Used in complex workflows.

---

# 📌 Degree of Relationship

Degree = number of participating entities.

---

# Unary Relationship (Degree 1)

Entity related to itself.

Example:

Employee manages Employee

---

## Diagram

![Unary](../Images/Chapter_3/UnaryRel.png)

---

# Binary Relationship (Degree 2)

Two entities.

Example:

Teacher teaches Subject

---

## Diagram

![Binary](../Images/Chapter_3/BinRel.png)

---

# Ternary Relationship (Degree 3)

Three entities.

Example:

Employee works in Department at Location

---

## Diagram

![Ternary](../Images/Chapter_3/TernaryRel.png)

---

# 📌 Worked Example - Degree

Unary:

```text
Employee supervises Employee
```

Binary:

```text
Student enrolls Course
```

Ternary:

```text
Doctor treats Patient in Hospital
```

Memory:

```text
Degree = number of entities involved
```

---

# 📌 Keys Revision

Important before relational model.

---

# Super Key

Any attribute(s) that uniquely identify rows.

Can contain extra attributes.

Example:

```text
EmpID
EmpID + Name
```

---

## Diagram

![SuperKey](../Images/Chapter_3/SuperKeyTable.png)

---

# Candidate Key

Minimal super key.

No unnecessary attributes.

---

## Diagram

![CandidateKey](../Images/Chapter_3/CandidateKeyTable.png)

---

# Primary Key

Chosen candidate key.

Rules:

- unique
- not null

---

# Foreign Key

Connects tables.

Maintains referential integrity.

---

## Diagram

![ForeignKey](../Images/Chapter_3/FK.png)

---

# 📌 Worked Example - Keys

Employee Table:

| EmpID | Email                               | Name |
| ----- | ----------------------------------- | ---- |
| 101   | [om@gmail.com](mailto:om@gmail.com) | Om   |

Possible unique identifiers:

```text
EmpID
Email
EmpID + Email
```

Super Keys:

- EmpID
- Email
- EmpID + Email

Candidate Keys:

- EmpID
- Email

Primary Key:

- EmpID

---

# 📌 Interview Questions

## What is generalization?

Combining similar entities into one generalized entity.

---

## What is specialization?

Breaking one entity into multiple specific entities.

---

## Generalization vs Specialization?

Generalization = bottom-up
Specialization = top-down

---

## What is aggregation?

Treating a relationship as an entity.

---

## What is unary relationship?

Entity related to itself.

---

## Super key vs Candidate key?

Super key may contain extra attributes.
Candidate key is minimal.

---

# 📌 Common Mistakes

❌ Generalization = Specialization
✔ Opposite concepts

❌ Candidate key = Primary key
✔ Primary key is selected candidate key

❌ Aggregation = normal relation
✔ Aggregation is higher abstraction

❌ Degree = Cardinality
✔ Completely different

---

# 📌 Quick Revision

- EER extends ER
- Generalization = bottom-up
- Specialization = top-down
- Aggregation = relation abstraction
- Unary = self relation
- Binary = 2 entities
- Ternary = 3 entities
- Super key may have extra fields
- Candidate key is minimal
- Primary key is selected candidate key
- Foreign key connects tables

---

# 📌 Practical / Industry Notes

Used heavily in:

- banking
- HRMS
- e-commerce
- ERP
- CRM systems

Helps in:

- schema optimization
- ORM modeling
- backend architecture
- microservice data design

Important in:

- system design interviews
- production database modeling

---

# 📌 Placement / Career Takeaway

Focus heavily on:

✔ Generalization vs Specialization
✔ Aggregation
✔ Relationship Degree
✔ Key hierarchy

These are asked often in:

- placements
- product companies
- backend interviews

Next:

```text
Day-05 → Relational Model
```

Important because:

```text
ER → Table conversion starts there
```

This is where SQL becomes easier.
