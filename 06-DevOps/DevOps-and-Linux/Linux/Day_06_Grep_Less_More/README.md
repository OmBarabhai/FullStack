# 🐧 Linux Day 06 - grep, less & more

<<<<<<< HEAD
=======
![Grep Less More](./Images/GrepLessMore.png)

>>>>>>> b37fb03a446b0fa85f20401d260501addacb53ad
---

# 🎯 Goal

Learn how to:

* Search text inside files
* Filter command output
* Read large files efficiently
* Use pipes with Linux commands

Used heavily in:

* Linux Administration
* DevOps
* AWS EC2
* Log Analysis
* Troubleshooting

---

# 📌 Important Files

| File        | Purpose           |
| ----------- | ----------------- |
| /etc/passwd | User Information  |
| /etc/group  | Group Information |
| /dev        | Device Files      |

---

# 📌 grep Command

```text
grep = Global Regular Expression Print
```

Used to search text or patterns inside files.

---

# 📌 Basic Search

```bash
grep root /etc/passwd
```

Searches for:

```text
root
```

inside the file.

---

# 📌 Ignore Case

```bash
grep -i hello xyz
```

Matches:

```text
hello
Hello
HELLO
hElLo
```

---

# 📌 Invert Match

```bash
grep -v hello xyz
```

Shows all lines that DO NOT contain:

```text
hello
```

---

# 📌 Line Numbers

```bash
grep -n hello xyz
```

Shows matching lines with line numbers.

---

# 📌 Before Lines

```bash
grep -nB4 sudo /etc/group
```

Shows:

* Matching line
* 4 lines before match

---

# 📌 After Lines

```bash
grep -nA9 sudo /etc/group
```

Shows:

* Matching line
* 9 lines after match

---

# 📌 grep Options

| Option | Purpose      |
| ------ | ------------ |
| -i     | Ignore Case  |
| -v     | Invert Match |
| -n     | Line Numbers |
| -A     | After Lines  |
| -B     | Before Lines |

---

# 📌 Pipe Operator

```text
| = Pipe
```

Sends output of one command to another command.

---

# 📌 Pipe Example

```bash
ls -l | grep sda
```

Flow:

```text
ls -l
   ↓
grep sda
```

---

# 📌 Search Block Devices

```bash
ls -l | grep ^b
```

Explanation:

```text
^b = lines starting with b
```

Used to find block device files.

---

# 📌 less Command

Used to open large files page by page.

```bash
less /etc/passwd
```

---

# 📌 less Navigation

| Key | Purpose       |
| --- | ------------- |
| d   | Next Page     |
| b   | Previous Page |
| q   | Quit          |

---

# 📌 more Command

Used to read files page by page.

```bash
more /etc/passwd
```

---

# 📌 Difference Between less and more

| less                          | more                |
| ----------------------------- | ------------------- |
| Forward & Backward Navigation | Mostly Forward Only |
| More Powerful                 | Basic Viewer        |
| Preferred in Linux            | Older Utility       |

---

# 📌 Real DevOps Examples

Search error logs:

```bash
grep ERROR app.log
```

Ignore case:

```bash
grep -i failed app.log
```

View large log file:

```bash
less /var/log/syslog
```

Filter output:

```bash
ls -l | grep txt
```

---

# 🎤 Interview Questions

### What is grep?

grep is a Linux command used to search text patterns inside files.

---

### What does grep stand for?

```text
Global Regular Expression Print
```

---

### What is grep -i?

Used for case-insensitive searching.

---

### What is grep -v?

Shows lines that do not match the pattern.

---

### What is grep -n?

Displays matching lines with line numbers.

---

### What is a Pipe (|)?

Pipe sends output from one command to another command.

---

### Difference between less and more?

less supports forward and backward navigation, while more mainly supports forward navigation.

---

# ⚡ Quick Revision

```text
grep      → Search Text

grep -i   → Ignore Case

grep -v   → Invert Match

grep -n   → Line Numbers

grep -A   → After Lines

grep -B   → Before Lines

less      → Large File Viewer

more      → Simple File Viewer

|         → Pipe Operator

^b        → Starts With b
```

---

# 🚀 DevOps Connection

Used daily in:

* AWS EC2
* Linux Servers
* Log Analysis
* Shell Scripting
* Docker Containers
* Kubernetes Nodes
* Monitoring & Troubleshooting

Mastering grep makes log analysis and debugging much faster.
