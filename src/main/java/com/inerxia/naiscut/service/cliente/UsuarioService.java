package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cliente.Usuario;
import com.inerxia.naiscut.model.cliente.UsuarioRepository;
import com.inerxia.naiscut.util.DataTypeHandler;
import org.hibernate.ObjectNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuarioService  {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.usuario"));
    }



}
