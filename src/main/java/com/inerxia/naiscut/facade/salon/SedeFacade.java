package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SedeMapper;
import com.inerxia.naiscut.facade.salon.dto.RegistroSalonDto;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.facade.salon.dto.SedeSalonDto;
import com.inerxia.naiscut.service.salon.SedeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<SedeSalonDto> getSedesSalon(){
        List<SedeDto> sedeDtoList = sedeMapper.toDto(sedeService.findAll());
        List<SedeSalonDto> sedeSalonDtoList = new ArrayList<>();
        Integer idSalon=null;
        String tipoSalon="";
        SalonDto salonDto = new SalonDto();
        for (SedeDto sede : sedeDtoList) {
            idSalon = sede.getIdSalonFk();
            if (Objects.isNull(salonDto.getId()) || !salonDto.getId().equals(idSalon)) {
                salonDto = salonFacade.findById(sede.getIdSalonFk());
                tipoSalon = salonFacade.getTipoSalon(salonDto.getIdTipoSalonFk());
            }

            SedeSalonDto sedeSalonDto = new SedeSalonDto(
                    sede.getId(),
                    sede.getDescripcion(),
                    sede.getCiudad(),
                    sede.getDireccion(),
                    sede.getTelefono(),
                    sede.getDomicilio(),
                    sede.getPrincipal(),
                    sede.getEstadoSede(),
                    salonDto.getNit(),
                    salonDto.getNombre(),
                    salonDto.getLogo(),
                    tipoSalon
            );
            sedeSalonDtoList.add(sedeSalonDto);
        }
        return sedeSalonDtoList;
    }

    public List<SedeDto> buscarPorSalon(Integer idSalonFk){
        salonFacade.findById(idSalonFk);
        return sedeMapper.toDto(sedeService.buscarPorSalon(idSalonFk));
    }

    public List<SedeDto> buscarPorDireccion(String direccion){
        return sedeMapper.toDto(sedeService.buscarPorDireccion(direccion));
    }

    public List<SedeDto> buscarPorNombreSalon(String nombre){
        return sedeMapper.toDto(sedeService.buscarPorNombreSalon(nombre));
    }

    public SedeDto cambiarSedePrincipal(Integer idSede){
        return sedeMapper.toDto(sedeService.cambiarSedePrincipal(idSede));
    }

    public RegistroSalonDto registrarSalon(RegistroSalonDto registroSalonDto){
        SalonDto salonDto = salonFacade.crearSalon(registroSalonDto.getSalonDto());
        registroSalonDto.getSedeDto().setIdSalonFk(salonDto.getId());
        SedeDto sedeDto = crearSede(registroSalonDto.getSedeDto());

        RegistroSalonDto registroSalonDto1 = new RegistroSalonDto();
        registroSalonDto1.setSalonDto(salonDto);
        registroSalonDto1.setSedeDto(sedeDto);

        return registroSalonDto1;
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
