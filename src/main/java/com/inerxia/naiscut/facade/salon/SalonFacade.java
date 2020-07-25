package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SalonMapper;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.service.salon.SalonService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SalonFacade {

    private SalonMapper salonMapper;
    private SalonService salonService;

    public SalonFacade(SalonMapper salonMapper, SalonService salonService) {
        this.salonMapper = salonMapper;
        this.salonService = salonService;
    }

    public SalonDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return salonMapper.toDto(salonService.findById(id));
    }
}
