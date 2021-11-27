package com.maxi.ProyectoFinalEgg.enumeracion;

public enum Consola {
    PS3("PS3"), PS4("PS4"), PS5("PS5"), XBOX_ONE("Xbox One"), XBOX_SERIES_X("Xbox Series X"), NINTENDO_SWITCH("Nintendo Switch");

    private final String mensaje;

    private Consola(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

}
