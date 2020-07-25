package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cliente.TipoIdentificacion;
import com.inerxia.naiscut.model.cliente.TipoIdentificacionRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TipoIdentificacionService {
    private TipoIdentificacionRepository tipoIdentificacionRepository;

    public TipoIdentificacionService(TipoIdentificacionRepository tipoIdentificacionRepository) {
        this.tipoIdentificacionRepository = tipoIdentificacionRepository;
    }

    public TipoIdentificacion findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return tipoIdentificacionRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.tipo_identificacion"));
    }
}
