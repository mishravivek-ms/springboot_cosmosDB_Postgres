package demo.paypal.idp.model;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;
import demo.paypal.idp.model.common.BankAccount;
import demo.paypal.idp.model.common.Card;
import demo.paypal.idp.model.common.PaymentIdentifier;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.Objects;

@Container(containerName = "accounts", autoCreateContainer = true, autoScale = true, ru = "15000")
public class Accounts {

    @PartitionKey
    @Id
    private String accountId;
    private String type;
    private String accountType;
    private String businessName;
    private List<String> ownerParties;
    private List<PaymentIdentifier> paymentIdentifiers;
    private List<BankAccount> linkedBankAccounts;
    private List<Card> linkedCards;
    private String createdAt;


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;

    }

    public void setLinkedBankAccounts(List<BankAccount> linkedBankAccounts) {
        this.linkedBankAccounts = linkedBankAccounts;

    }

    public void setLinkedCards(List<Card> linkedCards) {
        this.linkedCards = linkedCards;

    }

    public void setPaymentIdentifiers(List<PaymentIdentifier> paymentIdentifiers) {
        this.paymentIdentifiers = paymentIdentifiers;

    }

    public void setOwnerParties(List<String> ownerParties) {
        this.ownerParties = ownerParties;

    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;

    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;

    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public List<Card> getLinkedCards() {
        return this.linkedCards;
    }

    public List<BankAccount> getLinkedBankAccounts() {
        return this.linkedBankAccounts;
    }

    public List<PaymentIdentifier> getPaymentIdentifiers() {
        return this.paymentIdentifiers;
    }

    public List<String> getOwnerParties() {
        return this.ownerParties;
    }

    public String getBusinessName() {
        return this.businessName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId='" + accountId + '\'' +
                ", type='" + type + '\'' +
                ", accountType='" + accountType + '\'' +
                ", businessName='" + businessName + '\'' +
                ", ownerParties=" + ownerParties +
                ", paymentIdentifiers=" + paymentIdentifiers +
                ", linkedBankAccounts=" + linkedBankAccounts +
                ", linkedCards=" + linkedCards +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return Objects.equals(accountId, accounts.accountId) &&
                Objects.equals(type, accounts.type) &&
                Objects.equals(accountType, accounts.accountType) &&
                Objects.equals(businessName, accounts.businessName) &&
                Objects.equals(ownerParties, accounts.ownerParties) &&
                Objects.equals(paymentIdentifiers, accounts.paymentIdentifiers) &&
                Objects.equals(linkedBankAccounts, accounts.linkedBankAccounts) &&
                Objects.equals(linkedCards, accounts.linkedCards) &&
                Objects.equals(createdAt, accounts.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, type, accountType, businessName, ownerParties, paymentIdentifiers, linkedBankAccounts, linkedCards, createdAt);
    }

}
