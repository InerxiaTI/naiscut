package com.inerxia.naiscut.controller.cliente;

import com.inerxia.naiscut.facade.cliente.PersonaFacade;
import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
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
@RequestMapping("/persona")
public class PersonaController {
    private PersonaFacade personaFacade;

    public PersonaController(PersonaFacade personaFacade) {
        this.personaFacade = personaFacade;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca la persona por id", response = PersonaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<PersonaDto>> findById(@PathVariable Integer id){
        PersonaDto personaDto = personaFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                personaDto));
    }

    @GetMapping("/get-todos")
    @ApiOperation(value = "Busca todas las personas", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<List<PersonaDto>>> findAll(Pageable pageable){
        List<PersonaDto> personasDto = personaFacade.findAll(pageable);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                personasDto));
    }


}
