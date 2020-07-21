package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.servicio.dto.EmpleadoServicioDto;
import com.inerxia.naiscut.model.servicio.EmpleadoServicio;
import org.mapstruct.Mapper;

//TODO falta EmpleadoMapper.class
@Mapper(componentModel = "spring", uses = {ServicioMapper.class})
public interface EmpleadoServicioMapper extends EntityMapper<EmpleadoServicioDto, EmpleadoServicio>{
}
