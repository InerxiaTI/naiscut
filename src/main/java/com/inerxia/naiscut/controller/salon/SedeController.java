package com.inerxia.naiscut.controller.salon;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.facade.salon.SedeFacade;
import com.inerxia.naiscut.facade.salon.dto.RegistroSalonDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
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
@RequestMapping("/sede")
public class SedeController {

    private SedeFacade sedeFacade;

    public SedeController(SedeFacade sedeFacade) {
        this.sedeFacade = sedeFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la sede por id", response = SedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SedeDto>> findById(@PathVariable Integer id){
        SedeDto sedeDto = sedeFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                sedeDto));
    }

    @GetMapping("/get-por-salon/{idSalonFk}")
    @ApiOperation(value = "Busca sedes por salon", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<SedeDto>>> buscarPorSalon(@PathVariable Integer idSalonFk){
        List<SedeDto> sedeDtoList = sedeFacade.buscarPorSalon(idSalonFk);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                sedeDtoList));
    }

    @GetMapping("/get-por-direccion/{direccion}")
    @ApiOperation(value = "Busca sedes por direccion", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<SedeDto>>> buscarPorDireccion(@PathVariable String direccion){
        List<SedeDto> sedeDtoList = sedeFacade.buscarPorDireccion(direccion);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                sedeDtoList));
    }

    @PostMapping("/registrar-salon")
    @ApiOperation(value = "Registra un salon y una sede principal", response = RegistroSalonDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<RegistroSalonDto>> registrarSalon(@Valid @RequestBody RegistroSalonDto registroSalonDto){
        RegistroSalonDto registroSalonDto1 = sedeFacade.registrarSalon(registroSalonDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "registro_salon.crear.exito",
                registroSalonDto1));
    }

    @PostMapping
    @ApiOperation(value = "Crea una sede", response = SedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SedeDto>> crearSede(@Valid @RequestBody SedeDto sedeDto){
        SedeDto sedeDto1 = sedeFacade.crearSede(sedeDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "sede.crear.exito",
                sedeDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita una sede", response = SedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SedeDto>> editarSede(@Valid @RequestBody SedeDto sedeDto){
        try{
            SedeDto sedeDto1 = sedeFacade.editarSede(sedeDto);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "sede.editar.exito",
                    sedeDto1));
        }catch (DataIntegrityViolationException e){
            throw new DataConstraintViolationException("exception.data_constraint_violation.sede");
        }
    }

    @PutMapping("/cambiar-sede-principal/{idSede}")
    @ApiOperation(value = "Cambia la sede principal", response = SedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<SedeDto>> cambiarSedePrincipal(@PathVariable Integer idSede){
        SedeDto sedeDto1 = sedeFacade.cambiarSedePrincipal(idSede);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "sede.editar.exito",
                sedeDto1));
    }
}
