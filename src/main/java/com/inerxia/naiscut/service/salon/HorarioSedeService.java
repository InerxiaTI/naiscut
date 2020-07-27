package com.inerxia.naiscut.service.salon;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.salon.HorarioSede;
import com.inerxia.naiscut.model.salon.HorarioSedeRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class HorarioSedeService {

    HorarioSedeRepository horarioSedeRepository;

    public HorarioSedeService(HorarioSedeRepository horarioSedeRepository) {
        this.horarioSedeRepository = horarioSedeRepository;
    }

    public HorarioSede findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return horarioSedeRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.horario_sede"));
    }

    //TODO BUSCAR HORARIOS POR SEDE, POR RANGOS DE FECHA

    public HorarioSede crearHorarioSede(HorarioSede horarioSede){
        if(Objects.nonNull(horarioSede.getId())){
            Optional<HorarioSede> horarioSedeOptional = horarioSedeRepository.findById(horarioSede.getId());
            if(horarioSedeOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.horario_sede");
            }
        }
        try {
            return horarioSedeRepository.save(horarioSede);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.horario_sede");
        }
    }

    public HorarioSede editarHorarioSede(HorarioSede horarioSede){
        if(Objects.isNull(horarioSede.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        HorarioSede horarioSedeTx = horarioSedeRepository.findById(horarioSede.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.horario_sede"));

        try{
            horarioSedeTx.setDia(horarioSede.getDia());
            horarioSedeTx.setHoraInicio(horarioSede.getHoraInicio());
            horarioSedeTx.setHoraFinal(horarioSede.getHoraFinal());
            horarioSedeTx.setIdSedeFk(horarioSede.getIdSedeFk());

            return horarioSedeTx;
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.horario_sede");
        }
    }
}
