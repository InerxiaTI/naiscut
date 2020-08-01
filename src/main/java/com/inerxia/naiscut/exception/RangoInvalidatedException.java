package com.inerxia.naiscut.exception;

public class RangoInvalidatedException extends GeneralRuntimeException{

    private static  final long serialVersionUID = 1L;

    public RangoInvalidatedException(String mensaje){
        super(mensaje);
    }
}
