package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cita.CitaRepository;
import com.inerxia.naiscut.model.salon.Sede;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CitaService {
    private CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    //TODO no puede ser la misma persona cliente y empleado para una cita.
    //TODO no puede cambiarse el cliente en una cita
    //TODO el empleado puede cambiar pero teniendo en cuenta la disponibilidad.
    public Cita crearCita(Cita cita){
        if(Objects.nonNull(cita.getId())){
            Optional<Cita> citaOptional = citaRepository.findById(cita.getId());
            if(citaOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.cita");
            }
        }
        Integer consecutivo = citaRepository.findMaxConsecutivo(cita.getIdSedeFk());
        cita.setConsecutivo(consecutivo+1);

        try {
            return citaRepository.save(cita);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.cita");
        }
    }

    public Cita editarCita(Cita cita){
        if(Objects.isNull(cita.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Cita citaTx = citaRepository.findById(cita.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.cita"));

        citaTx.setIdClienteFk(cita.getIdClienteFk());
        citaTx.setIdEmpleadoFk(cita.getIdEmpleadoFk());
        citaTx.setIdSedeFk(cita.getIdSedeFk());
        citaTx.setFechaHoraInicio(cita.getFechaHoraInicio());
        citaTx.setDuracionTotal(cita.getDuracionTotal());
        citaTx.setIdEstadoCitaFk(cita.getIdEstadoCitaFk());
        citaTx.setFechaCreacion(cita.getFechaCreacion());


        return citaTx;
    }

    public Cita findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return citaRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.cita"));
    }
}
