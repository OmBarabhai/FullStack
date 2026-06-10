# DevOps Day 13: Monitoring & Security Foundations

## 📖 Overview
Explore CloudWatch for monitoring and logging, combined with IAM basics for access control. These foundational services enable operational visibility and security in AWS architectures.

---

## 🎯 Learning Objectives

✅ Understand CloudWatch metrics, logs, and alarms  
✅ Learn IAM fundamentals for access control  
✅ Master monitoring and alerting strategies  
✅ Prepare for operational and security questions

---

## 📚 Key Concepts

### **1. CloudWatch (Monitoring & Logging)**
Centralized monitoring and observability service:
- **Metrics**: CPU, network, disk usage for EC2, RDS, Lambda, and custom metrics
- **Dashboards**: Create custom dashboards to visualize metrics
- **Logs**: Centralize application and system logs from EC2, Lambda, RDS
- **Log Groups and Streams**: Organize logs by source and application
- **Alarms**: Create threshold-based alarms to trigger notifications or actions
- **Events**: Event-driven automation using EventBridge/CloudWatch Events
- **Insights**: Query logs using CloudWatch Logs Insights
- **Retention**: Configure log retention periods for cost optimization
- **Use cases**: Application performance monitoring, troubleshooting, alerting

### **2. IAM (Identity and Access Management) Basics**
Foundation for access control:
- **Users**: Individual accounts for people or applications
- **Groups**: Collection of users with common permissions
- **Roles**: Assume-able identities for EC2, Lambda, and cross-account access
- **Policies**: JSON documents defining permissions (Allow/Deny)
- **Principal**: Who is requesting access (user, role, service)
- **Action**: What operation is being performed (ec2:CreateInstance, s3:GetObject)
- **Resource**: What AWS resource is being accessed (ARN - Amazon Resource Name)
- **Conditions**: Restrictions on when policies apply (IP address, MFA, etc.)
- **Principle of Least Privilege**: Grant only necessary permissions

### **3. Monitoring Best Practices**
Effective operational monitoring:
- **Key metrics**: Monitor application and infrastructure health metrics
- **Alarm escalation**: Create escalating alarms (CRITICAL → SNS → page on-call)
- **Log aggregation**: Collect logs from all sources for centralized analysis
- **Baseline metrics**: Understand normal behavior to detect anomalies
- **Real-time alerts**: Configure SNS topics for immediate notification
- **Custom metrics**: Send application-specific metrics to CloudWatch
- **Log retention**: Balance storage costs with compliance requirements

---

## 🖼️ Visual References
- CloudWatch dashboard architecture with metrics and alarms
- IAM policy structure and evaluation logic

---

## 🔑 Key Takeaways

✨ CloudWatch provides complete visibility into application and infrastructure health  
✨ IAM enables fine-grained access control based on least privilege principle  
✨ Together, they provide operational oversight and security boundaries  

---

## 📝 AWS SAA Exam Relevance

Monitoring and IAM are core competencies tested in the SAA exam. Expect scenarios requiring you to design monitoring strategies, create IAM policies, and troubleshoot access control issues.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- CloudWatch dashboard diagram shows metrics, logs, and alarm structure
- IAM policy evaluation diagram illustrates permission model

Continue to **Day 14** for Identity Management: IAM in Detail
