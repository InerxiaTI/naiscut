package com.inerxia.naiscut.exception;

public class DataIntegrityViolationException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public DataIntegrityViolationException(String mensaje){
        super(mensaje);
    }
}
