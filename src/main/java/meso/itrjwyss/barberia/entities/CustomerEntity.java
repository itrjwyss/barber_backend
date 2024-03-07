package meso.itrjwyss.barberia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "customer"
)
public class CustomerEntity extends GenericEntity {

    @Column(length = 80, nullable = false)
    private String name;

    @Column(name = "phone_number", length = 15, nullable = false)
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
