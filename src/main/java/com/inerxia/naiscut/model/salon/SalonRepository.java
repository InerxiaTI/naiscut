package com.inerxia.naiscut.model.salon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Integer> {

    List<Salon> findByNombreContaining(String nombre);
}
