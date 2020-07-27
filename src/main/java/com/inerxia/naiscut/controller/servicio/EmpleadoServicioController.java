package com.inerxia.naiscut.controller.servicio;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.facade.servicio.EmpleadoServicioFacade;
import com.inerxia.naiscut.facade.servicio.dto.EmpleadoServicioDto;
import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empleado-servicio")
public class EmpleadoServicioController {

    private EmpleadoServicioFacade empleadoServicioFacade;

    public EmpleadoServicioController(EmpleadoServicioFacade empleadoServicioFacade) {
        this.empleadoServicioFacade = empleadoServicioFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el empleado servicio por id", response = EmpleadoServicioDto.class)
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

    @PostMapping
    @ApiOperation(value = "Crea un servicio para un empleado", response = EmpleadoServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EmpleadoServicioDto>> crearEmpleadoServicio(
            @Valid @RequestBody EmpleadoServicioDto empleadoServicioDto){
        EmpleadoServicioDto empleadoServicioDto1 = empleadoServicioFacade.crearEmpleadoServicio(empleadoServicioDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "empleado_servicio.crear.exito",
                empleadoServicioDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita el servicio de un empleado", response = EmpleadoServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<EmpleadoServicioDto>> editarEmpleadoServicio(
            @Valid @RequestBody EmpleadoServicioDto empleadoServicioDto){
        try {
            EmpleadoServicioDto empleadoServicioDto1 = empleadoServicioFacade.editarEmpleadoServicio(empleadoServicioDto);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "empleado_servicio.editar.exito",
                    empleadoServicioDto1));
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.empleado_servicio");
        }
    }
}
