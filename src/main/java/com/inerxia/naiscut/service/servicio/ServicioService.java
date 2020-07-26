package com.inerxia.naiscut.service.servicio;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.servicio.Servicio;
import com.inerxia.naiscut.model.servicio.ServicioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    //todo buscar servicios por sede, por rango de precio, por nombre

    public Servicio crearServicio(Servicio servicio){
        if(Objects.nonNull(servicio.getId())){
            Optional<Servicio> servicioOptional = servicioRepository.findById(servicio.getId());
            if(servicioOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.servicio");
            }
        }
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
        servicioTx.setEstado(servicio.getEstado());
        servicioTx.setIdSedeFk(servicio.getIdSedeFk());

        return servicioTx;
    }
}
