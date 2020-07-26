package com.inerxia.naiscut.service.servicio;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.servicio.EmpleadoServicio;
import com.inerxia.naiscut.model.servicio.EmpleadoServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmpleadoServicioService {

    private EmpleadoServicioRepository empleadoServicioRepository;

    public EmpleadoServicioService(EmpleadoServicioRepository empleadoServicioRepository) {
        this.empleadoServicioRepository = empleadoServicioRepository;
    }

    public EmpleadoServicio findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return empleadoServicioRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.empleado_servicio"));
    }
}
