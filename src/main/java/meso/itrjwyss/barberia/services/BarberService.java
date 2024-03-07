package meso.itrjwyss.barberia.services;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.BarberEntity;
import meso.itrjwyss.barberia.repositories.BarberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarberService {

    @Autowired
    private BarberRepository repository;

    public Iterable<BarberEntity> findAll() {
        return repository.findAll();
    }

    public Optional<BarberEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void save(BarberEntity barber) {
        repository.save(barber);
    }
}
