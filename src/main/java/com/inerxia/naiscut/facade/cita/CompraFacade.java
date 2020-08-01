package com.inerxia.naiscut.facade.cita;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cita.dto.CompraDto;
import com.inerxia.naiscut.facade.mapper.CompraMapper;
import com.inerxia.naiscut.model.cita.Compra;
import com.inerxia.naiscut.service.cita.CompraService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class CompraFacade extends Facade<CompraMapper, CompraService> implements GeneralFacade<CompraDto> {

    public CompraFacade(CompraMapper mapper, CompraService service) {
        super(mapper, service);
    }

    @Override
    public CompraDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    public CompraDto crearCompra(CompraDto compraDto){
        //salonFacade.findById(sedeDto.getIdSalonFk()); validar lo del consecutivo
        return mapper.toDto(service.crearCompra(mapper.toEntity(compraDto)));
    }

    public CompraDto editarCompra(CompraDto compraDto){
        //salonFacade.findById(sedeDto.getIdSalonFk());
        return mapper.toDto(service.editarCompra(mapper.toEntity(compraDto)));
    }

    @Override
    public List<CompraDto> findAll(Pageable pageable) {
        return null;
    }

}
