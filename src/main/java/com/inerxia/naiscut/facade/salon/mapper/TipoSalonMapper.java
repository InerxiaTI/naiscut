package com.inerxia.naiscut.facade.salon.mapper;

import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.model.salon.TipoSalon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoSalonMapper extends EntityMapper<TipoSalonDto, TipoSalon> {
}
