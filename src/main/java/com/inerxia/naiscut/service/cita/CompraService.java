package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.exception.DataNotFoundException;
import com.inerxia.naiscut.exception.ObjectNoEncontradoException;
import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cita.Compra;
import com.inerxia.naiscut.model.cita.CompraRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class CompraService {
    private CompraRepository compraRepository;

    public CompraService(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    public Compra crearCompra(Compra compra){
        if(Objects.nonNull(compra.getId())){
            Optional<Compra> compraOptional = compraRepository.findById(compra.getId());
            if(compraOptional.isPresent()){
                throw new DataNotFoundException("exception.data_duplicated.compra");
            }
        }

        try {
            return compraRepository.save(compra);
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.compra");
        }
    }

    public Compra editarCompra(Compra compra){
        if(Objects.isNull(compra.getId())){
            throw new ObjectNoEncontradoException("exception.objeto_no_encontrado");
        }

        Compra compraTx = compraRepository.findById(compra.getId())
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.compra"));

        compraTx.setValorTotal(compra.getValorTotal());
        compraTx.setIdMetodoPagoFk(compra.getIdMetodoPagoFk());
        compraTx.setIdEstadoCompraFk(compra.getIdEstadoCompraFk());
        compraTx.setFechaPago(compra.getFechaPago());

        return compraTx;
    }


    public Compra findById(Integer id){
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return compraRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("exception.data_not_found.compra"));

    }
}
