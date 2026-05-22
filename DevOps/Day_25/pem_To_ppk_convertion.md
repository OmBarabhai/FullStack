# Convert PEM to PPK Using PuTTYgen

## Step 1
Open:
```text
PuTTYgen
````

---

## Step 2

Click:

```text
Load
```

---

## Step 3

In File Explorer:

Change:

```text
PuTTY Private Key Files (*.ppk)
```

to:

```text
All Files (*.*)
```

---

## Step 4

Select:

```text
.pem file
```

Example:

```text
Om-Aws.pem
```

---

## Step 5

Click:

```text
Open
```

PuTTYgen loads the PEM key.

---

## Step 6

Click:

```text
Save private key
```

---

## Step 7

Click:

```text
Yes
```

(if PuTTY asks about saving without passphrase)

---

## Step 8

Give filename:

```text
Om-Aws.ppk
```

Save file.

---

# Final Result

```text
PEM → Converted to → PPK
```

---

# Usage

Use:

```text
.ppk
```

with:

```text
PuTTY
```

for SSH connection to EC2.

```
```
