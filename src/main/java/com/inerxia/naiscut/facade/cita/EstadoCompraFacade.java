package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.EstadoCompraDto;
import com.inerxia.naiscut.facade.mapper.EstadoCompraMapper;
import com.inerxia.naiscut.service.cita.EstadoCompraService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EstadoCompraFacade extends Facade<EstadoCompraMapper, EstadoCompraService> implements GeneralFacade<EstadoCompraDto> {

    public EstadoCompraFacade(EstadoCompraMapper mapper, EstadoCompraService service) {
        super(mapper, service);
    }

    @Override
    public EstadoCompraDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    @Override
    public List<EstadoCompraDto> findAll(Pageable pageable) {
        return null;
    }


}
