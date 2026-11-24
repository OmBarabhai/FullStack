# Section 10 — Designing DB Schema

> Lecture revision for AlgoCamp Lambda 4.0. This note follows the instructor's database-design approach and the available Booking.com study notes. It is not a generic DBMS textbook chapter.

## Source and coverage

- **Course:** AlgoCamp — Lambda 4.0: Ultimate Backend, Cloud & DevOps
- **Instructor:** Sanket Singh
- **Telegram course section:** Section 10 — Designing DB Schema
- **Available transcript:** `Pasted markdown(20260925-151122).md`
- **Available supporting study notes:** `Pasted markdown(20260926-101803).md`

**Coverage boundary:** The transcript available in the Library reaches approximately 44:55, where the instructor is beginning to inspect Booking.com and explain why a hotel booking is more involved than booking an entire hotel. The supporting study notes contain the later Booking.com room/date-availability design. The instructor announces Twitter as the second design exercise, but a detailed Twitter schema walkthrough was not present in the transcript or supporting notes I could access. It is deliberately not reconstructed here.

---

## 1. What database schema design means

Database schema design means deciding:

- Which entities/tables the application needs.
- Which attributes/columns each entity contains.
- How the tables are related.
- Which queries the database must support.
- Which business rules and edge cases the schema must preserve.

### HLD vs LLD vs DB design

| Design | Main focus |
|---|---|
| High-Level Design (HLD) | Overall system architecture |
| Low-Level Design (LLD) | Classes, objects and code structure |
| Database design | Tables, data and relationships |

For a database-design interview, the lecture takes a **relational database (RDBMS)** such as MySQL or PostgreSQL as its baseline. Actual engineering choices may differ based on requirements; a NoSQL database may need a different model.

## 2. The instructor's approach

The lecture emphasizes that DB design is a problem-solving exercise. There is no guaranteed perfect schema; requirements, queries and business rules create trade-offs.

### Three rules to keep in mind

**1. Reduce data redundancy**

Avoid repeating the same information across many rows. Normalize related data where it makes sense.

Example from the lecture: if many users' address strings repeat the same city, changing that city's name can require searching and updating many rows. A separate CITY entity referenced by an ID can avoid repeating the city value.

**2. Think about queries before finalizing tables**

Ask what the application needs to retrieve, filter, update and calculate. Table relationships affect how those queries are written and how expensive they may become.

**3. Visualize the real application**

Start from the actual product flow, not from table names alone. Familiar flows help reveal entities, relationships and common queries. The lecture uses e-commerce as an example:

```text
USER → SEARCH → PRODUCT → CART → ORDER → PAYMENT → DELIVERY
```

### Practical design sequence

```text
Clarify requirements
        ↓
Understand the real application flow
        ↓
Identify entities
        ↓
List important attributes
        ↓
Identify relationships and cardinality
        ↓
Consider expected queries
        ↓
Reduce unnecessary redundancy / normalize
        ↓
Apply business rules
        ↓
Check edge cases
        ↓
Review the schema
```

In an interview, communicate the reasoning instead of silently drawing tables. Explain an assumption, get clarification where needed, and refine the design.

---

## 3. Exercise 1 — Booking.com database design

### 3.1 Requirements identified in the lecture

The class starts by clarifying what the database must support:

1. Hotel owners can list a property and its rooms.
2. Users can book a room for a **range of dates**.
3. Users can bookmark/favourite hotels.
4. Users can submit hotel reviews, including a rating and comment.

The instructor explicitly excludes price comparison across multiple booking platforms from this exercise's scope.

**Payment boundary:** The lecture explains that payment processing is normally delegated to a payment gateway such as Razorpay, which communicates with banks/card networks. The application stores the relevant booking/payment state; it does not need to implement raw card processing itself.

### 3.2 Start with entities

The initial entities identified are:

- USER
- HOTEL
- BOOKING
- REVIEW
- BOOKMARK
- ROOM

The model is refined as the room/date requirements become clearer.

### 3.3 Many-to-many relationships

A many-to-many relationship means each side can be associated with multiple records on the other side. In an RDBMS, represent it using a third table, also called a **join table** or **through table**.

#### User and hotel reviews

A user can write multiple reviews, and a hotel can receive reviews from multiple users:

```text
USER ─────< REVIEW >───── HOTEL
```

The REVIEW table connects the two sides and stores relationship-specific data such as rating and comment.

#### User and hotel bookings — initial view

At the first level, the lecture models a booking as the connection between a user and a hotel:

```text
USER ─────< BOOKING >───── HOTEL
```

This is only the initial view. It is refined below because a user books a room for a date range, not an entire hotel.

#### User and hotel bookmarks

A user can bookmark many hotels, and one hotel can be bookmarked by many users:

```text
USER ─────< BOOKMARK >─── HOTEL
```

The BOOKMARK table acts as the join table.

### 3.4 Why use a join table?

The instructor compares a join-table design with putting an array of reviews inside each user record.

Problems with storing reviews as an array include:

- RDBMS support for array columns differs between database systems.
- Finding all reviews for one hotel can become more complicated when reviews for different hotels are embedded in users.
- Calculating a hotel's average rating may require examining many users' embedded reviews.
- Deleting one review may require searching through an array first.

With a separate REVIEW table, the database can use joins to fetch related data. The appropriate join type depends on which records the query needs.

**Important business-rule choice:** Some platforms allow any user to review a hotel; others allow only users with a completed stay/booking. If reviews must be verified against a stay, the relationship should be tied to the booking rather than treating every user-hotel pair as eligible. The lecture presents this as a business requirement decision, not a universal rule.

### 3.5 One-to-many: hotel and rooms

A hotel contains multiple rooms, while each room belongs to one hotel.

```text
HOTEL (1) ───────── (N) ROOM
```

For a one-to-many relationship in an RDBMS, place the primary key of the one-side in the many-side table as a foreign key:

**1:N → foreign key goes on the N-side.**

### 3.6 Room category is not a physical room

The supporting study notes distinguish:

- **Room category:** Basic, Deluxe, Premium Suite, etc.
- **Physical room:** An individual room, such as 301, 302 or 303.

A category can have multiple physical room instances. Availability must ultimately be determined for the physical room over the requested dates.

```text
HOTEL
  ↓
ROOM CATEGORY
  ↓
PHYSICAL ROOM
  ↓
DATE-WISE AVAILABILITY
```

### 3.7 Date-range booking and date-wise availability

A room can be booked for one date range and become available again after that booking ends. Therefore, room availability is date-dependent.

The supporting study notes describe a date-wise model: keep an availability record for each **physical room + date**.

The listed conceptual fields are:

- room identifier
- room category identifier
- hotel identifier
- physical room number
- date of availability
- booking identifier (nullable)

Meaning of the booking identifier:

| booking_id | Meaning |
|---|---|
| NULL | Room is available for that date |
| A booking ID | Room/date is occupied by that booking |

Example for Room 124:

| Date | booking_id | Meaning |
|---|---:|---|
| Apr 2 | NULL | Available |
| Apr 3 | NULL | Available |
| Apr 4 | 5001 | Booked |

The availability question is: **which physical rooms have every required date in the requested range available?**

### 3.8 Conceptual availability query

The supporting study notes preserve this lecture-style query shape:

```sql
SELECT COUNT(*)
FROM rooms
WHERE room_category_id = 55
  AND date_of_availability BETWEEN X AND Y
  AND booking_id IS NULL
GROUP BY room_no;
```

The reason for grouping by `room_no` is to identify physical rooms whose date rows match the availability filters.

**Treat this as a conceptual query shape from the study notes, not as a complete production-ready availability query.** The written notes explain that all required dates in the range must be available.

### 3.9 Indexing and the space–time trade-off

The supporting notes identify `date_of_availability` as an important filter for the date-range lookup and recommend an index on that column:

```sql
INDEX(date_of_availability)
```

An index is an additional data structure used to locate matching records faster than scanning all rows. The notes describe indexed range lookup as approximately (O(\log N)) at a simplified interview level; actual query cost depends on the database, index, selectivity and query plan.

Date-wise availability creates more rows. For example:

```text
10 physical rooms × 3 dates = 30 availability rows
```

This is the **space–time trade-off** described in the notes:

- More rows and storage are used.
- Availability reads can become more direct.
- Extra storage is accepted to reduce repeated computation during reads.

### 3.10 Booking update and overbooking risk

The BOOKING record is kept separately. Availability rows initially have `booking_id = NULL`. When a booking is made, the corresponding room/date availability rows are updated with that booking's ID.

A concurrency problem can occur:

```text
User A checks availability ── sees NULL
User B checks availability ── sees NULL
              ↓
Both attempt to reserve the same room/date range
              ↓
              OVERBOOKING
```

The supporting notes state that availability checking and reserving/updating must be handled with transaction/concurrency control:

```text
Check availability
       ↓
Reserve / update availability
       ↓
Commit
```

The goal is to stop two concurrent requests from both successfully reserving the same inventory. The available notes do not prescribe a specific locking or isolation implementation.

### 3.11 Cache is optional

The study notes mention caching room availability as a possible additional optimization. It is not the core schema design. First establish the database model and correctness; caching is an extra layer.

---

## 4. Booking.com conceptual schema map

```text
HOTEL
  │ 1:N
  ▼
ROOM CATEGORY
  │ 1:N
  ▼
PHYSICAL ROOM
  │ 1:N
  ▼
DATE-WISE AVAILABILITY
  │ booking_id
  ▼
BOOKING
  │
  ▼
USER

USER ─────< REVIEW >───── HOTEL
USER ─────< BOOKMARK >─── HOTEL
```

The diagram captures the relationships described in the supporting study notes. It is a conceptual map, not a complete ER diagram with every column or constraint.

## 5. Quick revision

| Rule | Remember |
|---|---|
| M:N | Use a join/through table |
| 1:N | Put the FK on the N-side |
| Hotel vs room | Users book rooms, not the entire hotel |
| Room category vs physical room | A category can have multiple physical rooms |
| Date-range booking | Availability depends on each requested date |
| booking_id = NULL | Available in the described availability model |
| Index | `date_of_availability` is the key filter in the study-note query |
| Space–time trade-off | Store more date rows to make availability reads more direct |
| Overbooking | Protect check-and-reserve with transaction/concurrency control |
| Reviews | Decide whether a booking is required based on business rules |
| Payments | Integrate a gateway; store application/payment state |

## 6. Interview self-check

Try to answer without reading:

1. What is the difference between HLD, LLD and database design?
2. Why does the instructor ask us to clarify requirements before creating tables?
3. Why should expected queries influence the schema?
4. Why is REVIEW a join table between USER and HOTEL in the initial model?
5. Why might a platform require a review to reference a booking?
6. Where does the foreign key go in a one-to-many relationship?
7. Why are room category and physical room separate concepts?
8. Why does the described availability model store room/date rows?
9. What does a NULL booking_id mean in the availability table?
10. What is the space–time trade-off in this example?
11. How can two concurrent booking requests cause overbooking?
12. Why is caching described as optional rather than the core schema?

## 7. Source coverage — do not assume missing lecture content

- The available timestamped Section 10 transcript supports the design approach, RDBMS interview baseline, requirement clarification, initial entities, M:N join-table reasoning, review business-rule choice, and the start of the room-booking refinement.
- The separate existing Booking.com study notes supply the room-category/physical-room model, date-wise availability, conceptual query, index, space–time trade-off, booking update and overbooking/concurrency material.
- The instructor announces **Twitter DB schema design** as the second exercise near the beginning of the class. Its detailed walkthrough is not in the available transcript/study note. Add that part only when the remaining lecture recording or transcript is available.

