package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.model.ocupacion.Ocupacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SedeMapper.class, EmpleadoMapper.class, CitaMapper.class})
public interface OcupacionMapper extends EntityMapper<OcupacionDto, Ocupacion>{
}
