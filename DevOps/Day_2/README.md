# DevOps Day 2: Networking Fundamentals - DNS & Load Balancers

## 📖 Overview

Day 2 covers **essential networking concepts** that enable communication between services in cloud architectures. Understanding DNS and load balancing is critical for scalable system design.

---

## 🎯 Learning Objectives

✅ Understand DNS (Domain Name System)  
✅ Learn how domain names resolve to IPs  
✅ Understand load balancing concepts  
✅ Know different load balancing strategies  
✅ Understand how traffic is distributed

---

## 📚 Key Concepts

### **1. DNS (Domain Name System)**

DNS translates human-readable domain names into IP addresses.

```
User Types: www.example.com
                  │
                  ▼
              DNS Resolver
                  │
                  ▼
         Returns: 192.0.2.1
                  │
                  ▼
         Browser connects to IP
```

**How it Works:**

1. User enters domain name
2. Browser queries DNS resolver
3. Resolver returns IP address
4. Browser connects to that IP
5. Website loads

**AWS Service**: **Route 53** - AWS's DNS service

---

### **2. Load Balancing**

Distributes incoming traffic across multiple servers for better **availability and performance**.

```
        Incoming Traffic
              │
              ▼
       ┌─────────────┐
       │Load Balancer│
       └──┬──┬──┬────┘
          │  │  │
      ┌───┘  │  └────┐
      │      │       │
    ┌─▼─┐  ┌─▼─┐  ┌──▼─┐
    │EC2│  │EC2│  │EC2 │
    └───┘  └───┘  └────┘
```

**Benefits:**

- **High Availability**: If one server fails, others handle traffic
- **Performance**: Distributes load evenly
- **Scalability**: Easy to add more servers

---

## 🔄 Load Balancing Strategies

### **1. Round Robin**

Distributes requests evenly in rotation:

```
Request 1 → Server 1
Request 2 → Server 2
Request 3 → Server 3
Request 4 → Server 1 (repeat)
```

### **2. Least Connections**

Routes to server with fewest active connections:

```
Server 1: 5 connections
Server 2: 2 connections ← Goes here
Server 3: 4 connections
```

### **3. IP Hash**

Same client always goes to same server:

```
User IP 192.168.1.1 → Always Server 1
User IP 192.168.1.2 → Always Server 2
```

### **4. Weighted Distribution**

Route more traffic to certain servers:

```
Server 1: 50% of traffic (more powerful)
Server 2: 30% of traffic
Server 3: 20% of traffic
```

---

## 🏗️ AWS Load Balancing Options

| Type                  | Best For               | Protocol    |
| --------------------- | ---------------------- | ----------- |
| **ELB** (Classic)     | Basic HTTP/HTTPS       | Layer 4 & 7 |
| **ALB** (Application) | Web apps, APIs         | HTTP/HTTPS  |
| **NLB** (Network)     | Ultra-high performance | TCP/UDP     |

**We'll use: ALB (Application Load Balancer)** - Most common for web apps

---

## 💡 How DNS + Load Balancing Work Together

```
1. User enters www.example.com
              │
              ▼
2. DNS resolves to Load Balancer IP
              │
              ▼
3. Request hits Load Balancer
              │
              ▼
4. Load Balancer chooses a server
              │
              ▼
5. Request forwarded to that server
              │
              ▼
6. Server responds through load balancer
              │
              ▼
7. Response sent back to user
```

---

## 🎯 Real-World Example

### **Without Load Balancer**

```
www.example.com → 192.0.2.1 (single server)
Problem: If server goes down, website is down!
```

### **With Load Balancer**

```
www.example.com → Load Balancer IP
                      │
            ┌─────────┼─────────┐
            ▼         ▼         ▼
        192.0.2.1  192.0.2.2  192.0.2.3
        (Server 1) (Server 2) (Server 3)

Problem Solved: If one server fails, others still work!
```

---

## 📊 Comparison

| Aspect           | Single Server              | Load Balanced                 |
| ---------------- | -------------------------- | ----------------------------- |
| **Availability** | One server fails = Down    | Multiple servers = Redundancy |
| **Performance**  | Limited by server capacity | Scales with more servers      |
| **Cost**         | Low                        | Higher (but worth it)         |
| **Complexity**   | Simple                     | More complex                  |
| **Best For**     | Development                | Production                    |

---

## 🚀 AWS Implementation

**Day 2 Architecture:**

```
Users
  │
  ▼
Route 53 (DNS)
  │
  ▼
Application Load Balancer (ALB)
  │
  ├─► EC2 Instance 1
  ├─► EC2 Instance 2
  └─► EC2 Instance 3
  │
  ▼
RDS Database (Shared)
```

---

## 📋 Checklist

- [ ] Understand what DNS does
- [ ] Know Route 53 for AWS DNS
- [ ] Understand load balancing basics
- [ ] Know different load balancing strategies
- [ ] Understand ALB use cases
- [ ] Can explain DNS + LB together
- [ ] Know when to use load balancers

---

## 💭 Key Takeaways

1. **DNS = Domain to IP translation**
2. **Load Balancer = Traffic distribution**
3. **Together = High availability**
4. **AWS Route 53 = Managed DNS**
5. **AWS ALB = Application load balancer**
6. **Both = Essential for scalable systems**

---

## 🔗 Connections to Other Days

- **Day 1**: Architecture patterns (load balancing enables scaling)
- **Day 3**: Network protocols (how traffic flows)
- **Day 8**: AWS Global infrastructure
- **Day 23**: Advanced load balancing features
- **Day 25+**: Practical ALB setup and configuration

---

## 🎓 For AWS SAA Exam

**Must Know:**
✅ DNS basics and Route 53  
✅ Load balancing concepts  
✅ ALB vs NLB use cases  
✅ When to use each load balancer  
✅ Health checks and failover

---

## 🏆 Summary

| Concept           | Purpose            | AWS Service      |
| ----------------- | ------------------ | ---------------- |
| DNS               | Domain → IP lookup | Route 53         |
| Load Balancer     | Distribute traffic | ALB / NLB        |
| High Availability | Survive failures   | Multiple servers |
| Scalability       | Handle growth      | More servers     |

---

**Load balancing is essential for production systems!** 🚀

Next: **Day 3 - Network Protocols & Communication**

---

_Perfect for AWS SAA Certification Preparation_
