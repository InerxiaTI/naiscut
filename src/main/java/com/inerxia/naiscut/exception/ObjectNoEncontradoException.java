package com.inerxia.naiscut.exception;

public class ObjectNoEncontradoException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public ObjectNoEncontradoException(String mensaje){
        super(mensaje);
    }
}
