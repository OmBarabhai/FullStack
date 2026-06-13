# 🐧 Linux Day 07 - man, sort, sed & find

![Linux Commands](./Images/Commands.png)

---

# 🎯 Goal

Learn how to:

* Read Linux documentation
* Sort data
* Replace text
* Search files and directories

Used heavily in:

* Linux Administration
* DevOps
* Shell Scripting
* AWS EC2
* Troubleshooting

---

# 📌 man Command

```text
man = Manual
```

Used to access Linux command documentation.

---

# 📌 Search Manual Pages

```bash
man -k passwd
```

Searches all manual pages related to:

```text
passwd
```

---

# 📌 Manual Sections

| Section | Purpose                        |
| ------- | ------------------------------ |
| 1       | User Commands                  |
| 5       | Configuration Files            |
| 8       | System Administration Commands |

---

# 📌 Open Specific Manual Section

```bash
man 1 passwd
```

User command documentation.

```bash
man 5 passwd
```

Configuration file documentation.

---

# 📌 Important man Options

| Command | Purpose                      |
| ------- | ---------------------------- |
| man -k  | Search Keyword               |
| man -t  | Convert Manual to PostScript |
| man man | Manual of man                |

---

# 📌 Create PostScript Manual

```bash
man -t passwd > passwd.ps
```

Creates:

```text
passwd.ps
```

---

# 📌 Check File Type

```bash
file passwd.ps
```

---

# 📌 View PostScript File

```bash
gv passwd.ps
```

---

# 📌 sort Command

Used to sort data line by line.

---

# 📌 Alphabetical Sort

```bash
sort xyz
```

---

# 📌 Numeric Sort

```bash
sort -n xyz
```

Sorts numbers correctly.

---

# 📌 Reverse Sort

```bash
sort -r xyz
```

Sorts in descending order.

---

# 📌 Unique Sort

```bash
sort -u xyz
```

Removes duplicate entries.

---

# 📌 sort Options

| Option | Purpose       |
| ------ | ------------- |
| -n     | Numeric Sort  |
| -r     | Reverse Sort  |
| -u     | Unique Values |

---

# 📌 sed Command

```text
sed = Stream Editor
```

Used for search and replace operations.

---

# 📌 Replace First Match

```bash
sed 's/linux/windows/1' file1
```

---

# 📌 Replace Second Match

```bash
sed 's/linux/windows/2' file1
```

---

# 📌 Replace All Matches

```bash
sed 's/linux/windows/g' file1
```

---

# 📌 Save Modified Output

```bash
sed 's/linux/windows/g' file1 > file2
```

---

# 📌 sed Syntax

```text
s = substitute

g = global
```

---

# 📌 find Command

Used to search files and directories.

---

# 📌 Search by Name

```bash
find / -name file1
```

---

# 📌 Search by Inode

```bash
find / -inum 42029
```

---

# 📌 Search by User

```bash
find / -user om
```

---

# 📌 Search by Type

Block Device:

```bash
find / -type b
```

Character Device:

```bash
find / -type c
```

---

# 📌 Search by Size

```bash
find / -size +10k
```

Files larger than 10 KB.

---

# 📌 Hide Permission Errors

```bash
find / -name file1 2>/dev/null
```

Sends errors to Linux trash can.

---

# 📌 find Options

| Option | Purpose         |
| ------ | --------------- |
| -name  | Search by Name  |
| -inum  | Search by Inode |
| -user  | Search by Owner |
| -type  | Search by Type  |
| -size  | Search by Size  |

---

# 📌 Real DevOps Examples

Find log files:

```bash
find /var/log -name "*.log"
```

Find files owned by root:

```bash
find / -user root
```

Replace text in configuration:

```bash
sed 's/http/https/g' config.txt
```

Sort log entries:

```bash
sort logs.txt
```

---

# 🎤 Interview Questions

### What is man?

man is the Linux manual command used to view documentation.

---

### What does man -k do?

Searches manuals related to a keyword.

---

### What is sort -n?

Sorts numeric values.

---

### What is sort -u?

Removes duplicate lines while sorting.

---

### What is sed?

sed is a Stream Editor used for text replacement.

---

### What does sed 's///g' mean?

Replace all occurrences of a pattern.

---

### What is find?

find is used to search files and directories.

---

### What is inode?

An inode is a unique identifier assigned to a file in Linux.

---

### Why use 2>/dev/null?

To hide permission denied errors.

---

# ⚡ Quick Revision

```text
man      → Manual

man -k   → Search Manual

sort     → Sort Data

sort -n  → Numeric Sort

sort -r  → Reverse Sort

sort -u  → Unique Values

sed      → Stream Editor

s///g    → Replace All

find     → Search Files

-name    → By Name

-inum    → By Inode

-user    → By Owner

-type    → By Type

-size    → By Size

2>/dev/null → Hide Errors
```

---

# 🚀 DevOps Connection

Used daily in:

* Linux Administration
* AWS EC2
* Shell Scripting
* Log Analysis
* Docker Hosts
* Kubernetes Nodes
* CI/CD Automation

Mastering man, sort, sed and find makes Linux troubleshooting and automation much easier.
