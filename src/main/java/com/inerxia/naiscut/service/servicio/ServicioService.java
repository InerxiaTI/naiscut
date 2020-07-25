package com.inerxia.naiscut.service.servicio;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.servicio.Servicio;
import com.inerxia.naiscut.model.servicio.ServicioRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ServicioService {

    private ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return servicioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.servicio"));
    }
}
