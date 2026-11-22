# 🗄️ Day 11 - AWS Storage & Database Services

## 📌 Goal

Understand AWS services used for:

* Databases
* Cache
* Shared Storage
* File Systems
* Archival
* Migration
* Hybrid Storage

This module covers:

* ElastiCache
* RDS
* DynamoDB
* DMS
* Redshift
* EFS
* FSx
* Glacier
* Snow Family
* Storage Gateway
* NFS

These are core for:

* AWS SAA
* DevOps
* Cloud Engineering
* System Design
* Production Architecture

---

# 🧠 Big Picture First

Real production flow:

```text
User
 ↓
Application
 ↓
Cache (ElastiCache)
 ↓
Database (RDS / DynamoDB)
 ↓
Storage (EFS / S3)
 ↓
Archive (Glacier)
```

Migration:

```text
On-Prem
 ↓
DMS / DataSync / Snowball / Storage Gateway
 ↓
AWS
```

This is the big picture.

---

# 1. Amazon ElastiCache

ElastiCache is in-memory caching.

Supports:

* Redis
* Memcached

Think:

```text
Temporary fast memory
```

Purpose:

Reduce database load.

---

Without cache:

```text
User
 ↓
Database
```

Problem:

Slow.

---

With cache:

```text
User
 ↓
Cache
 ↓
Database
```

Fast.

---

Real example:

Instagram:

```text
Profile data
Followers count
Likes
```

Store in cache.

Fast retrieval.

---

Visual:

![Amazon ElastiCache](./Images/01-aws-elasticache-caching-service.png)

---

# 2. Amazon RDS

RDS = Managed relational database.

Supports:

* MySQL
* PostgreSQL
* MariaDB
* Oracle
* SQL Server

Think:

```text
Traditional database in AWS
```

Used for:

* Banking
* ERP
* Ecommerce

Best for:

Structured data.

Example:

```text
Users table
Orders table
Payments table
```

---

Real flow:

```text
Application
 ↓
RDS
```

---

# 3. DynamoDB

DynamoDB = NoSQL database.

Think:

```text
Fast key-value database
```

Used for:

* Gaming
* Mobile apps
* Real-time apps

Best for:

Huge scale.

Example:

```text
UserID → Profile
```

Fast lookup.

---

Difference:

RDS:

```text
SQL
Fixed schema
```

DynamoDB:

```text
NoSQL
Flexible schema
```

---

# 4. AWS DMS

DMS = Database Migration Service.

Used for moving databases.

Flow:

```text
On-Prem DB
 ↓
AWS DMS
 ↓
RDS
```

Use when:

Migrating databases.

Example:

```text
Company MySQL
 ↓
AWS RDS MySQL
```

Very common.

---

# 5. Amazon Redshift

Redshift = Data warehouse.

Used for:

* Analytics
* BI
* Reporting

Think:

```text
Huge data analysis
```

Example:

```text
10TB sales data
```

Analyze quickly.

Not for normal apps.

---

Visual:

![AWS Database Services](./Images/02-aws-database-services-overview.png)

---

# 6. Amazon EFS

EFS = Shared Linux file storage.

Think:

```text
One shared disk for many EC2
```

Uses:

```text
NFS
Port 2049
```

Flow:

```text
EC2
EC2
EC2
 ↓
EFS
```

Best for:

Shared app files.

---

# 7. Amazon FSx

Managed file systems.

Types:

* Windows File Server
* Lustre

Use when:

Need Windows file system.

Think:

```text
Enterprise file server
```

---

# 8. Amazon Glacier

Low-cost archival storage.

Used for:

* Compliance
* Long backups
* Old logs

Think:

```text
Cold storage
```

Slow retrieval.

Cheap.

---

# 9. AWS Snow Family

Physical device for data transfer.

Types:

* Snowcone
* Snowball
* Snowmobile

Use when:

```text
Huge data
Slow internet
```

Memory trick:

```text
Internet too slow?
Ship disk physically.
```

Example:

```text
100TB migration
```

Use Snowball.

---

# 10. AWS Storage Gateway

Hybrid storage bridge.

Connects:

```text
On-Prem ↔ AWS
```

Think:

Company has local storage but wants AWS.

Flow:

```text
Office Server
 ↓
Storage Gateway
 ↓
S3 / Glacier
```

Important for hybrid cloud.

Very important.

---

Visual:

![AWS Storage Services](./Images/03-aws-storage-services-overview.png)

---

# 11. NFS (Network File System)

NFS allows shared file access.

Used by:

```text
EFS
```

Flow:

```text
EC2-1
EC2-2
EC2-3
 ↓
EFS
```

Same files.

Shared access.

Port:

```text
2049
```

Important practical.

---

Visual:

![Network File System](./Images/04-network-file-system-nfs-architecture.png)

---

# Decision Table (Very Important)

| Need                  | Service         |
| --------------------- | --------------- |
| Fast cache            | ElastiCache     |
| SQL database          | RDS             |
| NoSQL                 | DynamoDB        |
| Database migration    | DMS             |
| Analytics             | Redshift        |
| Shared Linux files    | EFS             |
| Shared Windows files  | FSx             |
| Archive               | Glacier         |
| Huge offline transfer | Snowball        |
| Hybrid storage        | Storage Gateway |

Memorize this.

---

# System Design Thinking

E-commerce:

```text
User
 ↓
App
 ↓
ElastiCache
 ↓
RDS
 ↓
S3
 ↓
Glacier
```

Hybrid company:

```text
On-Prem
 ↓
Storage Gateway
 ↓
S3
```

Database migration:

```text
On-Prem DB
 ↓
DMS
 ↓
RDS
```

Big data:

```text
App Logs
 ↓
S3
 ↓
Redshift
```

This is how interviews connect.

---

# Interview Questions

## RDS vs DynamoDB?

RDS:

```text
Relational
SQL
```

DynamoDB:

```text
NoSQL
Key-value
```

---

## Why ElastiCache?

To reduce DB load.

---

## Why EFS?

Shared file system.

---

## Why Glacier?

Cheap archive.

---

## When to use Snowball?

Large data + slow internet.

---

## What port EFS uses?

```text
2049
```

---

## What is Storage Gateway?

Hybrid storage bridge.

---

# AWS SAA Notes

Remember:

ElastiCache:

```text
Fast memory
```

RDS:

```text
Managed SQL
```

DynamoDB:

```text
Managed NoSQL
```

EFS:

```text
Shared Linux Storage
```

FSx:

```text
Managed file server
```

Glacier:

```text
Cold archive
```

Snowball:

```text
Physical transfer
```

Storage Gateway:

```text
Hybrid storage
```

---

# 🎯 Key Takeaways

✅ ElastiCache speeds apps
✅ RDS handles SQL workloads
✅ DynamoDB handles NoSQL scale
✅ DMS migrates databases
✅ Redshift analyzes large data
✅ EFS shares files across EC2
✅ Glacier archives data
✅ Snowball moves huge data
✅ Storage Gateway connects on-prem to AWS

---

# 🧠 Memory Formula

```text
Speed → ElastiCache
SQL → RDS
NoSQL → DynamoDB
Shared → EFS
Archive → Glacier
Transfer → Snowball
Hybrid → Storage Gateway
Analytics → Redshift
Migration → DMS
```

This makes revision fast.

---

# 🏁 Final Summary

Day 11 is one of the most important AWS architecture modules.

This is where you start understanding:

* how applications store data
* how they cache data
* how they migrate data
* how they archive data
* how hybrid cloud works

This directly helps in:

* AWS SAA
* DevOps
* HLD
* System Design
* Real production architecture
