package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cliente.dto.UsuarioDto;
import com.inerxia.naiscut.facade.mapper.UsuarioMapper;
import com.inerxia.naiscut.service.cliente.UsuarioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuarioFacade extends Facade<UsuarioMapper, UsuarioService> implements GeneralFacade<UsuarioDto> {


    public UsuarioFacade(UsuarioMapper mapper, UsuarioService service) {
        super(mapper, service);
    }

    @Override
    public UsuarioDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<UsuarioDto> findAll() {
        return null;
    }
}
