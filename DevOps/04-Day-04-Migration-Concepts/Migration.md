# ☁️ Day 04: Migration Concepts

## 📖 Overview

As organizations grow, maintaining physical servers becomes expensive and difficult.

Cloud migration helps businesses move applications, servers, and workloads from traditional data centers to virtualized environments and cloud platforms such as AWS.

Understanding migration concepts is important for AWS Solutions Architect, DevOps, Cloud Engineer, and Infrastructure roles.

This module covers:

* On-Premises Infrastructure
* Virtualization
* Hypervisor
* Physical to Virtual (P2V)
* Virtual to Virtual (V2V)
* Virtual to Cloud (V2C)
* Benefits of Cloud Migration

---

# 🎯 Learning Objectives

After completing this module, you should be able to:

✅ Explain On-Premises infrastructure

✅ Understand virtualization concepts

✅ Explain the role of a hypervisor

✅ Differentiate between P2V, V2V, and V2C migration

✅ Understand why businesses migrate to AWS

✅ Explain migration concepts in interviews

---

# 🏢 Traditional On-Premises Infrastructure

Before cloud computing, companies managed their own data centers.

Responsibilities included:

* Purchasing servers
* Maintaining hardware
* Managing networking
* Handling storage
* Performing upgrades
* Managing backups

Example:

```text
Company
   ↓
Own Data Center
   ↓
Servers + Storage + Network
```

Challenges:

* High cost
* Hardware failures
* Scaling difficulties
* Maintenance overhead

---

# 🧠 Virtualization

Virtualization allows multiple virtual machines (VMs) to run on a single physical server.

Instead of:

```text
1 Server = 1 Application
```

We can run:

```text
1 Server
   ↓
Multiple Virtual Machines
   ↓
Multiple Applications
```

Benefits:

* Better resource utilization
* Reduced hardware cost
* Easier management
* Faster deployment

---

# 🏗️ Hypervisor

A Hypervisor is software that creates and manages Virtual Machines.

Example:

* VMware ESXi
* Microsoft Hyper-V
* KVM

Architecture:

```text
Application
     ↓
Operating System
     ↓
Virtual Machine
     ↓
Hypervisor
     ↓
Physical Hardware
```

---

# 🔄 Migration Types

## 1️⃣ P2V (Physical to Virtual)

Physical Server → Virtual Machine

Example:

```text
Physical Server
      ↓
VMware Virtual Machine
```

Why?

* Reduce hardware dependency
* Improve resource utilization
* Easier backup and recovery

---

## 2️⃣ V2V (Virtual to Virtual)

Move a Virtual Machine from one virtualization platform to another.

Example:

```text
VMware
   ↓
Hyper-V
```

Use Cases:

* Platform migration
* Cost optimization
* Standardization

---

## 3️⃣ V2C (Virtual to Cloud)

Move Virtual Machines into AWS Cloud.

Example:

```text
VMware VM
      ↓
AWS EC2 Instance
```

Benefits:

* Elastic scaling
* Pay-as-you-go pricing
* High availability
* Managed infrastructure

---

# 🖼️ Architecture Diagram

![Migration Concepts](./Images/p2v-v2v-v2c-migration-overview.png)

---

# ☁️ Why Businesses Move to AWS

Traditional Environment:

```text
Buy Servers
Manage Hardware
Maintain Data Center
Handle Failures
```

AWS Environment:

```text
Provision Resources On Demand
Pay Only For Usage
Scale Automatically
Global Availability
```

Benefits:

* Lower cost
* Better scalability
* High availability
* Improved security
* Faster deployments

---

# 🏢 Real-World Example

Imagine a company has:

```text
500 Physical Servers
```

Challenges:

* Hardware maintenance
* Power consumption
* Data center costs

Migration Journey:

```text
Physical Servers
      ↓
Virtual Machines (P2V)
      ↓
AWS Cloud (V2C)
```

Result:

* Reduced operational cost
* Better scalability
* Faster deployments

---

# ☁️ AWS Migration Services

| Service                                 | Purpose              |
| --------------------------------------- | -------------------- |
| AWS Application Migration Service (MGN) | Server Migration     |
| AWS Database Migration Service (DMS)    | Database Migration   |
| AWS DataSync                            | Data Transfer        |
| AWS Snowball                            | Large Data Migration |
| AWS Storage Gateway                     | Hybrid Storage       |

---

# 🎤 Interview Questions

## What is On-Premises Infrastructure?

Infrastructure managed within an organization's own data center.

---

## What is Virtualization?

Running multiple virtual machines on a single physical server.

---

## What is a Hypervisor?

Software that creates and manages virtual machines.

---

## What is P2V Migration?

Migrating a physical server to a virtual machine.

---

## What is V2V Migration?

Migrating a virtual machine between virtualization platforms.

---

## What is V2C Migration?

Migrating a virtual machine to a cloud platform such as AWS.

---

## Why Do Companies Move to AWS?

* Reduce costs
* Improve scalability
* Increase availability
* Simplify infrastructure management

---

# 📝 AWS SAA Notes

Remember:

### P2V

```text
Physical Server → Virtual Machine
```

### V2V

```text
Virtual Machine → Virtual Machine
```

### V2C

```text
Virtual Machine → AWS Cloud
```

### Hypervisor

Creates and manages VMs.

### AWS MGN

Used for server migration.

### AWS DMS

Used for database migration.

---

# 📌 Key Takeaways

* On-Premises infrastructure requires hardware management.
* Virtualization improves resource utilization.
* Hypervisors create and manage VMs.
* P2V converts physical servers into virtual machines.
* V2V moves workloads between virtualization platforms.
* V2C moves workloads into AWS Cloud.
* AWS reduces operational complexity and cost.

---

# 🚀 Next Module

Day 05: Linux Fundamentals

Topics:

* Linux Basics
* Linux Architecture
* File System Structure
* Important Commands
* Users & Permissions

---

# 🏆 Summary

Migration is the process of moving workloads from traditional infrastructure to modern virtualized or cloud environments.

Understanding P2V, V2V, and V2C migration is essential for AWS architects, cloud engineers, and DevOps professionals because these migration strategies are commonly used when organizations modernize their infrastructure and adopt AWS.
