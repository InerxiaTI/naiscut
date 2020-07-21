package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.MetodoPagoDto;
import com.inerxia.naiscut.model.cita.MetodoPago;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MetodoPagoMapper extends EntityMapper<MetodoPagoDto, MetodoPago>{
}
