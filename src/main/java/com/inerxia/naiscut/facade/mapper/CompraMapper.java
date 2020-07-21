package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.CompraDto;
import com.inerxia.naiscut.model.cita.Compra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {
        CitaMapper.class, MetodoPagoMapper.class,
        EstadoCompraMapper.class})
public interface CompraMapper extends EntityMapper<CompraDto, Compra>{
}
