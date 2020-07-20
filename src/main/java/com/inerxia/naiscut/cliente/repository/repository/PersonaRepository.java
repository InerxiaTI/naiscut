package com.inerxia.naiscut.cliente.repository.repository;

import com.inerxia.naiscut.cliente.repository.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
