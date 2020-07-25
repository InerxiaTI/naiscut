package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.mapper.CitaMapper;
import com.inerxia.naiscut.service.cita.CitaService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CitaFacade extends Facade<CitaMapper, CitaService> implements GeneralFacade<CitaDto> {


    public CitaFacade(CitaMapper mapper, CitaService service) {
        super(mapper, service);
    }

    @Override
    public CitaDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<CitaDto> findAll(Pageable pageable) {
        return null;
    }

}
