package meso.itrjwyss.barberia.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(
    name = "appointment"
)
public class AppointmentEntity extends GenericEntity {

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date day;

    @Temporal(TemporalType.TIME)
    @Column(name = "hour_start", nullable = false)
    private Date hourStart;

    @Temporal(TemporalType.TIME)
    @Column(name = "hour_end", nullable = false)
    private Date hourEnd;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private CustomerEntity customer;

    @ManyToOne
    @JoinColumn(name = "barber_id", nullable = false)
    private BarberEntity barber;

    @OneToMany(mappedBy = "appointment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AppointmentServiceEntity> serviceList = new ArrayList<>();

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

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public BarberEntity getBarber() {
        return barber;
    }

    public void setBarber(BarberEntity barber) {
        this.barber = barber;
    }

    public List<AppointmentServiceEntity> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<AppointmentServiceEntity> serviceList) {
        this.serviceList = serviceList;
    }

    public void addService(AppointmentServiceEntity service) {
        serviceList.add(service);
    }
}
