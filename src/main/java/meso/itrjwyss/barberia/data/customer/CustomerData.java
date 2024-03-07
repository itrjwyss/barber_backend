package meso.itrjwyss.barberia.data.customer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import meso.itrjwyss.barberia.entities.CustomerEntity;

public class CustomerData {

    private Long id;
    private Boolean status;
    private String name;
    private String phoneNumber;

    @JsonIgnore
    public boolean isValid() {
        return (id != null
            && id > 0
            && status != null
            && name != null
            && !name.isEmpty()
            && phoneNumber != null
            && !phoneNumber.isEmpty()
        );
    }

    public CustomerData() { /* Constructor genérico para reflexión de Jackson */ }

    public CustomerData(CustomerEntity customerEntity) {
        this.id = customerEntity.getId();
        this.status = customerEntity.getStatus();
        this.name = customerEntity.getName();
        this.phoneNumber = customerEntity.getPhoneNumber();;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

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
