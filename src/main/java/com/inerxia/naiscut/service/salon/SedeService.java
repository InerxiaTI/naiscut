package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.salon.Sede;
import com.inerxia.naiscut.model.salon.SedeRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SedeService {

    private SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public Sede findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return sedeRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.sede"));
    }
}
