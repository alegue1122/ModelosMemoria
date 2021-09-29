package com.gestionmemoria.controlador;

import com.gestionmemoria.utils.Constants;
import com.gestionmemoria.utils.Utils;
import java.util.ArrayList;
import java.util.List;


public class Memoria {
    
    public static double memoriaTotalMbs;
    public static double memoriaUtilizadaMbs;
    public static int pixelUltimaParticion;
    private int cantidadParticiones;
    public Particion particionOS;
    public List<Particion> particionesUsuario;
    
    public Memoria(){
        long memoriaFin = Utils.convertMbsaBytes(Constants.TAMANO_PARTICION_OS_MBS);
        int pixelesParticion = new Double(Constants.PIXELES_PARTICION_OS).intValue();
        memoriaTotalMbs = Constants.CANTIDAD_MAXIMA_MEMORIA_MBS;
        memoriaUtilizadaMbs =0;
        memoriaUtilizadaMbs = memoriaUtilizadaMbs + Constants.TAMANO_PARTICION_OS_MBS;
        pixelUltimaParticion = Constants.ALTO_PANEL_MEMORIA-pixelesParticion;
        String rangoDirecciones = Utils.convertDecimaltoHexa(0)+" - "+Utils.convertDecimaltoHexa(memoriaFin);
        PanelParticionUI panelParticionOS = new PanelParticionUI(pixelUltimaParticion, pixelesParticion, Constants.ANCHO_PANEL_PARTICION, rangoDirecciones, "OS");
        this.particionOS = new Particion(-99,"Partición OS",0, memoriaFin, Utils.convertDecimaltoHexa(0), Utils.convertDecimaltoHexa(memoriaFin),Constants.TAMANO_PARTICION_OS_MBS,panelParticionOS);
        this.particionesUsuario = new ArrayList<>();
        pixelUltimaParticion--;
    }

    public int getCantidadParticiones() {
        return cantidadParticiones;
    }

    public void setCantidadParticiones(int cantidadParticiones) {
        this.cantidadParticiones = cantidadParticiones;
    }

    public Particion getParticionOS() {
        return particionOS;
    }

    public void setParticionOS(Particion particionOS) {
        this.particionOS = particionOS;
    }

    public List<Particion> getParticionesUsuario() {
        return particionesUsuario;
    }

    public void setParticionesUsuario(List<Particion> particionesUsuario) {
        this.particionesUsuario = particionesUsuario;
    }
    
    public int getIdParticion(){
        return particionesUsuario.size();
    }
   
    
}
