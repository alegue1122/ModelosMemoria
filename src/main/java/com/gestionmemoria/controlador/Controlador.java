package com.gestionmemoria.controlador;

import com.gestionmemoria.vista.GestionMemoriaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {
    
    private final GestionMemoriaForm gestionMemoriaForm;

    public Controlador(GestionMemoriaForm gestionMemoriaForm) {
        this.gestionMemoriaForm = gestionMemoriaForm;
    }
    
    public ActionListener crearProceso(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMemoriaForm.getModel().crearProceso();
            }
        };     
    }
    
    public ActionListener seleccionModeloMemoria(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent  e) {
                gestionMemoriaForm.getModel().seleccionarModeloMemoria(e);
            }
        };     
    }
    
    
    public ActionListener crearParticiones(){
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMemoriaForm.getModel().crearParticiones();
            }
        };     
    }
    
    public ActionListener lanzarSimulacion(){
         return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestionMemoriaForm.getModel().lanzarSimulacion();
            }
        };   
    }
    
}
