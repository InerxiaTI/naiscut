package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.salon.TipoSalon;
import com.inerxia.naiscut.model.salon.TipoSalonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return tipoSalonRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.tipo_salon"));
    }

    public List<TipoSalon> findAll(){
        List<TipoSalon> tipoSalonList = tipoSalonRepository.findAll();
        if (tipoSalonList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.tipo_salon");
        }
        return tipoSalonList;
    }
}
