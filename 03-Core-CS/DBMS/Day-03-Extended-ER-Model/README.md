# 🚀 Day 03 - Extended ER Model

> Advanced ER concepts used in real-world system modeling

---

# 📌 What is Extended ER Model?

Extended ER Model (EER) is the advanced version of the ER model.

It introduces:

* hierarchy
* inheritance
* abstraction
* complex relationships

```text
ER → Basic Modeling
EER → Advanced Modeling
```

Used when systems become complex.

---

### Interview Answer

EER extends the ER model by adding inheritance, generalization, specialization, and aggregation for complex system modeling.

---

# 📌 Core Concepts

EER includes:

* Generalization
* Specialization
* Aggregation
* Relationship Degree
* Advanced Key Hierarchy

---

# 📌 Generalization

Bottom-up approach.

Combines similar lower-level entities into one higher-level entity.

Example:

```text
SavingsAccount + CurrentAccount → Account
```

Diagram:

![Generalization](../Images/Chapter_2/Generalization.png)

Memory:

```text
Generalization = Merge
```

---

# 📌 Specialization

Top-down approach.

Break one parent entity into multiple child entities.

Example:

```text
Person → Student + Teacher
```

Diagram:

![Specialization](../Images/Chapter_2/Specialization.png)

Memory:

```text
Specialization = Split
```

---

# 📌 Generalization vs Specialization

| Generalization | Specialization |
| -------------- | -------------- |
| Bottom-up      | Top-down       |
| Merge          | Split          |
| Creates Parent | Creates Child  |

---

# 📌 Aggregation

Treat relationship as an entity.

Used when relationship itself has meaning.

Example:

```text
Employee works_on Project
Manager manages that relation
```

Diagram:

![Aggregation](../Images/Chapter_2/Aggregation.png)

Important:

Aggregation helps model complex workflows.

---

# 📌 Relationship Degree

Defines number of participating entities.

---

## Unary Relationship

Entity related to itself.

Example:

```text
Employee manages Employee
```

Diagram:

![Unary](../Images/Chapter_3/UnaryRel.png)

---

## Binary Relationship

Two entities.

Example:

```text
Teacher teaches Subject
```

Diagram:

![Binary](../Images/Chapter_3/BinRel.png)

---

## Ternary Relationship

Three entities.

Example:

```text
Doctor treats Patient in Hospital
```

Diagram:

![Ternary](../Images/Chapter_3/TernaryRel.png)

---

# 📌 Key Revision

Important before relational model.

---

## Super Key

Any attribute(s) that uniquely identify rows.

Can contain extra attributes.

Diagram:

![SuperKey](../Images/Chapter_3/SuperKeyTable.png)

Example:

```text
EmpID
EmpID + Email
```

---

## Candidate Key

Minimal super key.

Diagram:

![CandidateKey](../Images/Chapter_3/CandidateKeyTable.png)

Example:

```text
EmpID
Email
```

---

## Primary Key

Chosen candidate key.

Rules:

* Unique
* Not Null

Example:

```text
EmpID
```

---

## Foreign Key

Connects tables.

Maintains referential integrity.

Diagram:

![ForeignKey](../Images/Chapter_3/FK.png)

Example:

```text
Orders(CustomerID) → Customers(CustomerID)
```

---

# 📌 Interview Questions

### What is Generalization?

Combining similar entities into one parent.

---

### What is Specialization?

Breaking one parent into child entities.

---

### What is Aggregation?

Treating a relationship as an entity.

---

### Degree vs Cardinality?

```text
Degree = Number of participating entities
Cardinality = Number of relationship instances
```

---

# 📌 Common Mistakes

❌ Generalization = Specialization
✔ Opposite concepts

❌ Super Key = Candidate Key
✔ Candidate key is minimal

❌ Aggregation = Normal relation
✔ Higher abstraction

---

# 📌 Quick Revision

```text
EER = ER + Advanced abstraction

Generalization = Merge
Specialization = Split
Aggregation = Relationship as entity

Unary = 1 Entity
Binary = 2 Entities
Ternary = 3 Entities

Super Key > Candidate Key > Primary Key
Foreign Key connects tables
```

---

# 🎯 Placement Focus

Must know:

⭐ Generalization vs Specialization
⭐ Aggregation
⭐ Unary/Binary/Ternary
⭐ Super Key
⭐ Candidate Key
⭐ Primary Key
⭐ Foreign Key

Next:

```text
Day-04 → Relational Model
```
