package com.inerxia.naiscut.exception;

public class EntityNotFoundException extends GeneralRuntimeException{

    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(String mensaje){
        super(mensaje);
    }

}
