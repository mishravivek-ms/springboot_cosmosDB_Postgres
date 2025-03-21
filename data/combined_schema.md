# Combined CosmosDB Schema Configuration

## Overview
This document provides a comprehensive overview of the CosmosDB collections configuration, combining both User Configuration and Party Management database schemas. The setup is designed to support user management, party relationships, account activities, and document management functionalities.

## Collection Overview

| Container | Partition Key | Purpose |
|-----------|--------------|----------|
| AccountActivityLog | `/accountNumber` | Tracks all account-related activities and events |
| AccountCapabilityHist | `/accountNumber` | Maintains history of account capabilities and their states |
| Party | `/id` | Stores core party information including preferences and settings |
| PartyActivityLog | `/partyId` | Records all party-related activities and events |
| CredentialPublic | `/id` | Manages public credentials and authentication information |
| EmailAddress | `/id` | Stores email addresses with verification status |
| Phone | `/id` | Maintains phone number information |
| PartyRelationship | `/id` | Manages relationships between different parties |
| ProductCapability | `/productCode` | Defines product capabilities and features |
| PartySecurityQuestion | `/partyId` | Stores security questions and validations |
| PartyVulnerability | `/partyVulnerabilityId` | Tracks party vulnerabilities and consent management |
| AcctProdSubscriptionHistory | `/id` | Maintains product subscription history for accounts |
| DocumentConfiguration | `/type` | Stores document issuer and encryption configurations |
| PartyLegal | `/scuttleId` | Manages legal agreements and entitlements |

## Detailed Configuration

### Account Management Collections

#### AccountActivityLog
- **Partition Key**: `/accountNumber`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /accountNumber
  - /activityType
  - /activityTime
  - /correlationId
  - /referenceId
  - /timeCreated
  - /scuttleId

#### AccountCapabilityHist
- **Partition Key**: `/accountNumber`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /accountCapabilityHistTuid
  - /accountCapabilityId
  - /accountNumber
  - /capabilityName
  - /status
  - /timeCreated
  - /isLimited
  - /debugId

### Party Management Collections

#### Party
- **Partition Key**: `/id`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /id
  - /partyType
  - /isoPreferredLanguage
  - /timezoneCode
  - /disposition
  - /timeCreated
  - /timeUpdated
  - /updateVersion
- **Sub-document Types**:
  - Party (core information)
  - PartyName
  - PartyEmail
  - PartyPhone
  - PartyDocument

#### PartyRelationship
- **Partition Key**: `/id`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /id
  - /partyId1
  - /partyId2
  - /partyPartyRelType
  - /status
- **Unique Keys**:
  - /partyId,/relPartyId,/relationType

### Communication Collections

#### EmailAddress
- **Partition Key**: `/id`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /id
  - /emailAddress
  - /confirmationStatus
  - /confirmationAuthority
  - /timeCreated
  - /timeUpdated

#### Phone
- **Partition Key**: `/id`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /id
  - /countryCallingCode
  - /phoneNumber
  - /extensionNumber

### Security and Authentication

#### CredentialPublic
- **Partition Key**: `/id`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /id
  - /domain
  - /pcValue
  - /partyId
  - /receivingAccountNumber
  - /challengeStatus
  - /status

#### PartySecurityQuestion
- **Partition Key**: `/partyId`
- **Auto-scale Throughput**: 4000 RU/s
- **Indexed Paths**:
  - /partyId
  - /question1
  - /validation1
  - /question2
  - /validation2
  - /timeCreated
  - /timeUpdated

## Design Considerations

1. **Partitioning Strategy**
   - Partition keys are chosen based on the primary access patterns
   - Some collections use scuttle ID-based partitioning (0-255 range)
   - Others use natural business keys for partitioning

2. **Performance Optimization**
   - All collections configured with auto-scaled throughput starting at 4000 RU/s
   - Optimized indexing policies for common query patterns
   - Composite indexes for frequently queried field combinations

3. **Data Consistency**
   - Common fields (timeCreated, timeUpdated, status) indexed across collections
   - Change feed enabled for maintaining secondary indexes
   - Stored procedures available for transactional consistency

4. **Monitoring Requirements**
   - Monitor RU consumption patterns
   - Track hot partition usage
   - Regular consistency checks
   - Monitor change feed operations

## Usage

To create and configure these collections, use the CLI utility:

```bash
java -jar cli-utility-1.0-SNAPSHOT.jar -e <cosmos-endpoint> -k <cosmos-key> -d <database-name>
```

Options:
- `-e` or `--endpoint`: CosmosDB endpoint URL
- `-k` or `--key`: CosmosDB access key
- `-d` or `--database`: Database name
- `-h` or `--help`: Display help information
