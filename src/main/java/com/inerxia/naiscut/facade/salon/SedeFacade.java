package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SedeMapper;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.service.salon.SedeService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SedeFacade {

    private SedeMapper sedeMapper;
    private SedeService sedeService;

    public SedeFacade(SedeMapper sedeMapper, SedeService sedeService) {
        this.sedeMapper = sedeMapper;
        this.sedeService = sedeService;
    }

    public SedeDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return sedeMapper.toDto(sedeService.findById(id));
    }
}
