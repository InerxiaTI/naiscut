package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.salon.Salon;
import com.inerxia.naiscut.model.salon.SalonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SalonService {

    private SalonRepository salonRepository;

    public SalonService(SalonRepository salonRepository){
        this.salonRepository = salonRepository;
    }

    public Salon findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return salonRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.salon"));
    }

    public List<Salon> findAll(){
        List<Salon> salonList = salonRepository.findAll();
        if (salonList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.salon");
        }
        return salonList;
    }

    //TODO BUSCAR POR NOMBRE

    public Salon crearSalon(Salon salon){
        if(Objects.nonNull(salon.getId())){
            Optional<Salon> salonOptional = salonRepository.findById(salon.getId());
            if(salonOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.salon");
            }
        }
        return salonRepository.save(salon);
    }

    public Salon editarSalon(Salon salon){
        if(Objects.isNull(salon.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Salon salonTx = salonRepository.findById(salon.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.salon"));

        salonTx.setNit(salon.getNit());
        salonTx.setNombre(salon.getNombre());
        salonTx.setLogo(salon.getLogo());
        salonTx.setIdTipoSalonFk(salon.getIdTipoSalonFk());

        return salonTx;
    }
}
