# ☁️ Day 01: Architecture Fundamentals

## 📖 Overview

Architecture is the foundation of every application deployed in the cloud.

Before learning AWS services such as EC2, Load Balancer, Auto Scaling, RDS, or VPC, it is important to understand how applications are designed and how different architecture patterns solve scalability, availability, and performance challenges.

This module covers:

* Client-Server Architecture
* 1-Tier Architecture
* 2-Tier Architecture
* 3-Tier Architecture

These concepts are frequently asked in AWS SAA, DevOps, Cloud Engineer, and System Design interviews.

---

# 🎯 Learning Objectives

After completing this module, you should be able to:

✅ Explain how client-server communication works

✅ Differentiate between 1-tier, 2-tier, and 3-tier architectures

✅ Understand scalability limitations of monolithic systems

✅ Map architecture patterns to AWS services

✅ Identify suitable architecture for different business requirements

---

# 1️⃣ Client-Server Architecture

## What Problem Does It Solve?

Applications need a way for users to request data and receive responses.

The Client-Server model separates:

* Client → Requests data
* Server → Processes requests and returns responses

---

## How It Works

1. User opens browser
2. Browser sends request
3. Server processes request
4. Server returns response
5. Browser displays result

---

## Real-World Example

When you open:

* Google
* YouTube
* Amazon

Your browser acts as a client and communicates with a remote server.

---

## Architecture Diagram

![Client Server Architecture](./Images/01-client-server-architecture.png)

---

## AWS Mapping

| Component | AWS Service          |
| --------- | -------------------- |
| Client    | Browser / Mobile App |
| Server    | EC2                  |
| DNS       | Route 53             |
| CDN       | CloudFront           |

---

# 2️⃣ Single-Tier (1-Tier) Architecture

## What Is It?

All components run on a single machine:

* User Interface
* Application Logic
* Database

Everything exists in one place.

---

## Advantages

* Easy setup
* Low cost
* Good for learning

---

## Limitations

* Single point of failure
* Difficult to scale
* Poor reliability

---

## Real-World Use Cases

* Student projects
* Local applications
* Proof of Concepts

---

## Architecture Diagram

![1 Tier Architecture](./Images/02-one-tier-architecture.png)

---

## AWS Example

Single EC2 Instance:

* Frontend
* Backend
* Database

running together.

---

# 3️⃣ Two-Tier (2-Tier) Architecture

## What Is It?

Application and database are separated.

### Application Server

Handles:

* Business Logic
* API Requests
* User Interaction

### Database Server

Handles:

* Data Storage
* Queries
* Transactions

---

## Advantages

* Better security
* Easier maintenance
* Improved scalability

---

## Limitations

* Application server can become bottleneck
* Limited horizontal scaling

---

## Real-World Use Cases

* Medium-sized applications
* Internal company portals
* Small SaaS products

---

## Architecture Diagram

![2 Tier Architecture](./Images/03-two-tier-architecture.png)

---

## AWS Example

Application Layer:

* EC2

Database Layer:

* Amazon RDS

---

# 4️⃣ Three-Tier (3-Tier) Architecture

## What Is It?

Application is divided into:

### Presentation Layer

User Interface

### Application Layer

Business Logic

### Database Layer

Persistent Storage

---

## Advantages

* Better separation of concerns
* Easier scaling
* Improved security
* Better maintainability

---

## Real-World Use Cases

* E-Commerce Platforms
* Banking Applications
* Enterprise Systems

---

## Architecture Diagram

![3 Tier Architecture](./Images/04-three-tier-architecture.png)

---

## AWS Example

Presentation Layer:

* CloudFront
* Route 53

Application Layer:

* EC2
* Auto Scaling Group

Database Layer:

* Amazon RDS

---

# 📊 Architecture Comparison

| Feature      | 1-Tier | 2-Tier   | 3-Tier |
| ------------ | ------ | -------- | ------ |
| Complexity   | Low    | Medium   | High   |
| Cost         | Low    | Medium   | High   |
| Scalability  | Poor   | Moderate | Good   |
| Availability | Poor   | Better   | High   |
| Security     | Low    | Medium   | High   |
| Maintenance  | Easy   | Moderate | Easier |

---

# 🎤 Interview Questions

### What is Client-Server Architecture?

A model where clients send requests and servers process and return responses.

---

### Why is 1-Tier Architecture not suitable for production?

Because all components run on a single machine, creating a single point of failure and scalability limitations.

---

### Why is 2-Tier Architecture better than 1-Tier?

Database and application layers are separated, improving maintainability and security.

---

### What are the layers in 3-Tier Architecture?

* Presentation Layer
* Application Layer
* Database Layer

---

### Which architecture is commonly used in AWS?

3-Tier Architecture because it provides scalability, security, and maintainability.

---

# 📝 AWS SAA Exam Notes

Remember:

* EC2 = Compute Layer
* RDS = Database Layer
* Route 53 = DNS Layer
* CloudFront = Content Delivery Layer
* ALB = Traffic Distribution Layer

Exam questions often focus on:

* Scalability
* High Availability
* Fault Tolerance
* Separation of Concerns

---

# 🚀 Key Takeaways

* Client-Server is the foundation of web applications.
* 1-Tier is simple but not scalable.
* 2-Tier separates application and database.
* 3-Tier improves scalability and maintainability.
* Modern AWS architectures are built on multi-tier principles.
* Understanding these patterns is essential for AWS SAA and DevOps interviews.

---

# 📚 Next Module

Day 02: Networking Fundamentals

Topics:

* DNS
* IP Address
* Public vs Private Network
* Load Balancer Basics
* Ports and Protocols

These concepts will be used throughout the AWS journey.
