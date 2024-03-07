package meso.itrjwyss.barberia.services;

import java.util.Optional;
import meso.itrjwyss.barberia.entities.CustomerEntity;
import meso.itrjwyss.barberia.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Iterable<CustomerEntity> findAll() {
        return repository.findAll();
    }

    public Optional<CustomerEntity> findById(Long id) {
        return repository.findById(id);
    }

    public void save(CustomerEntity customer) {
        repository.save(customer);
    }
}
