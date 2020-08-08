package com.inerxia.naiscut.controller.cliente;

import com.inerxia.naiscut.exception.DataConstraintViolationException;
import com.inerxia.naiscut.facade.cliente.UsuarioFacade;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.cliente.dto.RegistroPersonaDto;
import com.inerxia.naiscut.facade.cliente.dto.UsuarioDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.facade.salon.dto.SedeDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioFacade usuarioFacade;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsuarioController(UsuarioFacade usuarioFacade,  BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioFacade = usuarioFacade;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @GetMapping("/get-por-id/{id}")
    @ApiOperation(value = "Busca el usuario por id", response = UsuarioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<UsuarioDto>> findById(@PathVariable Integer id){
        UsuarioDto usuarioDto = usuarioFacade.findById(id);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                usuarioDto));
    }


    @PostMapping("/registrar-usuario")
    @ApiOperation(value = "Registro en la aplicación", response = RegistroPersonaDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<RegistroPersonaDto>> crearUsuario(@Valid @RequestBody RegistroPersonaDto registroPersonaDto){
        registroPersonaDto.getUsuarioDto().setClave(bCryptPasswordEncoder.encode( registroPersonaDto.getUsuarioDto().getClave()));
        RegistroPersonaDto registroPersonaDto1 = usuarioFacade.registrarUsuario(registroPersonaDto);
        return ResponseEntity.ok(new StandardResponse<>(
                StandardResponse.EstadoStandardResponse.OK,
                "registro_usuario.crear.exito",
                registroPersonaDto1));
    }

    @PutMapping
    @ApiOperation(value = "Edita usuario", response = UsuarioDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La petición fue procesada con éxito"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error del servidor al procesar la respuesta"),
    })
    public ResponseEntity<StandardResponse<UsuarioDto>> editarUsuario(@Valid @RequestBody UsuarioDto usuarioDto){
        try{
            UsuarioDto usuarioDto1 = usuarioFacade.editarUsuario(usuarioDto);
            return ResponseEntity.ok(new StandardResponse<>(
                    StandardResponse.EstadoStandardResponse.OK,
                    "usuario.editar.exito",
                    usuarioDto1));
        }catch (DataIntegrityViolationException e){
            throw new DataConstraintViolationException("exception.data_constraint_violation.usuario");
        }
    }


}
