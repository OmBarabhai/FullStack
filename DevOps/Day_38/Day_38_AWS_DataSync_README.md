☁️ Day 38: AWS DataSync Practical - S3 to EFS Transfer

🎯 Project Goal

Transfer files from Amazon S3 to Amazon EFS using AWS DataSync and verify the transferred files from an EC2 instance mounted to EFS.

---

🧠 Why AWS DataSync?

Without DataSync:

S3
 ↓
Manual Scripts
 ↓
Copy Files
 ↓
EFS

Problems:

- Manual effort
- Scheduling complexity
- Error handling
- Slow large-scale transfers

With DataSync:

S3
 ↓
AWS DataSync
 ↓
EFS

Benefits:

- Managed service
- Automated transfers
- Faster migration
- Monitoring and reporting
- Secure data movement

---

🏗️ Architecture

High-Level Flow

Amazon S3
    ↓
DataSync Agent (EC2)
    ↓
AWS DataSync Service
    ↓
Amazon EFS
    ↓
EC2 Verification Instance

Architecture Diagram

"AWS DataSync Architecture" (./Images/02-aws-datasync-architecture.png)

Transfer Workflow

"S3 to EFS Transfer Workflow" (./Images/03-s3-to-efs-transfer-workflow.png)

---

🔩 Architecture Components

Component| Purpose
Amazon S3| Source storage
DataSync Agent| Reads and transfers data
AWS DataSync| Managed transfer service
Amazon EFS| Destination storage
EC2 Verification Instance| Verify transferred files
Security Group| Controls NFS traffic
EFS Mount Target| Network endpoint for EFS

---

🌐 Network Flow

S3 Bucket
    ↓
DataSync Agent
    ↓
TCP 2049 (NFS)
    ↓
EFS Mount Target
    ↓
Amazon EFS

---

🔐 Security Requirements

Resource| Requirement
EFS| TCP 2049
DataSync Agent| Outbound Access
S3 Bucket| IAM Access
EFS Mount Target| Available State
Security Group| NFS Allowed

---

⚙️ Commands Used

Get Latest DataSync Agent AMI

aws ssm get-parameter \
--name /aws/service/datasync/ami \
--region ap-south-1 \
--query "Parameter.Value" \
--output text

Example Output:

ami-0e617743295a316a7

---

📋 Practical Workflow

Step 1 - Create Private S3 Bucket

Created a private S3 bucket and uploaded sample files.

"Private S3 Bucket" (./Demo/01-s3-private-bucket-created.png)

---

Step 2 - Retrieve DataSync Agent AMI

Retrieved the latest AWS-managed DataSync Agent AMI.

"DataSync Agent AMI" (./Demo/02-datasync-agent-ami-generated.png)

---

Step 3 - Security Group Issue

Initial transfer failed because EFS blocked NFS traffic.

"Security Group Error" (./Demo/03-security-group-initial-error.png)

---

Step 4 - Fix Security Group

Allowed TCP 2049 for NFS communication.

"Security Group Fixed" (./Demo/04-security-group-fixed.png)

---

Step 5 - Create DataSync Agent

Created and activated the DataSync Agent on EC2.

"DataSync Agent Created" (./Demo/05-datasync-agent-created.png)

---

Step 6 - Register Activation Key

Connected the EC2 Agent to AWS DataSync.

"Activation Key Generated" (./Demo/06-agent-activation-key-generated.png)

---

Step 7 - Create EFS

Created Amazon EFS as the destination.

"EFS Created" (./Demo/07-efs-file-system-created.png)

---

Step 8 - Configure Source Location

Configured Amazon S3 as source.

"Source Location" (./Demo/08-datasync-source-location-s3.png)

---

Step 9 - Configure Destination Location

Configured Amazon EFS as destination.

"Destination Location" (./Demo/09-datasync-destination-efs.png)

---

Step 10 - Configure Transfer Task

Configured task settings.

"Task Configuration" (./Demo/10-datasync-task-configuration.png)

---

Step 11 - Review Advanced Settings

Validated task options before execution.

"Advanced Task Settings" (./Demo/11-datasync-task-advanced-settings.png)

---

Step 12 - Create Task

Created the DataSync task.

"Task Created" (./Demo/12-datasync-task-created.png)

---

Step 13 - Execute Task

Started the task with default options.

"Task Started" (./Demo/13-datasync-task-started.png)

---

Step 14 - Transfer Completed Successfully

Files transferred successfully.

"Transfer Successful" (./Demo/14-datasync-transfer-successful.png)

---

Step 15 - Launch Verification EC2

Created EC2 instance to verify EFS content.

"EC2 Instance" (./Demo/15-ec2-instance-for-verification.png)

---

Step 16 - Mount EFS

Connected to EC2 and mounted EFS.

"Login EC2" (./Demo/16-login-to-ec2-instance.png)

---

Step 17 - Verify Files

Confirmed transferred files inside EFS.

"Files Verified" (./Demo/17-files-verified-on-efs.png)

---

🧪 Verification Commands

Install EFS Utilities:

yum install -y nfs-utils

Create Mount Directory:

mkdir DataSync_Test

Mount EFS:

mount -t nfs4 <efs-dns-name>:/ DataSync_Test

Verify Files:

cd DataSync_Test
ls

---

⚠️ Troubleshooting

Error Faced

Failed to connect to EFS mount target

Root Cause

TCP 2049 blocked by EFS Security Group

Fix

Allow NFS (TCP 2049) in the EFS Security Group

---

🎤 Interview Questions

What is AWS DataSync?

A managed service used for secure and automated data transfer between storage systems.

What is a DataSync Agent?

A virtual machine that performs data transfers between source and destination locations.

Why is EFS used?

EFS provides shared file storage that can be mounted on multiple EC2 instances.

Which port is required for EFS?

TCP 2049

Why did the transfer fail initially?

The EFS Security Group blocked NFS traffic.

Difference Between S3 and EFS?

Amazon S3| Amazon EFS
Object Storage| File Storage
Bucket Based| NFS Based
Not Mountable| Mountable
Infinite Scale| Shared File System

---

📚 Lessons Learned

- DataSync requires network connectivity to EFS.
- EFS communication uses NFS protocol.
- NFS requires TCP 2049.
- Security Groups are the most common source of failures.
- DataSync Agent must be activated before task creation.
- EFS can be verified by mounting it on an EC2 instance.

---

☁️ AWS Services Used

- Amazon S3
- AWS DataSync
- Amazon EFS
- Amazon EC2
- IAM
- Security Groups
- NFS

---

🚀 Resume Project

AWS DataSync - S3 to EFS Migration

Implemented an end-to-end AWS DataSync workflow to migrate files from Amazon S3 to Amazon EFS using an EC2-based DataSync Agent. Configured source and destination locations, resolved NFS connectivity issues, executed migration tasks, and verified successful synchronization through an EC2-mounted EFS instance.

Technologies: AWS DataSync, Amazon S3, Amazon EFS, Amazon EC2, IAM, Security Groups, NFS

---

🏁 Final Summary

Successfully designed and implemented a complete S3-to-EFS migration workflow using AWS DataSync, including agent deployment, storage configuration, security troubleshooting, task execution, and file verification.