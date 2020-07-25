package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cita.Compra;
import com.inerxia.naiscut.model.cita.CompraRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class CompraService {
    private CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return compraRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.compra"));

    }
}
