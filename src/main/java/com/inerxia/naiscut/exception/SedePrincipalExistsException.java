package com.inerxia.naiscut.exception;

public class SedePrincipalExistsException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public SedePrincipalExistsException(String mensaje){
        super(mensaje);
    }
}
