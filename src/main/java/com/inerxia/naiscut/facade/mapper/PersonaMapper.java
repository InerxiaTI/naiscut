package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.model.cliente.Persona;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TipoIdentificacionMapper.class,GeneroMapper.class})
public interface PersonaMapper extends EntityMapper<PersonaDto, Persona> {
}
