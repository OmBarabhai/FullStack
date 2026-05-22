# EC2 Elastic IP Association

---

# Step 1 — Open Elastic IPs

Go to:
```text
EC2 → Elastic IPs
````

### Why?

* Used to create static public IP
* Public IP will not change after restart

---

# Step 2 — Allocate Elastic IP

Click:

```text
Allocate Elastic IP Address
```

Click:

```text id="jlwmk1"
Allocate
```

### Why?

* AWS creates a new static public IP

---

# Step 3 — Select Elastic IP

Select:

```text id="jlwmk2"
Allocated Elastic IP
```

### Why?

* Need to choose IP before attaching

---

# Step 4 — Associate Elastic IP

Click:

```text id="jlwmk3"
Actions
→ Associate Elastic IP Address
```

### Why?

* Connect Elastic IP to EC2 instance

---

# Step 5 — Select Instance

Choose:

```text id="jlwmk4"
Instance
```

Select:

```text id="jlwmk5"
EC2 Instance
```

Example:

```text id="jlwmk6"
MyLinuxInstance
```

### Why?

* Select which EC2 should receive static IP

---

# Step 6 — Associate

Click:

```text id="jlwmk7"
Associate
```

### Why?

* Final attachment of Elastic IP to EC2

---

# Final Result

```text id="jlwmk8"
Elastic IP
↓
Attached to EC2 Instance
↓
Static Public IP
```

---

# Why Elastic IP?

* Static Public IP
* IP does not change after restart
* Useful for:

  * Websites
  * SSH
  * Remote access
  * DNS mapping

---

# Important

```text id="jlwmk9"
Unused Elastic IP may cause charges
```

### Best Practice

```text id="jlwmka"
Release Elastic IP if not using
```

```
```
# Delete / Remove Elastic IP

---

# Step 1 — Open Elastic IPs

Go to:
```text
EC2 → Elastic IPs
````

### Why?

* Manage static public IPs

---

# Step 2 — Select Elastic IP

Select:

```text id="jlwmkc"
Elastic IP
```

### Why?

* Choose which Elastic IP to remove

---

# Step 3 — Disassociate Elastic IP

Click:

```text id="jlwmkd"
Actions
→ Disassociate Elastic IP Address
```

### Why?

* Remove Elastic IP from EC2 instance

---

# Step 4 — Release Elastic IP

Click:

```text id="jlwmke"
Actions
→ Release Elastic IP Address
```

### Why?

* Delete Elastic IP permanently
* Avoid unnecessary AWS charges

---

# Final Flow

```text id="urlpatterns"
Elastic IP
↓
Disassociate
↓
Release
↓
Deleted
```

---

# Important

```text id="g2h1mz"
Unused Elastic IP can cause charges
```

### Best Practice

```text id="jlwmkf"
Release Elastic IP if not using
```

```
```

