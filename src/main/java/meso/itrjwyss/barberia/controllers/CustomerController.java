package meso.itrjwyss.barberia.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import meso.itrjwyss.barberia.data.BaseResponse;
import meso.itrjwyss.barberia.data.customer.CreateCustomerRequest;
import meso.itrjwyss.barberia.data.customer.CustomerData;
import meso.itrjwyss.barberia.data.customer.FindCustomerResponse;
import meso.itrjwyss.barberia.entities.CustomerEntity;
import meso.itrjwyss.barberia.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/list")
    public List<CustomerData> list() {
        List<CustomerData> result = new ArrayList<>();
        service.findAll().forEach(customer ->
            result.add(new CustomerData(customer))
        );
        return result;
    }

    @GetMapping(path = {"/find", "/find/", "/find/{id}"})
    public FindCustomerResponse find(
        @PathVariable(name = "id", required = false) Long id
    ) {
        FindCustomerResponse response = new FindCustomerResponse();

        if (id != null && id > 0) {
            Optional<CustomerEntity> searchResult = service.findById(id);
            if (searchResult.isPresent()) {
                response.setSuccessful(true);
                response.setCustomer(new CustomerData(searchResult.get()));
            } else {
                response.setMessage("Cliente no encontrado.");
            }
        } else {
            response.setMessage("Identificador no válido para su búsqueda.");
        }

        return response;
    }

    @PostMapping("/created")
    public BaseResponse create(
        @RequestBody CreateCustomerRequest request
    ) {
        BaseResponse response = new BaseResponse();

        if (request !=  null && request.isValid()) {
            CustomerEntity newCustomer = new CustomerEntity();

            newCustomer.setName(request.getName());
            newCustomer.setPhoneNumber(request.getPhoneNumber());

            service.save(newCustomer);

            response.setSuccessful(true);
            response.setMessage("Cliente creado exitosamente.");
        } else {
            response.setMessage("La información requerida para crear un cliente no se encuentra completa.");
        }

        return response;
    }

    @PutMapping("/update")
    public BaseResponse update(
        @RequestBody CustomerData request
    ) {
        BaseResponse response = new BaseResponse();

        if (request != null && request.isValid()) {
            Optional<CustomerEntity> findCustomer = service.findById(request.getId());
            if (findCustomer.isPresent()) {
                CustomerEntity customerEntity = findCustomer.get();

                customerEntity.setPhoneNumber(request.getPhoneNumber());
                customerEntity.setName(request.getName());
                customerEntity.setStatus(request.getStatus());
                customerEntity.setUpdatedAt(new Date());

                service.save(customerEntity);

                response.setSuccessful(true);
                response.setMessage("Cliente actualizado exitosamente.");
            } else {
                response.setMessage("El cliente que se desea editar no existe.");
            }
        } else {
            response.setMessage("La información requerida para editar el cliente no se encuentra completa.");
        }

        return response;
    }
}
