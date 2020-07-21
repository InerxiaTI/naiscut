package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.model.salon.Sede;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SalonMapper.class, EmpleadoMapper.class})
public interface SedeMapper extends EntityMapper<SedeDto, Sede>{
}
