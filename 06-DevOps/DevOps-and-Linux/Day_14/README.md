# DevOps Day 14: Identity Management

## 📖 Overview
Deepen your understanding of IAM (Identity and Access Management). Master policy structure, role assumptions, and advanced IAM concepts essential for securing AWS architectures.

---

## 🎯 Learning Objectives

✅ Understand IAM policy structure and evaluation  
✅ Learn role assumption and cross-account access  
✅ Master permission boundaries and policy conditions  
✅ Prepare for security architecture questions

---

## 📚 Key Concepts

### **1. IAM Policy Structure**
Detailed anatomy of IAM policies:
- **Statement**: Array of individual permission statements
- **Effect**: Allow or Deny the action
- **Principal**: Who is granted the permission (user, role, service)
- **Action**: Specific AWS API operations (s3:GetObject, ec2:DescribeInstances)
- **Resource**: AWS resources affected (specific S3 buckets, EC2 instances)
- **Condition**: Optional restrictions (source IP, time of day, MFA requirement)
- **Version**: Policy language version (typically "2012-10-17")
- **Wildcard usage**: * for all actions/resources (use cautiously)

### **2. Role Assumption**
Assuming roles for temporary access:
- **Trust relationship**: Principal that can assume the role (user, service, cross-account)
- **STS (Security Token Service)**: Generate temporary credentials
- **AssumeRole API**: Request temporary credentials for a role
- **Session name**: Identify who assumed the role (audit trail)
- **Session duration**: Control how long credentials are valid (900 seconds to 12 hours)
- **Cross-account access**: Allow users in one account to access resources in another
- **Service roles**: Allow EC2, Lambda to assume roles for accessing other AWS services

### **3. Advanced IAM Concepts**
Complex IAM features for enterprise security:
- **Permission boundaries**: Maximum permissions a user can have (set by administrator)
- **Policy conditions**: Restrict based on time, IP, MFA, tags, source account
- **Resource-based policies**: Control who can access specific resources
- **Session policies**: Further restrict permissions for assumed role sessions
- **Temporary security credentials**: Access Key ID, Secret Access Key, Session Token
- **Policy evaluation**: Explicit Deny overrides all other decisions
- **Effective permissions**: Union of all applicable Allow statements minus Deny statements

---

## 🖼️ Visual References
- IAM policy evaluation logic diagram
- Role assumption flow and trust relationship diagram

---

## 🔑 Key Takeaways

✨ IAM policies are evaluated using Principal, Action, Resource, and Condition  
✨ Roles provide temporary credentials and enable cross-account access  
✨ Advanced features like permission boundaries enforce least privilege at scale  

---

## 📝 AWS SAA Exam Relevance

IAM mastery is critical for the SAA exam. Expect complex scenarios requiring policy creation, cross-account access setup, and security boundary design. Understanding policy evaluation order is essential.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Policy evaluation logic diagram shows how AWS evaluates permissions
- Role assumption diagram illustrates trust relationships and credential flows

Continue to **Day 15** for IAM Structure: Identity Providers, Roles, and Groups
