package com.inerxia.naiscut.controller.cliente;

import com.inerxia.naiscut.facade.cliente.UsuarioFacade;
import com.inerxia.naiscut.facade.cliente.dto.UsuarioDto;
import com.inerxia.naiscut.facade.ocupacion.dto.OcupacionDto;
import com.inerxia.naiscut.util.StandardResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioFacade usuarioFacade;

    public UsuarioController(UsuarioFacade usuarioFacade) {
        this.usuarioFacade = usuarioFacade;
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
}
