package com.inerxia.naiscut.controller.salon;

import com.inerxia.naiscut.facade.salon.HorarioSedeFacade;
import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
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
}
