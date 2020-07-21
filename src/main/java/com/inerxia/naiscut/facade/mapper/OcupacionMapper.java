package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.model.ocupacion.Ocupacion;
import org.mapstruct.Mapper;

//TODO falta EmpleadoMapper.class, CitaMapper.class
@Mapper(componentModel = "spring", uses = {SedeMapper.class})
public interface OcupacionMapper extends EntityMapper<OcupacionDto, Ocupacion>{
}
