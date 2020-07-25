package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cita.CitaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CitaService {
    private CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public Cita findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return citaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.cita"));
    }
}
