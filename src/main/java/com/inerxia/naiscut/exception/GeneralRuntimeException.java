package com.inerxia.naiscut.exception;

public class GeneralRuntimeException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    private String mensaje;
    private String translationKey;

    public GeneralRuntimeException(String mensaje){
        super(mensaje);
        this.mensaje = mensaje;
    }

    public GeneralRuntimeException(String mensaje, Throwable throwable){
        super(mensaje, throwable);
        this.mensaje = mensaje;
    }

    public GeneralRuntimeException(String mensaje, String translationKey){
        super(mensaje);
        this.mensaje = mensaje;
        this.translationKey=translationKey;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTranslationKey() {
        return translationKey;
    }

    public void setTranslationKey(String translationKey) {
        this.translationKey = translationKey;
    }
}
