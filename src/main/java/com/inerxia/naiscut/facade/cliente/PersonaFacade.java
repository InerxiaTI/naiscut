package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.mapper.PersonaMapper;
import com.inerxia.naiscut.service.cliente.PersonaService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public PersonaDto crearPersona(PersonaDto personaDto){
        //salonFacade.findById(sedeDto.getIdSalonFk()); validar lo del consecutivo
        return mapper.toDto(service.crearPersona(mapper.toEntity(personaDto)));
    }

    public PersonaDto editarPersona(PersonaDto personaDto){
        //salonFacade.findById(sedeDto.getIdSalonFk());
        return mapper.toDto(service.editarPersona(mapper.toEntity(personaDto)));
    }

    @Override
    public List<PersonaDto> findAll(Pageable pageable) {
        Logger.getGlobal().log(Level.INFO, "Find All en persona. "+pageable.getPageSize()+" / "+pageable.getPageNumber() );
        return mapper.toDto(service.findAll(pageable));
    }
}
