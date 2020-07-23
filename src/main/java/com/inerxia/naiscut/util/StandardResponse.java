package com.inerxia.naiscut.util;

public class StandardResponse<T> {

    private int estado;
    private String mensaje;
    private String devMensaje;
    private T body;

    public StandardResponse(EstadoStandardResponse estado, T body){
        this.estado = estado.getEstado();
        this.body = body;
    }

    public StandardResponse(EstadoStandardResponse estado, String mensaje){
        this.estado = estado.getEstado();
        this.mensaje = mensaje;
    }

    public StandardResponse(EstadoStandardResponse estado, String mensaje, T body){
        this.estado = estado.getEstado();
        this.mensaje = mensaje;
        this.body = body;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDevMensaje() {
        return devMensaje;
    }

    public void setDevMensaje(String devMensaje) {
        this.devMensaje = devMensaje;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public enum EstadoStandardResponse{
        OK(1),
        ERROR(0);

        private int estado;

        EstadoStandardResponse(int estado){
            this.estado = estado;
        }

        public int getEstado(){
            return estado;
        }
    }
}
