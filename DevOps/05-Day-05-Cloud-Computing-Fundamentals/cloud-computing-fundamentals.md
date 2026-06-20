This is good, but I’d improve it the same way as previous days:

Main missing things:

1. **Real-world business problem first**
2. **Why cloud was invented**
3. **Better AWS global infra explanation**
4. **Better IaaS/PaaS/SaaS memory**
5. **System design relation**
6. **Stronger revision structure**

Here’s the improved final Day 05:

---

# ☁️ Day 05 - Cloud Computing Fundamentals

## 📌 Goal

Understand what Cloud Computing is, why it was created, and how AWS delivers infrastructure globally.

This module covers:

* What is Cloud Computing
* On-Premises vs Cloud
* AWS Global Infrastructure
* Cloud Deployment Models
* Cloud Service Models
* IaaS
* PaaS
* SaaS

These are core for:

* AWS SAA
* DevOps
* Cloud Engineering
* System Design
* Infrastructure Design

---

# 🧠 Big Picture First

Imagine a company grows:

```text id="tr2j66"
10 Users
↓
100 Users
↓
1000 Users
↓
10000 Users
```

Problems:

```text id="jcn2g6"
Need more servers
Need more storage
Need more network
Need more maintenance
Need more backup
```

Company asks:

```text id="lry3e0"
How do we scale without buying hardware?
```

Answer:

```text id="0b0fui"
Cloud Computing
```

---

# 1. What is Cloud Computing?

Cloud Computing means using computing resources over the internet instead of owning physical infrastructure.

Traditional:

```text id="cckt6a"
Buy Server
Install Hardware
Setup Network
Maintain Everything
Pay Upfront
```

Cloud:

```text id="m0ycn9"
Internet
   ↓
AWS Cloud
   ↓
Use Resources On Demand
```

Simple:

```text id="ue3kgl"
Rent instead of Buy
```

---

# Why Cloud Was Created?

Before cloud:

Problems:

* High upfront cost
* Hardware failures
* Limited scaling
* Slow deployment
* Complex maintenance

Cloud solved:

* Instant resources
* Pay as you go
* Global availability
* Auto scaling

---

# Real Example

Old way:

```text id="z8hmx8"
Need 5 servers
Buy them
Wait 15 days
Install manually
```

Cloud way:

```text id="q4wqye"
Launch EC2 in 2 minutes
```

Huge difference.

---

# 2. On-Premises Infrastructure

On-prem means company owns infrastructure.

Architecture:

```text id="n8kl1e"
Company
   ↓
Own Data Center
   ↓
Servers + Storage + Network + Database
```

Company manages:

* Hardware
* Cooling
* Power
* Security
* Networking
* Backup

---

## Problems

As users grow:

```text id="2jhm6x"
More users
↓
More servers
↓
More racks
↓
More cost
```

Problems:

* Expensive
* Hard scaling
* Maintenance heavy

---

# 3. Cloud Infrastructure

Cloud provider manages infrastructure.

Architecture:

```text id="a53y2q"
AWS Data Centers
       ↓
Compute
Storage
Database
Network
       ↓
Customer uses via Internet
```

Customer focuses only on usage.

AWS handles hardware.

---

# Architecture Diagram

![Cloud Computing Fundamentals](./Images/cloud-computing-fundamentals.png)

---

# 4. AWS Global Infrastructure

AWS works globally.

Three important things:

---

# Region

Physical location.

Examples:

* Mumbai
* Hyderabad
* Ohio
* Singapore

Think:

```text id="ymwzgn"
Region = Country/City Level
```

Example:

```text id="tovjlwm"
ap-south-1 = Mumbai
```

---

# Availability Zone (AZ)

Separate data centers inside region.

Example:

```text id="9b2iwg"
Mumbai Region
├── AZ-A
├── AZ-B
└── AZ-C
```

Purpose:

* High availability
* Fault tolerance

Think:

```text id="uzq75z"
If one AZ fails, others work
```

---

# Edge Location

Used for caching.

Mainly:

* CloudFront

Purpose:

Bring content closer to users.

Think:

```text id="svs2yv"
Faster delivery
```

---

# AWS Global Flow

```text id="dwy8n4"
User
 ↓
Edge Location
 ↓
Region
 ↓
AZ
 ↓
Service
```

This is important.

---

# 5. Cloud Deployment Models

---

# Public Cloud

Provider owns infrastructure.

Examples:

* AWS
* Azure
* GCP

Flow:

```text id="wv8u3z"
Company → AWS Cloud
```

Benefits:

* Cheap
* Scalable
* Easy

---

# Private Cloud

Dedicated for one company.

Examples:

* VMware
* Private Datacenter

Benefits:

* More control
* More security

---

# Hybrid Cloud

Mix of both.

Flow:

```text id="boqn39"
On-Prem
   ↕
AWS Cloud
```

Used during migration.

Very common.

---

# 6. Service Models

---

# IaaS

AWS gives infrastructure.

You manage:

* OS
* Application
* Data

AWS manages:

* Hardware
* Network
* Storage

Examples:

* EC2
* EBS
* VPC

Memory:

```text id="rypbne"
IaaS = Rent server
```

---

# PaaS

AWS gives platform.

You manage:

* Code
* Data

AWS manages:

* OS
* Runtime
* Infrastructure

Examples:

* Elastic Beanstalk
* Heroku

Memory:

```text id="2y1p7v"
PaaS = Deploy code
```

---

# SaaS

Everything managed.

You only use software.

Examples:

* Gmail
* Zoom
* Salesforce

Memory:

```text id="ixb2ih"
SaaS = Use software
```

---

# Service Model Comparison

| Feature  | IaaS | PaaS   | SaaS |
| -------- | ---- | ------ | ---- |
| Hardware | AWS  | AWS    | AWS  |
| OS       | User | AWS    | AWS  |
| App      | User | User   | AWS  |
| Effort   | High | Medium | Low  |

---

# Real World Example

Starting online business.

Old way:

```text id="rj2hlf"
Buy server
Setup network
Install OS
Deploy app
```

Cloud way:

```text id="n7uz9m"
Create AWS account
Launch EC2
Deploy app
Go live
```

Result:

* Faster
* Cheaper
* Scalable

---

# AWS Mapping

| Need     | AWS Service |
| -------- | ----------- |
| Compute  | EC2         |
| Storage  | S3          |
| Database | RDS         |
| Network  | VPC         |
| DNS      | Route53     |
| CDN      | CloudFront  |

---

# System Design Connection

Production architecture:

```text id="hksgza"
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

Everything runs on cloud.

Without cloud:

Hard.

With AWS:

Easy.

---

# Interview Questions

## What is Cloud Computing?

Using computing resources over internet.

---

## On-Prem vs Cloud?

On-prem:

Own everything.

Cloud:

Rent everything.

---

## What is Region?

Physical AWS location.

---

## What is Availability Zone?

Isolated data center inside region.

---

## Public vs Private vs Hybrid?

Public = shared

Private = dedicated

Hybrid = both

---

## IaaS?

Infrastructure service.

Example:

EC2

---

## PaaS?

Platform service.

Example:

Elastic Beanstalk

---

## SaaS?

Software service.

Example:

Gmail

---

# 🎯 Key Takeaways

✅ Cloud means renting resources
✅ AWS removes hardware burden
✅ Region = location
✅ AZ = fault isolation
✅ Edge = fast delivery
✅ IaaS = infrastructure
✅ PaaS = platform
✅ SaaS = software

---

# 🧠 Memory Formula

```text id="oyiwgk"
Build → Deploy → Use
```

Mapping:

```text id="hccp0n"
IaaS = Build
PaaS = Deploy
SaaS = Use
```

---

# 🏁 Final Summary

Day 05 builds your cloud foundation.

Without this:

* EC2 won’t make sense
* S3 won’t make sense
* RDS won’t make sense
* VPC won’t make sense

Cloud is the base of AWS.

Master this deeply.
