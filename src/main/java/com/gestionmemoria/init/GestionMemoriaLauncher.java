
package com.gestionmemoria.init;
import com.gestionmemoria.modelo.Modelo;

public class GestionMemoriaLauncher {
    
    private Modelo app;
            
    public static void main(String args[]){
        new GestionMemoriaLauncher();
    }
    
    public GestionMemoriaLauncher(){
       app = new Modelo();
       app.iniciarAplicacion();
    }
}
