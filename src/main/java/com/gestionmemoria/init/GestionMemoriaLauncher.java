
package com.gestionmemoria.init;

import com.gestionmemoria.applet.GestionMemoriaForm;
import java.awt.BorderLayout;
import javax.swing.JFrame;


public class GestionMemoriaLauncher {
    
    public static void main(String args[]){
        GestionMemoriaForm gestionMemoria = new GestionMemoriaForm();
        gestionMemoria.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gestionMemoria.setLayout(new BorderLayout());
        gestionMemoria.setVisible(true);
    }
}
