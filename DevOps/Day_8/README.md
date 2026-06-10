# DevOps Day 8: Global Infrastructure

## 📖 Overview
Explore AWS's global infrastructure including Regions, Availability Zones, and Virtual Private Clouds. Understanding this infrastructure is fundamental to designing resilient, globally-distributed applications.

---

## 🎯 Learning Objectives

✅ Understand AWS Regions and their characteristics  
✅ Learn Availability Zones and fault isolation  
✅ Master VPC concepts and network isolation  
✅ Prepare for infrastructure design questions

---

## 📚 Key Concepts

### **1. AWS Regions**
Geographic areas containing AWS infrastructure:
- **30+ Regions worldwide**: Each region is geographically distinct
- **Independent infrastructure**: Each region operates independently with separate APIs
- **Data residency**: Choose regions based on regulatory and latency requirements
- **Regional services**: Most AWS services are region-specific (EC2, RDS, DynamoDB)
- **Global services**: S3, CloudFront, IAM, Route 53 operate across all regions
- **Region selection factors**: Compliance, latency, cost, service availability
- **Example regions**: us-east-1 (N. Virginia), eu-west-1 (Ireland), ap-southeast-1 (Singapore)

### **2. Availability Zones (AZs)**
Isolated locations within regions:
- **Multiple AZs per region**: Usually 3-6 AZs per region for redundancy
- **Physical separation**: Different data centers with independent power, cooling, networking
- **Low-latency connectivity**: Connected via high-speed fiber links (sub-millisecond latency)
- **Fault isolation**: Failure in one AZ does not affect other AZs
- **Multi-AZ deployment**: Distribute applications across AZs for high availability
- **Naming convention**: Region code + AZ letter (us-east-1a, us-east-1b, us-east-1c)

### **3. Virtual Private Cloud (VPC)**
Isolated network environment within AWS:
- **Network isolation**: Your own virtual network, logically isolated from other AWS accounts
- **CIDR blocks**: Define IP address ranges for your VPC and subnets
- **Subnets**: Divide VPC into public and private subnets across multiple AZs
- **Internet Gateway**: Enable communication between VPC and the internet
- **NAT Gateway/Instance**: Allow private instances to access internet (outbound only)
- **Route tables**: Define routing rules for traffic within and outside VPC
- **VPC Flow Logs**: Monitor and troubleshoot network traffic
- **VPC Peering**: Connect multiple VPCs for resource sharing

---

## 🖼️ Visual References
- Global Infrastructure map showing Regions and Availability Zones
- VPC architecture diagram with subnets, gateways, and routing

---

## 🔑 Key Takeaways

✨ Regions provide geographic distribution; Availability Zones provide fault tolerance  
✨ VPC gives you complete network control within AWS  
✨ Multi-region and Multi-AZ design enables global, resilient applications  

---

## 📝 AWS SAA Exam Relevance

Global infrastructure questions are fundamental to the SAA exam. Expect scenarios about selecting regions for compliance, designing for high availability across AZs, and configuring VPCs with proper network isolation and routing.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Global Infrastructure map shows current Regions and Availability Zones worldwide
- VPC architecture diagram illustrates networking components and relationships

Continue to **Day 9** for Compute Services: EC2, Lambda, and Elastic Beanstalk
