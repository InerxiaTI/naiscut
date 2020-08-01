package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.mapper.ClienteMapper;
import com.inerxia.naiscut.service.cliente.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
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

    public ClienteDto crearCliente(ClienteDto clienteDto){
        //salonFacade.findById(sedeDto.getIdSalonFk()); validar lo del consecutivo
        return mapper.toDto(service.crearCliente(mapper.toEntity(clienteDto)));
    }

    @Override
    public List<ClienteDto> findAll(Pageable pageable) {
        return null;
    }


}
