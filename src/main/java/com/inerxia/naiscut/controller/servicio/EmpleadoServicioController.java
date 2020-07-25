package com.inerxia.naiscut.controller.servicio;

import com.inerxia.naiscut.facade.servicio.EmpleadoServicioFacade;
import com.inerxia.naiscut.facade.servicio.dto.EmpleadoServicioDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empleado-servicio")
public class EmpleadoServicioController {

    private EmpleadoServicioFacade empleadoServicioFacade;

    public EmpleadoServicioController(EmpleadoServicioFacade empleadoServicioFacade) {
        this.empleadoServicioFacade = empleadoServicioFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el empleado servicio por id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EmpleadoServicioDto>> findById(@PathVariable Integer id){
        EmpleadoServicioDto empleadoServicioDto = empleadoServicioFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                empleadoServicioDto));
    }
}
