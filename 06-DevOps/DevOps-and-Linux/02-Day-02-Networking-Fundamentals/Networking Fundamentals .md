# 🌐 Day 02 - Networking Fundamentals (DNS & Load Balancers)

## 📌 Goal

Understand how users find applications and how traffic is distributed across servers.

This module covers:

* DNS (Domain Name System)
* Load Balancers
* Traffic Distribution
* Health Checks
* AWS Mapping (Route53 + ALB + NLB)

These are foundational for:

* AWS SAA
* DevOps
* System Design
* Backend Scaling
* High Availability

---

# 🧠 Big Picture First

Before understanding AWS networking:

```text
User
 ↓
DNS
 ↓
Load Balancer
 ↓
Application Server
 ↓
Database
```

This is the base request flow of almost every production system.

Remember:

```text
Find → Balance → Process → Store
```

---

# 1. DNS (Domain Name System)

## What is DNS?

DNS converts domain names into IP addresses.

Example:

```text
google.com → 142.250.183.14
```

Humans remember names.

Machines use IPs.

---

## Why DNS is needed?

Without DNS:

```text
User must remember IP addresses
```

Impossible for real-world scale.

DNS solves this.

---

## How DNS Works

Step by step:

1. User enters domain
2. Browser asks DNS resolver
3. Resolver finds IP
4. Returns IP
5. Browser connects server

Flow:

```text
User → DNS Resolver → Authoritative DNS → IP → Server
```

---

## Real Example

When you type:

```text
amazon.com
```

DNS resolves:

```text
amazon.com → Load Balancer IP
```

Then traffic goes forward.

---

## DNS Diagram

![DNS Resolution Process](./Images/01-dns-resolution-process.png)

---

## Important DNS Records

| Record | Purpose        |
| ------ | -------------- |
| A      | Domain to IPv4 |
| AAAA   | Domain to IPv6 |
| CNAME  | Domain alias   |
| MX     | Mail server    |
| NS     | Name server    |

---

## AWS Mapping

DNS in AWS:

* Route53

Used for:

* Domain registration
* Record management
* Routing

---

## Interview Questions

### What is DNS?

System that maps names to IP.

---

### Why DNS is important?

Makes internet human-friendly.

---

### What port does DNS use?

```text
53
```

UDP mostly.

TCP sometimes.

---

---

# 2. Load Balancer

## What is Load Balancer?

Distributes traffic across multiple servers.

Instead of:

```text
All users → One server
```

It does:

```text
All users → Multiple servers
```

---

## Why needed?

Without Load Balancer:

Problems:

* Single server overload
* Single point of failure
* Slow response

---

## With Load Balancer

Flow:

```text
User → Load Balancer → EC2-1 / EC2-2 / EC2-3
```

Benefits:

* Better scaling
* Better availability
* Better performance

---

## Load Balancer Diagram

![Load Balancer Traffic Distribution](./Images/02-load-balancer-traffic-distribution.png)

---

## Types of Load Balancing

### Round Robin

Requests distributed one by one.

Example:

```text
Req1 → Server1
Req2 → Server2
Req3 → Server3
```

---

### Least Connections

Send request to server with fewer active users.

---

### Weighted

More traffic to stronger servers.

---

## Health Checks

Load Balancer checks:

```text
Is server alive?
```

If unhealthy:

```text
Stops sending traffic
```

This is very important.

---

## AWS Load Balancer Types

### ALB (Application Load Balancer)

Layer 7.

Supports:

* HTTP
* HTTPS

Best for web apps.

---

### NLB (Network Load Balancer)

Layer 4.

Supports:

* TCP
* UDP

Best for performance.

---

## AWS Mapping

Load balancing:

* ALB
* NLB

---

## Interview Questions

### Why use Load Balancer?

To distribute traffic.

---

### What happens if one server dies?

Load Balancer redirects to healthy servers.

---

### Difference between ALB and NLB?

ALB:

* HTTP/HTTPS
* Layer 7

NLB:

* TCP/UDP
* Layer 4

---

---

# 3. DNS + Load Balancer Together

This is production flow:

```text
User
 ↓
DNS
 ↓
Load Balancer
 ↓
Healthy Server
 ↓
Database
```

Step-by-step:

1. User enters domain
2. DNS finds LB
3. LB receives traffic
4. LB picks healthy server
5. Server responds

This is real-world architecture.

---

# AWS Architecture Mapping

```text
User
 ↓
Route53
 ↓
ALB
 ↓
EC2 (Auto Scaling)
 ↓
RDS
```

This is one of the most common AWS interview architectures.

---

# Real System Design Thinking

Traffic growth:

```text
100 users → 1 server
1000 users → DNS + LB
10000 users → Multiple EC2
100000 users → Auto Scaling + Multi-AZ
```

This is how systems scale.

---

# Key Differences

| Feature     | DNS          | Load Balancer      |
| ----------- | ------------ | ------------------ |
| Purpose     | Find server  | Distribute traffic |
| Works on    | Domain names | Requests           |
| AWS Service | Route53      | ALB/NLB            |

---

# 🎯 Key Takeaways

✅ DNS resolves names into IP
✅ Load Balancer distributes traffic
✅ Health checks improve availability
✅ ALB works for web traffic
✅ NLB works for low-level traffic
✅ DNS + LB are core HLD concepts

---

# 🧠 Memory Formula

```text
Find → Balance → Process → Store
```

AWS Mapping:

```text
Find = Route53
Balance = ALB/NLB
Process = EC2
Store = RDS
```

---

# 🏁 Final Summary

Day 02 builds the request-routing foundation.

Without this:

* Route53 won’t make sense
* ELB won’t make sense
* Auto Scaling won’t make sense
* High Availability won’t make sense

Master this deeply.

It appears in:

* DevOps interviews
* AWS SAA
* System Design
* Production architectures
