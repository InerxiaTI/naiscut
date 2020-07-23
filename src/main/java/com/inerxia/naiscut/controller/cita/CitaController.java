package com.inerxia.naiscut.controller.cita;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("citas")
@Api(value = "Citas endpoint")
public class CitaController {

    @GetMapping(value = "/pruebaCita/{id}")
    @ApiOperation(value = "Prueba")
    public String pruebaCita(@PathVariable int id){
        return "Cita número"+id;
    }
}
