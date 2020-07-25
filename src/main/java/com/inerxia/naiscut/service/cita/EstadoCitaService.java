package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cita.EstadoCita;
import com.inerxia.naiscut.model.cita.EstadoCitaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EstadoCitaService {
    private EstadoCitaRepository estadoCitaRepository;

    public EstadoCitaService(EstadoCitaRepository estadoCitaRepository) {
        this.estadoCitaRepository = estadoCitaRepository;
    }

    public EstadoCita findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return estadoCitaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.estado_cita"));
    }
}
