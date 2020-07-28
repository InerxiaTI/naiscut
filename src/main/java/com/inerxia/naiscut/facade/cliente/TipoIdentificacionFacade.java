package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cliente.dto.TipoIdentificacionDto;
import com.inerxia.naiscut.facade.mapper.TipoIdentificacionMapper;
import com.inerxia.naiscut.service.cliente.TipoIdentificacionService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class TipoIdentificacionFacade extends Facade<TipoIdentificacionMapper, TipoIdentificacionService> implements GeneralFacade<TipoIdentificacionDto> {


    public TipoIdentificacionFacade(TipoIdentificacionMapper mapper, TipoIdentificacionService service) {
        super(mapper, service);
    }

    @Override
    public TipoIdentificacionDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<TipoIdentificacionDto> findAll(Pageable pageable) {
        return null;
    }


}
