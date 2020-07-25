package com.inerxia.naiscut.facade.ocupacion;

import com.inerxia.naiscut.facade.mapper.OcupacionMapper;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.service.ocupacion.OcupacionService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class OcupacionFacade {

    private OcupacionMapper ocupacionMapper;
    private OcupacionService ocupacionService;

    public OcupacionFacade(OcupacionMapper ocupacionMapper, OcupacionService ocupacionService) {
        this.ocupacionMapper = ocupacionMapper;
        this.ocupacionService = ocupacionService;
    }

    public OcupacionDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return ocupacionMapper.toDto(ocupacionService.findById(id));
    }
}
