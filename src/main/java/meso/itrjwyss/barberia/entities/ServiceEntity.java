package meso.itrjwyss.barberia.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(
    name = "service"
)
public class ServiceEntity extends GenericEntity {

    @Column(length = 50, nullable = false, unique = true)
    private String name;

    @Column(length = 200)
    private String description;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal price;

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
