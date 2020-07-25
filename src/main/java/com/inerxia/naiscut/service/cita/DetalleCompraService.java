package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.model.cita.DetalleCompra;
import com.inerxia.naiscut.model.cita.DetalleCompraRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class DetalleCompraService {
    private DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
        this.detalleCompraRepository = detalleCompraRepository;
    }

    public DetalleCompra findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return detalleCompraRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.detalle_compra"));
    }
}
