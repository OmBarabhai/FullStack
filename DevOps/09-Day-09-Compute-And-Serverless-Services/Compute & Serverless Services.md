# ☁️ Day 09 - Compute & Serverless Services

## 📌 Goal

Understand the core AWS compute services used to run applications, distribute traffic, scale automatically, deploy code easily, and build serverless systems.

This module covers:

* Amazon EC2
* Elastic Load Balancer (ELB)
* Auto Scaling
* Elastic Beanstalk
* AWS Lambda
* Event-Driven Architecture

These concepts are important for:

* AWS SAA
* DevOps
* Cloud Engineering
* System Design
* Production Deployment

---

# 🧠 Big Picture First

Imagine your app starts like this:

```text id="d9a1"
1 Server
 ↓
100 Users
```

Business grows:

```text id="d9a2"
10,000 Users
```

Problems:

* Server overload
* Downtime
* Slow response
* Hard deployment
* Hard automation

AWS solves using:

```text id="d9a3"
EC2
 ↓
ELB
 ↓
Auto Scaling
 ↓
Elastic Beanstalk
 ↓
Lambda
```

This is the compute layer of AWS.

---

# 1. Amazon EC2 (Elastic Compute Cloud)

EC2 is AWS virtual machine service.

Think:

```text id="d9a4"
Your own server in AWS
```

Instead of buying physical machines:

AWS gives servers on demand.

Flow:

```text id="d9a5"
Launch EC2
 ↓
Install OS
 ↓
Deploy App
 ↓
Serve Users
```

---

# Real Example

Suppose you build:

```text id="d9a6"
E-commerce App
```

Need:

* Backend
* Database connection
* API handling

You can launch:

```text id="d9a7"
EC2 instance
```

Install:

* Linux
* Node.js
* Nginx

Run app.

Simple.

---

# EC2 Lifecycle

```text id="d9a8"
Launch
 ↓
Running
 ↓
Stop
 ↓
Start
 ↓
Terminate
```

Important:

```text id="d9a9"
Terminate = Delete permanently
```

---

# EC2 Types

General:

```text id="d9a10"
t2, t3
```

Compute:

```text id="d9a11"
c5
```

Memory:

```text id="d9a12"
r5
```

Storage:

```text id="d9a13"
i3
```

GPU:

```text id="d9a14"
p3
```

Remember this.

---

# 2. Elastic Load Balancer (ELB)

Load Balancer distributes traffic.

Without ELB:

```text id="d9a15"
User
 ↓
EC2
```

Problem:

```text id="d9a16"
EC2 fails → App down
```

Bad.

---

With ELB:

```text id="d9a17"
User
 ↓
ELB
 ↓
EC2-1
EC2-2
EC2-3
```

Benefits:

* High Availability
* Traffic Distribution
* Fault Tolerance

---

# Types of ELB

---

# ALB (Application Load Balancer)

Works on:

```text id="d9a18"
Layer 7
```

Handles:

* HTTP
* HTTPS

Best for:

* Web apps
* APIs

---

# NLB (Network Load Balancer)

Works on:

```text id="d9a19"
Layer 4
```

Handles:

* TCP
* UDP

Best for:

* High performance apps

---

# Real Example

E-commerce app:

```text id="d9a20"
1000 users
```

ELB distributes:

```text id="d9a21"
333 → EC2-1
333 → EC2-2
334 → EC2-3
```

Balanced.

---

# 3. Auto Scaling

Auto Scaling adds/removes EC2 automatically.

Traffic:

Normal:

```text id="d9a22"
2 EC2
```

High:

```text id="d9a23"
5 EC2
```

Low:

```text id="d9a24"
2 EC2
```

This is elasticity.

---

# Real Flow

```text id="d9a25"
Traffic increases
 ↓
CloudWatch detects
 ↓
ASG launches EC2
```

Traffic decreases:

```text id="d9a26"
ASG removes EC2
```

Cost optimized.

---

Benefits:

* Cost saving
* Automatic scaling
* High availability

---

# 4. Elastic Beanstalk

Elastic Beanstalk is PaaS.

You upload code.

AWS manages:

* EC2
* ELB
* Auto Scaling
* Monitoring
* Deployment

Flow:

```text id="d9a27"
Write Code
 ↓
Upload Code
 ↓
AWS Deploys
```

Simple.

---

# Real Example

Instead of:

```text id="d9a28"
Launch EC2 manually
Install app manually
Configure manually
```

Do:

```text id="d9a29"
Upload ZIP file
```

AWS handles everything.

Good for beginners.

---

## Architecture Diagram

![Elastic Beanstalk](./Images/01-ec2-elastic-beanstalk-overview.png)

---

# 5. AWS Lambda

Lambda is serverless compute.

Means:

```text id="d9a30"
Run code without managing server
```

Flow:

```text id="d9a31"
Event
 ↓
Lambda
 ↓
Action
```

---

# Real Example

Daily cost saving:

```text id="d9a32"
9 PM → Stop EC2
6 AM → Start EC2
```

Using:

```text id="d9a33"
EventBridge + Lambda
```

Automation.

---

# Lambda Use Cases

* File processing
* Automation
* Notifications
* API backend
* Scheduled tasks

Very important.

---

## Architecture Diagram

![AWS Lambda](./Images/02-aws-lambda-automation-workflow.png)

---

# 6. Event-Driven Architecture

Services talk using events.

Flow:

```text id="d9a34"
S3 Upload
 ↓
Event Trigger
 ↓
Lambda
 ↓
Process File
```

Example:

```text id="d9a35"
EventBridge
 ↓
Lambda
 ↓
EC2 Start/Stop
```

Used everywhere.

---

# Service Classification

| Service           | Type       |
| ----------------- | ---------- |
| EC2               | IaaS       |
| ELB               | Networking |
| Auto Scaling      | Management |
| Elastic Beanstalk | PaaS       |
| Lambda            | Serverless |

---

# System Design Connection

Production architecture:

```text id="d9a36"
User
 ↓
Route53
 ↓
CloudFront
 ↓
ALB
 ↓
EC2 (ASG)
 ↓
RDS
```

Automation:

```text id="d9a37"
EventBridge
 ↓
Lambda
 ↓
Backup / Cleanup / Notifications
```

This is real-world architecture.

---

# Interview Questions

## What is EC2?

AWS virtual machine.

---

## What is ELB?

Distributes traffic across servers.

---

## What is Auto Scaling?

Automatically adds/removes EC2.

---

## What is Elastic Beanstalk?

PaaS for app deployment.

---

## What is Lambda?

Serverless compute service.

---

## EC2 vs Lambda?

EC2:

```text id="d9a38"
Long-running apps
```

Lambda:

```text id="d9a39"
Short event-based tasks
```

---

## ALB vs NLB?

ALB:

```text id="d9a40"
HTTP/HTTPS
Layer 7
```

NLB:

```text id="d9a41"
TCP/UDP
Layer 4
```

---

# AWS SAA Notes

EC2:

```text id="d9a42"
Virtual machine
```

ELB:

```text id="d9a43"
Traffic distribution
```

Auto Scaling:

```text id="d9a44"
Elasticity
```

Beanstalk:

```text id="d9a45"
PaaS
```

Lambda:

```text id="d9a46"
Serverless
```

Best Practice:

```text id="d9a47"
ALB + ASG + Multi-AZ
```

---

# 🎯 Key Takeaways

✅ EC2 gives virtual servers
✅ ELB distributes traffic
✅ Auto Scaling handles elasticity
✅ Elastic Beanstalk simplifies deployment
✅ Lambda enables serverless automation
✅ Event-driven architecture powers modern AWS systems

---

# 🧠 Memory Formula

```text id="d9a48"
Run → Balance → Scale → Deploy → Automate
```

Mapping:

```text id="d9a49"
Run = EC2
Balance = ELB
Scale = Auto Scaling
Deploy = Beanstalk
Automate = Lambda
```

---

# 🏁 Final Summary

Day 09 builds your AWS compute foundation.

Without this:

* EC2 won’t make sense
* Load Balancer won’t make sense
* Auto Scaling won’t make sense
* Beanstalk won’t make sense
* Lambda won’t make sense

These are the most important AWS compute services for real-world cloud architecture.
