package com.inerxia.naiscut.service.cita;

import com.inerxia.naiscut.model.cita.Cita;
import com.inerxia.naiscut.model.cita.CitaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CitaService {
    private CitaRepository citaRepository;

    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    public void findById(Integer id){
    }
}
