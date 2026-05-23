# EC2 Practical Tasks

---

# TASK 1

## Launch Windows 2019 EC2 Instance

### Step 1 to Step 7
- Launch Windows 2019 EC2 Instance
- Create a Key Pair
- Save Key Pair safely

### Add Security Group Rule
- Add a new rule:
```text
RDP Protocol
Port → 3389
Source → My IP
````

### Important

```text id="wkex0m"
Do NOT modify default rule
```

### Connect to Windows Machine

Use:

```text id="jlwmkt"
Remote Desktop Protocol (RDP)
```

### Login Credentials

```text id="wjx8bn"
Username → Administrator
Password → Decrypted using Key Pair
```

### Status

```text id="jlwmku"
✅ DONE
```

---

# TASK 2

## Launch Linux RedHat EC2 Instance and Connect

### Download Tools

* Download PuTTY
* Download PuTTYgen

---

## Convert PEM to PPK using PuTTYgen

### Steps

```text id="jlwmkv"
Open PuTTYgen
→ Load
→ Choose PEM File
→ Save Private Key
→ Save as xxxx.ppk
```

---

## Add Security Group Rule

### Add Rule

```text id="jex7xk"
SSH Protocol
Port → 22
Source → My IP
```

### Important

```text id="jlwmkw"
Do NOT modify default rule
```

---

## Connect Using PuTTY

### Steps

```text id="jlwmkx"
Hostname → Public IP
→ Expand SSH
→ Select Auth
→ Browse PPK File
```

### Login

```text id="jlwmky"
Username → ec2-user
```

### Status

```text id="jlwmkz"
✅ DONE
```

---

# TASK 3

## Stop and Start EC2 Instance

### Observation

```text id="jlwml0"
Public IP changes after Stop and Start
```

### Status

```text id="jlwml1"
✅ DONE
```

---

# TASK 4

## Assign Elastic IP (EIP)

### Steps

```text id="jlwml2"
EC2
→ Elastic IPs
→ Allocate Elastic IP
→ Select EIP
→ Actions
→ Associate Elastic IP
→ Select Instance
```

### Observation

```text id="jlwml3"
Elastic IP does NOT change after Stop and Start
```

### Status

```text id="jlwml4"
✅ DONE
```

---

# TASK 5

## Dissociate EIP and Release to AWS

### Steps

```text id="jlwml5"
Elastic IP
→ Actions
→ Disassociate Elastic IP
→ Actions
→ Release Elastic IP
```

### Status

```text id="jlwml6"
✅ DONE
```

---

# WHAT I LEARNED

## EC2 Operations

```text id="jlwml7"
Launch
Stop
Start
Terminate
```

---

## Networking

```text id="jlwml8"
Public IP
Private IP
Elastic IP
Security Groups
```

---

## Connectivity

```text id="jlwml9"
SSH
RDP
PuTTY
Remote Desktop
```

---

## Authentication

```text id="jlwmla"
Key Pair
PEM
PPK
```

---

## AWS Concepts

```text id="jlwmlb"
Dynamic Public IP
Static Public IP
Firewall Rules
Linux Access
Windows Access
```

---

# IMPORTANT AWS PRACTICE

## After Practicing

```text id="jlwmlc"
Stop/Terminate EC2
Release Elastic IP
Delete Unused Resources
Check Billing Dashboard
```

---

## Keep Only

```text id="jlwmld"
Key Pair
Security Group
```

---

# HOW TO EXPLAIN IN INTERVIEW

## Short Explanation

```text id="jlwmle"
I worked on AWS EC2 practicals where I launched Windows and Linux instances, configured Security Groups for RDP and SSH access, connected using Remote Desktop and PuTTY, converted PEM to PPK using PuTTYgen, tested dynamic public IP behavior, assigned Elastic IPs for static addressing, and released resources properly to avoid AWS charges.
```

---

# CURRENT LEVEL

```text id="jlwmlf"
Basic AWS EC2 Hands-on Practical Knowledge
```

```
```
