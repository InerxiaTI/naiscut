package com.inerxia.naiscut.facade.salon;

import com.inerxia.naiscut.facade.mapper.SedeMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SedeFacade {

    private SedeMapper sedeMapper;
}
