# DevOps Day 12: CDN & DNS

## 📖 Overview
Master CloudFront (Content Delivery Network) and Route 53 (DNS and domain management). These services are essential for global application delivery, performance optimization, and high availability.

---

## 🎯 Learning Objectives

✅ Understand CloudFront for content delivery  
✅ Learn Route 53 for DNS and traffic management  
✅ Master routing policies for availability  
✅ Prepare for global distribution scenarios

---

## 📚 Key Concepts

### **1. CloudFront (Content Delivery Network)**
Global content delivery with edge locations:
- **Edge locations**: 400+ points of presence worldwide for low-latency delivery
- **Caching**: Cache content at edge locations closer to users
- **Origin types**: S3 buckets, EC2 instances, ELB, Lambda@Edge, custom origins
- **Cache invalidation**: Purge cached content when updates are needed
- **Lambda@Edge**: Execute Lambda functions at edge locations
- **Geo-restriction**: Block or allow content delivery by country
- **HTTPS/SSL**: Secure content delivery with SSL/TLS certificates
- **Origin shield**: Additional caching layer between edge and origin
- **Use cases**: Static website delivery, video streaming, API acceleration, DDoS protection

### **2. Route 53 (DNS Service)**
Managed DNS and domain registration:
- **DNS records**: A, AAAA, CNAME, MX, NS, SOT, TXT, SRV records
- **Routing policies**: 
  - **Simple**: Single resource
  - **Weighted**: Distribute traffic by percentage
  - **Latency-based**: Route to lowest latency endpoint
  - **Failover**: Active-passive failover to backup resource
  - **Geolocation**: Route based on geographic location
  - **Geoproximity**: Route based on distance from location
  - **Multi-value**: Return multiple healthy resources
- **Health checks**: Monitor endpoints, automatic failover on unhealthy instances
- **Domain registration**: Register and manage domain names
- **Traffic flow**: Visual editor for complex routing policies
- **Use cases**: DNS management, application availability, traffic distribution

### **3. Performance Optimization with CloudFront & Route 53**
Combined strategy for global performance:
- **CloudFront caches content**: Reduces origin load, improves delivery speed
- **Route 53 routes traffic**: Directs users to nearest edge location
- **Origin failover**: Route 53 health checks trigger failover to secondary origin
- **Hybrid strategy**: CloudFront for content, Route 53 for intelligent routing
- **DDoS protection**: CloudFront with Route 53 provides layered protection

---

## 🖼️ Visual References
- CloudFront architecture with origins, edge locations, and caching layers
- Route 53 routing policies and health check mechanisms

---

## 🔑 Key Takeaways

✨ CloudFront delivers content globally with caching at edge locations  
✨ Route 53 enables intelligent DNS routing for availability and performance  
✨ Combined, they provide global distribution with automatic failover  

---

## 📝 AWS SAA Exam Relevance

CDN and DNS questions focus on content delivery optimization, routing policies for high availability, and global architecture design. Expect scenarios requiring you to select appropriate routing policies or explain how CloudFront improves performance.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- CloudFront diagram shows edge locations, caching behavior, and origin configuration
- Route 53 diagram illustrates routing policies and health check automation

Continue to **Day 13** for Monitoring: CloudWatch and IAM Basics
