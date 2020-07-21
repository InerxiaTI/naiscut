package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.EstadoCitaDto;
import com.inerxia.naiscut.model.cita.EstadoCita;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoCitaMapper extends EntityMapper<EstadoCitaDto, EstadoCita>{
}
