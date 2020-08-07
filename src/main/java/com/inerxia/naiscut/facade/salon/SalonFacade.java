package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.empleado.EmpleadoFacade;
import com.inerxia.naiscut.facade.mapper.SalonMapper;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.facade.salon.dto.TipoSalonDto;
import com.inerxia.naiscut.service.salon.SalonService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SalonFacade {

    private SalonMapper salonMapper;
    private SalonService salonService;

    private TipoSalonFacade tipoSalonFacade;
    private EmpleadoFacade empleadoFacade;

    public SalonFacade(SalonMapper salonMapper,
                       SalonService salonService,
                       TipoSalonFacade tipoSalonFacade,
                       EmpleadoFacade empleadoFacade) {
        this.salonMapper = salonMapper;
        this.salonService = salonService;
        this.tipoSalonFacade = tipoSalonFacade;
        this.empleadoFacade = empleadoFacade;
    }

    public SalonDto findById(Integer id){
        return salonMapper.toDto(salonService.findById(id));
    }

    public String getTipoSalon(Integer idTipoSalon){
        TipoSalonDto tipoSalonDto = tipoSalonFacade.findById(idTipoSalon);
        return tipoSalonDto.getDescripcion();
    }

    public List<SalonDto> buscarPorNombre(String nombre){
        return salonMapper.toDto(salonService.buscarPorNombre(nombre));
    }

    public List<SalonDto> findAll(){
        return salonMapper.toDto(salonService.findAll());
    }

    public SalonDto crearSalon(SalonDto salonDto){
        tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        empleadoFacade.findById(salonDto.getAdministrador_total_fk());
        return salonMapper.toDto(salonService.crearSalon(salonMapper.toEntity(salonDto)));
    }

    public SalonDto editarSalon(SalonDto salonDto){
        tipoSalonFacade.findById(salonDto.getIdTipoSalonFk());
        empleadoFacade.findById(salonDto.getAdministrador_total_fk());
        return salonMapper.toDto(salonService.editarSalon(salonMapper.toEntity(salonDto)));
    }
}
