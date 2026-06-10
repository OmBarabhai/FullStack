# DevOps Day 23: Load Balancing

## 📖 Overview
Master load balancing and auto-scaling for building highly available, scalable applications. These services distribute traffic and automatically adjust capacity, enabling elastic architectures.

---

## 🎯 Learning Objectives

✅ Understand load balancer types and selection  
✅ Learn auto-scaling groups and scaling policies  
✅ Master health checks and instance replacement  
✅ Prepare for scalability architecture questions

---

## 📚 Key Concepts

### **1. Elastic Load Balancing (ELB)**
Distribute traffic across instances:
- **Classic Load Balancer (CLB)**: Legacy, Layer 4/7, not recommended for new
- **Application Load Balancer (ALB)**: Layer 7, best for web/APIs, host/path based routing
- **Network Load Balancer (NLB)**: Layer 4, ultra-high performance, extreme throughput
- **Gateway Load Balancer (GLB)**: Layer 3, specialized for appliances
- **Cross-zone**: Distribute traffic across all AZs, optional for NLB/CLB
- **Sticky sessions**: Route requests from same client to same instance
- **Connection draining**: Graceful shutdown, in-flight connections complete

### **2. Application Load Balancer (ALB)**
Most common load balancer for web applications:
- **Host-based routing**: Route by domain name (api.example.com vs cdn.example.com)
- **Path-based routing**: Route by URL path (/images vs /api vs /web)
- **Protocol**: HTTP/HTTPS with SNI support for multiple SSL certificates
- **Target groups**: Route traffic to specific instance groups or Lambda
- **Health checks**: HTTP/HTTPS checks with configurable threshold
- **WAF integration**: Attach AWS WAF for application-layer protection
- **Access logs**: Log all requests for troubleshooting and compliance
- **WebSocket support**: Enable real-time applications

### **3. Network Load Balancer (NLB)**
Ultra-high performance for extreme workloads:
- **Throughput**: Millions of requests per second with ultra-low latency
- **TCP/UDP**: Layer 4 protocol-agnostic routing
- **Connection-based**: Non-terminating proxy for extreme performance
- **IP affinity**: Route based on source IP
- **Extreme performance**: For financial trading, gaming, DNS, IoT
- **Cost**: Higher than ALB, only for applications requiring extreme performance
- **Use cases**: Real-time gaming, financial trading systems, DNS

### **4. Auto Scaling Groups (ASG)**
Automatic capacity management:
- **Desired capacity**: Target number of instances
- **Minimum/Maximum**: Bounds on instance count
- **Scaling policies**: Rules for adding/removing instances
- **Target tracking**: Maintain desired metric level (CPU, request count)
- **Step scaling**: Different scaling rates based on metric magnitude
- **Scheduled scaling**: Scale up/down at specific times
- **Cooldown period**: Wait before next scaling action
- **Lifecycle hooks**: Custom scripts during scale up/down
- **Health check replacement**: Remove unhealthy instances automatically

### **5. Scaling Policy Types**
Different strategies for scaling:
- **Target Tracking Scaling**: Maintain target metric (e.g., 70% CPU)
- **Step Scaling**: Different scaling speeds for different metric ranges
- **Simple Scaling**: Add/remove instances on single alarm
- **Scheduled Scaling**: Scale based on predictable patterns (peak hours)
- **Predictive Scaling**: Use ML to forecast scaling needs
- **Warm pool**: Pre-initialize instances for faster scaling

### **6. Auto Scaling Workflow**
Complete flow for automatic capacity management:
- **Launch template**: Define instance configuration (AMI, instance type, security group)
- **ASG creation**: Set minimum, maximum, desired capacity
- **Health checks**: ELB health checks replace unhealthy instances
- **Scaling trigger**: Monitor metric, trigger scale up/down
- **Instance launch**: New instances automatically join load balancer
- **Instance termination**: Graceful drain before removal
- **Monitoring**: CloudWatch metrics track scaling activity

---

## 🖼️ Visual References
- Load balancer comparison (CLB, ALB, NLB, GLB)
- ALB routing architecture showing host and path-based routing
- Auto Scaling Group lifecycle and scaling policy flow
- Request flow from load balancer through ASG to instances

---

## 🔑 Key Takeaways

✨ ALB is best for most web applications with intelligent routing  
✨ Auto Scaling Groups automatically maintain desired capacity and replace failures  
✨ Together, load balancers and auto-scaling enable elastic, highly-available apps  

---

## 📝 AWS SAA Exam Relevance

Load balancing and auto-scaling are critical for building scalable, highly-available architectures. Expect scenarios requiring you to select appropriate load balancer types and design scaling policies.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Load balancer comparison shows when to use each type
- ALB routing diagram illustrates host and path-based routing
- Auto Scaling lifecycle diagram shows scaling triggers and instance management
- Complete request flow shows integration of LB with ASG

Continue to **Day 24** for IP & Optimization: IP Types, Acceleration, and Hibernation
