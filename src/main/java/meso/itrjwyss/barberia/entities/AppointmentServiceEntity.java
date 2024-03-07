package meso.itrjwyss.barberia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(
    name = "appointment_service"
)
public class AppointmentServiceEntity extends GenericEntity {

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceEntity service;

    @ManyToOne
    @JoinColumn(name = "appointment_id", nullable = false)

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }
}
