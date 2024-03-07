package meso.itrjwyss.barberia.data.appointment;

import meso.itrjwyss.barberia.entities.AppointmentServiceEntity;

public class AppointmentServiceData {

    private Long id;
    private Boolean status;
    private String serviceName;

    public AppointmentServiceData() { }

    public AppointmentServiceData(AppointmentServiceEntity serviceEntity) {
        this.id = serviceEntity.getId();
        this.status = serviceEntity.getStatus();
        this.serviceName = serviceEntity.getService().getName();
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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
