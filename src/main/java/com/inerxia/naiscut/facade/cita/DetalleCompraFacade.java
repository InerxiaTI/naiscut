package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cita.dto.DetalleCompraDto;
import com.inerxia.naiscut.facade.mapper.DetalleCompraMapper;
import com.inerxia.naiscut.service.cita.DetalleCompraService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class DetalleCompraFacade extends Facade<DetalleCompraMapper, DetalleCompraService> implements GeneralFacade<DetalleCompraDto> {


    public DetalleCompraFacade(DetalleCompraMapper mapper, DetalleCompraService service) {
        super(mapper, service);
    }

    @Override
    public DetalleCompraDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    public DetalleCompraDto crearDetalleCompra(DetalleCompraDto detalleCompraDto){
        //salonFacade.findById(sedeDto.getIdSalonFk()); validar lo del consecutivo
        return mapper.toDto(service.crearDetalleCompra(mapper.toEntity(detalleCompraDto)));
    }

    public DetalleCompraDto editarDetalleCompra(DetalleCompraDto detalleCompraDto){
        //salonFacade.findById(sedeDto.getIdSalonFk());
        return mapper.toDto(service.editarDetalleCompra(mapper.toEntity(detalleCompraDto)));
    }

    @Override
    public List<DetalleCompraDto> findAll(Pageable pageable) {
        return null;
    }

}
