# DevOps Day 18: Identity Center

## 📖 Overview
Explore AWS Identity Center (formerly AWS SSO) for centralized identity and access management. This service simplifies user management and federation across multiple AWS accounts and applications.

---

## 🎯 Learning Objectives

✅ Understand AWS Identity Center architecture  
✅ Learn permission set management  
✅ Master multi-account access patterns  
✅ Prepare for enterprise identity scenarios

---

## 📚 Key Concepts

### **1. AWS Identity Center**
Centralized identity and access service:
- **Single place for user management**: Create, update, and delete users centrally
- **Multi-account access**: Single login for all AWS accounts in organization
- **Third-party IdP integration**: Connect existing Okta, Azure AD, Ping Identity
- **Permission sets**: Group permissions for consistent access control
- **Automatic provisioning**: SCIM protocol for user lifecycle management
- **MFA enforcement**: Require multi-factor authentication for all users
- **Session management**: Control session timeout and activity tracking

### **2. Permission Sets**
Flexible permission management:
- **Predefined permission sets**: AWS-managed templates (Administrator, PowerUser, ReadOnly)
- **Custom permission sets**: Create organization-specific permissions
- **Permission boundaries**: Limit maximum permissions
- **Account access**: Assign permission sets to specific AWS accounts
- **User groups**: Apply permission sets to groups of users
- **Just-in-time (JIT) access**: Temporary elevated permissions with approval
- **Effective permissions**: Union of assigned permission sets

### **3. Multi-Account Access Patterns**
Managing access across AWS accounts:
- **AWS Organizations**: Hierarchy of accounts for centralized management
- **Cross-account roles**: Assume roles in other accounts
- **Consolidated billing**: Single invoice for all member accounts
- **Service Control Policies (SCPs)**: Guard rails preventing dangerous actions
- **Account isolation**: Separate workloads for security and blast radius
- **Shared services account**: Central account for shared resources (logging, DNS)
- **Landing zones**: Reference architecture for multi-account setup

### **4. Federation and Integration**
Connecting external identity systems:
- **SCIM (System for Cross-domain Identity Management)**: Protocol for user provisioning
- **Okta integration**: Seamless single sign-on with Okta directory
- **Azure AD integration**: Microsoft enterprise identity integration
- **Custom IdP**: Support for other enterprise identity providers
- **No AWS console password**: Users authenticate with corporate credentials
- **Application SSO**: Extend SSO to SaaS applications through Identity Center

---

## 🖼️ Visual References
- AWS Identity Center architecture with user directory and federated accounts
- Permission set assignment across multiple AWS accounts
- Multi-account organization structure

---

## 🔑 Key Takeaways

✨ Identity Center provides centralized user management for multiple accounts  
✨ Permission sets simplify access control at enterprise scale  
✨ Federation enables corporate directory integration without AWS passwords  

---

## 📝 AWS SAA Exam Relevance

Identity Center is increasingly important for enterprise AWS scenarios. Expect questions on multi-account access, permission set design, and federation strategies in organizational contexts.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Architecture diagram shows Identity Center as central hub for user access
- Permission set diagram illustrates assignment across accounts and users
- Organization structure diagram shows account hierarchy and boundaries

Continue to **Day 19** for EC2 Families: Types and Features
