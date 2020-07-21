package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.model.salon.Sede;
import org.mapstruct.Mapper;

//TODO falta EmpleadoMapper.class
@Mapper(componentModel = "spring", uses = {SalonMapper.class})
public interface SedeMapper extends EntityMapper<SedeDto, Sede>{
}
