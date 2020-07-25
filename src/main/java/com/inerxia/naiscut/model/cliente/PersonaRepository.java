package com.inerxia.naiscut.model.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer>, PagingAndSortingRepository<Persona, Integer> {

    public Page<Persona> findAll(Pageable page);
}
