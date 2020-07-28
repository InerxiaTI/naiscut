package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.model.cliente.PersonaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.persona"));
    }

    public List<Persona> findAll(Pageable page){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, page.getPageNumber()+"/"+page.getPageSize());
        List<Persona> personas;
        personas = personaRepository.findAll(page).getContent();
        if (personas.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.persona");
        }
        return personas;
    }
}
