package meso.itrjwyss.barberia.data.appointment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import meso.itrjwyss.barberia.entities.AppointmentEntity;

public class AppointmentData {

    private Long id;
    private Boolean status;
    private Date day;
    private Date hourStart;
    private Date hourEnd;
    private Long customerId;
    private String customerName;
    private String customerPhoneNumber;
    private Long barberId;
    private String barberName;

    @JsonIgnore
    public boolean isValid() {
        return (id != null
            && id > 0
            && status != null
            && day != null
            && hourStart != null
            && hourEnd != null
            && customerId != null
            && barberId != null
        );
    }

    public AppointmentData() { /* Constructor genérico para reflexión de Jackson */ }

    public AppointmentData(AppointmentEntity appointmentEntity) {
        this.id = appointmentEntity.getId();
        this.status = appointmentEntity.getStatus();
        this.day = appointmentEntity.getDay();
        this.hourStart = appointmentEntity.getHourStart();
        this.hourEnd = appointmentEntity.getHourEnd();
        this.customerId = appointmentEntity.getCustomer().getId();
        this.customerName = appointmentEntity.getCustomer().getName();
        this.customerPhoneNumber = appointmentEntity.getCustomer().getPhoneNumber();
        this.barberId = appointmentEntity.getBarber().getId();
        this.barberName = appointmentEntity.getBarber().getName();
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

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Date getHourStart() {
        return hourStart;
    }

    public void setHourStart(Date hourStart) {
        this.hourStart = hourStart;
    }

    public Date getHourEnd() {
        return hourEnd;
    }

    public void setHourEnd(Date hourEnd) {
        this.hourEnd = hourEnd;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public Long getBarberId() {
        return barberId;
    }

    public void setBarberId(Long barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }
}
