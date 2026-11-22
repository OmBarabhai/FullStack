# 🐧 Linux Day 4 - Linux Basic Commands

---

# 🎯 Goal

Learn basic Linux commands used daily in:

* Linux Administration
* DevOps
* AWS EC2
* Docker
* Shell Scripting

---

# 📚 Topics Covered

* pwd
* ls
* cd
* mkdir
* touch
* cat
* cp
* mv
* rm
* rmdir
* clear

---

# 📌 Current Directory

## pwd

Shows current working directory.

```bash
pwd
```

Example:

```text
/home/om/practice
```

---

# 📌 List Files & Folders

## ls

```bash
ls
```

Shows files and directories.

---

## ls -l

```bash
ls -l
```

Shows detailed information.

---

## ls -a

```bash
ls -a
```

Shows hidden files.

---

# 📌 Change Directory

## Go Inside Folder

```bash
cd foldername
```

Example:

```bash
cd practice
```

---

## Go Back One Step

```bash
cd ..
```

---

## Go Home Directory

```bash
cd ~
```

---

## Go Root Directory

```bash
cd /
```

---

# 📌 Create Directory

## Single Directory

```bash
mkdir project
```

---

## Multiple Directories

```bash
mkdir aws docker kubernetes
```

---

# 📌 Create Files

## Single File

```bash
touch file1.txt
```

---

## Multiple Files

```bash
touch file1 file2 file3
```

---

# 📌 Display File Content

## cat

```bash
cat file1.txt
```

Displays file content.

---

# 📌 Write Into File

## Create New Content

```bash
cat > file1
```

Save:

```text
Ctrl + D
```

---

## Append Content

```bash
cat >> file1
```

Adds new content.

---

# 📌 Copy Command

## Copy File

```bash
cp file1 file2
```

---

## Copy File To Directory

```bash
cp file1 dir1
```

---

## Copy Directory

```bash
cp -r dir1 dir2
```

Options:

```text
-r = recursive
-v = verbose
-f = force
```

Example:

```bash
cp -rvf dir1 dir2
```

---

# 📌 Move & Rename

## Rename File

```bash
mv file1 newfile
```

---

## Move File

```bash
mv file1 dir1
```

---

## Rename Directory

```bash
mv dir1 project
```

---

# 📌 Remove Files

## Remove File

```bash
rm file1
```

---

## Remove Directory

```bash
rm -r dir1
```

---

## Force Remove

```bash
rm -rf dir1
```

⚠️ Dangerous command.

---

## Remove Empty Directory

```bash
rmdir dir1
```

Works only if directory is empty.

---

# 📌 Multiple File Creation

```bash
touch k{1..6}
```

Creates:

```text
k1 k2 k3 k4 k5 k6
```

---

# 📌 Multiple Directory Creation

```bash
mkdir dir{1..4}
```

Creates:

```text
dir1 dir2 dir3 dir4
```

---

# 📌 Nested Directory Creation

```bash
mkdir -p L1/L2/L3
```

---

## Real Example

```bash
mkdir -p NIT/{Linux/{RHCSA,RHCE},Windows/{MCSA,MCSE},Oracle/{SQL,PLSQL}}
```

---

# 📌 Important Symbols

| Symbol | Meaning           |
| ------ | ----------------- |
| /      | Root Directory    |
| ~      | Home Directory    |
| .      | Current Directory |
| ..     | Parent Directory  |

---

# 📌 Linux Case Sensitive

Different files:

```text
file.txt
File.txt
FILE.txt
```

Linux treats all as different.

---

# 📌 Commands Practiced

```bash
pwd
ls
ls -l
ls -a
cd
mkdir
touch
cat
cp
mv
rm
rmdir
clear
```

---

# 🎤 Interview Questions

### What is pwd?

Print Working Directory.

Shows current location.

---

### Difference Between rm and rmdir?

| rm                        | rmdir                          |
| ------------------------- | ------------------------------ |
| Removes files/directories | Removes empty directories only |

---

### Difference Between cp and mv?

| cp   | mv          |
| ---- | ----------- |
| Copy | Move/Rename |

---

### What does mkdir -p do?

Creates nested directories.

---

### What is Linux Case Sensitivity?

Linux treats uppercase and lowercase names differently.

Example:

```text
file.txt
File.txt
```

Both are different files.

---

# ⚡ Quick Revision

```text
pwd    → current path
ls     → list files
cd     → change directory
mkdir  → create folder
touch  → create file
cat    → view file
cp     → copy
mv     → move/rename
rm     → delete
rmdir  → remove empty folder

~      → home
/      → root
.      → current
..     → parent
```

---

# 🚀 DevOps Connection

These commands are used daily in:

* Linux Servers
* AWS EC2
* Docker Containers
* Kubernetes Nodes
* Shell Scripts
* CI/CD Pipelines

Mastering these commands is the foundation of Linux and DevOps.
