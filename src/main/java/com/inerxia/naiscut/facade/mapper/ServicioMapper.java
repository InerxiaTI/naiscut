package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;
import com.inerxia.naiscut.model.servicio.Servicio;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SedeMapper.class})
public interface ServicioMapper extends EntityMapper<ServicioDto, Servicio>{
}
