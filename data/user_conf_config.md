# CosmosDB Collection Configuration

This document describes the configuration approach for setting up CosmosDB collections for the User Configuration database.

## Overview

The database setup is automated through a Java-based utility that creates collections with appropriate indexing policies and auto-scale throughput settings. Each collection is configured with specific partition keys and indexed paths optimized for the expected query patterns.

## Collections

### AccountActivityLog
- Partition Key: `/accountNumber`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /accountNumber
  - /activityType
  - /activityTime
  - /correlationId
  - /referenceId
  - /timeCreated
  - /scuttleId

### AccountCapabilityHist
- Partition Key: `/accountNumber`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /accountCapabilityHistTuid
  - /accountCapabilityId
  - /accountNumber
  - /capabilityName
  - /status
  - /timeCreated
  - /isLimited
  - /debugId

### Party
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /partyType
  - /isoPreferredLanguage
  - /timezoneCode
  - /disposition
  - /timeCreated
  - /timeUpdated
  - /updateVersion

### PartyActivityLog
- Partition Key: `/partyId`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /partyId
  - /activityType
  - /activityTime
  - /correlationId
  - /referenceId
  - /timeCreated
  - /scuttleId

### CredentialPublic
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /domain
  - /pcValue
  - /partyId
  - /receivingAccountNumber
  - /challengeStatus
  - /status
  - /timeCreated
  - /timeUpdated

### EmailAddress
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /emailAddress
  - /confirmationStatus
  - /confirmationAuthority
  - /timeCreated
  - /timeUpdated
  - /updateVersion

### Phone
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /countryCallingCode
  - /phoneNumber
  - /extensionNumber

### PartyRelationship
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /partyId1
  - /partyId2
  - /partyPartyRelType
  - /status
  - /timeCreated
  - /timeUpdated
  - /updateVersion

### ProductCapability
- Partition Key: `/productCode`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /productCode
  - /capabilityName
  - /countryCode
  - /timeCreated
  - /timeUpdated

### PartySecurityQuestion
- Partition Key: `/partyId`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /partyId
  - /question1
  - /validation1
  - /question2
  - /validation2
  - /timeCreated
  - /timeUpdated
  - /updateVersion
  - /scuttleId

### PartyVulnerability
- Partition Key: `/partyVulnerabilityId`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /partyVulnerabilityId
  - /partyId
  - /vulnerabilityId
  - /vulnerabilityNature
  - /status
  - /timeConsentGiven
  - /timeConsentWithdrawn
  - /timeVulnerabilityEnded
  - /timeCreated
  - /timeUpdated
  - /updateVersion

### AcctProdSubscriptionHistory
- Partition Key: `/id`
- Auto-scale Throughput: 4000 RU/s
- Indexed Paths:
  - /id
  - /accountNumber
  - /productId
  - /productCode
  - /status
  - /isDeficient
  - /timeCreated
  - /timeUpdated
  - /updateVersion
  - /scuttleId
  - /oldStatus
  - /debugId
  - /acctProdSubscriptionId
  - /isPartial
  - /provisioningContext

## Usage

To create the collections, use the CLI utility with the following parameters:

```bash
java -jar cli-utility-1.0-SNAPSHOT.jar -e <cosmos-endpoint> -k <cosmos-key> -d <database-name>
```

Options:
- `-e` or `--endpoint`: CosmosDB endpoint URL
- `-k` or `--key`: CosmosDB access key
- `-d` or `--database`: Database name
- `-h` or `--help`: Display help information

## Design Considerations

1. All collections are configured with auto-scaled throughput starting at 4000 RU/s
2. Partition keys are chosen based on the primary access patterns of each collection
3. Indexing policies are optimized for the most common query patterns
4. Common fields like timeCreated, timeUpdated, and status are indexed across collections
5. Each collection includes specific indexes relevant to its domain model
