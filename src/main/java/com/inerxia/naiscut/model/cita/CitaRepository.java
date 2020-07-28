package com.inerxia.naiscut.model.cita;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query("select max(c.consecutivo) from Cita c where c.idSedeFk = :sedeId")
    Integer findMaxConsecutivo(@Param("sedeId") Integer sedeId);

}
