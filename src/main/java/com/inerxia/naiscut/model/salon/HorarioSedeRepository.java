package com.inerxia.naiscut.model.salon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HorarioSedeRepository extends JpaRepository<HorarioSede, Integer> {

    List<HorarioSede> findByIdSedeFk(Integer idSedeFk);
}
