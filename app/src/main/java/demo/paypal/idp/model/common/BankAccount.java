package demo.paypal.idp.model.common;

public class BankAccount {

    private final String bankName;
    private final String accountNumber;
    private final String accountType;

    public BankAccount(String bankName, String accountNumber, String accountType) {
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
    }

    public String getBankName() {
        return this.bankName;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }
}
