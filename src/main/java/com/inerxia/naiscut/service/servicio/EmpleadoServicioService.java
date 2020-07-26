package com.inerxia.naiscut.service.servicio;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.servicio.EmpleadoServicio;
import com.inerxia.naiscut.model.servicio.EmpleadoServicioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

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
        return empleadoServicioRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.empleado_servicio"));
    }

    //todo buscar servicios de un empleado, buscar empleados de un servicio

    public EmpleadoServicio crearEmpleadoServcio(EmpleadoServicio empleadoServicio){
        if(Objects.nonNull(empleadoServicio.getId())){
            Optional<EmpleadoServicio> empleadoServicioOptional = empleadoServicioRepository.findById(empleadoServicio.getId());
            if(empleadoServicioOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.empleado_servicio");
            }
        }
        try{
            return empleadoServicioRepository.save(empleadoServicio);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.empleado_servicio");
        }
    }

    public EmpleadoServicio editarEmpleadoServicio(EmpleadoServicio empleadoServicio){
        if(Objects.isNull(empleadoServicio.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        EmpleadoServicio empleadoServicioTx = empleadoServicioRepository.findById(empleadoServicio.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.empleado_servicio"));

        try{
            empleadoServicioTx.setIdEmpleadoFk(empleadoServicio.getIdEmpleadoFk());
            empleadoServicioTx.setIdServicioFk(empleadoServicio.getIdServicioFk());
            return empleadoServicioTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.empleado_servicio");
        }
    }
}
