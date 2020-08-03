package com.inerxia.naiscut.controller.cliente;

import com.inerxia.naiscut.facade.cliente.GeneroFacade;
import com.inerxia.naiscut.facade.cliente.dto.GeneroDto;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/genero")
public class GeneroController {
    private GeneroFacade generoFacade;

    public GeneroController(GeneroFacade generoFacade) {
        this.generoFacade = generoFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el genero por id", response = GeneroDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<GeneroDto>> findById(@PathVariable Integer id){
        GeneroDto generoDto = generoFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                generoDto));
    }

    @GetMapping("/get-todos")
    @ApiOperation(value = "Busca todas los generos", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<GeneroDto>>> findAll(Pageable pageable){
        List<GeneroDto> personasDto = generoFacade.findAll(pageable);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                personasDto));
    }
}
