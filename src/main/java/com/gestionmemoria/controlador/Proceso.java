package com.gestionmemoria.controlador;

import java.util.Random;


public class Proceso {
    
    private int idProceso;
    private String nombreProceso;
    private double data;
    private double text;
    private double bss;
    private String estado;
    private int tiempoEjecucion;
    private double cantidadMemoriaProceso;

    public Proceso(int idProceso, String nombreProceso, double data, double text, double bss, double cantidadMemoriaProceso ,String estado) {
        this.idProceso = idProceso;
        this.nombreProceso = nombreProceso;
        this.data = data;
        this.text = text;
        this.bss = bss;
        this.cantidadMemoriaProceso = cantidadMemoriaProceso;
        this.estado = estado;
        Random random = new Random();
        tiempoEjecucion = random.nextInt(20)+1;
    }
   
    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public double getText() {
        return text;
    }

    public void setText(double text) {
        this.text = text;
    }

    public double getBss() {
        return bss;
    }

    public void setBss(double bss) {
        this.bss = bss;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public double getCantidadMemoriaProceso() {
        return cantidadMemoriaProceso;
    }

    public void setCantidadMemoriaProceso(double cantidadMemoriaProceso) {
        this.cantidadMemoriaProceso = cantidadMemoriaProceso;
    }

    public int getIdProceso() {
        return idProceso;
    }

    public void setIdProceso(int idProceso) {
        this.idProceso = idProceso;
    }
    
}
