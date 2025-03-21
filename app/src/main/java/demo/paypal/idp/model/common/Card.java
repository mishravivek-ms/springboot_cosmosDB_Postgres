package demo.paypal.idp.model.common;

public class Card {

    private final String cardType;
    private final String last4;
    private final String expiry;

    public Card(String cardType, String last4, String expiry) {
        this.cardType = cardType;
        this.last4 = last4;
        this.expiry = expiry;
    }

    public String getCardType() {
        return this.cardType;
    }

    public String getLast4() {
        return this.last4;
    }

    public String getExpiry() {
        return this.expiry;
    }
}
