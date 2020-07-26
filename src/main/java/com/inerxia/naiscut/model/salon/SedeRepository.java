package com.inerxia.naiscut.model.salon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SedeRepository extends JpaRepository<Sede, Integer> {

    List<Sede> findByIdSalonFk(Integer idSalonFk);

    List<Sede> findByDireccionContaining(String direcion);
}
