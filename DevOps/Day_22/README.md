# DevOps Day 22: Network Security

## 📖 Overview
Master network-level security controls including Security Groups, Network ACLs, and VPC design. These layered controls form the foundation of AWS network security architecture.

---

## 🎯 Learning Objectives

✅ Understand Security Groups and stateful filtering  
✅ Learn NACLs and stateless filtering  
✅ Master VPC security architecture  
✅ Design defense-in-depth network security

---

## 📚 Key Concepts

### **1. Security Groups**
Stateful firewall for EC2 instances:
- **Instance-level control**: Applied at network interface level
- **Stateful filtering**: Return traffic automatically allowed
- **Inbound rules**: Control incoming traffic (default: deny all)
- **Outbound rules**: Control outgoing traffic (default: allow all)
- **Protocol-specific rules**: TCP, UDP, ICMP, custom protocols
- **Port ranges**: Specify single port or range (0-65535)
- **CIDR notation**: Allow specific IP ranges (0.0.0.0/0 = any IP)
- **Security group references**: Allow traffic from other security groups
- **Use cases**: Database tier only accepts from app tier, web tier accepts HTTP/HTTPS

### **2. Network ACLs (NACLs)**
Stateless subnet-level firewall:
- **Subnet association**: Applied to entire subnet
- **Stateless filtering**: Must explicitly allow return traffic
- **Numbered rules**: Rules processed in order (100, 200, 300...)
- **Inbound rules**: Control incoming traffic
- **Outbound rules**: Control outgoing traffic
- **Rule priority**: Lower number = higher priority
- **Deny rules**: Explicitly block specific traffic
- **Ephemeral ports**: Allow high-numbered return ports (1024-65535)
- **Performance**: Minimal impact due to simple rule evaluation

### **3. Security Groups vs NACLs**
Layered network defense:
- **Security Groups**: Instance level, stateful, default deny inbound
- **NACLs**: Subnet level, stateless, default allow everything
- **Common pattern**: Permissive NACLs, restrictive Security Groups
- **Use both**: Defense in depth with redundant controls
- **Troubleshooting**: Check both SG and NACL when traffic blocked

### **4. VPC Network Security Design**
Architecture patterns for network isolation:
- **Public subnets**: Allow internet access via Internet Gateway
- **Private subnets**: No direct internet access, use NAT for outbound
- **Bastion subnet**: Jump host in public subnet with strict SG rules
- **Database subnet**: Private subnet, only accepts from application tier
- **DMZ pattern**: Public-facing servers in public subnet, internal services private
- **VPC peering**: Controlled access between VPCs with specific SG/NACL rules
- **VPC endpoints**: Private access to AWS services without internet

### **5. Common Security Patterns**
Real-world network security configurations:
- **Web tier**: Allow 80/443 from 0.0.0.0/0
- **Application tier**: Allow app port (e.g., 8080) from web tier SG only
- **Database tier**: Allow database port (3306, 5432) from app tier SG only
- **Jump host**: Allow SSH (22) from corporate IP only, other traffic denied
- **Hybrid access**: Allow Site-to-Site VPN CIDR block for corporate access
- **Egress control**: Restrict outbound to prevent data exfiltration

### **6. Advanced Security Features**
Deeper security capabilities:
- **VPC Flow Logs**: Monitor accepted/rejected traffic for troubleshooting
- **AWS WAF**: Application-layer firewall for CloudFront/ALB
- **AWS Shield**: DDoS protection (Standard included, Professional paid)
- **GuardDuty**: Threat detection using machine learning
- **Security Hub**: Centralized security findings and compliance

---

## 🖼️ Visual References
- Security Groups vs NACL comparison matrix
- Multi-tier VPC architecture with security boundaries
- Inbound/outbound rule examples for common scenarios
- VPC network diagram showing all security layers

---

## 🔑 Key Takeaways

✨ Security Groups and NACLs provide layered network defense  
✨ Multi-tier architecture isolates traffic between tiers  
✨ Explicit allow rules create secure default-deny posture  

---

## 📝 AWS SAA Exam Relevance

Network security is heavily tested in SAA exams. Expect complex scenarios requiring you to design security group rules, configure NACLs, and troubleshoot traffic flow in multi-tier architectures.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Comparison matrix clarifies when to use SG vs NACL
- Multi-tier architecture shows practical application of all security layers
- Rule examples demonstrate specific scenarios
- VPC diagram illustrates all components and their relationships

Continue to **Day 23** for Load Balancing: ELB, ALB, and Auto Scaling
