package com.inerxia.naiscut.service.ocupacion;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.ocupacion.Ocupacion;
import com.inerxia.naiscut.model.ocupacion.OcupacionRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class OcupacionService {

    private OcupacionRepository ocupacionRepository;

    public OcupacionService(OcupacionRepository ocupacionRepository) {
        this.ocupacionRepository = ocupacionRepository;
    }

    public Ocupacion findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return ocupacionRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.ocupacion"));
    }

    //todo buscar ocupacion por sede, por rango de fechas, por empleado

    public Ocupacion crearOcupacion(Ocupacion ocupacion){
        if(Objects.nonNull(ocupacion.getId())){
            Optional<Ocupacion> ocupacionOptional = ocupacionRepository.findById(ocupacion.getId());
            if(ocupacionOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.ocupacion");
            }
        }
        try{
            return ocupacionRepository.save(ocupacion);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.ocupacion");
        }
    }

    public Ocupacion editarOcupacion(Ocupacion ocupacion){
        if(Objects.isNull(ocupacion.getId())){
            throw new ObjectNoEncontradoException("exception.ocupacion");
        }

        Ocupacion ocupacionTx = ocupacionRepository.findById(ocupacion.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.ocupacion"));

        try{
            ocupacionTx.setIdEmpleadoFk(ocupacion.getIdEmpleadoFk());
            ocupacionTx.setFechaHoraInicio(ocupacion.getFechaHoraInicio());
            ocupacionTx.setFechaHoraFinal(ocupacion.getFechaHoraFinal());
            ocupacionTx.setIdCitaFk(ocupacion.getIdCitaFk());
            ocupacionTx.setComentario(ocupacion.getComentario());
            ocupacionTx.setIdSedeFk(ocupacion.getIdSedeFk());
            return ocupacionTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.ocupacion");
        }
    }
}
