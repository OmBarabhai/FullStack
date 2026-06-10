# DevOps Day 3: Network Protocols

## 📖 Overview
Master the OSI Model, understand network protocols, and learn port mapping concepts essential for network infrastructure design. This foundational knowledge is critical for designing secure and efficient AWS architectures.

---

## 🎯 Learning Objectives

✅ Understand the 7 layers of the OSI Model  
✅ Learn common network protocols (TCP, UDP, IP, HTTP, HTTPS)  
✅ Master port mapping and port translation concepts  
✅ Prepare for AWS networking exam scenarios

---

## 📚 Key Concepts

### **1. OSI Model (7 Layers)**
The Open Systems Interconnection model is the fundamental framework for understanding network communication:
- **Layer 7 - Application**: User applications (HTTP, SMTP, DNS, FTP)
- **Layer 6 - Presentation**: Data encryption, compression, translation
- **Layer 5 - Session**: Connection management and session control
- **Layer 4 - Transport**: TCP/UDP, end-to-end delivery, reliability
- **Layer 3 - Network**: IP routing, logical addressing (IP addresses)
- **Layer 2 - Data Link**: MAC addresses, switching, frame transmission
- **Layer 1 - Physical**: Cables, signals, hardware transmission

### **2. Network Protocols**
Common protocols used across AWS architectures:
- **TCP (Transmission Control Protocol)**: Connection-oriented, reliable delivery (port-based)
- **UDP (User Datagram Protocol)**: Connectionless, faster but unreliable (used for DNS, streaming)
- **HTTP**: Web traffic, unencrypted (port 80)
- **HTTPS**: Secure web traffic with TLS/SSL encryption (port 443)
- **SSH**: Secure shell for remote administration (port 22)
- **DNS**: Domain name resolution (port 53)

### **3. Port Mapping and Load Conversion**
Understanding port translation for load balancing:
- Port 80 → 8080 conversion allows multiple services on different ports
- Load balancers distribute traffic from external ports to internal application ports
- Network Address Translation (NAT) enables port mapping
- Essential for AWS ELB/ALB configurations

---

## 🖼️ Visual References
- `OSI.png` - Complete OSI Model with all 7 layers and examples
- `Protocols.png` - Common network protocols and their characteristics
- `LoadConv80to8080.png` - Load balancer port conversion example

---

## 🔑 Key Takeaways

✨ The OSI Model provides a universal framework for understanding network communication  
✨ TCP ensures reliable delivery while UDP prioritizes speed for real-time applications  
✨ Port mapping allows flexible service architecture and load balancing in cloud environments  

---

## 📝 AWS SAA Exam Relevance

Network protocols are fundamental to AWS networking questions, particularly around VPC configuration, security groups, NACLs, and load balancer setup. Understanding layer 4 (Transport) protocols is essential for ELB/ALB exam scenarios.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- OSI.png shows all 7 layers with real-world protocol examples
- Protocols.png illustrates TCP/UDP and common AWS-relevant protocols
- LoadConv80to8080.png demonstrates port translation in load balancing

Continue to **Day 4** for Migration Concepts and P2V Migration strategies
