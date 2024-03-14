package meso.itrjwyss.barberia.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import meso.itrjwyss.barberia.data.BaseResponse;
import meso.itrjwyss.barberia.data.ListData;
import meso.itrjwyss.barberia.data.appointment.AppointmentData;
import meso.itrjwyss.barberia.data.appointment.AppointmentServiceData;
import meso.itrjwyss.barberia.data.appointment.CreateAppointmentRequest;
import meso.itrjwyss.barberia.data.appointment.DataAppointmentResponse;
import meso.itrjwyss.barberia.data.appointment.FindAppointmentResponse;
import meso.itrjwyss.barberia.entities.AppointmentEntity;
import meso.itrjwyss.barberia.entities.AppointmentServiceEntity;
import meso.itrjwyss.barberia.entities.BarberEntity;
import meso.itrjwyss.barberia.entities.CustomerEntity;
import meso.itrjwyss.barberia.entities.ServiceEntity;
import meso.itrjwyss.barberia.services.AppointmentService;
import meso.itrjwyss.barberia.services.AppointmentServiceService;
import meso.itrjwyss.barberia.services.BarberService;
import meso.itrjwyss.barberia.services.CustomerService;
import meso.itrjwyss.barberia.services.ServiceService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/appointment")
public class AppointmentController {

    private final AppointmentService service;
    private final AppointmentServiceService appointmentService;
    private final BarberService barberService;
    private final CustomerService customerService;
    private final ServiceService serviceService;

    public AppointmentController(
        AppointmentService service,
        AppointmentServiceService appointmentService,
        BarberService barberService,
        CustomerService customerService,
        ServiceService serviceService
    ) {
        this.service = service;
        this.appointmentService = appointmentService;
        this.barberService = barberService;
        this.customerService = customerService;
        this.serviceService = serviceService;
    }

    @GetMapping("/list")
    public List<AppointmentData> list() {
        List<AppointmentData> result = new ArrayList<>();
        service.findAll().forEach(appointment ->
            result.add(new AppointmentData(appointment))
        );
        return result;
    }

    @GetMapping(path = {"/find", "/find/", "/find/{id}"})
    public FindAppointmentResponse find(
        @PathVariable(name = "id", required = false) Long id
    ) {
        FindAppointmentResponse response = new FindAppointmentResponse();

        if (id != null && id > 0) {
            Optional<AppointmentEntity> searchResult = service.findById(id);
            if (searchResult.isPresent()) {
                List<AppointmentServiceData> servicesList = new ArrayList<>();
                searchResult.get().getServiceList().forEach(service ->
                    servicesList.add(new AppointmentServiceData(service))
                );

                response.setSuccessful(true);
                response.setAppointment(new AppointmentData(searchResult.get()));
                response.setServiceList(servicesList);
            } else {
                response.setMessage("Cita no encontrada.");
            }
        } else {
            response.setMessage("Identificador no válido para su búsqueda.");
        }

        return response;
    }

    @GetMapping("/data")
    public DataAppointmentResponse data() {
        DataAppointmentResponse response = new DataAppointmentResponse();

        List<ListData> barbers =  new ArrayList<>();
        barberService.findAll().forEach(barberEntity ->
            barbers.add(new ListData(barberEntity.getId(), barberEntity.getName()))
        );

        List<ListData> customers = new ArrayList<>();
        customerService.findAll().forEach(customerEntity ->
            customers.add(new ListData(customerEntity.getId(), customerEntity.getName()))
        );

        List<ListData> services = new ArrayList<>();
        serviceService.findAll().forEach(serviceEntity ->
            services.add(new ListData(serviceEntity.getId(), serviceEntity.getName()))
        );

        response.setBarbers(barbers);
        response.setCustomers(customers);
        response.setServices(services);

        return response;
    }

    @PostMapping("/created")
    public BaseResponse create(
        @RequestBody CreateAppointmentRequest request
    ) {
        BaseResponse response = new BaseResponse();

        if (request !=  null && request.isValid()) {
            Optional<CustomerEntity> customerSearch = customerService.findById(request.getCustomerId());
            Optional<BarberEntity> barberSearch = barberService.findById(request.getBarberId());

            if (customerSearch.isPresent() && barberSearch.isPresent()) {
                try {
                    AppointmentEntity appointmentEntity = new AppointmentEntity();

                    SimpleDateFormat formatDay = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm");

                    appointmentEntity.setDay(formatDay.parse(request.getDay()));
                    appointmentEntity.setHourStart(formatHour.parse(request.getHourStart()));
                    appointmentEntity.setHourEnd(formatHour.parse(request.getHourEnd()));
                    appointmentEntity.setCustomer(customerSearch.get());
                    appointmentEntity.setBarber(barberSearch.get());

                    final boolean[] flag = {true};
                    request.getServiceIdList().forEach(serviceId -> {
                        Optional<ServiceEntity> tempService = serviceService.findById(serviceId);
                        if (tempService.isPresent()) {
                            AppointmentServiceEntity tempAppointmentService = new AppointmentServiceEntity();

                            tempAppointmentService.setAppointment(appointmentEntity);
                            tempAppointmentService.setService(tempService.get());

                            appointmentEntity.addService(tempAppointmentService);
                        } else {
                            flag[0] = false;
                        }
                    });

                    if (flag[0]) {
                        service.save(appointmentEntity);

                        response.setSuccessful(true);
                        response.setMessage("Cita creada exitosamente.");
                    } else {
                        response.setMessage("Alguno de los servicios asignados a la cita no existe en el sistema");
                    }

                } catch (ParseException e) {
                    response.setMessage("El formato de la fecha es incorrecto");
                }
            } else {
                response.setMessage("El cliente o barbero asignados no existe en el sistema.");
            }
        } else {
            response.setMessage("La información requerida para crear una cita no se encuentra completa.");
        }

        return response;
    }

    @PutMapping("/update")
    public BaseResponse update(
        @RequestBody AppointmentData request
    ) {
        BaseResponse response = new BaseResponse();

        if (request != null && request.isValid()) {
            Optional<AppointmentEntity> findAppointment = service.findById(request.getId());
            if (findAppointment.isPresent()) {
                AppointmentEntity appointmentEntity = findAppointment.get();

                appointmentEntity.setDay(request.getDay());
                appointmentEntity.setHourStart(request.getHourStart());
                appointmentEntity.setHourEnd(request.getHourEnd());
                appointmentEntity.setStatus(request.getStatus());
                appointmentEntity.setUpdatedAt(new Date());

                boolean flag = true;
                if (!request.getCustomerId().equals(appointmentEntity.getCustomer().getId())) {
                    Optional<CustomerEntity> customerEntity = customerService.findById(request.getCustomerId());
                    if (customerEntity.isPresent()) {
                        appointmentEntity.setCustomer(customerEntity.get());
                    } else {
                        flag = false;
                    }
                }

                if (flag && !request.getBarberId().equals(appointmentEntity.getBarber().getId())) {
                    Optional<BarberEntity> barberEntity = barberService.findById(request.getBarberId());
                    if (barberEntity.isPresent()) {
                        appointmentEntity.setBarber(barberEntity.get());
                    } else {
                        flag = false;
                    }
                }

                if (flag) {
                    service.save(appointmentEntity);

                    response.setSuccessful(true);
                    response.setMessage("Cita actualizada exitosamente.");
                } else {
                    response.setMessage("El cliente o barbero asignados no existe en el sistema.");
                }
            } else {
                response.setMessage("La cita que se desea editar no existe.");
            }
        } else {
            response.setMessage("La información requerida para editar la cita no se encuentra completa.");
        }

        return response;
    }
}
