package demo.paypal.idp.model.common;

public class Email {

    private final String email;
    private final boolean primary;

    public Email(String email, boolean primary) {
        this.email = email;
        this.primary = primary;
    }

    public String getEmail() {
        return this.email;
    }

    public boolean isPrimary() {
        return this.primary;
    }
}
