package com.inerxia.naiscut.facade.servicio;

import com.inerxia.naiscut.facade.empleado.EmpleadoFacade;
import com.inerxia.naiscut.facade.mapper.EmpleadoServicioMapper;
import com.inerxia.naiscut.facade.servicio.dto.EmpleadoServicioDto;
import com.inerxia.naiscut.service.servicio.EmpleadoServicioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class EmpleadoServicioFacade {

    private EmpleadoServicioMapper empleadoServicioMapper;
    private EmpleadoServicioService empleadoServicioService;

    private EmpleadoFacade empleadoFacade;
    private ServicioFacade servicioFacade;

    public EmpleadoServicioFacade(EmpleadoServicioMapper empleadoServicioMapper,
                                  EmpleadoServicioService empleadoServicioService,
                                  EmpleadoFacade empleadoFacade,
                                  ServicioFacade servicioFacade) {
        this.empleadoServicioMapper = empleadoServicioMapper;
        this.empleadoServicioService = empleadoServicioService;
        this.empleadoFacade = empleadoFacade;
        this.servicioFacade = servicioFacade;
    }

    public EmpleadoServicioDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return empleadoServicioMapper.toDto(empleadoServicioService.findById(id));
    }

    //todo mejorar los dto para la respuesta json
    public List<EmpleadoServicioDto> buscarServiciosDeEmpleado(Integer idEmpleadoFk){
        empleadoFacade.findById(idEmpleadoFk);
        return empleadoServicioMapper.toDto(empleadoServicioService.buscarServiciosDeEmpleado(idEmpleadoFk));
    }

    public List<EmpleadoServicioDto> buscarEmpleadosDeServicio(Integer idServicioFk){
        servicioFacade.findById(idServicioFk);
        return empleadoServicioMapper.toDto(empleadoServicioService.buscarEmpleadosDeServicio(idServicioFk));
    }

    public EmpleadoServicioDto crearEmpleadoServicio(EmpleadoServicioDto empleadoServicioDto){
        empleadoFacade.findById(empleadoServicioDto.getIdEmpleadoFk());
        servicioFacade.findById(empleadoServicioDto.getIdServicioFk());
        return empleadoServicioMapper.toDto(empleadoServicioService
                .crearEmpleadoServcio(empleadoServicioMapper.toEntity(empleadoServicioDto)));
    }

    public EmpleadoServicioDto editarEmpleadoServicio(EmpleadoServicioDto empleadoServicioDto){
        empleadoFacade.findById(empleadoServicioDto.getIdEmpleadoFk());
        servicioFacade.findById(empleadoServicioDto.getIdServicioFk());
        return empleadoServicioMapper.toDto(empleadoServicioService
                .editarEmpleadoServicio(empleadoServicioMapper.toEntity(empleadoServicioDto)));
    }
}
