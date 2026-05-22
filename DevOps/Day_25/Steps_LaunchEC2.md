
# EC2 Instance Creation Steps (Revision Notes)

## 1. Name and Tags

### Name
```text
MyLinuxInstance
````

### Why?

* Easy to identify EC2 instance

---

# 2. AMI (Operating System)

### Selected

```text
Red Hat Enterprise Linux 9 (HVM)
```

### Why?

* Used for RHCSA / DevOps practice
* Enterprise Linux environment

### Important

```text
Username → ec2-user
```

---

# 3. Instance Type

### Selected

```text
t2.micro
```

### Why?

* Free-tier friendly
* Good for beginners
* Low cost

### Specs

```text
1 vCPU
1 GiB RAM
```

---

# 4. Key Pair

### Selected

```text
Om-Aws
```

### Why?

* Used for SSH login securely

---

# 5. VPC

### Selected

```text
Default VPC
```

### Why?

* AWS default network
* Easy beginner setup

---

# 6. Subnet

### Selected

```text
ap-south-1a
```

### Why?

* Defines Availability Zone
* EC2 launched inside subnet

---

# 7. Auto Assign Public IP

### Selected

```text
Enable
```

### Why?

* Required for internet/SSH access

---

# 8. Security Group

### Selected

```text
default
```

### Why?

* Acts like firewall
* Controls inbound/outbound traffic

---

# 9. Storage

### Selected

```text
10 GiB gp3
```

### Why?

* Root disk for OS
* gp3 = SSD storage

---

# 10. IAM Instance Profile

### Selected

```text
None
```

### Why?

* No AWS service access needed currently

---

# 11. Hostname Type

### Selected

```text
IP Name
```

### Why?

* DNS hostname based on IP

---

# 12. Shutdown Behavior

### Selected

```text
Stop
```

### Why?

* Prevent accidental deletion

---

# 13. Termination Protection

### Selected

```text
Disabled
```

### Why?

* Easier for practice/labs

---

# 14. Detailed CloudWatch Monitoring

### Selected

```text
Disabled
```

### Why?

* Avoid extra cost

---

# 15. Credit Specification

### Selected

```text
Standard
```

### Why?

* Default CPU credit behavior

---

# 16. EBS Optimized

### Selected

```text
Disable
```

### Why?

* Not required for beginners

---

# 17. Purchasing Option

### Selected

```text
None (On-Demand)
```

### Why?

* Stable normal EC2 pricing

---

# 18. Metadata Version

### Selected

```text
IMDSv2
```

### Why?

* More secure metadata access

---

# 19. User Data

### Optional Script

```bash
#!/bin/bash
yum update -y
```

### Why?

* Automatically runs commands during launch

---

# Final Launch Summary

```text
AMI            → RHEL 9
Instance Type  → t2.micro
Storage        → 10 GB gp3
Public IP      → Enabled
Security Group → Default
Key Pair       → Om-Aws
Region         → ap-south-1
```

---

# Important Beginner Notes

## After Practice

```text
Stop Instance
Delete Unused Volumes
Check Billing Dashboard
```

---

# SSH Connection

```bash
ssh -i key.pem ec2-user@public-ip
```

```
```
