package com.inerxia.naiscut.facade.ocupacion;

import com.inerxia.naiscut.facade.cita.CitaFacade;
import com.inerxia.naiscut.facade.empleado.EmpleadoFacade;
import com.inerxia.naiscut.facade.mapper.OcupacionMapper;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.facade.salon.SedeFacade;
import com.inerxia.naiscut.service.ocupacion.OcupacionService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class OcupacionFacade {

    private OcupacionMapper ocupacionMapper;
    private OcupacionService ocupacionService;

    private CitaFacade citaFacade;
    private EmpleadoFacade empleadoFacade;
    private SedeFacade sedeFacade;

    public OcupacionFacade(OcupacionMapper ocupacionMapper,
                           OcupacionService ocupacionService,
                           CitaFacade citaFacade,
                           EmpleadoFacade empleadoFacade,
                           SedeFacade sedeFacade) {
        this.ocupacionMapper = ocupacionMapper;
        this.ocupacionService = ocupacionService;
        this.citaFacade = citaFacade;
        this.empleadoFacade = empleadoFacade;
        this.sedeFacade = sedeFacade;
    }

    public OcupacionDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return ocupacionMapper.toDto(ocupacionService.findById(id));
    }

    public OcupacionDto crearOcupacion(OcupacionDto ocupacionDto){
        empleadoFacade.findById(ocupacionDto.getIdEmpleadoFk());
        citaFacade.findById(ocupacionDto.getIdCitaFk());
        sedeFacade.findById(ocupacionDto.getIdSedeFk());
        return ocupacionMapper.toDto(ocupacionService
                .crearOcupacion(ocupacionMapper.toEntity(ocupacionDto)));
    }

    public OcupacionDto editarOcupacion(OcupacionDto ocupacionDto){
        empleadoFacade.findById(ocupacionDto.getIdEmpleadoFk());
        citaFacade.findById(ocupacionDto.getIdCitaFk());
        sedeFacade.findById(ocupacionDto.getIdSedeFk());
        return ocupacionMapper.toDto(ocupacionService
                .editarOcupacion(ocupacionMapper.toEntity(ocupacionDto)));
    }
}
