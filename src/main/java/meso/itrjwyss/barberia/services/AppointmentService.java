package meso.itrjwyss.barberia.services;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.AppointmentEntity;
import meso.itrjwyss.barberia.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public Iterable<AppointmentEntity> findAll() {
        return repository.findAll();
    }

    public Optional<AppointmentEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void save(AppointmentEntity appointment) {
        repository.save(appointment);
    }
}
