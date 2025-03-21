package demo.paypal.idp.model.common;

public class Name {

    private final String first;
    private final String last;

    public Name(final String first, final String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return this.first;
    }

    public String getLast() {
        return this.last;
    }
}
