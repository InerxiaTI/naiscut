package com.inerxia.naiscut.service.empleado;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.empleado.Empleado;
import com.inerxia.naiscut.model.empleado.EmpleadoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmpleadoService {
    private EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    public Empleado findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return empleadoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.empleado"));

    }
}
