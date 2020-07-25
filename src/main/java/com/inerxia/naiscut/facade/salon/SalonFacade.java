package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.facade.mapper.SalonMapper;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.service.salon.SalonService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return salonMapper.toDto(salonService.findById(id));
    }

    public List<SalonDto> findAll(){
        return salonMapper.toDto(salonService.findAll());
    }

    public SalonDto crearSalon(SalonDto salonDto){
        TipoSalonDto tipoSalonDto = tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        if (Objects.isNull(tipoSalonDto)){
            throw new DataNotFoundException("exception.data_not_found.tipo_salon");
        }
        return salonMapper.toDto(salonService.crearSalon(salonMapper.toEntity(salonDto)));
    }

    public SalonDto editarSalon(SalonDto salonDto){
        TipoSalonDto tipoSalonDto = tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        if (Objects.isNull(tipoSalonDto)){
            throw new DataNotFoundException("exception.data_not_found.tipo_salon");
        }
        return salonMapper.toDto(salonService.editarSalon(salonMapper.toEntity(salonDto)));
    }
}
