package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.exception.SedePrincipalExistsException;
import com.inerxia.naiscut.model.salon.Sede;
import com.inerxia.naiscut.model.salon.SedeRepository;
import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.util.DataTypeHandler;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public List<Sede> buscarPorSalon(Integer idSalonFk){
        if(Objects.isNull(idSalonFk)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Sede> sedeList = sedeRepository.findByIdSalonFk(idSalonFk);
        if (sedeList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.sede");
        }
        return sedeList;
    }

    public List<Sede> buscarPorDireccion(String direccion){
        if(Objects.isNull(direccion)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Sede> sedeList = sedeRepository.findByDireccionContaining(direccion);
        if (sedeList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.sede");
        }
        return sedeList;
    }

    public Sede cambiarSedePrincipal(Integer idSede){
        if(Objects.isNull(idSede)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        Sede futuraSedePrincipal = sedeRepository.findById(idSede)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.sede"));

        Optional<Sede> sedePrincipal = sedeRepository.findByIdSalonFkAndPrincipal(futuraSedePrincipal.getIdSalonFk(), '1');
        if(sedePrincipal.isPresent()) {
            Sede actualSedePrincipal = sedePrincipal.get();
            actualSedePrincipal.setPrincipal('0');
            futuraSedePrincipal.setPrincipal('1');
        }
        return futuraSedePrincipal;
    }

    public Sede crearSede(Sede sede){
        if(Objects.nonNull(sede.getId())){
            Optional<Sede> salonOptional = sedeRepository.findById(sede.getId());
            if(salonOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.sede");
            }
        }
        if(DataTypeHandler.charToBoolean(sede.getPrincipal())){
            Optional<Sede> sedePrincipal = sedeRepository.findByIdSalonFkAndPrincipal(sede.getIdSalonFk(), sede.getPrincipal());
            if (sedePrincipal.isPresent()) {
                throw new SedePrincipalExistsException("exception.sede_principal_exists.sede");
            }
        }
        try {
            sede.setPrincipal(DataTypeHandler.charToBoolean(sede.getPrincipal()) ? '1' : '0');
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

        try {
            sedeTx.setIdSalonFk(sede.getIdSalonFk());
            sedeTx.setDescripcion(sede.getDescripcion());
            sedeTx.setCiudad(sede.getCiudad());
            sedeTx.setDireccion(sede.getDireccion());
            sedeTx.setTelefono(sede.getTelefono());
            sedeTx.setDomicilio(sede.getDomicilio());
            sedeTx.setAdministradorFk(sede.getAdministradorFk());
            sedeTx.setEstadoSede(sede.getEstadoSede());
            return sedeTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.sede");
        }
    }
}
