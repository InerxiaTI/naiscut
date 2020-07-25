package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.mapper.PersonaMapper;
import com.inerxia.naiscut.service.cliente.PersonaService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PersonaFacade extends Facade<PersonaMapper, PersonaService> implements GeneralFacade<PersonaDto> {


    public PersonaFacade(PersonaMapper mapper, PersonaService service) {
        super(mapper, service);
    }

    @Override
    public PersonaDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<PersonaDto> findAll() {
        return mapper.toDto(service.findAll());
    }
}
