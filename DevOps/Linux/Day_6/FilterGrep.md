# 🐧 Linux Day 6 — grep / less / more Notes

---

# 📌 Important Files

| File | Use |
|---|---|
| /etc/passwd | User details |
| /etc/group | Group details |
| /dev | Device files |

---

# 📌 grep Command

➡️ Used to search text/pattern.

---

# 📌 Basic grep

```bash id="jlwm601"
grep root /etc/passwd
````

Search:

```text id="’wini602"
root
```

inside file.

---

# 📌 Ignore Case

```bash id="’wini603"
grep -i hello xyz
```

Matches:

* hello
* Hello
* HELLO

---

# 📌 Invert Match

```bash id="’wini604"
grep -v hello xyz
```

Shows lines NOT containing:

```text id="’wini605"
hello
```

---

# 📌 Line Number

```bash id="’wini606"
grep -n hello xyz
```

Shows line numbers.

---

# 📌 Before Lines

```bash id="’wini607"
grep -nB4 sudo /etc/group
```

Shows:

* matched line
* 4 lines before

---

# 📌 After Lines

```bash id="’wini608"
grep -nA9 sudo /etc/group
```

Shows:

* matched line
* 9 lines after

---

# 📌 Pipe + grep

## Block Files

```bash id="’wini609"
ls -l | grep ^b
```

Search block devices.

---

## Search Device

```bash id="’wini610"
ls -l | grep sda
```

Search:

```text id="’wini611"
sda
```

---

# 📌 grep Important Options

| Option | Use              |
| ------ | ---------------- |
| -i     | Ignore case      |
| -v     | Invert match     |
| -n     | Show line number |
| -A     | After lines      |
| -B     | Before lines     |

---

# 📌 less Command

➡️ Open large file page by page.

```bash id="’wini612"
less /etc/passwd
```

---

# 📌 less Navigation

| Key | Use           |
| --- | ------------- |
| d   | Next page     |
| b   | Previous page |
| q   | Quit          |

---

# 📌 more Command

➡️ Read file page by page.

```bash id="’wini613"
more /etc/passwd
```

---

# 📌 Difference

| less               | more           |
| ------------------ | -------------- |
| Forward & backward | Mostly forward |
| More powerful      | Simple         |

---

# 📌 Important Learning

* grep → search text
* less → open large file
* more → read file slowly
* pipe `|` → send output to another command

---

# 📌 Pipe Example

```bash id="’wini614"
ls -l | grep ^b
```

Flow:

```text id="’wini615"
ls -l
   ↓
grep
```

---

# 🎯 Quick Revision

```text id="’wini616"
grep     → search
grep -i  → ignore case
grep -v  → invert
grep -n  → line number
grep -A  → after lines
grep -B  → before lines
less     → large file view
more     → simple file view
|        → pipe
```

---
# 🐧 Linux Day 6 — grep / less / more Notes

---

# 📌 grep

```text id="jlwm701"
grep = Global Regular Expression Print
````

➡️ Used to search text/pattern inside file.

---

# 📌 Basic grep

```bash id="’wini702"
grep root /etc/passwd
```

Search:

```text id="’wini703"
root
```

inside file.

---

# 📌 grep Options

| Command | Use               |
| ------- | ----------------- |
| grep -i | Ignore case       |
| grep -v | Invert match      |
| grep -n | Show line number  |
| grep -A | Show after lines  |
| grep -B | Show before lines |

---

# 📌 Ignore Case

```bash id="’wini704"
grep -i hello xyz
```

Matches:

* hello
* Hello
* HELLO

---

# 📌 Invert Match

```bash id="’wini705"
grep -v hello xyz
```

Shows lines NOT containing:

```text id="’wini706"
hello
```

---

# 📌 Line Number

```bash id="’wini707"
grep -n hello xyz
```

Shows line numbers.

---

# 📌 Before Lines

```bash id="’wini708"
grep -nB4 sudo /etc/group
```

Shows:

* matched line
* 4 lines before

---

# 📌 After Lines

```bash id="’wini709"
grep -nA9 sudo /etc/group
```

Shows:

* matched line
* 9 lines after

---

# 📌 Pipe Symbol

```text id="’wini710"
|  = Pipe
```

➡️ Sends output of one command to another command.

---

# 📌 Pipe Example

```bash id="’wini711"
ls -l | grep sda
```

Flow:

```text id="’wini712"
ls -l
   ↓
grep sda
```

---

# 📌 less

➡️ Used to open large file page by page.

```bash id="’wini713"
less /etc/passwd
```

---

# 📌 less Navigation

| Key | Use           |
| --- | ------------- |
| d   | Next page     |
| b   | Previous page |
| q   | Quit          |

---

# 📌 more

➡️ Used to read file page by page.

```bash id="’wini714"
more /etc/passwd
```

---

# 📌 Difference

| less               | more           |
| ------------------ | -------------- |
| Forward & backward | Mostly forward |
| More powerful      | Simple         |

---

# 📌 Important Files

| File        | Use           |
| ----------- | ------------- |
| /etc/passwd | User details  |
| /etc/group  | Group details |
| /dev        | Device files  |

---

# ⚡ Important Learning

* grep → search text
* less → large file viewer
* more → simple file viewer
* pipe → connect commands

---

# 🎯 Quick Revision

```text id="’wini715"
grep     → search text
grep -i  → ignore case
grep -v  → invert match
grep -n  → line number
grep -A  → after lines
grep -B  → before lines
less     → open large file
more     → simple viewer
|        → pipe
```

---
