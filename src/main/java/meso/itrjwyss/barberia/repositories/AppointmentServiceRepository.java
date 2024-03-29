package meso.itrjwyss.barberia.repositories;

import meso.itrjwyss.barberia.entities.AppointmentEntity;
import meso.itrjwyss.barberia.entities.AppointmentServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentServiceRepository extends CrudRepository<AppointmentServiceEntity, Long> {

    Iterable<AppointmentServiceEntity> findAllByAppointment(AppointmentEntity appointment);
}
