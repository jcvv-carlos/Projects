package com.example.karloz.lanzador;

import android.graphics.drawable.Drawable;

public class App {
    private String nombre;
    private String appNombre;
    private String paquete;
    private Drawable icono;

    public App(String nombre, String appNombre, String paquete, Drawable icono) {
        this.nombre = nombre;
        this.appNombre = appNombre;
        this.paquete = paquete;
        this.icono = icono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAppNombre() {
        return appNombre;
    }

    public void setAppNombre(String appNombre) {
        this.appNombre = appNombre;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public Drawable getIcono() {
        return icono;
    }

    public void setIcono(Drawable icono) {
        this.icono = icono;
    }
}
