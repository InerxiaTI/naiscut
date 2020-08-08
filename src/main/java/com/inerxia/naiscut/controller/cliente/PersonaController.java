package com.inerxia.naiscut.controller.cliente;

import com.inerxia.naiscut.facade.cliente.PersonaFacade;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Collection;
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
            @ApiResponse(code = 403, message = "Error, acceso denegado")
    })
    @PreAuthorize("hasAuthority('CLIENTE')")
    public ResponseEntity<StandardResponse<List<PersonaDto>>> findAll(Pageable pageable){
        List<PersonaDto> personasDto = personaFacade.findAll(pageable);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                personasDto));
    }

    @PostMapping
    @ApiOperation(value = "Crea persona", response = PersonaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<PersonaDto>> crearPersona(@Valid @RequestBody PersonaDto personaDto){
        PersonaDto personaDto1 = personaFacade.crearPersona(personaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "persona.crear.exito",
                personaDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita una persona", response = PersonaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<PersonaDto>> editarPersona(@Valid @RequestBody PersonaDto personaDto){
        PersonaDto personaDto1 = personaFacade.editarPersona(personaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "persona.editar.exito",
                personaDto1));
    }






}
