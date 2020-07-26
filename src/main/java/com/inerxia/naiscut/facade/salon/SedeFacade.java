package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SedeMapper;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.service.salon.SedeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SedeFacade {

    private SedeMapper sedeMapper;
    private SedeService sedeService;

    private SalonFacade salonFacade;

    public SedeFacade(SedeMapper sedeMapper, SedeService sedeService, SalonFacade salonFacade) {
        this.sedeMapper = sedeMapper;
        this.sedeService = sedeService;
        this.salonFacade = salonFacade;
    }

    public SedeDto findById(Integer id){
        return sedeMapper.toDto(sedeService.findById(id));
    }

    public SedeDto crearSede(SedeDto sedeDto){
        salonFacade.findById(sedeDto.getIdSalonFk());
        return sedeMapper.toDto(sedeService.crearSede(sedeMapper.toEntity(sedeDto)));
    }

    public SedeDto editarSede(SedeDto sedeDto){
        salonFacade.findById(sedeDto.getIdSalonFk());
        return sedeMapper.toDto(sedeService.editarSede(sedeMapper.toEntity(sedeDto)));
    }
}
