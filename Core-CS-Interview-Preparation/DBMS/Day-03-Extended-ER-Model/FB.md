# 🚀 Day 06 - Facebook ER Diagram Case Study

> Real-world ER design using Facebook System

---

# 📌 Problem Statement

Design Facebook database.

Features:

- User Profile
- Add Friends
- Create Posts
- Like Posts
- Comment on Posts

---

# 📌 Lecture Reference

![Lecture Intro](../Images/Chapter_4/fb.png)

---

# Step 1 - Identify Features

Before designing ER:

Understand what system does.

Questions:

- What can user do?
- What data gets stored?

Features:

- Profile creation
- Add friends
- Create posts
- Like posts
- Comment on posts

---

![Features](../Images/Chapter_4/fb_Feature.png)

---

# Step 2 - Identify Entity Sets + Attributes

Rule:

```text
Nouns = Entities
Properties = Attributes
````

Entities:

* User_Profile
* User_Post
* Post_Comment
* Post_Like

---

## User_Profile

* User_ID
* Name
* Username
* Email
* Password
* Contact_No
* DOB
* Age (derived)

---

## User_Post

* Post_ID
* Text_Content
* Image
* Video
* Created_At
* Modified_At

---

## Post_Comment

* Comment_ID
* Text_Content
* Timestamp

---

## Post_Like

* Like_ID
* Timestamp

---

![Entity Sets + Attributes](../Images/Chapter_4/fb_EntitySets.png)

---

# Step 3 - Identify Relationships & Constraints

Rule:

```text
Actions = Relationships
```

---

## Friendship

User ↔ User

(M:N)

---

## Posts

User → Post

(1:N)

---

## Comments

User → Comment (1:N)

Post → Comment (1:N)

---

## Likes

User → Like (1:N)

Post → Like (1:N)

---

![Relationships](../Images/Chapter_4/fb_RelConst.png)

---

# Step 4 - Final ER Diagram

Complete ERD:

![Final ER Diagram](../Images/Chapter_4/fb_ERDig.png)

---

# 📌 System Design Connection

This becomes:

Services:

* User Service
* Post Service
* Comment Service
* Like Service
* Friendship Service

Tables:

```text
users
posts
comments
likes
friendships
```

LLD:

```java
class User {}
class Post {}
class Comment {}
class Like {}
class Friendship {}
```

ER → Tables → Classes → APIs

---

# 📌 Core Learning

Think like this:

```text
Features
↓
Entities
↓
Attributes
↓
Relationships
↓
Constraints
↓
ER Diagram
↓
Database
↓
Backend
↓
System Design
```

This is the real engineering flow.

```
