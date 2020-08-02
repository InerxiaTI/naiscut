package com.inerxia.naiscut.facade.cliente;

import com.inerxia.naiscut.facade.Facade;
import com.inerxia.naiscut.facade.GeneralFacade;
import com.inerxia.naiscut.facade.cita.dto.CitaDto;
import com.inerxia.naiscut.facade.cliente.dto.ClienteDto;
import com.inerxia.naiscut.facade.cliente.dto.PersonaDto;
import com.inerxia.naiscut.facade.cliente.dto.RegistroPersonaDto;
import com.inerxia.naiscut.facade.cliente.dto.UsuarioDto;
import com.inerxia.naiscut.facade.mapper.UsuarioMapper;
import com.inerxia.naiscut.model.cliente.Persona;
import com.inerxia.naiscut.service.cliente.UsuarioService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class UsuarioFacade extends Facade<UsuarioMapper, UsuarioService> implements GeneralFacade<UsuarioDto> {

    private PersonaFacade personaFacade;
    private ClienteFacade clienteFacade;

    public UsuarioFacade(UsuarioMapper mapper, UsuarioService service) {
        super(mapper, service);
    }

    @Autowired
    public UsuarioFacade(UsuarioMapper mapper, UsuarioService service, PersonaFacade personaFacade,
                         ClienteFacade clienteFacade) {
        super(mapper, service);
        this.personaFacade = personaFacade;
        this.clienteFacade = clienteFacade;
    }

    @Override
    public UsuarioDto findById(Integer id) {
        if(Objects.isNull(id)){
            throw new ObjectNotFoundException(id, "exception.objeto_no_encontrado");
        }
        return mapper.toDto(service.findById(id));
    }

    public RegistroPersonaDto registrarUsuario(RegistroPersonaDto registroPersonaDto){
        PersonaDto persona = personaFacade.crearPersona(registroPersonaDto.getPersonaDto());
        registroPersonaDto.setPersonaDto(persona);


        registroPersonaDto.getUsuarioDto().setIdPersonaFk(persona.getId());
        registroPersonaDto.setUsuarioDto(this.crearUsuario(registroPersonaDto.getUsuarioDto()));
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setIdPersonaFk(persona.getId());

        registroPersonaDto.setClienteDto(clienteFacade.crearCliente(clienteDto));
        return registroPersonaDto;
    }

    public UsuarioDto crearUsuario(UsuarioDto usuarioDto){
        //salonFacade.findById(sedeDto.getIdSalonFk()); validar lo del consecutivo
        return mapper.toDto(service.crearUsuario(mapper.toEntity(usuarioDto)));
    }



    public UsuarioDto editarUsuario(UsuarioDto usuarioDto){

        return mapper.toDto(service.editarUsuario(mapper.toEntity(usuarioDto)));
    }

    @Override
    public List<UsuarioDto> findAll(Pageable pageable) {
        return null;
    }


}
