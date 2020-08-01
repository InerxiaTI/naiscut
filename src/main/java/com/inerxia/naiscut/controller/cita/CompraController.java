package com.inerxia.naiscut.controller.cita;

import com.inerxia.naiscut.facade.cita.CompraFacade;
import com.inerxia.naiscut.facade.cita.dto.CompraDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/compra")
public class CompraController {
    private CompraFacade compraFacade;

    public CompraController(CompraFacade compraFacade) {
        this.compraFacade = compraFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la compra por id", response = CompraDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CompraDto>> findById(@PathVariable Integer id){
        CompraDto compraDto = compraFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                compraDto));
    }

    @PostMapping
    @ApiOperation(value = "Crea una compra", response = CompraDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CompraDto>> crearSede(@Valid @RequestBody CompraDto compraDto){
        CompraDto compraDto1 = compraFacade.crearCompra(compraDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "compra.crear.exito",
                compraDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita una compra", response = CompraDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CompraDto>> editarSede(@Valid @RequestBody CompraDto compraDto){
        CompraDto compraDto1 = compraFacade.editarCompra(compraDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "compra.editar.exito",
                compraDto1));
    }
}
