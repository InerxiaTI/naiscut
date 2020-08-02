package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cliente.Usuario;
import com.inerxia.naiscut.model.cliente.UsuarioRepository;
import com.inerxia.naiscut.util.DataTypeHandler;
import org.hibernate.ObjectNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@Transactional
public class UsuarioService  {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario){
        if(Objects.nonNull(usuario.getId())){
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuario.getId());
            if(usuarioOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.usuario");
            }
        }

        try {
            return usuarioRepository.save(usuario);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.usuario");
        }
    }

    public Usuario editarUsuario(Usuario usuario){
        if(Objects.isNull(usuario.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        Logger.getLogger(UsuarioService.class.getName()).log(Level.INFO, usuario.getId().toString());
        Usuario usuarioTx = this.findById(usuario.getId());
        usuarioTx.setUsuario(usuario.getUsuario());
        usuarioTx.setClave(usuario.getClave());
        usuarioTx.setEstado(DataTypeHandler.charToBoolean(usuario.getEstado()) ? '1' : '0');

        return usuarioTx;
    }

    public Usuario findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return usuarioRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.usuario"));
    }



}
