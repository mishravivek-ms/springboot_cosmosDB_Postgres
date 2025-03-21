package demo.paypal.idp.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import demo.paypal.idp.model.common.Address;
import demo.paypal.idp.model.common.PhoneNumber;
import demo.paypal.idp.model.common.Name;
import demo.paypal.idp.model.common.Email;

import java.util.List;
import java.util.Objects;

@Container(containerName = "parties", autoCreateContainer = true, autoScale = true, ru = "15000")
public class Parties {

    @PartitionKey
    private String id;
    private String type;
    private String businessName;
    private String ein;
    private List<Address> addresses;
    private List<PhoneNumber> phoneNumbers;
    private List<Email> emails;
    private String businessType;
    private String createdAt;
    private String dob;
    private Name name;

    public Parties() {}

    public Parties setId(String id) {
        this.id = id;
        return this;
    }

    public Parties setDob(String dob) {
        this.dob = dob;
        return this;
    }

    public Parties setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Parties setBusinessType(String businessType) {
        this.businessType = businessType;
        return this;
    }

    public Parties setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public Parties setAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public Parties setEin(String ein) {
        this.ein = ein;
        return this;
    }

    public Parties setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }

    public Parties setType(String type) {
        this.type = type;
        return this;
    }

    public Parties setName(Name name) {
        this.name = name;
        return this;
    }

    public Parties setEmails(List<Email> emails) {
        this.emails = emails;
        return this;
    }

    public String getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getEin() {
        return this.ein;
    }

    public List<Address> getAddresses() {
        return this.addresses;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public List<Email> getEmails() {
        return this.emails;
    }

    public String getBusinessType() {
        return this.businessType;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDob() {
        return this.dob;
    }

    public Name getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Parties{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", businessName='" + businessName + '\'' +
                ", ein='" + ein + '\'' +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneNumbers +
                ", emails=" + emails +
                ", businessType='" + businessType + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", dob='" + dob + '\'' +
                ", name=" + name +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parties parties = (Parties) o;
        return Objects.equals(id, parties.id) &&
                Objects.equals(type, parties.type) &&
                Objects.equals(businessName, parties.businessName) &&
                Objects.equals(ein, parties.ein) &&
                Objects.equals(addresses, parties.addresses) &&
                Objects.equals(phoneNumbers, parties.phoneNumbers) &&
                Objects.equals(emails, parties.emails) &&
                Objects.equals(businessType, parties.businessType) &&
                Objects.equals(createdAt, parties.createdAt) &&
                Objects.equals(dob, parties.dob) &&
                Objects.equals(name, parties.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, businessName, ein, addresses, phoneNumbers, emails, businessType, createdAt, dob, name);
    }
}
