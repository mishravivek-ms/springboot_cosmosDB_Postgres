package demo.paypal.idp.model.common;

public class Address {

    private final String street;
    private final String city;
    private final String state;
    private final String zip;
    private final String country;
    private final String primary;

    public Address(String street, String city, String state, String zip, String country, String primary) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.primary = primary;
    }

    public String getStreet() {
        return this.street;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }

    public String getZip() {
        return this.zip;
    }

    public String getCountry() {
        return this.country;
    }

    public String getPrimary() {
        return this.primary;
    }
}
