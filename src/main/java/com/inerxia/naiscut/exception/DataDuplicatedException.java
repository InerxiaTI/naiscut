package com.inerxia.naiscut.exception;

public class DataDuplicatedException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public DataDuplicatedException(String mensaje){
        super(mensaje);
    }
}
