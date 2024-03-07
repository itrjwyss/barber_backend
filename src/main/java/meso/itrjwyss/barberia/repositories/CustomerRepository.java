package meso.itrjwyss.barberia.repositories;

import meso.itrjwyss.barberia.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> { }
