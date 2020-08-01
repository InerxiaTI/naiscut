package com.inerxia.naiscut.facade.servicio;

import com.inerxia.naiscut.facade.mapper.ServicioMapper;
import com.inerxia.naiscut.facade.salon.SedeFacade;
import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;
import com.inerxia.naiscut.service.servicio.ServicioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicioFacade {

    private ServicioMapper servicioMapper;
    private ServicioService servicioService;

    private SedeFacade sedeFacade;

    public ServicioFacade(ServicioMapper servicioMapper, ServicioService servicioService, SedeFacade sedeFacade) {
        this.servicioMapper = servicioMapper;
        this.servicioService = servicioService;
        this.sedeFacade = sedeFacade;
    }

    public ServicioDto findById(Integer id){
        return servicioMapper.toDto(servicioService.findById(id));
    }

    public List<ServicioDto> buscarPorNombre(String nombre){
        return servicioMapper.toDto(servicioService.buscarPorNombre(nombre));
    }

    public List<ServicioDto> buscarPorSede(Integer idSedeFk){
        return servicioMapper.toDto(servicioService.buscarPorSede(idSedeFk));
    }

    public List<ServicioDto> buscarPorRangoPrecios(Double menor, Double mayor){
        return servicioMapper.toDto(servicioService.buscarPorRangoPrecios(menor, mayor));
    }

    public ServicioDto crearServicio(ServicioDto servicioDto){
        sedeFacade.findById(servicioDto.getIdSedeFk());
        return servicioMapper.toDto(servicioService.crearServicio(servicioMapper.toEntity(servicioDto)));
    }

    public ServicioDto editarServicio(ServicioDto servicioDto){
        sedeFacade.findById(servicioDto.getIdSedeFk());
        return servicioMapper.toDto(servicioService.editarServicio(servicioMapper.toEntity(servicioDto)));
    }
}
