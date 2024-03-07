package meso.itrjwyss.barberia.services;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.ServiceEntity;
import meso.itrjwyss.barberia.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository repository;

    public Iterable<ServiceEntity> findAll() {
        return repository.findAll();
    }

    public Optional<ServiceEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void save(ServiceEntity service) {
        repository.save(service);
    }

    public Optional<ServiceEntity> findByName(String name) {
        return repository.findByName(name);
    }
}
