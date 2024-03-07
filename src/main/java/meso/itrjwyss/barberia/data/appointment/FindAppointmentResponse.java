package meso.itrjwyss.barberia.data.appointment;

import java.util.List;
import meso.itrjwyss.barberia.data.BaseResponse;

public class FindAppointmentResponse extends BaseResponse {

    private AppointmentData appointment = null;
    private List<AppointmentServiceData> serviceList = null;

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
}
