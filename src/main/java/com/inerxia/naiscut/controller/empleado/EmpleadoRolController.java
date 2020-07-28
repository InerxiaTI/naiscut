package com.inerxia.naiscut.controller.empleado;

import com.inerxia.naiscut.facade.empleado.EmpleadoRolFacade;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoRolDto;
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
@RequestMapping("/empleado-rol")
public class EmpleadoRolController {
    private EmpleadoRolFacade empleadoRolFacade;

    public EmpleadoRolController(EmpleadoRolFacade empleadoRolFacade) {
        this.empleadoRolFacade = empleadoRolFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el rol de empleados por id", response = EmpleadoRolDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EmpleadoRolDto>> findById(@PathVariable Integer id){
        EmpleadoRolDto empleadoRolDto = empleadoRolFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                empleadoRolDto));
    }
}
