package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cita.EstadoCompra;
import com.inerxia.naiscut.model.cita.EstadoCompraRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class EstadoCompraService {
    private EstadoCompraRepository estadoCompraRepository;

    public EstadoCompraService(EstadoCompraRepository estadoCompraRepository) {
        this.estadoCompraRepository = estadoCompraRepository;
    }

    public EstadoCompra findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return estadoCompraRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.estado_compra"));
    }
}
