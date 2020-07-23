package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.salon.TipoSalon;
import com.inerxia.naiscut.model.salon.TipoSalonRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TipoSalonService {

    private TipoSalonRepository tipoSalonRepository;

    public TipoSalonService(TipoSalonRepository tipoSalonRepository){
        this.tipoSalonRepository = tipoSalonRepository;
    }

    public TipoSalon findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return tipoSalonRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.tipo_salon"));
    }
}
