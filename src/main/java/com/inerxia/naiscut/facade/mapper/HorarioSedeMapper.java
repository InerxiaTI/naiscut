package com.inerxia.naiscut.facade.mapper;

import com.inerxia.naiscut.facade.salon.dto.HorarioSedeDto;
import com.inerxia.naiscut.model.salon.HorarioSede;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SedeMapper.class})
public interface HorarioSedeMapper extends EntityMapper<HorarioSedeDto, HorarioSede>{
}
