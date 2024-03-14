package meso.itrjwyss.barberia.data.appointment;

import java.util.List;

public class UpdateAppointmentRequest {

    private Long id;
    private Boolean status;
    private String day;
    private String hourStart;
    private String hourEnd;
    private Long customerId;
    private Long barberId;
    private List<AppointmentServiceData> serviceDataList;

    public boolean isValid() {
        return (
            id != null &&
            status != null &&
            day != null &&
            hourStart != null &&
            hourEnd != null &&
            customerId != null &&
            barberId != null
        );
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHourStart() {
        return hourStart;
    }

    public void setHourStart(String hourStart) {
        this.hourStart = hourStart;
    }

    public String getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(String hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public List<AppointmentServiceData> getServiceDataList() {
        return serviceDataList;
    }

    public void setServiceDataList(List<AppointmentServiceData> serviceDataList) {
        this.serviceDataList = serviceDataList;
    }
}
