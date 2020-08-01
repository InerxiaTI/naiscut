package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.HorarioSedeMapper;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
import com.inerxia.naiscut.service.salon.HorarioSedeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    //TODO CREAR VARIOS HORARIOS POR SEDE

    public List<HorarioSedeDto> buscarPorSede(Integer idSedeFk){
        sedeFacade.findById(idSedeFk);
        return horarioSedeMapper.toDto(horarioSedeService.buscarPorSede(idSedeFk));
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
