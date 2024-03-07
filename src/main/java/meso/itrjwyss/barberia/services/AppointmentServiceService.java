package meso.itrjwyss.barberia.services;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.AppointmentEntity;
import meso.itrjwyss.barberia.entities.AppointmentServiceEntity;
import meso.itrjwyss.barberia.repositories.AppointmentServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceService {

    @Autowired
    private AppointmentServiceRepository repository;

    public Iterable<AppointmentServiceEntity> findAll() {
        return repository.findAll();
    }

    public Optional<AppointmentServiceEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void save(AppointmentServiceEntity appointmentService) {
        repository.save(appointmentService);
    }

    public Iterable<AppointmentServiceEntity> findAllByAppointment(AppointmentEntity appointment) {
        return repository.findAllByAppointment(appointment);
    }
}
