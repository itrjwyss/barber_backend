package meso.itrjwyss.barberia.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import meso.itrjwyss.barberia.data.BaseResponse;
import meso.itrjwyss.barberia.data.barber.BarberData;
import meso.itrjwyss.barberia.data.barber.CreateBarberRequest;
import meso.itrjwyss.barberia.data.barber.FindBarberResponse;
import meso.itrjwyss.barberia.entities.BarberEntity;
import meso.itrjwyss.barberia.services.BarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barber")
public class BarberController {

    @Autowired
    private BarberService service;

    @GetMapping("/list")
    public List<BarberData> list() {
        List<BarberData> result = new ArrayList<>();
        service.findAll().forEach(barber ->
            result.add(new BarberData(barber))
        );
        return result;
    }

    @GetMapping(path = {"/find", "/find/", "/find/{id}"})
    public FindBarberResponse find(
        @PathVariable(name = "id", required = false) Long id
    ) {
        FindBarberResponse response = new FindBarberResponse();

        if (id != null && id > 0) {
            Optional<BarberEntity> searchResult = service.findById(id);
            if (searchResult.isPresent()) {
                response.setSuccessful(true);
                response.setBarber(new BarberData(searchResult.get()));
            } else {
                response.setMessage("Barbero no encontrado.");
            }
        } else {
            response.setMessage("Identificador no válido para su búsqueda.");
        }

        return response;
    }

    @PostMapping("/created")
    public BaseResponse create(
        @RequestBody CreateBarberRequest request
    ) {
        BaseResponse response = new BaseResponse();

        if (request !=  null && request.isValid()) {
            BarberEntity newBarber = new BarberEntity();

            newBarber.setName(request.getName());
            service.save(newBarber);

            response.setSuccessful(true);
            response.setMessage("Barbero creado exitosamente.");
        } else {
            response.setMessage("La información requerida para crear un barbero no se encuentra completa.");
        }

        return response;
    }

    @PutMapping("/update")
    public BaseResponse update(
        @RequestBody BarberData request
    ) {
        BaseResponse response = new BaseResponse();

        if (request != null && request.isValid()) {
            Optional<BarberEntity> findBarber = service.findById(request.getId());
            if (findBarber.isPresent()) {
                BarberEntity barberEntity = findBarber.get();

                barberEntity.setName(request.getName());
                barberEntity.setStatus(request.getStatus());
                barberEntity.setUpdatedAt(new Date());

                service.save(barberEntity);

                response.setSuccessful(true);
                response.setMessage("Barbero actualizado exitosamente.");
            } else {
                response.setMessage("El barbero que se desea editar no existe.");
            }
        } else {
            response.setMessage("La información requerida para editar al barbero no se encuentra completa.");
        }

        return response;
    }
}
