package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.mapper.ClienteMapper;
import com.inerxia.naiscut.service.cliente.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ClienteFacade extends Facade<ClienteMapper, ClienteService> implements GeneralFacade<ClienteDto> {


    public ClienteFacade(ClienteMapper mapper, ClienteService service) {
        super(mapper, service);
    }

    @Override
    public ClienteDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<ClienteDto> findAll() {
        return null;
    }
}
