package demo.paypal.idp.model.response;

public class PartiesResponse {
    private String id;
    private String type;
    private String businessName;
    private String ein;

    public PartiesResponse() {
    }

    public PartiesResponse(String id, String type, String businessName, String ein) {
        this.id = id;
        this.type = type;
        this.businessName = businessName;
        this.ein = ein;
    }

    @Override
    public String toString() {
        return "PartiesResponse{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", businessName='" + businessName + '\'' +
                ", ein='" + ein + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getEin() {
        return ein;
    }

    public void setEin(String ein) {
        this.ein = ein;
    }
}
