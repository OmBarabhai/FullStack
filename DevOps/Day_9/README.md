# DevOps Day 9: Compute Services

## 📖 Overview
Explore AWS compute options: EC2 (traditional servers), Lambda (serverless), and Elastic Beanstalk (PaaS). Understanding when to use each service is critical for designing scalable, cost-effective architectures.

---

## 🎯 Learning Objectives

✅ Understand EC2 instances and use cases  
✅ Learn Lambda and serverless computing  
✅ Master Elastic Beanstalk for application deployment  
✅ Choose appropriate compute service for scenarios

---

## 📚 Key Concepts

### **1. EC2 (Elastic Compute Cloud)**
Virtual servers in the cloud:
- **Instance types**: General purpose (t3, m5), compute optimized (c5), memory optimized (r5), storage optimized (i3)
- **On-Demand Instances**: Pay by the hour, no commitment, flexible
- **Reserved Instances**: 1-3 year commitment for significant discounts (40-60% savings)
- **Spot Instances**: Unused capacity at 70-90% discount, can be terminated with 2-minute notice
- **Dedicated Hosts**: Physical servers for licensing compliance
- **AMIs (Amazon Machine Images)**: Pre-configured templates with OS and applications
- **Auto Scaling**: Automatically adjust instance count based on demand
- **Use cases**: Web servers, databases, batch processing, CI/CD pipelines

### **2. Lambda (Serverless Compute)**
Event-driven compute without managing servers:
- **No servers to manage**: AWS handles infrastructure, scaling, and maintenance
- **Pay per invocation**: Charge based on number of requests and execution duration
- **Trigger-based**: Execute functions in response to events (S3, DynamoDB, API Gateway, SNS)
- **Supported languages**: Python, Node.js, Java, C#, Go, Ruby, custom runtimes
- **Execution time limit**: Maximum 15 minutes per invocation
- **Concurrency**: Up to 1000 concurrent executions per account (adjustable)
- **Use cases**: API backends, real-time data processing, automation, microservices

### **3. Elastic Beanstalk (Platform as a Service)**
Managed platform for deploying web applications:
- **Easy deployment**: Deploy applications without managing infrastructure
- **Automatic scaling**: Built-in Auto Scaling and load balancing
- **Supported platforms**: Node.js, Python, Java, PHP, Ruby, Go, .NET, Docker
- **Environment management**: Staging and production environments
- **Blue/Green deployment**: Zero-downtime updates
- **Health monitoring**: Automatic health checks and instance replacement
- **Use cases**: Web applications, RESTful APIs, microservices

---

## 🖼️ Visual References
- EC2 instance types and use case selection chart
- Lambda vs Traditional compute comparison diagram

---

## 🔑 Key Takeaways

✨ EC2 provides flexibility and control for traditional applications  
✨ Lambda offers cost-efficiency for event-driven, unpredictable workloads  
✨ Elastic Beanstalk simplifies application deployment with automatic management  

---

## 📝 AWS SAA Exam Relevance

Compute service selection is a frequent SAA topic. Expect scenarios requiring you to choose between EC2, Lambda, and Elastic Beanstalk based on application requirements, cost optimization, and operational complexity.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- EC2 instance types chart helps match workload requirements to instance families
- Lambda vs Traditional compute comparison clarifies when to use serverless

Continue to **Day 10** for Storage Services: S3 and EBS
