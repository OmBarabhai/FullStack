# DevOps Day 20: Storage Options

## 📖 Overview
Explore EBS volume types and configurations for different workload requirements. Understand storage selection criteria and bastion host (jump host) architecture for secure access.

---

## 🎯 Learning Objectives

✅ Understand EBS volume types and performance tiers  
✅ Learn volume selection criteria  
✅ Master bastion host architecture  
✅ Prepare for storage and network security scenarios

---

## 📚 Key Concepts

### **1. EBS Volume Types**
Choosing appropriate storage:
- **General Purpose (gp3/gp2)**: 
  - Most workloads, balanced price and performance
  - gp3: 3,000-16,000 IOPS, 125-1,000 MB/s throughput
  - gp2: 100-16,000 IOPS (3 IOPS per GB baseline)
  - Cost-effective default choice
  
- **Provisioned IOPS (io1/io2)**:
  - High-performance databases (Oracle, SQL Server)
  - io2: 64,000 IOPS, 1,000 MB/s throughput
  - io1: 32,000 IOPS, 500 MB/s throughput
  - Premium pricing for guaranteed performance
  
- **Throughput Optimized (st1)**:
  - Big data, Hadoop, data warehousing
  - 500 MB/s throughput, burstable up to 500 MB/s
  - Lower cost than IOPS-optimized
  
- **Cold HDD (sc1)**:
  - Infrequent access workloads
  - 250 MB/s throughput
  - Lowest cost option

### **2. Volume Configuration**
Optimizing EBS performance:
- **Volume size**: Affects baseline performance and cost
- **IOPS provisioning**: Adjust independently from volume size (io1/io2/gp3)
- **Throughput provisioning**: Set baseline throughput (io1/io2/gp3)
- **Multi-attach**: Attach single volume to multiple instances (io1/io2)
- **EBS optimization**: Dedicated network bandwidth for storage
- **Snapshots**: Point-in-time backups, copy across regions
- **Encryption**: KMS-based encryption at rest

### **3. Volume Selection Decision**
Choosing the right volume type:
- **Identify workload type**: OLTP (databases), big data, general purpose
- **Measure current performance**: IOPS and throughput requirements
- **Calculate cost**: Price per GB and per IOPS
- **Plan growth**: Account for future performance needs
- **Test performance**: Run benchmarks on selected volume type
- **Right-size**: Monitor utilization and adjust if over-provisioned

### **4. Bastion Host (Jump Host) Architecture**
Secure access to private resources:
- **Public subnet placement**: Bastion in public subnet with Security Group restrictions
- **Single point of entry**: All administrative access routes through bastion
- **SSH key pair**: Separate key pair for bastion access
- **Port forwarding**: Use SSH tunneling to access private resources
- **Logging**: Enable detailed logging of bastion access (CloudTrail)
- **Network isolation**: NACLs restrict bastion communication
- **Auto Scaling bastion**: High availability with multiple bastion instances
- **Alternative to bastion**: AWS Systems Manager Session Manager (no SSH keys needed)

### **5. Private Subnet Access Patterns**
Securely accessing private resources:
- **Bastion SSH tunneling**: SSH -i key.pem -J bastion_ip private_instance_ip
- **VPN access**: Site-to-Site VPN or AWS Client VPN for corporate access
- **Systems Manager Session Manager**: Passwordless, auditible alternative
- **NAT Gateway**: For outbound internet access from private resources
- **VPC Peering**: Connect to resources in other VPCs

---

## 🖼️ Visual References
- EBS volume types comparison (IOPS, throughput, cost)
- Volume selection decision tree
- Bastion host architecture diagram showing public/private subnet routing

---

## 🔑 Key Takeaways

✨ EBS volume type selection directly impacts database performance and cost  
✨ Bastion hosts provide secure, auditable access to private resources  
✨ Right-sizing storage prevents over-provisioning costs  

---

## 📝 AWS SAA Exam Relevance

Storage configuration and secure access patterns are tested in SAA exams. Expect questions on volume type selection for specific workloads and bastion host architecture for security scenarios.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- EBS volume comparison shows performance tiers and cost implications
- Decision tree helps match workload to appropriate volume type
- Bastion architecture diagram shows security boundaries and access patterns

Continue to **Day 21** for AMI & Snapshots: Images and Recovery
