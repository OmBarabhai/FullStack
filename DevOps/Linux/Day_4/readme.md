## 1) What is Linux?

Linux is an open-source, UNIX-like operating system used widely in:
- servers
- cloud
- DevOps
- containers
- backend systems

### Why Linux matters now
- most cloud servers run Linux
- Docker and Kubernetes depend heavily on Linux
- DevOps tools run better on Linux
- interview questions often include Linux basics

---

## 2) Core Linux Terms

| Term | Full Form / Meaning |
|---|---|
| OS | Operating System |
| CLI | Command Line Interface |
| GUI | Graphical User Interface |
| TUI | Text User Interface |
| Shell | Interface between user and kernel |
| Kernel | Core of the OS |
| Root | Admin user |
| Sudo | Superuser do |
| GRUB | Grand Unified Bootloader |
| BIOS | Basic Input Output System |
| UEFI | Unified Extensible Firmware Interface |
| NTP | Network Time Protocol |
| RPM | Red Hat Package Manager |
| RHCSA | Red Hat Certified System Administrator |

---

## 3) Linux Architecture

```text
User
 ↓
Shell
 ↓
Kernel
 ↓
Hardware
````

### Simple meaning

* User types commands
* Shell reads them
* Kernel processes them
* Hardware does the work

### Kernel responsibilities

* process management
* memory management
* device management
* file system management

---

## 4) Boot Process

```text
Power ON
   ↓
BIOS / UEFI
   ↓
GRUB / GRUB2
   ↓
Kernel
   ↓
systemd / init
   ↓
Login
```

### Important points

* GRUB is the boot loader
* GRUB2 is the modern version
* kernel starts the Linux system
* systemd is used in modern Linux distributions

---

## 5) Linux File System

Linux starts from:

```text
/
```

This is the root directory.

### Important directories

| Directory | Use                       |
| --------- | ------------------------- |
| /home     | normal user files         |
| /root     | root admin files          |
| /boot     | startup files             |
| /etc      | configuration files       |
| /bin      | basic user commands       |
| /sbin     | admin commands            |
| /usr      | applications and software |
| /opt      | optional software         |
| /proc     | CPU and memory info       |
| /var/log  | system logs               |
| /tmp      | temporary files           |
| /mnt      | manual mount point        |
| /media    | auto mounted devices      |
| /dev      | device files              |
| /lib      | system libraries          |

### Quick memory

```text
/home    → user files
/root    → admin files
/boot    → boot files
/etc     → config files
/bin     → commands
/sbin    → admin commands
/proc    → system info
/var/log → logs
/tmp     → temporary files
```

---

## 6) Users in Linux

### Root user

* admin user
* full control
* UID = 0

### Normal user

* regular account
* personal files in `/home/username`

### Useful commands

```bash
whoami
id
id username
```

---

## 7) File and Folder Commands

| Command | Use                   |
| ------- | --------------------- |
| pwd     | show current location |
| ls      | list files/folders    |
| cd      | change directory      |
| mkdir   | create folder         |
| touch   | create file           |
| rm      | remove file           |
| rmdir   | remove empty folder   |
| cp      | copy                  |
| mv      | move / rename         |
| cat     | display file content  |
| clear   | clear terminal        |

### Important navigation

```bash
cd ..
cd ~
cd /
cd .
```

| Command | Meaning           |
| ------- | ----------------- |
| `cd ..` | one step back     |
| `cd ~`  | home directory    |
| `cd /`  | root directory    |
| `cd .`  | current directory |

---

## 8) File Content Commands

### Write to file

```bash
echo "hello" > file.txt
```

### Append to file

```bash
echo "new line" >> file.txt
```

### Read file

```bash
cat file.txt
```

### Input redirection

```bash
cat < file.txt
```

### Combine files

```bash
cat file1.txt file2.txt > file3.txt
```

### Important redirection symbols

| Symbol | Meaning           |
| ------ | ----------------- |
| `>`    | overwrite         |
| `>>`   | append            |
| `<`    | input redirection |

---

## 9) Copy, Move, Rename, Delete

### Copy file

```bash
cp file1.txt file2.txt
```

### Copy file into folder

```bash
cp file1.txt folder/
```

### Copy directory

```bash
cp -r folder1 folder2
```

### Rename file

```bash
mv old.txt new.txt
```

### Move file into folder

```bash
mv file.txt folder/
```

### Remove file

```bash
rm file.txt
```

### Remove folder with content

```bash
rm -r folder
```

### Dangerous force delete

```bash
rm -rf *
```

⚠️ Very dangerous. Deletes everything in the current folder.

### Empty folder only

```bash
rmdir folder
```

---

## 10) Multiple File and Folder Creation

### Multiple files

```bash
touch f1 f2 f3 f4
```

### Sequence expansion

```bash
touch k{1..6}
```

Creates:

```text
k1 k2 k3 k4 k5 k6
```

### Multiple folders

```bash
mkdir dir{1..4}
```

### Nested folders

```bash
mkdir -p L1/L2/L3
```

### Complex structure

```bash
mkdir -p NIT/{Linux/{RHCSA,RHCE},Windows/{MCSA,MCSE},Oracle/{SQL,PLSQL}}
```

---

## 11) File Type and System Info

### File type

```bash
file filename
```

Examples:

```bash
file f1
file /etc/passwd
file /dev/sda
```

### System information

```bash
uname -a
```

### Date and time

```bash
date
date +%Y
date +%T
date +%B
date +%D
```

### Terminal

```bash
tty
```

### Command history

```bash
history
```

---

## 12) Disk and Storage Basics

### Disk usage

```bash
du -h file_or_folder
```

### Inode number

```bash
ls -i file
```

### Symlink

```bash
ln -s target linkname
```

Example:

```bash
ln -s /home/om/practice/sort s1
```

### Important

* symbolic link is like a shortcut
* it points to another file or folder

---

## 13) Permissions Basics

### Check permissions

```bash
ls -l
```

### Permission types

* read = `r`
* write = `w`
* execute = `x`

### Basic idea

* user
* group
* others

### Common command

```bash
chmod
```

Example:

```bash
chmod 755 file.sh
```

---

## 14) Services and Networking Basics

| Service | Use                |
| ------- | ------------------ |
| HTTP    | websites           |
| FTP     | file transfer      |
| DNS     | domain to IP       |
| DHCP    | auto IP allocation |
| SMTP    | send mail          |
| IMAP    | receive mail       |

### Long forms

```text
HTTP = HyperText Transfer Protocol
FTP = File Transfer Protocol
DNS = Domain Name System
DHCP = Dynamic Host Configuration Protocol
SMTP = Simple Mail Transfer Protocol
IMAP = Internet Message Access Protocol
```

---

## 15) Important Files

### `/etc/passwd`

Stores user information.

### `/proc`

Virtual file system for system/process information.

### `/var/log`

Stores system logs.

### Examples

```bash
cat /etc/passwd
cat /proc/cpuinfo
cat /proc/meminfo
```

---

## 16) Linux Commands for Interview

### Very common commands

```bash
pwd
ls
cd
mkdir
touch
cp
mv
rm
cat
echo
history
whoami
id
file
du
ls -l
ls -a
ls -R
```

### Useful advanced beginner commands

```bash
tree
grep
head
tail
sort
wc
find
ps
top
df
free
```

---

## 17) Must-Remember Mistakes

| Wrong              | Correct            |
| ------------------ | ------------------ |
| cd..               | cd ..              |
| rmdir -rf folder   | rm -r folder       |
| >>>                | not valid          |
| cp file1.txt-file2 | cp file1.txt file2 |
| ls-l               | ls -l              |

---

## 18) Essential Short Theory for Interview

### What is Linux?

Linux is an open-source operating system used in servers, cloud, and DevOps.

### What is kernel?

Kernel is the core part of the operating system that manages resources.

### What is shell?

Shell is the interface between user and kernel.

### What is GRUB?

GRUB is the boot loader that loads the Linux kernel during startup.

### What is `/etc`?

It stores configuration files.

### What is `/proc`?

It is a virtual file system that shows process and system information.

### What is `/var/log`?

It stores log files.

### What is symlink?

It is a shortcut to a file or folder.

---

## 19) Current Job Market Value

Linux is useful for:

* full stack deployment
* backend servers
* AWS EC2
* Docker containers
* Kubernetes nodes
* CI/CD pipelines
* DevOps automation

### For MERN

* backend runs on Linux servers
* deployment often uses Ubuntu Linux
* Nginx and PM2 run on Linux

### For DevOps

* Linux is mandatory foundation
* shell scripting is important
* permissions and services matter

### For system design

* Linux helps understand servers, logs, processes, memory, and networking

---

## 20) Quick Revision Sheet

```text
/root      → admin folder
/home      → user folder
/etc       → config
/boot      → startup
/bin       → commands
/sbin      → admin commands
/proc      → system info
/var/log   → logs
/tmp       → temp files
```

```text
>   → overwrite
>>  → append
<   → input
```

```text
cp  → copy
mv  → move/rename
rm  → delete
ln -s → symlink
```

```text
Kernel → brain
Shell  → user interface
GRUB   → boot loader
```

---
# 📌 Hard Link Notes

---

# 🧠 Hard Link

A hard link is another name/reference for same file.

Both files share:
- same data
- same inode

---

# 📌 Create Hard Link

```bash id="jlwm401"
ln hard h1
````

Creates:

```text id="jlwm402"
h1 → hard link of hard
```

---

# 📌 Check File

```bash id="jlwm403"
file h1
```

Output:

```text id="jlwm404"
ASCII text
```

---

# 📌 Read Hard Link

```bash id="jlwm405"
cat h1
```

Output:

```text id="jlwm406"
Hello This is hard file
```

---

# 📌 Check Inode

```bash id="jlwm407"
ls -i hard
```

Example:

```text id="jlwm408"
41978 hard
```

Hard links share same inode number.

---

# 📌 Disk Usage

```bash id="’wini409"
du -h hard
du -h h1
```

Both show:

```text id="’wini410"
4.0K
```

---

# 📌 Important Learning

After deleting original file:

```bash id="’wini411"
rm -r hard
```

Still:

```bash id="’wini412"
cat h1
```

works.

Because:

```text id="’wini413"
h1 still points to same inode/data
```

---

# 📌 Hard Link Important Points

* Shares same inode
* Works even after original file deleted
* Cannot link directories normally
* Cannot cross different file systems

---

# 📌 Hard Link vs Soft Link

| Hard Link                   | Soft Link                    |
| --------------------------- | ---------------------------- |
| Same inode                  | Different inode              |
| Real copy reference         | Shortcut                     |
| Works after original delete | Breaks after original delete |

---

# 🎯 Interview Question

## What is Hard Link?

→ Hard link is another reference/name for same file sharing same inode and data.

---

```
```
