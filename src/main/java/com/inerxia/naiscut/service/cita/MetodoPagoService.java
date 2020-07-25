package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cita.MetodoPago;
import com.inerxia.naiscut.model.cita.MetodoPagoRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class MetodoPagoService {
    private MetodoPagoRepository metodoPagoRepository;

    public MetodoPagoService(MetodoPagoRepository metodoPagoRepository) {
        this.metodoPagoRepository = metodoPagoRepository;
    }

    public MetodoPago findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return metodoPagoRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.metodo_pago"));
    }
}
