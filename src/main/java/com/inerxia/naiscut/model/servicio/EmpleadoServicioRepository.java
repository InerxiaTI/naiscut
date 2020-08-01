package com.inerxia.naiscut.model.servicio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoServicioRepository extends JpaRepository<EmpleadoServicio, Integer> {

    List<EmpleadoServicio> findByIdEmpleadoFk(Integer idEmpleadoFk);

    List<EmpleadoServicio> findByIdServicioFk(Integer idServicioFk);
}
