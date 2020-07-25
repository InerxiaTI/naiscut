package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.EstadoCitaDto;
import com.inerxia.naiscut.facade.mapper.EstadoCitaMapper;
import com.inerxia.naiscut.service.cita.EstadoCitaService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EstadoCitaFacade extends Facade<EstadoCitaMapper, EstadoCitaService> implements GeneralFacade<EstadoCitaDto> {

    public EstadoCitaFacade(EstadoCitaMapper mapper, EstadoCitaService service) {
        super(mapper, service);
    }

    @Override
    public EstadoCitaDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<EstadoCitaDto> findAll() {
        return null;
    }
}
