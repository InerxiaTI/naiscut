package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cliente.dto.TipoIdentificacionDto;
import com.inerxia.naiscut.model.cliente.TipoIdentificacion;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper  extends EntityMapper<TipoIdentificacionDto, TipoIdentificacion> {
}
