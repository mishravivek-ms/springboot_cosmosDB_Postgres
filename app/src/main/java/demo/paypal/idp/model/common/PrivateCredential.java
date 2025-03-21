package demo.paypal.idp.model.common;

public class PrivateCredential {

    private final String id;
    private final String type;
    private final String partyId;
    private final String hashedValue;
    private final String credentialType;
    private final String createdAt;

    public PrivateCredential(String id, String type, String partyId, String hashedValue, String credentialType, String createdAt) {
        this.id = id;
        this.type = type;
        this.partyId = partyId;
        this.hashedValue = hashedValue;
        this.credentialType = credentialType;
        this.createdAt = createdAt;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getHashedValue() {
        return this.hashedValue;
    }

    public String getCredentialType() {
        return this.credentialType;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }
}
