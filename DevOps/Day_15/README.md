# DevOps Day 15: IAM Structure

## 📖 Overview
Understand IAM organizational structures including Identity Providers, Roles, and Groups. Master how to organize users and permissions at enterprise scale for security and manageability.

---

## 🎯 Learning Objectives

✅ Understand Identity Providers and federation  
✅ Learn role-based access control (RBAC)  
✅ Master group management and inheritance  
✅ Prepare for enterprise identity scenarios

---

## 📚 Key Concepts

### **1. Identity Providers (IdPs)**
External authentication systems integrated with AWS:
- **SAML (Security Assertion Markup Language)**: Enterprise SSO protocol for federated access
- **OpenID Connect**: Standards-based federation for mobile and web applications
- **ADFS (Active Directory Federation Services)**: Microsoft's implementation of SAML
- **Okta, Ping Identity, Azure AD**: Third-party IdPs for enterprise authentication
- **Identity federation**: Users authenticate with IdP, receive temporary AWS credentials
- **No AWS password required**: Users use corporate credentials (AD, Okta, etc.)
- **Audit and compliance**: Centralized authentication logs for compliance

### **2. IAM Roles and Role-Based Access Control (RBAC)**
Organizing permissions by role:
- **Role creation**: Define permissions needed for specific job functions
- **Role inheritance**: Attach multiple policies to single role
- **Service roles**: Roles that services (EC2, Lambda) assume
- **Cross-service roles**: Allow services to access other services
- **Temporary credentials**: Roles issue temporary STS credentials
- **Role session durations**: Control credential validity (900s to 12h)
- **Common roles**: DeveloperRole, AdminRole, ReadOnlyRole
- **Role versioning**: Manage multiple versions of role policies

### **3. IAM Groups**
Organizing users with common permissions:
- **Group membership**: Add users to groups, not individual users
- **Permission inheritance**: Users inherit group permissions
- **Simplified management**: Update permissions for entire group at once
- **Common groups**: Developers, QA, Operations, Security Teams
- **No nested groups**: Groups cannot contain other groups
- **Permissions**: Attach policies directly to groups
- **Scale to thousands**: Manage large organizations efficiently
- **Self-service**: Users can potentially manage own group membership

### **4. Permission Model Organization**
Enterprise-scale permission design:
- **Job function policies**: AWS-managed policies for common roles (DatabaseAdministrator, PowerUserAccess)
- **Custom policies**: Organization-specific permissions
- **Permission boundaries**: Limit maximum permissions per user or role
- **Resource tagging**: Control access to resources based on tags
- **Environment separation**: Prod vs Dev permissions via resource tags
- **Cost center allocation**: Tag resources for billing and access control

---

## 🖼️ Visual References
- Identity Provider federation architecture with SAML flow
- IAM organizational structure showing users, groups, and roles
- Permission inheritance hierarchy for RBAC

---

## 🔑 Key Takeaways

✨ Identity Providers enable enterprise SSO without AWS credentials  
✨ Roles provide flexible, temporary access control  
✨ Groups simplify permission management at scale  

---

## 📝 AWS SAA Exam Relevance

Enterprise identity architecture is tested in SAA exams. Expect scenarios requiring you to design IdP integration, organize users and roles, and implement RBAC in large organizations.

---

## 🚀 Next Steps

Review the visual diagrams in the `Notes/` folder:
- Identity Provider diagram shows federation and SAML assertion flow
- Organizational structure diagram illustrates user, group, and role relationships
- Permission inheritance diagram demonstrates RBAC in action

Continue to **Day 16** for Advanced Security: SAML, SSO, Tags, and Key Pairs
