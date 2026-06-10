# DevOps Day 21: AMI & Snapshots

## 📖 Overview
Master Amazon Machine Images (AMIs) and EBS snapshots for recovery, replication, and deployment. These tools are essential for infrastructure reproducibility and disaster recovery planning.

---

## 🎯 Learning Objectives

✅ Understand AMI creation and management  
✅ Learn snapshot creation and replication  
✅ Master recovery and disaster recovery workflows  
✅ Prepare for infrastructure backup scenarios

---

## 📚 Key Concepts

### **1. AMI (Amazon Machine Image)**
Pre-configured server templates:
- **Components**: OS, applications, configurations, data volumes
- **Root volume snapshot**: Captured boot volume from running instance
- **AWS-owned AMIs**: Official images for Linux, Windows, etc.
- **AWS Marketplace AMIs**: Third-party pre-configured images
- **Custom AMIs**: Create from running instances with bundled configuration
- **AMI regions**: AMIs are region-specific, must copy to other regions
- **Permissions**: Keep private (default) or share publicly/with specific accounts
- **Costs**: Storage charges for AMI snapshots (minimal)
- **Use cases**: Standardized deployments, rapid scaling, golden images

### **2. AMI Creation Workflow**
Building custom machine images:
- **Launch instance**: Start with base AWS AMI
- **Configure**: Install software, configure applications
- **Validate**: Test functionality and security
- **Create image**: Capture running instance as new AMI
- **Versioning**: Tag AMI with version numbers
- **Distribution**: Share AMI across accounts or regions
- **Deprecation**: Mark old versions for eventual removal
- **Cleanup**: Delete snapshots when AMI is deprecated

### **3. EBS Snapshots**
Point-in-time volume backups:
- **Incremental backup**: Only changed blocks since last snapshot
- **Regional storage**: Snapshots stored in region-specific S3 buckets
- **Copy to other regions**: Replicate snapshots for disaster recovery
- **Snapshot lifecycle**: Automatic cleanup with Data Lifecycle Manager
- **Snapshot permission**: Keep private or share with other accounts
- **Costs**: Charged for total unique blocks (not just changes)
- **Creation time**: Snapshots are created immediately (background copy)
- **Restoration**: Create new volume from snapshot in any AZ

### **4. Disaster Recovery with Snapshots**
Using snapshots for recovery:
- **Regular snapshots**: Schedule daily/hourly snapshots of critical volumes
- **Cross-region snapshots**: Copy to secondary region for disaster recovery
- **RTO/RPO planning**: Define recovery targets based on business needs
- **Snapshot retention**: Delete old snapshots to control storage costs
- **Automated snapshots**: Data Lifecycle Manager for policy-based automation
- **Volume restoration**: Create new volume from snapshot to recover data
- **Regional failure handling**: Use cross-region snapshots for complete region failure

### **5. AMI Sharing and Distribution**
Enterprise AMI management:
- **Golden images**: Standardized, hardened AMIs for consistent deployments
- **Account sharing**: Share AMI with specific AWS accounts
- **Public sharing**: Make AMI available to all AWS users (requires approval)
- **AWS Marketplace**: Monetize custom AMIs through marketplace
- **AMI catalog**: Central repository of approved AMIs
- **Compliance**: Scan AMIs for vulnerabilities and compliance violations
- **Versioning**: Maintain version history and deprecation policies

---

## 🖼️ Visual References
- AMI creation workflow from EC2 instance to reusable image
- Snapshot lifecycle and retention policies
- Disaster recovery architecture using cross-region snapshots

---

## 🔑 Key Takeaways

✨ AMIs enable rapid, consistent infrastructure deployment  
✨ Snapshots provide point-in-time recovery for data protection  
✨ Cross-region snapshots enable disaster recovery across regions  

---

## 📝 AWS SAA Exam Relevance

AMI and snapshot management are important for disaster recovery and infrastructure-as-code scenarios. Expect questions on snapshot strategies, cross-region replication, and using snapshots for recovery.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- AMI creation workflow shows process from instance to reusable image
- Snapshot diagram illustrates incremental backup and retention
- Disaster recovery diagram shows cross-region snapshot strategy

Continue to **Day 22** for Network Security: Security Groups, NACLs, and VPC
