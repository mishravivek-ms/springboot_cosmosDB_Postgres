package demo.paypal.idp.model.common;

import java.util.List;

public class AccessProfile {

    private final String accountId;
    private final List<String> privileges;

    public AccessProfile(String accountId, List<String> privileges) {
        this.accountId = accountId;
        this.privileges = privileges;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public List<String> getPrivileges() {
        return this.privileges;
    }
}
