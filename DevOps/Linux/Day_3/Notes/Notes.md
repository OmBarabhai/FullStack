# 🐧 Linux Day 3 — Linux File System & Boot Process
> RHCSA + DevOps + Interview Preparation Notes 🚀

---

# 📚 Topics Covered Today

- Linux File System
- Root Directory
- Boot Process
- BIOS & Boot Loader
- Linux Directories
- Root User vs Normal User
- RAM & Swap
- /proc information
- Modern Linux Structure

---

# 🖼️ Architecture Diagram

![Linux Directory Structure](./DIR.png)

---

# 📌 Linux Root Directory

Linux starts from:

```text
/
````

This is called:

```text
Top Level Directory
```

Everything in Linux comes under `/`.

---

# 🧠 Linux File System Structure

```text
/
├── /root
├── /home
├── /boot
├── /etc
├── /bin
├── /sbin
├── /usr
├── /opt
├── /proc
├── /var
├── /tmp
├── /mnt
├── /media
├── /dev
└── /lib
```

---

# 👤 Users in Linux

## 🔹 Root User

```text
root → Admin User
UID → 0
```

Root user has:

* Full permissions
* Full system access

Home directory:

```text
/root
```

---

## 🔹 Normal User

Example:

```text
/home/om
/home/student
```

Normal users store files in:

```text
/home/username
```

---

# 📂 Important Directories

---

# 📁 /home

Contains:

* Normal user folders
* Personal files

Example:

```text
/home/om
```

---

# 📁 /root

Home directory of:

* root user

---

# 📁 /boot

Contains:

* Boot files
* Kernel boot data
* GRUB files

---

# 🚀 Boot Loaders

| Boot Loader | Used In        |
| ----------- | -------------- |
| GRUB2       | RHEL 7/8/9     |
| GRUB        | Older Linux    |
| LILO        | Very old Linux |

---

# 📁 /etc

Contains:

* Configuration files

Examples:

* network configs
* user configs
* service configs

---

# 📁 /bin

Contains essential user commands.

Examples:

```bash
ls
cat
cp
mv
pwd
```

---

# 📁 /sbin

Contains system admin commands.

Examples:

```bash
reboot
shutdown
fdisk
```

Mostly used by:

```text
root user
```

---

# 📁 /usr

Contains:

* User applications
* Software
* Libraries

---

# 📁 /opt

Used for:

* Optional software
* Third-party applications

---

# 📁 /proc

Virtual directory.

Contains:

* CPU info
* Memory info
* Running process info

---

# 🧪 Important Commands

## CPU Information

```bash
cat /proc/cpuinfo
```

---

## Memory Information

```bash
cat /proc/meminfo
```

---

# 🧠 RAM vs Swap

| RAM             | Swap           |
| --------------- | -------------- |
| Physical Memory | Virtual Memory |

Swap helps when RAM becomes full.

---

# 📁 /var

Contains:

* Logs
* Cache
* Mail
* Temporary changing data

---

# 📁 /var/log

Stores:

```text
System logs
```

Important for:

* DevOps
* Troubleshooting
* Monitoring

---

# 📁 /tmp

Used for:

* Temporary files

---

# 📁 /mnt

Used for:

* Manual mounting

Examples:

* USB
* External drives

---

# 📁 /media

Used for:

* Automatically mounted devices

Examples:

* Pendrive
* DVD

---

# 📁 /dev

Contains:

* Device files

Examples:

* Hard disk
* USB
* Terminal devices

---

# 📁 /lib

Contains:

* System libraries
* Shared libraries

Required by:

* Commands
* Programs

---

# 🏗️ Modern Linux Structure

Modern Linux internally links:

```text
/bin    → /usr/bin
/sbin   → /usr/sbin
/lib    → /usr/lib
/lib64  → /usr/lib64
```

---

# 💻 BIOS & Boot Process

```text
Power ON
   ↓
BIOS / UEFI
   ↓
Boot Loader (GRUB2)
   ↓
Kernel
   ↓
Systemd / Init
   ↓
Login Screen
```

---

# ⌨️ BIOS Keys

| Key | Purpose    |
| --- | ---------- |
| F2  | BIOS Setup |
| F12 | Boot Menu  |
| DEL | BIOS       |
| ESC | Exit       |

(May vary by system)

---

# 💿 ISO File

```text
.iso
```

ISO contains:

* OS installer
* Bootable image

Examples:

* Ubuntu ISO
* Windows ISO

---

# 📌 Important Linux Paths

| Path     | Purpose         |
| -------- | --------------- |
| /home    | User files      |
| /root    | Root user       |
| /etc     | Config files    |
| /var/log | Logs            |
| /proc    | System info     |
| /tmp     | Temporary files |

---

# 🧪 Commands Practiced

```bash
pwd
ls
cd
mkdir
touch
uname -a
```

---

# 🎯 RHCSA Important Concepts

Focus more on:

✅ File System
✅ Boot Process
✅ Users
✅ Commands
✅ Logs
✅ Root User
✅ Linux Directories

---

# ❓ Interview Questions

---

# What is `/proc`?

> `/proc` is virtual file system containing process and system information.

---

# What is `/etc`?

> `/etc` stores Linux configuration files.

---

# What is `/var/log`?

> `/var/log` stores system log files.

---

# What is GRUB2?

> GRUB2 is Linux boot loader used during system startup.

---

# Difference Between `/bin` and `/sbin`?

| /bin          | /sbin          |
| ------------- | -------------- |
| User commands | Admin commands |

---

# What is Swap Memory?

> Swap is virtual memory used when RAM becomes full.

---

# 🚀 DevOps Connection

These concepts are used in:

* AWS EC2
* Docker
* Kubernetes
* Linux Servers
* Monitoring
* CI/CD

---

# 🏆 Day 3 Summary

Today I learned:

✅ Linux File System
✅ Root Directory
✅ Linux Directories
✅ Boot Process
✅ GRUB2
✅ RAM & Swap
✅ `/proc`
✅ `/etc`
✅ `/var/log`

---

# 🎯 Final Goal

```text
Linux Basics
   ↓
Linux Commands
   ↓
File System
   ↓
Users & Permissions
   ↓
Shell Scripting
   ↓
AWS + Docker + Kubernetes
```

Strong Linux fundamentals = Strong DevOps Engineer 🚀

---

```
```
