package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.empleado.dto.EmpleadoRolDto;
import com.inerxia.naiscut.model.empleado.EmpleadoRol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpleadoRolMapper extends EntityMapper<EmpleadoRolDto, EmpleadoRol> {
}
