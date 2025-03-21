package demo.paypal.idp.model.common;

public class PaymentIdentifier {

    private final String id;
    private final String value;
    private final String type;

    public PaymentIdentifier(String id, String value, String type) {
        this.id = id;
        this.value = value;
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }

    public String getType() {
        return this.type;
    }
}
