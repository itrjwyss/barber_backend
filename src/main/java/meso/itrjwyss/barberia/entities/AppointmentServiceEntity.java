package meso.itrjwyss.barberia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointment_id", nullable = false)
    private AppointmentEntity appointment;

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public AppointmentEntity getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentEntity appointment) {
        this.appointment = appointment;
    }
}
