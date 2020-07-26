package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SalonMapper;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.service.salon.SalonService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class SalonFacade {

    private SalonMapper salonMapper;
    private SalonService salonService;

    private TipoSalonFacade tipoSalonFacade;

    public SalonFacade(SalonMapper salonMapper, SalonService salonService, TipoSalonFacade tipoSalonFacade) {
        this.salonMapper = salonMapper;
        this.salonService = salonService;
        this.tipoSalonFacade = tipoSalonFacade;
    }

    public SalonDto findById(Integer id){
        return salonMapper.toDto(salonService.findById(id));
    }

    public List<SalonDto> findAll(){
        return salonMapper.toDto(salonService.findAll());
    }

    public SalonDto crearSalon(SalonDto salonDto){
        tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        return salonMapper.toDto(salonService.crearSalon(salonMapper.toEntity(salonDto)));
    }

    public SalonDto editarSalon(SalonDto salonDto){
        tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        return salonMapper.toDto(salonService.editarSalon(salonMapper.toEntity(salonDto)));
    }
}
