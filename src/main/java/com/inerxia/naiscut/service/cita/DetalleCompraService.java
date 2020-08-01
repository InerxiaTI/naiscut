package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cita.DetalleCompra;
import com.inerxia.naiscut.model.cita.DetalleCompraRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class DetalleCompraService {
    private DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraService(DetalleCompraRepository detalleCompraRepository) {
        this.detalleCompraRepository = detalleCompraRepository;
    }

    public DetalleCompra crearDetalleCompra(DetalleCompra detalleCompra){
        if(Objects.nonNull(detalleCompra.getId())){
            Optional<DetalleCompra> citaOptional = detalleCompraRepository.findById(detalleCompra.getId());
            if(citaOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.detalle_compra");
            }
        }


        try {
            return detalleCompraRepository.save(detalleCompra);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.detalle_compra");
        }
    }

    public DetalleCompra editarDetalleCompra(DetalleCompra detalleCompra){
        if(Objects.isNull(detalleCompra.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        DetalleCompra detalleCompraTx = detalleCompraRepository.findById(detalleCompra.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.detalle_compra"));

        detalleCompraTx.setIdServicioFk(detalleCompra.getIdServicioFk());
        detalleCompraTx.setPrecio(detalleCompra.getPrecio());
        detalleCompraTx.setDuracion(detalleCompra.getDuracion());
        detalleCompraTx.setIdCompraFk(detalleCompra.getIdCompraFk());



        return detalleCompraTx;
    }

    public DetalleCompra findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return detalleCompraRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.detalle_compra"));
    }
}
