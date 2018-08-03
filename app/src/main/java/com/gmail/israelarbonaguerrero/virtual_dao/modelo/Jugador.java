package com.gmail.israelarbonaguerrero.virtual_dao.modelo;

public class Jugador {

    private String jug_nombre, jug_nivel;
    private int jug_puntaje;

    public Jugador(){
    }

    public Jugador(String jug_nombre, String jug_nivel, int jug_puntaje){
        this.jug_nombre = jug_nombre;
        this.jug_nivel = jug_nivel;
        this.jug_puntaje = jug_puntaje;
    }

    public String getJug_nombre() {
        return jug_nombre;
    }

    public void setJug_nombre(String jug_nombre) {
        this.jug_nombre = jug_nombre;
    }

    public String getJug_nivel() {
        return jug_nivel;
    }

    public void setJug_nivel(String jug_nivel) {
        this.jug_nivel = jug_nivel;
    }

    public int getJug_puntaje() {
        return jug_puntaje;
    }

    public void setJug_puntaje(int jug_puntaje) {
        this.jug_puntaje = jug_puntaje;
    }


}
