package com.inerxia.naiscut.controller.empleado;

import com.inerxia.naiscut.facade.empleado.EmpleadoFacade;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoDto;
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
@RequestMapping("/empleado")
public class EmpleadoController {
    private EmpleadoFacade empleadoFacade;

    public EmpleadoController(EmpleadoFacade empleadoFacade) {
        this.empleadoFacade = empleadoFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el empleado por id", response = EmpleadoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EmpleadoDto>> findById(@PathVariable Integer id){
        EmpleadoDto empleadoDto = empleadoFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                empleadoDto));
    }
}
