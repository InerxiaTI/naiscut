package com.inerxia.naiscut.controller.ocupacion;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.facade.ocupacion.OcupacionFacade;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDiaDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDiaServicioDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ocupacion")
public class OcupacionController {

    private OcupacionFacade ocupacionFacade;

    public OcupacionController(OcupacionFacade ocupacionFacade) {
        this.ocupacionFacade = ocupacionFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la ocupacion por id", response = OcupacionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<OcupacionDto>> findById(@PathVariable Integer id){
        OcupacionDto ocupacionDto = ocupacionFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                ocupacionDto));
    }

    @PostMapping("/get-ocupacion-dia")
    @ApiOperation(value = "Obtiene la ocupacion del dia de una sede", response = OcupacionDiaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<OcupacionDiaDto>> getOcupacionDelDia(
            @Valid @RequestBody OcupacionDiaDto ocupacionDiaDto){
        OcupacionDiaDto ocupacionDto1 = ocupacionFacade.getOcupacionDelDia(ocupacionDiaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                ocupacionDto1));
    }

    @PostMapping("/get-ocupacion-dia-servicio")
    @ApiOperation(value = "Obtiene la ocupacion del dia de un servicio", response = OcupacionDiaServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<OcupacionDiaServicioDto>> getOcupacionDelDia(
            @Valid @RequestBody OcupacionDiaServicioDto ocupacionDiaServicioDto){
        OcupacionDiaServicioDto ocupacionDiaServicioDto1  = ocupacionFacade.getOcupacionDiaServicio(ocupacionDiaServicioDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                ocupacionDiaServicioDto1));
    }

    @PostMapping
    @ApiOperation(value = "Crea una ocupacion", response = OcupacionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<OcupacionDto>> crearOcupacion(
            @Valid @RequestBody OcupacionDto ocupacionDto){
        OcupacionDto ocupacionDto1 = ocupacionFacade.crearOcupacion(ocupacionDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "ocupacion.crear.exito",
                ocupacionDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita una ocupacion", response = OcupacionDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<OcupacionDto>> editarOcupacion(
            @Valid @RequestBody OcupacionDto ocupacionDto){
        try {
            OcupacionDto ocupacionDto1 = ocupacionFacade.editarOcupacion(ocupacionDto);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "ocupacion.editar.exito",
                    ocupacionDto1));
        }catch (DataIntegrityViolationException e) {
            throw new DataConstraintViolationException("exception.data_constraint_violation.ocupacion");
        }
    }
}
