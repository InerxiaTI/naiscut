package com.inerxia.naiscut.service.ocupacion;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.ocupacion.Ocupacion;
import com.inerxia.naiscut.model.ocupacion.OcupacionRepository;
import com.inerxia.naiscut.model.salon.TipoSalon;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class OcupacionService {

    private OcupacionRepository ocupacionRepository;

    public OcupacionService(OcupacionRepository ocupacionRepository) {
        this.ocupacionRepository = ocupacionRepository;
    }

    public Ocupacion findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return ocupacionRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.ocupacion"));
    }
}
