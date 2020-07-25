package com.inerxia.naiscut.controller.cita;


import com.inerxia.naiscut.facade.cita.CitaFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.empleado.dto.EmpleadoRolDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@Api(value = "Citas endpoint")
public class CitaController {

    private CitaFacade citaFacade;

    public CitaController(CitaFacade citaFacade) {
        this.citaFacade = citaFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el rol de empleados por id", response = CitaDto.class)
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
}
