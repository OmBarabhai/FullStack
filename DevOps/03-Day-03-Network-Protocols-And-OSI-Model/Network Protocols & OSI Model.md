# 🌐 Day 03 - Network Protocols & OSI Model

## 📌 Goal

Understand how devices communicate over a network and how AWS networking works internally.

This module covers:

* OSI Model
* Network Protocols
* TCP vs UDP
* HTTP vs HTTPS
* Port Numbers
* Port Mapping
* AWS Networking Mapping

These are core for:

* AWS SAA
* DevOps
* Linux
* System Design
* Networking Interviews

---

# 🧠 Big Picture First

Before AWS, understand this:

```text
User
 ↓
DNS
 ↓
Load Balancer
 ↓
Server
 ↓
Database
```

But internally data travels through:

```text
Application → Transport → Network → Data Link → Physical
```

That is OSI.

---

# 1. OSI Model (7 Layers)

OSI (Open Systems Interconnection) explains how data moves from sender to receiver.

Think:

```text
Sender → Network → Receiver
```

Everything travels layer by layer.

---

# Easy Memory Trick (Boy & Girl Example)

This is for memory only.

In interviews explain technical definition.

Imagine:

```text
Boy wants to send message to Girl
```

Message moves through all layers.

---

## Layer 7 - Application

Boy says:

```text
Hi 👋
```

Communication starts here.

Protocols:

* HTTP
* HTTPS
* FTP
* SMTP
* DNS

Real world:

```text
Open google.com
```

---

## Layer 6 - Presentation

Boy decides:

```text
Which language?
```

Makes sure both understand.

Handles:

* Encryption
* Compression
* Encoding

Example:

```text
HTTPS encryption
```

---

## Layer 5 - Session

Boy starts conversation:

```text
Hello, are you there?
```

Maintains connection.

Used for:

* Start session
* Maintain session
* End session

Example:

```text
Login session
```

---

## Layer 4 - Transport

Boy decides:

```text
Should I send safely or quickly?
```

Protocols:

* TCP
* UDP

This decides delivery type.

---

## Layer 3 - Network

Boy asks:

```text
Where does she live?
```

Uses IP address.

Example:

```text
192.168.1.10
```

Device:

Router

---

## Layer 2 - Data Link

Boy asks:

```text
Which exact house?
```

Uses MAC address.

Example:

```text
AA:BB:CC:DD
```

Device:

Switch

---

## Layer 1 - Physical

Boy physically delivers.

Uses:

* Cable
* Fiber
* Wireless

---

# OSI Summary Table

| Layer | Name         | Work                | Example |
| ----- | ------------ | ------------------- | ------- |
| 7     | Application  | User interaction    | HTTP    |
| 6     | Presentation | Encryption          | SSL/TLS |
| 5     | Session      | Maintain session    | Login   |
| 4     | Transport    | Delivery            | TCP/UDP |
| 3     | Network      | Routing             | IP      |
| 2     | Data Link    | Local delivery      | MAC     |
| 1     | Physical     | Actual transmission | Cable   |

---

## OSI Diagram

![OSI Model](./Images/01-osi-model-seven-layers.png)

---

# Real Packet Flow

When opening:

```text
amazon.com
```

Flow:

```text
Application (HTTP request)
 ↓
Transport (TCP)
 ↓
Network (IP)
 ↓
Data Link (MAC)
 ↓
Physical (Cable/Wifi)
 ↓
Internet
 ↓
Server
```

This is actual communication.

---

# 2. TCP vs UDP

Both belong to:

```text
Layer 4
```

---

# TCP (Reliable)

Think:

Boy wants important message delivered.

So he checks:

```text
Did you get it?
```

Features:

* Reliable
* Ordered
* Error checking
* Connection oriented

Examples:

* HTTP
* HTTPS
* SSH
* FTP
* MySQL

Used in:

* Banking
* Login systems
* Database

---

## TCP Handshake (Very Important)

Before talking:

```text
Boy → SYN
Girl → SYN-ACK
Boy → ACK
```

Connection established.

Memory:

```text
Knock → Open → Enter
```

---

# UDP (Fast)

Think:

Boy shouts:

```text
I LOVE YOU
```

No confirmation.

Fast.

Features:

* Fast
* No guarantee
* No order
* Connectionless

Examples:

* DNS
* Gaming
* Video streaming
* Calls

---

## TCP vs UDP Table

| Feature    | TCP      | UDP          |
| ---------- | -------- | ------------ |
| Reliable   | Yes      | No           |
| Fast       | No       | Yes          |
| Ordered    | Yes      | No           |
| Connection | Required | Not Required |

---

## Protocol Diagram

![Network Protocols](./Images/02-network-protocols-overview.png)

---

# 3. HTTP vs HTTPS

---

## HTTP

Port:

```text
80
```

Example:

```text
http://example.com
```

Features:

* Unencrypted
* Less secure

Think:

```text
Anyone can read message
```

---

## HTTPS

Port:

```text
443
```

Example:

```text
https://example.com
```

Features:

* Encrypted
* Secure

Think:

```text
Secret message inside lock 🔒
```

---

## HTTP vs HTTPS Table

| Feature    | HTTP | HTTPS |
| ---------- | ---- | ----- |
| Port       | 80   | 443   |
| Encryption | No   | Yes   |
| Security   | Low  | High  |

---

# 4. Important Ports

| Service    | Port  |
| ---------- | ----- |
| SSH        | 22    |
| HTTP       | 80    |
| HTTPS      | 443   |
| DNS        | 53    |
| FTP        | 21    |
| SMTP       | 25    |
| MySQL      | 3306  |
| PostgreSQL | 5432  |
| MongoDB    | 27017 |
| RDP        | 3389  |

---

# Why Ports Matter in AWS?

Security Groups use ports.

Example:

```text
Port 22 → SSH
Port 80 → Website
Port 443 → Secure Website
Port 3306 → MySQL
```

Without opening ports:

No communication.

---

# 5. Port Mapping

Example:

User accesses:

```text
Port 80
```

But app runs on:

```text
Port 8080
```

Flow:

```text
User
 ↓
Load Balancer :80
 ↓
Application :8080
```

This is Port Mapping.

Purpose:

* Hide internal ports
* Security
* Reverse proxy

---

## Port Mapping Diagram

![Port Mapping](./Images/03-port-forwarding-load-balancer.png)

---

# AWS Mapping

| Concept          | AWS Service     |
| ---------------- | --------------- |
| DNS              | Route53         |
| Layer 4          | NLB             |
| Layer 7          | ALB             |
| Firewall         | Security Groups |
| Network Firewall | NACL            |
| Routing          | Route Tables    |
| Private Network  | VPC             |

---

# System Design Connection

Real production flow:

```text
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

Protocols:

```text
HTTPS → ALB
TCP → Database
SSH → EC2
DNS → Route53
```

This is why networking matters.

---

# Interview Questions

## What is OSI?

A framework for network communication.

---

## Which layer uses IP?

Layer 3

---

## Which layer uses MAC?

Layer 2

---

## What is TCP handshake?

```text
SYN → SYN-ACK → ACK
```

---

## HTTP port?

```text
80
```

---

## HTTPS port?

```text
443
```

---

## SSH port?

```text
22
```

---

# 🎯 Key Takeaways

✅ OSI explains data travel
✅ Boy-Girl analogy helps memory
✅ TCP gives reliability
✅ UDP gives speed
✅ HTTP uses port 80
✅ HTTPS uses port 443
✅ Security Groups depend on ports
✅ AWS networking depends on protocols

---

# 🧠 Memory Formula

```text
Talk → Pack → Route → Deliver
```

AWS Mapping:

```text
Talk = HTTP/HTTPS
Pack = TCP/UDP
Route = IP
Deliver = AWS Network
```

---

# 🏁 Final Summary

Day 03 builds your networking brain.

Without this:

* Security Groups won’t make sense
* ALB/NLB won’t make sense
* Route Tables won’t make sense
* VPC won’t make sense

Master this.

This is one of the strongest foundations for:

* AWS SAA
* DevOps
* System Design
* Backend Engineering
