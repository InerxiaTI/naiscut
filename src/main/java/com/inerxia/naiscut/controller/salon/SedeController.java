package com.inerxia.naiscut.controller.salon;

import com.inerxia.naiscut.facade.salon.SedeFacade;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
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
@RequestMapping("/sede")
public class SedeController {

    private SedeFacade sedeFacade;

    public SedeController(SedeFacade sedeFacade) {
        this.sedeFacade = sedeFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la sede por id", response = List.class)
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
}
