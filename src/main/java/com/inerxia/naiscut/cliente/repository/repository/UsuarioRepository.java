package com.inerxia.naiscut.cliente.repository.repository;

import com.inerxia.naiscut.cliente.repository.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
