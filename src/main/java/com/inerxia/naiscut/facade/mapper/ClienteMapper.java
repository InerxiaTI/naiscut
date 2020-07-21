package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.model.cliente.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class})
public interface ClienteMapper extends EntityMapper<ClienteDto, Cliente>{
}
