# DevOps Day 6: Shared Responsibility Model

## 📖 Overview
Understand the division of security and operational responsibilities between AWS and customers. This critical model defines your security obligations and is essential for SAA exam success.

---

## 🎯 Learning Objectives

✅ Understand AWS responsibility areas  
✅ Understand customer responsibility areas  
✅ Know the shared responsibility boundary  
✅ Apply responsibility model to architectural decisions

---

## 📚 Key Concepts

### **1. AWS Responsibilities ("Security OF the Cloud")**
AWS manages the physical and virtualization layer:
- **Physical infrastructure security**: Data center security, access controls, environmental controls
- **Hardware maintenance**: Server hardware, storage, networking equipment
- **Hypervisor and virtualization**: Virtual machine isolation, resource allocation
- **Network infrastructure**: Internet connectivity, DDoS protection (AWS Shield Standard)
- **AWS service security**: Service patches, updates, vulnerability management
- **Physical data center security**: Biometric controls, surveillance, security personnel

### **2. Customer Responsibilities ("Security IN the Cloud")**
You manage application and data security:
- **Identity and Access Management (IAM)**: User authentication, authorization, access controls
- **Data protection**: Encryption at rest and in transit
- **Network configuration**: Security groups, NACLs, VPC setup
- **Operating systems**: OS patches, updates, configuration hardening
- **Application security**: Code vulnerabilities, input validation, application firewalls (WAF)
- **Data backup and disaster recovery**: Backup strategy, replication, recovery procedures
- **Monitoring and logging**: CloudTrail, CloudWatch configuration, log analysis
- **Compliance**: Meeting regulatory and compliance requirements

### **3. Shared Responsibility Boundaries**
Areas where both parties contribute:
- **Patch management**: AWS patches infrastructure and database engines; you patch applications and OS
- **Configuration management**: AWS provides services; you configure them securely
- **Database services**: AWS manages RDS/DynamoDB infrastructure; you manage data and access
- **Storage services**: AWS manages S3 infrastructure; you manage encryption and access policies
- **Monitoring**: AWS provides tools (CloudWatch); you configure and respond to alerts

---

## 🖼️ Visual References
- Shared Responsibility Model diagram showing AWS vs Customer boundaries

---

## 🔑 Key Takeaways

✨ AWS secures the infrastructure; you secure your applications and data  
✨ Clear responsibility boundaries prevent security gaps  
✨ Shared services require cooperation for complete security posture  

---

## 📝 AWS SAA Exam Relevance

Exam questions frequently test responsibility model understanding, particularly around who is responsible for specific security controls. Expect scenarios asking whether AWS or the customer is responsible for patching, encryption, or compliance.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Shared Responsibility Model shows the clear boundary between AWS and customer obligations

Continue to **Day 7** for Cloud Qualities including Elasticity, Scalability, and High Availability
