package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CompraDto;
import com.inerxia.naiscut.facade.mapper.CompraMapper;
import com.inerxia.naiscut.service.cita.CompraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompraFacade extends Facade<CompraMapper, CompraService> implements GeneralFacade<CompraDto> {

    public CompraFacade(CompraMapper mapper, CompraService service) {
        super(mapper, service);
    }

    @Override
    public CompraDto findById(Integer i) {
        return null;
    }

    @Override
    public List<CompraDto> findAll() {
        return null;
    }
}
