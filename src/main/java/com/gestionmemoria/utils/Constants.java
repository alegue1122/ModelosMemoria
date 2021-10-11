package com.gestionmemoria.utils;

public class Constants {
    
     public static final String SELECCIONE = "--Seleccione--";
     public static final String MODEL_PARTICION_EFIJA = "Particiones Estáticas Fijas";
     public static final String MODEL_PARTICION_EDINAMICA= "Particiones Estáticas Variables";
     public static final String MODEL_PARTICION_DINAMICA = "Particiones Dinámicas";
     public static final String MODEL_SEGMENTACION = "Segmentación";
     public static final String MODEL_PAGINACION = "Paginación";
     
     public static final int ANCHO_PANEL_PARTICION = 150;
     public static final int ALTO_PANEL_MEMORIA    = 750;
     
     public static final double CANTIDAD_MAXIMA_MEMORIA_MBS = 16;
     public static final int TAMANO_PARTICION_OS_MBS = 2; 
     public static final double PIXELES_POR_MB = 46.875;
     public static final double PIXELES_PARTICION_OS = TAMANO_PARTICION_OS_MBS*PIXELES_POR_MB;
     
     public static final String ESTADO_LISTO="Listo";
     public static final String ESTADO_EJECUCION="En Ejecución";
     public static final String ESTADO_TERMINADO="Terminado";
     
     //Ajustes
     public static final String PRIMER_AJUSTE = "Primer Ajuste";
     public static final String PEOR_AJUSTE = "Peor Ajuste";
     public static final String MEJOR_AJUSTE = "Mejor Ajuste";
}
