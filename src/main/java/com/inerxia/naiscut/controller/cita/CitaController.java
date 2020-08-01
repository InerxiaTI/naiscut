package com.inerxia.naiscut.controller.cita;


import com.inerxia.naiscut.facade.cita.CitaFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cita")
public class CitaController {

    private CitaFacade citaFacade;

    public CitaController(CitaFacade citaFacade) {
        this.citaFacade = citaFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la cita por id", response = CitaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CitaDto>> findById(@PathVariable Integer id){
        CitaDto citaDto = citaFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                citaDto));
    }

    @PostMapping
    @ApiOperation(value = "Crea una cita", response = CitaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CitaDto>> crearSede(@Valid @RequestBody CitaDto citaDto){
        CitaDto citaDto1 = citaFacade.crearCita(citaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "cita.crear.exito",
                citaDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita una cita", response = CitaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<CitaDto>> editarSede(@Valid @RequestBody CitaDto citaDto){
        CitaDto citaDto1 = citaFacade.editarCita(citaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "cita.editar.exito",
                citaDto1));
    }
}
