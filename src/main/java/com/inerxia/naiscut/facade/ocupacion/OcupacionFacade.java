package com.inerxia.naiscut.facade.ocupacion;

import com.inerxia.naiscut.facade.cita.CitaFacade;
import com.inerxia.naiscut.facade.empleado.EmpleadoFacade;
import com.inerxia.naiscut.facade.mapper.OcupacionMapper;
import com.inerxia.naiscut.facade.ocupacion.dto.CuartoDto;
import com.inerxia.naiscut.facade.ocupacion.dto.DetalleCuartoDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDiaDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.facade.salon.HorarioSedeFacade;
import com.inerxia.naiscut.facade.salon.SedeFacade;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
import com.inerxia.naiscut.service.ocupacion.OcupacionService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class OcupacionFacade {

    private OcupacionMapper ocupacionMapper;
    private OcupacionService ocupacionService;

    private CitaFacade citaFacade;
    private EmpleadoFacade empleadoFacade;
    private SedeFacade sedeFacade;
    private HorarioSedeFacade horarioSedeFacade;

    public OcupacionFacade(OcupacionMapper ocupacionMapper,
                           OcupacionService ocupacionService,
                           CitaFacade citaFacade,
                           EmpleadoFacade empleadoFacade,
                           SedeFacade sedeFacade,
                           HorarioSedeFacade horarioSedeFacade) {
        this.ocupacionMapper = ocupacionMapper;
        this.ocupacionService = ocupacionService;
        this.citaFacade = citaFacade;
        this.empleadoFacade = empleadoFacade;
        this.sedeFacade = sedeFacade;
        this.horarioSedeFacade = horarioSedeFacade;
    }

    public OcupacionDto findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return ocupacionMapper.toDto(ocupacionService.findById(id));
    }

    //todo buscar la ocupacion de un dia de una sede
    public OcupacionDiaDto getOcupacionDelDia(OcupacionDiaDto ocupacionDiaDto){
        List<HorarioSedeDto> horarioSedeDtoList = horarioSedeFacade.buscarPorSede(ocupacionDiaDto.getIdSedeFk());

        //todo validar que la hora sea la correcta, no 5 horas menos
        //todo validar que nunca vengan segundos
        horarioSedeDtoList.forEach(horarioSedeDto -> {
            if(horarioSedeDto.getDia()==ocupacionDiaDto.getDia()){
                ocupacionDiaDto.setHoraInicio(horarioSedeDto.getHoraInicio());
                ocupacionDiaDto.setHoraFinal(horarioSedeDto.getHoraFinal());
            }
        });

        LocalTime hi = ocupacionDiaDto.getHoraInicio();
        LocalTime hf = ocupacionDiaDto.getHoraFinal();

        List<CuartoDto> cuartoDtoList = new ArrayList<>();
        int horaAnterior=-1;
        LocalTime i = hi;
        CuartoDto cuartoDto = new CuartoDto();
        while (i.isBefore(hf)) {
            if(horaAnterior<0){
                cuartoDto.setCuarto(hi);
                cuartoDto.setDetalleCuartoDto(getDetallesCuarto(ocupacionDiaDto.getFechaConsulta(),
                                                            ocupacionDiaDto.getIdSedeFk(),
                                                            cuartoDto.getCuarto()));
                cuartoDtoList.add(cuartoDto);
            }
            cuartoDto = new CuartoDto();
            horaAnterior++;
            LocalTime before = cuartoDtoList.get(horaAnterior).getCuarto();
            cuartoDto.setCuarto(before.plusMinutes(15));

            cuartoDto.setDetalleCuartoDto(getDetallesCuarto(ocupacionDiaDto.getFechaConsulta(),
                                                    ocupacionDiaDto.getIdSedeFk(),
                                                    cuartoDto.getCuarto()));
            cuartoDtoList.add(cuartoDto);

            i=cuartoDtoList.get(horaAnterior+1).getCuarto();
        }
        ocupacionDiaDto.setCuartoDtoList(cuartoDtoList);
        return ocupacionDiaDto;
    }

    private List<DetalleCuartoDto> getDetallesCuarto(LocalDate fecha, Integer idSede, LocalTime cuarto){
        List<DetalleCuartoDto> detalleCuartoDtoList = new ArrayList<>();

        List<OcupacionDto> ocupacionDtoList = ocupacionMapper.toDto(
                ocupacionService.buscarPorFechaYSede(fecha,idSede));

        ocupacionDtoList.forEach(ocupacionDto -> {
            if (ocupacionDto.getHoraInicio()==cuarto){
                DetalleCuartoDto detalleCuartoDto = new DetalleCuartoDto();
                detalleCuartoDto.setIdCitaFk(ocupacionDto.getIdCitaFk());
                detalleCuartoDto.setIdEmpleadoFk(ocupacionDto.getIdEmpleadoFk());
                detalleCuartoDto.setHoraFinalCita(ocupacionDto.getHoraFinal());
                detalleCuartoDtoList.add(detalleCuartoDto);
            }
        });

        return detalleCuartoDtoList;
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
