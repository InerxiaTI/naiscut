package com.inerxia.naiscut.facade.servicio;

import com.inerxia.naiscut.facade.mapper.EmpleadoServicioMapper;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.facade.servicio.dto.EmpleadoServicioDto;
import com.inerxia.naiscut.service.servicio.EmpleadoServicioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmpleadoServicioFacade {

    private EmpleadoServicioMapper empleadoServicioMapper;
    private EmpleadoServicioService empleadoServicioService;

    public EmpleadoServicioFacade(EmpleadoServicioMapper empleadoServicioMapper, EmpleadoServicioService empleadoServicioService) {
        this.empleadoServicioMapper = empleadoServicioMapper;
        this.empleadoServicioService = empleadoServicioService;
    }

    public EmpleadoServicioDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return empleadoServicioMapper.toDto(empleadoServicioService.findById(id));
    }
}
