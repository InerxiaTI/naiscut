package com.inerxia.naiscut.controller.cita;

import com.inerxia.naiscut.facade.cita.EstadoCitaFacade;
import com.inerxia.naiscut.facade.cita.dto.EstadoCitaDto;
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
@RequestMapping("/estado-cita")
public class EstadoCitaController {
    private EstadoCitaFacade estadoCitaFacade;

    public EstadoCitaController(EstadoCitaFacade estadoCitaFacade) {
        this.estadoCitaFacade = estadoCitaFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el estado cita por id", response = EstadoCitaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EstadoCitaDto>> findById(@PathVariable Integer id){
        EstadoCitaDto estadoCitaDto = estadoCitaFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                estadoCitaDto));
    }
}
