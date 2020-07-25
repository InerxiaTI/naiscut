package com.inerxia.naiscut.controller.cita;

import com.inerxia.naiscut.facade.cita.DetalleCompraFacade;
import com.inerxia.naiscut.facade.cita.dto.DetalleCompraDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle-compra")
public class DetalleCompraController {
    private DetalleCompraFacade detalleCompraFacade;

    public DetalleCompraController(DetalleCompraFacade detalleCompraFacade) {
        this.detalleCompraFacade = detalleCompraFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el detalle compra por id", response = OcupacionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<DetalleCompraDto>> findById(@PathVariable Integer id){
        DetalleCompraDto detalleCompraDto = detalleCompraFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                detalleCompraDto));
    }
}
