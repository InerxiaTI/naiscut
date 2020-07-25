package com.inerxia.naiscut.service.empleado;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.empleado.EmpleadoRol;
import com.inerxia.naiscut.model.empleado.EmpleadoRolRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EmpleadoRolService {
    private EmpleadoRolRepository empleadoRolRepository;

    public EmpleadoRolService(EmpleadoRolRepository empleadoRolRepository) {
        this.empleadoRolRepository = empleadoRolRepository;
    }

    public EmpleadoRol findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return empleadoRolRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.empleado_rol"));
    }
}
