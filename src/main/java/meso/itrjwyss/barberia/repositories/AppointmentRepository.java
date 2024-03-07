package meso.itrjwyss.barberia.repositories;

import java.util.Date;
import meso.itrjwyss.barberia.entities.AppointmentEntity;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<AppointmentEntity, Long> {

    Iterable<AppointmentEntity> findAllByDay(Date day);
}
