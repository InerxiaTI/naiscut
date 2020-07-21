package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cita.dto.DetalleCompraDto;
import com.inerxia.naiscut.model.cita.DetalleCompra;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicioMapper.class, CompraMapper.class})
public interface DetalleCompraMapper extends EntityMapper<DetalleCompraDto, DetalleCompra>{
}
