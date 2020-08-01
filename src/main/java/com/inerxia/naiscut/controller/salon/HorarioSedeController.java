package com.inerxia.naiscut.controller.salon;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.facade.salon.HorarioSedeFacade;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
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
@RequestMapping("/horario-sede")
public class HorarioSedeController {

    private HorarioSedeFacade horarioSedeFacade;

    public HorarioSedeController(HorarioSedeFacade horarioSedeFacade) {
        this.horarioSedeFacade = horarioSedeFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el horario de la sede por id", response = HorarioSedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<HorarioSedeDto>> findById(@PathVariable Integer id){
        HorarioSedeDto horarioSedeDto = horarioSedeFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                horarioSedeDto));
    }

    @GetMapping("/get-por-sede/{idSedeFk}")
    @ApiOperation(value = "Busca los horarios de una sede", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<HorarioSedeDto>>> buscarPorSede(@PathVariable Integer idSedeFk){
        List<HorarioSedeDto> horarioSedeDtoList = horarioSedeFacade.buscarPorSede(idSedeFk);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                horarioSedeDtoList));
    }

    @PostMapping
    @ApiOperation(value = "Crea un horario para una sede", response = HorarioSedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<HorarioSedeDto>> crearHorarioSede(@Valid @RequestBody HorarioSedeDto horarioSedeDto){
        HorarioSedeDto horarioSedeDto1 = horarioSedeFacade.crearHorarioSede(horarioSedeDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "horario_sede.crear.exito",
                horarioSedeDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita un horario de una sede", response = HorarioSedeDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<HorarioSedeDto>> editarHorarioSEde(@Valid @RequestBody HorarioSedeDto horarioSedeDto){
        try{
            HorarioSedeDto horarioSedeDto1 = horarioSedeFacade.editarHorarioSede(horarioSedeDto);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "horario_sede.editar.exito",
                    horarioSedeDto1));
        }catch (DataIntegrityViolationException e){
            throw new DataConstraintViolationException("exception.data_constraint_violation.horario_sede");
        }
    }
}
