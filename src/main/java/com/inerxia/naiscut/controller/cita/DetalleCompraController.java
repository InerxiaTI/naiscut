package com.inerxia.naiscut.controller.cita;

import com.inerxia.naiscut.facade.cita.DetalleCompraFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cita.dto.DetalleCompraDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping
    @ApiOperation(value = "Crea un detalle compra", response = DetalleCompraDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<DetalleCompraDto>> crearSede(@Valid @RequestBody DetalleCompraDto detalleCompraDto){
        DetalleCompraDto detalleCompraDto1 = detalleCompraFacade.crearDetalleCompra(detalleCompraDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "detalle_compra.crear.exito",
                detalleCompraDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un detalle compra", response = DetalleCompraDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<DetalleCompraDto>> editarSede(@Valid @RequestBody DetalleCompraDto detalleCompraDto){
        DetalleCompraDto detalleCompraDto1 = detalleCompraFacade.editarDetalleCompra(detalleCompraDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "detalle_compra.editar.exito",
                detalleCompraDto1));
    }
}
