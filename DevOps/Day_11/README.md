# DevOps Day 11: Data & Caching

## 📖 Overview
Explore managed database and caching services: RDS (relational databases), DynamoDB (NoSQL), ElastiCache (in-memory caching), and EFS (shared file storage). These services power modern application architectures.

---

## 🎯 Learning Objectives

✅ Understand RDS and relational database management  
✅ Learn DynamoDB and NoSQL design patterns  
✅ Master ElastiCache for performance optimization  
✅ Know EFS for shared file system needs

---

## 📚 Key Concepts

### **1. RDS (Relational Database Service)**
Managed relational databases:
- **Database engines**: MySQL, PostgreSQL, MariaDB, Oracle, SQL Server
- **Automated backups**: Daily snapshots, 7-35 day retention
- **Multi-AZ deployment**: Synchronous replication for high availability, automatic failover
- **Read replicas**: Scale read-heavy workloads across regions
- **Automated patching**: OS and database engine updates during maintenance windows
- **Performance Insights**: Monitor database performance and identify bottlenecks
- **Use cases**: Web applications, business applications, transactional workloads

### **2. DynamoDB (NoSQL Database)**
Serverless, fully managed NoSQL database:
- **Key-value and document storage**: Flexible schema, JSON documents
- **Provisioned and on-demand capacity**: Pay for predictable or variable workloads
- **Automatic scaling**: Adjust throughput to match demand
- **Global tables**: Multi-region replication for disaster recovery
- **TTL (Time to Live)**: Automatically delete old items
- **DynamoDB Streams**: Capture changes for real-time processing
- **Strong and eventual consistency**: Choose consistency model per query
- **Use cases**: Real-time applications, IoT data, user profiles, session storage

### **3. ElastiCache (In-Memory Caching)**
Managed caching service for performance:
- **Memcached**: Simple key-value caching, ideal for session storage
- **Redis**: Advanced data structures, pub/sub, persistence options
- **Session caching**: Reduce database load by caching frequently accessed data
- **Query result caching**: Cache expensive database queries
- **Real-time leaderboards**: Use Redis sorted sets for rankings
- **Automatic failover**: Multi-AZ deployments with automatic recovery
- **Use cases**: Session storage, application caching, real-time analytics

### **4. EFS (Elastic File System)**
Managed shared file system:
- **POSIX-compliant**: Compatible with Linux file system semantics
- **Automatic scaling**: Grows and shrinks automatically
- **Multi-AZ access**: Mount from multiple EC2 instances across AZs
- **NFS protocol**: Standard network file system, familiar to Linux users
- **Performance modes**: General Purpose or Max IO
- **Throughput modes**: Bursting or Provisioned
- **Use cases**: Shared application data, home directories, content repositories

---

## 🖼️ Visual References
- RDS Multi-AZ architecture with read replicas
- DynamoDB global tables and auto-scaling diagram
- ElastiCache deployment with application integration
- EFS shared file system across multiple AZs

---

## 🔑 Key Takeaways

✨ RDS provides managed relational databases with automated backups and failover  
✨ DynamoDB enables serverless NoSQL for flexible, scalable applications  
✨ ElastiCache dramatically improves performance by reducing database load  
✨ EFS provides shared file system storage for collaborative applications  

---

## 📝 AWS SAA Exam Relevance

Database and caching services are fundamental to SAA architecture questions. Expect scenarios requiring you to choose between RDS and DynamoDB, design caching strategies, and implement high-availability database architectures.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- RDS diagram shows Multi-AZ failover and read replica scaling
- DynamoDB diagram illustrates global tables and partition key design
- ElastiCache diagram shows integration with application tier
- EFS diagram shows shared access from multiple EC2 instances

Continue to **Day 12** for CDN & DNS: CloudFront and Route 53
