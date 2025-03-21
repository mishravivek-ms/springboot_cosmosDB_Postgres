# Cosmos DB Model for Business and Personal Account Scenario

## **Overview**
This document outlines the Cosmos DB data model for managing business and personal accounts in **CustomerA**. The model captures **parties (users and businesses), accounts, access profiles, authentication, and ownership structures**. This ensures **flexibility, scalability, and secure data partitioning**.

## **Scenario Progression**
The following outlines the evolution of Joe's business and personal account setup within **CustomerA**:

### **Phase 1: Business Account Setup**
Joe starts his business, **Joe's Bike Shop**, and creates a **Business Account** on CustomerA. 
- **Entities Created:** 
  - Business Account for **Joe's Bike Shop**
  - Joe's **Party** (Personal Profile)
  - Joe's **Public Credential** for authentication
  - Joe's **Access Profile** to manage the Business Account

### **Phase 2: Hiring Employees**
Joe hires **John** to help run the business. John gets a **limited access profile** for processing payments.
- **Entities Created:** 
  - John's **Party** (Personal Profile)
  - John's **Public Credential** for authentication
  - John's **Access Profile** (Limited access to the Business Account)

### **Phase 3: Personal Accounts for Employees**
John decides to create his **Personal Account** to receive payments from Joe directly.
- **Entities Created/Updated:**
  - John's **Personal Account**
  - **Updated Public Credential** to allow money reception
  - **Updated Access Profile** to allow login selection between the Business and Personal Account

### **Phase 4: Business Stakeholders Added**
Joe brings in **Fred and Mary** as **business stakeholders**.
- **Entities Created:**
  - **Fred’s Party** (Stakeholder)
  - **Mary’s Party** (Stakeholder)
  - **Updated Business Account Ownership** to reflect multiple stakeholders

### **Phase 5: Joint Personal Account for Joe and Mary**
Joe and Mary create a **Joint Personal Account** for shared expenses and payments.
- **Entities Created/Updated:**
  - Joint Personal Account
  - **Mary’s Party** (Personal Profile)
  - **Mary’s Public Credential** for authentication
  - **Updated Joe’s Access Profile** to allow account selection
  - **New Payment Identifier** for the Joint Account

---

## **Entities and Data Models**
### **1. Parties (Users & Businesses)**
- **Joe’s Party Entity** (`party_joe.json`)
- **John’s Party Entity** (`party_john.json`)
- **Mary’s Party Entity** (`party_mary.json`)
- **Fred’s Party Entity** (`party_fred.json`)
- **Mary’s Party Entity** (`party_mary_stakeholder.json`)
- **Joe’s Bike Shop Business Party Entity** (`party_business.json`)


### **2. Accounts**
- **Joe’s Bike Shop Business Account** (`business_account.json`)
- **John’s Personal Account** (`personal_account_john.json`)
- **Joe & Mary’s Joint Account** (`joint_account.json`)

### **3. Access Profiles (Actors)**
- **Joe’s Business & Personal Access Profile** (`actor_joe.json`)
- **John’s Employee & Personal Access Profile** (`actor_john.json`)
- **Mary’s Joint Account Access Profile** (`actor_mary.json`)

### **4. Authentication & Credentials**
- **Joe’s Public Credential** (`public_credential_joe.json`)
- **John’s Public Credential** (`public_credential_john.json`)
- **Mary’s Public Credential** (`public_credential_mary.json`)
- **Joe’s Private Credential** (`private_credential_joe.json`)
- **John’s Private Credential** (`private_credential_john.json`)
- **Mary’s Private Credential** (`private_credential_mary.json`)

### **5. Ownership Relationships**
- **Joe’s Ownership of Business & Joint Account**
- **Mary’s Ownership of Joint Account & Stakeholder Role**
- **Fred & Mary’s Stakeholder Role in Bike Shop**

---

## **Key  from the Playbook**
- **Accounts and Parties Are Separate:** The **Account** entity handles financial transactions, while **Parties** represent **people and businesses**.
- **Flexible Authentication:** Public credentials allow **a single login across multiple accounts**.
- **Stakeholders Can Be Tracked Separately:** They are **not Actors** and do not need login access.
- **Multi-Account Access Profiles:** The same **Party** can have **multiple Access Profiles** to control privileges for different accounts.

---
