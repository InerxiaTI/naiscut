package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cliente.Genero;
import com.inerxia.naiscut.model.cliente.GeneroRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class GeneroService {
    private GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Genero findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return generoRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.genero"));
    }
}
