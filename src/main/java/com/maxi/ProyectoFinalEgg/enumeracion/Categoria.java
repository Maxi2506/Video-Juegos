package com.maxi.ProyectoFinalEgg.enumeracion;

public enum Categoria {
    CONSOLAS("Consolas"), JUEGOS("Juegos"), ACCESORIOS("Accesorios"), SERVICIO_TECNICO("Servicio Técnico");

    private final String mensaje;

    private Categoria (String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
