package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.TipoSalonMapper;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.service.salon.TipoSalonService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return tipoSalonMapper.toDto(tipoSalonService.findById(id));
    }

    public List<TipoSalonDto> findAll(){
        return tipoSalonMapper.toDto(tipoSalonService.findAll());
    }
}
