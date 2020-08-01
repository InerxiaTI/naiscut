package com.inerxia.naiscut.model.salon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SedeRepository extends JpaRepository<Sede, Integer> {

    List<Sede> findByIdSalonFk(Integer idSalonFk);

    List<Sede> findByDireccionContaining(String direcion);

    Optional<Sede> findByIdSalonFkAndPrincipal(Integer idSalonFk, char principal);

    @Query("SELECT s FROM Sede s JOIN s.salonFk sa WHERE sa.nombre LIKE %:nombre%")
    List<Sede> findByNombreSalon(String nombre);

}
