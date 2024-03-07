package meso.itrjwyss.barberia.data.barber;

import com.fasterxml.jackson.annotation.JsonIgnore;
import meso.itrjwyss.barberia.entities.BarberEntity;

public class BarberData {

    private Long id;
    private Boolean status;
    private String name;

    @JsonIgnore
    public boolean isValid() {
        return (id != null
            && id > 0
            && status != null
            && name != null
            && !name.isEmpty()
        );
    }

    public BarberData() { /* Constructor genérico para reflexión de Jackson */ }

    public BarberData(BarberEntity barberEntity) {
        this.id = barberEntity.getId();
        this.status = barberEntity.getStatus();
        this.name = barberEntity.getName();
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
}
