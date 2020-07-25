package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.HorarioSedeMapper;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
import com.inerxia.naiscut.service.salon.HorarioSedeService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class HorarioSedeFacade {

    private HorarioSedeMapper horarioSedeMapper;
    private HorarioSedeService horarioSedeService;

    public HorarioSedeFacade(HorarioSedeMapper horarioSedeMapper, HorarioSedeService horarioSedeService) {
        this.horarioSedeMapper = horarioSedeMapper;
        this.horarioSedeService = horarioSedeService;
    }

    public HorarioSedeDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return horarioSedeMapper.toDto(horarioSedeService.findById(id));
    }
}
