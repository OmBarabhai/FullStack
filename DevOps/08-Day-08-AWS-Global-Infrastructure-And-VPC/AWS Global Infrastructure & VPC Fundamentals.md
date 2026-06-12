# 🌎 Day 08: AWS Global Infrastructure & VPC Fundamentals

## 📖 Overview

AWS operates one of the largest cloud infrastructures in the world.

To build highly available, fault-tolerant, and scalable applications, it is important to understand how AWS organizes its infrastructure globally.

This module covers:

- AWS Global Infrastructure
- Regions
- Availability Zones (AZ)
- Data Centers
- Virtual Private Cloud (VPC)
- Regional Services
- Multi-AZ Architecture

These concepts are frequently asked in AWS SAA, DevOps, Cloud, and Infrastructure interviews.

---

# 🎯 Learning Objectives

After completing this module, you should be able to:

✅ Explain AWS Global Infrastructure

✅ Understand Regions and Availability Zones

✅ Differentiate Region vs Availability Zone

✅ Understand why Multi-AZ is important

✅ Explain AWS VPC fundamentals

✅ Understand default VPC behavior

---

# 🌎 AWS Global Infrastructure

AWS provides cloud services through a worldwide network of infrastructure.

AWS Global Infrastructure consists of:

```text
Regions
    ↓
Availability Zones
    ↓
Data Centers
```

AWS manages all infrastructure while customers consume services.

---

# 🏢 What is a Region?

A Region is a physical geographic location where AWS has deployed infrastructure.

Examples:

```text
Mumbai       → ap-south-1
Hyderabad    → ap-south-2
Ohio         → us-east-2
Singapore    → ap-southeast-1
```

Each Region contains multiple Availability Zones.

---

# 🏗️ What is an Availability Zone (AZ)?

An Availability Zone is one or more physically separate data centers within a Region.

Example:

```text
Mumbai Region
│
├── ap-south-1a
├── ap-south-1b
└── ap-south-1c
```

Benefits:

- High Availability
- Fault Isolation
- Disaster Recovery

---

# 🧠 Easy Memory Trick

Think of:

```text
India
   ↓
Maharashtra
   ↓
Cities
```

Similarly:

```text
Region
   ↓
Availability Zones
   ↓
Data Centers
```

Region is the big area.

AZ is a smaller isolated location inside the Region.

---

# 🖼️ Architecture Diagram

![AWS Regions and Availability Zones](./Images/01-aws-regions-and-availability-zones.png)

---

# 🔄 Multi-AZ Architecture

AWS recommends distributing resources across multiple AZs.

Example:

```text
AZ-A
  EC2

AZ-B
  EC2

Load Balancer
     ↓
Distributes Traffic
```

If one AZ fails:

```text
AZ-A Down
     ↓
AZ-B Continues Running
```

Benefits:

- High Availability
- Fault Tolerance
- Reduced Downtime

---

# 🌐 What is VPC?

VPC stands for:

```text
Virtual Private Cloud
```

A VPC is a logically isolated network inside AWS where you launch resources.

Think of it as:

```text
Your Private Data Center
Inside AWS
```

Resources inside VPC:

- EC2
- RDS
- Load Balancers
- Lambda (VPC Attached)

---

# 🧠 Easy Memory Trick

Imagine AWS is a large apartment building.

```text
AWS Cloud
```

Your VPC is:

```text
Your Private Flat
```

Other customers have their own VPCs.

By default:

```text
Your VPC
≠
Another Customer's VPC
```

They cannot communicate unless explicitly configured.

---

# 🖼️ Architecture Diagram

![AWS VPC](./Images/02-aws-vpc-overview.png)

---

# ⚠️ Default VPC Behavior

Every AWS Region contains:

```text
1 Default VPC
```

Features:

- Preconfigured Networking
- Public Subnet
- Internet Connectivity
- Easy Resource Launch

Useful for:

- Beginners
- Testing
- Learning AWS

Production environments usually use custom VPCs.

---

# 🌉 Communication Between VPCs

By default:

```text
VPC A
    X
VPC B
```

No communication.

To communicate:

```text
VPC Peering
Transit Gateway
VPN
```

Must be configured.

---

# ☁️ AWS Mapping

| Concept | AWS Service |
|----------|------------|
| Global Infrastructure | AWS Regions |
| Data Centers | Availability Zones |
| Networking | VPC |
| High Availability | Multi-AZ |
| VPC Connectivity | VPC Peering |
| Multi-VPC Connectivity | Transit Gateway |

---

# 🎤 Interview Questions

## What is an AWS Region?

A physical geographic location where AWS hosts infrastructure.

---

## What is an Availability Zone?

One or more isolated data centers within a Region.

---

## Why does AWS have multiple AZs?

To provide:

- High Availability
- Fault Tolerance
- Disaster Recovery

---

## What is VPC?

A logically isolated virtual network within AWS.

---

## How many default VPCs exist per Region?

```text
One Default VPC
```

---

## Can two VPCs communicate by default?

```text
No
```

Communication requires:

- VPC Peering
- Transit Gateway
- VPN

---

## Why deploy resources across multiple AZs?

To reduce downtime and improve availability.

---

# 📝 AWS SAA Notes

Remember:

### Region

```text
Geographical Area
```

Example:

```text
Mumbai
Hyderabad
Singapore
```

---

### Availability Zone

```text
Data Centers
Inside Region
```

---

### VPC

```text
Private Network
Inside AWS
```

---

### Default VPC

```text
One Per Region
```

---

### Multi-AZ

```text
High Availability
```

---

### AWS Best Practice

```text
Deploy Across Multiple AZs
```

---

# 📌 Key Takeaways

- AWS infrastructure is organized into Regions and Availability Zones.
- Regions are geographic locations.
- Availability Zones are isolated data centers.
- Multi-AZ deployment improves availability.
- VPC provides isolated networking.
- Each Region contains a default VPC.
- VPCs cannot communicate by default.
- These concepts are fundamental for AWS networking and architecture design.

---

# 🚀 Next Module

Day 09: AWS Networking Components

Topics:

- Subnets
- CIDR Blocks
- Internet Gateway
- NAT Gateway
- Route Tables

---

# 🏆 Summary

AWS Global Infrastructure is built using Regions and Availability Zones to provide scalability, reliability, and fault tolerance.

VPC provides a secure and isolated networking environment where AWS resources are deployed. Understanding Regions, AZs, and VPCs is essential for AWS architecture design and certification preparation.
