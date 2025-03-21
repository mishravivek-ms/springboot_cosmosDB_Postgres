package demo.paypal.idp.model.oracle;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Parties {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String type;
    private String businessName;
    private String ein;

    // for JPA only, no use
    public Parties() {
    }

    public Parties(Long id, String type, String businessName, String ein) {
        this.id = id;
        this.type = type;
        this.businessName = businessName;
        this.ein = ein;
    }

    @Override
    public String toString() {
        return "parties{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", businessName='" + businessName + '\'' +
                ", ein='" + ein + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
