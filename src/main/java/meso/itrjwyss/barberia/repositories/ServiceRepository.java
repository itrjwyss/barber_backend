package meso.itrjwyss.barberia.repositories;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;

public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {

    Optional<ServiceEntity> findByName(String name);
}
