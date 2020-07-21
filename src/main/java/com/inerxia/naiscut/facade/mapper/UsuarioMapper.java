package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.cliente.dto.UsuarioDto;
import com.inerxia.naiscut.model.cliente.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PersonaMapper.class})
public interface UsuarioMapper extends EntityMapper<UsuarioDto, Usuario> {
}
