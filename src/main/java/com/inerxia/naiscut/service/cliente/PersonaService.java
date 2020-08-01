package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.model.cliente.PersonaRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class PersonaService {
    private PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    public Persona crearPersona(Persona persona){
        if(Objects.nonNull(persona.getId())){
            Optional<Persona> personaOptional = personaRepository.findById(persona.getId());
            if(personaOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.persona");
            }
        }

        try {
            return personaRepository.save(persona);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.persona");
        }
    }

    public Persona editarPersona(Persona persona){
        if(Objects.isNull(persona.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Persona personaTx = personaRepository.findById(persona.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.persona"));

        personaTx.setIdentificacion(persona.getIdentificacion());
        personaTx.setIdTipoIdentificacionFk(persona.getIdTipoIdentificacionFk());
        personaTx.setPrimerNombre(persona.getPrimerNombre());
        personaTx.setSegundoNombre(persona.getSegundoNombre());
        personaTx.setPrimerApellido(persona.getPrimerApellido());
        personaTx.setSegundoApellido(persona.getSegundoApellido());
        personaTx.setDireccion(persona.getDireccion());
        personaTx.setCorreo(persona.getCorreo());
        personaTx.setTelefonoMovil(persona.getTelefonoMovil());
        personaTx.setTelefonoFijo(persona.getTelefonoFijo());
        personaTx.setFechaNacimiento(persona.getFechaNacimiento());
        personaTx.setIdGeneroFk(persona.getIdGeneroFk());

        return personaTx;
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
