package com.inerxia.naiscut.facade.ocupacion.dto;

import java.time.LocalTime;
import java.util.List;

public class CuartoDto {

    private LocalTime cuarto;
    private List<DetalleCuartoDto> detalleCuartoDto;

    public List<DetalleCuartoDto> getDetalleCuartoDto() {
        return detalleCuartoDto;
    }

    public void setDetalleCuartoDto(List<DetalleCuartoDto> detalleCuartoDto) {
        this.detalleCuartoDto = detalleCuartoDto;
    }

    public LocalTime getCuarto() {
        return cuarto;
    }

    public void setCuarto(LocalTime cuarto) {
        this.cuarto = cuarto;
    }
}