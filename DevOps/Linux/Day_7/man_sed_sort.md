# 🐧 Linux Day 7 - Important Notes

---

# 📌 man Command

```text id="m1n7xp"
man = Manual
```

➡️ Used to open command documentation/help.

---

# 📌 Search Manual

```bash id="jlwm901"
man -k passwd
```

Search related manual pages.

---

# 📌 Manual Sections

| Section | Use           |
| ------- | ------------- |
| 1       | User commands |
| 5       | Config files  |

---

# 📌 Open Specific Section

```bash id="’wini902"
man 1 passwd
```

```bash id="’wini903"
man 5 passwd
```

---

# 📌 man Important Options

| Command | Use                   |
| ------- | --------------------- |
| man -k  | Search keyword        |
| man -t  | Convert to PostScript |
| man man | Manual of man         |

---

# 📌 Create PostScript File

```bash id="’wini904"
man -t passwd > passwd.ps
```

Creates:

```text id="’wini905"
passwd.ps
```

---

# 📌 File Type Check

```bash id="’wini906"
file ~/passwd.ps
```

---

# 📌 View PostScript File

```bash id="’wini907"
gv ~/passwd.ps
```

---

# 📌 sort Command

➡️ Used to sort lines.

---

# 📌 Basic Sort

```bash id="’wini908"
sort xyz
```

---

# 📌 Numeric Sort

```bash id="’wini909"
sort -n xyz
```

---

# 📌 Reverse Sort

```bash id="’wini910"
sort -r xyz
```

---

# 📌 Unique Sort

```bash id="’wini911"
sort -u xyz
```

Removes duplicate lines.

---

# 📌 sed Command

```text id="’wini912"
sed = Stream Editor
```

➡️ Used for find & replace.

---

# 📌 Replace First Match

```bash id="’wini913"
sed 's/linux/windows/1' file1
```

---

# 📌 Replace Second Match

```bash id="’wini914"
sed 's/linux/windows/2' file1
```

---

# 📌 Replace All Matches

```bash id="’wini915"
sed 's/linux/windows/g' file1
```

---

# 📌 Save Output

```bash id="’wini916"
sed 's/linux/windows/g' file1 > file2
```

---

# 📌 find Command

➡️ Used to search files/directories.

---

# 📌 Search By Name

```bash id="’wini917"
find / -name file1
```

---

# 📌 Search By Inode

```bash id="’wini918"
find / -inum 42029
```

---

# 📌 Hide Permission Errors

```bash id="’wini919"
find / -inum 42029 2>/dev/null
```

---

# 📌 Search By User

```bash id="’wini920"
find / -user om
```

---

# 📌 Search By Type

| Type | Meaning        |
| ---- | -------------- |
| b    | Block file     |
| c    | Character file |

```bash id="’wini921"
find / -type b
```

---

# 📌 Search By Size

```bash id="’wini922"
find / -size +10k
```

➡️ Files bigger than 10KB.

---

# 📌 Important Learning

- man → help/manual
- sort → sorting
- sed → replace text
- find → search files
- `2>/dev/null` → hide errors

---

# 🎯 Quick Revision

```text id="’wini923"
man     → manual
sort    → sorting
sed     → replace text
find    → search files
man -k  → search manual
sort -n → numeric sort
sort -r → reverse
sort -u → unique
sed s///g → replace all
```
