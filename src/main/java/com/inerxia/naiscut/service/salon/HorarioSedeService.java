package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.salon.HorarioSede;
import com.inerxia.naiscut.model.salon.HorarioSedeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class HorarioSedeService {

    HorarioSedeRepository horarioSedeRepository;

    public HorarioSedeService(HorarioSedeRepository horarioSedeRepository) {
        this.horarioSedeRepository = horarioSedeRepository;
    }

    public HorarioSede findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return horarioSedeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.horario_sede"));
    }
}
