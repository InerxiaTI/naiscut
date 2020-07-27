package com.inerxia.naiscut.model.salon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SedeRepository extends JpaRepository<Sede, Integer> {

    List<Sede> findByIdSalonFk(Integer idSalonFk);

    List<Sede> findByDireccionContaining(String direcion);

    Optional<Sede> findByIdSalonFkAndPrincipal(Integer idSalonFk, char principal);

}
