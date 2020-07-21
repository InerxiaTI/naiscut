package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cliente.dto.GeneroDto;
import com.inerxia.naiscut.model.cliente.Genero;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GeneroMapper extends EntityMapper<GeneroDto, Genero>{
}
