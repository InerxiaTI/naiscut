package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.EntityNotFoundException;
import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.model.cliente.PersonaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class PersonaService {
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return personaRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("exception.entity_not_found.persona"));
    }

    public List<Persona> findAll(){
        return personaRepository.findAll();
    }
}
