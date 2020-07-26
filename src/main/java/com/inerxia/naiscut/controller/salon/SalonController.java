package com.inerxia.naiscut.controller.salon;


import com.inerxia.naiscut.facade.salon.SalonFacade;
import com.inerxia.naiscut.facade.salon.dto.SalonDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/salon")
public class SalonController {

    private SalonFacade salonFacade;

    public SalonController(SalonFacade salonFacade) {
        this.salonFacade = salonFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el salon por id", response = SalonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SalonDto>> findById(@PathVariable Integer id){
        SalonDto salonDto = salonFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                salonDto));
    }

    @GetMapping("/get-todos")
    @ApiOperation(value = "Lista todos los salones", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<SalonDto>>> findAll(){
        List<SalonDto> salonDtoList = salonFacade.findAll();
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                salonDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Crea un salon", response = SalonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SalonDto>> crearSalon(@Valid @RequestBody SalonDto salonDto){
        SalonDto salonDto1 = salonFacade.crearSalon(salonDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "salon.crear.exito",
                salonDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un salon", response = SalonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SalonDto>> editarSalon(@Valid @RequestBody SalonDto salonDto){
        SalonDto salonDto1 = salonFacade.editarSalon(salonDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "salon.editar.exito",
                salonDto1));
    }
}
