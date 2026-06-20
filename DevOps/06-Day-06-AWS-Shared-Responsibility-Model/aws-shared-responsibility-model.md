# 🔐 Day 06 - AWS Shared Responsibility Model

## 📌 Goal

Understand how security responsibilities are divided between AWS and customers.

This module covers:

* AWS Shared Responsibility Model
* Security OF the Cloud
* Security IN the Cloud
* IaaS Responsibility
* PaaS Responsibility
* SaaS Responsibility
* EC2 Security Ownership

These concepts are important for:

* AWS SAA
* DevOps
* Cloud Security
* System Design
* AWS Interviews

---

# 🧠 Big Picture First

Many beginners think:

```text
AWS handles all security
```

Wrong.

Actual model:

```text
AWS + Customer = Security
```

AWS protects infrastructure.

Customer protects resources.

This is called:

```text
Security OF the Cloud + Security IN the Cloud
```

---

# 1. What is Shared Responsibility Model?

AWS divides security responsibilities into two parts:

```text
AWS (Provider)
        +
Customer
```

Both are responsible.

Think:

```text
Renting house
```

Owner handles:

* Building
* Walls
* Roof

You handle:

* Locking doors
* Protecting valuables

Same in AWS.

---

# 2. Security OF the Cloud (AWS Responsibility)

AWS secures the infrastructure.

AWS manages:

* Physical Data Centers
* Physical Servers
* Storage Hardware
* Networking Hardware
* Hypervisor
* Regions
* Availability Zones

Flow:

```text
Customer
    ↓
Uses AWS Services

AWS
    ↓
Protects Infrastructure
```

Think:

```text
AWS protects building
```

---

# AWS Responsibilities

```text
Physical Security
↓
Server Hardware
↓
Storage Hardware
↓
Networking
↓
Hypervisor
↓
Availability
```

These are never customer-managed.

---

# 3. Security IN the Cloud (Customer Responsibility)

Customer secures everything deployed inside AWS.

Customer manages:

* Operating System
* Applications
* User Access
* IAM Policies
* Security Groups
* Data
* Database Configuration

Flow:

```text
Your EC2
   ↓
OS
App
Users
Data
```

Think:

```text
Customer protects what they install
```

---

# Architecture Diagram

![AWS Shared Responsibility Model](./Images/aws-shared-responsibility-model.png)

---

# 4. Responsibility by Service Model

Responsibility changes depending on service type.

---

# IaaS (Infrastructure as a Service)

Example:

* EC2

Customer manages:

* OS
* Applications
* Data

AWS manages:

* Hardware
* Storage
* Networking
* Hypervisor

Flow:

```text
AWS → Server
You → Operating System
You → Application
```

Memory:

```text
More control = More responsibility
```

---

# PaaS (Platform as a Service)

Example:

* Elastic Beanstalk

Customer manages:

* Application Code
* Data

AWS manages:

* OS
* Runtime
* Infrastructure

Flow:

```text
You upload code
AWS runs everything
```

Memory:

```text
Medium control = Medium responsibility
```

---

# SaaS (Software as a Service)

Examples:

* Gmail
* Zoom
* Salesforce

Customer manages:

* User Data
* User Access

Provider manages:

* Application
* Platform
* Infrastructure

Flow:

```text
Open app → Use app
```

Memory:

```text
Less control = Less responsibility
```

---

# Responsibility Comparison

| Layer       | IaaS     | PaaS     | SaaS     |
| ----------- | -------- | -------- | -------- |
| Application | Customer | Customer | Provider |
| Data        | Customer | Customer | Provider |
| OS          | Customer | Provider | Provider |
| Runtime     | Customer | Provider | Provider |
| Hardware    | Provider | Provider | Provider |
| Networking  | Provider | Provider | Provider |

---

# Real EC2 Example

Launch EC2:

AWS gives:

```text
Virtual Machine
Storage
Network
Hardware
```

You install:

```text
Linux
Nginx
Node.js
App
Database
Users
```

If OS gets hacked:

```text
Customer problem
```

If AWS hardware fails:

```text
AWS problem
```

Important.

---

# 5. Important AWS Concepts

---

# Elasticity

Automatically scale based on demand.

Example:

```text
100 Users
 ↓
1000 Users
 ↓
Auto Scale
```

Meaning:

Scale up and down automatically.

---

# Scalability

Ability to grow.

Example:

```text
1 Server
 ↓
10 Servers
```

Meaning:

Handle more traffic.

---

# High Availability

Keep app running during failures.

Example:

```text
AZ-1 fails
 ↓
AZ-2 works
```

Meaning:

Application stays online.

---

# AWS Mapping

| Concept    | AWS Service       |
| ---------- | ----------------- |
| Compute    | EC2               |
| Platform   | Elastic Beanstalk |
| Identity   | IAM               |
| Monitoring | CloudWatch        |
| Storage    | S3                |
| Database   | RDS               |

---

# System Design Connection

Production flow:

```text
User
 ↓
Route53
 ↓
CloudFront
 ↓
ALB
 ↓
EC2
 ↓
RDS
```

Security ownership:

```text
AWS → Infrastructure
You → Everything inside app
```

This is important for architecture interviews.

---

# Interview Questions

## What is Shared Responsibility Model?

Security responsibilities shared between AWS and customer.

---

## What does AWS manage?

* Hardware
* Data Centers
* Hypervisor
* Physical Security
* Networking

---

## What does customer manage in EC2?

* OS
* Application
* Users
* Data
* Security Groups

---

## Who patches EC2 OS?

Customer.

---

## Who patches AWS hardware?

AWS.

---

## Security OF the Cloud?

AWS responsibility.

---

## Security IN the Cloud?

Customer responsibility.

---

# AWS SAA Notes

EC2:

```text
AWS → Hardware
You → OS
```

Elastic Beanstalk:

```text
AWS → Platform
You → Code
```

SaaS:

```text
Provider manages almost everything
```

Rule:

```text
More control = More responsibility
```

---

# 🎯 Key Takeaways

✅ AWS and customer both share security
✅ AWS secures infrastructure
✅ Customer secures resources
✅ IaaS gives highest control
✅ SaaS gives lowest responsibility
✅ Shared Responsibility is heavily asked in AWS exams

---

# 🧠 Memory Formula

```text
OF = AWS
IN = Customer
```

Remember:

```text
Building = AWS
Inside Room = Customer
```

---

# 🏁 Final Summary

Day 06 builds your AWS security foundation.

Without this:

* IAM won’t make sense
* Security Groups won’t make sense
* EC2 security won’t make sense
* RDS security won’t make sense

This is one of the most important AWS certification topics.
