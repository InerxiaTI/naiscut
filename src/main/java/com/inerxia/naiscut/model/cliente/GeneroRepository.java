package com.inerxia.naiscut.model.cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneroRepository extends JpaRepository<Genero, Integer> ,
        PagingAndSortingRepository<Genero, Integer> {

    public Page<Genero> findAll(Pageable page);
}
