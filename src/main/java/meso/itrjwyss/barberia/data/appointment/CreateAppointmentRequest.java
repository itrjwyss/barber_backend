package meso.itrjwyss.barberia.data.appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CreateAppointmentRequest {

    private String day;
    private String hourStart;
    private String hourEnd;
    private Long customerId;
    private Long barberId;
    private List<Long> serviceIdList;

    public boolean isValid() {
        return (day != null && hourStart != null && hourEnd != null && customerId != null && barberId != null);
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

    public List<Long> getServiceIdList() {
        return Objects.requireNonNullElseGet(serviceIdList, ArrayList::new);
    }

    public void setServiceIdList(List<Long> serviceIdList) {
        this.serviceIdList = serviceIdList;
    }
}
