package com.inerxia.naiscut.service.cliente;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cliente.Cliente;
import com.inerxia.naiscut.model.cliente.ClienteRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente crearCliente(Cliente cliente){
        if(Objects.nonNull(cliente.getId())){
            Optional<Cliente> clienteOptional = clienteRepository.findById(cliente.getId());
            if(clienteOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.cliente");
            }
        }


        try {
            return clienteRepository.save(cliente);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.cliente");
        }
    }

    public Cliente findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return clienteRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.cliente"));
    }
}
