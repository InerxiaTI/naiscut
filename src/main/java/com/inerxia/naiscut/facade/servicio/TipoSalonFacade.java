package com.inerxia.naiscut.facade.servicio;

import com.inerxia.naiscut.facade.mapper.TipoSalonMapper;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.service.salon.TipoSalonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TipoSalonFacade {

    private TipoSalonMapper tipoSalonMapper;
    private TipoSalonService tipoSalonService;

    public TipoSalonFacade(TipoSalonMapper tipoSalonMapper, TipoSalonService tipoSalonService){
        this.tipoSalonMapper = tipoSalonMapper;
        this.tipoSalonService= tipoSalonService;
    }

    public TipoSalonDto findById(Integer id){
        return tipoSalonMapper.toDto(tipoSalonService.findById(id));
    }
}
