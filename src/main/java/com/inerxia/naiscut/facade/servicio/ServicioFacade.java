package com.inerxia.naiscut.facade.servicio;

import com.inerxia.naiscut.facade.mapper.ServicioMapper;
import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;
import com.inerxia.naiscut.service.servicio.ServicioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ServicioFacade {

    private ServicioMapper servicioMapper;
    private ServicioService servicioService;

    public ServicioFacade(ServicioMapper servicioMapper, ServicioService servicioService) {
        this.servicioMapper = servicioMapper;
        this.servicioService = servicioService;
    }

    public ServicioDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return servicioMapper.toDto(servicioService.findById(id));
    }
}
