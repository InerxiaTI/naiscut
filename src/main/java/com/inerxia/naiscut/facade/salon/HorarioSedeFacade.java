package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.facade.mapper.HorarioSedeMapper;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
import com.inerxia.naiscut.service.salon.HorarioSedeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@Service
@Transactional
public class HorarioSedeFacade {

    private HorarioSedeMapper horarioSedeMapper;
    private HorarioSedeService horarioSedeService;

    private SedeFacade sedeFacade;

    public HorarioSedeFacade(HorarioSedeMapper horarioSedeMapper, HorarioSedeService horarioSedeService, SedeFacade sedeFacade) {
        this.horarioSedeMapper = horarioSedeMapper;
        this.horarioSedeService = horarioSedeService;
        this.sedeFacade = sedeFacade;
    }

    public HorarioSedeDto findById(Integer id){
        return horarioSedeMapper.toDto(horarioSedeService.findById(id));
    }

    public List<HorarioSedeDto> buscarPorSede(Integer idSedeFk){
        sedeFacade.findById(idSedeFk);
        return horarioSedeMapper.toDto(horarioSedeService.buscarPorSede(idSedeFk));
    }

    public List<HorarioSedeDto> crearHorariosPorSede(List<HorarioSedeDto> horarioSedeDtoList){
        if(Objects.isNull(horarioSedeDtoList)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        horarioSedeDtoList.forEach(this::crearHorarioSede);
        return horarioSedeDtoList;
    }

    public HorarioSedeDto crearHorarioSede(HorarioSedeDto horarioSedeDto){
        sedeFacade.findById(horarioSedeDto.getIdSedeFk());
        return horarioSedeMapper.toDto(horarioSedeService.crearHorarioSede(horarioSedeMapper.toEntity(horarioSedeDto)));
    }

    public HorarioSedeDto editarHorarioSede(HorarioSedeDto horarioSedeDto){
        sedeFacade.findById(horarioSedeDto.getIdSedeFk());
        return horarioSedeMapper.toDto(horarioSedeService.editarHorarioSede(horarioSedeMapper.toEntity(horarioSedeDto)));
    }
}
