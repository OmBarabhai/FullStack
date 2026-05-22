# Connect EC2 to PuTTY (Windows)

---

# Step 1 — Convert PEM to PPK

Open:
```text
PuTTYgen
````

Click:

```text
Load
```

Change:

```text
PuTTY Private Key Files (*.ppk)
```

to:

```text
All Files (*.*)
```

Select:

```text
.pem file
```

Example:

```text
Om-Aws.pem
```

Click:

```text
Open
```

Then click:

```text
Save private key
```

Save as:

```text
Om-Aws.ppk
```

---

# Step 2 — Configure Security Group

Go to:

```text
EC2 → Security Groups
```

Select:

```text
default
```

Go to:

```text
Inbound Rules
→ Edit Inbound Rules
```

Add Rule:

```text
Type      → SSH
Protocol  → TCP
Port      → 22
Source    → My IP
```

Save Rules.

---

# Step 3 — Open PuTTY

Enter:

```text
Host Name → Public IPv4 Address
Port      → 22
Connection → SSH
```

Example:

```text
13.201.xx.xx
```

---

# Step 4 — Add PPK File

Go to:

```text
Connection
→ SSH
→ Auth
→ Credentials
```

Browse:

```text
Select .ppk file
```

Example:

```text
Om-Aws.ppk
```

---

# Step 5 — Connect

Click:

```text
Open
```

Accept:

```text
Security Alert → Accept
```

---

# Step 6 — Login to Linux

Login as:

```text
ec2-user
```

---

# Final Flow

```text
PEM → Convert to PPK
↓
Configure Security Group
↓
Open PuTTY
↓
Add Public IP
↓
Attach PPK
↓
Login as ec2-user
```

```
```
