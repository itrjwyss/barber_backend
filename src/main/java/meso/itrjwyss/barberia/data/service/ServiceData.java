package meso.itrjwyss.barberia.data.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import meso.itrjwyss.barberia.entities.ServiceEntity;

public class ServiceData {

    private Long id;
    private Boolean status;
    private String name;
    private String description;
    private BigDecimal price;

    @JsonIgnore
    public boolean isValid() {
        return (id != null && id > 0 && status != null && name != null && !name.isEmpty() && price != null);
    }

    public ServiceData() { /* Constructor genérico para reflexión de Jackson */ }

    public ServiceData(ServiceEntity serviceEntity) {
        this.id = serviceEntity.getId();
        this.status = serviceEntity.getStatus();
        this.name = serviceEntity.getName();
        this.description = serviceEntity.getDescription();
        this.price = serviceEntity.getPrice();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
