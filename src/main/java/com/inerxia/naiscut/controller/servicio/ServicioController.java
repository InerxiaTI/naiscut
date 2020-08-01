package com.inerxia.naiscut.controller.servicio;

import com.inerxia.naiscut.facade.servicio.ServicioFacade;
import com.inerxia.naiscut.facade.servicio.dto.ServicioDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/servicio")
public class ServicioController {

    private ServicioFacade servicioFacade;

    public ServicioController(ServicioFacade servicioFacade) {
        this.servicioFacade = servicioFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el servicio por id", response = ServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ServicioDto>> findById(@PathVariable Integer id){
        ServicioDto servicioDto = servicioFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                servicioDto));
    }

    @GetMapping("/get-por-nombre/{nombre}")
    @ApiOperation(value = "Busca servicios por el nombre", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ServicioDto>>> buscarPorNombre(@PathVariable String nombre){
        List<ServicioDto> servicioDtoList = servicioFacade.buscarPorNombre(nombre);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                servicioDtoList));
    }

    @GetMapping("/get-por-sede/{idSedeFk}")
    @ApiOperation(value = "Busca servicios por la sede", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ServicioDto>>> buscarPorSede(@PathVariable Integer idSedeFk){
        List<ServicioDto> servicioDtoList = servicioFacade.buscarPorSede(idSedeFk);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                servicioDtoList));
    }

    @GetMapping("/get-por-rango-precios/{menor}/{mayor}")
    @ApiOperation(value = "Busca servicios por rango de precios", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<ServicioDto>>> buscarPorRangoPrecios(
            @PathVariable Double menor, @PathVariable Double mayor){
        List<ServicioDto> servicioDtoList = servicioFacade.buscarPorRangoPrecios(menor, mayor);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                servicioDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Crea un servicio", response = ServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ServicioDto>> crearServicio(@Valid @RequestBody ServicioDto servicioDto){
        ServicioDto servicioDto1 = servicioFacade.crearServicio(servicioDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "servicio.crear.exito",
                servicioDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un servicio", response = ServicioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<ServicioDto>> editarServicio(@Valid @RequestBody ServicioDto servicioDto){
        ServicioDto servicioDto1 = servicioFacade.editarServicio(servicioDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "servicio.editar.exito",
                servicioDto1));
    }
}
