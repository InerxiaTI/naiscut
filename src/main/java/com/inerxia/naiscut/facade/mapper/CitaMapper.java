package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.model.cita.Cita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        ClienteMapper.class, EmpleadoMapper.class,
        SedeMapper.class,EstadoCitaMapper.class})
public interface CitaMapper extends EntityMapper<CitaDto, Cita>{
}
