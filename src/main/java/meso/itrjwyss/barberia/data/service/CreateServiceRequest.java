package meso.itrjwyss.barberia.data.service;

import java.math.BigDecimal;

public class CreateServiceRequest {

    private String name;
    private String description;
    private BigDecimal price;

    public boolean isValid() {
        return (name != null && !name.isEmpty() && price != null);
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
