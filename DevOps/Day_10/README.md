# DevOps Day 10: Storage Services

## 📖 Overview
Master AWS storage solutions including S3 (object storage) and EBS (block storage). Understanding the differences and appropriate use cases is essential for designing scalable and reliable storage architectures.

---

## 🎯 Learning Objectives

✅ Understand S3 and object storage concepts  
✅ Learn EBS and block storage use cases  
✅ Know storage class selection and lifecycle policies  
✅ Prepare for storage architecture questions

---

## 📚 Key Concepts

### **1. S3 (Simple Storage Service)**
Managed object storage for any data type:
- **Unlimited scalability**: Store virtually unlimited data
- **Bucket structure**: Create buckets to organize objects (files)
- **Storage classes**: Standard, Intelligent-Tiering, Glacier, Deep Archive for cost optimization
- **Versioning**: Keep multiple versions of objects for recovery and audit
- **Lifecycle policies**: Automatically transition objects to cheaper storage classes or delete
- **Encryption**: Server-side encryption (SSE-S3, SSE-KMS) or client-side encryption
- **Access control**: Bucket policies, IAM policies, ACLs for fine-grained access
- **Static website hosting**: Host static websites directly from S3
- **Use cases**: Data backup, archives, media distribution, data lakes, log storage

### **2. EBS (Elastic Block Storage)**
Block storage volumes for EC2 instances:
- **Persistent storage**: Data persists after instance termination
- **Volume types**: General Purpose (gp3/gp2), Provisioned IOPS (io2/io1), Throughput Optimized (st1), Cold HDD (sc1)
- **IOPS and throughput**: Adjust performance based on requirements
- **Snapshots**: Create point-in-time backups, replicate across regions
- **Encryption**: Encrypt volumes with AWS KMS
- **Multi-Attach**: Connect single volume to multiple EC2 instances (io1/io2 only)
- **Use cases**: Databases, file systems, application data, OS root volumes

### **3. Storage Class Selection**
Choosing appropriate storage for different access patterns:
- **S3 Standard**: Frequently accessed data, millisecond latency
- **S3 Intelligent-Tiering**: Unknown access patterns, automatic cost optimization
- **S3 Glacier**: Long-term archival, retrieval time of hours/days
- **S3 Deep Archive**: Compliance retention, lowest cost storage
- **EBS gp3**: Most workloads, balanced performance and cost
- **EBS io2**: High-performance databases, consistent IOPS
- **Lifecycle policies**: Transition S3 objects to cheaper classes after 30/90/180 days

---

## 🖼️ Visual References
- `S3.png` - S3 storage architecture, storage classes, and lifecycle
- `EBS.png` - EBS volume types, performance tiers, and use cases

---

## 🔑 Key Takeaways

✨ S3 is ideal for unstructured data and backups; EBS for block-level storage  
✨ Storage class selection significantly impacts costs and performance  
✨ Lifecycle policies automate cost optimization over time  

---

## 📝 AWS SAA Exam Relevance

Storage service selection appears frequently in SAA exams. Expect scenarios requiring you to choose between S3 and EBS, select appropriate storage classes, and design lifecycle policies for cost optimization.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- S3.png shows storage classes, access patterns, and lifecycle transitions
- EBS.png details volume types and performance characteristics

Continue to **Day 11** for Data & Caching: RDS, DynamoDB, ElastiCache, and EFS
