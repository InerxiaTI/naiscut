package com.inerxia.naiscut.facade.empleado;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoRolDto;
import com.inerxia.naiscut.facade.mapper.EmpleadoRolMapper;
import com.inerxia.naiscut.service.empleado.EmpleadoRolService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmpleadoRolFacade extends Facade<EmpleadoRolMapper, EmpleadoRolService> implements GeneralFacade<EmpleadoRolDto> {


    public EmpleadoRolFacade(EmpleadoRolMapper mapper, EmpleadoRolService service) {
        super(mapper, service);
    }

    @Override
    public EmpleadoRolDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<EmpleadoRolDto> findAll() {
        return null;
    }
}
