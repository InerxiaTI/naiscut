package com.inerxia.naiscut.facade.mapper;


import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.model.empleado.Empleado;
import com.inerxia.naiscut.model.salon.TipoSalon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class, SedeMapper.class})
public interface EmpleadoMapper extends EntityMapper<EmpleadoDto, Empleado>{
}
