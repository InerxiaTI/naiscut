package com.inerxia.naiscut.service.servicio;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.exception.RangoInvalidatedException;
import com.inerxia.naiscut.model.servicio.Servicio;
import com.inerxia.naiscut.model.servicio.ServicioRepository;
import com.inerxia.naiscut.util.DataTypeHandler;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class ServicioService {

    private ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public Servicio findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        return servicioRepository.findById(id).orElseThrow(()-> new DataNotFoundException("exception.data_not_found.servicio"));
    }

    public List<Servicio> buscarPorSede(Integer idSedeFk){
        if(Objects.isNull(idSedeFk)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Servicio> servicioList = servicioRepository.findByIdSedeFk(idSedeFk);
        if (servicioList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.servicio");
        }
        return servicioList;
    }

    public List<Servicio> buscarPorNombre(String nombre){
        if(Objects.isNull(nombre)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }
        List<Servicio> servicioList = servicioRepository.findByNombreContaining(nombre);
        if (servicioList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.servicio");
        }
        return servicioList;
    }

    public List<Servicio> buscarPorRangoPrecios(Double menor, Double mayor){
        if(Objects.isNull(menor) || Objects.isNull(mayor)){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        if(menor > mayor){
            throw new RangoInvalidatedException("exception.rango_invalidated.servicio");
        }

        List<Servicio> servicioList = servicioRepository.findByPrecioBetween(menor, mayor);
        if (servicioList.isEmpty()){
            throw new DataNotFoundException("exception.data_not_found.servicio");
        }
        return servicioList;
    }

    public Servicio crearServicio(Servicio servicio){
        if(Objects.nonNull(servicio.getId())){
            Optional<Servicio> servicioOptional = servicioRepository.findById(servicio.getId());
            if(servicioOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.servicio");
            }
        }
        servicio.setEstado(DataTypeHandler.charToBoolean(servicio.getEstado()) ? '1' : '0');
        return servicioRepository.save(servicio);
    }

    public Servicio editarServicio(Servicio servicio){
        if(Objects.isNull(servicio.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Servicio servicioTx = servicioRepository.findById(servicio.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.servicio"));

        servicioTx.setNombre(servicio.getNombre());
        servicioTx.setDescripcion(servicio.getDescripcion());
        servicioTx.setPrecio(servicio.getPrecio());
        servicioTx.setDuracion(servicio.getDuracion());
        servicioTx.setEstado(DataTypeHandler.charToBoolean(servicio.getEstado()) ? '1' : '0');
        servicioTx.setIdSedeFk(servicio.getIdSedeFk());

        return servicioTx;
    }
}
