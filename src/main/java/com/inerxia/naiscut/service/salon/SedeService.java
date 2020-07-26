package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.salon.Sede;
import com.inerxia.naiscut.model.salon.SedeRepository;
import com.inerxia.naiscut.exception.DataConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SedeService {

    private SedeRepository sedeRepository;

    public SedeService(SedeRepository sedeRepository) {
        this.sedeRepository = sedeRepository;
    }

    public Sede findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return sedeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.sede"));
    }

    //TODO BUSCAR POR SALON, BUSCAR POR DIRECCION

    public Sede crearSede(Sede sede){
        if(Objects.nonNull(sede.getId())){
            Optional<Sede> salonOptional = sedeRepository.findById(sede.getId());
            if(salonOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.sede");
            }
        }

        try {
            return sedeRepository.save(sede);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.sede");
        }
    }


    public Sede editarSede(Sede sede){
        if(Objects.isNull(sede.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Sede sedeTx = sedeRepository.findById(sede.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.sede"));

        sedeTx.setIdSalonFk(sede.getIdSalonFk());
        sedeTx.setDescripcion(sede.getDescripcion());
        sedeTx.setCiudad(sede.getCiudad());
        sedeTx.setDireccion(sede.getDireccion());
        sedeTx.setTelefono(sede.getTelefono());
        sedeTx.setDomicilio(sede.getDomicilio());
        sedeTx.setPrincipal(sede.getPrincipal());
        sedeTx.setAdministradorFk(sede.getAdministradorFk());
        sedeTx.setEstadoSede(sede.getEstadoSede());

        return sedeTx;
    }
}
