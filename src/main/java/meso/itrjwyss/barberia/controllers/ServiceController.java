package meso.itrjwyss.barberia.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import meso.itrjwyss.barberia.data.BaseResponse;
import meso.itrjwyss.barberia.data.service.CreateServiceRequest;
import meso.itrjwyss.barberia.data.service.ServiceData;
import meso.itrjwyss.barberia.data.service.FindServiceResponse;
import meso.itrjwyss.barberia.entities.ServiceEntity;
import meso.itrjwyss.barberia.services.ServiceService;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService service;

    @GetMapping("/list")
    public List<ServiceData> list() {
        List<ServiceData> result = new ArrayList<>();
        service.findAll().forEach(service ->
            result.add(new ServiceData(service))
        );
        return result;
    }

    @GetMapping(path = { "/find", "/find/", "/find/{id}"})
    public FindServiceResponse find(
        @PathVariable(name = "id", required = false) Long id
    ) {
        FindServiceResponse response = new FindServiceResponse();

        if (id != null && id > 0) {
            Optional<ServiceEntity> searchResult = service.findById(id);
            if (searchResult.isPresent()) {
                response.setSuccessful(true);
                response.setService(new ServiceData(searchResult.get()));
            } else {
                response.setMessage("Servicio no encontrado.");
            }
        } else {
            response.setMessage("Identificador no válido para su búsqueda.");
        }

        return response;
    }

    @PostMapping("/create")
    public BaseResponse create(
        @RequestBody CreateServiceRequest request
    ) {
        BaseResponse response = new BaseResponse();

        if (request != null && request.isValid()) {
            Optional<ServiceEntity> searchName = service.findByName(request.getName());
            if (searchName.isPresent()) {
                response.setMessage("El nombre del servicio que se desea crear ya existe.");
            } else {
                ServiceEntity newService = new ServiceEntity();

                newService.setName(request.getName());
                newService.setDescription(request.getDescription());
                newService.setPrice(request.getPrice());

                service.save(newService);

                response.setSuccessful(true);
                response.setMessage("Servicio creado exitosamente.");
            }
        } else {
            response.setMessage("La información requerida para crear un servicio no se encuentra completa.");
        }

        return response;
    }

    @PutMapping("/update")
    public BaseResponse update(
        @RequestBody ServiceData request
    ) {
        BaseResponse response = new BaseResponse();

        if (request != null && request.isValid()) {
            Optional<ServiceEntity> findService = service.findById(request.getId());
            if (findService.isPresent()) {
                ServiceEntity serviceEntity = findService.get();
                boolean flag = true;

                if (!serviceEntity.getName().equalsIgnoreCase(request.getName())) {
                    Optional<ServiceEntity> nameService = service.findByName(request.getName());
                    if (nameService.isPresent()) {
                        flag = false;
                        response.setMessage("El nuevo nombre del servicio ya está definido en otro servicio.");
                    }
                }

                if (flag) {
                    serviceEntity.setPrice(request.getPrice());
                    serviceEntity.setName(request.getName());
                    serviceEntity.setDescription(request.getDescription());
                    serviceEntity.setStatus(request.getStatus());
                    serviceEntity.setUpdatedAt(new Date());

                    service.save(serviceEntity);

                    response.setSuccessful(true);
                    response.setMessage("Servicio actualizado exitosamente.");
                }
            } else {
                response.setMessage("El servicio que se desea editar no existe.");
            }
        } else {
            response.setMessage("La información requerida para editar el servicio no se encuentra completa.");
        }

        return response;
    }
}
