package com.inerxia.naiscut.empleado.repository.repository;

import com.inerxia.naiscut.empleado.repository.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
