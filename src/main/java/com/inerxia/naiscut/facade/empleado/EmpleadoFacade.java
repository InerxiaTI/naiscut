package com.inerxia.naiscut.facade.empleado;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
import com.inerxia.naiscut.facade.mapper.EmpleadoMapper;
import com.inerxia.naiscut.service.empleado.EmpleadoService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmpleadoFacade extends Facade<EmpleadoMapper, EmpleadoService> implements GeneralFacade<EmpleadoDto> {


    public EmpleadoFacade(EmpleadoMapper mapper, EmpleadoService service) {
        super(mapper, service);
    }

    @Override
    public EmpleadoDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<EmpleadoDto> findAll(Pageable pageable) {
        return null;
    }


}
