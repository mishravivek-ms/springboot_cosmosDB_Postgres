package demo.paypal.idp.model.common;

public class PhoneNumber {

    private final String type;
    private final String number;
    private final boolean primary;

    public PhoneNumber(String type, String number, boolean primary) {
        this.type = type;
        this.number = number;
        this.primary = primary;
    }

    public String getType() {
        return this.type;
    }

    public String getNumber() {
        return this.number;
    }

    public boolean isPrimary() {
        return this.primary;
    }
}
