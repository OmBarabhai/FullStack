# EC2 Networking Notes

## Public IP vs Private IP

### Private IP
- Used for internal AWS network communication
- Every EC2 instance gets a private IP
- Examples:
  - `10.x.x.x`
  - `172.x.x.x`
  - `192.168.x.x`

### Public IP
- Used for internet access
- Required for SSH from your laptop/system
- Optional in AWS

---

# NIC (Network Interface Card)

In AWS:
- NIC = ENI (Elastic Network Interface)

Example structure:

```text
EC2 Instance
│
├── NIC-1 (Primary ENI)
│     ├── Private IP
│     └── Optional Public IP
│
└── NIC-2 (Optional Secondary ENI)
      └── Additional Private IPs
````

---

# Important AWS Rule

## Auto-assign Public IP works ONLY when:

* EC2 has one network interface (NIC-1 only)

If you add:

* NIC-2
* multiple ENIs

AWS shows error:

```text
Auto-assign IP can only be assigned
to instances with one network interface.
```

---

# Correct Understanding

## Default EC2 Setup

```text
EC2
 └── NIC-1
      ├── Private IP
      └── Public IP
```

This is the most common beginner setup.

---

# Multiple NIC Setup

```text
EC2
├── NIC-1
│    └── Private IP
│
└── NIC-2
     └── Another Private IP
```

In multi-NIC setup:

* Auto public IP is disabled
* Public IP must be managed manually

---

# Notes

```text
NIC-1 (Primary ENI)
- Has private IP
- Can also have public IP

NIC-2 (Secondary ENI)
- Usually used for additional private networking
- Used in advanced networking setups
```

---

# Real-world Use of Multiple NICs

Used for:

* Firewall appliances
* Load balancers
* Security separation
* Multi-network architecture

Not usually needed for beginners.

---

# Primary IP vs Secondary IP

## Question

Can one EC2 instance have multiple private IPs?

## Answer

Yes. One EC2 instance can have:

* One Primary Private IP
* Multiple Secondary Private IPs

---

# Primary Private IP

* Default IP assigned to EC2
* Used for main communication
* Cannot be removed

Example:

```text
10.0.0.10
```

---

# Secondary Private IP

* Additional private IPs
* Used when server/network gets overloaded
* Helps handle multiple applications/services
* Can be added or removed manually

Example:

```text
10.0.0.11
10.0.0.12
```

---

# Simple Structure

```text
EC2 Instance
│
├── Primary Private IP
│     └── Main Server Traffic
│
└── Secondary Private IPs
      └── Additional Traffic / Applications
```

---

# IPv4 vs IPv6 in EC2

```text
EC2 Instance
│
├── IPv4
│     ├── Private IP
│     └── Public IP
│
└── IPv6
      └── Public IP
```

---

# Difference

## IPv4

* Supports:

  * Private IP
  * Public IP

* Most commonly used in AWS

Example:

```text
Private IP → 10.0.0.10
Public IP  → 52.x.x.x
```

---

## IPv6

* Currently mainly used as Public IP in AWS
* Globally unique address
* No NAT required

Example:

```text
2406:da1a:abcd::1234
```

---

# ENA vs ENA Express

## ENA

* ENA = Elastic Network Adapter
* High-speed networking for EC2
* Used for normal enhanced networking

---

## ENA Express

* Advanced version of ENA
* Lower latency
* Higher packet processing performance
* Used for high-performance applications

---

# Use Cases

* HPC (High Performance Computing)
* Real-time applications
* Large-scale distributed systems
* High network traffic workloads

---

# Simple Structure

```text
EC2 Instance
│
├── ENA
│     └── Enhanced Networking
│
└── ENA Express
      └── Ultra Low Latency + High Throughput
```

---

# Important Point

* ENA = Default enhanced networking
* ENA Express = Faster optimized networking

---

# EC2 Advanced Details Notes

## Domain Join Directory

* Connect EC2 to Active Directory
* Used in enterprise Windows environments

---

## IAM Instance Profile

* Attach IAM Role to EC2
* Gives permissions without access keys

Example:

```text
EC2 → S3 Access
```

---

## Hostname Type

* Defines EC2 hostname format

Options:

* IP name
* Resource name

---

## DNS Hostname

* Creates DNS records for EC2

### IPv4 (A Record)

```text
example.com → 52.x.x.x
```

### IPv6 (AAAA Record)

```text
example.com → 2406:xxxx::
```

---

## Instance Auto Recovery

* AWS automatically recovers failed instance

---

## Shutdown Behavior

### Stop

* Instance stopped
* Data remains

### Terminate

* Instance deleted permanently

---

## Hibernate

* Saves RAM state
* Resume from same state later

---

## Termination Protection

* Prevents accidental EC2 deletion

---

## Stop Protection

* Prevents accidental stop

---

## Detailed CloudWatch Monitoring

* Sends monitoring every 1 minute
* Better monitoring
* Extra cost possible

---

## Credit Specification

### Standard

* Default CPU credit behavior for burstable instances

---

## Placement Group

* Controls EC2 placement strategy
* Improves performance/availability

---

## EBS Optimized

* Dedicated bandwidth for EBS storage

---

## Purchasing Options

### On-Demand

* Pay normally

### Spot Instance

* Very cheap unused AWS capacity
* Can terminate anytime

### Capacity Reservation

* Reserve capacity in AWS

---

## Tenancy

### Shared

* Default hardware sharing

### Dedicated

* Dedicated physical server

---

## Nitro Enclave

* Extra security isolation for sensitive workloads

---

## Metadata Version

### IMDSv2

* Recommended secure metadata version

---

## User Data

* Run scripts automatically during EC2 launch

Example:

```bash
#!/bin/bash
yum update -y
```

---

# Important Beginner Settings

Recommended for learning:

```text
IAM Profile          → None
Termination Protect  → Disabled
Detailed Monitoring  → Disabled
Purchasing Option    → On-Demand
Tenancy              → Shared
Metadata Version     → IMDSv2
```

```
```
