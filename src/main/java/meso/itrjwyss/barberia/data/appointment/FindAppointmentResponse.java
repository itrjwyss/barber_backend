package meso.itrjwyss.barberia.data.appointment;

import java.util.ArrayList;
import java.util.List;
import meso.itrjwyss.barberia.data.BaseResponse;
import meso.itrjwyss.barberia.data.ListData;

public class FindAppointmentResponse extends BaseResponse {

    private AppointmentData appointment = null;
    private List<AppointmentServiceData> serviceList = null;

    private List<ListData> barbers =  new ArrayList<>();
    private List<ListData> customers = new ArrayList<>();
    private List<ListData> services = new ArrayList<>();

    public AppointmentData getAppointment() {
        return appointment;
    }

    public void setAppointment(AppointmentData appointment) {
        this.appointment = appointment;
    }

    public List<AppointmentServiceData> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<AppointmentServiceData> serviceList) {
        this.serviceList = serviceList;
    }

    public List<ListData> getBarbers() {
        return barbers;
    }

    public void setBarbers(List<ListData> barbers) {
        this.barbers = barbers;
    }

    public List<ListData> getCustomers() {
        return customers;
    }

    public void setCustomers(List<ListData> customers) {
        this.customers = customers;
    }

    public List<ListData> getServices() {
        return services;
    }

    public void setServices(List<ListData> services) {
        this.services = services;
    }
}
