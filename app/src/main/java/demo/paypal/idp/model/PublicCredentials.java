package demo.paypal.idp.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import demo.paypal.idp.model.common.PrivateCredential;

@Container(containerName = "publicCredentials", autoCreateContainer = true, autoScale = true, ru = "15000")
public class PublicCredentials {

    @PartitionKey
    private String id;
    private String type;
    private String partyId;
    private String credentialType;
    private String value;
    private PrivateCredential privateCredential;
    private String createdAt;

    public PublicCredentials() {}

    public PublicCredentials setId(String id) {
        this.id = id;
        return this;
    }

    public PublicCredentials setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public PublicCredentials setPrivateCredential(PrivateCredential privateCredential) {
        this.privateCredential = privateCredential;
        return this;
    }

    public PublicCredentials setValue(String value) {
        this.value = value;
        return this;
    }

    public PublicCredentials setCredentialType(String credentialType) {
        this.credentialType = credentialType;
        return this;
    }

    public PublicCredentials setPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    public PublicCredentials setType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public PrivateCredential getPrivateCredential() {
        return this.privateCredential;
    }

    public String getValue() {
        return this.value;
    }

    public String getCredentialType() {
        return this.credentialType;
    }

    public String getPartyId() {
        return this.partyId;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "PublicCredentials{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", partyId='" + partyId + '\'' +
                ", credentialType='" + credentialType + '\'' +
                ", value='" + value + '\'' +
                ", privateCredential=" + privateCredential +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
