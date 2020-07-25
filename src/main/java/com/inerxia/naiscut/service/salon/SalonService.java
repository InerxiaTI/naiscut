package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.salon.Salon;
import com.inerxia.naiscut.model.salon.SalonRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SalonService {

    private SalonRepository salonRepository;

    public SalonService(SalonRepository salonRepository){
        this.salonRepository = salonRepository;
    }

    public Salon findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return salonRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.salon"));
    }
}
