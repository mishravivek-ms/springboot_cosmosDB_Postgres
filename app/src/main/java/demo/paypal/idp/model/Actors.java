package demo.paypal.idp.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import demo.paypal.idp.model.common.AccessProfile;

import java.util.List;

@Container(containerName = "actors", autoCreateContainer = true, autoScale = true, ru = "15000")
public class Actors {

    @PartitionKey
    private String id;
    private String type;
    private String partyId;
    private List<AccessProfile> accessProfiles;
    private String defaultAccount;
    private String createdAt;

    public Actors() {}

    public Actors setId(String id) {
        this.id = id;
        return this;
    }

    public Actors setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Actors setDefaultAccount(String defaultAccount) {
        this.defaultAccount = defaultAccount;
        return this;
    }

    public Actors setAccessProfiles(List<AccessProfile> accessProfiles) {
        this.accessProfiles = accessProfiles;
        return this;
    }

    public Actors setPartyId(String partyId) {
        this.partyId = partyId;
        return this;
    }

    public Actors setType(String type) {
        this.type = type;
        return this;
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

    public List<AccessProfile> getAccessProfiles() {
        return this.accessProfiles;
    }

    public String getDefaultAccount() {
        return this.defaultAccount;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", partyId='" + partyId + '\'' +
                ", accessProfiles=" + accessProfiles +
                ", defaultAccount='" + defaultAccount + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
