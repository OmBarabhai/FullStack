# 💾 Day 10 - AWS Storage Fundamentals

## 📌 Goal

Understand the two core AWS storage services used in almost every architecture.

This module covers:

* Amazon S3
* Amazon EBS
* Object Storage
* Block Storage
* Buckets
* Objects
* EBS Volumes
* Snapshots

These concepts are important for:

* AWS SAA
* DevOps
* Cloud Engineering
* System Design
* Production Architecture

---

# 🧠 Big Picture First

Every application needs storage.

Example:

```text id="d10a1"
Instagram
 ↓
Images
Videos
Profiles
Logs
```

Question:

```text id="d10a2"
Where do we store all this data?
```

AWS provides:

```text id="d10a3"
S3 = Store files
EBS = Store server disk
```

Simple:

```text id="d10a4"
S3 = Cloud Storage
EBS = Hard Disk
```

This is the base.

---

# 1. Amazon S3 (Simple Storage Service)

S3 is AWS Object Storage.

Think:

```text id="d10a5"
Google Drive
Dropbox
Cloud Storage
```

But for applications.

Used for:

* Images
* Videos
* Logs
* Backups
* Static websites

---

# Easy Memory Trick

Your laptop:

```text id="d10a6"
Folder
 ↓
Files
```

AWS:

```text id="d10a7"
Bucket
 ↓
Objects
```

Remember:

```text id="d10a8"
Bucket = Folder
Object = File
```

---

# Core S3 Terminology

---

# Bucket

Container for storing objects.

Examples:

```text id="d10a9"
company-backup
project-files
user-images
```

Important:

Bucket names are globally unique.

Meaning:

```text id="d10a10"
No duplicate names in AWS
```

---

# Object

Actual file.

Examples:

```text id="d10a11"
image.png
video.mp4
resume.pdf
backup.zip
```

Everything in S3 is an object.

---

# Key

Unique object path.

Example:

```text id="d10a12"
images/profile.png
```

Think:

```text id="d10a13"
Full file path
```

---

# S3 Architecture

Flow:

```text id="d10a14"
Bucket
 ↓
Objects
 ↓
Keys
```

Simple storage structure.

---

# S3 Features

---

# Unlimited Storage

Store almost unlimited data.

Examples:

* Logs
* Images
* Videos
* Backups

---

# High Durability

S3 durability:

```text id="d10a15"
99.999999999%
(11 nines)
```

Means:

Very low data loss.

Important for interviews.

---

# High Availability

AWS manages storage across multiple systems.

Result:

```text id="d10a16"
Data remains accessible
```

---

# Serverless

No server to manage.

Just upload.

Use.

Done.

---

# Regional Service

Bucket created inside region.

Example:

```text id="d10a17"
Mumbai
Singapore
Ohio
```

Important:

```text id="d10a18"
Bucket belongs to region
```

---

# Real Example

Instagram:

Store:

```text id="d10a19"
Profile Images
Reels
Stories
Backups
```

All can go in:

```text id="d10a20"
S3
```

Perfect fit.

---

# Visual Learning

![Amazon S3](./Images/01-amazon-s3-storage-fundamentals.png)

---

# 2. Amazon EBS (Elastic Block Store)

EBS is block storage for EC2.

Think:

```text id="d10a21"
Hard Disk for EC2
```

Used when:

EC2 needs storage.

Flow:

```text id="d10a22"
EC2
 ↓
EBS
```

Without EBS:

```text id="d10a23"
No disk
No OS
```

---

# Easy Memory Trick

Physical:

```text id="d10a24"
CPU
RAM
Hard Disk
```

AWS:

```text id="d10a25"
EC2
 ↓
EBS Volume
```

Same concept.

---

# EBS Features

---

# Persistent Storage

Data remains after reboot.

Example:

```text id="d10a26"
Restart EC2
Data still exists
```

Important.

---

# High Performance

Used for:

* Databases
* Applications
* Logs

Fast storage.

---

# Snapshots

Backup of EBS.

Flow:

```text id="d10a27"
EBS Volume
 ↓
Snapshot
 ↓
Stored in S3
```

Used for:

* Backup
* Restore
* Migration

Important.

---

# Multiple Volumes

One EC2 can have:

```text id="d10a28"
Root Volume
+
Additional Volumes
```

Example:

```text id="d10a29"
OS + App Data + Logs
```

---

# Root Volume

Contains:

```text id="d10a30"
OS
Boot files
System files
```

Examples:

Linux:

```text id="d10a31"
/ (root)
```

Windows:

```text id="d10a32"
C:
```

---

# Additional Volume

Used for:

```text id="d10a33"
App files
Database files
Logs
```

Extra storage.

---

# Real Example

Database server:

Need:

```text id="d10a34"
Fast reads
Fast writes
Persistent disk
```

Best:

```text id="d10a35"
EBS
```

---

# Visual Learning

![Amazon EBS](./Images/02-amazon-ebs-block-storage-overview.png)

---

# S3 vs EBS

| Feature      | S3                  | EBS           |
| ------------ | ------------------- | ------------- |
| Storage Type | Object              | Block         |
| Used With    | Many AWS Services   | EC2 Only      |
| Storage Size | Unlimited           | Volume Based  |
| Access       | API                 | Attached Disk |
| Performance  | Good                | High          |
| Best For     | Files, Images, Logs | OS, DB, Apps  |

---

# Real World Thinking

If storing:

Images:

```text id="d10a36"
Use S3
```

Running OS:

```text id="d10a37"
Use EBS
```

Database:

```text id="d10a38"
Use EBS
```

Backups:

```text id="d10a39"
Use S3
```

Static website:

```text id="d10a40"
Use S3
```

---

# System Design Connection

Production architecture:

```text id="d10a41"
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
EBS (OS + App)
 ↓
RDS
```

Files:

```text id="d10a42"
EC2 uploads to S3
```

Real example:

```text id="d10a43"
User uploads profile picture
 ↓
App saves in S3
```

Very common.

---

# Interview Questions

## What is S3?

Object storage service.

---

## What is EBS?

Block storage attached to EC2.

---

## Difference between S3 and EBS?

S3:

```text id="d10a44"
Store files
```

EBS:

```text id="d10a45"
Store server disk data
```

---

## Can EBS attach to multiple EC2?

Generally:

```text id="d10a46"
No
```

---

## Where are EBS snapshots stored?

```text id="d10a47"
S3
```

---

## Is S3 unlimited?

```text id="d10a48"
Yes (practically)
```

---

# AWS SAA Notes

S3:

```text id="d10a49"
Object Storage
Serverless
Unlimited
```

EBS:

```text id="d10a50"
Block Storage
EC2 Disk
AZ Specific
```

Snapshot:

```text id="d10a51"
Backup of EBS
Stored in S3
```

Rule:

```text id="d10a52"
Files → S3
Disk → EBS
```

---

# 🎯 Key Takeaways

✅ S3 stores files as objects
✅ Bucket contains objects
✅ Object has unique key
✅ EBS acts as EC2 disk
✅ EBS supports snapshots
✅ S3 and EBS solve different problems
✅ Both are core AWS storage services

---

# 🧠 Memory Formula

```text id="d10a53"
Store Files → S3
Store Disk → EBS
Backup Disk → Snapshot
```

Simple.

---

# 🏁 Final Summary

Day 10 builds your AWS storage foundation.

Without this:

* EC2 storage won’t make sense
* S3 practicals won’t make sense
* Backups won’t make sense
* Snapshots won’t make sense
* File upload architecture won’t make sense

These are some of the most important storage services in AWS.
