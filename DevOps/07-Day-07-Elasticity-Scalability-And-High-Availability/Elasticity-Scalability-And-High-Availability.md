# 🚀 Day 07: Elasticity, Scalability & High Availability

## 📖 Overview

Modern cloud applications must be able to handle increasing traffic, unexpected failures, and changing workloads.

AWS provides features that allow applications to:

- Scale resources when demand changes
- Automatically recover from failures
- Remain available with minimal downtime

These concepts are among the most important topics in AWS SAA, DevOps, Cloud Engineering, and System Design interviews.

This module covers:

- Elasticity
- Scalability
- Vertical Scaling
- Horizontal Scaling
- High Availability
- Redundancy
- Fault Tolerance
- Health Checks

---

# 🎯 Learning Objectives

After completing this module, you should be able to:

✅ Explain Elasticity

✅ Explain Scalability

✅ Differentiate Vertical and Horizontal Scaling

✅ Understand High Availability

✅ Understand Fault Tolerance

✅ Explain AWS Auto Scaling

✅ Answer AWS interview questions related to scaling and availability

---

# 🧠 What is Elasticity?

Elasticity means automatically increasing or decreasing resources based on workload.

Imagine:

```text
Morning Traffic → Low
Afternoon Traffic → High
Night Traffic → Low
```

Resources automatically adjust.

Example:

```text
2 Servers
    ↓
10 Servers
    ↓
2 Servers
```

AWS Service:

```text
Auto Scaling Group (ASG)
```

---

## Real-Life Example

Imagine a food delivery app.

```text
Normal Day
    ↓
100 Orders
```

During a festival:

```text
1000 Orders
```

AWS automatically launches more servers.

After traffic decreases:

```text
1000 Orders
    ↓
100 Orders
```

Extra servers are removed automatically.

This is Elasticity.

---

## Architecture Diagram

![Elasticity and Scalability](./Images/01-elasticity-vs-scalability.png)

---

# 📈 What is Scalability?

Scalability means increasing system capacity to handle more workload.

Unlike elasticity, scaling focuses on growth.

Example:

```text
100 Users
    ↓
10,000 Users
```

System capacity increases.

---

## Types of Scalability

### Vertical Scaling (Scale Up)

Increase server size.

Example:

```text
4 GB RAM
    ↓
16 GB RAM
```

```text
2 CPU
    ↓
8 CPU
```

AWS Example:

```text
t2.micro
    ↓
t3.large
```

---

### Horizontal Scaling (Scale Out)

Add more servers.

Example:

```text
1 Server
    ↓
5 Servers
```

Load Balancer distributes traffic.

AWS Example:

```text
Load Balancer
       ↓
EC2
EC2
EC2
EC2
```

---

## Vertical vs Horizontal Scaling

| Feature | Vertical | Horizontal |
|----------|----------|----------|
| Increase Server Size | ✅ | ❌ |
| Add More Servers | ❌ | ✅ |
| Downtime Possible | Yes | No |
| Cloud Preferred | Limited | Yes |
| AWS Best Practice | No | Yes |

---

# 🛡️ What is High Availability?

High Availability (HA) means keeping applications available even when failures occur.

Goal:

```text
Maximum Uptime
Minimum Downtime
```

Example:

```text
Server 1 Fails
      ↓
Server 2 Handles Requests
```

Users should not notice failures.

---

## Key Components

### Redundancy

Create duplicate resources.

Example:

```text
Server A
Server B
Server C
```

All provide the same application.

---

### Monitoring

Continuously check system health.

Example:

```text
Health Checks
```

AWS detects unhealthy servers automatically.

---

### Failover

Traffic automatically shifts to healthy resources.

Example:

```text
Server A Fails
      ↓
Traffic → Server B
```

---

## Architecture Diagram

![High Availability](./Images/02-high-availability-and-fault-tolerance.png)

---

# 🏗️ Fault Tolerance

Fault Tolerance means the application continues working even when components fail.

Example:

```text
One Server Down
      ↓
Application Still Running
```

Goal:

```text
0 Downtime
```

---

# ☁️ AWS Services Used

| Requirement | AWS Service |
|-------------|-------------|
| Elasticity | Auto Scaling |
| Horizontal Scaling | Auto Scaling Groups |
| Traffic Distribution | Application Load Balancer |
| Health Checks | ALB Health Checks |
| High Availability | Multi-AZ |
| Monitoring | CloudWatch |
| Fault Tolerance | Multi-AZ + Redundancy |

---

# 🎤 Interview Questions

## What is Elasticity?

The ability to automatically increase or decrease resources based on demand.

---

## What is Scalability?

The ability of a system to handle increasing workload.

---

## Difference Between Elasticity and Scalability?

Elasticity adjusts resources automatically based on demand.

Scalability increases system capacity to support growth.

---

## What is Vertical Scaling?

Increasing server resources such as CPU or RAM.

---

## What is Horizontal Scaling?

Adding more servers to distribute workload.

---

## What is High Availability?

Keeping applications accessible with minimal downtime.

---

## What is Fault Tolerance?

Ability of a system to continue operating despite failures.

---

## Which AWS Service Provides Elasticity?

```text
Auto Scaling Group (ASG)
```

---

## Which AWS Service Distributes Traffic?

```text
Application Load Balancer (ALB)
```

---

# 📝 AWS SAA Notes

Remember:

### Elasticity

```text
Scale Out
Scale In
Automatically
```

### Scalability

```text
Handle Growth
```

### Vertical Scaling

```text
More RAM
More CPU
```

### Horizontal Scaling

```text
More Servers
```

### High Availability

```text
Minimal Downtime
```

### Fault Tolerance

```text
Zero or Near-Zero Downtime
```

### AWS Best Practice

```text
Horizontal Scaling
+
Load Balancer
+
Auto Scaling
```

---

# 📌 Key Takeaways

- Elasticity automatically adjusts resources.
- Scalability increases system capacity.
- Vertical scaling upgrades a server.
- Horizontal scaling adds more servers.
- High Availability minimizes downtime.
- Fault Tolerance keeps systems running during failures.
- AWS achieves these using Auto Scaling, ALB, Multi-AZ, and CloudWatch.

---

# 🚀 Next Module

Day 08: AWS Global Infrastructure

Topics:

- Regions
- Availability Zones
- Edge Locations
- AWS Global Network
- Multi-AZ Architecture

---

# 🏆 Summary

Elasticity, Scalability, and High Availability are core cloud concepts that enable applications to handle growth, recover from failures, and provide a reliable user experience.

AWS provides Auto Scaling, Load Balancers, Multi-AZ deployments, and monitoring services to build highly available and scalable cloud applications.
