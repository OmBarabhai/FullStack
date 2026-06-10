# DevOps Day 25: EC2 Launch & Setup

## 📖 Overview

Day 25 covers the foundational skills needed to launch and configure Amazon EC2 instances on AWS. This is a critical first step in any cloud infrastructure project, focusing on practical instance creation, connectivity, and security configuration.

---

## 🎯 Learning Objectives

✅ Launch and configure EC2 instances from scratch  
✅ Connect to instances via both Linux SSH and Windows RDP protocols  
✅ Manage Elastic IPs for static addressing  
✅ Convert PEM keys to PPK format for Windows connectivity  
✅ Secure instances with proper key management  

---

## 📚 What You'll Learn

This day provides comprehensive hands-on experience with EC2 instance lifecycle management, from creation to secure remote access.

### Key Topics:

- **EC2 Instance Launch**: Step-by-step process for creating new instances, selecting AMIs, instance types, and configuring network settings
- **Linux Connectivity (SSH)**: Establishing secure shell connections to Linux-based instances using PEM keys and proper authentication
- **Windows Connectivity (RDP)**: Connecting to Windows instances using Remote Desktop Protocol with security best practices
- **Elastic IP Management**: Assigning and managing static public IP addresses to maintain consistent connectivity
- **Key Pair Conversion**: Converting between PEM (Linux/macOS) and PPK (PuTTY/Windows) formats for cross-platform access
- **Security Fundamentals**: Understanding key pair security, instance metadata, and access control

---

## 📝 Documentation & Guides

This day includes comprehensive step-by-step guides for all aspects of EC2 setup:

- **Steps_LaunchEC2.md**: Complete walkthrough for launching EC2 instances with proper configuration
- **ConnectToLinux.md**: Detailed SSH connection guide for Linux instances with troubleshooting
- **ConnectTOWindows.md**: Windows RDP connection procedures and connection string setup
- **Elastic_IP.md**: Managing static IP addresses and elastic IP lifecycle
- **pem_To_ppk_convertion.md**: Converting key formats for cross-platform compatibility
- **Task.md**: Practical exercises to reinforce learning
- **IMP.md**: Important notes and common pitfalls
- **Notes.md**: General reference material and additional context

---

## 🔑 Key Takeaways

✨ EC2 instances are the foundation of AWS infrastructure—mastering launch procedures is essential  
✨ Secure key management is critical; never share PEM files and use proper permissions  
✨ Understanding both SSH and RDP protocols enables flexibility across different operating systems  
✨ Elastic IPs are valuable for production workloads requiring consistent addressing  

---

## 📊 Project Relevance

This day is fundamental for the AWS Solutions Architect Associate exam and real-world DevOps work. EC2 management is a prerequisite skill for all subsequent infrastructure projects. These skills directly support:

- **AWS SAA Exam**: EC2 fundamentals, instance types, lifecycle, connectivity
- **Real-World DevOps**: Daily infrastructure operations and management
- **Foundation for Advanced Topics**: All subsequent projects build on solid EC2 fundamentals

---

## 🚀 Next Steps

1. Work through the step-by-step guides in order
2. Perform all hands-on exercises in Task.md
3. Practice launching instances with different configurations
4. Ensure you can reliably connect via both Linux and Windows methods
5. Review important notes in IMP.md
6. Move to Day 26: EC2 Operations Management

---

**Estimated Time**: 4-6 hours  
**Hands-On Required**: Yes - Launch and connect to at least 3 instances
