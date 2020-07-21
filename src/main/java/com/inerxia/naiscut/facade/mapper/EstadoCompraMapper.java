package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.EstadoCompraDto;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.model.cita.EstadoCompra;
import com.inerxia.naiscut.model.salon.Salon;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EstadoCompraMapper extends EntityMapper<EstadoCompraDto, EstadoCompra> {
}
