package com.inerxia.naiscut.model.ocupacion;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface OcupacionRepository extends JpaRepository<Ocupacion, Integer> {

    List<Ocupacion> findByFechaAndIdSedeFk(LocalDate fecha, Integer idSedeFk);

}
