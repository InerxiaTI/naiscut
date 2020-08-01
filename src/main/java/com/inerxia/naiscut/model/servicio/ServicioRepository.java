package com.inerxia.naiscut.model.servicio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByIdSedeFk(Integer idSedeFk);

    List<Servicio> findByNombreContaining(String nombre);

    List<Servicio> findByPrecioBetween(Double menor, Double mayor);
}
