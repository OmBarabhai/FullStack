# Important AWS Practice Note

## After Practicing Always Check Dashboard

Go to:
```text
EC2 Dashboard
````

### Why?

* Avoid unnecessary AWS charges
* Ensure no resources are still running

---

# After Practice Everything Should Be Deleted/Stopped

## Keep Only

```text id="xalq0v"
Key Pair
Security Group
```

---

# Stop/Delete These Resources

```text id="jlwmkh"
EC2 Instances
Elastic IPs
EBS Volumes
Load Balancers
Snapshots
```

---

# Best Practice Flow

```text id="jlwmki"
Practice
↓
Stop / Terminate EC2
↓
Release Elastic IP
↓
Delete Unused Volumes
↓
Check Billing Dashboard
↓
Cost Should Be Near Zero
```

---

# Important

```text id="jlwmkj"
Unused AWS resources may cause charges
```

### Always Verify:

```text id="jlwmkk"
EC2 → Instances = 0 Running
Elastic IPs = Released
Billing = $0 or Near Zero
```

```
```
