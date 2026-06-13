# 🐧 Linux Day 2 - OS Types, Client Server & Linux Architecture

> DevOps + RHCSA + Linux Beginner Journey 🚀

---

# 📚 Topics Covered

* Types of Operating Systems
* Client vs Server
* Linux Architecture
* Shell Basics
* Kernel Basics
* Multi User & Multi Tasking
* Networking Services

---

# 🖼️ Notes Images

## 📷 Types of Operating System

![Types Of OS](./Images/TypesOs.png)

---

## 📷 Client Server Architecture

![Client Server](./Images/clientServer.png)

---

## 📷 Linux Architecture

![Linux Architecture](./Images/Architecture_UNIX.png)

---

## 📷 Server vs Client Difference

![Server vs Client](./Images/DifferenceSerClie.png)

---

# 📌 Types of Operating System

## Single User Single Tasking

### Example

* MS-DOS

### Meaning

One user performs one task at a time.

---

## Single User Multi Tasking

### Example

* Windows

### Meaning

One user performs multiple tasks simultaneously.

Examples:

* Browser
* VS Code
* Music Player

---

## Multi User Multi Tasking

### Example

* UNIX
* Linux

### Meaning

Multiple users can access the system and run multiple tasks at the same time.

---

# 📌 Why Linux is Powerful?

Linux supports:

✅ Multi User

✅ Multi Tasking

✅ Remote Access

✅ Server Environment

---

# 📌 Client vs Server

## Client

Client requests services.

Examples:

* Browser
* Mobile
* Laptop

---

## Server

Server provides services.

Examples:

* Web Server
* Database Server
* Mail Server

---

# 📌 Client Server Flow

```text
Client
   │ Request
   ▼
Server
   │ Response
   ▼
Client
```

---

# 📌 Real Life Example

| Real Life          | Computer |
| ------------------ | -------- |
| Customer           | Client   |
| Restaurant Kitchen | Server   |

---

# 📌 Client OS Examples

* Windows XP
* Windows 7
* Windows 10

Used for:

* Personal Systems
* Desktop Usage

---

# 📌 Server OS Examples

* RHEL
* Windows Server
* Ubuntu Server

Used for:

* Hosting
* Networking
* Enterprise Infrastructure

---

# 📌 Important Server Services

| Service | Purpose                 |
| ------- | ----------------------- |
| HTTP    | Web Service             |
| FTP     | File Transfer           |
| DNS     | Domain Name Resolution  |
| DHCP    | Automatic IP Assignment |
| SMTP    | Send Emails             |
| IMAP    | Receive Emails          |

---

# 📌 HTTP

HTTP = Hyper Text Transfer Protocol

Used for:

* Websites
* Web Applications

Example:

```text
google.com
```

---

# 📌 FTP

FTP = File Transfer Protocol

Used for transferring files between systems.

---

# 📌 DNS

DNS converts:

```text
google.com → IP Address
```

---

# 📌 DHCP

DHCP automatically assigns:

* IP Address
* Gateway
* DNS Information

---

# 📌 SMTP

Used to send emails.

---

# 📌 IMAP

Used to receive emails.

---

# 📌 Linux Architecture

```text
User
 ↓
Shell
 ↓
Kernel
 ↓
Hardware
```

---

# 📌 User

User provides commands.

Examples:

```bash
ls
pwd
cat
```

---

# 📌 Shell

Shell acts as an interface between:

```text
User
 ↓
Shell
 ↓
Kernel
```

---

# 📌 Types of Shell

| Shell | Full Form          |
| ----- | ------------------ |
| SH    | Bourne Shell       |
| BASH  | Bourne Again Shell |
| KSH   | Korn Shell         |
| CSH   | C Shell            |

---

# 📌 BASH

Most commonly used Linux shell.

Used for:

* Running Commands
* Shell Scripting

---

# 📌 Kernel

Kernel is the core of the Operating System.

Responsibilities:

* Memory Management
* Process Management
* Device Management
* File System Management

---

# 📌 Hardware

Examples:

* CPU
* RAM
* Hard Disk
* Devices

---

# 📌 Linux Kernel Type

```text
Linux → Monolithic Kernel
```

---

# 📌 Commands Learned

## uname

```bash
uname -a
```

Shows system information.

---

## ls

```bash
ls
```

Lists files and directories.

---

## cat

```bash
cat file.txt
```

Displays file contents.

---

# 🎤 Interview Questions

### What is Multi User OS?

Multi User OS allows multiple users to access a system simultaneously.

---

### What is Multi Tasking?

Ability to run multiple tasks at the same time.

---

### What is Client?

Client requests services from a server.

---

### What is Server?

Server provides services and resources to clients.

---

### What is Shell?

Shell is an interface between user and kernel.

---

### What is Kernel?

Kernel is the core part of an operating system.

---

### What is DNS?

DNS converts domain names into IP addresses.

---

### What is DHCP?

DHCP automatically assigns IP addresses.

---

### What is HTTP?

HTTP is used for web communication.

---

### What is FTP?

FTP is used for file transfer.

---

# ⚡ Quick Revision

```text
MS-DOS  → Single User Single Tasking

Windows → Single User Multi Tasking

Linux   → Multi User Multi Tasking

Client  → Requests Service

Server  → Provides Service

Shell   → User Interface

Kernel  → Core of OS

HTTP    → Web Service

FTP     → File Transfer

DNS     → Name to IP

DHCP    → Auto IP Assignment

SMTP    → Send Mail

IMAP    → Receive Mail
```

---

# 🚀 DevOps Connection

Linux Architecture, Networking Services, Shell, and Kernel concepts are heavily used in:

* AWS
* Docker
* Kubernetes
* Linux Servers
* CI/CD Pipelines
* DevOps Automation

Strong Linux Fundamentals = Strong DevOps Foundation 🚀
