# Cosmos DB Model for Business Account Scenario

Joe is setting up his bike shop, Joe's Bike Shop, and registers it as a legal business. He then creates a Business Account on PayPal, providing his EIN, linking his business bank account, and setting up authentication.

## **1. Joe’s Party (User Profile)**

**File Name:** `party_joe.json`  
**Container Name:** `Parties`  
**Partition Key:** `/partyId`  

```json
{
  "partyId": "party-joe-56789",
  "type": "Party",
  "name": {
    "first": "Joe",
    "last": "Doe"
  },
  "emails": [
    {
      "email": "joe.doe@somepubcre.net",
      "primary": true
    }
  ],
  "addresses": [
    {
      "type": "home",
      "street": "456 Elm St",
      "city": "Austin",
      "state": "TX",
      "zip": "73301",
      "country": "US",
      "primary": true
    }
  ],
  "phoneNumbers": [
    {
      "type": "mobile",
      "number": "+1-555-6789",
      "primary": true
    }
  ],
  "dob": "1980-02-10",
  "createdAt": "2025-03-19T10:00:00Z"
}
```

---

## **2. Joe’s Bike Shop Party (Business Entity)**

**File Name:** `party_business.json`  
**Container Name:** `Parties`  
**Partition Key:** `/partyId`  

```json
{
  "partyId": "party-biz-12345",
  "type": "Party",
  "businessName": "Joe's Bike Shop",
  "ein": "12-3456789",
  "addresses": [
    {
      "type": "business",
      "street": "100 Main St",
      "city": "Austin",
      "state": "TX",
      "zip": "73301",
      "country": "US",
      "primary": true
    }
  ],
  "phoneNumbers": [
    {
      "type": "business",
      "number": "+1-555-8888",
      "primary": true
    }
  ],
  "businessType": "Retail",
  "createdAt": "2025-03-19T10:05:00Z"
}
```

---

## **3. Credential (Login & Payment Identifier)**

**File Name:** `credential_joe.json`  
**Container Name:** `Credentials`  
**Partition Key:** `/credentialId`  

```json
{
  "credentialId": "cred-joe-78912",
  "type": "PublicCredential",
  "partyId": "party-joe-56789",
  "publicCredentialType": "email",
  "value": "joe.doe@somepubcre.net",
  "privateCredentialHashedValue": "hashed-password-value",
  "privateCredentialType": "password",
  "createdAt": "2025-03-19T10:10:00Z"
}
```

---

## **5. Business Account Document**

**File Name:** `business_account.json`  
**Container Name:** `Accounts`  
**Partition Key:** `/accountId`  

```json
{
  "accountId": "account-biz-67890",
  "type": "Account",
  "accountType": "Business",
  "businessName": "Joe's Bike Shop",
  "ownerParties": ["party-joe-56789", "party-biz-12345"],
  "paymentIdentifiers": [
    {
      "id": "payment-biz-abc123",
      "type": "email",
      "value": "payments@joesbikeshop.com"
    }
  ],
  "linkedBankAccounts": [
    {
      "bankName": "Local Bank",
      "accountNumber": "XXXX-7890",
      "accountType": "Business Checking"
    }
  ],
  "linkedCards": [
    {
      "cardType": "Business Visa",
      "last4": "5678",
      "expiry": "12/28"
    }
  ],
  "createdAt": "2025-03-19T10:15:00Z"
}
```

---

## **6. Joe’s Access Profile (Actor)**

**File Name:** `actor_joe.json`  
**Container Name:** `Actors`  
**Partition Key:** `/actorId`  

```json
{
  "actorId": "actor-joe-98765",
  "type": "Actor",
  "partyId": "party-joe-56789",
  "accessProfiles": [
    {
      "accountId": "account-biz-67890",
      "privileges": ["manage_account", "view_balance", "receive_money"]
    }
  ],
  "defaultAccount": "account-biz-67890",
  "createdAt": "2025-03-19T10:20:00Z"
}
```
