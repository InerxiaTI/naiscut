package com.inerxia.naiscut.cliente.repository.repository;

import com.inerxia.naiscut.cliente.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
