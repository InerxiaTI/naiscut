package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cliente.Genero;
import com.inerxia.naiscut.model.cliente.GeneroRepository;
import com.inerxia.naiscut.model.cliente.Persona;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

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
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.genero"));
    }

    public List<Genero> findAll(Pageable page){
        Logger.getLogger(this.getClass().getName()).log(Level.INFO, page.getPageNumber()+"/"+page.getPageSize());
        List<Genero> generos;
        generos = generoRepository.findAll(page).getContent();
        if (generos.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.genero");
        }
        

        return generos;
    }
}
