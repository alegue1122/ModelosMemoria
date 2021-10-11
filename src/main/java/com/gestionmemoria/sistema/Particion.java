
package com.gestionmemoria.sistema;
public class Particion {
    
    private int id;
    private String nombre;
    private long direccionInicio;
    private long direccionFin;
    private String direccionInicioHexa;
    private String direccionFinHexa;
    private double totalMemoriaParticion;
    private String procesoEnParticion;
    private PanelParticionUI panelParticionUI;

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    private boolean state;
    
    public Particion(){
        
    }

    public Particion(int id, String nombre,long direccionInicio, long direccionFin, String direccionInicioHexa, String direccionFinHexa, double totalMemoriaParticion, PanelParticionUI panelParticionUI) {
        this.id = id;
        this.nombre = nombre;
        this.direccionInicio = direccionInicio;
        this.direccionFin = direccionFin;
        this.direccionInicioHexa = direccionInicioHexa;
        this.direccionFinHexa = direccionFinHexa;
        this.totalMemoriaParticion= totalMemoriaParticion;
        this.panelParticionUI = panelParticionUI;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public long getDireccionInicio() {
        return direccionInicio;
    }

    public void setDireccionInicio(long direccionInicio) {
        this.direccionInicio = direccionInicio;
    }

    public long getDireccionFin() {
        return direccionFin;
    }

    public void setDireccionFin(long direccionFin) {
        this.direccionFin = direccionFin;
    }

    public String getDireccionInicioHexa() {
        return direccionInicioHexa;
    }

    public void setDireccionInicioHexa(String direccionInicioHexa) {
        this.direccionInicioHexa = direccionInicioHexa;
    }

    public String getDireccionFinHexa() {
        return direccionFinHexa;
    }

    public void setDireccionFinHexa(String direccionFinHexa) {
        this.direccionFinHexa = direccionFinHexa;
    }

    public PanelParticionUI getPanelParticionUI() {
        return panelParticionUI;
    }

    public void setPanelParticionUI(PanelParticionUI panelParticion) {
        this.panelParticionUI = panelParticion;
    }

    public double getTotalMemoriaParticion() {
        return totalMemoriaParticion;
    }

    public void setTotalMemoriaParticion(double totalMemoriaParticion) {
        this.totalMemoriaParticion = totalMemoriaParticion;
    }

    public String getProcesoEnParticion() {
        return procesoEnParticion;
    }

    public void setProcesoEnParticion(String procesoEnParticion) {
        this.procesoEnParticion = procesoEnParticion;
    }

    
}
